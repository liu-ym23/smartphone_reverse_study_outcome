package stepos.support.v7.widget;

import android.view.View;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
public final class c1 implements Runnable {

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ d1 f12736c;

    @Override // java.lang.Runnable
    public final void run() {
        d1 d1Var = this.f12736c;
        View view = d1Var.f12741a;
        StepOSRecyclerView stepOSRecyclerView = d1Var.f12743c;
        if (view != null) {
            stepOSRecyclerView.setPressed(false);
            d1Var.f12741a.setPressed(false);
            View view2 = d1Var.f12741a;
            boolean z10 = StepOSRecyclerView.f12637u0;
            int iM = stepOSRecyclerView.m(view2);
            if (iM >= 0 && !n1.c(stepOSRecyclerView) && stepOSRecyclerView.isAttachedToWindow()) {
                d1Var.b(d1Var.f12743c, d1Var.f12741a, iM, stepOSRecyclerView.getAdapter().getItemId(iM));
            }
            d1Var.f12741a = null;
            d1Var.f12742b = false;
        }
    }
}
