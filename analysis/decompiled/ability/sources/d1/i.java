package d1;

import b1.C0821b;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes2.dex */
public final class i extends A8.b {
    public CopyOnWriteArrayList b;
    public CopyOnWriteArrayList c;
    public CopyOnWriteArrayList d;
    public C0.b e;
    public C0821b f;
    public long g;
    public boolean h;

    @Override // A8.b
    public final void F0() {
        super.F0();
        Q0();
    }

    @Override // A8.b
    public final void H0(C0821b c0821b, boolean z10) {
        super.H0(c0821b, z10);
        this.f = c0821b;
        this.g = System.currentTimeMillis();
        this.h = z10;
        s1.b.a(cc.dd.ee.kk.ff.c.c).c(this.e);
    }

    @Override // A8.b
    public final void K0(boolean z10) {
        super.K0(z10);
        Q0();
        c1.b bVar = (c1.b) this.f160a;
        synchronized (bVar) {
            bVar.a(bVar.l);
        }
    }

    @Override // A8.b
    public final cc.dd.ee.ee.ee.d L0() {
        return cc.dd.ee.ee.ee.d.c;
    }

    /* JADX WARN: Removed duplicated region for block: B:85:0x02c8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void P0() {
        /*
            Method dump skipped, instructions count: 989
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: d1.i.P0():void");
    }

    public final void Q0() {
        this.b.clear();
        this.d.clear();
        this.c.clear();
        this.g = 0L;
        s1.b.a(cc.dd.ee.kk.ff.c.c).b(this.e);
    }
}
