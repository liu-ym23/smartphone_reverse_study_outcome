package l8;

import f8.b1;
import f8.e1;
import f8.y0;
import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Member;
import java.lang.reflect.Modifier;
import java.util.Collection;

/* loaded from: classes.dex */
public abstract class w extends s implements v8.b, v8.c {
    @Override // v8.b
    public final e a(e9.c cVar) {
        q7.k.e(cVar, "fqName");
        Member memberB = b();
        q7.k.c(memberB, "null cannot be cast to non-null type java.lang.reflect.AnnotatedElement");
        Annotation[] declaredAnnotations = ((AnnotatedElement) memberB).getDeclaredAnnotations();
        if (declaredAnnotations != null) {
            return a.a.M(declaredAnnotations, cVar);
        }
        return null;
    }

    public abstract Member b();

    public final e9.f c() {
        String name = b().getName();
        e9.f fVarE = name != null ? e9.f.e(name) : null;
        return fVarE == null ? e9.h.f3200a : fVarE;
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0121  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.ArrayList d(java.lang.reflect.Type[] r13, java.lang.annotation.Annotation[][] r14, boolean r15) throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        /*
            Method dump skipped, instructions count: 305
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: l8.w.d(java.lang.reflect.Type[], java.lang.annotation.Annotation[][], boolean):java.util.ArrayList");
    }

    public final e1 e() {
        int modifiers = b().getModifiers();
        return Modifier.isPublic(modifiers) ? b1.f3464c : Modifier.isPrivate(modifiers) ? y0.f3522c : Modifier.isProtected(modifiers) ? Modifier.isStatic(modifiers) ? j8.c.f5403c : j8.b.f5402c : j8.a.f5401c;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof w) && q7.k.a(b(), ((w) obj).b());
    }

    @Override // v8.b
    public final Collection getAnnotations() {
        Member memberB = b();
        q7.k.c(memberB, "null cannot be cast to non-null type java.lang.reflect.AnnotatedElement");
        Annotation[] declaredAnnotations = ((AnnotatedElement) memberB).getDeclaredAnnotations();
        return declaredAnnotations != null ? a.a.P(declaredAnnotations) : d7.z.f2978f;
    }

    public final int hashCode() {
        return b().hashCode();
    }

    public final String toString() {
        return getClass().getName() + ": " + b();
    }
}
