package com.bytedance.android.gamecp.host_api.model.user;

import com.bytedance.android.livehostapi.platform.depend.user.UserChangedCallback;

/* JADX INFO: loaded from: classes44.dex */
public interface IUser {

    public static final enum Status extends Enum<Status> {
        public static final Status Login = null;
        public static final Status Logout = null;
        public static final Status Update = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Status[] f57401a = null;

        static {
            Status r100 = new Status(UserChangedCallback.CHANGE_TYPE_LOGIN, 0);
            Login = r100;
            Status r101 = new Status(UserChangedCallback.CHANGE_TYPE_LOGOUT, 1);
            Logout = r101;
            Status r102 = new Status(UserChangedCallback.CHANGE_TYPE_UPDATE, 2);
            Update = r102;
            f57401a = new Status[]{r100, r101, r102};
        }

        public static Status[] values() {
            return (Status[]) f57401a.clone();
        }

        public static Status valueOf(String r100) {
            return (Status) r27.a.a(Status.class, r100);
        }

        public Status(String r100, int r101) {
            super(r100, r101);
        }
    }

    String getId();

    String getNickName();

    String getRealNickName();

    String getSecUid();
}
