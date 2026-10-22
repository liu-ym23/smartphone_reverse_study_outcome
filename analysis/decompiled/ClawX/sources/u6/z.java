package u6;

import org.bouncycastle.crypto.digests.Blake2xsDigest;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class z {

    /* renamed from: a, reason: collision with root package name */
    public int f5781a;

    /* renamed from: b, reason: collision with root package name */
    public final int[] f5782b = new int[10];

    public final int a() {
        return (this.f5781a & 16) != 0 ? this.f5782b[4] : Blake2xsDigest.UNKNOWN_DIGEST_LENGTH;
    }

    public final void b(z other) {
        kotlin.jvm.internal.p.e(other, "other");
        for (int i8 = 0; i8 < 10; i8++) {
            if (((1 << i8) & other.f5781a) != 0) {
                c(i8, other.f5782b[i8]);
            }
        }
    }

    public final void c(int i8, int i9) {
        if (i8 >= 0) {
            int[] iArr = this.f5782b;
            if (i8 >= iArr.length) {
                return;
            }
            this.f5781a = (1 << i8) | this.f5781a;
            iArr[i8] = i9;
        }
    }
}
