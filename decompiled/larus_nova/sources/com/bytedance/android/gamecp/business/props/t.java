package com.bytedance.android.gamecp.business.props;

import com.bytedance.android.gamecp.common.monitor.LiveTracingMonitor;
import com.bytedance.common.utility.Logger;
import com.ss.ttm.player.MediaPlayer;
import kotlin.Unit;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
public final class t implements qv.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ j f56397a;

    @Override // qv.a
    public final void onSuccess() {
        Logger.d("showCaptchaV2", "showCaptcha, onSuccess");
        this.f56397a.e();
        LiveTracingMonitor.EventModule r100 = com.bytedance.android.gamecp.common.utils.t.f57302a;
        JSONObject r101 = this.f56397a.g();
        r101.put("error_code", 0);
        Unit r102 = Unit.INSTANCE;
        com.bytedance.android.gamecp.common.utils.t.b(MediaPlayer.MEDIA_PLAYER_OPTION_FORMATER_REC_BUFFER_TYPE, r101);
    }

    public t(j r100) {
        this.f56397a = r100;
    }

    @Override // qv.a
    public final void onFailure(int r100) {
        Logger.d("showCaptchaV2", "showCaptcha, onFailure");
        LiveTracingMonitor.EventModule r101 = com.bytedance.android.gamecp.common.utils.t.f57302a;
        JSONObject r102 = this.f56397a.g();
        r102.put("error_code", r100);
        Unit r103 = Unit.INSTANCE;
        com.bytedance.android.gamecp.common.utils.t.b(MediaPlayer.MEDIA_PLAYER_OPTION_FORMATER_REC_BUFFER_TYPE, r102);
    }
}
