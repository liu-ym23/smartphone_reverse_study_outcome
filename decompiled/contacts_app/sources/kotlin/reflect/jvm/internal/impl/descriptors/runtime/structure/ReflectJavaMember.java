package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Member;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibility;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMember;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaValueParameter;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.name.SpecialNames;

/* JADX INFO: compiled from: ReflectJavaMember.kt */
/* JADX INFO: loaded from: classes4.dex */
public abstract class ReflectJavaMember extends ReflectJavaElement implements ReflectJavaAnnotationOwner, ReflectJavaModifierListOwner, JavaMember {
    public abstract Member getMember();

    public ReflectJavaMember() {
    }

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

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMember
    public /* bridge */ /* synthetic */ JavaClass getContainingClass() {
        return getContainingClass();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaModifierListOwner
    public Visibility getVisibility() {
        return ReflectJavaModifierListOwner.DefaultImpls.getVisibility(this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaModifierListOwner
    public boolean isAbstract() {
        return ReflectJavaModifierListOwner.DefaultImpls.isAbstract(this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationOwner
    public boolean isDeprecatedInJavaDoc() {
        return ReflectJavaAnnotationOwner.DefaultImpls.isDeprecatedInJavaDoc(this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaModifierListOwner
    public boolean isFinal() {
        return ReflectJavaModifierListOwner.DefaultImpls.isFinal(this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaModifierListOwner
    public boolean isStatic() {
        return ReflectJavaModifierListOwner.DefaultImpls.isStatic(this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaAnnotationOwner
    public AnnotatedElement getElement() {
        Member r1 = getMember();
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type java.lang.reflect.AnnotatedElement");
        return (AnnotatedElement) r1;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaModifierListOwner
    public int getModifiers() {
        return getMember().getModifiers();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaNamedElement
    public Name getName() {
        String r0 = getMember().getName();
        if (r0 == null) goto L5;
        Name r1 = Name.identifier(r0);
    L6:
        if (r1 == null) goto L8;
        return r1;
    L8:
        return SpecialNames.NO_NAME_PROVIDED;
    L5:
        r1 = null;
        goto L6
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMember
    public ReflectJavaClass getContainingClass() {
        Class<?> r2 = getMember().getDeclaringClass();
        Intrinsics.checkNotNullExpressionValue(r2, "member.declaringClass");
        return new ReflectJavaClass(r2);
    }

    protected final List<JavaValueParameter> getValueParameters(Type[] r12, Annotation[][] r13, boolean r14) {
        Intrinsics.checkNotNullParameter(r12, "parameterTypes");
        Intrinsics.checkNotNullParameter(r13, "parameterAnnotations");
        ArrayList r0 = new ArrayList(r12.length);
        List<String> r1 = Java8ParameterNamesLoader.INSTANCE.loadParameterNames(getMember());
        if (r1 == null) goto L5;
        int r3 = r1.size() - r12.length;
    L6:
        int r4 = r12.length;
        int r5 = 0;
    L7:
        if (r5 >= r4) goto L23;
        ReflectJavaType r6 = ReflectJavaType.Factory.create(r12[r5]);
        if (r1 == null) goto L15;
        String r7 = (String) CollectionsKt.getOrNull(r1, r5 + r3);
        if (r7 == null) goto L14;
    L16:
        if (r14 == true) goto L18;
    L20:
        boolean r8 = false;
    L21:
        r0.add(new ReflectJavaValueParameter(r6, r13[r5], r7, r8));
        r5 = r5 + 1;
        goto L7
    L18:
        if (r5 != ArraysKt.getLastIndex(r12)) goto L20;
        r8 = true;
        goto L21
    L14:
        throw new IllegalStateException(("No parameter with index " + r5 + '+' + r3 + " (name=" + getName() + " type=" + r6 + ") in " + this).toString());
    L15:
        r7 = null;
        goto L16
    L23:
        return r0;
    L5:
        r3 = 0;
        goto L6
    }

    public boolean equals(Object r2) {
        if ((r2 instanceof ReflectJavaMember) == true) goto L5;
    L7:
        return false;
    L5:
        if (Intrinsics.areEqual(getMember(), ((ReflectJavaMember) r2).getMember()) == false) goto L7;
        return true;
    }

    public int hashCode() {
        return getMember().hashCode();
    }

    public String toString() {
        return getClass().getName() + ": " + getMember();
    }
}
