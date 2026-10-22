package com.amap.api.mapcore.util;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes28.dex */
public class j4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f27455a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Map<String, a> f27456b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    List<String> f27457c;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f27458a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Object f27459b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private Class<?>[] f27460c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private Object[] f27461d;

        public static /* synthetic */ Object a(a r100) {
            return r100.f27459b;
        }

        public static /* synthetic */ String b(a r100) {
            return r100.f27458a;
        }

        public static /* synthetic */ Class[] c(a r100) {
            return r100.f27460c;
        }

        public static /* synthetic */ Object[] d(a r100) {
            return r100.f27461d;
        }

        public a(Object r100, String r101, Object... r102) {
            this.f27459b = r100;
            this.f27458a = r101;
            if (r102 != null) goto L5;
            return;
        L5:
            if (r102.length <= 0) goto L17;
            this.f27460c = new Class[r102.length];
            int r103 = 0;
            int r104 = 0;
        L8:
            if (r104 >= r102.length) goto L10;
            this.f27460c[r104] = r102[r104].getClass();
            r104 = r104 + 1;
            goto L8
        L10:
            this.f27461d = new Object[r102.length];
        L12:
            if (r103 >= r102.length) goto L18;
            this.f27461d[r103] = r102[r103];
            r103 = r103 + 1;
            goto L12
        L18:
            return;
        }
    }

    public synchronized void a() {
        monitor-enter(this);
    L55:
        th = move-exception;
        throw th;
    L5:
        if (this.f27455a != true) goto L8;
        monitor-exit(this);
        return;
    L8:
        this.f27455a = true;     // Catch: Throwable -> L55
        Map<String, a> r100 = this.f27456b;     // Catch: Throwable -> L55
        if (r100 != null) goto L11;
    L53:
        monitor-exit(this);
        return;
    L11:
        if (r100.isEmpty() == true) goto L53;
        List<String> r101 = this.f27457c;     // Catch: Throwable -> L55
        if (r101 == null) goto L53;
        if (r101.isEmpty() == true) goto L53;
        int r102 = 0;
    L18:
        if (r102 >= this.f27457c.size()) goto L52;
        a r103 = this.f27456b.get(ListProtector.get(this.f27457c, r102));     // Catch: Throwable -> L55
        if (r103 == null) goto L51;
        if (a.a(r103) == null) goto L51;
        Class<?> r104 = a.a(r103).getClass();     // Catch: InvocationTargetException -> L41 IllegalArgumentException -> L43 IllegalAccessException -> L45 SecurityException -> L47 NoSuchMethodException -> L49 Throwable -> L55
        Method r105 = r104.getDeclaredMethod(a.b(r103), a.c(r103));     // Catch: NoSuchMethodException -> L27 InvocationTargetException -> L41 IllegalArgumentException -> L43 IllegalAccessException -> L45 SecurityException -> L47 Throwable -> L55
    L38:
        if (r105 == null) goto L51;
        r105.setAccessible(true);     // Catch: InvocationTargetException -> L41 IllegalArgumentException -> L43 IllegalAccessException -> L45 SecurityException -> L47 NoSuchMethodException -> L49 Throwable -> L55
        r105.invoke(a.a(r103), a.d(r103));     // Catch: InvocationTargetException -> L41 IllegalArgumentException -> L43 IllegalAccessException -> L45 SecurityException -> L47 NoSuchMethodException -> L49 Throwable -> L55
    L28:
        if (a.c(r103).length <= 0) goto L37;
        Class<?>[] r106 = new Class[a.c(r103).length];     // Catch: InvocationTargetException -> L41 IllegalArgumentException -> L43 IllegalAccessException -> L45 SecurityException -> L47 NoSuchMethodException -> L49 Throwable -> L55
        int r107 = 0;
    L31:
        if (r107 >= a.c(r103).length) goto L36;
        if (a.c(r103)[r107].getInterfaces().length <= 0) goto L35;
        r106[r107] = a.c(r103)[r107].getInterfaces()[0];     // Catch: InvocationTargetException -> L41 IllegalArgumentException -> L43 IllegalAccessException -> L45 SecurityException -> L47 NoSuchMethodException -> L49 Throwable -> L55
    L35:
        r107 = r107 + 1;     // Catch: InvocationTargetException -> L41 IllegalArgumentException -> L43 IllegalAccessException -> L45 SecurityException -> L47 NoSuchMethodException -> L49 Throwable -> L55
        goto L31
    L36:
        r105 = r104.getDeclaredMethod(a.b(r103), r106);     // Catch: InvocationTargetException -> L41 IllegalArgumentException -> L43 IllegalAccessException -> L45 SecurityException -> L47 NoSuchMethodException -> L49 Throwable -> L55
        goto L38
    L37:
        r105 = null;
        goto L38
    L49:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L55
    L47:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L55
    L41:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L55
    L45:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L55
    L43:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L55
    L51:
        r102 = r102 + 1;     // Catch: Throwable -> L55
        goto L18
    L52:
        this.f27456b.clear();     // Catch: Throwable -> L55
        this.f27457c.clear();     // Catch: Throwable -> L55
        goto L53
    }

    public j4() {
        this.f27455a = false;
        this.f27456b = Collections.synchronizedMap(new HashMap());
        this.f27457c = Collections.synchronizedList(new LinkedList());
    }

    public synchronized void a(Object r100, Object... r101) {
        monitor-enter(this);
        StackTraceElement[] r102 = ThreadMethodProxy.currentThread().getStackTrace();     // Catch: Throwable -> L24
        if (r102 == null) goto L27;
        if (r102.length < 3) goto L27;
        String r103 = r102[3].getMethodName();     // Catch: Throwable -> L24
        StringBuilder r104 = new StringBuilder();     // Catch: Throwable -> L24
        r104.append(r100.getClass().getName());     // Catch: Throwable -> L24
        r104.append("::");     // Catch: Throwable -> L24
        r104.append(r103);     // Catch: Throwable -> L24
        r104.append("(");     // Catch: Throwable -> L24
        if (r101.length <= 0) goto L14;
        int r105 = 0;
    L12:
        if (r105 >= r101.length) goto L14;
        r104.append(r101[r105].getClass().getName());     // Catch: Throwable -> L24
        r104.append(",");     // Catch: Throwable -> L24
        r105 = r105 + 1;     // Catch: Throwable -> L24
    L14:
        r104.append(")");     // Catch: Throwable -> L24
        String r106 = t5.a(r104.toString());     // Catch: Throwable -> L24
        a r107 = new a(r100, r103, r101);     // Catch: Throwable -> L24
        if (this.f27457c.contains(r106) == true) goto L17;
        List<String> r108 = this.f27457c;     // Catch: Throwable -> L24
        r108.add(r108.size(), r106);     // Catch: Throwable -> L24
    L17:
        this.f27456b.put(r106, r107);     // Catch: Throwable -> L24
    L27:
        this.f27455a = false;     // Catch: Throwable -> L21
        monitor-exit(this);
        return;
    L21:
        th = move-exception;
        throw th;
    }
}
