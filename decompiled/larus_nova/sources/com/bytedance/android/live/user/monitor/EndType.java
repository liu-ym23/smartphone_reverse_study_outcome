package com.bytedance.android.live.user.monitor;

import com.tencent.open.SocialConstants;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0012\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/live/user/monitor/EndType;", "", "", "key", "Ljava/lang/String;", "getKey", "()Ljava/lang/String;", SocialConstants.PARAM_APP_DESC, "getDesc", "IsViewValid", "RespIsNotUser", "RequestError", "Success", "IsFromCameraChange", "NoLogin", "NoMatchId", "NoTypeMatch", "NoMatchRoomID", "CtxOrAdminNull", "NoPermissionChange", "liveuser-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum EndType extends Enum<EndType> {
    public static final EndType CtxOrAdminNull = null;
    public static final EndType IsFromCameraChange = null;
    public static final EndType IsViewValid = null;
    public static final EndType NoLogin = null;
    public static final EndType NoMatchId = null;
    public static final EndType NoMatchRoomID = null;
    public static final EndType NoPermissionChange = null;
    public static final EndType NoTypeMatch = null;
    public static final EndType RequestError = null;
    public static final EndType RespIsNotUser = null;
    public static final EndType Success = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ EndType[] f102517a = null;
    private final String desc;
    private final String key;

    public static EndType valueOf(String r100) {
        return (EndType) r27.a.a(EndType.class, r100);
    }

    public static EndType[] values() {
        return (EndType[]) f102517a.clone();
    }

    static {
        EndType r100 = new EndType("IsViewValid", 0, "end_is_view_valid", "widget无效");
        IsViewValid = r100;
        EndType r101 = new EndType("RespIsNotUser", 1, "end_resp_is_not_user", "接口返回不是User对象");
        RespIsNotUser = r101;
        EndType r102 = new EndType("RequestError", 2, "end_request_error", "借口失败");
        RequestError = r102;
        EndType r103 = new EndType("Success", 3, "end_success", "成功");
        Success = r103;
        EndType r104 = new EndType("IsFromCameraChange", 4, "data_is_from_camera_change", "cmd_widget_loaded的IsFromCameraChange");
        IsFromCameraChange = r104;
        EndType r105 = new EndType("NoLogin", 5, "end_no_login", "未登录");
        NoLogin = r105;
        EndType r106 = new EndType("NoMatchId", 6, "end_no_match_id", "id不匹配");
        NoMatchId = r106;
        EndType r107 = new EndType("NoTypeMatch", 7, "end_no_type_match", "msg中actionType不匹配");
        NoTypeMatch = r107;
        EndType r108 = new EndType("NoMatchRoomID", 8, "end_no_match_room_id", "roomId不匹配");
        NoMatchRoomID = r108;
        EndType r109 = new EndType("CtxOrAdminNull", 9, "end_ctx_or_admin_null", "UserContext或者Admin为null");
        CtxOrAdminNull = r109;
        EndType r110 = new EndType("NoPermissionChange", 10, "end_no_permission_change", "权限变化列表为null");
        NoPermissionChange = r110;
        f102517a = new EndType[]{r100, r101, r102, r103, r104, r105, r106, r107, r108, r109, r110};
    }

    public final String getDesc() {
        return this.desc;
    }

    public final String getKey() {
        return this.key;
    }

    public EndType(String r100, int r101, String r102, String r103) {
        super(r100, r101);
        this.key = r102;
        this.desc = r103;
    }
}
