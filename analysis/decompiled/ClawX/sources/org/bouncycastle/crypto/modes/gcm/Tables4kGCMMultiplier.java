package org.bouncycastle.crypto.modes.gcm;

import java.lang.reflect.Array;
import org.bouncycastle.util.Pack;

/* loaded from: classes.dex */
public class Tables4kGCMMultiplier implements GCMMultiplier {
    private byte[] H;
    private long[][] T;

    @Override // org.bouncycastle.crypto.modes.gcm.GCMMultiplier
    public void init(byte[] bArr) {
        if (this.T == null) {
            this.T = (long[][]) Array.newInstance((Class<?>) Long.TYPE, 256, 2);
        } else if (GCMUtil.areEqual(this.H, bArr) != 0) {
            return;
        }
        byte[] bArr2 = new byte[16];
        this.H = bArr2;
        GCMUtil.copy(bArr, bArr2);
        GCMUtil.asLongs(this.H, this.T[1]);
        long[] jArr = this.T[1];
        GCMUtil.multiplyP7(jArr, jArr);
        for (int i8 = 2; i8 < 256; i8 += 2) {
            long[][] jArr2 = this.T;
            GCMUtil.divideP(jArr2[i8 >> 1], jArr2[i8]);
            long[][] jArr3 = this.T;
            GCMUtil.xor(jArr3[i8], jArr3[1], jArr3[i8 + 1]);
        }
    }

    @Override // org.bouncycastle.crypto.modes.gcm.GCMMultiplier
    public void multiplyH(byte[] bArr) {
        long[] jArr = this.T[bArr[15] & 255];
        long j4 = jArr[0];
        long j8 = jArr[1];
        for (int i8 = 14; i8 >= 0; i8--) {
            long[] jArr2 = this.T[bArr[i8] & 255];
            long j9 = j8 << 56;
            j8 = ((j8 >>> 8) | (j4 << 56)) ^ jArr2[1];
            j4 = (((((j4 >>> 8) ^ jArr2[0]) ^ j9) ^ (j9 >>> 1)) ^ (j9 >>> 2)) ^ (j9 >>> 7);
        }
        Pack.longToBigEndian(j4, bArr, 0);
        Pack.longToBigEndian(j8, bArr, 8);
    }
}
