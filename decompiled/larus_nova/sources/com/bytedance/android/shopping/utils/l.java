package com.bytedance.android.shopping.utils;

import com.bytedance.jedi.model.ext.cache.guava.LruCache;
import java.util.List;
import kotlin.Pair;

/* JADX INFO: loaded from: classes14.dex */
public class l<K, V> extends LruCache<K, V> {
    @Override // com.bytedance.jedi.model.ext.cache.guava.LruCache
    public final List<Pair<K, V>> h() {
        return super.h();
    }

    public l(long r100) {
        super(r100);
    }

    @Override // com.bytedance.jedi.model.cache.AbstractCache
    public final V b(K r100) {
        return this.f251069b.f251068a.getIfPresent(r100);
    }

    public final void i(K r100) {
        super.g(r100, null);
    }

    @Override // com.bytedance.jedi.model.ext.cache.guava.LruCache, com.bytedance.jedi.model.cache.AbstractCache
    public final void g(K r100, V r101) {
        super.g(r100, r101);
    }
}
