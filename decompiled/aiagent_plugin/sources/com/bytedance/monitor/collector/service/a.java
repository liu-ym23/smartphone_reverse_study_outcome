package com.bytedance.monitor.collector.service;

import android.os.Build;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Field;

/* JADX INFO: compiled from: DoubleReflectHelper.java */
/* JADX INFO: loaded from: classes.dex */
public final class a {
    public static boolean a() {
        if (Build.VERSION.SDK_INT < 28) goto L5;
    L10:
        return true;
    L5:
        if (Build.VERSION.SDK_INT == 27) goto L7;
    L9:
        return false;
    L7:
        if (Build.VERSION.PREVIEW_SDK_INT <= 0) goto L9;
        goto L9
    }

    public static Field a(Class<?> r6, String r7) {
        Field r8 = (Field) ZeusTransformUtils.preCheckCast(Class.class.getDeclaredMethod("getDeclaredField", new Class[]{String.class}).invoke(r6, new Object[]{r7}), Field.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L4
        r8.setAccessible(true);     // Catch: Throwable -> L4
        return r8;
    L4:
        th = move-exception;
        th.printStackTrace();
        return null;
    }

    public static Field b(Class<?> r1, String r2) {
        if (a() == false) goto L9;
        return a(r1, r2);
    L6:
        return null;
    L9:
        return com.bytedance.monitor.a.b.a(r1, r2);
    }
}
