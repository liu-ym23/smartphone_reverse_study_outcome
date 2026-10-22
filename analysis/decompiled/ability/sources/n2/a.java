package n2;

import D7.N;
import N9.j;
import android.content.Context;
import com.apm.insight.entity.Header;
import com.apm.insight.g;
import com.apm.insight.nativecrash.NativeImpl;
import com.stepos.taskrobot.settingsprovider.SettingsConfig;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import y2.e;

/* loaded from: classes2.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public JSONObject f5345a = new JSONObject();
    public Header b;

    public static a a(long j5, Context context, Throwable th) {
        if (j5 == 0) {
            j5 = System.currentTimeMillis();
        }
        a aVar = new a();
        aVar.e(1, "isJava");
        aVar.e(e.b(th), SettingsConfig.KEY_DATA);
        aVar.e(Long.valueOf(j5), "crash_time");
        aVar.e(com.stepos.statsrpk.d.o(), "process_name");
        if (!com.stepos.statsrpk.d.l(context)) {
            aVar.e(1, "remote_process");
        }
        return aVar;
    }

    public static a b(Context context, long j5, String str) {
        a aVar = new a();
        aVar.e(1, "is_dart");
        aVar.e(Long.valueOf(j5), "crash_time");
        aVar.e(com.stepos.statsrpk.d.o(), "process_name");
        aVar.e(str, SettingsConfig.KEY_DATA);
        com.stepos.statsrpk.d.b(context, aVar.f5345a);
        return aVar;
    }

    public static void i(JSONObject jSONObject, String str, String str2, String str3) {
        if (jSONObject == null) {
            return;
        }
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(str);
        if (jSONObjectOptJSONObject == null) {
            try {
                jSONObjectOptJSONObject = new JSONObject();
                jSONObject.put(str, jSONObjectOptJSONObject);
            } catch (Throwable unused) {
                return;
            }
        }
        jSONObjectOptJSONObject.put(str2, str3);
    }

    public static void j(JSONObject jSONObject, Throwable th) {
        String str = "npth_err_info";
        if (jSONObject.opt("npth_err_info") != null) {
            for (int i = 0; i < 5; i++) {
                if (jSONObject.opt("npth_err_info" + i) == null) {
                    try {
                        str = "npth_err_info" + i;
                    } catch (Throwable unused) {
                        return;
                    }
                }
            }
            return;
        }
        jSONObject.put(str, e.b(th));
    }

    public static void k(JSONObject jSONObject, Map map) {
        if (map != null) {
            try {
                for (Map.Entry entry : map.entrySet()) {
                    jSONObject.put((String) entry.getKey(), entry.getValue());
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static void l(JSONObject jSONObject, JSONObject jSONObject2) {
        try {
            jSONObject.put("storage", jSONObject2);
        } catch (Throwable unused) {
        }
        long jOptLong = jSONObject2.optLong("inner_free");
        long jOptLong2 = jSONObject2.optLong("sdcard_free");
        long jOptLong3 = jSONObject2.optLong("inner_free_real");
        String str = "64M - ";
        String str2 = jOptLong <= 1024 ? "0 - 1K" : jOptLong <= 65536 ? "1K - 64K" : jOptLong <= 524288 ? "64K - 512K" : jOptLong <= 1048576 ? "512K - 1M" : jOptLong <= 67108864 ? "1M - 64M" : "64M - ";
        String str3 = jOptLong3 <= 1024 ? "0 - 1K" : jOptLong3 <= 65536 ? "1K - 64K" : jOptLong3 <= 524288 ? "64K - 512K" : jOptLong3 <= 1048576 ? "512K - 1M" : jOptLong3 <= 67108864 ? "1M - 64M" : "64M - ";
        if (jOptLong2 <= 1024) {
            str = "0 - 1K";
        } else if (jOptLong2 <= 65536) {
            str = "1K - 64K";
        } else if (jOptLong2 <= 524288) {
            str = "64K - 512K";
        } else if (jOptLong2 <= 1048576) {
            str = "512K - 1M";
        } else if (jOptLong2 <= 67108864) {
            str = "1M - 64M";
        }
        i(jSONObject, "filters", "inner_free", str2);
        i(jSONObject, "filters", "inner_free_real", str3);
        i(jSONObject, "filters", "sdcard_free", str);
    }

    public static void o(JSONObject jSONObject, JSONObject jSONObject2) {
        JSONObject jSONObject3;
        JSONObject jSONObject4;
        if (jSONObject == null || jSONObject2 == null || jSONObject2.length() <= 0) {
            return;
        }
        try {
            Iterator<String> itKeys = jSONObject2.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                Object objOpt = jSONObject.opt(next);
                if (objOpt != null) {
                    if (objOpt instanceof JSONObject) {
                        jSONObject3 = jSONObject.getJSONObject(next);
                        jSONObject4 = jSONObject2.getJSONObject(next);
                    } else if (objOpt instanceof JSONArray) {
                        JSONArray jSONArrayOptJSONArray = jSONObject2.optJSONArray(next);
                        if (jSONArrayOptJSONArray != null) {
                            JSONArray jSONArray = (JSONArray) objOpt;
                            if (jSONArray.length() == 1 && (jSONArray.opt(0) instanceof JSONObject) && (jSONArrayOptJSONArray.opt(0) instanceof JSONObject)) {
                                jSONObject3 = jSONArray.getJSONObject(0);
                                jSONObject4 = jSONArrayOptJSONArray.getJSONObject(0);
                            } else {
                                for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                                    jSONArray.put(jSONArrayOptJSONArray.get(i));
                                }
                            }
                        }
                    }
                    o(jSONObject3, jSONObject4);
                }
                jSONObject.put(next, jSONObject2.opt(next));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public static boolean p(String str) {
        x2.c cVar = new x2.c(new File(j.g(g.f2160a, str), "meminfo.txt"));
        cVar.c = "VmSize:";
        cVar.d = "\\s+";
        cVar.e = -1;
        return ((long) cVar.a()) > (NativeImpl.s() ? Long.MAX_VALUE : Header.e() ? 3891200L : 2867200L);
    }

    public static boolean s(String str) {
        x2.c cVar = new x2.c(new File(j.g(g.f2160a, str), "fds.txt"));
        cVar.c = "Total FD Count:";
        cVar.d = ":";
        cVar.e = -2;
        return cVar.a() > 960;
    }

    public static boolean t(String str) {
        x2.c cVar = new x2.c(new File(j.g(g.f2160a, str), "threads.txt"));
        cVar.c = "Total Threads Count:";
        cVar.d = ":";
        cVar.e = -2;
        return cVar.a() > 350;
    }

    public final void c(long j5) {
        try {
            e(Long.valueOf(j5), "app_start_time");
            e(new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss", Locale.getDefault()).format(new Date(j5)), "app_start_time_readable");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void d(Header header) {
        e(header.f2158a, "header");
        this.b = header;
    }

    public final void e(Object obj, String str) {
        try {
            this.f5345a.put(str, obj);
        } catch (Exception e) {
            S0.b.p0(e);
        }
    }

    public final void f(String str, String str2) {
        JSONObject jSONObject = this.f5345a;
        Object objOpt = jSONObject.opt(SettingsConfig.KEY_DATA);
        if (objOpt instanceof JSONArray) {
            i(((JSONArray) objOpt).optJSONObject(0), "filters", str, str2);
        } else {
            i(jSONObject, "filters", str, str2);
        }
    }

    public final void g(List list) {
        JSONArray jSONArray = new JSONArray();
        if (list == null || list.isEmpty()) {
            e(jSONArray, "patch_info");
            return;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            jSONArray.put((String) it.next());
        }
        e(jSONArray, "patch_info");
    }

    public final void h(Map map) {
        JSONObject jSONObject = this.f5345a;
        JSONArray jSONArray = new JSONArray();
        if (map != null) {
            try {
                for (String str : map.keySet()) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("package_name", str);
                    jSONObject2.put("version_code", map.get(str));
                    jSONArray.put(jSONObject2);
                }
            } catch (Exception unused) {
                return;
            }
        }
        jSONObject.put("plugin_info", jSONArray);
    }

    public final boolean m() {
        JSONObject jSONObjectOptJSONObject = this.f5345a;
        Object objOpt = jSONObjectOptJSONObject.opt(SettingsConfig.KEY_DATA);
        if (objOpt instanceof JSONArray) {
            jSONObjectOptJSONObject = ((JSONArray) objOpt).optJSONObject(0);
        }
        return !N.h(jSONObjectOptJSONObject);
    }

    public final void n(String str, String str2) {
        JSONObject jSONObject = this.f5345a;
        Object objOpt = jSONObject.opt(SettingsConfig.KEY_DATA);
        if (objOpt instanceof JSONArray) {
            i(((JSONArray) objOpt).optJSONObject(0), "custom", str, str2);
        } else {
            i(jSONObject, "custom", str, str2);
        }
    }

    public final void q() {
        f("is_64_devices", String.valueOf(Header.e()));
        f("is_64_runtime", String.valueOf(NativeImpl.s()));
        f("is_x86_devices", String.valueOf(Header.g()));
    }

    public final void r(HashMap map) {
        JSONObject jSONObjectOptJSONObject;
        if (map != null) {
            JSONObject jSONObjectOptJSONObject2 = this.f5345a;
            Object objOpt = jSONObjectOptJSONObject2.opt(SettingsConfig.KEY_DATA);
            if (objOpt instanceof JSONArray) {
                jSONObjectOptJSONObject2 = ((JSONArray) objOpt).optJSONObject(0);
            }
            if (jSONObjectOptJSONObject2 == null) {
                jSONObjectOptJSONObject = new JSONObject();
            } else {
                jSONObjectOptJSONObject = jSONObjectOptJSONObject2.optJSONObject("filters");
                if (jSONObjectOptJSONObject == null) {
                    jSONObjectOptJSONObject = new JSONObject();
                    e(jSONObjectOptJSONObject, "filters");
                }
            }
            for (Map.Entry entry : map.entrySet()) {
                try {
                    jSONObjectOptJSONObject.put((String) entry.getKey(), entry.getValue());
                } catch (JSONException unused) {
                }
            }
            e(jSONObjectOptJSONObject, "filters");
        }
    }

    public final Header u() {
        if (this.b == null) {
            Context context = g.f2160a;
            Header header = new Header();
            this.b = header;
            d(header);
        }
        return this.b;
    }
}
