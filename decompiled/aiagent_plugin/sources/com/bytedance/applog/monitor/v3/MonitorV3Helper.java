package com.bytedance.applog.monitor.v3;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import com.bytedance.applog.log.m;
import com.bytedance.applog.monitor.v3.impl.SentryMonitor;
import com.bytedance.applog.monitor.v3.impl.StatsMonitor;
import com.bytedance.bdinstall.ai;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.crash.general.RomInfo;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;
import os.teatracker.IBdInstall;

/* JADX INFO: loaded from: classes.dex */
public class MonitorV3Helper implements Handler.Callback {
    private static final int MSG_REPORT = 1;
    public static final int SENTRY_STAINED_FLAG_EVENT_VERIFY_ONLY = 2;
    public static final int SENTRY_STAINED_FLAG_ONLINE_ONLY = 1;
    private static final String launchUuid = null;
    private static final List<String> logTags = null;
    private static int monitorAppId;
    private e config;
    private final c configManager;
    private final com.bytedance.applog.monitor.v3.impl.a errorMonitor;
    private final JSONObject features;
    private Handler handler;
    private final AtomicBoolean hasInit;
    private final JSONObject header;
    private final SentryMonitor sentryMonitor;
    private final StatsMonitor statsMonitor;

    static /* synthetic */ List access$000() {
        return logTags;
    }

    static /* synthetic */ e access$100(MonitorV3Helper r0) {
        return r0.config;
    }

    static /* synthetic */ JSONObject access$200(MonitorV3Helper r0) {
        return r0.header;
    }

    static /* synthetic */ JSONObject access$300(MonitorV3Helper r0) {
        return r0.features;
    }

    static /* synthetic */ SentryMonitor access$400(MonitorV3Helper r0) {
        return r0.sentryMonitor;
    }

    static /* synthetic */ StatsMonitor access$500(MonitorV3Helper r0) {
        return r0.statsMonitor;
    }

    static /* synthetic */ com.bytedance.applog.monitor.v3.impl.a access$600(MonitorV3Helper r0) {
        return r0.errorMonitor;
    }

    static {
        logTags = Collections.singletonList("MonitorV3Helper");
        launchUuid = UUID.randomUUID().toString();
        monitorAppId = 3590;
    }

    public static void setMonitorAppId(int r0) {
        if (r0 <= 0) goto L5;
        monitorAppId = r0;
        return;
    }

    public MonitorV3Helper() {
        c r0 = new c();
        this.configManager = r0;
        this.errorMonitor = new com.bytedance.applog.monitor.v3.impl.a(r0);
        this.sentryMonitor = new SentryMonitor(r0);
        this.statsMonitor = new StatsMonitor(r0);
        this.header = new JSONObject();
        this.hasInit = new AtomicBoolean(false);
        this.features = new JSONObject();
        setStringHeader("cold_start_id", launchUuid);
    }

    public c getConfigManager() {
        return this.configManager;
    }

    public void setHeader(String r6, String r7) {
        if (isEnabled() == true) goto L5;
        return;
    L5:
        m.a().b(8, logTags, "setHeader {} = {}", new Object[]{r6, r7});
        this.header.put(r6, r7);     // Catch: Throwable -> L8
        return;
    }

    public void setFeature(String r8, boolean r9) {
        if (isEnabled() == true) goto L5;
        return;
    L5:
        m.a().b(8, logTags, "setFeature boolean {} = {}", new Object[]{r8, Boolean.valueOf(r9)});
        JSONObject r0 = this.features;
        monitor-enter(r0);
        JSONObject r7 = this.features;     // Catch: Throwable -> L13
        if (r9 == false) goto L10;
        int r10 = 1;
    L11:
        r7.put(r8, r10);     // Catch: Throwable -> L13
    L15:
        monitor-exit(r0);     // Catch: Throwable -> L17
        return;
    L10:
        r10 = 0;
    L17:
        th = move-exception;
        throw th;
    L13:
        th = move-exception;
        m.a().b(8, logTags, "setFeature json error", new Object[]{th});     // Catch: Throwable -> L17
        goto L15
    }

