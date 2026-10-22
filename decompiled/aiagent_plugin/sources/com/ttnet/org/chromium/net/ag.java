package com.ttnet.org.chromium.net;

import java.io.Closeable;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: UploadDataProvider.java */
/* JADX INFO: loaded from: classes4.dex */
public abstract class ag implements Closeable {
    public abstract long a();

    public abstract void a(ah r1);

    public abstract void a(ah r1, ByteBuffer r2);

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    public ag() {
    }
}
