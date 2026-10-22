package com.bytedance.android.livesdk.viewmodel;

import java.util.List;

/* JADX INFO: loaded from: classes11.dex */
public interface e<T> {
    void onError(Throwable r100);

    void onLoading();

    void onSuccess(List<T> r100, boolean r101);
}
