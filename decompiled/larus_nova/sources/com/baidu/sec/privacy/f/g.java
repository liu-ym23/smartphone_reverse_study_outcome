package com.baidu.sec.privacy.f;

import com.ss.android.socialbase.downloader.constants.MonitorConstants;

/* JADX INFO: loaded from: classes39.dex */
public class g {
    public g() {
    }

    public static String a(String r100, String r101) {
        Class r102 = com.baidu.sec.privacy.b.b.a(com.baidu.sec.privacy.b.b.a()).a(g.class.getClassLoader(), "android.os.SystemProperties");     // Catch: Throwable -> L8
        if (r102 != null) goto L6;
        return r101;
    L6:
        return (String) r102.getMethod(MonitorConstants.CONNECT_TYPE_GET, new Class[]{String.class}).invoke(r102, new Object[]{r100});
    L8:
        th = move-exception;
        c.a(th);
        return r101;
    }
}
