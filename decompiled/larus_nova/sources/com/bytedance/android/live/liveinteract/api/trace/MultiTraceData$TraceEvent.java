package com.bytedance.android.live.liveinteract.api.trace;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b+\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001R\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u0017\u0010\b\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\b\u0010\u0005\u001a\u0004\b\t\u0010\u0007j\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%j\u0002\b&j\u0002\b'j\u0002\b(j\u0002\b)j\u0002\b*j\u0002\b+j\u0002\b,j\u0002\b-¨\u0006."}, d2 = {"com/bytedance/android/live/liveinteract/api/trace/MultiTraceData$TraceEvent", "", "Lcom/bytedance/android/live/liveinteract/api/trace/MultiTraceData$TraceEvent;", "", "eventName", "Ljava/lang/String;", "getEventName", "()Ljava/lang/String;", "eventDes", "getEventDes", "OPEN_LINKED_PANEL", "InviteAudienceLink", "AudienceApplyLink", "CloseLink", "RtcLinkError", "LinkMedia", "LinkPipeline", "OpenChatRoom", "SwitchScene", "EnterRoomStatistics", "OpenEnlargeGuest", "OPEN_ORDER_SONG_PANEL", "AddSongChain", "SongControl", "SingFlow", "MusicPlayFlow", "KtvFeatureSwitch", "MultiLinkDynamic", "AdventureCall", "AnimRenderPlatform", "AnchorCloudGame", "GuestCloudGame", "GameAvatarStart", "GameAvatarEnd", "InteractXplay", "ChorusInfoUpdate", "JoinChorus", "LeaveChorus", "ChorusFlow", "ChorusCDNStream", "ChorusCaptureStream", "LyricsRecognize", "GuestLinkerLink", "GuestLinkerMedia", "BackupSei", "LinkmicPanelOpen", "liveinteract-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum MultiTraceData$TraceEvent extends Enum<MultiTraceData$TraceEvent> {
    public static final MultiTraceData$TraceEvent AddSongChain = null;
    public static final MultiTraceData$TraceEvent AdventureCall = null;
    public static final MultiTraceData$TraceEvent AnchorCloudGame = null;
    public static final MultiTraceData$TraceEvent AnimRenderPlatform = null;
    public static final MultiTraceData$TraceEvent AudienceApplyLink = null;
    public static final MultiTraceData$TraceEvent BackupSei = null;
    public static final MultiTraceData$TraceEvent ChorusCDNStream = null;
    public static final MultiTraceData$TraceEvent ChorusCaptureStream = null;
    public static final MultiTraceData$TraceEvent ChorusFlow = null;
    public static final MultiTraceData$TraceEvent ChorusInfoUpdate = null;
    public static final MultiTraceData$TraceEvent CloseLink = null;
    public static final MultiTraceData$TraceEvent EnterRoomStatistics = null;
    public static final MultiTraceData$TraceEvent GameAvatarEnd = null;
    public static final MultiTraceData$TraceEvent GameAvatarStart = null;
    public static final MultiTraceData$TraceEvent GuestCloudGame = null;
    public static final MultiTraceData$TraceEvent GuestLinkerLink = null;
    public static final MultiTraceData$TraceEvent GuestLinkerMedia = null;
    public static final MultiTraceData$TraceEvent InteractXplay = null;
    public static final MultiTraceData$TraceEvent InviteAudienceLink = null;
    public static final MultiTraceData$TraceEvent JoinChorus = null;
    public static final MultiTraceData$TraceEvent KtvFeatureSwitch = null;
    public static final MultiTraceData$TraceEvent LeaveChorus = null;
    public static final MultiTraceData$TraceEvent LinkMedia = null;
    public static final MultiTraceData$TraceEvent LinkPipeline = null;
    public static final MultiTraceData$TraceEvent LinkmicPanelOpen = null;
    public static final MultiTraceData$TraceEvent LyricsRecognize = null;
    public static final MultiTraceData$TraceEvent MultiLinkDynamic = null;
    public static final MultiTraceData$TraceEvent MusicPlayFlow = null;
    public static final MultiTraceData$TraceEvent OPEN_LINKED_PANEL = null;
    public static final MultiTraceData$TraceEvent OPEN_ORDER_SONG_PANEL = null;
    public static final MultiTraceData$TraceEvent OpenChatRoom = null;
    public static final MultiTraceData$TraceEvent OpenEnlargeGuest = null;
    public static final MultiTraceData$TraceEvent RtcLinkError = null;
    public static final MultiTraceData$TraceEvent SingFlow = null;
    public static final MultiTraceData$TraceEvent SongControl = null;
    public static final MultiTraceData$TraceEvent SwitchScene = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MultiTraceData$TraceEvent[] f71496a = null;
    private final String eventDes;
    private final String eventName;

    public static MultiTraceData$TraceEvent valueOf(String r100) {
        return (MultiTraceData$TraceEvent) a.a(MultiTraceData$TraceEvent.class, r100);
    }

    public static MultiTraceData$TraceEvent[] values() {
        return (MultiTraceData$TraceEvent[]) f71496a.clone();
    }

    static {
        MultiTraceData$TraceEvent r100 = new MultiTraceData$TraceEvent("OPEN_LINKED_PANEL", 0, "open_linked_panel", "开启连线面板");
        OPEN_LINKED_PANEL = r100;
        MultiTraceData$TraceEvent r101 = new MultiTraceData$TraceEvent("InviteAudienceLink", 1, "InviteAudienceLink", "邀请观众连线");
        InviteAudienceLink = r101;
        MultiTraceData$TraceEvent r102 = new MultiTraceData$TraceEvent("AudienceApplyLink", 2, "AudienceApplyLink", "观众申请连线");
        AudienceApplyLink = r102;
        MultiTraceData$TraceEvent r103 = new MultiTraceData$TraceEvent("CloseLink", 3, "CloseLink", "断开连线");
        CloseLink = r103;
        MultiTraceData$TraceEvent r104 = new MultiTraceData$TraceEvent("RtcLinkError", 4, "RtcLinkError", "Rtc连线异常");
        RtcLinkError = r104;
        MultiTraceData$TraceEvent r105 = new MultiTraceData$TraceEvent("LinkMedia", 5, "LinkMedia", "连线音视频");
        LinkMedia = r105;
        MultiTraceData$TraceEvent r106 = new MultiTraceData$TraceEvent("LinkPipeline", 6, "LinkPipeline", "连线流程");
        LinkPipeline = r106;
        MultiTraceData$TraceEvent r107 = new MultiTraceData$TraceEvent("OpenChatRoom", 7, "OpenChatRoom", "主播开启聊天室");
        OpenChatRoom = r107;
        MultiTraceData$TraceEvent r108 = new MultiTraceData$TraceEvent("SwitchScene", 8, "SwitchScene", "主播切换布局");
        SwitchScene = r108;
        MultiTraceData$TraceEvent r109 = new MultiTraceData$TraceEvent("EnterRoomStatistics", 9, "EnterRoomStatistics", "看播进房耗时");
        EnterRoomStatistics = r109;
        MultiTraceData$TraceEvent r110 = new MultiTraceData$TraceEvent("OpenEnlargeGuest", 10, "OpenEnlargeGuest", "开启主咖");
        OpenEnlargeGuest = r110;
        MultiTraceData$TraceEvent r111 = new MultiTraceData$TraceEvent("OPEN_ORDER_SONG_PANEL", 11, "open_order_song_panel", "开启点歌面板");
        OPEN_ORDER_SONG_PANEL = r111;
        MultiTraceData$TraceEvent r112 = new MultiTraceData$TraceEvent("AddSongChain", 12, "AddSongChain", "点歌链路");
        AddSongChain = r112;
        MultiTraceData$TraceEvent r113 = new MultiTraceData$TraceEvent("SongControl", 13, "SongControl", "歌曲控制");
        SongControl = r113;
        MultiTraceData$TraceEvent r114 = new MultiTraceData$TraceEvent("SingFlow", 14, "SingFlow", "开唱流程");
        SingFlow = r114;
        MultiTraceData$TraceEvent r115 = new MultiTraceData$TraceEvent("MusicPlayFlow", 15, "MusicPlayFlow", "播放流程");
        MusicPlayFlow = r115;
        MultiTraceData$TraceEvent r116 = new MultiTraceData$TraceEvent("KtvFeatureSwitch", 16, "KtvFeatureSwitch", "功能开关");
        KtvFeatureSwitch = r116;
        MultiTraceData$TraceEvent r117 = new MultiTraceData$TraceEvent("MultiLinkDynamic", 17, "MultiLinkDynamic", "动态化框架");
        MultiLinkDynamic = r117;
        MultiTraceData$TraceEvent r118 = new MultiTraceData$TraceEvent("AdventureCall", 18, "AdventureCall", "奇遇连连通话流程");
        AdventureCall = r118;
        MultiTraceData$TraceEvent r119 = new MultiTraceData$TraceEvent("AnimRenderPlatform", 19, "AnimRenderPlatform", "动效渲染框架加载");
        AnimRenderPlatform = r119;
        MultiTraceData$TraceEvent r120 = new MultiTraceData$TraceEvent("AnchorCloudGame", 20, "AnchorXplayLoad", "主播云游戏链路");
        AnchorCloudGame = r120;
        MultiTraceData$TraceEvent r121 = new MultiTraceData$TraceEvent("GuestCloudGame", 21, "GuestXplayLoad", "嘉宾云游戏链路");
        GuestCloudGame = r121;
        MultiTraceData$TraceEvent r122 = new MultiTraceData$TraceEvent("GameAvatarStart", 22, "GameAvatarStart", "云游戏HamletAvatar开启链路");
        GameAvatarStart = r122;
        MultiTraceData$TraceEvent r123 = new MultiTraceData$TraceEvent("GameAvatarEnd", 23, "GameAvatarEnd", "云游戏HamletAvatar关闭链路");
        GameAvatarEnd = r123;
        MultiTraceData$TraceEvent r124 = new MultiTraceData$TraceEvent("InteractXplay", 24, "InteractXplayLoad", "云游戏开启链路");
        InteractXplay = r124;
        MultiTraceData$TraceEvent r125 = new MultiTraceData$TraceEvent("ChorusInfoUpdate", 25, "ChorusInfoUpdate", "合唱状态变更");
        ChorusInfoUpdate = r125;
        MultiTraceData$TraceEvent r126 = new MultiTraceData$TraceEvent("JoinChorus", 26, "JoinChorus", "加入合唱流程");
        JoinChorus = r126;
        MultiTraceData$TraceEvent r127 = new MultiTraceData$TraceEvent("LeaveChorus", 27, "LeaveChorus", "离开合唱流程");
        LeaveChorus = r127;
        MultiTraceData$TraceEvent r128 = new MultiTraceData$TraceEvent("ChorusFlow", 28, "ChorusFlow", "合唱中流程");
        ChorusFlow = r128;
        MultiTraceData$TraceEvent r129 = new MultiTraceData$TraceEvent("ChorusCDNStream", 29, "chorusCdnStreamPush", "合唱推流链路");
        ChorusCDNStream = r129;
        MultiTraceData$TraceEvent r130 = new MultiTraceData$TraceEvent("ChorusCaptureStream", 30, "chorusCapture", "合唱采集链路");
        ChorusCaptureStream = r130;
        MultiTraceData$TraceEvent r131 = new MultiTraceData$TraceEvent("LyricsRecognize", 31, "LyricsRecognize", "歌词识别流程");
        LyricsRecognize = r131;
        MultiTraceData$TraceEvent r132 = new MultiTraceData$TraceEvent("GuestLinkerLink", 32, "GuestLinkerLink", "嘉宾奇遇连线流程");
        GuestLinkerLink = r132;
        MultiTraceData$TraceEvent r133 = new MultiTraceData$TraceEvent("GuestLinkerMedia", 33, "GuestLinkerMedia", "嘉宾奇遇音视频链路");
        GuestLinkerMedia = r133;
        MultiTraceData$TraceEvent r134 = new MultiTraceData$TraceEvent("BackupSei", 34, "BackupSei", "备份SEI");
        BackupSei = r134;
        MultiTraceData$TraceEvent r135 = new MultiTraceData$TraceEvent("LinkmicPanelOpen", 35, "ttlive_linkmic_panel_open", "动态化面板");
        LinkmicPanelOpen = r135;
        f71496a = new MultiTraceData$TraceEvent[]{r100, r101, r102, r103, r104, r105, r106, r107, r108, r109, r110, r111, r112, r113, r114, r115, r116, r117, r118, r119, r120, r121, r122, r123, r124, r125, r126, r127, r128, r129, r130, r131, r132, r133, r134, r135};
    }

    public final String getEventDes() {
        return this.eventDes;
    }

    public final String getEventName() {
        return this.eventName;
    }

    public MultiTraceData$TraceEvent(String r100, int r101, String r102, String r103) {
        super(r100, r101);
        this.eventName = r102;
        this.eventDes = r103;
    }
}
