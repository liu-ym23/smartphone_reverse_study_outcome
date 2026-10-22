package com.tmall.wireless.tangram.core.resolver;

/* JADX INFO: loaded from: classes4.dex */
public abstract class InstanceResolver<T> extends BaseResolver<T, T> {
    public InstanceResolver() {
    }

    @Override // com.tmall.wireless.tangram.core.resolver.Resolver
    public T create(int r10) {
        return this.mSparseArray.get(r10);
    }
}
