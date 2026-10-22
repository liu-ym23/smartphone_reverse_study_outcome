package com.bytedance.android.livesdkapi.depend.model.live;

import am3.g;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import com.huawei.hms.push.constant.RemoteMessageConst;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@ProtoMessage("webcast.api.battle.RecordResponse.BattleRecord")
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR \u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0015\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\f\"\u0004\b\u0017\u0010\u000eR\u001e\u0010\u0018\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\bR\u001e\u0010\u001b\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\f\"\u0004\b\u001d\u0010\u000eR \u0010\u001e\u001a\u0004\u0018\u00010\u001f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001e\u0010$\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\f\"\u0004\b&\u0010\u000eR \u0010'\u001a\u0004\u0018\u00010(8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001c\u0010-\u001a\u0004\u0018\u00010(X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010*\"\u0004\b/\u0010,¨\u00060"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/BattleRecord;", "", "()V", "battleResultType", "", "getBattleResultType", "()I", "setBattleResultType", "(I)V", "battleStartTime", "", "getBattleStartTime", "()J", "setBattleStartTime", "(J)V", "battleUserInfo", "Lcom/bytedance/android/livesdkapi/depend/model/live/BattleUserInfo;", "getBattleUserInfo", "()Lcom/bytedance/android/livesdkapi/depend/model/live/BattleUserInfo;", "setBattleUserInfo", "(Lcom/bytedance/android/livesdkapi/depend/model/live/BattleUserInfo;)V", RemoteMessageConst.Notification.CHANNEL_ID, "getChannelId", "setChannelId", "matchType", "getMatchType", "setMatchType", "ownHistoricRoomId", "getOwnHistoricRoomId", "setOwnHistoricRoomId", "rivalLivingRoom", "Lcom/bytedance/android/livesdkapi/depend/model/live/Room;", "getRivalLivingRoom", "()Lcom/bytedance/android/livesdkapi/depend/model/live/Room;", "setRivalLivingRoom", "(Lcom/bytedance/android/livesdkapi/depend/model/live/Room;)V", "rivalLivingRoomId", "getRivalLivingRoomId", "setRivalLivingRoomId", "rivalOpenId", "", "getRivalOpenId", "()Ljava/lang/String;", "setRivalOpenId", "(Ljava/lang/String;)V", "signExtra", "getSignExtra", "setSignExtra", "livebase_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class BattleRecord implements h {

    @SerializedName("battle_result_type")
    protected int battleResultType;

    @SerializedName("battle_start_time")
    protected long battleStartTime;

    @SerializedName("user_info")
    protected BattleUserInfo battleUserInfo;

    @SerializedName("channel_id")
    protected long channelId;

    @SerializedName(ILiveRoomPlayFragmentConstant.EXTRA_LOG_MATCH_TYPE)
    protected int matchType;

    @SerializedName("own_historic_room_id")
    protected long ownHistoricRoomId;

    @SerializedName("rival_living_room")
    protected Room rivalLivingRoom;

    @SerializedName("rival_living_room_id")
    protected long rivalLivingRoomId;

    @SerializedName("rival_open_id")
    protected String rivalOpenId;
    private String signExtra;

    public BattleRecord() {
    }

    public final int getBattleResultType() {
        return this.battleResultType;
    }

    public final long getBattleStartTime() {
        return this.battleStartTime;
    }

    public final BattleUserInfo getBattleUserInfo() {
        return this.battleUserInfo;
    }

    public final long getChannelId() {
        return this.channelId;
    }

    public final int getMatchType() {
        return this.matchType;
    }

    public final long getOwnHistoricRoomId() {
        return this.ownHistoricRoomId;
    }

    public final Room getRivalLivingRoom() {
        return this.rivalLivingRoom;
    }

    public final long getRivalLivingRoomId() {
        return this.rivalLivingRoomId;
    }

    public final String getRivalOpenId() {
        return this.rivalOpenId;
    }

    public final String getSignExtra() {
        return this.signExtra;
    }

    public BattleRecord(g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L20;
        if (r102 != 9) goto L8;
        this.rivalLivingRoom = new Room(r100);
        goto L3
    L8:
        if (r102 != 5000) goto L9;
        this.rivalOpenId = am3.h.c(r100);
        goto L3
    L9:
        switch(r102) {
            case 1: goto L17;
            case 2: goto L16;
            case 3: goto L15;
            case 4: goto L14;
            case 5: goto L13;
            case 6: goto L12;
            case 7: goto L11;
            default: goto L10;
        };
    L11:
        this.matchType = (int) r100.j();
        goto L3
    L12:
        this.channelId = r100.j();
        goto L3
    L13:
        this.ownHistoricRoomId = r100.j();
        goto L3
    L14:
        this.battleResultType = r100.i();
        goto L3
    L15:
        this.rivalLivingRoomId = r100.j();
        goto L3
    L16:
        this.battleStartTime = r100.j();
        goto L3
    L17:
        this.battleUserInfo = new BattleUserInfo(r100);
        goto L3
    L10:
        am3.h.e(r100);
        goto L3
    L20:
        r100.d(r101);
    }

    public final void setBattleResultType(int r100) {
        this.battleResultType = r100;
    }

    public final void setBattleStartTime(long r100) {
        this.battleStartTime = r100;
    }

    public final void setBattleUserInfo(BattleUserInfo r100) {
        this.battleUserInfo = r100;
    }

    public final void setChannelId(long r100) {
        this.channelId = r100;
    }

    public final void setMatchType(int r100) {
        this.matchType = r100;
    }

    public final void setOwnHistoricRoomId(long r100) {
        this.ownHistoricRoomId = r100;
    }

    public final void setRivalLivingRoom(Room r100) {
        this.rivalLivingRoom = r100;
    }

    public final void setRivalLivingRoomId(long r100) {
        this.rivalLivingRoomId = r100;
    }

    public final void setRivalOpenId(String r100) {
        this.rivalOpenId = r100;
    }

    public final void setSignExtra(String r100) {
        this.signExtra = r100;
    }
}
