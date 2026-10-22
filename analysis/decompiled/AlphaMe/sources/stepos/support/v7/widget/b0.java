package stepos.support.v7.widget;

import android.view.View;

/* loaded from: classes2.dex */
public final class b0 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c0 f15070a;

    public b0(c0 c0Var) {
        this.f15070a = c0Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        c0 c0Var = this.f15070a;
        if (c0Var.f15074a != null) {
            StepOSRecyclerView stepOSRecyclerView = c0Var.f15076c;
            stepOSRecyclerView.setPressed(false);
            c0Var.f15074a.setPressed(false);
            View view = c0Var.f15074a;
            boolean z4 = StepOSRecyclerView.f14911C0;
            int iN = stepOSRecyclerView.n(view);
            if (iN >= 0 && !n0.c(stepOSRecyclerView) && stepOSRecyclerView.isAttachedToWindow()) {
                c0Var.b(c0Var.f15076c, c0Var.f15074a, iN, stepOSRecyclerView.getAdapter().getItemId(iN));
            }
            c0Var.f15074a = null;
            c0Var.f15075b = false;
        }
    }
}
