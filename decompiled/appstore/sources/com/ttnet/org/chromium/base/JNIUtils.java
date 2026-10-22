package com.ttnet.org.chromium.base;

import com.ttnet.org.chromium.base.annotations.CalledByNative;
import com.ttnet.org.chromium.base.annotations.MainDex;

/* JADX INFO: loaded from: classes4.dex */
@MainDex
public class JNIUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Boolean f18256a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static ClassLoader f18257b;

    static {
    }

    @CalledByNative
    public static Object getClassLoader() {
        ClassLoader r10 = f18257b;
        if (r10 == null) goto L5;
        return r10;
    L5:
        return JNIUtils.class.getClassLoader();
    }

    @CalledByNative
    public static boolean isSelectiveJniRegistrationEnabled() {
        if (f18256a != null) goto L6;
        f18256a = Boolean.FALSE;
    L6:
        return f18256a.booleanValue();
    }
}
