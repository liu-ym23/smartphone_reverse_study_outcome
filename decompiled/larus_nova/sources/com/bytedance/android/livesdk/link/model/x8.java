package com.bytedance.android.livesdk.link.model;

import com.bytedance.android.ec.model.response.anchorv3.PromotionProductPrivilegesStruct;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.tencent.connect.common.Constants;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0011\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u001a\u0010\u0007\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004R\u001c\u0010\n\u001a\u0004\u0018\u00010\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\t\u0010\u0006\u001a\u0004\b\b\u0010\u0004R\u001a\u0010\u000f\u001a\u00020\u000b8&X§\u0004¢\u0006\f\u0012\u0004\b\u000e\u0010\u0006\u001a\u0004\b\f\u0010\rR\"\u0010\u0015\u001a\n\u0018\u00010\u0010j\u0004\u0018\u0001`\u00118&X§\u0004¢\u0006\f\u0012\u0004\b\u0014\u0010\u0006\u001a\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0018\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0017\u0010\u0006\u001a\u0004\b\u0016\u0010\u0004R\u001a\u0010\u001b\u001a\u00020\u000b8&X§\u0004¢\u0006\f\u0012\u0004\b\u001a\u0010\u0006\u001a\u0004\b\u0019\u0010\rR\u001a\u0010\u001e\u001a\u00020\u000b8&X§\u0004¢\u0006\f\u0012\u0004\b\u001d\u0010\u0006\u001a\u0004\b\u001c\u0010\rR\u001a\u0010!\u001a\u00020\u000b8&X§\u0004¢\u0006\f\u0012\u0004\b \u0010\u0006\u001a\u0004\b\u001f\u0010\rR\u001a\u0010$\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b#\u0010\u0006\u001a\u0004\b\"\u0010\u0004R\u001a\u0010'\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b&\u0010\u0006\u001a\u0004\b%\u0010\u0004R\u001a\u0010*\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b)\u0010\u0006\u001a\u0004\b(\u0010\u0004R.\u00101\u001a\u0016\u0012\u0004\u0012\u00020,\u0018\u00010+j\n\u0012\u0004\u0012\u00020,\u0018\u0001`-8&X§\u0004¢\u0006\f\u0012\u0004\b0\u0010\u0006\u001a\u0004\b.\u0010/R\u001e\u00107\u001a\u000602j\u0002`38VX\u0097\u0004¢\u0006\f\u0012\u0004\b6\u0010\u0006\u001a\u0004\b4\u00105R\u001c\u0010<\u001a\u0004\u0018\u0001088&X§\u0004¢\u0006\f\u0012\u0004\b;\u0010\u0006\u001a\u0004\b9\u0010:R\u001a\u0010A\u001a\u00020=8&X§\u0004¢\u0006\f\u0012\u0004\b@\u0010\u0006\u001a\u0004\b>\u0010?R\u001a\u0010D\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\bC\u0010\u0006\u001a\u0004\bB\u0010\u0004R\u001c\u0010I\u001a\u0004\u0018\u00010E8&X§\u0004¢\u0006\f\u0012\u0004\bH\u0010\u0006\u001a\u0004\bF\u0010GR\u001a\u0010L\u001a\u00020\u000b8&X§\u0004¢\u0006\f\u0012\u0004\bK\u0010\u0006\u001a\u0004\bJ\u0010\rR\u001a\u0010O\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\bN\u0010\u0006\u001a\u0004\bM\u0010\u0004R\u001a\u0010R\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\bQ\u0010\u0006\u001a\u0004\bP\u0010\u0004R\u001a\u0010U\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\bT\u0010\u0006\u001a\u0004\bS\u0010\u0004¨\u0006V"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/x8;", "Lvh7/c;", "", "getUserId", "()Ljava/lang/String;", "getUserId$annotations", "()V", "userId", "getSecUid", "getSecUid$annotations", "secUid", "", "getRoomId", "()J", "getRoomId$annotations", "roomId", "Lpy/k;", "Lcom/bytedance/android/live/api/IImageModelKt;", "getAvatarThumb", "()Lpy/k;", "getAvatarThumb$annotations", "avatarThumb", "getNickName", "getNickName$annotations", "nickName", "getShortId", "getShortId$annotations", "shortId", "getFansNum", "getFansNum$annotations", "fansNum", "getLinkStatus", "getLinkStatus$annotations", "linkStatus", "getStatusReason", "getStatusReason$annotations", "statusReason", "getCustomVerify", "getCustomVerify$annotations", "customVerify", "getDisplayId", "getDisplayId$annotations", "displayId", "", "Lcom/bytedance/android/livesdk/link/model/IBattleRivalTag;", "Lcom/bytedance/revenue/platform/api/core/KmpList;", "getTags", "()Ljava/util/List;", "getTags$annotations", PromotionProductPrivilegesStruct.TAGS, "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoomKt;", "getRoom", "()Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;", "getRoom$annotations", "room", "Lcom/bytedance/android/livesdk/link/model/n0;", "getActivityUser", "()Lcom/bytedance/android/livesdk/link/model/n0;", "getActivityUser$annotations", "activityUser", "", "getFollowType", "()I", "getFollowType$annotations", "followType", "getSignExtra", "getSignExtra$annotations", "signExtra", "Lcom/bytedance/android/livesdk/link/model/IRivalExtraInfo;", "getRivalExtraInfo", "()Lcom/bytedance/android/livesdk/link/model/IRivalExtraInfo;", "getRivalExtraInfo$annotations", "rivalExtraInfo", "getGender", "getGender$annotations", "gender", "getLinkText", "getLinkText$annotations", "linkText", "getBattleAttachedInfo", "getBattleAttachedInfo$annotations", "battleAttachedInfo", "getRoomStatusDesc", "getRoomStatusDesc$annotations", "roomStatusDesc", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface x8 extends vh7.c<x8> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = "activity_user")
    n0 getActivityUser();

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
    long getGender();

    @FieldName(name = "link_status")
    long getLinkStatus();

    @FieldName(name = "link_text")
    String getLinkText();

    @FieldName(name = "nick_name")
    String getNickName();

    @FieldName(name = "extra_info")
    IRivalExtraInfo getRivalExtraInfo();

    @FieldName(name = "room")
    IRoom getRoom();

    @FieldName(name = "room_id")
    long getRoomId();

    @FieldName(name = "room_status_desc")
    String getRoomStatusDesc();

    @FieldName(name = "sec_user_id")
    String getSecUid();

    @FieldName(name = "short_id")
    long getShortId();

    @FieldName(name = "sign_extra")
    String getSignExtra();

    @FieldName(name = "status_reason")
    String getStatusReason();

    @FieldName(name = PromotionProductPrivilegesStruct.TAGS)
    List<IBattleRivalTag> getTags();

    @FieldName(name = Constants.JumpUrlConstants.URL_KEY_OPENID)
    String getUserId();
}
