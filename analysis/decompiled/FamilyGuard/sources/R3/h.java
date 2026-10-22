package R3;

/* loaded from: classes.dex */
public final class h<T> {

    /* renamed from: a, reason: collision with root package name */
    final float f4988a;

    /* renamed from: b, reason: collision with root package name */
    int f4989b;

    /* renamed from: c, reason: collision with root package name */
    int f4990c;

    /* renamed from: d, reason: collision with root package name */
    int f4991d;

    /* renamed from: e, reason: collision with root package name */
    T[] f4992e;

    public h() {
        this(16, 0.75f);
    }

    static int c(int i5) {
        int i6 = i5 * (-1640531527);
        return i6 ^ (i6 >>> 16);
    }

    public boolean a(T t5) {
        T t6;
        T[] tArr = this.f4992e;
        int i5 = this.f4989b;
        int iC = c(t5.hashCode()) & i5;
        T t7 = tArr[iC];
        if (t7 != null) {
            if (t7.equals(t5)) {
                return false;
            }
            do {
                iC = (iC + 1) & i5;
                t6 = tArr[iC];
                if (t6 == null) {
                }
            } while (!t6.equals(t5));
            return false;
        }
        tArr[iC] = t5;
        int i6 = this.f4990c + 1;
        this.f4990c = i6;
        if (i6 >= this.f4991d) {
            d();
        }
        return true;
    }

    public Object[] b() {
        return this.f4992e;
    }

    void d() {
        T t5;
        T[] tArr = this.f4992e;
        int length = tArr.length;
        int i5 = length << 1;
        int i6 = i5 - 1;
        T[] tArr2 = (T[]) new Object[i5];
        int i7 = this.f4990c;
        while (true) {
            int i8 = i7 - 1;
            if (i7 == 0) {
                this.f4989b = i6;
                this.f4991d = (int) (i5 * this.f4988a);
                this.f4992e = tArr2;
                return;
            }
            do {
                length--;
                t5 = tArr[length];
            } while (t5 == null);
            int iC = c(t5.hashCode()) & i6;
            if (tArr2[iC] != null) {
                do {
                    iC = (iC + 1) & i6;
                } while (tArr2[iC] != null);
            }
            tArr2[iC] = tArr[length];
            i7 = i8;
        }
    }

    public boolean e(T t5) {
        T t6;
        T[] tArr = this.f4992e;
        int i5 = this.f4989b;
        int iC = c(t5.hashCode()) & i5;
        T t7 = tArr[iC];
        if (t7 == null) {
            return false;
        }
        if (t7.equals(t5)) {
            return f(iC, tArr, i5);
        }
        do {
            iC = (iC + 1) & i5;
            t6 = tArr[iC];
            if (t6 == null) {
                return false;
            }
        } while (!t6.equals(t5));
        return f(iC, tArr, i5);
    }

    boolean f(int i5, T[] tArr, int i6) {
        int i7;
        T t5;
        this.f4990c--;
        while (true) {
            int i8 = i5 + 1;
            while (true) {
                i7 = i8 & i6;
                t5 = tArr[i7];
                if (t5 == null) {
                    tArr[i5] = null;
                    return true;
                }
                int iC = c(t5.hashCode()) & i6;
                if (i5 <= i7) {
                    if (i5 >= iC || iC > i7) {
                        break;
                    }
                    i8 = i7 + 1;
                } else if (i5 < iC || iC <= i7) {
                    i8 = i7 + 1;
                }
            }
            tArr[i5] = t5;
            i5 = i7;
        }
    }

    public h(int i5, float f5) {
        this.f4988a = f5;
        int iA = i.a(i5);
        this.f4989b = iA - 1;
        this.f4991d = (int) (f5 * iA);
        this.f4992e = (T[]) new Object[iA];
    }
}
