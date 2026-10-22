package Y6;

import a7.f;
import java.lang.reflect.Array;
import java.util.zip.Checksum;

/* loaded from: classes3.dex */
public final class a implements Checksum {
    public static final long[][] c = (long[][]) Array.newInstance((Class<?>) Long.TYPE, 8, 256);
    public long b = 0;

    /* renamed from: a, reason: collision with root package name */
    public long f1565a = 0;

    static {
        for (int i = 0; i < 256; i++) {
            long j5 = i;
            for (int i6 = 0; i6 < 8; i6++) {
                j5 = (j5 & 1) == 1 ? (j5 >>> 1) ^ (-3932672073523589310L) : j5 >>> 1;
            }
            c[0][i] = j5;
        }
        for (int i10 = 0; i10 < 256; i10++) {
            long j6 = c[0][i10];
            for (int i11 = 1; i11 < 8; i11++) {
                long[][] jArr = c;
                j6 = (j6 >>> 8) ^ jArr[0][(int) (255 & j6)];
                jArr[i11][i10] = j6;
            }
        }
    }

    @Override // java.util.zip.Checksum
    public final long getValue() {
        return this.f1565a;
    }

    @Override // java.util.zip.Checksum
    public final void reset() {
        long j5 = this.b;
        this.f1565a = j5;
        f.e.j(Long.valueOf(j5), "tos: call checksum reset, value {}");
    }

    @Override // java.util.zip.Checksum
    public final void update(int i) {
        update(new byte[]{(byte) i}, 0, 1);
    }

    @Override // java.util.zip.Checksum
    public final void update(byte[] bArr, int i, int i6) {
        long[][] jArr;
        this.f1565a = ~this.f1565a;
        int i10 = i;
        int i11 = i6;
        while (true) {
            jArr = c;
            if (i11 < 8) {
                break;
            }
            long[] jArr2 = jArr[7];
            long j5 = this.f1565a;
            this.f1565a = ((((((jArr[6][(int) ((bArr[i10 + 1] & 255) ^ ((j5 >>> 8) & 255))] ^ jArr2[(int) ((j5 & 255) ^ (bArr[i10] & 255))]) ^ jArr[5][(int) (((j5 >>> 16) & 255) ^ (bArr[i10 + 2] & 255))]) ^ jArr[4][(int) (((j5 >>> 24) & 255) ^ (bArr[i10 + 3] & 255))]) ^ jArr[3][(int) (((j5 >>> 32) & 255) ^ (bArr[i10 + 4] & 255))]) ^ jArr[2][(int) (((j5 >>> 40) & 255) ^ (bArr[i10 + 5] & 255))]) ^ jArr[1][(int) (((j5 >>> 48) & 255) ^ (bArr[i10 + 6] & 255))]) ^ jArr[0][(int) ((j5 >>> 56) ^ (bArr[i10 + 7] & 255))];
            i10 += 8;
            i11 -= 8;
        }
        while (i11 > 0) {
            long[] jArr3 = jArr[0];
            long j6 = this.f1565a;
            this.f1565a = jArr3[(int) ((bArr[i10] ^ j6) & 255)] ^ (j6 >>> 8);
            i10++;
            i11--;
        }
        this.f1565a = ~this.f1565a;
    }
}
