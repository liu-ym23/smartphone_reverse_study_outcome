package kotlinx.coroutines.sync;

import kotlin.c;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.p;
import kotlinx.coroutines.internal.b0;
import kotlinx.coroutines.internal.c0;

/* JADX INFO: loaded from: classes4.dex */
public abstract class SemaphoreKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f21750a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final b0 f21751b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final b0 f21752c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final b0 f21753d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final b0 f21754e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f21755f = 0;

    static {
        f21750a = c0.g("kotlinx.coroutines.semaphore.maxSpinCycles", 100, 0, 0, 12, null);
        f21751b = new b0("PERMIT");
        f21752c = new b0("TAKEN");
        f21753d = new b0("BROKEN");
        f21754e = new b0("CANCELLED");
        f21755f = c0.g("kotlinx.coroutines.semaphore.segmentSize", 16, 0, 0, 12, null);
    }

    public static final /* synthetic */ a a(long r10, a r11) {
        return h(r10, r11);
    }

    public static final /* synthetic */ b0 b() {
        return f21753d;
    }

    public static final /* synthetic */ b0 c() {
        return f21754e;
    }

    public static final /* synthetic */ int d() {
        return f21750a;
    }

    public static final /* synthetic */ b0 e() {
        return f21751b;
    }

    public static final /* synthetic */ int f() {
        return f21755f;
    }

    public static final /* synthetic */ b0 g() {
        return f21752c;
    }

    public static final a h(long r10, a r11) {
        return new a(r10, r11, 0);
    }

    public static final Object i(Semaphore r10, Function0 r11, Continuation r12) {
        if ((r12 instanceof SemaphoreKt$withPermit$1) == false) goto L7;
        SemaphoreKt$withPermit$1 r13 = (SemaphoreKt$withPermit$1) r12;
        int r14 = r13.label;
        if ((r14 & Integer.MIN_VALUE) == 0) goto L7;
        r13.label = r14 - Integer.MIN_VALUE;
    L8:
        Object r15 = r13.result;
        Object r16 = kotlin.coroutines.intrinsics.a.d();
        int r17 = r13.label;
        if (r17 == 0) goto L14;
        if (r17 != 1) goto L13;
        r11 = (Function0) r13.L$1;
        r10 = (Semaphore) r13.L$0;
        c.b(r15);
    L23:
        Object r18 = r11.invoke();     // Catch: Throwable -> L20
        p.b(1);
        r10.release();
        p.a(1);
        return r18;
    L20:
        th = move-exception;
        p.b(1);
        r10.release();
        p.a(1);
        throw th;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        c.b(r15);
        r13.L$0 = r10;
        r13.L$1 = r11;
        r13.label = 1;
        if (r10.acquire(r13) != r16) goto L23;
        return r16;
    L7:
        r13 = new SemaphoreKt$withPermit$1(r12);
        goto L8
    }
}
