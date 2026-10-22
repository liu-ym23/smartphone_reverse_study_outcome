package com.tmall.wireless.tangram.core.resolver;

/* JADX INFO: loaded from: classes4.dex */
public interface Resolver<T, O> {
    public static final int UNKNOWN = -1;

    O create(int r10);

    void register(int r10, T r11);

    int size();

    int type(T r10);
}
