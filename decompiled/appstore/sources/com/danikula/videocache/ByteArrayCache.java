package com.danikula.videocache;

import java.io.ByteArrayInputStream;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public class ByteArrayCache implements Cache {
    private volatile boolean completed;
    private volatile byte[] data;

    public ByteArrayCache() {
        this(new byte[0]);
    }

    @Override // com.danikula.videocache.Cache
    public void append(byte[] r10, int r11) throws ProxyCacheException {
        Preconditions.checkNotNull(this.data);
        if (r11 >= 0) goto L5;
    L7:
        boolean r12 = false;
    L8:
        Preconditions.checkArgument(r12);
        byte[] r13 = Arrays.copyOf(this.data, this.data.length + r11);
        System.arraycopy(r10, 0, r13, this.data.length, r11);
        this.data = r13;
        return;
    L5:
        if (r11 > r10.length) goto L7;
        r12 = true;
        goto L8
    }

    @Override // com.danikula.videocache.Cache
    public long available() throws ProxyCacheException {
        return this.data.length;
    }

    @Override // com.danikula.videocache.Cache
    public void close() throws ProxyCacheException {
    }

    @Override // com.danikula.videocache.Cache
    public void complete() {
        this.completed = true;
    }

    @Override // com.danikula.videocache.Cache
    public boolean isCompleted() {
        return this.completed;
    }

    @Override // com.danikula.videocache.Cache
    public int read(byte[] r10, long r11, int r12) throws ProxyCacheException {
        if (r11 < this.data.length) goto L7;
        return -1;
    L7:
        if (r11 > 2147483647L) goto L11;
        return new ByteArrayInputStream(this.data).read(r10, (int) r11, r12);
    L11:
        throw new IllegalArgumentException("Too long offset for memory cache " + r11);
    }

    public ByteArrayCache(byte[] r10) {
        this.data = (byte[]) Preconditions.checkNotNull(r10);
    }
}
