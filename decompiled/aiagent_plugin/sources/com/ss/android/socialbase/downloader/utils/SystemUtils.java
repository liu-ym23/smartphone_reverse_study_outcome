package com.ss.android.socialbase.downloader.utils;

import android.content.Context;
import android.content.pm.ServiceInfo;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes4.dex */
public class SystemUtils {
    public SystemUtils() {
    }

    public static boolean checkServiceExists(Context r4, String r5, String r6) {
        ServiceInfo[] r7 = ((Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin")).getPackageManager().getPackageInfo(r5, 4).services;     // Catch: Throwable -> L16
        int r8 = r7.length;     // Catch: Throwable -> L16
        int r1 = 0;
    L4:
        if (r1 >= r8) goto L18;
        ServiceInfo r2 = r7[r1];     // Catch: Throwable -> L16
        if (r2.exported == false) goto L15;
        if (r2.enabled == false) goto L15;
        if (r2.permission != null) goto L15;
        if (r2.name.equals(r6) == false) goto L15;
        return true;
    L15:
        r1 = r1 + 1;
    L18:
        return false;
    L16:
        th = move-exception;
        th.printStackTrace();
        goto L18
    }
}
