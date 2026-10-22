package com.bytedance.android.livesdk.chatroom.model.interact;

import com.bytedance.android.ec.model.response.anchorv3.PromotionProductPrivilegesStruct;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
public interface l1 extends vh7.c<l1> {
    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = "avatar_thumb")
    py.k getAvatarThumb();

    @FieldName(name = "battle_attached_info")
    String getBattleAttachedInfo();

    @FieldName(name = "custom_verify")
    String getCustomVerify();

    @FieldName(name = "display_id")
    String getDisplayId();

    @FieldName(name = "fans_num")
    long getFansNum();

    @FieldName(name = "follow_type")
    int getFollowType();

    @FieldName(name = "gender")
    int getGender();

    @FieldName(name = "link_status")
    long getLinkStatus();

    @FieldName(name = "link_text")
    String getLinkText();

    @FieldName(name = "nick_name")
    String getNickName();

    @FieldName(name = "extra_info")
    com.bytedance.android.livesdk.chatroom.interact.model.z getRivalExtraInfo();

    @FieldName(name = "room")
    IRoom getRoom();

    @FieldName(name = "room_id")
    long getRoomId();

    @FieldName(name = "sec_user_id")
    String getSecUserId();

    @FieldName(name = "short_id")
    long getShortId();

    @FieldName(name = "sign_extra")
    String getSignExtra();

    @FieldName(name = "status_reason")
    String getStatusReason();

    @FieldName(name = PromotionProductPrivilegesStruct.TAGS)
    List<q> getTags();

    String getUserId();
}
