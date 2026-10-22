package com.obric.aiagent.skill.manager.impl;

import android.os.SystemClock;
import com.obric.aiagent.assistant.idl.IFlowSettingsIDL;
import com.obric.aiagent.skill.manager.api.ISkillSettingsService;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONObject;

/* JADX INFO: compiled from: SkillSettingsServiceImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class SkillSettingsServiceImpl implements ISkillSettingsService {
    private static final String CLOUD_SETTINGS_KEY = "o_agent_skills";
    private static final a Companion = null;
    private static final long INIT_RECOVER_POLL_INTERVAL_MS = 1000;
    private static final int INIT_RECOVER_POLL_TIMES = 10;
    private static final long REFRESH_TTL_MS = 3600000;
    private final Object fetchLock;
    private final AtomicBoolean initialized;
    private final AtomicBoolean isFetchSettingSuccess;
    private final AtomicBoolean isFlowIPCRegistered;
    private final AtomicBoolean isRecovering;
    private final AtomicBoolean isRefreshing;
    private final AtomicLong lastSuccessElapsedMs;
    private final kotlinx.coroutines.am settingsScope;
    private final fd settingsStore;

    /* JADX INFO: compiled from: SkillSettingsServiceImpl.kt */
    private static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: SkillSettingsServiceImpl.kt */
    @d.c.b.a.f(b = "SkillSettingsServiceImpl.kt", c = {107}, d = "invokeSuspend", e = "com.obric.aiagent.skill.manager.impl.SkillSettingsServiceImpl$initSettings$1$1")
    static final class b extends d.c.b.a.l implements d.h.a.m<kotlinx.coroutines.am, d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f19417a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ SkillSettingsServiceImpl f19418b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ IFlowSettingsIDL f19419c;

        b(SkillSettingsServiceImpl r3, IFlowSettingsIDL r4, d.c.d<? super b> r5) {
            IFlowSettingsIDL r6 = (IFlowSettingsIDL) ZeusTransformUtils.wrapperContextForParams(r4, IFlowSettingsIDL.class, "com.obric.aiagent.plugin");
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f19418b = r3;
            this.f19419c = r6;
            super(2, r7);
        }

        public final Object a(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
            return ((b) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), b.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new b(this.f19418b, this.f19419c, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
            return a((kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r10) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f19417a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r10);
        L14:
            return d.x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r10);
            SkillSettingsServiceImpl.fetchSkillSettings$default(this.f19418b, this.f19419c, "init", false, 4, null);
            if (SkillSettingsServiceImpl.access$isFetchSettingSuccess$p(this.f19418b).get() == true) goto L14;
            SkillSettingsServiceImpl r11 = this.f19418b;
            d.c.d r2 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f19417a = 1;
            if (SkillSettingsServiceImpl.access$pollRecoverAfterInitFailure(r11, r2) != r0) goto L14;
            return r0;
        }
    }

    /* JADX INFO: compiled from: SkillSettingsServiceImpl.kt */
    @d.c.b.a.f(b = "SkillSettingsServiceImpl.kt", c = {134}, d = "pollRecoverAfterInitFailure", e = "com.obric.aiagent.skill.manager.impl.SkillSettingsServiceImpl")
    static final class c extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f19420a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f19421b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        /* synthetic */ Object f19422c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ SkillSettingsServiceImpl f19423d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f19424e;

        c(SkillSettingsServiceImpl r3, d.c.d<? super c> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f19423d = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f19422c = r3;
            this.f19424e |= Integer.MIN_VALUE;
            return SkillSettingsServiceImpl.access$pollRecoverAfterInitFailure(this.f19423d, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: SkillSettingsServiceImpl.kt */
    @d.c.b.a.f(b = "SkillSettingsServiceImpl.kt", c = {}, d = "invokeSuspend", e = "com.obric.aiagent.skill.manager.impl.SkillSettingsServiceImpl$recoverFromFailure$1")
    static final class d extends d.c.b.a.l implements d.h.a.m<kotlinx.coroutines.am, d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f19425a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ SkillSettingsServiceImpl f19426b;

        d(SkillSettingsServiceImpl r3, d.c.d<? super d> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f19426b = r3;
            super(2, r5);
        }

        public final Object a(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
            return ((d) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), d.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new d(this.f19426b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
            return a((kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r2) {
            d.c.a.b.a();
            if (this.f19425a != 0) goto L7;
            d.o.a(r2);
            SkillSettingsServiceImpl.access$recoverInternal(this.f19426b);
            return d.x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: SkillSettingsServiceImpl.kt */
    @d.c.b.a.f(b = "SkillSettingsServiceImpl.kt", c = {}, d = "invokeSuspend", e = "com.obric.aiagent.skill.manager.impl.SkillSettingsServiceImpl$refreshSettingsIfStale$1")
    static final class e extends d.c.b.a.l implements d.h.a.m<kotlinx.coroutines.am, d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f19427a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ SkillSettingsServiceImpl f19428b;

        e(SkillSettingsServiceImpl r3, d.c.d<? super e> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f19428b = r3;
            super(2, r5);
        }

        public final Object a(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
            return ((e) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), e.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new e(this.f19428b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
            return a((kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r8) {
            d.c.a.b.a();
            if (this.f19427a != 0) goto L22;
            d.o.a(r8);
            IFlowSettingsIDL r0 = com.obric.aiagent.assistant.idl.at.a(d.h.b.aa.b(IFlowSettingsIDL.class));     // Catch: Throwable -> L12 Exception -> L14
            if (r0 != null) goto L10;
            ee.b(ee.f19808a, "SkillManager", "Skill settings TTL refresh skipped because IPC is unavailable", null, 4, null);     // Catch: Throwable -> L12 Exception -> L14
            d.x r1 = d.x.f38692a;     // Catch: Throwable -> L12 Exception -> L14
            SkillSettingsServiceImpl.access$isRefreshing$p(this.f19428b).set(false);
            return r1;
        L10:
            SkillSettingsServiceImpl.access$fetchSkillSettings(this.f19428b, r0, "refresh", true);     // Catch: Throwable -> L12 Exception -> L14
        L11:
            SkillSettingsServiceImpl.access$isRefreshing$p(this.f19428b).set(false);
            return d.x.f38692a;
        L12:
            th = move-exception;
            SkillSettingsServiceImpl.access$isRefreshing$p(this.f19428b).set(false);
            throw th;
        L14:
            e = move-exception;
            ee.f19808a.a("SkillManager", "Skill settings TTL refresh failed", "Skill settings TTL refresh failed: " + e.getMessage(), (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L12
            goto L11
        L22:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    static {
        Companion = new a(null);
    }

    /* JADX INFO: renamed from: lambda$yQascBfm6PLCol6Gp2Pjo-Ey1bs, reason: not valid java name */
    public static /* synthetic */ void m270lambda$yQascBfm6PLCol6Gp2PjoEy1bs(SkillSettingsServiceImpl r0, IFlowSettingsIDL r1) {
        initSettings$lambda$0(r0, r1);
    }

    public SkillSettingsServiceImpl() {
        this.settingsScope = kotlinx.coroutines.an.a(kotlinx.coroutines.cx.a(null, 1, null).plus((d.c.g) ZeusTransformUtils.preCheckCast(kotlinx.coroutines.bd.c(), d.c.g.class, "com.obric.aiagent.plugin")));
        this.settingsStore = new fd();
        this.initialized = new AtomicBoolean(false);
        this.isFlowIPCRegistered = new AtomicBoolean(false);
        this.isFetchSettingSuccess = new AtomicBoolean(false);
        this.isRecovering = new AtomicBoolean(false);
        this.isRefreshing = new AtomicBoolean(false);
        this.lastSuccessElapsedMs = new AtomicLong(0);
        this.fetchLock = new Object();
        initSettings();
    }

    public static final /* synthetic */ void access$fetchSkillSettings(SkillSettingsServiceImpl r2, IFlowSettingsIDL r3, String r4, boolean r5) {
        r2.fetchSkillSettings((IFlowSettingsIDL) ZeusTransformUtils.wrapperContextForParams(r3, IFlowSettingsIDL.class, "com.obric.aiagent.plugin"), r4, r5);
    }

    public static final /* synthetic */ AtomicBoolean access$isFetchSettingSuccess$p(SkillSettingsServiceImpl r0) {
        return r0.isFetchSettingSuccess;
    }

    public static final /* synthetic */ AtomicBoolean access$isRefreshing$p(SkillSettingsServiceImpl r0) {
        return r0.isRefreshing;
    }

    public static final /* synthetic */ Object access$pollRecoverAfterInitFailure(SkillSettingsServiceImpl r2, d.c.d r3) {
        return r2.pollRecoverAfterInitFailure((d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ void access$recoverInternal(SkillSettingsServiceImpl r0) {
        r0.recoverInternal();
    }

    @Override // com.obric.aiagent.skill.manager.api.ISkillSettingsService
    public com.obric.aiagent.skill.manager.api.al getSettings() {
        if (this.isFetchSettingSuccess.get() == false) goto L5;
        refreshSettingsIfStale();
    L9:
        return this.settingsStore.a();
    L5:
        if (this.isFlowIPCRegistered.get() == false) goto L9;
        recoverFromFailure$default(this, false, 1, null);
        goto L9
    }

    private final void refreshSettingsIfStale() {
        if (this.isFlowIPCRegistered.get() == true) goto L5;
        return;
    L5:
        long r0 = this.lastSuccessElapsedMs.get();
        if (r0 == 0) goto L11;
        if ((SystemClock.elapsedRealtime() - r0) >= 3600000) goto L11;
        return;
    L11:
        if (this.isRefreshing.compareAndSet(false, true) == true) goto L13;
        return;
    L13:
        kotlinx.coroutines.i.a(this.settingsScope, null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new e(this, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
    }

    private final void initSettings() {
        if (this.initialized.compareAndSet(false, true) == true) goto L6;
        ee.a(ee.f19808a, "SkillManager", "Skill settings initialization already in progress", null, 4, null);
        return;
    L6:
        com.obric.aiagent.assistant.idl.at.a(d.h.b.aa.b(IFlowSettingsIDL.class), false, false, new $$Lambda$SkillSettingsServiceImpl$yQascBfm6PLCol6Gp2PjoEy1bs(this), 3, null);
    }

    private static final void initSettings$lambda$0(SkillSettingsServiceImpl r14, IFlowSettingsIDL r15) {
        IFlowSettingsIDL r16 = (IFlowSettingsIDL) ZeusTransformUtils.wrapperContextForParams(r15, IFlowSettingsIDL.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r16, "ipc");
        if (r14.isFlowIPCRegistered.compareAndSet(false, true) == true) goto L6;
        ee.a(ee.f19808a, "SkillManager", "Flow settings IPC is already registered", null, 4, null);
        return;
    L6:
        ee.a(ee.f19808a, "SkillManager", "Flow settings IPC registered", null, 4, null);
        kotlinx.coroutines.i.a(r14.settingsScope, null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new b(r14, r16, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x00bc -> B:28:0x00cf). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x00cd -> B:27:0x00ce). Please report as a decompilation issue!!! */
    private final Object pollRecoverAfterInitFailure(d.c.d<? super d.x> r12) {
        d.c.d r13 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r12, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r13, c.class) == false) goto L7;
        c r0 = (c) ZeusTransformUtils.preCheckCast(r13, c.class, "com.obric.aiagent.plugin");
        if ((r0.f19424e & Integer.MIN_VALUE) == 0) goto L7;
        r0.f19424e -= Integer.MIN_VALUE;
    L8:
        Object r14 = r0.f19422c;
        Object r2 = d.c.a.b.a();
        int r3 = r0.f19424e;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        int r11 = r0.f19421b;
        SkillSettingsServiceImpl r1 = (SkillSettingsServiceImpl) ZeusTransformUtils.preCheckCast(r0.f19420a, SkillSettingsServiceImpl.class, "com.obric.aiagent.plugin");
        d.o.a(r14);
    L27:
        SkillSettingsServiceImpl r15 = r1;
    L28:
        r11 = r11 + 1;
    L16:
        if (r11 >= 11) goto L29;
        ee.a(ee.f19808a, "SkillManager", "Skill settings recovery polling tick=" + r11 + "/10", null, 4, null);
        r15.recoverFromFailure(false);
        if (r15.isFetchSettingSuccess.get() == false) goto L22;
        ee.a(ee.f19808a, "SkillManager", "Skill settings recovery polling succeeded, tick=" + r11 + "/10", null, 4, null);
        return d.x.f38692a;
    L22:
        if (r11 >= 10) goto L28;
        r0.f19420a = r15;
        r0.f19421b = r11;
        r0.f19424e = 1;
        if (kotlinx.coroutines.ax.a(1000, r0) != r2) goto L26;
        return r2;
    L26:
        r1 = r15;
        goto L27
    L29:
        ee.b(ee.f19808a, "SkillManager", "Skill settings recovery polling reached max retries, success=" + r15.isFetchSettingSuccess.get(), null, 4, null);
        return d.x.f38692a;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        d.o.a(r14);
        ee.a(ee.f19808a, "SkillManager", "Skill settings recovery polling started, times=10 interval_ms=1000", null, 4, null);
        r15 = this;
        r11 = 1;
    L7:
        r0 = new c(this, r13);
        goto L8
    }

    static /* synthetic */ void recoverFromFailure$default(SkillSettingsServiceImpl r0, boolean r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = true;
    L5:
        r0.recoverFromFailure(r1);
    }

    private final void recoverFromFailure(boolean r8) {
        if (this.isFetchSettingSuccess.get() == false) goto L6;
        return;
    L6:
        if (this.isFlowIPCRegistered.get() == true) goto L9;
        return;
    L9:
        if (this.isRecovering.compareAndSet(false, true) == true) goto L11;
        return;
    L11:
        if (r8 == false) goto L13;
        kotlinx.coroutines.i.a(this.settingsScope, null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new d(this, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
        return;
    L13:
        recoverInternal();
    }

    private final void recoverInternal() {
        IFlowSettingsIDL r3 = com.obric.aiagent.assistant.idl.at.a(d.h.b.aa.b(IFlowSettingsIDL.class));     // Catch: Throwable -> L10 Exception -> L12
        if (r3 != null) goto L8;
        ee.b(ee.f19808a, "SkillManager", "Skill settings recovery skipped because IPC is unavailable", null, 4, null);     // Catch: Throwable -> L10 Exception -> L12
        this.isRecovering.set(false);
        return;
    L8:
        fetchSkillSettings$default(this, r3, "recover", false, 4, null);     // Catch: Throwable -> L10 Exception -> L12
    L9:
        this.isRecovering.set(false);
        return;
    L12:
        e = move-exception;
        ee.f19808a.a("SkillManager", "Skill settings recovery failed", "Skill settings recovery failed: " + e.getMessage(), (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        this.isRecovering.set(false);
        throw th;
    }

    static /* synthetic */ void fetchSkillSettings$default(SkillSettingsServiceImpl r1, IFlowSettingsIDL r2, String r3, boolean r4, int r5, Object r6) {
        IFlowSettingsIDL r7 = (IFlowSettingsIDL) ZeusTransformUtils.wrapperContextForParams(r2, IFlowSettingsIDL.class, "com.obric.aiagent.plugin");
        if ((r5 & 4) == 0) goto L5;
        r4 = false;
    L5:
        r1.fetchSkillSettings(r7, r3, r4);
    }

    private final void fetchSkillSettings(IFlowSettingsIDL r10, String r11, boolean r12) {
        IFlowSettingsIDL r13 = (IFlowSettingsIDL) ZeusTransformUtils.wrapperContextForParams(r10, IFlowSettingsIDL.class, "com.obric.aiagent.plugin");
        Object r0 = this.fetchLock;
        monitor-enter(r0);
    L35:
        th = move-exception;
        throw th;
    L5:
        if (this.isFetchSettingSuccess.get() == false) goto L40;
        if (r12 == true) goto L40;
        monitor-exit(r0);
        return;
    L40:
        String r14 = r13.getObricCloudConfig(CLOUD_SETTINGS_KEY);     // Catch: Exception -> L31 Throwable -> L35
        CharSequence r1 = (CharSequence) ZeusTransformUtils.preCheckCast(r14, CharSequence.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L35
        if (r1 != null) goto L13;
    L16:
        boolean r2 = true;
    L17:
        if (r2 == false) goto L19;
    L28:
        applyFetchFailure$default(this, r11, "config_unavailable", null, r12, 4, null);     // Catch: Throwable -> L35
        monitor-exit(r0);
        return;
    L19:
        if (d.o.o.a(r14, "null", true) == true) goto L28;
        this.settingsStore.a(new JSONObject(r14));     // Catch: Exception -> L23 Throwable -> L35
        this.isFetchSettingSuccess.set(true);     // Catch: Exception -> L23 Throwable -> L35
        this.lastSuccessElapsedMs.set(SystemClock.elapsedRealtime());     // Catch: Exception -> L23 Throwable -> L35
        ee.a(ee.f19808a, "SkillManager", "Skill settings fetch succeeded, phase=" + r11 + " source=cloud", null, 4, null);     // Catch: Exception -> L23 Throwable -> L35
    L25:
        d.x r9 = d.x.f38692a;     // Catch: Throwable -> L35
        monitor-exit(r0);
        return;
    L23:
        e = move-exception;
        applyFetchFailure(r11, "parse_exception", e, r12);     // Catch: Throwable -> L35
        goto L25
    L13:
        if (d.o.o.d(r1) == true) goto L16;
        r2 = false;
        goto L17
    L31:
        e = move-exception;
        applyFetchFailure(r11, "ipc_read_exception", e, r12);     // Catch: Throwable -> L35
    }

    static /* synthetic */ void applyFetchFailure$default(SkillSettingsServiceImpl r0, String r1, String r2, Exception r3, boolean r4, int r5, Object r6) {
        if ((r5 & 4) == 0) goto L6;
        r3 = null;
    L6:
        if ((r5 & 8) == 0) goto L8;
        r4 = false;
    L8:
        r0.applyFetchFailure(r1, r2, r3, r4);
    }

    private final void applyFetchFailure(String r11, String r12, Exception r13, boolean r14) {
        if (r14 == false) goto L12;
        if (this.isFetchSettingSuccess.get() == false) goto L12;
        String r6 = "Skill settings refresh failed, phase=" + r11 + " source=cache reason=" + r12;
        if (r13 != null) goto L9;
        ee.b(ee.f19808a, "SkillManager", r6, null, 4, null);
        return;
    L9:
        ee.f19808a.a("SkillManager", "Skill settings refresh failed, phase=" + r11 + " reason=" + r12, r6 + ": " + r13.getMessage(), (Throwable) ZeusTransformUtils.preCheckCast(r13, Throwable.class, "com.obric.aiagent.plugin"));
        return;
    L12:
        if (this.isFetchSettingSuccess.get() == true) goto L14;
        this.settingsStore.b();
    L14:
        this.isFetchSettingSuccess.set(false);
        String r7 = "Skill settings fetch failed, phase=" + r11 + " source=default reason=" + r12;
        if (r13 != null) goto L17;
        ee.b(ee.f19808a, "SkillManager", r7, null, 4, null);
        return;
    L17:
        ee.f19808a.a("SkillManager", "Skill settings fetch failed, phase=" + r11 + " reason=" + r12, r7 + ": " + r13.getMessage(), (Throwable) ZeusTransformUtils.preCheckCast(r13, Throwable.class, "com.obric.aiagent.plugin"));
    }
}
