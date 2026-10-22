package kotlin.reflect.jvm.internal.impl.resolve;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.InlineClassRepresentation;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyGetterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.VariableDescriptor;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;

/* JADX INFO: compiled from: inlineClassesUtils.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class InlineClassesUtilsKt {
    private static final ClassId JVM_INLINE_ANNOTATION_CLASS_ID = null;
    private static final FqName JVM_INLINE_ANNOTATION_FQ_NAME = null;

    static {
        FqName r0 = new FqName("kotlin.jvm.JvmInline");
        JVM_INLINE_ANNOTATION_FQ_NAME = r0;
        ClassId r1 = ClassId.topLevel(r0);
        Intrinsics.checkNotNullExpressionValue(r1, "topLevel(JVM_INLINE_ANNOTATION_FQ_NAME)");
        JVM_INLINE_ANNOTATION_CLASS_ID = r1;
    }

    public static final boolean isInlineClass(DeclarationDescriptor r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if ((r1 instanceof ClassDescriptor) == true) goto L5;
    L7:
        return false;
    L5:
        if ((((ClassDescriptor) r1).getValueClassRepresentation() instanceof InlineClassRepresentation) == false) goto L7;
        return true;
    }

    public static final KotlinType unsubstitutedUnderlyingType(KotlinType r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        ClassifierDescriptor r3 = r2.getConstructor().mo2083getDeclarationDescriptor();
        SimpleType r1 = null;
        if ((r3 instanceof ClassDescriptor) == true) goto L5;
        r3 = null;
    L5:
        ClassDescriptor r4 = (ClassDescriptor) r3;
        if (r4 == null) goto L11;
        InlineClassRepresentation<SimpleType> r5 = DescriptorUtilsKt.getInlineClassRepresentation(r4);
        if (r5 == null) goto L11;
        r1 = (SimpleType) r5.getUnderlyingType();
    L11:
        return r1;
    }

    public static final boolean isInlineClassType(KotlinType r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        ClassifierDescriptor r2 = r1.getConstructor().mo2083getDeclarationDescriptor();
        if (r2 != null) goto L7;
        return false;
    L7:
        return isInlineClass(r2);
    }

    public static final boolean isGetterOfUnderlyingPropertyOfInlineClass(CallableDescriptor r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if ((r1 instanceof PropertyGetterDescriptor) == false) goto L7;
        PropertyDescriptor r2 = ((PropertyGetterDescriptor) r1).getCorrespondingProperty();
        Intrinsics.checkNotNullExpressionValue(r2, "correspondingProperty");
        if (isUnderlyingPropertyOfInlineClass(r2) == false) goto L7;
        return true;
    L7:
        return false;
    }

    public static final boolean isUnderlyingPropertyOfInlineClass(VariableDescriptor r3) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        if (r3.getExtensionReceiverParameter() != null) goto L15;
        DeclarationDescriptor r0 = r3.getContainingDeclaration();
        Name r2 = null;
        if ((r0 instanceof ClassDescriptor) == false) goto L7;
        ClassDescriptor r1 = (ClassDescriptor) r0;
    L8:
        if (r1 == null) goto L13;
        InlineClassRepresentation<SimpleType> r4 = DescriptorUtilsKt.getInlineClassRepresentation(r1);
        if (r4 == null) goto L13;
        r2 = r4.getUnderlyingPropertyName();
    L13:
        if (Intrinsics.areEqual(r2, r3.getName()) == false) goto L15;
        return true;
    L7:
        r1 = null;
    L15:
        return false;
    }
}
