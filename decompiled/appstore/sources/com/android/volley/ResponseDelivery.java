package com.android.volley;

/* JADX INFO: loaded from: classes.dex */
public interface ResponseDelivery {
    void postError(Request<?> r10, VolleyError r11);

    void postResponse(Request<?> r10, Response<?> r11);

    void postResponse(Request<?> r10, Response<?> r11, Runnable r12);
}
