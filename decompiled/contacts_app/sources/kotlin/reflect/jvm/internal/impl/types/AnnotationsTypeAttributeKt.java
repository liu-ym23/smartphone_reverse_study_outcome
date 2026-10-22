package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;

/* JADX INFO: compiled from: AnnotationsTypeAttribute.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class AnnotationsTypeAttributeKt {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = null;
    private static final ReadOnlyProperty annotationsAttribute$delegate = null;

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinPackage(AnnotationsTypeAttributeKt.class, "descriptors"), "annotationsAttribute", "getAnnotationsAttribute(Lorg/jetbrains/kotlin/types/TypeAttributes;)Lorg/jetbrains/kotlin/types/AnnotationsTypeAttribute;"))};
        ReadOnlyProperty r0 = TypeAttributes.Companion.generateNullableAccessor(Reflection.getOrCreateKotlinClass(AnnotationsTypeAttribute.class));
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type kotlin.properties.ReadOnlyProperty<org.jetbrains.kotlin.types.TypeAttributes, T of org.jetbrains.kotlin.types.TypeAttributes.Companion.attributeAccessor?>");
        annotationsAttribute$delegate = r0;
    }

    public static final AnnotationsTypeAttribute getAnnotationsAttribute(TypeAttributes r3) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        return (AnnotationsTypeAttribute) annotationsAttribute$delegate.getValue(r3, $$delegatedProperties[0]);
    }

    public static final Annotations getAnnotations(TypeAttributes r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        AnnotationsTypeAttribute r2 = getAnnotationsAttribute(r1);
        if (r2 == null) goto L7;
        Annotations r3 = r2.getAnnotations();
        if (r3 == null) goto L7;
        return r3;
    L7:
        return Annotations.Companion.getEMPTY();
    }
}
