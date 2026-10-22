package com.bytedance.retrofit2;

/* JADX INFO: loaded from: classes.dex */
public interface Call<T> extends Cloneable {
    void cancel();

    Call<T> clone();

    void enqueue(Callback<T> r10);

    f6.f execute() throws Exception;

    boolean isCanceled();

    boolean isExecuted();

    g6.b request();
}
