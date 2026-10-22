package b0;

import d2.i0;
import java.lang.invoke.VarHandle;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class h extends yb.l implements xb.l {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f1740c;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ x f1741f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ xb.l f1742g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ h(x xVar, xb.l lVar, int i) {
        super(1);
        this.f1740c = i;
        this.f1741f = xVar;
        this.f1742g = lVar;
    }

    @Override // xb.l
    public final Object invoke(Object obj) {
        int i = this.f1740c;
        xb.l lVar = this.f1742g;
        x xVar = this.f1741f;
        switch (i) {
            case 0:
                i0 i0Var = (i0) obj;
                if (xVar != null) {
                    xVar.f1795b.setValue(i0Var);
                }
                if (lVar != null) {
                    lVar.invoke(i0Var);
                }
                return jb.v.f6774a;
            default:
                xVar.f1797d.add(lVar);
                t tVar = new t(0);
                tVar.f1786b = xVar;
                tVar.f1787c = lVar;
                VarHandle.storeStoreFence();
                return tVar;
        }
    }
}
