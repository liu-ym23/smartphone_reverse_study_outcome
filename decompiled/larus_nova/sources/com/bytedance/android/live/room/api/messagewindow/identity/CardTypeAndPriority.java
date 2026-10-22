package com.bytedance.android.live.room.api.messagewindow.identity;

import com.tencent.open.SocialConstants;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u001d\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u0004j\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#¨\u0006$"}, d2 = {"Lcom/bytedance/android/live/room/api/messagewindow/identity/CardTypeAndPriority;", "", "", "type", "Ljava/lang/String;", "getType", "()Ljava/lang/String;", "", "priority", "I", "getPriority", "()I", SocialConstants.PARAM_APP_DESC, "Test", "Unknown", "LightFeedback", "AnchorPkFeedback", "LiveAppWidgetGuide", "Banner", "DrawAndGuess", "WatchVideo", "AudienceLink", "VideoTalk", "VSEpisodeInteract", "MicRoomFollowCard", "KtvOrder", "PaidProfile", "LiveMiniApp", "AssembledIntroduceCard", "WelfareProject", "PaidLiveInteract", "PaidLiveTicketSale", "PaidLiveShareTicket", "PaidLiveTrialPayGuide", "BottomBannerReadPackage", "GiftLynxCard", "experience-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum CardTypeAndPriority extends Enum<CardTypeAndPriority> {
    public static final CardTypeAndPriority AnchorPkFeedback = null;
    public static final CardTypeAndPriority AssembledIntroduceCard = null;
    public static final CardTypeAndPriority AudienceLink = null;
    public static final CardTypeAndPriority Banner = null;
    public static final CardTypeAndPriority BottomBannerReadPackage = null;
    public static final CardTypeAndPriority DrawAndGuess = null;
    public static final CardTypeAndPriority GiftLynxCard = null;
    public static final CardTypeAndPriority KtvOrder = null;
    public static final CardTypeAndPriority LightFeedback = null;
    public static final CardTypeAndPriority LiveAppWidgetGuide = null;
    public static final CardTypeAndPriority LiveMiniApp = null;
    public static final CardTypeAndPriority MicRoomFollowCard = null;
    public static final CardTypeAndPriority PaidLiveInteract = null;
    public static final CardTypeAndPriority PaidLiveShareTicket = null;
    public static final CardTypeAndPriority PaidLiveTicketSale = null;
    public static final CardTypeAndPriority PaidLiveTrialPayGuide = null;
    public static final CardTypeAndPriority PaidProfile = null;
    public static final CardTypeAndPriority Test = null;
    public static final CardTypeAndPriority Unknown = null;
    public static final CardTypeAndPriority VSEpisodeInteract = null;
    public static final CardTypeAndPriority VideoTalk = null;
    public static final CardTypeAndPriority WatchVideo = null;
    public static final CardTypeAndPriority WelfareProject = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CardTypeAndPriority[] f98988a = null;
    private final String desc;
    private final int priority;
    private final String type;

    public static CardTypeAndPriority valueOf(String r100) {
        return (CardTypeAndPriority) a.a(CardTypeAndPriority.class, r100);
    }

    public static CardTypeAndPriority[] values() {
        return (CardTypeAndPriority[]) f98988a.clone();
    }

    static {
        CardTypeAndPriority r100 = new CardTypeAndPriority("Test", 0, "Test", 9999, "测试卡片");
        Test = r100;
        CardTypeAndPriority r101 = new CardTypeAndPriority("Unknown", 1, "Unknown", 0, "未知卡片");
        Unknown = r101;
        CardTypeAndPriority r102 = new CardTypeAndPriority("LightFeedback", 2, "FeedbackBanner", 1000, "满意度反馈");
        LightFeedback = r102;
        CardTypeAndPriority r103 = new CardTypeAndPriority("AnchorPkFeedback", 3, "FeedbackBanner", 1000, "主播pk反馈");
        AnchorPkFeedback = r103;
        CardTypeAndPriority r104 = new CardTypeAndPriority("LiveAppWidgetGuide", 4, "LiveAppWidgetGuide", 1000, "直播桌面组件引导");
        LiveAppWidgetGuide = r104;
        CardTypeAndPriority r105 = new CardTypeAndPriority("Banner", 5, "Banner", 1100, "右下角banner");
        Banner = r105;
        CardTypeAndPriority r106 = new CardTypeAndPriority("DrawAndGuess", 6, "GamePlayerWindow", 1200, "你画我猜");
        DrawAndGuess = r106;
        CardTypeAndPriority r107 = new CardTypeAndPriority("WatchVideo", 7, "AnchorVideoPlay", 1200, "主播看视频");
        WatchVideo = r107;
        CardTypeAndPriority r108 = new CardTypeAndPriority("AudienceLink", 8, "StrongReminder", 1200, "观众连线（两个人，右下角有小窗");
        AudienceLink = r108;
        CardTypeAndPriority r109 = new CardTypeAndPriority("VideoTalk", 9, "BigPartyLinkMic", 1200, "聊天室，在右边的那种");
        VideoTalk = r109;
        CardTypeAndPriority r110 = new CardTypeAndPriority("VSEpisodeInteract", 10, "VSEpisodeInteract", 1300, "节目互动组件");
        VSEpisodeInteract = r110;
        CardTypeAndPriority r111 = new CardTypeAndPriority("MicRoomFollowCard", 11, "MicRoomFollowCard", 1300, "麦序房关注卡片");
        MicRoomFollowCard = r111;
        CardTypeAndPriority r112 = new CardTypeAndPriority("KtvOrder", 12, "KTVOrderSongEntrance", 1400, "ktv点歌单");
        KtvOrder = r112;
        CardTypeAndPriority r113 = new CardTypeAndPriority("PaidProfile", 13, "PaidProfile", 1500, "付费连线讲解卡");
        PaidProfile = r113;
        CardTypeAndPriority r114 = new CardTypeAndPriority("LiveMiniApp", 14, "LiveMiniApp", 1600, "直播小程序卡");
        LiveMiniApp = r114;
        CardTypeAndPriority r115 = new CardTypeAndPriority("AssembledIntroduceCard", 15, "AssembledIntroduceCard", 1600, "聚合讲解卡，电商、游戏、团购、小程序、小风车、本地生活……，通过RightCardPlaceHolder实现的都是这个卡");
        AssembledIntroduceCard = r115;
        CardTypeAndPriority r116 = new CardTypeAndPriority("WelfareProject", 16, "WelfareProject", 1600, "公益组件卡");
        WelfareProject = r116;
        CardTypeAndPriority r117 = new CardTypeAndPriority("PaidLiveInteract", 17, "PaywallVoteView", 1700, "付费互动组件");
        PaidLiveInteract = r117;
        CardTypeAndPriority r118 = new CardTypeAndPriority("PaidLiveTicketSale", 18, "PaywallTicketCard", 1800, "付费直播售票讲解卡");
        PaidLiveTicketSale = r118;
        CardTypeAndPriority r119 = new CardTypeAndPriority("PaidLiveShareTicket", 19, "PaidLiveShareTicket", 1900, "付费金主感知赠票卡（助力票）");
        PaidLiveShareTicket = r119;
        CardTypeAndPriority r120 = new CardTypeAndPriority("PaidLiveTrialPayGuide", 20, "PaidLiveTrialPayGuide", 2000, "付费试看引导");
        PaidLiveTrialPayGuide = r120;
        CardTypeAndPriority r121 = new CardTypeAndPriority("BottomBannerReadPackage", 21, "bottomBannerReadPackage", 3000, "右下角banner红包优先级");
        BottomBannerReadPackage = r121;
        CardTypeAndPriority r122 = new CardTypeAndPriority("GiftLynxCard", 22, "GiftLynxCard", 4000, "礼物lynx卡片");
        GiftLynxCard = r122;
        f98988a = new CardTypeAndPriority[]{r100, r101, r102, r103, r104, r105, r106, r107, r108, r109, r110, r111, r112, r113, r114, r115, r116, r117, r118, r119, r120, r121, r122};
    }

    public final int getPriority() {
        return this.priority;
    }

    public final String getType() {
        return this.type;
    }

    public CardTypeAndPriority(String r100, int r101, String r102, int r103, String r104) {
        super(r100, r101);
        this.type = r102;
        this.priority = r103;
        this.desc = r104;
    }
}
