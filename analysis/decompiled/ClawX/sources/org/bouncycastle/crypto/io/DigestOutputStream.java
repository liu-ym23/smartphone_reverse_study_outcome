package org.bouncycastle.crypto.io;

import java.io.OutputStream;
import org.bouncycastle.crypto.Digest;

/* loaded from: classes.dex */
public class DigestOutputStream extends OutputStream {
    protected Digest digest;

    public DigestOutputStream(Digest digest) {
        this.digest = digest;
    }

    public byte[] getDigest() {
        byte[] bArr = new byte[this.digest.getDigestSize()];
        this.digest.doFinal(bArr, 0);
        return bArr;
    }

    @Override // java.io.OutputStream
    public void write(int i8) {
        this.digest.update((byte) i8);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i8, int i9) {
        this.digest.update(bArr, i8, i9);
    }
}
