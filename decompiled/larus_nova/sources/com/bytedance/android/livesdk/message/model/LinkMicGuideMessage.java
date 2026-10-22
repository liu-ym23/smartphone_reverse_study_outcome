package com.bytedance.android.livesdk.message.model;

import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.livesdk.chatroom.model.interact.PaidLinkmicExplainCardInfo;
import com.bytedance.android.livesdk.link.model.bridge.ILinkMicGuideMessageBridge;
import com.bytedance.android.livesdkapi.config.FastStartLiveConfig;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.message.Text;
import com.bytedance.android.tools.pbadapter.annotation.IgnoreProtoFieldCheck;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.FlexModelDelegate;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes11.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
public class LinkMicGuideMessage extends o0 implements vh7.c.a<ILinkMicGuideMessageBridge>, ILinkMicGuideMessageBridge {
    public static final long AUDIO_CHATROMM_GUIDELINE = 0;
    public static final long CALL_TO_LINKMIC = 3;
    public static final long CREATE_GROUP_CHAT_GUIDE = 5;
    public static final long CROSS_LINK_GUIDE_AUDIO_BUBBLE_ANIMATION = 16;
    public static final long CROSS_LINK_GUIDE_BUBBLE = 15;
    public static final long FAST_MATCH_GUIDELINE = 2;
    public static final long GUEST_BATTLE_BUBBLE_GUIDE = 7;
    public static final long JOIN_GROUP_CHAT_GUIDE = 6;
    public static final long KTV_ADD_SONG_GUIDE = 4;
    public static final long LINKMIC_FOLLOW_EFFECT = 11;
    public static final long LINKMIC_ICON_WHEN_HIDDEN_GUIDELINE = 1;
    public static final long NORMAL_PAID_LINKMIC_EXPLAIN_CARD = 9;
    public static final long NORMAL_PAID_LINKMIC_MIGRATE_TO_PLAY = 10;
    public static final long PK_LINK_BUBBLE_CONTENT = 12;
    public static final long PLAY_MODE_GUIDE_BUBBLE = 13;
    public static final long ROOM_BATTLE_RANDOM_MATCH_BUBBLE = 14;
    public static final long TEAM_FIGHT_BUBBLE_GUIDE = 8;

    @SerializedName("anchor_info")
    public AnchorGuideInfo anchorGuideInfo;

    @SerializedName("cue_threshold")
    public int audienceLimit;

    @SerializedName("call_to_linkmic_content")
    public a callToLinkMicContent;

    @SerializedName("create_group_chat_guide_content")
    public CreateGroupChatGuideContent createGroupChatGuideContent;

    @SerializedName("cross_link_guide_audio_bubble_animation_content")
    public q3 crossLinkGuideAudioBubbleAnimationContent;

    @SerializedName("cross_link_guide_bubble_content")
    public r3 crossLinkGuideBubbleContent;
    private final transient FlexModelDelegate<ILinkMicGuideMessageBridge> delegate;

    @SerializedName("guest_battle_bubble_guide_content")
    public GuestBattleBubbleGuideContent guestBattleBubbleGuideContent;

    @SerializedName("guideline_type")
    public long guidelineType;

    @SerializedName("join_group_chat_guide_content")
    public JoinGroupChatGuideContent joinGroupChatGuideContent;

    @SerializedName("ktv_add_song_guide_content")
    public b ktvAddSongGuideContent;

    @SerializedName("linkmic_follow_effect_content")
    public c linkmicFollowEffectContent;

    @SerializedName("normal_paid_linkmic_explain_card_content")
    public NormalPaidLinkmicExplainCardContent normalPaidLinkmicExplainCardContent;

    @SerializedName("normal_paid_linkmic_migrate_to_play_content")
    public NormalPaidLinkmicMigrateToPlayContent normalPaidLinkmicMigrateToPlayContent;

    @SerializedName("pk_link_bubble_content")
    public d pkLinkBubbleContent;

    @SerializedName("play_mode_guide_bubble_content")
    public PlayModeGuideBubbleContent playModeGuideBubbleContent;

