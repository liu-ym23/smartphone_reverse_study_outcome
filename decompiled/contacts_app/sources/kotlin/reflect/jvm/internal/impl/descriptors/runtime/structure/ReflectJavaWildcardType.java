package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.Collection;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaWildcardType;

/* JADX INFO: compiled from: ReflectJavaWildcardType.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class ReflectJavaWildcardType extends ReflectJavaType implements JavaWildcardType {
    private final Collection<JavaAnnotation> annotations;
    private final boolean isDeprecatedInJavaDoc;
    private final WildcardType reflectType;

    public ReflectJavaWildcardType(WildcardType r2) {
        Intrinsics.checkNotNullParameter(r2, "reflectType");
        this.reflectType = r2;
        this.annotations = CollectionsKt.emptyList();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaWildcardType
    public /* bridge */ /* synthetic */ JavaType getBound() {
        return getBound();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaType
    public /* bridge */ /* synthetic */ Type getReflectType() {
        return getReflectType();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaType
    protected WildcardType getReflectType() {
        return this.reflectType;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaWildcardType
    public ReflectJavaType getBound() {
        Type[] r0 = getReflectType().getUpperBounds();
        Type[] r1 = getReflectType().getLowerBounds();
        if (r0.length > 1) goto L17;
        if (r1.length > 1) goto L17;
        if (r1.length != 1) goto L10;
        ReflectJavaType.Factory r4 = ReflectJavaType.Factory;
        Intrinsics.checkNotNullExpressionValue(r1, "lowerBounds");
        Object r2 = ArraysKt.single(r1);
        Intrinsics.checkNotNullExpressionValue(r2, "lowerBounds.single()");
        return r4.create((Type) r2);
    L10:
        if (r0.length != 1) goto L15;
        Intrinsics.checkNotNullExpressionValue(r0, "upperBounds");
        Type r5 = (Type) ArraysKt.single(r0);
        if (Intrinsics.areEqual(r5, Object.class) == true) goto L15;
        ReflectJavaType.Factory r3 = ReflectJavaType.Factory;
        Intrinsics.checkNotNullExpressionValue(r5, "ub");
        return r3.create(r5);
    L15:
        return null;
    L17:
        throw new UnsupportedOperationException("Wildcard types with many bounds are not yet supported: " + getReflectType());
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaWildcardType
    public boolean isExtends() {
        Type[] r1 = getReflectType().getUpperBounds();
        Intrinsics.checkNotNullExpressionValue(r1, "reflectType.upperBounds");
        return !Intrinsics.areEqual(ArraysKt.firstOrNull(r1), Object.class);
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
