package io.reactivex.internal.disposables;

import io.reactivex.CompletableObserver;
import io.reactivex.MaybeObserver;
import io.reactivex.Observer;
import io.reactivex.SingleObserver;
import io.reactivex.annotations.Nullable;
import io.reactivex.internal.fuseable.QueueDisposable;

/* JADX INFO: loaded from: classes4.dex */
public final enum EmptyDisposable extends Enum<EmptyDisposable> implements QueueDisposable<Object> {
    private static final /* synthetic */ EmptyDisposable[] $VALUES = null;
    public static final EmptyDisposable INSTANCE = null;
    public static final EmptyDisposable NEVER = null;

    static {
        EmptyDisposable r10 = new EmptyDisposable("INSTANCE", 0);
        INSTANCE = r10;
        EmptyDisposable r11 = new EmptyDisposable("NEVER", 1);
        NEVER = r11;
        $VALUES = new EmptyDisposable[]{r10, r11};
    }

    private EmptyDisposable(String r10, int r11) {
        super(r10, r11);
    }

    public static void complete(Observer<?> r10) {
        r10.onSubscribe(INSTANCE);
        r10.onComplete();
    }

    public static void error(Throwable r10, Observer<?> r11) {
        r11.onSubscribe(INSTANCE);
        r11.onError(r10);
    }

    public static EmptyDisposable valueOf(String r10) {
        return (EmptyDisposable) Enum.valueOf(EmptyDisposable.class, r10);
    }

    public static EmptyDisposable[] values() {
        return (EmptyDisposable[]) $VALUES.clone();
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public void clear() {
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        if (this != INSTANCE) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public boolean isEmpty() {
        return true;
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public boolean offer(Object r10) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    @Nullable
    public Object poll() throws Exception {
        return null;
    }

    @Override // io.reactivex.internal.fuseable.QueueFuseable
    public int requestFusion(int r10) {
        return r10 & 2;
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public boolean offer(Object r10, Object r11) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    public static void complete(MaybeObserver<?> r10) {
        r10.onSubscribe(INSTANCE);
        r10.onComplete();
    }

    public static void error(Throwable r10, CompletableObserver r11) {
        r11.onSubscribe(INSTANCE);
        r11.onError(r10);
    }

    public static void complete(CompletableObserver r10) {
        r10.onSubscribe(INSTANCE);
        r10.onComplete();
    }

    public static void error(Throwable r10, SingleObserver<?> r11) {
        r11.onSubscribe(INSTANCE);
        r11.onError(r10);
    }

    public static void error(Throwable r10, MaybeObserver<?> r11) {
        r11.onSubscribe(INSTANCE);
        r11.onError(r10);
    }
}
