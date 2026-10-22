package com.bytedance.compression.zstd;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public class NoPool implements BufferPool {
    public static final BufferPool INSTANCE = null;

    @Override // com.bytedance.compression.zstd.BufferPool
    public void release(ByteBuffer r1) {
    }

    static {
        INSTANCE = new NoPool();
    }

    private NoPool() {
    }

    @Override // com.bytedance.compression.zstd.BufferPool
    public ByteBuffer get(int r1) {
        return ByteBuffer.allocate(r1);
    }
}
