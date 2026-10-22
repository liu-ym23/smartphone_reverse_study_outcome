package com.bytedance.android.gamecp.business.gamedetail.component.convertbtn;

import com.bytedance.android.gamecp.business.gamedetail.view.ReserveButton2;
import com.bytedance.android.gamecp.common.track.TrackRegisterStrategy;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes44.dex */
public final class b extends TrackRegisterStrategy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ NewReserveWidget f53918a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ReserveButton2 f53919b;

    @Override // com.bytedance.android.gamecp.common.track.TrackRegisterStrategy
    public final int getAutoReportStrategy() {
        return 7;
    }

    @Override // com.bytedance.android.gamecp.common.track.TrackRegisterStrategy
    public final Map<String, String> getClickTempExtraAttrs() {
        Pair[] r100 = new Pair[2];
        if (NewReserveWidget.dr(this.f53918a, false, this.f53919b) == true) goto L5;
        String r101 = "book";
    L6:
        r100[0] = TuplesKt.to("status", r101);
        r100[1] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_BUTTON_TYPE, "bottom");
        return MapsKt.mapOf(r100);
    L5:
        r101 = "booked";
        goto L6
    }

    @Override // com.bytedance.android.gamecp.common.track.TrackRegisterStrategy
    public final Map<String, String> getShowExtraAttrs() {
        Pair[] r100 = new Pair[2];
        if (NewReserveWidget.dr(this.f53918a, true, this.f53919b) == true) goto L5;
        String r101 = "book";
    L6:
        r100[0] = TuplesKt.to("status", r101);
        r100[1] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_BUTTON_TYPE, "bottom");
        return MapsKt.mapOf(r100);
    L5:
        r101 = "booked";
        goto L6
    }

    @Override // com.bytedance.android.gamecp.common.track.TrackRegisterStrategy
    public final yu.a getGPTrackShowConfig() {
        return new yu.a(true, 2);
    }

    public b(NewReserveWidget r100, ReserveButton2 r101) {
        this.f53918a = r100;
        this.f53919b = r101;
    }
}
