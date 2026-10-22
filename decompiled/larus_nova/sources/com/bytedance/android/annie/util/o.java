package com.bytedance.android.annie.util;

import android.text.TextUtils;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.lang.reflect.Method;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class o {
    public static Method a(Class<?> r100, String r101, Class<?>[] r102) {
        if (r100 != null) goto L5;
    L13:
        return null;
    L5:
        if (TextUtils.isEmpty(r101) == true) goto L13;
        int r103 = x8.a.f562881a;     // Catch: Throwable -> L9
        String r104 = "thread id : " + ThreadMethodProxy.currentThread().getName();     // Catch: Throwable -> L9
        Intrinsics.checkNotNullParameter("Annie_ReflectUtils", "tag");     // Catch: Throwable -> L9
        Intrinsics.checkNotNullParameter(r104, "msg");     // Catch: Throwable -> L9
        x8.a.d("Annie_ReflectUtils", r104, false);     // Catch: Throwable -> L9
        return r100.getMethod(r101, r102);
    L9:
        th = move-exception;
        int r105 = x8.a.f562881a;
        x8.a.a("Annie_ReflectUtils", "exception in getMethod, pkg : " + r100.getName() + ", function : " + r101 + ", " + th.toString());
        return r100.getDeclaredMethod(r101, r102);
    }

    public static Object b(Class<?> r100, String r101, Object... r102) {
        Object r103 = null;
        if (r100 != null) goto L5;
    L18:
        return r103;
    L5:
        if (TextUtils.isEmpty(r101) == true) goto L18;
        Object[] r104 = new Object[0];
        Method r105 = a(r100, r101, new Class[0]);     // Catch: Throwable -> L16
        if (r105 == null) goto L19;
        r105.setAccessible(true);     // Catch: Throwable -> L16
        if (r102.length <= 0) goto L14;
        r103 = r105.invoke(r102[0], r104);     // Catch: Throwable -> L16
        goto L19
    L14:
        r103 = r105.invoke(null, r104);     // Catch: Throwable -> L16
    L19:
    L16:
        th = move-exception;
        int r106 = x8.a.f562881a;
        x8.a.a("Annie_ReflectUtils", "exception in invokeMethod, pkg : " + r100.getName() + ", function : " + r101 + ", " + th.toString());
        goto L18
    }
}
