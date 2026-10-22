package n4;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final int f10620a;

    /* renamed from: b, reason: collision with root package name */
    public final float f10621b;

    /* renamed from: c, reason: collision with root package name */
    public int f10622c;

    /* renamed from: d, reason: collision with root package name */
    public int f10623d;

    /* renamed from: e, reason: collision with root package name */
    public final float f10624e;

    /* renamed from: f, reason: collision with root package name */
    public final float f10625f;

    /* renamed from: g, reason: collision with root package name */
    public final int f10626g;
    public final float h;

    /* JADX WARN: Removed duplicated region for block: B:43:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00ca  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public a(int r4, float r5, float r6, float r7, int r8, float r9, int r10, float r11, int r12, float r13) {
        /*
            Method dump skipped, instructions count: 214
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: n4.a.<init>(int, float, float, float, int, float, int, float, int, float):void");
    }

    public static a a(float f8, float f9, float f10, float f11, int[] iArr, float f12, int[] iArr2, float f13, int[] iArr3) {
        a aVar = null;
        int i10 = 1;
        for (int i11 : iArr3) {
            int length = iArr2.length;
            int i12 = 0;
            while (i12 < length) {
                int i13 = iArr2[i12];
                int length2 = iArr.length;
                int i14 = 0;
                while (i14 < length2) {
                    int i15 = length;
                    int i16 = i12;
                    int i17 = i10;
                    int i18 = length2;
                    int i19 = i14;
                    a aVar2 = new a(i17, f9, f10, f11, iArr[i14], f12, i13, f13, i11, f8);
                    float f14 = aVar2.h;
                    if (aVar == null || f14 < aVar.h) {
                        if (f14 == 0.0f) {
                            return aVar2;
                        }
                        aVar = aVar2;
                    }
                    int i20 = i17 + 1;
                    i14 = i19 + 1;
                    i12 = i16;
                    i10 = i20;
                    length = i15;
                    length2 = i18;
                }
                i12++;
                i10 = i10;
                length = length;
            }
        }
        return aVar;
    }

    public final String toString() {
        return "Arrangement [priority=" + this.f10620a + ", smallCount=" + this.f10622c + ", smallSize=" + this.f10621b + ", mediumCount=" + this.f10623d + ", mediumSize=" + this.f10624e + ", largeCount=" + this.f10626g + ", largeSize=" + this.f10625f + ", cost=" + this.h + "]";
    }
}
