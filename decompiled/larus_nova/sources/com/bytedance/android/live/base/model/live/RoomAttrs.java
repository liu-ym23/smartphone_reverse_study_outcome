package com.bytedance.android.live.base.model.live;

import com.bytedance.android.live.GsonHelper;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes45.dex */
public class RoomAttrs implements IRoomAttrs {

    @SerializedName("admin_flag")
    private int adminFlag;

    @SerializedName("fanticket_this_room")
    public long currentRoomContribution;

    @SerializedName("rank_this_room")
    public int currentRoomRank;

    @SerializedName("rank")
    public int rank;

    @SerializedName("silence_flag")
    private int silenceFlag;

    public RoomAttrs() {
    }

    public int hashCode() {
        return (((this.silenceFlag * 31) + this.adminFlag) * 31) + this.rank;
    }

    @Override // com.bytedance.android.live.base.model.live.IRoomAttrs
    public int getAdminFlag() {
        return this.adminFlag;
    }

    @Override // com.bytedance.android.live.base.model.live.IRoomAttrs
    public int getRank() {
        return this.rank;
    }

    @Override // com.bytedance.android.live.base.model.live.IRoomAttrs
    public int getSilenceFlag() {
        return this.silenceFlag;
    }

    public static RoomAttrs from(IRoomAttrs r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        if ((r100 instanceof RoomAttrs) == false) goto L9;
        Gson r101 = GsonHelper.get();
        return (RoomAttrs) GsonProtectorUtils.fromJson(r101, GsonProtectorUtils.toJson(r101, r100), RoomAttrs.class);
    L9:
        RoomAttrs r102 = new RoomAttrs();
        r102.initWith(r100);
        return r102;
    }

    private void initWith(IRoomAttrs r100) {
        this.silenceFlag = r100.getSilenceFlag();
        this.adminFlag = r100.getAdminFlag();
        this.rank = r100.getRank();
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L8;
    L21:
        return false;
    L8:
        if (getClass() != r100.getClass()) goto L21;
        RoomAttrs r101 = (RoomAttrs) r100;
        if (this.silenceFlag == r101.silenceFlag) goto L14;
        return false;
    L14:
        if (this.adminFlag == r101.adminFlag) goto L17;
        return false;
    L17:
        if (this.rank == r101.rank) goto L22;
        return false;
    L22:
        return true;
    }

    public void setAdminFlag(int r100) {
        this.adminFlag = r100;
    }

    public void setRank(int r100) {
        this.rank = r100;
    }

    public void setSilenceFlag(int r100) {
        this.silenceFlag = r100;
    }
}
