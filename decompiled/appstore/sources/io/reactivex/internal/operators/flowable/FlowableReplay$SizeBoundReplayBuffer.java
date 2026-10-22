package io.reactivex.internal.operators.flowable;

/* JADX INFO: loaded from: classes4.dex */
final class FlowableReplay$SizeBoundReplayBuffer<T> extends FlowableReplay$BoundedReplayBuffer<T> {
    private static final long serialVersionUID = -5898283885385201806L;
    final int limit;

    public FlowableReplay$SizeBoundReplayBuffer(int r10) {
        this.limit = r10;
    }

    @Override // io.reactivex.internal.operators.flowable.FlowableReplay$BoundedReplayBuffer
    public void truncate() {
        if (this.size <= this.limit) goto L6;
        removeFirst();
        return;
    }
}
