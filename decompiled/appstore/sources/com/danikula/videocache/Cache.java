package com.danikula.videocache;

/* JADX INFO: loaded from: classes2.dex */
public interface Cache {
    void append(byte[] r10, int r11) throws ProxyCacheException;

    long available() throws ProxyCacheException;

    void close() throws ProxyCacheException;

    void complete() throws ProxyCacheException;

    boolean isCompleted();

    int read(byte[] r10, long r11, int r12) throws ProxyCacheException;
}
