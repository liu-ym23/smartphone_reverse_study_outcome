package rx.internal.operators;

import java.util.Iterator;
import java.util.concurrent.atomic.AtomicLong;
import rx.Producer;
import rx.Subscriber;

/* JADX INFO: loaded from: classes4.dex */
final class OnSubscribeFromIterable$IterableProducer<T> extends AtomicLong implements Producer {
    private static final long serialVersionUID = -8730475647105475802L;
    private final Iterator<? extends T> it;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final Subscriber f24156o;

    public OnSubscribeFromIterable$IterableProducer(Subscriber r10, Iterator<? extends T> r11) {
        this.f24156o = r10;
        this.it = r11;
    }

    public void fastPath() {
        Subscriber r10 = this.f24156o;
        Iterator<? extends T> r11 = this.it;
    L4:
        if (r10.isUnsubscribed() == true) goto L5;
        r10.onNext(r11.next());
        if (r10.isUnsubscribed() == true) goto L9;
        if (r11.hasNext() == true) goto L4;
        if (r10.isUnsubscribed() == true) goto L30;
        r10.onCompleted();
        return;
    L30:
        return;
    L16:
        th = move-exception;
        rx.exceptions.a.f(th, r10);
        return;
    L9:
        return;
    L19:
        th = move-exception;
        rx.exceptions.a.f(th, r10);
        return;
    }

    @Override // rx.Producer
    public void request(long r10) {
        if (get() != Long.MAX_VALUE) goto L6;
        return;
    L6:
        if (r10 != Long.MAX_VALUE) goto L11;
        if (compareAndSet(0, Long.MAX_VALUE) == false) goto L11;
        fastPath();
        return;
    L11:
        if (r10 > 0) goto L13;
        return;
    L13:
        if (a.b(this, r10) != 0) goto L18;
        slowPath(r10);
        return;
    }

    public void slowPath(long r10) {
        Subscriber r11 = this.f24156o;
        Iterator<? extends T> r12 = this.it;
    L3:
        long r13 = 0;
    L5:
        if (r13 != r10) goto L7;
        r10 = get();
        if (r13 != r10) goto L5;
        r10 = a.c(this, r13);
        if (r10 != 0) goto L3;
        return;
    L7:
        if (r11.isUnsubscribed() == true) goto L8;
        r11.onNext(r12.next());
        if (r11.isUnsubscribed() == true) goto L12;
        if (r12.hasNext() == false) goto L16;
        r13 = r13 + 1;
        goto L5
    L16:
        if (r11.isUnsubscribed() == true) goto L46;
        r11.onCompleted();
        return;
    L46:
        return;
    L20:
        th = move-exception;
        rx.exceptions.a.f(th, r11);
        return;
    L12:
        return;
    L23:
        th = move-exception;
        rx.exceptions.a.f(th, r11);
        return;
    }
}
