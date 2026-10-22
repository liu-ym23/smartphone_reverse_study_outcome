package com.google.android.material.sidesheet;

import android.view.View;
import com.stepos.core.ota.confirmui.ConfirmDecisionBus;
import com.stepos.core.ota.confirmui.ModelConfirmFlow;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final /* synthetic */ class f implements w0.d, ConfirmDecisionBus.DecisionListener {

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ int f5163g;
    public final /* synthetic */ Object h;

    public /* synthetic */ f(Object obj, int i10) {
        this.h = obj;
        this.f5163g = i10;
    }

    @Override // w0.d
    public boolean a(View view) {
        ((SideSheetBehavior) this.h).g(this.f5163g);
        return true;
    }

    @Override // com.stepos.core.ota.confirmui.ConfirmDecisionBus.DecisionListener
    public void onDecision(ConfirmDecisionBus.Decision decision) {
        ModelConfirmFlow.showResourceGateBlocked$lambda$70((ModelConfirmFlow) this.h, this.f5163g, decision);
    }
}
