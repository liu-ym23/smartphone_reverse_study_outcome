package Z2;

/* loaded from: classes2.dex */
public abstract class G0 {

    /* renamed from: a, reason: collision with root package name */
    public static final ThreadLocal f2166a = new ThreadLocal();

    public static V a() {
        ThreadLocal threadLocal = f2166a;
        V v4 = (V) threadLocal.get();
        if (v4 != null) {
            return v4;
        }
        C0120d c0120d = new C0120d(Thread.currentThread());
        threadLocal.set(c0120d);
        return c0120d;
    }
}
