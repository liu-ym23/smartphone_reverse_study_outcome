package org.bouncycastle.crypto.modes.gcm;

/* loaded from: classes.dex */
public class BasicGCMExponentiator implements GCMExponentiator {

    /* renamed from: x, reason: collision with root package name */
    private long[] f4531x;

    @Override // org.bouncycastle.crypto.modes.gcm.GCMExponentiator
    public void exponentiateX(long j4, byte[] bArr) {
        long[] jArrOneAsLongs = GCMUtil.oneAsLongs();
        if (j4 > 0) {
            long[] jArr = new long[2];
            GCMUtil.copy(this.f4531x, jArr);
            do {
                if ((1 & j4) != 0) {
                    GCMUtil.multiply(jArrOneAsLongs, jArr);
                }
                GCMUtil.square(jArr, jArr);
                j4 >>>= 1;
            } while (j4 > 0);
        }
        GCMUtil.asBytes(jArrOneAsLongs, bArr);
    }

    @Override // org.bouncycastle.crypto.modes.gcm.GCMExponentiator
    public void init(byte[] bArr) {
        this.f4531x = GCMUtil.asLongs(bArr);
    }
}
