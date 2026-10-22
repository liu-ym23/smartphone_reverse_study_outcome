package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import java.util.concurrent.Future;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;

/* JADX INFO: loaded from: classes4.dex */
public abstract class h1 {
    public static final CompletableJob a(Job r10) {
        return j1.a(r10);
    }

    public static /* synthetic */ CompletableJob b(Job r10, int r11, Object r12) {
        return j1.b(r10, r11, r12);
    }

    public static final void c(CoroutineContext r10, CancellationException r11) {
        j1.c(r10, r11);
    }

    public static /* synthetic */ void d(CoroutineContext r10, CancellationException r11, int r12, Object r13) {
        j1.d(r10, r11, r12, r13);
    }

    public static final Object e(Job r10, Continuation r11) {
        return j1.e(r10, r11);
    }

    public static final void f(CancellableContinuation r10, Future r11) {
        i1.a(r10, r11);
    }

    public static final DisposableHandle g(Job r10, DisposableHandle r11) {
        return j1.f(r10, r11);
    }

    public static final void h(CoroutineContext r10) {
        j1.g(r10);
    }

    public static final void i(Job r10) {
        j1.h(r10);
    }

    public static final Job j(CoroutineContext r10) {
        return j1.i(r10);
    }
}
