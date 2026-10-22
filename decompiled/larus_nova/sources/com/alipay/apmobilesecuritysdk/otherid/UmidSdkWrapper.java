package com.alipay.apmobilesecuritysdk.otherid;

import android.content.Context;
import com.alipay.sdk.m.b0.d;
import com.alipay.sdk.m.z.a;

/* JADX INFO: loaded from: classes28.dex */
public class UmidSdkWrapper {
    public static final String UMIDTOKEN_FILE_NAME = "xxxwww_v2";
    public static final String UMIDTOKEN_KEY_NAME = "umidtk";
    public static volatile String cachedUmidToken = "";
    public static volatile boolean initUmidFinished;

    public UmidSdkWrapper() {
    }

    public static String compatUmidBug(Context r100, String r101) {
        if (a.a(r101) == false) goto L5;
    L8:
        String r102 = UtdidWrapper.getUtdid(r100);
        if (r102 == null) goto L14;
        if (r102.contains("?") == false) goto L14;
        r102 = "";
    L14:
        if (a.a(r102) == false) goto L17;
        return "";
    L17:
        return r102;
    L5:
        if (a.a(r101, "000000000000000000000000") == true) goto L8;
        return r101;
    }

    public static synchronized String getSecurityToken(Context r100) {
        monitor-enter(UmidSdkWrapper.class);
        String r101 = cachedUmidToken;     // Catch: Throwable -> L7
        monitor-exit(UmidSdkWrapper.class);
        return r101;
    L7:
        th = move-exception;
        throw th;
    }

    public static String startUmidTaskSync(Context r100, int r101) {
        return "";
    }

    public static synchronized void updateLocalUmidToken(Context r100, String r101) {
        monitor-enter(UmidSdkWrapper.class);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (a.b(r101) == false) goto L7;
        d.a(r100, UMIDTOKEN_FILE_NAME, UMIDTOKEN_KEY_NAME, r101);     // Catch: Throwable -> L9
        cachedUmidToken = r101;     // Catch: Throwable -> L9
    L7:
        monitor-exit(UmidSdkWrapper.class);
    }
}
