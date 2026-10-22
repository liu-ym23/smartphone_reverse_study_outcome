package com.bumptech.glide.provider;

import androidx.collection.ArrayMap;
import com.bumptech.glide.util.MultiClassKey;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes39.dex */
public class ModelToResourceClassCache {
    private final ArrayMap<MultiClassKey, List<Class<?>>> registeredResourceClassCache;
    private final AtomicReference<MultiClassKey> resourceClassKeyRef;

    public void clear() {
        ArrayMap<MultiClassKey, List<Class<?>>> r100 = this.registeredResourceClassCache;
        monitor-enter(r100);
        this.registeredResourceClassCache.clear();     // Catch: Throwable -> L7
        monitor-exit(r100);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public ModelToResourceClassCache() {
        this.resourceClassKeyRef = new AtomicReference();
        this.registeredResourceClassCache = new ArrayMap();
    }

    public List<Class<?>> get(Class<?> r100, Class<?> r101, Class<?> r102) {
        MultiClassKey r103 = this.resourceClassKeyRef.getAndSet(null);
        if (r103 != null) goto L5;
        r103 = new MultiClassKey(r100, r101, r102);
    L6:
        ArrayMap<MultiClassKey, List<Class<?>>> r104 = this.registeredResourceClassCache;
        monitor-enter(r104);
        List<Class<?>> r105 = this.registeredResourceClassCache.get(r103);     // Catch: Throwable -> L12
        monitor-exit(r104);     // Catch: Throwable -> L12
        this.resourceClassKeyRef.set(r103);
        return r105;
    L12:
        th = move-exception;
        throw th;
    L5:
        r103.set(r100, r101, r102);
        goto L6
    }

    public void put(Class<?> r100, Class<?> r101, Class<?> r102, List<Class<?>> r103) {
        ArrayMap<MultiClassKey, List<Class<?>>> r104 = this.registeredResourceClassCache;
        monitor-enter(r104);
        this.registeredResourceClassCache.put(new MultiClassKey(r100, r101, r102), r103);     // Catch: Throwable -> L7
        monitor-exit(r104);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }
}
