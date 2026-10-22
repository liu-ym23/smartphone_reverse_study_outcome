package com.bytedance.retrofit2;

/* JADX INFO: loaded from: classes.dex */
public interface Callback<T> {
    void onFailure(Call<T> r10, Throwable r11);

    void onResponse(Call<T> r10, f6.f r11);
}
