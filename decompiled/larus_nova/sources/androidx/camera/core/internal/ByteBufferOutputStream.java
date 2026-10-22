package androidx.camera.core.internal;

import java.io.EOFException;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public final class ByteBufferOutputStream extends OutputStream {
    private final ByteBuffer mByteBuffer;

    public ByteBufferOutputStream(ByteBuffer r100) {
        this.mByteBuffer = r100;
    }

    @Override // java.io.OutputStream
    public void write(int r100) throws IOException {
        if (this.mByteBuffer.hasRemaining() == false) goto L7;
        this.mByteBuffer.put((byte) r100);
        return;
    L7:
        throw new EOFException("Output ByteBuffer has no bytes remaining.");
    }

    @Override // java.io.OutputStream
    public void write(byte[] r100, int r101, int r102) throws IOException {
        if (r100 == null) goto L21;
        if (r101 < 0) goto L19;
        if (r101 > r100.length) goto L19;
        if (r102 < 0) goto L19;
        int r103 = r101 + r102;
        if (r103 > r100.length) goto L19;
        if (r103 < 0) goto L19;
        if (r102 != 0) goto L13;
        return;
    L13:
        if (this.mByteBuffer.remaining() < r102) goto L17;
        this.mByteBuffer.put(r100, r101, r102);
        return;
    L17:
        throw new EOFException("Output ByteBuffer has insufficient bytes remaining.");
    L19:
        throw new IndexOutOfBoundsException();
    L21:
        throw null;
    }
}
