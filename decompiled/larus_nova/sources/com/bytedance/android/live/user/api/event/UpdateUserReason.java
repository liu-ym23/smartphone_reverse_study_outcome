package com.bytedance.android.live.user.api.event;

import com.tencent.open.SocialConstants;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u0017\u0010\b\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\b\u0010\u0005\u001a\u0004\b\t\u0010\u0007R\u0017\u0010\u000b\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001a¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/live/user/api/event/UpdateUserReason;", "", "", "toString", "reason", "Ljava/lang/String;", "getReason", "()Ljava/lang/String;", SocialConstants.PARAM_APP_DESC, "getDesc", "Lcom/bytedance/android/live/user/api/event/UpdateUserType;", "updateUserType", "Lcom/bytedance/android/live/user/api/event/UpdateUserType;", "getUpdateUserType", "()Lcom/bytedance/android/live/user/api/event/UpdateUserType;", "USER_CONTEXT_CREATE_DEFAULT", "ENTER_ROOM_UPDATE", "REFRESH_USER_MESSAGE", "ON_USER_LOGIN", "ADMIN_CHANGE", "ADMIN_PROMPT_CHANGE", "BAN_STATE_CHANGE", "ADMIN_PRIVILEGE_MESSAGE", "RECHARGE_PAY_SUCCESS", "REV_UPDATE", "BIZ_UPDATE_USER", "MSG_UNKNOWN", "liveuser-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum UpdateUserReason extends Enum<UpdateUserReason> {
    public static final UpdateUserReason ADMIN_CHANGE = null;
    public static final UpdateUserReason ADMIN_PRIVILEGE_MESSAGE = null;
    public static final UpdateUserReason ADMIN_PROMPT_CHANGE = null;
    public static final UpdateUserReason BAN_STATE_CHANGE = null;
    public static final UpdateUserReason BIZ_UPDATE_USER = null;
    public static final UpdateUserReason ENTER_ROOM_UPDATE = null;
    public static final UpdateUserReason MSG_UNKNOWN = null;
    public static final UpdateUserReason ON_USER_LOGIN = null;
    public static final UpdateUserReason RECHARGE_PAY_SUCCESS = null;
    public static final UpdateUserReason REFRESH_USER_MESSAGE = null;
    public static final UpdateUserReason REV_UPDATE = null;
    public static final UpdateUserReason USER_CONTEXT_CREATE_DEFAULT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ UpdateUserReason[] f102509a = null;
    private final String desc;
    private final String reason;
    private final UpdateUserType updateUserType;

    public static UpdateUserReason valueOf(String r100) {
        return (UpdateUserReason) a.a(UpdateUserReason.class, r100);
    }

    public static UpdateUserReason[] values() {
        return (UpdateUserReason[]) f102509a.clone();
    }

    static {
        UpdateUserType r110 = UpdateUserType.IN_ROOM;
        UpdateUserReason r100 = new UpdateUserReason("USER_CONTEXT_CREATE_DEFAULT", 0, "user_context_create_default", "UserContext创建时默认值", r110);
        USER_CONTEXT_CREATE_DEFAULT = r100;
        UpdateUserReason r101 = new UpdateUserReason("ENTER_ROOM_UPDATE", 1, "enter_room_update", "进房后更新当前用户信息", r110);
        ENTER_ROOM_UPDATE = r101;
        UpdateUserReason r102 = new UpdateUserReason("REFRESH_USER_MESSAGE", 2, "refresh_user_message", "刷新User信息的消息", r110);
        REFRESH_USER_MESSAGE = r102;
        UpdateUserReason r103 = new UpdateUserReason("ON_USER_LOGIN", 3, "on_user_login", "用户登录", r110);
        ON_USER_LOGIN = r103;
        UpdateUserReason r104 = new UpdateUserReason("ADMIN_CHANGE", 4, "admin_change", "管理员状态变化", r110);
        ADMIN_CHANGE = r104;
        UpdateUserReason r105 = new UpdateUserReason("ADMIN_PROMPT_CHANGE", 5, "admin_prompt_change", "管理员提词权限变化", r110);
        ADMIN_PROMPT_CHANGE = r105;
        UpdateUserReason r106 = new UpdateUserReason("BAN_STATE_CHANGE", 6, "ban_state_change", "用户禁言状态变化", r110);
        BAN_STATE_CHANGE = r106;
        UpdateUserReason r107 = new UpdateUserReason("ADMIN_PRIVILEGE_MESSAGE", 7, "admin_privilege_message", "细分权限更新消息", r110);
        ADMIN_PRIVILEGE_MESSAGE = r107;
        UpdateUserReason r108 = new UpdateUserReason("RECHARGE_PAY_SUCCESS", 8, "recharge_pay_success", "充值成功", r110);
        RECHARGE_PAY_SUCCESS = r108;
        UpdateUserReason r109 = new UpdateUserReason("REV_UPDATE", 9, "rev_update", "营收更新", r110);
        REV_UPDATE = r109;
        UpdateUserReason r111 = new UpdateUserReason("BIZ_UPDATE_USER", 10, "biz_update_user", "业务方主动更新", r110);
        BIZ_UPDATE_USER = r111;
        UpdateUserReason r112 = new UpdateUserReason("MSG_UNKNOWN", 11, "msg_unknown", "MemberMessage未知的type", r110);
        MSG_UNKNOWN = r112;
        f102509a = new UpdateUserReason[]{r100, r101, r102, r103, r104, r105, r106, r107, r108, r109, r111, r112};
    }

    @Override // java.lang.Enum
    public String toString() {
        return "UpdateUserReason(reason=" + this.reason + ", desc=" + this.desc + ", updateUserType=" + this.updateUserType + ')';
    }

    public final String getDesc() {
        return this.desc;
    }

    public final String getReason() {
        return this.reason;
    }

    public final UpdateUserType getUpdateUserType() {
        return this.updateUserType;
    }

    public UpdateUserReason(String r100, int r101, String r102, String r103, UpdateUserType r104) {
        super(r100, r101);
        this.reason = r102;
        this.desc = r103;
        this.updateUserType = r104;
    }
}
