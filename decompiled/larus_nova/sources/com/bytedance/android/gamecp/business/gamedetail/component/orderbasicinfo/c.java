package com.bytedance.android.gamecp.business.gamedetail.component.orderbasicinfo;

import com.bytedance.android.gamecp.common.track.TrackRegisterStrategy;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes44.dex */
public final class c extends TrackRegisterStrategy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ OrderGameDetailInfoItemWidget f54774a;

    @Override // com.bytedance.android.gamecp.common.track.TrackRegisterStrategy
    public final int getAutoReportStrategy() {
        return 1;
    }

    @Override // com.bytedance.android.gamecp.common.track.TrackRegisterStrategy
    public final Map<String, String> getShowExtraAttrs() {
        if (this.f54774a.f54725t == false) goto L5;
        String r100 = "1";
    L7:
        return MapsKt.mapOf(TuplesKt.to("is_fullscreen", r100));
    L5:
        r100 = "0";
        goto L7
    }

    public c(OrderGameDetailInfoItemWidget r100) {
        this.f54774a = r100;
    }
}
