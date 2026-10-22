package com.bytedance.compression.zstd;

import java.nio.ByteBuffer;

/* JADX INFO: compiled from: NoPool.java */
/* JADX INFO: loaded from: classes.dex */
public class c implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f7096a = null;

    @Override // com.bytedance.compression.zstd.b
    public void a(ByteBuffer r1) {
    }

    static {
        f7096a = new c();
    }

    private c() {
    }

    @Override // com.bytedance.compression.zstd.b
    public ByteBuffer a(int r1) {
        return ByteBuffer.allocate(r1);
    }
}
