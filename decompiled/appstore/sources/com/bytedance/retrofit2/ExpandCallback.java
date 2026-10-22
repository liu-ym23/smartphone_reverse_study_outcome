package com.bytedance.retrofit2;

/* JADX INFO: loaded from: classes.dex */
public interface ExpandCallback<T> extends Callback<T> {
    void onAsyncPreRequest(f6.d r10);

    void onAsyncResponse(Call<T> r10, f6.f r11);
}
