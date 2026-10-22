package u0;

import java.lang.invoke.VarHandle;
import java.util.ArrayList;
import java.util.HashMap;
import k0.q1;
import p.g0;
import p.o0;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public class b extends f {

    /* renamed from: n, reason: collision with root package name */
    public static final int[] f13637n = new int[0];

    /* renamed from: e, reason: collision with root package name */
    public final xb.l f13638e;

    /* renamed from: f, reason: collision with root package name */
    public final xb.l f13639f;

    /* renamed from: g, reason: collision with root package name */
    public int f13640g;

    /* renamed from: h, reason: collision with root package name */
    public g0 f13641h;
    public ArrayList i;

    /* renamed from: j, reason: collision with root package name */
    public k f13642j;

    /* renamed from: k, reason: collision with root package name */
    public int[] f13643k;

    /* renamed from: l, reason: collision with root package name */
    public int f13644l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f13645m;

    public b(long j10, k kVar, xb.l lVar, xb.l lVar2) {
        super(j10, kVar);
        this.f13638e = lVar;
        this.f13639f = lVar2;
        this.f13642j = k.i;
        this.f13643k = f13637n;
        this.f13644l = 1;
    }

    public final void A(long j10) {
        synchronized (m.f13676c) {
            this.f13642j = this.f13642j.e(j10);
        }
    }

    public void B(g0 g0Var) {
        this.f13641h = g0Var;
    }

    public b C(xb.l lVar, xb.l lVar2) {
        long j10;
        c cVar;
        if (this.f13654c) {
            q1.a("Cannot use a disposed snapshot");
        }
        if (this.f13645m && this.f13655d < 0) {
            q1.b("Unsupported operation on a disposed or applied snapshot");
        }
        A(g());
        Object obj = m.f13676c;
        synchronized (obj) {
            long j11 = m.f13678e;
            j10 = 1;
            m.f13678e = j11 + j10;
            m.f13677d = m.f13677d.e(j11);
            k kVarD = d();
            r(kVarD.e(j11));
            cVar = new c(j11, m.e(kVarD, g() + j10, j11), m.l(lVar, e(), true), m.b(lVar2, i()));
            cVar.f13646o = this;
            k();
            VarHandle.storeStoreFence();
        }
        if (this.f13645m || this.f13654c) {
            return cVar;
        }
        long jG = g();
        synchronized (obj) {
            long j12 = m.f13678e;
            m.f13678e = j12 + j10;
            s(j12);
            m.f13677d = m.f13677d.e(g());
        }
        r(m.e(d(), jG + j10, g()));
        return cVar;
    }

    @Override // u0.f
    public final void b() {
        m.f13677d = m.f13677d.b(g()).a(this.f13642j);
    }

    @Override // u0.f
    public void c() {
        if (this.f13654c) {
            return;
        }
        this.f13654c = true;
        synchronized (m.f13676c) {
            o();
        }
        l();
    }

    @Override // u0.f
    public boolean f() {
        return false;
    }

    @Override // u0.f
    public int h() {
        return this.f13640g;
    }

    @Override // u0.f
    public xb.l i() {
        return this.f13639f;
    }

    @Override // u0.f
    public void k() {
        this.f13644l++;
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x008c  */
    @Override // u0.f
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void l() {
        /*
            r17 = this;
            r0 = r17
            int r1 = r0.f13644l
            if (r1 <= 0) goto L7
            goto Lc
        L7:
            java.lang.String r1 = "no pending nested snapshots"
            k0.q1.a(r1)
        Lc:
            int r1 = r0.f13644l
            int r1 = r1 + (-1)
            r0.f13644l = r1
            if (r1 != 0) goto L94
            boolean r1 = r0.f13645m
            if (r1 != 0) goto L94
            p.g0 r1 = r0.x()
            if (r1 == 0) goto L91
            boolean r2 = r0.f13645m
            if (r2 == 0) goto L27
            java.lang.String r2 = "Unsupported operation on a snapshot that has been applied"
            k0.q1.b(r2)
        L27:
            r2 = 0
            r0.B(r2)
            long r2 = r0.g()
            java.lang.Object[] r4 = r1.f9561b
            long[] r1 = r1.f9560a
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
            u0.v r13 = (u0.v) r13
            u0.x r13 = r13.a()
        L69:
            if (r13 == 0) goto L86
            long r14 = r13.f13713a
            int r16 = (r14 > r2 ? 1 : (r14 == r2 ? 0 : -1))
            if (r16 == 0) goto L7d
            u0.k r6 = r0.f13642j
            java.lang.Long r14 = java.lang.Long.valueOf(r14)
            boolean r6 = kb.l.s0(r6, r14)
            if (r6 == 0) goto L83
        L7d:
            t0.d r6 = u0.m.f13674a
            r14 = 0
            r13.f13713a = r14
        L83:
            u0.x r13 = r13.f13714b
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
        throw new UnsupportedOperationException("Method not decompiled: u0.b.l():void");
    }

    @Override // u0.f
    public void m() {
        if (this.f13645m || this.f13654c) {
            return;
        }
        v();
    }

    @Override // u0.f
    public void n(v vVar) {
        g0 g0VarX = x();
        if (g0VarX == null) {
            int i = o0.f9601a;
            g0VarX = new g0();
            B(g0VarX);
        }
        g0VarX.a(vVar);
    }

    @Override // u0.f
    public final void p() {
        int length = this.f13643k.length;
        for (int i = 0; i < length; i++) {
            m.u(this.f13643k[i]);
        }
        o();
    }

    @Override // u0.f
    public void t(int i) {
        this.f13640g = i;
    }

    @Override // u0.f
    public f u(xb.l lVar) {
        long j10;
        d dVar;
        if (this.f13654c) {
            q1.a("Cannot use a disposed snapshot");
        }
        if (this.f13645m && this.f13655d < 0) {
            q1.b("Unsupported operation on a disposed or applied snapshot");
        }
        long jG = g();
        A(g());
        Object obj = m.f13676c;
        synchronized (obj) {
            long j11 = m.f13678e;
            j10 = 1;
            m.f13678e = j11 + j10;
            m.f13677d = m.f13677d.e(j11);
            dVar = new d(j11, m.e(d(), jG + j10, j11), m.l(lVar, e(), true), this);
        }
        if (this.f13645m || this.f13654c) {
            return dVar;
        }
        long jG2 = g();
        synchronized (obj) {
            long j12 = m.f13678e;
            m.f13678e = j12 + j10;
            s(j12);
            m.f13677d = m.f13677d.e(g());
        }
        r(m.e(d(), jG2 + j10, g()));
        return dVar;
    }

    public final void v() {
        long j10;
        A(g());
        if (this.f13645m || this.f13654c) {
            return;
        }
        long jG = g();
        synchronized (m.f13676c) {
            long j11 = m.f13678e;
            j10 = 1;
            m.f13678e = j11 + j10;
            s(j11);
            m.f13677d = m.f13677d.e(g());
        }
        r(m.e(d(), jG + j10, g()));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0145  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public u0.r w() {
        /*
            Method dump skipped, instructions count: 363
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: u0.b.w():u0.r");
    }

    public g0 x() {
        return this.f13641h;
    }

    @Override // u0.f
    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public xb.l e() {
        return this.f13638e;
    }

    public final r z(long j10, g0 g0Var, HashMap map, k kVar) {
        ArrayList arrayList;
        ArrayList arrayListF0;
        ArrayList arrayList2;
        k kVar2;
        Object[] objArr;
        long[] jArr;
        k kVar3;
        Object[] objArr2;
        long[] jArr2;
        int i;
        long j11;
        ArrayList arrayList3;
        x xVarD;
        k kVarD = d().e(g()).d(this.f13642j);
        Object[] objArr3 = g0Var.f9561b;
        long[] jArr3 = g0Var.f9560a;
        int length = jArr3.length - 2;
        if (length >= 0) {
            int i3 = 0;
            arrayList2 = null;
            arrayListF0 = null;
            while (true) {
                long j12 = jArr3[i3];
                if ((((~j12) << 7) & j12 & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i10 = 8 - ((~(i3 - length)) >>> 31);
                    int i11 = 0;
                    while (i11 < i10) {
                        if ((j12 & 255) < 128) {
                            objArr2 = objArr3;
                            v vVar = (v) objArr3[(i3 << 3) + i11];
                            jArr2 = jArr3;
                            x xVarA = vVar.a();
                            i = i11;
                            ArrayList arrayList4 = arrayList2;
                            x xVarS = m.s(xVarA, j10, kVar);
                            if (xVarS == null) {
                                kVar3 = kVarD;
                                arrayList3 = arrayListF0;
                                j11 = j12;
                            } else {
                                arrayList3 = arrayListF0;
                                j11 = j12;
                                x xVarS2 = m.s(xVarA, g(), kVarD);
                                if (xVarS2 == null) {
                                    kVar3 = kVarD;
                                } else {
                                    kVar3 = kVarD;
                                    if (xVarS2.f13713a != 1 && !xVarS.equals(xVarS2)) {
                                        x xVarS3 = m.s(xVarA, g(), d());
                                        if (xVarS3 == null) {
                                            m.r();
                                            throw null;
                                        }
                                        if (map == null || (xVarD = (x) map.get(xVarS)) == null) {
                                            xVarD = vVar.d(xVarS2, xVarS, xVarS3);
                                        }
                                        if (xVarD == null) {
                                            return new g();
                                        }
                                        if (!xVarD.equals(xVarS3)) {
                                            if (xVarD.equals(xVarS)) {
                                                ArrayList arrayList5 = arrayList4 == null ? new ArrayList() : arrayList4;
                                                arrayList5.add(new jb.g(vVar, xVarS.b(g())));
                                                arrayListF0 = arrayList3 == null ? new ArrayList() : arrayList3;
                                                arrayListF0.add(vVar);
                                                arrayList2 = arrayList5;
                                            } else {
                                                arrayList2 = arrayList4 == null ? new ArrayList() : arrayList4;
                                                arrayList2.add(!xVarD.equals(xVarS2) ? new jb.g(vVar, xVarD) : new jb.g(vVar, xVarS2.b(g())));
                                            }
                                        }
                                        arrayListF0 = arrayList3;
                                    }
                                }
                            }
                            arrayList2 = arrayList4;
                            arrayListF0 = arrayList3;
                        } else {
                            kVar3 = kVarD;
                            objArr2 = objArr3;
                            jArr2 = jArr3;
                            i = i11;
                            j11 = j12;
                        }
                        j12 = j11 >> 8;
                        i11 = i + 1;
                        jArr3 = jArr2;
                        objArr3 = objArr2;
                        kVarD = kVar3;
                    }
                    kVar2 = kVarD;
                    objArr = objArr3;
                    jArr = jArr3;
                    if (i10 != 8) {
                        break;
                    }
                } else {
                    kVar2 = kVarD;
                    objArr = objArr3;
                    jArr = jArr3;
                }
                if (i3 == length) {
                    arrayList = arrayList2;
                    break;
                }
                i3++;
                jArr3 = jArr;
                objArr3 = objArr;
                kVarD = kVar2;
            }
        } else {
            arrayList = null;
            arrayListF0 = null;
        }
        arrayList2 = arrayList;
        if (arrayList2 != null) {
            v();
            int size = arrayList2.size();
            for (int i12 = 0; i12 < size; i12++) {
                jb.g gVar = (jb.g) arrayList2.get(i12);
                v vVar2 = (v) gVar.f6759c;
                x xVar = (x) gVar.f6760f;
                xVar.f13713a = j10;
                synchronized (m.f13676c) {
                    xVar.f13714b = vVar2.a();
                    vVar2.c(xVar);
                }
            }
        }
        if (arrayListF0 != null) {
            int size2 = arrayListF0.size();
            for (int i13 = 0; i13 < size2; i13++) {
                g0Var.k((v) arrayListF0.get(i13));
            }
            ArrayList arrayList6 = this.i;
            if (arrayList6 != null) {
                arrayListF0 = kb.l.F0(arrayList6, arrayListF0);
            }
            this.i = arrayListF0;
        }
        return h.f13656b;
    }
}
