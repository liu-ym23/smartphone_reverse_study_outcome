package kotlinx.coroutines;

/* JADX INFO: loaded from: classes4.dex */
public abstract class g0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final boolean f21563a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Delay f21564b = null;

    static {
        f21563a = kotlinx.coroutines.internal.c0.f("kotlinx.coroutines.main.delay", false);
        f21564b = b();
    }

    public static final Delay a() {
        return f21564b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final Delay b() {
        if (f21563a == false) goto L5;
        o1 r10 = l0.c();
        if (kotlinx.coroutines.internal.s.c(r10) == true) goto L13;
        if ((r10 instanceof Delay) == false) goto L13;
        return (Delay) r10;
    L13:
        return f0.f21422i;
    L5:
        return f0.f21422i;
    }
}
