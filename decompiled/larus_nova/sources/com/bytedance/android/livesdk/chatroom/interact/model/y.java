package com.bytedance.android.livesdk.chatroom.interact.model;

import com.bytedance.android.livesdk.chatroom.model.interact.p1;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\bg\u0018\u0000 \u00132\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002:\u0001\u0014J\b\u0010\u0004\u001a\u00020\u0003H&R\u001a\u0010\n\u001a\u00020\u00058&X§\u0004¢\u0006\f\u0012\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\r\u001a\u00020\u00058&X§\u0004¢\u0006\f\u0012\u0004\b\f\u0010\t\u001a\u0004\b\u000b\u0010\u0007R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u000e8&X§\u0004¢\u0006\f\u0012\u0004\b\u0011\u0010\t\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/interact/model/y;", "Lvh7/c;", "", "", "isOpen", "", "getKey", "()I", "getKey$annotations", "()V", "key", "getValue", "getValue$annotations", "value", "Lcom/bytedance/android/livesdk/chatroom/model/interact/p1;", "getContent", "()Lcom/bytedance/android/livesdk/chatroom/model/interact/p1;", "getContent$annotations", "content", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface y extends vh7.c<y> {
    public static final int ALL_USERS = 23;
    public static final int AL_ALLOW_GIFT_TO_OTHER_ANCHORS = 4;
    public static final String APPLICATION_REASON_DEFAULT_TEMPLATE = "";
    public static final int AUDIO_CHAT_ONE_PLUS_EIGHT = 24;
    public static final int AUDIO_CHAT_THREE_TIMES_THREE_N_EMPTY = 26;
    public static final int AUDIO_CHAT_THREE_TIMES_THREE_ONE_EMPTY = 25;
    public static final int AUDIO_SUBTITLE = 94;
    public static final int AU_ADD_LINK_MIC_TIME = 45;
    public static final int AU_ALLOW_ADMIN_OPERATE_AUDIENCE = 24;
    public static final int AU_AUDIO_CHAT_APPLY_NEED_VERIFY = 16;
    public static final int AU_AUDIO_CHAT_EMOJI_ENTRANCE = 23;
    public static final int AU_AUDIO_CHAT_GUEST_CAN_ACCEPT_GIFT = 18;
    public static final int AU_AUDIO_CHAT_ONLY_ACCEPT_FOLLOWER_APPLY = 17;
    public static final int AU_ApplyStrongReminderEntrance = 37;
    public static final int AU_Audio1V8EnlargeStageSwitch = 109;
    public static final int AU_AutoInitInfo = 59;
    public static final int AU_BIG_PARTY_AUDIENCE_DEFAULT_OPEN_VIDEO = 52;
    public static final int AU_BIG_PARTY_EMOJI_ENTRANCE = 22;
    public static final int AU_BIG_PARTY_GUEST_CAN_ACCEPT_GIFT = 11;
    public static final int AU_BIG_PARTY_ONLY_ACCEPT_FOLLOWER_APPLY = 10;
    public static final int AU_BIG_PARTY_ONLY_JOIN_THROUGH_INVITATION = 40;
    public static final int AU_BigPartyNormalPaidLinkmicConfig = 63;
    public static final int AU_EMOJI_WITH_SOUND = 29;
    public static final int AU_ENABLE_AUDIENCE_LINKMIC = 61;
    public static final int AU_EnlargeGuestEqual1V8 = 105;
    public static final int AU_GuestBattleConfig = 72;
    public static final int AU_GuestLinkConfig = 107;
    public static final int AU_INTERACT_AUDIENCE_IS_TURN_ON = 8;
    public static final int AU_INTERACT_EMOJI_ENTRANCE = 28;
    public static final int AU_INTIMATE_CHAT_APPLICATION_REASON = 51;
    public static final int AU_INTIMATE_CHAT_GUEST_CAN_ACCEPT_GIFT = 13;
    public static final int AU_INTIMATE_CHAT_LIMIT_TIME = 42;
    public static final int AU_INTIMATE_CHAT_NEED_VERIFIED = 15;
    public static final int AU_INTIMATE_CHAT_ONLY_ACCEPT_FOLLOWER_APPLY = 12;
    public static final int AU_INTIMATE_CHAT_ONLY_JOIN_THROUGH_INVITATION = 14;
    public static final int AU_INTIMATE_CHAT_PAID_COUNT = 41;
    public static final int AU_IntimateChatIsTheOnSwitchSet = 38;
    public static final int AU_IntimateChatNormalPaidLinkmicConfig = 66;
    public static final int AU_IsKTVChallengeTurnOn = 58;
    public static final int AU_KTVAutoLeave = 82;
    public static final int AU_KTVComponentConfig = 90;
    public static final int AU_KTVEnableAtmosphere = 53;
    public static final int AU_KTVEnableAvatar = 55;
    public static final int AU_KTVEnableColdStartSongList = 54;
    public static final int AU_KTVFriendsGroup = 56;
    public static final int AU_KTVLyricMode = 87;
    public static final int AU_KTVMidiMode = 92;
    public static final int AU_KTVRealTimeChorus = 113;
    public static final int AU_KTV_ALLOW_SINGER_OPEN_CAMERA = 34;
    public static final int AU_LINK_MIC_AUTO_SILENCE = 77;
    public static final int AU_NormalPaidLinkmicAddPriceConfig = 70;
    public static final int AU_NormalPaidLinkmicDesc = 65;
    public static final int AU_NormalPaidLinkmicExplainCard = 64;
    public static final int AU_OFFICIAL_CHANNEL_HOST_CAN_ACCEPT_GIFT = 25;
    public static final int AU_OPEN_CAMERA = 33;
    public static final int AU_PAID_QUEUE = 89;
    public static final int AU_RoomBattleConfig = 69;
    public static final int AU_SELF_DISCIPLINE_CONFIG = 76;
    public static final int AU_TeamFightConfig = 73;
    public static final int AU_VIDEO_CHAT_ACCEPT_AUDIENCE_PREAPPLY = 62;
    public static final int AU_VIDEO_CHAT_APPLY_NEED_VERIFY = 9;
    public static final int AU_VIDEO_CHAT_ONLY_ACCEPT_FOLLOWER_APPLY = 10;
    public static final int AU_VIDEO_TALK_LIMIT_TIME = 44;
    public static final int AU_VIDEO_TALK_PAID_COUNT = 43;
    public static final int AU_VOICE_CHAT_PRE_ONLINE_TURN_ON = 47;
    public static final int AU_WaitingListSortStrategy = 58;
    public static final int CLEAR_GUEST_INCOME_VALUE = 93;
    public static final a Companion = null;
    public static final int NORMAL_PAID_WAITING_LIST_SORT_STRATEGY_APPLY_TIME = 72;
    public static final int NORMAL_PAID_WAITING_LIST_SORT_STRATEGY_FAN_TICKET = 71;
    public static final int OFF = 2;
    public static final int ONLY_FANS = 22;
    public static final int ONLY_FANS_CLUB_USER = 21;
    public static final int ONLY_FOLLOWING_USER = 20;
    public static final int OPEN = 1;
    public static final int PAID_LINK_DISABLE = -1;
    public static final int PAID_LINK_OFF = 0;
    public static final int PK_ALLOW_GIFT_TO_OTHER_ANCHORS = 7;
    public static final int UNSET = 0;
    public static final int VIDEO_TALK_ONLY_JOIN_THROUGH_INVITATION = 40;
    public static final int WAITING_LIST_SORT_STRATEGY_APPLY_TIME = 40;
    public static final int WAITING_LIST_SORT_STRATEGY_FAN_TICKET = 41;
    public static final int WAITING_LIST_SORT_STRATEGY_RECOMMEND = 42;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f106765a = null;

        public a() {
        }

        static {
            f106765a = new a();
        }
    }

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class b {
    }

    static {
        Companion = a.f106765a;
    }

    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = "content")
    p1 getContent();

    @FieldName(name = "key")
    int getKey();

    @FieldName(name = "value")
    int getValue();

    boolean isOpen();
}
