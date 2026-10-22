package o;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public int f4260a;
    public c d;

    /* renamed from: e, reason: collision with root package name */
    public c f4263e;

    /* renamed from: f, reason: collision with root package name */
    public c f4264f;

    /* renamed from: g, reason: collision with root package name */
    public c f4265g;

    /* renamed from: h, reason: collision with root package name */
    public int f4266h;

    /* renamed from: i, reason: collision with root package name */
    public int f4267i;

    /* renamed from: j, reason: collision with root package name */
    public int f4268j;

    /* renamed from: k, reason: collision with root package name */
    public int f4269k;

    /* renamed from: q, reason: collision with root package name */
    public int f4275q;

    /* renamed from: r, reason: collision with root package name */
    public final /* synthetic */ g f4276r;

    /* renamed from: b, reason: collision with root package name */
    public d f4261b = null;

    /* renamed from: c, reason: collision with root package name */
    public int f4262c = 0;

    /* renamed from: l, reason: collision with root package name */
    public int f4270l = 0;

    /* renamed from: m, reason: collision with root package name */
    public int f4271m = 0;

    /* renamed from: n, reason: collision with root package name */
    public int f4272n = 0;

    /* renamed from: o, reason: collision with root package name */
    public int f4273o = 0;

    /* renamed from: p, reason: collision with root package name */
    public int f4274p = 0;

    public f(g gVar, int i8, c cVar, c cVar2, c cVar3, c cVar4, int i9) {
        this.f4276r = gVar;
        this.f4260a = i8;
        this.d = cVar;
        this.f4263e = cVar2;
        this.f4264f = cVar3;
        this.f4265g = cVar4;
        this.f4266h = gVar.f4282v0;
        this.f4267i = gVar.f4278r0;
        this.f4268j = gVar.f4283w0;
        this.f4269k = gVar.f4279s0;
        this.f4275q = i9;
    }

    public final void a(d dVar) {
        int i8 = this.f4260a;
        g gVar = this.f4276r;
        if (i8 == 0) {
            int iP = gVar.P(dVar, this.f4275q);
            if (dVar.f4239o0[0] == 3) {
                this.f4274p++;
                iP = 0;
            }
            this.f4270l = iP + (dVar.f4222f0 != 8 ? gVar.O0 : 0) + this.f4270l;
            int iO = gVar.O(dVar, this.f4275q);
            if (this.f4261b == null || this.f4262c < iO) {
                this.f4261b = dVar;
                this.f4262c = iO;
                this.f4271m = iO;
            }
        } else {
            int iP2 = gVar.P(dVar, this.f4275q);
            int iO2 = gVar.O(dVar, this.f4275q);
            if (dVar.f4239o0[1] == 3) {
                this.f4274p++;
                iO2 = 0;
            }
            this.f4271m = iO2 + (dVar.f4222f0 != 8 ? gVar.P0 : 0) + this.f4271m;
            if (this.f4261b == null || this.f4262c < iP2) {
                this.f4261b = dVar;
                this.f4262c = iP2;
                this.f4270l = iP2;
            }
        }
        this.f4273o++;
    }

    public final void b(int i8, boolean z, boolean z2) {
        g gVar;
        int i9;
        d dVar;
        char c3;
        int i10;
        int i11;
        int i12;
        int i13 = this.f4273o;
        int i14 = 0;
        while (true) {
            gVar = this.f4276r;
            if (i14 >= i13 || (i12 = this.f4272n + i14) >= gVar.f4277a1) {
                break;
            }
            d dVar2 = gVar.Z0[i12];
            if (dVar2 != null) {
                dVar2.A();
            }
            i14++;
        }
        if (i13 == 0 || this.f4261b == null) {
            return;
        }
        boolean z8 = z2 && i8 == 0;
        int i15 = -1;
        int i16 = -1;
        for (int i17 = 0; i17 < i13; i17++) {
            int i18 = this.f4272n + (z ? (i13 - 1) - i17 : i17);
            if (i18 >= gVar.f4277a1) {
                break;
            }
            if (gVar.Z0[i18].f4222f0 == 0) {
                if (i15 == -1) {
                    i15 = i17;
                }
                i16 = i17;
            }
        }
        if (this.f4260a != 0) {
            d dVar3 = this.f4261b;
            dVar3.f4226h0 = gVar.C0;
            c cVar = dVar3.H;
            c cVar2 = dVar3.J;
            int i19 = this.f4266h;
            if (i8 > 0) {
                i19 += gVar.O0;
            }
            if (z) {
                cVar2.a(this.f4264f, i19);
                if (z2) {
                    cVar.a(this.d, this.f4268j);
                }
                if (i8 > 0) {
                    this.f4264f.d.H.a(cVar2, 0);
                }
            } else {
                cVar.a(this.d, i19);
                if (z2) {
                    cVar2.a(this.f4264f, this.f4268j);
                }
                if (i8 > 0) {
                    this.d.d.J.a(cVar, 0);
                }
            }
            d dVar4 = null;
            int i20 = 0;
            while (i20 < i13) {
                int i21 = this.f4272n + i20;
                if (i21 >= gVar.f4277a1) {
                    return;
                }
                d dVar5 = gVar.Z0[i21];
                if (i20 == 0) {
                    dVar5.f(dVar5.I, this.f4263e, this.f4267i);
                    int i22 = gVar.D0;
                    float f3 = gVar.J0;
                    if (this.f4272n == 0) {
                        int i23 = gVar.F0;
                        i9 = -1;
                        if (i23 != -1) {
                            f3 = gVar.L0;
                        }
                        i22 = i23;
                        dVar5.f4228i0 = i22;
                        dVar5.f4218d0 = f3;
                    } else {
                        i9 = -1;
                    }
                    if (z2 && (i23 = gVar.H0) != i9) {
                        f3 = gVar.N0;
                        i22 = i23;
                    }
                    dVar5.f4228i0 = i22;
                    dVar5.f4218d0 = f3;
                }
                if (i20 == i13 - 1) {
                    dVar5.f(dVar5.K, this.f4265g, this.f4269k);
                }
                if (dVar4 != null) {
                    c cVar3 = dVar4.K;
                    c cVar4 = dVar5.I;
                    cVar4.a(cVar3, gVar.P0);
                    if (i20 == i15) {
                        int i24 = this.f4267i;
                        if (cVar4.h()) {
                            cVar4.f4210h = i24;
                        }
                    }
                    cVar3.a(cVar4, 0);
                    if (i20 == i16 + 1) {
                        int i25 = this.f4269k;
                        if (cVar3.h()) {
                            cVar3.f4210h = i25;
                        }
                    }
                }
                if (dVar5 != dVar3) {
                    if (z) {
                        int i26 = gVar.Q0;
                        if (i26 == 0) {
                            dVar5.J.a(cVar2, 0);
                        } else if (i26 == 1) {
                            dVar5.H.a(cVar, 0);
                        } else if (i26 == 2) {
                            dVar5.H.a(cVar, 0);
                            dVar5.J.a(cVar2, 0);
                        }
                    } else {
                        int i27 = gVar.Q0;
                        if (i27 == 0) {
                            dVar5.H.a(cVar, 0);
                        } else if (i27 == 1) {
                            dVar5.J.a(cVar2, 0);
                        } else if (i27 == 2) {
                            if (z8) {
                                dVar5.H.a(this.d, this.f4266h);
                                dVar5.J.a(this.f4264f, this.f4268j);
                            } else {
                                dVar5.H.a(cVar, 0);
                                dVar5.J.a(cVar2, 0);
                            }
                        }
                    }
                }
                i20++;
                dVar4 = dVar5;
            }
            return;
        }
        d dVar6 = this.f4261b;
        dVar6.f4228i0 = gVar.D0;
        c cVar5 = dVar6.K;
        c cVar6 = dVar6.I;
        int i28 = this.f4267i;
        if (i8 > 0) {
            i28 += gVar.P0;
        }
        cVar6.a(this.f4263e, i28);
        if (z2) {
            cVar5.a(this.f4265g, this.f4269k);
        }
        if (i8 > 0) {
            this.f4263e.d.K.a(cVar6, 0);
        }
        if (gVar.R0 != 3 || dVar6.D) {
            dVar = dVar6;
        } else {
            for (int i29 = 0; i29 < i13; i29++) {
                int i30 = this.f4272n + (z ? (i13 - 1) - i29 : i29);
                if (i30 >= gVar.f4277a1) {
                    break;
                }
                dVar = gVar.Z0[i30];
                if (dVar.D) {
                    break;
                }
            }
            dVar = dVar6;
        }
        int i31 = 0;
        d dVar7 = null;
        while (i31 < i13) {
            int i32 = z ? (i13 - 1) - i31 : i31;
            int i33 = this.f4272n + i32;
            if (i33 >= gVar.f4277a1) {
                return;
            }
            d dVar8 = gVar.Z0[i33];
            if (i31 == 0) {
                dVar8.f(dVar8.H, this.d, this.f4266h);
            }
            if (i32 == 0) {
                int i34 = gVar.C0;
                float f7 = z ? 1.0f - gVar.I0 : gVar.I0;
                if (this.f4272n == 0) {
                    int i35 = gVar.E0;
                    i10 = i34;
                    if (i35 != -1) {
                        f7 = z ? 1.0f - gVar.K0 : gVar.K0;
                        i11 = i35;
                    }
                    dVar8.f4226h0 = i11;
                    dVar8.f4217c0 = f7;
                } else {
                    i10 = i34;
                }
                if (!z2 || (i11 = gVar.G0) == -1) {
                    i11 = i10;
                } else {
                    f7 = z ? 1.0f - gVar.M0 : gVar.M0;
                }
                dVar8.f4226h0 = i11;
                dVar8.f4217c0 = f7;
            }
            if (i31 == i13 - 1) {
                dVar8.f(dVar8.J, this.f4264f, this.f4268j);
            }
            if (dVar7 != null) {
                c cVar7 = dVar7.J;
                c cVar8 = dVar8.H;
                cVar8.a(cVar7, gVar.O0);
                if (i31 == i15) {
                    int i36 = this.f4266h;
                    if (cVar8.h()) {
                        cVar8.f4210h = i36;
                    }
                }
                cVar7.a(cVar8, 0);
                if (i31 == i16 + 1) {
                    int i37 = this.f4268j;
                    if (cVar7.h()) {
                        cVar7.f4210h = i37;
                    }
                }
            }
            if (dVar8 != dVar6) {
                int i38 = gVar.R0;
                c3 = 3;
                if (i38 == 3 && dVar.D && dVar8 != dVar && dVar8.D) {
                    dVar8.L.a(dVar.L, 0);
                } else if (i38 == 0) {
                    dVar8.I.a(cVar6, 0);
                } else if (i38 == 1) {
                    dVar8.K.a(cVar5, 0);
                } else if (z8) {
                    dVar8.I.a(this.f4263e, this.f4267i);
                    dVar8.K.a(this.f4265g, this.f4269k);
                } else {
                    dVar8.I.a(cVar6, 0);
                    dVar8.K.a(cVar5, 0);
                }
            } else {
                c3 = 3;
            }
            i31++;
            dVar7 = dVar8;
        }
    }

    public final int c() {
        return this.f4260a == 1 ? this.f4271m - this.f4276r.P0 : this.f4271m;
    }

    public final int d() {
        return this.f4260a == 0 ? this.f4270l - this.f4276r.O0 : this.f4270l;
    }

    public final void e(int i8) {
        g gVar;
        int i9;
        int i10 = this.f4274p;
        if (i10 == 0) {
            return;
        }
        int i11 = this.f4273o;
        int i12 = i8 / i10;
        int i13 = 0;
        while (true) {
            gVar = this.f4276r;
            if (i13 >= i11 || (i9 = this.f4272n + i13) >= gVar.f4277a1) {
                break;
            }
            d dVar = gVar.Z0[i9];
            if (this.f4260a == 0) {
                if (dVar != null) {
                    int[] iArr = dVar.f4239o0;
                    if (iArr[0] == 3 && dVar.f4241q == 0) {
                        gVar.Q(1, i12, iArr[1], dVar.k(), dVar);
                    }
                }
            } else if (dVar != null) {
                int[] iArr2 = dVar.f4239o0;
                if (iArr2[1] == 3 && dVar.f4242r == 0) {
                    int i14 = i12;
                    gVar.Q(iArr2[0], dVar.n(), 1, i14, dVar);
                    i12 = i14;
                }
            }
            i13++;
        }
        this.f4270l = 0;
        this.f4271m = 0;
        this.f4261b = null;
        this.f4262c = 0;
        int i15 = this.f4273o;
        for (int i16 = 0; i16 < i15; i16++) {
            int i17 = this.f4272n + i16;
            if (i17 >= gVar.f4277a1) {
                return;
            }
            d dVar2 = gVar.Z0[i17];
            if (this.f4260a == 0) {
                int iN = dVar2.n();
                int i18 = gVar.O0;
                if (dVar2.f4222f0 == 8) {
                    i18 = 0;
                }
                this.f4270l = iN + i18 + this.f4270l;
                int iO = gVar.O(dVar2, this.f4275q);
                if (this.f4261b == null || this.f4262c < iO) {
                    this.f4261b = dVar2;
                    this.f4262c = iO;
                    this.f4271m = iO;
                }
            } else {
                int iP = gVar.P(dVar2, this.f4275q);
                int iO2 = gVar.O(dVar2, this.f4275q);
                int i19 = gVar.P0;
                if (dVar2.f4222f0 == 8) {
                    i19 = 0;
                }
                this.f4271m = iO2 + i19 + this.f4271m;
                if (this.f4261b == null || this.f4262c < iP) {
                    this.f4261b = dVar2;
                    this.f4262c = iP;
                    this.f4270l = iP;
                }
            }
        }
    }

    public final void f(int i8, c cVar, c cVar2, c cVar3, c cVar4, int i9, int i10, int i11, int i12, int i13) {
        this.f4260a = i8;
        this.d = cVar;
        this.f4263e = cVar2;
        this.f4264f = cVar3;
        this.f4265g = cVar4;
        this.f4266h = i9;
        this.f4267i = i10;
        this.f4268j = i11;
        this.f4269k = i12;
        this.f4275q = i13;
    }
}
