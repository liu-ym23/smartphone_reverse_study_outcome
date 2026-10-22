package g2;

import D7.N;
import F.i;
import N9.j;
import android.content.Context;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.apm.insight.CrashType;
import com.apm.insight.ICrashCallback;
import com.apm.insight.MonitorCrash;
import com.apm.insight.Npth;
import com.apm.insight.f;
import com.apm.insight.g;
import com.apm.insight.log.ILog;
import com.apm.insight.log.VLog;
import com.stepos.statsrpk.d;
import e2.C1404a;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;
import java.util.Properties;
import org.json.JSONArray;
import org.json.JSONObject;
import w0.C2085f;

/* renamed from: g2.a, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C1452a implements ICrashCallback {
    public static volatile C1452a c;

    /* renamed from: a, reason: collision with root package name */
    public volatile C2085f f4477a;
    public volatile i b;

    public static F1.b a(String str, List list, String str2) {
        MonitorCrash monitorCrash;
        C1404a c1404aC;
        F1.b bVar = new F1.b();
        if (TextUtils.isEmpty(str)) {
            bVar.e = String.valueOf(g.a().h().get("aid"));
            bVar.d = g.e().h();
        } else {
            bVar.e = str;
            String strB = null;
            if (!TextUtils.isEmpty(str)) {
                try {
                    if (TextUtils.equals(f.j(), str)) {
                        monitorCrash = f.b;
                        if (monitorCrash != null) {
                            strB = monitorCrash.config().getDeviceId();
                        }
                        if (TextUtils.isEmpty(strB) && (c1404aC = C1404a.c(str)) != null) {
                            strB = c1404aC.b();
                        }
                    } else {
                        monitorCrash = (MonitorCrash) f.c.get(str);
                        if (monitorCrash != null) {
                            strB = monitorCrash.config().getDeviceId();
                        }
                        if (TextUtils.isEmpty(strB)) {
                            strB = c1404aC.b();
                        }
                    }
                } catch (Throwable unused) {
                }
            }
            bVar.d = strB;
        }
        bVar.f = str2;
        bVar.g = list;
        return bVar;
    }

    public static C1452a b() {
        if (c == null) {
            synchronized (C1452a.class) {
                try {
                    if (c == null) {
                        C1452a c1452a = new C1452a();
                        c1452a.f4477a = new C2085f(7);
                        c1452a.b = new i();
                        Npth.registerCrashCallback(c1452a, CrashType.ALL);
                        c = c1452a;
                    }
                } finally {
                }
            }
        }
        return c;
    }

    public static void c(int i, int i6, String str) {
        try {
            ILog iLogF = f();
            if (iLogF == null) {
                return;
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("log_type", "process_exit");
            jSONObject.put(NotificationCompat.CATEGORY_SERVICE, "process_exit");
            jSONObject.put("reason", i);
            jSONObject.put("description", str);
            jSONObject.put("status", i6);
            iLogF.e("APMPlus", jSONObject.toString());
        } catch (Throwable unused) {
        }
    }

    public static void e(CrashType crashType, String str, String str2) {
        try {
            ILog iLogF = f();
            if (iLogF == null) {
                return;
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("log_type", "crash");
            jSONObject.put(NotificationCompat.CATEGORY_SERVICE, "crash");
            jSONObject.put("crash_type", crashType);
            if (str.length() > 3000) {
                str = str.substring(0, 3000);
            }
            jSONObject.put("stack", str);
            jSONObject.put("crash_thread_name", str2);
            iLogF.e("APMPlus", jSONObject.toString());
        } catch (Throwable unused) {
        }
    }

    public static ILog f() {
        if (g.g.isApmPLusLogEnable()) {
            return VLog.getInstance("APMPlus");
        }
        return null;
    }

    public final void d(CrashType crashType, long j5, String str, JSONArray jSONArray) {
        if (jSONArray != null) {
            for (int i = 0; i < jSONArray.length(); i++) {
                String strK = N.k(jSONArray.optJSONObject(i), "header", "aid");
                if (z2.b.g(strK) || z2.b.h(strK)) {
                    Context context = g.f2160a;
                    String strO = d.o();
                    try {
                        if (this.f4477a != null) {
                            try {
                                this.f4477a.b(strK);
                            } catch (Throwable th) {
                                int i6 = com.apm.insight.b.f2156a;
                                M0.i.k("NPTH_CATCH", th);
                            }
                        }
                        File file = new File(new File(j.C(g.f2160a), "apminsight/alogCrash"), crashType.getName() + "_" + strK + "_" + str + ".atmp");
                        if (!file.exists()) {
                            file.getParentFile().mkdirs();
                            Properties properties = new Properties();
                            properties.setProperty("aid", strK);
                            properties.setProperty("process_name", strO);
                            properties.setProperty("crash_time", String.valueOf(j5));
                            FileOutputStream fileOutputStream = null;
                            try {
                                FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                                try {
                                    properties.store(fileOutputStream2, "");
                                    fileOutputStream2.close();
                                    M0.i.i(fileOutputStream2);
                                } catch (Throwable unused) {
                                    fileOutputStream = fileOutputStream2;
                                    M0.i.i(fileOutputStream);
                                }
                            } catch (Throwable unused2) {
                            }
                        }
                    } catch (Throwable th2) {
                        int i10 = com.apm.insight.b.f2156a;
                        M0.i.k("NPTH_CATCH", th2);
                    }
                }
            }
        }
    }

    @Override // com.apm.insight.ICrashCallback
    public final void onCrash(CrashType crashType, String str, Thread thread) {
        crashType.equals(CrashType.NATIVE);
    }
}
