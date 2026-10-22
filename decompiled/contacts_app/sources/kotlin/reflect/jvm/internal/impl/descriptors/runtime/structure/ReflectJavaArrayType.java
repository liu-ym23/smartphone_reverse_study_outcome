package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.util.Collection;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaArrayType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaType;

/* JADX INFO: compiled from: ReflectJavaArrayType.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class ReflectJavaArrayType extends ReflectJavaType implements JavaArrayType {
    private final Collection<JavaAnnotation> annotations;
    private final ReflectJavaType componentType;
    private final boolean isDeprecatedInJavaDoc;
    private final Type reflectType;

    public ReflectJavaArrayType(Type r3) {
        Intrinsics.checkNotNullParameter(r3, "reflectType");
        this.reflectType = r3;
        Type r4 = getReflectType();
        if ((r4 instanceof GenericArrayType) == false) goto L6;
        ReflectJavaType.Factory r0 = ReflectJavaType.Factory;
        Type r5 = ((GenericArrayType) r4).getGenericComponentType();
        Intrinsics.checkNotNullExpressionValue(r5, "genericComponentType");
        ReflectJavaType r6 = r0.create(r5);
    L10:
        this.componentType = r6;
        this.annotations = CollectionsKt.emptyList();
        return;
    L6:
        if ((r4 instanceof Class) == false) goto L13;
        Class r7 = (Class) r4;
        if (r7.isArray() == false) goto L13;
        ReflectJavaType.Factory r1 = ReflectJavaType.Factory;
        Class<?> r8 = r7.getComponentType();
        Intrinsics.checkNotNullExpressionValue(r8, "getComponentType()");
        r6 = r1.create(r8);
    L13:
        throw new IllegalArgumentException("Not an array type (" + getReflectType().getClass() + "): " + getReflectType());
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaArrayType
    public /* bridge */ /* synthetic */ JavaType getComponentType() {
        return getComponentType();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaType
    protected Type getReflectType() {
        return this.reflectType;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaArrayType
    public ReflectJavaType getComponentType() {
        return this.componentType;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner
    public Collection<JavaAnnotation> getAnnotations() {
        return this.annotations;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner
    public boolean isDeprecatedInJavaDoc() {
        return this.isDeprecatedInJavaDoc;
    }
}
