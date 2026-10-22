package org.bouncycastle.crypto.io;

import java.io.OutputStream;
import org.bouncycastle.crypto.Signer;

/* loaded from: classes.dex */
public class SignerOutputStream extends OutputStream {
    protected Signer signer;

    public SignerOutputStream(Signer signer) {
        this.signer = signer;
    }

    public Signer getSigner() {
        return this.signer;
    }

    @Override // java.io.OutputStream
    public void write(int i8) {
        this.signer.update((byte) i8);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i8, int i9) {
        this.signer.update(bArr, i8, i9);
    }
}
