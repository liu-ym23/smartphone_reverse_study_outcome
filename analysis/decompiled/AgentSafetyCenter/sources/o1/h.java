package o1;

import u1.g1;
import u1.s1;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class h extends i {

    /* renamed from: c, reason: collision with root package name */
    public w0.l f9034c;

    /* renamed from: d, reason: collision with root package name */
    public wd.a f9035d;

    /* renamed from: e, reason: collision with root package name */
    public p.n f9036e;

    /* renamed from: f, reason: collision with root package name */
    public g1 f9037f;

    /* renamed from: g, reason: collision with root package name */
    public j f9038g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f9039h;
    public boolean i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f9040j;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:169:0x0312  */
    /* JADX WARN: Type inference failed for: r10v0 */
    /* JADX WARN: Type inference failed for: r10v1 */
    /* JADX WARN: Type inference failed for: r10v10 */
    /* JADX WARN: Type inference failed for: r10v11, types: [m0.e] */
    /* JADX WARN: Type inference failed for: r10v12 */
    /* JADX WARN: Type inference failed for: r10v13 */
    /* JADX WARN: Type inference failed for: r10v14, types: [m0.e] */
    /* JADX WARN: Type inference failed for: r10v16 */
    /* JADX WARN: Type inference failed for: r10v17 */
    /* JADX WARN: Type inference failed for: r10v18 */
    /* JADX WARN: Type inference failed for: r10v19 */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.lang.Object, java.util.List] */
    /* JADX WARN: Type inference failed for: r5v3, types: [java.lang.Object, java.util.List] */
    /* JADX WARN: Type inference failed for: r6v14, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v31 */
    /* JADX WARN: Type inference failed for: r6v4, types: [int] */
    /* JADX WARN: Type inference failed for: r7v0, types: [w0.l] */
    /* JADX WARN: Type inference failed for: r7v1, types: [w0.l] */
    /* JADX WARN: Type inference failed for: r7v30 */
    /* JADX WARN: Type inference failed for: r7v31, types: [w0.l] */
    /* JADX WARN: Type inference failed for: r7v32, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r7v33 */
    /* JADX WARN: Type inference failed for: r7v34 */
    /* JADX WARN: Type inference failed for: r7v35 */
    /* JADX WARN: Type inference failed for: r7v36 */
    /* JADX WARN: Type inference failed for: r7v37 */
    /* JADX WARN: Type inference failed for: r7v38 */
    @Override // o1.i
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean a(p.n r52, s1.q r53, ma.a r54, boolean r55) {
        /*
            Method dump skipped, instructions count: 791
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: o1.h.a(p.n, s1.q, ma.a, boolean):boolean");
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object, java.util.Collection, java.util.List] */
    @Override // o1.i
    public final void b(ma.a aVar) {
        super.b(aVar);
        j jVar = this.f9038g;
        if (jVar == null) {
            return;
        }
        this.f9039h = this.i;
        ?? r12 = jVar.f9056a;
        int size = r12.size();
        for (int i = 0; i < size; i++) {
            s sVar = (s) r12.get(i);
            boolean z10 = sVar.f9074d;
            long j10 = sVar.f9071a;
            boolean zA = aVar.a(j10);
            boolean z11 = this.i;
            if ((!z10 && !zA) || (!z10 && !z11)) {
                this.f9035d.h(j10);
            }
        }
        this.i = false;
        this.f9040j = jVar.f9058c == 5;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4, types: [m0.e] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7, types: [m0.e] */
    /* JADX WARN: Type inference failed for: r1v9 */
    /* JADX WARN: Type inference failed for: r8v1, types: [w0.l] */
    /* JADX WARN: Type inference failed for: r8v10 */
    /* JADX WARN: Type inference failed for: r8v11 */
    /* JADX WARN: Type inference failed for: r8v12 */
    /* JADX WARN: Type inference failed for: r8v2, types: [w0.l] */
    /* JADX WARN: Type inference failed for: r8v4 */
    /* JADX WARN: Type inference failed for: r8v5, types: [w0.l] */
    /* JADX WARN: Type inference failed for: r8v6, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r8v7 */
    /* JADX WARN: Type inference failed for: r8v8 */
    /* JADX WARN: Type inference failed for: r8v9 */
    public final void c() {
        m0.e eVar = this.f9046a;
        Object[] objArr = eVar.f8158c;
        int i = eVar.f8160g;
        for (int i3 = 0; i3 < i; i3++) {
            ((h) objArr[i3]).c();
        }
        u1.m mVarE = this.f9034c;
        ?? eVar2 = 0;
        while (mVarE != 0) {
            if (mVarE instanceof s1) {
                ((s1) mVarE).A();
            } else if ((mVarE.f15116g & 16) != 0 && (mVarE instanceof u1.m)) {
                w0.l lVar = mVarE.f13866t;
                int i10 = 0;
                eVar2 = eVar2;
                mVarE = mVarE;
                while (lVar != null) {
                    if ((lVar.f15116g & 16) != 0) {
                        i10++;
                        eVar2 = eVar2;
                        if (i10 == 1) {
                            mVarE = lVar;
                        } else {
                            if (eVar2 == 0) {
                                eVar2 = new m0.e(new w0.l[16]);
                            }
                            if (mVarE != 0) {
                                eVar2.b(mVarE);
                                mVarE = 0;
                            }
                            eVar2.b(lVar);
                        }
                    }
                    lVar = lVar.f15118j;
                    eVar2 = eVar2;
                    mVarE = mVarE;
                }
                if (i10 == 1) {
                }
            }
            mVarE = u1.f.e(eVar2);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v0 */
    /* JADX WARN: Type inference failed for: r7v1, types: [w0.l] */
    /* JADX WARN: Type inference failed for: r7v10 */
    /* JADX WARN: Type inference failed for: r7v11 */
    /* JADX WARN: Type inference failed for: r7v3 */
    /* JADX WARN: Type inference failed for: r7v4, types: [w0.l] */
    /* JADX WARN: Type inference failed for: r7v5, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r7v6 */
    /* JADX WARN: Type inference failed for: r7v7 */
    /* JADX WARN: Type inference failed for: r7v8 */
    /* JADX WARN: Type inference failed for: r7v9 */
    /* JADX WARN: Type inference failed for: r8v0 */
    /* JADX WARN: Type inference failed for: r8v1 */
    /* JADX WARN: Type inference failed for: r8v10 */
    /* JADX WARN: Type inference failed for: r8v11 */
    /* JADX WARN: Type inference failed for: r8v2 */
    /* JADX WARN: Type inference failed for: r8v3, types: [m0.e] */
    /* JADX WARN: Type inference failed for: r8v4 */
    /* JADX WARN: Type inference failed for: r8v5 */
    /* JADX WARN: Type inference failed for: r8v6, types: [m0.e] */
    /* JADX WARN: Type inference failed for: r8v8 */
    /* JADX WARN: Type inference failed for: r8v9 */
    public final boolean d(ma.a aVar) {
        w0.l lVar = this.f9034c;
        p.n nVar = this.f9036e;
        boolean z10 = false;
        z10 = false;
        if (nVar.h() != 0 && lVar.f15126r) {
            j jVar = this.f9038g;
            jVar.getClass();
            g1 g1Var = this.f9037f;
            g1Var.getClass();
            long j10 = g1Var.f11279g;
            u1.m mVarE = lVar;
            ?? eVar = 0;
            while (mVarE != 0) {
                if (mVarE instanceof s1) {
                    ((s1) mVarE).q(jVar, k.f9061g, j10);
                } else if ((mVarE.f15116g & 16) != 0 && (mVarE instanceof u1.m)) {
                    w0.l lVar2 = mVarE.f13866t;
                    int i = 0;
                    mVarE = mVarE;
                    eVar = eVar;
                    while (lVar2 != null) {
                        if ((lVar2.f15116g & 16) != 0) {
                            i++;
                            eVar = eVar;
                            if (i == 1) {
                                mVarE = lVar2;
                            } else {
                                if (eVar == 0) {
                                    eVar = new m0.e(new w0.l[16]);
                                }
                                if (mVarE != 0) {
                                    eVar.b(mVarE);
                                    mVarE = 0;
                                }
                                eVar.b(lVar2);
                            }
                        }
                        lVar2 = lVar2.f15118j;
                        mVarE = mVarE;
                        eVar = eVar;
                    }
                    if (i == 1) {
                    }
                }
                mVarE = u1.f.e(eVar);
            }
            if (lVar.f15126r) {
                m0.e eVar2 = this.f9046a;
                Object[] objArr = eVar2.f8158c;
                int i3 = eVar2.f8160g;
                for (int i10 = 0; i10 < i3; i10++) {
                    ((h) objArr[i10]).d(aVar);
                }
            }
            z10 = true;
        }
        b(aVar);
        nVar.a();
        this.f9037f = null;
        return z10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [w0.l] */
    /* JADX WARN: Type inference failed for: r0v1, types: [w0.l] */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4, types: [w0.l] */
    /* JADX WARN: Type inference failed for: r0v5, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r13v10 */
    /* JADX WARN: Type inference failed for: r13v11 */
    /* JADX WARN: Type inference failed for: r13v12 */
    /* JADX WARN: Type inference failed for: r13v13 */
    /* JADX WARN: Type inference failed for: r13v2 */
    /* JADX WARN: Type inference failed for: r13v3 */
    /* JADX WARN: Type inference failed for: r13v4 */
    /* JADX WARN: Type inference failed for: r13v5, types: [m0.e] */
    /* JADX WARN: Type inference failed for: r13v6 */
    /* JADX WARN: Type inference failed for: r13v7 */
    /* JADX WARN: Type inference failed for: r13v8, types: [m0.e] */
    /* JADX WARN: Type inference failed for: r6v0 */
    /* JADX WARN: Type inference failed for: r6v1, types: [w0.l] */
    /* JADX WARN: Type inference failed for: r6v10, types: [w0.l] */
    /* JADX WARN: Type inference failed for: r6v11, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v12 */
    /* JADX WARN: Type inference failed for: r6v13 */
    /* JADX WARN: Type inference failed for: r6v14 */
    /* JADX WARN: Type inference failed for: r6v15 */
    /* JADX WARN: Type inference failed for: r6v16 */
    /* JADX WARN: Type inference failed for: r6v17 */
    /* JADX WARN: Type inference failed for: r6v9 */
    /* JADX WARN: Type inference failed for: r7v0 */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v10 */
    /* JADX WARN: Type inference failed for: r7v11 */
    /* JADX WARN: Type inference failed for: r7v12 */
    /* JADX WARN: Type inference failed for: r7v3 */
    /* JADX WARN: Type inference failed for: r7v4, types: [m0.e] */
    /* JADX WARN: Type inference failed for: r7v5 */
    /* JADX WARN: Type inference failed for: r7v6 */
    /* JADX WARN: Type inference failed for: r7v7, types: [m0.e] */
    /* JADX WARN: Type inference failed for: r7v9 */
    public final boolean e(ma.a aVar, boolean z10) {
        u1.m mVarE = this.f9034c;
        if (this.f9036e.h() == 0 || !mVarE.f15126r) {
            return false;
        }
        j jVar = this.f9038g;
        jVar.getClass();
        g1 g1Var = this.f9037f;
        g1Var.getClass();
        long j10 = g1Var.f11279g;
        u1.m mVarE2 = mVarE;
        ?? eVar = 0;
        while (mVarE2 != 0) {
            if (mVarE2 instanceof s1) {
                ((s1) mVarE2).q(jVar, k.f9059c, j10);
            } else if ((mVarE2.f15116g & 16) != 0 && (mVarE2 instanceof u1.m)) {
                w0.l lVar = mVarE2.f13866t;
                int i = 0;
                mVarE2 = mVarE2;
                eVar = eVar;
                while (lVar != null) {
                    if ((lVar.f15116g & 16) != 0) {
                        i++;
                        eVar = eVar;
                        if (i == 1) {
                            mVarE2 = lVar;
                        } else {
                            if (eVar == 0) {
                                eVar = new m0.e(new w0.l[16]);
                            }
                            if (mVarE2 != 0) {
                                eVar.b(mVarE2);
                                mVarE2 = 0;
                            }
                            eVar.b(lVar);
                        }
                    }
                    lVar = lVar.f15118j;
                    mVarE2 = mVarE2;
                    eVar = eVar;
                }
                if (i == 1) {
                }
            }
            mVarE2 = u1.f.e(eVar);
        }
        if (mVarE.f15126r) {
            m0.e eVar2 = this.f9046a;
            Object[] objArr = eVar2.f8158c;
            int i3 = eVar2.f8160g;
            for (int i10 = 0; i10 < i3; i10++) {
                h hVar = (h) objArr[i10];
                this.f9037f.getClass();
                hVar.e(aVar, z10);
            }
        }
        if (mVarE.f15126r) {
            ?? eVar3 = 0;
            while (mVarE != 0) {
                if (mVarE instanceof s1) {
                    ((s1) mVarE).q(jVar, k.f9060f, j10);
                } else if ((mVarE.f15116g & 16) != 0 && (mVarE instanceof u1.m)) {
                    w0.l lVar2 = mVarE.f13866t;
                    int i11 = 0;
                    mVarE = mVarE;
                    eVar3 = eVar3;
                    while (lVar2 != null) {
                        if ((lVar2.f15116g & 16) != 0) {
                            i11++;
                            eVar3 = eVar3;
                            if (i11 == 1) {
                                mVarE = lVar2;
                            } else {
                                if (eVar3 == 0) {
                                    eVar3 = new m0.e(new w0.l[16]);
                                }
                                if (mVarE != 0) {
                                    eVar3.b(mVarE);
                                    mVarE = 0;
                                }
                                eVar3.b(lVar2);
                            }
                        }
                        lVar2 = lVar2.f15118j;
                        mVarE = mVarE;
                        eVar3 = eVar3;
                    }
                    if (i11 == 1) {
                    }
                }
                mVarE = u1.f.e(eVar3);
            }
        }
        return true;
    }

    public final void f(long j10, p.a0 a0Var) {
        wd.a aVar = this.f9035d;
        if (aVar.e(j10) && a0Var.f(this) < 0) {
            aVar.h(j10);
            this.f9036e.f(j10);
        }
        m0.e eVar = this.f9046a;
        Object[] objArr = eVar.f8158c;
        int i = eVar.f8160g;
        for (int i3 = 0; i3 < i; i3++) {
            ((h) objArr[i3]).f(j10, a0Var);
        }
    }

    public final String toString() {
        return "Node(modifierNode=" + this.f9034c + ", children=" + this.f9046a + ", pointerIds=" + this.f9035d + ')';
    }
}
