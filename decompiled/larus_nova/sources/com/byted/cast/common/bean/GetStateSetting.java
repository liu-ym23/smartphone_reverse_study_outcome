package com.byted.cast.common.bean;

/* JADX INFO: loaded from: classes39.dex */
public class GetStateSetting {
    private int firstQueryStateDelayTime;
    private int queryStateErrorRetryCount;
    private int queryStateInterval;
    private int queryStopStateRetryCount;
    private boolean shouldStopStateTaskBeforePlay;

    public GetStateSetting() {
        this.firstQueryStateDelayTime = 500;
        this.queryStateInterval = 1000;
        this.queryStateErrorRetryCount = 10;
        this.queryStopStateRetryCount = 10;
        this.shouldStopStateTaskBeforePlay = true;
    }

    public int getFirstQueryStateDelayTime() {
        return this.firstQueryStateDelayTime;
    }

    public int getQueryStateErrorRetryCount() {
        return this.queryStateErrorRetryCount;
    }

    public int getQueryStateInterval() {
        return this.queryStateInterval;
    }

    public int getQueryStopStateRetryCount() {
        return this.queryStopStateRetryCount;
    }

    public boolean isShouldStopStateTaskBeforePlay() {
        return this.shouldStopStateTaskBeforePlay;
    }

    public void setFirstQueryStateDelayTime(int r100) {
        this.firstQueryStateDelayTime = r100;
    }

    public void setQueryStateErrorRetryCount(int r100) {
        this.queryStateErrorRetryCount = r100;
    }

    public void setQueryStateInterval(int r100) {
        this.queryStateInterval = r100;
    }

    public void setQueryStopStateRetryCount(int r100) {
        this.queryStopStateRetryCount = r100;
    }

    public void setShouldStopStateTaskBeforePlay(boolean r100) {
        this.shouldStopStateTaskBeforePlay = r100;
    }
}
