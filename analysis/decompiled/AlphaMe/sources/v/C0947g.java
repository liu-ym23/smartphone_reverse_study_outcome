package v;

import java.util.ArrayList;
import w.C0956b;
import w.C0968n;

/* renamed from: v.g, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0947g extends AbstractC0950j {

    /* renamed from: A0, reason: collision with root package name */
    public int f15630A0;

    /* renamed from: B0, reason: collision with root package name */
    public C0956b f15631B0;

    /* renamed from: C0, reason: collision with root package name */
    public C0968n f15632C0;

    /* renamed from: D0, reason: collision with root package name */
    public int f15633D0;

    /* renamed from: E0, reason: collision with root package name */
    public int f15634E0;

    /* renamed from: F0, reason: collision with root package name */
    public int f15635F0;

    /* renamed from: G0, reason: collision with root package name */
    public int f15636G0;

    /* renamed from: H0, reason: collision with root package name */
    public int f15637H0;

    /* renamed from: I0, reason: collision with root package name */
    public int f15638I0;

    /* renamed from: J0, reason: collision with root package name */
    public float f15639J0;

    /* renamed from: K0, reason: collision with root package name */
    public float f15640K0;

    /* renamed from: L0, reason: collision with root package name */
    public float f15641L0;

    /* renamed from: M0, reason: collision with root package name */
    public float f15642M0;

    /* renamed from: N0, reason: collision with root package name */
    public float f15643N0;

    /* renamed from: O0, reason: collision with root package name */
    public float f15644O0;

    /* renamed from: P0, reason: collision with root package name */
    public int f15645P0;

    /* renamed from: Q0, reason: collision with root package name */
    public int f15646Q0;
    public int R0;

    /* renamed from: S0, reason: collision with root package name */
    public int f15647S0;

    /* renamed from: T0, reason: collision with root package name */
    public int f15648T0;

    /* renamed from: U0, reason: collision with root package name */
    public int f15649U0;

    /* renamed from: V0, reason: collision with root package name */
    public int f15650V0;

    /* renamed from: W0, reason: collision with root package name */
    public ArrayList f15651W0;

    /* renamed from: X0, reason: collision with root package name */
    public C0944d[] f15652X0;

    /* renamed from: Y0, reason: collision with root package name */
    public C0944d[] f15653Y0;

    /* renamed from: Z0, reason: collision with root package name */
    public int[] f15654Z0;

    /* renamed from: a1, reason: collision with root package name */
    public C0944d[] f15655a1;

    /* renamed from: b1, reason: collision with root package name */
    public int f15656b1;

    /* renamed from: s0, reason: collision with root package name */
    public int f15657s0;

    /* renamed from: t0, reason: collision with root package name */
    public int f15658t0;

    /* renamed from: u0, reason: collision with root package name */
    public int f15659u0;

    /* renamed from: v0, reason: collision with root package name */
    public int f15660v0;

    /* renamed from: w0, reason: collision with root package name */
    public int f15661w0;

    /* renamed from: x0, reason: collision with root package name */
    public int f15662x0;

    /* renamed from: y0, reason: collision with root package name */
    public boolean f15663y0;

    /* renamed from: z0, reason: collision with root package name */
    public int f15664z0;

    public final int T(int i4, C0944d c0944d) {
        if (c0944d == null) {
            return 0;
        }
        int[] iArr = c0944d.f15580p0;
        if (iArr[1] == 3) {
            int i5 = c0944d.f15583s;
            if (i5 == 0) {
                return 0;
            }
            if (i5 == 2) {
                int i6 = (int) (c0944d.f15590z * i4);
                if (i6 != c0944d.l()) {
                    c0944d.f15561g = true;
                    V(c0944d, iArr[0], c0944d.r(), 1, i6);
                }
                return i6;
            }
            if (i5 == 1) {
                return c0944d.l();
            }
            if (i5 == 3) {
                return (int) ((c0944d.r() * c0944d.f15545W) + 0.5f);
            }
        }
        return c0944d.l();
    }

    public final int U(int i4, C0944d c0944d) {
        if (c0944d == null) {
            return 0;
        }
        int[] iArr = c0944d.f15580p0;
        if (iArr[0] == 3) {
            int i5 = c0944d.f15582r;
            if (i5 == 0) {
                return 0;
            }
            if (i5 == 2) {
                int i6 = (int) (c0944d.f15587w * i4);
                if (i6 != c0944d.r()) {
                    c0944d.f15561g = true;
                    V(c0944d, 1, i6, iArr[1], c0944d.l());
                }
                return i6;
            }
            if (i5 == 1) {
                return c0944d.r();
            }
            if (i5 == 3) {
                return (int) ((c0944d.l() * c0944d.f15545W) + 0.5f);
            }
        }
        return c0944d.r();
    }

    public final void V(C0944d c0944d, int i4, int i5, int i6, int i7) {
        C0968n c0968n;
        C0944d c0944d2;
        while (true) {
            c0968n = this.f15632C0;
            if (c0968n != null || (c0944d2 = this.T) == null) {
                break;
            } else {
                this.f15632C0 = ((C0945e) c0944d2).f15606u0;
            }
        }
        C0956b c0956b = this.f15631B0;
        c0956b.f15732a = i4;
        c0956b.f15733b = i6;
        c0956b.f15734c = i5;
        c0956b.f15735d = i7;
        c0968n.b(c0944d, c0956b);
        c0944d.P(this.f15631B0.f15736e);
        c0944d.M(this.f15631B0.f15737f);
        C0956b c0956b2 = this.f15631B0;
        c0944d.f15528E = c0956b2.f15739h;
        c0944d.J(c0956b2.f15738g);
    }

    @Override // v.AbstractC0950j, v.InterfaceC0949i
    public final void a() {
        for (int i4 = 0; i4 < this.f15672r0; i4++) {
            C0944d c0944d = this.f15671q0[i4];
            if (c0944d != null) {
                c0944d.f15529F = true;
            }
        }
    }

    @Override // v.C0944d
    public final void c(t.e eVar, boolean z4) {
        C0944d c0944d;
        float f4;
        int i4;
        super.c(eVar, z4);
        C0944d c0944d2 = this.T;
        boolean z5 = c0944d2 != null && ((C0945e) c0944d2).f15607v0;
        int i5 = this.f15648T0;
        ArrayList arrayList = this.f15651W0;
        if (i5 != 0) {
            if (i5 == 1) {
                int size = arrayList.size();
                int i6 = 0;
                while (i6 < size) {
                    ((C0946f) arrayList.get(i6)).b(i6, z5, i6 == size + (-1));
                    i6++;
                }
            } else if (i5 != 2) {
                if (i5 == 3) {
                    int size2 = arrayList.size();
                    int i7 = 0;
                    while (i7 < size2) {
                        ((C0946f) arrayList.get(i7)).b(i7, z5, i7 == size2 + (-1));
                        i7++;
                    }
                }
            } else if (this.f15654Z0 != null && this.f15653Y0 != null && this.f15652X0 != null) {
                for (int i8 = 0; i8 < this.f15656b1; i8++) {
                    this.f15655a1[i8].E();
                }
                int[] iArr = this.f15654Z0;
                int i9 = iArr[0];
                int i10 = iArr[1];
                float f5 = this.f15639J0;
                C0944d c0944d3 = null;
                int i11 = 0;
                while (i11 < i9) {
                    if (z5) {
                        i4 = (i9 - i11) - 1;
                        f4 = 1.0f - this.f15639J0;
                    } else {
                        f4 = f5;
                        i4 = i11;
                    }
                    C0944d c0944d4 = this.f15653Y0[i4];
                    if (c0944d4 != null && c0944d4.f15562g0 != 8) {
                        C0943c c0943c = c0944d4.f15532I;
                        if (i11 == 0) {
                            c0944d4.g(c0943c, this.f15532I, this.f15661w0);
                            c0944d4.f15566i0 = this.f15633D0;
                            c0944d4.f15556d0 = f4;
                        }
                        if (i11 == i9 - 1) {
                            c0944d4.g(c0944d4.f15534K, this.f15534K, this.f15662x0);
                        }
                        if (i11 > 0 && c0944d3 != null) {
                            int i12 = this.f15645P0;
                            C0943c c0943c2 = c0944d3.f15534K;
                            c0944d4.g(c0943c, c0943c2, i12);
                            c0944d3.g(c0943c2, c0943c, 0);
                        }
                        c0944d3 = c0944d4;
                    }
                    i11++;
                    f5 = f4;
                }
                for (int i13 = 0; i13 < i10; i13++) {
                    C0944d c0944d5 = this.f15652X0[i13];
                    if (c0944d5 != null && c0944d5.f15562g0 != 8) {
                        C0943c c0943c3 = c0944d5.f15533J;
                        if (i13 == 0) {
                            c0944d5.g(c0943c3, this.f15533J, this.f15657s0);
                            c0944d5.f15568j0 = this.f15634E0;
                            c0944d5.f15558e0 = this.f15640K0;
                        }
                        if (i13 == i10 - 1) {
                            c0944d5.g(c0944d5.f15535L, this.f15535L, this.f15658t0);
                        }
                        if (i13 > 0 && c0944d3 != null) {
                            int i14 = this.f15646Q0;
                            C0943c c0943c4 = c0944d3.f15535L;
                            c0944d5.g(c0943c3, c0943c4, i14);
                            c0944d3.g(c0943c4, c0943c3, 0);
                        }
                        c0944d3 = c0944d5;
                    }
                }
                for (int i15 = 0; i15 < i9; i15++) {
                    for (int i16 = 0; i16 < i10; i16++) {
                        int i17 = (i16 * i9) + i15;
                        if (this.f15650V0 == 1) {
                            i17 = (i15 * i10) + i16;
                        }
                        C0944d[] c0944dArr = this.f15655a1;
                        if (i17 < c0944dArr.length && (c0944d = c0944dArr[i17]) != null && c0944d.f15562g0 != 8) {
                            C0944d c0944d6 = this.f15653Y0[i15];
                            C0944d c0944d7 = this.f15652X0[i16];
                            if (c0944d != c0944d6) {
                                c0944d.g(c0944d.f15532I, c0944d6.f15532I, 0);
                                c0944d.g(c0944d.f15534K, c0944d6.f15534K, 0);
                            }
                            if (c0944d != c0944d7) {
                                c0944d.g(c0944d.f15533J, c0944d7.f15533J, 0);
                                c0944d.g(c0944d.f15535L, c0944d7.f15535L, 0);
                            }
                        }
                    }
                }
            }
        } else if (arrayList.size() > 0) {
            ((C0946f) arrayList.get(0)).b(0, z5, true);
        }
        this.f15663y0 = false;
    }
}
