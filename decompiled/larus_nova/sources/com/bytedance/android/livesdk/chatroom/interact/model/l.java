package com.bytedance.android.livesdk.chatroom.interact.model;

import com.bytedance.android.ec.model.response.anchorv3.PromotionProductPrivilegesStruct;
import com.bytedance.android.livesdkapi.depend.model.live.BattleRivalTag;
import com.bytedance.android.livesdkapi.depend.model.live.BattleStarActivityGradeMedal;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.tools.pbadapter.annotation.IgnoreProtoFieldCheck;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@ProtoMessage("webcast.data.BattleRival")
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b@\u0010AR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR*\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R*\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0013\u001a\u0004\b\u0019\u0010\u0015\"\u0004\b\u001a\u0010\u0017R*\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u0013\u001a\u0004\b\u001c\u0010\u0015\"\u0004\b\u001d\u0010\u0017R$\u0010\u001f\u001a\u0004\u0018\u00010\u001e8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\"\u0010&\u001a\u00020%8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b&\u0010(\"\u0004\b)\u0010*R$\u0010,\u001a\u0004\u0018\u00010+8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R$\u00103\u001a\u0004\u0018\u0001028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b3\u00104\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\"\u0010:\u001a\u0002098\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?¨\u0006B"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/interact/model/l;", "", "Lcom/bytedance/android/livesdkapi/depend/model/live/Room;", "room", "Lcom/bytedance/android/livesdkapi/depend/model/live/Room;", "getRoom", "()Lcom/bytedance/android/livesdkapi/depend/model/live/Room;", "setRoom", "(Lcom/bytedance/android/livesdkapi/depend/model/live/Room;)V", "Lcom/bytedance/android/livesdk/chatroom/interact/model/RivalExtraInfo;", "rivalExtraInfo", "Lcom/bytedance/android/livesdk/chatroom/interact/model/RivalExtraInfo;", "getRivalExtraInfo", "()Lcom/bytedance/android/livesdk/chatroom/interact/model/RivalExtraInfo;", "setRivalExtraInfo", "(Lcom/bytedance/android/livesdk/chatroom/interact/model/RivalExtraInfo;)V", "", "Lcom/bytedance/android/livesdkapi/depend/model/live/BattleRivalTag;", "battleRivalTagList", "Ljava/util/List;", "getBattleRivalTagList", "()Ljava/util/List;", "setBattleRivalTagList", "(Ljava/util/List;)V", "roomTags", "getRoomTags", "setRoomTags", "userTags", "getUserTags", "setUserTags", "", "recommendReason", "Ljava/lang/String;", "getRecommendReason", "()Ljava/lang/String;", "setRecommendReason", "(Ljava/lang/String;)V", "", "isHightLight", "Z", "()Z", "setHightLight", "(Z)V", "Lcom/bytedance/android/livesdk/chatroom/interact/model/m;", "inviteButton", "Lcom/bytedance/android/livesdk/chatroom/interact/model/m;", "getInviteButton", "()Lcom/bytedance/android/livesdk/chatroom/interact/model/m;", "setInviteButton", "(Lcom/bytedance/android/livesdk/chatroom/interact/model/m;)V", "Lcom/bytedance/android/livesdkapi/depend/model/live/BattleStarActivityGradeMedal;", "activityMedal", "Lcom/bytedance/android/livesdkapi/depend/model/live/BattleStarActivityGradeMedal;", "getActivityMedal", "()Lcom/bytedance/android/livesdkapi/depend/model/live/BattleStarActivityGradeMedal;", "setActivityMedal", "(Lcom/bytedance/android/livesdkapi/depend/model/live/BattleStarActivityGradeMedal;)V", "", "serverInviteType", "I", "getServerInviteType", "()I", "setServerInviteType", "(I)V", "<init>", "()V", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class l implements vh7.h {

    @SerializedName("activity_medal")
    protected BattleStarActivityGradeMedal activityMedal;

    @SerializedName(PromotionProductPrivilegesStruct.TAGS)
    protected List<BattleRivalTag> battleRivalTagList;

    @SerializedName("invite_button")
    protected m inviteButton;

    @SerializedName("is_highlight")
    protected boolean isHightLight;

    @SerializedName("recommend_reason")
    protected String recommendReason;

    @SerializedName("extra_info")
    protected RivalExtraInfo rivalExtraInfo;

    @IgnoreProtoFieldCheck
    @SerializedName("room")
    protected Room room;

    @SerializedName("room_tags")
    protected List<BattleRivalTag> roomTags;

    @SerializedName("from_server_invite_type")
    protected int serverInviteType;

    @SerializedName("user_tags")
    protected List<BattleRivalTag> userTags;

    public l() {
    }

    public l(am3.g r100) {
        this.battleRivalTagList = new ArrayList();
        this.roomTags = new ArrayList();
        this.userTags = new ArrayList();
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L20;
        if (r102 != 13) goto L7;
        this.serverInviteType = r100.i();
        goto L3
    L7:
        switch(r102) {
            case 1: goto L18;
            case 2: goto L17;
            case 3: goto L15;
            case 4: goto L14;
            case 5: goto L13;
            case 6: goto L12;
            case 7: goto L11;
            case 8: goto L10;
            case 9: goto L9;
            default: goto L8;
        };
    L9:
        this.inviteButton = new m(r100);
        goto L3
    L10:
        this.activityMedal = new BattleStarActivityGradeMedal(r100);
        goto L3
    L11:
        this.isHightLight = am3.h.a(r100);
        goto L3
    L12:
        this.recommendReason = am3.h.c(r100);
        goto L3
    L13:
        List<BattleRivalTag> r103 = this.userTags;
        BattleRivalTag r104 = new BattleRivalTag(r100);
    L16:
        r103.add(r104);
        goto L3
    L14:
        r103 = this.roomTags;
        r104 = new BattleRivalTag(r100);
        goto L16
    L15:
        r103 = this.battleRivalTagList;
        r104 = new BattleRivalTag(r100);
        goto L16
    L17:
        this.rivalExtraInfo = new RivalExtraInfo(r100);
        goto L3
    L18:
        this.room = new Room(r100);
        goto L3
    L8:
        am3.h.e(r100);
        goto L3
    L20:
        r100.d(r101);
    }
}
