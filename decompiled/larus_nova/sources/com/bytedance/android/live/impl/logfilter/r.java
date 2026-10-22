package com.bytedance.android.live.impl.logfilter;

import com.bytedance.android.live.impl.service.FeatureManager;
import com.bytedance.android.livesdkapi.service.IPerformanceManager;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class r implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final r f69234a = null;

    public r() {
    }

    static {
        f69234a = new r();
    }

    @Override // com.bytedance.android.live.impl.logfilter.f
    public final void onEvent(String r100, Map<String, String> r101) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        Intrinsics.checkNotNullParameter(r101, "params");
        int r102 = r100.hashCode();
        if (r102 == (-1235807369)) goto L11;
        if (r102 == (-692878481)) goto L8;
        return;
    L8:
        if (r100.equals("livesdk_live_user_tone_report") == false) goto L14;
    L12:
        String r103 = r101.get(IPerformanceManager.PlayerClient.player_audio_render_rms_db);
        String r104 = r101.get(IPerformanceManager.PlayerClient.player_audio_decoder_rms_db);
        FeatureManager r105 = FeatureManager.f69275u;
        z90.a.C8431a.a(r105, IPerformanceManager.PlayerClient.player_audio_render_rms_db, r101.get(IPerformanceManager.PlayerClient.player_audio_render_rms_db));
        z90.a.C8431a.a(r105, IPerformanceManager.PlayerClient.player_audio_decoder_rms_db, r101.get(IPerformanceManager.PlayerClient.player_audio_decoder_rms_db));
        return;
    L14:
        return;
    L11:
        if (r100.equals("livesdk_performance_monitor_base_new") == true) goto L12;
    }
}
