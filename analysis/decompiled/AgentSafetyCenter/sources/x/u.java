package x;

import java.lang.invoke.VarHandle;
import kc.w;
import u.f0;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class u {

    /* renamed from: a, reason: collision with root package name */
    public static final float f15501a = 1;

    /* renamed from: b, reason: collision with root package name */
    public static final m f15502b;

    static {
        s sVar = new s();
        VarHandle.storeStoreFence();
        f15502b = new m(null, 0, false, 0.0f, sVar, 0.0f, false, w.a(nb.h.f8811c), p5.f.b(1.0f, 1.0f), o2.b.b(0, 0, 15), kb.s.f7404c, 0, 0, 0, f0.f13453c, 0, 0);
    }

    public static final r a(k0.s sVar) {
        Object[] objArr = new Object[0];
        p5.u uVar = r.f15478x;
        boolean zD = sVar.d(0) | sVar.d(0);
        Object objM = sVar.M();
        if (zD || objM == k0.m.f6974a) {
            objM = new t(0);
            sVar.i0(objM);
        }
        return (r) t0.a.j(objArr, uVar, (xb.a) objM, sVar, 0, 4);
    }
}
