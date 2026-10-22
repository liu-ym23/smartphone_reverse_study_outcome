package r;

import a.AbstractC0291a;
import e2.C1404a;

/* renamed from: r.d, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C1872d extends AbstractC1869a {
    public final String f;
    public final C1404a g;
    public final C1871c h;
    public int i;

    public C1872d(C1871c c1871c, String str) {
        super(c1871c);
        this.i = 0;
        this.f = str;
        this.h = c1871c;
        this.g = C1404a.c(c1871c.f.a());
    }

    @Override // r.AbstractC1869a
    public final boolean c() {
        C1871c c1871c;
        C1871c c1871c2 = this.h;
        String str = this.f;
        int i = AbstractC0291a.n(c1871c2, null, str) ? 0 : this.i + 1;
        this.i = i;
        if (i > 3 && (c1871c = this.g.c) != null) {
            c1871c.g.removeMessages(15);
            c1871c.g.obtainMessage(15, new Object[]{Boolean.FALSE, str}).sendToTarget();
        }
        return true;
    }

    @Override // r.AbstractC1869a
    public final String d() {
        return "RangersEventVerify";
    }

    @Override // r.AbstractC1869a
    public final long[] e() {
        return new long[]{1000};
    }

    @Override // r.AbstractC1869a
    public final long f() {
        return 1000L;
    }
}
