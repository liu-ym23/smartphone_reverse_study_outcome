package kotlinx.coroutines.flow.internal;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.y;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.internal.ThreadContextKt;

/* JADX INFO: loaded from: classes4.dex */
public abstract class d {
    public static final /* synthetic */ FlowCollector a(FlowCollector r10, CoroutineContext r11) {
        return e(r10, r11);
    }

    public static final ChannelFlow b(Flow r10) {
        if ((r10 instanceof ChannelFlow) == false) goto L5;
        ChannelFlow r11 = (ChannelFlow) r10;
    L6:
        if (r11 == null) goto L8;
        return r11;
    L8:
        return new f(r10, null, 0, null, 14, null);
    L5:
        r11 = null;
        goto L6
    }

    public static final Object c(CoroutineContext r10, Object r11, Object r12, Function2 r13, Continuation r14) {
        Object r15 = ThreadContextKt.c(r10, r12);
        p r16 = new p(r14, r10);     // Catch: Throwable -> L8
        Object r17 = ((Function2) y.e(r13, 2)).mo0invoke(r11, r16);     // Catch: Throwable -> L8
        ThreadContextKt.a(r10, r15);
        if (r17 != kotlin.coroutines.intrinsics.a.d()) goto L7;
        tf.d.c(r14);
    L7:
        return r17;
    L8:
        th = move-exception;
        ThreadContextKt.a(r10, r15);
        throw th;
    }

    public static /* synthetic */ Object d(CoroutineContext r10, Object r11, Object r12, Function2 r13, Continuation r14, int r15, Object r16) {
        if ((r15 & 4) == 0) goto L6;
        r12 = ThreadContextKt.b(r10);
    L6:
        return c(r10, r11, r12, r13, r14);
    }

    public static final FlowCollector e(FlowCollector r10, CoroutineContext r11) {
        if ((r10 instanceof o) == false) goto L5;
        boolean r12 = true;
    L6:
        if (r12 == false) goto L9;
        return r10;
    L9:
        return new UndispatchedContextCollector(r10, r11);
    L5:
        r12 = r10 instanceof l;
        goto L6
    }
}
