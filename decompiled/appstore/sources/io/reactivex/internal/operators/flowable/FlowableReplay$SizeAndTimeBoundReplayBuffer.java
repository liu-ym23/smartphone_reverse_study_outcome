package io.reactivex.internal.operators.flowable;

import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes4.dex */
final class FlowableReplay$SizeAndTimeBoundReplayBuffer<T> extends FlowableReplay$BoundedReplayBuffer<T> {
    private static final long serialVersionUID = 3457957419649567404L;
    final int limit;
    final long maxAge;
    final mf.f scheduler;
    final TimeUnit unit;

    public FlowableReplay$SizeAndTimeBoundReplayBuffer(int r10, long r11, TimeUnit r12, mf.f r13) {
        this.limit = r10;
        this.maxAge = r11;
        this.unit = r12;
    }

    @Override // io.reactivex.internal.operators.flowable.FlowableReplay$BoundedReplayBuffer
    public Object enterTransform(Object r10) {
        throw null;
    }

    @Override // io.reactivex.internal.operators.flowable.FlowableReplay$BoundedReplayBuffer
    public FlowableReplay$Node getHead() {
        throw null;
    }

    @Override // io.reactivex.internal.operators.flowable.FlowableReplay$BoundedReplayBuffer
    public Object leaveTransform(Object r10) {
        return ((rf.a) r10).a();
    }

    @Override // io.reactivex.internal.operators.flowable.FlowableReplay$BoundedReplayBuffer
    public void truncate() {
        throw null;
    }

    @Override // io.reactivex.internal.operators.flowable.FlowableReplay$BoundedReplayBuffer
    public void truncateFinal() {
        throw null;
    }
}
