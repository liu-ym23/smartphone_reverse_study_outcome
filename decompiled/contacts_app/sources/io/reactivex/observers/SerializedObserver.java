package io.reactivex.observers;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.AppendOnlyLinkedArrayList;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.plugins.RxJavaPlugins;

/* JADX INFO: loaded from: classes4.dex */
public final class SerializedObserver<T> implements Observer<T>, Disposable {
    static final int QUEUE_LINK_SIZE = 4;
    final boolean delayError;
    volatile boolean done;
    final Observer<? super T> downstream;
    boolean emitting;
    AppendOnlyLinkedArrayList<Object> queue;
    Disposable upstream;

    public SerializedObserver(Observer<? super T> r2) {
        this(r2, false);
    }

    public SerializedObserver(Observer<? super T> r1, boolean r2) {
        this.downstream = r1;
        this.delayError = r2;
    }

    @Override // io.reactivex.Observer
    public void onSubscribe(Disposable r2) {
        if (DisposableHelper.validate(this.upstream, r2) == false) goto L6;
        this.upstream = r2;
        this.downstream.onSubscribe(this);
        return;
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        this.upstream.dispose();
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return this.upstream.isDisposed();
    }

    @Override // io.reactivex.Observer
    public void onNext(T r3) {
        if (this.done == false) goto L5;
        return;
    L5:
        if (r3 != null) goto L8;
        this.upstream.dispose();
        onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
        return;
    L8:
        monitor-enter(this);
    L25:
        th = move-exception;
        throw th;
    L10:
        if (this.done == false) goto L14;
        monitor-exit(this);     // Catch: Throwable -> L25
        return;
    L14:
        if (this.emitting == false) goto L21;
        AppendOnlyLinkedArrayList<Object> r0 = this.queue;     // Catch: Throwable -> L25
        if (r0 != null) goto L18;
        r0 = new AppendOnlyLinkedArrayList(4);     // Catch: Throwable -> L25
        this.queue = r0;     // Catch: Throwable -> L25
    L18:
        r0.add(NotificationLite.next(r3));     // Catch: Throwable -> L25
        monitor-exit(this);     // Catch: Throwable -> L25
        return;
    L21:
        this.emitting = true;     // Catch: Throwable -> L25
        monitor-exit(this);     // Catch: Throwable -> L25
        this.downstream.onNext(r3);
        emitLoop();
    }

    @Override // io.reactivex.Observer
    public void onError(Throwable r3) {
        if (this.done == false) goto L6;
        RxJavaPlugins.onError(r3);
        return;
    L6:
        monitor-enter(this);
        boolean r1 = true;
        if (this.done == false) goto L11;
    L22:
        monitor-exit(this);     // Catch: Throwable -> L28
        if (r1 == false) goto L26;
        RxJavaPlugins.onError(r3);
        return;
    L26:
        this.downstream.onError(r3);
        return;
    L11:
        if (this.emitting == false) goto L21;
        this.done = true;     // Catch: Throwable -> L28
        AppendOnlyLinkedArrayList<Object> r0 = this.queue;     // Catch: Throwable -> L28
        if (r0 != null) goto L15;
        r0 = new AppendOnlyLinkedArrayList(4);     // Catch: Throwable -> L28
        this.queue = r0;     // Catch: Throwable -> L28
    L15:
        Object r4 = NotificationLite.error(r3);     // Catch: Throwable -> L28
        if (this.delayError == false) goto L18;
        r0.add(r4);     // Catch: Throwable -> L28
    L19:
        monitor-exit(this);     // Catch: Throwable -> L28
        return;
    L18:
        r0.setFirst(r4);     // Catch: Throwable -> L28
        goto L19
    L21:
        this.done = true;     // Catch: Throwable -> L28
        this.emitting = true;     // Catch: Throwable -> L28
        r1 = false;
    L28:
        th = move-exception;
        throw th;
    }

    @Override // io.reactivex.Observer
    public void onComplete() {
        if (this.done == false) goto L5;
        return;
    L5:
        monitor-enter(this);
    L22:
        th = move-exception;
        throw th;
    L7:
        if (this.done == false) goto L11;
        monitor-exit(this);     // Catch: Throwable -> L22
        return;
    L11:
        if (this.emitting == false) goto L18;
        AppendOnlyLinkedArrayList<Object> r0 = this.queue;     // Catch: Throwable -> L22
        if (r0 != null) goto L15;
        r0 = new AppendOnlyLinkedArrayList(4);     // Catch: Throwable -> L22
        this.queue = r0;     // Catch: Throwable -> L22
    L15:
        r0.add(NotificationLite.complete());     // Catch: Throwable -> L22
        monitor-exit(this);     // Catch: Throwable -> L22
        return;
    L18:
        this.done = true;     // Catch: Throwable -> L22
        this.emitting = true;     // Catch: Throwable -> L22
        monitor-exit(this);     // Catch: Throwable -> L22
        this.downstream.onComplete();
    }

    void emitLoop() {
    L2:
        monitor-enter(this);
        AppendOnlyLinkedArrayList<Object> r0 = this.queue;     // Catch: Throwable -> L13
        if (r0 == null) goto L5;
        this.queue = null;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        if (r0.accept(this.downstream) == false) goto L2;
        return;
    L5:
        this.emitting = false;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return;
    L13:
        th = move-exception;
        throw th;
    }
}
