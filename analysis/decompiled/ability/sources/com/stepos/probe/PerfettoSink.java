package com.stepos.probe;

import android.os.Process;
import android.util.Log;
import androidx.autofill.HintConstants;
import androidx.constraintlayout.core.dsl.a;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.stepos.ability.commoninternal.Key;
import com.stepos.deepbinder.core.constant.Constants;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.b;
import kotlin.jvm.internal.k;
import m9.AbstractC1683A;
import m9.AbstractC1691I;
import org.json.JSONException;
import org.json.JSONObject;
import u9.c;
import u9.d;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u0002H\u0082 ¢\u0006\u0004\b\u0003\u0010\u0004J(\u0010\t\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005H\u0082 ¢\u0006\u0004\b\t\u0010\nJ \u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005H\u0082 ¢\u0006\u0004\b\u000b\u0010\fJ(\u0010\r\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005H\u0082 ¢\u0006\u0004\b\r\u0010\n¨\u0006\u000e"}, d2 = {"Lcom/stepos/probe/PerfettoSink;", "", "LC7/r;", "nativeInit", "()V", "", "track", HintConstants.AUTOFILL_HINT_NAME, "argsJson", "nativeBeginSlice", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "nativeEndSlice", "(Ljava/lang/String;Ljava/lang/String;)V", "nativeInstant", "probe-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class PerfettoSink {

    /* renamed from: a, reason: collision with root package name */
    public static final PerfettoSink f3964a;

    static {
        PerfettoSink perfettoSink = new PerfettoSink();
        f3964a = perfettoSink;
        Process.myPid();
        d dVar = AbstractC1691I.f5315a;
        AbstractC1683A.b(c.f6743a.plus(AbstractC1683A.c()));
        try {
            System.loadLibrary("perfetto_jni");
            perfettoSink.nativeInit();
            Log.i("clawbench_perfetto", "Perfetto SDK initialized (system backend)");
        } catch (UnsatisfiedLinkError e) {
            a.w("libperfetto_jni load failed — Perfetto 通路禁用, logcat 兜底. ", e.getMessage(), "clawbench_perfetto");
        }
    }

    public static JSONObject a(int i, String str, String str2, String str3, String str4) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("module", "ability");
        jSONObject.put(TypedValues.CycleType.S_WAVE_PHASE, "calltool");
        jSONObject.put("lane", str);
        jSONObject.put(Constants.PARAM_PID, i);
        if (str2.length() > 0) {
            jSONObject.put(Key.KEY_TRACE_ID, str2);
        }
        if (str3.length() > 0) {
            jSONObject.put("session_id", str3);
        }
        if (str4 != null && str4.length() != 0 && !str4.equals("{}")) {
            try {
                JSONObject jSONObject2 = new JSONObject(str4);
                Iterator<String> itKeys = jSONObject2.keys();
                k.e(itKeys, "keys(...)");
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    Object obj = jSONObject2.get(next);
                    if (obj != null) {
                        jSONObject.put(next, obj);
                    }
                }
            } catch (Throwable th) {
                b.a(th);
            }
        }
        return jSONObject;
    }

    public static void b(String name, Integer num, String str, String str2, String str3) throws JSONException {
        k.f(name, "name");
        String strConcat = "cb:".concat(name);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(Constants.PARAM_PID, num.intValue());
        if (str.length() > 0) {
            jSONObject.put(Key.KEY_TRACE_ID, str);
        }
        if (str2.length() > 0) {
            jSONObject.put("session_id", str2);
        }
        if (str3 != null && str3.length() != 0 && !str3.equals("{}")) {
            try {
                JSONObject jSONObject2 = new JSONObject(str3);
                Iterator<String> itKeys = jSONObject2.keys();
                k.e(itKeys, "keys(...)");
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    Object obj = jSONObject2.get(next);
                    if (obj != null) {
                        jSONObject.put(next, obj);
                    }
                }
            } catch (Throwable th) {
                b.a(th);
            }
        }
        try {
            PerfettoSink perfettoSink = f3964a;
            String string = jSONObject.toString();
            k.e(string, "toString(...)");
            perfettoSink.nativeInstant(strConcat, name, string);
        } catch (Exception e) {
            a.w("native call failed: ", e.getMessage(), "clawbench_perfetto");
        } catch (UnsatisfiedLinkError unused) {
        }
    }

    public static void c(int i, String str, String str2, String str3, String str4) throws JSONException {
        String strConcat = "cb:ability:calltool:".concat(str);
        JSONObject jSONObjectA = a(i, str, str2, str3, str4);
        try {
            PerfettoSink perfettoSink = f3964a;
            String strConcat2 = "ability.calltool.".concat(str);
            String string = jSONObjectA.toString();
            k.e(string, "toString(...)");
            perfettoSink.nativeBeginSlice(strConcat, strConcat2, string);
        } catch (Exception e) {
            a.w("native call failed: ", e.getMessage(), "clawbench_perfetto");
        } catch (UnsatisfiedLinkError unused) {
        }
    }

    public static void d(int i, String str, String str2, String str3, String str4) throws JSONException {
        PerfettoSink perfettoSink = f3964a;
        String strConcat = "cb:ability:calltool:".concat(str);
        JSONObject jSONObjectA = a(i, str, str2, str3, null);
        try {
            String string = jSONObjectA.toString();
            k.e(string, "toString(...)");
            perfettoSink.nativeEndSlice(strConcat, string);
        } catch (Exception e) {
            a.w("native call failed: ", e.getMessage(), "clawbench_perfetto");
        } catch (UnsatisfiedLinkError unused) {
        }
        if (str4 == null || str4.length() == 0 || str4.equals("{}")) {
            return;
        }
        JSONObject jSONObject = new JSONObject(jSONObjectA.toString());
        try {
            JSONObject jSONObject2 = new JSONObject(str4);
            Iterator<String> itKeys = jSONObject2.keys();
            k.e(itKeys, "keys(...)");
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                jSONObject.put(next, jSONObject2.get(next));
            }
        } catch (Throwable th) {
            b.a(th);
        }
        try {
            String string2 = jSONObject.toString();
            k.e(string2, "toString(...)");
            perfettoSink.nativeInstant(strConcat, "calltool_end", string2);
        } catch (Exception e6) {
            a.w("native call failed: ", e6.getMessage(), "clawbench_perfetto");
        } catch (UnsatisfiedLinkError unused2) {
        }
    }

    private final native void nativeBeginSlice(String track, String name, String argsJson);

    private final native void nativeEndSlice(String track, String argsJson);

    private final native void nativeInit();

    private final native void nativeInstant(String track, String name, String argsJson);
}
