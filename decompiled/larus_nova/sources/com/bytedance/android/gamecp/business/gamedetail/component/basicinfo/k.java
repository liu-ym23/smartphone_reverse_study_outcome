package com.bytedance.android.gamecp.business.gamedetail.component.basicinfo;

import com.bytedance.android.gamecp.common.track.TrackRegisterStrategy;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes44.dex */
public final class k extends TrackRegisterStrategy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AudienceGameDetailInfoWidget f53736a;

    @Override // com.bytedance.android.gamecp.common.track.TrackRegisterStrategy
    public final int getAutoReportStrategy() {
        return 1;
    }

    @Override // com.bytedance.android.gamecp.common.track.TrackRegisterStrategy
    public final Map<String, String> getShowExtraAttrs() {
        if (this.f53736a.f53534x == false) goto L5;
        String r100 = "1";
    L7:
        return MapsKt.mapOf(TuplesKt.to("is_fullscreen", r100));
    L5:
        r100 = "0";
        goto L7
    }

    public k(AudienceGameDetailInfoWidget r100) {
        this.f53736a = r100;
    }
}
