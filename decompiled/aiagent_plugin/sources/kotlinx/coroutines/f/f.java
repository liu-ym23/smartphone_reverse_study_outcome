package kotlinx.coroutines.f;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlinx.coroutines.internal.al;
import kotlinx.coroutines.internal.am;

/* JADX INFO: compiled from: Semaphore.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int f39342a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final al f39343b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final al f39344c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final al f39345d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final al f39346e = null;
    private static final int f = 0;

    public static final /* synthetic */ int a() {
        return f;
    }

    public static final /* synthetic */ g a(long r0, g r2) {
        return b(r0, r2);
    }

    public static final /* synthetic */ al b() {
        return f39343b;
    }

    public static final /* synthetic */ al c() {
        return f39344c;
    }

    public static final /* synthetic */ int d() {
        return f39342a;
    }

    public static final /* synthetic */ al e() {
        return f39345d;
    }

    public static final /* synthetic */ al f() {
        return f39346e;
    }

    public static final d a(int r1, int r2) {
        return (d) ZeusTransformUtils.preCheckCast(new e(r1, r2), d.class, "com.obric.aiagent.plugin");
    }

    public static /* synthetic */ d a(int r0, int r1, int r2, Object r3) {
        if ((r2 & 2) == 0) goto L6;
        r1 = 0;
    L6:
        return a(r0, r1);
    }

    private static final g b(long r2, g r4) {
        return new g(r2, r4, 0);
    }

    static {
        f39342a = am.a("kotlinx.coroutines.semaphore.maxSpinCycles", 100, 0, 0, 12, null);
        f39343b = new al("PERMIT");
        f39344c = new al("TAKEN");
        f39345d = new al("BROKEN");
        f39346e = new al("CANCELLED");
        f = am.a("kotlinx.coroutines.semaphore.segmentSize", 16, 0, 0, 12, null);
    }
}
