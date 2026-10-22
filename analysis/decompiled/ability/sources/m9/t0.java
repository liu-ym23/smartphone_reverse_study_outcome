package m9;

/* loaded from: classes4.dex */
public abstract class t0 {

    /* renamed from: a, reason: collision with root package name */
    public static final ThreadLocal f5334a = new ThreadLocal();

    public static AbstractC1701T a() {
        ThreadLocal threadLocal = f5334a;
        AbstractC1701T abstractC1701T = (AbstractC1701T) threadLocal.get();
        if (abstractC1701T != null) {
            return abstractC1701T;
        }
        C1714g c1714g = new C1714g(Thread.currentThread());
        threadLocal.set(c1714g);
        return c1714g;
    }
}
