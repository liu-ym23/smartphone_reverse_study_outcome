package com.bytedance.android.livesdkapi.depend.model.live;

import am3.g;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@ProtoMessage("webcast.data.RoomUserAttr")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001e\u0010\f\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR \u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0015\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\b¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/RoomUserAttr;", "", "()V", "adminFlag", "", "getAdminFlag", "()J", "setAdminFlag", "(J)V", "rank", "getRank", "setRank", "roomId", "getRoomId", "setRoomId", "roomIdStr", "", "getRoomIdStr", "()Ljava/lang/String;", "setRoomIdStr", "(Ljava/lang/String;)V", "silenceFlag", "getSilenceFlag", "setSilenceFlag", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class RoomUserAttr implements h {

    @SerializedName("admin_flag")
    protected long adminFlag;

    @SerializedName("rank")
    protected long rank;

    @SerializedName("room_id")
    protected long roomId;

    @SerializedName("room_id_str")
    protected String roomIdStr;

    @SerializedName("silence_flag")
    protected long silenceFlag;

    public RoomUserAttr() {
    }

    public final long getAdminFlag() {
        return this.adminFlag;
    }

    public final long getRank() {
        return this.rank;
    }

    public final long getRoomId() {
        return this.roomId;
    }

    public final String getRoomIdStr() {
        return this.roomIdStr;
    }

    public final long getSilenceFlag() {
        return this.silenceFlag;
    }

    public RoomUserAttr(g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L21;
        if (r102 != 1) goto L8;
        this.roomId = r100.j();
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.roomIdStr = am3.h.c(r100);
        goto L3
    L10:
        if (r102 != 3) goto L12;
        this.silenceFlag = r100.j();
        goto L3
    L12:
        if (r102 != 4) goto L14;
        this.adminFlag = r100.j();
        goto L3
    L14:
        if (r102 != 5) goto L15;
        this.rank = r100.j();
        goto L3
    L15:
        am3.h.e(r100);
        goto L3
    L21:
        r100.d(r101);
    }

    public final void setAdminFlag(long r100) {
        this.adminFlag = r100;
    }

    public final void setRank(long r100) {
        this.rank = r100;
    }

    public final void setRoomId(long r100) {
        this.roomId = r100;
    }

    public final void setRoomIdStr(String r100) {
        this.roomIdStr = r100;
    }

    public final void setSilenceFlag(long r100) {
        this.silenceFlag = r100;
    }
}
