package a2;

import java.lang.invoke.VarHandle;
import java.util.Iterator;
import p.f0;
import p.n0;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class k implements Iterable, zb.a {

    /* renamed from: c, reason: collision with root package name */
    public final f0 f75c;

    /* renamed from: f, reason: collision with root package name */
    public p.r f76f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f77g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f78h;

    public k() {
        long[] jArr = n0.f9597a;
        this.f75c = new f0();
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x005b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final a2.k a() {
        /*
            r17 = this;
            r0 = r17
            a2.k r1 = new a2.k
            r1.<init>()
            boolean r2 = r0.f77g
            r1.f77g = r2
            boolean r2 = r0.f78h
            r1.f78h = r2
            p.f0 r2 = r1.f75c
            r2.getClass()
            p.f0 r0 = r0.f75c
            r0.getClass()
            java.lang.Object[] r3 = r0.f9553b
            java.lang.Object[] r4 = r0.f9554c
            long[] r0 = r0.f9552a
            int r5 = r0.length
            int r5 = r5 + (-2)
            if (r5 < 0) goto L60
            r6 = 0
            r7 = r6
        L26:
            r8 = r0[r7]
            long r10 = ~r8
            r12 = 7
            long r10 = r10 << r12
            long r10 = r10 & r8
            r12 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r10 = r10 & r12
            int r10 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r10 == 0) goto L5b
            int r10 = r7 - r5
            int r10 = ~r10
            int r10 = r10 >>> 31
            r11 = 8
            int r10 = 8 - r10
            r12 = r6
        L40:
            if (r12 >= r10) goto L59
            r13 = 255(0xff, double:1.26E-321)
            long r13 = r13 & r8
            r15 = 128(0x80, double:6.3E-322)
            int r13 = (r13 > r15 ? 1 : (r13 == r15 ? 0 : -1))
            if (r13 >= 0) goto L55
            int r13 = r7 << 3
            int r13 = r13 + r12
            r14 = r3[r13]
            r13 = r4[r13]
            r2.m(r14, r13)
        L55:
            long r8 = r8 >> r11
            int r12 = r12 + 1
            goto L40
        L59:
            if (r10 != r11) goto L60
        L5b:
            if (r7 == r5) goto L60
            int r7 = r7 + 1
            goto L26
        L60:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: a2.k.a():a2.k");
    }

    public final Object b(x xVar) {
        Object objG = this.f75c.g(xVar);
        if (objG != null) {
            return objG;
        }
        ad.o.f("Key not present: ", xVar, " - consider getOrElse or getOrNull");
        return null;
    }

    public final void c(k kVar) {
        f0 f0Var = kVar.f75c;
        Object[] objArr = f0Var.f9553b;
        Object[] objArr2 = f0Var.f9554c;
        long[] jArr = f0Var.f9552a;
        int length = jArr.length - 2;
        if (length < 0) {
            return;
        }
        int i = 0;
        while (true) {
            long j10 = jArr[i];
            if ((((~j10) << 7) & j10 & (-9187201950435737472L)) != -9187201950435737472L) {
                int i3 = 8 - ((~(i - length)) >>> 31);
                for (int i10 = 0; i10 < i3; i10++) {
                    if ((255 & j10) < 128) {
                        int i11 = (i << 3) + i10;
                        Object obj = objArr[i11];
                        Object obj2 = objArr2[i11];
                        x xVar = (x) obj;
                        f0 f0Var2 = this.f75c;
                        Object objG = f0Var2.g(xVar);
                        xVar.getClass();
                        Object objInvoke = xVar.f146b.invoke(objG, obj2);
                        if (objInvoke != null) {
                            f0Var2.m(xVar, objInvoke);
                        }
                    }
                    j10 >>= 8;
                }
                if (i3 != 8) {
                    return;
                }
            }
            if (i == length) {
                return;
            } else {
                i++;
            }
        }
    }

    public final void d(x xVar, Object obj) {
        boolean z10 = obj instanceof a;
        f0 f0Var = this.f75c;
        if (z10 && f0Var.c(xVar)) {
            Object objG = f0Var.g(xVar);
            objG.getClass();
            a aVar = (a) objG;
            a aVar2 = (a) obj;
            String str = aVar2.f29a;
            if (str == null) {
                str = aVar.f29a;
            }
            jb.b bVar = aVar2.f30b;
            if (bVar == null) {
                bVar = aVar.f30b;
            }
            f0Var.m(xVar, new a(str, bVar));
        } else {
            f0Var.m(xVar, obj);
        }
        xVar.getClass();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof k)) {
            return false;
        }
        k kVar = (k) obj;
        return yb.k.a(this.f75c, kVar.f75c) && this.f77g == kVar.f77g && this.f78h == kVar.f78h;
    }

    public final int hashCode() {
        return Boolean.hashCode(this.f78h) + k0.a.h(this.f75c.hashCode() * 31, 31, this.f77g);
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        p.r rVar = this.f76f;
        if (rVar == null) {
            f0 f0Var = this.f75c;
            f0Var.getClass();
            p.r rVar2 = new p.r();
            rVar2.f9617c = f0Var;
            VarHandle.storeStoreFence();
            this.f76f = rVar2;
            rVar = rVar2;
        }
        return ((p.g) rVar.entrySet()).iterator();
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0078 A[PHI: r2
      0x0078: PHI (r2v6 java.lang.String) = (r2v5 java.lang.String), (r2v7 java.lang.String) binds: [B:13:0x003f, B:20:0x0076] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String toString() {
        /*
            r19 = this;
            r0 = r19
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            boolean r2 = r0.f77g
            java.lang.String r3 = ", "
            if (r2 == 0) goto L14
            java.lang.String r2 = "mergeDescendants=true"
            r1.append(r2)
            r2 = r3
            goto L16
        L14:
            java.lang.String r2 = ""
        L16:
            boolean r4 = r0.f78h
            if (r4 == 0) goto L23
            r1.append(r2)
            java.lang.String r2 = "isClearingSemantics=true"
            r1.append(r2)
            r2 = r3
        L23:
            p.f0 r4 = r0.f75c
            java.lang.Object[] r5 = r4.f9553b
            java.lang.Object[] r6 = r4.f9554c
            long[] r4 = r4.f9552a
            int r7 = r4.length
            int r7 = r7 + (-2)
            if (r7 < 0) goto L7d
            r9 = 0
        L31:
            r10 = r4[r9]
            long r12 = ~r10
            r14 = 7
            long r12 = r12 << r14
            long r12 = r12 & r10
            r14 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r12 = r12 & r14
            int r12 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
            if (r12 == 0) goto L78
            int r12 = r9 - r7
            int r12 = ~r12
            int r12 = r12 >>> 31
            r13 = 8
            int r12 = 8 - r12
            r14 = 0
        L4b:
            if (r14 >= r12) goto L76
            r15 = 255(0xff, double:1.26E-321)
            long r15 = r15 & r10
            r17 = 128(0x80, double:6.3E-322)
            int r15 = (r15 > r17 ? 1 : (r15 == r17 ? 0 : -1))
            if (r15 >= 0) goto L72
            int r15 = r9 << 3
            int r15 = r15 + r14
            r16 = r5[r15]
            r15 = r6[r15]
            r8 = r16
            a2.x r8 = (a2.x) r8
            r1.append(r2)
            java.lang.String r2 = r8.f145a
            r1.append(r2)
            java.lang.String r2 = " : "
            r1.append(r2)
            r1.append(r15)
            r2 = r3
        L72:
            long r10 = r10 >> r13
            int r14 = r14 + 1
            goto L4b
        L76:
            if (r12 != r13) goto L7d
        L78:
            if (r9 == r7) goto L7d
            int r9 = r9 + 1
            goto L31
        L7d:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r0 = v1.g0.w(r0)
            r2.append(r0)
            java.lang.String r0 = "{ "
            r2.append(r0)
            r2.append(r1)
            java.lang.String r0 = " }"
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: a2.k.toString():java.lang.String");
    }
}
