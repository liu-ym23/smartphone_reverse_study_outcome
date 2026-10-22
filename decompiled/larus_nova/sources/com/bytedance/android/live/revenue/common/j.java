package com.bytedance.android.live.revenue.common;

import io.reactivex.disposables.Disposable;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes47.dex */
public abstract class j implements Disposable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicBoolean f90839a;

    public abstract void d();

    @Override // io.reactivex.disposables.Disposable
    public final void dispose() {
        if (this.f90839a.getAndSet(true) == false) goto L5;
        return;
    L5:
        d();
    }

    @Override // io.reactivex.disposables.Disposable
    public final boolean isDisposed() {
        return this.f90839a.get();
    }

    public j() {
        this.f90839a = new AtomicBoolean(false);
    }
}
