package com.bytedance.android.live.core.utils.rxutils;

import io.reactivex.disposables.Disposable;

/* JADX INFO: loaded from: classes45.dex */
public final class x implements Disposable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Disposable f66381a;

    @Override // io.reactivex.disposables.Disposable
    public final void dispose() {
        Disposable r100 = this.f66381a;
        if (r100 == null) goto L6;
        r100.dispose();
        return;
    }

    @Override // io.reactivex.disposables.Disposable
    public final boolean isDisposed() {
        Disposable r100 = this.f66381a;
        if (r100 != null) goto L5;
    L8:
        return true;
    L5:
        if (r100.isDisposed() == true) goto L8;
        return false;
    }

    public x() {
        this.f66381a = null;
    }

    public final void b(Disposable r100) {
        Disposable r101 = this.f66381a;
        if (r101 != null) goto L5;
    L9:
        this.f66381a = r100;
        return;
    L5:
        if (r101.isDisposed() == true) goto L9;
        Disposable r102 = this.f66381a;
        if (r102 == null) goto L9;
        r102.dispose();
        goto L9
    }
}
