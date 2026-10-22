package K9;

import Z8.C1173v;
import Z9.InterfaceC1178a;
import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* loaded from: classes5.dex */
public final class E extends t implements j, Z9.y {

    /* renamed from: a, reason: collision with root package name */
    public final TypeVariable<?> f4147a;

    public E(TypeVariable<?> typeVariable) {
        kotlin.jvm.internal.p.i(typeVariable, "typeVariable");
        this.f4147a = typeVariable;
    }

    @Override // Z9.d
    public boolean A() {
        return false;
    }

    @Override // Z9.y
    /* renamed from: M, reason: merged with bridge method [inline-methods] */
    public List<r> getUpperBounds() {
        Type[] bounds = this.f4147a.getBounds();
        kotlin.jvm.internal.p.h(bounds, "getBounds(...)");
        ArrayList arrayList = new ArrayList(bounds.length);
        for (Type type : bounds) {
            arrayList.add(new r(type));
        }
        r rVar = (r) Z8.F.Z0(arrayList);
        return kotlin.jvm.internal.p.d(rVar != null ? rVar.M() : null, Object.class) ? C1173v.m() : arrayList;
    }

    @Override // Z9.d
    public /* bridge */ /* synthetic */ InterfaceC1178a d(ga.c cVar) {
        return d(cVar);
    }

    public boolean equals(Object obj) {
        return (obj instanceof E) && kotlin.jvm.internal.p.d(this.f4147a, ((E) obj).f4147a);
    }

    @Override // Z9.d
    public /* bridge */ /* synthetic */ Collection getAnnotations() {
        return getAnnotations();
    }

    @Override // Z9.t
    public ga.e getName() {
        ga.e eVarJ = ga.e.j(this.f4147a.getName());
        kotlin.jvm.internal.p.h(eVarJ, "identifier(...)");
        return eVarJ;
    }

    public int hashCode() {
        return this.f4147a.hashCode();
    }

    @Override // K9.j
    public AnnotatedElement s() {
        TypeVariable<?> typeVariable = this.f4147a;
        if (typeVariable instanceof AnnotatedElement) {
            return (AnnotatedElement) typeVariable;
        }
        return null;
    }

    public String toString() {
        return E.class.getName() + ": " + this.f4147a;
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
