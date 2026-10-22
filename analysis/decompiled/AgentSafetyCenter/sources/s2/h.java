package s2;

import jb.v;
import k0.s;
import xb.p;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class h extends yb.l implements p {

    /* renamed from: c, reason: collision with root package name */
    public static final h f11346c = new h(2);

    @Override // xb.p
    public final Object invoke(Object obj, Object obj2) {
        s sVar = (s) obj;
        int iIntValue = ((Number) obj2).intValue();
        if (!sVar.P(iIntValue & 1, (iIntValue & 3) != 2)) {
            sVar.S();
        }
        return v.f6774a;
    }
}
