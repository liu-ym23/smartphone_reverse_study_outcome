package com.blankj.utilcode.util;

import android.content.res.Resources;
import android.util.DisplayMetrics;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static List<Field> f19233a;

    public class a implements Runnable {
        @Override // java.lang.Runnable
        public void run() throws SecurityException {
            b.g();
        }
    }

    public static void b(Resources resources, float f10) throws SecurityException {
        resources.getDisplayMetrics().xdpi = f10;
        p.a().getResources().getDisplayMetrics().xdpi = f10;
        d(resources, f10);
    }

    public static void c(Resources resources, float f10) {
        Iterator<Field> it = f19233a.iterator();
        while (it.hasNext()) {
            try {
                DisplayMetrics displayMetrics = (DisplayMetrics) it.next().get(resources);
                if (displayMetrics != null) {
                    displayMetrics.xdpi = f10;
                }
            } catch (Exception e10) {
                e10.printStackTrace();
            }
        }
    }

    public static void d(Resources resources, float f10) throws SecurityException {
        if (f19233a != null) {
            c(resources, f10);
            return;
        }
        f19233a = new ArrayList();
        Class<?> superclass = resources.getClass();
        Field[] declaredFields = superclass.getDeclaredFields();
        while (declaredFields != null && declaredFields.length > 0) {
            for (Field field : declaredFields) {
                if (field.getType().isAssignableFrom(DisplayMetrics.class)) {
                    field.setAccessible(true);
                    DisplayMetrics displayMetricsE = e(resources, field);
                    if (displayMetricsE != null) {
                        f19233a.add(field);
                        displayMetricsE.xdpi = f10;
                    }
                }
            }
            superclass = superclass.getSuperclass();
            if (superclass == null) {
                return;
            } else {
                declaredFields = superclass.getDeclaredFields();
            }
        }
    }

    public static DisplayMetrics e(Resources resources, Field field) {
        try {
            return (DisplayMetrics) field.get(resources);
        } catch (Exception unused) {
            return null;
        }
    }

    public static Runnable f() {
        return new a();
    }

    public static void g() throws SecurityException {
        b(Resources.getSystem(), Resources.getSystem().getDisplayMetrics().xdpi);
    }
}
