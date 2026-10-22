package com.bytedance.android.live.core.utils;

import android.os.Build;
import com.bytedance.common.utility.StringUtils;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes45.dex */
public final class f1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Boolean f66133a;

    public static Boolean a() {
        Boolean r100 = f66133a;
        if (r100 == null) goto L5;
        return r100;
    L5:
        boolean r101 = false;
        Method r102 = Build.class.getDeclaredMethod("getString", new Class[]{String.class});     // Catch: Throwable -> L13
        r102.setAccessible(true);     // Catch: Throwable -> L13
        Object r103 = r102.invoke(null, new Object[]{"ro.vivo.os.version"});     // Catch: Throwable -> L13
        if ((r103 instanceof String) == true) goto L9;
    L15:
        f66133a = Boolean.valueOf(r101);
        return Boolean.valueOf(r101);
    L9:
        if (StringUtils.isEmpty((String) r103) == true) goto L15;
        if ("unknown".equals((String) r103) == true) goto L15;
        r101 = true;
    L13:
        th = move-exception;
        th.printStackTrace();
        goto L15
    }
}
