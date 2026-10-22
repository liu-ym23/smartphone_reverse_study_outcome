package com.bytedance.android.anya.internal;

import io.reactivex.disposables.Disposable;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes43.dex */
public abstract class j implements Disposable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicBoolean f41693a;

    public abstract void k();

    @Override // io.reactivex.disposables.Disposable
    public final void dispose() {
        if (this.f41693a.getAndSet(true) == false) goto L5;
        return;
    L5:
        k();
    }

    @Override // io.reactivex.disposables.Disposable
    public final boolean isDisposed() {
        return this.f41693a.get();
    }

    public j() {
        this.f41693a = new AtomicBoolean(false);
    }
}
