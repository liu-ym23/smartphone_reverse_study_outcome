package org.apache.http.pool;

/* JADX INFO: loaded from: classes4.dex */
public interface ConnPoolControl<T> {
    int getDefaultMaxPerRoute();

    int getMaxPerRoute(T r10);

    int getMaxTotal();

    PoolStats getStats(T r10);

    PoolStats getTotalStats();

    void setDefaultMaxPerRoute(int r10);

    void setMaxPerRoute(T r10, int r11);

    void setMaxTotal(int r10);
}
