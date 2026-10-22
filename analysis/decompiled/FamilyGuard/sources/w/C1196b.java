package w;

import java.util.ArrayList;
import v.d;
import v.e;

/* renamed from: w.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1196b {

    /* renamed from: a, reason: collision with root package name */
    private final ArrayList<v.e> f23389a = new ArrayList<>();

    /* renamed from: b, reason: collision with root package name */
    private a f23390b = new a();

    /* renamed from: c, reason: collision with root package name */
    private v.f f23391c;

    /* renamed from: w.b$a */
    public static class a {

        /* renamed from: k, reason: collision with root package name */
        public static int f23392k = 0;

        /* renamed from: l, reason: collision with root package name */
        public static int f23393l = 1;

        /* renamed from: m, reason: collision with root package name */
        public static int f23394m = 2;

        /* renamed from: a, reason: collision with root package name */
        public e.b f23395a;

        /* renamed from: b, reason: collision with root package name */
        public e.b f23396b;

        /* renamed from: c, reason: collision with root package name */
        public int f23397c;

        /* renamed from: d, reason: collision with root package name */
        public int f23398d;

        /* renamed from: e, reason: collision with root package name */
        public int f23399e;

        /* renamed from: f, reason: collision with root package name */
        public int f23400f;

        /* renamed from: g, reason: collision with root package name */
        public int f23401g;

        /* renamed from: h, reason: collision with root package name */
        public boolean f23402h;

        /* renamed from: i, reason: collision with root package name */
        public boolean f23403i;

        /* renamed from: j, reason: collision with root package name */
        public int f23404j;
    }

    /* renamed from: w.b$b, reason: collision with other inner class name */
    public interface InterfaceC0254b {
        void a();

        void b(v.e eVar, a aVar);
    }

    public C1196b(v.f fVar) {
        this.f23391c = fVar;
    }

    private boolean a(InterfaceC0254b interfaceC0254b, v.e eVar, int i5) {
        this.f23390b.f23395a = eVar.A();
        this.f23390b.f23396b = eVar.T();
        this.f23390b.f23397c = eVar.W();
        this.f23390b.f23398d = eVar.x();
        a aVar = this.f23390b;
        aVar.f23403i = false;
        aVar.f23404j = i5;
        e.b bVar = aVar.f23395a;
        e.b bVar2 = e.b.MATCH_CONSTRAINT;
        boolean z5 = bVar == bVar2;
        boolean z6 = aVar.f23396b == bVar2;
        boolean z7 = z5 && eVar.f23063d0 > 0.0f;
        boolean z8 = z6 && eVar.f23063d0 > 0.0f;
        if (z7 && eVar.f23104y[0] == 4) {
            aVar.f23395a = e.b.FIXED;
        }
        if (z8 && eVar.f23104y[1] == 4) {
            aVar.f23396b = e.b.FIXED;
        }
        interfaceC0254b.b(eVar, aVar);
        eVar.k1(this.f23390b.f23399e);
        eVar.L0(this.f23390b.f23400f);
        eVar.K0(this.f23390b.f23402h);
        eVar.A0(this.f23390b.f23401g);
        a aVar2 = this.f23390b;
        aVar2.f23404j = a.f23392k;
        return aVar2.f23403i;
    }

    /* JADX WARN: Removed duplicated region for block: B:56:0x0097 A[PHI: r10
      0x0097: PHI (r10v2 boolean) = (r10v1 boolean), (r10v1 boolean), (r10v1 boolean), (r10v4 boolean), (r10v4 boolean) binds: [B:32:0x0061, B:34:0x0067, B:36:0x006b, B:54:0x0094, B:52:0x008d] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00a0 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void b(v.f r13) {
        /*
            r12 = this;
            java.util.ArrayList<v.e> r0 = r13.f23213L0
            int r0 = r0.size()
            r1 = 64
            boolean r1 = r13.T1(r1)
            w.b$b r2 = r13.I1()
            r3 = 0
            r4 = r3
        L12:
            if (r4 >= r0) goto La4
            java.util.ArrayList<v.e> r5 = r13.f23213L0
            java.lang.Object r5 = r5.get(r4)
            v.e r5 = (v.e) r5
            boolean r6 = r5 instanceof v.h
            if (r6 == 0) goto L22
            goto La0
        L22:
            boolean r6 = r5 instanceof v.C1177a
            if (r6 == 0) goto L28
            goto La0
        L28:
            boolean r6 = r5.l0()
            if (r6 == 0) goto L30
            goto La0
        L30:
            if (r1 == 0) goto L47
            w.l r6 = r5.f23064e
            if (r6 == 0) goto L47
            w.n r7 = r5.f23066f
            if (r7 == 0) goto L47
            w.g r6 = r6.f23473e
            boolean r6 = r6.f23425j
            if (r6 == 0) goto L47
            w.g r6 = r7.f23473e
            boolean r6 = r6.f23425j
            if (r6 == 0) goto L47
            goto La0
        L47:
            v.e$b r6 = r5.u(r3)
            r7 = 1
            v.e$b r8 = r5.u(r7)
            v.e$b r9 = v.e.b.MATCH_CONSTRAINT
            if (r6 != r9) goto L60
            int r10 = r5.f23100w
            if (r10 == r7) goto L60
            if (r8 != r9) goto L60
            int r10 = r5.f23102x
            if (r10 == r7) goto L60
            r10 = r7
            goto L61
        L60:
            r10 = r3
        L61:
            if (r10 != 0) goto L97
            boolean r11 = r13.T1(r7)
            if (r11 == 0) goto L97
            boolean r11 = r5 instanceof v.l
            if (r11 != 0) goto L97
            if (r6 != r9) goto L7c
            int r11 = r5.f23100w
            if (r11 != 0) goto L7c
            if (r8 == r9) goto L7c
            boolean r11 = r5.i0()
            if (r11 != 0) goto L7c
            r10 = r7
        L7c:
            if (r8 != r9) goto L8b
            int r11 = r5.f23102x
            if (r11 != 0) goto L8b
            if (r6 == r9) goto L8b
            boolean r11 = r5.i0()
            if (r11 != 0) goto L8b
            r10 = r7
        L8b:
            if (r6 == r9) goto L8f
            if (r8 != r9) goto L97
        L8f:
            float r6 = r5.f23063d0
            r8 = 0
            int r6 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r6 <= 0) goto L97
            goto L98
        L97:
            r7 = r10
        L98:
            if (r7 == 0) goto L9b
            goto La0
        L9b:
            int r6 = w.C1196b.a.f23392k
            r12.a(r2, r5, r6)
        La0:
            int r4 = r4 + 1
            goto L12
        La4:
            r2.a()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: w.C1196b.b(v.f):void");
    }

    private void c(v.f fVar, String str, int i5, int i6, int i7) {
        int I5 = fVar.I();
        int iH = fVar.H();
        fVar.a1(0);
        fVar.Z0(0);
        fVar.k1(i6);
        fVar.L0(i7);
        fVar.a1(I5);
        fVar.Z0(iH);
        this.f23391c.X1(i5);
        this.f23391c.s1();
    }

    public long d(v.f fVar, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13) {
        boolean zH1;
        int i14;
        int i15;
        int i16;
        v.f fVar2;
        long j5;
        int i17;
        int i18;
        boolean z5;
        C1196b c1196b = this;
        InterfaceC0254b interfaceC0254bI1 = fVar.I1();
        int size = fVar.f23213L0.size();
        int iW = fVar.W();
        int iX = fVar.x();
        boolean zB = v.k.b(i5, 128);
        boolean z6 = zB || v.k.b(i5, 64);
        if (z6) {
            for (int i19 = 0; i19 < size; i19++) {
                v.e eVar = fVar.f23213L0.get(i19);
                e.b bVarA = eVar.A();
                e.b bVar = e.b.MATCH_CONSTRAINT;
                boolean z7 = (bVarA == bVar) && (eVar.T() == bVar) && eVar.v() > 0.0f;
                if ((eVar.i0() && z7) || ((eVar.k0() && z7) || (eVar instanceof v.l) || eVar.i0() || eVar.k0())) {
                    z6 = false;
                    break;
                }
            }
        }
        if (z6) {
            boolean z8 = s.d.f20152r;
        }
        boolean z9 = z6 & ((i8 == 1073741824 && i10 == 1073741824) || zB);
        int i20 = 2;
        if (z9) {
            int iMin = Math.min(fVar.G(), i9);
            int iMin2 = Math.min(fVar.F(), i11);
            if (i8 == 1073741824 && fVar.W() != iMin) {
                fVar.k1(iMin);
                fVar.M1();
            }
            if (i10 == 1073741824 && fVar.x() != iMin2) {
                fVar.L0(iMin2);
                fVar.M1();
            }
            if (i8 == 1073741824 && i10 == 1073741824) {
                zH1 = fVar.F1(zB);
                i14 = 2;
            } else {
                boolean zG1 = fVar.G1(zB);
                if (i8 == 1073741824) {
                    zG1 &= fVar.H1(zB, 0);
                    i14 = 1;
                } else {
                    i14 = 0;
                }
                if (i10 == 1073741824) {
                    zH1 = fVar.H1(zB, 1) & zG1;
                    i14++;
                } else {
                    zH1 = zG1;
                }
            }
            if (zH1) {
                fVar.p1(i8 == 1073741824, i10 == 1073741824);
            }
        } else {
            zH1 = false;
            i14 = 0;
        }
        long j6 = 0;
        if (zH1 && i14 == 2) {
            return 0L;
        }
        int iJ1 = fVar.J1();
        if (size > 0) {
            b(fVar);
        }
        e(fVar);
        int size2 = c1196b.f23389a.size();
        if (size > 0) {
            c1196b.c(fVar, "First pass", 0, iW, iX);
            i15 = iW;
            i16 = iX;
        } else {
            i15 = iW;
            i16 = iX;
        }
        if (size2 > 0) {
            e.b bVarA2 = fVar.A();
            e.b bVar2 = e.b.WRAP_CONTENT;
            boolean z10 = bVarA2 == bVar2;
            boolean z11 = fVar.T() == bVar2;
            int iMax = Math.max(fVar.W(), c1196b.f23391c.I());
            int iMax2 = Math.max(fVar.x(), c1196b.f23391c.H());
            int i21 = 0;
            boolean zF1 = false;
            while (i21 < size2) {
                long j7 = j6;
                v.e eVar2 = c1196b.f23389a.get(i21);
                if (eVar2 instanceof v.l) {
                    int iW2 = eVar2.W();
                    int iX2 = eVar2.x();
                    boolean zA = zF1 | c1196b.a(interfaceC0254bI1, eVar2, a.f23393l);
                    i18 = i15;
                    int iW3 = eVar2.W();
                    z5 = z9;
                    int iX3 = eVar2.x();
                    if (iW3 != iW2) {
                        eVar2.k1(iW3);
                        if (z10 && eVar2.M() > iMax) {
                            iMax = Math.max(iMax, eVar2.M() + eVar2.o(d.b.RIGHT).f());
                        }
                        zA = true;
                    }
                    if (iX3 != iX2) {
                        eVar2.L0(iX3);
                        if (z11 && eVar2.r() > iMax2) {
                            iMax2 = Math.max(iMax2, eVar2.r() + eVar2.o(d.b.BOTTOM).f());
                        }
                        zA = true;
                    }
                    zF1 = zA | ((v.l) eVar2).F1();
                } else {
                    i18 = i15;
                    z5 = z9;
                }
                i21++;
                i15 = i18;
                j6 = j7;
                z9 = z5;
                i20 = 2;
            }
            int i22 = i15;
            boolean z12 = z9;
            j5 = j6;
            int i23 = i20;
            int i24 = 0;
            while (i24 < i23) {
                int i25 = 0;
                while (i25 < size2) {
                    v.e eVar3 = c1196b.f23389a.get(i25);
                    if (((eVar3 instanceof v.i) && !(eVar3 instanceof v.l)) || (eVar3 instanceof v.h) || eVar3.V() == 8 || ((z12 && eVar3.f23064e.f23473e.f23425j && eVar3.f23066f.f23473e.f23425j) || (eVar3 instanceof v.l))) {
                        i17 = i24;
                    } else {
                        int iW4 = eVar3.W();
                        int iX4 = eVar3.x();
                        int iP = eVar3.p();
                        int i26 = a.f23393l;
                        if (i24 == 1) {
                            i26 = a.f23394m;
                        }
                        boolean zA2 = zF1 | c1196b.a(interfaceC0254bI1, eVar3, i26);
                        int iW5 = eVar3.W();
                        i17 = i24;
                        int iX5 = eVar3.x();
                        if (iW5 != iW4) {
                            eVar3.k1(iW5);
                            if (z10 && eVar3.M() > iMax) {
                                iMax = Math.max(iMax, eVar3.M() + eVar3.o(d.b.RIGHT).f());
                            }
                            zA2 = true;
                        }
                        if (iX5 != iX4) {
                            eVar3.L0(iX5);
                            if (z11 && eVar3.r() > iMax2) {
                                iMax2 = Math.max(iMax2, eVar3.r() + eVar3.o(d.b.BOTTOM).f());
                            }
                            zA2 = true;
                        }
                        zF1 = (!eVar3.Z() || iP == eVar3.p()) ? zA2 : true;
                    }
                    i25++;
                    c1196b = this;
                    i24 = i17;
                }
                int i27 = i24;
                if (!zF1) {
                    break;
                }
                i24 = i27 + 1;
                c(fVar, "intermediate pass", i24, i22, i16);
                i23 = 2;
                zF1 = false;
                c1196b = this;
            }
            fVar2 = fVar;
        } else {
            fVar2 = fVar;
            j5 = 0;
        }
        fVar2.W1(iJ1);
        return j5;
    }

    public void e(v.f fVar) {
        this.f23389a.clear();
        int size = fVar.f23213L0.size();
        for (int i5 = 0; i5 < size; i5++) {
            v.e eVar = fVar.f23213L0.get(i5);
            e.b bVarA = eVar.A();
            e.b bVar = e.b.MATCH_CONSTRAINT;
            if (bVarA == bVar || eVar.T() == bVar) {
                this.f23389a.add(eVar);
            }
        }
        fVar.M1();
    }
}
