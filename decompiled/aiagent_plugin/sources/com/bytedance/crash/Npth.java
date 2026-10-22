package com.bytedance.crash;

import android.app.Application;
import android.content.Context;
import com.bytedance.crash.crash.CrashSummary;
import com.bytedance.crash.jni.NativeBridge;
import com.bytedance.crash.runtime.ConfigManager;
import com.bytedance.crash.runtime.DefaultWorkThread;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class Npth {
    private static final ah sCachedDataCenter = null;

    static class a extends aa {
        a() {
        }

        @Override // com.bytedance.crash.aa
        public void a(aa.a r3) {
            final aa.a r4 = (aa.a) ZeusTransformUtils.wrapperContextForParams(r3, aa.a.class, "com.obric.aiagent.plugin");
            if (r4 != null) goto L5;
            return;
        L5:
            Npth.addTag("has_register_evil_callback", String.valueOf(true));
            com.bytedance.crash.dumper.h.a(new AnonymousClass1(this, r4));
        }

        @Override // com.bytedance.crash.aa
        public String a() {
            return com.bytedance.crash.dumper.c.a();
        }

        static void b() {
            new a();
            aa.a(new AnonymousClass2());
        }
    }

    @Deprecated
    public static long getFileSize(String r2) {
        return 0;
    }

    @Deprecated
    public static long getFolderSize(String r2) {
        return 0;
    }

    @Deprecated
    public static boolean hasCrashWhenNativeCrash() {
        return false;
    }

    @Deprecated
    public static void openANRMonitor() {
    }

    @Deprecated
    public static void openJavaCrashMonitor() {
    }

    @Deprecated
    public static boolean openNativeCrashMonitor() {
        return false;
    }

    @Deprecated
    public static void registerCrashCallbackOnDrop(c r0, CrashType r1) {
    }

    @Deprecated
    public static void setANRCheckEnable(boolean r0) {
    }

    @Deprecated
    public static void setAlogFlushAddr(long r0) {
    }

    @Deprecated
    public static void setAlogLogDirAddr(long r0) {
    }

    @Deprecated
    public static void setAlogWriteAddr(long r0) {
    }

    @Deprecated
    public static void setInitAnrAhead(boolean r0) {
    }

    public static void setTerminateMonitorDelayTime(long r0) {
    }

    @Deprecated
    public static void stopEnsure() {
    }

    @Deprecated
    public static void stopUpload() {
    }

    public Npth() {
    }

    static {
        sCachedDataCenter = com.bytedance.crash.monitor.h.e();
    }

    public static synchronized void init(Context r3, ICommonParams r4) {
        monitor-enter(Npth.class);
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L11
        ICommonParams r6 = (ICommonParams) ZeusTransformUtils.wrapperContextForParams(r4, ICommonParams.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L11
        if (isInit() == false) goto L8;
        monitor-exit(Npth.class);
        return;
    L8:
        com.bytedance.crash.c.a.a();     // Catch: Throwable -> L11
        final com.bytedance.crash.monitor.a r7 = com.bytedance.crash.monitor.h.a(r5, r6);     // Catch: Throwable -> L11
        r7.a(new com.bytedance.crash.dumper.j(r6));     // Catch: Throwable -> L11
        a.b();     // Catch: Throwable -> L11
        DefaultWorkThread.post(new AnonymousClass1(r7));     // Catch: Throwable -> L11
        com.bytedance.crash.c.a.b();     // Catch: Throwable -> L11
        monitor-exit(Npth.class);
        return;
    L11:
        th = move-exception;
        throw th;
    }

    public static synchronized void init(Context r7, ICommonParams r8, boolean r9, boolean r10, boolean r11) {
        monitor-enter(Npth.class);
        init((Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.aiagent.plugin"), (ICommonParams) ZeusTransformUtils.wrapperContextForParams(r8, ICommonParams.class, "com.obric.aiagent.plugin"), r9, r9, r10, r11);     // Catch: Throwable -> L7
        monitor-exit(Npth.class);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static synchronized void init(Context r9, ICommonParams r10, boolean r11, boolean r12, boolean r13, boolean r14) {
        monitor-enter(Npth.class);
        init((Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin"), (ICommonParams) ZeusTransformUtils.wrapperContextForParams(r10, ICommonParams.class, "com.obric.aiagent.plugin"), r11, r12, r13, r14, 0);     // Catch: Throwable -> L7
        monitor-exit(Npth.class);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static synchronized void init(Context r11, ICommonParams r12, boolean r13, boolean r14, boolean r15, boolean r16, long r17) {
        monitor-enter(Npth.class);
        init(null, (Context) ZeusTransformUtils.wrapperContextForParams(r11, Context.class, "com.obric.aiagent.plugin"), (ICommonParams) ZeusTransformUtils.wrapperContextForParams(r12, ICommonParams.class, "com.obric.aiagent.plugin"), r13, r14, r15, r16, r17);     // Catch: Throwable -> L7
        monitor-exit(Npth.class);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static synchronized void init(Application r0, Context r1, ICommonParams r2, boolean r3, boolean r4, boolean r5, boolean r6, long r7) {
        monitor-enter(Npth.class);
        Application r8 = (Application) ZeusTransformUtils.wrapperContextForParams(r0, Application.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L7
        init((Context) ZeusTransformUtils.wrapperContextForParams(r1, Context.class, "com.obric.aiagent.plugin"), (ICommonParams) ZeusTransformUtils.wrapperContextForParams(r2, ICommonParams.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L7
        monitor-exit(Npth.class);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static synchronized com.bytedance.crash.monitor.f initSDK(Context r8, String r9, int r10, long r11, String r13) {
        monitor-enter(Npth.class);
        com.bytedance.crash.monitor.f r12 = com.bytedance.crash.monitor.h.a((Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.aiagent.plugin"), r9, r10, r11, r13);     // Catch: Throwable -> L7
        monitor-exit(Npth.class);
        return r12;
    L7:
        th = move-exception;
        throw th;
    }

    public static synchronized void initMiniApp(Context r7, ICommonParams r8) {
        monitor-enter(Npth.class);
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L7
        ICommonParams r2 = (ICommonParams) ZeusTransformUtils.wrapperContextForParams(r8, ICommonParams.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L7
        ad.a(true);     // Catch: Throwable -> L7
        init(r1, r2, true, false, true, true);     // Catch: Throwable -> L7
        monitor-exit(Npth.class);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static synchronized void initMiniApp(Context r7, ICommonParams r8, int r9, String r10) {
        monitor-enter(Npth.class);
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L7
        ICommonParams r2 = (ICommonParams) ZeusTransformUtils.wrapperContextForParams(r8, ICommonParams.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L7
        ad.a(true);     // Catch: Throwable -> L7
        ad.a(r9, r10);     // Catch: Throwable -> L7
        init(r1, r2, true, true, true, true);     // Catch: Throwable -> L7
        monitor-exit(Npth.class);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static boolean isJavaCrashEnable() {
        return ad.b();
    }

    public static boolean isANREnable() {
        return ad.b();
    }

    public static boolean isNativeCrashEnable() {
        return ad.b();
    }

    public static boolean isInit() {
        if (com.bytedance.crash.monitor.h.a() == null) goto L5;
        return true;
    L5:
        return false;
    }

    public static void setCurProcessName(String r0) {
        com.bytedance.crash.o.b.a(r0);
    }

    public static void setApplication(Application r2) {
        Application r3 = (Application) ZeusTransformUtils.wrapperContextForParams(r2, Application.class, "com.obric.aiagent.plugin");
        if (r3 == null) goto L6;
        i.a(r3);
        return;
    }

    @Deprecated
    public static void setAnrInfoFileObserver(String r2, r r3) {
        ad.a(r2, (r) ZeusTransformUtils.wrapperContextForParams(r3, r.class, "com.obric.aiagent.plugin"));
    }

    @Deprecated
    public static void setLogcatImpl(com.bytedance.crash.runtime.b r2) {
        ad.a((com.bytedance.crash.runtime.b) ZeusTransformUtils.wrapperContextForParams(r2, com.bytedance.crash.runtime.b.class, "com.obric.aiagent.plugin"));
    }

    public static boolean isRunning() {
        return ad.c();
    }

    public static void reportDartError(String r0) {
        ad.a(r0);
    }

    public static void reportDartError(String r2, Map<? extends String, ? extends String> r3, Map<String, String> r4, w r5) {
        ad.a(r2, (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin"), (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.aiagent.plugin"), (w) ZeusTransformUtils.wrapperContextForParams(r5, w.class, "com.obric.aiagent.plugin"));
    }

    public static void reportGameException(String r0, String r1, String r2) {
        ad.a(r0, r1, r2);
    }

    public static ConfigManager getConfigManager() {
        return ac.a();
    }

    public static void scanNativeCrash(Context r13, c r14, String[] r15) {
        List<CrashSummary> r16 = com.bytedance.crash.crash.b.a((Context) ZeusTransformUtils.wrapperContextForParams(r13, Context.class, "com.obric.aiagent.plugin"));
        if (r16 != null) goto L5;
        return;
    L5:
        Iterator<CrashSummary> r17 = r16.iterator();
    L7:
        if (r17.hasNext() == false) goto L12;
        CrashSummary r18 = (CrashSummary) ZeusTransformUtils.preCheckCast(r17.next(), CrashSummary.class, "com.obric.aiagent.plugin");
        if (r18 == null) goto L7;
        r14.a(0, null, r18.getCrashType(), r18.getStartTime(), r18.getCrashTime(), r18.getProcessName(), r18.getStackTrace(), null, null);
        goto L7
    }

    public static void addImportTags(Map<? extends String, ? extends String> r2) {
        Map r3 = (Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.aiagent.plugin");
        if (r3 != null) goto L5;
        return;
    L5:
        if (r3.isEmpty() == true) goto L9;
        ag.a(r3);
        return;
    }

    public static void addImportTag(String r0, String r1) {
        ag.a(r0, r1);
    }

    public static void removeImportTag(String r0) {
        ag.a(r0);
    }

    public static void addTags(Map<? extends String, ? extends String> r2) {
        ag.a((Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.aiagent.plugin"), sCachedDataCenter);
    }

    public static void addTag(String r1, String r2) {
        ag.a(r1, r2, sCachedDataCenter);
    }

    public static void removeTag(String r1) {
        ag.a(r1, sCachedDataCenter);
    }

    public static void registerCrashCallback(ICrashCallback r2, CrashType r3) {
        ICrashCallback r4 = (ICrashCallback) ZeusTransformUtils.wrapperContextForParams(r2, ICrashCallback.class, "com.obric.aiagent.plugin");
        sCachedDataCenter.a(r4, r3);
    }

    public static void registerCrashInfoCallback(d r1, CrashType r2) {
        sCachedDataCenter.a(r1, r2);
    }

    public static void registerANRCallback(k r2) {
        k r3 = (k) ZeusTransformUtils.wrapperContextForParams(r2, k.class, "com.obric.aiagent.plugin");
        sCachedDataCenter.a(r3);
    }

    public static void registerOOMCallback(IOOMCallback r2) {
        IOOMCallback r3 = (IOOMCallback) ZeusTransformUtils.wrapperContextForParams(r2, IOOMCallback.class, "com.obric.aiagent.plugin");
        sCachedDataCenter.a(r3);
    }

    public static void registerHprofCallback(IOOMCallback r2) {
        IOOMCallback r3 = (IOOMCallback) ZeusTransformUtils.wrapperContextForParams(r2, IOOMCallback.class, "com.obric.aiagent.plugin");
        sCachedDataCenter.c(r3);
    }

    public static void unregisterCrashCallback(ICrashCallback r2, CrashType r3) {
        ICrashCallback r4 = (ICrashCallback) ZeusTransformUtils.wrapperContextForParams(r2, ICrashCallback.class, "com.obric.aiagent.plugin");
        sCachedDataCenter.b(r4, r3);
    }

    public static void unregisterOOMCallback(IOOMCallback r1, CrashType r2) {
        IOOMCallback r3 = (IOOMCallback) ZeusTransformUtils.wrapperContextForParams(r1, IOOMCallback.class, "com.obric.aiagent.plugin");
        sCachedDataCenter.b(r3);
    }

    public static void unregisterHprofCallback(IOOMCallback r1, CrashType r2) {
        IOOMCallback r3 = (IOOMCallback) ZeusTransformUtils.wrapperContextForParams(r1, IOOMCallback.class, "com.obric.aiagent.plugin");
        sCachedDataCenter.d(r3);
    }

    public static void setCrashFilter(ICrashFilter r2) {
        ICrashFilter r3 = (ICrashFilter) ZeusTransformUtils.wrapperContextForParams(r2, ICrashFilter.class, "com.obric.aiagent.plugin");
        sCachedDataCenter.a(r3);
    }

    public static void addAttachUserData(AttachUserData r2, CrashType r3) {
        AttachUserData r4 = (AttachUserData) ZeusTransformUtils.wrapperContextForParams(r2, AttachUserData.class, "com.obric.aiagent.plugin");
        sCachedDataCenter.a(r4, r3);
    }

    public static void addAttachLongUserData(AttachUserData r2, CrashType r3) {
        AttachUserData r4 = (AttachUserData) ZeusTransformUtils.wrapperContextForParams(r2, AttachUserData.class, "com.obric.aiagent.plugin");
        sCachedDataCenter.a(r4, r3);
    }

    public static void removeAttachUserData(AttachUserData r2, CrashType r3) {
        AttachUserData r4 = (AttachUserData) ZeusTransformUtils.wrapperContextForParams(r2, AttachUserData.class, "com.obric.aiagent.plugin");
        sCachedDataCenter.a(r3, r4);
    }

    public static void removeAttachLongUserData(AttachUserData r2, CrashType r3) {
        AttachUserData r4 = (AttachUserData) ZeusTransformUtils.wrapperContextForParams(r2, AttachUserData.class, "com.obric.aiagent.plugin");
        sCachedDataCenter.a(r3, r4);
    }

    public static void registerSdk(int r1, String r2) {
        sCachedDataCenter.a(r1, r2);
    }

    public static void registerSdk(String r1, String r2) {
        sCachedDataCenter.c(r1, r2);
    }

    public static void addUserCrashInfoCallback(x r2, CrashType r3) {
        x r4 = (x) ZeusTransformUtils.wrapperContextForParams(r2, x.class, "com.obric.aiagent.plugin");
        if (r4 == null) goto L6;
        sCachedDataCenter.a(r4, r3);
        return;
    }

    public static void removeCrashInfoCallback(x r2, CrashType r3) {
        x r4 = (x) ZeusTransformUtils.wrapperContextForParams(r2, x.class, "com.obric.aiagent.plugin");
        if (r4 == null) goto L6;
        sCachedDataCenter.b(r4, r3);
        return;
    }

    public static void setScriptStackCallback(u r2) {
        ad.a((u) ZeusTransformUtils.wrapperContextForParams(r2, u.class, "com.obric.aiagent.plugin"));
    }

    public static void stopAnr() {
        ad.e();
    }

    public static void setRequestIntercept(com.bytedance.crash.upload.f r2) {
        ad.a((com.bytedance.crash.upload.f) ZeusTransformUtils.wrapperContextForParams(r2, com.bytedance.crash.upload.f.class, "com.obric.aiagent.plugin"));
    }

    public static void setAlogFlushV2Addr(long r0) {
        com.bytedance.crash.alog.a.a(r0);
    }

    public static void enableALogCollector(String r2, com.bytedance.crash.alog.c r3, com.bytedance.crash.alog.d r4) {
        ad.a(r2, (com.bytedance.crash.alog.c) ZeusTransformUtils.wrapperContextForParams(r3, com.bytedance.crash.alog.c.class, "com.obric.aiagent.plugin"), (com.bytedance.crash.alog.d) ZeusTransformUtils.wrapperContextForParams(r4, com.bytedance.crash.alog.d.class, "com.obric.aiagent.plugin"));
    }

    public static boolean hasCrash() {
        return ad.f();
    }

    public static void enableGwpAsan(boolean r0) {
        if (r0 == false) goto L5;
        ad.d();
        return;
    }

    public static void setEncryptImpl(o r2) {
        ad.a((o) ZeusTransformUtils.wrapperContextForParams(r2, o.class, "com.obric.aiagent.plugin"));
    }

    public static void customActivityName(com.bytedance.crash.h.a r2) {
        ActivityLifecycle.a((com.bytedance.crash.h.a) ZeusTransformUtils.wrapperContextForParams(r2, com.bytedance.crash.h.a.class, "com.obric.aiagent.plugin"));
    }

    @Deprecated
    public static void reportError(Throwable r0) {
        ad.a(r0);
    }

    @Deprecated
    public static void reportError(String r0) {
        ad.b(r0);
    }

    @Deprecated
    public static void setAttachUserData(AttachUserData r2, CrashType r3) {
        addAttachUserData((AttachUserData) ZeusTransformUtils.wrapperContextForParams(r2, AttachUserData.class, "com.obric.aiagent.plugin"), r3);
    }

    public static void dumpHprof(String r0) {
        NativeBridge.p(r0);
    }

    @Deprecated
    public static boolean isStopUpload() {
        return ad.g();
    }

    @Deprecated
    public static void setBusiness(String r0) {
        i.a(r0);
    }

    public static void setRequestPermission(com.bytedance.crash.upload.g r2) {
        com.bytedance.crash.upload.b.a((com.bytedance.crash.upload.g) ZeusTransformUtils.wrapperContextForParams(r2, com.bytedance.crash.upload.g.class, "com.obric.aiagent.plugin"));
    }

    public static void setOpenNewAnrMonitor(boolean r0) {
        j.b(r0);
    }

    public static void setCrashMonitorService(n r2) {
        i.a((n) ZeusTransformUtils.wrapperContextForParams(r2, n.class, "com.obric.aiagent.plugin"));
    }

    public static void setFixDumpStack(boolean r0) {
        com.bytedance.crash.k.a.a(r0);
    }

    public static void setUrlConnectionInterceptor(com.bytedance.crash.l.c r2) {
        com.bytedance.crash.upload.b.a((com.bytedance.crash.l.c) ZeusTransformUtils.wrapperContextForParams(r2, com.bytedance.crash.l.c.class, "com.obric.aiagent.plugin"));
    }

    public static void setMaxCacheSize(int r0) {
        com.bytedance.crash.d.e.a(r0);
    }

    public static void setQueueLimitSize(int r0) {
        com.bytedance.crash.d.e.b(r0);
    }

    public static void addWhiteLogType(String r0) {
        com.bytedance.crash.d.e.a(r0);
    }

    public static int optMtkBuffer(int r0) {
        return com.bytedance.crash.k.a.a(r0);
    }

    public static int fixScudoVmaLeak() {
        return com.bytedance.crash.k.a.a();
    }

    public static void setTagCacheService(v r2) {
        ag.a((v) ZeusTransformUtils.wrapperContextForParams(r2, v.class, "com.obric.aiagent.plugin"));
        ah r0 = sCachedDataCenter;
        ag.a(new HashMap(r0.d()), r0);
        r0.e();
    }

    public static void setTagOpt(boolean r1) {
        sCachedDataCenter.a(r1);
    }

    public static void addCustomCrashReasonArray(String r1, String r2) {
        sCachedDataCenter.a(r1, r2);
    }

    public static void removeCustomCrashReasonArray(String r1) {
        sCachedDataCenter.a(r1);
    }

    public static void setCustomCrashReasonArrayLimit(String r1, int r2) {
        sCachedDataCenter.a(r1, r2);
    }

    public static void setCrashUploadCallback(e r2) {
        e r3 = (e) ZeusTransformUtils.wrapperContextForParams(r2, e.class, "com.obric.aiagent.plugin");
        sCachedDataCenter.a(r3);
    }

    public static void ignoreExceptionTag(boolean r0) {
        ah.b(r0);
    }

    public static void setTerminateOpt(boolean r0) {
        ah.c(r0);
    }

    public static void optProcessTrackDisk() {
        ah.l();
    }

    public static void setOpenDumpTraceOpt(boolean r0) {
        ah.d(r0);
    }

    public static void setNpthInitOptEnable(boolean r0) {
        ah.e(r0);
    }

    public static void setUseLocalDomain(boolean r0) {
        com.bytedance.crash.monitor.b.b(r0);
    }

    public static void setDomainName(String r1) {
        com.bytedance.crash.runtime.a.a(new URL(r1).getHost());     // Catch: Throwable -> L4
        return;
    }

    public static void setRequestHeaderProvider(com.bytedance.crash.l.f r2) {
        af.a((com.bytedance.crash.l.f) ZeusTransformUtils.wrapperContextForParams(r2, com.bytedance.crash.l.f.class, "com.obric.aiagent.plugin"));
    }

    public static void setNetworkCallback(com.bytedance.crash.l.e r2) {
        af.a((com.bytedance.crash.l.e) ZeusTransformUtils.wrapperContextForParams(r2, com.bytedance.crash.l.e.class, "com.obric.aiagent.plugin"));
    }

    public static int startOptMtkBuffer(int r0) {
        return ad.a(r0);
    }

    public static void setUploadDelayTime(long r0) {
        com.bytedance.crash.upload.h.a(r0);
    }

    public static void setCrashAccessibilityEnable(boolean r0) {
        com.bytedance.crash.n.d.a(r0);
    }

    public static void pause() {
        com.bytedance.crash.d.d.a(true);
        com.bytedance.crash.d.g.a(true);
    }

    public static void resume() {
        com.bytedance.crash.d.d.a(false);
        com.bytedance.crash.d.g.a(false);
    }

    public static void setAnrDisableDumpData(boolean r0) {
        com.bytedance.crash.anr.e.b(r0);
    }

    @Deprecated
    public static void registerPreCrashCallback(t r2, CrashType r3) {
        t r4 = (t) ZeusTransformUtils.wrapperContextForParams(r2, t.class, "com.obric.aiagent.plugin");
        sCachedDataCenter.a(r4, r3);
    }

    @Deprecated
    public static void unregisterPreCrashCallback(t r2, CrashType r3) {
        t r4 = (t) ZeusTransformUtils.wrapperContextForParams(r2, t.class, "com.obric.aiagent.plugin");
        sCachedDataCenter.b(r4, r3);
    }

    public static void registerPreANRCallback(s r2) {
        s r3 = (s) ZeusTransformUtils.wrapperContextForParams(r2, s.class, "com.obric.aiagent.plugin");
        sCachedDataCenter.a(r3);
    }

    public static void unregisterPreANRCallback(s r2) {
        s r3 = (s) ZeusTransformUtils.wrapperContextForParams(r2, s.class, "com.obric.aiagent.plugin");
        sCachedDataCenter.b(r3);
    }

    public static void registerAnrUploadCallback(l r2) {
        l r3 = (l) ZeusTransformUtils.wrapperContextForParams(r2, l.class, "com.obric.aiagent.plugin");
        sCachedDataCenter.a(r3);
    }

    public static void setIgnoreHandler(com.bytedance.crash.f.a r0) {
        com.bytedance.crash.crash.d.a(r0);
    }

    public static void setAnrMonitorOpt(boolean r0) {
        j.a(r0);
    }

    public static void setCloseBgAnr(boolean r0) {
        ah.f(r0);
    }

    public static void setANRImprovementOpt(boolean r0) {
        j.c(r0);
    }

    public static void setDumpAnrAsync(boolean r0) {
        ad.b(r0);
    }

    public static void setAnrResendSigquit(boolean r0) {
        ad.c(r0);
    }

    public static void clean() {
        com.bytedance.crash.d.e.a();
    }

    public static void reportBizException(String r2, Throwable r3, String r4, Map<String, String> r5) {
        Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.aiagent.plugin");
        if (r2 == null) goto L8;
        if (r3 == null) goto L9;
        reportBizException(r2, r3, r4, r6, false);
        return;
    L9:
        return;
    }

    public static void reportBizException(String r7, Throwable r8, String r9, Map<String, String> r10, boolean r11) {
        Map<String, String> r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r10, Map.class, "com.obric.aiagent.plugin");
        if (r7 == null) goto L8;
        if (r8 == null) goto L9;
        com.bytedance.crash.d.c.a().a(r7, r8, r9, r4, null, r11);
        return;
    L9:
        return;
    }

    public static void reportBizException(String r8, Throwable r9, String r10, Map<String, String> r11, Map<String, String> r12) {
        Map r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r11, Map.class, "com.obric.aiagent.plugin");
        Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r12, Map.class, "com.obric.aiagent.plugin");
        if (r8 == null) goto L8;
        if (r9 == null) goto L9;
        reportBizException(r8, r9, r10, r5, r6, false);
        return;
    L9:
        return;
    }

    public static void reportBizException(String r9, Throwable r10, String r11, Map<String, String> r12, Map<String, String> r13, boolean r14) {
        Map<String, String> r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r12, Map.class, "com.obric.aiagent.plugin");
        Map<String, String> r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r13, Map.class, "com.obric.aiagent.plugin");
        if (r9 == null) goto L8;
        if (r10 == null) goto L9;
        com.bytedance.crash.d.c.a().a(r9, r10, r11, r6, r7, r14);
        return;
    L9:
        return;
    }

    public static void reportBizException(String r7, com.bytedance.crash.d.j r8, boolean r9) {
        com.bytedance.crash.d.j r10 = (com.bytedance.crash.d.j) ZeusTransformUtils.wrapperContextForParams(r8, com.bytedance.crash.d.j.class, "com.obric.aiagent.plugin");
        if (r7 == null) goto L16;
        if (r10 != null) goto L7;
        return;
    L7:
        if (com.bytedance.crash.d.c.b() == true) goto L9;
    L11:
        com.bytedance.crash.d.a r11 = r10.a();
        if (r11 != null) goto L14;
        return;
    L14:
        com.bytedance.crash.d.c.a().a(r7, r11.a(), r11.b(), r11.c(), r11.d(), r9);
        return;
    L9:
        if (com.bytedance.crash.d.c.a(r7) == true) goto L11;
        return;
    }

    public static void reportBizException(String r2, com.bytedance.crash.d.j r3) {
        reportBizException(r2, (com.bytedance.crash.d.j) ZeusTransformUtils.wrapperContextForParams(r3, com.bytedance.crash.d.j.class, "com.obric.aiagent.plugin"), false);
    }

    public static boolean addNativeProtectorConfig(JSONObject r0) {
        return com.bytedance.crash.j.b.a(r0);
    }
}
