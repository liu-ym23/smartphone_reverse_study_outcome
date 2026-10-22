package com.bytedance.android.live.profile.monitor;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b>\b\u0086\u0001\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006j\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%j\u0002\b&j\u0002\b'j\u0002\b(j\u0002\b)j\u0002\b*j\u0002\b+j\u0002\b,j\u0002\b-j\u0002\b.j\u0002\b/j\u0002\b0j\u0002\b1j\u0002\b2j\u0002\b3j\u0002\b4j\u0002\b5j\u0002\b6j\u0002\b7j\u0002\b8j\u0002\b9j\u0002\b:j\u0002\b;j\u0002\b<j\u0002\b=j\u0002\b>j\u0002\b?¨\u0006@"}, d2 = {"Lcom/bytedance/android/live/profile/monitor/DataType;", "", "", "key", "Ljava/lang/String;", "getKey", "()Ljava/lang/String;", "description", "getDescription", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "MonitorVersion", "RequestSuccess", "ErrorCode", "State", "StateMsg", "TargetUid", "SecTargetUid", "WebcastUid", "IsAdmin", "IsToSelf", "IsToAnchor", "IsToUnionAnchor", "SelfIsAnchor", "IsRoomHideProfile", "IsForceSecret", "IsIntercomHideUserCard", "ClickUserPosition", "ReportSource", "IsSkipPrivacyCheck", "Source", "HideProfileCheckFirst", "HideProfile", "ForceShowProfile", "IsClearAndRecord", "ProfileOpenMode", "RequestLogId", "TargetDisplayRoleRequest", "TargetIsMysteryMan", "OptimizeIdentity", "ProfileMode", "PageType", "SelfUid", "RoomId", "IsShopDSL", "IsPreLoad", "GetCacheCount", "IsHitCache", "IsRefreshRequest", "UpdateTimeNode", "TTNetQuality", "LiveNetQuality", "OpenPanelCount", "OpenAnchorPanelCount", "TimeAfterEnterRoom", "AnchorId", "GetXmlCacheCount", "HitXmlCacheCount", "PreInflateType", "IsExistDialogShowing", "IsSkipExistPanelCheck", "IsMyLiveEnable", "IsMyLive", "IsPreOtherAnchor", "live-profile-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum DataType extends Enum<DataType> {
    public static final DataType AnchorId = null;
    public static final DataType ClickUserPosition = null;
    public static final a Companion = null;
    public static final DataType ErrorCode = null;
    public static final String FALSE = "0";
    public static final DataType ForceShowProfile = null;
    public static final DataType GetCacheCount = null;
    public static final DataType GetXmlCacheCount = null;
    public static final DataType HideProfile = null;
    public static final DataType HideProfileCheckFirst = null;
    public static final DataType HitXmlCacheCount = null;
    public static final DataType IsAdmin = null;
    public static final DataType IsClearAndRecord = null;
    public static final DataType IsExistDialogShowing = null;
    public static final DataType IsForceSecret = null;
    public static final DataType IsHitCache = null;
    public static final DataType IsIntercomHideUserCard = null;
    public static final DataType IsMyLive = null;
    public static final DataType IsMyLiveEnable = null;
    public static final DataType IsPreLoad = null;
    public static final DataType IsPreOtherAnchor = null;
    public static final DataType IsRefreshRequest = null;
    public static final DataType IsRoomHideProfile = null;
    public static final DataType IsShopDSL = null;
    public static final DataType IsSkipExistPanelCheck = null;
    public static final DataType IsSkipPrivacyCheck = null;
    public static final DataType IsToAnchor = null;
    public static final DataType IsToSelf = null;
    public static final DataType IsToUnionAnchor = null;
    public static final DataType LiveNetQuality = null;
    public static final DataType MonitorVersion = null;
    public static final String Normal = "normal";
    public static final DataType OpenAnchorPanelCount = null;
    public static final DataType OpenPanelCount = null;
    public static final DataType OptimizeIdentity = null;
    public static final DataType PageType = null;
    public static final DataType PreInflateType = null;
    public static final DataType ProfileMode = null;
    public static final DataType ProfileOpenMode = null;
    public static final DataType ReportSource = null;
    public static final DataType RequestLogId = null;
    public static final DataType RequestSuccess = null;
    public static final DataType RoomId = null;
    public static final DataType SecTargetUid = null;
    public static final DataType SelfIsAnchor = null;
    public static final DataType SelfUid = null;
    public static final DataType Source = null;
    public static final DataType State = null;
    public static final DataType StateMsg = null;
    public static final String TRUE = "1";
    public static final DataType TTNetQuality = null;
    public static final DataType TargetDisplayRoleRequest = null;
    public static final DataType TargetIsMysteryMan = null;
    public static final DataType TargetUid = null;
    public static final DataType TimeAfterEnterRoom = null;
    public static final String Transition = "transition";
    public static final DataType UpdateTimeNode = null;
    public static final DataType WebcastUid = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DataType[] f86087a = null;
    private final String description;
    private final String key;

    public static final class a {
        public a() {
        }
    }

    public static DataType valueOf(String r100) {
        return (DataType) r27.a.a(DataType.class, r100);
    }

    @JvmStatic
    public static final String valueOf(boolean r100) {
        Companion.getClass();
        if (r100 == false) goto L5;
        return "1";
    L5:
        return "0";
    }

    public static DataType[] values() {
        return (DataType[]) f86087a.clone();
    }

    static {
        DataType r100 = new DataType("MonitorVersion", 0, "data_monitor_version", "ProfileMonitor版本");
        MonitorVersion = r100;
        DataType r101 = new DataType("RequestSuccess", 1, "data_request_success", "请求成功或失败");
        RequestSuccess = r101;
        DataType r102 = new DataType("ErrorCode", 2, "data_error_code", "请求错误码");
        ErrorCode = r102;
        DataType r103 = new DataType("State", 3, "data_state", "最后结束的状态，具体见EndType");
        State = r103;
        DataType r104 = new DataType("StateMsg", 4, "data_state_msg", "结束状态的附加信息");
        StateMsg = r104;
        DataType r105 = new DataType("TargetUid", 5, "data_target_uid", "目标uid");
        TargetUid = r105;
        DataType r106 = new DataType("SecTargetUid", 6, "data_sec_target_uid", "secUid");
        SecTargetUid = r106;
        DataType r107 = new DataType("WebcastUid", 7, "data_webcast_uid", "匿名直播间的webcastUid");
        WebcastUid = r107;
        DataType r108 = new DataType("IsAdmin", 8, "data_is_admin", "自己是否是管理员");
        IsAdmin = r108;
        DataType r109 = new DataType("IsToSelf", 9, "data_is_to_self", "是否是看自己");
        IsToSelf = r109;
        DataType r110 = new DataType("IsToAnchor", 10, "data_is_to_anchor", "是否是看主播");
        IsToAnchor = r110;
        DataType r111 = new DataType("IsToUnionAnchor", 11, "data_is_to_union_anchor", "是否是看联合主播");
        IsToUnionAnchor = r111;
        DataType r112 = new DataType("SelfIsAnchor", 12, "data_self_is_anchor", "自己是否是主播");
        SelfIsAnchor = r112;
        DataType r113 = new DataType("IsRoomHideProfile", 13, "data_is_room_hide_profile", "直播间是否不允许打开资料卡");
        IsRoomHideProfile = r113;
        DataType r114 = new DataType("IsForceSecret", 14, "data_is_force_secret", "匿名直播间时，是否跳过主播和管理员权限，强制匿名");
        IsForceSecret = r114;
        DataType r115 = new DataType("IsIntercomHideUserCard", 15, "data_is_intercom_hide_user_card", "其他直播用户，不允许打开资料卡");
        IsIntercomHideUserCard = r115;
        DataType r116 = new DataType("ClickUserPosition", 16, "data_click_user_position", "点击区域");
        ClickUserPosition = r116;
        DataType r117 = new DataType("ReportSource", 17, "data_report_source", "举报来源");
        ReportSource = r117;
        DataType r118 = new DataType("IsSkipPrivacyCheck", 18, "data_is_skip_privacy_check", "是否跳过匿名直播间检查");
        IsSkipPrivacyCheck = r118;
        DataType r119 = new DataType("Source", 19, "data_source", "来源");
        Source = r119;
        DataType r120 = new DataType("HideProfileCheckFirst", 20, "data_hide_profile_check_first", "第一次匿名检查之后的结果");
        HideProfileCheckFirst = r120;
        DataType r121 = new DataType("HideProfile", 21, "data_hide_profile", "匿名直播间检查最终结果");
        HideProfile = r121;
        DataType r122 = new DataType("ForceShowProfile", 22, "data_force_show_profile", "强制打开资料卡，无视权限判断");
        ForceShowProfile = r122;
        DataType r123 = new DataType("IsClearAndRecord", 23, "data_is_clear_and_record", "是否处于清屏录屏状态");
        IsClearAndRecord = r123;
        DataType r124 = new DataType("ProfileOpenMode", 24, "data_profile_open_mode", "资料卡模式，正常or过渡");
        ProfileOpenMode = r124;
        DataType r125 = new DataType("RequestLogId", 25, "data_request_log_id", "请求的logId");
        RequestLogId = r125;
        DataType r126 = new DataType("TargetDisplayRoleRequest", 26, "data_target_display_role_request", "请求时判断的目标身份，未知、正常or神秘人");
        TargetDisplayRoleRequest = r126;
        DataType r127 = new DataType("TargetIsMysteryMan", 27, "data_target_is_mystery_man", "请求完成之后判断是否是神秘人");
        TargetIsMysteryMan = r127;
        DataType r128 = new DataType("OptimizeIdentity", 28, "data_optimize_identity", "资料卡链路");
        OptimizeIdentity = r128;
        DataType r129 = new DataType("ProfileMode", 29, "data_profile_mode", "资料卡模式");
        ProfileMode = r129;
        DataType r130 = new DataType("PageType", 30, "data_page_type", "资料卡视角");
        PageType = r130;
        DataType r131 = new DataType("SelfUid", 31, "data_self_uid", "自己的uid");
        SelfUid = r131;
        DataType r132 = new DataType("RoomId", 32, "data_room_id", "房间id");
        RoomId = r132;
        DataType r133 = new DataType("IsShopDSL", 33, "data_is_shop_dsl", "店铺区使用dsl");
        IsShopDSL = r133;
        DataType r134 = new DataType("IsPreLoad", 34, "data_is_preload", "是否是预加载链路");
        IsPreLoad = r134;
        DataType r135 = new DataType("GetCacheCount", 35, "data_get_cache_count", "当前是第几次获取缓存");
        GetCacheCount = r135;
        DataType r136 = new DataType("IsHitCache", 36, "data_is_hit_cache", "是否命中缓存");
        IsHitCache = r136;
        DataType r137 = new DataType("IsRefreshRequest", 37, "data_is_refresh_request", "是否是二次刷新请求");
        IsRefreshRequest = r137;
        DataType r138 = new DataType("UpdateTimeNode", 38, "data_update_time_node", "更新时机节点");
        UpdateTimeNode = r138;
        DataType r139 = new DataType("TTNetQuality", 39, "data_ttnet_quality", "TTNet统计的网络质量");
        TTNetQuality = r139;
        DataType r140 = new DataType("LiveNetQuality", 40, "data_livenet_quality", "直播统计的网络质量");
        LiveNetQuality = r140;
        DataType r141 = new DataType("OpenPanelCount", 41, "data_open_panel_count", "当前直播间内打开资料卡次数");
        OpenPanelCount = r141;
        DataType r142 = new DataType("OpenAnchorPanelCount", 42, "data_open_anchor_panel_count", "当前直播间内打开主播资料卡的次数");
        OpenAnchorPanelCount = r142;
        DataType r143 = new DataType("TimeAfterEnterRoom", 43, "data_time_after_enter_room", "进房之后多少毫秒点击打开资料卡");
        TimeAfterEnterRoom = r143;
        DataType r144 = new DataType("AnchorId", 44, "data_anchor_id", "主播id");
        AnchorId = r144;
        DataType r145 = new DataType("GetXmlCacheCount", 45, "data_get_xml_cache_count", "获取布局资源缓存次数");
        GetXmlCacheCount = r145;
        DataType r146 = new DataType("HitXmlCacheCount", 46, "data_hit_xml_cache_count", "命中布局资源缓存次数");
        HitXmlCacheCount = r146;
        DataType r147 = new DataType("PreInflateType", 47, "data_is_pre_inflate", "布局资源预加载类型");
        PreInflateType = r147;
        DataType r148 = new DataType("IsExistDialogShowing", 48, "data_is_exist_dialog_showing", "是否已有面板正在展示");
        IsExistDialogShowing = r148;
        DataType r149 = new DataType("IsSkipExistPanelCheck", 49, "data_is_skip_exist_panel_check", "是否跳过已有面板检查");
        IsSkipExistPanelCheck = r149;
        DataType r150 = new DataType("IsMyLiveEnable", 50, "data_is_my_live_enable", "用户是否命中我的直播实验");
        IsMyLiveEnable = r150;
        DataType r151 = new DataType("IsMyLive", 51, "data_is_my_live", "当前资料卡是否是我的直播模式");
        IsMyLive = r151;
        DataType r152 = new DataType("IsPreOtherAnchor", 52, "data_is_preload_other_anchor", "是否是预请求PK主播");
        IsPreOtherAnchor = r152;
        f86087a = new DataType[]{r100, r101, r102, r103, r104, r105, r106, r107, r108, r109, r110, r111, r112, r113, r114, r115, r116, r117, r118, r119, r120, r121, r122, r123, r124, r125, r126, r127, r128, r129, r130, r131, r132, r133, r134, r135, r136, r137, r138, r139, r140, r141, r142, r143, r144, r145, r146, r147, r148, r149, r150, r151, r152};
        Companion = new a();
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getKey() {
        return this.key;
    }

    public DataType(String r100, int r101, String r102, String r103) {
        super(r100, r101);
        this.key = r102;
        this.description = r103;
    }

    public /* synthetic */ DataType(String r100, int r101, String r102, String r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 2) == 0) goto L5;
        r103 = "";
    L5:
        this(r100, r101, r102, r103);
    }
}
