package ia;

/* loaded from: classes.dex */
public abstract class z1 {

    /* renamed from: a, reason: collision with root package name */
    public static final ThreadLocal f5029a = new ThreadLocal();

    public static x0 a() {
        ThreadLocal threadLocal = f5029a;
        x0 x0Var = (x0) threadLocal.get();
        if (x0Var != null) {
            return x0Var;
        }
        g gVar = new g(Thread.currentThread());
        threadLocal.set(gVar);
        return gVar;
    }
}
