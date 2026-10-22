package com.obric.autogui.vdplayer.adapter.orchestrator.a.a;

import android.os.Bundle;
import com.obric.autogui.common.api.agent.BizStatus;
import com.obric.autogui.common.api.agent.IAutoActionAgentEventListener;
import d.h.b.o;

/* JADX INFO: compiled from: UserInterruptedEventHandler.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class h extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final BizStatus f31667a;

    @Override // com.obric.autogui.vdplayer.adapter.orchestrator.a.a.a, com.obric.autogui.common.api.agent.IAutoActionAgentEventListener
    public void onBizStatusChanged(IAutoActionAgentEventListener.SessionInfo r1, BizStatus r2, BizStatus r3, int r4, BizStatus.StatusChangedReasonStruct r5, Bundle r6) {
        o.e(r1, "sessionInfo");
        o.e(r2, "oldStatus");
        o.e(r3, "status");
        o.e(r5, "reasonDetails");
    }

    public h() {
        this.f31667a = BizStatus.USER_INTERRUPTED;
    }

    @Override // com.obric.autogui.vdplayer.adapter.orchestrator.a.a
    public BizStatus a() {
        return this.f31667a;
    }
}
