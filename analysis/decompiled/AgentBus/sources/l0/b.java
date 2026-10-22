package l0;

import b0.u1;
import java.util.ArrayList;
import java.util.HashMap;
import k.b0;
import k.h0;

/* loaded from: classes.dex */
public class b extends f {

    /* renamed from: n, reason: collision with root package name */
    public static final int[] f5732n = new int[0];

    /* renamed from: e, reason: collision with root package name */
    public final p7.k f5733e;

    /* renamed from: f, reason: collision with root package name */
    public final p7.k f5734f;

    /* renamed from: g, reason: collision with root package name */
    public int f5735g;

    /* renamed from: h, reason: collision with root package name */
    public b0 f5736h;

    /* renamed from: i, reason: collision with root package name */
    public ArrayList f5737i;

    /* renamed from: j, reason: collision with root package name */
    public k f5738j;

    /* renamed from: k, reason: collision with root package name */
    public int[] f5739k;

    /* renamed from: l, reason: collision with root package name */
    public int f5740l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f5741m;

    public b(long j2, k kVar, p7.k kVar2, p7.k kVar3) {
        super(j2, kVar);
        this.f5733e = kVar2;
        this.f5734f = kVar3;
        this.f5738j = k.f5764j;
        this.f5739k = f5732n;
        this.f5740l = 1;
    }

    public final void A(long j2) {
        synchronized (m.f5774c) {
            this.f5738j = this.f5738j.j(j2);
        }
    }

    public void B(b0 b0Var) {
        this.f5736h = b0Var;
    }

    public b C(p7.k kVar, p7.k kVar2) {
        long j2;
        c cVar;
        if (this.f5750c) {
            u1.a("Cannot use a disposed snapshot");
        }
        if (this.f5741m && this.f5751d < 0) {
            u1.b("Unsupported operation on a disposed or applied snapshot");
        }
        A(g());
        Object obj = m.f5774c;
        synchronized (obj) {
            long j4 = m.f5776e;
            j2 = 1;
            m.f5776e = j4 + j2;
            m.f5775d = m.f5775d.j(j4);
            k kVarD = d();
            r(kVarD.j(j4));
            cVar = new c(j4, m.e(kVarD, g() + j2, j4), m.l(kVar, e(), true), m.b(kVar2, i()), this);
        }
        if (this.f5741m || this.f5750c) {
            return cVar;
        }
        long jG = g();
        synchronized (obj) {
            long j10 = m.f5776e;
            m.f5776e = j10 + j2;
            s(j10);
            m.f5775d = m.f5775d.j(g());
        }
        r(m.e(d(), jG + j2, g()));
        return cVar;
    }

    @Override // l0.f
    public final void b() {
        m.f5775d = m.f5775d.f(g()).a(this.f5738j);
    }

    @Override // l0.f
    public void c() {
        if (this.f5750c) {
            return;
        }
        this.f5750c = true;
        synchronized (m.f5774c) {
            o();
        }
        l();
    }

    @Override // l0.f
    public boolean f() {
        return false;
    }

    @Override // l0.f
    public int h() {
        return this.f5735g;
    }

    @Override // l0.f
    public p7.k i() {
        return this.f5734f;
    }

