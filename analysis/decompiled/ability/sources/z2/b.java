package z2;

import D7.N;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import w2.AbstractC2095a;

/* loaded from: classes2.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f6926a = 0;

    static {
        new ConcurrentLinkedQueue();
    }

    public static int a(String... strArr) {
        return N.b(b(), -1, strArr);
    }

    public static JSONObject b() {
        d dVar = (d) d.c.get(com.apm.insight.g.a().s());
        if (dVar != null) {
            return dVar.f6928a;
        }
        return null;
    }

    public static void c(JSONArray jSONArray, boolean z10) {
        JSONObject jSONObjectOptJSONObject;
        Map map;
        S0.b.c0("apmconfig", "fromnet " + z10 + " : " + jSONArray);
        if (z10 && (map = AbstractC2095a.g) != null) {
            map.clear();
        }
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                JSONObject jSONObjectOptJSONObject2 = jSONArray.optJSONObject(i);
                String next = jSONObjectOptJSONObject2.keys().next();
                JSONObject jSONObjectOptJSONObject3 = jSONObjectOptJSONObject2.optJSONObject(next);
                S0.b.N("update config " + next + " : " + jSONObjectOptJSONObject3);
                d.a(next, jSONObjectOptJSONObject3);
                if (z10) {
                    if (AbstractC2095a.g == null) {
                        AbstractC2095a.g = new HashMap();
                    }
                    AbstractC2095a.g.put(next, String.valueOf(System.currentTimeMillis()));
                }
            } catch (Throwable unused) {
            }
        }
        String strS = com.apm.insight.g.a().s();
        if (jSONArray.length() == 0) {
            jSONObjectOptJSONObject = null;
        } else {
            for (int i6 = 0; i6 < jSONArray.length(); i6++) {
                jSONObjectOptJSONObject = jSONArray.optJSONObject(i6).optJSONObject(strS);
                if (jSONObjectOptJSONObject != null) {
                    break;
                }
            }
            jSONObjectOptJSONObject = null;
        }
        JSONObject jSONObject = j.f6932a;
        if (jSONObjectOptJSONObject != null) {
            try {
                JSONObject jSONObjectOptJSONObject4 = jSONObjectOptJSONObject.optJSONObject("exception_modules");
                String strOptString = jSONObjectOptJSONObject4 != null ? jSONObjectOptJSONObject4.optString("npth") : null;
                File file = new File(N9.j.C(com.apm.insight.g.f2160a), "apminsight/configCrash/configNative");
                if (strOptString != null) {
                    JSONObject jSONObject2 = new JSONObject(strOptString);
                    j.f6932a = jSONObject2;
                    M.a.p(file, j.e(jSONObject2));
                } else {
                    j.f6932a = new JSONObject();
                }
            } catch (JSONException unused2) {
            } catch (Throwable th) {
                int i10 = com.apm.insight.b.f2156a;
                M0.i.k("NPTH_CATCH", th);
            }
        }
        if (z10) {
            try {
                M.a.o(new File(N9.j.C(com.apm.insight.g.f2160a), "apminsight/configCrash/configFile"), jSONArray);
            } catch (IOException unused3) {
            }
            try {
                if (AbstractC2095a.d == null) {
                    AbstractC2095a.d = new File(N9.j.C(com.apm.insight.g.f2160a), "apminsight/configCrash/configInvalid");
                }
                M.a.n(AbstractC2095a.d, AbstractC2095a.g);
            } catch (Throwable unused4) {
            }
        }
    }

    public static boolean d(Object obj) {
        d dVar;
        String strF = n2.c.f(obj);
        if (strF != null && (dVar = (d) d.c.get(strF)) != null) {
            if (dVar.f6928a == null ? false : dVar.b) {
                d dVar2 = (d) d.c.get(strF);
                if (dVar2 == null || dVar2.e()) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean e(String str) {
        JSONObject jSONObject;
        if (!d.d(str)) {
            AbstractC2095a.i();
        }
        d dVar = (d) d.c.get(str);
        return dVar != null && (jSONObject = dVar.f6928a) != null && 1 == N.b(jSONObject, 0, "crash_module", "switcher") && dVar.e();
    }

    public static boolean f() {
        return a("custom_event_settings", "npth_simple_setting", "disable_looper_monitor") == 1;
    }

    public static boolean g(String str) {
        d dVar;
        JSONObject jSONObject;
        return d.d(str) && (dVar = (d) d.c.get(str)) != null && (jSONObject = dVar.f6928a) != null && 1 == N.b(jSONObject, 0, "crash_module", "upload_alog") && dVar.c() && dVar.e();
    }

    public static boolean h(String str) {
        d dVar;
        JSONObject jSONObject;
        return d.d(str) && (dVar = (d) d.c.get(str)) != null && (jSONObject = dVar.f6928a) != null && 1 == N.b(jSONObject, 0, "crash_module", "apmplus_alog_rate") && dVar.e();
    }

    public static boolean i() {
        JSONObject jSONObject;
        try {
            d dVar = (d) d.c.get(n2.c.f(com.apm.insight.f.b));
            if (dVar != null && (jSONObject = dVar.f6928a) != null && 1 == N.b(jSONObject, 0, "crash_module", "custom_file_sampling_rate") && dVar.c()) {
                if (dVar.e()) {
                    return true;
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public static boolean j() {
        JSONObject jSONObject;
        try {
            d dVar = (d) d.c.get(n2.c.f(com.apm.insight.f.b));
            if (dVar != null && (jSONObject = dVar.f6928a) != null && 1 == N.b(jSONObject, 0, "exit_module", "switcher") && 1 == N.b(dVar.f6928a, 0, "exit_module", "exit_sampling_rate")) {
                if (dVar.e()) {
                    return true;
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }
}
