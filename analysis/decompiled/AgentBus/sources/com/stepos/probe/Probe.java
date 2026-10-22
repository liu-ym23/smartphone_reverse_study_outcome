package com.stepos.probe;

import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.provider.Settings;
import android.util.Log;
import c7.j;
import com.stepos.agentcache.core.ServiceContract;
import d7.a0;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import m.x;
import org.json.JSONException;
import org.json.JSONObject;
import q7.k;
import w7.e0;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\f\u0010\rJ\u001f\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0014\u0010\u0015J%\u0010\u0017\u001a\u0004\u0018\u00010\u000f*\u0012\u0012\u0004\u0012\u00020\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0016H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J1\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u000f2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0002¢\u0006\u0004\b\u001d\u0010\u001eJQ\u0010#\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u000f2\u0006\u0010 \u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u000f2\u0016\b\u0002\u0010!\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00162\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b#\u0010$JY\u0010%\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u000f2\u0006\u0010 \u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\u001b2\u0016\b\u0002\u0010!\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00162\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b%\u0010&J]\u0010'\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u000f2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\u0016\b\u0002\u0010!\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00162\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b'\u0010(J5\u0010,\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u000f2\u0006\u0010*\u001a\u00020)2\u0006\u0010+\u001a\u00020\u000f¢\u0006\u0004\b,\u0010-J\u0015\u0010/\u001a\u00020\u00062\u0006\u0010.\u001a\u00020\u000f¢\u0006\u0004\b/\u00100J\u001d\u00103\u001a\u00020\u00062\u0006\u00101\u001a\u00020\u000f2\u0006\u00102\u001a\u00020)¢\u0006\u0004\b3\u00104R\u0014\u00105\u001a\u00020\u000f8\u0002X\u0082T¢\u0006\u0006\n\u0004\b5\u00106R\u0014\u00107\u001a\u00020\u000f8\u0002X\u0082T¢\u0006\u0006\n\u0004\b7\u00106R\"\u00108\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b8\u00109\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R\u0014\u0010>\u001a\u00020)8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b>\u0010?R\u0014\u0010A\u001a\u00020@8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bA\u0010B¨\u0006C"}, d2 = {"Lcom/stepos/probe/Probe;", "", "<init>", "()V", "Landroid/content/Context;", "context", "Lc7/r;", "init", "(Landroid/content/Context;)V", "Landroid/content/ContentResolver;", "cr", "", "readSetting", "(Landroid/content/ContentResolver;)Z", "enabled", "", "source", "applySetting", "(ZLjava/lang/String;)V", "sessionId", "laneFromSession", "(Ljava/lang/String;)Ljava/lang/String;", "", "toJsonOrNull", "(Ljava/util/Map;)Ljava/lang/String;", "type", ServiceContract.RequiredKeys.TRACE_ID, "", "durationMs", "recordEvent", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;)V", "module", "phase", "extras", "laneKey", "phaseStart", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;)V", "phaseEnd", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/util/Map;Ljava/lang/String;)V", "event", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/util/Map;Ljava/lang/String;)V", "", "errorCode", "errorMsg", "fail", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)V", "label", "mark", "(Ljava/lang/String;)V", "name", "value", "counter", "(Ljava/lang/String;I)V", "TAG", "Ljava/lang/String;", "SETTINGS_KEY", "profileEnabled", "Z", "getProfileEnabled", "()Z", "setProfileEnabled", "(Z)V", "pid", "I", "Ljava/text/SimpleDateFormat;", "tsFmt", "Ljava/text/SimpleDateFormat;", "probe-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class Probe {
    private static final String SETTINGS_KEY = "clawbench_probe_profile";
    private static final String TAG = "clawbench_probe";
    private static volatile boolean profileEnabled;
    public static final Probe INSTANCE = new Probe();
    private static final int pid = Process.myPid();
    private static final SimpleDateFormat tsFmt = new SimpleDateFormat("HH:mm:ss.SSS", Locale.US);

    private Probe() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void applySetting(boolean enabled, String source) {
        if (enabled == profileEnabled && k.a(source, "init")) {
            Log.i(TAG, "init: profileEnabled=" + enabled + " (key=clawbench_probe_profile)");
            return;
        }
        boolean z4 = enabled != profileEnabled;
        profileEnabled = enabled;
        Log.i(TAG, "profile " + source + ": profileEnabled=" + enabled + (z4 ? " (changed)" : "") + " — adb: settings " + (enabled ? "delete" : "put") + " global clawbench_probe_profile " + (enabled ? "" : "0"));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void event$default(Probe probe, String str, String str2, String str3, String str4, Long l6, Map map, String str5, int i2, Object obj) throws JSONException {
        if ((i2 & 16) != 0) {
            l6 = null;
        }
        if ((i2 & 32) != 0) {
            map = a0.f2944f;
        }
        if ((i2 & 64) != 0) {
            str5 = null;
        }
        probe.event(str, str2, str3, str4, l6, map, str5);
    }

    public static final void init(Context context) {
        k.e(context, "context");
        final ContentResolver contentResolver = context.getContentResolver();
        Probe probe = INSTANCE;
        k.b(contentResolver);
        probe.applySetting(probe.readSetting(contentResolver), "init");
        contentResolver.registerContentObserver(Settings.Global.getUriFor(SETTINGS_KEY), false, new ContentObserver(new Handler(Looper.getMainLooper())) { // from class: com.stepos.probe.Probe.init.1
            @Override // android.database.ContentObserver
            public void onChange(boolean selfChange) {
                Probe probe2 = Probe.INSTANCE;
                ContentResolver contentResolver2 = contentResolver;
                k.b(contentResolver2);
                probe2.applySetting(probe2.readSetting(contentResolver2), "settings");
            }
        });
    }

    private final String laneFromSession(String sessionId) {
        if (sessionId.length() == 0) {
            return "no-sid";
        }
        String strG0 = ga.k.G0(':', sessionId, sessionId);
        if (strG0.length() < 8) {
            return strG0;
        }
        String strSubstring = strG0.substring(0, 8);
        k.d(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static /* synthetic */ void phaseStart$default(Probe probe, String str, String str2, String str3, String str4, Map map, String str5, int i2, Object obj) throws JSONException {
        if ((i2 & 16) != 0) {
            map = a0.f2944f;
        }
        Map map2 = map;
        if ((i2 & 32) != 0) {
            str5 = null;
        }
        probe.phaseStart(str, str2, str3, str4, map2, str5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean readSetting(ContentResolver cr) {
        try {
            return Settings.Global.getInt(cr, SETTINGS_KEY, 0) != 0;
        } catch (Exception e10) {
            x.v("read clawbench_probe_profile failed, fallback to false: ", e10.getMessage(), TAG);
            return false;
        }
    }

    private final void recordEvent(String type, String traceId, String sessionId, Long durationMs) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("ts", tsFmt.format(new Date(jCurrentTimeMillis)));
        linkedHashMap.put("type", type);
        linkedHashMap.put("trace_id", traceId);
        linkedHashMap.put("session_id", sessionId);
        if (durationMs != null) {
            linkedHashMap.put("duration_ms", durationMs);
        }
        ReleaseBuckets.INSTANCE.addEvent(jCurrentTimeMillis, linkedHashMap);
    }

    private final String toJsonOrNull(Map<String, ? extends Object> map) {
        if (map == null || map.isEmpty()) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry<String, ? extends Object> entry : map.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (value != null) {
                try {
                    jSONObject.put(key, value);
                } catch (Throwable th) {
                    e0.n(th);
                }
            }
        }
        if (jSONObject.length() == 0) {
            return null;
        }
        return jSONObject.toString();
    }

    public final void counter(String name, int value) {
        k.e(name, "name");
        if (profileEnabled) {
            PerfettoSink.INSTANCE.emit(name, value);
        }
    }

    public final void event(String module, String type, String traceId, String sessionId, Long durationMs, Map<String, ? extends Object> extras, String laneKey) throws JSONException {
        k.e(module, "module");
        k.e(type, "type");
        k.e(traceId, ServiceContract.RequiredKeys.TRACE_ID);
        k.e(sessionId, "sessionId");
        k.e(extras, "extras");
        ProbeLine.emit$default(ProbeLine.INSTANCE, type, type, module, traceId, sessionId, 0L, "ok", durationMs, extras, 32, null);
        recordEvent(type, traceId, sessionId, durationMs);
        if (profileEnabled) {
            PerfettoSink.INSTANCE.instant(x.l(module, ":", type, ":", laneKey == null ? laneFromSession(sessionId) : laneKey), Integer.valueOf(pid), traceId, sessionId, toJsonOrNull(extras));
        }
    }

    public final void fail(String module, String traceId, String sessionId, int errorCode, String errorMsg) {
        k.e(module, "module");
        k.e(traceId, ServiceContract.RequiredKeys.TRACE_ID);
        k.e(sessionId, "sessionId");
        k.e(errorMsg, "errorMsg");
        ProbeLine.emit$default(ProbeLine.INSTANCE, module.concat("_error"), "error", module, traceId, sessionId, 0L, "failed", null, d7.e0.U(new j("error_code", Integer.valueOf(errorCode)), new j("error_msg", errorMsg)), 160, null);
        recordEvent(module.concat("_error"), traceId, sessionId, null);
    }

    public final boolean getProfileEnabled() {
        return profileEnabled;
    }

    public final void mark(String label) {
        k.e(label, "label");
        if (profileEnabled) {
            PerfettoSink.mark$default(PerfettoSink.INSTANCE, label, null, 2, null);
        }
    }

    public final void phaseEnd(String module, String phase, String traceId, String sessionId, long durationMs, Map<String, ? extends Object> extras, String laneKey) throws JSONException {
        k.e(module, "module");
        k.e(phase, "phase");
        k.e(traceId, ServiceContract.RequiredKeys.TRACE_ID);
        k.e(sessionId, "sessionId");
        k.e(extras, "extras");
        ProbeLine.emit$default(ProbeLine.INSTANCE, a1.a.x(module, "_", phase), phase, module, traceId, sessionId, 0L, "ok", Long.valueOf(durationMs), extras, 32, null);
        recordEvent(a1.a.x(module, "_", phase), traceId, sessionId, Long.valueOf(durationMs));
        if (profileEnabled) {
            PerfettoSink.INSTANCE.phaseEnd(pid, module, phase, laneKey == null ? laneFromSession(sessionId) : laneKey, traceId, sessionId, toJsonOrNull(extras));
        }
    }

    public final void phaseStart(String module, String phase, String traceId, String sessionId, Map<String, ? extends Object> extras, String laneKey) throws JSONException {
        k.e(module, "module");
        k.e(phase, "phase");
        k.e(traceId, ServiceContract.RequiredKeys.TRACE_ID);
        k.e(sessionId, "sessionId");
        k.e(extras, "extras");
        ProbeLine.emit$default(ProbeLine.INSTANCE, a1.a.x(module, "_", phase), phase, module, traceId, sessionId, 0L, "ok", null, extras, 160, null);
        recordEvent(module + "_" + phase + "_start", traceId, sessionId, null);
        if (profileEnabled) {
            PerfettoSink.INSTANCE.phaseBegin(pid, module, phase, laneKey == null ? laneFromSession(sessionId) : laneKey, traceId, sessionId, toJsonOrNull(extras));
        }
    }

    public final void setProfileEnabled(boolean z4) {
        profileEnabled = z4;
    }
}
