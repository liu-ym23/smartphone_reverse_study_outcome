package com.byted.cast.common.bean;

/* JADX INFO: loaded from: classes39.dex */
public class PrivateStateConfig {
    private int queryStateErrorRetryCount;
    private int queryStateInterval;
    private boolean shouldStartStateTask;

    public PrivateStateConfig() {
        this.queryStateInterval = 1000;
        this.queryStateErrorRetryCount = 10;
        this.shouldStartStateTask = true;
    }

    public int getQueryStateErrorRetryCount() {
        return this.queryStateErrorRetryCount;
    }

    public int getQueryStateInterval() {
        return this.queryStateInterval;
    }

    public boolean isShouldStartStateTask() {
        return this.shouldStartStateTask;
    }

    public void setQueryStateErrorRetryCount(int r100) {
        this.queryStateErrorRetryCount = r100;
    }

    public void setQueryStateInterval(int r100) {
        this.queryStateInterval = r100;
    }

    public void setShouldStartStateTask(boolean r100) {
        this.shouldStartStateTask = r100;
    }
}
