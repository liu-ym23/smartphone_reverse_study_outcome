package org.bouncycastle.crypto.threshold;

/* loaded from: classes.dex */
public interface SecretSplitter {
    SplitSecret resplit(byte[] bArr, int i8, int i9);

    SplitSecret split(int i8, int i9);

    SplitSecret splitAround(SecretShare secretShare, int i8, int i9);
}
