package com.obric.autogui.session.state.a;

import android.content.Context;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.bytedance.security.zenmobile.io.SensitiveType;
import com.obric.aiagent.plugin.R;
import com.obric.autogui.common.api.agent.BizStatus;
import com.obric.autogui.common.api.app.foundation.AutoActionFoundation;
import com.obric.autogui.common.api.app.foundation.FoundationStatus;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.platform.AOPlatformTools;
import com.obric.autogui.common.api.platform.account.IAutoActionAccountApi;
import com.obric.autogui.common.api.platform.security.IAutoActionSecurityApi;
import com.obric.eventkit.eventstaskmanager.ITaskManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.x;

/* JADX INFO: compiled from: StateQueueing.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class k extends com.obric.autogui.session.state.a {
    private static final String TAG = "S-Queueing";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f31310b = null;

    /* JADX INFO: compiled from: StateQueueing.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: StateQueueing.kt */
    @d.c.b.a.f(b = "StateQueueing.kt", c = {60, ITaskManager.Stub.TRANSACTION_removeEventTaskExecutionDetailRecordsBySessionId, 83}, d = "changeTo", e = "com.obric.autogui.session.state.impl.StateQueueing")
    static final class b extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f31311a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f31312b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ k f31313c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f31314d;

        b(k r3, d.c.d<? super b> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f31313c = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f31312b = r3;
            this.f31314d |= Integer.MIN_VALUE;
            return this.f31313c.a(null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: StateQueueing.kt */
    @d.c.b.a.f(b = "StateQueueing.kt", c = {63}, d = "invokeSuspend", e = "com.obric.autogui.session.state.impl.StateQueueing$changeTo$2$1")
    static final class c extends d.c.b.a.l implements d.h.a.b<d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f31315a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ k f31316b;

        c(k r3, d.c.d<? super c> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f31316b = r3;
            super(1, r5);
        }

        public final Object a(d.c.d<? super x> r3) {
            return ((c) ZeusTransformUtils.preCheckCast(create((d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin")), c.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new c(this.f31316b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.b
        public /* synthetic */ Object invoke(d.c.d<? super x> r3) {
            return a((d.c.d) ZeusTransformUtils.preCheckCast(r3, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r12) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f31315a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r12);
        L12:
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r12);
            com.obric.autogui.session.state.b r13 = this.f31316b.e();
            BizStatus r2 = BizStatus.IDLE;
            BizStatus.StatusChangedReasonStruct r10 = new BizStatus.StatusChangedReasonStruct(com.obric.autogui.session.state.a.e.f31232c.a(), null, null, null, 14, null);
            d.c.d<? super com.obric.autogui.common.e> r3 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f31315a = 1;
            if (r13.a(r2, r10, r3) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: compiled from: StateQueueing.kt */
    @d.c.b.a.f(b = "StateQueueing.kt", c = {75}, d = "invokeSuspend", e = "com.obric.autogui.session.state.impl.StateQueueing$changeTo$3$1")
    static final class d extends d.c.b.a.l implements d.h.a.b<d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f31317a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ k f31318b;

        d(k r3, d.c.d<? super d> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f31318b = r3;
            super(1, r5);
        }

        public final Object a(d.c.d<? super x> r3) {
            return ((d) ZeusTransformUtils.preCheckCast(create((d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin")), d.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new d(this.f31318b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.b
        public /* synthetic */ Object invoke(d.c.d<? super x> r3) {
            return a((d.c.d) ZeusTransformUtils.preCheckCast(r3, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r12) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f31317a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r12);
        L12:
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r12);
            com.obric.autogui.session.state.b r13 = this.f31318b.e();
            BizStatus r2 = BizStatus.IDLE;
            BizStatus.StatusChangedReasonStruct r10 = new BizStatus.StatusChangedReasonStruct(com.obric.autogui.session.state.a.e.f31231b.a(), null, null, null, 14, null);
            d.c.d<? super com.obric.autogui.common.e> r3 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f31317a = 1;
            if (r13.a(r2, r10, r3) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: compiled from: StateQueueing.kt */
    @d.c.b.a.f(b = "StateQueueing.kt", c = {116}, d = "checkNetwork", e = "com.obric.autogui.session.state.impl.StateQueueing")
    static final class e extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        /* synthetic */ Object f31319a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ k f31320b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f31321c;

        e(k r3, d.c.d<? super e> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f31320b = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f31319a = r3;
            this.f31321c |= Integer.MIN_VALUE;
            return k.a(this.f31320b, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    static {
        f31310b = new a(null);
    }

    public static final /* synthetic */ Object a(k r2, d.c.d r3) {
        return r2.b((d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public k(com.obric.autogui.session.state.b r9, com.obric.autogui.session.a r10) {
        d.h.b.o.e(r9, "machine");
        d.h.b.o.e(r10, SensitiveType.SESSION);
        super(BizStatus.QUEUEING, r10, r9, false, 8, null);
    }

    @Override // com.obric.autogui.session.state.a
    public Object b(com.obric.autogui.session.state.a r4, d.c.d<? super com.obric.autogui.common.e> r5) {
        d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
        String r7 = d().l().getUserTask();
        if (r7 == null) goto L18;
        if (d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.aiagent.plugin")) == false) goto L8;
        Loog.INSTANCE.e(TAG, " - [QueueCheck] User-Task query is empty. TaskInfo=" + d().l() + '/' + d().l().doubaoMessageId());
        com.obric.autogui.common.e.a r8 = com.obric.autogui.common.e.f29014b;
        String r3 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(d().getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.agent_error_empty_query, WsChannelMultiProcessSharedProvider.STRING_TYPE, "agent_error_empty_query"));
        d.h.b.o.c(r3, "getString(...)");
        return r8.c(r3);
    L8:
        IAutoActionSecurityApi r9 = AOPlatformTools.INSTANCE.security();
        if (r9 == null) goto L11;
        com.obric.autogui.common.e r10 = r9.checkPrompt(r7);
    L12:
        if (r10 == null) goto L18;
        if (r10.g() == true) goto L16;
        Loog.INSTANCE.e(TAG, " - query includes sensitive content.");
    L16:
        return r10;
    L11:
        r10 = null;
    L18:
        return com.obric.autogui.common.e.f29014b.a();
    }

    @Override // com.obric.autogui.session.state.a
    public Object a(com.obric.autogui.session.state.a r10, d.c.d<? super com.obric.autogui.common.e> r11) {
        d.c.d r12 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r11, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r12, b.class) == false) goto L7;
        b r1 = (b) ZeusTransformUtils.preCheckCast(r12, b.class, "com.obric.aiagent.plugin");
        if ((r1.f31314d & Integer.MIN_VALUE) == 0) goto L7;
        r1.f31314d -= Integer.MIN_VALUE;
    L8:
        Object r13 = r1.f31312b;
        Object r3 = d.c.a.b.a();
        int r4 = r1.f31314d;
        if (r4 == 0) goto L18;
        if (r4 == 1) goto L17;
        if (r4 == 2) goto L16;
        if (r4 != 3) goto L15;
        d.o.a(r13);
    L38:
        return com.obric.autogui.common.e.f29014b.a();
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        k this = (k) ZeusTransformUtils.preCheckCast(r1.f31311a, k.class, "com.obric.aiagent.plugin");
        d.o.a(r13);
    L30:
        com.obric.autogui.common.e r14 = (com.obric.autogui.common.e) ZeusTransformUtils.preCheckCast(r13, com.obric.autogui.common.e.class, "com.obric.aiagent.plugin");
        if (r14.g() == true) goto L34;
        this.e().a().launch((d.h.a.b) ZeusTransformUtils.preCheckCast(new d(this, null), d.h.a.b.class, "com.obric.aiagent.plugin"));
        return r14;
    L34:
        r1.f31311a = null;
        r1.f31314d = 3;
        if (this.c(r1) != r3) goto L38;
        return r3;
    L17:
        this = (k) ZeusTransformUtils.preCheckCast(r1.f31311a, k.class, "com.obric.aiagent.plugin");
        d.o.a(r13);
    L23:
        com.obric.autogui.common.e r15 = (com.obric.autogui.common.e) ZeusTransformUtils.preCheckCast(r13, com.obric.autogui.common.e.class, "com.obric.aiagent.plugin");
        if (r15.g() == true) goto L27;
        this.e().a().launch((d.h.a.b) ZeusTransformUtils.preCheckCast(new c(this, null), d.h.a.b.class, "com.obric.aiagent.plugin"));
        return r15;
    L27:
        r1.f31311a = this;
        r1.f31314d = 2;
        r13 = this.b(r1);
        if (r13 != r3) goto L30;
        return r3;
    L18:
        d.o.a(r13);
        if (ZeusTransformUtils.instanceOf(r10, j.class) == false) goto L40;
        r1.f31311a = this;
        r1.f31314d = 1;
        r13 = a(r1);
        if (r13 != r3) goto L23;
        return r3;
    L40:
        return com.obric.autogui.common.e.f29014b.a();
    L7:
        r1 = new b(this, r12);
        goto L8
    }

    private final Object a(d.c.d<? super com.obric.autogui.common.e> r6) {
        d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
        if (AutoActionFoundation.INSTANCE.getStatus() != FoundationStatus.NotInitialised) goto L6;
        Loog.INSTANCE.e(TAG, " - [StateQueue] FoundationStatus is NotInitialised.");
        return com.obric.autogui.common.e.a.a(com.obric.autogui.common.e.f29014b, ZeusTransformUtils.mapRes(R.string.agent_internal_error, WsChannelMultiProcessSharedProvider.STRING_TYPE, "agent_internal_error"), null, 2, null);
    L6:
        IAutoActionAccountApi.UserInfoAcquiringResult r7 = AOPlatformTools.INSTANCE.account().acquireUserInfo();
        int r8 = r7.getType();
        if (r8 == 1) goto L19;
        if (r8 == 2) goto L17;
        if (r7.getUserInfo() != null) goto L15;
        Loog.INSTANCE.e(TAG, " - [StateQueue] fetched NULL log-in info.");
        return com.obric.autogui.common.e.a.a(com.obric.autogui.common.e.f29014b, ZeusTransformUtils.mapRes(R.string.agent_cannot_start_system_login_status_cannot_fetch, WsChannelMultiProcessSharedProvider.STRING_TYPE, "agent_cannot_start_system_login_status_cannot_fetch"), null, 2, null);
    L15:
        return com.obric.autogui.common.e.f29014b.a();
    L17:
        return com.obric.autogui.common.e.a.a(com.obric.autogui.common.e.f29014b, ZeusTransformUtils.mapRes(R.string.agent_cannot_start_system_login_status_cannot_fetch, WsChannelMultiProcessSharedProvider.STRING_TYPE, "agent_cannot_start_system_login_status_cannot_fetch"), null, 2, null);
    L19:
        return com.obric.autogui.common.e.a.a(com.obric.autogui.common.e.f29014b, ZeusTransformUtils.mapRes(R.string.agent_cannot_start_system_login_not_logged_in, WsChannelMultiProcessSharedProvider.STRING_TYPE, "agent_cannot_start_system_login_not_logged_in"), null, 2, null);
    }

    private final Object b(d.c.d<? super com.obric.autogui.common.e> r5) {
        d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r6, e.class) == false) goto L7;
        e r0 = (e) ZeusTransformUtils.preCheckCast(r6, e.class, "com.obric.aiagent.plugin");
        if ((r0.f31321c & Integer.MIN_VALUE) == 0) goto L7;
        r0.f31321c -= Integer.MIN_VALUE;
    L8:
        Object r4 = r0.f31319a;
        Object r7 = d.c.a.b.a();
        int r2 = r0.f31321c;
        if (r2 == 0) goto L14;
        if (r2 != 1) goto L13;
        d.o.a(r4);
    L17:
        com.obric.autogui.common.e r8 = (com.obric.autogui.common.e) ZeusTransformUtils.preCheckCast(r4, com.obric.autogui.common.e.class, "com.obric.aiagent.plugin");
        if (r8.g() == true) goto L21;
        return r8;
    L21:
        return com.obric.autogui.common.e.f29014b.a();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        d.o.a(r4);
        com.obric.autogui.session.state.c r9 = com.obric.autogui.session.state.c.f31395a;
        r0.f31321c = 1;
        r4 = r9.a(r0);
        if (r4 != r7) goto L17;
        return r7;
    L7:
        r0 = new e(this, r6);
        goto L8
    }

    @Override // com.obric.autogui.session.state.a, com.obric.autogui.util.c.a, com.obric.autogui.util.c.b
    public void b(com.obric.autogui.util.c.b r3) {
        com.obric.autogui.util.c.b r4 = (com.obric.autogui.util.c.b) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.autogui.util.c.b.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "fromState");
        super.b(r4);
        com.obric.autogui.session.c.f30777a.d();
    }

    private final Object c(d.c.d<? super x> r3) {
        d.c.d<? super x> r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
        Object r2 = com.obric.autogui.agents.b.f26789a.a(d(), r4);
        if (r2 != d.c.a.b.a()) goto L6;
        return r2;
    L6:
        return x.f38692a;
    }
}
