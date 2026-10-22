package Y;

import H.f;
import H.h;
import H.k;
import android.util.Log;
import androidx.autofill.HintConstants;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.bytedance.apm.insight.ApmInsightInitConfig;
import java.util.HashSet;
import java.util.concurrent.ConcurrentLinkedDeque;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    public static final HashSet f1557a = new HashSet(32);
    public static final ConcurrentLinkedDeque b = new ConcurrentLinkedDeque();
    public static long c = 10000;

    public static void a() {
        ConcurrentLinkedDeque concurrentLinkedDeque = b;
        try {
            int size = concurrentLinkedDeque.size();
            for (int i = 0; i < size; i++) {
                d dVar = (d) concurrentLinkedDeque.peekLast();
                if (dVar != null && dVar.f != 0) {
                    d dVar2 = (d) concurrentLinkedDeque.pollLast();
                    long j5 = dVar2.b;
                    String str = dVar2.f1558a;
                    if (j5 <= 0 || dVar2.c <= 0 || dVar2.d <= 0 || dVar2.e <= 0) {
                        if (h.b) {
                            k.f723a.y("apm_autopage");
                            return;
                        }
                        return;
                    }
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(HintConstants.AUTOFILL_HINT_NAME, AppAgent.ON_CREATE);
                    jSONObject.put("start", j5);
                    jSONObject.put("end", dVar2.c);
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put(HintConstants.AUTOFILL_HINT_NAME, "onResume");
                    jSONObject2.put("start", dVar2.d);
                    jSONObject2.put("end", dVar2.e);
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put(HintConstants.AUTOFILL_HINT_NAME, "onWindowFocusChanged");
                    jSONObject3.put("start", dVar2.f);
                    JSONArray jSONArray = new JSONArray();
                    jSONArray.put(jSONObject);
                    jSONArray.put(jSONObject2);
                    jSONArray.put(jSONObject3);
                    JSONObject jSONObject4 = new JSONObject();
                    jSONObject4.put(HintConstants.AUTOFILL_HINT_NAME, "page_load_stats");
                    jSONObject4.put("page_type", "activity");
                    jSONObject4.put("start", j5);
                    jSONObject4.put("end", dVar2.f);
                    long j6 = dVar2.f - j5;
                    if (j6 >= 0 && j6 <= c) {
                        jSONObject4.put("spans", jSONArray);
                        HashSet hashSet = f1557a;
                        int i6 = hashSet.contains(str) ? 2 : 1;
                        hashSet.add(str);
                        jSONObject4.put("launch_mode", i6);
                        jSONObject4.put("collect_from", 1);
                        jSONObject4.put("page_name", str);
                        JSONObject jSONObject5 = new JSONObject();
                        jSONObject5.put("trace", jSONObject4);
                        if (h.b) {
                            Log.d("ApmInsight", U7.a.e(new String[]{"Receive:PageData"}));
                        }
                        ApmInsightInitConfig apmInsightInitConfig = (ApmInsightInitConfig) C4.a.c().c;
                        if (!(apmInsightInitConfig != null ? apmInsightInitConfig.enablePageMonitor() : true)) {
                            return;
                        } else {
                            L0.d.f925a.b(new f(2, jSONObject5));
                        }
                    }
                }
                return;
            }
        } catch (Exception e) {
            if (h.b) {
                e.printStackTrace();
            }
        }
    }
}
