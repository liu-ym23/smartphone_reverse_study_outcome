package stepos.support.v7.widget;

import android.view.ActionMode;
import android.view.ViewGroup;
import android.view.animation.Interpolator;

/* renamed from: stepos.support.v7.widget.e0, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class RunnableC1986e0 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6609a;
    public final /* synthetic */ ViewGroup b;

    public /* synthetic */ RunnableC1986e0(ViewGroup viewGroup, int i) {
        this.f6609a = i;
        this.b = viewGroup;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C2005u c2005u;
        int i = this.f6609a;
        ViewGroup viewGroup = this.b;
        switch (i) {
            case 0:
                StepOSRecyclerView stepOSRecyclerView = (StepOSRecyclerView) viewGroup;
                int i6 = stepOSRecyclerView.b;
                if ((i6 == 5 || i6 == 4) && stepOSRecyclerView.c == null) {
                    ActionMode actionModeStartActionMode = stepOSRecyclerView.startActionMode(stepOSRecyclerView.d);
                    stepOSRecyclerView.c = actionModeStartActionMode;
                    stepOSRecyclerView.m = stepOSRecyclerView.l;
                    if (actionModeStartActionMode != null) {
                        boolean z10 = stepOSRecyclerView.g;
                        if (!StepOSRecyclerView.f6512u0) {
                            stepOSRecyclerView.post(new RunnableC1984d0(stepOSRecyclerView, z10));
                        }
                    }
                }
                stepOSRecyclerView.f6540j = null;
                break;
            case 1:
                Interpolator interpolator = PopupNestedScrollingLayout.f6477L;
                ((PopupNestedScrollingLayout) viewGroup).k = true;
                break;
            case 2:
                ActionMenuView actionMenuView = ((Toolbar) viewGroup).f6579a;
                if (actionMenuView != null && (c2005u = actionMenuView.e) != null) {
                    c2005u.m();
                    break;
                }
                break;
            default:
                I0.c(viewGroup);
                break;
        }
    }
}
