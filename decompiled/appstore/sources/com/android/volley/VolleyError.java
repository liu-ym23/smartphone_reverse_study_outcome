package com.android.volley;

/* JADX INFO: loaded from: classes.dex */
public class VolleyError extends Exception {
    public final NetworkResponse networkResponse;
    private long networkTimeMs;

    public VolleyError() {
        this.networkResponse = null;
    }

    public long getNetworkTimeMs() {
        return this.networkTimeMs;
    }

    public void setNetworkTimeMs(long r10) {
        this.networkTimeMs = r10;
    }

    public VolleyError(NetworkResponse r10) {
        this.networkResponse = r10;
    }

    public VolleyError(String r10) {
        super(r10);
        this.networkResponse = null;
    }

    public VolleyError(String r10, Throwable r11) {
        super(r10, r11);
        this.networkResponse = null;
    }

    public VolleyError(Throwable r10) {
        super(r10);
        this.networkResponse = null;
    }
}
