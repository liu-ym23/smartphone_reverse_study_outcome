package org.bouncycastle.crypto.io;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.bouncycastle.crypto.Digest;

/* loaded from: classes.dex */
public class DigestInputStream extends FilterInputStream {
    protected Digest digest;

    public DigestInputStream(InputStream inputStream, Digest digest) {
        super(inputStream);
        this.digest = digest;
    }

    public Digest getDigest() {
        return this.digest;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        int i8 = ((FilterInputStream) this).in.read();
        if (i8 >= 0) {
            this.digest.update((byte) i8);
        }
        return i8;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i8, int i9) throws IOException {
        int i10 = ((FilterInputStream) this).in.read(bArr, i8, i9);
        if (i10 > 0) {
            this.digest.update(bArr, i8, i10);
        }
        return i10;
    }
}
