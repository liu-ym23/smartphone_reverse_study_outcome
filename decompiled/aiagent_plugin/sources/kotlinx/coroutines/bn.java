package kotlinx.coroutines;

/* JADX INFO: compiled from: EventLoop.common.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class bn {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final kotlinx.coroutines.internal.al f39164a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final kotlinx.coroutines.internal.al f39165b = null;

    public static final long a(long r3) {
        if (r3 > 0) goto L6;
        return 0;
    L6:
        if (r3 < 9223372036854L) goto L9;
        return Long.MAX_VALUE;
    L9:
        return 1000000 * r3;
    }

    public static final /* synthetic */ kotlinx.coroutines.internal.al a() {
        return f39165b;
    }

    public static final /* synthetic */ kotlinx.coroutines.internal.al b() {
        return f39164a;
    }

    static {
        f39164a = new kotlinx.coroutines.internal.al("REMOVED_TASK");
        f39165b = new kotlinx.coroutines.internal.al("CLOSED_EMPTY");
    }
}
