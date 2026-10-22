package y2;

/* loaded from: classes2.dex */
public final class I {

    /* renamed from: a, reason: collision with root package name */
    public static H f43816a;

    public static synchronized C5918A a(w wVar) {
        try {
            if (f43816a == null) {
                f43816a = new H(null);
            }
        } catch (Throwable th) {
            throw th;
        }
        return (C5918A) f43816a.b(wVar);
    }

    public static synchronized C5918A b(String str) {
        return a(w.d("common").c());
    }
}
