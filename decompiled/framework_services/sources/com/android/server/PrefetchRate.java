package com.android.server;

import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public class PrefetchRate implements Serializable {
    private int killedCount;
    private String packageName;
    private int prefetchCount;
    private int successCount;

    public PrefetchRate(String packageName) {
        this.packageName = packageName;
        this.prefetchCount = 0;
        this.successCount = 0;
    }

    public void notifyPrefetched() {
        this.prefetchCount++;
    }

    public void notifySuccessStart() {
        this.successCount++;
    }

    public void notifyKilledPrefetch() {
        this.killedCount++;
    }

    public void clear() {
        this.prefetchCount = 0;
        this.successCount = 0;
        this.killedCount = 0;
    }

    public String toString() {
        return this.packageName + "_" + this.prefetchCount + "_" + this.successCount + "_" + this.killedCount;
    }
}
