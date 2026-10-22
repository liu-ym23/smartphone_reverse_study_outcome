package s;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract /* synthetic */ class f {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f10999a = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48};

    public static /* synthetic */ boolean a(int i, int i3) {
        if (i != 0) {
            return i == i3;
        }
        throw null;
    }

    public static int b(int i, int i3, int i10) {
        return (Integer.hashCode(i) + i3) * i10;
    }

    public static /* synthetic */ int c(int i) {
        if (i != 0) {
            return i - 1;
        }
        throw null;
    }

    public static /* synthetic */ int[] d(int i) {
        int[] iArr = new int[i];
        System.arraycopy(f10999a, 0, iArr, 0, i);
        return iArr;
    }
}
