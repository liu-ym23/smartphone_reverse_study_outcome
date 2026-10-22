package kotlin.reflect.jvm.internal.calls;

import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.KotlinReflectionInternalError;
import kotlin.reflect.jvm.internal.UtilKt;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.VariableDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.InlineClassesUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;

/* JADX INFO: compiled from: InlineClassAwareCaller.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u001a\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u0006*\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\u0002H\u0000\u001a6\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\n0\t\"\n\b\u0000\u0010\n*\u0004\u0018\u00010\u000b*\b\u0012\u0004\u0012\u0002H\n0\t2\u0006\u0010\u0007\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\rH\u0000\u001a\u0018\u0010\u000e\u001a\u00020\u000f*\u0006\u0012\u0002\b\u00030\u00102\u0006\u0010\u0007\u001a\u00020\u0002H\u0000\u001a\u0018\u0010\u0011\u001a\u00020\u000f*\u0006\u0012\u0002\b\u00030\u00102\u0006\u0010\u0007\u001a\u00020\u0002H\u0000\u001a\f\u0010\u0012\u001a\u00020\r*\u00020\u0002H\u0002\u001a\u0014\u0010\u0013\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0010*\u0004\u0018\u00010\u0014H\u0000\u001a\u0012\u0010\u0013\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0010*\u00020\u0001H\u0000\"\u001a\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00028BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0015"}, d2 = {"expectedReceiverType", "Lkotlin/reflect/jvm/internal/impl/types/KotlinType;", "Lkotlin/reflect/jvm/internal/impl/descriptors/CallableMemberDescriptor;", "getExpectedReceiverType", "(Lorg/jetbrains/kotlin/descriptors/CallableMemberDescriptor;)Lorg/jetbrains/kotlin/types/KotlinType;", "coerceToExpectedReceiverType", "", "descriptor", "createInlineClassAwareCallerIfNeeded", "Lkotlin/reflect/jvm/internal/calls/Caller;", "M", "Ljava/lang/reflect/Member;", "isDefault", "", "getBoxMethod", "Ljava/lang/reflect/Method;", "Ljava/lang/Class;", "getUnboxMethod", "hasInlineClassReceiver", "toInlineClass", "Lkotlin/reflect/jvm/internal/impl/descriptors/DeclarationDescriptor;", "kotlin-reflection"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class InlineClassAwareCallerKt {
    public static /* synthetic */ Caller createInlineClassAwareCallerIfNeeded$default(Caller r0, CallableMemberDescriptor r1, boolean r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = false;
    L6:
        return createInlineClassAwareCallerIfNeeded(r0, r1, r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <M extends Member> Caller<M> createInlineClassAwareCallerIfNeeded(Caller<? extends M> r5, CallableMemberDescriptor r6, boolean r7) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r6, "descriptor");
        boolean r1 = true;
        if (InlineClassesUtilsKt.isGetterOfUnderlyingPropertyOfInlineClass(r6) == true) goto L29;
        List<ValueParameterDescriptor> r0 = r6.getValueParameters();
        Intrinsics.checkNotNullExpressionValue(r0, "descriptor.valueParameters");
        List<ValueParameterDescriptor> r2 = r0;
        if ((r2 instanceof Collection) == true) goto L7;
    L9:
        Iterator<T> r3 = r2.iterator();
    L11:
        if (r3.hasNext() == false) goto L8;
        KotlinType r4 = ((ValueParameterDescriptor) r3.next()).getType();
        Intrinsics.checkNotNullExpressionValue(r4, "it.type");
        if (InlineClassesUtilsKt.isInlineClassType(r4) == false) goto L11;
        boolean r8 = true;
    L15:
        if (r8 == true) goto L29;
        KotlinType r9 = r6.getReturnType();
        if (r9 != null) goto L19;
    L21:
        boolean r10 = false;
    L22:
        if (r10 == true) goto L29;
        if ((r5 instanceof BoundCaller) == false) goto L26;
    L28:
        r1 = false;
        goto L29
    L26:
        if (hasInlineClassReceiver(r6) == false) goto L28;
    L19:
        if (InlineClassesUtilsKt.isInlineClassType(r9) != true) goto L21;
        r10 = true;
    L8:
        r8 = false;
        goto L15
    L7:
        if (r2.isEmpty() == false) goto L9;
    L29:
        if (r1 == true) goto L31;
        return r5;
    L31:
        return new InlineClassAwareCaller(r6, r5, r7);
    }

    private static final boolean hasInlineClassReceiver(CallableMemberDescriptor r2) {
        KotlinType r3 = getExpectedReceiverType(r2);
        if (r3 != null) goto L5;
        return false;
    L5:
        if (InlineClassesUtilsKt.isInlineClassType(r3) == true) goto L7;
        return false;
    L7:
        return true;
    }

    public static final Method getUnboxMethod(Class<?> r3, CallableMemberDescriptor r4) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        Intrinsics.checkNotNullParameter(r4, "descriptor");
        Method r0 = r3.getDeclaredMethod("unbox-impl", new Class[0]);     // Catch: NoSuchMethodException -> L5
        Intrinsics.checkNotNullExpressionValue(r0, "{\n        getDeclaredMet…LINE_CLASS_MEMBERS)\n    }");     // Catch: NoSuchMethodException -> L5
        return r0;
    L6:
        throw new KotlinReflectionInternalError("No unbox method found in inline class: " + r3 + " (calling " + r4 + ')');
    }

    public static final Method getBoxMethod(Class<?> r4, CallableMemberDescriptor r5) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        Intrinsics.checkNotNullParameter(r5, "descriptor");
        Method r0 = r4.getDeclaredMethod("box-impl", new Class[]{getUnboxMethod(r4, r5).getReturnType()});     // Catch: NoSuchMethodException -> L5
        Intrinsics.checkNotNullExpressionValue(r0, "{\n        getDeclaredMet…riptor).returnType)\n    }");     // Catch: NoSuchMethodException -> L5
        return r0;
    L6:
        throw new KotlinReflectionInternalError("No box method found in inline class: " + r4 + " (calling " + r5 + ')');
    }

    public static final Class<?> toInlineClass(KotlinType r3) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        Class<?> r0 = toInlineClass(r3.getConstructor().mo2083getDeclarationDescriptor());
        if (r0 != null) goto L6;
        return null;
    L6:
        if (TypeUtils.isNullableType(r3) == true) goto L8;
        return r0;
    L8:
        KotlinType r4 = InlineClassesUtilsKt.unsubstitutedUnderlyingType(r3);
        if (r4 != null) goto L12;
        return null;
    L12:
        if (TypeUtils.isNullableType(r4) == false) goto L14;
    L16:
        return null;
    L14:
        if (KotlinBuiltIns.isPrimitiveType(r4) == true) goto L16;
        return r0;
    }

    public static final Class<?> toInlineClass(DeclarationDescriptor r4) {
        if ((r4 instanceof ClassDescriptor) == true) goto L5;
    L11:
        return null;
    L5:
        if (InlineClassesUtilsKt.isInlineClass(r4) == false) goto L11;
        ClassDescriptor r0 = (ClassDescriptor) r4;
        Class<?> r1 = UtilKt.toJavaClass(r0);
        if (r1 == null) goto L10;
        return r1;
    L10:
        throw new KotlinReflectionInternalError("Class object for the class " + r0.getName() + " cannot be found (classId=" + DescriptorUtilsKt.getClassId((ClassifierDescriptor) r4) + ')');
    }

    private static final KotlinType getExpectedReceiverType(CallableMemberDescriptor r3) {
        ReceiverParameterDescriptor r0 = r3.getExtensionReceiverParameter();
        ReceiverParameterDescriptor r1 = r3.getDispatchReceiverParameter();
        if (r0 != null) goto L19;
        SimpleType r2 = null;
        if (r1 != null) goto L9;
        return null;
    L9:
        if ((r3 instanceof ConstructorDescriptor) == true) goto L21;
        DeclarationDescriptor r4 = r3.getContainingDeclaration();
        if ((r4 instanceof ClassDescriptor) == false) goto L14;
        ClassDescriptor r5 = (ClassDescriptor) r4;
    L15:
        if (r5 == null) goto L18;
        r2 = r5.getDefaultType();
    L18:
        return r2;
    L14:
        r5 = null;
        goto L15
    L21:
        return r1.getType();
    L19:
        return r0.getType();
    }

    public static final Object coerceToExpectedReceiverType(Object r1, CallableMemberDescriptor r2) {
        Intrinsics.checkNotNullParameter(r2, "descriptor");
        if ((r2 instanceof PropertyDescriptor) == true) goto L5;
    L7:
        KotlinType r0 = getExpectedReceiverType(r2);
        if (r0 == null) goto L16;
        Class<?> r3 = toInlineClass(r0);
        if (r3 == null) goto L17;
        Method r4 = getUnboxMethod(r3, r2);
        if (r4 != null) goto L15;
        return r1;
    L15:
        return r4.invoke(r1, new Object[0]);
    L17:
        return r1;
    L16:
        return r1;
    L5:
        if (InlineClassesUtilsKt.isUnderlyingPropertyOfInlineClass((VariableDescriptor) r2) == false) goto L7;
        return r1;
    }
}
