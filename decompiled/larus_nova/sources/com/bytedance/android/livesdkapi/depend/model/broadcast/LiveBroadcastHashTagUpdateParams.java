package com.bytedance.android.livesdkapi.depend.model.broadcast;

/* JADX INFO: loaded from: classes12.dex */
public class LiveBroadcastHashTagUpdateParams {
    private final long newHashTagId;
    private final String newHashTagName;
    private final long oldHashTagId;
    private final long roomId;

    public long getNewHashTagId() {
        return this.newHashTagId;
    }

    public String getNewHashTagName() {
        return this.newHashTagName;
    }

    public long getOldHashTagId() {
        return this.oldHashTagId;
    }

    public long getRoomId() {
        return this.roomId;
    }

    public LiveBroadcastHashTagUpdateParams(long r100, long r101, long r102, String r103) {
        this.roomId = r100;
        this.oldHashTagId = r101;
        this.newHashTagId = r102;
        this.newHashTagName = r103;
    }
}
