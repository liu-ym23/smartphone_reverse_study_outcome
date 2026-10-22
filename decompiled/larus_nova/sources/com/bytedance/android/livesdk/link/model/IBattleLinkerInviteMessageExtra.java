package com.bytedance.android.livesdk.link.model;

import com.bytedance.android.ec.model.response.anchorv3.PromotionProductPrivilegesStruct;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0002lmR\u001a\u0010\u0007\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004R\u001a\u0010\f\u001a\u00020\b8&X§\u0004¢\u0006\f\u0012\u0004\b\u000b\u0010\u0006\u001a\u0004\b\t\u0010\nR\u001a\u0010\u000f\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u000e\u0010\u0006\u001a\u0004\b\r\u0010\u0004R\u001a\u0010\u0012\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0011\u0010\u0006\u001a\u0004\b\u0010\u0010\u0004R\u001a\u0010\u0015\u001a\u00020\b8&X§\u0004¢\u0006\f\u0012\u0004\b\u0014\u0010\u0006\u001a\u0004\b\u0013\u0010\nR\u001a\u0010\u0018\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0017\u0010\u0006\u001a\u0004\b\u0016\u0010\u0004R\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u00198&X§\u0004¢\u0006\f\u0012\u0004\b\u001c\u0010\u0006\u001a\u0004\b\u001a\u0010\u001bR.\u0010$\u001a\u0016\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u001ej\n\u0012\u0004\u0012\u00020\u001f\u0018\u0001` 8&X§\u0004¢\u0006\f\u0012\u0004\b#\u0010\u0006\u001a\u0004\b!\u0010\"R\"\u0010*\u001a\n\u0018\u00010%j\u0004\u0018\u0001`&8&X§\u0004¢\u0006\f\u0012\u0004\b)\u0010\u0006\u001a\u0004\b'\u0010(R\u001a\u0010-\u001a\u00020\b8&X§\u0004¢\u0006\f\u0012\u0004\b,\u0010\u0006\u001a\u0004\b+\u0010\nR\u001a\u00100\u001a\u00020\b8&X§\u0004¢\u0006\f\u0012\u0004\b/\u0010\u0006\u001a\u0004\b.\u0010\nR\u001c\u00105\u001a\u0004\u0018\u0001018&X§\u0004¢\u0006\f\u0012\u0004\b4\u0010\u0006\u001a\u0004\b2\u00103R\u001a\u0010:\u001a\u0002068&X§\u0004¢\u0006\f\u0012\u0004\b9\u0010\u0006\u001a\u0004\b7\u00108R\u001a\u0010=\u001a\u0002068&X§\u0004¢\u0006\f\u0012\u0004\b<\u0010\u0006\u001a\u0004\b;\u00108R\u001c\u0010B\u001a\u0004\u0018\u00010>8&X§\u0004¢\u0006\f\u0012\u0004\bA\u0010\u0006\u001a\u0004\b?\u0010@R\u001c\u0010G\u001a\u0004\u0018\u00010C8&X§\u0004¢\u0006\f\u0012\u0004\bF\u0010\u0006\u001a\u0004\bD\u0010ER\u001c\u0010K\u001a\u0004\u0018\u0001068&X§\u0004¢\u0006\f\u0012\u0004\bJ\u0010\u0006\u001a\u0004\bH\u0010IR.\u0010N\u001a\u0016\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u001ej\n\u0012\u0004\u0012\u00020\u001f\u0018\u0001` 8&X§\u0004¢\u0006\f\u0012\u0004\bM\u0010\u0006\u001a\u0004\bL\u0010\"R$\u0010U\u001a\u0004\u0018\u00010O8&@&X§\u000e¢\u0006\u0012\u0012\u0004\bT\u0010\u0006\u001a\u0004\bP\u0010Q\"\u0004\bR\u0010SR.\u0010X\u001a\u0016\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u001ej\n\u0012\u0004\u0012\u00020\u001f\u0018\u0001` 8&X§\u0004¢\u0006\f\u0012\u0004\bW\u0010\u0006\u001a\u0004\bV\u0010\"R\u001a\u0010[\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\bZ\u0010\u0006\u001a\u0004\bY\u0010\u0004R\u001a\u0010`\u001a\u00020\\8&X§\u0004¢\u0006\f\u0012\u0004\b_\u0010\u0006\u001a\u0004\b]\u0010^R\u001a\u0010e\u001a\u00020a8&X§\u0004¢\u0006\f\u0012\u0004\bd\u0010\u0006\u001a\u0004\bb\u0010cR.\u0010h\u001a\u0016\u0012\u0004\u0012\u00020\b\u0018\u00010\u001ej\n\u0012\u0004\u0012\u00020\b\u0018\u0001` 8&X§\u0004¢\u0006\f\u0012\u0004\bg\u0010\u0006\u001a\u0004\bf\u0010\"R.\u0010k\u001a\u0016\u0012\u0004\u0012\u00020\b\u0018\u00010\u001ej\n\u0012\u0004\u0012\u00020\b\u0018\u0001` 8&X§\u0004¢\u0006\f\u0012\u0004\bj\u0010\u0006\u001a\u0004\bi\u0010\"¨\u0006n"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/IBattleLinkerInviteMessageExtra;", "Lvh7/c;", "", "getMatchType", "()J", "getMatchType$annotations", "()V", "matchType", "", "getTips", "()Ljava/lang/String;", "getTips$annotations", "tips", "getInviteType", "getInviteType$annotations", "inviteType", "getScene", "getScene$annotations", "scene", "getTheme", "getTheme$annotations", "theme", "getDuration", "getDuration$annotations", "duration", "Lcom/bytedance/android/livesdk/link/model/m4;", "getExtra", "()Lcom/bytedance/android/livesdk/link/model/m4;", "getExtra$annotations", "extra", "", "Lcom/bytedance/android/livesdk/link/model/IBattleRivalTag;", "Lcom/bytedance/revenue/platform/api/core/KmpList;", "getTagList", "()Ljava/util/List;", "getTagList$annotations", "tagList", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoomKt;", "getInviteRoom", "()Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;", "getInviteRoom$annotations", "inviteRoom", "getRecommendReason", "getRecommendReason$annotations", "recommendReason", "getActivityName", "getActivityName$annotations", "activityName", "Lcom/bytedance/android/livesdk/link/model/n0;", "getActivityUser", "()Lcom/bytedance/android/livesdk/link/model/n0;", "getActivityUser$annotations", "activityUser", "", "getPkCheckState", "()I", "getPkCheckState$annotations", "pkCheckState", "getSwitchPlayMode", "getSwitchPlayMode$annotations", "switchPlayMode", "Lcom/bytedance/android/livesdk/link/model/aa;", "getVoteSetting", "()Lcom/bytedance/android/livesdk/link/model/aa;", "getVoteSetting$annotations", "voteSetting", "Lcom/bytedance/android/livesdk/link/model/IBattleConfigSetting;", "getBattleConfigSetting", "()Lcom/bytedance/android/livesdk/link/model/IBattleConfigSetting;", "getBattleConfigSetting$annotations", "battleConfigSetting", "getInviteStatus", "()Ljava/lang/Integer;", "getInviteStatus$annotations", "inviteStatus", "getMatchTags", "getMatchTags$annotations", "matchTags", "Lcom/bytedance/android/livesdk/link/model/h5;", "getLinkMicBizExtra", "()Lcom/bytedance/android/livesdk/link/model/h5;", "setLinkMicBizExtra", "(Lcom/bytedance/android/livesdk/link/model/h5;)V", "getLinkMicBizExtra$annotations", "linkMicBizExtra", "getSemiFriendTags", "getSemiFriendTags$annotations", "semiFriendTags", "getInvitePanelStyle", "getInvitePanelStyle$annotations", "invitePanelStyle", "Lcom/bytedance/android/livesdk/link/model/m1;", "getRankSeasonInfo", "()Lcom/bytedance/android/livesdk/link/model/m1;", "getRankSeasonInfo$annotations", "rankSeasonInfo", "Lcom/bytedance/android/livesdk/link/model/l1;", "getAcceptTip", "()Lcom/bytedance/android/livesdk/link/model/l1;", "getAcceptTip$annotations", "acceptTip", "getCannotPkAnchorUidList", "getCannotPkAnchorUidList$annotations", "cannotPkAnchorUidList", "getInviterFollowIds", "getInviterFollowIds$annotations", "inviterFollowIds", "InvitePanelStyle", "InviteStatus", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface IBattleLinkerInviteMessageExtra extends vh7.c<IBattleLinkerInviteMessageExtra> {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/IBattleLinkerInviteMessageExtra$InvitePanelStyle;", "", "Old", "New", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final enum InvitePanelStyle extends Enum<InvitePanelStyle> {
        public static final InvitePanelStyle New = null;
        public static final InvitePanelStyle Old = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ InvitePanelStyle[] f147030a = null;

        static {
            InvitePanelStyle r100 = new InvitePanelStyle("Old", 0);
            Old = r100;
            InvitePanelStyle r101 = new InvitePanelStyle("New", 1);
            New = r101;
            f147030a = new InvitePanelStyle[]{r100, r101};
        }

        public static InvitePanelStyle valueOf(String r100) {
            return (InvitePanelStyle) r27.a.a(InvitePanelStyle.class, r100);
        }

        public static InvitePanelStyle[] values() {
            return (InvitePanelStyle[]) f147030a.clone();
        }

        public InvitePanelStyle(String r100, int r101) {
            super(r100, r101);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/IBattleLinkerInviteMessageExtra$InviteStatus;", "", "InviteStatusUnknown", "InviteStatusInPK", "InviteStatusInLinkMic", "InviteStatusInAudienceLinkMic", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final enum InviteStatus extends Enum<InviteStatus> {
        public static final InviteStatus InviteStatusInAudienceLinkMic = null;
        public static final InviteStatus InviteStatusInLinkMic = null;
        public static final InviteStatus InviteStatusInPK = null;
        public static final InviteStatus InviteStatusUnknown = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ InviteStatus[] f147031a = null;

        static {
            InviteStatus r100 = new InviteStatus("InviteStatusUnknown", 0);
            InviteStatusUnknown = r100;
            InviteStatus r101 = new InviteStatus("InviteStatusInPK", 1);
            InviteStatusInPK = r101;
            InviteStatus r102 = new InviteStatus("InviteStatusInLinkMic", 2);
            InviteStatusInLinkMic = r102;
            InviteStatus r103 = new InviteStatus("InviteStatusInAudienceLinkMic", 3);
            InviteStatusInAudienceLinkMic = r103;
            f147031a = new InviteStatus[]{r100, r101, r102, r103};
        }

        public static InviteStatus valueOf(String r100) {
            return (InviteStatus) r27.a.a(InviteStatus.class, r100);
        }

        public static InviteStatus[] values() {
            return (InviteStatus[]) f147031a.clone();
        }

        public InviteStatus(String r100, int r101) {
            super(r100, r101);
        }
    }

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = "accept_tip")
    l1 getAcceptTip();

    @FieldName(name = "activity_name")
    String getActivityName();

    @FieldName(name = "activity_user")
    n0 getActivityUser();

    @FieldName(name = "battle_config_setting")
    IBattleConfigSetting getBattleConfigSetting();

    @FieldName(name = "can_not_pass_anchor_open_ids")
    List<String> getCannotPkAnchorUidList();

    @FieldName(name = "duration")
    long getDuration();

    @FieldName(name = "extra")
    m4 getExtra();

    @FieldName(name = "battle_invite_panel_opt")
    long getInvitePanelStyle();

    @FieldName(name = "invite_room")
    IRoom getInviteRoom();

    @FieldName(name = "invite_status")
    Integer getInviteStatus();

    @FieldName(name = "invite_type")
    long getInviteType();

    @FieldName(name = "inviter_followed_open_ids")
    List<String> getInviterFollowIds();

    @FieldName(name = "link_mic_biz_extra")
    h5 getLinkMicBizExtra();

    @FieldName(name = "match_tags")
    List<IBattleRivalTag> getMatchTags();

    @FieldName(name = ILiveRoomPlayFragmentConstant.EXTRA_LOG_MATCH_TYPE)
    long getMatchType();

    @FieldName(name = "anchor_pk_check")
    int getPkCheckState();

    @FieldName(name = "rank_season_info")
    m1 getRankSeasonInfo();

    @FieldName(name = "recommend_reason")
    String getRecommendReason();

    @FieldName(name = "scene")
    long getScene();

    @FieldName(name = "half_friend_tags")
    List<IBattleRivalTag> getSemiFriendTags();

    @FieldName(name = "switch_play_mode")
    int getSwitchPlayMode();

    @FieldName(name = PromotionProductPrivilegesStruct.TAGS)
    List<IBattleRivalTag> getTagList();

    @FieldName(name = "theme")
    String getTheme();

    @FieldName(name = "tips")
    String getTips();

    @FieldName(name = "vote_setting")
    aa getVoteSetting();

    @FieldName(name = "link_mic_biz_extra#setter")
    void setLinkMicBizExtra(h5 r100);
}
