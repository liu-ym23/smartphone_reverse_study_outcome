package s0;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name */
    public final int f11194a;

    /* renamed from: b, reason: collision with root package name */
    public final long[] f11195b;

    /* renamed from: c, reason: collision with root package name */
    public final Object[] f11196c;

    public j(int i, long[] jArr, Object[] objArr) {
        this.f11194a = i;
        this.f11195b = jArr;
        this.f11196c = objArr;
    }

    public final int a(long j10) {
        int i = this.f11194a - 1;
        if (i != -1) {
            long[] jArr = this.f11195b;
            int i3 = 0;
            if (i != 0) {
                while (i3 <= i) {
                    int i10 = (i3 + i) >>> 1;
                    long j11 = jArr[i10] - j10;
                    if (j11 < 0) {
                        i3 = i10 + 1;
                    } else {
                        if (j11 <= 0) {
                            return i10;
                        }
                        i = i10 - 1;
                    }
                }
                return -(i3 + 1);
            }
            long j12 = jArr[0];
            if (j12 == j10) {
                return 0;
            }
            if (j12 > j10) {
                return -2;
            }
        }
        return -1;
    }

    public final j b(Object obj, long j10) {
        long[] jArr;
        int i;
        Object[] objArr = this.f11196c;
        int i3 = 0;
        int i10 = 0;
        for (Object obj2 : objArr) {
            if (obj2 != null) {
                i10++;
            }
        }
        int i11 = i10 + 1;
        long[] jArr2 = new long[i11];
        Object[] objArr2 = new Object[i11];
        if (i11 > 1) {
            int i12 = 0;
            while (true) {
                jArr = this.f11195b;
                i = this.f11194a;
                if (i3 >= i11 || i12 >= i) {
                    break;
                }
                long j11 = jArr[i12];
                Object obj3 = objArr[i12];
                if (j11 > j10) {
                    jArr2[i3] = j10;
                    objArr2[i3] = obj;
                    i3++;
                    break;
                }
                if (obj3 != null) {
                    jArr2[i3] = j11;
                    objArr2[i3] = obj3;
                    i3++;
                }
                i12++;
            }
            if (i12 == i) {
                jArr2[i10] = j10;
                objArr2[i10] = obj;
            } else {
                while (i3 < i11) {
                    long j12 = jArr[i12];
                    Object obj4 = objArr[i12];
                    if (obj4 != null) {
                        jArr2[i3] = j12;
                        objArr2[i3] = obj4;
                        i3++;
                    }
                    i12++;
                }
            }
        } else {
            jArr2[0] = j10;
            objArr2[0] = obj;
        }
        return new j(i11, jArr2, objArr2);
    }
}
