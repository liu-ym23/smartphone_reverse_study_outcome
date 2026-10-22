package z2;

import B9.Z;
import B9.a0;
import a.AbstractC0291a;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.view.ContextThemeWrapper;
import androidx.compose.material3.internal.CalendarModelKt;
import com.stepos.ability.R;
import com.stepos.agentcache.sdk.api.AgentCacheSdk;
import com.stepos.agentcache.sdk.api.LogLevel;
import com.stepos.agentcache.sdk.api.LogMessage;
import com.stepos.taskrobot.base.datareport.DataReportLogLevel;
import g1.AbstractC1451a;
import h8.InterfaceC1501I;
import j9.t;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.security.MessageDigest;
import java.util.Collection;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import k9.AbstractC1651b;
import k9.C1650a;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.builders.MapBuilder;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.model.TypeVariance;
import kotlin.time.DurationUnit;
import org.json.JSONObject;
import z9.C2199a;

/* loaded from: classes2.dex */
public abstract class l {

    /* renamed from: a, reason: collision with root package name */
    public static volatile r f6934a = null;
    public static Application b = null;
    public static Context c = null;
    public static String d = null;
    public static long e = -1;
    public static boolean f = false;
    public static h2.c g = null;
    public static ActivityManager.ProcessErrorStateInfo h = null;
    public static u1.d i = null;

    /* renamed from: j, reason: collision with root package name */
    public static String f6935j = "";
    public static long k = -30000;
    public static File l;

    public static boolean A(Context context) {
        try {
            String strV = AbstractC0291a.v("persist.stepos.usagestats.debug", "");
            if (strV == null) {
                return false;
            }
            if (strV.equals("all")) {
                return true;
            }
            return strV.equals(context.getPackageName());
        } catch (Exception e6) {
            androidx.constraintlayout.core.dsl.a.t(e6, new StringBuilder("isDebugMode error "), "CommonUtils");
            return false;
        }
    }

    public static final boolean B(InterfaceC1501I interfaceC1501I) {
        kotlin.jvm.internal.k.f(interfaceC1501I, "<this>");
        return interfaceC1501I.getGetter() == null;
    }

    public static H7.h C(H7.f fVar, H7.g key) {
        kotlin.jvm.internal.k.f(key, "key");
        return kotlin.jvm.internal.k.b(fVar.getKey(), key) ? EmptyCoroutineContext.f4908a : fVar;
    }

    public static s4.e D(String payloadJson, boolean z10) {
        kotlin.jvm.internal.k.f(payloadJson, "payloadJson");
        try {
            JSONObject jSONObjectOptJSONObject = new JSONObject(payloadJson).optJSONObject("rules");
            if (jSONObjectOptJSONObject == null) {
                return null;
            }
            String strOptString = jSONObjectOptJSONObject.optString("rules_ext");
            kotlin.jvm.internal.k.e(strOptString, "optString(...)");
            String string = j9.m.R0(strOptString).toString();
            if (string.length() == 0) {
                return null;
            }
            JSONObject jSONObject = new JSONObject(string);
            return new s4.e(G(jSONObject.optJSONObject("tool_scope_all")), F(jSONObject.optJSONObject("scopes")), z10);
        } catch (Exception unused) {
            return null;
        }
    }

    public static final long E(String str) {
        char cCharAt;
        int length = str.length();
        int i6 = (length <= 0 || !j9.m.i0("+-", str.charAt(0))) ? 0 : 1;
        if (length - i6 > 16) {
            int i10 = i6;
            while (true) {
                if (i6 < length) {
                    char cCharAt2 = str.charAt(i6);
                    if (cCharAt2 == '0') {
                        if (i10 == i6) {
                            i10++;
                        }
                    } else if ('1' > cCharAt2 || cCharAt2 >= ':') {
                        break;
                    }
                    i6++;
                } else if (length - i10 > 16) {
                    return str.charAt(0) == '-' ? Long.MIN_VALUE : Long.MAX_VALUE;
                }
            }
        }
        return (!t.e0(str, "+", false) || length <= 1 || '0' > (cCharAt = str.charAt(1)) || cCharAt >= ':') ? Long.parseLong(str) : Long.parseLong(j9.m.j0(1, str));
    }

