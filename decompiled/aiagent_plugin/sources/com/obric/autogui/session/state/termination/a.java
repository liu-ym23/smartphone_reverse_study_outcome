package com.obric.autogui.session.state.termination;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.bytedance.security.zenmobile.io.SensitiveType;
import com.obric.aiagent.plugin.R;
import com.obric.autogui.agents.vlm.models.a.g;
import com.obric.autogui.agents.vlm.models.omni.r;
import com.obric.autogui.common.api.AOBizTracking;
import com.obric.autogui.common.api.AOSystemTools;
import com.obric.autogui.common.api.agent.BizStatus;
import com.obric.autogui.common.api.agent.model.EndStepParams;
import com.obric.autogui.common.api.app.AOHostAppTools;
import com.obric.autogui.common.api.logging.LogUtil;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.platform.display.DisplayAccessor;
import com.obric.autogui.common.api.platform.display.capture.IScreenshot;
import com.obric.autogui.common.api.platform.display.capture.ScreenshotResult;
import com.obric.autogui.common.api.platform.tracking.IAutoActionTrackingApi;
import com.obric.autogui.common.api.space.AOOperatingSpace;
import com.obric.autogui.common.api.space.OperatingSpaceManager;
import com.obric.autogui.common.api.space.status.SpaceStatus;
import com.obric.autogui.common.e;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ao;
import d.c.b.a.l;
import d.f;
import d.n;
import d.o;
import d.x;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlinx.coroutines.w;
import kotlinx.coroutines.y;
import org.json.JSONObject;

