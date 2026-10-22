package com.stepos.core.ota.crypto;

import ai.onnxruntime.a;
import androidx.datastore.preferences.protobuf.b1;
import com.stepos.core.ota.domain.port.PayloadDecryptException;
import java.io.IOException;
import java.io.InputStream;
import javax.crypto.AEADBadTagException;
import javax.crypto.spec.SecretKeySpec;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class BlockDecryptingInputStream extends InputStream {
    private static final Companion Companion = new Companion(null);
    private static final byte[] EMPTY = new byte[0];
    private byte[] buffer;
    private int bufferPos;
    private boolean closed;
    private boolean finished;
    private final CryptoHeader header;
    private int nextBlock;
    private long produced;
    private final SecretKeySpec secretKey;
    private final InputStream source;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        public final byte[] getEMPTY() {
            return BlockDecryptingInputStream.EMPTY;
        }

        private Companion() {
        }
    }

    public BlockDecryptingInputStream(InputStream source, byte[] key, CryptoHeader header) {
        g.f(source, "source");
        g.f(key, "key");
        g.f(header, "header");
        this.source = source;
        this.header = header;
        this.secretKey = new SecretKeySpec(key, "AES");
        this.buffer = EMPTY;
    }

    private final boolean ensureBuffer() throws IOException {
        if (this.closed) {
            throw new IOException("stream closed");
        }
        if (this.bufferPos < this.buffer.length) {
            return true;
        }
        if (this.finished) {
            return false;
        }
        return fillNextBlock();
    }

    private final boolean fillNextBlock() throws IOException {
        if (this.nextBlock >= this.header.getBlockCount()) {
            this.finished = true;
            if (this.produced == this.header.getPlainLen()) {
                return false;
            }
            long j10 = this.produced;
            long plainLen = this.header.getPlainLen();
            StringBuilder sbQ = a.q(j10, "plaintext length mismatch: produced ", ", header says ");
            sbQ.append(plainLen);
            throw new PayloadDecryptException(sbQ.toString(), null, 2, null);
        }
        int i10 = this.nextBlock;
        int iPlainBytesOf = this.header.plainBytesOf(i10);
        byte[] bArr = new byte[iPlainBytesOf + 16];
        readFully(bArr, i10);
        try {
            byte[] bArrDecrypt = GcmBlocks.INSTANCE.decrypt(this.secretKey, this.header.getIv(), this.header.getFormatVersion(), i10, bArr);
            if (bArrDecrypt.length != iPlainBytesOf) {
                StringBuilder sbD = h0.e.d(i10, "block ", bArrDecrypt.length, " produced ", " bytes, expected ");
                sbD.append(iPlainBytesOf);
                throw new PayloadDecryptException(sbD.toString(), null, 2, null);
            }
            this.buffer = bArrDecrypt;
            this.bufferPos = 0;
            this.produced += bArrDecrypt.length;
            this.nextBlock++;
            return true;
        } catch (AEADBadTagException e10) {
            throw new PayloadDecryptException(a.g(i10, "block ", " authentication failed"), e10);
        }
    }

    private final void readFully(byte[] bArr, int i10) throws IOException {
        int i11 = 0;
        while (i11 < bArr.length) {
            int i12 = this.source.read(bArr, i11, bArr.length - i11);
            if (i12 < 0) {
                throw new PayloadDecryptException(a.j(" bytes", bArr.length, h0.e.d(i10, "ciphertext truncated at block ", i11, ": got ", " of ")), null, 2, null);
            }
            i11 += i12;
        }
    }

    @Override // java.io.InputStream
    public int available() {
        return this.buffer.length - this.bufferPos;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.closed) {
            return;
        }
        this.closed = true;
        this.buffer = EMPTY;
        this.source.close();
    }

    @Override // java.io.InputStream
    public int read() {
        if (!ensureBuffer()) {
            return -1;
        }
        byte[] bArr = this.buffer;
        int i10 = this.bufferPos;
        this.bufferPos = i10 + 1;
        return bArr[i10] & 255;
    }

    @Override // java.io.InputStream
    public int read(byte[] b10, int i10, int i11) {
        g.f(b10, "b");
        if (i10 < 0 || i11 < 0 || i11 > b10.length - i10) {
            throw new IndexOutOfBoundsException();
        }
        if (i11 == 0) {
            return 0;
        }
        if (!ensureBuffer()) {
            return -1;
        }
        int iMin = Math.min(i11, this.buffer.length - this.bufferPos);
        byte[] bArr = this.buffer;
        int i12 = this.bufferPos;
        b1.n(i10, i12, i12 + iMin, bArr, b10);
        this.bufferPos += iMin;
        return iMin;
    }
}
