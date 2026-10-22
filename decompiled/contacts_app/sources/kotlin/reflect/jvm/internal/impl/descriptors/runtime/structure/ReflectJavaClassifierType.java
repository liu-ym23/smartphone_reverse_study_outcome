package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassifier;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassifierType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaType;
import kotlin.reflect.jvm.internal.impl.name.FqName;

/* JADX INFO: compiled from: ReflectJavaClassifierType.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class ReflectJavaClassifierType extends ReflectJavaType implements JavaClassifierType {
    private final JavaClassifier classifier;
    private final Type reflectType;

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaType, kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner
    public JavaAnnotation findAnnotation(FqName r1) {
        Intrinsics.checkNotNullParameter(r1, "fqName");
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner
    public boolean isDeprecatedInJavaDoc() {
        return false;
    }

    public ReflectJavaClassifierType(Type r3) {
        Intrinsics.checkNotNullParameter(r3, "reflectType");
        this.reflectType = r3;
        Type r4 = getReflectType();
        if ((r4 instanceof Class) == false) goto L6;
        ReflectJavaClass r0 = new ReflectJavaClass((Class) r4);
    L11:
        this.classifier = r0;
        return;
    L6:
        if ((r4 instanceof TypeVariable) == false) goto L9;
        r0 = new ReflectJavaTypeParameter((TypeVariable) r4);
        goto L11
    L9:
        if ((r4 instanceof ParameterizedType) == false) goto L14;
        Type r5 = ((ParameterizedType) r4).getRawType();
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type java.lang.Class<*>");
        r0 = new ReflectJavaClass((Class) r5);
        goto L11
    L14:
        throw new IllegalStateException("Not a classifier type (" + r4.getClass() + "): " + r4);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaType
    public Type getReflectType() {
        return this.reflectType;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassifierType
    public JavaClassifier getClassifier() {
        return this.classifier;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassifierType
    public String getClassifierQualifiedName() {
        throw new UnsupportedOperationException("Type not found: " + getReflectType());
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassifierType
    public String getPresentableText() {
        return getReflectType().toString();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassifierType
    public boolean isRaw() {
        Type r2 = getReflectType();
        if ((r2 instanceof Class) == false) goto L12;
        TypeVariable[] r3 = ((Class) r2).getTypeParameters();
        Intrinsics.checkNotNullExpressionValue(r3, "getTypeParameters()");
        if (r3.length != 0) goto L7;
        boolean r4 = true;
    L9:
        if ((!r4) == true) goto L11;
        return false;
    L11:
        return true;
    L7:
        r4 = false;
        goto L9
    L12:
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassifierType
    public List<JavaType> getTypeArguments() {
        List<Type> r3 = ReflectClassUtilKt.getParameterizedTypeArguments(getReflectType());
        ReflectJavaType.Factory r0 = ReflectJavaType.Factory;
        ArrayList r1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r3, 10));
        Iterator<T> r4 = r3.iterator();
    L4:
        if (r4.hasNext() == false) goto L7;
        r1.add(r0.create((Type) r4.next()));
        goto L4
    L7:
        return r1;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner
    public Collection<JavaAnnotation> getAnnotations() {
        return CollectionsKt.emptyList();
    }
}
