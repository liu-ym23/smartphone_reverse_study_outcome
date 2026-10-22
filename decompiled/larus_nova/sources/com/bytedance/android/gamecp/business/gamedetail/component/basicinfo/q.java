package com.bytedance.android.gamecp.business.gamedetail.component.basicinfo;

import com.bytedance.android.gamecp.common.track.TrackRegisterStrategy;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes44.dex */
public final class q extends TrackRegisterStrategy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AudienceGameDetailInfoWidgetV2 f53747a;

    @Override // com.bytedance.android.gamecp.common.track.TrackRegisterStrategy
    public final int getAutoReportStrategy() {
        return 1;
    }

    @Override // com.bytedance.android.gamecp.common.track.TrackRegisterStrategy
    public final Map<String, String> getShowExtraAttrs() {
        if (this.f53747a.G == false) goto L5;
        String r100 = "1";
    L7:
        return MapsKt.mapOf(TuplesKt.to("is_fullscreen", r100));
    L5:
        r100 = "0";
        goto L7
    }

    public q(AudienceGameDetailInfoWidgetV2 r100) {
        this.f53747a = r100;
    }
}
