package s8;

import java.util.List;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class g0 implements xb.l {

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ List f11610c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ int f11611f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ xb.p f11612g;

    /* renamed from: h, reason: collision with root package name */
    public /* synthetic */ d1 f11613h;
    public /* synthetic */ k0.c1 i;

    /* renamed from: j, reason: collision with root package name */
    public /* synthetic */ k0.h1 f11614j;

    @Override // xb.l
    public final Object invoke(Object obj) {
        List list = this.f11610c;
        int i = this.f11611f;
        xb.p pVar = this.f11612g;
        d1 d1Var = this.f11613h;
        k0.c1 c1Var = this.i;
        k0.h1 h1Var = this.f11614j;
        Integer num = (Integer) obj;
        int iIntValue = num.intValue();
        m1 m1Var = (m1) kb.l.y0(iIntValue, list);
        if (m1Var != null && (m1Var.f11796e > 0 || m1Var.f11797f > 0 || m1Var.f11798g > 0)) {
            if (iIntValue != i) {
                pVar.invoke(d1Var, num);
            }
            Integer num2 = (Integer) c1Var.getValue();
            if (num2 == null || num2.intValue() != iIntValue) {
                c1Var.setValue(num);
                h1Var.h(h1Var.g() + 1);
            }
        }
        return jb.v.f6774a;
    }
}
