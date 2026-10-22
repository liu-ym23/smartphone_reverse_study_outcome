package io.reactivex.internal.operators.observable;

import androidx.lifecycle.p;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes4.dex */
final class ObservableReplay$ReplayObserver<T> extends AtomicReference<Disposable> implements Observer<T>, Disposable {
    static final ObservableReplay$InnerDisposable[] EMPTY = null;
    static final ObservableReplay$InnerDisposable[] TERMINATED = null;
    private static final long serialVersionUID = -533785617179540163L;
    final ObservableReplay$ReplayBuffer<T> buffer;
    boolean done;
    final AtomicReference<ObservableReplay$InnerDisposable[]> observers;
    final AtomicBoolean shouldConnect;

    static {
        EMPTY = new ObservableReplay$InnerDisposable[0];
        TERMINATED = new ObservableReplay$InnerDisposable[0];
    }

    public ObservableReplay$ReplayObserver(ObservableReplay$ReplayBuffer<T> r10) {
        this.buffer = r10;
        this.observers = new AtomicReference(EMPTY);
        this.shouldConnect = new AtomicBoolean();
    }

    public boolean add(ObservableReplay$InnerDisposable<T> r10) {
    L2:
        ObservableReplay$InnerDisposable[] r11 = this.observers.get();
        if (r11 == TERMINATED) goto L4;
        int r12 = r11.length;
        ObservableReplay$InnerDisposable[] r13 = new ObservableReplay$InnerDisposable[r12 + 1];
        System.arraycopy(r11, 0, r13, 0, r12);
        r13[r12] = r10;
        if (p.a(this.observers, r11, r13) == false) goto L2;
        return true;
    L4:
        return false;
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        this.observers.set(TERMINATED);
        DisposableHelper.dispose(this);
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        if (this.observers.get() != TERMINATED) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // io.reactivex.Observer
    public void onComplete() {
        if (this.done == true) goto L6;
        this.done = true;
        this.buffer.complete();
        replayFinal();
        return;
    }

    @Override // io.reactivex.Observer
    public void onError(Throwable r10) {
        if (this.done == true) goto L5;
        this.done = true;
        this.buffer.error(r10);
        replayFinal();
        return;
    L5:
        qf.a.e(r10);
    }

    @Override // io.reactivex.Observer
    public void onNext(T r10) {
        if (this.done == true) goto L6;
        this.buffer.next(r10);
        replay();
        return;
    }

    @Override // io.reactivex.Observer
    public void onSubscribe(Disposable r10) {
        if (DisposableHelper.setOnce(this, r10) == false) goto L6;
        replay();
        return;
    }

    public void remove(ObservableReplay$InnerDisposable<T> r10) {
    L2:
        ObservableReplay$InnerDisposable[] r11 = this.observers.get();
        int r12 = r11.length;
        if (r12 == 0) goto L4;
        int r13 = 0;
    L6:
        if (r13 >= r12) goto L11;
        if (r11[r13].equals(r10) == true) goto L12;
        r13 = r13 + 1;
    L12:
        if (r13 < 0) goto L13;
        if (r12 != 1) goto L17;
        ObservableReplay$InnerDisposable[] r14 = EMPTY;
    L19:
        if (p.a(this.observers, r11, r14) == false) goto L2;
        return;
    L17:
        ObservableReplay$InnerDisposable[] r15 = new ObservableReplay$InnerDisposable[r12 - 1];
        System.arraycopy(r11, 0, r15, 0, r13);
        System.arraycopy(r11, r13 + 1, r15, r13, (r12 - r13) - 1);
        r14 = r15;
        goto L19
    L13:
        return;
    L11:
        r13 = -1;
        goto L12
    }

    public void replay() {
        ObservableReplay$InnerDisposable<T>[] r10 = this.observers.get();
        int r11 = r10.length;
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L5;
        ObservableReplay$InnerDisposable<T> r13 = r10[r12];
        this.buffer.replay(r13);
        r12 = r12 + 1;
        goto L3
    }

    public void replayFinal() {
        ObservableReplay$InnerDisposable<T>[] r10 = this.observers.getAndSet(TERMINATED);
        int r11 = r10.length;
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L5;
        ObservableReplay$InnerDisposable<T> r13 = r10[r12];
        this.buffer.replay(r13);
        r12 = r12 + 1;
        goto L3
    }
}
