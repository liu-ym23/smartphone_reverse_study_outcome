package com.alipay.apmobilesecuritysdk.d;

import android.content.Context;
import com.alipay.apmobilesecuritysdk.e.h;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes28.dex */
public final class b {
    public static synchronized Map<String, String> a(Context r110, Map<String, String> r111) {
        monitor-enter(b.class);
        HashMap r100 = new HashMap();     // Catch: Throwable -> L9
        String r101 = com.alipay.sdk.m.z.a.a(r111, "tid", "");     // Catch: Throwable -> L9
        String r102 = com.alipay.sdk.m.z.a.a(r111, com.alipay.sdk.m.l.b.f25485g, "");     // Catch: Throwable -> L9
        String r103 = com.alipay.sdk.m.z.a.a(r111, "userId", "");     // Catch: Throwable -> L9
        String r104 = com.alipay.sdk.m.z.a.a(r111, "appName", "");     // Catch: Throwable -> L9
        String r105 = com.alipay.sdk.m.z.a.a(r111, "appKeyClient", "");     // Catch: Throwable -> L9
        String r106 = com.alipay.sdk.m.z.a.a(r111, "tmxSessionId", "");     // Catch: Throwable -> L9
        String r112 = h.f(r110);     // Catch: Throwable -> L9
        String r113 = com.alipay.sdk.m.z.a.a(r111, "sessionId", "");     // Catch: Throwable -> L9
        r100.put("AC1", r101);     // Catch: Throwable -> L9
        r100.put("AC2", r102);     // Catch: Throwable -> L9
        r100.put("AC3", "");     // Catch: Throwable -> L9
        r100.put("AC4", r112);     // Catch: Throwable -> L9
        r100.put("AC5", r103);     // Catch: Throwable -> L9
        r100.put("AC6", r106);     // Catch: Throwable -> L9
        r100.put("AC7", "");     // Catch: Throwable -> L9
        r100.put("AC8", r104);     // Catch: Throwable -> L9
        r100.put("AC9", r105);     // Catch: Throwable -> L9
        if (com.alipay.sdk.m.z.a.b(r113) == false) goto L7;
        r100.put("AC10", r113);     // Catch: Throwable -> L9
    L7:
        monitor-exit(b.class);
        return r100;
    L9:
        th = move-exception;
        throw th;
    }
}
