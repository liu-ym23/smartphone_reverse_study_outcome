package com.bytedance.android.gamecp.business.gamedetail.component.convertbtn.betadownload;

import android.widget.TextView;
import com.bytedance.android.gamecp.business.gamedetail.view.GameDetailCommonButton;
import com.bytedance.android.gamecp.common.track.TrackRegisterStrategy;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes44.dex */
public final class o extends TrackRegisterStrategy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ NewBetaDownloadPCWidget f54035a;

    @Override // com.bytedance.android.gamecp.common.track.TrackRegisterStrategy
    public final int getAutoReportStrategy() {
        return 7;
    }

    @Override // com.bytedance.android.gamecp.common.track.TrackRegisterStrategy
    public final Map<String, Object> getClickTempExtraAttrs() {
        Pair[] r100 = new Pair[2];
        r100[0] = TuplesKt.to("test_id", this.f54035a.f53930p);
        GameDetailCommonButton r101 = this.f54035a.f53929o;
        if (r101 == null) goto L7;
        TextView r102 = r101.getTvDes();
        if (r102 == null) goto L7;
        CharSequence r103 = r102.getText();
    L8:
        r100[1] = TuplesKt.to("info_content", String.valueOf(r103));
        return MapsKt.mapOf(r100);
    L7:
        r103 = null;
        goto L8
    }

    @Override // com.bytedance.android.gamecp.common.track.TrackRegisterStrategy
    public final Map<String, Object> getShowExtraAttrs() {
        Pair[] r100 = new Pair[2];
        r100[0] = TuplesKt.to("test_id", this.f54035a.f53930p);
        GameDetailCommonButton r101 = this.f54035a.f53929o;
        if (r101 == null) goto L7;
        TextView r102 = r101.getTvDes();
        if (r102 == null) goto L7;
        CharSequence r103 = r102.getText();
    L8:
        r100[1] = TuplesKt.to("info_content", String.valueOf(r103));
        return MapsKt.mapOf(r100);
    L7:
        r103 = null;
        goto L8
    }

    @Override // com.bytedance.android.gamecp.common.track.TrackRegisterStrategy
    public final yu.a getGPTrackShowConfig() {
        return new yu.a(true, 2);
    }

    public o(NewBetaDownloadPCWidget r100) {
        this.f54035a = r100;
    }
}
