package stepos.support.v7.widget;

import android.view.ActionMode;
import android.view.ViewGroup;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class v implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f12866a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ViewGroup f12867b;

    public /* synthetic */ v(ViewGroup viewGroup, int i10) {
        this.f12866a = i10;
        this.f12867b = viewGroup;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f12866a) {
            case 0:
                StepOSRecyclerView stepOSRecyclerView = (StepOSRecyclerView) this.f12867b;
                int i10 = stepOSRecyclerView.f12576b;
                if ((i10 == 5 || i10 == 4) && stepOSRecyclerView.f12577c == null) {
                    ActionMode actionModeStartActionMode = stepOSRecyclerView.startActionMode(stepOSRecyclerView.f12578d);
                    stepOSRecyclerView.f12577c = actionModeStartActionMode;
                    stepOSRecyclerView.f12598p = stepOSRecyclerView.f12596o;
                    if (actionModeStartActionMode != null) {
                        boolean z = stepOSRecyclerView.f12586j;
                        if (!StepOSRecyclerView.f12573t0) {
                            stepOSRecyclerView.post(new u(stepOSRecyclerView, z));
                        }
                    }
                }
                stepOSRecyclerView.f12592m = null;
                break;
            default:
                g0.c(this.f12867b);
                break;
        }
    }
}
