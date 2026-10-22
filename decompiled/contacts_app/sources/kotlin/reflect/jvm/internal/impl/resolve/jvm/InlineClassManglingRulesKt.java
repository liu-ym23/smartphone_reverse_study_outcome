package kotlin.reflect.jvm.internal.impl.resolve.jvm;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.resolve.InlineClassesUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;

/* JADX INFO: compiled from: inlineClassManglingRules.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class InlineClassManglingRulesKt {
    public static final boolean shouldHideConstructorDueToInlineClassTypeValueParameters(CallableMemberDescriptor r3) {
        Intrinsics.checkNotNullParameter(r3, "descriptor");
        if ((r3 instanceof ClassConstructorDescriptor) == false) goto L5;
        ClassConstructorDescriptor r4 = (ClassConstructorDescriptor) r3;
    L7:
        if (r4 != null) goto L10;
        return false;
    L10:
        if (DescriptorVisibilities.isPrivate(r4.getVisibility()) == false) goto L12;
        return false;
    L12:
        ClassDescriptor r1 = r4.getConstructedClass();
        Intrinsics.checkNotNullExpressionValue(r1, "constructorDescriptor.constructedClass");
        if (InlineClassesUtilsKt.isInlineClass(r1) == false) goto L16;
        return false;
    L16:
        if (DescriptorUtils.isSealedClass(r4.getConstructedClass()) == false) goto L18;
        return false;
    L18:
        List<ValueParameterDescriptor> r5 = r4.getValueParameters();
        Intrinsics.checkNotNullExpressionValue(r5, "constructorDescriptor.valueParameters");
        List<ValueParameterDescriptor> r6 = r5;
        if ((r6 instanceof Collection) == true) goto L21;
    L23:
        Iterator<T> r7 = r6.iterator();
    L25:
        if (r7.hasNext() == false) goto L34;
        KotlinType r2 = ((ValueParameterDescriptor) r7.next()).getType();
        Intrinsics.checkNotNullExpressionValue(r2, "it.type");
        if (requiresFunctionNameManglingInParameterTypes(r2) == false) goto L25;
        return true;
    L34:
        return false;
    L21:
        if (r6.isEmpty() == false) goto L23;
        return false;
    L5:
        r4 = null;
        goto L7
    }

    public static final boolean isInlineClassThatRequiresMangling(DeclarationDescriptor r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if (InlineClassesUtilsKt.isInlineClass(r1) == true) goto L5;
    L7:
        return false;
    L5:
        if (isDontMangleClass((ClassDescriptor) r1) == true) goto L7;
        return true;
    }

    public static final boolean isInlineClassThatRequiresMangling(KotlinType r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        ClassifierDescriptor r3 = r2.getConstructor().mo2083getDeclarationDescriptor();
        if (r3 != null) goto L5;
        return false;
    L5:
        if (isInlineClassThatRequiresMangling(r3) == true) goto L7;
        return false;
    L7:
        return true;
    }

    private static final boolean requiresFunctionNameManglingInParameterTypes(KotlinType r1) {
        if (isInlineClassThatRequiresMangling(r1) == false) goto L5;
    L8:
        return true;
    L5:
        if (isTypeParameterWithUpperBoundThatRequiresMangling(r1) == true) goto L8;
        return false;
    }

    private static final boolean isDontMangleClass(ClassDescriptor r1) {
        return Intrinsics.areEqual(DescriptorUtilsKt.getFqNameSafe(r1), StandardNames.RESULT_FQ_NAME);
    }

    private static final boolean isTypeParameterWithUpperBoundThatRequiresMangling(KotlinType r1) {
        ClassifierDescriptor r2 = r1.getConstructor().mo2083getDeclarationDescriptor();
        if ((r2 instanceof TypeParameterDescriptor) == false) goto L5;
        TypeParameterDescriptor r3 = (TypeParameterDescriptor) r2;
    L6:
        if (r3 != null) goto L10;
        return false;
    L10:
        return requiresFunctionNameManglingInParameterTypes(TypeUtilsKt.getRepresentativeUpperBound(r3));
    L5:
        r3 = null;
        goto L6
    }
}