    @Override // l0.f
    public void k() {
        this.f5740l++;
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x008c  */
    @Override // l0.f
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void l() {
        /*
            r17 = this;
            r0 = r17
            int r1 = r0.f5740l
            if (r1 <= 0) goto L7
            goto Lc
        L7:
            java.lang.String r1 = "no pending nested snapshots"
            b0.u1.a(r1)
        Lc:
            int r1 = r0.f5740l
            int r1 = r1 + (-1)
            r0.f5740l = r1
            if (r1 != 0) goto L94
            boolean r1 = r0.f5741m
            if (r1 != 0) goto L94
            k.b0 r1 = r0.x()
            if (r1 == 0) goto L91
            boolean r2 = r0.f5741m
            if (r2 == 0) goto L27
            java.lang.String r2 = "Unsupported operation on a snapshot that has been applied"
            b0.u1.b(r2)
        L27:
            r2 = 0
            r0.B(r2)
            long r2 = r0.g()
            java.lang.Object[] r4 = r1.f5454b
            long[] r1 = r1.f5453a
            int r5 = r1.length
            int r5 = r5 + (-2)
            if (r5 < 0) goto L91
            r7 = 0
        L39:
            r8 = r1[r7]
            long r10 = ~r8
            r12 = 7
            long r10 = r10 << r12
            long r10 = r10 & r8
            r12 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r10 = r10 & r12
            int r10 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r10 == 0) goto L8c
            int r10 = r7 - r5
            int r10 = ~r10
            int r10 = r10 >>> 31
            r11 = 8
            int r10 = 8 - r10
            r12 = 0
        L53:
            if (r12 >= r10) goto L8a
            r13 = 255(0xff, double:1.26E-321)
            long r13 = r13 & r8
            r15 = 128(0x80, double:6.3E-322)
            int r13 = (r13 > r15 ? 1 : (r13 == r15 ? 0 : -1))
            if (r13 >= 0) goto L86
            int r13 = r7 << 3
            int r13 = r13 + r12
            r13 = r4[r13]
            l0.v r13 = (l0.v) r13
            l0.x r13 = r13.a()
        L69:
            if (r13 == 0) goto L86
            long r14 = r13.f5813a
            int r16 = (r14 > r2 ? 1 : (r14 == r2 ? 0 : -1))
            if (r16 == 0) goto L7d
            l0.k r6 = r0.f5738j
            java.lang.Long r14 = java.lang.Long.valueOf(r14)
            boolean r6 = d7.r.I0(r6, r14)
            if (r6 == 0) goto L83
        L7d:
            c6.d r6 = l0.m.f5772a
            r14 = 0
            r13.f5813a = r14
        L83:
            l0.x r13 = r13.f5814b
            goto L69
        L86:
            long r8 = r8 >> r11
            int r12 = r12 + 1
            goto L53
        L8a:
            if (r10 != r11) goto L91
        L8c:
            if (r7 == r5) goto L91
            int r7 = r7 + 1
            goto L39
        L91:
            r0.a()
        L94:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: l0.b.l():void");
    }

    @Override // l0.f
    public void m() {
        if (this.f5741m || this.f5750c) {
            return;
        }
        v();
    }

    @Override // l0.f
    public void n(v vVar) {
        b0 b0VarX = x();
        if (b0VarX == null) {
            int i2 = h0.f5493a;
            b0VarX = new b0();
            B(b0VarX);
        }
        b0VarX.a(vVar);
    }

    @Override // l0.f
    public final void p() {
        int length = this.f5739k.length;
        for (int i2 = 0; i2 < length; i2++) {
            m.u(this.f5739k[i2]);
        }
        o();
    }

    @Override // l0.f
    public void t(int i2) {
        this.f5735g = i2;
    }

    @Override // l0.f
    public f u(p7.k kVar) {
        long j2;
        d dVar;
        if (this.f5750c) {
            u1.a("Cannot use a disposed snapshot");
        }
        if (this.f5741m && this.f5751d < 0) {
            u1.b("Unsupported operation on a disposed or applied snapshot");
        }
        long jG = g();
        A(g());
        Object obj = m.f5774c;
        synchronized (obj) {
            long j4 = m.f5776e;
            j2 = 1;
            m.f5776e = j4 + j2;
            m.f5775d = m.f5775d.j(j4);
            dVar = new d(j4, m.e(d(), jG + j2, j4), m.l(kVar, e(), true), this);
        }
        if (this.f5741m || this.f5750c) {
            return dVar;
        }
        long jG2 = g();
        synchronized (obj) {
            long j10 = m.f5776e;
            m.f5776e = j10 + j2;
            s(j10);
            m.f5775d = m.f5775d.j(g());
        }
        r(m.e(d(), jG2 + j2, g()));
        return dVar;
    }

    public final void v() {
        long j2;
        A(g());
        if (this.f5741m || this.f5750c) {
            return;
        }
        long jG = g();
        synchronized (m.f5774c) {
            long j4 = m.f5776e;
            j2 = 1;
            m.f5776e = j4 + j2;
            s(j4);
            m.f5775d = m.f5775d.j(g());
        }
        r(m.e(d(), jG + j2, g()));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0145  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public l0.r w() {
        /*
            Method dump skipped, instructions count: 363
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: l0.b.w():l0.r");
    }

    public b0 x() {
        return this.f5736h;
    }

    @Override // l0.f
    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public p7.k e() {
        return this.f5733e;
    }

    public final r z(long j2, b0 b0Var, HashMap map, k kVar) {
        ArrayList arrayList;
        ArrayList arrayListC1;
        ArrayList arrayList2;
        k kVar2;
        Object[] objArr;
        long[] jArr;
        k kVar3;
        Object[] objArr2;
        long[] jArr2;
        int i2;
        long j4;
        ArrayList arrayList3;
        x xVarH;
        k kVarI = d().j(g()).i(this.f5738j);
        Object[] objArr3 = b0Var.f5454b;
        long[] jArr3 = b0Var.f5453a;
        int length = jArr3.length - 2;
        if (length >= 0) {
            int i10 = 0;
            arrayList2 = null;
            arrayListC1 = null;
            while (true) {
                long j10 = jArr3[i10];
                if ((((~j10) << 7) & j10 & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i11 = 8 - ((~(i10 - length)) >>> 31);
                    int i12 = 0;
                    while (i12 < i11) {
                        if ((j10 & 255) < 128) {
                            objArr2 = objArr3;
                            v vVar = (v) objArr3[(i10 << 3) + i12];
                            jArr2 = jArr3;
                            x xVarA = vVar.a();
                            i2 = i12;
                            ArrayList arrayList4 = arrayList2;
                            x xVarS = m.s(xVarA, j2, kVar);
                            if (xVarS == null) {
                                kVar3 = kVarI;
                                arrayList3 = arrayListC1;
                                j4 = j10;
                            } else {
                                arrayList3 = arrayListC1;
                                j4 = j10;
                                x xVarS2 = m.s(xVarA, g(), kVarI);
                                if (xVarS2 == null) {
                                    kVar3 = kVarI;
                                } else {
                                    kVar3 = kVarI;
                                    if (xVarS2.f5813a != 1 && !xVarS.equals(xVarS2)) {
                                        x xVarS3 = m.s(xVarA, g(), d());
                                        if (xVarS3 == null) {
                                            m.r();
                                            throw null;
                                        }
                                        if (map == null || (xVarH = (x) map.get(xVarS)) == null) {
                                            xVarH = vVar.h(xVarS2, xVarS, xVarS3);
                                        }
                                        if (xVarH == null) {
                                            return new g();
                                        }
                                        if (!xVarH.equals(xVarS3)) {
                                            if (xVarH.equals(xVarS)) {
                                                ArrayList arrayList5 = arrayList4 == null ? new ArrayList() : arrayList4;
                                                arrayList5.add(new c7.j(vVar, xVarS.b(g())));
                                                arrayListC1 = arrayList3 == null ? new ArrayList() : arrayList3;
                                                arrayListC1.add(vVar);
                                                arrayList2 = arrayList5;
                                            } else {
                                                arrayList2 = arrayList4 == null ? new ArrayList() : arrayList4;
                                                arrayList2.add(!xVarH.equals(xVarS2) ? new c7.j(vVar, xVarH) : new c7.j(vVar, xVarS2.b(g())));
                                            }
                                        }
                                        arrayListC1 = arrayList3;
                                    }
                                }
                            }
                            arrayList2 = arrayList4;
                            arrayListC1 = arrayList3;
                        } else {
                            kVar3 = kVarI;
                            objArr2 = objArr3;
                            jArr2 = jArr3;
                            i2 = i12;
                            j4 = j10;
                        }
                        j10 = j4 >> 8;
                        i12 = i2 + 1;
                        jArr3 = jArr2;
                        objArr3 = objArr2;
                        kVarI = kVar3;
                    }
                    kVar2 = kVarI;
                    objArr = objArr3;
                    jArr = jArr3;
                    if (i11 != 8) {
                        break;
                    }
                } else {
                    kVar2 = kVarI;
                    objArr = objArr3;
                    jArr = jArr3;
                }
                if (i10 == length) {
                    arrayList = arrayList2;
                    break;
                }
                i10++;
                jArr3 = jArr;
                objArr3 = objArr;
                kVarI = kVar2;
            }
        } else {
            arrayList = null;
            arrayListC1 = null;
        }
        arrayList2 = arrayList;
        if (arrayList2 != null) {
            v();
            int size = arrayList2.size();
            for (int i13 = 0; i13 < size; i13++) {
                c7.j jVar = (c7.j) arrayList2.get(i13);
                v vVar2 = (v) jVar.f1973f;
                x xVar = (x) jVar.f1974g;
                xVar.f5813a = j2;
                synchronized (m.f5774c) {
                    xVar.f5814b = vVar2.a();
                    vVar2.f(xVar);
                }
            }
        }
        if (arrayListC1 != null) {
            int size2 = arrayListC1.size();
            for (int i14 = 0; i14 < size2; i14++) {
                b0Var.k((v) arrayListC1.get(i14));
            }
            ArrayList arrayList6 = this.f5737i;
            if (arrayList6 != null) {
                arrayListC1 = d7.r.c1(arrayList6, arrayListC1);
            }
            this.f5737i = arrayListC1;
        }
        return h.f5752b;
    }
}
