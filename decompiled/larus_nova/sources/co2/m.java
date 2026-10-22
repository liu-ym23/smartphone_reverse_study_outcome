package co2;

import com.bytedance.android.livesdk.performance.o0;
import com.bytedance.android.livesdk.performance.q;
import com.bytedance.android.livesdkapi.service.IPerformanceManager;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes11.dex */
public final class m implements q {
    public m() {
    }

    @Override // com.bytedance.android.livesdk.performance.q
    public final void a(Map<String, String> r100, o0 r101) {
        if (r101 == null) goto L10;
        HashMap r102 = (HashMap) r100;
        r102.put("avg_fps", String.valueOf(r101.f154735p0));
        r102.put("video_stall_count", String.valueOf(r101.L0));
        r102.put("video_stall_duration", String.valueOf(r101.M0));
        r102.put("total_drop_count", String.valueOf(r101.J0));
        r102.put("total_drop_time", String.valueOf(r101.I0));
        r102.put("ui_stall_count", String.valueOf(r101.J0));
        r102.put("ui_stall_duration", String.valueOf(r101.I0));
        r102.put("video_ui_total_stall_rate", String.valueOf(r101.f154741s0));
        r102.put("ui_total_stall_rate", String.valueOf(r101.f154743t0));
        r102.put("video_total_stall_rate", String.valueOf(r101.f154747v0));
        r102.put("ui_slight_stall_rate", String.valueOf(r101.f154753y0));
        r102.put("ui_moderate_stall_rate", String.valueOf(r101.A0));
        r102.put("ui_serious_stall_rate", String.valueOf(r101.C0));
        if (r101.E0 == false) goto L7;
        String r103 = "1";
    L8:
        r102.put(IPerformanceManager.Stall.has_stall, r103);
        r102.put("ui_stall_duration_sum", String.valueOf(r101.M0 + r101.I0));
        r102.put("ui_stall_count_sum", String.valueOf(r101.L0 + r101.J0));
        return;
    L7:
        r103 = "0";
        goto L8
    }
}
