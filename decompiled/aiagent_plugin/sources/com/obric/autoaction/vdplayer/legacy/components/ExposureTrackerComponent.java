package com.obric.autoaction.vdplayer.legacy.components;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import androidx.lifecycle.p;
import com.obric.autoaction.a.e;
import com.obric.autoaction.a.f;
import com.obric.autoaction.vdplayer.legacy.d.q;
import com.obric.autoaction.vdplayer.legacy.d.u;
import com.obric.autogui.common.api.agent.AutoActionAgent;
import com.obric.autogui.common.api.agent.IAutoActionAgentEventListener;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.presentation.AutoActionUIContext;
import com.obric.autogui.common.api.presentation.GlobalUIContext;
import com.obric.autogui.common.api.presentation.IAutoActionPresentationApi;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.b.a.l;
import d.c.d;
import d.h.a.m;
import d.h.b.h;
import d.o;
import d.x;
import kotlinx.coroutines.am;
import kotlinx.coroutines.b.ab;
import kotlinx.coroutines.b.i;

/* JADX INFO: compiled from: ExposureTrackerComponent.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class ExposureTrackerComponent implements e, f {
    private static final String TAG = "ExposureTrackerComp";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f25743a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private com.obric.autoaction.a.c f25744b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Long f25745c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f25746d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f25747e;

    /* JADX INFO: compiled from: ExposureTrackerComponent.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: ExposureTrackerComponent.kt */
    @d.c.b.a.f(b = "ExposureTrackerComponent.kt", c = {39}, d = "invokeSuspend", e = "com.obric.autoaction.vdplayer.legacy.components.ExposureTrackerComponent$onAttach$1")
    static final class b extends l implements m<am, d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f25748a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ u f25749b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ ExposureTrackerComponent f25750c;

        b(u r3, ExposureTrackerComponent r4, d<? super b> r5) {
            d r6 = (d) ZeusTransformUtils.wrapperContextForParams(r5, d.class, "com.obric.aiagent.plugin");
            this.f25749b = r3;
            this.f25750c = r4;
            super(2, r6);
        }

        public final Object a(am r3, d<? super x> r4) {
            return ((b) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin")), b.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d<x> create(Object r3, d<?> r4) {
            d r5 = (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin");
            return (d) ZeusTransformUtils.preCheckCast(new b(this.f25749b, this.f25750c, r5), d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.preCheckCast(r4, d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r6) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f25748a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L6;
            o.a(r6);
        L12:
            throw new d.d();
        L6:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r6);
            ab<q> r7 = this.f25749b.c();
            final ExposureTrackerComponent r3 = this.f25750c;
            i<? super q> r2 = (i) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r3), i.class, "com.obric.aiagent.plugin");
            d<?> r4 = (d) ZeusTransformUtils.preCheckCast(this, d.class, "com.obric.aiagent.plugin");
            this.f25748a = 1;
            if (r7.collect(r2, r4) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: compiled from: ExposureTrackerComponent.kt */
    @d.c.b.a.f(b = "ExposureTrackerComponent.kt", c = {}, d = "invokeSuspend", e = "com.obric.autoaction.vdplayer.legacy.components.ExposureTrackerComponent$onAttach$2")
    static final class c extends l implements m<am, d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f25752a;

        c(d<? super c> r3) {
            super(2, (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.aiagent.plugin"));
        }

        public final Object a(am r3, d<? super x> r4) {
            return ((c) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin")), c.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d<x> create(Object r1, d<?> r2) {
            return (d) ZeusTransformUtils.preCheckCast(new c((d) ZeusTransformUtils.wrapperContextForParams(r2, d.class, "com.obric.aiagent.plugin")), d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.preCheckCast(r4, d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r1) {
            d.c.a.b.a();
            if (this.f25752a != 0) goto L7;
            o.a(r1);
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    static {
        f25743a = new a(null);
    }

    public ExposureTrackerComponent() {
    }

    public static final /* synthetic */ com.obric.autoaction.a.c a(ExposureTrackerComponent r0) {
        return r0.f25744b;
    }

    public static final /* synthetic */ void a(ExposureTrackerComponent r0, Intent r1) {
        r0.b(r1);
    }

    public static final /* synthetic */ void a(ExposureTrackerComponent r0, boolean r1) {
        r0.a(r1);
    }

    public static final /* synthetic */ void b(ExposureTrackerComponent r0) {
        r0.a();
    }

    @Override // com.obric.autoaction.a.f
    public void a(com.obric.autoaction.a.c r19) {
        d.h.b.o.e(r19, "componentHost");
        f.a.a(this, r19);
        this.f25744b = r19;
        u r2 = (u) ZeusTransformUtils.preCheckCast(r19.c().a(u.class), u.class, "com.obric.aiagent.plugin");
        kotlinx.coroutines.i.a(r19.a(), null, null, (m) ZeusTransformUtils.preCheckCast(new b(r2, this, null), m.class, "com.obric.aiagent.plugin"), 3, null);
        kotlinx.coroutines.i.a(r19.a(), null, null, (m) ZeusTransformUtils.preCheckCast(new c(null), m.class, "com.obric.aiagent.plugin"), 3, null);
    }

    private final void a() {
        if (((GlobalUIContext) ZeusTransformUtils.preCheckCast(AutoActionUIContext.INSTANCE.getState().c(), GlobalUIContext.class, "com.obric.aiagent.plugin")).getPlayer().getVisible() != IAutoActionPresentationApi.PlayerVisibility.Invisible) goto L5;
        return;
    L5:
        b();
    }

    private final void b() {
        if (this.f25746d >= 0) goto L5;
        return;
    L5:
        this.f25747e = System.currentTimeMillis();
        Long r0 = this.f25745c;
        if (r0 == null) goto L9;
        com.obric.autoaction.vdplayer.legacy.c.b.f25682a.a(String.valueOf(((Number) ZeusTransformUtils.preCheckCast(r0, Number.class, "com.obric.aiagent.plugin")).longValue()), this.f25747e - this.f25746d);
        this.f25746d = -1;
        Loog.INSTANCE.i(TAG, "end record player show, refMsgId: " + this.f25745c + ", showEndTime: " + this.f25747e + ", duration: " + (this.f25747e - this.f25746d));
        return;
    }

    @Override // androidx.lifecycle.d
    public void a(p r4) {
        p r5 = (p) ZeusTransformUtils.wrapperContextForParams(r4, p.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r5, "owner");
        super.a(r5);
        com.obric.autoaction.a.c r6 = this.f25744b;
        Intent r0 = null;
        if (r6 == null) goto L5;
        Context r7 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r6.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
    L7:
        if (ZeusTransformUtils.instanceOf(r7, Activity.class) == false) goto L9;
        Activity r8 = (Activity) ZeusTransformUtils.preCheckCast(r7, Activity.class, "com.obric.aiagent.plugin");
    L10:
        if (r8 == null) goto L12;
        r0 = r8.getIntent();
    L12:
        b(r0);
        a(true);
        return;
    L9:
        r8 = null;
        goto L10
    L5:
        r7 = null;
        goto L7
    }

    @Override // androidx.lifecycle.d
    public void e(p r3) {
        p r4 = (p) ZeusTransformUtils.wrapperContextForParams(r3, p.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "owner");
        super.e(r4);
        a(false);
    }

    @Override // androidx.lifecycle.d
    public void b(p r4) {
        p r5 = (p) ZeusTransformUtils.wrapperContextForParams(r4, p.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r5, "owner");
        super.b(r5);
        a(true);
        IAutoActionAgentEventListener.SessionInfo r6 = (IAutoActionAgentEventListener.SessionInfo) ZeusTransformUtils.preCheckCast(AutoActionAgent.INSTANCE.getOngoingSessionInfo().a(), IAutoActionAgentEventListener.SessionInfo.class, "com.obric.aiagent.plugin");
        if (r6 == null) goto L5;
        Long r7 = r6.getRefMsgId();
    L6:
        this.f25745c = r7;
        this.f25746d = System.currentTimeMillis();
        Loog.INSTANCE.i(TAG, "start record player show, refMsgId: " + this.f25745c + ", showStartTime: " + this.f25746d);
        return;
    L5:
        r7 = null;
        goto L6
    }

    @Override // androidx.lifecycle.d
    public void d(p r3) {
        p r4 = (p) ZeusTransformUtils.wrapperContextForParams(r3, p.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "owner");
        super.d(r4);
        a(false);
        b();
        this.f25745c = null;
    }

    @Override // com.obric.autoaction.a.e
    public void a(Intent r4) {
        Loog.INSTANCE.d(TAG, "onNewIntent");
        if (r4 == null) goto L6;
        b(r4);
        return;
    }

    private final void b(Intent r7) {
        if (r7 != null) goto L4;
        return;
    L4:
        ComponentName r6 = r7.getComponent();
        String r8 = r7.getStringExtra("source_from");
        if (r8 != null) goto L16;
        boolean r0 = true;
        if (r6 == null) goto L13;
        String r2 = r6.getClassName();
        if (r2 == null) goto L13;
        if (d.o.o.c(r2, "SurfaceCardStarterActivity", false, 2, null) != true) goto L13;
    L14:
        if (r0 == false) goto L16;
        r8 = "virtual_screen";
    L13:
        r0 = false;
    L16:
        com.obric.autoaction.vdplayer.legacy.c.b.f25682a.a(r8);
        com.obric.autoaction.vdplayer.legacy.c.a.f25675a.a(r8, r6);
    }

    private final void a(boolean r4) {
        if (r4 == false) goto L9;
        IAutoActionAgentEventListener.SessionInfo r3 = (IAutoActionAgentEventListener.SessionInfo) ZeusTransformUtils.preCheckCast(AutoActionAgent.INSTANCE.getOngoingSessionInfo().a(), IAutoActionAgentEventListener.SessionInfo.class, "com.obric.aiagent.plugin");
        if (r3 != null) goto L8;
        Loog.INSTANCE.e(TAG, "reportActivityShowing() failed -- no session info.");
        return;
    L8:
        com.obric.autoaction.vdplayer.legacy.c.a.f25675a.a(r3);
        return;
    L9:
        com.obric.autoaction.a.c r5 = this.f25744b;
        Intent r1 = null;
        if (r5 == null) goto L12;
        Context r6 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r5.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
    L14:
        if (ZeusTransformUtils.instanceOf(r6, Activity.class) == false) goto L16;
        Activity r7 = (Activity) ZeusTransformUtils.preCheckCast(r6, Activity.class, "com.obric.aiagent.plugin");
    L17:
        if (r7 == null) goto L19;
        r1 = r7.getIntent();
    L19:
        b(r1);
        com.obric.autoaction.vdplayer.legacy.c.a.f25675a.a();
        return;
    L16:
        r7 = null;
        goto L17
    L12:
        r6 = null;
        goto L14
    }
}
