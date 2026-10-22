package com.alipay.mobilesecuritysdk.face;

import android.content.Context;
import com.alipay.apmobilesecuritysdk.face.APSecuritySdk;
import com.alipay.sdk.m.l.b;
import com.alipay.sdk.m.z.a;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes28.dex */
public class SecurityClientMobile {
    public SecurityClientMobile() {
    }

    public static synchronized String GetApdid(Context r100, Map<String, String> r101) {
        monitor-enter(SecurityClientMobile.class);
        HashMap r102 = new HashMap();     // Catch: Throwable -> L7
        r102.put(b.f25485g, a.a(r101, b.f25485g, ""));     // Catch: Throwable -> L7
        r102.put("tid", a.a(r101, "tid", ""));     // Catch: Throwable -> L7
        r102.put("userId", a.a(r101, "userId", ""));     // Catch: Throwable -> L7
        APSecuritySdk.getInstance(r100).initToken(0, r102, null);     // Catch: Throwable -> L7
        String r103 = com.alipay.apmobilesecuritysdk.a.a.a(r100);     // Catch: Throwable -> L7
        monitor-exit(SecurityClientMobile.class);
        return r103;
    L7:
        th = move-exception;
        throw th;
    }
}
