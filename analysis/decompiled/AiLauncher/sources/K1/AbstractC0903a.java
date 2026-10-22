package K1;

/* renamed from: K1.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0903a implements y {

    /* renamed from: a, reason: collision with root package name */
    public static final ThreadLocal<m> f4025a = new ThreadLocal<>();

    /* renamed from: b, reason: collision with root package name */
    public static final ThreadLocal<Character> f4026b = new ThreadLocal<>();

    /* renamed from: c, reason: collision with root package name */
    public static final Character f4027c = ',';

    public final char d(m mVar, Object obj, char c10) {
        ThreadLocal<m> threadLocal = f4025a;
        threadLocal.set(mVar);
        ThreadLocal<Character> threadLocal2 = f4026b;
        threadLocal2.set(Character.valueOf(c10));
        e(obj);
        threadLocal.set(null);
        return threadLocal2.get().charValue();
    }

    public abstract void e(Object obj);
}
