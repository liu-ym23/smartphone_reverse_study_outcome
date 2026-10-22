package q0;

/* renamed from: q0.k, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0964k implements c0 {

    /* renamed from: a, reason: collision with root package name */
    private static final ThreadLocal<C0946I> f19857a = new ThreadLocal<>();

    /* renamed from: b, reason: collision with root package name */
    private static final ThreadLocal<Character> f19858b = new ThreadLocal<>();

    /* renamed from: c, reason: collision with root package name */
    private static final Character f19859c = ',';

    final char f(C0946I c0946i, Object obj, char c6) {
        ThreadLocal<C0946I> threadLocal = f19857a;
        C0946I c0946i2 = threadLocal.get();
        threadLocal.set(c0946i);
        ThreadLocal<Character> threadLocal2 = f19858b;
        threadLocal2.set(Character.valueOf(c6));
        g(obj);
        threadLocal.set(c0946i2);
        return threadLocal2.get().charValue();
    }

    public abstract void g(Object obj);
}
