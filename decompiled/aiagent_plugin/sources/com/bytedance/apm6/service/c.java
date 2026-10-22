package com.bytedance.apm6.service;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: ServiceManager.java */
/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final ConcurrentHashMap<Class, Object> f5444a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ConcurrentHashMap<Class, a<?>> f5445b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final ConcurrentHashMap<Class, b> f5446c = null;

    public c() {
    }

    static {
        f5444a = new ConcurrentHashMap();
        f5445b = new ConcurrentHashMap();
        f5446c = new ConcurrentHashMap();
    }

    public static <T> T a(Class<T> r6) {
        T r0 = (T) f5444a.get(r6);
        if (r0 == null) goto L5;
    L18:
        return r0;
    L5:
        monitor-enter(c.class);
        ConcurrentHashMap<Class, a<?>> r2 = f5445b;     // Catch: Throwable -> L15
        a r3 = (a) ZeusTransformUtils.preCheckCast(r2.get(r6), a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L15
        if (r3 == null) goto L13;
        r0 = (T) r3.b();
        r2.remove(r6);     // Catch: Throwable -> L15
        if (r0 == null) goto L13;
        b(r6, r0);     // Catch: Throwable -> L15
        monitor-exit(c.class);     // Catch: Throwable -> L15
        return r0;
    L13:
        monitor-exit(c.class);     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        throw th;
    }

    public static <T> void a(Class<T> r1, T r2) {
        f5444a.put(r1, r2);
    }

    public static <T> void a(Class<T> r2, a<T> r3) {
        a<?> r4 = (a) ZeusTransformUtils.wrapperContextForParams(r3, a.class, "com.obric.aiagent.plugin");
        f5445b.put(r2, r4);
    }

    private static <T> void b(Class<T> r4, T r5) {
        f5444a.put(r4, r5);
        ConcurrentHashMap<Class, b> r0 = f5446c;
        b r1 = (b) ZeusTransformUtils.preCheckCast(r0.get(r4), b.class, "com.obric.aiagent.plugin");
        if (r1 == null) goto L6;
        r1.a(r5);
        r0.remove(r4);
        return;
    }
}
