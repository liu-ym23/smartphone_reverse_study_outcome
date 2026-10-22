package com.blankj.utilcode.util;

import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.util.Log;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static List f6218a;

    public static void a(Resources r10, float r11) {
        r10.getDisplayMetrics().xdpi = r11;
        Utils.c().getResources().getDisplayMetrics().xdpi = r11;
        c(r10, r11);
    }

    public static void b(Resources r10, float r11) {
        Iterator r12 = f6218a.iterator();
    L4:
        if (r12.hasNext() == false) goto L12;
        DisplayMetrics r13 = (DisplayMetrics) ((Field) r12.next()).get(r10);     // Catch: Exception -> L10
        if (r13 == null) goto L4;
        r13.xdpi = r11;     // Catch: Exception -> L10
    L10:
        e = move-exception;
        Log.e("AdaptScreenUtils", "applyMetricsFields: " + e);
        goto L4
    }

    public static void c(Resources r10, float r11) {
        if (f6218a != null) goto L19;
        f6218a = new ArrayList();
        Class<?> r12 = r10.getClass();
        Field[] r13 = r12.getDeclaredFields();
    L5:
        if (r13 == null) goto L28;
        if (r13.length <= 0) goto L29;
        int r14 = r13.length;
        int r15 = 0;
    L9:
        if (r15 >= r14) goto L16;
        Field r16 = r13[r15];
        if (r16.getType().isAssignableFrom(DisplayMetrics.class) == false) goto L15;
        r16.setAccessible(true);
        DisplayMetrics r17 = d(r10, r16);
        if (r17 == null) goto L15;
        f6218a.add(r16);
        r17.xdpi = r11;
    L15:
        r15 = r15 + 1;
        goto L9
    L16:
        r12 = r12.getSuperclass();
        if (r12 == null) goto L30;
        r13 = r12.getDeclaredFields();
        goto L5
    L30:
        return;
    L29:
        return;
    L28:
        return;
    L19:
        b(r10, r11);
    }

    public static DisplayMetrics d(Resources r10, Field r11) {
        return (DisplayMetrics) r11.get(r10);
    L4:
        e = move-exception;
        Log.e("AdaptScreenUtils", "getMetricsFromField: " + e);
        return null;
    }

    public static void e() {
        a(Resources.getSystem(), Resources.getSystem().getDisplayMetrics().xdpi);
    }
}
