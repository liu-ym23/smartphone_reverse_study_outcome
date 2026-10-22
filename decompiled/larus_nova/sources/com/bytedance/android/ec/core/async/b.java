package com.bytedance.android.ec.core.async;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/* JADX INFO: loaded from: classes43.dex */
public interface b {
    Disposable add(Disposable r100);

    void clearDisposable();

    CompositeDisposable compositeDisposable();

    void remove(Disposable r100);
}
