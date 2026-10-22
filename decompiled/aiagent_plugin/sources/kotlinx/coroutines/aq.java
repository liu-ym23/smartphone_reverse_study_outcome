package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: Debug.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class aq {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final boolean f38857a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final boolean f38858b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final boolean f38859c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final AtomicLong f38860d = null;

    static {
        boolean r0 = false;
        f38857a = false;
        String r1 = kotlinx.coroutines.internal.am.a("kotlinx.coroutines.debug");
        if (r1 == null) goto L26;
        int r3 = r1.hashCode();
        if (r3 == 0) goto L22;
        if (r3 == 3551) goto L19;
        if (r3 == 109935) goto L16;
        if (r3 != 3005871) goto L25;
        if (r1.equals("auto") == true) goto L26;
    L25:
        throw new IllegalStateException(("System property 'kotlinx.coroutines.debug' has unrecognized value '" + r1 + '\'').toString());
    L16:
        if (r1.equals("off") == false) goto L25;
    L19:
        if (r1.equals("on") == false) goto L25;
    L23:
        boolean r2 = true;
    L27:
        f38858b = r2;
        if (r2 == true) goto L30;
    L32:
        f38859c = r0;
        f38860d = new AtomicLong(0);
        return;
    L30:
        if (kotlinx.coroutines.internal.am.a("kotlinx.coroutines.stacktrace.recovery", true) == false) goto L32;
        r0 = true;
        goto L32
    L22:
        if (r1.equals("") == false) goto L25;
    L26:
        r2 = false;
        goto L27
    }

    public static final boolean a() {
        return f38857a;
    }

    public static final boolean b() {
        return f38858b;
    }

    public static final boolean c() {
        return f38859c;
    }

    public static final AtomicLong d() {
        return f38860d;
    }
}
