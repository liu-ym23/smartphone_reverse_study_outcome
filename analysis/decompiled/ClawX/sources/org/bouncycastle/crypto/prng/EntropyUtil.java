package org.bouncycastle.crypto.prng;

/* loaded from: classes.dex */
public class EntropyUtil {
    public static byte[] generateSeed(EntropySource entropySource, int i8) {
        byte[] bArr = new byte[i8];
        if (i8 * 8 <= entropySource.entropySize()) {
            System.arraycopy(entropySource.getEntropy(), 0, bArr, 0, i8);
            return bArr;
        }
        int iEntropySize = entropySource.entropySize() / 8;
        for (int i9 = 0; i9 < i8; i9 += iEntropySize) {
            byte[] entropy = entropySource.getEntropy();
            int i10 = i8 - i9;
            if (entropy.length <= i10) {
                System.arraycopy(entropy, 0, bArr, i9, entropy.length);
            } else {
                System.arraycopy(entropy, 0, bArr, i9, i10);
            }
        }
        return bArr;
    }
}
