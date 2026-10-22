package com.bytedance.reparo.core;

import android.os.Build;
import android.text.TextUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class PatchConstructorHelper {
    private static Map<String, Class> sOriginClassMap;

    public PatchConstructorHelper() {
    }

    static {
        sOriginClassMap = new HashMap();
    }

    public static void collectConstructorClass(Constructor r2) {
        Class r3 = r2.getDeclaringClass();
        String r0 = r3.getName();
        sOriginClassMap.put(r0, r3);
    }

    public static void changeInstanceDeclaringClass(String r2, Object r3) {
        if (l.a() == true) goto L6;
        return;
    L6:
        if (Build.VERSION.SDK_INT < 26) goto L9;
        return;
    L9:
        if (TextUtils.isEmpty(r2) == false) goto L12;
        return;
    L12:
        if (sOriginClassMap.containsKey(r2) == true) goto L14;
        return;
    L14:
        Class r4 = (Class) ZeusTransformUtils.preCheckCast(sOriginClassMap.get(r2), Class.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r4, r3) == false) goto L17;
        return;
    L17:
        monitor-enter(r3);
        Field r0 = Object.class.getDeclaredField("shadow$_klass_");     // Catch: Throwable -> L20 Exception -> L22
        r0.setAccessible(true);     // Catch: Throwable -> L20 Exception -> L22
        r0.set(r3, r4);     // Catch: Throwable -> L20 Exception -> L22
    L24:
        monitor-exit(r3);     // Catch: Throwable -> L20
        return;
    L20:
        th = move-exception;
        throw th;
    L22:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L20
        goto L24
    }
}
