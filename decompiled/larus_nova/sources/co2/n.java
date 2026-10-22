package co2;

import com.bytedance.android.livesdk.performance.o0;
import com.bytedance.android.livesdk.performance.q;
import com.bytedance.android.livesdkapi.performance.IPerformanceStrategyManager;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes11.dex */
public final class n implements q {
    public n() {
    }

    @Override // com.bytedance.android.livesdk.performance.q
    public final void a(Map<String, String> r110, o0 r111) {
        String r100 = "1";
        if (r111 == null) goto L28;
        JSONObject r101 = new JSONObject();
        if (r111.f154693a == false) goto L10;
        r101.put(IPerformanceStrategyManager.KEY_DOUBLE_PREVIEW_FPS, r111.Q);     // Catch: Exception -> L18
        r101.put("in_cap_fps", r111.Y);     // Catch: Exception -> L18
        r101.put("real_fps", r111.R);     // Catch: Exception -> L18
    L25:
        goto L19
    L10:
        if (Intrinsics.areEqual("vs_episode", r111.f154705e) == true) goto L25;
        if (r111.P == false) goto L14;
        Object r102 = "1";
    L15:
        r101.put("surface_render", r102);     // Catch: Exception -> L18
        r101.put(IPerformanceStrategyManager.KEY_DOUBLE_PREVIEW_FPS, r111.Q);     // Catch: Exception -> L18
        r101.put("real_fps", r111.R);     // Catch: Exception -> L18
        r101.put("pull_cdn_ip", r111.S);     // Catch: Exception -> L18
        r101.put("pull_play_url", r111.T);     // Catch: Exception -> L18
        r101.put("pull_download_speed", r111.X);     // Catch: Exception -> L18
        goto L25
    L14:
        r102 = "0";
    L19:
        HashMap r112 = (HashMap) r110;
        r112.put("stream", r101.toString());
        if (r111.P == true) goto L23;
        r100 = "0";
    L23:
        r112.put("surface_render", r100);
        return;
    }
}
