package com.bytedance.android.livesdk.dslservice.slice.cache;

import android.util.LruCache;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes8.dex */
public abstract class AbsCacheMap<Key, Value> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f122931a;

    public final LruCache<Key, Value> b() {
        return (LruCache) this.f122931a.getValue();
    }

    public AbsCacheMap() {
        this.f122931a = LazyKt.lazy(new AbsCacheMap$cacheMap$2(this));
    }

    public final Value a(Key r100) {
        return b().get(r100);
    }
}
