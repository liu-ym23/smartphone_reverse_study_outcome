package v9;

import java.util.AbstractCollection;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;

/* loaded from: classes.dex */
public final class u implements m0, y9.m {

    /* renamed from: a, reason: collision with root package name */
    public v f10591a;

    /* renamed from: b, reason: collision with root package name */
    public final LinkedHashSet f10592b;

    /* renamed from: c, reason: collision with root package name */
    public final int f10593c;

    public u(AbstractCollection abstractCollection) {
        q7.k.e(abstractCollection, "typesToIntersect");
        abstractCollection.isEmpty();
        LinkedHashSet linkedHashSet = new LinkedHashSet(abstractCollection);
        this.f10592b = linkedHashSet;
        this.f10593c = linkedHashSet.hashCode();
    }

    @Override // v9.m0
    public final boolean a() {
        return false;
    }

    @Override // v9.m0
    public final f8.g c() {
        return null;
    }

    @Override // v9.m0
    public final Collection d() {
        return this.f10592b;
    }

    public final z e() {
        i0.f10557g.getClass();
        return d.t(i0.f10558h, this, d7.z.f2978f, false, n7.o.g("member scope for intersection type", this.f10592b), new r8.c(10, this));
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof u)) {
            return false;
        }
        return q7.k.a(this.f10592b, ((u) obj).f10592b);
    }

    public final String f(p7.k kVar) {
        q7.k.e(kVar, "getProperTypeRelatedToStringify");
        return d7.r.U0(d7.r.j1(this.f10592b, new p1.w(2, kVar)), " & ", "{", "}", new r8.c(11, kVar), 24);
    }

    @Override // v9.m0
    public final List getParameters() {
        return d7.z.f2978f;
    }

    public final int hashCode() {
        return this.f10593c;
    }

    @Override // v9.m0
    public final c8.h n() {
        c8.h hVarN = ((v) this.f10592b.iterator().next()).E0().n();
        q7.k.d(hVarN, "intersectedTypes.iterato…xt().constructor.builtIns");
        return hVarN;
    }

    public final String toString() {
        return f(t.f10590g);
    }
}
