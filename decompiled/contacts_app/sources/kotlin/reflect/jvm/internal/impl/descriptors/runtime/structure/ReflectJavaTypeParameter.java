package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaTypeParameter;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;

/* JADX INFO: compiled from: ReflectJavaTypeParameter.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class ReflectJavaTypeParameter extends ReflectJavaElement implements ReflectJavaAnnotationOwner, JavaTypeParameter {
    private final TypeVariable<?> typeVariable;

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner
    public ReflectJavaAnnotation findAnnotation(FqName r1) {
        return ReflectJavaAnnotationOwner.DefaultImpls.findAnnotation(this, r1);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner
    public /* bridge */ /* synthetic */ JavaAnnotation findAnnotation(FqName r1) {
        return findAnnotation(r1);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner
    public /* bridge */ /* synthetic */ Collection getAnnotations() {
        return getAnnotations();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner
    public List<ReflectJavaAnnotation> getAnnotations() {
        return ReflectJavaAnnotationOwner.DefaultImpls.getAnnotations(this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaTypeParameter
    public /* bridge */ /* synthetic */ Collection getUpperBounds() {
        return getUpperBounds();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner
    public boolean isDeprecatedInJavaDoc() {
        return ReflectJavaAnnotationOwner.DefaultImpls.isDeprecatedInJavaDoc(this);
    }

    public ReflectJavaTypeParameter(TypeVariable<?> r2) {
        Intrinsics.checkNotNullParameter(r2, "typeVariable");
        this.typeVariable = r2;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaTypeParameter
    public List<ReflectJavaClassifierType> getUpperBounds() {
        Type[] r5 = this.typeVariable.getBounds();
        Intrinsics.checkNotNullExpressionValue(r5, "typeVariable.bounds");
        Type[] r6 = r5;
        ArrayList r0 = new ArrayList(r6.length);
        int r1 = r6.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L5;
        r0.add(new ReflectJavaClassifierType(r6[r2]));
        r2 = r2 + 1;
        goto L3
    L5:
        ArrayList r3 = r0;
        ReflectJavaClassifierType r7 = (ReflectJavaClassifierType) CollectionsKt.singleOrNull(r3);
        if (r7 == null) goto L8;
        Type r8 = r7.getReflectType();
    L10:
        if (Intrinsics.areEqual(r8, Object.class) == true) goto L12;
        return r3;
    L12:
        return CollectionsKt.emptyList();
    L8:
        r8 = null;
        goto L10
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaAnnotationOwner
    public AnnotatedElement getElement() {
        TypeVariable<?> r1 = this.typeVariable;
        if ((r1 instanceof AnnotatedElement) == true) goto L7;
        return null;
    L7:
        return (AnnotatedElement) r1;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaNamedElement
    public Name getName() {
        Name r1 = Name.identifier(this.typeVariable.getName());
        Intrinsics.checkNotNullExpressionValue(r1, "identifier(typeVariable.name)");
        return r1;
    }

    public boolean equals(Object r2) {
        if ((r2 instanceof ReflectJavaTypeParameter) == true) goto L5;
    L7:
        return false;
    L5:
        if (Intrinsics.areEqual(this.typeVariable, ((ReflectJavaTypeParameter) r2).typeVariable) == false) goto L7;
        return true;
    }

    public int hashCode() {
        return this.typeVariable.hashCode();
    }

    public String toString() {
        return getClass().getName() + ": " + this.typeVariable;
    }
}
