package co2;

import com.bytedance.android.livesdk.performance.o0;
import com.bytedance.android.livesdk.performance.q;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes11.dex */
public final class i implements q {
    public i() {
    }

    @Override // com.bytedance.android.livesdk.performance.q
    public final void a(Map<String, String> r100, o0 r101) {
        if (r101 == null) goto L11;
        JSONObject r102 = new JSONObject();
        r102.put("java_total", r101.f154746v);     // Catch: Exception -> L8
        r102.put("java_free", r101.f154748w);     // Catch: Exception -> L8
        r102.put("java_used", r101.f154750x);     // Catch: Exception -> L8
        r102.put("pss_dalvik", r101.f154740s);     // Catch: Exception -> L8
        r102.put("pss_native", r101.f154742t);     // Catch: Exception -> L8
        r102.put("pss_total", r101.f154738r);     // Catch: Exception -> L8
        r102.put("graphics", r101.D);     // Catch: Exception -> L8
        r102.put("vmsize", r101.f154744u);     // Catch: Exception -> L8
        r102.put("java_free_mem", r101.f154754z);     // Catch: Exception -> L8
        r102.put("native_heap_free_mem", r101.A);     // Catch: Exception -> L8
        r102.putOpt("summary_java_heap", Long.valueOf(r101.B));     // Catch: Exception -> L8
        r102.putOpt("summary_native_heap", Long.valueOf(r101.C));     // Catch: Exception -> L8
        r102.putOpt("summary_code", Long.valueOf(r101.E));     // Catch: Exception -> L8
        r102.putOpt("summary_stack", Long.valueOf(r101.F));     // Catch: Exception -> L8
        r102.putOpt("summary_private_other", Long.valueOf(r101.H));     // Catch: Exception -> L8
        r102.putOpt("summary_system", Long.valueOf(r101.G));     // Catch: Exception -> L8
    L6:
        HashMap r103 = (HashMap) r100;
        r103.put("pss", r102.toString());
        r103.put("pss_app_usage", String.valueOf(r101.f154738r));
        return;
    }
}
