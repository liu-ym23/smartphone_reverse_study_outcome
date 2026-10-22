package com.bytedance.bdtracker;

import android.view.View;
import com.bytedance.applog.log.LoggerImpl;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public class v5 {
    public static Object b;
    public static Field c;
    public static Class d;
    public static Class e;
    public static final List<String> a = Collections.singletonList("WindowHelper");
    public static boolean f = false;
    public static boolean g = false;
    public static boolean h = false;

    public static Object a(View view) {
        try {
            Class[] clsArr = new Class[0];
            return view.getClass().getMethod("getItemData", null).invoke(view, null);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x005b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static android.view.View[] a() throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException {
        /*
            r0 = 0
            android.view.View[] r1 = new android.view.View[r0]
            java.lang.Object r2 = com.bytedance.bdtracker.v5.b
            if (r2 != 0) goto L1b
            java.lang.Object r2 = com.bytedance.bdtracker.w.j
            android.app.Activity r2 = (android.app.Activity) r2
            if (r2 == 0) goto L1a
            r1 = 1
            android.view.View[] r1 = new android.view.View[r1]
            android.view.Window r2 = r2.getWindow()
            android.view.View r2 = r2.getDecorView()
            r1[r0] = r2
        L1a:
            return r1
        L1b:
            boolean r3 = com.bytedance.bdtracker.v5.g     // Catch: java.lang.Exception -> L3e
            if (r3 == 0) goto L2e
            java.lang.reflect.Field r3 = com.bytedance.bdtracker.v5.c     // Catch: java.lang.Exception -> L3e
            java.lang.Object r2 = r3.get(r2)     // Catch: java.lang.Exception -> L3e
            java.util.ArrayList r2 = (java.util.ArrayList) r2     // Catch: java.lang.Exception -> L3e
            java.lang.Object[] r2 = r2.toArray(r1)     // Catch: java.lang.Exception -> L3e
        L2b:
            android.view.View[] r2 = (android.view.View[]) r2     // Catch: java.lang.Exception -> L3e
            goto L3a
        L2e:
            boolean r3 = com.bytedance.bdtracker.v5.h     // Catch: java.lang.Exception -> L3e
            if (r3 == 0) goto L39
            java.lang.reflect.Field r3 = com.bytedance.bdtracker.v5.c     // Catch: java.lang.Exception -> L3e
            java.lang.Object r2 = r3.get(r2)     // Catch: java.lang.Exception -> L3e
            goto L2b
        L39:
            r2 = 0
        L3a:
            if (r2 == 0) goto L4c
            r1 = r2
            goto L4c
        L3e:
            r2 = move-exception
            com.bytedance.applog.log.IAppLogLogger r3 = com.bytedance.applog.log.LoggerImpl.global()
            java.util.List<java.lang.String> r4 = com.bytedance.bdtracker.v5.a
            java.lang.Object[] r5 = new java.lang.Object[r0]
            java.lang.String r6 = "getWindowViews failed"
            r3.error(r4, r6, r2, r5)
        L4c:
            java.util.ArrayList r2 = new java.util.ArrayList
            int r3 = r1.length
            r2.<init>(r3)
            java.util.HashSet r3 = new java.util.HashSet
            r3.<init>()
            int r4 = r1.length
            r5 = r0
        L59:
            if (r5 >= r4) goto L9b
            int r6 = r4 + (-1)
            int r6 = r6 - r5
            r6 = r1[r6]
            if (r6 == 0) goto L98
            int r7 = r6.getWindowVisibility()
            if (r7 != 0) goto L98
            int r7 = r6.getVisibility()
            if (r7 != 0) goto L98
            int r7 = r6.getWidth()
            if (r7 == 0) goto L98
            int r7 = r6.getHeight()
            if (r7 == 0) goto L98
            int r7 = com.bytedance.bdtracker.u5.a(r6)
            java.lang.Integer r8 = java.lang.Integer.valueOf(r7)
            boolean r8 = r3.contains(r8)
            if (r8 != 0) goto L98
            r2.add(r0, r6)
            boolean r6 = b(r6)
            if (r6 == 0) goto L98
            java.lang.Integer r6 = java.lang.Integer.valueOf(r7)
            r3.add(r6)
        L98:
            int r5 = r5 + 1
            goto L59
        L9b:
            int r0 = r2.size()
            android.view.View[] r0 = new android.view.View[r0]
            r2.toArray(r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.bdtracker.v5.a():android.view.View[]");
    }

    public static void b() {
        if (f) {
            return;
        }
        try {
            Class<?> cls = Class.forName("android.view.WindowManagerGlobal");
            c = cls.getDeclaredField("mViews");
            Field declaredField = cls.getDeclaredField("sDefaultWindowManager");
            c.setAccessible(true);
            if (c.getType() == ArrayList.class) {
                g = true;
            } else if (c.getType() == View[].class) {
                h = true;
            }
            declaredField.setAccessible(true);
            b = declaredField.get(null);
        } catch (Throwable th) {
            LoggerImpl.global().error(a, "Get window manager views failed", th, new Object[0]);
        }
        try {
            try {
                d = Class.forName("com.android.internal.policy.PhoneWindow$DecorView");
            } catch (Throwable th2) {
                LoggerImpl.global().error(a, "Get DecorView failed", th2, new Object[0]);
            }
        } catch (ClassNotFoundException unused) {
            d = Class.forName("com.android.internal.policy.DecorView");
        }
        try {
            e = Class.forName("android.widget.PopupWindow$PopupDecorView");
        } catch (Throwable th3) {
            LoggerImpl.global().error(a, "Get popup view failed", th3, new Object[0]);
        }
        f = true;
    }

    public static boolean b(View view) {
        if (!f) {
            b();
        }
        Class<?> cls = view.getClass();
        return cls == d || cls == e;
    }
}
