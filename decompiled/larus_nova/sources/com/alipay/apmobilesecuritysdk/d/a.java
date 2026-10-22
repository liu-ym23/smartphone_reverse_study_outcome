package com.alipay.apmobilesecuritysdk.d;

import android.content.Context;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes28.dex */
public final class a {
    public static synchronized Map<String, String> a(Context r100, Map<String, String> r101) {
        monitor-enter(a.class);
        String r102 = com.alipay.sdk.m.z.a.a(r101, "appchannel", "");     // Catch: Throwable -> L7
        HashMap r103 = new HashMap();     // Catch: Throwable -> L7
        r103.put("AA1", r100.getPackageName());     // Catch: Throwable -> L7
        com.alipay.sdk.m.a0.a.a();     // Catch: Throwable -> L7
        r103.put("AA2", com.alipay.sdk.m.a0.a.a(r100));     // Catch: Throwable -> L7
        r103.put("AA3", "APPSecuritySDK-ALIPAYSDK");     // Catch: Throwable -> L7
        r103.put("AA4", "3.4.0.202303020703");     // Catch: Throwable -> L7
        r103.put("AA6", r102);     // Catch: Throwable -> L7
        monitor-exit(a.class);
        return r103;
    L7:
        th = move-exception;
        throw th;
    }
}
