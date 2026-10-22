package kotlinx.coroutines;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes4.dex */
public abstract class h {
    public static final Deferred a(CoroutineScope r10, CoroutineContext r11, CoroutineStart r12, Function2 r13) {
        return j.a(r10, r11, r12, r13);
    }

    public static /* synthetic */ Deferred b(CoroutineScope r10, CoroutineContext r11, CoroutineStart r12, Function2 r13, int r14, Object r15) {
        return j.b(r10, r11, r12, r13, r14, r15);
    }

    public static final Job c(CoroutineScope r10, CoroutineContext r11, CoroutineStart r12, Function2 r13) {
        return j.c(r10, r11, r12, r13);
    }

    public static /* synthetic */ Job d(CoroutineScope r10, CoroutineContext r11, CoroutineStart r12, Function2 r13, int r14, Object r15) {
        return j.d(r10, r11, r12, r13, r14, r15);
    }

    public static final Object e(CoroutineContext r10, Function2 r11) {
        return i.a(r10, r11);
    }

    public static /* synthetic */ Object f(CoroutineContext r10, Function2 r11, int r12, Object r13) {
        return i.b(r10, r11, r12, r13);
    }

    public static final Object g(CoroutineContext r10, Function2 r11, Continuation r12) {
        return j.e(r10, r11, r12);
    }
}
