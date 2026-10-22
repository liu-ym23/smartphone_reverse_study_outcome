package org.bouncycastle.crypto.modes.gcm;

import java.lang.reflect.Array;
import org.bouncycastle.util.Pack;

/* loaded from: classes.dex */
public class Tables8kGCMMultiplier implements GCMMultiplier {
    private byte[] H;
    private long[][][] T;

    @Override // org.bouncycastle.crypto.modes.gcm.GCMMultiplier
    public void init(byte[] bArr) {
        if (this.T == null) {
            this.T = (long[][][]) Array.newInstance((Class<?>) Long.TYPE, 2, 256, 2);
        } else if (GCMUtil.areEqual(this.H, bArr) != 0) {
            return;
        }
        byte[] bArr2 = new byte[16];
        this.H = bArr2;
        GCMUtil.copy(bArr, bArr2);
        for (int i8 = 0; i8 < 2; i8++) {
            long[][][] jArr = this.T;
            long[][] jArr2 = jArr[i8];
            if (i8 == 0) {
                GCMUtil.asLongs(this.H, jArr2[1]);
                long[] jArr3 = jArr2[1];
                GCMUtil.multiplyP7(jArr3, jArr3);
            } else {
                GCMUtil.multiplyP8(jArr[i8 - 1][1], jArr2[1]);
            }
            for (int i9 = 2; i9 < 256; i9 += 2) {
                GCMUtil.divideP(jArr2[i9 >> 1], jArr2[i9]);
                GCMUtil.xor(jArr2[i9], jArr2[1], jArr2[i9 + 1]);
            }
        }
    }

    @Override // org.bouncycastle.crypto.modes.gcm.GCMMultiplier
    public void multiplyH(byte[] bArr) {
        long[][][] jArr = this.T;
        long[][] jArr2 = jArr[0];
        long[][] jArr3 = jArr[1];
        long[] jArr4 = jArr2[bArr[14] & 255];
        long[] jArr5 = jArr3[bArr[15] & 255];
        long j4 = jArr4[0] ^ jArr5[0];
        long j8 = jArr5[1] ^ jArr4[1];
        for (int i8 = 12; i8 >= 0; i8 -= 2) {
            long[] jArr6 = jArr2[bArr[i8] & 255];
            long[] jArr7 = jArr3[bArr[i8 + 1] & 255];
            long j9 = j8 << 48;
            j8 = ((j8 >>> 16) | (j4 << 48)) ^ (jArr6[1] ^ jArr7[1]);
            j4 = (((((j4 >>> 16) ^ (jArr7[0] ^ jArr6[0])) ^ j9) ^ (j9 >>> 1)) ^ (j9 >>> 2)) ^ (j9 >>> 7);
        }
        Pack.longToBigEndian(j4, bArr, 0);
        Pack.longToBigEndian(j8, bArr, 8);
    }
}
