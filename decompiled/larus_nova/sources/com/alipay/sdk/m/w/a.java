package com.alipay.sdk.m.w;

import android.content.Context;
import android.os.SystemClock;
import android.util.Pair;
import com.alipay.sdk.m.u.e;
import com.alipay.sdk.m.u.n;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes28.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f25883a = "CDT";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f25884b = 1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f25885c = 2;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f25886d = 3;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f25887e = 4;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f25888f = 5;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static ConcurrentHashMap<Integer, Pair<Long, ?>> f25889g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static ExecutorService f25890h;

    /* JADX INFO: renamed from: com.alipay.sdk.m.w.a$a, reason: collision with other inner class name */
    public interface InterfaceC0495a<T, R> {
        R a(T r100);
    }

    static {
        f25890h = PThreadExecutorsUtils.newFixedThreadPool(16, new DefaultThreadFactory("pay/sdk/m/w/a"));
    }

    public static synchronized void a() {
        monitor-enter(a.class);
        f25889g = null;     // Catch: Throwable -> L8
        monitor-exit(a.class);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public a() {
    }

    public static Context a(Context r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        return r100.getApplicationContext();
    }

    public static synchronized void a(int r100, Object r101) {
        monitor-enter(a.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (f25889g != null) goto L7;
        f25889g = new ConcurrentHashMap();     // Catch: Throwable -> L10
    L7:
        f25889g.put(Integer.valueOf(r100), new Pair(Long.valueOf(SystemClock.elapsedRealtime()), r101));     // Catch: Throwable -> L10
        monitor-exit(a.class);
    }

    public static Pair<Boolean, ?> a(int r100, TimeUnit r101, long r102) {
        ConcurrentHashMap<Integer, Pair<Long, ?>> r103 = f25889g;
        if (r103 == null) goto L5;
        Pair<Long, ?> r104 = r103.get(Integer.valueOf(r100));
        if (r104 == null) goto L9;
        Long r105 = (Long) r104.first;
        Object r106 = r104.second;
        if (r105 == null) goto L18;
        if ((SystemClock.elapsedRealtime() - r105.longValue()) > TimeUnit.MILLISECONDS.convert(r102, r101)) goto L18;
        return new Pair(Boolean.TRUE, r106);
    L18:
        return new Pair(Boolean.FALSE, null);
    L9:
        return new Pair(Boolean.FALSE, null);
    L5:
        return new Pair(Boolean.FALSE, null);
    }

    public static <T> T a(int r100, long r101, TimeUnit r102, InterfaceC0495a<Object, Boolean> r103, Callable<T> r104, boolean r110, long r111, TimeUnit r112, com.alipay.sdk.m.s.a r113, boolean r114) {
        Pair<Boolean, ?> r105 = a(r100, r102, r101);     // Catch: Throwable -> L20
        if (((Boolean) r105.first).booleanValue() == true) goto L6;
    L9:
        if (r114 == true) goto L11;
    L14:
        if (r110 == false) goto L16;
        T r106 = f25890h.submit(r104).get(r111, r112);     // Catch: Throwable -> L20
    L17:
        a(r100, r106);     // Catch: Throwable -> L20
    L18:
        e.d("getC", r100 + " new " + r106);     // Catch: Throwable -> L20
        return r106;
    L16:
        r106 = r104.call();     // Catch: Throwable -> L20
        goto L17
    L11:
        if (n.h() == false) goto L14;
        com.alipay.sdk.m.k.a.b(r113, "biz", "ch_get_main", "" + r100);     // Catch: Throwable -> L20
        e.d("getC", r100 + " skip");     // Catch: Throwable -> L20
        r106 = null;
        goto L18
    L6:
        if (r103.a(r105.second).booleanValue() == false) goto L9;
        e.d("getC", r100 + " got " + r105.second);     // Catch: Throwable -> L20
        return (T) r105.second;
    L20:
        th = move-exception;
        e.a(f25883a, "ch_get_e|" + r100, th);
        com.alipay.sdk.m.k.a.a(r113, "biz", "ch_get_e|" + r100, th);
        e.d("getC", r100 + " err");
        return null;
    }
}
