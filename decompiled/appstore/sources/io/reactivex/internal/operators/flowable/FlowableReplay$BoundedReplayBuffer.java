package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.util.NotificationLite;
import java.util.Collection;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes4.dex */
class FlowableReplay$BoundedReplayBuffer<T> extends AtomicReference<FlowableReplay$Node> implements FlowableReplay$ReplayBuffer<T> {
    private static final long serialVersionUID = 2346567790059478686L;
    long index;
    int size;
    FlowableReplay$Node tail;

    public FlowableReplay$BoundedReplayBuffer() {
        FlowableReplay$Node r10 = new FlowableReplay$Node(null, 0);
        this.tail = r10;
        set(r10);
    }

    public final void addLast(FlowableReplay$Node r10) {
        this.tail.set(r10);
        this.tail = r10;
        this.size++;
    }

    public final void collect(Collection<? super T> r10) {
        FlowableReplay$Node r11 = getHead();
    L3:
        r11 = r11.get();
        if (r11 == null) goto L11;
        Object r12 = leaveTransform(r11.value);
        if (NotificationLite.isComplete(r12) == true) goto L15;
        if (NotificationLite.isError(r12) == true) goto L16;
        r10.add((Object) NotificationLite.getValue(r12));
        goto L3
    L16:
        return;
    L15:
        return;
    }

    @Override // io.reactivex.internal.operators.flowable.FlowableReplay$ReplayBuffer
    public final void complete() {
        Object r10 = enterTransform(NotificationLite.complete());
        long r11 = this.index + 1;
        this.index = r11;
        addLast(new FlowableReplay$Node(r10, r11));
        truncateFinal();
    }

    public Object enterTransform(Object r10) {
        return r10;
    }

    @Override // io.reactivex.internal.operators.flowable.FlowableReplay$ReplayBuffer
    public final void error(Throwable r10) {
        Object r11 = enterTransform(NotificationLite.error(r10));
        long r12 = this.index + 1;
        this.index = r12;
        addLast(new FlowableReplay$Node(r11, r12));
        truncateFinal();
    }

    public FlowableReplay$Node getHead() {
        return get();
    }

    public boolean hasCompleted() {
        Object r10 = this.tail.value;
        if (r10 != null) goto L5;
    L7:
        return false;
    L5:
        if (NotificationLite.isComplete(leaveTransform(r10)) == false) goto L7;
        return true;
    }

    public boolean hasError() {
        Object r10 = this.tail.value;
        if (r10 != null) goto L5;
    L7:
        return false;
    L5:
        if (NotificationLite.isError(leaveTransform(r10)) == false) goto L7;
        return true;
    }

    public Object leaveTransform(Object r10) {
        return r10;
    }

    @Override // io.reactivex.internal.operators.flowable.FlowableReplay$ReplayBuffer
    public final void next(T r10) {
        Object r11 = enterTransform(NotificationLite.next(r10));
        long r12 = this.index + 1;
        this.index = r12;
        addLast(new FlowableReplay$Node(r11, r12));
        truncate();
    }

    public final void removeFirst() {
        FlowableReplay$Node r10 = get().get();
        if (r10 == null) goto L7;
        this.size--;
        setFirst(r10);
        return;
    L7:
        throw new IllegalStateException("Empty list!");
    }

    public final void removeSome(int r10) {
        FlowableReplay$Node r11 = get();
    L3:
        if (r10 <= 0) goto L5;
        r11 = r11.get();
        r10 = r10 - 1;
        this.size--;
        goto L3
    L5:
        setFirst(r11);
        FlowableReplay$Node r12 = get();
        if (r12.get() != null) goto L10;
        this.tail = r12;
        return;
    }

    @Override // io.reactivex.internal.operators.flowable.FlowableReplay$ReplayBuffer
    public final void replay(FlowableReplay$InnerSubscription<T> r15) {
        monitor-enter(r15);
    L8:
        th = move-exception;
        throw th;
    L4:
        if (r15.emitting == false) goto L10;
        r15.missed = true;     // Catch: Throwable -> L8
        monitor-exit(r15);     // Catch: Throwable -> L8
        return;
    L10:
        r15.emitting = true;     // Catch: Throwable -> L8
        monitor-exit(r15);     // Catch: Throwable -> L8
    L13:
        if (r15.isDisposed() == true) goto L14;
        long r10 = r15.get();
        if (r10 != Long.MAX_VALUE) goto L19;
        boolean r11 = true;
    L20:
        FlowableReplay$Node r12 = (FlowableReplay$Node) r15.index();
        if (r12 != null) goto L23;
        r12 = getHead();
        r15.index = r12;
        io.reactivex.internal.util.a.a(r15.totalRequested, r12.index);
    L23:
        long r13 = 0;
    L25:
        if (r10 == 0) goto L47;
        FlowableReplay$Node r14 = r12.get();
        if (r14 == null) goto L47;
        Object r16 = leaveTransform(r14.value);
    L33:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        r15.index = null;
        r15.dispose();
        if (NotificationLite.isError(r16) == false) goto L43;
        return;
    L43:
        if (NotificationLite.isComplete(r16) == true) goto L78;
        r15.child.onError(th);
        return;
    L78:
        return;
    L30:
        if (NotificationLite.accept(r16, r15.child) == true) goto L31;
        r13 = r13 + 1;
        r10 = r10 - 1;
        if (r15.isDisposed() == true) goto L37;
        r12 = r14;
        goto L25
    L37:
        r15.index = null;
        return;
    L31:
        r15.index = null;     // Catch: Throwable -> L33
        return;
    L47:
        if (r13 == 0) goto L51;
        r15.index = r12;
        if (r11 == true) goto L51;
        r15.produced(r13);
    L51:
        monitor-enter(r15);
    L57:
        th = move-exception;
        throw th;
    L53:
        if (r15.missed == false) goto L54;
        r15.missed = false;     // Catch: Throwable -> L57
        monitor-exit(r15);     // Catch: Throwable -> L57
        goto L13
    L54:
        r15.emitting = false;     // Catch: Throwable -> L57
        monitor-exit(r15);     // Catch: Throwable -> L57
        return;
    L19:
        r11 = false;
        goto L20
    L14:
        r15.index = null;
    }

    public final void setFirst(FlowableReplay$Node r10) {
        set(r10);
    }

    public final void trimHead() {
        FlowableReplay$Node r10 = get();
        if (r10.value == null) goto L6;
        FlowableReplay$Node r11 = new FlowableReplay$Node(null, 0);
        r11.lazySet(r10.get());
        set(r11);
        return;
    }

    public void truncate() {
    }

    public void truncateFinal() {
        trimHead();
    }
}
