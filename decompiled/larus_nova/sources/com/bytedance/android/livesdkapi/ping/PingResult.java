package com.bytedance.android.livesdkapi.ping;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes12.dex */
public class PingResult {

    @SerializedName("mosaic_status")
    private int mosaicStatus;

    @SerializedName("next_ping")
    private long nextPingInterval;

    @SerializedName("room_id")
    private long roomId;

    @SerializedName("room_status")
    private int roomStatus;

    public PingResult() {
    }

    public String toString() {
        return "PingResult{roomStatus=" + this.roomStatus + ", roomId=" + this.roomId + ", mosaicStatus=" + this.mosaicStatus + ", nextPingInterval=" + this.nextPingInterval + '}';
    }

    public int getMosaicStatus() {
        return this.mosaicStatus;
    }

    public long getNextPingInterval() {
        return this.nextPingInterval;
    }

    public long getRoomId() {
        return this.roomId;
    }

    public int getRoomStatus() {
        return this.roomStatus;
    }

    public void setMosaicStatus(int r100) {
        this.mosaicStatus = r100;
    }

    public void setRoomId(long r100) {
        this.roomId = r100;
    }

    public void setRoomStatus(int r100) {
        this.roomStatus = r100;
    }
}
