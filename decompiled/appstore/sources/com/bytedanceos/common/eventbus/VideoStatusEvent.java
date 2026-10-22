package com.bytedanceos.common.eventbus;

/* JADX INFO: loaded from: classes2.dex */
public class VideoStatusEvent extends BaseEvent {
    public static final int VIDEO_STATUS_RESUME = 1;
    public static final int VIDEO_STATUS_STOP = 2;
    private int mVideoStatus;

    public VideoStatusEvent() {
    }

    public int getVideoStatus() {
        return this.mVideoStatus;
    }

    public void setVideoStatus(int r10) {
        this.mVideoStatus = r10;
    }
}
