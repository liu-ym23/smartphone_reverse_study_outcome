package io.reactivex.internal.disposables;

import io.reactivex.disposables.Disposable;

/* JADX INFO: loaded from: classes4.dex */
public interface DisposableContainer {
    boolean add(Disposable r10);

    boolean delete(Disposable r10);

    boolean remove(Disposable r10);
}
