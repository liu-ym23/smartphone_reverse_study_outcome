package da;

import android.content.ContentResolver;
import android.os.Process;
import android.provider.Settings;
import android.util.Log;
import com.stepos.core.ability.speech.AsrSseEvent;
import com.stepos.probe.PerfettoSink;
import com.tonyodev.fetch2core.server.FileResponse;
import da.f;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import kotlin.Pair;
import kotlin.jvm.internal.g;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static volatile boolean f8415a;

    /* renamed from: b, reason: collision with root package name */
    public static final int f8416b = Process.myPid();

    /* renamed from: c, reason: collision with root package name */
    public static final SimpleDateFormat f8417c = new SimpleDateFormat("HH:mm:ss.SSS", Locale.US);

    public static void a(String str, boolean z) {
        if (z == f8415a && str.equals("init")) {
            Log.i("clawbench_probe", "init: profileEnabled=" + z + " (key=clawbench_probe_profile)");
            return;
        }
        boolean z3 = z != f8415a;
        f8415a = z;
        Log.i("clawbench_probe", com.stepos.core.ota.d.j(com.stepos.core.ota.d.m("profile ", str, ": profileEnabled=", z3 ? " (changed)" : "", z), " — adb: settings ", z ? "delete" : "put", " global clawbench_probe_profile ", z ? "" : "0"));
    }

    public static void b(String traceId, Map map, String str) throws JSONException {
        g.f(traceId, "traceId");
        d.a("first_token", "first_token", traceId, "ok", null, map, 32);
        g("first_token", null, traceId);
        if (f8415a) {
            if (str == null) {
                str = "no-sid";
            }
            PerfettoSink perfettoSink = PerfettoSink.f7999a;
            String strConcat = "aiengine:first_token:".concat(str);
            Integer numValueOf = Integer.valueOf(f8416b);
            String strH = h(map);
            perfettoSink.getClass();
            PerfettoSink.b(strConcat, numValueOf, traceId, strH);
        }
    }

    public static void c(int i10, String traceId, String errorMsg) {
        g.f(traceId, "traceId");
        g.f(errorMsg, "errorMsg");
        d.a("aiengine".concat("_error"), AsrSseEvent.TYPE_ERROR, traceId, "failed", null, kotlin.collections.b.g0(new Pair("error_code", Integer.valueOf(i10)), new Pair("error_msg", errorMsg)), 160);
        g("aiengine".concat("_error"), null, traceId);
    }

    public static void d(String traceId, long j10, Map map, String str) throws JSONException {
        g.f(traceId, "traceId");
        d.a("aiengine_llm_infer", "llm_infer", traceId, "ok", Long.valueOf(j10), map, 32);
        g("aiengine_llm_infer", Long.valueOf(j10), traceId);
        if (f8415a) {
            if (str == null) {
                str = "no-sid";
            }
            PerfettoSink perfettoSink = PerfettoSink.f7999a;
            int i10 = f8416b;
            String strH = h(map);
            perfettoSink.getClass();
            PerfettoSink.d(str, i10, traceId, strH);
        }
    }

    public static void e(String traceId, Map map, String str) throws JSONException {
        g.f(traceId, "traceId");
        d.a("aiengine_llm_infer", "llm_infer", traceId, "ok", null, map, 160);
        g("aiengine_llm_infer_start", null, traceId);
        if (f8415a) {
            if (str == null) {
                str = "no-sid";
            }
            PerfettoSink perfettoSink = PerfettoSink.f7999a;
            int i10 = f8416b;
            String strH = h(map);
            perfettoSink.getClass();
            PerfettoSink.c(str, i10, traceId, strH);
        }
    }

    public static boolean f(ContentResolver contentResolver) {
        try {
            return Settings.Global.getInt(contentResolver, "clawbench_probe_profile", 0) != 0;
        } catch (Exception e10) {
            a0.a.A("read clawbench_probe_profile failed, fallback to false: ", e10.getMessage(), "clawbench_probe");
            return false;
        }
    }

    public static void g(String str, Long l10, String str2) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("ts", f8417c.format(new Date(jCurrentTimeMillis)));
        linkedHashMap.put(FileResponse.FIELD_TYPE, str);
        linkedHashMap.put("trace_id", str2);
        linkedHashMap.put("session_id", "");
        if (l10 != null) {
            linkedHashMap.put("duration_ms", l10);
        }
        synchronized (f.f8419a) {
            f.a(jCurrentTimeMillis);
            f.b bVar = f.f8423e;
            if (bVar != null) {
                bVar.f8430d.add(linkedHashMap);
            }
        }
    }

    public static String h(Map map) {
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
                    kotlin.c.a(th);
                }
            }
        }
        if (jSONObject.length() == 0) {
            return null;
        }
        return jSONObject.toString();
    }
}
