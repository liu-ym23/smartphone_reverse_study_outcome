package com.fasterxml.jackson.databind.l;

import java.io.OutputStream;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: ByteBufferBackedOutputStream.java */
/* JADX INFO: loaded from: classes2.dex */
public class g extends OutputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final ByteBuffer f13016a;

    public g(ByteBuffer r1) {
        this.f13016a = r1;
    }

    @Override // java.io.OutputStream
    public void write(int r1) {
        this.f13016a.put((byte) r1);
    }

    @Override // java.io.OutputStream
    public void write(byte[] r1, int r2, int r3) {
        this.f13016a.put(r1, r2, r3);
    }
}
