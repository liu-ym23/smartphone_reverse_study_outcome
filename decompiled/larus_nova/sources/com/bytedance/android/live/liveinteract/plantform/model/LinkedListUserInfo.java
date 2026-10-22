package com.bytedance.android.live.liveinteract.plantform.model;

import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes46.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
public class LinkedListUserInfo extends FlexModelBase<o> implements o {

    @SerializedName("current_time")
    public long currentTime;

    @SerializedName("expected_leave_time")
    public long expectLeaveTime;

    @SerializedName("join_channel_time")
    public long joinChannelTime;

    public LinkedListUserInfo() {
        super(o.class);
    }

    public String toString() {
        return "LinkedListUserInfo{joinChannelTime=" + this.joinChannelTime + ", expectLeaveTime=" + this.expectLeaveTime + ", currentTime=" + this.currentTime + '}';
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.o
    public long getCurrentTime() {
        return this.currentTime;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.o
    public long getExpectLeaveTime() {
        return this.expectLeaveTime;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.o
    public long getJoinChannelTime() {
        return this.joinChannelTime;
    }

    public boolean same(LinkedListUserInfo r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if (this.joinChannelTime == r100.joinChannelTime) goto L8;
        return false;
    L8:
        if (this.expectLeaveTime == r100.expectLeaveTime) goto L10;
        return false;
    L10:
        if (this.currentTime != r100.currentTime) goto L15;
        return true;
    L15:
        return false;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.o
    public void setCurrentTime(long r100) {
        this.currentTime = r100;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.o
    public void setExpectLeaveTime(long r100) {
        this.expectLeaveTime = r100;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.model.o
    public void setJoinChannelTime(long r100) {
        this.joinChannelTime = r100;
    }

    public static LinkedListUserInfo copy(long r100, long r101, long r102) {
        LinkedListUserInfo r103 = new LinkedListUserInfo();
        r103.joinChannelTime = r100;
        r103.expectLeaveTime = r101;
        r103.currentTime = r102;
        return r103;
    }
}
