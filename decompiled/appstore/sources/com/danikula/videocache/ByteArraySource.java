package com.danikula.videocache;

import java.io.ByteArrayInputStream;

/* JADX INFO: loaded from: classes2.dex */
public class ByteArraySource implements Source {
    private ByteArrayInputStream arrayInputStream;
    private final byte[] data;

    public ByteArraySource(byte[] r10) {
        this.data = r10;
    }

    @Override // com.danikula.videocache.Source
    public void close() throws ProxyCacheException {
    }

    @Override // com.danikula.videocache.Source
    public long length() throws ProxyCacheException {
        return this.data.length;
    }

    @Override // com.danikula.videocache.Source
    public void open(long r10) throws ProxyCacheException {
        ByteArrayInputStream r11 = new ByteArrayInputStream(this.data);
        this.arrayInputStream = r11;
        r11.skip(r10);
    }

    @Override // com.danikula.videocache.Source
    public int read(byte[] r10) throws ProxyCacheException {
        return this.arrayInputStream.read(r10, 0, r10.length);
    }
}
