package com.apm.insight;

import D7.N;
import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import com.apm.insight.MonitorCrash;
import e2.C1404a;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import v2.RunnableC2056a;
import z2.l;

/* loaded from: classes2.dex */
public final class f {
    public static volatile MonitorCrash b;
    public static volatile ConcurrentHashMap c = new ConcurrentHashMap();

    /* renamed from: a, reason: collision with root package name */
    public final MonitorCrash f2159a;

    public f(MonitorCrash monitorCrash) {
        this.f2159a = monitorCrash;
        n2.c.f5346a.add(this);
        RunnableC2056a.a();
        l.i().a(new A1.a(21));
    }

    public static void e(Context context, MonitorCrash monitorCrash) {
        b = monitorCrash;
        e eVar = new e(new f(monitorCrash), monitorCrash);
        Context context2 = g.f2160a;
        synchronized (g.class) {
            Application application = g.b;
            if (application == null) {
                if (context instanceof Application) {
                    application = (Application) context;
                    if (application.getBaseContext() == null) {
                        throw new IllegalArgumentException("初始化时传入的Application还未attach, 请在init时传入attachBaseContext的参数, 并在init之前手动调用Npth.setApplication(Application).");
                    }
                } else {
                    application = (Application) context.getApplicationContext();
                    if (application == null) {
                        throw new IllegalArgumentException("初始化时传入了baseContext, 导致无法获取Application实例, 请在init之前手动调用Npth.setApplication(Application).");
                    }
                    if (application.getBaseContext() != null) {
                        context = application.getBaseContext();
                    }
                }
            }
            g.d(application, context);
            g.f = new A5.c(g.f2160a, eVar, g.a());
        }
    }

    public static String h(String str) {
        MonitorCrash monitorCrash;
        if (b != null && TextUtils.equals(str, b.mConfig.f2147a)) {
            monitorCrash = b;
        } else if (c == null || (monitorCrash = (MonitorCrash) c.get(str)) == null) {
            return null;
        }
        return monitorCrash.mConfig.b;
    }

    public static String i(String str) {
        MonitorCrash monitorCrash;
        if (b != null && TextUtils.equals(str, b.mConfig.f2147a)) {
            monitorCrash = b;
        } else if (c == null || (monitorCrash = (MonitorCrash) c.get(str)) == null) {
            return null;
        }
        return monitorCrash.mConfig.getDeviceId();
    }

    public static String j() {
        if (b == null) {
            return null;
        }
        return b.mConfig.f2147a;
    }

    public static long k() {
        long j5 = b == null ? 0L : b.mConfig.d;
        if (j5 <= 0) {
            try {
                Context context = g.f2160a;
                ConcurrentHashMap concurrentHashMap = D2.c.f374a;
                return D2.c.b(context, context.getPackageName(), 0) != null ? r0.versionCode : 0;
            } catch (Throwable unused) {
            }
        }
        return j5;
    }

