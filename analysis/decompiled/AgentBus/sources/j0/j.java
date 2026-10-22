package j0;

/* loaded from: classes.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name */
    public final int f5086a;

    /* renamed from: b, reason: collision with root package name */
    public final long[] f5087b;

    /* renamed from: c, reason: collision with root package name */
    public final Object[] f5088c;

    public j(int i2, long[] jArr, Object[] objArr) {
        this.f5086a = i2;
        this.f5087b = jArr;
        this.f5088c = objArr;
    }

    public final int a(long j2) {
        int i2 = this.f5086a - 1;
        if (i2 != -1) {
            long[] jArr = this.f5087b;
            int i10 = 0;
            if (i2 != 0) {
                while (i10 <= i2) {
                    int i11 = (i10 + i2) >>> 1;
                    long j4 = jArr[i11] - j2;
                    if (j4 < 0) {
                        i10 = i11 + 1;
                    } else {
                        if (j4 <= 0) {
                            return i11;
                        }
                        i2 = i11 - 1;
                    }
                }
                return -(i10 + 1);
            }
            long j10 = jArr[0];
            if (j10 == j2) {
                return 0;
            }
            if (j10 > j2) {
                return -2;
            }
        }
        return -1;
    }

    public final j b(long j2, Object obj) {
        long[] jArr;
        int i2;
        Object[] objArr = this.f5088c;
        int i10 = 0;
        int i11 = 0;
        for (Object obj2 : objArr) {
            if (obj2 != null) {
                i11++;
            }
        }
        int i12 = i11 + 1;
        long[] jArr2 = new long[i12];
        Object[] objArr2 = new Object[i12];
        if (i12 > 1) {
            int i13 = 0;
            while (true) {
                jArr = this.f5087b;
                i2 = this.f5086a;
                if (i10 >= i12 || i13 >= i2) {
                    break;
                }
                long j4 = jArr[i13];
                Object obj3 = objArr[i13];
                if (j4 > j2) {
                    jArr2[i10] = j2;
                    objArr2[i10] = obj;
                    i10++;
                    break;
                }
                if (obj3 != null) {
                    jArr2[i10] = j4;
                    objArr2[i10] = obj3;
                    i10++;
                }
                i13++;
            }
            if (i13 == i2) {
                jArr2[i11] = j2;
                objArr2[i11] = obj;
            } else {
                while (i10 < i12) {
                    long j10 = jArr[i13];
                    Object obj4 = objArr[i13];
                    if (obj4 != null) {
                        jArr2[i10] = j10;
                        objArr2[i10] = obj4;
                        i10++;
                    }
                    i13++;
                }
            }
        } else {
            jArr2[0] = j2;
            objArr2[0] = obj;
        }
        return new j(i12, jArr2, objArr2);
    }
}
