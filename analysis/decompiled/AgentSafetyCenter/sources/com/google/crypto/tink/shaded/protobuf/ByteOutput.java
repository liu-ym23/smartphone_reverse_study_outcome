package com.google.crypto.tink.shaded.protobuf;

import java.nio.ByteBuffer;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class ByteOutput {
    public abstract void write(byte b10);

    public abstract void write(ByteBuffer byteBuffer);

    public abstract void write(byte[] bArr, int i, int i3);

    public abstract void writeLazy(ByteBuffer byteBuffer);

    public abstract void writeLazy(byte[] bArr, int i, int i3);
}
