package io.reactivex.internal.disposables;

import io.reactivex.disposables.Disposable;
import java.util.concurrent.atomic.AtomicReferenceArray;

/* JADX INFO: loaded from: classes4.dex */
public final class ArrayCompositeDisposable extends AtomicReferenceArray<Disposable> implements Disposable {
    private static final long serialVersionUID = 2746389416410565408L;

    public ArrayCompositeDisposable(int r10) {
        super(r10);
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        int r10 = 0;
        if (get(0) == DisposableHelper.DISPOSED) goto L13;
        int r11 = length();
    L5:
        if (r10 >= r11) goto L19;
        Disposable r12 = get(r10);
        DisposableHelper r13 = DisposableHelper.DISPOSED;
        if (r12 == r13) goto L12;
        Disposable r14 = getAndSet(r10, r13);
        if (r14 == r13) goto L12;
        if (r14 == null) goto L12;
        r14.dispose();
    L12:
        r10 = r10 + 1;
        goto L5
    L19:
        return;
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        if (get(0) != DisposableHelper.DISPOSED) goto L6;
        return true;
    L6:
        return false;
    }

    public Disposable replaceResource(int r10, Disposable r11) {
    L2:
        Disposable r12 = get(r10);
        if (r12 == DisposableHelper.DISPOSED) goto L4;
        if (compareAndSet(r10, r12, r11) == false) goto L2;
        return r12;
    L4:
        r11.dispose();
        return null;
    }

    public boolean setResource(int r10, Disposable r11) {
    L2:
        Disposable r12 = get(r10);
        if (r12 == DisposableHelper.DISPOSED) goto L4;
        if (compareAndSet(r10, r12, r11) == false) goto L2;
        if (r12 == null) goto L15;
        r12.dispose();
        return true;
    L15:
        return true;
    L4:
        r11.dispose();
        return false;
    }
}
