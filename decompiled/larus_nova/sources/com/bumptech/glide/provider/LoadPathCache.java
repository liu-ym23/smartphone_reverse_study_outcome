package com.bumptech.glide.provider;

import androidx.collection.ArrayMap;
import com.bumptech.glide.load.engine.DecodePath;
import com.bumptech.glide.load.engine.LoadPath;
import com.bumptech.glide.load.resource.transcode.UnitTranscoder;
import com.bumptech.glide.util.MultiClassKey;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes39.dex */
public class LoadPathCache {
    private static final LoadPath<?, ?, ?> NO_PATHS_SIGNAL = null;
    private final ArrayMap<MultiClassKey, LoadPath<?, ?, ?>> cache;
    private final AtomicReference<MultiClassKey> keyRef;

    static {
        NO_PATHS_SIGNAL = new LoadPath(Object.class, Object.class, Object.class, Collections.singletonList(new DecodePath(Object.class, Object.class, Object.class, Collections.emptyList(), new UnitTranscoder(), null)), null);
    }

    public LoadPathCache() {
        this.cache = new ArrayMap();
        this.keyRef = new AtomicReference();
    }

    public boolean isEmptyLoadPath(LoadPath<?, ?, ?> r100) {
        return NO_PATHS_SIGNAL.equals(r100);
    }

    private MultiClassKey getKey(Class<?> r100, Class<?> r101, Class<?> r102) {
        MultiClassKey r103 = this.keyRef.getAndSet(null);
        if (r103 != null) goto L5;
        r103 = new MultiClassKey();
    L5:
        r103.set(r100, r101, r102);
        return r103;
    }

    public <Data, TResource, Transcode> LoadPath<Data, TResource, Transcode> get(Class<Data> r100, Class<TResource> r101, Class<Transcode> r102) {
        MultiClassKey r103 = getKey(r100, r101, r102);
        ArrayMap<MultiClassKey, LoadPath<?, ?, ?>> r104 = this.cache;
        monitor-enter(r104);
        LoadPath<Data, TResource, Transcode> r105 = (LoadPath) this.cache.get(r103);     // Catch: Throwable -> L8
        monitor-exit(r104);     // Catch: Throwable -> L8
        this.keyRef.set(r103);
        return r105;
    L8:
        th = move-exception;
        throw th;
    }

    public void put(Class<?> r100, Class<?> r101, Class<?> r102, LoadPath<?, ?, ?> r103) {
        ArrayMap<MultiClassKey, LoadPath<?, ?, ?>> r104 = this.cache;
        monitor-enter(r104);
        ArrayMap<MultiClassKey, LoadPath<?, ?, ?>> r105 = this.cache;     // Catch: Throwable -> L11
        MultiClassKey r106 = new MultiClassKey(r100, r101, r102);     // Catch: Throwable -> L11
        if (r103 != null) goto L8;
        r103 = NO_PATHS_SIGNAL;     // Catch: Throwable -> L11
    L8:
        r105.put(r106, r103);     // Catch: Throwable -> L11
        monitor-exit(r104);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        throw th;
    }
}
