package org.bouncycastle.crypto.prng;

/* loaded from: classes.dex */
public interface RandomGenerator {
    void addSeedMaterial(long j4);

    void addSeedMaterial(byte[] bArr);

    void nextBytes(byte[] bArr);

    void nextBytes(byte[] bArr, int i8, int i9);
}
