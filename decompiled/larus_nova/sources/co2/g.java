package co2;

import com.bytedance.android.livesdk.performance.o0;
import com.bytedance.android.livesdk.performance.q;
import com.bytedance.android.livesdkapi.service.IPerformanceManager;
import com.ss.android.ugc.effectmanager.EffectConfiguration;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes11.dex */
public final class g implements q {
    public g() {
    }

    @Override // com.bytedance.android.livesdk.performance.q
    public final void a(Map<String, String> r100, o0 r101) {
        if (r101 == null) goto L11;
        JSONObject r102 = new JSONObject();
        r102.put("usage", r101.f154736q);     // Catch: JSONException -> L8
    L6:
        HashMap r103 = (HashMap) r100;
        r103.put(EffectConfiguration.KEY_GPU_INFO, r102.toString());
        r103.put(IPerformanceManager.GPU.gpu_usage, String.valueOf(r101.f154736q));
        return;
    }
}
