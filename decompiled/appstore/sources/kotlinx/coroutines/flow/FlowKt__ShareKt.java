package kotlinx.coroutines.flow;

import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.flow.internal.ChannelFlow;

/* JADX INFO: loaded from: classes4.dex */
public abstract /* synthetic */ class FlowKt__ShareKt {
    public static final SharedFlow a(MutableSharedFlow r10) {
        return new y0(r10, null);
    }

    public static final StateFlow b(MutableStateFlow r10) {
        return new z0(r10, null);
    }

    public static final d1 c(Flow r10, int r11) {
        int r12 = bg.h.d(r11, Channel.Factory.a()) - r11;
        if ((r10 instanceof ChannelFlow) == false) goto L21;
        ChannelFlow r13 = (ChannelFlow) r10;
        Flow r14 = r13.e();
        if (r14 == null) goto L21;
        int r15 = r13.f21520b;
        if (r15 == (-3)) goto L13;
        if (r15 == (-2)) goto L13;
        if (r15 == 0) goto L13;
        r12 = r15;
    L19:
        return new d1(r14, r12, r13.f21521c, r13.f21519a);
    L13:
        if (r13.f21521c != BufferOverflow.SUSPEND) goto L16;
        if (r15 != 0) goto L19;
    L15:
        r12 = 0;
        goto L19
    L16:
        if (r11 != 0) goto L15;
        r12 = 1;
    L21:
        return new d1(r10, r12, BufferOverflow.SUSPEND, EmptyCoroutineContext.INSTANCE);
    }

    public static final Job d(CoroutineScope r10, CoroutineContext r11, Flow r12, MutableSharedFlow r13, SharingStarted r14, Object r15) {
        if (kotlin.jvm.internal.q.b(r14, SharingStarted.Companion.c()) == false) goto L5;
        CoroutineStart r16 = CoroutineStart.DEFAULT;
    L7:
        return kotlinx.coroutines.h.c(r10, r11, r16, new FlowKt__ShareKt$launchSharing$1(r14, r12, r13, r15, null));
    L5:
        r16 = CoroutineStart.UNDISPATCHED;
        goto L7
    }

    public static final StateFlow e(Flow r10, CoroutineScope r11, SharingStarted r12, Object r13) {
        d1 r14 = c(r10, 1);
        MutableStateFlow r15 = f1.a(r13);
        return new z0(r15, d(r11, r14.f21515d, r14.f21512a, r15, r12, r13));
    }
}
