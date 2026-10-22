package co2;

import com.bytedance.android.livesdk.performance.o0;
import com.bytedance.android.livesdk.performance.q;
import com.bytedance.android.livesdkapi.performance.IPerformanceStrategyManager;
import com.bytedance.android.livesdkapi.service.IPerformanceManager;
import com.bytedance.crash.dumper.Scraps;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes11.dex */
public final class a implements q {
    public a() {
    }

    @Override // com.bytedance.android.livesdk.performance.q
    public final void a(Map<String, String> r100, o0 r101) {
        if (r101 == null) goto L11;
        JSONObject r102 = new JSONObject();
        r102.put("battery_level", r101.f154697b0);     // Catch: Exception -> L8
        r102.put("voltage", r101.f154700c0);     // Catch: Exception -> L8
        r102.put(IPerformanceManager.Battery.battery_scale, r101.f154703d0);     // Catch: Exception -> L8
        r102.put("health", r101.f154706e0);     // Catch: Exception -> L8
        r102.put("present", r101.f154709f0);     // Catch: Exception -> L8
        r102.put("charge_status", r101.f154712g0);     // Catch: Exception -> L8
        r102.put("charge_plugged", r101.f154715h0);     // Catch: Exception -> L8
        r102.put(IPerformanceManager.Battery.battery_current, r101.f154718i0);     // Catch: Exception -> L8
        r102.put("battery_average", r101.f154721j0);     // Catch: Exception -> L8
        r102.put("battery_energy", r101.f154724k0);     // Catch: Exception -> L8
        r102.put(IPerformanceStrategyManager.KEY_FLOAT_TEMPERATURE, r101.N);     // Catch: Exception -> L8
    L6:
        ((HashMap) r100).put(Scraps.BATTERY, r102.toString());
        return;
    }
}
