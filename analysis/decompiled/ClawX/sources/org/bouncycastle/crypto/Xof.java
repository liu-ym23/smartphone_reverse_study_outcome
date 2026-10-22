package org.bouncycastle.crypto;

/* loaded from: classes.dex */
public interface Xof extends ExtendedDigest {
    int doFinal(byte[] bArr, int i8, int i9);

    int doOutput(byte[] bArr, int i8, int i9);
}
