package com.bytedance.android.gamecp.business.gamedetail.component.titlebar.betaapply.download;

import com.bytedance.android.gamecp.common.track.TrackRegisterStrategy;
import java.util.Map;

/* JADX INFO: loaded from: classes44.dex */
public final class b extends TrackRegisterStrategy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TitleBetaApplyDownloadButtonWidget f55148a;

    @Override // com.bytedance.android.gamecp.common.track.TrackRegisterStrategy
    public final int getAutoReportStrategy() {
        return 7;
    }

    @Override // com.bytedance.android.gamecp.common.track.TrackRegisterStrategy
    public final Map<String, Object> getClickTempExtraAttrs() {
        return TitleBetaApplyDownloadButtonWidget.dr(this.f55148a);
    }

    @Override // com.bytedance.android.gamecp.common.track.TrackRegisterStrategy
    public final yu.a getGPTrackShowConfig() {
        return new yu.a(true, 2);
    }

    @Override // com.bytedance.android.gamecp.common.track.TrackRegisterStrategy
    public final Map<String, Object> getShowExtraAttrs() {
        return TitleBetaApplyDownloadButtonWidget.dr(this.f55148a);
    }

    public b(TitleBetaApplyDownloadButtonWidget r100) {
        this.f55148a = r100;
    }
}
