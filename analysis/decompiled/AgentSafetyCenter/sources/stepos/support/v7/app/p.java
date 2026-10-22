package stepos.support.v7.app;

import java.lang.invoke.VarHandle;
import java.util.WeakHashMap;
import stepos.support.v7.widget.ActionBarContextView;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
public final class p implements Runnable {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f12409c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ o f12410f;

    public /* synthetic */ p(int i) {
        this.f12409c = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f12409c) {
            case 0:
                o oVar = this.f12410f;
                if ((oVar.N & 1) != 0) {
                    o.k(oVar, 0);
                }
                if ((oVar.N & 4096) != 0) {
                    o.k(oVar, 108);
                }
                oVar.M = false;
                oVar.N = 0;
                break;
            default:
                o oVar2 = this.f12410f;
                oVar2.f12407z.showAtLocation(oVar2.f12406y, 55, 0, 0);
                oVar2.p();
                ActionBarContextView actionBarContextView = oVar2.f12406y;
                WeakHashMap weakHashMap = n3.k0.f8724a;
                actionBarContextView.setAlpha(0.0f);
                n3.o0 o0VarA = n3.k0.a(oVar2.f12406y);
                o0VarA.a(1.0f);
                oVar2.B = o0VarA;
                h.u uVar = new h.u(3);
                uVar.f4896h = this;
                VarHandle.storeStoreFence();
                o0VarA.e(uVar);
                break;
        }
    }
}
