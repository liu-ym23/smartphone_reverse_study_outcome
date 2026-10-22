package e9;

import h0.t1;
import w.s0;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class e0 implements xb.q {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f3642c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ Object f3643f;

    public /* synthetic */ e0(int i) {
        this.f3642c = i;
    }

    @Override // xb.q
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        int i = this.f3642c;
        Object obj4 = this.f3643f;
        switch (i) {
            case 0:
                String str = (String) obj4;
                k0.s sVar = (k0.s) obj2;
                int iIntValue = ((Integer) obj3).intValue();
                ((s0) obj).getClass();
                if (sVar.P(iIntValue & 1, (iIntValue & 17) != 16)) {
                    t1.b(str, null, j9.b0.f6638f, com.stepos.statsrpk.h.t(17), null, 0L, null, 0L, 0, false, 0, 0, null, sVar, 3456, 0, 131058);
                } else {
                    sVar.S();
                }
                return jb.v.f6774a;
            case 1:
                ((a9.e) obj4).invoke((Throwable) obj);
                break;
            case 2:
                ((Integer) obj3).getClass();
                ((r.s) obj).getClass();
                ((s0.c) obj4).invoke((k0.s) obj2, 0);
                break;
            case 3:
                sc.c cVar = (sc.c) obj4;
                sc.c.f12175l.set(cVar, null);
                cVar.e(null);
                break;
            default:
                ((sc.g) obj4).c();
                break;
        }
        return jb.v.f6774a;
    }
}
