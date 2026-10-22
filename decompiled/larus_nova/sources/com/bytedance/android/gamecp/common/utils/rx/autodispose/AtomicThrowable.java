package com.bytedance.android.gamecp.common.utils.rx.autodispose;

import io.reactivex.exceptions.CompositeException;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes44.dex */
final class AtomicThrowable extends AtomicReference<Throwable> {
    public Throwable terminate() {
        Throwable r100 = ExceptionHelper.f57283a;
        Throwable r101 = get();
        Throwable r102 = ExceptionHelper.f57283a;
        if (r101 != r102) goto L5;
        return r101;
    L5:
        return getAndSet(r102);
    }

    public AtomicThrowable() {
    }

    public boolean addThrowable(Throwable r100) {
        Throwable r101 = ExceptionHelper.f57283a;
    L3:
        Throwable r102 = get();
        boolean r103 = false;
        if (r102 == ExceptionHelper.f57283a) goto L26;
        if (r102 != null) goto L9;
        Throwable r104 = r100;
    L11:
        if (compareAndSet(r102, r104) == true) goto L12;
        if (get() == r102) goto L11;
    L15:
        if (r103 == false) goto L3;
        return true;
    L12:
        r103 = true;
        goto L15
    L9:
        r104 = new CompositeException(new Throwable[]{r102, r100});
        goto L11
    L26:
        return false;
    }
}
