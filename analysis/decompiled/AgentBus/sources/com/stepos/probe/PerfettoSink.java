package com.stepos.probe;

import android.os.Process;
import android.util.Log;
import com.stepos.agentcache.core.ServiceContract;
import g7.i;
import ga.r;
import ia.b0;
import ia.d0;
import ia.n0;
import ia.x1;
import java.io.File;
import java.util.Iterator;
import kotlin.Metadata;
import m.x;
import n7.l;
import org.json.JSONException;
import org.json.JSONObject;
import pa.d;
import pa.e;
import q7.k;
import w7.e0;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0005\u0010\u0003JI\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\bH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0019\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0012\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u001e\u0010\u0018\u001a\u00020\u00042\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00040\u0016H\u0082\b¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\u0004H\u0082 ¢\u0006\u0004\b\u001a\u0010\u0003J(\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\bH\u0082 ¢\u0006\u0004\b\u001e\u0010\u001fJ \u0010 \u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\bH\u0082 ¢\u0006\u0004\b \u0010!J(\u0010\"\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\bH\u0082 ¢\u0006\u0004\b\"\u0010\u001fJ \u0010$\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\b2\u0006\u0010#\u001a\u00020\u0006H\u0082 ¢\u0006\u0004\b$\u0010%J\u001d\u0010&\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\b2\u0006\u0010#\u001a\u00020\u0006¢\u0006\u0004\b&\u0010%J!\u0010(\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\b2\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b(\u0010)JM\u0010*\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\b2\b\b\u0002\u0010\f\u001a\u00020\b2\b\b\u0002\u0010\r\u001a\u00020\b2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b*\u0010+JM\u0010,\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\b2\b\b\u0002\u0010\f\u001a\u00020\b2\b\b\u0002\u0010\r\u001a\u00020\b2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b,\u0010+JA\u0010-\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\b2\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\f\u001a\u00020\b2\b\b\u0002\u0010\r\u001a\u00020\b2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b-\u0010.J\u001d\u00100\u001a\u00020/2\u0006\u0010\u001c\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\b¢\u0006\u0004\b0\u00101R\u0014\u00102\u001a\u00020\b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b2\u00103R\u0014\u00104\u001a\u00020\b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b4\u00103R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u00105R\u0014\u00107\u001a\u0002068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b7\u00108¨\u00069"}, d2 = {"Lcom/stepos/probe/PerfettoSink;", "", "<init>", "()V", "Lc7/r;", "warmup", "", "pid", "", "module", "phase", "laneKey", ServiceContract.RequiredKeys.TRACE_ID, "sessionId", "extrasJson", "Lorg/json/JSONObject;", "buildBaseArgs", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lorg/json/JSONObject;", "path", "", "readLong", "(Ljava/lang/String;)Ljava/lang/Long;", "Lkotlin/Function0;", "block", "tryRun", "(Lp7/a;)V", "nativeInit", "track", "name", "argsJson", "nativeBeginSlice", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "nativeEndSlice", "(Ljava/lang/String;Ljava/lang/String;)V", "nativeInstant", "value", "nativeCounter", "(Ljava/lang/String;I)V", "emit", "pidOverride", "mark", "(Ljava/lang/String;Ljava/lang/Integer;)V", "phaseBegin", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "phaseEnd", "instant", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "", "emitSysfs", "(Ljava/lang/String;Ljava/lang/String;)Z", "TAG", "Ljava/lang/String;", "PREFIX", "I", "Lia/b0;", "markScope", "Lia/b0;", "probe-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class PerfettoSink {
    public static final PerfettoSink INSTANCE;
    private static final String PREFIX = "cb_";
    private static final String TAG = "clawbench_perfetto";
    private static final b0 markScope;
    private static final int pid;

    static {
        PerfettoSink perfettoSink = new PerfettoSink();
        INSTANCE = perfettoSink;
        pid = Process.myPid();
        e eVar = n0.f4982a;
        d dVar = d.f8556h;
        x1 x1VarC = d0.c();
        dVar.getClass();
        markScope = d0.b(i.plus(dVar, x1VarC));
        try {
            System.loadLibrary("perfetto_jni");
            perfettoSink.nativeInit();
            Log.i(TAG, "Perfetto SDK initialized (system backend)");
        } catch (UnsatisfiedLinkError e10) {
            x.v("libperfetto_jni load failed — Perfetto 通路禁用, logcat 兜底. ", e10.getMessage(), TAG);
        }
    }

    private PerfettoSink() {
    }

    private final JSONObject buildBaseArgs(int pid2, String module, String phase, String laneKey, String traceId, String sessionId, String extrasJson) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("module", module);
        jSONObject.put("phase", phase);
        jSONObject.put("lane", laneKey);
        jSONObject.put("pid", pid2);
        if (traceId.length() > 0) {
            jSONObject.put("trace_id", traceId);
        }
        if (sessionId.length() > 0) {
            jSONObject.put("session_id", sessionId);
        }
        if (extrasJson != null && extrasJson.length() != 0 && !extrasJson.equals("{}")) {
            try {
                JSONObject jSONObject2 = new JSONObject(extrasJson);
                Iterator<String> itKeys = jSONObject2.keys();
                k.d(itKeys, "keys(...)");
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    Object obj = jSONObject2.get(next);
                    if (obj != null) {
                        jSONObject.put(next, obj);
                    }
                }
            } catch (Throwable th) {
                e0.n(th);
            }
        }
        return jSONObject;
    }

    public static /* synthetic */ void instant$default(PerfettoSink perfettoSink, String str, Integer num, String str2, String str3, String str4, int i2, Object obj) throws JSONException {
        if ((i2 & 2) != 0) {
            num = null;
        }
        if ((i2 & 4) != 0) {
            str2 = "";
        }
        if ((i2 & 8) != 0) {
            str3 = "";
        }
        if ((i2 & 16) != 0) {
            str4 = null;
        }
        perfettoSink.instant(str, num, str2, str3, str4);
    }

    public static /* synthetic */ void mark$default(PerfettoSink perfettoSink, String str, Integer num, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            num = null;
        }
        perfettoSink.mark(str, num);
    }

    private final native void nativeBeginSlice(String track, String name, String argsJson);

    /* JADX INFO: Access modifiers changed from: private */
    public final native void nativeCounter(String track, int value);

    private final native void nativeEndSlice(String track, String argsJson);

    private final native void nativeInit();

    private final native void nativeInstant(String track, String name, String argsJson);

    public static /* synthetic */ void phaseBegin$default(PerfettoSink perfettoSink, int i2, String str, String str2, String str3, String str4, String str5, String str6, int i10, Object obj) throws JSONException {
        if ((i10 & 16) != 0) {
            str4 = "";
        }
        if ((i10 & 32) != 0) {
            str5 = "";
        }
        if ((i10 & 64) != 0) {
            str6 = null;
        }
        perfettoSink.phaseBegin(i2, str, str2, str3, str4, str5, str6);
    }

    public static /* synthetic */ void phaseEnd$default(PerfettoSink perfettoSink, int i2, String str, String str2, String str3, String str4, String str5, String str6, int i10, Object obj) throws JSONException {
        if ((i10 & 16) != 0) {
            str4 = "";
        }
        if ((i10 & 32) != 0) {
            str5 = "";
        }
        if ((i10 & 64) != 0) {
            str6 = null;
        }
        perfettoSink.phaseEnd(i2, str, str2, str3, str4, str5, str6);
    }

    private final Long readLong(String path) {
        try {
            return r.j0(ga.k.N0(l.N(new File(path))).toString());
        } catch (Exception unused) {
            return null;
        }
    }

    private final void tryRun(p7.a block) {
        try {
            block.c();
        } catch (Exception e10) {
            x.v("native call failed: ", e10.getMessage(), TAG);
        } catch (UnsatisfiedLinkError unused) {
        }
    }

    public static final void warmup() {
    }

    public final void emit(String name, int value) {
        k.e(name, "name");
        if (!r.g0(name, PREFIX, false)) {
            name = PREFIX.concat(name);
        }
        try {
            INSTANCE.nativeCounter(name, value);
        } catch (Exception e10) {
            x.v("native call failed: ", e10.getMessage(), TAG);
        } catch (UnsatisfiedLinkError unused) {
        }
    }

    public final boolean emitSysfs(String name, String path) {
        k.e(name, "name");
        k.e(path, "path");
        Long l6 = readLong(path);
        if (l6 == null) {
            return false;
        }
        long jLongValue = l6.longValue();
        if (-2147483648L > jLongValue || jLongValue > 2147483647L) {
            jLongValue /= 1000;
        }
        emit(name, (int) jLongValue);
        return true;
    }

    public final void instant(String name, Integer pidOverride, String traceId, String sessionId, String extrasJson) throws JSONException {
        k.e(name, "name");
        k.e(traceId, ServiceContract.RequiredKeys.TRACE_ID);
        k.e(sessionId, "sessionId");
        String strConcat = "cb:".concat(name);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("pid", pidOverride != null ? pidOverride.intValue() : pid);
        if (traceId.length() > 0) {
            jSONObject.put("trace_id", traceId);
        }
        if (sessionId.length() > 0) {
            jSONObject.put("session_id", sessionId);
        }
        if (extrasJson != null && extrasJson.length() != 0 && !extrasJson.equals("{}")) {
            try {
                JSONObject jSONObject2 = new JSONObject(extrasJson);
                Iterator<String> itKeys = jSONObject2.keys();
                k.d(itKeys, "keys(...)");
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    Object obj = jSONObject2.get(next);
                    if (obj != null) {
                        jSONObject.put(next, obj);
                    }
                }
            } catch (Throwable th) {
                e0.n(th);
            }
        }
        try {
            PerfettoSink perfettoSink = INSTANCE;
            String string = jSONObject.toString();
            k.d(string, "toString(...)");
            perfettoSink.nativeInstant(strConcat, name, string);
        } catch (Exception e10) {
            x.v("native call failed: ", e10.getMessage(), TAG);
        } catch (UnsatisfiedLinkError unused) {
        }
    }

    public final void mark(String traceId, Integer pidOverride) {
        k.e(traceId, ServiceContract.RequiredKeys.TRACE_ID);
        String strConcat = "cb_mark_".concat(traceId);
        try {
            INSTANCE.nativeCounter(strConcat, 100);
            d0.s(markScope, null, null, new PerfettoSink$mark$1$1(strConcat, null), 3);
            Log.i(TAG, "mark traceId=" + traceId + " (cb_mark_" + traceId + " pulse)");
        } catch (Exception e10) {
            x.v("native call failed: ", e10.getMessage(), TAG);
        } catch (UnsatisfiedLinkError unused) {
        }
    }

    public final void phaseBegin(int pid2, String module, String phase, String laneKey, String traceId, String sessionId, String extrasJson) throws JSONException {
        k.e(module, "module");
        k.e(phase, "phase");
        k.e(laneKey, "laneKey");
        k.e(traceId, ServiceContract.RequiredKeys.TRACE_ID);
        k.e(sessionId, "sessionId");
        StringBuilder sb2 = new StringBuilder("cb:");
        x.w(sb2, module, ":", phase, ":");
        sb2.append(laneKey);
        String string = sb2.toString();
        JSONObject jSONObjectBuildBaseArgs = buildBaseArgs(pid2, module, phase, laneKey, traceId, sessionId, extrasJson);
        try {
            String string2 = jSONObjectBuildBaseArgs.toString();
            k.d(string2, "toString(...)");
            INSTANCE.nativeBeginSlice(string, module + "." + phase + "." + laneKey, string2);
        } catch (Exception e10) {
            x.v("native call failed: ", e10.getMessage(), TAG);
        } catch (UnsatisfiedLinkError unused) {
        }
    }

    public final void phaseEnd(int pid2, String module, String phase, String laneKey, String traceId, String sessionId, String extrasJson) throws JSONException {
        k.e(module, "module");
        k.e(phase, "phase");
        k.e(laneKey, "laneKey");
        k.e(traceId, ServiceContract.RequiredKeys.TRACE_ID);
        k.e(sessionId, "sessionId");
        StringBuilder sb2 = new StringBuilder("cb:");
        x.w(sb2, module, ":", phase, ":");
        sb2.append(laneKey);
        String string = sb2.toString();
        JSONObject jSONObjectBuildBaseArgs = buildBaseArgs(pid2, module, phase, laneKey, traceId, sessionId, null);
        try {
            PerfettoSink perfettoSink = INSTANCE;
            String string2 = jSONObjectBuildBaseArgs.toString();
            k.d(string2, "toString(...)");
            perfettoSink.nativeEndSlice(string, string2);
        } catch (Exception e10) {
            x.v("native call failed: ", e10.getMessage(), TAG);
        } catch (UnsatisfiedLinkError unused) {
        }
        if (extrasJson == null || extrasJson.length() == 0 || extrasJson.equals("{}")) {
            return;
        }
        JSONObject jSONObject = new JSONObject(jSONObjectBuildBaseArgs.toString());
        try {
            JSONObject jSONObject2 = new JSONObject(extrasJson);
            Iterator<String> itKeys = jSONObject2.keys();
            k.d(itKeys, "keys(...)");
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                jSONObject.put(next, jSONObject2.get(next));
            }
        } catch (Throwable th) {
            e0.n(th);
        }
        try {
            String string3 = jSONObject.toString();
            k.d(string3, "toString(...)");
            INSTANCE.nativeInstant(string, phase + "_end", string3);
        } catch (Exception e11) {
            x.v("native call failed: ", e11.getMessage(), TAG);
        } catch (UnsatisfiedLinkError unused2) {
        }
    }
}
