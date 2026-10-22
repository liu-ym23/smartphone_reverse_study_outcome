package L;

import H.h;
import android.util.Log;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import g1.AbstractC1451a;
import org.json.JSONObject;
import x0.C2112a;

/* loaded from: classes2.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public long f921a;
    public long b;
    public boolean c;

    public static void a(f fVar, String str, String str2, long j5, long j6) {
        if (h.g()) {
            long j10 = j6 - j5;
            if (j10 < 0 || j10 / 1000.0f > 2592000.0d) {
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("type", str);
                jSONObject.put(TypedValues.TransitionType.S_DURATION, j10);
                jSONObject.put("start_time", j5);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("process_name", h.c());
                jSONObject2.put("is_main_process", h.g());
                P.e eVar = new P.e("operate", null, str2, jSONObject, jSONObject2, null);
                try {
                    JSONObject jSONObjectA = eVar.a();
                    if (jSONObjectA != null) {
                        C2112a.c.a(jSONObjectA.toString());
                    }
                } catch (Throwable unused) {
                }
                if (h.f717v && AbstractC1451a.f4474w.a(str2)) {
                    S0.b.z(eVar);
                    O.a.g().c(eVar);
                    if (h.b) {
                        Log.d("ApmInsight", U7.a.e(new String[]{"Receive:OperateData:" + str + ":" + (j10 / 1000)}));
                    }
                } else if (h.b) {
                    Log.d("ApmInsight", U7.a.e(new String[]{"Receive:OperateData:" + str + ":" + (j10 / 1000) + " operate enable:" + h.f717v + " setting:" + AbstractC1451a.f4474w.a(str2)}));
                }
            } catch (Exception unused2) {
            }
        }
    }
}
