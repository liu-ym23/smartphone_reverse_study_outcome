package n8;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.TypeVariable;
import java.util.Collection;
import kotlin.collections.EmptyList;
import x8.InterfaceC2119b;

/* loaded from: classes4.dex */
public final class v extends l implements InterfaceC2119b {

    /* renamed from: a, reason: collision with root package name */
    public final TypeVariable f5366a;

    public v(TypeVariable typeVariable) {
        kotlin.jvm.internal.k.f(typeVariable, "typeVariable");
        this.f5366a = typeVariable;
    }

    @Override // x8.InterfaceC2119b
    public final d a(G8.c fqName) {
        Annotation[] declaredAnnotations;
        kotlin.jvm.internal.k.f(fqName, "fqName");
        TypeVariable typeVariable = this.f5366a;
        AnnotatedElement annotatedElement = typeVariable instanceof AnnotatedElement ? (AnnotatedElement) typeVariable : null;
        if (annotatedElement == null || (declaredAnnotations = annotatedElement.getDeclaredAnnotations()) == null) {
            return null;
        }
        return H4.o.B(declaredAnnotations, fqName);
    }

    public final boolean equals(Object obj) {
        if (obj instanceof v) {
            return kotlin.jvm.internal.k.b(this.f5366a, ((v) obj).f5366a);
        }
        return false;
    }

    @Override // x8.InterfaceC2119b
    public final Collection getAnnotations() {
        Annotation[] declaredAnnotations;
        TypeVariable typeVariable = this.f5366a;
        AnnotatedElement annotatedElement = typeVariable instanceof AnnotatedElement ? (AnnotatedElement) typeVariable : null;
        return (annotatedElement == null || (declaredAnnotations = annotatedElement.getDeclaredAnnotations()) == null) ? EmptyList.f4893a : H4.o.D(declaredAnnotations);
    }

    public final int hashCode() {
        return this.f5366a.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        androidx.constraintlayout.core.dsl.a.z(sb, v.class, ": ");
        sb.append(this.f5366a);
        return sb.toString();
    }
}
