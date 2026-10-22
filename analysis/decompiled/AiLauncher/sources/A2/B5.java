package A2;

/* loaded from: classes2.dex */
public final class B5 {

    /* renamed from: a, reason: collision with root package name */
    public static A5 f298a;

    public static synchronized s5 a(n5 n5Var) {
        try {
            if (f298a == null) {
                f298a = new A5(null);
            }
        } catch (Throwable th) {
            throw th;
        }
        return (s5) f298a.b(n5Var);
    }

    public static synchronized s5 b(String str) {
        return a(n5.d("vision-common").c());
    }
}
