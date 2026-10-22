package n;

/* loaded from: classes.dex */
public abstract /* synthetic */ class f {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f6606a = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48};

    public static /* synthetic */ int a(int i2, int i10) {
        if (i2 == 0 || i10 == 0) {
            throw null;
        }
        return i2 - i10;
    }

    public static int b(int i2, int i10, int i11) {
        return (Integer.hashCode(i2) + i10) * i11;
    }

    public static String c(int i2, String str) {
        return str + i2;
    }

    public static /* synthetic */ int d(int i2) {
        if (i2 != 0) {
            return i2 - 1;
        }
        throw null;
    }

    public static /* synthetic */ int[] e(int i2) {
        int[] iArr = new int[i2];
        System.arraycopy(f6606a, 0, iArr, 0, i2);
        return iArr;
    }
}
