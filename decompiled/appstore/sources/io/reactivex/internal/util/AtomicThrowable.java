package io.reactivex.internal.util;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes4.dex */
public final class AtomicThrowable extends AtomicReference<Throwable> {
    private static final long serialVersionUID = 3949248817947090603L;

    public AtomicThrowable() {
    }

    public boolean addThrowable(Throwable r10) {
        return ExceptionHelper.a(this, r10);
    }

    public boolean isTerminated() {
        if (get() != ExceptionHelper.f20726a) goto L5;
        return true;
    L5:
        return false;
    }

    public Throwable terminate() {
        return ExceptionHelper.b(this);
    }
}
