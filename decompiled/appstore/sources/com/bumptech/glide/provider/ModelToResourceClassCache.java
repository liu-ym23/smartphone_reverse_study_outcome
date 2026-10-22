package com.bumptech.glide.provider;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import com.bumptech.glide.util.MultiClassKey;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
public class ModelToResourceClassCache {
    private final ArrayMap registeredResourceClassCache;
    private final AtomicReference<MultiClassKey> resourceClassKeyRef;

    public ModelToResourceClassCache() {
        this.resourceClassKeyRef = new AtomicReference();
        this.registeredResourceClassCache = new ArrayMap();
    }

    public void clear() {
        ArrayMap r10 = this.registeredResourceClassCache;
        monitor-enter(r10);
        this.registeredResourceClassCache.clear();     // Catch: Throwable -> L7
        monitor-exit(r10);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Nullable
    public List<Class<?>> get(@NonNull Class<?> r10, @NonNull Class<?> r11, @NonNull Class<?> r12) {
        MultiClassKey r13 = this.resourceClassKeyRef.getAndSet(null);
        if (r13 != null) goto L5;
        r13 = new MultiClassKey(r10, r11, r12);
    L6:
        ArrayMap r14 = this.registeredResourceClassCache;
        monitor-enter(r14);
        List<Class<?>> r15 = (List) this.registeredResourceClassCache.get(r13);     // Catch: Throwable -> L12
        monitor-exit(r14);     // Catch: Throwable -> L12
        this.resourceClassKeyRef.set(r13);
        return r15;
    L12:
        th = move-exception;
        throw th;
    L5:
        r13.set(r10, r11, r12);
        goto L6
    }

    public void put(@NonNull Class<?> r10, @NonNull Class<?> r11, @NonNull Class<?> r12, @NonNull List<Class<?>> r13) {
        ArrayMap r14 = this.registeredResourceClassCache;
        monitor-enter(r14);
        this.registeredResourceClassCache.put(new MultiClassKey(r10, r11, r12), r13);     // Catch: Throwable -> L7
        monitor-exit(r14);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }
}
