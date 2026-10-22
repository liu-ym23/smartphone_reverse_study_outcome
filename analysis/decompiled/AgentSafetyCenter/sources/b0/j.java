package b0;

import java.lang.invoke.VarHandle;
import java.util.List;
import k0.c1;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class j extends yb.l implements xb.a {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f1745c;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ c1 f1746f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ j(c1 c1Var, int i) {
        super(0);
        this.f1745c = i;
        this.f1746f = c1Var;
    }

    @Override // xb.a
    public final Object invoke() {
        int i = this.f1745c;
        c1 c1Var = this.f1746f;
        switch (i) {
            case 0:
                if (c1Var != null) {
                    return (List) c1Var.getValue();
                }
                return null;
            case 1:
                return (g0.g) c1Var.getValue();
            case 2:
                xb.l lVar = (xb.l) c1Var.getValue();
                x.f fVar = new x.f();
                b2.a aVar = new b2.a(6);
                aVar.f1861c = new m0.e(new y.h[16]);
                VarHandle.storeStoreFence();
                fVar.f15407a = aVar;
                lVar.invoke(fVar);
                VarHandle.storeStoreFence();
                return fVar;
            default:
                return (x.h) ((xb.a) c1Var.getValue()).invoke();
        }
    }
}
