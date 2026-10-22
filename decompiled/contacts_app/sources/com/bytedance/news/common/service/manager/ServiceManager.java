package com.bytedance.news.common.service.manager;

import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
public class ServiceManager {
    private static final ConcurrentHashMap<Class, Object> SERVICES = null;
    private static final ConcurrentHashMap<Class, ServiceCreator<?>> SERVICE_CREATORS = null;
    private static final ConcurrentHashMap<Class, ServiceLoadListener> SERVICE_LOAD_LISTENERS = null;

    public ServiceManager() {
    }

    static {
        SERVICES = new ConcurrentHashMap();
        SERVICE_CREATORS = new ConcurrentHashMap();
        SERVICE_LOAD_LISTENERS = new ConcurrentHashMap();
    }

    public static <T> T getService(Class<T> r2) {
        ConcurrentHashMap<Class, Object> r0 = SERVICES;
        T r1 = (T) r0.get(r2);
        if (r1 != null) goto L33;
        monitor-enter(r2);
        T r3 = (T) r0.get(r2);
        if (r3 == null) goto L9;
        monitor-exit(r2);     // Catch: Throwable -> L30
        return r3;
    L9:
        ConcurrentHashMap<Class, ServiceCreator<?>> r4 = SERVICE_CREATORS;     // Catch: Throwable -> L30
        ServiceCreator<?> r5 = r4.get(r2);     // Catch: Throwable -> L30
        if (r5 == null) goto L35;
        T r6 = (T) r5.create();
        r4.remove(r2);     // Catch: Throwable -> L30
        if (r6 == null) goto L35;
        putService(r2, r6);     // Catch: Throwable -> L30
        monitor-exit(r2);     // Catch: Throwable -> L30
        return r6;
    L35:
        T r7 = (T) ServiceFinder.findService(r2);
        if (r7 == null) goto L23;
        putService(r2, r7);     // Catch: Exception -> L21 Throwable -> L30
        monitor-exit(r2);     // Catch: Throwable -> L30
        return r7;
    L23:
        r1 = (T) tryGetByReflect(r2);
        if (r1 == null) goto L28;
        putService(r2, r1);     // Catch: Throwable -> L30
        monitor-exit(r2);     // Catch: Throwable -> L30
        return r1;
    L28:
        monitor-exit(r2);     // Catch: Throwable -> L30
    L21:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L30
    L30:
        th = move-exception;
        throw th;
    L33:
        return r1;
    }

    public static <T> void registerService(Class<T> r1, T r2) {
        SERVICES.put(r1, r2);
    }

    public static <T> void registerService(Class<T> r1, ServiceCreator<T> r2) {
        SERVICE_CREATORS.put(r1, r2);
    }

    public static <T> void unregisterService(Class<T> r1, T r2) {
        SERVICES.remove(r1, r2);
    }

    public static <T> void registerServiceLoadListener(Class<T> r1, ServiceLoadListener<T> r2) {
        SERVICE_LOAD_LISTENERS.put(r1, r2);
    }

    private static <T> void putService(Class<T> r2, T r3) {
        SERVICES.put(r2, r3);
        ConcurrentHashMap<Class, ServiceLoadListener> r0 = SERVICE_LOAD_LISTENERS;
        ServiceLoadListener r1 = r0.get(r2);
        if (r1 == null) goto L6;
        r1.onServiceLoaded(r3);
        r0.remove(r2);
        return;
    }

    private static <T> T tryGetByReflect(Class<T> r2) {
        Object r3 = Class.forName(String.format("%s__ServiceProxy", new Object[]{r2.getName()})).newInstance();     // Catch: Throwable -> L9
        if ((r3 instanceof IServiceProxy) == false) goto L7;
        return (T) ((IServiceProxy) r3).newInstance();
    L7:
        return null;
    L12:
        return null;
    }
}