    public final JSONArray a(StackTraceElement[] stackTraceElementArr, Throwable th) {
        String[] strArr = this.f2159a.mConfig.f;
        if (strArr == null) {
            JSONArray jSONArray = new JSONArray();
            int length = stackTraceElementArr.length;
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("start", 0);
                jSONObject.put("end", length);
            } catch (Throwable unused) {
            }
            return jSONArray.put(jSONObject);
        }
        if (th == null || stackTraceElementArr == null) {
            return null;
        }
        StackTraceElement stackTraceElement = y2.e.f6892a;
        y2.d dVar = new y2.d();
        JSONArray jSONArray2 = new JSONArray();
        for (int i = 0; i < stackTraceElementArr.length; i++) {
            if (dVar.f6891a == -1) {
                if (y2.e.l(stackTraceElementArr[i].getClassName(), strArr)) {
                    dVar.f6891a = i;
                    dVar.b = i;
                }
            } else if (!y2.e.l(stackTraceElementArr[i].getClassName(), strArr)) {
                dVar.b = i;
                jSONArray2.put(dVar.a());
                dVar = new y2.d();
            }
        }
        if (dVar.f6891a != -1) {
            dVar.b = stackTraceElementArr.length;
            jSONArray2.put(dVar.a());
        }
        return jSONArray2;
    }

    public final JSONArray b(String[] strArr) {
        MonitorCrash monitorCrash = this.f2159a;
        if (monitorCrash.config().f == null) {
            JSONArray jSONArray = new JSONArray();
            int length = strArr.length;
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("start", 0);
                jSONObject.put("end", length);
            } catch (Throwable unused) {
            }
            return jSONArray.put(jSONObject);
        }
        String[] strArr2 = monitorCrash.mConfig.f;
        StackTraceElement stackTraceElement = y2.e.f6892a;
        y2.d dVar = new y2.d();
        JSONArray jSONArray2 = new JSONArray();
        for (int i = 0; i < strArr.length; i++) {
            if (dVar.f6891a == -1) {
                if (y2.e.l(strArr[i], strArr2)) {
                    dVar.f6891a = i;
                    dVar.b = i;
                }
            } else if (!y2.e.l(strArr[i], strArr2)) {
                dVar.b = i;
                jSONArray2.put(dVar.a());
                dVar = new y2.d();
            }
        }
        if (dVar.f6891a != -1) {
            dVar.b = strArr.length;
            jSONArray2.put(dVar.a());
        }
        try {
            if (N.g(jSONArray2) && monitorCrash.mConfig.m) {
                String strValueOf = String.valueOf(A2.e.c().f85j);
                if (!TextUtils.isEmpty(strValueOf)) {
                    for (String str : monitorCrash.mConfig.f) {
                        if (strValueOf.contains(str)) {
                            JSONArray jSONArray3 = new JSONArray();
                            int length2 = strArr.length;
                            JSONObject jSONObject2 = new JSONObject();
                            try {
                                jSONObject2.put("start", 0);
                                jSONObject2.put("end", length2);
                            } catch (Throwable unused2) {
                            }
                            return jSONArray3.put(jSONObject2);
                        }
                    }
                }
            }
        } catch (Throwable unused3) {
        }
        return jSONArray2;
    }

    public final JSONObject c(CrashType crashType, JSONArray jSONArray, boolean z10) {
        Map<? extends String, ? extends String> userData;
        MonitorCrash monitorCrash = this.f2159a;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("header", d(z10));
            if (crashType != null) {
                AttachUserData attachUserData = monitorCrash.mCustomData;
                JSONObject jSONObject2 = null;
                if (attachUserData != null && (userData = attachUserData.getUserData(crashType)) != null) {
                    jSONObject2 = new JSONObject((Map<?, ?>) userData);
                }
                jSONObject.put("custom", jSONObject2);
                jSONObject.put("filters", new JSONObject((Map<?, ?>) monitorCrash.mTagMap));
            }
            jSONObject.put("line_num", jSONArray);
        } catch (Throwable unused) {
        }
        return jSONObject;
    }

    public final JSONObject d(boolean z10) {
        C1404a c1404aC;
        JSONArray jSONArray;
        MonitorCrash monitorCrash = this.f2159a;
        JSONObject jSONObject = new JSONObject();
        try {
            MonitorCrash.Config config = monitorCrash.mConfig;
            if (config.f == null) {
                Context context = g.f2160a;
                if (config.d == -1) {
                    ConcurrentHashMap concurrentHashMap = D2.c.f374a;
                    config.d = D2.c.b(context, context.getPackageName(), 0) != null ? r4.versionCode : 0;
                }
                MonitorCrash.Config config2 = monitorCrash.mConfig;
                if (config2.e == null) {
                    config2.e = D2.c.c(context);
                }
            }
        } catch (Throwable unused) {
        }
        if ((TextUtils.isEmpty(monitorCrash.mConfig.getDeviceId()) || "0".equals(monitorCrash.mConfig.getDeviceId())) && (c1404aC = C1404a.c(monitorCrash.mConfig.f2147a)) != null) {
            monitorCrash.mConfig.setDeviceId(c1404aC.b(), false);
        }
        try {
            jSONObject.put("aid", String.valueOf(monitorCrash.mConfig.f2147a));
            if (z10 && !TextUtils.isEmpty(monitorCrash.mConfig.b)) {
                jSONObject.put("x-auth-token", monitorCrash.mConfig.b);
            }
            jSONObject.put("update_version_code", monitorCrash.mConfig.d);
            jSONObject.put("version_code", monitorCrash.mConfig.d);
            jSONObject.put("app_version", monitorCrash.mConfig.e);
            jSONObject.put("channel", monitorCrash.mConfig.c);
            String[] strArr = monitorCrash.mConfig.f;
            JSONArray jSONArray2 = null;
            if (strArr == null) {
                jSONArray = null;
            } else {
                jSONArray = new JSONArray();
                for (String str : strArr) {
                    jSONArray.put(str);
                }
            }
            jSONObject.put("package", jSONArray);
            jSONObject.put("device_id", monitorCrash.mConfig.getDeviceId());
            jSONObject.put("user_id", monitorCrash.mConfig.getUID());
            jSONObject.put("ssid", monitorCrash.mConfig.getSSID());
            jSONObject.put("os", "Android");
            String[] strArr2 = monitorCrash.mConfig.g;
            if (strArr2 != null) {
                jSONArray2 = new JSONArray();
                for (String str2 : strArr2) {
                    jSONArray2.put(str2);
                }
            }
            jSONObject.put("so_list", jSONArray2);
            jSONObject.put("single_upload", 0);
        } catch (JSONException unused2) {
        }
        return jSONObject;
    }

    public final JSONArray f(String str) {
        if (this.f2159a == b) {
            return new JSONArray();
        }
        String[] strArr = this.f2159a.mConfig.g;
        if (strArr == null || strArr.length <= 0) {
            return null;
        }
        for (String str2 : strArr) {
            if (str.contains(str2)) {
                return new JSONArray();
            }
        }
        return null;
    }

    public final String g() {
        return this.f2159a.mConfig.f2147a;
    }
}
