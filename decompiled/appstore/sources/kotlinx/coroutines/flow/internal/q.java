package kotlinx.coroutines.flow.internal;

import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.flow.SharedFlowImpl;
import kotlinx.coroutines.flow.StateFlow;

/* JADX INFO: loaded from: classes4.dex */
public final class q extends SharedFlowImpl implements StateFlow {
    public q(int r10) {
        super(1, Channel.UNLIMITED, BufferOverflow.DROP_OLDEST);
        tryEmit(Integer.valueOf(r10));
    }

    public Integer T() {
        monitor-enter(this);
        Integer r10 = Integer.valueOf(((Number) G()).intValue());     // Catch: Throwable -> L6
        monitor-exit(this);
        return r10;
    L6:
        th = move-exception;
        throw th;
    }

    public final boolean U(int r10) {
        monitor-enter(this);
        boolean r11 = tryEmit(Integer.valueOf(((Number) G()).intValue() + r10));     // Catch: Throwable -> L6
        monitor-exit(this);
        return r11;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // kotlinx.coroutines.flow.StateFlow
    public /* bridge */ /* synthetic */ Object getValue() {
        return T();
    }
}
