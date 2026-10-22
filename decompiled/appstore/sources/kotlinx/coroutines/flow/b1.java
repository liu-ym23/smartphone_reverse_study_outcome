package kotlinx.coroutines.flow;

import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.Channel;

/* JADX INFO: loaded from: classes4.dex */
public abstract class b1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final kotlinx.coroutines.internal.b0 f21509a = null;

    static {
        f21509a = new kotlinx.coroutines.internal.b0("NO_VALUE");
    }

    public static final MutableSharedFlow a(int r10, int r11, BufferOverflow r12) {
        if (r10 < 0) goto L19;
        if (r11 < 0) goto L17;
        if (r10 > 0) goto L11;
        if (r11 > 0) goto L11;
        if (r12 == BufferOverflow.SUSPEND) goto L11;
        throw new IllegalArgumentException(("replay or extraBufferCapacity must be positive with non-default onBufferOverflow strategy " + r12).toString());
    L11:
        int r13 = r11 + r10;
        if (r13 >= 0) goto L15;
        r13 = Channel.UNLIMITED;
    L15:
        return new SharedFlowImpl(r10, r13, r12);
    L17:
        throw new IllegalArgumentException(("extraBufferCapacity cannot be negative, but was " + r11).toString());
    L19:
        throw new IllegalArgumentException(("replay cannot be negative, but was " + r10).toString());
    }

    public static /* synthetic */ MutableSharedFlow b(int r10, int r11, BufferOverflow r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r10 = 0;
    L6:
        if ((r13 & 2) == 0) goto L9;
        r11 = 0;
    L9:
        if ((r13 & 4) == 0) goto L12;
        r12 = BufferOverflow.SUSPEND;
    L12:
        return a(r10, r11, r12);
    }

    public static final /* synthetic */ Object c(Object[] r10, long r11) {
        return f(r10, r11);
    }

    public static final /* synthetic */ void d(Object[] r10, long r11, Object r12) {
        g(r10, r11, r12);
    }

    public static final Flow e(SharedFlow r10, CoroutineContext r11, int r12, BufferOverflow r13) {
        if (r12 == 0) goto L6;
        if (r12 == (-3)) goto L6;
    L9:
        return new kotlinx.coroutines.flow.internal.f(r10, r11, r12, r13);
    L6:
        if (r13 != BufferOverflow.SUSPEND) goto L9;
        return r10;
    }

    public static final Object f(Object[] r10, long r11) {
        return r10[((int) r11) & (r10.length - 1)];
    }

    public static final void g(Object[] r10, long r11, Object r12) {
        r10[((int) r11) & (r10.length - 1)] = r12;
    }
}
