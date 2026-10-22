package h;

import android.view.ViewGroup;
import java.lang.invoke.VarHandle;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class r implements Runnable {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f4890c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ e0 f4891f;

    public /* synthetic */ r(int i) {
        this.f4890c = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ViewGroup viewGroup;
        switch (this.f4890c) {
            case 0:
                e0 e0Var = this.f4891f;
                if ((e0Var.f4787b0 & 1) != 0) {
                    e0Var.t(0);
                }
                if ((e0Var.f4787b0 & 4096) != 0) {
                    e0Var.t(108);
                }
                e0Var.f4786a0 = false;
                e0Var.f4787b0 = 0;
                break;
            default:
                e0 e0Var2 = this.f4891f;
                e0Var2.f4806x.showAtLocation(e0Var2.f4805w, 55, 0, 0);
                n3.o0 o0Var = e0Var2.f4808z;
                if (o0Var != null) {
                    o0Var.b();
                }
                if (!e0Var2.B || (viewGroup = e0Var2.C) == null || !viewGroup.isLaidOut()) {
                    e0Var2.f4805w.setAlpha(1.0f);
                    e0Var2.f4805w.setVisibility(0);
                    break;
                } else {
                    e0Var2.f4805w.setAlpha(0.0f);
                    n3.o0 o0VarA = n3.k0.a(e0Var2.f4805w);
                    o0VarA.a(1.0f);
                    e0Var2.f4808z = o0VarA;
                    u uVar = new u(0);
                    uVar.f4896h = this;
                    VarHandle.storeStoreFence();
                    o0VarA.e(uVar);
                    break;
                }
                break;
        }
    }
}
