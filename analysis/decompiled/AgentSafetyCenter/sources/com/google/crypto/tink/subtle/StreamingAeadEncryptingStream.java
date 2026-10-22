package com.google.crypto.tink.subtle;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
class StreamingAeadEncryptingStream extends FilterOutputStream {
    ByteBuffer ctBuffer;
    private StreamSegmentEncrypter encrypter;
    boolean open;
    private int plaintextSegmentSize;
    ByteBuffer ptBuffer;

    public StreamingAeadEncryptingStream(NonceBasedStreamingAead nonceBasedStreamingAead, OutputStream outputStream, byte[] bArr) throws IOException {
        super(outputStream);
        this.encrypter = nonceBasedStreamingAead.newStreamSegmentEncrypter(bArr);
        int plaintextSegmentSize = nonceBasedStreamingAead.getPlaintextSegmentSize();
        this.plaintextSegmentSize = plaintextSegmentSize;
        this.ptBuffer = ByteBuffer.allocate(plaintextSegmentSize);
        this.ctBuffer = ByteBuffer.allocate(nonceBasedStreamingAead.getCiphertextSegmentSize());
        this.ptBuffer.limit(this.plaintextSegmentSize - nonceBasedStreamingAead.getCiphertextOffset());
        ByteBuffer header = this.encrypter.getHeader();
        byte[] bArr2 = new byte[header.remaining()];
        header.get(bArr2);
        ((FilterOutputStream) this).out.write(bArr2);
        this.open = true;
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        if (this.open) {
            try {
                this.ptBuffer.flip();
                this.ctBuffer.clear();
                this.encrypter.encryptSegment(this.ptBuffer, true, this.ctBuffer);
                this.ctBuffer.flip();
                ((FilterOutputStream) this).out.write(this.ctBuffer.array(), this.ctBuffer.position(), this.ctBuffer.remaining());
                this.open = false;
                super.close();
            } catch (GeneralSecurityException e10) {
                throw new IOException("ptBuffer.remaining():" + this.ptBuffer.remaining() + " ctBuffer.remaining():" + this.ctBuffer.remaining(), e10);
            }
        }
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public synchronized void write(byte[] bArr, int i, int i3) {
        try {
            if (!this.open) {
                throw new IOException("Trying to write to closed stream");
            }
            while (true) {
                int iRemaining = this.ptBuffer.remaining();
                ByteBuffer byteBuffer = this.ptBuffer;
                if (i3 > iRemaining) {
                    int iRemaining2 = byteBuffer.remaining();
                    ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr, i, iRemaining2);
                    i += iRemaining2;
                    i3 -= iRemaining2;
                    try {
                        this.ptBuffer.flip();
                        this.ctBuffer.clear();
                        this.encrypter.encryptSegment(this.ptBuffer, byteBufferWrap, false, this.ctBuffer);
                        this.ctBuffer.flip();
                        ((FilterOutputStream) this).out.write(this.ctBuffer.array(), this.ctBuffer.position(), this.ctBuffer.remaining());
                        this.ptBuffer.clear();
                        this.ptBuffer.limit(this.plaintextSegmentSize);
                    } catch (GeneralSecurityException e10) {
                        throw new IOException(e10);
                    }
                } else {
                    byteBuffer.put(bArr, i, i3);
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] bArr) {
        write(bArr, 0, bArr.length);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(int i) {
        write(new byte[]{(byte) i});
    }
}
