package v9;

import java.util.List;

/* loaded from: classes.dex */
public abstract class p extends z0 implements y9.g {

    /* renamed from: g, reason: collision with root package name */
    public final z f10580g;

    /* renamed from: h, reason: collision with root package name */
    public final z f10581h;

    public p(z zVar, z zVar2) {
        q7.k.e(zVar, "lowerBound");
        q7.k.e(zVar2, "upperBound");
        this.f10580g = zVar;
        this.f10581h = zVar2;
    }

    @Override // v9.v
    public final List C0() {
        return L0().C0();
    }

    @Override // v9.v
    public final i0 D0() {
        return L0().D0();
    }

    @Override // v9.v
    public final m0 E0() {
        return L0().E0();
    }

    @Override // v9.v
    public final boolean F0() {
        return L0().F0();
    }

    public abstract z L0();

    public abstract String M0(g9.g gVar, g9.g gVar2);

    public String toString() {
        return g9.g.f3941e.Z(this);
    }

    @Override // v9.v
    public o9.n v0() {
        return L0().v0();
    }
}
