package org.bouncycastle.util;

import org.bouncycastle.crypto.digests.SHA512tDigest;
import org.bouncycastle.crypto.digests.SHAKEDigest;

/* loaded from: classes.dex */
public class Fingerprint {
    private static char[] encodingTable = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    private final byte[] fingerprint;

    public Fingerprint(byte[] bArr) {
        this(bArr, 160);
    }

    public static byte[] calculateFingerprint(byte[] bArr) {
        return calculateFingerprint(bArr, 160);
    }

    @Deprecated
    public static byte[] calculateFingerprintSHA512_160(byte[] bArr) {
        SHA512tDigest sHA512tDigest = new SHA512tDigest(160);
        sHA512tDigest.update(bArr, 0, bArr.length);
        byte[] bArr2 = new byte[sHA512tDigest.getDigestSize()];
        sHA512tDigest.doFinal(bArr2, 0);
        return bArr2;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof Fingerprint) {
            return Arrays.areEqual(((Fingerprint) obj).fingerprint, this.fingerprint);
        }
        return false;
    }

    public byte[] getFingerprint() {
        return Arrays.clone(this.fingerprint);
    }

    public int hashCode() {
        return Arrays.hashCode(this.fingerprint);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i8 = 0; i8 != this.fingerprint.length; i8++) {
            if (i8 > 0) {
                sb.append(":");
            }
            sb.append(encodingTable[(this.fingerprint[i8] >>> 4) & 15]);
            sb.append(encodingTable[this.fingerprint[i8] & 15]);
        }
        return sb.toString();
    }

    public Fingerprint(byte[] bArr, int i8) {
        this.fingerprint = calculateFingerprint(bArr, i8);
    }

    public static byte[] calculateFingerprint(byte[] bArr, int i8) {
        if (i8 % 8 != 0) {
            throw new IllegalArgumentException("bitLength must be a multiple of 8");
        }
        SHAKEDigest sHAKEDigest = new SHAKEDigest(256);
        sHAKEDigest.update(bArr, 0, bArr.length);
        int i9 = i8 / 8;
        byte[] bArr2 = new byte[i9];
        sHAKEDigest.doFinal(bArr2, 0, i9);
        return bArr2;
    }

    @Deprecated
    public Fingerprint(byte[] bArr, boolean z) {
        if (z) {
            this.fingerprint = calculateFingerprintSHA512_160(bArr);
        } else {
            this.fingerprint = calculateFingerprint(bArr);
        }
    }
}
