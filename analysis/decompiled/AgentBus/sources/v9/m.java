package v9;

import java.util.List;

/* loaded from: classes.dex */
public abstract class m extends z {
    @Override // v9.v
    public final List C0() {
        return N0().C0();
    }

    @Override // v9.v
    public i0 D0() {
        return N0().D0();
    }

    @Override // v9.v
    public final m0 E0() {
        return N0().E0();
    }

    @Override // v9.v
    public boolean F0() {
        return N0().F0();
    }

    public abstract z N0();

    @Override // v9.z0
    /* renamed from: O0, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public z J0(w9.g gVar) {
        q7.k.e(gVar, "kotlinTypeRefiner");
        z zVarN0 = N0();
        q7.k.e(zVarN0, "type");
        return P0(zVarN0);
    }

    public abstract m P0(z zVar);

    @Override // v9.v
    public final o9.n v0() {
        return N0().v0();
    }
}
