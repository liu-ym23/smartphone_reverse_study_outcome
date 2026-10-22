package A2;

/* loaded from: classes2.dex */
public final class F5 {

    /* renamed from: a, reason: collision with root package name */
    public static F5 f351a;

    public static synchronized F5 a() {
        try {
            if (f351a == null) {
                f351a = new F5();
            }
        } catch (Throwable th) {
            throw th;
        }
        return f351a;
    }

    public static final boolean b() {
        return E5.a("mlkit-dev-profiling");
    }
}
