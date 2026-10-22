package com.bytedance.android.gamecp.business.gamedetail.component.orderbutton;

import com.bytedance.android.gamecp.common.track.TrackRegisterStrategy;

/* JADX INFO: loaded from: classes44.dex */
public final class j extends TrackRegisterStrategy {
    @Override // com.bytedance.android.gamecp.common.track.TrackRegisterStrategy
    public final int getAutoReportStrategy() {
        return 3;
    }

    @Override // com.bytedance.android.gamecp.common.track.TrackRegisterStrategy
    public final yu.a getGPTrackShowConfig() {
        return new yu.a(true, 2);
    }

    public j() {
    }
}
