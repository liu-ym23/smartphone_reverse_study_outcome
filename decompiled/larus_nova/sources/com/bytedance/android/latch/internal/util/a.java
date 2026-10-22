package com.bytedance.android.latch.internal.util;

import io.reactivex.disposables.Disposable;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes44.dex */
public abstract class a implements Disposable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicBoolean f58387a;

    public abstract void j();

    @Override // io.reactivex.disposables.Disposable
    public final void dispose() {
        if (this.f58387a.getAndSet(true) == false) goto L5;
        return;
    L5:
        j();
    }

    @Override // io.reactivex.disposables.Disposable
    public final boolean isDisposed() {
        return this.f58387a.get();
    }

    public a() {
        this.f58387a = new AtomicBoolean(false);
    }
}
