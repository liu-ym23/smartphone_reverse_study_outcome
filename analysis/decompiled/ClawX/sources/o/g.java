package o;

import java.util.ArrayList;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class g extends i {
    public p.b A0;
    public r.f B0;
    public int C0;
    public int D0;
    public int E0;
    public int F0;
    public int G0;
    public int H0;
    public float I0;
    public float J0;
    public float K0;
    public float L0;
    public float M0;
    public float N0;
    public int O0;
    public int P0;
    public int Q0;
    public int R0;
    public int S0;
    public int T0;
    public int U0;
    public ArrayList V0;
    public d[] W0;
    public d[] X0;
    public int[] Y0;
    public d[] Z0;

    /* renamed from: a1, reason: collision with root package name */
    public int f4277a1;

    /* renamed from: r0, reason: collision with root package name */
    public int f4278r0;

    /* renamed from: s0, reason: collision with root package name */
    public int f4279s0;

    /* renamed from: t0, reason: collision with root package name */
    public int f4280t0;

    /* renamed from: u0, reason: collision with root package name */
    public int f4281u0;

    /* renamed from: v0, reason: collision with root package name */
    public int f4282v0;

    /* renamed from: w0, reason: collision with root package name */
    public int f4283w0;

    /* renamed from: x0, reason: collision with root package name */
    public boolean f4284x0;

    /* renamed from: y0, reason: collision with root package name */
    public int f4285y0;

    /* renamed from: z0, reason: collision with root package name */
    public int f4286z0;

    @Override // o.i
    public final void N() {
        for (int i8 = 0; i8 < this.f4294q0; i8++) {
            d dVar = this.f4293p0[i8];
            if (dVar != null) {
                dVar.E = true;
            }
        }
    }

    public final int O(d dVar, int i8) {
        d dVar2;
        if (dVar != null) {
            int[] iArr = dVar.f4239o0;
            if (iArr[1] == 3) {
                int i9 = dVar.f4242r;
                if (i9 != 0) {
                    if (i9 == 2) {
                        int i10 = (int) (dVar.y * i8);
                        if (i10 != dVar.k()) {
                            dVar.f4223g = true;
                            Q(iArr[0], dVar.n(), 1, i10, dVar);
                        }
                        return i10;
                    }
                    dVar2 = dVar;
                    if (i9 == 1) {
                        return dVar2.k();
                    }
                    if (i9 == 3) {
                        return (int) ((dVar2.n() * dVar2.V) + 0.5f);
                    }
                }
            } else {
                dVar2 = dVar;
            }
            return dVar2.k();
        }
        return 0;
    }

    public final int P(d dVar, int i8) {
        d dVar2;
        if (dVar != null) {
            int[] iArr = dVar.f4239o0;
            if (iArr[0] == 3) {
                int i9 = dVar.f4241q;
                if (i9 != 0) {
                    if (i9 == 2) {
                        int i10 = (int) (dVar.f4246v * i8);
                        if (i10 != dVar.n()) {
                            dVar.f4223g = true;
                            Q(1, i10, iArr[1], dVar.k(), dVar);
                        }
                        return i10;
                    }
                    dVar2 = dVar;
                    if (i9 == 1) {
                        return dVar2.n();
                    }
                    if (i9 == 3) {
                        return (int) ((dVar2.k() * dVar2.V) + 0.5f);
                    }
                }
            } else {
                dVar2 = dVar;
            }
            return dVar2.n();
        }
        return 0;
    }

    public final void Q(int i8, int i9, int i10, int i11, d dVar) {
        r.f fVar;
        d dVar2;
        p.b bVar = this.A0;
        while (true) {
            fVar = this.B0;
            if (fVar != null || (dVar2 = this.S) == null) {
                break;
            } else {
                this.B0 = ((e) dVar2).f4253t0;
            }
        }
        bVar.f4592a = i8;
        bVar.f4593b = i10;
        bVar.f4594c = i9;
        bVar.d = i11;
        fVar.b(dVar, bVar);
        dVar.J(bVar.f4595e);
        dVar.G(bVar.f4596f);
        dVar.D = bVar.f4598h;
        dVar.D(bVar.f4597g);
    }

    @Override // o.d
    public final void b(m.c cVar, boolean z) {
        d dVar;
        float f3;
        int i8;
        ArrayList arrayList = this.V0;
        super.b(cVar, z);
        d dVar2 = this.S;
        boolean z2 = dVar2 != null && ((e) dVar2).f4254u0;
        int i9 = this.S0;
        if (i9 != 0) {
            if (i9 == 1) {
                int size = arrayList.size();
                int i10 = 0;
                while (i10 < size) {
                    ((f) arrayList.get(i10)).b(i10, z2, i10 == size + (-1));
                    i10++;
                }
            } else if (i9 == 2 && this.Y0 != null && this.X0 != null && this.W0 != null) {
                for (int i11 = 0; i11 < this.f4277a1; i11++) {
                    this.Z0[i11].A();
                }
                int[] iArr = this.Y0;
                int i12 = iArr[0];
                int i13 = iArr[1];
                float f7 = this.I0;
                d dVar3 = null;
                int i14 = 0;
                while (i14 < i12) {
                    if (z2) {
                        i8 = (i12 - i14) - 1;
                        f3 = 1.0f - this.I0;
                    } else {
                        f3 = f7;
                        i8 = i14;
                    }
                    d dVar4 = this.X0[i8];
                    if (dVar4 != null) {
                        c cVar2 = dVar4.H;
                        if (dVar4.f4222f0 != 8) {
                            if (i14 == 0) {
                                dVar4.f(cVar2, this.H, this.f4282v0);
                                dVar4.f4226h0 = this.C0;
                                dVar4.f4217c0 = f3;
                            }
                            if (i14 == i12 - 1) {
                                dVar4.f(dVar4.J, this.J, this.f4283w0);
                            }
                            if (i14 > 0 && dVar3 != null) {
                                c cVar3 = dVar3.J;
                                dVar4.f(cVar2, cVar3, this.O0);
                                dVar3.f(cVar3, cVar2, 0);
                            }
                            dVar3 = dVar4;
                        }
                    }
                    i14++;
                    f7 = f3;
                }
                for (int i15 = 0; i15 < i13; i15++) {
                    d dVar5 = this.W0[i15];
                    if (dVar5 != null) {
                        c cVar4 = dVar5.I;
                        if (dVar5.f4222f0 != 8) {
                            if (i15 == 0) {
                                dVar5.f(cVar4, this.I, this.f4278r0);
                                dVar5.f4228i0 = this.D0;
                                dVar5.f4218d0 = this.J0;
                            }
                            if (i15 == i13 - 1) {
                                dVar5.f(dVar5.K, this.K, this.f4279s0);
                            }
                            if (i15 > 0 && dVar3 != null) {
                                c cVar5 = dVar3.K;
                                dVar5.f(cVar4, cVar5, this.P0);
                                dVar3.f(cVar5, cVar4, 0);
                            }
                            dVar3 = dVar5;
                        }
                    }
                }
                for (int i16 = 0; i16 < i12; i16++) {
                    for (int i17 = 0; i17 < i13; i17++) {
                        int i18 = (i17 * i12) + i16;
                        if (this.U0 == 1) {
                            i18 = (i16 * i13) + i17;
                        }
                        d[] dVarArr = this.Z0;
                        if (i18 < dVarArr.length && (dVar = dVarArr[i18]) != null && dVar.f4222f0 != 8) {
                            d dVar6 = this.X0[i16];
                            d dVar7 = this.W0[i17];
                            if (dVar != dVar6) {
                                dVar.f(dVar.H, dVar6.H, 0);
                                dVar.f(dVar.J, dVar6.J, 0);
                            }
                            if (dVar != dVar7) {
                                dVar.f(dVar.I, dVar7.I, 0);
                                dVar.f(dVar.K, dVar7.K, 0);
                            }
                        }
                    }
                }
            }
        } else if (arrayList.size() > 0) {
            ((f) arrayList.get(0)).b(0, z2, true);
        }
        this.f4284x0 = false;
    }
}
