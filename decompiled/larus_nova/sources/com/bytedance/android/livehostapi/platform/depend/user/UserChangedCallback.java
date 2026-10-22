package com.bytedance.android.livehostapi.platform.depend.user;

/* JADX INFO: loaded from: classes7.dex */
public interface UserChangedCallback {
    public static final String CHANGE_TYPE_LOGIN = "Login";
    public static final String CHANGE_TYPE_LOGOUT = "Logout";
    public static final String CHANGE_TYPE_SWITCH = "Switch";
    public static final String CHANGE_TYPE_UNKNOWN = "Unknown";
    public static final String CHANGE_TYPE_UPDATE = "Update";

    /* JADX INFO: renamed from: com.bytedance.android.livehostapi.platform.depend.user.UserChangedCallback$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static void $default$onUserChanged(UserChangedCallback r100, boolean r101, String r102) {
        }
    }

    void onRealUserLogin(boolean r100);

    void onUserChanged(boolean r100);

    void onUserChanged(boolean r100, String r101);
}
