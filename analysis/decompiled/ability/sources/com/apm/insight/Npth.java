package com.apm.insight;

import a.AbstractC0291a;
import android.app.Application;
import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.apm.insight.nativecrash.NativeImpl;
import com.apm.insight.runtime.ConfigManager;
import h2.C1483a;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import o2.RunnableC1756a;
import q2.C1797b;
import w2.m;
import z2.k;
import z2.l;

/* loaded from: classes2.dex */
public final class Npth {
    private static boolean sInit;

    public static void addAttachLongUserData(AttachUserData attachUserData, CrashType crashType) {
        if (attachUserData != null) {
            u1.d dVar = g.h;
            dVar.getClass();
            if (crashType != CrashType.ALL) {
                dVar.O(attachUserData, crashType);
                return;
            }
            dVar.O(attachUserData, CrashType.LAUNCH);
            dVar.O(attachUserData, CrashType.JAVA);
            dVar.O(attachUserData, CrashType.CUSTOM_JAVA);
            dVar.O(attachUserData, CrashType.NATIVE);
            dVar.O(attachUserData, CrashType.ANR);
            dVar.O(attachUserData, CrashType.DART);
        }
    }

    public static void addAttachUserData(AttachUserData attachUserData, CrashType crashType) {
        if (attachUserData != null) {
            g.h.x(attachUserData, crashType);
        }
    }

    public static void addTags(Map<? extends String, ? extends String> map) {
        if (map == null || map.isEmpty()) {
            return;
        }
        ((HashMap) g.h.d).putAll(map);
    }

    public static void checkInnerNpth(boolean z10) {
        boolean z11 = k.f6933a;
        g.f2166v = z10;
    }

    public static void dumpHprof(String str) {
        boolean z10 = k.f6933a;
        NativeImpl.k(str);
    }

    public static void enableALogCollector(String str, g2.b bVar, g2.c cVar) {
        boolean z10 = k.f6933a;
    }

    public static void enableAnrInfo(boolean z10) {
        boolean z11 = k.f6933a;
        g.u = z10;
    }

    public static void enableLoopMonitor(boolean z10) {
        boolean z11 = k.f6933a;
        g.f2165t = z10;
    }

    public static void enableNativeDump(boolean z10) {
        boolean z11 = k.f6933a;
        g.f2167w = z10;
    }

    public static void enableThreadsBoost() {
        g.o = 1;
    }

    public static ConfigManager getConfigManager() {
        return g.g;
    }

    public static boolean hasCrash() {
        boolean z10 = k.f6933a;
        return C1797b.m || NativeImpl.q();
    }

    public static boolean hasCrashWhenJavaCrash() {
        boolean z10 = k.f6933a;
        Boolean bool = (Boolean) C1797b.n.get();
        return (bool != null && bool.booleanValue()) || NativeImpl.q();
    }