    public static Map F(JSONObject jSONObject) {
        if (jSONObject == null) {
            return kotlin.collections.a.M();
        }
        MapBuilder mapBuilder = new MapBuilder();
        Iterator<String> itKeys = jSONObject.keys();
        kotlin.jvm.internal.k.e(itKeys, "keys(...)");
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(next);
            if (jSONObjectOptJSONObject != null) {
                String strOptString = jSONObjectOptJSONObject.optString("group_id");
                kotlin.jvm.internal.k.e(strOptString, "optString(...)");
                String string = j9.m.R0(strOptString).toString();
                if (string.length() != 0) {
                    kotlin.jvm.internal.k.c(next);
                    String strOptString2 = jSONObjectOptJSONObject.optString("data_level");
                    kotlin.jvm.internal.k.e(strOptString2, "optString(...)");
                    mapBuilder.put(next, new s4.d(strOptString2, jSONObjectOptJSONObject.optBoolean("redline", false), string));
                }
            }
        }
        return mapBuilder.b();
    }

    public static Map G(JSONObject jSONObject) {
        if (jSONObject == null) {
            return kotlin.collections.a.M();
        }
        MapBuilder mapBuilder = new MapBuilder();
        Iterator<String> itKeys = jSONObject.keys();
        kotlin.jvm.internal.k.e(itKeys, "keys(...)");
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            kotlin.jvm.internal.k.c(next);
            String strOptString = jSONObject.optString(next);
            kotlin.jvm.internal.k.e(strOptString, "optString(...)");
            mapBuilder.put(next, strOptString);
        }
        return mapBuilder.b();
    }

    public static H7.h H(H7.f fVar, H7.h context) {
        kotlin.jvm.internal.k.f(context, "context");
        return context == EmptyCoroutineContext.f4908a ? fVar : (H7.h) context.fold(fVar, new H7.b(1));
    }

    public static final long I(int i6, DurationUnit unit) {
        kotlin.jvm.internal.k.f(unit, "unit");
        return unit.compareTo(DurationUnit.d) <= 0 ? v(H4.o.w(i6, unit, DurationUnit.b)) : J(i6, unit);
    }

    public static final long J(long j5, DurationUnit unit) {
        kotlin.jvm.internal.k.f(unit, "unit");
        DurationUnit durationUnit = DurationUnit.b;
        long jW = H4.o.w(4611686018426999999L, durationUnit, unit);
        if ((-jW) <= j5 && j5 <= jW) {
            return v(H4.o.w(j5, unit, durationUnit));
        }
        DurationUnit targetUnit = DurationUnit.c;
        kotlin.jvm.internal.k.f(targetUnit, "targetUnit");
        return t(AbstractC1451a.v(targetUnit.f5171a.convert(j5, unit.f5171a), -4611686018427387903L, 4611686018427387903L));
    }

    public static final Z a(String str, z9.f kind) {
        kotlin.jvm.internal.k.f(kind, "kind");
        if (j9.m.s0(str)) {
            throw new IllegalArgumentException("Blank serial names are prohibited");
        }
        a0.a(str);
        return new Z(str, kind);
    }

    public static final z9.m b(String str, z9.g original) {
        kotlin.jvm.internal.k.f(original, "original");
        if (j9.m.s0(str)) {
            throw new IllegalArgumentException("Blank serial names are prohibited");
        }
        if (!str.equals(original.h())) {
            if (original.getKind() instanceof z9.f) {
                a0.a(str);
            }
            return new z9.m(str, original);
        }
        StringBuilder sbV = B7.a.v("The name of the wrapped descriptor (", str, ") cannot be the same as the name of the original descriptor (");
        sbV.append(original.h());
        sbV.append(')');
        throw new IllegalArgumentException(sbV.toString().toString());
    }

    public static String c(long j5, String str) {
        try {
            return M.a.c(new File(N9.j.C(com.apm.insight.g.f2160a), "apminsight/TrackInfo/" + ((j5 - (j5 % CalendarModelKt.MillisecondsIn24Hours)) / CalendarModelKt.MillisecondsIn24Hours) + "/" + str));
        } catch (Throwable th) {
            return th.getMessage();
        }
    }

    public static String d(Context context) {
        try {
            if (!TextUtils.isEmpty(f6935j)) {
                return f6935j;
            }
            byte[] bArrDigest = MessageDigest.getInstance("SHA1").digest(context.getPackageManager().getPackageInfo(context.getPackageName(), 64).signatures[0].toByteArray());
            StringBuffer stringBuffer = new StringBuffer();
            for (byte b5 : bArrDigest) {
                String upperCase = Integer.toHexString(b5 & 255).toUpperCase(Locale.US);
                if (upperCase.length() == 1) {
                    stringBuffer.append("0");
                }
                stringBuffer.append(upperCase);
                stringBuffer.append(":");
            }
            String string = stringBuffer.toString();
            String strSubstring = string.substring(0, string.length() - 1);
            f6935j = strSubstring;
            return strSubstring;
        } catch (PackageManager.NameNotFoundException e6) {
            e6.printStackTrace();
            return null;
        } catch (Exception e9) {
            e9.printStackTrace();
            return null;
        }
    }

    public static String e(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(str.getBytes());
            byte[] bArrDigest = messageDigest.digest();
            if (bArrDigest.length <= 0) {
                return null;
            }
            char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
            char[] cArr2 = new char[bArrDigest.length * 2];
            int i6 = 0;
            for (byte b5 : bArrDigest) {
                int i10 = i6 + 1;
                cArr2[i6] = cArr[(b5 >>> 4) & 15];
                i6 += 2;
                cArr2[i10] = cArr[b5 & 15];
            }
            return new String(cArr2);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static JSONObject f() {
        try {
            StackTraceElement[] stackTrace = Looper.getMainLooper().getThread().getStackTrace();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("thread_number", 1);
            jSONObject.put("mainStackFromTrace", y2.e.d(stackTrace));
            return jSONObject;
        } catch (Throwable th) {
            int i6 = com.apm.insight.b.f2156a;
            M0.i.k("NPTH_CATCH", th);
            return null;
        }
    }

    public static final long g(String str) throws NumberFormatException {
        DurationUnit durationUnit;
        char cCharAt;
        int length = str.length();
        if (length == 0) {
            throw new IllegalArgumentException("The string is empty");
        }
        int i6 = C1650a.d;
        char cCharAt2 = str.charAt(0);
        int i10 = (cCharAt2 == '+' || cCharAt2 == '-') ? 1 : 0;
        boolean z10 = i10 > 0 && j9.m.F0(str, '-');
        if (length <= i10) {
            throw new IllegalArgumentException("No components");
        }
        if (str.charAt(i10) != 'P') {
            throw new IllegalArgumentException();
        }
        int i11 = i10 + 1;
        if (i11 == length) {
            throw new IllegalArgumentException();
        }
        DurationUnit durationUnit2 = null;
        long jE = 0;
        boolean z11 = false;
        while (i11 < length) {
            if (str.charAt(i11) != 'T') {
                int i12 = i11;
                while (i12 < str.length() && (('0' <= (cCharAt = str.charAt(i12)) && cCharAt < ':') || j9.m.i0("+-.", cCharAt))) {
                    i12++;
                }
                String strSubstring = str.substring(i11, i12);
                kotlin.jvm.internal.k.e(strSubstring, "substring(...)");
                if (strSubstring.length() == 0) {
                    throw new IllegalArgumentException();
                }
                int length2 = strSubstring.length() + i11;
                if (length2 < 0 || length2 >= str.length()) {
                    throw new IllegalArgumentException("Missing unit for value ".concat(strSubstring));
                }
                char cCharAt3 = str.charAt(length2);
                int i13 = length2 + 1;
                if (z11) {
                    if (cCharAt3 == 'H') {
                        durationUnit = DurationUnit.f;
                    } else if (cCharAt3 == 'M') {
                        durationUnit = DurationUnit.e;
                    } else {
                        if (cCharAt3 != 'S') {
                            throw new IllegalArgumentException("Invalid duration ISO time unit: " + cCharAt3);
                        }
                        durationUnit = DurationUnit.d;
                    }
                } else {
                    if (cCharAt3 != 'D') {
                        throw new IllegalArgumentException("Invalid or unsupported duration ISO non-time unit: " + cCharAt3);
                    }
                    durationUnit = DurationUnit.g;
                }
                if (durationUnit2 != null && durationUnit2.compareTo(durationUnit) <= 0) {
                    throw new IllegalArgumentException("Unexpected order of duration components");
                }
                int iP0 = j9.m.p0(strSubstring, '.', 0, 6);
                if (durationUnit != DurationUnit.d || iP0 <= 0) {
                    jE = C1650a.e(jE, J(E(strSubstring), durationUnit));
                } else {
                    String strSubstring2 = strSubstring.substring(0, iP0);
                    kotlin.jvm.internal.k.e(strSubstring2, "substring(...)");
                    long jE2 = C1650a.e(jE, J(E(strSubstring2), durationUnit));
                    String strSubstring3 = strSubstring.substring(iP0);
                    kotlin.jvm.internal.k.e(strSubstring3, "substring(...)");
                    double d6 = Double.parseDouble(strSubstring3);
                    double dV = H4.o.v(d6, durationUnit, DurationUnit.b);
                    if (Double.isNaN(dV)) {
                        throw new IllegalArgumentException("Duration value cannot be NaN.");
                    }
                    long jV = U7.a.V(dV);
                    jE = C1650a.e(jE2, (-4611686018426999999L > jV || jV >= 4611686018427000000L) ? u(U7.a.V(H4.o.v(d6, durationUnit, DurationUnit.c))) : v(jV));
                }
                durationUnit2 = durationUnit;
                i11 = i13;
            } else {
                if (z11 || (i11 = i11 + 1) == length) {
                    throw new IllegalArgumentException();
                }
                z11 = true;
            }
        }
        if (!z10) {
            return jE;
        }
        long j5 = ((-(jE >> 1)) << 1) + (((int) jE) & 1);
        int i14 = AbstractC1651b.f4877a;
        return j5;
    }

    public static File h() {
        if (l == null) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            l = new File(N9.j.C(com.apm.insight.g.f2160a), "apminsight/TrackInfo/" + ((jCurrentTimeMillis - (jCurrentTimeMillis % CalendarModelKt.MillisecondsIn24Hours)) / CalendarModelKt.MillisecondsIn24Hours) + "/" + com.apm.insight.g.g());
        }
        return l;
    }

    public static r i() {
        if (f6934a == null) {
            if (f6934a == null) {
                synchronized (l.class) {
                    try {
                        if (f6934a == null) {
                            f6934a = new r("default_npth_thread");
                            f6934a.f6940a.start();
                        }
                    } finally {
                    }
                }
            }
            p pVar = f6934a.f6940a;
        }
        return f6934a;
    }

    public static void j(String str) {
        try {
            c = ((Application) Class.forName("android.app.ActivityThread").getMethod("currentApplication", null).invoke(null, null)).getApplicationContext();
        } catch (Exception unused) {
        }
        Context context = c;
        if (!TextUtils.isEmpty(str)) {
            try {
                System.loadLibrary(str);
                return;
            } catch (Throwable th) {
                StringBuilder sbV = B7.a.v("loadLibrary ", str, " fail! Error: ");
                sbV.append(th.getMessage());
                Log.i("a", sbV.toString());
            }
        }
        if (context != null && !TextUtils.isEmpty(str)) {
            try {
                System.load((context.getApplicationInfo().dataDir + "/lib") + File.separator + "lib" + str + ".so");
                return;
            } catch (Throwable th2) {
                Log.i("a", "load  fail! Error: " + th2.getMessage());
            }
        }
        if (context == null || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            A5.c cVar = new A5.c(5);
            if (str.length() == 0) {
                throw new IllegalArgumentException("Given library is either null or empty");
            }
            A5.c.i("Beginning load of %s...", str);
            cVar.n(context, str);
        } catch (Throwable unused2) {
        }
    }

    public static z9.h k(String str, z9.g[] gVarArr) {
        if (j9.m.s0(str)) {
            throw new IllegalArgumentException("Blank serial names are prohibited");
        }
        C2199a c2199a = new C2199a(str);
        return new z9.h(str, z9.k.c, c2199a.c.size(), D7.q.I0(gVarArr), c2199a);
    }

    public static final z9.h l(String serialName, H4.o oVar, z9.g[] gVarArr, S7.k kVar) {
        kotlin.jvm.internal.k.f(serialName, "serialName");
        if (j9.m.s0(serialName)) {
            throw new IllegalArgumentException("Blank serial names are prohibited");
        }
        if (oVar.equals(z9.k.c)) {
            throw new IllegalArgumentException("For StructureKind.CLASS please use 'buildClassSerialDescriptor' instead");
        }
        C2199a c2199a = new C2199a(serialName);
        kVar.invoke(c2199a);
        return new z9.h(serialName, oVar, c2199a.c.size(), D7.q.I0(gVarArr), c2199a);
    }

    public static z9.h m(String serialName, H4.o oVar, z9.g[] gVarArr) {
        kotlin.jvm.internal.k.f(serialName, "serialName");
        if (j9.m.s0(serialName)) {
            throw new IllegalArgumentException("Blank serial names are prohibited");
        }
        if (oVar.equals(z9.k.c)) {
            throw new IllegalArgumentException("For StructureKind.CLASS please use 'buildClassSerialDescriptor' instead");
        }
        C2199a c2199a = new C2199a(serialName);
        return new z9.h(serialName, oVar, c2199a.c.size(), D7.q.I0(gVarArr), c2199a);
    }

    public static void n(BufferedReader bufferedReader) throws IOException {
        if (bufferedReader == null) {
            return;
        }
        try {
            bufferedReader.close();
        } catch (IOException unused) {
        }
    }

    public static void o(Closeable closeable) throws IOException {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e6) {
                Log.e("CommonUtils", "closeQuietly error " + e6.getMessage());
            }
        }
    }

    public static final TypeVariance p(Variance variance) {
        int iOrdinal = variance.ordinal();
        if (iOrdinal == 0) {
            return TypeVariance.d;
        }
        if (iOrdinal == 1) {
            return TypeVariance.b;
        }
        if (iOrdinal == 2) {
            return TypeVariance.c;
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final void q(int i6, int i10) {
        if (i6 > i10) {
            throw new IndexOutOfBoundsException(androidx.compose.foundation.b.o(i6, "toIndex (", i10, ") is greater than size (", ")."));
        }
    }

    public static final Q.a r(Activity activity, boolean z10) {
        Configuration configuration = new Configuration(activity.getResources().getConfiguration());
        if (z10) {
            configuration.uiMode = (configuration.uiMode & (-49)) | 32;
        }
        ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(activity, R.style.Theme_VoiceWakeup_Dialog_Confirmation);
        contextThemeWrapper.applyOverrideConfiguration(configuration);
        Q.a aVar = new Q.a(contextThemeWrapper);
        A6.n nVar = (A6.n) aVar.b;
        nVar.o = true;
        nVar.n = 1;
        nVar.k = -1;
        nVar.l = 0;
        nVar.e = Integer.MAX_VALUE;
        return aVar;
    }

    public static boolean s(String str, String log, DataReportLogLevel level, String str2, int i6) {
        LogLevel logLevel;
        kotlin.jvm.internal.k.f(log, "log");
        kotlin.jvm.internal.k.f(level, "level");
        AgentCacheSdk agentCacheSdk = AgentCacheSdk.INSTANCE;
        int iOrdinal = level.ordinal();
        if (iOrdinal == 0) {
            logLevel = LogLevel.INFO;
        } else if (iOrdinal == 1) {
            logLevel = LogLevel.WARN;
        } else {
            if (iOrdinal != 2) {
                throw new NoWhenBranchMatchedException();
            }
            logLevel = LogLevel.ERROR;
        }
        return agentCacheSdk.reportLog(str, "gui_agent_call", new LogMessage(logLevel, "trace_log", log, str2), i6);
    }

    public static final long t(long j5) {
        long j6 = (j5 << 1) + 1;
        int i6 = C1650a.d;
        int i10 = AbstractC1651b.f4877a;
        return j6;
    }

    public static final long u(long j5) {
        return (-4611686018426L > j5 || j5 >= 4611686018427L) ? t(AbstractC1451a.v(j5, -4611686018427387903L, 4611686018427387903L)) : v(j5 * 1000000);
    }

    public static final long v(long j5) {
        long j6 = j5 << 1;
        int i6 = C1650a.d;
        int i10 = AbstractC1651b.f4877a;
        return j6;
    }

    public static Object w(H7.f fVar, Object obj, S7.n operation) {
        kotlin.jvm.internal.k.f(operation, "operation");
        return operation.invoke(obj, fVar);
    }

    public static H7.f x(H7.f fVar, H7.g key) {
        kotlin.jvm.internal.k.f(key, "key");
        if (kotlin.jvm.internal.k.b(fVar.getKey(), key)) {
            return fVar;
        }
        return null;
    }

    public static final int y(c8.e eVar) {
        kotlin.jvm.internal.k.f(eVar, "<this>");
        return eVar.a().size();
    }

    public static /* synthetic */ Collection z(Q8.q qVar, Q8.f fVar, int i6) {
        if ((i6 & 1) != 0) {
            fVar = Q8.f.m;
        }
        Q8.o.f1129a.getClass();
        return qVar.c(fVar, Q8.l.b);
    }
}
