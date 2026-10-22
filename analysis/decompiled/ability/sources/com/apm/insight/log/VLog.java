package com.apm.insight.log;

import android.content.Context;
import com.apm.insight.log.VLogConfig;
import com.apm.insight.log.a.f;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes2.dex */
public class VLog {

    /* renamed from: a, reason: collision with root package name */
    private static boolean f2169a = false;
    private static Object b = new Object();

    public static void changeLevel(int i) {
        a.a(i);
    }

    public static ILog createInstance(VLogConfig vLogConfig, String str) {
        ILog vLog = getInstance(str);
        return vLog != null ? vLog : a.a(str, vLogConfig);
    }

    public static void d(String str, String str2) {
        a.b(str, str2);
    }

    public static void destroy() {
        a.c();
    }

    public static void e(String str, String str2) {
        a.e(str, str2);
    }

    public static void flush() {
        a.a();
    }

    public static ILog getInstance(String str) {
        return a.a(str);
    }

    public static HashMap<String, String> getLastFetchErrorInfo() {
        return a.b();
    }

    public static List<String> getLogFiles(long j5, long j6) {
        ArrayList arrayList = new ArrayList();
        try {
            File[] fileArrA = f.a((String) null, (String) null, j5 * 1000, j6 * 1000);
            for (File file : fileArrA) {
                arrayList.add(file.getAbsolutePath());
            }
        } catch (Exception unused) {
        }
        return arrayList;
    }

    public static void i(String str, String str2) {
        a.c(str, str2);
    }

    public static void init(Context context, int i) {
        synchronized (b) {
            try {
                if (f2169a) {
                    return;
                }
                f2169a = true;
                a.a(new VLogConfig.Builder(context).setMaxDirSize(i << 20).setOffloadMainThreadWrite(true).build());
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void release() {
        a.d();
    }

    public static void v(String str, String str2) {
        a.a(str, str2);
    }

    public static void w(String str, String str2) {
        a.d(str, str2);
    }

    public static List<String> getLogFiles(boolean z10, long j5, long j6, int i) {
        ArrayList arrayList = new ArrayList();
        try {
            for (File file : f.a(z10, j5 * 1000, j6 * 1000, i)) {
                arrayList.add(file.getAbsolutePath());
            }
        } catch (Exception unused) {
        }
        return arrayList;
    }
}
