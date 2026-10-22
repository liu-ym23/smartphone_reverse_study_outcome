package com.ttnet.org.chromium.net.impl;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.channels.ReadableByteChannel;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: InputStreamChannel.java */
/* JADX INFO: loaded from: classes4.dex */
final class q implements ReadableByteChannel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final InputStream f38161a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final AtomicBoolean f38162b;

    private q(InputStream r3) {
        this.f38162b = new AtomicBoolean(true);
        this.f38161a = r3;
    }

    static ReadableByteChannel a(InputStream r2) {
        if (ZeusTransformUtils.instanceOf(r2, FileInputStream.class) == false) goto L7;
        return ((FileInputStream) ZeusTransformUtils.preCheckCast(r2, FileInputStream.class, "com.obric.aiagent.plugin")).getChannel();
    L7:
        return new q(r2);
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer r4) {
        if (r4.hasArray() == false) goto L7;
        int r3 = this.f38161a.read(r4.array(), r4.arrayOffset() + r4.position(), r4.remaining());
        if (r3 <= 0) goto L10;
        r4.position(r4.position() + r3);
    L10:
        return r3;
    L7:
        byte[] r0 = new byte[Math.min(16384, Math.min(Math.max(this.f38161a.available(), 4096), r4.remaining()))];
        r3 = this.f38161a.read(r0);
        if (r3 <= 0) goto L10;
        r4.put(r0, 0, r3);
        goto L10
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return this.f38162b.get();
    }

    @Override // java.nio.channels.Channel, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.f38162b.compareAndSet(true, false) == false) goto L6;
        this.f38161a.close();
        return;
    }
}