    @SerializedName("create_teamfight_guide_content")
    public TeamFightBubbleGuideContent teamFightBubbleGuideContent;

    @JsonAdapter(FlexModelJsonAdapter.class)
    public static class AnchorGuideInfo extends FlexModelBase<f6> implements f6 {

        @SerializedName("infoList")
        public List<AnchorGuideInfoItem> infoItems;

        public AnchorGuideInfo() {
            super(f6.class);
        }

        @Override // com.bytedance.android.livesdk.message.model.f6
        public List<g6> getInfoItems() {
            return this.infoItems;
        }
    }

    @JsonAdapter(FlexModelJsonAdapter.class)
    public static class AnchorGuideInfoItem extends FlexModelBase<g6> implements g6 {

        @SerializedName("content")
        public String content;

        @SerializedName("icon")
        public py.k iconModel;

        public AnchorGuideInfoItem() {
            super(g6.class);
        }

        @Override // com.bytedance.android.livesdk.message.model.g6
        public String getContent() {
            return this.content;
        }

        @Override // com.bytedance.android.livesdk.message.model.g6
        public py.k getIconModel() {
            return this.iconModel;
        }
    }

    @JsonAdapter(FlexModelJsonAdapter.class)
    public static class CreateGroupChatGuideContent extends FlexModelBase<c7> implements c7 {

        @SerializedName("anchor_id")
        public long anchorID;

        @SerializedName("body_text")
        public String bodyText;

        @SerializedName("header_text")
        public String headerText;

        public CreateGroupChatGuideContent() {
            super(c7.class);
        }

        @Override // com.bytedance.android.livesdk.message.model.c7
        public long getAnchorID() {
            return this.anchorID;
        }

        @Override // com.bytedance.android.livesdk.message.model.c7
        public String getBodyText() {
            return this.bodyText;
        }

        @Override // com.bytedance.android.livesdk.message.model.c7
        public String getHeaderText() {
            return this.headerText;
        }
    }

    public static final enum GroupType extends Enum<GroupType> {
        public static final GroupType DefaultGroupType = null;
        public static final GroupType KtvGroup = null;
        public static final GroupType LinkmicGroup = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ GroupType[] f153571a = null;
        public final int value;

        static {
            GroupType r100 = new GroupType("DefaultGroupType", 0, 0);
            DefaultGroupType = r100;
            GroupType r101 = new GroupType("LinkmicGroup", 1, 1);
            LinkmicGroup = r101;
            GroupType r102 = new GroupType("KtvGroup", 2, 2);
            KtvGroup = r102;
            f153571a = new GroupType[]{r100, r101, r102};
        }

        public static GroupType[] values() {
            return (GroupType[]) f153571a.clone();
        }

        public static GroupType valueOf(String r100) {
            return (GroupType) r27.a.a(GroupType.class, r100);
        }

        public GroupType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    @JsonAdapter(FlexModelJsonAdapter.class)
    public static class GuestBattleBubbleGuideContent extends FlexModelBase<y7> implements y7 {

        @SerializedName("text")
        public Text text;

        public GuestBattleBubbleGuideContent() {
            super(y7.class);
        }

        @Override // com.bytedance.android.livesdk.message.model.y7
        public com.bytedance.android.live.base.model.message.a5 getText() {
            return this.text;
        }
    }

    public static final enum GuideSource extends Enum<GuideSource> {
        public static final GuideSource Invitation = null;
        public static final GuideSource SingingRank = null;
        public static final GuideSource UnknownGuideSource = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ GuideSource[] f153572a = null;
        public final int value;

        static {
            GuideSource r100 = new GuideSource("UnknownGuideSource", 0, 0);
            UnknownGuideSource = r100;
            GuideSource r101 = new GuideSource("Invitation", 1, 1);
            Invitation = r101;
            GuideSource r102 = new GuideSource("SingingRank", 2, 2);
            SingingRank = r102;
            f153572a = new GuideSource[]{r100, r101, r102};
        }

        public static GuideSource[] values() {
            return (GuideSource[]) f153572a.clone();
        }

