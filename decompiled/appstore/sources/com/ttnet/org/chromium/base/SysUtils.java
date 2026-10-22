package com.ttnet.org.chromium.base;

import android.app.ActivityManager;
import com.ttnet.org.chromium.base.annotations.CalledByNative;
import com.ttnet.org.chromium.base.annotations.JNINamespace;
import com.ttnet.org.chromium.base.annotations.MainDex;

/* JADX INFO: loaded from: classes4.dex */
@JNINamespace("base::android")
@MainDex
public class SysUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Boolean f18300a;

    public interface Natives {
        void logPageFaultCountToTracing();
    }

    static {
    }

    public static boolean a() {
        CommandLine.a();
        throw null;
    }

    @CalledByNative
    public static boolean isCurrentlyLowMemory() {
        ActivityManager r10 = (ActivityManager) e.d().getSystemService("activity");
        ActivityManager.MemoryInfo r11 = new ActivityManager.MemoryInfo();
        r10.getMemoryInfo(r11);
        return r11.lowMemory;
    }

    @CalledByNative
    public static boolean isLowEndDevice() {
        if (f18300a != null) goto L6;
        f18300a = Boolean.valueOf(a());
    L6:
        return f18300a.booleanValue();
    }
}
