package com.obric.oui.material;

import android.util.Log;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: TokenParserCore.java */
/* JADX INFO: loaded from: classes4.dex */
public final class o {
    private static final String TAG = "TokenParserCore";

    public static <T> ConcurrentHashMap<String, T> a(Class<?> r3, Class<?> r4) {
        ConcurrentHashMap<String, T> r0 = new ConcurrentHashMap();
        if (r3 == null) goto L10;
        if (r4 == null) goto L10;
        a(r3, r3.getDeclaredFields(), r4, r0);     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        a(TAG, "Failed to parse tokens from class:" + r3.getSimpleName(), th);
    L10:
        return r0;
    }

    public static <T> ConcurrentHashMap<String, T> a(Object r3, Class<?> r4) {
        ConcurrentHashMap<String, T> r0 = new ConcurrentHashMap();
        if (r3 == null) goto L10;
        if (r4 == null) goto L10;
        a(r3, r3.getClass().getDeclaredFields(), r4, r0);     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        a(TAG, "Failed to parse tokens from " + r3.getClass().getSimpleName(), th);
    L10:
        return r0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static <T> ConcurrentHashMap<String, T> a(Object r5, Field[] r6, Class<?> r7, ConcurrentHashMap<String, T> r8) {
        int r0 = r6.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L11;
        Field r2 = r6[r1];
        if (b(r7, r2.getType()) == false) goto L10;
        r2.setAccessible(true);
        Object r3 = r2.get(r5);
        if (r3 == null) goto L10;
        r8.put(r2.getName().toLowerCase(Locale.ROOT), r3);
    L10:
        r1 = r1 + 1;
        goto L3
    L11:
        return r8;
    }

    public static <T> T a(String r2, Map<String, T> r3) {
        Map r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin");
        if (r2 == null) goto L11;
        if (r4 == null) goto L11;
        String r5 = r2.toLowerCase(Locale.ROOT).trim();
        if (r5.length() != 0) goto L10;
        return null;
    L10:
        return (T) r4.get(r5);
    L11:
        return null;
    }

    public static <T> void a(ConcurrentHashMap<String, T> r0, Object r1, Class<?> r2, boolean r3) {
        a(r0, a(r1, r2), r3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> void a(ConcurrentHashMap<String, T> r4, Map<String, ? extends T> r5, boolean r6) {
        Map r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.aiagent.plugin");
        if (r4 == 0) goto L20;
        if (r7 != null) goto L6;
        return;
    L6:
        if (r7.isEmpty() == true) goto L32;
        Iterator r8 = r7.entrySet().iterator();
    L10:
        if (r8.hasNext() == false) goto L33;
        Map.Entry r0 = (Map.Entry) ZeusTransformUtils.preCheckCast(r8.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        String r2 = (String) ZeusTransformUtils.preCheckCast(r0.getKey(), String.class, "com.obric.aiagent.plugin");
        if (r2 == null) goto L10;
        String r3 = r2.toLowerCase(Locale.ROOT).trim();
        if (r3.length() == 0) goto L10;
        if (r6 == true) goto L18;
        r4.putIfAbsent(r3, r0.getValue());
        goto L10
    L18:
        r4.put(r3, r0.getValue());
        goto L10
    L33:
        return;
    L32:
        return;
    }

    private static boolean b(Class<?> r3, Class<?> r4) {
        if (r3.isAssignableFrom(r4) == false) goto L6;
        return true;
    L6:
        if (r4.isPrimitive() == true) goto L9;
        return false;
    L9:
        if (r4 != Float.TYPE) goto L13;
        if (r3 != Float.class) goto L13;
        return true;
    L13:
        if (r4 != Integer.TYPE) goto L17;
        if (r3 != Integer.class) goto L17;
        return true;
    L17:
        if (r4 != Boolean.TYPE) goto L21;
        if (r3 != Boolean.class) goto L21;
        return true;
    L21:
        if (r4 != Long.TYPE) goto L25;
        if (r3 != Long.class) goto L25;
        return true;
    L25:
        if (r4 != Double.TYPE) goto L29;
        if (r3 != Double.class) goto L29;
        return true;
    L29:
        if (r4 != Short.TYPE) goto L33;
        if (r3 != Short.class) goto L33;
        return true;
    L33:
        if (r4 != Byte.TYPE) goto L37;
        if (r3 != Byte.class) goto L37;
        return true;
    L37:
        if (r4 != Character.TYPE) goto L42;
        if (r3 != Character.class) goto L42;
        return true;
    L42:
        return false;
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r0, String r1, Throwable r2) {
        return Log.e(r0, r1, r2);
    }
}
