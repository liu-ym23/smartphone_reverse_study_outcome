package d0;

import java.util.NoSuchElementException;
import k.a0;
import k.z;
import q7.k;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final a0 f2742a;

    public static final Object a(a0 a0Var) {
        Object objG = a0Var.g(null);
        if (objG == null) {
            return null;
        }
        if (!(objG instanceof z)) {
            a0Var.j(null);
            return objG;
        }
        z zVar = (z) objG;
        if (zVar.g()) {
            throw new NoSuchElementException("List is empty.");
        }
        int i2 = zVar.f5557b - 1;
        Object objE = zVar.e(i2);
        zVar.j(i2);
        k.c(objE, "null cannot be cast to non-null type V of androidx.compose.runtime.collection.MultiValueMap");
        if (zVar.g()) {
            a0Var.j(null);
        }
        if (zVar.f5557b == 1) {
            a0Var.l(null, zVar.d());
        }
        return objE;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0083  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final k.z b(k.a0 r15) {
        /*
            boolean r0 = r15.i()
            if (r0 == 0) goto Le
            k.z r15 = k.f0.f5488b
            java.lang.String r0 = "null cannot be cast to non-null type androidx.collection.ObjectList<E of androidx.collection.ObjectListKt.emptyObjectList>"
            q7.k.c(r15, r0)
            return r15
        Le:
            k.z r0 = new k.z
            r0.<init>()
            java.lang.Object[] r1 = r15.f5448c
            long[] r15 = r15.f5446a
            int r2 = r15.length
            int r2 = r2 + (-2)
            if (r2 < 0) goto L88
            r3 = 0
            r4 = r3
        L1e:
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
        L38:
            if (r9 >= r7) goto L81
            r10 = 255(0xff, double:1.26E-321)
            long r10 = r10 & r5
            r12 = 128(0x80, double:6.3E-322)
            int r10 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r10 >= 0) goto L7d
            int r10 = r4 << 3
            int r10 = r10 + r9
            r10 = r1[r10]
            boolean r11 = r10 instanceof k.z
            if (r11 == 0) goto L75
            k.z r10 = (k.z) r10
            boolean r11 = r10.g()
            if (r11 == 0) goto L55
            goto L7d
        L55:
            int r11 = r0.f5557b
            int r12 = r10.f5557b
            int r11 = r11 + r12
            java.lang.Object[] r12 = r0.f5556a
            int r13 = r12.length
            if (r13 >= r11) goto L62
            r0.l(r11, r12)
        L62:
            java.lang.Object[] r11 = r0.f5556a
            java.lang.Object[] r12 = r10.f5556a
            int r13 = r0.f5557b
            int r14 = r10.f5557b
            d7.n.Y(r12, r11, r13, r3, r14)
            int r11 = r0.f5557b
            int r10 = r10.f5557b
            int r11 = r11 + r10
            r0.f5557b = r11
            goto L7d
        L75:
            java.lang.String r11 = "null cannot be cast to non-null type V of androidx.compose.runtime.collection.MultiValueMap"
            q7.k.c(r10, r11)
            r0.a(r10)
        L7d:
            long r5 = r5 >> r8
            int r9 = r9 + 1
            goto L38
        L81:
            if (r7 != r8) goto L88
        L83:
            if (r4 == r2) goto L88
            int r4 = r4 + 1
            goto L1e
        L88:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: d0.a.b(k.a0):k.z");
    }

    public final boolean equals(Object obj) {
        if (obj instanceof a) {
            return k.a(this.f2742a, ((a) obj).f2742a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f2742a.hashCode();
    }

    public final String toString() {
        return "MultiValueMap(map=" + this.f2742a + ')';
    }
}
