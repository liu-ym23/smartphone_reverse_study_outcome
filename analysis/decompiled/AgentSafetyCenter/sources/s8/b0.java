package s8;

import java.util.List;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class b0 implements xb.l {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f11455c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ List f11456f;

    @Override // xb.l
    public final Object invoke(Object obj) {
        int i = this.f11455c;
        List list = this.f11456f;
        int iIntValue = ((Integer) obj).intValue();
        switch (i) {
            case 0:
                m1 m1Var = (m1) kb.l.y0(iIntValue, list);
                return Boolean.valueOf(m1Var != null && (m1Var.f11796e > 0 || m1Var.f11797f > 0 || m1Var.f11798g > 0));
            case 1:
                m1 m1Var2 = (m1) kb.l.y0(iIntValue, list);
                return Boolean.valueOf(m1Var2 != null && (m1Var2.f11796e > 0 || m1Var2.f11797f > 0 || m1Var2.f11798g > 0));
            case 2:
                m1 m1Var3 = (m1) kb.l.y0(iIntValue, list);
                if (m1Var3 != null) {
                    return m1Var3.f11792a;
                }
                return null;
            default:
                m1 m1Var4 = (m1) kb.l.y0(iIntValue, list);
                return Boolean.valueOf(m1Var4 != null && (m1Var4.f11796e > 0 || m1Var4.f11797f > 0 || m1Var4.f11798g > 0));
        }
    }
}
