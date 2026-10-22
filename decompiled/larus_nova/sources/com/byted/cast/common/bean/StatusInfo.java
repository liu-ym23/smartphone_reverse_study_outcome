package com.byted.cast.common.bean;

import android.text.TextUtils;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes39.dex */
public class StatusInfo {

    @SerializedName("duration")
    private long duration;
    private MediaInfo mediaInfo;

    @SerializedName("position")
    private long position;

    @SerializedName("speed")
    private float speed;
    private String status;

    public boolean isPlaying() {
        return TextUtils.equals(this.status, "PLAYING");
    }

    public String toString() {
        return "StatusInfo{status=" + this.status + ", duration=" + this.duration + ", position=" + this.position + ", speed=" + this.speed + '}';
    }

    public StatusInfo() {
        this.speed = 1.0f;
    }

    public long getDuration() {
        return this.duration;
    }

    public MediaInfo getMediaInfo() {
        return this.mediaInfo;
    }

    public long getPosition() {
        return this.position;
    }

    public float getSpeed() {
        return this.speed;
    }

    public String getStatus() {
        return this.status;
    }

    public void setDuration(long r100) {
        this.duration = r100;
    }

    public void setMediaInfo(MediaInfo r100) {
        this.mediaInfo = r100;
    }

    public void setPosition(long r100) {
        this.position = r100;
    }

    public void setSpeed(float r100) {
        this.speed = r100;
    }

    public void setStatus(String r100) {
        this.status = r100;
    }
}
