package org.bouncycastle.crypto.hpke;

/* loaded from: classes.dex */
public class HPKEContext {
    protected final AEAD aead;
    protected final byte[] exporterSecret;
    protected final HKDF hkdf;
    protected final byte[] suiteId;

    public HPKEContext(AEAD aead, HKDF hkdf, byte[] bArr, byte[] bArr2) {
        this.aead = aead;
        this.hkdf = hkdf;
        this.exporterSecret = bArr;
        this.suiteId = bArr2;
    }

    public byte[] expand(byte[] bArr, byte[] bArr2, int i8) {
        return this.hkdf.Expand(bArr, bArr2, i8);
    }

    public byte[] export(byte[] bArr, int i8) {
        return this.hkdf.LabeledExpand(this.exporterSecret, this.suiteId, "sec", bArr, i8);
    }

    public byte[] extract(byte[] bArr, byte[] bArr2) {
        return this.hkdf.Extract(bArr, bArr2);
    }

    public byte[] open(byte[] bArr, byte[] bArr2) {
        return this.aead.open(bArr, bArr2);
    }

    public byte[] seal(byte[] bArr, byte[] bArr2) {
        return this.aead.seal(bArr, bArr2);
    }

    public byte[] open(byte[] bArr, byte[] bArr2, int i8, int i9) {
        return this.aead.open(bArr, bArr2, i8, i9);
    }

    public byte[] seal(byte[] bArr, byte[] bArr2, int i8, int i9) {
        return this.aead.seal(bArr, bArr2, i8, i9);
    }
}
