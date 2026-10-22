package com.bytedance.android.live.user.monitor;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.tencent.open.SocialConstants;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b(\b\u0086\u0001\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006j\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%j\u0002\b&j\u0002\b'j\u0002\b(j\u0002\b)¨\u0006*"}, d2 = {"Lcom/bytedance/android/live/user/monitor/DataType;", "", "", "key", "Ljava/lang/String;", "getKey", "()Ljava/lang/String;", SocialConstants.PARAM_APP_DESC, "getDesc", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "UpdateReason", "IsLogin", "Request", "CallFrom", "RequestSuccess", "RequestErrorMsg", "LogId", "UpdateUser", "IsAnchor", "UserAttrNull", "IsAdmin", "IsMuted", "AdminPrivileges", "OldPermissions", "NewPermissions", "AddPermissions", "DeletePermissions", "MsgUserId", "MsgActionType", "CurrUID", "CurrRoomId", "CurrAnchorId", "MsgRoomId", "MemberMessageType", "MsgIsAdmin", "MsgIsPrompt", "MsgIsBan", "RevReason", "EndType", "StartTime", "EndTime", "liveuser-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum DataType extends Enum<DataType> {
    public static final DataType AddPermissions = null;
    public static final DataType AdminPrivileges = null;
    public static final DataType CallFrom = null;
    public static final a Companion = null;
    public static final DataType CurrAnchorId = null;
    public static final DataType CurrRoomId = null;
    public static final DataType CurrUID = null;
    public static final DataType DeletePermissions = null;
    public static final DataType EndTime = null;
    public static final DataType EndType = null;
    public static final DataType IsAdmin = null;
    public static final DataType IsAnchor = null;
    public static final DataType IsLogin = null;
    public static final DataType IsMuted = null;
    public static final DataType LogId = null;
    public static final DataType MemberMessageType = null;
    public static final DataType MsgActionType = null;
    public static final DataType MsgIsAdmin = null;
    public static final DataType MsgIsBan = null;
    public static final DataType MsgIsPrompt = null;
    public static final DataType MsgRoomId = null;
    public static final DataType MsgUserId = null;
    public static final DataType NewPermissions = null;
    public static final DataType OldPermissions = null;
    public static final DataType Request = null;
    public static final DataType RequestErrorMsg = null;
    public static final DataType RequestSuccess = null;
    public static final DataType RevReason = null;
    public static final DataType StartTime = null;
    public static final DataType UpdateReason = null;
    public static final DataType UpdateUser = null;
    public static final DataType UserAttrNull = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DataType[] f102516a = null;
    private final String desc;
    private final String key;

    public static final class a {
        public a() {
        }
    }

    public static DataType valueOf(String r100) {
        return (DataType) r27.a.a(DataType.class, r100);
    }

    public static DataType[] values() {
        return (DataType[]) f102516a.clone();
    }

    static {
        DataType r100 = new DataType("UpdateReason", 0, "data_update_reason", "更新原因");
        UpdateReason = r100;
        DataType r101 = new DataType("IsLogin", 1, "data_is_login", "是否登录");
        IsLogin = r101;
        DataType r102 = new DataType("Request", 2, "data_request", "请求webcast/user接口");
        Request = r102;
        DataType r103 = new DataType("CallFrom", 3, "data_call_from", "请求来源");
        CallFrom = r103;
        DataType r104 = new DataType("RequestSuccess", 4, "data_request_success", "请求成功或失败");
        RequestSuccess = r104;
        DataType r105 = new DataType("RequestErrorMsg", 5, "data_request_error_msg", "请求失败信息");
        RequestErrorMsg = r105;
        DataType r106 = new DataType("LogId", 6, "data_log_id", "log_id");
        LogId = r106;
        DataType r107 = new DataType("UpdateUser", 7, "data_update_user", "更新User");
        UpdateUser = r107;
        DataType r108 = new DataType("IsAnchor", 8, "data_is_anchor", "自己是主播");
        IsAnchor = r108;
        DataType r109 = new DataType("UserAttrNull", 9, "data_user_attr_null", "新User的userAttr是空的");
        UserAttrNull = r109;
        DataType r110 = new DataType("IsAdmin", 10, "data_is_admin", "自己是否是管理员");
        IsAdmin = r110;
        DataType r111 = new DataType("IsMuted", 11, "data_is_muted", "自己是否被禁言");
        IsMuted = r111;
        DataType r112 = new DataType("AdminPrivileges", 12, "data_admin_privileges", "新权限");
        AdminPrivileges = r112;
        DataType r113 = new DataType("OldPermissions", 13, "data_old_permissions", "之前的权限");
        OldPermissions = r113;
        DataType r114 = new DataType("NewPermissions", 14, "data_new_permissions", "现在的权限");
        NewPermissions = r114;
        DataType r115 = new DataType("AddPermissions", 15, "data_add_permissions", "新增的权限");
        AddPermissions = r115;
        DataType r116 = new DataType("DeletePermissions", 16, "data_delete_permissions", "删除的权限");
        DeletePermissions = r116;
        DataType r117 = new DataType("MsgUserId", 17, "data_msg_user_id", "消息下发的uid");
        MsgUserId = r117;
        DataType r118 = new DataType("MsgActionType", 18, "data_msg_action_type", "消息actionType");
        MsgActionType = r118;
        DataType r119 = new DataType("CurrUID", 19, "data_curr_uid", "当前用户的uid");
        CurrUID = r119;
        DataType r120 = new DataType("CurrRoomId", 20, "data_curr_room_id", "当前roomId");
        CurrRoomId = r120;
        DataType r121 = new DataType("CurrAnchorId", 21, "data_curr_anchor_id", "当前主播id");
        CurrAnchorId = r121;
        DataType r122 = new DataType("MsgRoomId", 22, "data_msg_room_id", "msg里的roomId");
        MsgRoomId = r122;
        DataType r123 = new DataType("MemberMessageType", 23, "data_member_message_type", "MemberMessage的类型");
        MemberMessageType = r123;
        DataType r124 = new DataType("MsgIsAdmin", 24, "data_msg_is_admin", "msg中是否是管理员");
        MsgIsAdmin = r124;
        DataType r125 = new DataType("MsgIsPrompt", 25, "data_msg_is_prompt", "消息中是否是提词权限");
        MsgIsPrompt = r125;
        DataType r126 = new DataType("MsgIsBan", 26, "data_msg_is_ban", "消息中是否被禁言");
        MsgIsBan = r126;
        DataType r127 = new DataType("RevReason", 27, "data_rev_reason", "营收更新原因");
        RevReason = r127;
        DataType r128 = new DataType("EndType", 28, "data_end_type", "结束原因");
        EndType = r128;
        DataType r129 = new DataType("StartTime", 29, "data_start_time", "开始时间");
        StartTime = r129;
        DataType r130 = new DataType("EndTime", 30, "data_end_time", "结束时间");
        EndTime = r130;
        f102516a = new DataType[]{r100, r101, r102, r103, r104, r105, r106, r107, r108, r109, r110, r111, r112, r113, r114, r115, r116, r117, r118, r119, r120, r121, r122, r123, r124, r125, r126, r127, r128, r129, r130};
        Companion = new a();
    }

    public final String getDesc() {
        return this.desc;
    }

    public final String getKey() {
        return this.key;
    }

    public DataType(String r100, int r101, String r102, String r103) {
        super(r100, r101);
        this.key = r102;
        this.desc = r103;
    }
}
