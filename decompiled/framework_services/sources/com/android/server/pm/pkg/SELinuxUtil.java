package com.android.server.pm.pkg;

/* JADX INFO: loaded from: classes2.dex */
public final class SELinuxUtil {
    public static final String COMPLETE_STR = ":complete";
    private static final String INSTANT_APP_STR = ":ephemeralapp";

    public SELinuxUtil() {
    }

    public static String getSeinfoUser(PackageUserState userState) {
        if (userState.isInstantApp() == false) goto L6;
        return ":ephemeralapp:complete";
    L6:
        return COMPLETE_STR;
    }
}
