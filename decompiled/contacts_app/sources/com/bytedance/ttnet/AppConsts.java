package com.bytedance.ttnet;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes2.dex */
public class AppConsts {
    public static final int APP_SECURITY_LEVEL_TTP_RESTRICTION = 2;
    public static final int APP_SECURITY_LEVEL_UNSPECIFIED = 0;
    public static final int APP_SECURITY_LEVEL_USER_PRIVACY_RESTRICTION = 1;
    public static final String KEY_DATA = "data";
    public static final String KEY_MESSAGE = "message";
    public static final String STATUS_ERROR = "error";
    public static final String STATUS_SUCCESS = "success";

    public AppConsts() {
    }

    public static String getHostSuffix() {
        String r0 = TTNetInit.getTTNetDepend().getHostSuffix();
        if (r0 == null) goto L8;
        if (TextUtils.isEmpty(r0) == true) goto L8;
        return r0;
    L8:
        throw new IllegalArgumentException("hostSuffix is not init !!!");
    }

    public static String getCdnHostSuffix() {
        String r0 = TTNetInit.getTTNetDepend().getCdnHostSuffix();
        if (r0 == null) goto L8;
        if (TextUtils.isEmpty(r0) == true) goto L8;
        return r0;
    L8:
        throw new IllegalArgumentException("cdnHostSuffix is not init !!!");
    }
}
