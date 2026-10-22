package kotlinx.coroutines.flow;

import java.util.List;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.internal.FusibleFlow;

/* JADX INFO: loaded from: classes4.dex */
public final class y0 implements SharedFlow, CancellableFlow, FusibleFlow {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Job f21558a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ SharedFlow f21559b;

    public y0(SharedFlow r10, Job r11) {
        this.f21558a = r11;
        this.f21559b = r10;
    }

    @Override // kotlinx.coroutines.flow.SharedFlow, kotlinx.coroutines.flow.Flow
    public Object collect(FlowCollector r10, Continuation r11) {
        return this.f21559b.collect(r10, r11);
    }

    @Override // kotlinx.coroutines.flow.internal.FusibleFlow
    public Flow fuse(CoroutineContext r10, int r11, BufferOverflow r12) {
        return b1.e(this, r10, r11, r12);
    }

    @Override // kotlinx.coroutines.flow.SharedFlow
    public List getReplayCache() {
        return this.f21559b.getReplayCache();
    }
}
