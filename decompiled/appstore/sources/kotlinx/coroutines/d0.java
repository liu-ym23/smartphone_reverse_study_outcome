package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes4.dex */
public abstract class d0 {
    public static final CoroutineScope a(CoroutineContext r10) {
        if (r10.get(Job.Key) != null) goto L7;
        r10 = r10.plus(h1.b(null, 1, null));
    L7:
        return new kotlinx.coroutines.internal.f(r10);
    }

    public static final CoroutineScope b() {
        return new kotlinx.coroutines.internal.f(x1.b(null, 1, null).plus(l0.c()));
    }

    public static final void c(CoroutineScope r10, CancellationException r11) {
        Job r12 = (Job) r10.getCoroutineContext().get(Job.Key);
        if (r12 == null) goto L7;
        r12.cancel(r11);
        return;
    L7:
        throw new IllegalStateException(("Scope cannot be cancelled because it does not have a job: " + r10).toString());
    }

    public static /* synthetic */ void d(CoroutineScope r10, CancellationException r11, int r12, Object r13) {
        if ((r12 & 1) == 0) goto L5;
        r11 = null;
    L5:
        c(r10, r11);
    }

    public static final Object e(Function2 r10, Continuation r11) {
        kotlinx.coroutines.internal.x r12 = new kotlinx.coroutines.internal.x(r11.getContext(), r11);
        Object r13 = cg.b.c(r12, r12, r10);
        if (r13 != kotlin.coroutines.intrinsics.a.d()) goto L5;
        tf.d.c(r11);
    L5:
        return r13;
    }

    public static final boolean f(CoroutineScope r10) {
        Job r11 = (Job) r10.getCoroutineContext().get(Job.Key);
        if (r11 != null) goto L7;
        return true;
    L7:
        return r11.isActive();
    }

    public static final CoroutineScope g(CoroutineScope r10, CoroutineContext r11) {
        return new kotlinx.coroutines.internal.f(r10.getCoroutineContext().plus(r11));
    }
}
