package com.tmall.wireless.tangram.core.resolver;

import android.util.SparseArray;
import androidx.collection.ArrayMap;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public abstract class BaseResolver<T, O> implements Resolver<T, O> {
    protected Map<T, Integer> mMap;
    protected SparseArray<T> mSparseArray;

    public BaseResolver() {
        this.mMap = new ArrayMap(64);
        this.mSparseArray = new SparseArray(64);
    }

    @Override // com.tmall.wireless.tangram.core.resolver.Resolver
    public void register(int r10, T r11) {
        this.mMap.put(r11, Integer.valueOf(r10));
        this.mSparseArray.put(r10, r11);
    }

    @Override // com.tmall.wireless.tangram.core.resolver.Resolver
    public int size() {
        return this.mSparseArray.size();
    }

    @Override // com.tmall.wireless.tangram.core.resolver.Resolver
    public int type(T r10) {
        if (this.mMap.containsKey(r10) == true) goto L5;
        return -1;
    L5:
        return this.mMap.get(r10).intValue();
    }
}
