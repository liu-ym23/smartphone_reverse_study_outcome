package androidx.lifecycle;

import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes.dex */
public abstract class PausingDispatcherKt {
    public static final Object a(Lifecycle r10, Function2 r11, Continuation r12) {
        return d(r10, Lifecycle.State.CREATED, r11, r12);
    }

    public static final Object b(Lifecycle r10, Function2 r11, Continuation r12) {
        return d(r10, Lifecycle.State.RESUMED, r11, r12);
    }

    public static final Object c(Lifecycle r10, Function2 r11, Continuation r12) {
        return d(r10, Lifecycle.State.STARTED, r11, r12);
    }

    public static final Object d(Lifecycle r10, Lifecycle.State r11, Function2 r12, Continuation r13) {
        return kotlinx.coroutines.h.g(kotlinx.coroutines.l0.c().e(), new PausingDispatcherKt$whenStateAtLeast$2(r10, r11, r12, null), r13);
    }
}
