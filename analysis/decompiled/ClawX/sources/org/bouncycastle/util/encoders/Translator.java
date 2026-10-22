package org.bouncycastle.util.encoders;

/* loaded from: classes.dex */
public interface Translator {
    int decode(byte[] bArr, int i8, int i9, byte[] bArr2, int i10);

    int encode(byte[] bArr, int i8, int i9, byte[] bArr2, int i10);

    int getDecodedBlockSize();

    int getEncodedBlockSize();
}
