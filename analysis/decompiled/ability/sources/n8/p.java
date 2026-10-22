package n8;

import h8.C1515X;
import h8.a0;
import h8.d0;
import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Member;
import java.lang.reflect.Modifier;
import java.util.Collection;
import kotlin.collections.EmptyList;
import l8.C1664a;
import l8.C1665b;
import l8.C1666c;
import x8.InterfaceC2119b;
import x8.InterfaceC2120c;

/* loaded from: classes4.dex */
public abstract class p extends l implements InterfaceC2119b, InterfaceC2120c {
    @Override // x8.InterfaceC2119b
    public final d a(G8.c fqName) {
        kotlin.jvm.internal.k.f(fqName, "fqName");
        Member memberB = b();
        kotlin.jvm.internal.k.d(memberB, "null cannot be cast to non-null type java.lang.reflect.AnnotatedElement");
        Annotation[] declaredAnnotations = ((AnnotatedElement) memberB).getDeclaredAnnotations();
        if (declaredAnnotations != null) {
            return H4.o.B(declaredAnnotations, fqName);
        }
        return null;
    }

    public abstract Member b();

    public final G8.f c() {
        String name = b().getName();
        return name != null ? G8.f.e(name) : G8.h.f692a;
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0127  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.ArrayList d(java.lang.reflect.Type[] r13, java.lang.annotation.Annotation[][] r14, boolean r15) throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        /*
            Method dump skipped, instructions count: 311
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: n8.p.d(java.lang.reflect.Type[], java.lang.annotation.Annotation[][], boolean):java.util.ArrayList");
    }

    public final d0 e() {
        int modifiers = b().getModifiers();
        return Modifier.isPublic(modifiers) ? a0.c : Modifier.isPrivate(modifiers) ? C1515X.c : Modifier.isProtected(modifiers) ? Modifier.isStatic(modifiers) ? C1666c.c : C1665b.c : C1664a.c;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof p) && kotlin.jvm.internal.k.b(b(), ((p) obj).b());
    }

    @Override // x8.InterfaceC2119b
    public final Collection getAnnotations() {
        Member memberB = b();
        kotlin.jvm.internal.k.d(memberB, "null cannot be cast to non-null type java.lang.reflect.AnnotatedElement");
        Annotation[] declaredAnnotations = ((AnnotatedElement) memberB).getDeclaredAnnotations();
        return declaredAnnotations != null ? H4.o.D(declaredAnnotations) : EmptyList.f4893a;
    }

    public final int hashCode() {
        return b().hashCode();
    }

    public final String toString() {
        return getClass().getName() + ": " + b();
    }
}
