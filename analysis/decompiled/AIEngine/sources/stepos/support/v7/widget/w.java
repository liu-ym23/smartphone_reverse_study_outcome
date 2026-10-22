package stepos.support.v7.widget;

import android.view.View;
import stepos.support.v7.widget.StepOSRecyclerView;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class w implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ StepOSRecyclerView.h f12868a;

    public w(StepOSRecyclerView.h hVar) {
        this.f12868a = hVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        StepOSRecyclerView.h hVar = this.f12868a;
        View view = hVar.f12626a;
        StepOSRecyclerView stepOSRecyclerView = StepOSRecyclerView.this;
        if (view != null) {
            stepOSRecyclerView.setPressed(false);
            hVar.f12626a.setPressed(false);
            View view2 = hVar.f12626a;
            boolean z = StepOSRecyclerView.f12573t0;
            int iN = stepOSRecyclerView.n(view2);
            if (iN >= 0 && !z.d(stepOSRecyclerView) && stepOSRecyclerView.isAttachedToWindow()) {
                hVar.b(StepOSRecyclerView.this, hVar.f12626a, iN, stepOSRecyclerView.getAdapter().getItemId(iN));
            }
            hVar.f12626a = null;
            hVar.f12627b = false;
        }
    }
}
