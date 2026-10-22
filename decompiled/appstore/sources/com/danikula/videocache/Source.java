package com.danikula.videocache;

/* JADX INFO: loaded from: classes2.dex */
public interface Source {
    void close() throws ProxyCacheException;

    long length() throws ProxyCacheException;

    void open(long r10) throws ProxyCacheException;

    int read(byte[] r10) throws ProxyCacheException;
}
