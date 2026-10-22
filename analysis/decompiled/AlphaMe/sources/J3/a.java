package J3;

import K3.f;
import android.view.ActionMode;
import android.view.View;
import android.view.animation.Interpolator;
import stepos.support.v7.app.B;
import stepos.support.v7.app.E;
import stepos.support.v7.widget.ActionMenuView;
import stepos.support.v7.widget.C0897q;
import stepos.support.v7.widget.PopupNestedScrollingLayout;
import stepos.support.v7.widget.StepOSRecyclerView;
import stepos.support.v7.widget.Toolbar;
import stepos.support.v7.widget.W;
import stepos.support.v7.widget.y0;

/* loaded from: classes2.dex */
public final class a implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f897a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f898b;

    public /* synthetic */ a(int i4, Object obj) {
        this.f897a = i4;
        this.f898b = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0897q c0897q;
        int i4 = this.f897a;
        Object obj = this.f898b;
        switch (i4) {
            case 0:
                c.a((c) obj);
                break;
            case 1:
                f fVar = (f) obj;
                f.a(fVar, fVar.f1067e, fVar.f1066d, fVar.f1072j);
                break;
            case 2:
                PopupNestedScrollingLayout popupNestedScrollingLayout = (PopupNestedScrollingLayout) obj;
                Interpolator interpolator = PopupNestedScrollingLayout.f14855I;
                B b4 = popupNestedScrollingLayout.f14890u;
                if (b4 != null) {
                    ((E) b4).f14266a.f14273d.performDragTriggered();
                }
                popupNestedScrollingLayout.f14880k = true;
                break;
            case 3:
                StepOSRecyclerView stepOSRecyclerView = (StepOSRecyclerView) obj;
                int i5 = stepOSRecyclerView.f14937b;
                if ((i5 == 5 || i5 == 4) && stepOSRecyclerView.f14938c == null) {
                    ActionMode actionModeStartActionMode = stepOSRecyclerView.startActionMode(stepOSRecyclerView.f14939d);
                    stepOSRecyclerView.f14938c = actionModeStartActionMode;
                    stepOSRecyclerView.f14950m = stepOSRecyclerView.f14948l;
                    if (actionModeStartActionMode != null) {
                        boolean z4 = stepOSRecyclerView.f14942g;
                        if (!StepOSRecyclerView.f14911C0) {
                            stepOSRecyclerView.post(new W(stepOSRecyclerView, z4));
                        }
                    }
                }
                stepOSRecyclerView.f14945j = null;
                break;
            case 4:
                ActionMenuView actionMenuView = ((Toolbar) obj).f15013a;
                if (actionMenuView != null && (c0897q = actionMenuView.f14802t) != null) {
                    c0897q.o();
                    break;
                }
                break;
            default:
                y0.c((View) obj);
                break;
        }
    }
}
