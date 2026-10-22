package d1;

import b1.C0821b;

/* renamed from: d1.a, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC1374a extends A8.b {
    public C0821b b;
    public final C0.b c;
    public boolean d;

    public AbstractC1374a(c1.b bVar) {
        super(bVar);
        this.c = new C0.b(this, Q0(), Q0());
    }

    @Override // A8.b
    public final void F0() {
        super.F0();
        s1.b.a(cc.dd.ee.kk.ff.c.c).b(this.c);
    }

    @Override // A8.b
    public final void H0(C0821b c0821b, boolean z10) {
        super.H0(c0821b, z10);
        this.b = c0821b;
        this.d = z10;
        s1.b.a(cc.dd.ee.kk.ff.c.c).c(this.c);
    }

    @Override // A8.b
    public void K0(boolean z10) {
        super.K0(z10);
        s1.b.a(cc.dd.ee.kk.ff.c.c).b(this.c);
        c1.b bVar = (c1.b) this.f160a;
        synchronized (bVar) {
            bVar.a(bVar.l);
        }
    }

    public abstract boolean P0(boolean z10);

    public abstract long Q0();

    public abstract boolean R0();
}
