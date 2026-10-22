package com.android.volley;

/* JADX INFO: loaded from: classes.dex */
public class Response<T> {
    public final Cache.Entry cacheEntry;
    public final VolleyError error;
    public boolean intermediate;
    public final T result;

    public interface ErrorListener {
        void onErrorResponse(VolleyError r10);
    }

    public interface Listener<T> {
        void onResponse(T r10);
    }

    private Response(T r10, Cache.Entry r11) {
        this.intermediate = false;
        this.result = r10;
        this.cacheEntry = r11;
        this.error = null;
    }

    public static <T> Response<T> error(VolleyError r10) {
        return new Response(r10);
    }

    public static <T> Response<T> success(T r10, Cache.Entry r11) {
        return new Response(r10, r11);
    }

    public boolean isSuccess() {
        if (this.error != null) goto L5;
        return true;
    L5:
        return false;
    }

    private Response(VolleyError r10) {
        this.intermediate = false;
        this.result = null;
        this.cacheEntry = null;
        this.error = r10;
    }
}
