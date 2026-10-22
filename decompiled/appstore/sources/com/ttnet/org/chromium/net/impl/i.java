package com.ttnet.org.chromium.net.impl;

import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.channels.ReadableByteChannel;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes4.dex */
public final class i implements ReadableByteChannel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InputStream f18805a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicBoolean f18806b;

    public i(InputStream r10) {
        this.f18806b = new AtomicBoolean(true);
        this.f18805a = r10;
    }

    public static ReadableByteChannel a(InputStream r10) {
        if ((r10 instanceof FileInputStream) == false) goto L7;
        return ((FileInputStream) r10).getChannel();
    L7:
        return new i(r10);
    }

    @Override // java.nio.channels.Channel, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.f18806b.compareAndSet(true, false) == false) goto L6;
        this.f18805a.close();
        return;
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return this.f18806b.get();
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer r10) {
        if (r10.hasArray() == false) goto L7;
        int r11 = this.f18805a.read(r10.array(), r10.arrayOffset() + r10.position(), r10.remaining());
        if (r11 <= 0) goto L10;
        r10.position(r10.position() + r11);
    L10:
        return r11;
    L7:
        byte[] r12 = new byte[Math.min(16384, Math.min(Math.max(this.f18805a.available(), 4096), r10.remaining()))];
        r11 = this.f18805a.read(r12);
        if (r11 <= 0) goto L10;
        r10.put(r12, 0, r11);
        goto L10
    }
}
