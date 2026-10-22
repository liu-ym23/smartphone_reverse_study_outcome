package F5;

import android.content.ContentResolver;
import android.os.Process;
import android.provider.Settings;
import android.util.Log;
import com.stepos.ability.commoninternal.Key;
import j9.m;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import kotlin.jvm.internal.k;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    public static volatile boolean f550a;
    public static final int b = Process.myPid();
    public static final SimpleDateFormat c = new SimpleDateFormat("HH:mm:ss.SSS", Locale.US);

    public static void a(String str, boolean z10) {
        if (z10 == f550a && str.equals("init")) {
            Log.i("clawbench_probe", "init: profileEnabled=" + z10 + " (key=clawbench_probe_profile)");
            return;
        }
        boolean z11 = z10 != f550a;
        f550a = z10;
        Log.i("clawbench_probe", androidx.appfunctions.metadata.a.p(androidx.constraintlayout.core.dsl.a.l("profile ", str, ": profileEnabled=", z11 ? " (changed)" : "", z10), " — adb: settings ", z10 ? "delete" : "put", " global clawbench_probe_profile ", z10 ? "" : "0"));
    }

    public static String b(String str) {
        if (str.length() == 0) {
            return "no-sid";
        }
        String strI0 = m.I0(':', str, str);
        if (strI0.length() < 8) {
            return strI0;
        }
        String strSubstring = strI0.substring(0, 8);
        k.e(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static boolean c(ContentResolver contentResolver) {
        try {
            return Settings.Global.getInt(contentResolver, "clawbench_probe_profile", 0) != 0;
        } catch (Exception e) {
            androidx.constraintlayout.core.dsl.a.w("read clawbench_probe_profile failed, fallback to false: ", e.getMessage(), "clawbench_probe");
            return false;
        }
    }

    public static void d(String str, String str2, String str3, Long l) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("ts", c.format(new Date(jCurrentTimeMillis)));
        linkedHashMap.put("type", str);
        linkedHashMap.put(Key.KEY_TRACE_ID, str2);
        linkedHashMap.put("session_id", str3);
        if (l != null) {
            linkedHashMap.put("duration_ms", l);
        }
        synchronized (g.f554a) {
            g gVar = g.f554a;
            g.a(jCurrentTimeMillis);
            f fVar = g.e;
            if (fVar != null) {
                ((ArrayList) fVar.c).add(linkedHashMap);
            }
        }
    }

    public static String e(Map map) {
        if (map.isEmpty()) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry entry : map.entrySet()) {
            String str = (String) entry.getKey();
            Object value = entry.getValue();
            if (value != null) {
                try {
                    jSONObject.put(str, value);
                } catch (Throwable th) {
                    kotlin.b.a(th);
                }
            }
        }
        if (jSONObject.length() == 0) {
            return null;
        }
        return jSONObject.toString();
    }
}
