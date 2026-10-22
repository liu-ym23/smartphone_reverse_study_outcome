package nc;

import java.lang.invoke.VarHandle;
import java.util.Arrays;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public class j0 extends oc.b implements g0, h, g, oc.r {
    public final int i;

    /* renamed from: j, reason: collision with root package name */
    public final int f8860j;

    /* renamed from: k, reason: collision with root package name */
    public final mc.a f8861k;

    /* renamed from: l, reason: collision with root package name */
    public Object[] f8862l;

    /* renamed from: m, reason: collision with root package name */
    public long f8863m;

    /* renamed from: n, reason: collision with root package name */
    public long f8864n;

    /* renamed from: o, reason: collision with root package name */
    public int f8865o;

    /* renamed from: p, reason: collision with root package name */
    public int f8866p;

    public j0(int i, int i3, mc.a aVar) {
        this.i = i;
        this.f8860j = i3;
        this.f8861k = aVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:34:0x007f A[Catch: all -> 0x0038, TryCatch #0 {all -> 0x0038, blocks: (B:15:0x0031, B:32:0x0077, B:34:0x007f, B:38:0x0092, B:41:0x0099, B:42:0x009d, B:43:0x009e, B:22:0x0049), top: B:50:0x0020 }] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0090 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r5v1, types: [oc.b] */
    /* JADX WARN: Type inference failed for: r5v12 */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v4, types: [nc.j0] */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v7 */
    /* JADX WARN: Type inference failed for: r9v0, types: [nc.h] */
    /* JADX WARN: Type inference failed for: r9v1 */
    /* JADX WARN: Type inference failed for: r9v15 */
    /* JADX WARN: Type inference failed for: r9v16 */
    /* JADX WARN: Type inference failed for: r9v17 */
    /* JADX WARN: Type inference failed for: r9v2, types: [oc.d] */
    /* JADX WARN: Type inference failed for: r9v3 */
    /* JADX WARN: Type inference failed for: r9v4 */
    /* JADX WARN: Type inference failed for: r9v5, types: [nc.l0] */
    /* JADX WARN: Type inference failed for: r9v8, types: [nc.l0] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:44:0x00ac -> B:16:0x0034). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void i(nc.j0 r8, nc.h r9, nb.c r10) throws java.lang.Throwable {
        /*
            boolean r0 = r10 instanceof nc.i0
            if (r0 == 0) goto L13
            r0 = r10
            nc.i0 r0 = (nc.i0) r0
            int r1 = r0.f8856k
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f8856k = r1
            goto L18
        L13:
            nc.i0 r0 = new nc.i0
            r0.<init>(r8, r10)
        L18:
            java.lang.Object r10 = r0.i
            ob.a r1 = ob.a.f9351c
            int r2 = r0.f8856k
            r3 = 3
            r4 = 2
            if (r2 == 0) goto L5c
            r8 = 1
            if (r2 == r8) goto L4d
            if (r2 == r4) goto L41
            if (r2 != r3) goto L3b
            kc.x0 r8 = r0.f8854h
            nc.l0 r9 = r0.f8853g
            nc.h r2 = r0.f8852f
            nc.j0 r5 = r0.f8851c
            id.c.I(r10)     // Catch: java.lang.Throwable -> L38
        L34:
            r10 = r2
            r2 = r8
            r8 = r5
            goto L74
        L38:
            r8 = move-exception
            goto Lb2
        L3b:
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            od.f.e(r8)
            return
        L41:
            kc.x0 r8 = r0.f8854h
            nc.l0 r9 = r0.f8853g
            nc.h r2 = r0.f8852f
            nc.j0 r5 = r0.f8851c
            id.c.I(r10)     // Catch: java.lang.Throwable -> L38
            goto L77
        L4d:
            nc.l0 r9 = r0.f8853g
            nc.h r8 = r0.f8852f
            nc.j0 r2 = r0.f8851c
            id.c.I(r10)     // Catch: java.lang.Throwable -> L59
            r10 = r8
            r8 = r2
            goto L68
        L59:
            r8 = move-exception
            r5 = r2
            goto Lb2
        L5c:
            id.c.I(r10)
            oc.d r10 = r8.b()
            nc.l0 r10 = (nc.l0) r10
            r7 = r10
            r10 = r9
            r9 = r7
        L68:
            nb.g r2 = r0.getContext()     // Catch: java.lang.Throwable -> Laf
            kc.w0 r5 = kc.w0.f7498c     // Catch: java.lang.Throwable -> Laf
            nb.e r2 = r2.get(r5)     // Catch: java.lang.Throwable -> Laf
            kc.x0 r2 = (kc.x0) r2     // Catch: java.lang.Throwable -> Laf
        L74:
            r5 = r8
            r8 = r2
            r2 = r10
        L77:
            java.lang.Object r10 = r5.r(r9)     // Catch: java.lang.Throwable -> L38
            pc.t r6 = nc.k0.f8871a     // Catch: java.lang.Throwable -> L38
            if (r10 != r6) goto L90
            r0.f8851c = r5     // Catch: java.lang.Throwable -> L38
            r0.f8852f = r2     // Catch: java.lang.Throwable -> L38
            r0.f8853g = r9     // Catch: java.lang.Throwable -> L38
            r0.f8854h = r8     // Catch: java.lang.Throwable -> L38
            r0.f8856k = r4     // Catch: java.lang.Throwable -> L38
            java.lang.Object r10 = r5.g(r9, r0)     // Catch: java.lang.Throwable -> L38
            if (r10 != r1) goto L77
            goto Lae
        L90:
            if (r8 == 0) goto L9e
            boolean r6 = r8.d()     // Catch: java.lang.Throwable -> L38
            if (r6 == 0) goto L99
            goto L9e
        L99:
            java.util.concurrent.CancellationException r8 = r8.o()     // Catch: java.lang.Throwable -> L38
            throw r8     // Catch: java.lang.Throwable -> L38
        L9e:
            r0.f8851c = r5     // Catch: java.lang.Throwable -> L38
            r0.f8852f = r2     // Catch: java.lang.Throwable -> L38
            r0.f8853g = r9     // Catch: java.lang.Throwable -> L38
            r0.f8854h = r8     // Catch: java.lang.Throwable -> L38
            r0.f8856k = r3     // Catch: java.lang.Throwable -> L38
            java.lang.Object r10 = r2.emit(r10, r0)     // Catch: java.lang.Throwable -> L38
            if (r10 != r1) goto L34
        Lae:
            return
        Laf:
            r10 = move-exception
            r5 = r8
            r8 = r10
        Lb2:
            r5.e(r9)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: nc.j0.i(nc.j0, nc.h, nb.c):void");
    }

    @Override // oc.r
    public final g a(nb.g gVar, int i, mc.a aVar) {
        return k0.l(this, gVar, i, aVar);
    }

    @Override // oc.b
    public final oc.d c() {
        l0 l0Var = new l0();
        l0Var.f8876a = -1L;
        return l0Var;
    }

    @Override // nc.g
    public final Object collect(h hVar, nb.c cVar) throws Throwable {
        i(this, hVar, cVar);
        return ob.a.f9351c;
    }

    @Override // oc.b
    public final oc.d[] d() {
        return new l0[2];
    }

    @Override // nc.h
    public final Object emit(Object obj, nb.c cVar) {
        nb.c[] cVarArrL;
        h0 h0Var;
        if (o(obj)) {
            return jb.v.f6774a;
        }
        kc.g gVar = new kc.g(1, td.h.y(cVar));
        gVar.s();
        nb.c[] cVarArrL2 = oc.c.f9366a;
        synchronized (this) {
            try {
                if (p(obj)) {
                    gVar.resumeWith(jb.v.f6774a);
                    cVarArrL = l(cVarArrL2);
                    h0Var = null;
                } else {
                    long jM = m() + this.f8865o + this.f8866p;
                    h0 h0Var2 = new h0();
                    h0Var2.f8842c = this;
                    h0Var2.f8843f = jM;
                    h0Var2.f8844g = obj;
                    h0Var2.f8845h = gVar;
                    VarHandle.storeStoreFence();
                    k(h0Var2);
                    this.f8866p++;
                    if (this.f8860j == 0) {
                        cVarArrL2 = l(cVarArrL2);
                    }
                    cVarArrL = cVarArrL2;
                    h0Var = h0Var2;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (h0Var != null) {
            kc.w.h(gVar, h0Var);
        }
        for (nb.c cVar2 : cVarArrL) {
            if (cVar2 != null) {
                cVar2.resumeWith(jb.v.f6774a);
            }
        }
        Object objR = gVar.r();
        ob.a aVar = ob.a.f9351c;
        if (objR != aVar) {
            objR = jb.v.f6774a;
        }
        return objR == aVar ? objR : jb.v.f6774a;
    }

    public final Object g(l0 l0Var, i0 i0Var) {
        kc.g gVar = new kc.g(1, td.h.y(i0Var));
        gVar.s();
        synchronized (this) {
            try {
                if (q(l0Var) < 0) {
                    l0Var.f8877b = gVar;
                } else {
                    gVar.resumeWith(jb.v.f6774a);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        Object objR = gVar.r();
        return objR == ob.a.f9351c ? objR : jb.v.f6774a;
    }

    public final void h() {
        if (this.f8860j != 0 || this.f8866p > 1) {
            Object[] objArr = this.f8862l;
            objArr.getClass();
            while (this.f8866p > 0) {
                long jM = m();
                int i = this.f8865o;
                int i3 = this.f8866p;
                if (objArr[((int) ((jM + (i + i3)) - 1)) & (objArr.length - 1)] != k0.f8871a) {
                    return;
                }
                this.f8866p = i3 - 1;
                k0.c(objArr, m() + this.f8865o + this.f8866p, null);
            }
        }
    }

    public final void j() {
        oc.d[] dVarArr;
        Object[] objArr = this.f8862l;
        objArr.getClass();
        k0.c(objArr, m(), null);
        this.f8865o--;
        long jM = m() + 1;
        if (this.f8863m < jM) {
            this.f8863m = jM;
        }
        if (this.f8864n < jM) {
            if (this.f9363f != 0 && (dVarArr = this.f9362c) != null) {
                for (oc.d dVar : dVarArr) {
                    if (dVar != null) {
                        l0 l0Var = (l0) dVar;
                        long j10 = l0Var.f8876a;
                        if (j10 >= 0 && j10 < jM) {
                            l0Var.f8876a = jM;
                        }
                    }
                }
            }
            this.f8864n = jM;
        }
    }

    public final void k(Object obj) {
        int i = this.f8865o + this.f8866p;
        Object[] objArrN = this.f8862l;
        if (objArrN == null) {
            objArrN = n(null, 0, 2);
        } else if (i >= objArrN.length) {
            objArrN = n(objArrN, i, objArrN.length * 2);
        }
        k0.c(objArrN, m() + i, obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final nb.c[] l(nb.c[] cVarArr) {
        oc.d[] dVarArr;
        l0 l0Var;
        kc.g gVar;
        int length = cVarArr.length;
        if (this.f9363f != 0 && (dVarArr = this.f9362c) != null) {
            int length2 = dVarArr.length;
            int i = 0;
            cVarArr = cVarArr;
            while (i < length2) {
                oc.d dVar = dVarArr[i];
                if (dVar != null && (gVar = (l0Var = (l0) dVar).f8877b) != null && q(l0Var) >= 0) {
                    int length3 = cVarArr.length;
                    cVarArr = cVarArr;
                    if (length >= length3) {
                        cVarArr = Arrays.copyOf(cVarArr, Math.max(2, cVarArr.length * 2));
                    }
                    cVarArr[length] = gVar;
                    l0Var.f8877b = null;
                    length++;
                }
                i++;
                cVarArr = cVarArr;
            }
        }
        return cVarArr;
    }

    public final long m() {
        return Math.min(this.f8864n, this.f8863m);
    }

    public final Object[] n(Object[] objArr, int i, int i3) {
        if (i3 <= 0) {
            od.f.e("Buffer size overflow");
            return null;
        }
        Object[] objArr2 = new Object[i3];
        this.f8862l = objArr2;
        if (objArr != null) {
            long jM = m();
            for (int i10 = 0; i10 < i; i10++) {
                long j10 = i10 + jM;
                k0.c(objArr2, j10, objArr[((int) j10) & (objArr.length - 1)]);
            }
        }
        return objArr2;
    }

    public final boolean o(Object obj) {
        int i;
        boolean z10;
        nb.c[] cVarArrL = oc.c.f9366a;
        synchronized (this) {
            if (p(obj)) {
                cVarArrL = l(cVarArrL);
                z10 = true;
            } else {
                z10 = false;
            }
        }
        for (nb.c cVar : cVarArrL) {
            if (cVar != null) {
                cVar.resumeWith(jb.v.f6774a);
            }
        }
        return z10;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0046  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean p(java.lang.Object r13) {
        /*
            r12 = this;
            int r1 = r12.f9363f
            int r2 = r12.i
            r9 = 1
            if (r1 != 0) goto L23
            if (r2 != 0) goto Lb
            goto L7e
        Lb:
            r12.k(r13)
            int r1 = r12.f8865o
            int r1 = r1 + r9
            r12.f8865o = r1
            if (r1 <= r2) goto L18
            r12.j()
        L18:
            long r1 = r12.m()
            int r3 = r12.f8865o
            long r3 = (long) r3
            long r1 = r1 + r3
            r12.f8864n = r1
            return r9
        L23:
            int r1 = r12.f8865o
            int r3 = r12.f8860j
            if (r1 < r3) goto L46
            long r4 = r12.f8864n
            long r6 = r12.f8863m
            int r1 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r1 > 0) goto L46
            mc.a r1 = r12.f8861k
            int r1 = r1.ordinal()
            if (r1 == 0) goto L44
            if (r1 == r9) goto L46
            r0 = 2
            if (r1 != r0) goto L3f
            goto L7e
        L3f:
            g5.f.a()
            r0 = 0
            return r0
        L44:
            r0 = 0
            return r0
        L46:
            r12.k(r13)
            int r1 = r12.f8865o
            int r1 = r1 + r9
            r12.f8865o = r1
            if (r1 <= r3) goto L53
            r12.j()
        L53:
            long r3 = r12.m()
            int r1 = r12.f8865o
            long r5 = (long) r1
            long r3 = r3 + r5
            long r5 = r12.f8863m
            long r3 = r3 - r5
            int r1 = (int) r3
            if (r1 <= r2) goto L7e
            r1 = 1
            long r1 = r1 + r5
            long r3 = r12.f8864n
            long r5 = r12.m()
            int r7 = r12.f8865o
            long r7 = (long) r7
            long r5 = r5 + r7
            long r7 = r12.m()
            int r10 = r12.f8865o
            long r10 = (long) r10
            long r7 = r7 + r10
            int r10 = r12.f8866p
            long r10 = (long) r10
            long r7 = r7 + r10
            r0 = r12
            r0.s(r1, r3, r5, r7)
        L7e:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: nc.j0.p(java.lang.Object):boolean");
    }

    public final long q(l0 l0Var) {
        long j10 = l0Var.f8876a;
        if (j10 >= m() + this.f8865o && (this.f8860j > 0 || j10 > m() || this.f8866p == 0)) {
            return -1L;
        }
        return j10;
    }

    public final Object r(l0 l0Var) {
        Object obj;
        nb.c[] cVarArrT = oc.c.f9366a;
        synchronized (this) {
            try {
                long jQ = q(l0Var);
                if (jQ < 0) {
                    obj = k0.f8871a;
                } else {
                    long j10 = l0Var.f8876a;
                    Object[] objArr = this.f8862l;
                    objArr.getClass();
                    Object obj2 = objArr[((int) jQ) & (objArr.length - 1)];
                    if (obj2 instanceof h0) {
                        obj2 = ((h0) obj2).f8844g;
                    }
                    l0Var.f8876a = jQ + 1;
                    Object obj3 = obj2;
                    cVarArrT = t(j10);
                    obj = obj3;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        for (nb.c cVar : cVarArrT) {
            if (cVar != null) {
                cVar.resumeWith(jb.v.f6774a);
            }
        }
        return obj;
    }

    public final void s(long j10, long j11, long j12, long j13) {
        long jMin = Math.min(j11, j10);
        for (long jM = m(); jM < jMin; jM++) {
            Object[] objArr = this.f8862l;
            objArr.getClass();
            k0.c(objArr, jM, null);
        }
        this.f8863m = j10;
        this.f8864n = j11;
        this.f8865o = (int) (j12 - jMin);
        this.f8866p = (int) (j13 - j12);
    }

    public final nb.c[] t(long j10) {
        long j11;
        long j12;
        long j13;
        nb.c[] cVarArr;
        nb.c[] cVarArr2;
        oc.d[] dVarArr;
        pc.t tVar = k0.f8871a;
        nb.c[] cVarArr3 = oc.c.f9366a;
        if (j10 <= this.f8864n) {
            long jM = m();
            long j14 = this.f8865o + jM;
            int i = this.f8860j;
            if (i == 0 && this.f8866p > 0) {
                j14++;
            }
            int i3 = 0;
            if (this.f9363f != 0 && (dVarArr = this.f9362c) != null) {
                for (oc.d dVar : dVarArr) {
                    if (dVar != null) {
                        long j15 = ((l0) dVar).f8876a;
                        if (j15 >= 0 && j15 < j14) {
                            j14 = j15;
                        }
                    }
                }
            }
            if (j14 > this.f8864n) {
                long jM2 = m() + this.f8865o;
                int i10 = this.f9363f;
                int iMin = this.f8866p;
                if (i10 > 0) {
                    j11 = 1;
                    iMin = Math.min(iMin, i - ((int) (jM2 - j14)));
                } else {
                    j11 = 1;
                }
                long j16 = this.f8866p + jM2;
                if (iMin > 0) {
                    Object[] objArr = this.f8862l;
                    objArr.getClass();
                    j12 = jM;
                    nb.c[] cVarArr4 = new nb.c[iMin];
                    long j17 = jM2;
                    while (true) {
                        if (jM2 >= j16) {
                            cVarArr2 = cVarArr4;
                            j13 = j14;
                            break;
                        }
                        cVarArr2 = cVarArr4;
                        Object obj = objArr[((int) jM2) & (objArr.length - 1)];
                        if (obj != tVar) {
                            obj.getClass();
                            h0 h0Var = (h0) obj;
                            j13 = j14;
                            int i11 = i3 + 1;
                            cVarArr2[i3] = h0Var.f8845h;
                            k0.c(objArr, jM2, tVar);
                            k0.c(objArr, j17, h0Var.f8844g);
                            j17 += j11;
                            if (i11 >= iMin) {
                                break;
                            }
                            i3 = i11;
                        } else {
                            j13 = j14;
                        }
                        jM2 += j11;
                        cVarArr4 = cVarArr2;
                        j14 = j13;
                    }
                    jM2 = j17;
                    cVarArr = cVarArr2;
                } else {
                    j12 = jM;
                    j13 = j14;
                    cVarArr = cVarArr3;
                }
                int i12 = (int) (jM2 - j12);
                long j18 = this.f9363f == 0 ? jM2 : j13;
                long jMax = Math.max(this.f8863m, jM2 - Math.min(this.i, i12));
                if (i == 0 && jMax < j16) {
                    Object[] objArr2 = this.f8862l;
                    objArr2.getClass();
                    if (yb.k.a(objArr2[((int) jMax) & (objArr2.length - 1)], tVar)) {
                        jM2 += j11;
                        jMax += j11;
                    }
                }
                s(jMax, j18, jM2, j16);
                h();
                return cVarArr.length == 0 ? cVarArr : l(cVarArr);
            }
        }
        return cVarArr3;
    }
}