    public static boolean hasCrashWhenNativeCrash() {
        boolean z10 = k.f6933a;
        return C1797b.m;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0058 A[Catch: all -> 0x00a5, TryCatch #1 {, blocks: (B:4:0x0003, B:9:0x000a, B:20:0x004f, B:31:0x0072, B:33:0x0087, B:23:0x0058, B:25:0x005c, B:26:0x0063, B:12:0x0036, B:14:0x003a, B:15:0x0041), top: B:45:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0087 A[Catch: all -> 0x00a5, TRY_LEAVE, TryCatch #1 {, blocks: (B:4:0x0003, B:9:0x000a, B:20:0x004f, B:31:0x0072, B:33:0x0087, B:23:0x0058, B:25:0x005c, B:26:0x0063, B:12:0x0036, B:14:0x003a, B:15:0x0041), top: B:45:0x0003 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static synchronized void init(@androidx.annotation.NonNull android.app.Application r6, @androidx.annotation.NonNull android.content.Context r7, @androidx.annotation.NonNull com.apm.insight.ICommonParams r8, boolean r9, boolean r10, boolean r11, boolean r12, long r13) {
        /*
            java.lang.Class<com.apm.insight.Npth> r13 = com.apm.insight.Npth.class
            monitor-enter(r13)
            boolean r14 = com.apm.insight.Npth.sInit     // Catch: java.lang.Throwable -> La5
            if (r14 == 0) goto L9
            monitor-exit(r13)
            return
        L9:
            r14 = 1
            com.apm.insight.Npth.sInit = r14     // Catch: java.lang.Throwable -> La5
            r0 = r6
            r1 = r7
            r2 = r9
            r3 = r10
            r4 = r11
            r5 = r12
            z2.k.a(r0, r1, r2, r3, r4, r5)     // Catch: java.lang.Throwable -> La5
            com.apm.insight.g.d(r0, r1)     // Catch: java.lang.Throwable -> La5
            A5.c r6 = new A5.c     // Catch: java.lang.Throwable -> La5
            android.content.Context r7 = com.apm.insight.g.f2160a     // Catch: java.lang.Throwable -> La5
            A5.c r9 = com.apm.insight.g.a()     // Catch: java.lang.Throwable -> La5
            r6.<init>(r7, r8, r9)     // Catch: java.lang.Throwable -> La5
            com.apm.insight.g.f = r6     // Catch: java.lang.Throwable -> La5
            A5.c r6 = com.apm.insight.g.a()     // Catch: java.lang.Throwable -> La5
            java.util.Map r6 = r6.h()     // Catch: java.lang.Throwable -> La5
            java.lang.String r7 = "update_version_code"
            java.lang.Object r7 = r6.get(r7)     // Catch: java.lang.Throwable -> La5
            if (r7 != 0) goto L36
            goto L4e
        L36:
            boolean r8 = r7 instanceof java.lang.Integer     // Catch: java.lang.Throwable -> La5
            if (r8 == 0) goto L41
            java.lang.Integer r7 = (java.lang.Integer) r7     // Catch: java.lang.Throwable -> La5
            int r7 = r7.intValue()     // Catch: java.lang.Throwable -> La5
            goto L4f
        L41:
            boolean r8 = r7 instanceof java.lang.String     // Catch: java.lang.Throwable -> La5
            if (r8 == 0) goto L4e
            java.lang.String r7 = java.lang.String.valueOf(r7)     // Catch: java.lang.Throwable -> L4e
            int r7 = java.lang.Integer.parseInt(r7)     // Catch: java.lang.Throwable -> L4e
            goto L4f
        L4e:
            r7 = 0
        L4f:
            java.lang.String r8 = "aid"
            java.lang.Object r8 = r6.get(r8)     // Catch: java.lang.Throwable -> La5
            if (r8 != 0) goto L58
            goto L70
        L58:
            boolean r9 = r8 instanceof java.lang.Integer     // Catch: java.lang.Throwable -> La5
            if (r9 == 0) goto L63
            java.lang.Integer r8 = (java.lang.Integer) r8     // Catch: java.lang.Throwable -> La5
            int r8 = r8.intValue()     // Catch: java.lang.Throwable -> La5
            goto L72
        L63:
            boolean r9 = r8 instanceof java.lang.String     // Catch: java.lang.Throwable -> La5
            if (r9 == 0) goto L70
            java.lang.String r8 = java.lang.String.valueOf(r8)     // Catch: java.lang.Throwable -> L70
            int r8 = java.lang.Integer.parseInt(r8)     // Catch: java.lang.Throwable -> L70
            goto L72
        L70:
            r8 = 4444(0x115c, float:6.227E-42)
        L72:
            java.lang.String r9 = "app_version"
            java.lang.Object r9 = r6.get(r9)     // Catch: java.lang.Throwable -> La5
            java.lang.String r9 = java.lang.String.valueOf(r9)     // Catch: java.lang.Throwable -> La5
            java.lang.String r8 = java.lang.String.valueOf(r8)     // Catch: java.lang.Throwable -> La5
            long r10 = (long) r7     // Catch: java.lang.Throwable -> La5
            com.apm.insight.MonitorCrash r7 = com.apm.insight.MonitorCrash.init(r1, r8, r10, r9)     // Catch: java.lang.Throwable -> La5
            if (r7 == 0) goto La8
            com.apm.insight.MonitorCrash$Config r7 = r7.config()     // Catch: java.lang.Throwable -> La5
            A5.c r8 = com.apm.insight.g.a()     // Catch: java.lang.Throwable -> La5
            java.lang.String r8 = r8.r()     // Catch: java.lang.Throwable -> La5
            com.apm.insight.MonitorCrash$Config r7 = r7.setDeviceId(r8)     // Catch: java.lang.Throwable -> La5
            java.lang.String r8 = "channel"
            java.lang.Object r6 = r6.get(r8)     // Catch: java.lang.Throwable -> La5
            java.lang.String r6 = java.lang.String.valueOf(r6)     // Catch: java.lang.Throwable -> La5
            r7.setChannel(r6)     // Catch: java.lang.Throwable -> La5
            goto La8
        La5:
            r0 = move-exception
            r6 = r0
            goto Laa
        La8:
            monitor-exit(r13)
            return
        Laa:
            monitor-exit(r13)     // Catch: java.lang.Throwable -> La5
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.apm.insight.Npth.init(android.app.Application, android.content.Context, com.apm.insight.ICommonParams, boolean, boolean, boolean, boolean, long):void");
    }

    public static synchronized void initMiniApp(@NonNull Context context, @NonNull ICommonParams iCommonParams) {
        g.e = true;
        init(context, iCommonParams, true, false, true, true);
    }

    public static boolean isANREnable() {
        return k.c;
    }

    public static boolean isInit() {
        return sInit;
    }

    public static boolean isJavaCrashEnable() {
        return k.b;
    }

    public static boolean isNativeCrashEnable() {
        return k.d;
    }

    public static boolean isRunning() {
        boolean z10 = k.f6933a;
        return SystemClock.uptimeMillis() - B0.f.d <= 15000;
    }

    public static boolean isStopUpload() {
        return k.h;
    }

    public static void openANRMonitor() {
        if (k.f6933a) {
            C1483a c1483a = (C1483a) h2.d.m(g.f2160a).f4555a;
            if (!c1483a.c) {
                c1483a.f4543a = new B0.f(c1483a);
                c1483a.d = g.c;
                c1483a.c = true;
            }
            k.c = true;
        }
    }

    public static void openJavaCrashMonitor() {
        if (!k.f6933a || k.b) {
            return;
        }
        Context context = g.f2160a;
        C1797b c1797bC = C1797b.c();
        c1797bC.b = new com.zyql.ability.sdk.client.b(context, 2);
        c1797bC.c = new com.zyql.ability.sdk.client.b(context, 1);
    }

    public static boolean openNativeCrashMonitor() {
        if (k.f6933a && !k.d) {
            boolean zG = NativeImpl.g(g.f2160a);
            k.d = zG;
            if (!zG) {
                k.e = true;
            }
        }
        return k.d;
    }

    public static void registerCrashCallback(ICrashCallback iCrashCallback, CrashType crashType) {
        k.c(iCrashCallback, crashType);
    }

    public static void registerOOMCallback(IOOMCallback iOOMCallback) {
        ((CopyOnWriteArrayList) k.f.e).add(iOOMCallback);
    }

    public static void registerSdk(int i, String str) {
        if (g.i == null) {
            synchronized (g.class) {
                try {
                    if (g.i == null) {
                        g.i = new ConcurrentHashMap();
                    }
                } finally {
                }
            }
        }
        g.i.put(Integer.valueOf(i), str);
    }

    public static void removeAttachLongUserData(AttachUserData attachUserData, CrashType crashType) {
        if (attachUserData != null) {
            u1.d dVar = g.h;
            dVar.getClass();
            if (crashType != CrashType.ALL) {
                dVar.Q(attachUserData, crashType);
                return;
            }
            dVar.Q(attachUserData, CrashType.LAUNCH);
            dVar.Q(attachUserData, CrashType.JAVA);
            dVar.Q(attachUserData, CrashType.CUSTOM_JAVA);
            dVar.Q(attachUserData, CrashType.NATIVE);
            dVar.Q(attachUserData, CrashType.ANR);
            dVar.Q(attachUserData, CrashType.DART);
        }
    }

    public static void removeAttachUserData(AttachUserData attachUserData, CrashType crashType) {
        if (attachUserData != null) {
            u1.d dVar = g.h;
            dVar.getClass();
            if (crashType != CrashType.ALL) {
                dVar.P(attachUserData, crashType);
                return;
            }
            dVar.P(attachUserData, CrashType.LAUNCH);
            dVar.P(attachUserData, CrashType.JAVA);
            dVar.P(attachUserData, CrashType.CUSTOM_JAVA);
            dVar.P(attachUserData, CrashType.NATIVE);
            dVar.P(attachUserData, CrashType.ANR);
            dVar.P(attachUserData, CrashType.DART);
        }
    }

    @Keep
    public static void reportDartError(String str) {
        S0.b.N("reportDartError " + str);
        boolean z10 = k.f6933a;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        AbstractC0291a.k(str, null, null, null, null);
    }

    @Deprecated
    public static void reportError(String str) {
        boolean z10 = k.f6933a;
        if (g.g.isReportErrorEnable()) {
            C1797b c1797b = C1797b.l;
            if (str == null) {
                return;
            }
            try {
                l.i().a(new Y.a(str, 2));
            } catch (Throwable unused) {
            }
        }
    }

    public static void setAlogFlushAddr(long j5) {
        boolean z10 = k.f6933a;
    }

    public static void setAlogFlushV2Addr(long j5) {
        boolean z10 = k.f6933a;
        NativeImpl.j(j5);
    }

    public static void setAlogLogDirAddr(long j5) {
        boolean z10 = k.f6933a;
        NativeImpl.o(j5);
    }

    public static void setAlogWriteAddr(long j5) {
    }

    public static void setAnrInfoFileObserver(String str, d dVar) {
        boolean z10 = k.f6933a;
        l.i().a(new A.a(24, str, false, dVar));
    }

    public static void setApplication(Application application) {
        if (application != null) {
            g.b = application;
        } else {
            Context context = g.f2160a;
        }
    }

    @Deprecated
    public static void setAttachUserData(AttachUserData attachUserData, CrashType crashType) {
        if (attachUserData != null) {
            g.h.x(attachUserData, crashType);
        }
    }

    public static void setBusiness(String str) {
        if (str != null) {
            g.d = str;
        }
    }

    public static void setCrashFilter(ICrashFilter iCrashFilter) {
        g.h.e = iCrashFilter;
    }

    public static void setCurProcessName(String str) {
        com.stepos.statsrpk.d.b = str;
    }

    public static void setEncryptImpl(@NonNull c cVar) {
        boolean z10 = k.f6933a;
        g.g.setEncryptImpl(cVar);
    }

    public static void setLogcatImpl(z2.g gVar) {
        boolean z10 = k.f6933a;
    }

    public static void setRequestIntercept(m mVar) {
        boolean z10 = k.f6933a;
    }

    public static void stopAnr() {
        if (k.f6933a) {
            C1483a c1483a = (C1483a) h2.d.m(g.f2160a).f4555a;
            if (c1483a.c) {
                c1483a.c = false;
                B0.f fVar = c1483a.f4543a;
                if (fVar != null) {
                    fVar.b = true;
                }
                c1483a.f4543a = null;
            }
            k.c = false;
        }
    }

    public static void stopUpload() {
        k.h = true;
    }

    public static void unregisterCrashCallback(ICrashCallback iCrashCallback, CrashType crashType) {
        k.d(iCrashCallback, crashType);
    }

    public static void unregisterOOMCallback(IOOMCallback iOOMCallback, CrashType crashType) {
        ((CopyOnWriteArrayList) k.f.e).remove(iOOMCallback);
    }

    public static synchronized void initMiniApp(@NonNull Context context, @NonNull ICommonParams iCommonParams, int i, String str) {
        g.e = true;
        g.m = i;
        g.n = str;
        init(context, iCommonParams, true, true, true, true);
    }

    @Keep
    public static void reportDartError(String str, @Nullable Map<? extends String, ? extends String> map, @Nullable Map<String, String> map2, @Nullable IUploadCallback iUploadCallback) {
        S0.b.N("reportDartError " + str);
        boolean z10 = k.f6933a;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        AbstractC0291a.k(str, map, map2, null, iUploadCallback);
    }

    @Deprecated
    public static void reportError(@NonNull Throwable th) {
        boolean z10 = k.f6933a;
        if (g.g.isReportErrorEnable()) {
            C1797b c1797b = C1797b.l;
            if (th == null) {
                return;
            }
            try {
                l.i().a(new RunnableC1756a(1, th));
            } catch (Throwable unused) {
            }
        }
    }

    @Keep
    public static void reportDartError(String str, @Nullable Map<? extends String, ? extends String> map, @Nullable Map<String, String> map2, @Nullable Map<String, String> map3, @Nullable IUploadCallback iUploadCallback) {
        S0.b.N("reportDartError " + str);
        boolean z10 = k.f6933a;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        AbstractC0291a.k(str, map, map2, map3, iUploadCallback);
    }

    public static synchronized void init(@NonNull Context context, @NonNull ICommonParams iCommonParams) {
        init(context, iCommonParams, true, false, false);
    }

    public static synchronized void init(@NonNull Context context, @NonNull ICommonParams iCommonParams, boolean z10, boolean z11, boolean z12) {
        init(context, iCommonParams, z10, z10, z11, z12);
    }

    public static synchronized void init(@NonNull Context context, @NonNull ICommonParams iCommonParams, boolean z10, boolean z11, boolean z12, boolean z13) {
        init(context, iCommonParams, z10, z11, z12, z13, 0L);
    }

    public static synchronized void init(@NonNull Context context, @NonNull ICommonParams iCommonParams, boolean z10, boolean z11, boolean z12, boolean z13, long j5) {
        Application application = g.b;
        if (application == null) {
            if (context instanceof Application) {
                application = (Application) context;
                if (application.getBaseContext() == null) {
                    throw new IllegalArgumentException("初始化时传入的Application还未attach, 请在init时传入attachBaseContext的参数, 并在init之前手动调用Npth.setApplication(Application).");
                }
            } else {
                application = (Application) context.getApplicationContext();
                if (application == null) {
                    throw new IllegalArgumentException("初始化时传入了baseContext, 导致无法获取Application实例, 请在init之前手动调用Npth.setApplication(Application).");
                }
                if (application.getBaseContext() != null) {
                    context = application.getBaseContext();
                }
            }
        }
        init(application, context, iCommonParams, z10, z11, z12, z13, j5);
    }
}
