package com.zyql.ai.selector.entity;

/* loaded from: classes4.dex */
public class MediaExtraInfo {
    private long duration;
    private int height;
    private int width;

    public long getDuration() {
        return this.duration;
    }

    public int getHeight() {
        return this.height;
    }

    public int getWidth() {
        return this.width;
    }

    public void setDuration(long j10) {
        this.duration = j10;
    }

    public void setHeight(int i10) {
        this.height = i10;
    }

    public void setWidth(int i10) {
        this.width = i10;
    }

    public String toString() {
        return "MediaExtraInfo{width=" + this.width + ", height=" + this.height + ", duration=" + this.duration + '}';
    }
}
