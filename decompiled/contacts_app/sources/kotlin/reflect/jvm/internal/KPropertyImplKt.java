package kotlin.reflect.jvm.internal;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.calls.Caller;
import kotlin.reflect.jvm.internal.calls.CallerImpl;
import kotlin.reflect.jvm.internal.calls.InlineClassAwareCallerKt;
import kotlin.reflect.jvm.internal.calls.InternalUnderlyingValOfInlineClass;
import kotlin.reflect.jvm.internal.calls.ThrowingCaller;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmProtoBufUtil;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.resolve.InlineClassesUtilsKt;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedPropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;

/* JADX INFO: compiled from: KPropertyImpl.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a \u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0006*\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00022\u0006\u0010\u0007\u001a\u00020\bH\u0002\u001a\f\u0010\t\u001a\u00020\b*\u00020\nH\u0002\"\"\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u000b"}, d2 = {"boundReceiver", "", "Lkotlin/reflect/jvm/internal/KPropertyImpl$Accessor;", "getBoundReceiver", "(Lkotlin/reflect/jvm/internal/KPropertyImpl$Accessor;)Ljava/lang/Object;", "computeCallerForAccessor", "Lkotlin/reflect/jvm/internal/calls/Caller;", "isGetter", "", "isJvmFieldPropertyInCompanionObject", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "kotlin-reflection"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class KPropertyImplKt {
    public static final /* synthetic */ Caller access$computeCallerForAccessor(KPropertyImpl.Accessor r0, boolean r1) {
        return computeCallerForAccessor(r0, r1);
    }

    public static final Object getBoundReceiver(KPropertyImpl.Accessor<?, ?> r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return r1.getProperty().getBoundReceiver();
    }

    private static final Caller<?> computeCallerForAccessor(KPropertyImpl.Accessor<?, ?> r6, boolean r7) {
        if (KDeclarationContainerImpl.Companion.getLOCAL_PROPERTY_SIGNATURE$kotlin_reflection().matches(r6.getProperty().getSignature()) == true) goto L5;
        JvmPropertySignature r0 = RuntimeTypeMapper.INSTANCE.mapPropertySignature(r6.getProperty().getDescriptor());
        if ((r0 instanceof JvmPropertySignature.KotlinProperty) == false) goto L61;
        JvmPropertySignature.KotlinProperty r1 = (JvmPropertySignature.KotlinProperty) r0;
        JvmProtoBuf.JvmPropertySignature r2 = r1.getSignature();
        if (r7 == false) goto L14;
        if (r2.hasGetter() == false) goto L16;
        JvmProtoBuf.JvmMethodSignature r3 = r2.getGetter();
    L17:
        if (r3 == null) goto L19;
        Method r4 = r6.getProperty().getContainer().findMethodBySignature(r1.getNameResolver().getString(r3.getName()), r1.getNameResolver().getString(r3.getDesc()));
    L20:
        if (r4 != null) goto L42;
        if (InlineClassesUtilsKt.isUnderlyingPropertyOfInlineClass(r6.getProperty().getDescriptor()) == true) goto L24;
    L36:
        Field r5 = r6.getProperty().getJavaField();
        if (r5 == null) goto L40;
        Caller r8 = computeCallerForAccessor$computeFieldCaller(r6, r7, r5);
    L75:
        return InlineClassAwareCallerKt.createInlineClassAwareCallerIfNeeded$default(r8, r6.getDescriptor(), false, 2, null);
    L40:
        throw new KotlinReflectionInternalError("No accessors or field is found for property " + r6.getProperty());
    L24:
        if (Intrinsics.areEqual(r6.getProperty().getDescriptor().getVisibility(), DescriptorVisibilities.INTERNAL) == false) goto L36;
        Class<?> r9 = InlineClassAwareCallerKt.toInlineClass(r6.getProperty().getDescriptor().getContainingDeclaration());
        if (r9 == null) goto L35;
        Method r10 = InlineClassAwareCallerKt.getUnboxMethod(r9, r6.getProperty().getDescriptor());
        if (r10 == null) goto L35;
        if (r6.isBound() == false) goto L32;
        InternalUnderlyingValOfInlineClass.Unbound r11 = new InternalUnderlyingValOfInlineClass.Bound(r10, getBoundReceiver(r6));
    L33:
        r8 = r11;
        goto L75
    L32:
        r11 = new InternalUnderlyingValOfInlineClass.Unbound(r10);
    L35:
        throw new KotlinReflectionInternalError("Underlying property of inline class " + r6.getProperty() + " should have a field");
    L42:
        if (Modifier.isStatic(r4.getModifiers()) == true) goto L49;
        if (r6.isBound() == false) goto L46;
        CallerImpl.Method.Instance r12 = new CallerImpl.Method.BoundInstance(r4, getBoundReceiver(r6));
    L47:
        r8 = r12;
        goto L75
    L46:
        r12 = new CallerImpl.Method.Instance(r4);
        goto L47
    L49:
        if (computeCallerForAccessor$isJvmStaticProperty(r6) == false) goto L56;
        if (r6.isBound() == false) goto L53;
        CallerImpl.Method.JvmStaticInObject r13 = new CallerImpl.Method.BoundJvmStaticInObject(r4);
    L54:
        r8 = r13;
        goto L75
    L53:
        r13 = new CallerImpl.Method.JvmStaticInObject(r4);
        goto L54
    L56:
        if (r6.isBound() == false) goto L58;
        CallerImpl.Method.Static r14 = new CallerImpl.Method.BoundStatic(r4, getBoundReceiver(r6));
    L59:
        r8 = r14;
        goto L75
    L58:
        r14 = new CallerImpl.Method.Static(r4);
        goto L59
    L19:
        r4 = null;
    L16:
        r3 = null;
        goto L17
    L14:
        if (r2.hasSetter() == false) goto L16;
        r3 = r2.getSetter();
        goto L17
    L61:
        if ((r0 instanceof JvmPropertySignature.JavaField) == false) goto L64;
        r8 = computeCallerForAccessor$computeFieldCaller(r6, r7, ((JvmPropertySignature.JavaField) r0).getField());
        goto L75
    L64:
        if ((r0 instanceof JvmPropertySignature.JavaMethodProperty) == false) goto L79;
        if (r7 == false) goto L67;
        Method r15 = ((JvmPropertySignature.JavaMethodProperty) r0).getGetterMethod();
    L70:
        if (r6.isBound() == false) goto L72;
        CallerImpl.Method.Instance r16 = new CallerImpl.Method.BoundInstance(r15, getBoundReceiver(r6));
    L73:
        r8 = r16;
        goto L75
    L72:
        r16 = new CallerImpl.Method.Instance(r15);
        goto L73
    L67:
        JvmPropertySignature.JavaMethodProperty r17 = (JvmPropertySignature.JavaMethodProperty) r0;
        r15 = r17.getSetterMethod();
        if (r15 != null) goto L70;
        throw new KotlinReflectionInternalError("No source found for setter of Java method property: " + r17.getGetterMethod());
    L79:
        if ((r0 instanceof JvmPropertySignature.MappedKotlinProperty) == false) goto L96;
        if (r7 == false) goto L82;
        JvmFunctionSignature.KotlinFunction r18 = ((JvmPropertySignature.MappedKotlinProperty) r0).getGetterSignature();
    L84:
        Method r19 = r6.getProperty().getContainer().findMethodBySignature(r18.getMethodName(), r18.getMethodDesc());
        if (r19 == null) goto L92;
        Modifier.isStatic(r19.getModifiers());
        if (r6.isBound() == false) goto L90;
        return new CallerImpl.Method.BoundInstance(r19, getBoundReceiver(r6));
    L90:
        return new CallerImpl.Method.Instance(r19);
    L92:
        throw new KotlinReflectionInternalError("No accessor found for property " + r6.getProperty());
    L82:
        r18 = ((JvmPropertySignature.MappedKotlinProperty) r0).getSetterSignature();
        if (r18 != null) goto L84;
        throw new KotlinReflectionInternalError("No setter found for property " + r6.getProperty());
    L96:
        throw new NoWhenBranchMatchedException();
    L5:
        return ThrowingCaller.INSTANCE;
    }

    private static final boolean computeCallerForAccessor$isJvmStaticProperty(KPropertyImpl.Accessor<?, ?> r1) {
        return r1.getProperty().getDescriptor().getAnnotations().hasAnnotation(UtilKt.getJVM_STATIC());
    }

    private static final boolean computeCallerForAccessor$isNotNullProperty(KPropertyImpl.Accessor<?, ?> r0) {
        return !TypeUtils.isNullableType(r0.getProperty().getDescriptor().getType());
    }

    private static final CallerImpl<Field> computeCallerForAccessor$computeFieldCaller(KPropertyImpl.Accessor<?, ?> r1, boolean r2, Field r3) {
        if (isJvmFieldPropertyInCompanionObject(r1.getProperty().getDescriptor()) == false) goto L5;
    L22:
        if (r2 == false) goto L29;
        if (r1.isBound() == false) goto L26;
        CallerImpl.FieldGetter.Instance r4 = new CallerImpl.FieldGetter.BoundInstance(r3, getBoundReceiver(r1));
    L38:
        return r4;
    L26:
        r4 = new CallerImpl.FieldGetter.Instance(r3);
        goto L38
    L29:
        if (r1.isBound() == false) goto L32;
        return new CallerImpl.FieldSetter.BoundInstance(r3, computeCallerForAccessor$isNotNullProperty(r1), getBoundReceiver(r1));
    L32:
        return new CallerImpl.FieldSetter.Instance(r3, computeCallerForAccessor$isNotNullProperty(r1));
    L5:
        if (Modifier.isStatic(r3.getModifiers()) == false) goto L22;
        if (computeCallerForAccessor$isJvmStaticProperty(r1) == false) goto L19;
        if (r2 == false) goto L16;
        if (r1.isBound() == false) goto L13;
        CallerImpl.FieldGetter.JvmStaticInObject r5 = new CallerImpl.FieldGetter.BoundJvmStaticInObject(r3);
    L33:
        return r5;
    L13:
        r5 = new CallerImpl.FieldGetter.JvmStaticInObject(r3);
        goto L33
    L16:
        if (r1.isBound() == false) goto L35;
        return new CallerImpl.FieldSetter.BoundJvmStaticInObject(r3, computeCallerForAccessor$isNotNullProperty(r1));
    L35:
        return new CallerImpl.FieldSetter.JvmStaticInObject(r3, computeCallerForAccessor$isNotNullProperty(r1));
    L19:
        if (r2 == false) goto L37;
        return new CallerImpl.FieldGetter.Static(r3);
    L37:
        return new CallerImpl.FieldSetter.Static(r3, computeCallerForAccessor$isNotNullProperty(r1));
    }

    private static final boolean isJvmFieldPropertyInCompanionObject(PropertyDescriptor r4) {
        DeclarationDescriptor r0 = r4.getContainingDeclaration();
        Intrinsics.checkNotNullExpressionValue(r0, "containingDeclaration");
        if (DescriptorUtils.isCompanionObject(r0) == true) goto L5;
        return false;
    L5:
        DeclarationDescriptor r1 = r0.getContainingDeclaration();
        if (DescriptorUtils.isInterface(r1) == true) goto L12;
        if (DescriptorUtils.isAnnotationClass(r1) == true) goto L12;
    L16:
        return true;
    L12:
        if ((r4 instanceof DeserializedPropertyDescriptor) == true) goto L14;
        return false;
    L14:
        if (JvmProtoBufUtil.isMovedFromInterfaceCompanion(((DeserializedPropertyDescriptor) r4).getProto()) == true) goto L16;
        return false;
    }
}
