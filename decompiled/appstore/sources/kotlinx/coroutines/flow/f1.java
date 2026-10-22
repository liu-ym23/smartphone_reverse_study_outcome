package kotlinx.coroutines.flow;

import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.channels.BufferOverflow;

/* JADX INFO: loaded from: classes4.dex */
public abstract class f1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final kotlinx.coroutines.internal.b0 f21516a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final kotlinx.coroutines.internal.b0 f21517b = null;

    static {
        f21516a = new kotlinx.coroutines.internal.b0("NONE");
        f21517b = new kotlinx.coroutines.internal.b0("PENDING");
    }

    public static final MutableStateFlow a(Object r10) {
        if (r10 != null) goto L6;
        r10 = kotlinx.coroutines.flow.internal.m.f21551a;
    L6:
        return new StateFlowImpl(r10);
    }

    public static final /* synthetic */ kotlinx.coroutines.internal.b0 b() {
        return f21516a;
    }

    public static final /* synthetic */ kotlinx.coroutines.internal.b0 c() {
        return f21517b;
    }

    public static final Flow d(StateFlow r10, CoroutineContext r11, int r12, BufferOverflow r13) {
        if (r12 < 0) goto L7;
        if (r12 >= 2) goto L7;
    L9:
        if (r13 != BufferOverflow.DROP_OLDEST) goto L12;
        return r10;
    L12:
        return b1.e(r10, r11, r12, r13);
    L7:
        if (r12 != (-2)) goto L12;
        goto L9
    }
}
