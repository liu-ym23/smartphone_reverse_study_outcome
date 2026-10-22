package com.google.crypto.tink.aead.internal;

import b8.z;
import com.google.crypto.tink.subtle.Bytes;
import g5.f;
import java.util.Arrays;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public class Poly1305 {
    public static final int MAC_KEY_SIZE_IN_BYTES = 32;
    public static final int MAC_TAG_SIZE_IN_BYTES = 16;

    private Poly1305() {
    }

    public static byte[] computeMac(byte[] bArr, byte[] bArr2) {
        if (bArr.length != 32) {
            f.s("The key length in bytes must be 32.");
            return null;
        }
        long jLoad26 = load26(bArr, 0, 0) & 67108863;
        int i = 3;
        int i3 = 2;
        long jLoad262 = load26(bArr, 3, 2) & 67108611;
        long jLoad263 = load26(bArr, 6, 4) & 67092735;
        long jLoad264 = load26(bArr, 9, 6) & 66076671;
        long jLoad265 = load26(bArr, 12, 8) & 1048575;
        long j10 = jLoad262 * 5;
        long j11 = jLoad263 * 5;
        long j12 = jLoad264 * 5;
        long j13 = jLoad265 * 5;
        byte[] bArr3 = new byte[17];
        long j14 = 0;
        int i10 = 0;
        long j15 = 0;
        long j16 = 0;
        long j17 = 0;
        long j18 = 0;
        while (i10 < bArr2.length) {
            copyBlockSize(bArr3, bArr2, i10);
            long jLoad266 = j18 + load26(bArr3, 0, 0);
            long jLoad267 = j14 + load26(bArr3, i, i3);
            long jLoad268 = j15 + load26(bArr3, 6, 4);
            long jLoad269 = j16 + load26(bArr3, 9, 6);
            long j19 = jLoad262;
            long jLoad2610 = j17 + (load26(bArr3, 12, 8) | (bArr3[16] << 24));
            long j20 = (jLoad2610 * j10) + (jLoad269 * j11) + (jLoad268 * j12) + (jLoad267 * j13) + (jLoad266 * jLoad26);
            long j21 = (jLoad2610 * j11) + (jLoad269 * j12) + (jLoad268 * j13) + (jLoad267 * jLoad26) + (jLoad266 * j19);
            long j22 = (jLoad2610 * j12) + (jLoad269 * j13) + (jLoad268 * jLoad26) + (jLoad267 * j19) + (jLoad266 * jLoad263);
            long j23 = (jLoad2610 * j13) + (jLoad269 * jLoad26) + (jLoad268 * j19) + (jLoad267 * jLoad263) + (jLoad266 * jLoad264);
            long j24 = jLoad269 * j19;
            long j25 = jLoad2610 * jLoad26;
            long j26 = j25 + j24 + (jLoad268 * jLoad263) + (jLoad267 * jLoad264) + (jLoad266 * jLoad265);
            long j27 = j21 + (j20 >> 26);
            long j28 = j22 + (j27 >> 26);
            j15 = j28 & 67108863;
            long j29 = j23 + (j28 >> 26);
            j16 = j29 & 67108863;
            long j30 = j26 + (j29 >> 26);
            long j31 = j30 >> 26;
            j17 = j30 & 67108863;
            long j32 = (j31 * 5) + (j20 & 67108863);
            j18 = j32 & 67108863;
            j14 = (j27 & 67108863) + (j32 >> 26);
            i10 += 16;
            jLoad262 = j19;
            i = 3;
            i3 = 2;
        }
        long j33 = j15 + (j14 >> 26);
        long j34 = j33 & 67108863;
        long j35 = j16 + (j33 >> 26);
        long j36 = j35 & 67108863;
        long j37 = j17 + (j35 >> 26);
        long j38 = j37 & 67108863;
        long j39 = ((j37 >> 26) * 5) + j18;
        long j40 = j39 >> 26;
        long j41 = j39 & 67108863;
        long j42 = (j14 & 67108863) + j40;
        long j43 = j41 + 5;
        long j44 = j43 & 67108863;
        long j45 = j42 + (j43 >> 26);
        long j46 = j34 + (j45 >> 26);
        long j47 = j36 + (j46 >> 26);
        long j48 = j47 & 67108863;
        long j49 = (j38 + (j47 >> 26)) - 67108864;
        long j50 = j49 >> 63;
        long j51 = j41 & j50;
        long j52 = j42 & j50;
        long j53 = j34 & j50;
        long j54 = j36 & j50;
        long j55 = j38 & j50;
        long j56 = ~j50;
        long j57 = j52 | (j45 & 67108863 & j56);
        long j58 = j53 | (j46 & 67108863 & j56);
        long j59 = j54 | (j48 & j56);
        long j60 = (j51 | (j44 & j56) | (j57 << 26)) & 4294967295L;
        long j61 = ((j57 >> 6) | (j58 << 20)) & 4294967295L;
        long j62 = ((j58 >> 12) | (j59 << 14)) & 4294967295L;
        long j63 = ((j59 >> 18) | ((j55 | (j49 & j56)) << 8)) & 4294967295L;
        long jLoad32 = j60 + load32(bArr, 16);
        long j64 = jLoad32 & 4294967295L;
        long jLoad322 = j61 + load32(bArr, 20) + (jLoad32 >> 32);
        long j65 = jLoad322 & 4294967295L;
        long jLoad323 = j62 + load32(bArr, 24) + (jLoad322 >> 32);
        long j66 = jLoad323 & 4294967295L;
        long jLoad324 = (j63 + load32(bArr, 28) + (jLoad323 >> 32)) & 4294967295L;
        byte[] bArr4 = new byte[16];
        toByteArray(bArr4, j64, 0);
        toByteArray(bArr4, j65, 4);
        toByteArray(bArr4, j66, 8);
        toByteArray(bArr4, jLoad324, 12);
        return bArr4;
    }

    private static void copyBlockSize(byte[] bArr, byte[] bArr2, int i) {
        int iMin = Math.min(16, bArr2.length - i);
        System.arraycopy(bArr2, i, bArr, 0, iMin);
        bArr[iMin] = 1;
        if (iMin != 16) {
            Arrays.fill(bArr, iMin + 1, bArr.length, (byte) 0);
        }
    }

    private static long load26(byte[] bArr, int i, int i3) {
        return (load32(bArr, i) >> i3) & 67108863;
    }

    private static long load32(byte[] bArr, int i) {
        return (((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16)) & 4294967295L;
    }

    private static void toByteArray(byte[] bArr, long j10, int i) {
        int i3 = 0;
        while (i3 < 4) {
            bArr[i + i3] = (byte) (255 & j10);
            i3++;
            j10 >>= 8;
        }
    }

    public static void verifyMac(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        if (Bytes.equal(computeMac(bArr, bArr2), bArr3)) {
            return;
        }
        z.l("invalid MAC");
    }
}
