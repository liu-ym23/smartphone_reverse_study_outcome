package com.bytedance.android.gamecp.business.props;

import com.bytedance.android.gamecp.common.monitor.LiveTracingMonitor;
import com.ss.ttm.player.MediaPlayer;
import io.reactivex.functions.Consumer;
import kotlin.Unit;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
public final class p<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ j f56389a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f56390b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ wt.a f56391c;

    public p(j r100, String r101, wt.a r102) {
        this.f56389a = r100;
        this.f56390b = r101;
        this.f56391c = r102;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        com.bytedance.android.gamecp.base.network.response.i r101 = (com.bytedance.android.gamecp.base.network.response.i) r100;
        LiveTracingMonitor.EventModule r102 = com.bytedance.android.gamecp.common.utils.t.f57302a;
        JSONObject r103 = this.f56389a.g();
        r103.put("error_code", ((wt.j) r101.data).status);
        Unit r104 = Unit.INSTANCE;
        JSONObject r105 = new JSONObject();
        r105.put("order_id", this.f56390b);
        com.bytedance.android.gamecp.common.utils.t.c(MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_MEDIACODEC_PIPELINE_CTL, r103, r105);
        if (((wt.j) r101.data).status != 3) goto L5;
        j.b(this.f56389a, true, this.f56391c);
    L6:
        j.a(this.f56389a);
        return;
    L5:
        j.b(this.f56389a, false, this.f56391c);
        goto L6
    }
}
