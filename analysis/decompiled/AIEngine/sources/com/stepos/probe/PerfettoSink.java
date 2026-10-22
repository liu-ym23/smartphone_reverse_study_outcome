package com.stepos.probe;

import a0.a;
import android.os.Process;
import android.util.Log;
import java.util.Iterator;
import kotlin.c;
import kotlin.jvm.internal.g;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import lb.n;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class PerfettoSink {

    /* renamed from: a, reason: collision with root package name */
    public static final PerfettoSink f7999a;

    /* renamed from: b, reason: collision with root package name */
    public static final CoroutineScope f8000b;

    static {
        PerfettoSink perfettoSink = new PerfettoSink();
        f7999a = perfettoSink;
        Process.myPid();
        f8000b = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO().plus(SupervisorKt.SupervisorJob$default(null, 1, null)));
        try {
            System.loadLibrary("perfetto_jni");
            perfettoSink.nativeInit();
            Log.i("clawbench_perfetto", "Perfetto SDK initialized (system backend)");
        } catch (UnsatisfiedLinkError e10) {
            a.A("libperfetto_jni load failed — Perfetto 通路禁用, logcat 兜底. ", e10.getMessage(), "clawbench_perfetto");
        }
    }

    public static JSONObject a(String str, int i10, String str2, String str3) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("module", "aiengine");
        jSONObject.put("phase", "llm_infer");
        jSONObject.put("lane", str);
        jSONObject.put("pid", i10);
        if (str2.length() > 0) {
            jSONObject.put("trace_id", str2);
        }
        if (str3 != null && str3.length() != 0 && !str3.equals("{}")) {
            try {
                JSONObject jSONObject2 = new JSONObject(str3);
                Iterator<String> itKeys = jSONObject2.keys();
                g.e(itKeys, "keys(...)");
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    Object obj = jSONObject2.get(next);
                    if (obj != null) {
                        jSONObject.put(next, obj);
                    }
                }
                n nVar = n.f10413a;
                return jSONObject;
            } catch (Throwable th) {
                c.a(th);
            }
        }
        return jSONObject;
    }

    public static void b(String name, Integer num, String traceId, String str) throws JSONException {
        g.f(name, "name");
        g.f(traceId, "traceId");
        String strConcat = "cb:".concat(name);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("pid", num.intValue());
        if (traceId.length() > 0) {
            jSONObject.put("trace_id", traceId);
        }
        if (str != null && str.length() != 0 && !str.equals("{}")) {
            try {
                JSONObject jSONObject2 = new JSONObject(str);
                Iterator<String> itKeys = jSONObject2.keys();
                g.e(itKeys, "keys(...)");
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    Object obj = jSONObject2.get(next);
                    if (obj != null) {
                        jSONObject.put(next, obj);
                    }
                }
                n nVar = n.f10413a;
            } catch (Throwable th) {
                c.a(th);
            }
        }
        try {
            PerfettoSink perfettoSink = f7999a;
            String string = jSONObject.toString();
            g.e(string, "toString(...)");
            perfettoSink.nativeInstant(strConcat, name, string);
        } catch (Exception e10) {
            a.A("native call failed: ", e10.getMessage(), "clawbench_perfetto");
        } catch (UnsatisfiedLinkError unused) {
        }
    }

    public static void c(String str, int i10, String traceId, String str2) throws JSONException {
        g.f(traceId, "traceId");
        String strConcat = "cb:aiengine:llm_infer:".concat(str);
        JSONObject jSONObjectA = a(str, i10, traceId, str2);
        try {
            PerfettoSink perfettoSink = f7999a;
            String strConcat2 = "aiengine.llm_infer.".concat(str);
            String string = jSONObjectA.toString();
            g.e(string, "toString(...)");
            perfettoSink.nativeBeginSlice(strConcat, strConcat2, string);
        } catch (Exception e10) {
            a.A("native call failed: ", e10.getMessage(), "clawbench_perfetto");
        } catch (UnsatisfiedLinkError unused) {
        }
    }

    public static void d(String str, int i10, String traceId, String str2) throws JSONException {
        PerfettoSink perfettoSink = f7999a;
        g.f(traceId, "traceId");
        String strConcat = "cb:aiengine:llm_infer:".concat(str);
        JSONObject jSONObjectA = a(str, i10, traceId, null);
        try {
            String string = jSONObjectA.toString();
            g.e(string, "toString(...)");
            perfettoSink.nativeEndSlice(strConcat, string);
        } catch (Exception e10) {
            a.A("native call failed: ", e10.getMessage(), "clawbench_perfetto");
        } catch (UnsatisfiedLinkError unused) {
        }
        if (str2 == null || str2.length() == 0 || str2.equals("{}")) {
            return;
        }
        JSONObject jSONObject = new JSONObject(jSONObjectA.toString());
        try {
            JSONObject jSONObject2 = new JSONObject(str2);
            Iterator<String> itKeys = jSONObject2.keys();
            g.e(itKeys, "keys(...)");
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                jSONObject.put(next, jSONObject2.get(next));
            }
            n nVar = n.f10413a;
        } catch (Throwable th) {
            c.a(th);
        }
        try {
            String string2 = jSONObject.toString();
            g.e(string2, "toString(...)");
            perfettoSink.nativeInstant(strConcat, "llm_infer_end", string2);
        } catch (Exception e11) {
            a.A("native call failed: ", e11.getMessage(), "clawbench_perfetto");
        } catch (UnsatisfiedLinkError unused2) {
        }
    }

    private final native void nativeBeginSlice(String str, String str2, String str3);

    private final native void nativeCounter(String str, int i10);

    private final native void nativeEndSlice(String str, String str2);

    private final native void nativeInit();

    private final native void nativeInstant(String str, String str2, String str3);
}
