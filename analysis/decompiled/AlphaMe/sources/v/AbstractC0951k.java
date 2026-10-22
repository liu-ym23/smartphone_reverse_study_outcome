package v;

/* renamed from: v.k, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0951k {

    /* renamed from: a, reason: collision with root package name */
    public static final boolean[] f15673a = new boolean[3];

    public static void a(C0945e c0945e, t.e eVar, C0944d c0944d) {
        c0944d.f15577o = -1;
        c0944d.f15579p = -1;
        int i4 = c0945e.f15580p0[0];
        int[] iArr = c0944d.f15580p0;
        if (i4 != 2 && iArr[0] == 4) {
            C0943c c0943c = c0944d.f15532I;
            int i5 = c0943c.f15521g;
            int iR = c0945e.r();
            C0943c c0943c2 = c0944d.f15534K;
            int i6 = iR - c0943c2.f15521g;
            c0943c.f15523i = eVar.k(c0943c);
            c0943c2.f15523i = eVar.k(c0943c2);
            eVar.d(c0943c.f15523i, i5);
            eVar.d(c0943c2.f15523i, i6);
            c0944d.f15577o = 2;
            c0944d.f15547Y = i5;
            int i7 = i6 - i5;
            c0944d.f15543U = i7;
            int i8 = c0944d.f15552b0;
            if (i7 < i8) {
                c0944d.f15543U = i8;
            }
        }
        if (c0945e.f15580p0[1] == 2 || iArr[1] != 4) {
            return;
        }
        C0943c c0943c3 = c0944d.f15533J;
        int i9 = c0943c3.f15521g;
        int iL = c0945e.l();
        C0943c c0943c4 = c0944d.f15535L;
        int i10 = iL - c0943c4.f15521g;
        c0943c3.f15523i = eVar.k(c0943c3);
        c0943c4.f15523i = eVar.k(c0943c4);
        eVar.d(c0943c3.f15523i, i9);
        eVar.d(c0943c4.f15523i, i10);
        if (c0944d.f15550a0 > 0 || c0944d.f15562g0 == 8) {
            C0943c c0943c5 = c0944d.f15536M;
            t.i iVarK = eVar.k(c0943c5);
            c0943c5.f15523i = iVarK;
            eVar.d(iVarK, c0944d.f15550a0 + i9);
        }
        c0944d.f15579p = 2;
        c0944d.f15548Z = i9;
        int i11 = i10 - i9;
        c0944d.f15544V = i11;
        int i12 = c0944d.f15554c0;
        if (i11 < i12) {
            c0944d.f15544V = i12;
        }
    }

    public static final boolean b(int i4, int i5) {
        return (i4 & i5) == i5;
    }
}
