package com.bytedance.android.gamecp.business.gamedetail.component.titlebar.reserverbtn;

import com.bytedance.android.gamecp.business.gamedetail.view.ReserveButton;
import com.bytedance.android.gamecp.common.track.TrackRegisterStrategy;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes44.dex */
public final class c extends TrackRegisterStrategy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TitleReserveButtonWidget f55251a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ReserveButton f55252b;

    @Override // com.bytedance.android.gamecp.common.track.TrackRegisterStrategy
    public final int getAutoReportStrategy() {
        return 7;
    }

    @Override // com.bytedance.android.gamecp.common.track.TrackRegisterStrategy
    public final Map<String, String> getClickTempExtraAttrs() {
        if (TitleReserveButtonWidget.dr(this.f55251a, this.f55252b) == false) goto L5;
        String r100 = "book";
    L7:
        return MapsKt.mapOf(TuplesKt.to("status", r100));
    L5:
        r100 = "booked";
        goto L7
    }

    @Override // com.bytedance.android.gamecp.common.track.TrackRegisterStrategy
    public final Map<String, String> getShowExtraAttrs() {
        if (TitleReserveButtonWidget.dr(this.f55251a, this.f55252b) == false) goto L5;
        String r100 = "book";
    L7:
        return MapsKt.mapOf(TuplesKt.to("status", r100));
    L5:
        r100 = "booked";
        goto L7
    }

    public c(TitleReserveButtonWidget r100, ReserveButton r101) {
        this.f55251a = r100;
        this.f55252b = r101;
    }
}
