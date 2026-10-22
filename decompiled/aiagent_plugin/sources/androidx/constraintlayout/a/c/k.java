package androidx.constraintlayout.a.c;

/* JADX INFO: compiled from: Optimizer.java */
/* JADX INFO: loaded from: classes.dex */
public class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static boolean[] f788a;

    public static final boolean a(int r0, int r1) {
        if ((r0 & r1) != r1) goto L5;
        return true;
    L5:
        return false;
    }

    static {
        f788a = new boolean[3];
    }

    static void a(f r5, androidx.constraintlayout.a.d r6, e r7) {
        r7.l = -1;
        r7.m = -1;
        if (r5.K[0] == e.a.f776b) goto L8;
        if (r7.K[0] != e.a.f778d) goto L8;
        int r0 = r7.A.f759d;
        int r1 = r5.F() - r7.C.f759d;
        d r2 = r7.A;
        r2.f = r6.a(r7.A);
        d r3 = r7.C;
        r3.f = r6.a(r7.C);
        r6.a(r7.A.f, r0);
        r6.a(r7.C.f, r1);
        r7.l = 2;
        r7.f(r0, r1);
    L8:
        if (r5.K[1] != e.a.f776b) goto L10;
        return;
    L10:
        if (r7.K[1] != e.a.f778d) goto L19;
        int r4 = r7.B.f759d;
        int r8 = r5.G() - r7.D.f759d;
        d r9 = r7.B;
        r9.f = r6.a(r7.B);
        d r10 = r7.D;
        r10.f = r6.a(r7.D);
        r6.a(r7.B.f, r4);
        r6.a(r7.D.f, r8);
        if (r7.W <= 0) goto L14;
    L15:
        d r11 = r7.E;
        r11.f = r6.a(r7.E);
        r6.a(r7.E.f, r7.W + r4);
    L16:
        r7.m = 2;
        r7.g(r4, r8);
        return;
    L14:
        if (r7.B() != 8) goto L16;
    }
}
