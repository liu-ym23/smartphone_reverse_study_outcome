package io.reactivex.internal.operators.observable;

import io.reactivex.Observer;
import io.reactivex.internal.util.NotificationLite;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes4.dex */
final class ObservableReplay$UnboundedReplayBuffer<T> extends ArrayList<Object> implements ObservableReplay$ReplayBuffer<T> {
    private static final long serialVersionUID = 7063189396499112664L;
    volatile int size;

    public ObservableReplay$UnboundedReplayBuffer(int r10) {
        super(r10);
    }

    @Override // io.reactivex.internal.operators.observable.ObservableReplay$ReplayBuffer
    public void complete() {
        add(NotificationLite.complete());
        this.size++;
    }

    @Override // io.reactivex.internal.operators.observable.ObservableReplay$ReplayBuffer
    public void error(Throwable r10) {
        add(NotificationLite.error(r10));
        this.size++;
    }

    @Override // io.reactivex.internal.operators.observable.ObservableReplay$ReplayBuffer
    public void next(T r10) {
        add(NotificationLite.next(r10));
        this.size++;
    }

    @Override // io.reactivex.internal.operators.observable.ObservableReplay$ReplayBuffer
    public void replay(ObservableReplay$InnerDisposable<T> r10) {
        if (r10.getAndIncrement() == 0) goto L5;
        return;
    L5:
        Observer<? super T> r11 = r10.child;
        int r12 = 1;
    L7:
        if (r10.isDisposed() == true) goto L8;
        int r13 = this.size;
        Integer r14 = (Integer) r10.index();
        if (r14 == null) goto L12;
        int r15 = r14.intValue();
    L13:
        if (r15 >= r13) goto L21;
        if (NotificationLite.accept(get(r15), r11) == true) goto L16;
        if (r10.isDisposed() == true) goto L19;
        r15 = r15 + 1;
        goto L13
    L19:
        return;
    L16:
        return;
    L21:
        r10.index = Integer.valueOf(r15);
        r12 = r10.addAndGet(-r12);
        if (r12 != 0) goto L7;
        return;
    L12:
        r15 = 0;
        goto L13
    }
}
