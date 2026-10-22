package androidx.room;

/* loaded from: classes.dex */
public final class p {

    /* renamed from: a, reason: collision with root package name */
    public final long[] f4225a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean[] f4226b;

    /* renamed from: c, reason: collision with root package name */
    public final int[] f4227c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f4228d;

    public p(int i4) {
        this.f4225a = new long[i4];
        this.f4226b = new boolean[i4];
        this.f4227c = new int[i4];
    }

    public final int[] a() {
        synchronized (this) {
            try {
                if (!this.f4228d) {
                    return null;
                }
                long[] jArr = this.f4225a;
                int length = jArr.length;
                int i4 = 0;
                int i5 = 0;
                while (i4 < length) {
                    int i6 = i5 + 1;
                    int i7 = 1;
                    boolean z4 = jArr[i4] > 0;
                    boolean[] zArr = this.f4226b;
                    if (z4 != zArr[i5]) {
                        int[] iArr = this.f4227c;
                        if (!z4) {
                            i7 = 2;
                        }
                        iArr[i5] = i7;
                    } else {
                        this.f4227c[i5] = 0;
                    }
                    zArr[i5] = z4;
                    i4++;
                    i5 = i6;
                }
                this.f4228d = false;
                return (int[]) this.f4227c.clone();
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
