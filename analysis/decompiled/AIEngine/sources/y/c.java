package y;

import androidx.datastore.preferences.protobuf.b1;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public int f13927a;

    /* renamed from: b, reason: collision with root package name */
    public long[] f13928b;

    /* renamed from: c, reason: collision with root package name */
    public int[] f13929c;

    /* renamed from: d, reason: collision with root package name */
    public int[] f13930d;

    /* renamed from: e, reason: collision with root package name */
    public int f13931e;

    public final int a(long j10) {
        int i10 = this.f13927a + 1;
        long[] jArr = this.f13928b;
        int length = jArr.length;
        if (i10 > length) {
            int i11 = length * 2;
            long[] jArr2 = new long[i11];
            int[] iArr = new int[i11];
            b1.p(jArr, jArr2, 0, 0, jArr.length);
            b1.r(0, 0, this.f13929c, iArr, 14);
            this.f13928b = jArr2;
            this.f13929c = iArr;
        }
        int i12 = this.f13927a;
        this.f13927a = i12 + 1;
        int length2 = this.f13930d.length;
        if (this.f13931e >= length2) {
            int i13 = length2 * 2;
            int[] iArr2 = new int[i13];
            int i14 = 0;
            while (i14 < i13) {
                int i15 = i14 + 1;
                iArr2[i14] = i15;
                i14 = i15;
            }
            b1.r(0, 0, this.f13930d, iArr2, 14);
            this.f13930d = iArr2;
        }
        int i16 = this.f13931e;
        int[] iArr3 = this.f13930d;
        this.f13931e = iArr3[i16];
        long[] jArr3 = this.f13928b;
        jArr3[i12] = j10;
        this.f13929c[i12] = i16;
        iArr3[i16] = i12;
        while (i12 > 0) {
            int i17 = ((i12 + 1) >> 1) - 1;
            if (kotlin.jvm.internal.g.h(jArr3[i17], j10) <= 0) {
                break;
            }
            long[] jArr4 = this.f13928b;
            int[] iArr4 = this.f13929c;
            int[] iArr5 = this.f13930d;
            long j11 = jArr4[i17];
            jArr4[i17] = jArr4[i12];
            jArr4[i12] = j11;
            int i18 = iArr4[i17];
            int i19 = iArr4[i12];
            iArr4[i17] = i19;
            iArr4[i12] = i18;
            iArr5[i19] = i17;
            iArr5[i18] = i12;
            i12 = i17;
        }
        return i16;
    }
}
