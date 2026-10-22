package b0;

import android.os.Trace;
import com.stepos.account.oauth.OAuthConstants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.RandomAccess;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public final class p {
    public int A;
    public boolean B;
    public final n C;
    public final ArrayList D;
    public boolean E;
    public o2 F;
    public p2 G;
    public s2 H;
    public boolean I;
    public t1 J;
    public final c0.b K;
    public a L;
    public c0.c M;
    public final m0.c N;
    public final g7.l O;
    public boolean P;
    public long Q;
    public w R;

    /* renamed from: a, reason: collision with root package name */
    public final i5.l f1271a;

    /* renamed from: b, reason: collision with root package name */
    public final u f1272b;

    /* renamed from: c, reason: collision with root package name */
    public final p2 f1273c;

    /* renamed from: d, reason: collision with root package name */
    public final k.d0 f1274d;

    /* renamed from: e, reason: collision with root package name */
    public final c0.a f1275e;

    /* renamed from: f, reason: collision with root package name */
    public final c0.a f1276f;

    /* renamed from: g, reason: collision with root package name */
    public final x f1277g;

    /* renamed from: i, reason: collision with root package name */
    public s1 f1279i;

    /* renamed from: j, reason: collision with root package name */
    public int f1280j;

    /* renamed from: k, reason: collision with root package name */
    public int f1281k;

    /* renamed from: l, reason: collision with root package name */
    public int f1282l;

    /* renamed from: n, reason: collision with root package name */
    public int[] f1284n;

    /* renamed from: o, reason: collision with root package name */
    public k.r f1285o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f1286p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f1287q;

    /* renamed from: u, reason: collision with root package name */
    public k.t f1291u;

    /* renamed from: v, reason: collision with root package name */
    public boolean f1292v;

    /* renamed from: x, reason: collision with root package name */
    public boolean f1294x;

    /* renamed from: z, reason: collision with root package name */
    public int f1296z;

    /* renamed from: h, reason: collision with root package name */
    public final ArrayList f1278h = new ArrayList();

    /* renamed from: m, reason: collision with root package name */
    public final r0 f1283m = new r0();

    /* renamed from: r, reason: collision with root package name */
    public final ArrayList f1288r = new ArrayList();

    /* renamed from: s, reason: collision with root package name */
    public final r0 f1289s = new r0();

    /* renamed from: t, reason: collision with root package name */
    public j0.h f1290t = j0.h.f5083i;

    /* renamed from: w, reason: collision with root package name */
    public final r0 f1293w = new r0();

    /* renamed from: y, reason: collision with root package name */
    public int f1295y = -1;

    public p(i5.l lVar, u uVar, p2 p2Var, k.d0 d0Var, c0.a aVar, c0.a aVar2, b1 b1Var, x xVar) {
        this.f1271a = lVar;
        this.f1272b = uVar;
        this.f1273c = p2Var;
        this.f1274d = d0Var;
        this.f1275e = aVar;
        this.f1276f = aVar2;
        this.f1277g = xVar;
        AtomicReference atomicReference = j2.f1205y;
        this.B = ((Boolean) atomicReference.get()).booleanValue();
        this.C = new n(0, this);
        this.D = new ArrayList();
        o2 o2VarF = p2Var.f();
        o2VarF.c();
        this.F = o2VarF;
        p2 p2Var2 = new p2();
        if (((Boolean) atomicReference.get()).booleanValue()) {
            p2Var2.f1316p = new k.t();
        }
        this.G = p2Var2;
        s2 s2VarH = p2Var2.h();
        s2VarH.e(true);
        this.H = s2VarH;
        this.K = new c0.b(this, aVar);
        o2 o2VarF2 = this.G.f();
        try {
            a aVarA = o2VarF2.a(0);
            o2VarF2.c();
            this.L = aVarA;
            this.M = new c0.c();
            this.N = new m0.c(this);
            g7.l lVar2 = ((j2) uVar).f1227v;
            g7.l lVarY = y();
            this.O = lVar2.Q(lVarY == null ? g7.m.f3866f : lVarY);
        } catch (Throwable th) {
            o2VarF2.c();
            throw th;
        }
    }

    public static final int K(p pVar, int i2, boolean z4, int i10) {
        c0.b bVar = pVar.K;
        o2 o2Var = pVar.F;
        int[] iArr = o2Var.f1258b;
        int[] iArr2 = o2Var.f1258b;
        int i11 = i2 * 5;
        int i12 = iArr[i11 + 1];
        if ((134217728 & i12) != 0) {
            int iH = o2Var.h(i2);
            Object objN = o2Var.n(i2, iArr2);
            if (iH == 206 && q7.k.a(objN, s.f1335e)) {
                o2Var.g(i2, 0);
                return o2Var.m(i2);
            }
            if (!o2Var.j(i2)) {
                return o2Var.m(i2);
            }
        } else if ((i12 & 67108864) != 0) {
            int i13 = iArr[i11 + 3] + i2;
            int iK = 0;
            for (int i14 = i2 + 1; i14 < i13; i14 += iArr2[(i14 * 5) + 3]) {
                boolean zJ = o2Var.j(i14);
                if (zJ) {
                    bVar.c();
                    Object objL = o2Var.l(i14);
                    bVar.c();
                    bVar.f1722h.add(objL);
                }
                iK += K(pVar, i14, zJ || z4, zJ ? 0 : i10 + iK);
                if (zJ) {
                    bVar.c();
                    bVar.a();
                }
            }
            if (!o2Var.j(i2)) {
                return iK;
            }
        } else if (!o2Var.j(i2)) {
            return o2Var.m(i2);
        }
        return 1;
    }

    public final void A(ArrayList arrayList) {
        c0.a aVar = this.f1276f;
        c0.b bVar = this.K;
        c0.a aVar2 = bVar.f1716b;
        try {
            bVar.f1716b = aVar;
            aVar.f1713a.U(c0.y.f1766d);
            if (arrayList.size() <= 0) {
                bVar.f1716b.f1713a.U(c0.m.f1750d);
                bVar.f1720f = 0;
            } else {
                c7.j jVar = (c7.j) arrayList.get(0);
                e1 e1Var = (e1) jVar.f1973f;
                e1Var.getClass();
                throw null;
            }
        } finally {
            bVar.f1716b = aVar2;
        }
    }

    public final void B(t1 t1Var, Object obj) {
        P(126665345, null, 0, null);
        C();
        c0(obj);
        long j2 = this.Q;
        try {
            this.Q = 126665345;
            if (this.P) {
                s2 s2Var = this.H;
                int i2 = s2Var.f1367v;
                int iQ = s2Var.q(i2);
                int[] iArr = s2Var.f1347b;
                int i10 = (iQ * 5) + 1;
                int i11 = iArr[i10];
                if ((i11 & 134217728) == 0) {
                    int i12 = (i11 & (-134217729)) | 134217728;
                    iArr[i10] = i12;
                    if ((67108864 & i12) == 0) {
                        s2Var.Q(s2Var.B(i2, iArr));
                    }
                }
            }
            boolean z4 = (this.P || q7.k.a(this.F.e(), t1Var)) ? false : true;
            if (z4) {
                H(t1Var);
            }
            P(202, s.f1333c, 0, t1Var);
            this.J = null;
            boolean z10 = this.f1292v;
            this.f1292v = z4;
            j0.i.c(this, new j0.d(316014703, true, new o(0, obj)));
            this.f1292v = z10;
        } finally {
        }
    }

    public final Object C() {
        boolean z4 = this.P;
        b1 b1Var = k.f1229a;
        if (!z4) {
            Object objK = this.F.k();
            if (!this.f1294x) {
                return objK;
            }
        } else if (this.f1287q) {
            s.c("A call to createNode(), emitNode() or useNode() expected");
            return b1Var;
        }
        return b1Var;
    }

    public final int D(int i2) {
        int iO = this.F.o(i2) + 1;
        int i10 = 0;
        while (iO < i2) {
            if (!this.F.i(iO)) {
                i10++;
            }
            iO += r2.a(iO, this.F.f1258b);
        }
        return i10;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0059 A[Catch: all -> 0x0024, TRY_LEAVE, TryCatch #0 {all -> 0x0024, blocks: (B:3:0x0005, B:6:0x0012, B:8:0x0020, B:12:0x0029, B:11:0x0026, B:15:0x0030, B:18:0x0038, B:21:0x0040, B:23:0x0048, B:25:0x004e, B:26:0x0052, B:27:0x0053, B:29:0x0059, B:22:0x0044), top: B:34:0x0005, inners: #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object E(b0.x r9, b0.x r10, java.lang.Integer r11, java.util.List r12, p7.a r13) {
        /*
            r8 = this;
            boolean r0 = r8.E
            int r1 = r8.f1280j
            r2 = 1
            r8.E = r2     // Catch: java.lang.Throwable -> L24
            r2 = 0
            r8.f1280j = r2     // Catch: java.lang.Throwable -> L24
            int r3 = r12.size()     // Catch: java.lang.Throwable -> L24
            r4 = r2
        Lf:
            r5 = 0
            if (r4 >= r3) goto L2c
            java.lang.Object r6 = r12.get(r4)     // Catch: java.lang.Throwable -> L24
            c7.j r6 = (c7.j) r6     // Catch: java.lang.Throwable -> L24
            java.lang.Object r7 = r6.f1973f     // Catch: java.lang.Throwable -> L24
            b0.z1 r7 = (b0.z1) r7     // Catch: java.lang.Throwable -> L24
            java.lang.Object r6 = r6.f1974g     // Catch: java.lang.Throwable -> L24
            if (r6 == 0) goto L26
            r8.W(r7, r6)     // Catch: java.lang.Throwable -> L24
            goto L29
        L24:
            r9 = move-exception
            goto L62
        L26:
            r8.W(r7, r5)     // Catch: java.lang.Throwable -> L24
        L29:
            int r4 = r4 + 1
            goto Lf
        L2c:
            if (r9 == 0) goto L59
            if (r11 == 0) goto L35
            int r11 = r11.intValue()     // Catch: java.lang.Throwable -> L24
            goto L36
        L35:
            r11 = -1
        L36:
            if (r10 == 0) goto L53
            boolean r12 = r10.equals(r9)     // Catch: java.lang.Throwable -> L24
            if (r12 != 0) goto L53
            if (r11 < 0) goto L53
            r9.f1408u = r10     // Catch: java.lang.Throwable -> L24
            r9.f1409v = r11     // Catch: java.lang.Throwable -> L24
            java.lang.Object r10 = r13.c()     // Catch: java.lang.Throwable -> L4d
            r9.f1408u = r5     // Catch: java.lang.Throwable -> L24
            r9.f1409v = r2     // Catch: java.lang.Throwable -> L24
            goto L57
        L4d:
            r10 = move-exception
            r9.f1408u = r5     // Catch: java.lang.Throwable -> L24
            r9.f1409v = r2     // Catch: java.lang.Throwable -> L24
            throw r10     // Catch: java.lang.Throwable -> L24
        L53:
            java.lang.Object r10 = r13.c()     // Catch: java.lang.Throwable -> L24
        L57:
            if (r10 != 0) goto L5d
        L59:
            java.lang.Object r10 = r13.c()     // Catch: java.lang.Throwable -> L24
        L5d:
            r8.E = r0
            r8.f1280j = r1
            return r10
        L62:
            r8.E = r0
            r8.f1280j = r1
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: b0.p.E(b0.x, b0.x, java.lang.Integer, java.util.List, p7.a):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x026f  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x0307  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x0310  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x031c  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0125  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void F() throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 856
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: b0.p.F():void");
    }

    public final void G() {
        int i2;
        o2 o2Var = this.F;
        int i10 = o2Var.f1263g;
        boolean zJ = o2Var.j(i10);
        c0.b bVar = this.K;
        if (zJ) {
            bVar.c();
            Object objL = this.F.l(i10);
            bVar.c();
            bVar.f1722h.add(objL);
        }
        K(this, i10, zJ, 0);
        bVar.c();
        if (zJ) {
            bVar.a();
        }
        bVar.d(false);
        p pVar = bVar.f1715a;
        r0 r0Var = bVar.f1718d;
        o2 o2Var2 = pVar.F;
        if (o2Var2.f1259c > 0 && r0Var.a(-2) != (i2 = o2Var2.f1265i)) {
            if (!bVar.f1717c && bVar.f1719e) {
                bVar.d(false);
                bVar.f1716b.f1713a.U(c0.p.f1753d);
                bVar.f1717c = true;
            }
            if (i2 > 0) {
                a aVarA = o2Var2.a(i2);
                r0Var.c(i2);
                bVar.d(false);
                c0.i0 i0Var = bVar.f1716b.f1713a;
                i0Var.U(c0.o.f1752d);
                a.a.j0(i0Var, 0, aVarA);
                bVar.f1717c = true;
            }
        }
        bVar.f1716b.f1713a.U(c0.w.f1764d);
        int i11 = bVar.f1720f;
        o2 o2Var3 = pVar.F;
        bVar.f1720f = o2Var3.f1258b[(o2Var3.f1263g * 5) + 3] + i11;
    }

    public final void H(t1 t1Var) {
        k.t tVar = this.f1291u;
        if (tVar == null) {
            tVar = new k.t();
            this.f1291u = tVar;
        }
        tVar.g(this.F.f1263g, t1Var);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x001a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void I(int r7, int r8, int r9) {
        /*
            r6 = this;
            b0.o2 r0 = r6.F
            if (r7 != r8) goto L5
            goto L1a
        L5:
            if (r7 == r9) goto L6b
            if (r8 != r9) goto Lb
            goto L6b
        Lb:
            int r1 = r0.o(r7)
            if (r1 != r8) goto L14
            r9 = r8
            goto L6b
        L14:
            int r1 = r0.o(r8)
            if (r1 != r7) goto L1c
        L1a:
            r9 = r7
            goto L6b
        L1c:
            int r1 = r0.o(r7)
            int r2 = r0.o(r8)
            if (r1 != r2) goto L2b
            int r9 = r0.o(r7)
            goto L6b
        L2b:
            r1 = 0
            r2 = r7
            r3 = r1
        L2e:
            if (r2 <= 0) goto L39
            if (r2 == r9) goto L39
            int r2 = r0.o(r2)
            int r3 = r3 + 1
            goto L2e
        L39:
            r2 = r8
            r4 = r1
        L3b:
            if (r2 <= 0) goto L46
            if (r2 == r9) goto L46
            int r2 = r0.o(r2)
            int r4 = r4 + 1
            goto L3b
        L46:
            int r9 = r3 - r4
            r5 = r7
            r2 = r1
        L4a:
            if (r2 >= r9) goto L53
            int r5 = r0.o(r5)
            int r2 = r2 + 1
            goto L4a
        L53:
            int r4 = r4 - r3
            r9 = r8
        L55:
            if (r1 >= r4) goto L5e
            int r9 = r0.o(r9)
            int r1 = r1 + 1
            goto L55
        L5e:
            r1 = r9
            r9 = r5
        L60:
            if (r9 == r1) goto L6b
            int r9 = r0.o(r9)
            int r1 = r0.o(r1)
            goto L60
        L6b:
            if (r7 <= 0) goto L7f
            if (r7 == r9) goto L7f
            boolean r1 = r0.j(r7)
            if (r1 == 0) goto L7a
            c0.b r1 = r6.K
            r1.a()
        L7a:
            int r7 = r0.o(r7)
            goto L6b
        L7f:
            r6.p(r8, r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: b0.p.I(int, int, int):void");
    }

    public final Object J() {
        boolean z4 = this.P;
        b1 b1Var = k.f1229a;
        if (!z4) {
            Object objK = this.F.k();
            if (!this.f1294x) {
                return objK instanceof l2 ? ((l2) objK).f1236a : objK;
            }
        } else if (this.f1287q) {
            s.c("A call to createNode(), emitNode() or useNode() expected");
            return b1Var;
        }
        return b1Var;
    }

    public final boolean L(int i2, boolean z4) {
        return ((i2 & 1) == 0 && (this.P || this.f1294x)) || z4 || !z();
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00e2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void M() throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 278
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: b0.p.M():void");
    }

    public final void N() {
        o2 o2Var = this.F;
        int i2 = o2Var.f1265i;
        this.f1281k = i2 >= 0 ? o2Var.f1258b[(i2 * 5) + 1] & 67108863 : 0;
        o2Var.r();
    }

    public final void O() {
        if (this.f1281k != 0) {
            s.c("No nodes can be emitted before calling skipAndEndGroup");
        }
        if (this.P) {
            return;
        }
        z1 z1VarW = w();
        if (z1VarW != null) {
            int i2 = z1VarW.f1442b;
            if ((i2 & 128) == 0) {
                z1VarW.f1442b = i2 | 16;
            }
        }
        if (this.f1288r.isEmpty()) {
            N();
        } else {
            F();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00c6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void P(int r27, java.lang.Object r28, int r29, b0.t1 r30) {
        /*
            Method dump skipped, instructions count: 939
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: b0.p.P(int, java.lang.Object, int, b0.t1):void");
    }

    public final void Q() {
        P(-127, null, 0, null);
    }

    public final void R(Object obj, boolean z4) {
        if (z4) {
            o2 o2Var = this.F;
            if (o2Var.f1267k <= 0) {
                if ((o2Var.f1258b[(o2Var.f1263g * 5) + 1] & 1073741824) == 0) {
                    u1.a("Expected a node group");
                }
                o2Var.s();
                return;
            }
            return;
        }
        if (obj != null && this.F.e() != obj) {
            c0.b bVar = this.K;
            bVar.getClass();
            bVar.d(false);
            c0.i0 i0Var = bVar.f1716b.f1713a;
            i0Var.U(c0.d0.f1732d);
            a.a.j0(i0Var, 0, obj);
        }
        this.F.s();
    }

    public final void S(int i2) {
        int i10;
        int i11;
        if (this.f1279i != null) {
            P(i2, null, 0, null);
            return;
        }
        if (this.f1287q) {
            s.c("A call to createNode(), emitNode() or useNode() expected");
        }
        this.Q = Long.rotateLeft(Long.rotateLeft(this.Q, 3) ^ i2, 3) ^ this.f1282l;
        this.f1282l++;
        o2 o2Var = this.F;
        boolean z4 = this.P;
        b1 b1Var = k.f1229a;
        if (z4) {
            o2Var.f1267k++;
            this.H.N(i2, b1Var, b1Var, false);
            u(false, null);
            return;
        }
        if (o2Var.f() == i2 && ((i11 = o2Var.f1263g) >= o2Var.f1264h || (o2Var.f1258b[(i11 * 5) + 1] & 536870912) == 0)) {
            o2Var.s();
            u(false, null);
            return;
        }
        if (o2Var.f1267k <= 0 && (i10 = o2Var.f1263g) != o2Var.f1264h) {
            int i12 = this.f1280j;
            G();
            this.K.e(i12, o2Var.q());
            s.a(this.f1288r, i10, o2Var.f1263g);
        }
        o2Var.f1267k++;
        this.P = true;
        this.J = null;
        if (this.H.f1368w) {
            s2 s2VarH = this.G.h();
            this.H = s2VarH;
            s2VarH.J();
            this.I = false;
            this.J = null;
        }
        s2 s2Var = this.H;
        s2Var.d();
        int i13 = s2Var.f1365t;
        s2Var.N(i2, b1Var, b1Var, false);
        this.L = s2Var.b(i13);
        u(false, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x006b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final b0.p T(int r6) {
        /*
            r5 = this;
            r5.S(r6)
            boolean r6 = r5.P
            java.util.ArrayList r0 = r5.D
            b0.x r1 = r5.f1277g
            if (r6 == 0) goto L21
            b0.z1 r6 = new b0.z1
            r6.<init>(r1)
            r0.add(r6)
            r5.c0(r6)
            int r0 = r5.A
            r6.f1445e = r0
            int r0 = r6.f1442b
            r0 = r0 & (-17)
            r6.f1442b = r0
            return r5
        L21:
            b0.o2 r6 = r5.F
            int r6 = r6.f1265i
            java.util.ArrayList r2 = r5.f1288r
            int r6 = b0.s.e(r6, r2)
            if (r6 < 0) goto L34
            java.lang.Object r6 = r2.remove(r6)
            b0.s0 r6 = (b0.s0) r6
            goto L35
        L34:
            r6 = 0
        L35:
            b0.o2 r2 = r5.F
            java.lang.Object r2 = r2.k()
            b0.b1 r3 = b0.k.f1229a
            boolean r3 = q7.k.a(r2, r3)
            if (r3 == 0) goto L4c
            b0.z1 r2 = new b0.z1
            r2.<init>(r1)
            r5.c0(r2)
            goto L53
        L4c:
            java.lang.String r1 = "null cannot be cast to non-null type androidx.compose.runtime.RecomposeScopeImpl"
            q7.k.c(r2, r1)
            b0.z1 r2 = (b0.z1) r2
        L53:
            r1 = 0
            r3 = 1
            if (r6 != 0) goto L6b
            int r6 = r2.f1442b
            r4 = r6 & 64
            if (r4 == 0) goto L5f
            r4 = r3
            goto L60
        L5f:
            r4 = r1
        L60:
            if (r4 == 0) goto L66
            r6 = r6 & (-65)
            r2.f1442b = r6
        L66:
            if (r4 == 0) goto L69
            goto L6b
        L69:
            r6 = r1
            goto L6c
        L6b:
            r6 = r3
        L6c:
            int r4 = r2.f1442b
            if (r6 == 0) goto L73
            r6 = r4 | 8
            goto L75
        L73:
            r6 = r4 & (-9)
        L75:
            r2.f1442b = r6
            r0.add(r2)
            int r6 = r5.A
            r2.f1445e = r6
            int r6 = r2.f1442b
            r0 = r6 & (-17)
            r2.f1442b = r0
            r0 = r6 & 256(0x100, float:3.59E-43)
            if (r0 == 0) goto Lac
            r6 = r6 & (-273(0xfffffffffffffeef, float:NaN))
            r6 = r6 | 512(0x200, float:7.17E-43)
            r2.f1442b = r6
            c0.b r6 = r5.K
            c0.a r6 = r6.f1716b
            c0.i0 r6 = r6.f1713a
            c0.b0 r0 = c0.b0.f1727d
            r6.U(r0)
            a.a.j0(r6, r1, r2)
            boolean r6 = r5.f1294x
            if (r6 != 0) goto Lac
            int r6 = r2.f1442b
            r0 = r6 & 128(0x80, float:1.8E-43)
            if (r0 == 0) goto Lac
            r5.f1294x = r3
            r6 = r6 | 1024(0x400, float:1.435E-42)
            r2.f1442b = r6
        Lac:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: b0.p.T(int):b0.p");
    }

    public final void U() {
        P(125, null, 2, null);
        this.f1287q = true;
    }

    public final void V() {
        this.f1282l = 0;
        this.F = this.f1273c.f();
        P(100, null, 0, null);
        j0.h hVarC = v.f1379a;
        this.f1293w.c(this.f1292v ? 1 : 0);
        this.f1292v = f(hVarC);
        this.J = null;
        if (!this.f1286p) {
            this.f1286p = false;
        }
        if (!this.B) {
            this.B = false;
        }
        if (this.B) {
            c3 c3Var = m0.d.f6125a;
            q7.k.c(c3Var, "null cannot be cast to non-null type androidx.compose.runtime.CompositionLocal<kotlin.Any?>");
            hVarC = hVarC.c(c3Var, new d3(y()));
        }
        this.f1290t = hVarC;
        Set set = (Set) b.o(hVarC, m0.f.f6127a);
        if (set != null) {
            w wVar = this.R;
            if (wVar == null) {
                wVar = new w(this.f1277g);
                this.R = wVar;
            }
            set.add(wVar);
        }
        P(Long.hashCode(1000), null, 0, null);
    }

    public final boolean W(z1 z1Var, Object obj) {
        a aVar = z1Var.f1443c;
        if (aVar == null) {
            return false;
        }
        int iA = this.F.f1257a.a(aVar);
        if (!this.E || iA < this.F.f1263g) {
            return false;
        }
        ArrayList arrayList = this.f1288r;
        int iE = s.e(iA, arrayList);
        if (iE < 0) {
            int i2 = -(iE + 1);
            if (!(obj instanceof i0)) {
                obj = null;
            }
            arrayList.add(i2, new s0(z1Var, iA, obj));
            return true;
        }
        s0 s0Var = (s0) arrayList.get(iE);
        if (!(obj instanceof i0)) {
            s0Var.f1339c = null;
            return true;
        }
        Object obj2 = s0Var.f1339c;
        if (obj2 == null) {
            s0Var.f1339c = obj;
            return true;
        }
        if (obj2 instanceof k.b0) {
            ((k.b0) obj2).a(obj);
            return true;
        }
        int i10 = k.h0.f5493a;
        k.b0 b0Var = new k.b0(2);
        b0Var.i(obj2);
        b0Var.i(obj);
        s0Var.f1339c = b0Var;
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0083  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void X(k.a0 r15) {
        /*
            r14 = this;
            java.util.ArrayList r14 = r14.f1288r
            int r0 = d7.s.t0(r14)
        L6:
            r1 = -1
            if (r1 >= r0) goto L2a
            java.lang.Object r1 = r14.get(r0)
            b0.s0 r1 = (b0.s0) r1
            b0.z1 r2 = r1.f1337a
            b0.a r2 = r2.f1443c
            if (r2 == 0) goto L24
            boolean r3 = r2.a()
            if (r3 == 0) goto L24
            int r3 = r1.f1338b
            int r2 = r2.f1096a
            if (r3 == r2) goto L27
            r1.f1338b = r2
            goto L27
        L24:
            r14.remove(r0)
        L27:
            int r0 = r0 + (-1)
            goto L6
        L2a:
            java.lang.Object[] r0 = r15.f5447b
            java.lang.Object[] r1 = r15.f5448c
            long[] r15 = r15.f5446a
            int r2 = r15.length
            int r2 = r2 + (-2)
            if (r2 < 0) goto L88
            r3 = 0
            r4 = r3
        L37:
            r5 = r15[r4]
            long r7 = ~r5
            r9 = 7
            long r7 = r7 << r9
            long r7 = r7 & r5
            r9 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r7 = r7 & r9
            int r7 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r7 == 0) goto L83
            int r7 = r4 - r2
            int r7 = ~r7
            int r7 = r7 >>> 31
            r8 = 8
            int r7 = 8 - r7
            r9 = r3
        L51:
            if (r9 >= r7) goto L81
            r10 = 255(0xff, double:1.26E-321)
            long r10 = r10 & r5
            r12 = 128(0x80, double:6.3E-322)
            int r10 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r10 >= 0) goto L7d
            int r10 = r4 << 3
            int r10 = r10 + r9
            r11 = r0[r10]
            r10 = r1[r10]
            java.lang.String r12 = "null cannot be cast to non-null type androidx.compose.runtime.RecomposeScopeImpl"
            q7.k.c(r11, r12)
            b0.z1 r11 = (b0.z1) r11
            b0.a r12 = r11.f1443c
            if (r12 == 0) goto L7d
            int r12 = r12.f1096a
            b0.b1 r13 = b0.b1.f1110j
            if (r10 != r13) goto L75
            r10 = 0
        L75:
            b0.s0 r13 = new b0.s0
            r13.<init>(r11, r12, r10)
            r14.add(r13)
        L7d:
            long r5 = r5 >> r8
            int r9 = r9 + 1
            goto L51
        L81:
            if (r7 != r8) goto L88
        L83:
            if (r4 == r2) goto L88
            int r4 = r4 + 1
            goto L37
        L88:
            b0.q r15 = b0.s.f1336f
            d7.w.C0(r14, r15)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: b0.p.X(k.a0):void");
    }

    public final void Y(int i2, int i10) {
        if (d0(i2) != i10) {
            if (i2 < 0) {
                k.r rVar = this.f1285o;
                if (rVar == null) {
                    rVar = new k.r();
                    this.f1285o = rVar;
                }
                rVar.f(i2, i10);
                return;
            }
            int[] iArr = this.f1284n;
            if (iArr == null) {
                int i11 = this.F.f1259c;
                int[] iArr2 = new int[i11];
                Arrays.fill(iArr2, 0, i11, -1);
                this.f1284n = iArr2;
                iArr = iArr2;
            }
            iArr[i2] = i10;
        }
    }

    public final void Z(int i2, int i10) {
        int iD0 = d0(i2);
        if (iD0 != i10) {
            int i11 = i10 - iD0;
            ArrayList arrayList = this.f1278h;
            int size = arrayList.size() - 1;
            while (i2 != -1) {
                int iD02 = d0(i2) + i11;
                Y(i2, iD02);
                int i12 = size;
                while (true) {
                    if (-1 < i12) {
                        s1 s1Var = (s1) arrayList.get(i12);
                        if (s1Var != null && s1Var.a(i2, iD02)) {
                            size = i12 - 1;
                            break;
                        }
                        i12--;
                    } else {
                        break;
                    }
                }
                if (i2 < 0) {
                    i2 = this.F.f1265i;
                } else if (this.F.j(i2)) {
                    return;
                } else {
                    i2 = this.F.o(i2);
                }
            }
        }
    }

    public final void a() {
        i();
        this.f1278h.clear();
        this.f1283m.f1328b = 0;
        this.f1289s.f1328b = 0;
        this.f1293w.f1328b = 0;
        this.f1291u = null;
        c0.c cVar = this.M;
        cVar.f1729b.Q();
        cVar.f1728a.Q();
        this.Q = 0;
        this.f1296z = 0;
        this.f1287q = false;
        this.P = false;
        this.f1294x = false;
        this.E = false;
        this.f1295y = -1;
        o2 o2Var = this.F;
        if (!o2Var.f1262f) {
            o2Var.c();
        }
        if (this.H.f1368w) {
            return;
        }
        v();
    }

    public final j0.h a0(t1 t1Var, j0.h hVar) {
        j0.h hVar2 = (j0.h) t1Var;
        hVar2.getClass();
        j0.g gVar = new j0.g(hVar2);
        gVar.putAll(hVar);
        j0.h hVarA = gVar.a();
        P(204, s.f1334d, 0, null);
        C();
        c0(hVarA);
        C();
        c0(hVar);
        q(false);
        return hVarA;
    }

    public final void b(Object obj, p7.n nVar) {
        if (this.P) {
            c0.i0 i0Var = this.M.f1728a;
            i0Var.U(c0.e0.f1734d);
            a.a.j0(i0Var, 0, obj);
            q7.k.c(nVar, "null cannot be cast to non-null type @[ExtensionFunctionType] kotlin.Function2<kotlin.Any?, kotlin.Any?, kotlin.Unit>");
            q7.z.c(2, nVar);
            a.a.j0(i0Var, 1, nVar);
            return;
        }
        c0.b bVar = this.K;
        bVar.b();
        c0.i0 i0Var2 = bVar.f1716b.f1713a;
        i0Var2.U(c0.e0.f1734d);
        q7.k.c(nVar, "null cannot be cast to non-null type @[ExtensionFunctionType] kotlin.Function2<kotlin.Any?, kotlin.Any?, kotlin.Unit>");
        q7.z.c(2, nVar);
        a.a.k0(i0Var2, 0, obj, 1, nVar);
    }

    public final void b0(Object obj) {
        int i2;
        o2 o2Var;
        int i10;
        s2 s2Var;
        if (obj instanceof k2) {
            k2 k2Var = (k2) obj;
            a aVarA = null;
            if (this.P) {
                s2 s2Var2 = this.H;
                int i11 = s2Var2.f1365t;
                if (i11 > s2Var2.f1367v + 1) {
                    int i12 = i11 - 1;
                    int iB = s2Var2.B(i12, s2Var2.f1347b);
                    while (true) {
                        i10 = i12;
                        i12 = iB;
                        s2Var = this.H;
                        if (i12 == s2Var.f1367v || i12 < 0) {
                            break;
                        } else {
                            iB = s2Var.B(i12, s2Var.f1347b);
                        }
                    }
                    aVarA = s2Var.b(i10);
                }
            } else {
                o2 o2Var2 = this.F;
                int i13 = o2Var2.f1263g;
                if (i13 > o2Var2.f1265i + 1) {
                    int i14 = i13 - 1;
                    int iO = o2Var2.o(i14);
                    while (true) {
                        i2 = i14;
                        i14 = iO;
                        o2Var = this.F;
                        if (i14 == o2Var.f1265i || i14 < 0) {
                            break;
                        } else {
                            iO = o2Var.o(i14);
                        }
                    }
                    aVarA = o2Var.a(i2);
                }
            }
            l2 l2Var = new l2(k2Var, aVarA);
            if (this.P) {
                c0.i0 i0Var = this.K.f1716b.f1713a;
                i0Var.U(c0.v.f1763d);
                a.a.j0(i0Var, 0, l2Var);
            }
            this.f1274d.add(obj);
            obj = l2Var;
        }
        c0(obj);
    }

    public final boolean c(float f10) {
        Object objC = C();
        if ((objC instanceof Float) && f10 == ((Number) objC).floatValue()) {
            return false;
        }
        c0(Float.valueOf(f10));
        return true;
    }

    public final void c0(Object obj) {
        if (this.P) {
            s2 s2Var = this.H;
            if (s2Var.f1359n <= 0 || s2Var.f1354i == s2Var.f1356k) {
                s2Var.C(obj);
                return;
            }
            k.t tVar = s2Var.f1364s;
            if (tVar == null) {
                tVar = new k.t();
            }
            s2Var.f1364s = tVar;
            int i2 = s2Var.f1367v;
            Object objB = tVar.b(i2);
            if (objB == null) {
                objB = new k.z();
                tVar.g(i2, objB);
            }
            ((k.z) objB).a(obj);
            return;
        }
        o2 o2Var = this.F;
        boolean z4 = o2Var.f1270n;
        c0.b bVar = this.K;
        if (!z4) {
            a aVarA = o2Var.a(o2Var.f1265i);
            c0.i0 i0Var = bVar.f1716b.f1713a;
            i0Var.U(c0.e.f1733d);
            a.a.k0(i0Var, 0, aVarA, 1, obj);
            return;
        }
        int iC = (o2Var.f1268l - r2.c(o2Var.f1265i, o2Var.f1258b)) - 1;
        if (bVar.f1715a.F.f1265i - bVar.f1720f >= 0) {
            bVar.d(true);
            c0.i0 i0Var2 = bVar.f1716b.f1713a;
            i0Var2.U(c0.q.f1757h);
            a.a.j0(i0Var2, 0, obj);
            i0Var2.f1743c[i0Var2.f1744d - i0Var2.f1741a[i0Var2.f1742b - 1].f1556b] = iC;
            return;
        }
        o2 o2Var2 = this.F;
        a aVarA2 = o2Var2.a(o2Var2.f1265i);
        c0.i0 i0Var3 = bVar.f1716b.f1713a;
        i0Var3.U(c0.q.f1756g);
        a.a.k0(i0Var3, 0, obj, 1, aVarA2);
        i0Var3.f1743c[i0Var3.f1744d - i0Var3.f1741a[i0Var3.f1742b - 1].f1556b] = iC;
    }

    public final boolean d(int i2) {
        Object objC = C();
        if ((objC instanceof Integer) && i2 == ((Number) objC).intValue()) {
            return false;
        }
        c0(Integer.valueOf(i2));
        return true;
    }

    public final int d0(int i2) {
        int i10;
        if (i2 >= 0) {
            int[] iArr = this.f1284n;
            return (iArr == null || (i10 = iArr[i2]) < 0) ? this.F.m(i2) : i10;
        }
        k.r rVar = this.f1285o;
        if (rVar == null || rVar.c(i2) < 0) {
            return 0;
        }
        int iC = rVar.c(i2);
        if (iC >= 0) {
            return rVar.f5525c[iC];
        }
        l.a.e("Cannot find value for key " + i2);
        throw null;
    }

    public final boolean e(long j2) {
        Object objC = C();
        if ((objC instanceof Long) && j2 == ((Number) objC).longValue()) {
            return false;
        }
        c0(Long.valueOf(j2));
        return true;
    }

    public final void e0() {
        if (!this.f1287q) {
            s.c("A call to createNode(), emitNode() or useNode() expected was not expected");
        }
        this.f1287q = false;
        if (this.P) {
            s.c("useNode() called while inserting");
        }
        o2 o2Var = this.F;
        Object objL = o2Var.l(o2Var.f1265i);
        c0.b bVar = this.K;
        bVar.c();
        bVar.f1722h.add(objL);
        if (this.f1294x && (objL instanceof i1.f0)) {
            bVar.b();
            bVar.f1716b.f1713a.U(c0.g0.f1738d);
        }
    }

    public final boolean f(Object obj) {
        if (q7.k.a(C(), obj)) {
            return false;
        }
        c0(obj);
        return true;
    }

    public final boolean g(boolean z4) {
        Object objC = C();
        if ((objC instanceof Boolean) && z4 == ((Boolean) objC).booleanValue()) {
            return false;
        }
        c0(Boolean.valueOf(z4));
        return true;
    }

    public final boolean h(Object obj) {
        if (C() == obj) {
            return false;
        }
        c0(obj);
        return true;
    }

    public final void i() {
        this.f1279i = null;
        this.f1280j = 0;
        this.f1281k = 0;
        this.Q = 0L;
        this.f1287q = false;
        c0.b bVar = this.K;
        bVar.f1717c = false;
        bVar.f1718d.f1328b = 0;
        bVar.f1720f = 0;
        bVar.f1719e = true;
        bVar.f1721g = 0;
        bVar.f1722h.clear();
        bVar.f1723i = -1;
        bVar.f1724j = -1;
        bVar.f1725k = -1;
        bVar.f1726l = 0;
        this.D.clear();
        this.f1284n = null;
        this.f1285o = null;
    }

    public final Object j(w1 w1Var) {
        return b.o(l(), w1Var);
    }

    public final void k(p7.a aVar) {
        if (!this.f1287q) {
            s.c("A call to createNode(), emitNode() or useNode() expected was not expected");
        }
        this.f1287q = false;
        if (!this.P) {
            s.c("createNode() can only be called when inserting");
        }
        r0 r0Var = this.f1283m;
        int i2 = r0Var.f1327a[r0Var.f1328b - 1];
        s2 s2Var = this.H;
        a aVarB = s2Var.b(s2Var.f1367v);
        this.f1281k++;
        c0.c cVar = this.M;
        c0.i0 i0Var = cVar.f1728a;
        i0Var.U(c0.q.f1754e);
        a.a.j0(i0Var, 0, aVar);
        i0Var.f1743c[i0Var.f1744d - i0Var.f1741a[i0Var.f1742b - 1].f1556b] = i2;
        a.a.j0(i0Var, 1, aVarB);
        c0.i0 i0Var2 = cVar.f1729b;
        i0Var2.U(c0.q.f1755f);
        i0Var2.f1743c[i0Var2.f1744d - i0Var2.f1741a[i0Var2.f1742b - 1].f1556b] = i2;
        a.a.j0(i0Var2, 0, aVarB);
    }

    public final t1 l() {
        t1 t1Var;
        t1 t1Var2 = this.J;
        if (t1Var2 != null) {
            return t1Var2;
        }
        int iO = this.F.f1265i;
        boolean z4 = this.P;
        i1 i1Var = s.f1333c;
        if (z4 && this.I) {
            int iB = this.H.f1367v;
            while (iB > 0) {
                s2 s2Var = this.H;
                if (s2Var.f1347b[s2Var.q(iB) * 5] == 202 && q7.k.a(this.H.r(iB), i1Var)) {
                    Object objP = this.H.p(iB);
                    q7.k.c(objP, "null cannot be cast to non-null type androidx.compose.runtime.PersistentCompositionLocalMap");
                    t1 t1Var3 = (t1) objP;
                    this.J = t1Var3;
                    return t1Var3;
                }
                s2 s2Var2 = this.H;
                iB = s2Var2.B(iB, s2Var2.f1347b);
            }
        }
        if (this.F.f1259c > 0) {
            while (iO > 0) {
                if (this.F.h(iO) == 202) {
                    o2 o2Var = this.F;
                    if (q7.k.a(o2Var.n(iO, o2Var.f1258b), i1Var)) {
                        k.t tVar = this.f1291u;
                        if (tVar == null || (t1Var = (t1) tVar.b(iO)) == null) {
                            o2 o2Var2 = this.F;
                            Object objB = o2Var2.b(iO, o2Var2.f1258b);
                            q7.k.c(objB, "null cannot be cast to non-null type androidx.compose.runtime.PersistentCompositionLocalMap");
                            t1Var = (t1) objB;
                        }
                        this.J = t1Var;
                        return t1Var;
                    }
                }
                iO = this.F.o(iO);
            }
        }
        j0.h hVar = this.f1290t;
        this.J = hVar;
        return hVar;
    }

    public final List m() {
        RandomAccess randomAccess;
        boolean z4 = this.B;
        d7.z zVar = d7.z.f2978f;
        if (!z4) {
            return zVar;
        }
        ArrayList arrayList = new ArrayList();
        s2 s2Var = this.H;
        arrayList.addAll(ib.k.j(s2Var, null, s2Var.f1365t, null));
        o2 o2Var = this.F;
        if (o2Var.f1262f || o2Var.f1259c == 0) {
            randomAccess = zVar;
        } else {
            m0.i iVar = new m0.i(o2Var);
            int iO = o2Var.f1265i;
            Object objValueOf = Integer.valueOf(o2Var.f1268l - r2.c(iO, o2Var.f1258b));
            while (iO >= 0) {
                iVar.c(o2Var.f1257a.j(iO), objValueOf);
                objValueOf = o2Var.a(iO);
                iO = o2Var.o(iO);
            }
            randomAccess = iVar.f6121f;
        }
        arrayList.addAll(randomAccess);
        arrayList.addAll(zVar);
        return arrayList;
    }

    public final void n() {
        Trace.beginSection("Compose:Composer.dispose");
        try {
            this.D.clear();
            this.f1288r.clear();
            this.f1275e.f1713a.Q();
            this.f1291u = null;
            this.f1271a.t();
        } finally {
            Trace.endSection();
        }
    }

    public final void o(k.a0 a0Var, j0.d dVar) {
        ArrayList arrayList = this.f1288r;
        if (this.E) {
            s.c("Reentrant composition is not supported");
        }
        Trace.beginSection("Compose:recompose");
        try {
            this.A = Long.hashCode(l0.m.k().g());
            this.f1291u = null;
            X(a0Var);
            this.f1280j = 0;
            this.E = true;
            try {
                V();
                Object objC = C();
                if (objC != dVar && dVar != null) {
                    c0(dVar);
                }
                n nVar = this.C;
                d0.e eVarI = b.i();
                try {
                    eVarI.b(nVar);
                    i1 i1Var = s.f1331a;
                    if (dVar != null) {
                        P(OAuthConstants.RESPONSE_CODE_OK, i1Var, 0, null);
                        j0.i.c(this, dVar);
                        q(false);
                    } else if (!this.f1292v || objC == null || objC.equals(k.f1229a)) {
                        M();
                    } else {
                        P(OAuthConstants.RESPONSE_CODE_OK, i1Var, 0, null);
                        q7.z.c(2, objC);
                        j0.i.c(this, (p7.n) objC);
                        q(false);
                    }
                    eVarI.j(eVarI.f2751h - 1);
                    t();
                    this.E = false;
                    arrayList.clear();
                    if (!this.H.f1368w) {
                        s.c("Check failed");
                    }
                    v();
                } catch (Throwable th) {
                    eVarI.j(eVarI.f2751h - 1);
                    throw th;
                }
            } finally {
            }
        } finally {
            Trace.endSection();
        }
    }

    public final void p(int i2, int i10) {
        if (i2 <= 0 || i2 == i10) {
            return;
        }
        p(this.F.o(i2), i10);
        if (this.F.j(i2)) {
            Object objL = this.F.l(i2);
            c0.b bVar = this.K;
            bVar.c();
            bVar.f1722h.add(objL);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:150:0x03a9  */
    /* JADX WARN: Removed duplicated region for block: B:201:0x051c  */
    /* JADX WARN: Type inference failed for: r3v19 */
    /* JADX WARN: Type inference failed for: r3v29, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r3v32 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void q(boolean r43) {
        /*
            Method dump skipped, instructions count: 1622
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: b0.p.q(boolean):void");
    }

    public final void r() {
        q(false);
        z1 z1VarW = w();
        if (z1VarW != null) {
            int i2 = z1VarW.f1442b;
            if ((i2 & 1) != 0) {
                z1VarW.f1442b = i2 | 2;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x007b A[EDGE_INSN: B:59:0x007b->B:28:0x007b BREAK  A[LOOP:0: B:15:0x0037->B:27:0x0078], EDGE_INSN: B:60:0x007b->B:28:0x007b BREAK  A[LOOP:0: B:15:0x0037->B:27:0x0078]] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00eb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final b0.z1 s() {
        /*
            Method dump skipped, instructions count: 241
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: b0.p.s():b0.z1");
    }

    public final void t() {
        q(false);
        q(false);
        c0.b bVar = this.K;
        if (bVar.f1717c) {
            bVar.d(false);
            bVar.d(false);
            bVar.f1716b.f1713a.U(c0.l.f1749d);
            bVar.f1717c = false;
        }
        bVar.b();
        if (bVar.f1718d.f1328b != 0) {
            s.c("Missed recording an endGroup()");
        }
        if (!this.f1278h.isEmpty()) {
            s.c("Start/end imbalance");
        }
        i();
        this.F.c();
        this.f1292v = this.f1293w.b() != 0;
    }

    public final void u(boolean z4, s1 s1Var) {
        this.f1278h.add(this.f1279i);
        this.f1279i = s1Var;
        int i2 = this.f1281k;
        r0 r0Var = this.f1283m;
        r0Var.c(i2);
        r0Var.c(this.f1282l);
        r0Var.c(this.f1280j);
        if (z4) {
            this.f1280j = 0;
        }
        this.f1281k = 0;
        this.f1282l = 0;
    }

    public final void v() {
        p2 p2Var = new p2();
        if (this.B) {
            p2Var.f1315o = new HashMap();
        }
        if (((Boolean) j2.f1205y.get()).booleanValue()) {
            p2Var.f1316p = new k.t();
        }
        this.G = p2Var;
        s2 s2VarH = p2Var.h();
        s2VarH.e(true);
        this.H = s2VarH;
    }

    public final z1 w() {
        if (this.f1296z != 0) {
            return null;
        }
        ArrayList arrayList = this.D;
        if (arrayList.isEmpty()) {
            return null;
        }
        return (z1) arrayList.get(arrayList.size() - 1);
    }

    public final boolean x() {
        if (!z() || this.f1292v) {
            return true;
        }
        z1 z1VarW = w();
        return (z1VarW == null || (z1VarW.f1442b & 4) == 0) ? false : true;
    }

    public final m0.c y() {
        if (this.B) {
            return this.N;
        }
        return null;
    }

    public final boolean z() {
        z1 z1VarW;
        return (this.P || this.f1294x || this.f1292v || (z1VarW = w()) == null || (z1VarW.f1442b & 8) != 0) ? false : true;
    }
}
