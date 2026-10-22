package com.bytedance.android.gamecp.business.gamedetail.component.convertbtn.betasignupbutton;

import com.bytedance.android.gamecp.common.track.TrackRegisterStrategy;
import java.util.Map;

/* JADX INFO: loaded from: classes44.dex */
public final class g extends TrackRegisterStrategy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ NewBetaSignUpWidget f54127a;

    @Override // com.bytedance.android.gamecp.common.track.TrackRegisterStrategy
    public final int getAutoReportStrategy() {
        return 7;
    }

    @Override // com.bytedance.android.gamecp.common.track.TrackRegisterStrategy
    public final Map<String, Object> getClickTempExtraAttrs() {
        return NewBetaSignUpWidget.dr(this.f54127a);
    }

    @Override // com.bytedance.android.gamecp.common.track.TrackRegisterStrategy
    public final yu.a getGPTrackShowConfig() {
        return new yu.a(true, 2);
    }

    @Override // com.bytedance.android.gamecp.common.track.TrackRegisterStrategy
    public final Map<String, Object> getShowExtraAttrs() {
        return NewBetaSignUpWidget.dr(this.f54127a);
    }

    public g(NewBetaSignUpWidget r100) {
        this.f54127a = r100;
    }
}
