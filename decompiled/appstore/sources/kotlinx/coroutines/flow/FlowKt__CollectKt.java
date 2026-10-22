package kotlinx.coroutines.flow;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: classes4.dex */
public abstract /* synthetic */ class FlowKt__CollectKt {
    public static final Object a(Flow r10, Continuation r11) {
        Object r12 = r10.collect(kotlinx.coroutines.flow.internal.l.f21550a, r11);
        if (r12 != kotlin.coroutines.intrinsics.a.d()) goto L6;
        return r12;
    L6:
        return Unit.f21064a;
    }

    public static final Object b(Flow r10, Function2 r11, Continuation r12) {
        Object r13 = c.g(c.d(c.H(r10, r11), 0, null, 2, null), r12);
        if (r13 != kotlin.coroutines.intrinsics.a.d()) goto L6;
        return r13;
    L6:
        return Unit.f21064a;
    }

    public static final Object c(FlowCollector r10, Flow r11, Continuation r12) {
        c.s(r10);
        Object r13 = r11.collect(r10, r12);
        if (r13 != kotlin.coroutines.intrinsics.a.d()) goto L6;
        return r13;
    L6:
        return Unit.f21064a;
    }

    public static final Job d(Flow r10, CoroutineScope r11) {
        return kotlinx.coroutines.h.d(r11, null, null, new FlowKt__CollectKt$launchIn$1(r10, null), 3, null);
    }
}
