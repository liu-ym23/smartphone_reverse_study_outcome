package com.bytedance.android.format.model.message;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b1\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%j\u0002\b&j\u0002\b'j\u0002\b(j\u0002\b)j\u0002\b*j\u0002\b+j\u0002\b,j\u0002\b-j\u0002\b.j\u0002\b/j\u0002\b0j\u0002\b1j\u0002\b2¨\u00063"}, d2 = {"Lcom/bytedance/android/format/model/message/LiveMsgType;", "", "", "type", "I", "getType", "()I", "LiveMsgType_Invalid", "LiveMsgType_PingReq", "LiveMsgType_PingResp", "LiveMsgType_ChatReq", "LiveMsgType_ChatResp", "LiveMsgType_ReportLiveVideoProgressReq", "LiveMsgType_ReportLiveVideoProgressResp", "LiveMsgType_PrepareLiveTextReq", "LiveMsgType_PrepareLiveTextResp", "LiveMsgType_StartLiveTextReq", "LiveMsgType_StartLiveTextResp", "LiveMsgType_PromotionCardFlush", "LiveMsgType_LeaveRoom", "LiveMsgType_OfflineVideoPlayProgress", "LiveMsgType_OfflineVideoPlayEnd", "LiveMsgType_ClickEnterRoom", "LiveMsgType_OnlineUserStatus", "LiveMsgType_SliceSchedule", "LiveMsgType_ClientInterrupt", "LiveMsgType_SwitchChapterBg", "LiveMsgType_CustomConfigChangeReq", "LiveMsgType_TalkStart", "LiveMsgType_TouchGuide", "LiveMsgType_FinishedTouchGuide", "LiveMsgType_EnterContainer", "LiveMsgType_LeaveContainer", "LiveMsgType_OpeningChatReq", "LiveMsgType_LiveMsgType_Sug", "LiveMsgType_PlayGameStart", "LiveMsgType_PlayGameEnd", "LiveMsgType_MsgRecalled", "LiveMsgType_PlayAnimation", "LiveMsgType_AudioStart", "LiveMsgType_FinishLoadingForChangeScene", "LiveMsgType_ChargeGameStart", "LiveMsgType_ChargeGameEnd", "LiveMsgType_SugDisappear", "LiveMsgType_CarouselComponentUpdate", "LiveMsgType_StartPlayScheduleVideo", "LiveMsgType_KeyMemoryUpdated", "LiveMsgType_IceBreakingReceived", "LiveMsgType_Sug", "LiveMsgType_ShowUpCompleted", "LiveMsgType_PassThroughMetricsEvent", "format-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum LiveMsgType extends Enum<LiveMsgType> {
    public static final LiveMsgType LiveMsgType_AudioStart = null;
    public static final LiveMsgType LiveMsgType_CarouselComponentUpdate = null;
    public static final LiveMsgType LiveMsgType_ChargeGameEnd = null;
    public static final LiveMsgType LiveMsgType_ChargeGameStart = null;
    public static final LiveMsgType LiveMsgType_ChatReq = null;
    public static final LiveMsgType LiveMsgType_ChatResp = null;
    public static final LiveMsgType LiveMsgType_ClickEnterRoom = null;
    public static final LiveMsgType LiveMsgType_ClientInterrupt = null;
    public static final LiveMsgType LiveMsgType_CustomConfigChangeReq = null;
    public static final LiveMsgType LiveMsgType_EnterContainer = null;
    public static final LiveMsgType LiveMsgType_FinishLoadingForChangeScene = null;
    public static final LiveMsgType LiveMsgType_FinishedTouchGuide = null;
    public static final LiveMsgType LiveMsgType_IceBreakingReceived = null;
    public static final LiveMsgType LiveMsgType_Invalid = null;
    public static final LiveMsgType LiveMsgType_KeyMemoryUpdated = null;
    public static final LiveMsgType LiveMsgType_LeaveContainer = null;
    public static final LiveMsgType LiveMsgType_LeaveRoom = null;
    public static final LiveMsgType LiveMsgType_LiveMsgType_Sug = null;
    public static final LiveMsgType LiveMsgType_MsgRecalled = null;
    public static final LiveMsgType LiveMsgType_OfflineVideoPlayEnd = null;
    public static final LiveMsgType LiveMsgType_OfflineVideoPlayProgress = null;
    public static final LiveMsgType LiveMsgType_OnlineUserStatus = null;
    public static final LiveMsgType LiveMsgType_OpeningChatReq = null;
    public static final LiveMsgType LiveMsgType_PassThroughMetricsEvent = null;
    public static final LiveMsgType LiveMsgType_PingReq = null;
    public static final LiveMsgType LiveMsgType_PingResp = null;
    public static final LiveMsgType LiveMsgType_PlayAnimation = null;
    public static final LiveMsgType LiveMsgType_PlayGameEnd = null;
    public static final LiveMsgType LiveMsgType_PlayGameStart = null;
    public static final LiveMsgType LiveMsgType_PrepareLiveTextReq = null;
    public static final LiveMsgType LiveMsgType_PrepareLiveTextResp = null;
    public static final LiveMsgType LiveMsgType_PromotionCardFlush = null;
    public static final LiveMsgType LiveMsgType_ReportLiveVideoProgressReq = null;
    public static final LiveMsgType LiveMsgType_ReportLiveVideoProgressResp = null;
    public static final LiveMsgType LiveMsgType_ShowUpCompleted = null;
    public static final LiveMsgType LiveMsgType_SliceSchedule = null;
    public static final LiveMsgType LiveMsgType_StartLiveTextReq = null;
    public static final LiveMsgType LiveMsgType_StartLiveTextResp = null;
    public static final LiveMsgType LiveMsgType_StartPlayScheduleVideo = null;
    public static final LiveMsgType LiveMsgType_Sug = null;
    public static final LiveMsgType LiveMsgType_SugDisappear = null;
    public static final LiveMsgType LiveMsgType_SwitchChapterBg = null;
    public static final LiveMsgType LiveMsgType_TalkStart = null;
    public static final LiveMsgType LiveMsgType_TouchGuide = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LiveMsgType[] f51357a = null;
    private final int type;

    public static LiveMsgType valueOf(String r100) {
        return (LiveMsgType) a.a(LiveMsgType.class, r100);
    }

    public static LiveMsgType[] values() {
        return (LiveMsgType[]) f51357a.clone();
    }

    static {
        LiveMsgType r100 = new LiveMsgType("LiveMsgType_Invalid", 0, 0);
        LiveMsgType_Invalid = r100;
        LiveMsgType r101 = new LiveMsgType("LiveMsgType_PingReq", 1, 1);
        LiveMsgType_PingReq = r101;
        LiveMsgType r102 = new LiveMsgType("LiveMsgType_PingResp", 2, 2);
        LiveMsgType_PingResp = r102;
        LiveMsgType r103 = new LiveMsgType("LiveMsgType_ChatReq", 3, 3);
        LiveMsgType_ChatReq = r103;
        LiveMsgType r104 = new LiveMsgType("LiveMsgType_ChatResp", 4, 4);
        LiveMsgType_ChatResp = r104;
        LiveMsgType r105 = new LiveMsgType("LiveMsgType_ReportLiveVideoProgressReq", 5, 5);
        LiveMsgType_ReportLiveVideoProgressReq = r105;
        LiveMsgType r106 = new LiveMsgType("LiveMsgType_ReportLiveVideoProgressResp", 6, 6);
        LiveMsgType_ReportLiveVideoProgressResp = r106;
        LiveMsgType r107 = new LiveMsgType("LiveMsgType_PrepareLiveTextReq", 7, 9);
        LiveMsgType_PrepareLiveTextReq = r107;
        LiveMsgType r108 = new LiveMsgType("LiveMsgType_PrepareLiveTextResp", 8, 10);
        LiveMsgType_PrepareLiveTextResp = r108;
        LiveMsgType r109 = new LiveMsgType("LiveMsgType_StartLiveTextReq", 9, 11);
        LiveMsgType_StartLiveTextReq = r109;
        LiveMsgType r110 = new LiveMsgType("LiveMsgType_StartLiveTextResp", 10, 12);
        LiveMsgType_StartLiveTextResp = r110;
        LiveMsgType r111 = new LiveMsgType("LiveMsgType_PromotionCardFlush", 11, 13);
        LiveMsgType_PromotionCardFlush = r111;
        LiveMsgType r112 = new LiveMsgType("LiveMsgType_LeaveRoom", 12, 14);
        LiveMsgType_LeaveRoom = r112;
        LiveMsgType r113 = new LiveMsgType("LiveMsgType_OfflineVideoPlayProgress", 13, 17);
        LiveMsgType_OfflineVideoPlayProgress = r113;
        LiveMsgType r114 = new LiveMsgType("LiveMsgType_OfflineVideoPlayEnd", 14, 19);
        LiveMsgType_OfflineVideoPlayEnd = r114;
        LiveMsgType r115 = new LiveMsgType("LiveMsgType_ClickEnterRoom", 15, 21);
        LiveMsgType_ClickEnterRoom = r115;
        LiveMsgType r116 = new LiveMsgType("LiveMsgType_OnlineUserStatus", 16, 22);
        LiveMsgType_OnlineUserStatus = r116;
        LiveMsgType r117 = new LiveMsgType("LiveMsgType_SliceSchedule", 17, 23);
        LiveMsgType_SliceSchedule = r117;
        LiveMsgType r118 = new LiveMsgType("LiveMsgType_ClientInterrupt", 18, 24);
        LiveMsgType_ClientInterrupt = r118;
        LiveMsgType r119 = new LiveMsgType("LiveMsgType_SwitchChapterBg", 19, 25);
        LiveMsgType_SwitchChapterBg = r119;
        LiveMsgType r120 = new LiveMsgType("LiveMsgType_CustomConfigChangeReq", 20, 26);
        LiveMsgType_CustomConfigChangeReq = r120;
        LiveMsgType r121 = new LiveMsgType("LiveMsgType_TalkStart", 21, 27);
        LiveMsgType_TalkStart = r121;
        LiveMsgType r122 = new LiveMsgType("LiveMsgType_TouchGuide", 22, 28);
        LiveMsgType_TouchGuide = r122;
        LiveMsgType r123 = new LiveMsgType("LiveMsgType_FinishedTouchGuide", 23, 29);
        LiveMsgType_FinishedTouchGuide = r123;
        LiveMsgType r124 = new LiveMsgType("LiveMsgType_EnterContainer", 24, 30);
        LiveMsgType_EnterContainer = r124;
        LiveMsgType r125 = new LiveMsgType("LiveMsgType_LeaveContainer", 25, 31);
        LiveMsgType_LeaveContainer = r125;
        LiveMsgType r126 = new LiveMsgType("LiveMsgType_OpeningChatReq", 26, 32);
        LiveMsgType_OpeningChatReq = r126;
        LiveMsgType r127 = new LiveMsgType("LiveMsgType_LiveMsgType_Sug", 27, 33);
        LiveMsgType_LiveMsgType_Sug = r127;
        LiveMsgType r128 = new LiveMsgType("LiveMsgType_PlayGameStart", 28, 34);
        LiveMsgType_PlayGameStart = r128;
        LiveMsgType r129 = new LiveMsgType("LiveMsgType_PlayGameEnd", 29, 35);
        LiveMsgType_PlayGameEnd = r129;
        LiveMsgType r130 = new LiveMsgType("LiveMsgType_MsgRecalled", 30, 36);
        LiveMsgType_MsgRecalled = r130;
        LiveMsgType r131 = new LiveMsgType("LiveMsgType_PlayAnimation", 31, 40);
        LiveMsgType_PlayAnimation = r131;
        LiveMsgType r132 = new LiveMsgType("LiveMsgType_AudioStart", 32, 45);
        LiveMsgType_AudioStart = r132;
        LiveMsgType r133 = new LiveMsgType("LiveMsgType_FinishLoadingForChangeScene", 33, 41);
        LiveMsgType_FinishLoadingForChangeScene = r133;
        LiveMsgType r134 = new LiveMsgType("LiveMsgType_ChargeGameStart", 34, 50);
        LiveMsgType_ChargeGameStart = r134;
        LiveMsgType r135 = new LiveMsgType("LiveMsgType_ChargeGameEnd", 35, 51);
        LiveMsgType_ChargeGameEnd = r135;
        LiveMsgType r136 = new LiveMsgType("LiveMsgType_SugDisappear", 36, 55);
        LiveMsgType_SugDisappear = r136;
        LiveMsgType r137 = new LiveMsgType("LiveMsgType_CarouselComponentUpdate", 37, 56);
        LiveMsgType_CarouselComponentUpdate = r137;
        LiveMsgType r138 = new LiveMsgType("LiveMsgType_StartPlayScheduleVideo", 38, 57);
        LiveMsgType_StartPlayScheduleVideo = r138;
        LiveMsgType r139 = new LiveMsgType("LiveMsgType_KeyMemoryUpdated", 39, 60);
        LiveMsgType_KeyMemoryUpdated = r139;
        LiveMsgType r140 = new LiveMsgType("LiveMsgType_IceBreakingReceived", 40, 61);
        LiveMsgType_IceBreakingReceived = r140;
        LiveMsgType r141 = new LiveMsgType("LiveMsgType_Sug", 41, 71);
        LiveMsgType_Sug = r141;
        LiveMsgType r142 = new LiveMsgType("LiveMsgType_ShowUpCompleted", 42, 62);
        LiveMsgType_ShowUpCompleted = r142;
        LiveMsgType r143 = new LiveMsgType("LiveMsgType_PassThroughMetricsEvent", 43, 98);
        LiveMsgType_PassThroughMetricsEvent = r143;
        f51357a = new LiveMsgType[]{r100, r101, r102, r103, r104, r105, r106, r107, r108, r109, r110, r111, r112, r113, r114, r115, r116, r117, r118, r119, r120, r121, r122, r123, r124, r125, r126, r127, r128, r129, r130, r131, r132, r133, r134, r135, r136, r137, r138, r139, r140, r141, r142, r143};
    }

    public final int getType() {
        return this.type;
    }

    public LiveMsgType(String r100, int r101, int r102) {
        super(r100, r101);
        this.type = r102;
    }
}
