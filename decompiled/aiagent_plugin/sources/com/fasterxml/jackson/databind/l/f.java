package com.fasterxml.jackson.databind.l;

import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: ByteBufferBackedInputStream.java */
/* JADX INFO: loaded from: classes2.dex */
public class f extends InputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final ByteBuffer f13015a;

    public f(ByteBuffer r1) {
        this.f13015a = r1;
    }

    @Override // java.io.InputStream
    public int available() {
        return this.f13015a.remaining();
    }

    @Override // java.io.InputStream
    public int read() {
        if (this.f13015a.hasRemaining() == true) goto L7;
        return -1;
    L7:
        return this.f13015a.get() & 255;
    }

    @Override // java.io.InputStream
    public int read(byte[] r2, int r3, int r4) {
        if (this.f13015a.hasRemaining() == true) goto L6;
        return -1;
    L6:
        int r5 = Math.min(r4, this.f13015a.remaining());
        this.f13015a.get(r2, r3, r5);
        return r5;
    }
}