    public void setFeature(String r8, String r9) {
        if (isEnabled() == true) goto L5;
        return;
    L5:
        m.a().b(8, logTags, "setFeature string {} = {}", new Object[]{r8, r9});
        JSONObject r0 = this.features;
        monitor-enter(r0);
        this.features.put(r8, r9);     // Catch: Throwable -> L9
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L13
        return;
    L9:
        th = move-exception;
        m.a().b(8, logTags, "setFeature json error", new Object[]{th});     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        throw th;
    }

    public void setFeature(String r8, JSONObject r9) {
        if (isEnabled() == true) goto L5;
        return;
    L5:
        m.a().b(8, logTags, "setFeature json {} = {}", new Object[]{r8, r9});
        JSONObject r0 = this.features;
        monitor-enter(r0);
        this.features.put(r8, r9);     // Catch: Throwable -> L9
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L13
        return;
    L9:
        th = move-exception;
        m.a().b(8, logTags, "setFeature json error", new Object[]{th});     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        throw th;
    }

    public void setFeature(String r8, long r9) {
        if (isEnabled() == true) goto L5;
        return;
    L5:
        m.a().b(8, logTags, "setFeature int {} = {}", new Object[]{r8, Long.valueOf(r9)});
        JSONObject r0 = this.features;
        monitor-enter(r0);
        this.features.put(r8, r9);     // Catch: Throwable -> L9
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L13
        return;
    L9:
        th = move-exception;
        m.a().b(8, logTags, "setFeature json error", new Object[]{th});     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        throw th;
    }

    public void increaseStats(j r2) {
        increaseStats(r2, 1);
    }

    public void increaseStats(String r2) {
        increaseStats(r2, 1);
    }

    public void increaseStats(j r7, int r8) {
        if (isEnabled() == true) goto L5;
        return;
    L5:
        m.a().b(8, logTags, "increaseStats {} +{}", new Object[]{r7, Integer.valueOf(r8)});
        this.statsMonitor.increase(r7.name(), r8);
    }

    public void increaseStats(String r7, int r8) {
        if (isEnabled() == true) goto L5;
        return;
    L5:
        m.a().b(8, logTags, "increaseStats {} +{}", new Object[]{r7, Integer.valueOf(r8)});
        this.statsMonitor.increase(r7, r8);
    }

    public boolean isEventHitStage(String r2) {
        if (isStageEnabled() == true) goto L7;
        return false;
    L7:
        return this.sentryMonitor.isEventHitSampling(r2);
    }

    public boolean isEventMaybeAccepted(String r2) {
        if (isStageEnabled() == true) goto L7;
        return false;
    L7:
        return this.sentryMonitor.isEventMaybeAccepted(r2);
    }

    public void stageEvent(a r10, String r11, String r12, long r13, i r15) {
        stageEvent(null, -1, r10, r11, r12, r13, r15);
    }

    public void stageEvent(String r15, int r16, a r17, String r18, String r19, long r20, i r22) {
        if (isStageEnabled() == true) goto L5;
        return;
    L5:
        m.a().b(8, logTags, "stageEvent {} -> event: {}, monitor_id: {}, ts: {}, type: {}, priority: {}-{}", new Object[]{r17, r18, r19, Long.valueOf(r20), r22, r15, Integer.valueOf(r16)});
        this.sentryMonitor.stage(r15, r16, r17, r18, r19, r20, r22);
    }

    public void sendError(String r2, Throwable r3) {
        sendError(r2, r3, true);
    }

    public void sendError(String r6, Throwable r7, boolean r8) {
        if (isErrorEnabled() == true) goto L5;
        return;
    L5:
        m.a().b(8, logTags, "sendError {} -> {}", new Object[]{r6, r7});
        this.errorMonitor.a(r6, r7);
        if (r8 == false) goto L9;
        com.bytedance.applog.monitor.a.b.a().a(r6, r7);
        return;
    }

