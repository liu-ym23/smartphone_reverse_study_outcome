package com.bytedance.android.live.browser.jsbridge.event;

/* JADX INFO: loaded from: classes45.dex */
public class RoomTopRightBannerEvent {
    public static final int BANNER_STATUS_COLLAPSE = 1;
    public static final int BANNER_STATUS_EXPAND = 0;
    private long animationTime;
    private int status;

    public RoomTopRightBannerEvent() {
    }

    public String toString() {
        return "RoomTopRightBannerEvent{animationTime=" + this.animationTime + ", status=" + this.status + '}';
    }

    public long getAnimationTime() {
        return this.animationTime;
    }

    public int getStatus() {
        return this.status;
    }

    public void setAnimationTime(long r100) {
        this.animationTime = r100;
    }

    public void setStatus(int r100) {
        this.status = r100;
    }
}
