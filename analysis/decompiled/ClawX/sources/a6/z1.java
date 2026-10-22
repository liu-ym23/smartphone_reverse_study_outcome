package a6;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public abstract class z1 {

    /* renamed from: a, reason: collision with root package name */
    public static final ThreadLocal f233a = new ThreadLocal();

    public static a1 a() {
        ThreadLocal threadLocal = f233a;
        a1 a1Var = (a1) threadLocal.get();
        if (a1Var != null) {
            return a1Var;
        }
        h hVar = new h(Thread.currentThread());
        threadLocal.set(hVar);
        return hVar;
    }
}
