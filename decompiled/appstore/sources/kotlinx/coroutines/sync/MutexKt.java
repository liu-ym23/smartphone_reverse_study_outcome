package kotlinx.coroutines.sync;

import kotlin.c;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.p;
import kotlinx.coroutines.internal.b0;

/* JADX INFO: loaded from: classes4.dex */
public abstract class MutexKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b0 f21741a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final b0 f21742b = null;

    static {
        f21741a = new b0("NO_OWNER");
        f21742b = new b0("ALREADY_LOCKED_BY_OWNER");
    }

    public static final Mutex a(boolean r10) {
        return new MutexImpl(r10);
    }

    public static /* synthetic */ Mutex b(boolean r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L6;
        r10 = false;
    L6:
        return a(r10);
    }

    public static final /* synthetic */ b0 c() {
        return f21741a;
    }

    public static final /* synthetic */ b0 d() {
        return f21742b;
    }

    public static final Object e(Mutex r10, Object r11, Function0 r12, Continuation r13) {
        if ((r13 instanceof MutexKt$withLock$1) == false) goto L7;
        MutexKt$withLock$1 r14 = (MutexKt$withLock$1) r13;
        int r15 = r14.label;
        if ((r15 & Integer.MIN_VALUE) == 0) goto L7;
        r14.label = r15 - Integer.MIN_VALUE;
    L8:
        Object r16 = r14.result;
        Object r17 = kotlin.coroutines.intrinsics.a.d();
        int r18 = r14.label;
        if (r18 == 0) goto L14;
        if (r18 != 1) goto L13;
        r12 = (Function0) r14.L$2;
        r11 = r14.L$1;
        r10 = (Mutex) r14.L$0;
        c.b(r16);
    L23:
        Object r19 = r12.invoke();     // Catch: Throwable -> L20
        p.b(1);
        r10.unlock(r11);
        p.a(1);
        return r19;
    L20:
        th = move-exception;
        p.b(1);
        r10.unlock(r11);
        p.a(1);
        throw th;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        c.b(r16);
        r14.L$0 = r10;
        r14.L$1 = r11;
        r14.L$2 = r12;
        r14.label = 1;
        if (r10.lock(r11, r14) != r17) goto L23;
        return r17;
    L7:
        r14 = new MutexKt$withLock$1(r13);
        goto L8
    }
}
