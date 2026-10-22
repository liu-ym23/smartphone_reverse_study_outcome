package com.bytedanceos.common.core.ui.presenter;

/* JADX INFO: loaded from: classes2.dex */
public interface IView<X, Y> {
    void onRequestError(Throwable r10);

    void onUpdateView(int r10, X r11, Y r12);
}
