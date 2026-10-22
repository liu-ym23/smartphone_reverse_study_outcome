package com.google.protobuf;

import java.io.IOException;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes3.dex */
public abstract class ByteOutput {
    public ByteOutput() {
    }

    public abstract void write(byte r10) throws IOException;

    public abstract void write(ByteBuffer r10) throws IOException;

    public abstract void write(byte[] r10, int r11, int r12) throws IOException;

    public abstract void writeLazy(ByteBuffer r10) throws IOException;

    public abstract void writeLazy(byte[] r10, int r11, int r12) throws IOException;
}
