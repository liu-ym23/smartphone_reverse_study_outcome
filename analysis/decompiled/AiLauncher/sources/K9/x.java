package K9;

import E9.l0;
import E9.m0;
import Z8.C1173v;
import Z9.InterfaceC1178a;
import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Member;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaClass;

/* loaded from: classes5.dex */
public abstract class x extends t implements j, z, Z9.q {
    @Override // Z9.d
    public boolean A() {
        return false;
    }

    @Override // Z9.q
    /* renamed from: M, reason: merged with bridge method [inline-methods] */
    public ReflectJavaClass L() {
        Class<?> declaringClass = N().getDeclaringClass();
        kotlin.jvm.internal.p.h(declaringClass, "getDeclaringClass(...)");
        return new ReflectJavaClass(declaringClass);
    }

    public abstract Member N();

    public final List<Z9.B> O(Type[] parameterTypes, Annotation[][] parameterAnnotations, boolean z10) {
        String str;
        kotlin.jvm.internal.p.i(parameterTypes, "parameterTypes");
        kotlin.jvm.internal.p.i(parameterAnnotations, "parameterAnnotations");
        ArrayList arrayList = new ArrayList(parameterTypes.length);
        List<String> listB = C0922c.f4165a.b(N());
        int size = listB != null ? listB.size() - parameterTypes.length : 0;
        int length = parameterTypes.length;
        int i10 = 0;
        while (i10 < length) {
            D dA = D.f4146a.a(parameterTypes[i10]);
            if (listB != null) {
                str = (String) Z8.F.t0(listB, i10 + size);
                if (str == null) {
                    throw new IllegalStateException(("No parameter with index " + i10 + '+' + size + " (name=" + getName() + " type=" + dA + ") in " + this).toString());
                }
            } else {
                str = null;
            }
            arrayList.add(new F(dA, parameterAnnotations[i10], str, z10 && i10 == Z8.r.f0(parameterTypes)));
            i10++;
        }
        return arrayList;
    }

    @Override // Z9.d
    public /* bridge */ /* synthetic */ InterfaceC1178a d(ga.c cVar) {
        return d(cVar);
    }

    public boolean equals(Object obj) {
        return (obj instanceof x) && kotlin.jvm.internal.p.d(N(), ((x) obj).N());
    }

    @Override // Z9.d
    public /* bridge */ /* synthetic */ Collection getAnnotations() {
        return getAnnotations();
    }

    @Override // K9.z
    public int getModifiers() {
        return N().getModifiers();
    }

    @Override // Z9.t
    public ga.e getName() {
        ga.e eVarJ;
        String name = N().getName();
        return (name == null || (eVarJ = ga.e.j(name)) == null) ? ga.g.f32742b : eVarJ;
    }

    @Override // Z9.s
    public m0 getVisibility() {
        int modifiers = getModifiers();
        return Modifier.isPublic(modifiers) ? l0.h.f2464c : Modifier.isPrivate(modifiers) ? l0.e.f2461c : Modifier.isProtected(modifiers) ? Modifier.isStatic(modifiers) ? I9.c.f3397c : I9.b.f3396c : I9.a.f3395c;
    }

    public int hashCode() {
        return N().hashCode();
    }

    @Override // Z9.s
    public boolean isAbstract() {
        return Modifier.isAbstract(getModifiers());
    }

    @Override // Z9.s
    public boolean isFinal() {
        return Modifier.isFinal(getModifiers());
    }

    @Override // Z9.s
    public boolean isStatic() {
        return Modifier.isStatic(getModifiers());
    }

    @Override // K9.j
    public AnnotatedElement s() {
        Member memberN = N();
        kotlin.jvm.internal.p.g(memberN, "null cannot be cast to non-null type java.lang.reflect.AnnotatedElement");
        return (AnnotatedElement) memberN;
    }

    public String toString() {
        return getClass().getName() + ": " + N();
    }

    @Override // K9.j, Z9.d
    public C0926g d(ga.c fqName) {
        Annotation[] declaredAnnotations;
        kotlin.jvm.internal.p.i(fqName, "fqName");
        AnnotatedElement annotatedElementS = s();
        if (annotatedElementS == null || (declaredAnnotations = annotatedElementS.getDeclaredAnnotations()) == null) {
            return null;
        }
        return k.a(declaredAnnotations, fqName);
    }

    @Override // K9.j, Z9.d
    public List<C0926g> getAnnotations() {
        Annotation[] declaredAnnotations;
        List<C0926g> listB;
        AnnotatedElement annotatedElementS = s();
        return (annotatedElementS == null || (declaredAnnotations = annotatedElementS.getDeclaredAnnotations()) == null || (listB = k.b(declaredAnnotations)) == null) ? C1173v.m() : listB;
    }
}
