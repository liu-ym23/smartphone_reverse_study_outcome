package K1;

/* loaded from: classes.dex */
public abstract class d implements y {

    /* renamed from: a, reason: collision with root package name */
    public static final ThreadLocal<m> f4031a = new ThreadLocal<>();

    /* renamed from: b, reason: collision with root package name */
    public static final ThreadLocal<Character> f4032b = new ThreadLocal<>();

    /* renamed from: c, reason: collision with root package name */
    public static final Character f4033c = ',';

    public final char d(m mVar, Object obj, char c10) {
        ThreadLocal<m> threadLocal = f4031a;
        threadLocal.set(mVar);
        ThreadLocal<Character> threadLocal2 = f4032b;
        threadLocal2.set(Character.valueOf(c10));
        e(obj);
        threadLocal.set(null);
        return threadLocal2.get().charValue();
    }

    public abstract void e(Object obj);
}
