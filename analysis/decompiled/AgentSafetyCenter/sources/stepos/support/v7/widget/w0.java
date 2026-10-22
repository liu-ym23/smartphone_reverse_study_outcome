package stepos.support.v7.widget;

import android.view.ActionMode;
import android.view.View;
import android.view.animation.PathInterpolator;
import java.lang.invoke.VarHandle;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
public final class w0 implements Runnable {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f12893c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ View f12894f;

    public /* synthetic */ w0(int i) {
        this.f12893c = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        q qVar;
        switch (this.f12893c) {
            case 0:
                StepOSRecyclerView stepOSRecyclerView = (StepOSRecyclerView) this.f12894f;
                int i = stepOSRecyclerView.f12643f;
                if ((i == 5 || i == 4) && stepOSRecyclerView.f12644g == null) {
                    ActionMode actionModeStartActionMode = stepOSRecyclerView.startActionMode(stepOSRecyclerView.f12646h);
                    stepOSRecyclerView.f12644g = actionModeStartActionMode;
                    stepOSRecyclerView.f12663q = stepOSRecyclerView.f12661p;
                    if (actionModeStartActionMode != null) {
                        boolean z10 = stepOSRecyclerView.f12651k;
                        if (!StepOSRecyclerView.f12637u0) {
                            v0 v0Var = new v0();
                            v0Var.f12870f = stepOSRecyclerView;
                            v0Var.f12869c = z10;
                            VarHandle.storeStoreFence();
                            stepOSRecyclerView.post(v0Var);
                        }
                    }
                }
                stepOSRecyclerView.f12657n = null;
                break;
            case 1:
                PopupNestedScrollingLayout popupNestedScrollingLayout = (PopupNestedScrollingLayout) this.f12894f;
                PathInterpolator pathInterpolator = PopupNestedScrollingLayout.L;
                stepos.support.v7.app.t tVar = popupNestedScrollingLayout.f12632y;
                if (tVar != null) {
                    ((stepos.support.v7.app.w) ((stepos.support.v7.app.f) tVar).f12315f).f12513d.getClass();
                }
                popupNestedScrollingLayout.f12622o = true;
                break;
            case 2:
                ActionMenuView actionMenuView = ((Toolbar) this.f12894f).f12681c;
                if (actionMenuView != null && (qVar = actionMenuView.f12606x) != null) {
                    qVar.o();
                    break;
                }
                break;
            default:
                x1.c(this.f12894f);
                break;
        }
    }
}
