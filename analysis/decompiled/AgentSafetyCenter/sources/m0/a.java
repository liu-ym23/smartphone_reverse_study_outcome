package m0;

import p.a0;
import p.f0;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public f0 f8151a;

    public static final Object a(f0 f0Var) {
        Object objG = f0Var.g(null);
        if (objG == null) {
            return null;
        }
        if (!(objG instanceof a0)) {
            f0Var.k(null);
            return objG;
        }
        a0 a0Var = (a0) objG;
        if (a0Var.g()) {
            g5.f.m("List is empty.");
            return null;
        }
        int i = a0Var.f9517b - 1;
        Object objE = a0Var.e(i);
        a0Var.j(i);
        objE.getClass();
        if (a0Var.g()) {
            f0Var.k(null);
        }
        if (a0Var.f9517b == 1) {
            f0Var.m(null, a0Var.d());
        }
        return objE;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x007f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final p.a0 b(p.f0 r15) {
        /*
            boolean r0 = r15.i()
            if (r0 == 0) goto Lc
            p.a0 r15 = p.k0.f9588b
            r15.getClass()
            return r15
        Lc:
            p.a0 r0 = new p.a0
            r0.<init>()
            java.lang.Object[] r1 = r15.f9554c
            long[] r15 = r15.f9552a
            int r2 = r15.length
            int r2 = r2 + (-2)
            if (r2 < 0) goto L84
            r3 = 0
            r4 = r3
        L1c:
            r5 = r15[r4]
            long r7 = ~r5
            r9 = 7
            long r7 = r7 << r9
            long r7 = r7 & r5
            r9 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r7 = r7 & r9
            int r7 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r7 == 0) goto L7f
            int r7 = r4 - r2
            int r7 = ~r7
            int r7 = r7 >>> 31
            r8 = 8
            int r7 = 8 - r7
            r9 = r3
        L36:
            if (r9 >= r7) goto L7d
            r10 = 255(0xff, double:1.26E-321)
            long r10 = r10 & r5
            r12 = 128(0x80, double:6.3E-322)
            int r10 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r10 >= 0) goto L79
            int r10 = r4 << 3
            int r10 = r10 + r9
            r10 = r1[r10]
            boolean r11 = r10 instanceof p.a0
            if (r11 == 0) goto L73
            p.a0 r10 = (p.a0) r10
            boolean r11 = r10.g()
            if (r11 == 0) goto L53
            goto L79
        L53:
            int r11 = r0.f9517b
            int r12 = r10.f9517b
            int r11 = r11 + r12
            java.lang.Object[] r12 = r0.f9516a
            int r13 = r12.length
            if (r13 >= r11) goto L60
            r0.l(r12, r11)
        L60:
            java.lang.Object[] r11 = r0.f9516a
            java.lang.Object[] r12 = r10.f9516a
            int r13 = r0.f9517b
            int r14 = r10.f9517b
            kb.k.i0(r12, r11, r13, r3, r14)
            int r11 = r0.f9517b
            int r10 = r10.f9517b
            int r11 = r11 + r10
            r0.f9517b = r11
            goto L79
        L73:
            r10.getClass()
            r0.a(r10)
        L79:
            long r5 = r5 >> r8
            int r9 = r9 + 1
            goto L36
        L7d:
            if (r7 != r8) goto L84
        L7f:
            if (r4 == r2) goto L84
            int r4 = r4 + 1
            goto L1c
        L84:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: m0.a.b(p.f0):p.a0");
    }

    public final boolean equals(Object obj) {
        return (obj instanceof a) && this.f8151a.equals(((a) obj).f8151a);
    }

    public final int hashCode() {
        return this.f8151a.hashCode();
    }

    public final String toString() {
        return "MultiValueMap(map=" + this.f8151a + ')';
    }
}
