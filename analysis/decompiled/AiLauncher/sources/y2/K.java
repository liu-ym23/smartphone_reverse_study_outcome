package y2;

/* loaded from: classes2.dex */
public final class K {

    /* renamed from: a, reason: collision with root package name */
    public static K f43818a;

    public static synchronized K a() {
        try {
            if (f43818a == null) {
                f43818a = new K();
            }
        } catch (Throwable th) {
            throw th;
        }
        return f43818a;
    }

    public static void b() {
        J.a();
    }
}
