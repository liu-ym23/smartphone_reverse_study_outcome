package com.obric.oui.material;

import android.util.Log;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes4.dex */
public abstract class q {
    public static ConcurrentHashMap a(Class r10, Class r11) {
        ConcurrentHashMap r12 = new ConcurrentHashMap();
        if (r10 == null) goto L10;
        if (r11 == null) goto L10;
        g(r10, r10.getDeclaredFields(), r11, r12);     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        Log.e("TokenParserCore", "Failed to parse tokens from class:" + r10.getSimpleName(), th);
    L10:
        return r12;
    }

    public static ConcurrentHashMap b(Object r10, Class r11) {
        ConcurrentHashMap r12 = new ConcurrentHashMap();
        if (r10 == null) goto L10;
        if (r11 == null) goto L10;
        g(r10, r10.getClass().getDeclaredFields(), r11, r12);     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        Log.e("TokenParserCore", "Failed to parse tokens from " + r10.getClass().getSimpleName(), th);
    L10:
        return r12;
    }

    public static boolean c(Class r10, Class r11) {
        if (r10.isAssignableFrom(r11) == false) goto L6;
        return true;
    L6:
        if (r11.isPrimitive() == true) goto L9;
        return false;
    L9:
        if (r11 != Float.TYPE) goto L13;
        if (r10 != Float.class) goto L13;
        return true;
    L13:
        if (r11 != Integer.TYPE) goto L17;
        if (r10 != Integer.class) goto L17;
        return true;
    L17:
        if (r11 != Boolean.TYPE) goto L21;
        if (r10 != Boolean.class) goto L21;
        return true;
    L21:
        if (r11 != Long.TYPE) goto L25;
        if (r10 != Long.class) goto L25;
        return true;
    L25:
        if (r11 != Double.TYPE) goto L29;
        if (r10 != Double.class) goto L29;
        return true;
    L29:
        if (r11 != Short.TYPE) goto L33;
        if (r10 != Short.class) goto L33;
        return true;
    L33:
        if (r11 != Byte.TYPE) goto L37;
        if (r10 != Byte.class) goto L37;
        return true;
    L37:
        if (r11 != Character.TYPE) goto L42;
        if (r10 != Character.class) goto L42;
        return true;
    L42:
        return false;
    }

    public static Object d(String r10, Map r11) {
        if (r10 == null) goto L11;
        if (r11 == null) goto L11;
        String r12 = r10.toLowerCase(Locale.ROOT).trim();
        if (r12.length() != 0) goto L10;
        return null;
    L10:
        return r11.get(r12);
    L11:
        return null;
    }

    public static void e(ConcurrentHashMap r10, Object r11, Class r12, boolean r13) {
        f(r10, b(r11, r12), r13);
    }

    public static void f(ConcurrentHashMap r10, Map r11, boolean r12) {
        if (r10 == null) goto L19;
        if (r11 != null) goto L5;
        return;
    L5:
        if (r11.isEmpty() == true) goto L31;
        Iterator r13 = r11.entrySet().iterator();
    L9:
        if (r13.hasNext() == false) goto L32;
        Map.Entry r14 = (Map.Entry) r13.next();
        String r15 = (String) r14.getKey();
        if (r15 == null) goto L9;
        String r16 = r15.toLowerCase(Locale.ROOT).trim();
        if (r16.length() == 0) goto L9;
        if (r12 == true) goto L17;
        r10.putIfAbsent(r16, r14.getValue());
        goto L9
    L17:
        r10.put(r16, r14.getValue());
        goto L9
    L32:
        return;
    L31:
        return;
    }

    public static ConcurrentHashMap g(Object r10, Field[] r11, Class r12, ConcurrentHashMap r13) {
        int r14 = r11.length;
        int r15 = 0;
    L3:
        if (r15 >= r14) goto L11;
        Field r16 = r11[r15];
        if (c(r12, r16.getType()) == false) goto L10;
        r16.setAccessible(true);
        Object r17 = r16.get(r10);
        if (r17 == null) goto L10;
        r13.put(r16.getName().toLowerCase(Locale.ROOT), r17);
    L10:
        r15 = r15 + 1;
        goto L3
    L11:
        return r13;
    }
}
