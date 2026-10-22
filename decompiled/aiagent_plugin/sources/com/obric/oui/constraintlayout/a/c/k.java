package com.obric.oui.constraintlayout.a.c;

/* JADX INFO: compiled from: Optimizer.java */
/* JADX INFO: loaded from: classes4.dex */
public class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static boolean[] f34769a;

    public static final boolean a(int r0, int r1) {
        if ((r0 & r1) != r1) goto L5;
        return true;
    L5:
        return false;
    }

    static {
        f34769a = new boolean[3];
    }

    static void a(f r5, com.obric.oui.constraintlayout.a.d r6, e r7) {
        r7.l = -1;
        r7.m = -1;
        if (r5.L[0] == e.a.f34757b) goto L8;
        if (r7.L[0] != e.a.f34759d) goto L8;
        int r0 = r7.B.f34740d;
        int r1 = r5.F() - r7.D.f34740d;
        d r2 = r7.B;
        r2.f = r6.a(r7.B);
        d r3 = r7.D;
        r3.f = r6.a(r7.D);
        r6.a(r7.B.f, r0);
        r6.a(r7.D.f, r1);
        r7.l = 2;
        r7.f(r0, r1);
    L8:
        if (r5.L[1] != e.a.f34757b) goto L10;
        return;
    L10:
        if (r7.L[1] != e.a.f34759d) goto L19;
        int r4 = r7.C.f34740d;
        int r8 = r5.G() - r7.E.f34740d;
        d r9 = r7.C;
        r9.f = r6.a(r7.C);
        d r10 = r7.E;
        r10.f = r6.a(r7.E);
        r6.a(r7.C.f, r4);
        r6.a(r7.E.f, r8);
        if (r7.X <= 0) goto L14;
    L15:
        d r11 = r7.F;
        r11.f = r6.a(r7.F);
        r6.a(r7.F.f, r7.X + r4);
    L16:
        r7.m = 2;
        r7.g(r4, r8);
        return;
    L14:
        if (r7.B() != 8) goto L16;
    }
}
