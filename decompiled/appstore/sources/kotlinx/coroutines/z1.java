package kotlinx.coroutines;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class z1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final z1 f21774a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ThreadLocal f21775b = null;

    static {
        f21774a = new z1();
        f21775b = kotlinx.coroutines.internal.h0.a(new kotlinx.coroutines.internal.b0("ThreadLocalEventLoop"));
    }

    public z1() {
    }

    public final q0 a() {
        return (q0) f21775b.get();
    }

    public final q0 b() {
        ThreadLocal r10 = f21775b;
        q0 r11 = (q0) r10.get();
        if (r11 != null) goto L6;
        q0 r12 = t0.a();
        r10.set(r12);
        return r12;
    L6:
        return r11;
    }

    public final void c() {
        f21775b.set(null);
    }

    public final void setEventLoop$kotlinx_coroutines_core(@NotNull q0 r10) {
        f21775b.set(r10);
    }
}
