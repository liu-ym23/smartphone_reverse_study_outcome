package com.ttnet.org.chromium.base;

import com.ttnet.org.chromium.base.annotations.CalledByNative;
import dalvik.system.BaseDexClassLoader;

/* JADX INFO: loaded from: classes4.dex */
public final class BundleUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Boolean f18241a;

    static {
    }

    public static boolean a() {
        if (c.f18317c == true) goto L7;
        return false;
    L7:
        return f18241a.booleanValue();
    }

    @CalledByNative
    private static String getNativeLibraryPath(String r10) {
        o r11 = o.b();
        String r12 = ((BaseDexClassLoader) e.d().getClassLoader()).findLibrary(r10);     // Catch: Throwable -> L7
        if (r11 == null) goto L6;
        r11.close();
    L6:
        return r12;
    L7:
        th = move-exception;
        if (r11 != null) goto L16;
    L13:
        throw th;
    L16:
        r11.close();     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        th.addSuppressed(th);
        goto L13
    }

    @CalledByNative
    public static boolean isBundleForNative() {
        return a();
    }
}
