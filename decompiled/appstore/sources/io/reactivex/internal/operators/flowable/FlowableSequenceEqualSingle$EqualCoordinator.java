package io.reactivex.internal.operators.flowable;

import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiPredicate;
import io.reactivex.internal.fuseable.SimpleQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;
import org.reactivestreams.Publisher;

/* JADX INFO: loaded from: classes4.dex */
final class FlowableSequenceEqualSingle$EqualCoordinator<T> extends AtomicInteger implements Disposable, FlowableSequenceEqual$EqualCoordinatorHelper {
    private static final long serialVersionUID = -6178010334400373240L;
    final BiPredicate<? super T, ? super T> comparer;
    final SingleObserver<? super Boolean> downstream;
    final AtomicThrowable error;
    final FlowableSequenceEqual$EqualSubscriber<T> first;
    final FlowableSequenceEqual$EqualSubscriber<T> second;

    /* JADX INFO: renamed from: v1, reason: collision with root package name */
    T f20630v1;

    /* JADX INFO: renamed from: v2, reason: collision with root package name */
    T f20631v2;

    public FlowableSequenceEqualSingle$EqualCoordinator(SingleObserver<? super Boolean> r10, int r11, BiPredicate<? super T, ? super T> r12) {
        this.downstream = r10;
        this.comparer = r12;
        this.first = new FlowableSequenceEqual$EqualSubscriber(this, r11);
        this.second = new FlowableSequenceEqual$EqualSubscriber(this, r11);
        this.error = new AtomicThrowable();
    }

    public void cancelAndClear() {
        this.first.cancel();
        this.first.clear();
        this.second.cancel();
        this.second.clear();
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        this.first.cancel();
        this.second.cancel();
        if (getAndIncrement() != 0) goto L6;
        this.first.clear();
        this.second.clear();
        return;
    }

    @Override // io.reactivex.internal.operators.flowable.FlowableSequenceEqual$EqualCoordinatorHelper
    public void drain() {
        if (getAndIncrement() == 0) goto L5;
        return;
    L5:
        int r10 = 1;
    L6:
        SimpleQueue<T> r11 = this.first.queue;
        SimpleQueue<T> r12 = this.second.queue;
        if (r11 == null) goto L60;
        if (r12 == null) goto L60;
    L10:
        if (isDisposed() == true) goto L11;
        if (this.error.get() != null) goto L15;
        boolean r13 = this.first.done;
        T r14 = this.f20630v1;
        if (r14 == null) goto L74;
    L24:
        boolean r15 = false;
        if (r14 != null) goto L27;
        boolean r16 = true;
    L28:
        boolean r17 = this.second.done;
        T r18 = this.f20631v2;
        if (r18 == null) goto L72;
    L35:
        if (r18 != null) goto L37;
        r15 = true;
    L37:
        if (r13 == false) goto L43;
        if (r17 == false) goto L43;
        if (r16 == false) goto L43;
        if (r15 == false) goto L43;
        this.downstream.onSuccess(Boolean.TRUE);
        return;
    L43:
        if (r13 == false) goto L48;
        if (r17 == false) goto L48;
        if (r16 == r15) goto L48;
        cancelAndClear();
        this.downstream.onSuccess(Boolean.FALSE);
        return;
    L48:
        if (r16 == true) goto L67;
        if (r15 == true) goto L67;
        if (this.comparer.test(r14, r18) == false) goto L53;
        this.f20630v1 = null;
        this.f20631v2 = null;
        this.first.request();
        this.second.request();
        goto L10
    L53:
        cancelAndClear();
        this.downstream.onSuccess(Boolean.FALSE);
        return;
    L56:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        cancelAndClear();
        this.error.addThrowable(th);
        this.downstream.onError(this.error.terminate());
        return;
    L67:
        r10 = addAndGet(-r10);
        if (r10 != 0) goto L6;
        return;
    L72:
        r18 = r12.poll();     // Catch: Throwable -> L32
        this.f20631v2 = r18;
    L32:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        cancelAndClear();
        this.error.addThrowable(th);
        this.downstream.onError(this.error.terminate());
        return;
    L27:
        r16 = false;
        goto L28
    L74:
        r14 = r11.poll();     // Catch: Throwable -> L21
        this.f20630v1 = r14;
    L21:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        cancelAndClear();
        this.error.addThrowable(th);
        this.downstream.onError(this.error.terminate());
        return;
    L15:
        cancelAndClear();
        this.downstream.onError(this.error.terminate());
        return;
    L11:
        this.first.clear();
        this.second.clear();
        return;
    L60:
        if (isDisposed() == true) goto L61;
        if (this.error.get() == null) goto L67;
        cancelAndClear();
        this.downstream.onError(this.error.terminate());
        return;
    L61:
        this.first.clear();
        this.second.clear();
    }

    @Override // io.reactivex.internal.operators.flowable.FlowableSequenceEqual$EqualCoordinatorHelper
    public void innerError(Throwable r10) {
        if (this.error.addThrowable(r10) == false) goto L5;
        drain();
        return;
    L5:
        qf.a.e(r10);
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        if (this.first.get() != SubscriptionHelper.CANCELLED) goto L5;
        return true;
    L5:
        return false;
    }

    public void subscribe(Publisher<? extends T> r10, Publisher<? extends T> r11) {
        r10.subscribe(this.first);
        r11.subscribe(this.second);
    }
}