    public void init(e r8) {
        m.a().b(8, logTags, "init monitor v3 helper with config: {}", new Object[]{r8});
        if (this.hasInit.compareAndSet(false, true) == true) goto L5;
        return;
    L5:
        this.config = r8;
        d r0 = r8.a();
        if (this.configManager.a() == true) goto L8;
    L31:
        this.errorMonitor.a();
        this.sentryMonitor.initWithDisabled();
        this.statsMonitor.initWithDisabled();
        return;
    L8:
        if (((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r8.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")) == null) goto L31;
        if (r0 == null) goto L31;
        setStringHeader(WsConstants.KEY_APP_ID, String.valueOf(monitorAppId));
        setStringHeader("host_aid", r0.a());
        setStringHeader("channel", r0.b());
        setStringHeader("cdid", r0.k());
        setStringHeader("sdk_version_v2", r0.j());
        setStringHeader(RomInfo.KEY_OS_TYPE, "Android");
        setStringHeader(RomInfo.KEY_ROM_OS_VERSION, Build.VERSION.RELEASE);
        setStringHeader(IBdInstall.PARAM_APP_NAME, r0.d());
        setStringHeader(WsConstants.KEY_APP_VERSION, r0.c());
        setStringHeader("update_version_code", String.valueOf(r0.e()));
        if (r0.f() == false) goto L15;
        setFeature("log_enable", 1);
    L15:
        if (r0.l() == false) goto L18;
        setFeature("devtools_enable", 1);
    L18:
        if (r0.g() == false) goto L21;
        setFeature("tourist_mode", 1);
    L21:
        if (r0.h() == false) goto L24;
        setFeature("frequency_control_enable", 1);
    L24:
        if (r0.i() == false) goto L27;
        setFeature("log_event_filter_enable", 1);
    L27:
        if (isDebugMode() == false) goto L29;
        setFeature("debug_mode", 1);
    L29:
        setFeature("report_interval", r8.b());
        String r1 = r0.a();
        this.configManager.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r8.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r1);
        HandlerThread r4 = new HandlerThread(r0.a() + "@applog_monitor_v3");
        r4.start();
        Handler r2 = new Handler(r4.getLooper(), this);
        this.handler = r2;
        r2.sendEmptyMessageDelayed(1, this.configManager.f());
        this.errorMonitor.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r8.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r4, r1);
        this.sentryMonitor.init((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r8.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r4, r1);
        this.statsMonitor.init((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r8.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r4, r1);
    }

    public void flush() {
        if (this.handler != null) goto L5;
        return;
    L5:
        m.a().b(8, logTags, "monitor flush...", new Object[0]);
        this.handler.removeMessages(1);
        this.handler.sendEmptyMessageDelayed(1, 500);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message r2) {
        if (r2.what != 1) goto L8;
        doReport();
        return false;
    L8:
        return false;
    }

    public void setStringHeader(String r6, String r7) {
        if (isEnabled() == true) goto L5;
        return;
    L5:
        m.a().b(8, logTags, "setStringHeader {}: {}", new Object[]{r6, r7});
        this.header.put(r6, r7);     // Catch: Throwable -> L8
        return;
    }

    public boolean isEnabled() {
        return this.configManager.a();
    }

    public boolean isStageEnabled() {
        if (isEnabled() == true) goto L5;
    L7:
        return false;
    L5:
        if (this.configManager.h() == false) goto L7;
        return true;
    }

    public boolean isDebugMode() {
        return this.configManager.j();
    }

    public boolean isStageForAllEvents() {
        if (isStageEnabled() == true) goto L5;
    L7:
        return false;
    L5:
        if (this.sentryMonitor.isAcceptAllEvents() == false) goto L7;
        return true;
    }

    public boolean isErrorEnabled() {
        if (isEnabled() == true) goto L5;
    L7:
        return false;
    L5:
        if (this.configManager.d() == false) goto L7;
        return true;
    }

    private void doReport() {
        if (isEnabled() == false) goto L15;
        e r0 = this.config;
        if (r0 != null) goto L7;
        return;
    L7:
        if (r0.c() != null) goto L9;
        return;
    L9:
        if (this.config.e() != null) goto L11;
        return;
    L11:
        if (TextUtils.isEmpty(this.config.d()) == true) goto L19;
        m.a().b(8, logTags, "start doReport...", new Object[0]);
        final long r4 = this.configManager.b();
        final int r3 = this.configManager.c();
        final ai r6 = this.config.c();
        final String r7 = this.config.d();
        this.config.e().submit(new AnonymousClass1(this, r3, r4, r6, r7));
        this.handler.removeMessages(1);
        this.handler.sendEmptyMessageDelayed(1, this.configManager.e());
        return;
    L19:
        return;
    }
}
