package com.ss.android.deviceregister.b;

import android.util.Log;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.ss.android.deviceregister.m;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: ServiceManager.java */
/* JADX INFO: loaded from: classes4.dex */
public class b {
    private static final String TAG = "ServiceManager ";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final ConcurrentHashMap<Class, Object> f37354a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ConcurrentHashMap<Class, a> f37355b = null;

    static {
        f37354a = new ConcurrentHashMap();
        f37355b = new ConcurrentHashMap();
    }

    public static <T> void a(Class<T> r2, T r3) {
        ConcurrentHashMap<Class, Object> r0 = f37354a;
        if (r0.containsKey(m.class) == true) goto L6;
        r0.put(r2, r3);
        a(TAG, "register service: " + r2.getName());
        return;
    }

    public static <T> T a(Class<T> r6) {
        ConcurrentHashMap<Class, Object> r0 = f37354a;
        Object r1 = (T) r0.get(r6);
        if (r1 != null) goto L18;
        monitor-enter(r0);
        r1 = r0.get(r6);     // Catch: Throwable -> L15
        if (r1 != null) goto L13;
        ConcurrentHashMap<Class, a> r2 = f37355b;     // Catch: Throwable -> L15
        a r3 = (a) ZeusTransformUtils.preCheckCast(r2.get(r6), a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L15
        if (r3 == null) goto L13;
        r1 = (T) r3.a(r6);
        if (r1 == null) goto L12;
        r0.put(r6, r1);     // Catch: Throwable -> L15
    L12:
        r2.remove(r6);     // Catch: Throwable -> L15
        a(TAG, "create service: " + r6.getName());     // Catch: Throwable -> L15
    L13:
        monitor-exit(r0);     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        throw th;
    L18:
        return (T) r1;
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.d(r1, r2);
    }
}
