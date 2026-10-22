package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.util.NotificationLite;
import java.util.ArrayList;
import org.reactivestreams.Subscriber;

/* JADX INFO: loaded from: classes4.dex */
final class FlowableReplay$UnboundedReplayBuffer<T> extends ArrayList<Object> implements FlowableReplay$ReplayBuffer<T> {
    private static final long serialVersionUID = 7063189396499112664L;
    volatile int size;

    public FlowableReplay$UnboundedReplayBuffer(int r10) {
        super(r10);
    }

    @Override // io.reactivex.internal.operators.flowable.FlowableReplay$ReplayBuffer
    public void complete() {
        add(NotificationLite.complete());
        this.size++;
    }

    @Override // io.reactivex.internal.operators.flowable.FlowableReplay$ReplayBuffer
    public void error(Throwable r10) {
        add(NotificationLite.error(r10));
        this.size++;
    }

    @Override // io.reactivex.internal.operators.flowable.FlowableReplay$ReplayBuffer
    public void next(T r10) {
        add(NotificationLite.next(r10));
        this.size++;
    }

    @Override // io.reactivex.internal.operators.flowable.FlowableReplay$ReplayBuffer
    public void replay(FlowableReplay$InnerSubscription<T> r15) {
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
        Subscriber<? super T> r10 = r15.child;
    L14:
        if (r15.isDisposed() == true) goto L15;
        int r11 = this.size;
        Integer r12 = (Integer) r15.index();
        if (r12 == null) goto L19;
        int r13 = r12.intValue();
    L20:
        long r14 = r15.get();
        long r16 = r14;
        long r17 = 0;
    L22:
        if (r16 == 0) goto L40;
        if (r13 >= r11) goto L40;
        Object r18 = get(r13);
        if (NotificationLite.accept(r18, r10) == true) goto L27;
        if (r15.isDisposed() == true) goto L30;
        r13 = r13 + 1;
        r16 = r16 - 1;
        r17 = r17 + 1;
        goto L22
    L30:
        return;
    L27:
        return;
    L32:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        r15.dispose();
        if (NotificationLite.isError(r18) == false) goto L36;
        return;
    L36:
        if (NotificationLite.isComplete(r18) == true) goto L71;
        r10.onError(th);
        return;
    L71:
        return;
    L40:
        if (r17 == 0) goto L44;
        r15.index = Integer.valueOf(r13);
        if (r14 == Long.MAX_VALUE) goto L44;
        r15.produced(r17);
    L44:
        monitor-enter(r15);
    L50:
        th = move-exception;
        throw th;
    L46:
        if (r15.missed == false) goto L47;
        r15.missed = false;     // Catch: Throwable -> L50
        monitor-exit(r15);     // Catch: Throwable -> L50
        goto L14
    L47:
        r15.emitting = false;     // Catch: Throwable -> L50
        monitor-exit(r15);     // Catch: Throwable -> L50
        return;
    L19:
        r13 = 0;
        goto L20
    }
}
