package com.bytedance.bdtracker;

import android.os.Build;
import android.text.TextUtils;
import com.bytedance.applog.log.IAppLogLogger;
import com.bytedance.applog.log.LoggerImpl;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.InputStreamReader;
import okio.Segment;

/* loaded from: classes.dex */
public class p5 {
    public static final CharSequence a = "amigo";
    public static final CharSequence b = "funtouch";
    public static final a5<Boolean> c = new a();

    public static class a extends a5<Boolean> {
        @Override // com.bytedance.bdtracker.a5
        public Boolean a(Object[] objArr) {
            try {
                Class<?> cls = Class.forName("com.huawei.system.BuildEx");
                Class[] clsArr = new Class[0];
                return Boolean.valueOf("harmony".equals(cls.getMethod("getOsBrand", null).invoke(cls, null)));
            } catch (Throwable unused) {
                return false;
            }
        }
    }

    public static String a(String str) {
        BufferedReader bufferedReader;
        String strA = r5.a(str);
        if (!TextUtils.isEmpty(strA)) {
            return strA;
        }
        String line = "";
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            Process processExec = Runtime.getRuntime().exec("getprop " + str);
            bufferedReader = new BufferedReader(new InputStreamReader(processExec.getInputStream()), Segment.SHARE_MINIMUM);
            try {
                line = bufferedReader.readLine();
                processExec.destroy();
            } catch (Throwable th) {
                th = th;
                try {
                    LoggerImpl.global().error("getSysPropByExec error", th, new Object[0]);
                    return line;
                } finally {
                    r.a((Closeable) bufferedReader);
                }
            }
        } catch (Throwable th2) {
            th = th2;
            bufferedReader = null;
        }
        return line;
    }

    public static boolean a() throws ClassNotFoundException {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            String str = (String) cls.getDeclaredMethod("get", String.class).invoke(cls, "ro.build.version.emui");
            if (!TextUtils.isEmpty(str)) {
                LoggerImpl.global().debug("Honor# oldHonor device, version is" + str, new Object[0]);
                return true;
            }
        } catch (Exception e) {
            IAppLogLogger iAppLogLoggerGlobal = LoggerImpl.global();
            StringBuilder sbA = com.bytedance.bdtracker.a.a("Honor# ");
            sbA.append(e.getMessage());
            iAppLogLoggerGlobal.error(sbA.toString(), e, new Object[0]);
        }
        return false;
    }

    public static boolean b() {
        String str = Build.MANUFACTURER;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.toLowerCase().contains("oppo") || str.toLowerCase().contains("realme");
    }

    public static boolean c() {
        return (!TextUtils.isEmpty(Build.DISPLAY) && Build.DISPLAY.contains("Flyme")) || "flyme".equals(Build.USER);
    }

    public static boolean d() {
        if (TextUtils.isEmpty(Build.BRAND) || !Build.BRAND.toLowerCase().startsWith("honor")) {
            return !TextUtils.isEmpty(Build.MANUFACTURER) && Build.MANUFACTURER.toLowerCase().startsWith("honor");
        }
        return true;
    }

    public static boolean e() {
        if (TextUtils.isEmpty(Build.BRAND) || !Build.BRAND.toLowerCase().startsWith("huawei")) {
            return !TextUtils.isEmpty(Build.MANUFACTURER) && Build.MANUFACTURER.toLowerCase().startsWith("huawei");
        }
        return true;
    }

    public static boolean f() {
        return Class.forName("miui.os.Build").getName().length() > 0;
    }
}
