package com.bytedance.compression.zstd;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public class b implements BufferPool {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final BufferPool f7121a = null;

    static {
        f7121a = new b();
    }

    public b() {
    }

    @Override // com.bytedance.compression.zstd.BufferPool
    public ByteBuffer get(int r10) {
        return ByteBuffer.allocate(r10);
    }

    @Override // com.bytedance.compression.zstd.BufferPool
    public void release(ByteBuffer r10) {
    }
}
