package com.bytedance.android.livesdk.performance;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.os.Debug;
import android.os.Process;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livehostapi.platform.base.IBaseHostPerformanceMonitor;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes11.dex */
public final class k0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final HashMap<String, Long> f154674a = null;

    static {
        f154674a = new HashMap();
    }

    public static Map<String, Long> a(Context r100) {
        int r101 = Process.myPid();
        if (r100 == null) goto L10;
        int[] r102 = {r101};
        ActivityManager r103 = (ActivityManager) r100.getSystemService("activity");
        if (r103 == null) goto L10;
        Debug.MemoryInfo[] r104 = r103.getProcessMemoryInfo(r102);
        if (r104 == null) goto L10;
        Debug.MemoryInfo r105 = r104[0];
    L12:
        HashMap r106 = new HashMap();
        if (r105 != null) goto L16;
    L21:
        return r106;
    L16:
        if (Build.VERSION.SDK_INT <= 23) goto L21;
        r106.put(IBaseHostPerformanceMonitor.MEM_SUMMARY_JAVA_HEAP, Long.valueOf(CastLongProtector.parseLong(r105.getMemoryStat("summary.java-heap")) * 1024));     // Catch: NumberFormatException -> L19
        r106.put(IBaseHostPerformanceMonitor.MEM_SUMMARY_NATIVE_HEAP, Long.valueOf(CastLongProtector.parseLong(r105.getMemoryStat("summary.native-heap")) * 1024));     // Catch: NumberFormatException -> L19
        r106.put(IBaseHostPerformanceMonitor.MEM_SUMMARY_CODE, Long.valueOf(CastLongProtector.parseLong(r105.getMemoryStat("summary.code")) * 1024));     // Catch: NumberFormatException -> L19
        r106.put(IBaseHostPerformanceMonitor.MEM_SUMMARY_STACK, Long.valueOf(CastLongProtector.parseLong(r105.getMemoryStat("summary.stack")) * 1024));     // Catch: NumberFormatException -> L19
        r106.put(IBaseHostPerformanceMonitor.MEM_SUMMARY_PRIVATE_OTHER, Long.valueOf(CastLongProtector.parseLong(r105.getMemoryStat("summary.private-other")) * 1024));     // Catch: NumberFormatException -> L19
        r106.put(IBaseHostPerformanceMonitor.MEM_SUMMARY_SYSTEM, Long.valueOf(CastLongProtector.parseLong(r105.getMemoryStat("summary.system")) * 1024));     // Catch: NumberFormatException -> L19
    L19:
        e = move-exception;
        ALogger.e("MemoryUtils", "memInfo2Map: " + e.toString());
    L10:
        r105 = null;
        goto L12
    }
}
