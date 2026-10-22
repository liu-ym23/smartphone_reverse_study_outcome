package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeSource;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiPredicate;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes4.dex */
final class MaybeEqualSingle$EqualCoordinator<T> extends AtomicInteger implements Disposable {
    final SingleObserver<? super Boolean> downstream;
    final BiPredicate<? super T, ? super T> isEqual;
    final MaybeEqualSingle$EqualObserver<T> observer1;
    final MaybeEqualSingle$EqualObserver<T> observer2;

    public MaybeEqualSingle$EqualCoordinator(SingleObserver<? super Boolean> r10, BiPredicate<? super T, ? super T> r11) {
        super(2);
        this.downstream = r10;
        this.isEqual = r11;
        this.observer1 = new MaybeEqualSingle$EqualObserver(this);
        this.observer2 = new MaybeEqualSingle$EqualObserver(this);
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        this.observer1.dispose();
        this.observer2.dispose();
    }

    public void done() {
        if (decrementAndGet() != 0) goto L21;
        Object r10 = this.observer1.value;
        Object r11 = this.observer2.value;
        if (r10 == null) goto L12;
        if (r11 == null) goto L12;
        boolean r12 = this.isEqual.test(r10, r11);     // Catch: Throwable -> L9
        this.downstream.onSuccess(Boolean.valueOf(r12));
        return;
    L9:
        th = move-exception;
        io.reactivex.exceptions.a.a(th);
        this.downstream.onError(th);
        return;
    L12:
        SingleObserver<? super Boolean> r13 = this.downstream;
        if (r10 != null) goto L16;
        if (r11 != null) goto L16;
        boolean r14 = true;
    L17:
        r13.onSuccess(Boolean.valueOf(r14));
        return;
    L16:
        r14 = false;
        goto L17
    }

    public void error(MaybeEqualSingle$EqualObserver<T> r10, Throwable r11) {
        if (getAndSet(0) <= 0) goto L9;
        MaybeEqualSingle$EqualObserver<T> r12 = this.observer1;
        if (r10 != r12) goto L7;
        this.observer2.dispose();
    L8:
        this.downstream.onError(r11);
        return;
    L7:
        r12.dispose();
        goto L8
    L9:
        qf.a.e(r11);
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return DisposableHelper.isDisposed(this.observer1.get());
    }

    public void subscribe(MaybeSource<? extends T> r10, MaybeSource<? extends T> r11) {
        r10.subscribe(this.observer1);
        r11.subscribe(this.observer2);
    }
}
