package kotlinx.coroutines.flow;

import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ReceiveChannel;

/* JADX INFO: loaded from: classes4.dex */
public abstract /* synthetic */ class FlowKt__DelayKt {
    public static final ReceiveChannel a(CoroutineScope r10, long r11, long r13) {
        if (r11 < 0) goto L11;
        if (r13 < 0) goto L9;
        return ProduceKt.d(r10, null, 0, new FlowKt__DelayKt$fixedPeriodTicker$3(r13, r11, null), 1, null);
    L9:
        throw new IllegalArgumentException(("Expected non-negative initial delay, but has " + r13 + " ms").toString());
    L11:
        throw new IllegalArgumentException(("Expected non-negative delay, but has " + r11 + " ms").toString());
    }

    public static /* synthetic */ ReceiveChannel b(CoroutineScope r10, long r11, long r12, int r13, Object r14) {
        if ((r13 & 2) == 0) goto L6;
        r12 = r11;
    L6:
        return c.y(r10, r11, r12);
    }
}
