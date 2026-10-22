package org.bouncycastle.crypto.prng.drbg;

import java.util.Hashtable;
import org.bouncycastle.asn1.BERTags;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.Mac;
import org.bouncycastle.util.Integers;

/* loaded from: classes.dex */
class Utils {
    static final Hashtable maxSecurityStrengths;

    static {
        Hashtable hashtable = new Hashtable();
        maxSecurityStrengths = hashtable;
        hashtable.put("SHA-1", Integers.valueOf(128));
        hashtable.put("SHA-224", Integers.valueOf(BERTags.PRIVATE));
        hashtable.put("SHA-256", Integers.valueOf(256));
        hashtable.put("SHA-384", Integers.valueOf(256));
        hashtable.put("SHA-512", Integers.valueOf(256));
        hashtable.put("SHA-512/224", Integers.valueOf(BERTags.PRIVATE));
        hashtable.put("SHA-512/256", Integers.valueOf(256));
    }

    public static int getMaxSecurityStrength(Digest digest) {
        return ((Integer) maxSecurityStrengths.get(digest.getAlgorithmName())).intValue();
    }

    public static byte[] hash_df(Digest digest, byte[] bArr, int i8) {
        int i9 = (i8 + 7) / 8;
        byte[] bArr2 = new byte[i9];
        int digestSize = i9 / digest.getDigestSize();
        int digestSize2 = digest.getDigestSize();
        byte[] bArr3 = new byte[digestSize2];
        int i10 = 1;
        int i11 = 0;
        for (int i12 = 0; i12 <= digestSize; i12++) {
            digest.update((byte) i10);
            digest.update((byte) (i8 >> 24));
            digest.update((byte) (i8 >> 16));
            digest.update((byte) (i8 >> 8));
            digest.update((byte) i8);
            digest.update(bArr, 0, bArr.length);
            digest.doFinal(bArr3, 0);
            int i13 = i12 * digestSize2;
            int i14 = i9 - i13;
            if (i14 > digestSize2) {
                i14 = digestSize2;
            }
            System.arraycopy(bArr3, 0, bArr2, i13, i14);
            i10++;
        }
        int i15 = i8 % 8;
        if (i15 != 0) {
            int i16 = 8 - i15;
            int i17 = 0;
            while (i11 != i9) {
                int i18 = bArr2[i11] & 255;
                bArr2[i11] = (byte) ((i17 << (8 - i16)) | (i18 >>> i16));
                i11++;
                i17 = i18;
            }
        }
        return bArr2;
    }

    public static boolean isTooLarge(byte[] bArr, int i8) {
        return bArr != null && bArr.length > i8;
    }

    public static int getMaxSecurityStrength(Mac mac) {
        String algorithmName = mac.getAlgorithmName();
        return ((Integer) maxSecurityStrengths.get(algorithmName.substring(0, algorithmName.indexOf("/")))).intValue();
    }
}
