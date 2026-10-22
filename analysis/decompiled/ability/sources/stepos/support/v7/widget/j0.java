package stepos.support.v7.widget;

import android.view.View;

/* loaded from: classes4.dex */
public final class j0 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ k0 f6621a;

    public j0(k0 k0Var) {
        this.f6621a = k0Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        k0 k0Var = this.f6621a;
        View view = k0Var.f6622a;
        StepOSRecyclerView stepOSRecyclerView = k0Var.c;
        if (view != null) {
            stepOSRecyclerView.setPressed(false);
            k0Var.f6622a.setPressed(false);
            View view2 = k0Var.f6622a;
            boolean z10 = StepOSRecyclerView.f6512u0;
            int iM = stepOSRecyclerView.m(view2);
            if (iM >= 0 && !v0.c(stepOSRecyclerView) && stepOSRecyclerView.isAttachedToWindow()) {
                k0Var.b(k0Var.c, k0Var.f6622a, iM, stepOSRecyclerView.getAdapter().getItemId(iM));
            }
            k0Var.f6622a = null;
            k0Var.b = false;
        }
    }
}
