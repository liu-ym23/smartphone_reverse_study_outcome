package com.android.server;

import android.annotation.SystemApi;
import android.util.ArrayMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@SystemApi(client = SystemApi.Client.SYSTEM_SERVER)
public final class LocalManagerRegistry {
    private static final Map<Class<?>, Object> sManagers = null;

    public static class ManagerNotFoundException extends Exception {
        public <T> ManagerNotFoundException(Class<T> managerClass) {
            super("Local manager " + managerClass.getName() + " does not exist or is not ready");
        }
    }

    private LocalManagerRegistry() {
    }

    static {
        sManagers = new ArrayMap();
    }

    public static <T> T getManager(Class<T> r2) {
        Map<Class<?>, Object> r0 = sManagers;
        monitor-enter(r0);
        T r1 = (T) sManagers.get(r2);
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public static <T> T getManagerOrThrow(Class<T> r2) throws ManagerNotFoundException {
        T r0 = (T) getManager(r2);
        if (r0 == null) goto L6;
        return r0;
    L6:
        throw new ManagerNotFoundException(r2);
    }

    public static <T> void addManager(Class<T> managerClass, T manager) {
        managerClass.getClass();
        manager.getClass();
        Map<Class<?>, Object> r0 = sManagers;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (sManagers.containsKey(managerClass) == true) goto L12;
        sManagers.put(managerClass, manager);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L12:
        throw new IllegalStateException(managerClass.getName() + " is already registered");     // Catch: Throwable -> L9
    }
}
