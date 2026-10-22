package d1;

import c1.AbstractC0870a;

/* loaded from: classes2.dex */
public final class g extends AbstractC1374a {
    @Override // A8.b
    public final cc.dd.ee.ee.ee.d L0() {
        return cc.dd.ee.ee.ee.d.f2139a;
    }

    @Override // d1.AbstractC1374a
    public final boolean P0(boolean z10) {
        if (!z10) {
            return z10;
        }
        AbstractC0870a.f2080a.getClass();
        c1.b bVar = (c1.b) this.f160a;
        synchronized (bVar) {
            bVar.a(bVar.i);
        }
        return z10;
    }

    @Override // d1.AbstractC1374a
    public final long Q0() {
        return this.d ? 600000L : 30000L;
    }

    @Override // d1.AbstractC1374a
    public final boolean R0() {
        return false;
    }
}
