package com.ttnet.org.chromium.net;

import java.io.Closeable;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes4.dex */
public abstract class y implements Closeable {
    public y() {
    }

    public abstract long a();

    public abstract void b(z r10, ByteBuffer r11);

    public abstract void c(z r10);

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }
}
