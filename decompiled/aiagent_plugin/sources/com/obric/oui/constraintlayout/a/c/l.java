package com.obric.oui.constraintlayout.a.c;

/* JADX INFO: compiled from: Placeholder.java */
/* JADX INFO: loaded from: classes4.dex */
public class l extends m {
    public l() {
    }

    @Override // com.obric.oui.constraintlayout.a.c.m
    public void b(int r6, int r7, int r8, int r9) {
        int r0 = f() + g();
        boolean r1 = false;
        int r2 = r0 + 0;
        int r3 = (b() + c()) + 0;
        if (this.aA <= 0) goto L5;
        r2 = r2 + this.az[0].F();
        r3 = r3 + this.az[0].G();
    L5:
        int r4 = Math.max(H(), r2);
        int r5 = Math.max(I(), r3);
        if (r6 == 1073741824) goto L13;
        if (r6 != Integer.MIN_VALUE) goto L10;
        r7 = Math.min(r4, r7);
        goto L13
    L10:
        if (r6 != 0) goto L12;
        r7 = r4;
        goto L13
    L12:
        r7 = 0;
    L13:
        if (r8 == 1073741824) goto L20;
        if (r8 != Integer.MIN_VALUE) goto L17;
        r9 = Math.min(r5, r9);
        goto L20
    L17:
        if (r8 != 0) goto L19;
        r9 = r5;
        goto L20
    L19:
        r9 = 0;
    L20:
        h(r7, r9);
        q(r7);
        r(r9);
        if (this.aA <= 0) goto L23;
        r1 = true;
    L23:
        g(r1);
    }

    @Override // com.obric.oui.constraintlayout.a.c.e
    public void a(com.obric.oui.constraintlayout.a.d r2, boolean r3) {
        super.a(r2, r3);
        if (this.aA <= 0) goto L6;
        e r4 = this.az[0];
        r4.Y();
        r4.a(d.a.f34744b, this, d.a.f34744b);
        r4.a(d.a.f34746d, this, d.a.f34746d);
        r4.a(d.a.f34745c, this, d.a.f34745c);
        r4.a(d.a.f34747e, this, d.a.f34747e);
        return;
    }
}
