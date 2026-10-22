package io.reactivex.internal.util;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes4.dex */
public final class AtomicThrowable extends AtomicReference<Throwable> {
    private static final long serialVersionUID = 3949248817947090603L;

    public AtomicThrowable() {
    }

    public boolean addThrowable(Throwable r1) {
        return ExceptionHelper.addThrowable(this, r1);
    }

    public Throwable terminate() {
        return ExceptionHelper.terminate(this);
    }

    public boolean isTerminated() {
        if (get() != ExceptionHelper.TERMINATED) goto L5;
        return true;
    L5:
        return false;
    }
}
