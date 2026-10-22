package F3;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    static final D3.b<Object, Object> f1754a = new a();

    static final class a implements D3.b<Object, Object> {
        a() {
        }
    }

    public static int a(int i5, int i6) {
        if (i5 < i6) {
            return -1;
        }
        return i5 > i6 ? 1 : 0;
    }

    public static int b(long j5, long j6) {
        if (j5 < j6) {
            return -1;
        }
        return j5 > j6 ? 1 : 0;
    }

    public static boolean c(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    public static <T> T d(T t5, String str) {
        if (t5 != null) {
            return t5;
        }
        throw new NullPointerException(str);
    }

    public static int e(int i5, String str) {
        if (i5 > 0) {
            return i5;
        }
        throw new IllegalArgumentException(str + " > 0 required but it was " + i5);
    }
}
