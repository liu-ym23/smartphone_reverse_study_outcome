package l8;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.TypeVariable;
import java.util.Collection;

/* loaded from: classes.dex */
public final class c0 extends s implements v8.b {

    /* renamed from: a, reason: collision with root package name */
    public final TypeVariable f5856a;

    public c0(TypeVariable typeVariable) {
        q7.k.e(typeVariable, "typeVariable");
        this.f5856a = typeVariable;
    }

    @Override // v8.b
    public final e a(e9.c cVar) {
        Annotation[] declaredAnnotations;
        q7.k.e(cVar, "fqName");
        TypeVariable typeVariable = this.f5856a;
        AnnotatedElement annotatedElement = typeVariable instanceof AnnotatedElement ? (AnnotatedElement) typeVariable : null;
        if (annotatedElement == null || (declaredAnnotations = annotatedElement.getDeclaredAnnotations()) == null) {
            return null;
        }
        return a.a.M(declaredAnnotations, cVar);
    }

    public final boolean equals(Object obj) {
        if (obj instanceof c0) {
            return q7.k.a(this.f5856a, ((c0) obj).f5856a);
        }
        return false;
    }

    @Override // v8.b
    public final Collection getAnnotations() {
        Annotation[] declaredAnnotations;
        TypeVariable typeVariable = this.f5856a;
        AnnotatedElement annotatedElement = typeVariable instanceof AnnotatedElement ? (AnnotatedElement) typeVariable : null;
        return (annotatedElement == null || (declaredAnnotations = annotatedElement.getDeclaredAnnotations()) == null) ? d7.z.f2978f : a.a.P(declaredAnnotations);
    }

    public final int hashCode() {
        return this.f5856a.hashCode();
    }

    public final String toString() {
        return c0.class.getName() + ": " + this.f5856a;
    }
}
