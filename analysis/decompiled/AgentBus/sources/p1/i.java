package p1;

import java.util.Iterator;
import k.a0;
import k.g0;

/* loaded from: classes.dex */
public final class i implements Iterable, r7.a {

    /* renamed from: f, reason: collision with root package name */
    public final a0 f8304f;

    /* renamed from: g, reason: collision with root package name */
    public k.q f8305g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f8306h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f8307i;

    public i() {
        long[] jArr = g0.f5491a;
        this.f8304f = new a0();
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x005d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final p1.i a() {
        /*
            r17 = this;
            r0 = r17
            p1.i r1 = new p1.i
            r1.<init>()
            boolean r2 = r0.f8306h
            r1.f8306h = r2
            boolean r2 = r0.f8307i
            r1.f8307i = r2
            k.a0 r2 = r1.f8304f
            r2.getClass()
            java.lang.String r3 = "from"
            k.a0 r0 = r0.f8304f
            q7.k.e(r0, r3)
            java.lang.Object[] r3 = r0.f5447b
            java.lang.Object[] r4 = r0.f5448c
            long[] r0 = r0.f5446a
            int r5 = r0.length
            int r5 = r5 + (-2)
            if (r5 < 0) goto L62
            r6 = 0
            r7 = r6
        L28:
            r8 = r0[r7]
            long r10 = ~r8
            r12 = 7
            long r10 = r10 << r12
            long r10 = r10 & r8
            r12 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r10 = r10 & r12
            int r10 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r10 == 0) goto L5d
            int r10 = r7 - r5
            int r10 = ~r10
            int r10 = r10 >>> 31
            r11 = 8
            int r10 = 8 - r10
            r12 = r6
        L42:
            if (r12 >= r10) goto L5b
            r13 = 255(0xff, double:1.26E-321)
            long r13 = r13 & r8
            r15 = 128(0x80, double:6.3E-322)
            int r13 = (r13 > r15 ? 1 : (r13 == r15 ? 0 : -1))
            if (r13 >= 0) goto L57
            int r13 = r7 << 3
            int r13 = r13 + r12
            r14 = r3[r13]
            r13 = r4[r13]
            r2.l(r14, r13)
        L57:
            long r8 = r8 >> r11
            int r12 = r12 + 1
            goto L42
        L5b:
            if (r10 != r11) goto L62
        L5d:
            if (r7 == r5) goto L62
            int r7 = r7 + 1
            goto L28
        L62:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: p1.i.a():p1.i");
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof i)) {
            return false;
        }
        i iVar = (i) obj;
        return q7.k.a(this.f8304f, iVar.f8304f) && this.f8306h == iVar.f8306h && this.f8307i == iVar.f8307i;
    }

    public final Object f(v vVar) {
        Object objG = this.f8304f.g(vVar);
        if (objG != null) {
            return objG;
        }
        throw new IllegalStateException("Key not present: " + vVar + " - consider getOrElse or getOrNull");
    }

    public final void h(i iVar) {
        a0 a0Var = iVar.f8304f;
        Object[] objArr = a0Var.f5447b;
        Object[] objArr2 = a0Var.f5448c;
        long[] jArr = a0Var.f5446a;
        int length = jArr.length - 2;
        if (length < 0) {
            return;
        }
        int i2 = 0;
        while (true) {
            long j2 = jArr[i2];
            if ((((~j2) << 7) & j2 & (-9187201950435737472L)) != -9187201950435737472L) {
                int i10 = 8 - ((~(i2 - length)) >>> 31);
                for (int i11 = 0; i11 < i10; i11++) {
                    if ((255 & j2) < 128) {
                        int i12 = (i2 << 3) + i11;
                        Object obj = objArr[i12];
                        Object obj2 = objArr2[i12];
                        v vVar = (v) obj;
                        a0 a0Var2 = this.f8304f;
                        Object objG = a0Var2.g(vVar);
                        q7.k.c(vVar, "null cannot be cast to non-null type androidx.compose.ui.semantics.SemanticsPropertyKey<kotlin.Any?>");
                        Object objInvoke = vVar.f8374b.invoke(objG, obj2);
                        if (objInvoke != null) {
                            a0Var2.l(vVar, objInvoke);
                        }
                    }
                    j2 >>= 8;
                }
                if (i10 != 8) {
                    return;
                }
            }
            if (i2 == length) {
                return;
            } else {
                i2++;
            }
        }
    }

    public final int hashCode() {
        return Boolean.hashCode(this.f8307i) + m.x.e(this.f8304f.hashCode() * 31, 31, this.f8306h);
    }

    public final void i(v vVar, Object obj) {
        boolean z4 = obj instanceof a;
        a0 a0Var = this.f8304f;
        if (z4 && a0Var.c(vVar)) {
            Object objG = a0Var.g(vVar);
            q7.k.c(objG, "null cannot be cast to non-null type androidx.compose.ui.semantics.AccessibilityAction<*>");
            a aVar = (a) objG;
            a aVar2 = (a) obj;
            String str = aVar2.f8266a;
            if (str == null) {
                str = aVar.f8266a;
            }
            c7.c cVar = aVar2.f8267b;
            if (cVar == null) {
                cVar = aVar.f8267b;
            }
            a0Var.l(vVar, new a(str, cVar));
        } else {
            a0Var.l(vVar, obj);
        }
        vVar.getClass();
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        k.q qVar = this.f8305g;
        if (qVar == null) {
            a0 a0Var = this.f8304f;
            a0Var.getClass();
            k.q qVar2 = new k.q(a0Var);
            this.f8305g = qVar2;
            qVar = qVar2;
        }
        return ((k.g) qVar.entrySet()).iterator();
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
            boolean r2 = r0.f8306h
            java.lang.String r3 = ", "
            if (r2 == 0) goto L14
            java.lang.String r2 = "mergeDescendants=true"
            r1.append(r2)
            r2 = r3
            goto L16
        L14:
            java.lang.String r2 = ""
        L16:
            boolean r4 = r0.f8307i
            if (r4 == 0) goto L23
            r1.append(r2)
            java.lang.String r2 = "isClearingSemantics=true"
            r1.append(r2)
            r2 = r3
        L23:
            k.a0 r4 = r0.f8304f
            java.lang.Object[] r5 = r4.f5447b
            java.lang.Object[] r6 = r4.f5448c
            long[] r4 = r4.f5446a
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
            p1.v r8 = (p1.v) r8
            r1.append(r2)
            java.lang.String r2 = r8.f8373a
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
            java.lang.String r0 = j1.k0.s(r0)
            r2.append(r0)
            java.lang.String r0 = "{ "
            r2.append(r0)
            r2.append(r1)
            java.lang.String r0 = " }"
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p1.i.toString():java.lang.String");
    }
}
