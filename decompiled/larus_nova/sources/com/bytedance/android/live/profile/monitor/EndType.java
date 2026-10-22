package com.bytedance.android.live.profile.monitor;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0016\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001c¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/live/profile/monitor/EndType;", "", "", "stateCode", "I", "getStateCode", "()I", "", "description", "Ljava/lang/String;", "getDescription", "()Ljava/lang/String;", "Success", "DialogShowing", "ProfileLauncherShowing", "TransitionProfileLauncherShowing", "ActivityNullOrPause", "RoomIllegal", "HideProfile", "NetworkRequesting", "HostFragmentInfoErr", "NetworkRequestError", "Dismissed", "ClickFrequently", "ViewInvalid", "EventIsNull", "HideProfileWithReportDialog", "BroadcastPluginLoadFailed", "Unlogin", "live-profile-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum EndType extends Enum<EndType> {
    public static final EndType ActivityNullOrPause = null;
    public static final EndType BroadcastPluginLoadFailed = null;
    public static final EndType ClickFrequently = null;
    public static final EndType DialogShowing = null;
    public static final EndType Dismissed = null;
    public static final EndType EventIsNull = null;
    public static final EndType HideProfile = null;
    public static final EndType HideProfileWithReportDialog = null;
    public static final EndType HostFragmentInfoErr = null;
    public static final EndType NetworkRequestError = null;
    public static final EndType NetworkRequesting = null;
    public static final EndType ProfileLauncherShowing = null;
    public static final EndType RoomIllegal = null;
    public static final EndType Success = null;
    public static final EndType TransitionProfileLauncherShowing = null;
    public static final EndType Unlogin = null;
    public static final EndType ViewInvalid = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ EndType[] f86088a = null;
    private final String description;
    private final int stateCode;

    public static EndType valueOf(String r100) {
        return (EndType) a.a(EndType.class, r100);
    }

    public static EndType[] values() {
        return (EndType[]) f86088a.clone();
    }

    static {
        EndType r100 = new EndType("Success", 0, 0, "成功");
        Success = r100;
        EndType r101 = new EndType("DialogShowing", 1, 1, "资料卡面板正在展示");
        DialogShowing = r101;
        EndType r102 = new EndType("ProfileLauncherShowing", 2, 2, "接口launcher正在请求中，或面板正在展示");
        ProfileLauncherShowing = r102;
        EndType r103 = new EndType("TransitionProfileLauncherShowing", 3, 3, "过渡特效launcher正在请求中，或面板正在展示中");
        TransitionProfileLauncherShowing = r103;
        EndType r104 = new EndType("ActivityNullOrPause", 4, 4, "activity为空，或交互层被暂停");
        ActivityNullOrPause = r104;
        EndType r105 = new EndType("RoomIllegal", 5, 5, "room信息不合法");
        RoomIllegal = r105;
        EndType r106 = new EndType("HideProfile", 6, 6, "直播间不允许打开资料卡，toast拦截");
        HideProfile = r106;
        EndType r107 = new EndType("NetworkRequesting", 7, 7, "profile接口正在请求");
        NetworkRequesting = r107;
        EndType r108 = new EndType("HostFragmentInfoErr", 8, 8, "fragmentActivity信息错误");
        HostFragmentInfoErr = r108;
        EndType r109 = new EndType("NetworkRequestError", 9, 9, "profile接口报错");
        NetworkRequestError = r109;
        EndType r110 = new EndType("Dismissed", 10, 10, "请求成功，但是资料卡已经被取消");
        Dismissed = r110;
        EndType r111 = new EndType("ClickFrequently", 11, 11, "点击过于频繁");
        ClickFrequently = r111;
        EndType r112 = new EndType("ViewInvalid", 12, 12, "view无效");
        ViewInvalid = r112;
        EndType r113 = new EndType("EventIsNull", 13, 13, "UserProfileEvent为null");
        EventIsNull = r113;
        EndType r114 = new EndType("HideProfileWithReportDialog", 14, 14, "直播间不允许打开资料卡，吊起了举报面板");
        HideProfileWithReportDialog = r114;
        EndType r115 = new EndType("BroadcastPluginLoadFailed", 15, 15, "开播插件加载失败");
        BroadcastPluginLoadFailed = r115;
        EndType r116 = new EndType("Unlogin", 16, 16, "未登录时不支持打开资料卡");
        Unlogin = r116;
        f86088a = new EndType[]{r100, r101, r102, r103, r104, r105, r106, r107, r108, r109, r110, r111, r112, r113, r114, r115, r116};
    }

    public final String getDescription() {
        return this.description;
    }

    public final int getStateCode() {
        return this.stateCode;
    }

    public EndType(String r100, int r101, int r102, String r103) {
        super(r100, r101);
        this.stateCode = r102;
        this.description = r103;
    }
}
