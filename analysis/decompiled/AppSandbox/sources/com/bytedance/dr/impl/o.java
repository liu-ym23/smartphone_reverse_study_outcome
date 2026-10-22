package com.bytedance.dr.impl;

import android.content.Context;
import com.bytedance.applog.log.IAppLogLogger;
import com.bytedance.applog.log.LoggerImpl;
import com.bytedance.dr.OaidApi;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public final class o implements OaidApi {
    public static Object a;
    public static Class<?> b;
    public static Method c;

    static {
        try {
            Class<?> cls = Class.forName("com.android.id.impl.IdProviderImpl");
            b = cls;
            a = cls.newInstance();
            c = b.getMethod("getOAID", Context.class);
        } catch (Throwable th) {
            LoggerImpl.global().error(1, "Oaid#Api#static reflect exception! ", th, new Object[0]);
        }
    }

    public static boolean a() {
        IAppLogLogger iAppLogLoggerGlobal = LoggerImpl.global();
        StringBuilder sbA = com.bytedance.bdtracker.a.a("Oaid#XiaomiOppoImpl isSupport -> ");
        sbA.append((b == null || a == null || c == null) ? false : true);
        iAppLogLoggerGlobal.debug(sbA.toString(), new Object[0]);
        return (b == null || a == null || c == null) ? false : true;
    }

    @Override // com.bytedance.dr.OaidApi
    public String getName() {
        return "Xiaomi";
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x001b  */
    @Override // com.bytedance.dr.OaidApi
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public com.bytedance.dr.OaidApi.a getOaid(android.content.Context r5) {
        /*
            r4 = this;
            r4 = 0
            com.bytedance.dr.OaidApi$a r0 = new com.bytedance.dr.OaidApi$a     // Catch: java.lang.Throwable -> L1f
            r0.<init>()     // Catch: java.lang.Throwable -> L1f
            java.lang.reflect.Method r1 = com.bytedance.dr.impl.o.c     // Catch: java.lang.Throwable -> L1f
            java.lang.Object r2 = com.bytedance.dr.impl.o.a     // Catch: java.lang.Throwable -> L1f
            if (r2 == 0) goto L1b
            if (r1 == 0) goto L1b
            java.lang.Object[] r5 = new java.lang.Object[]{r5}     // Catch: java.lang.Throwable -> L1b
            java.lang.Object r5 = r1.invoke(r2, r5)     // Catch: java.lang.Throwable -> L1b
            if (r5 == 0) goto L1b
            java.lang.String r5 = (java.lang.String) r5     // Catch: java.lang.Throwable -> L1b
            goto L1c
        L1b:
            r5 = r4
        L1c:
            r0.a = r5     // Catch: java.lang.Throwable -> L1f
            return r0
        L1f:
            r5 = move-exception
            com.bytedance.applog.log.IAppLogLogger r0 = com.bytedance.applog.log.LoggerImpl.global()
            r1 = 0
            java.lang.Object[] r1 = new java.lang.Object[r1]
            r2 = 1
            java.lang.String r3 = "Oaid#invokeMethod get oaid failed"
            r0.error(r2, r3, r5, r1)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.dr.impl.o.getOaid(android.content.Context):com.bytedance.dr.OaidApi$a");
    }

    @Override // com.bytedance.dr.OaidApi
    public boolean support(Context context) {
        return a();
    }
}
