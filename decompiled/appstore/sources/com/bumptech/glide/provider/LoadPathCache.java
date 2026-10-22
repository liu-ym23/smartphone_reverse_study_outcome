package com.bumptech.glide.provider;

import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import com.bumptech.glide.load.engine.DecodePath;
import com.bumptech.glide.load.engine.LoadPath;
import com.bumptech.glide.load.resource.transcode.UnitTranscoder;
import com.bumptech.glide.util.MultiClassKey;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
public class LoadPathCache {
    private static final LoadPath<?, ?, ?> NO_PATHS_SIGNAL = null;
    private final ArrayMap cache;
    private final AtomicReference<MultiClassKey> keyRef;

    static {
        NO_PATHS_SIGNAL = new LoadPath(Object.class, Object.class, Object.class, Collections.singletonList(new DecodePath(Object.class, Object.class, Object.class, Collections.emptyList(), new UnitTranscoder(), null)), null);
    }

    public LoadPathCache() {
        this.cache = new ArrayMap();
        this.keyRef = new AtomicReference();
    }

    private MultiClassKey getKey(Class<?> r10, Class<?> r11, Class<?> r12) {
        MultiClassKey r13 = this.keyRef.getAndSet(null);
        if (r13 != null) goto L5;
        r13 = new MultiClassKey();
    L5:
        r13.set(r10, r11, r12);
        return r13;
    }

    @Nullable
    public <Data, TResource, Transcode> LoadPath<Data, TResource, Transcode> get(Class<Data> r10, Class<TResource> r11, Class<Transcode> r12) {
        MultiClassKey r13 = getKey(r10, r11, r12);
        ArrayMap r14 = this.cache;
        monitor-enter(r14);
        LoadPath<Data, TResource, Transcode> r15 = (LoadPath) this.cache.get(r13);     // Catch: Throwable -> L8
        monitor-exit(r14);     // Catch: Throwable -> L8
        this.keyRef.set(r13);
        return r15;
    L8:
        th = move-exception;
        throw th;
    }

    public boolean isEmptyLoadPath(@Nullable LoadPath<?, ?, ?> r10) {
        return NO_PATHS_SIGNAL.equals(r10);
    }

    public void put(Class<?> r10, Class<?> r11, Class<?> r12, @Nullable LoadPath<?, ?, ?> r13) {
        ArrayMap r14 = this.cache;
        monitor-enter(r14);
        ArrayMap r15 = this.cache;     // Catch: Throwable -> L11
        MultiClassKey r16 = new MultiClassKey(r10, r11, r12);     // Catch: Throwable -> L11
        if (r13 != null) goto L8;
        r13 = NO_PATHS_SIGNAL;     // Catch: Throwable -> L11
    L8:
        r15.put(r16, r13);     // Catch: Throwable -> L11
        monitor-exit(r14);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        throw th;
    }
}
