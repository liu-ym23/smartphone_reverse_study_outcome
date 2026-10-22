package X8;

import a9.InterfaceC0313e;
import h8.InterfaceC1524g;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.collections.EmptyList;

/* loaded from: classes4.dex */
public final class v implements K, InterfaceC0313e {

    /* renamed from: a, reason: collision with root package name */
    public w f1536a;
    public final LinkedHashSet b;
    public final int c;

    public v(AbstractCollection typesToIntersect) {
        kotlin.jvm.internal.k.f(typesToIntersect, "typesToIntersect");
        typesToIntersect.isEmpty();
        LinkedHashSet linkedHashSet = new LinkedHashSet(typesToIntersect);
        this.b = linkedHashSet;
        this.c = linkedHashSet.hashCode();
    }

    public final A b() {
        H.b.getClass();
        return AbstractC0272c.w(H.c, this, EmptyList.f4893a, false, H4.o.x("member scope for intersection type", this.b), new J4.b(this, 8));
    }

    @Override // X8.K
    public final e8.i c() {
        e8.i iVarC = ((w) this.b.iterator().next()).Q().c();
        kotlin.jvm.internal.k.e(iVarC, "getBuiltIns(...)");
        return iVarC;
    }

    @Override // X8.K
    public final InterfaceC1524g d() {
        return null;
    }

    @Override // X8.K
    public final Collection e() {
        return this.b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof v)) {
            return false;
        }
        return kotlin.jvm.internal.k.b(this.b, ((v) obj).b);
    }

    @Override // X8.K
    public final boolean f() {
        return false;
    }

    public final String g(S7.k getProperTypeRelatedToStringify) {
        kotlin.jvm.internal.k.f(getProperTypeRelatedToStringify, "getProperTypeRelatedToStringify");
        return D7.v.I0(D7.v.Z0(this.b, new C0289u(getProperTypeRelatedToStringify)), " & ", "{", "}", new J4.b(getProperTypeRelatedToStringify, 7), 24);
    }

    @Override // X8.K
    public final List getParameters() {
        return EmptyList.f4893a;
    }

    public final int hashCode() {
        return this.c;
    }

    public final String toString() {
        return g(C0288t.b);
    }
}
