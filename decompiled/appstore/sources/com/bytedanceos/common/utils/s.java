package com.bytedanceos.common.utils;

import com.bytedanceos.common.model.AppInfo;
import com.bytedanceos.common.networkv2.params.NetValue;

/* JADX INFO: loaded from: classes2.dex */
public abstract class s {
    public static void a(String r10, AppInfo r11) {
        b(r10, r11, "");
    }

    public static void b(String r10, AppInfo r11, String r12) {
        if (r11 == null) goto L10;
        c(r10, r11.appPackageName, r11.appDownloadUrl, r11.appName, r11.appVersionCode, r11.trackerInfo, r11.tabSource, r12, r11.mRetryNum, r11.traceId);
        if (r11.isSysAppAutoUpdate() == true) goto L6;
        return;
    L6:
        if (r10.hashCode() != 57) goto L12;
        r10.equals(NetValue.AppStatusType.REQUEST_DOWNLOAD);
        return;
    L12:
        return;
    }

    public static void c(String r10, String r11, String r12, String r13, int r14, String r15, String r16, String r17, int r18, String r19) {
    }
}
