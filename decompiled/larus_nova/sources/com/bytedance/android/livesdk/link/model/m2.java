package com.bytedance.android.livesdk.link.model;

import com.bytedance.android.ec.model.response.anchorv3.PromotionProductPrivilegesStruct;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0007\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u001e\u0010\b\u001a\u00060\u0002j\u0002`\u00038VX\u0097\u0004¢\u0006\f\u0012\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0004\u0010\u0005R\u001c\u0010\r\u001a\u0004\u0018\u00010\t8&X§\u0004¢\u0006\f\u0012\u0004\b\f\u0010\u0007\u001a\u0004\b\n\u0010\u000bR.\u0010\u0014\u001a\u0016\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000ej\n\u0012\u0004\u0012\u00020\u000f\u0018\u0001`\u00108&X§\u0004¢\u0006\f\u0012\u0004\b\u0013\u0010\u0007\u001a\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u00158&X§\u0004¢\u0006\f\u0012\u0004\b\u0018\u0010\u0007\u001a\u0004\b\u0016\u0010\u0017R\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u001a8&X§\u0004¢\u0006\f\u0012\u0004\b\u001d\u0010\u0007\u001a\u0004\b\u001b\u0010\u001cR\u001c\u0010#\u001a\u0004\u0018\u00010\u001f8&X§\u0004¢\u0006\f\u0012\u0004\b\"\u0010\u0007\u001a\u0004\b \u0010!R\u001a\u0010(\u001a\u00020$8&X§\u0004¢\u0006\f\u0012\u0004\b'\u0010\u0007\u001a\u0004\b%\u0010&R6\u0010+\u001a\u001e\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0018\u00010\u000ej\u000e\u0012\b\u0012\u00060\u0002j\u0002`\u0003\u0018\u0001`\u00108&X§\u0004¢\u0006\f\u0012\u0004\b*\u0010\u0007\u001a\u0004\b)\u0010\u0012R\u001a\u0010.\u001a\u00020$8&X§\u0004¢\u0006\f\u0012\u0004\b-\u0010\u0007\u001a\u0004\b,\u0010&R\u001a\u00103\u001a\u00020/8&X§\u0004¢\u0006\f\u0012\u0004\b2\u0010\u0007\u001a\u0004\b0\u00101R\u001a\u00108\u001a\u0002048&X§\u0004¢\u0006\f\u0012\u0004\b7\u0010\u0007\u001a\u0004\b5\u00106R\u001a\u0010;\u001a\u0002048&X§\u0004¢\u0006\f\u0012\u0004\b:\u0010\u0007\u001a\u0004\b9\u00106R\u001a\u0010>\u001a\u0002048&X§\u0004¢\u0006\f\u0012\u0004\b=\u0010\u0007\u001a\u0004\b<\u00106R\"\u0010D\u001a\n\u0018\u00010?j\u0004\u0018\u0001`@8&X§\u0004¢\u0006\f\u0012\u0004\bC\u0010\u0007\u001a\u0004\bA\u0010BR\u001a\u0010G\u001a\u0002048&X§\u0004¢\u0006\f\u0012\u0004\bF\u0010\u0007\u001a\u0004\bE\u00106R\u001a\u0010J\u001a\u0002048&X§\u0004¢\u0006\f\u0012\u0004\bI\u0010\u0007\u001a\u0004\bH\u00106R*\u0010M\u001a\u0012\u0012\u0004\u0012\u00020\u000f0\u000ej\b\u0012\u0004\u0012\u00020\u000f`\u00108&X§\u0004¢\u0006\f\u0012\u0004\bL\u0010\u0007\u001a\u0004\bK\u0010\u0012R\u001a\u0010P\u001a\u0002048&X§\u0004¢\u0006\f\u0012\u0004\bO\u0010\u0007\u001a\u0004\bN\u00106R\"\u0010U\u001a\u0002048&@&X§\u000e¢\u0006\u0012\u0012\u0004\bT\u0010\u0007\u001a\u0004\bQ\u00106\"\u0004\bR\u0010SR$\u0010\\\u001a\u0004\u0018\u00010V8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b[\u0010\u0007\u001a\u0004\bW\u0010X\"\u0004\bY\u0010Z¨\u0006]"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/m2;", "Lvh7/c;", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoomKt;", "getRoom", "()Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;", "getRoom$annotations", "()V", "room", "Lcom/bytedance/android/livesdk/link/model/IRivalExtraInfo;", "getRivalExtraInfo", "()Lcom/bytedance/android/livesdk/link/model/IRivalExtraInfo;", "getRivalExtraInfo$annotations", "rivalExtraInfo", "", "Lcom/bytedance/android/livesdk/link/model/IBattleRivalTag;", "Lcom/bytedance/revenue/platform/api/core/KmpList;", "getBattleRivalTagList", "()Ljava/util/List;", "getBattleRivalTagList$annotations", "battleRivalTagList", "Lcom/bytedance/android/livesdk/link/model/n2;", "getInviteButton", "()Lcom/bytedance/android/livesdk/link/model/n2;", "getInviteButton$annotations", "inviteButton", "Lcom/bytedance/android/livesdk/link/model/a3;", "getActivityMedal", "()Lcom/bytedance/android/livesdk/link/model/a3;", "getActivityMedal$annotations", "activityMedal", "Lcom/bytedance/android/livesdk/link/model/n0;", "getActivityUser", "()Lcom/bytedance/android/livesdk/link/model/n0;", "getActivityUser$annotations", "activityUser", "", "getServerInviteType", "()I", "getServerInviteType$annotations", "serverInviteType", "getParticipantRooms", "getParticipantRooms$annotations", "participantRooms", "getRoomScene", "getRoomScene$annotations", "roomScene", "", "getStatus", "()J", "getStatus$annotations", "status", "", "getLinkText", "()Ljava/lang/String;", "getLinkText$annotations", "linkText", "getRecommendInfo", "getRecommendInfo$annotations", "recommendInfo", "getBattleAttachedInfo", "getBattleAttachedInfo$annotations", "battleAttachedInfo", "Lpy/k;", "Lcom/bytedance/android/live/api/IImageModelKt;", "getPkStageMedal", "()Lpy/k;", "getPkStageMedal$annotations", "pkStageMedal", "getPkStageDesc", "getPkStageDesc$annotations", "pkStageDesc", "getRoomStatusDesc", "getRoomStatusDesc$annotations", "roomStatusDesc", "getSemiFriendTags", "getSemiFriendTags$annotations", "semiFriendTags", "getCanReserve", "getCanReserve$annotations", "canReserve", "getReserveDesc", "setReserveDesc", "(Ljava/lang/String;)V", "getReserveDesc$annotations", "reserveDesc", "Lcom/bytedance/android/livesdk/link/model/p2;", "getRankSeasonInfo", "()Lcom/bytedance/android/livesdk/link/model/p2;", "setRankSeasonInfo", "(Lcom/bytedance/android/livesdk/link/model/p2;)V", "getRankSeasonInfo$annotations", "rankSeasonInfo", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface m2 extends vh7.c<m2> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = "activity_medal")
    a3 getActivityMedal();

    @FieldName(name = "activity_user")
    n0 getActivityUser();

    @FieldName(name = "battle_attached_info")
    String getBattleAttachedInfo();

    @FieldName(name = PromotionProductPrivilegesStruct.TAGS)
    List<IBattleRivalTag> getBattleRivalTagList();

    @FieldName(name = "reserve_button")
    String getCanReserve();

    @FieldName(name = "invite_button")
    n2 getInviteButton();

    @FieldName(name = "link_text")
    String getLinkText();

    @FieldName(name = "participant_rooms")
    List<IRoom> getParticipantRooms();

    @FieldName(name = "pk_stage_desc")
    String getPkStageDesc();

    @FieldName(name = "pk_stage_medal")
    py.k getPkStageMedal();

    @FieldName(name = "rank_season_info")
    p2 getRankSeasonInfo();

    @FieldName(name = com.bytedance.android.ec.core.event.a.KEY_RECOMMEND_INFO)
    String getRecommendInfo();

    @FieldName(name = "reserve_desc")
    String getReserveDesc();

    @FieldName(name = "extra_info")
    IRivalExtraInfo getRivalExtraInfo();

    @FieldName(name = "room")
    IRoom getRoom();

    @FieldName(name = "scene")
    int getRoomScene();

    @FieldName(name = "room_status_desc")
    String getRoomStatusDesc();

    @FieldName(name = "half_friend_tags")
    List<IBattleRivalTag> getSemiFriendTags();

    @FieldName(name = "from_server_invite_type")
    int getServerInviteType();

    @FieldName(name = "link_status")
    long getStatus();

    @FieldName(name = "rank_season_info#setter")
    void setRankSeasonInfo(p2 r100);

    @FieldName(name = "reserve_desc#setter")
    void setReserveDesc(String r100);
}
