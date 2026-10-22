package com.google.common.cache;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.google.common.util.concurrent.UncheckedExecutionException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.ExecutionException;

/* JADX INFO: loaded from: classes3.dex */
@GwtIncompatible
public abstract class AbstractLoadingCache<K, V> extends AbstractCache<K, V> implements LoadingCache<K, V> {
    public AbstractLoadingCache() {
    }

    @Override // com.google.common.cache.LoadingCache, com.google.common.base.Function
    public final V apply(K r10) {
        return getUnchecked(r10);
    }

    @Override // com.google.common.cache.LoadingCache
    public ImmutableMap<K, V> getAll(Iterable<? extends K> r10) throws ExecutionException {
        LinkedHashMap r11 = Maps.newLinkedHashMap();
        Iterator<? extends K> r12 = r10.iterator();
    L4:
        if (r12.hasNext() == false) goto L9;
        K r13 = r12.next();
        if (r11.containsKey(r13) == true) goto L4;
        r11.put(r13, get(r13));
        goto L4
    L9:
        return ImmutableMap.copyOf(r11);
    }

    @Override // com.google.common.cache.LoadingCache
    public V getUnchecked(K r10) {
        return get(r10);
    L4:
        e = move-exception;
        throw new UncheckedExecutionException(e.getCause());
    }

    @Override // com.google.common.cache.LoadingCache
    public void refresh(K r10) {
        throw new UnsupportedOperationException();
    }
}
