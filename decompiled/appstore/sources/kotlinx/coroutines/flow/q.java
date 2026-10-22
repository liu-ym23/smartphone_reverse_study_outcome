package kotlinx.coroutines.flow;

import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.internal.FusibleFlow;

/* JADX INFO: loaded from: classes4.dex */
public abstract /* synthetic */ class q {
    public static final Flow a(Flow r10, int r11, BufferOverflow r12) {
        if (r11 < 0) goto L5;
    L10:
        if (r11 == (-1)) goto L12;
    L16:
        if (r11 != (-1)) goto L18;
        r12 = BufferOverflow.DROP_OLDEST;
        r11 = 0;
    L18:
        int r13 = r11;
        BufferOverflow r14 = r12;
        if ((r10 instanceof FusibleFlow) == false) goto L22;
        return FusibleFlow.a.a((FusibleFlow) r10, null, r13, r14, 1, null);
    L22:
        return new kotlinx.coroutines.flow.internal.f(r10, null, r13, r14, 2, null);
    L12:
        if (r12 == BufferOverflow.SUSPEND) goto L16;
        throw new IllegalArgumentException("CONFLATED capacity cannot be used with non-default onBufferOverflow");
    L5:
        if (r11 == (-2)) goto L10;
        if (r11 == (-1)) goto L10;
        throw new IllegalArgumentException(("Buffer size should be non-negative, BUFFERED, or CONFLATED, but was " + r11).toString());
    }

    public static /* synthetic */ Flow b(Flow r10, int r11, BufferOverflow r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r11 = -2;
    L6:
        if ((r13 & 2) == 0) goto L9;
        r12 = BufferOverflow.SUSPEND;
    L9:
        return c.c(r10, r11, r12);
    }

    public static final void c(CoroutineContext r10) {
        if (r10.get(Job.Key) != null) goto L6;
        return;
    L6:
        throw new IllegalArgumentException(("Flow context cannot contain job in it. Had " + r10).toString());
    }

    public static final Flow d(Flow r10) {
        return c.d(r10, -1, null, 2, null);
    }

    public static final Flow e(Flow r10, CoroutineContext r11) {
        c(r11);
        if (kotlin.jvm.internal.q.b(r11, EmptyCoroutineContext.INSTANCE) == false) goto L6;
        return r10;
    L6:
        if ((r10 instanceof FusibleFlow) == false) goto L9;
        return FusibleFlow.a.a((FusibleFlow) r10, r11, 0, null, 6, null);
    L9:
        return new kotlinx.coroutines.flow.internal.f(r10, r11, 0, null, 12, null);
    }
}
