package com.android.server.flags;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public class FlagCache<V> {
    final Map<String, Map<String, V>> mCache;
    private final Function<String, HashMap<String, V>> mNewHashMap;

    /* JADX INFO: renamed from: $r8$lambda$627xT1dedfgk5-2I2VGDthKmOCM, reason: not valid java name */
    public static /* synthetic */ HashMap m4240$r8$lambda$627xT1dedfgk52I2VGDthKmOCM(String r0) {
        return lambda$new$0(r0);
    }

    private static /* synthetic */ HashMap lambda$new$0(String k) {
        return new HashMap();
    }

    FlagCache() {
        this.mNewHashMap = new FlagCache$$ExternalSyntheticLambda0();
        this.mCache = new HashMap();
    }

    boolean containsNamespace(String namespace) {
        Map<String, Map<String, V>> r0 = this.mCache;
        monitor-enter(r0);
        boolean r1 = this.mCache.containsKey(namespace);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    boolean contains(String namespace, String name) {
        Map<String, Map<String, V>> r0 = this.mCache;
        monitor-enter(r0);
        Map<String, V> nsCache = this.mCache.get(namespace);     // Catch: Throwable -> L9
        if (nsCache != null) goto L7;
    L11:
        boolean r2 = false;
    L12:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r2;
    L7:
        if (nsCache.containsKey(name) == false) goto L11;
        r2 = true;
    L9:
        th = move-exception;
        throw th;
    }

    boolean setIfChanged(String namespace, String name, V value) {
        Map<String, Map<String, V>> r0 = this.mCache;
        monitor-enter(r0);
        Map<String, V> nsCache = this.mCache.computeIfAbsent(namespace, this.mNewHashMap);     // Catch: Throwable -> L12
        V curValue = nsCache.get(name);     // Catch: Throwable -> L12
        if (curValue == null) goto L14;
        if (curValue.equals(value) == false) goto L14;
        monitor-exit(r0);     // Catch: Throwable -> L12
        return false;
    L14:
        nsCache.put(name, value);     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
        return true;
    L12:
        th = move-exception;
        throw th;
    }

    V getOrSet(String namespace, String name, V defaultValue) {
        Map<String, Map<String, V>> r0 = this.mCache;
        monitor-enter(r0);
        Map<String, V> nsCache = this.mCache.computeIfAbsent(namespace, this.mNewHashMap);     // Catch: Throwable -> L10
        V value = nsCache.putIfAbsent(name, defaultValue);     // Catch: Throwable -> L10
        if (value != null) goto L7;
        V r3 = defaultValue;
    L8:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r3;
    L7:
        r3 = value;
    L10:
        th = move-exception;
        throw th;
    }

    V getOrNull(String namespace, String name) {
        Map<String, Map<String, V>> r0 = this.mCache;
        monitor-enter(r0);
        Map<String, V> nsCache = this.mCache.get(namespace);     // Catch: Throwable -> L9
        if (nsCache != null) goto L11;
        monitor-exit(r0);     // Catch: Throwable -> L9
        return null;
    L11:
        V r2 = nsCache.get(name);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r2;
    L9:
        th = move-exception;
        throw th;
    }
}
