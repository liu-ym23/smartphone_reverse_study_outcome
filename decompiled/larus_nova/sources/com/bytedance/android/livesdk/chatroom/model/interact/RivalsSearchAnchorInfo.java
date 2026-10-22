package com.bytedance.android.livesdk.chatroom.model.interact;

import com.bytedance.android.ec.model.response.anchorv3.PromotionProductPrivilegesStruct;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.livesdk.chatroom.interact.model.RivalExtraInfo;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.tencent.connect.common.Constants;
import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
@ProtoMessage("webcast.api.battle.RivalsSearchResponse.AnchorInfo")
@JsonAdapter(FlexModelJsonAdapter.class)
public class RivalsSearchAnchorInfo extends FlexModelBase<l1> implements l1 {

    @SerializedName("avatar_thumb")
    public ImageModel avatarThumb;

    @SerializedName("battle_attached_info")
    public String battleAttachedInfo;

    @SerializedName("custom_verify")
    public String customVerify;

    @SerializedName("display_id")
    public String displayId;

    @SerializedName("fans_num")
    public long fansNum;

    @SerializedName("follow_type")
    public int followType;

    @SerializedName("gender")
    public int gender;

    @SerializedName("link_status")
    public long linkStatus;

    @SerializedName("link_text")
    public String linkText;

    @SerializedName("nick_name")
    public String nickName;

    @SerializedName("extra_info")
    public RivalExtraInfo rivalExtraInfo;

    @SerializedName("room")
    public Room room;

    @SerializedName("room_id")
    public long roomId;

    @SerializedName("sec_user_id")
    public String secUserId;

    @SerializedName("short_id")
    public long shortId;

    @SerializedName("sign_extra")
    public String signExtra;

    @SerializedName("status_reason")
    public String statusReason;

    @SerializedName(PromotionProductPrivilegesStruct.TAGS)
    public List<BattleRivalTag> tags;

    @SerializedName("user_id")
    long userId;

    @SerializedName(Constants.JumpUrlConstants.URL_KEY_OPENID)
    String userOpenId;

    public RivalsSearchAnchorInfo() {
        super(l1.class);
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.interact.l1
    public String getUserId() {
        return com.bytedance.android.live.base.model.user.n0.e(Long.valueOf(this.userId), this.userOpenId);
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.interact.l1
    public py.k getAvatarThumb() {
        return this.avatarThumb;
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.interact.l1
    public String getBattleAttachedInfo() {
        return this.battleAttachedInfo;
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.interact.l1
    public String getCustomVerify() {
        return this.customVerify;
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.interact.l1
    public String getDisplayId() {
        return this.displayId;
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.interact.l1
    public long getFansNum() {
        return this.fansNum;
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.interact.l1
    public int getFollowType() {
        return this.followType;
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.interact.l1
    public int getGender() {
        return this.gender;
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.interact.l1
    public long getLinkStatus() {
        return this.linkStatus;
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.interact.l1
    public String getLinkText() {
        return this.linkText;
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.interact.l1
    public String getNickName() {
        return this.nickName;
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.interact.l1
    public com.bytedance.android.livesdk.chatroom.interact.model.z getRivalExtraInfo() {
        return this.rivalExtraInfo;
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.interact.l1
    public IRoom getRoom() {
        return this.room;
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.interact.l1
    public long getRoomId() {
        return this.roomId;
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.interact.l1
    public String getSecUserId() {
        return this.secUserId;
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.interact.l1
    public long getShortId() {
        return this.shortId;
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.interact.l1
    public String getSignExtra() {
        return this.signExtra;
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.interact.l1
    public String getStatusReason() {
        return this.statusReason;
    }

    @Override // com.bytedance.android.livesdk.chatroom.model.interact.l1
    public List<q> getTags() {
        return this.tags;
    }

    public String getUserOpenId() {
        return this.userOpenId;
    }

    public void setAvatarThumb(ImageModel r100) {
        this.avatarThumb = r100;
    }

    public void setCustomVerify(String r100) {
        this.customVerify = r100;
    }

    public void setDisplayId(String r100) {
        this.displayId = r100;
    }

    public void setFansNum(int r100) {
        this.fansNum = r100;
    }

    public void setLinkStatus(int r100) {
        this.linkStatus = r100;
    }

    public void setNickName(String r100) {
        this.nickName = r100;
    }

    public void setRoom(Room r100) {
        this.room = r100;
    }

    public void setRoomId(int r100) {
        this.roomId = r100;
    }

    public void setShortId(int r100) {
        this.shortId = r100;
    }

    public void setUserId(String r100) {
        this.userOpenId = r100;
    }

    public void setUserOpenId(String r100) {
        this.userOpenId = r100;
    }
}
