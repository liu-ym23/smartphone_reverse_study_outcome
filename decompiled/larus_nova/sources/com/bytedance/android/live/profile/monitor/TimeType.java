package com.bytedance.android.live.profile.monitor;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u001a\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001b¨\u0006\u001c"}, d2 = {"Lcom/bytedance/android/live/profile/monitor/TimeType;", "", "", "key", "Ljava/lang/String;", "getKey", "()Ljava/lang/String;", "description", "getDescription", "ReceiveOpenProfileEvent", "RequestStart", "RequestEnd", "DialogOnCreate", "DialogOnActivityCreated", "DialogOnCreateDialog", "DialogOnDismiss", "InflateViewStart", "InflateViewEnd", "DialogOnViewCreated", "AssemblePanelStart", "AssemblePanelEnd", "PrepareEnterAnim", "EnterAnimStart", "EnterAnimEnd", "ExitAnimStart", "ExitAnimEnd", "OpenPreLoadPanel", "FinalDataAvailable", "live-profile-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum TimeType extends Enum<TimeType> {
    public static final TimeType AssemblePanelEnd = null;
    public static final TimeType AssemblePanelStart = null;
    public static final TimeType DialogOnActivityCreated = null;
    public static final TimeType DialogOnCreate = null;
    public static final TimeType DialogOnCreateDialog = null;
    public static final TimeType DialogOnDismiss = null;
    public static final TimeType DialogOnViewCreated = null;
    public static final TimeType EnterAnimEnd = null;
    public static final TimeType EnterAnimStart = null;
    public static final TimeType ExitAnimEnd = null;
    public static final TimeType ExitAnimStart = null;
    public static final TimeType FinalDataAvailable = null;
    public static final TimeType InflateViewEnd = null;
    public static final TimeType InflateViewStart = null;
    public static final TimeType OpenPreLoadPanel = null;
    public static final TimeType PrepareEnterAnim = null;
    public static final TimeType ReceiveOpenProfileEvent = null;
    public static final TimeType RequestEnd = null;
    public static final TimeType RequestStart = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ TimeType[] f86098a = null;
    private final String description;
    private final String key;

    public static TimeType valueOf(String r100) {
        return (TimeType) a.a(TimeType.class, r100);
    }

    public static TimeType[] values() {
        return (TimeType[]) f86098a.clone();
    }

    static {
        TimeType r100 = new TimeType("ReceiveOpenProfileEvent", 0, "time_receive_open_profile_event", "接收到打开资料卡的事件");
        ReceiveOpenProfileEvent = r100;
        TimeType r101 = new TimeType("RequestStart", 1, "time_request_start", "发起请求");
        RequestStart = r101;
        TimeType r102 = new TimeType("RequestEnd", 2, "time_request_end", "请求结束");
        RequestEnd = r102;
        TimeType r103 = new TimeType("DialogOnCreate", 3, "time_dialog_on_create", "面板onCreate回调");
        DialogOnCreate = r103;
        TimeType r104 = new TimeType("DialogOnActivityCreated", 4, "time_dialog_on_activity_created", "面板onActivityCreated");
        DialogOnActivityCreated = r104;
        TimeType r105 = new TimeType("DialogOnCreateDialog", 5, "time_dialog_on_create_dialog", "面板onCreateDialog");
        DialogOnCreateDialog = r105;
        TimeType r106 = new TimeType("DialogOnDismiss", 6, "time_dialog_on_dismiss", "面板onDismiss");
        DialogOnDismiss = r106;
        TimeType r107 = new TimeType("InflateViewStart", 7, "time_inflate_view_start", "开始解析资料卡布局");
        InflateViewStart = r107;
        TimeType r108 = new TimeType("InflateViewEnd", 8, "time_inflate_view_end", "解析资料卡布局完成");
        InflateViewEnd = r108;
        TimeType r109 = new TimeType("DialogOnViewCreated", 9, "time_dialog_on_view_created", "面板onViewCreated");
        DialogOnViewCreated = r109;
        TimeType r110 = new TimeType("AssemblePanelStart", 10, "time_assemble_panel_start", "开始组装面板");
        AssemblePanelStart = r110;
        TimeType r111 = new TimeType("AssemblePanelEnd", 11, "time_assemble_panel_end", "组装面板结束");
        AssemblePanelEnd = r111;
        TimeType r112 = new TimeType("PrepareEnterAnim", 12, "time_prepare_enter_anim", "准备入场动画");
        PrepareEnterAnim = r112;
        TimeType r113 = new TimeType("EnterAnimStart", 13, "time_enter_anim_start", "入场动画开始");
        EnterAnimStart = r113;
        TimeType r114 = new TimeType("EnterAnimEnd", 14, "time_enter_anim_end", "入场动画结束");
        EnterAnimEnd = r114;
        TimeType r115 = new TimeType("ExitAnimStart", 15, "time_exit_anim_start", "出场动画开始");
        ExitAnimStart = r115;
        TimeType r116 = new TimeType("ExitAnimEnd", 16, "time_exit_anim_end", "出场动画结束");
        ExitAnimEnd = r116;
        TimeType r117 = new TimeType("OpenPreLoadPanel", 17, "time_open_preload_panel", "打开预加载面板");
        OpenPreLoadPanel = r117;
        TimeType r118 = new TimeType("FinalDataAvailable", 18, "time_final_data_available", "最终数据可用");
        FinalDataAvailable = r118;
        f86098a = new TimeType[]{r100, r101, r102, r103, r104, r105, r106, r107, r108, r109, r110, r111, r112, r113, r114, r115, r116, r117, r118};
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getKey() {
        return this.key;
    }

    public TimeType(String r100, int r101, String r102, String r103) {
        super(r100, r101);
        this.key = r102;
        this.description = r103;
    }
}
