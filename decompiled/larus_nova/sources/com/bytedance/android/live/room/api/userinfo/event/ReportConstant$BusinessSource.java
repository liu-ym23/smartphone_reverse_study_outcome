package com.bytedance.android.live.room.api.userinfo.event;

import com.bytedance.android.livesdk.action.instance.ShareAction;
import r27.a;

/* JADX INFO: loaded from: classes47.dex */
public final enum ReportConstant$BusinessSource extends Enum<ReportConstant$BusinessSource> {
    public static final ReportConstant$BusinessSource AudienceOperatePanel = null;
    public static final ReportConstant$BusinessSource InputPanel = null;
    public static final ReportConstant$BusinessSource LandscapeScreenShot = null;
    public static final ReportConstant$BusinessSource LiveRoomFragmentDislikeMenu = null;
    public static final ReportConstant$BusinessSource LiveRoomFragmentDislikeOrHideMenu = null;
    public static final ReportConstant$BusinessSource LongPressPanel = null;
    public static final ReportConstant$BusinessSource ManagePanel = null;
    public static final ReportConstant$BusinessSource MorePanelReportButton = null;
    public static final ReportConstant$BusinessSource MorePanelShareButton = null;
    public static final ReportConstant$BusinessSource MultiLinkGuestLink = null;
    public static final ReportConstant$BusinessSource MysteriousManProfile = null;
    public static final ReportConstant$BusinessSource NewProfile = null;
    public static final ReportConstant$BusinessSource OldProfile = null;
    public static final ReportConstant$BusinessSource PreviewShareButton = null;
    public static final ReportConstant$BusinessSource ReportAnonymityComment = null;
    public static final ReportConstant$BusinessSource ReportJSB = null;
    public static final ReportConstant$BusinessSource RoomChannelLinkManagePanel = null;
    public static final ReportConstant$BusinessSource ScreenShot = null;
    public static final ReportConstant$BusinessSource ShareAction = null;
    public static final ReportConstant$BusinessSource VSMorePanelShareButton = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ReportConstant$BusinessSource[] f99154a = null;
    private final String businessType;
    private final String description;

    static {
        ReportConstant$BusinessSource r100 = new ReportConstant$BusinessSource("MysteriousManProfile", 0, "MysteriousMan", "神秘人资料卡");
        MysteriousManProfile = r100;
        ReportConstant$BusinessSource r101 = new ReportConstant$BusinessSource("NewProfile", 1, "NewProfile", "新版资料卡");
        NewProfile = r101;
        ReportConstant$BusinessSource r102 = new ReportConstant$BusinessSource("OldProfile", 2, "OldProfile", "旧版资料卡");
        OldProfile = r102;
        ReportConstant$BusinessSource r103 = new ReportConstant$BusinessSource("ManagePanel", 3, "ManagePanel", "管理面板");
        ManagePanel = r103;
        ReportConstant$BusinessSource r104 = new ReportConstant$BusinessSource("AudienceOperatePanel", 4, "AudienceOperatePanel", "用户侧公屏操作面板");
        AudienceOperatePanel = r104;
        ReportConstant$BusinessSource r105 = new ReportConstant$BusinessSource("ReportAnonymityComment", 5, "ReportAnonymityComment", "举报匿名直播间评论");
        ReportAnonymityComment = r105;
        ReportConstant$BusinessSource r110 = new ReportConstant$BusinessSource("ReportJSB", 6, "ReportJSB", "前端调用举报JSB");
        ReportJSB = r110;
        ReportConstant$BusinessSource r111 = new ReportConstant$BusinessSource("InputPanel", 7, "CommentAssociation", "输入面板文字联想唤起举报页面");
        InputPanel = r111;
        ReportConstant$BusinessSource r112 = new ReportConstant$BusinessSource(ShareAction.TAG, 8, ShareAction.TAG, ShareAction.TAG);
        ShareAction = r112;
        ReportConstant$BusinessSource r113 = new ReportConstant$BusinessSource("MorePanelReportButton", 9, "MorePanelReportButton", "更多面板举报按钮");
        MorePanelReportButton = r113;
        ReportConstant$BusinessSource r114 = new ReportConstant$BusinessSource("MorePanelShareButton", 10, "MorePanelShareButton", "更多面板分享按钮");
        MorePanelShareButton = r114;
        ReportConstant$BusinessSource r115 = new ReportConstant$BusinessSource("PreviewShareButton", 11, "PreviewShareButton", "预览流分享按钮");
        PreviewShareButton = r115;
        ReportConstant$BusinessSource r106 = new ReportConstant$BusinessSource("LongPressPanel", 12, "LongPressPanel", "长按面板举报");
        LongPressPanel = r106;
        ReportConstant$BusinessSource r107 = new ReportConstant$BusinessSource("LiveRoomFragmentDislikeMenu", 13, "LiveRoomFragmentDislikeMenu", "LiveRoomFragment不喜欢菜单");
        LiveRoomFragmentDislikeMenu = r107;
        ReportConstant$BusinessSource r108 = new ReportConstant$BusinessSource("LiveRoomFragmentDislikeOrHideMenu", 14, "LiveRoomFragmentDislikeOrHideMenu", "LiveRoomFragment附带清屏功能的不喜欢菜单");
        LiveRoomFragmentDislikeOrHideMenu = r108;
        ReportConstant$BusinessSource r109 = new ReportConstant$BusinessSource("VSMorePanelShareButton", 15, "MorePanelShareButton", "VS侧更多面板分享按钮");
        VSMorePanelShareButton = r109;
        ReportConstant$BusinessSource r116 = new ReportConstant$BusinessSource("RoomChannelLinkManagePanel", 16, "RoomChannelLinkManagePanel", "频道房语音成员管理面板");
        RoomChannelLinkManagePanel = r116;
        ReportConstant$BusinessSource r117 = new ReportConstant$BusinessSource("ScreenShot", 17, "ScreenShot", "截屏举报");
        ScreenShot = r117;
        ReportConstant$BusinessSource r118 = new ReportConstant$BusinessSource("LandscapeScreenShot", 18, "LandscapeScreenShot", "横屏截屏举报");
        LandscapeScreenShot = r118;
        ReportConstant$BusinessSource r119 = new ReportConstant$BusinessSource("MultiLinkGuestLink", 19, "GuestLink", "多人场景嘉宾连线功能举报");
        MultiLinkGuestLink = r119;
        f99154a = new ReportConstant$BusinessSource[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r106, r107, r108, r109, r116, r117, r118, r119};
    }

    public static ReportConstant$BusinessSource[] values() {
        return (ReportConstant$BusinessSource[]) f99154a.clone();
    }

    public String getBusinessType() {
        return this.businessType;
    }

    public static ReportConstant$BusinessSource valueOf(String r100) {
        return (ReportConstant$BusinessSource) a.a(ReportConstant$BusinessSource.class, r100);
    }

    public ReportConstant$BusinessSource(String r100, int r101, String r102, String r103) {
        super(r100, r101);
        this.businessType = r102;
        this.description = r103;
    }
}
