package x;

import com.fasterxml.jackson.core.ErrorReportConfiguration;
import k0.v1;
import t.c1;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public r f15412a;

    /* renamed from: b, reason: collision with root package name */
    public f f15413b;

    /* renamed from: c, reason: collision with root package name */
    public b f15414c;

    /* renamed from: d, reason: collision with root package name */
    public b2.a f15415d;

    public final void a(int i, Object obj, k0.s sVar, int i3) {
        int i10;
        Object obj2;
        k0.s sVar2;
        sVar.Z(-462424778);
        int i11 = (sVar.d(i) ? 4 : 2) | i3 | (sVar.h(obj) ? 32 : 16) | (sVar.f(this) ? ErrorReportConfiguration.DEFAULT_MAX_ERROR_TOKEN_LENGTH : 128);
        if ((i11 & 147) == 146 && sVar.B()) {
            sVar.S();
            i10 = i;
            obj2 = obj;
            sVar2 = sVar;
        } else {
            i10 = i;
            obj2 = obj;
            sVar2 = sVar;
            c1.a(obj2, i10, this.f15412a.f15495r, s0.h.d(-824725566, new w.m(i, 1, this), sVar), sVar2, ((i11 >> 3) & 14) | 3072 | ((i11 << 3) & 112));
        }
        v1 v1VarS = sVar2.s();
        if (v1VarS != null) {
            v1VarS.f7091d = new g(this, i10, obj2, i3);
        }
    }

    /* JADX WARN: Type inference failed for: r1v6, types: [xb.l, yb.l] */
    public final Object b(int i) {
        f fVar = this.f15413b;
        fVar.getClass();
        y.h hVarG = fVar.f15407a.g(i);
        return ((yb.l) hVarG.f15747c.f9742g).invoke(Integer.valueOf(i - hVarG.f15745a));
    }

    public final int c() {
        f fVar = this.f15413b;
        fVar.getClass();
        return fVar.f15407a.f1860b;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object d(int r4) {
        /*
            r3 = this;
            b2.a r0 = r3.f15415d
            java.lang.Object r1 = r0.f1862d
            java.lang.Object[] r1 = (java.lang.Object[]) r1
            int r0 = r0.f1860b
            int r0 = r4 - r0
            if (r0 < 0) goto L17
            r1.getClass()
            int r2 = r1.length
            int r2 = r2 + (-1)
            if (r0 > r2) goto L17
            r0 = r1[r0]
            goto L18
        L17:
            r0 = 0
        L18:
            if (r0 != 0) goto L43
            x.f r3 = r3.f15413b
            r3.getClass()
            b2.a r3 = r3.f15407a
            y.h r3 = r3.g(r4)
            int r0 = r3.f15745a
            int r0 = r4 - r0
            p5.m r3 = r3.f15747c
            java.lang.Object r3 = r3.f9741f
            xb.l r3 = (xb.l) r3
            if (r3 == 0) goto L3d
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            java.lang.Object r3 = r3.invoke(r0)
            if (r3 != 0) goto L3c
            goto L3d
        L3c:
            return r3
        L3d:
            y.f r3 = new y.f
            r3.<init>(r4)
            return r3
        L43:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: x.h.d(int):java.lang.Object");
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof h) {
            return yb.k.a(this.f15413b, ((h) obj).f15413b);
        }
        return false;
    }

    public final int hashCode() {
        return this.f15413b.hashCode();
    }
}
