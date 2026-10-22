package b0;

import d2.h0;
import d2.i0;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class i extends yb.l implements xb.a {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f1743c;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ x f1744f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ i(x xVar, int i) {
        super(0);
        this.f1743c = i;
        this.f1744f = xVar;
    }

    @Override // xb.a
    public final Object invoke() {
        h0 h0Var;
        switch (this.f1743c) {
            case 0:
                x xVar = this.f1744f;
                return Boolean.valueOf(xVar != null ? ((Boolean) new i(xVar, 2).invoke()).booleanValue() : false);
            case 1:
                x xVar2 = this.f1744f;
                return Boolean.valueOf(xVar2 != null ? ((Boolean) new i(xVar2, 2).invoke()).booleanValue() : false);
            default:
                x xVar3 = this.f1744f;
                d2.g gVar = xVar3.f1796c;
                i0 i0Var = (i0) xVar3.f1795b.getValue();
                return Boolean.valueOf(yb.k.a(gVar, (i0Var == null || (h0Var = i0Var.f3122a) == null) ? null : h0Var.f3106a));
        }
    }
}
