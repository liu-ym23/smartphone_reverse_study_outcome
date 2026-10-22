package com.bytedance.android.live.core.utils.rxutils.autodispose;

import io.reactivex.disposables.Disposable;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes45.dex */
final enum AutoDisposableHelper extends Enum<AutoDisposableHelper> implements Disposable {
    public static final AutoDisposableHelper DISPOSED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AutoDisposableHelper[] f66291a = null;

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        return true;
    }

    static {
        AutoDisposableHelper r100 = new AutoDisposableHelper();
        DISPOSED = r100;
        f66291a = new AutoDisposableHelper[]{r100};
    }

    public AutoDisposableHelper() {
        super("DISPOSED", 0);
    }

    public static AutoDisposableHelper[] values() {
        return (AutoDisposableHelper[]) f66291a.clone();
    }

    public static boolean dispose(AtomicReference<Disposable> r100) {
        Disposable r101 = r100.get();
        AutoDisposableHelper r102 = DISPOSED;
        if (r101 == r102) goto L10;
        Disposable r103 = r100.getAndSet(r102);
        if (r103 == r102) goto L13;
        if (r103 == null) goto L12;
        r103.dispose();
        return true;
    L12:
        return true;
    L13:
        return false;
    L10:
        return false;
    }

    public static AutoDisposableHelper valueOf(String r100) {
        return (AutoDisposableHelper) r27.a.a(AutoDisposableHelper.class, r100);
    }
}
