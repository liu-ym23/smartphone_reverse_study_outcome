package u0;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    public int f13657a;

    /* renamed from: b, reason: collision with root package name */
    public int f13658b;

    /* renamed from: c, reason: collision with root package name */
    public Object f13659c;

    /* renamed from: d, reason: collision with root package name */
    public Object f13660d;

    /* renamed from: e, reason: collision with root package name */
    public Object f13661e;

    public int a(long j10) {
        int i = this.f13657a + 1;
        long[] jArr = (long[]) this.f13659c;
        int length = jArr.length;
        if (i > length) {
            int i3 = length * 2;
            long[] jArr2 = new long[i3];
            int[] iArr = new int[i3];
            kb.k.h0(jArr, jArr2, 0, 0, jArr.length);
            kb.k.j0(0, 0, (int[]) this.f13660d, iArr, 14);
            this.f13659c = jArr2;
            this.f13660d = iArr;
        }
        int i10 = this.f13657a;
        this.f13657a = i10 + 1;
        int length2 = ((int[]) this.f13661e).length;
        if (this.f13658b >= length2) {
            int i11 = length2 * 2;
            int[] iArr2 = new int[i11];
            int i12 = 0;
            while (i12 < i11) {
                int i13 = i12 + 1;
                iArr2[i12] = i13;
                i12 = i13;
            }
            kb.k.j0(0, 0, (int[]) this.f13661e, iArr2, 14);
            this.f13661e = iArr2;
        }
        int i14 = this.f13658b;
        int[] iArr3 = (int[]) this.f13661e;
        this.f13658b = iArr3[i14];
        long[] jArr3 = (long[]) this.f13659c;
        jArr3[i10] = j10;
        ((int[]) this.f13660d)[i10] = i14;
        iArr3[i14] = i10;
        while (i10 > 0) {
            int i15 = ((i10 + 1) >> 1) - 1;
            if (yb.k.c(jArr3[i15], j10) <= 0) {
                break;
            }
            b(i15, i10);
            i10 = i15;
        }
        return i14;
    }

    public void b(int i, int i3) {
        long[] jArr = (long[]) this.f13659c;
        int[] iArr = (int[]) this.f13660d;
        int[] iArr2 = (int[]) this.f13661e;
        long j10 = jArr[i];
        jArr[i] = jArr[i3];
        jArr[i3] = j10;
        int i10 = iArr[i];
        int i11 = iArr[i3];
        iArr[i] = i11;
        iArr[i3] = i10;
        iArr2[i11] = i;
        iArr2[i10] = i3;
    }
}
