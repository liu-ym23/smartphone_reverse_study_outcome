package com.bytedance.android.gamecp.business.gamedetail.component.betaapply.signup;

import com.bytedance.android.gamecp.common.track.TrackRegisterStrategy;
import java.util.Map;

/* JADX INFO: loaded from: classes44.dex */
public final class c extends TrackRegisterStrategy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BetaApplyButtonItemWidget f53806a;

    @Override // com.bytedance.android.gamecp.common.track.TrackRegisterStrategy
    public final int getAutoReportStrategy() {
        return 7;
    }

    @Override // com.bytedance.android.gamecp.common.track.TrackRegisterStrategy
    public final Map<String, Object> getClickTempExtraAttrs() {
        return BetaApplyButtonItemWidget.er(this.f53806a);
    }

    @Override // com.bytedance.android.gamecp.common.track.TrackRegisterStrategy
    public final yu.a getGPTrackShowConfig() {
        return new yu.a(true, 2);
    }

    @Override // com.bytedance.android.gamecp.common.track.TrackRegisterStrategy
    public final Map<String, Object> getShowExtraAttrs() {
        return BetaApplyButtonItemWidget.er(this.f53806a);
    }

    public c(BetaApplyButtonItemWidget r100) {
        this.f53806a = r100;
    }
}
