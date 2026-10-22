package d1;

import b1.C0821b;

/* loaded from: classes2.dex */
public final class f extends A8.b {
    @Override // A8.b
    public final void H0(C0821b c0821b, boolean z10) {
        super.H0(c0821b, z10);
        c1.b bVar = (c1.b) this.f160a;
        synchronized (bVar) {
            bVar.a(bVar.h);
        }
    }

    @Override // A8.b
    public final void K0(boolean z10) {
        super.K0(z10);
        I0("life cycle change when state is idle, lifecycle change to back?: " + z10);
        c1.b bVar = (c1.b) this.f160a;
        synchronized (bVar) {
            bVar.a(bVar.h);
        }
    }

    @Override // A8.b
    public final cc.dd.ee.ee.ee.d L0() {
        return cc.dd.ee.ee.ee.d.e;
    }
}
