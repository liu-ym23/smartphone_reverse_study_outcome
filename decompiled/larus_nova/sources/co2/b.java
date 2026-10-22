package co2;

import com.bytedance.android.livesdk.performance.o0;
import com.bytedance.android.livesdk.performance.q;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes11.dex */
public final class b implements q {
    public b() {
    }

    @Override // com.bytedance.android.livesdk.performance.q
    public final void a(Map<String, String> r100, o0 r101) {
        if (r101 == null) goto L12;
        JSONObject r102 = new JSONObject();
        r102.put("cpu_speed", r101.f154728m);     // Catch: Exception -> L9
        r102.put("cpu_rate", r101.f154726l);     // Catch: Exception -> L9
    L7:
        HashMap r103 = (HashMap) r100;
        r103.put("cpu", r102.toString());
        r103.put("cpu_rate", String.valueOf(r101.f154726l));
        r103.put("cpu_speed", String.valueOf(r101.f154728m));
        return;
    }
}