/* JADX INFO: compiled from: AOSessionTerminationManager.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.obric.autogui.session.a f31411a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f31412b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f31413c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f31414d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f31415e;
    private boolean f;
    private int g;
    private final f h;
    private final AtomicBoolean i;
    private w<Bitmap> j;
    private final Bundle k;

    /* JADX INFO: renamed from: com.obric.autogui.session.state.termination.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AOSessionTerminationManager.kt */
    private static final class C0859a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long f31416a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long f31417b;

        public boolean equals(Object r9) {
            if (this != r9) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r9, C0859a.class) == true) goto L8;
            return false;
        L8:
            C0859a r10 = (C0859a) ZeusTransformUtils.preCheckCast(r9, C0859a.class, "com.obric.aiagent.plugin");
            if (this.f31416a == r10.f31416a) goto L12;
            return false;
        L12:
            if (this.f31417b == r10.f31417b) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (Long.hashCode(this.f31416a) * 31) + Long.hashCode(this.f31417b);
        }

        public String toString() {
            return "UserTerminationMetrics(waitedTimeMillis=" + this.f31416a + ", taskDuration=" + this.f31417b + ')';
        }

        public C0859a(long r1, long r3) {
            this.f31416a = r1;
            this.f31417b = r3;
        }

        public final long a() {
            return this.f31416a;
        }

        public final long b() {
            return this.f31417b;
        }
    }

    /* JADX INFO: compiled from: AOSessionTerminationManager.kt */
    @d.c.b.a.f(b = "AOSessionTerminationManager.kt", c = {264, 269}, d = "acquireTerminationScreenshot", e = "com.obric.autogui.session.state.termination.AOSessionTerminationManager")
    static final class b extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f31418a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f31419b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ a f31420c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f31421d;

        b(a r3, d.c.d<? super b> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f31420c = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f31419b = r3;
            this.f31421d |= Integer.MIN_VALUE;
            return this.f31420c.a((d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: AOSessionTerminationManager.kt */
    @d.c.b.a.f(b = "AOSessionTerminationManager.kt", c = {172}, d = "invokeSuspend", e = "com.obric.autogui.session.state.termination.AOSessionTerminationManager$systemTerminate$2")
    static final class c extends l implements d.h.a.b<d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f31422a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.obric.autogui.session.state.b f31423b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f31424c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ a f31425d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ e f31426e;
        final /* synthetic */ EndStepParams f;
        final /* synthetic */ Map<String, Object> g;

        c(com.obric.autogui.session.state.b r3, int r4, a r5, e r6, EndStepParams r7, Map<String, ? extends Object> r8, d.c.d<? super c> r9) {
            Map<String, Object> r10 = (Map) ZeusTransformUtils.wrapperContextForParams(r8, Map.class, "com.obric.aiagent.plugin");
            d.c.d r11 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r9, d.c.d.class, "com.obric.aiagent.plugin");
            this.f31423b = r3;
            this.f31424c = r4;
            this.f31425d = r5;
            this.f31426e = r6;
            this.f = r7;
            this.g = r10;
            super(1, r11);
        }

        public final Object a(d.c.d<? super x> r3) {
            return ((c) ZeusTransformUtils.preCheckCast(create((d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin")), c.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(d.c.d<?> r11) {
            d.c.d r9 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r11, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new c(this.f31423b, this.f31424c, this.f31425d, this.f31426e, this.f, this.g, r9), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.b
        public /* synthetic */ Object invoke(d.c.d<? super x> r3) {
            return a((d.c.d) ZeusTransformUtils.preCheckCast(r3, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r11) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f31422a;
            boolean r2 = true;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r11);
        L23:
            e r12 = (e) ZeusTransformUtils.preCheckCast(r11, e.class, "com.obric.aiagent.plugin");
            if (r12.g() == true) goto L26;
            Loog.INSTANCE.e(LogUtil.INSTANCE.getCLAZZ_TAG(this.f31425d), "(ses/" + a.a(this.f31425d).a() + ") [system] failed to change state to Terminated; error=" + r12 + ", " + a.b(this.f31425d));
        L26:
            a r3 = this.f31425d;
            int r4 = this.f31424c;
            monitor-enter(r3);
            a.a(r3, false);     // Catch: Throwable -> L39
            a.b(r3, r12.g());     // Catch: Throwable -> L39
            if (r12.g() == false) goto L35;
            if (r4 != 0) goto L34;
            r2 = false;
        L34:
            a.c(r3, r2);     // Catch: Throwable -> L39
            a.d(r3, false);     // Catch: Throwable -> L39
        L35:
            x r13 = x.f38692a;     // Catch: Throwable -> L39
            monitor-exit(r3);
            a.c(this.f31425d);
            return x.f38692a;
        L39:
            th = move-exception;
            throw th;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r11);
            com.obric.autogui.session.state.b r14 = this.f31423b;
            BizStatus r5 = BizStatus.TERMINATED;
            int r6 = this.f31424c;
            if (r6 != (-1)) goto L11;
            r6 = this.f31425d.b();
        L11:
            e r7 = this.f31426e;
            String r8 = null;
            if (r7 == null) goto L16;
            CharSequence r9 = r7.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOHostAppTools.INSTANCE.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));
            if (r9 == null) goto L16;
            String r10 = r9.toString();
        L17:
            EndStepParams r15 = this.f;
            Map r16 = ao.e(this.g);
            e r17 = this.f31426e;
            if (r17 == null) goto L20;
            r8 = r17.h();
        L20:
            r16.put("early_term_msg", r8);
            x r18 = x.f38692a;
            BizStatus.StatusChangedReasonStruct r19 = new BizStatus.StatusChangedReasonStruct(r6, r10, r15, r16);
            d.c.d<? super e> r20 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f31422a = 1;
            r11 = r14.a(r5, r19, r20);
            if (r11 != r0) goto L23;
            return r0;
        L16:
            r10 = null;
            goto L17
        }
    }

    /* JADX INFO: compiled from: AOSessionTerminationManager.kt */
    @d.c.b.a.f(b = "AOSessionTerminationManager.kt", c = {85}, d = "invokeSuspend", e = "com.obric.autogui.session.state.termination.AOSessionTerminationManager$userTerminate$2")
    static final class d extends l implements d.h.a.b<d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f31427a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ a f31428b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ com.obric.autogui.session.state.b f31429c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ C0859a f31430d;

        d(a r3, com.obric.autogui.session.state.b r4, C0859a r5, d.c.d<? super d> r6) {
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
            this.f31428b = r3;
            this.f31429c = r4;
            this.f31430d = r5;
            super(1, r7);
        }

        public static /* synthetic */ x lambda$Z9Npn34CVHD57mrInxI2g3SyTSI(r r0) {
            return a(r0);
        }

        public final Object a(d.c.d<? super x> r3) {
            return ((d) ZeusTransformUtils.preCheckCast(create((d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin")), d.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(d.c.d<?> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new d(this.f31428b, this.f31429c, this.f31430d, r6), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.b
        public /* synthetic */ Object invoke(d.c.d<? super x> r3) {
            return a((d.c.d) ZeusTransformUtils.preCheckCast(r3, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r12) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f31427a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r12);
        L11:
            e r13 = (e) ZeusTransformUtils.preCheckCast(r12, e.class, "com.obric.aiagent.plugin");
            if (r13.g() == true) goto L14;
            Loog.INSTANCE.e(LogUtil.INSTANCE.getCLAZZ_TAG(this.f31428b), "(ses/" + a.a(this.f31428b).a() + ") [user-termination] failed to change state to Terminated; error=" + r13 + ", " + a.b(this.f31428b));
        L14:
            IAutoActionTrackingApi r3 = (IAutoActionTrackingApi) ZeusTransformUtils.preCheckCast(AOBizTracking.INSTANCE, IAutoActionTrackingApi.class, "com.obric.aiagent.plugin");
            JSONObject r5 = new JSONObject();
            C0859a r2 = this.f31430d;
            a r4 = this.f31428b;
            r5.put("wait_step_millis", r2.a());
            r5.put("task_duration", r2.b());
            com.obric.autogui.session.c.b.a(r5, a.a(r4));
            x r6 = x.f38692a;
            IAutoActionTrackingApi.DefaultImpls.reportEvent$default(r3, "oauto_user_terminated", r5, false, false, null, 28, null);
            a r7 = this.f31428b;
            monitor-enter(r7);
            a.a(r7, false);     // Catch: Throwable -> L24
            a.b(r7, r13.g());     // Catch: Throwable -> L24
            if (r13.g() == false) goto L20;
            a.c(r7, true);     // Catch: Throwable -> L24
            a.d(r7, true);     // Catch: Throwable -> L24
        L20:
            x r14 = x.f38692a;     // Catch: Throwable -> L24
            monitor-exit(r7);
            a.c(this.f31428b);
            return x.f38692a;
        L24:
            th = move-exception;
            throw th;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r12);
            a.a(this.f31428b).a($$Lambda$a$d$Z9Npn34CVHD57mrInxI2g3SyTSI.INSTANCE);
            com.obric.autogui.agents.b.f26789a.a().b(a.a(this.f31428b));
            com.obric.autogui.session.state.b r15 = this.f31429c;
            BizStatus r8 = BizStatus.TERMINATED;
            BizStatus.StatusChangedReasonStruct r10 = new BizStatus.StatusChangedReasonStruct(2, e.f29014b.a(ZeusTransformUtils.mapRes(R.string.agent_task_early_term_user_request, WsChannelMultiProcessSharedProvider.STRING_TYPE, "agent_task_early_term_user_request")).a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOHostAppTools.INSTANCE.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).toString(), null, null, 12, null);
            d.c.d<? super e> r9 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f31427a = 1;
            r12 = r15.a(r8, r10, r9);
            if (r12 != r0) goto L11;
            return r0;
        }

        private static final x a(r r0) {
            r0.l();
            return x.f38692a;
        }
    }

    public static /* synthetic */ g lambda$hVzDqNgqOSJPcbVjZaMJ8jNZSyc(a r0) {
        return d(r0);
    }

    public a(com.obric.autogui.session.a r2) {
        d.h.b.o.e(r2, SensitiveType.SESSION);
        this.f31411a = r2;
        this.g = -1;
        this.h = d.g.a(new $$Lambda$a$hVzDqNgqOSJPcbVjZaMJ8jNZSyc(this));
        this.i = new AtomicBoolean(false);
        this.j = y.a(null, 1, null);
        this.k = new Bundle();
    }

    public static final /* synthetic */ com.obric.autogui.session.a a(a r0) {
        return r0.f31411a;
    }

    public static final /* synthetic */ void a(a r0, boolean r1) {
        r0.f31413c = r1;
    }

    public static final /* synthetic */ String b(a r0) {
        return r0.k();
    }

    public static final /* synthetic */ void b(a r0, boolean r1) {
        r0.f31414d = r1;
    }

    public static final /* synthetic */ void c(a r0) {
        r0.h();
    }

    public static final /* synthetic */ void c(a r0, boolean r1) {
        r0.f31415e = r1;
    }

    public static final /* synthetic */ void d(a r0, boolean r1) {
        r0.f = r1;
    }

    public final void a(boolean r1) {
        this.f31412b = r1;
    }

    public final boolean a() {
        return this.f31412b;
    }

    public final void a(int r1) {
        this.g = r1;
    }

    public final int b() {
        return this.g;
    }

    private final void g() {
        com.obric.autogui.session.c.a.a(this.f31411a.O(), "ses_term", "switch", 0, 4, null);
    }

    private final void h() {
        com.obric.autogui.session.c.a.b(this.f31411a.O(), "ses_term", "switch", 0, 4, null);
    }

    public final e c() {
        e r0 = j();
        if (r0.g() == true) goto L5;
        return r0;
    L5:
        C0859a r1 = i();
        com.obric.autogui.session.state.b r2 = this.f31411a.m();
        g();
        this.f31411a.m().a().launch((d.h.a.b) ZeusTransformUtils.preCheckCast(new d(this, r2, r1, null), d.h.a.b.class, "com.obric.aiagent.plugin"));
        return e.f29014b.a();
    }

    private final C0859a i() {
        long r0 = AOSystemTools.INSTANCE.bootTimeMillis();
        Object r2 = this.f31411a.F().get("KEY_PLATFORM_EXTRA_STEP_STARTED_AT");
        if (ZeusTransformUtils.instanceOf(r2, Long.class) == false) goto L5;
        Long r3 = (Long) ZeusTransformUtils.preCheckCast(r2, Long.class, "com.obric.aiagent.plugin");
    L6:
        if (r3 == null) goto L8;
        long r4 = r3.longValue();
    L9:
        long r5 = this.f31411a.l().getTriggeredBootTime();
        long r6 = 0;
        if (r4 <= 0) goto L12;
        long r7 = r0 - r4;
    L14:
        if (r5 <= 0) goto L17;
        r6 = r0 - r5;
    L17:
        return new C0859a(r7, r6);
    L12:
        r7 = 0;
        goto L14
    L8:
        r4 = -1;
        goto L9
    L5:
        r3 = null;
        goto L6
    }

    public static /* synthetic */ e a(a r1, e r2, int r3, EndStepParams r4, Map r5, int r6, Object r7) {
        Map<String, ? extends Object> r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.aiagent.plugin");
        if ((r6 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r6 & 2) == 0) goto L9;
        r3 = -1;
    L9:
        if ((r6 & 4) == 0) goto L12;
        r4 = null;
    L12:
        if ((r6 & 8) == 0) goto L15;
        r8 = ao.b();
    L15:
        return r1.a(r2, r3, r4, r8);
    }

    public final e a(e r11, int r12, EndStepParams r13, Map<String, ? extends Object> r14) {
        Map r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r14, Map.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r8, "ext");
        e r15 = j();
        if (r15.g() == true) goto L5;
        return r15;
    L5:
        com.obric.autogui.session.state.b r3 = this.f31411a.m();
        g();
        this.f31411a.m().a().launch((d.h.a.b) ZeusTransformUtils.preCheckCast(new c(r3, r12, this, r11, r13, r8, null), d.h.a.b.class, "com.obric.aiagent.plugin"));
        return e.f29014b.a();
    }

    private final e j() {
        monitor-enter(this);
    L18:
        th = move-exception;
        throw th;
    L4:
        if (this.f31413c == false) goto L9;
        Loog.INSTANCE.e(LogUtil.INSTANCE.getCLAZZ_TAG(this), "(ses/" + this.f31411a.a() + ") terminating in progress - cannot terminate again, " + k());     // Catch: Throwable -> L18
        e r0 = e.a.a(e.f29014b, ZeusTransformUtils.mapRes(R.string.agent_task_terminate_failed_terminating, WsChannelMultiProcessSharedProvider.STRING_TYPE, "agent_task_terminate_failed_terminating"), null, 2, null);     // Catch: Throwable -> L18
        monitor-exit(this);
        return r0;
    L9:
        if (this.f31414d == false) goto L14;
        Loog.INSTANCE.w(LogUtil.INSTANCE.getCLAZZ_TAG(this), "(ses/" + this.f31411a.a() + ") the session is terminated - no-need to terminate again, " + k());     // Catch: Throwable -> L18
        e r1 = e.a.a(e.f29014b, ZeusTransformUtils.mapRes(R.string.agent_task_terminate_failed_already_terminated, WsChannelMultiProcessSharedProvider.STRING_TYPE, "agent_task_terminate_failed_already_terminated"), null, 2, null);     // Catch: Throwable -> L18
        monitor-exit(this);
        return r1;
    L14:
        this.f31413c = true;     // Catch: Throwable -> L18
        x r2 = x.f38692a;     // Catch: Throwable -> L18
        monitor-exit(this);
        return e.f29014b.a();
    }

    public final synchronized boolean d() {
        monitor-enter(this);
        boolean r0 = this.f31414d;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized boolean e() {
        monitor-enter(this);
    L12:
        th = move-exception;
        throw th;
    L4:
        if (this.f31413c == true) goto L9;
        if (this.f31414d == true) goto L9;
        boolean r0 = false;
    L10:
        monitor-exit(this);
        return r0;
    L9:
        r0 = true;
        goto L10
    }

    private final String k() {
        return this.f31411a.m().d().e();
    }

    private final g l() {
        return (g) ZeusTransformUtils.preCheckCast(this.h.b(), g.class, "com.obric.aiagent.plugin");
    }

    private static final g d(a r3) {
        return new g((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r3.f31411a.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), 1.0f);
    }

    public final Object a(d.c.d<? super Bitmap> r11) {
        d.c.d r12 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r11, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r12, b.class) == false) goto L7;
        b r0 = (b) ZeusTransformUtils.preCheckCast(r12, b.class, "com.obric.aiagent.plugin");
        if ((r0.f31421d & Integer.MIN_VALUE) == 0) goto L7;
        r0.f31421d -= Integer.MIN_VALUE;
    L8:
        b r7 = r0;
        Object r13 = r7.f31419b;
        Object r1 = d.c.a.b.a();
        int r2 = r7.f31421d;
        if (r2 == 0) goto L16;
        if (r2 == 1) goto L15;
        if (r2 != 2) goto L14;
        a this = (a) ZeusTransformUtils.preCheckCast(r7.f31418a, a.class, "com.obric.aiagent.plugin");
        o.a(r13);
    L28:
        ScreenshotResult r14 = (ScreenshotResult) ZeusTransformUtils.preCheckCast(r13, ScreenshotResult.class, "com.obric.aiagent.plugin");
        if (r14.getStatus() != ScreenshotResult.Status.ContainsSecure) goto L34;
        Drawable r3 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f31411a.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getDrawable(ZeusTransformUtils.mapRes(R.drawable.vlm_pred_secure_screenshot_placeholder_img, "drawable", "vlm_pred_secure_screenshot_placeholder_img"));
        if (ZeusTransformUtils.instanceOf(r3, BitmapDrawable.class) == false) goto L34;
        Loog.INSTANCE.w(LogUtil.INSTANCE.getCLAZZ_TAG(this), " - using placeholder for secure termination scr-shot");
        Bitmap r15 = ((BitmapDrawable) ZeusTransformUtils.preCheckCast(r3, BitmapDrawable.class, "com.obric.aiagent.plugin")).getBitmap();
        this.j.a(r15);
        return r15;
    L34:
        IScreenshot r4 = r14.getPic();
        if (r14.ok() == false) goto L40;
        if (r4 == null) goto L40;
        Bitmap r16 = this.a(r4.getBitmap());
        this.j.a(r16);
        return r16;
    L40:
        Loog.INSTANCE.e(LogUtil.INSTANCE.getCLAZZ_TAG(this), " - cannot fetch termination scr-shot: " + r14.getStatus());
        this.j.a(null);
        return null;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        o.a(r13);
    L24:
        return r13;
    L16:
        o.a(r13);
        if (this.i.compareAndSet(false, true) == false) goto L19;
        Loog.INSTANCE.i(LogUtil.INSTANCE.getCLAZZ_TAG(this), " - fetching term-screenshot for session=" + this.f31411a.a());
        String r17 = com.obric.autogui.agents.vlm.models.c.a.f27282a.b(this.f31411a.a());
        com.obric.autogui.agents.vlm.models.a.a r5 = (com.obric.autogui.agents.vlm.models.a.a) ZeusTransformUtils.preCheckCast(l(), com.obric.autogui.agents.vlm.models.a.a.class, "com.obric.aiagent.plugin");
        r7.f31418a = this;
        r7.f31421d = 2;
        r13 = com.obric.autogui.agents.vlm.models.a.a.C0681a.a(r5, r17, null, false, false, r7, 14, null);
        if (r13 != r1) goto L28;
        return r1;
    L19:
        if (this.j.b() == false) goto L21;
        Loog.INSTANCE.i(LogUtil.INSTANCE.getCLAZZ_TAG(this), " - we are actually acquiring the term-screenshot... wait for a moment!");
    L21:
        w<Bitmap> r10 = this.j;
        r7.f31421d = 1;
        r13 = r10.a(r7);
        if (r13 != r1) goto L24;
        return r1;
    L7:
        r0 = new b(this, r12);
        goto L8
    }

    private final Bitmap a(Bitmap r11) {
        AOOperatingSpace r1 = OperatingSpaceManager.INSTANCE.getActiveSpace();
        if (r1 == null) goto L9;
        SpaceStatus r2 = r1.getSpaceStatus();
        if (r2 == null) goto L9;
        DisplayAccessor.Rotation r3 = r2.getRotation();
        if (r3 == null) goto L9;
    L10:
        Loog.INSTANCE.i(LogUtil.INSTANCE.getCLAZZ_TAG(this), " - term-screenshot rotation=" + r3);
        if (r3 != DisplayAccessor.Rotation.Rotation0) goto L13;
    L25:
        return r11;
    L13:
        if (r11.isRecycled() == true) goto L25;
        n.a r4 = n.f38560a;     // Catch: Throwable -> L17
        a r5 = (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L17
        Matrix r8 = new Matrix();     // Catch: Throwable -> L17
        r8.postRotate(r3.getDegree());     // Catch: Throwable -> L17
        Object r6 = n.f(Bitmap.createBitmap(r11, 0, 0, r11.getWidth(), r11.getHeight(), r8, true));     // Catch: Throwable -> L17
    L19:
        Throwable r7 = n.c(r6);
        if (r7 != null) goto L22;
        Object r12 = r6;
    L24:
        return (Bitmap) ZeusTransformUtils.preCheckCast(r12, Bitmap.class, "com.obric.aiagent.plugin");
    L22:
        Loog.INSTANCE.e(LogUtil.INSTANCE.getCLAZZ_TAG(this), " - rotate term-screenshot failed", r7);
        r12 = r11;
    L17:
        th = move-exception;
        n.a r9 = n.f38560a;
        r6 = n.f(o.a(th));
    L9:
        r3 = DisplayAccessor.Rotation.Rotation0;
        goto L10
    }

    public final Bundle f() {
        return this.k;
    }

    public final void a(d.h.a.b<? super Bundle, x> r3) {
        d.h.a.b r4 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.b.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "adder");
        r4.invoke(this.k);
    }
}
