package x5;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public abstract class e {

    /* renamed from: a, reason: collision with root package name */
    public static final int[] f6287a;

    /* renamed from: b, reason: collision with root package name */
    public static final long[] f6288b;

    static {
        int[] iArr = new int[256];
        int i8 = 0;
        for (int i9 = 0; i9 < 256; i9++) {
            iArr[i9] = "0123456789abcdef".charAt(i9 & 15) | ("0123456789abcdef".charAt(i9 >> 4) << '\b');
        }
        f6287a = iArr;
        int[] iArr2 = new int[256];
        for (int i10 = 0; i10 < 256; i10++) {
            iArr2[i10] = "0123456789ABCDEF".charAt(i10 & 15) | ("0123456789ABCDEF".charAt(i10 >> 4) << '\b');
        }
        int[] iArr3 = new int[256];
        for (int i11 = 0; i11 < 256; i11++) {
            iArr3[i11] = -1;
        }
        int i12 = 0;
        int i13 = 0;
        while (i12 < "0123456789abcdef".length()) {
            iArr3["0123456789abcdef".charAt(i12)] = i13;
            i12++;
            i13++;
        }
        int i14 = 0;
        int i15 = 0;
        while (i14 < "0123456789ABCDEF".length()) {
            iArr3["0123456789ABCDEF".charAt(i14)] = i15;
            i14++;
            i15++;
        }
        long[] jArr = new long[256];
        for (int i16 = 0; i16 < 256; i16++) {
            jArr[i16] = -1;
        }
        int i17 = 0;
        int i18 = 0;
        while (i17 < "0123456789abcdef".length()) {
            jArr["0123456789abcdef".charAt(i17)] = i18;
            i17++;
            i18++;
        }
        int i19 = 0;
        while (i8 < "0123456789ABCDEF".length()) {
            jArr["0123456789ABCDEF".charAt(i8)] = i19;
            i8++;
            i19++;
        }
        f6288b = jArr;
    }
}