        public static GuideSource valueOf(String r100) {
            return (GuideSource) r27.a.a(GuideSource.class, r100);
        }

        public GuideSource(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    @JsonAdapter(FlexModelJsonAdapter.class)
    public static class JoinGroupChatGuideContent extends FlexModelBase<d8> implements d8 {

        @SerializedName("body_text")
        public String bodyText;

        @SerializedName("conversation_id")
        public String conversationID;

        @SerializedName("group_id")
        public Long conversationShortID;

        @IgnoreProtoFieldCheck
        @SerializedName("group_type")
        public int group_type;

        @IgnoreProtoFieldCheck
        @SerializedName("guide_source")
        public int guide_source;

        @SerializedName("header_text")
        public String headerText;

        @SerializedName("icons")
        public List<ImageModel> iconsList;

        public JoinGroupChatGuideContent() {
            super(d8.class);
        }

        @Override // com.bytedance.android.livesdk.message.model.d8
        public String getBodyText() {
            return this.bodyText;
        }

        @Override // com.bytedance.android.livesdk.message.model.d8
        public String getConversationID() {
            return this.conversationID;
        }

        @Override // com.bytedance.android.livesdk.message.model.d8
        public Long getConversationShortID() {
            return this.conversationShortID;
        }

        @Override // com.bytedance.android.livesdk.message.model.d8
        public int getGroup_type() {
            return this.group_type;
        }

        @Override // com.bytedance.android.livesdk.message.model.d8
        public int getGuide_source() {
            return this.guide_source;
        }

        @Override // com.bytedance.android.livesdk.message.model.d8
        public String getHeaderText() {
            return this.headerText;
        }

        @Override // com.bytedance.android.livesdk.message.model.d8
        public List<py.k> getIconsList() {
            return this.iconsList;
        }
    }

    @JsonAdapter(FlexModelJsonAdapter.class)
    public static class NormalPaidLinkmicExplainCardContent extends FlexModelBase<xa> implements xa {

        @SerializedName("explain_card_info")
        public PaidLinkmicExplainCardInfo paidLinkmicExplainCardInfo;

        public NormalPaidLinkmicExplainCardContent() {
            super(xa.class);
        }

        @Override // com.bytedance.android.livesdk.message.model.xa
        public com.bytedance.android.livesdk.chatroom.model.interact.i1 getPaidLinkmicExplainCardInfo() {
            return this.paidLinkmicExplainCardInfo;
        }
    }

    @JsonAdapter(FlexModelJsonAdapter.class)
    public static class NormalPaidLinkmicMigrateToPlayContent extends FlexModelBase<ya> implements ya {

        @SerializedName("toast")
        public String toast;

        public NormalPaidLinkmicMigrateToPlayContent() {
            super(ya.class);
        }

        @Override // com.bytedance.android.livesdk.message.model.ya
        public String getToast() {
            return this.toast;
        }
    }

    @JsonAdapter(FlexModelJsonAdapter.class)
    public static class PlayModeGuideBubbleContent extends FlexModelBase<eb> implements eb {

        @SerializedName("anchor_show_position")
        public int anchorShowPosition;

        @SerializedName("play_mode_enhance_type")
        public int enhanceType;

        @SerializedName("extra")
        public Map<String, String> extra;

        @SerializedName(FastStartLiveConfig.PLAY_MODE)
        public int playMode;

        @SerializedName("text")
        public Text richText;

        @SerializedName("schema")
        public String schema;

        @SerializedName("toast")
        public String toast;

        public PlayModeGuideBubbleContent() {
            super(eb.class);
        }

        @Override // com.bytedance.android.livesdk.message.model.eb
        public int getAnchorShowPosition() {
            return this.anchorShowPosition;
        }

        @Override // com.bytedance.android.livesdk.message.model.eb
        public int getEnhanceType() {
            return this.enhanceType;
        }

        @Override // com.bytedance.android.livesdk.message.model.eb
        public Map<String, String> getExtra() {
            return this.extra;
        }

        @Override // com.bytedance.android.livesdk.message.model.eb
        public int getPlayMode() {
            return this.playMode;
        }

        @Override // com.bytedance.android.livesdk.message.model.eb
        public com.bytedance.android.live.base.model.message.a5 getRichText() {
            return this.richText;
        }

        @Override // com.bytedance.android.livesdk.message.model.eb
        public String getSchema() {
            return this.schema;
        }

        @Override // com.bytedance.android.livesdk.message.model.eb
        public String getToast() {
            return this.toast;
        }
    }

    @JsonAdapter(FlexModelJsonAdapter.class)
    public static class TeamFightBubbleGuideContent extends FlexModelBase<xb> implements xb {

        @SerializedName(ILiveRoomPlayFragmentConstant.EXTRA_TASK_TOKEN_TOAST_TEXT)
        public Text text;

        public TeamFightBubbleGuideContent() {
            super(xb.class);
        }

        @Override // com.bytedance.android.livesdk.message.model.xb
        public com.bytedance.android.live.base.model.message.a5 getText() {
            return this.text;
        }
    }

    public static class a {
        public a() {
        }
    }

    public static class b {
        public b() {
        }
    }

    public static class c {

        @SerializedName("follow_infos")
        public List<a> followInfos;

        @SerializedName("from_open_id")
        String fromOpenId;

        @SerializedName("from_user_id")
        long fromUserId;

        @SerializedName("room_id")
        public long roomId;

        public static class a {

            @SerializedName("follow_status")
            public long followStatus;

            @SerializedName("target_open_id")
            String targetOpenId;

            @SerializedName("target_user_id")
            long targetUserId;

            public a() {
            }
        }

        public c() {
        }
    }

    public static class d {

        @SerializedName("toast")
        public String toast;

        public d() {
        }
    }

    public LinkMicGuideMessage() {
        this.delegate = new FlexModelDelegate(ILinkMicGuideMessageBridge.class, this);
        this.type = MessageType.LINK_MIC_GUIDE_MESSAGE;
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.ILinkMicGuideMessageBridge
    public f6 getAnchorGuideInfo() {
        return this.anchorGuideInfo;
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.ILinkMicGuideMessageBridge
    public int getAudienceLimit() {
        return this.audienceLimit;
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.ILinkMicGuideMessageBridge
    public c7 getCreateGroupChatGuideContent() {
        return this.createGroupChatGuideContent;
    }

    @Override // vh7.c.a
    public FlexModelDelegate<ILinkMicGuideMessageBridge> getDelegate() {
        return this.delegate;
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.ILinkMicGuideMessageBridge
    public y7 getGuestBattleBubbleGuideContent() {
        return this.guestBattleBubbleGuideContent;
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.ILinkMicGuideMessageBridge
    public long getGuidelineType() {
        return this.guidelineType;
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.ILinkMicGuideMessageBridge
    public d8 getJoinGroupChatGuideContent() {
        return this.joinGroupChatGuideContent;
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.ILinkMicGuideMessageBridge
    public xa getNormalPaidLinkmicExplainCardContent() {
        return this.normalPaidLinkmicExplainCardContent;
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.ILinkMicGuideMessageBridge
    public ya getNormalPaidLinkmicMigrateToPlayContent() {
        return this.normalPaidLinkmicMigrateToPlayContent;
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.ILinkMicGuideMessageBridge
    public eb getPlayModeGuideBubbleContent() {
        return this.playModeGuideBubbleContent;
    }

    @Override // com.bytedance.android.livesdk.link.model.bridge.ILinkMicGuideMessageBridge
    public xb getTeamFightBubbleGuideContent() {
        return this.teamFightBubbleGuideContent;
    }

    @Override // vh7.c.a, vh7.c
    public <R extends vh7.e<ILinkMicGuideMessageBridge>> R castTo(Class<R> r100) {
        return (R) this.delegate.castTo(r100);
    }

    @Override // vh7.c.a, vh7.c
    public <R extends vh7.e<ILinkMicGuideMessageBridge>> R castToOrNull(Class<R> r100) {
        return (R) this.delegate.castToOrNull(r100);
    }
}
