package c1;

import i1.d1;
import i1.p1;
import k.z;

/* loaded from: classes.dex */
public final class d extends e {

    /* renamed from: c, reason: collision with root package name */
    public final n0.l f1785c;

    /* renamed from: d, reason: collision with root package name */
    public final d1.b f1786d;

    /* renamed from: e, reason: collision with root package name */
    public final k.n f1787e;

    /* renamed from: f, reason: collision with root package name */
    public d1 f1788f;

    /* renamed from: g, reason: collision with root package name */
    public f f1789g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f1790h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f1791i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f1792j;

    public d(n0.l lVar) {
        this.f1785c = lVar;
        d1.b bVar = new d1.b(0, false);
        bVar.f2768h = new long[2];
        this.f1786d = bVar;
        this.f1787e = new k.n(2);
        this.f1791i = true;
        this.f1792j = true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:170:0x0311  */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.lang.Object, java.util.List] */
    /* JADX WARN: Type inference failed for: r4v6, types: [java.lang.Object, java.util.List] */
    /* JADX WARN: Type inference failed for: r5v0, types: [n0.l] */
    /* JADX WARN: Type inference failed for: r5v1, types: [n0.l] */
    /* JADX WARN: Type inference failed for: r5v38 */
    /* JADX WARN: Type inference failed for: r5v39, types: [n0.l] */
    /* JADX WARN: Type inference failed for: r5v40, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v41 */
    /* JADX WARN: Type inference failed for: r5v42 */
    /* JADX WARN: Type inference failed for: r5v43 */
    /* JADX WARN: Type inference failed for: r5v44 */
    /* JADX WARN: Type inference failed for: r5v45 */
    /* JADX WARN: Type inference failed for: r5v46 */
    /* JADX WARN: Type inference failed for: r5v47 */
    /* JADX WARN: Type inference failed for: r5v8 */
    /* JADX WARN: Type inference failed for: r5v9, types: [int] */
    /* JADX WARN: Type inference failed for: r8v0 */
    /* JADX WARN: Type inference failed for: r8v1 */
    /* JADX WARN: Type inference failed for: r8v15 */
    /* JADX WARN: Type inference failed for: r8v16, types: [d0.e] */
    /* JADX WARN: Type inference failed for: r8v17 */
    /* JADX WARN: Type inference failed for: r8v18 */
    /* JADX WARN: Type inference failed for: r8v19, types: [d0.e] */
    /* JADX WARN: Type inference failed for: r8v21 */
    /* JADX WARN: Type inference failed for: r8v22 */
    /* JADX WARN: Type inference failed for: r8v23 */
    /* JADX WARN: Type inference failed for: r8v24 */
    @Override // c1.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean a(k.n r53, g1.k r54, q6.b r55, boolean r56) {
        /*
            Method dump skipped, instructions count: 790
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: c1.d.a(k.n, g1.k, q6.b, boolean):boolean");
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object, java.util.Collection, java.util.List] */
    @Override // c1.e
    public final void b(q6.b bVar) {
        super.b(bVar);
        f fVar = this.f1789g;
        if (fVar == null) {
            return;
        }
        this.f1790h = this.f1791i;
        ?? r12 = fVar.f1795a;
        int size = r12.size();
        for (int i2 = 0; i2 < size; i2++) {
            l lVar = (l) r12.get(i2);
            boolean z4 = lVar.f1807d;
            long j2 = lVar.f1804a;
            boolean zX0 = bVar.x0(j2);
            boolean z10 = this.f1791i;
            if ((!z4 && !zX0) || (!z4 && !z10)) {
                this.f1786d.i(j2);
            }
        }
        this.f1791i = false;
        this.f1792j = fVar.f1796b == 5;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4, types: [d0.e] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7, types: [d0.e] */
    /* JADX WARN: Type inference failed for: r1v9 */
    /* JADX WARN: Type inference failed for: r8v1, types: [n0.l] */
    /* JADX WARN: Type inference failed for: r8v10 */
    /* JADX WARN: Type inference failed for: r8v11 */
    /* JADX WARN: Type inference failed for: r8v12 */
    /* JADX WARN: Type inference failed for: r8v2, types: [n0.l] */
    /* JADX WARN: Type inference failed for: r8v4 */
    /* JADX WARN: Type inference failed for: r8v5, types: [n0.l] */
    /* JADX WARN: Type inference failed for: r8v6, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r8v7 */
    /* JADX WARN: Type inference failed for: r8v8 */
    /* JADX WARN: Type inference failed for: r8v9 */
    public final void c() {
        d0.e eVar = this.f1793a;
        Object[] objArr = eVar.f2749f;
        int i2 = eVar.f2751h;
        for (int i10 = 0; i10 < i2; i10++) {
            ((d) objArr[i10]).c();
        }
        i1.k kVarE = this.f1785c;
        ?? eVar2 = 0;
        while (kVarE != 0) {
            if (kVarE instanceof p1) {
                ((p1) kVarE).M();
            } else if ((kVarE.f6799h & 16) != 0 && (kVarE instanceof i1.k)) {
                n0.l lVar = kVarE.f4514u;
                int i11 = 0;
                eVar2 = eVar2;
                kVarE = kVarE;
                while (lVar != null) {
                    if ((lVar.f6799h & 16) != 0) {
                        i11++;
                        eVar2 = eVar2;
                        if (i11 == 1) {
                            kVarE = lVar;
                        } else {
                            if (eVar2 == 0) {
                                eVar2 = new d0.e(new n0.l[16]);
                            }
                            if (kVarE != 0) {
                                eVar2.b(kVarE);
                                kVarE = 0;
                            }
                            eVar2.b(lVar);
                        }
                    }
                    lVar = lVar.f6802k;
                    eVar2 = eVar2;
                    kVarE = kVarE;
                }
                if (i11 == 1) {
                }
            }
            kVarE = i1.l.e(eVar2);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:4:0x000a  */
    /* JADX WARN: Type inference failed for: r7v0 */
    /* JADX WARN: Type inference failed for: r7v1, types: [n0.l] */
    /* JADX WARN: Type inference failed for: r7v10 */
    /* JADX WARN: Type inference failed for: r7v11 */
    /* JADX WARN: Type inference failed for: r7v3 */
    /* JADX WARN: Type inference failed for: r7v4, types: [n0.l] */
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
    /* JADX WARN: Type inference failed for: r8v3, types: [d0.e] */
    /* JADX WARN: Type inference failed for: r8v4 */
    /* JADX WARN: Type inference failed for: r8v5 */
    /* JADX WARN: Type inference failed for: r8v6, types: [d0.e] */
    /* JADX WARN: Type inference failed for: r8v8 */
    /* JADX WARN: Type inference failed for: r8v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean d(q6.b r15) {
        /*
            r14 = this;
            k.n r0 = r14.f1787e
            int r1 = r0.c()
            r2 = 0
            r3 = 0
            if (r1 != 0) goto Ld
        La:
            r9 = r3
            goto L83
        Ld:
            n0.l r1 = r14.f1785c
            boolean r4 = r1.f6810s
            if (r4 != 0) goto L14
            goto La
        L14:
            c1.f r4 = r14.f1789g
            q7.k.b(r4)
            i1.d1 r5 = r14.f1788f
            q7.k.b(r5)
            long r5 = r5.f3758h
            r7 = r1
            r8 = r2
        L22:
            r9 = 1
            if (r7 == 0) goto L6c
            boolean r10 = r7 instanceof i1.p1
            if (r10 == 0) goto L31
            i1.p1 r7 = (i1.p1) r7
            c1.g r9 = c1.g.f1799h
            r7.C(r4, r9, r5)
            goto L67
        L31:
            int r10 = r7.f6799h
            r11 = 16
            r10 = r10 & r11
            if (r10 == 0) goto L67
            boolean r10 = r7 instanceof i1.k
            if (r10 == 0) goto L67
            r10 = r7
            i1.k r10 = (i1.k) r10
            n0.l r10 = r10.f4514u
            r12 = r3
        L42:
            if (r10 == 0) goto L64
            int r13 = r10.f6799h
            r13 = r13 & r11
            if (r13 == 0) goto L61
            int r12 = r12 + 1
            if (r12 != r9) goto L4f
            r7 = r10
            goto L61
        L4f:
            if (r8 != 0) goto L58
            d0.e r8 = new d0.e
            n0.l[] r13 = new n0.l[r11]
            r8.<init>(r13)
        L58:
            if (r7 == 0) goto L5e
            r8.b(r7)
            r7 = r2
        L5e:
            r8.b(r10)
        L61:
            n0.l r10 = r10.f6802k
            goto L42
        L64:
            if (r12 != r9) goto L67
            goto L22
        L67:
            n0.l r7 = i1.l.e(r8)
            goto L22
        L6c:
            boolean r1 = r1.f6810s
            if (r1 == 0) goto L83
            d0.e r1 = r14.f1793a
            java.lang.Object[] r4 = r1.f2749f
            int r1 = r1.f2751h
            r5 = r3
        L77:
            if (r5 >= r1) goto L83
            r6 = r4[r5]
            c1.d r6 = (c1.d) r6
            r6.d(r15)
            int r5 = r5 + 1
            goto L77
        L83:
            r14.b(r15)
            int r15 = r0.f5510i
            java.lang.Object[] r1 = r0.f5509h
            r4 = r3
        L8b:
            if (r4 >= r15) goto L92
            r1[r4] = r2
            int r4 = r4 + 1
            goto L8b
        L92:
            r0.f5510i = r3
            r0.f5507f = r3
            r14.f1788f = r2
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: c1.d.d(q6.b):boolean");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v2, types: [n0.l] */
    /* JADX WARN: Type inference failed for: r0v3, types: [n0.l] */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v6, types: [n0.l] */
    /* JADX WARN: Type inference failed for: r0v7, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r13v10 */
    /* JADX WARN: Type inference failed for: r13v11 */
    /* JADX WARN: Type inference failed for: r13v12 */
    /* JADX WARN: Type inference failed for: r13v13 */
    /* JADX WARN: Type inference failed for: r13v2 */
    /* JADX WARN: Type inference failed for: r13v3 */
    /* JADX WARN: Type inference failed for: r13v4 */
    /* JADX WARN: Type inference failed for: r13v5, types: [d0.e] */
    /* JADX WARN: Type inference failed for: r13v6 */
    /* JADX WARN: Type inference failed for: r13v7 */
    /* JADX WARN: Type inference failed for: r13v8, types: [d0.e] */
    /* JADX WARN: Type inference failed for: r6v0 */
    /* JADX WARN: Type inference failed for: r6v1, types: [n0.l] */
    /* JADX WARN: Type inference failed for: r6v10, types: [n0.l] */
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
    /* JADX WARN: Type inference failed for: r7v4, types: [d0.e] */
    /* JADX WARN: Type inference failed for: r7v5 */
    /* JADX WARN: Type inference failed for: r7v6 */
    /* JADX WARN: Type inference failed for: r7v7, types: [d0.e] */
    /* JADX WARN: Type inference failed for: r7v9 */
    public final boolean e(q6.b bVar, boolean z4) {
        if (this.f1787e.c() == 0) {
            return false;
        }
        i1.k kVarE = this.f1785c;
        if (!kVarE.f6810s) {
            return false;
        }
        f fVar = this.f1789g;
        q7.k.b(fVar);
        d1 d1Var = this.f1788f;
        q7.k.b(d1Var);
        long j2 = d1Var.f3758h;
        i1.k kVarE2 = kVarE;
        ?? eVar = 0;
        while (kVarE2 != 0) {
            if (kVarE2 instanceof p1) {
                ((p1) kVarE2).C(fVar, g.f1797f, j2);
            } else if ((kVarE2.f6799h & 16) != 0 && (kVarE2 instanceof i1.k)) {
                n0.l lVar = kVarE2.f4514u;
                int i2 = 0;
                kVarE2 = kVarE2;
                eVar = eVar;
                while (lVar != null) {
                    if ((lVar.f6799h & 16) != 0) {
                        i2++;
                        eVar = eVar;
                        if (i2 == 1) {
                            kVarE2 = lVar;
                        } else {
                            if (eVar == 0) {
                                eVar = new d0.e(new n0.l[16]);
                            }
                            if (kVarE2 != 0) {
                                eVar.b(kVarE2);
                                kVarE2 = 0;
                            }
                            eVar.b(lVar);
                        }
                    }
                    lVar = lVar.f6802k;
                    kVarE2 = kVarE2;
                    eVar = eVar;
                }
                if (i2 == 1) {
                }
            }
            kVarE2 = i1.l.e(eVar);
        }
        if (kVarE.f6810s) {
            d0.e eVar2 = this.f1793a;
            Object[] objArr = eVar2.f2749f;
            int i10 = eVar2.f2751h;
            for (int i11 = 0; i11 < i10; i11++) {
                d dVar = (d) objArr[i11];
                q7.k.b(this.f1788f);
                dVar.e(bVar, z4);
            }
        }
        if (kVarE.f6810s) {
            ?? eVar3 = 0;
            while (kVarE != 0) {
                if (kVarE instanceof p1) {
                    ((p1) kVarE).C(fVar, g.f1798g, j2);
                } else if ((kVarE.f6799h & 16) != 0 && (kVarE instanceof i1.k)) {
                    n0.l lVar2 = kVarE.f4514u;
                    int i12 = 0;
                    kVarE = kVarE;
                    eVar3 = eVar3;
                    while (lVar2 != null) {
                        if ((lVar2.f6799h & 16) != 0) {
                            i12++;
                            eVar3 = eVar3;
                            if (i12 == 1) {
                                kVarE = lVar2;
                            } else {
                                if (eVar3 == 0) {
                                    eVar3 = new d0.e(new n0.l[16]);
                                }
                                if (kVarE != 0) {
                                    eVar3.b(kVarE);
                                    kVarE = 0;
                                }
                                eVar3.b(lVar2);
                            }
                        }
                        lVar2 = lVar2.f6802k;
                        kVarE = kVarE;
                        eVar3 = eVar3;
                    }
                    if (i12 == 1) {
                    }
                }
                kVarE = i1.l.e(eVar3);
            }
        }
        return true;
    }

    public final void f(long j2, z zVar) {
        d1.b bVar = this.f1786d;
        if (bVar.e(j2) && zVar.f(this) < 0) {
            bVar.i(j2);
            k.n nVar = this.f1787e;
            int iB = l.a.b(nVar.f5508g, nVar.f5510i, j2);
            if (iB >= 0) {
                Object[] objArr = nVar.f5509h;
                Object obj = objArr[iB];
                Object obj2 = k.o.f5511a;
                if (obj != obj2) {
                    objArr[iB] = obj2;
                    nVar.f5507f = true;
                }
            }
        }
        d0.e eVar = this.f1793a;
        Object[] objArr2 = eVar.f2749f;
        int i2 = eVar.f2751h;
        for (int i10 = 0; i10 < i2; i10++) {
            ((d) objArr2[i10]).f(j2, zVar);
        }
    }

    public final String toString() {
        return "Node(modifierNode=" + this.f1785c + ", children=" + this.f1793a + ", pointerIds=" + this.f1786d + ')';
    }
}
