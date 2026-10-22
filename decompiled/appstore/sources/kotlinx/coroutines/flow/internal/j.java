package kotlinx.coroutines.flow.internal;

import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: classes4.dex */
public abstract class j {
    public static final void a(AbortFlowException r10, FlowCollector r11) {
        if (r10.owner != r11) goto L5;
        return;
    L5:
        throw r10;
    }
}
