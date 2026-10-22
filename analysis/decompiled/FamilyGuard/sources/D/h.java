package D;

/* loaded from: classes.dex */
public final class h {
    public static void a(boolean z5) {
        if (!z5) {
            throw new IllegalArgumentException();
        }
    }

    public static void b(boolean z5, Object obj) {
        if (!z5) {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
    }

    public static int c(int i5) {
        if (i5 >= 0) {
            return i5;
        }
        throw new IllegalArgumentException();
    }

    public static int d(int i5, String str) {
        if (i5 >= 0) {
            return i5;
        }
        throw new IllegalArgumentException(str);
    }

    public static <T> T e(T t5) {
        t5.getClass();
        return t5;
    }

    public static <T> T f(T t5, Object obj) {
        if (t5 != null) {
            return t5;
        }
        throw new NullPointerException(String.valueOf(obj));
    }

    public static void g(boolean z5, String str) {
        if (!z5) {
            throw new IllegalStateException(str);
        }
    }
}
