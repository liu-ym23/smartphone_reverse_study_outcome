package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;

/* JADX INFO: loaded from: classes4.dex */
public abstract /* synthetic */ class j1 {
    public static final CompletableJob a(Job r10) {
        return new g1(r10);
    }

    public static /* synthetic */ CompletableJob b(Job r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L6;
        r10 = null;
    L6:
        return h1.a(r10);
    }

    public static final void c(CoroutineContext r10, CancellationException r11) {
        Job r12 = (Job) r10.get(Job.Key);
        if (r12 == null) goto L6;
        r12.cancel(r11);
        return;
    }

    public static /* synthetic */ void d(CoroutineContext r10, CancellationException r11, int r12, Object r13) {
        if ((r12 & 1) == 0) goto L5;
        r11 = null;
    L5:
        h1.c(r10, r11);
    }

    public static final Object e(Job r10, Continuation r11) {
        Job.a.b(r10, null, 1, null);
        Object r12 = r10.join(r11);
        if (r12 != kotlin.coroutines.intrinsics.a.d()) goto L6;
        return r12;
    L6:
        return Unit.f21064a;
    }

    public static final DisposableHandle f(Job r10, DisposableHandle r11) {
        return r10.invokeOnCompletion(new o0(r11));
    }

    public static final void g(CoroutineContext r10) {
        Job r11 = (Job) r10.get(Job.Key);
        if (r11 == null) goto L6;
        h1.i(r11);
        return;
    }

    public static final void h(Job r10) {
        if (r10.isActive() == false) goto L6;
        return;
    L6:
        throw r10.getCancellationException();
    }

    public static final Job i(CoroutineContext r10) {
        Job r11 = (Job) r10.get(Job.Key);
        if (r11 == null) goto L6;
        return r11;
    L6:
        throw new IllegalStateException(("Current context doesn't contain Job in it: " + r10).toString());
    }
}
