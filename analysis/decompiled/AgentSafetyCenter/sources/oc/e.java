package oc;

import androidx.lifecycle.l0;
import java.util.ArrayList;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class e implements r {

    /* renamed from: c, reason: collision with root package name */
    public final nb.g f9369c;

    /* renamed from: f, reason: collision with root package name */
    public final int f9370f;

    /* renamed from: g, reason: collision with root package name */
    public final mc.a f9371g;

    public e(nb.g gVar, int i, mc.a aVar) {
        this.f9369c = gVar;
        this.f9370f = i;
        this.f9371g = aVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0015  */
    @Override // oc.r
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final nc.g a(nb.g r5, int r6, mc.a r7) {
        /*
            r4 = this;
            nb.g r0 = r4.f9369c
            nb.g r5 = r5.plus(r0)
            mc.a r1 = mc.a.f8550c
            mc.a r2 = r4.f9371g
            int r3 = r4.f9370f
            if (r7 == r1) goto Lf
            goto L26
        Lf:
            r7 = -3
            if (r3 != r7) goto L13
            goto L25
        L13:
            if (r6 != r7) goto L17
        L15:
            r6 = r3
            goto L25
        L17:
            r7 = -2
            if (r3 != r7) goto L1b
            goto L25
        L1b:
            if (r6 != r7) goto L1e
            goto L15
        L1e:
            int r6 = r6 + r3
            if (r6 < 0) goto L22
            goto L25
        L22:
            r6 = 2147483647(0x7fffffff, float:NaN)
        L25:
            r7 = r2
        L26:
            boolean r0 = yb.k.a(r5, r0)
            if (r0 == 0) goto L31
            if (r6 != r3) goto L31
            if (r7 != r2) goto L31
            return r4
        L31:
            oc.e r4 = r4.c(r5, r6, r7)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: oc.e.a(nb.g, int, mc.a):nc.g");
    }

    public abstract Object b(mc.r rVar, nb.c cVar);

    public abstract e c(nb.g gVar, int i, mc.a aVar);

    @Override // nc.g
    public Object collect(nc.h hVar, nb.c cVar) {
        Object objF = kc.w.f(new l0(hVar, this, (nb.c) null, 17), cVar);
        return objF == ob.a.f9351c ? objF : jb.v.f6774a;
    }

    public nc.g d() {
        return null;
    }

    public String toString() {
        ArrayList arrayList = new ArrayList(4);
        nb.h hVar = nb.h.f8811c;
        nb.g gVar = this.f9369c;
        if (gVar != hVar) {
            arrayList.add("context=" + gVar);
        }
        int i = this.f9370f;
        if (i != -3) {
            arrayList.add("capacity=" + i);
        }
        mc.a aVar = mc.a.f8550c;
        mc.a aVar2 = this.f9371g;
        if (aVar2 != aVar) {
            arrayList.add("onBufferOverflow=" + aVar2);
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(getClass().getSimpleName());
        sb2.append('[');
        return k0.a.s(sb2, kb.l.B0(arrayList, ", ", null, null, null, 62), ']');
    }
}
