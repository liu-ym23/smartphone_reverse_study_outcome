package com.stepos.core.common.device;

import a4.a;
import android.content.Context;
import com.stepos.core.common.log.AIEngineLogger;
import com.stepos.core.common.log.LogModule;
import com.stepos.cpuset.c;
import com.tencent.mmkv.MMKV;
import gc.q;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Result;
import kotlin.b;
import lb.d;
import lb.n;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class OaidResolver {
    private static final String KEY_OAID = "oaid_resolved";
    private static final String MMKV_ID = "device_oaid_store";
    private static final String TAG = "OaidResolver";
    private static volatile boolean bound;
    private static volatile String cached;
    public static final OaidResolver INSTANCE = new OaidResolver();
    private static final AtomicReference<Context> appContextRef = new AtomicReference<>(null);
    private static final Object cacheLock = new Object();
    private static final d kv$delegate = b.b(new c(14));

    private OaidResolver() {
    }

    private final Context currentApplication() {
        Object objA;
        try {
            Object objInvoke = Class.forName("android.app.ActivityThread").getMethod("currentApplication", null).invoke(null, null);
            objA = objInvoke instanceof Context ? (Context) objInvoke : null;
        } catch (Throwable th) {
            objA = kotlin.c.a(th);
        }
        return (Context) (objA instanceof Result.Failure ? null : objA);
    }

    private final void ensureBound(Context context) {
        Context contextCurrentApplication;
        Object objA;
        if ((context == null || (contextCurrentApplication = context.getApplicationContext()) == null) && (contextCurrentApplication = currentApplication()) == null) {
            return;
        }
        if (bound && appContextRef.get() == contextCurrentApplication) {
            return;
        }
        synchronized (cacheLock) {
            try {
                AtomicReference<Context> atomicReference = appContextRef;
                Context context2 = atomicReference.get();
                if (context2 != null && context2 != contextCurrentApplication) {
                    cached = null;
                    bound = false;
                }
                if (bound && atomicReference.get() == contextCurrentApplication) {
                    return;
                }
                atomicReference.set(contextCurrentApplication);
                try {
                    ba.d.b().getClass();
                    if (!a.n()) {
                        AIEngineLogger.w(LogModule.SYSTEM, TAG, "OpenIdHelper not supported, will use ANDROID_ID fallback");
                    }
                    objA = n.f10413a;
                } catch (Throwable th) {
                    objA = kotlin.c.a(th);
                }
                Throwable thB = Result.b(objA);
                if (thB != null) {
                    AIEngineLogger.w(LogModule.SYSTEM, TAG, "OpenIdHelper setup failed, will use ANDROID_ID fallback", thB);
                }
                bound = true;
                n nVar = n.f10413a;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public static /* synthetic */ String get$default(OaidResolver oaidResolver, Context context, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            context = null;
        }
        return oaidResolver.get(context);
    }

    private final MMKV getKv() {
        return (MMKV) kv$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MMKV kv_delegate$lambda$2() {
        Object objA;
        try {
            objA = MMKV.o(MMKV_ID);
        } catch (Throwable th) {
            objA = kotlin.c.a(th);
        }
        Throwable thB = Result.b(objA);
        if (thB != null) {
            AIEngineLogger.w(LogModule.SYSTEM, TAG, "MMKV unavailable, memory-only cache", thB);
        }
        if (objA instanceof Result.Failure) {
            objA = null;
        }
        return (MMKV) objA;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0016  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final java.lang.String readPersisted() {
        /*
            r2 = this;
            r0 = 0
            com.tencent.mmkv.MMKV r2 = r2.getKv()     // Catch: java.lang.Throwable -> L18
            if (r2 == 0) goto L16
            java.lang.String r1 = "oaid_resolved"
            java.lang.String r2 = r2.h(r1, r0)     // Catch: java.lang.Throwable -> L18
            if (r2 == 0) goto L16
            boolean r1 = gc.q.t0(r2)     // Catch: java.lang.Throwable -> L18
            if (r1 != 0) goto L16
            goto L1d
        L16:
            r2 = r0
            goto L1d
        L18:
            r2 = move-exception
            kotlin.Result$Failure r2 = kotlin.c.a(r2)
        L1d:
            boolean r1 = r2 instanceof kotlin.Result.Failure
            if (r1 == 0) goto L22
            goto L23
        L22:
            r0 = r2
        L23:
            java.lang.String r0 = (java.lang.String) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.common.device.OaidResolver.readPersisted():java.lang.String");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x000e  */
    @android.annotation.SuppressLint({"HardwareIds"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final java.lang.String resolveUncached(android.content.Context r3) {
        /*
            r2 = this;
            java.lang.String r2 = ""
            boolean r0 = a4.a.n()     // Catch: java.lang.Throwable -> L10
            if (r0 == 0) goto Le
            java.lang.String r0 = a4.a.m(r3)     // Catch: java.lang.Throwable -> L10
            if (r0 != 0) goto L15
        Le:
            r0 = r2
            goto L15
        L10:
            r0 = move-exception
            kotlin.Result$Failure r0 = kotlin.c.a(r0)
        L15:
            boolean r1 = r0 instanceof kotlin.Result.Failure
            if (r1 == 0) goto L1a
            r0 = r2
        L1a:
            java.lang.String r0 = (java.lang.String) r0
            boolean r1 = gc.q.t0(r0)
            if (r1 != 0) goto L23
            return r0
        L23:
            android.content.ContentResolver r3 = r3.getContentResolver()     // Catch: java.lang.Throwable -> L31
            java.lang.String r0 = "android_id"
            java.lang.String r3 = android.provider.Settings.Secure.getString(r3, r0)     // Catch: java.lang.Throwable -> L31
            if (r3 != 0) goto L36
            r3 = r2
            goto L36
        L31:
            r3 = move-exception
            kotlin.Result$Failure r3 = kotlin.c.a(r3)
        L36:
            boolean r0 = r3 instanceof kotlin.Result.Failure
            if (r0 == 0) goto L3b
            goto L3c
        L3b:
            r2 = r3
        L3c:
            java.lang.String r2 = (java.lang.String) r2
            boolean r3 = gc.q.t0(r2)
            if (r3 == 0) goto L4d
            com.stepos.core.common.log.LogModule r3 = com.stepos.core.common.log.LogModule.SYSTEM
            java.lang.String r0 = "OaidResolver"
            java.lang.String r1 = "OAID and ANDROID_ID both empty"
            com.stepos.core.common.log.AIEngineLogger.w(r3, r0, r1)
        L4d:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.common.device.OaidResolver.resolveUncached(android.content.Context):java.lang.String");
    }

    private final void writePersisted(String str) {
        Object objA;
        try {
            MMKV kv = getKv();
            objA = kv != null ? Boolean.valueOf(kv.l(KEY_OAID, str)) : null;
        } catch (Throwable th) {
            objA = kotlin.c.a(th);
        }
        Throwable thB = Result.b(objA);
        if (thB != null) {
            AIEngineLogger.w(LogModule.SYSTEM, TAG, "persist OAID failed", thB);
        }
    }

    public final String get(Context context) {
        ensureBound(context);
        String str = cached;
        if (str != null) {
            return str;
        }
        synchronized (cacheLock) {
            String str2 = cached;
            if (str2 != null) {
                return str2;
            }
            OaidResolver oaidResolver = INSTANCE;
            String persisted = oaidResolver.readPersisted();
            if (persisted != null) {
                cached = persisted;
                return persisted;
            }
            Context context2 = appContextRef.get();
            if (context2 == null) {
                AIEngineLogger.w(LogModule.SYSTEM, TAG, "get() without Application context, return empty");
                return "";
            }
            String strResolveUncached = oaidResolver.resolveUncached(context2);
            if (!q.t0(strResolveUncached)) {
                cached = strResolveUncached;
                oaidResolver.writePersisted(strResolveUncached);
            }
            return strResolveUncached;
        }
    }
}
