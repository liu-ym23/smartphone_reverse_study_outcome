package v;

/* renamed from: v.f, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0946f {

    /* renamed from: a, reason: collision with root package name */
    public int f15612a;

    /* renamed from: d, reason: collision with root package name */
    public C0943c f15615d;

    /* renamed from: e, reason: collision with root package name */
    public C0943c f15616e;

    /* renamed from: f, reason: collision with root package name */
    public C0943c f15617f;

    /* renamed from: g, reason: collision with root package name */
    public C0943c f15618g;

    /* renamed from: h, reason: collision with root package name */
    public int f15619h;

    /* renamed from: i, reason: collision with root package name */
    public int f15620i;

    /* renamed from: j, reason: collision with root package name */
    public int f15621j;

    /* renamed from: k, reason: collision with root package name */
    public int f15622k;

    /* renamed from: q, reason: collision with root package name */
    public int f15628q;

    /* renamed from: r, reason: collision with root package name */
    public final /* synthetic */ C0947g f15629r;

    /* renamed from: b, reason: collision with root package name */
    public C0944d f15613b = null;

    /* renamed from: c, reason: collision with root package name */
    public int f15614c = 0;

    /* renamed from: l, reason: collision with root package name */
    public int f15623l = 0;

    /* renamed from: m, reason: collision with root package name */
    public int f15624m = 0;

    /* renamed from: n, reason: collision with root package name */
    public int f15625n = 0;

    /* renamed from: o, reason: collision with root package name */
    public int f15626o = 0;

    /* renamed from: p, reason: collision with root package name */
    public int f15627p = 0;

    public C0946f(C0947g c0947g, int i4, C0943c c0943c, C0943c c0943c2, C0943c c0943c3, C0943c c0943c4, int i5) {
        this.f15629r = c0947g;
        this.f15619h = 0;
        this.f15620i = 0;
        this.f15621j = 0;
        this.f15622k = 0;
        this.f15628q = 0;
        this.f15612a = i4;
        this.f15615d = c0943c;
        this.f15616e = c0943c2;
        this.f15617f = c0943c3;
        this.f15618g = c0943c4;
        this.f15619h = c0947g.f15661w0;
        this.f15620i = c0947g.f15657s0;
        this.f15621j = c0947g.f15662x0;
        this.f15622k = c0947g.f15658t0;
        this.f15628q = i5;
    }

    public final void a(C0944d c0944d) {
        int i4 = this.f15612a;
        C0947g c0947g = this.f15629r;
        if (i4 == 0) {
            int iU = c0947g.U(this.f15628q, c0944d);
            if (c0944d.f15580p0[0] == 3) {
                this.f15627p++;
                iU = 0;
            }
            this.f15623l = iU + (c0944d.f15562g0 != 8 ? c0947g.f15645P0 : 0) + this.f15623l;
            int iT = c0947g.T(this.f15628q, c0944d);
            if (this.f15613b == null || this.f15614c < iT) {
                this.f15613b = c0944d;
                this.f15614c = iT;
                this.f15624m = iT;
            }
        } else {
            int iU2 = c0947g.U(this.f15628q, c0944d);
            int iT2 = c0947g.T(this.f15628q, c0944d);
            if (c0944d.f15580p0[1] == 3) {
                this.f15627p++;
                iT2 = 0;
            }
            this.f15624m = iT2 + (c0944d.f15562g0 != 8 ? c0947g.f15646Q0 : 0) + this.f15624m;
            if (this.f15613b == null || this.f15614c < iU2) {
                this.f15613b = c0944d;
                this.f15614c = iU2;
                this.f15623l = iU2;
            }
        }
        this.f15626o++;
    }

    public final void b(int i4, boolean z4, boolean z5) {
        C0947g c0947g;
        int i5;
        int i6;
        int i7;
        C0944d c0944d;
        int i8;
        char c4;
        int i9;
        float f4;
        float f5;
        int i10;
        float f6;
        int i11;
        int i12 = this.f15626o;
        int i13 = 0;
        while (true) {
            c0947g = this.f15629r;
            if (i13 >= i12 || (i11 = this.f15625n + i13) >= c0947g.f15656b1) {
                break;
            }
            C0944d c0944d2 = c0947g.f15655a1[i11];
            if (c0944d2 != null) {
                c0944d2.E();
            }
            i13++;
        }
        if (i12 == 0 || this.f15613b == null) {
            return;
        }
        boolean z6 = z5 && i4 == 0;
        int i14 = -1;
        int i15 = -1;
        for (int i16 = 0; i16 < i12; i16++) {
            int i17 = this.f15625n + (z4 ? (i12 - 1) - i16 : i16);
            if (i17 >= c0947g.f15656b1) {
                break;
            }
            C0944d c0944d3 = c0947g.f15655a1[i17];
            if (c0944d3 != null && c0944d3.f15562g0 == 0) {
                if (i14 == -1) {
                    i14 = i16;
                }
                i15 = i16;
            }
        }
        if (this.f15612a != 0) {
            C0944d c0944d4 = this.f15613b;
            c0944d4.f15566i0 = c0947g.f15633D0;
            int i18 = this.f15619h;
            if (i4 > 0) {
                i18 += c0947g.f15645P0;
            }
            C0943c c0943c = c0944d4.f15532I;
            C0943c c0943c2 = c0944d4.f15534K;
            if (z4) {
                c0943c2.a(this.f15617f, i18);
                if (z5) {
                    c0943c.a(this.f15615d, this.f15621j);
                }
                if (i4 > 0) {
                    this.f15617f.f15518d.f15532I.a(c0943c2, 0);
                }
            } else {
                c0943c.a(this.f15615d, i18);
                if (z5) {
                    c0943c2.a(this.f15617f, this.f15621j);
                }
                if (i4 > 0) {
                    this.f15615d.f15518d.f15534K.a(c0943c, 0);
                }
            }
            C0944d c0944d5 = null;
            for (int i19 = 0; i19 < i12; i19++) {
                int i20 = this.f15625n + i19;
                if (i20 >= c0947g.f15656b1) {
                    return;
                }
                C0944d c0944d6 = c0947g.f15655a1[i20];
                if (c0944d6 != null) {
                    C0943c c0943c3 = c0944d6.f15533J;
                    if (i19 == 0) {
                        c0944d6.g(c0943c3, this.f15616e, this.f15620i);
                        int i21 = c0947g.f15634E0;
                        float f7 = c0947g.f15640K0;
                        if (this.f15625n == 0) {
                            i7 = c0947g.f15636G0;
                            i5 = i21;
                            i6 = -1;
                            if (i7 != -1) {
                                f7 = c0947g.f15642M0;
                            }
                            c0944d6.f15568j0 = i7;
                            c0944d6.f15558e0 = f7;
                        } else {
                            i5 = i21;
                            i6 = -1;
                        }
                        if (!z5 || (i7 = c0947g.f15638I0) == i6) {
                            i7 = i5;
                        } else {
                            f7 = c0947g.f15644O0;
                        }
                        c0944d6.f15568j0 = i7;
                        c0944d6.f15558e0 = f7;
                    }
                    if (i19 == i12 - 1) {
                        c0944d6.g(c0944d6.f15535L, this.f15618g, this.f15622k);
                    }
                    if (c0944d5 != null) {
                        int i22 = c0947g.f15646Q0;
                        C0943c c0943c4 = c0944d5.f15535L;
                        c0943c3.a(c0943c4, i22);
                        if (i19 == i14) {
                            int i23 = this.f15620i;
                            if (c0943c3.h()) {
                                c0943c3.f15522h = i23;
                            }
                        }
                        c0943c4.a(c0943c3, 0);
                        if (i19 == i15 + 1) {
                            int i24 = this.f15622k;
                            if (c0943c4.h()) {
                                c0943c4.f15522h = i24;
                            }
                        }
                    }
                    if (c0944d6 != c0944d4) {
                        C0943c c0943c5 = c0944d6.f15534K;
                        C0943c c0943c6 = c0944d6.f15532I;
                        if (z4) {
                            int i25 = c0947g.R0;
                            if (i25 == 0) {
                                c0943c5.a(c0943c2, 0);
                            } else if (i25 == 1) {
                                c0943c6.a(c0943c, 0);
                            } else if (i25 == 2) {
                                c0943c6.a(c0943c, 0);
                                c0943c5.a(c0943c2, 0);
                            }
                            c0944d5 = c0944d6;
                        } else {
                            int i26 = c0947g.R0;
                            if (i26 == 0) {
                                c0943c6.a(c0943c, 0);
                            } else if (i26 == 1) {
                                c0943c5.a(c0943c2, 0);
                            } else if (i26 == 2) {
                                if (z6) {
                                    c0943c6.a(this.f15615d, this.f15619h);
                                    c0943c5.a(this.f15617f, this.f15621j);
                                } else {
                                    c0943c6.a(c0943c, 0);
                                    c0943c5.a(c0943c2, 0);
                                }
                            }
                            c0944d5 = c0944d6;
                        }
                    } else {
                        c0944d5 = c0944d6;
                    }
                }
            }
            return;
        }
        C0944d c0944d7 = this.f15613b;
        c0944d7.f15568j0 = c0947g.f15634E0;
        int i27 = this.f15620i;
        if (i4 > 0) {
            i27 += c0947g.f15646Q0;
        }
        C0943c c0943c7 = this.f15616e;
        C0943c c0943c8 = c0944d7.f15533J;
        c0943c8.a(c0943c7, i27);
        C0943c c0943c9 = c0944d7.f15535L;
        if (z5) {
            c0943c9.a(this.f15618g, this.f15622k);
        }
        if (i4 > 0) {
            this.f15616e.f15518d.f15535L.a(c0943c8, 0);
        }
        if (c0947g.f15647S0 != 3 || c0944d7.f15528E) {
            c0944d = c0944d7;
        } else {
            for (int i28 = 0; i28 < i12; i28++) {
                int i29 = this.f15625n + (z4 ? (i12 - 1) - i28 : i28);
                if (i29 >= c0947g.f15656b1) {
                    break;
                }
                c0944d = c0947g.f15655a1[i29];
                if (c0944d.f15528E) {
                    break;
                }
            }
            c0944d = c0944d7;
        }
        int i30 = 0;
        C0944d c0944d8 = null;
        while (i30 < i12) {
            int i31 = z4 ? (i12 - 1) - i30 : i30;
            int i32 = this.f15625n + i31;
            if (i32 >= c0947g.f15656b1) {
                return;
            }
            C0944d c0944d9 = c0947g.f15655a1[i32];
            if (c0944d9 == null) {
                i8 = i12;
                c4 = 3;
            } else {
                C0943c c0943c10 = c0944d9.f15532I;
                if (i30 == 0) {
                    c0944d9.g(c0943c10, this.f15615d, this.f15619h);
                }
                if (i31 == 0) {
                    int i33 = c0947g.f15633D0;
                    if (z4) {
                        i9 = i33;
                        f4 = 1.0f - c0947g.f15639J0;
                    } else {
                        i9 = i33;
                        f4 = c0947g.f15639J0;
                    }
                    if (this.f15625n == 0) {
                        int i34 = c0947g.f15635F0;
                        f5 = f4;
                        if (i34 != -1) {
                            f6 = z4 ? 1.0f - c0947g.f15641L0 : c0947g.f15641L0;
                            i10 = i34;
                        }
                        c0944d9.f15566i0 = i10;
                        c0944d9.f15556d0 = f6;
                    } else {
                        f5 = f4;
                    }
                    if (!z5 || (i10 = c0947g.f15637H0) == -1) {
                        i10 = i9;
                        f6 = f5;
                    } else {
                        f6 = z4 ? 1.0f - c0947g.f15643N0 : c0947g.f15643N0;
                    }
                    c0944d9.f15566i0 = i10;
                    c0944d9.f15556d0 = f6;
                }
                if (i30 == i12 - 1) {
                    i8 = i12;
                    c0944d9.g(c0944d9.f15534K, this.f15617f, this.f15621j);
                } else {
                    i8 = i12;
                }
                if (c0944d8 != null) {
                    int i35 = c0947g.f15645P0;
                    C0943c c0943c11 = c0944d8.f15534K;
                    c0943c10.a(c0943c11, i35);
                    if (i30 == i14) {
                        int i36 = this.f15619h;
                        if (c0943c10.h()) {
                            c0943c10.f15522h = i36;
                        }
                    }
                    c0943c11.a(c0943c10, 0);
                    if (i30 == i15 + 1) {
                        int i37 = this.f15621j;
                        if (c0943c11.h()) {
                            c0943c11.f15522h = i37;
                        }
                    }
                }
                if (c0944d9 != c0944d7) {
                    int i38 = c0947g.f15647S0;
                    c4 = 3;
                    if (i38 == 3 && c0944d.f15528E && c0944d9 != c0944d && c0944d9.f15528E) {
                        c0944d9.f15536M.a(c0944d.f15536M, 0);
                    } else {
                        C0943c c0943c12 = c0944d9.f15533J;
                        if (i38 != 0) {
                            C0943c c0943c13 = c0944d9.f15535L;
                            if (i38 == 1) {
                                c0943c13.a(c0943c9, 0);
                            } else if (z6) {
                                c0943c12.a(this.f15616e, this.f15620i);
                                c0943c13.a(this.f15618g, this.f15622k);
                            } else {
                                c0943c12.a(c0943c8, 0);
                                c0943c13.a(c0943c9, 0);
                            }
                        } else {
                            c0943c12.a(c0943c8, 0);
                        }
                    }
                } else {
                    c4 = 3;
                }
                c0944d8 = c0944d9;
            }
            i30++;
            i12 = i8;
        }
    }

    public final int c() {
        return this.f15612a == 1 ? this.f15624m - this.f15629r.f15646Q0 : this.f15624m;
    }

    public final int d() {
        return this.f15612a == 0 ? this.f15623l - this.f15629r.f15645P0 : this.f15623l;
    }

    public final void e(int i4) {
        C0947g c0947g;
        int i5;
        int i6 = this.f15627p;
        if (i6 == 0) {
            return;
        }
        int i7 = this.f15626o;
        int i8 = i4 / i6;
        int i9 = 0;
        while (true) {
            c0947g = this.f15629r;
            if (i9 >= i7 || (i5 = this.f15625n + i9) >= c0947g.f15656b1) {
                break;
            }
            C0944d c0944d = c0947g.f15655a1[i5];
            if (this.f15612a == 0) {
                if (c0944d != null) {
                    int[] iArr = c0944d.f15580p0;
                    if (iArr[0] == 3 && c0944d.f15582r == 0) {
                        c0947g.V(c0944d, 1, i8, iArr[1], c0944d.l());
                    }
                }
            } else if (c0944d != null) {
                int[] iArr2 = c0944d.f15580p0;
                if (iArr2[1] == 3 && c0944d.f15583s == 0) {
                    c0947g.V(c0944d, iArr2[0], c0944d.r(), 1, i8);
                }
            }
            i9++;
        }
        this.f15623l = 0;
        this.f15624m = 0;
        this.f15613b = null;
        this.f15614c = 0;
        int i10 = this.f15626o;
        for (int i11 = 0; i11 < i10; i11++) {
            int i12 = this.f15625n + i11;
            if (i12 >= c0947g.f15656b1) {
                return;
            }
            C0944d c0944d2 = c0947g.f15655a1[i12];
            if (this.f15612a == 0) {
                int iR = c0944d2.r();
                int i13 = c0947g.f15645P0;
                if (c0944d2.f15562g0 == 8) {
                    i13 = 0;
                }
                this.f15623l = iR + i13 + this.f15623l;
                int iT = c0947g.T(this.f15628q, c0944d2);
                if (this.f15613b == null || this.f15614c < iT) {
                    this.f15613b = c0944d2;
                    this.f15614c = iT;
                    this.f15624m = iT;
                }
            } else {
                int iU = c0947g.U(this.f15628q, c0944d2);
                int iT2 = c0947g.T(this.f15628q, c0944d2);
                int i14 = c0947g.f15646Q0;
                if (c0944d2.f15562g0 == 8) {
                    i14 = 0;
                }
                this.f15624m = iT2 + i14 + this.f15624m;
                if (this.f15613b == null || this.f15614c < iU) {
                    this.f15613b = c0944d2;
                    this.f15614c = iU;
                    this.f15623l = iU;
                }
            }
        }
    }

    public final void f(int i4, C0943c c0943c, C0943c c0943c2, C0943c c0943c3, C0943c c0943c4, int i5, int i6, int i7, int i8, int i9) {
        this.f15612a = i4;
        this.f15615d = c0943c;
        this.f15616e = c0943c2;
        this.f15617f = c0943c3;
        this.f15618g = c0943c4;
        this.f15619h = i5;
        this.f15620i = i6;
        this.f15621j = i7;
        this.f15622k = i8;
        this.f15628q = i9;
    }
}
