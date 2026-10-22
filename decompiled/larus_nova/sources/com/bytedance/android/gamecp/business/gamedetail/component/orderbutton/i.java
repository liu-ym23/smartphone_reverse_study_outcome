package com.bytedance.android.gamecp.business.gamedetail.component.orderbutton;

import com.bytedance.android.gamecp.business.gamedetail.view.ReserveButton;
import com.bytedance.android.gamecp.common.track.TrackRegisterStrategy;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes44.dex */
public final class i extends TrackRegisterStrategy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ GameOrderButtonItemWidget f54870a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ReserveButton f54871b;

    @Override // com.bytedance.android.gamecp.common.track.TrackRegisterStrategy
    public final int getAutoReportStrategy() {
        return 7;
    }

    @Override // com.bytedance.android.gamecp.common.track.TrackRegisterStrategy
    public final Map<String, String> getClickTempExtraAttrs() {
        Pair[] r100 = new Pair[2];
        if (GameOrderButtonItemWidget.dr(this.f54870a, false, this.f54871b) == false) goto L5;
        String r101 = "book";
    L6:
        r100[0] = TuplesKt.to("status", r101);
        r100[1] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_BUTTON_TYPE, "top");
        return MapsKt.mapOf(r100);
    L5:
        r101 = "booked";
        goto L6
    }

    @Override // com.bytedance.android.gamecp.common.track.TrackRegisterStrategy
    public final Map<String, String> getShowExtraAttrs() {
        Pair[] r100 = new Pair[2];
        if (GameOrderButtonItemWidget.dr(this.f54870a, true, this.f54871b) == false) goto L5;
        String r101 = "book";
    L6:
        r100[0] = TuplesKt.to("status", r101);
        r100[1] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_BUTTON_TYPE, "top");
        return MapsKt.mapOf(r100);
    L5:
        r101 = "booked";
        goto L6
    }

    @Override // com.bytedance.android.gamecp.common.track.TrackRegisterStrategy
    public final yu.a getGPTrackShowConfig() {
        return new yu.a(true, 2);
    }

    public i(GameOrderButtonItemWidget r100, ReserveButton r101) {
        this.f54870a = r100;
        this.f54871b = r101;
    }
}
