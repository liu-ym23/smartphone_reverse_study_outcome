package com.obric.autogui.session.state;

import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.obric.aiagent.plugin.R;
import com.obric.autogui.common.api.agent.BizStatus;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.threading.AOThreadingTools;
import com.obric.autogui.session.state.a.g;
import com.obric.autogui.session.state.a.h;
import com.obric.autogui.session.state.a.i;
import com.obric.autogui.session.state.a.j;
import com.obric.autogui.session.state.a.k;
import com.obric.autogui.session.state.a.l;
import com.obric.autogui.session.state.a.m;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ao;
import d.a.p;
import d.h.b.o;
import d.h.b.z;
import d.s;
import d.x;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import kotlinx.coroutines.am;
import kotlinx.coroutines.w;
import kotlinx.coroutines.y;

/* JADX INFO: compiled from: AOSessionStateMachine.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b {
    private static final String TAG = "AO-Ses-SM";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f31372a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.obric.autogui.session.a f31373b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final AOThreadingTools.SingleThreadCoroutineScopeWrapper f31374c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final AOThreadingTools.SingleThreadCoroutineScopeWrapper f31375d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final g f31376e;
    private final k f;
    private final j g;
    private final h h;
    private final i i;
    private final m j;
    private final l k;
    private final Map<BizStatus, com.obric.autogui.session.state.a> l;
    private final com.obric.autogui.session.state.holderfile.a m;
    private final com.obric.autogui.util.c.c n;
    private final AtomicBoolean o;
    private final Object p;
    private final AtomicReference<C0857b> q;
    private final AtomicReference<BizStatus> r;

    /* JADX INFO: compiled from: AOSessionStateMachine.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: renamed from: com.obric.autogui.session.state.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AOSessionStateMachine.kt */
    private static final class C0857b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final com.obric.autogui.session.state.a f31377a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final w<com.obric.autogui.common.e> f31378b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final BizStatus.StatusChangedReasonStruct f31379c;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, C0857b.class) == true) goto L8;
            return false;
        L8:
            C0857b r6 = (C0857b) ZeusTransformUtils.preCheckCast(r5, C0857b.class, "com.obric.aiagent.plugin");
            if (o.a(this.f31377a, r6.f31377a) == true) goto L12;
            return false;
        L12:
            if (o.a(this.f31378b, r6.f31378b) == true) goto L15;
            return false;
        L15:
            if (o.a(this.f31379c, r6.f31379c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            return (((this.f31377a.hashCode() * 31) + this.f31378b.hashCode()) * 31) + this.f31379c.hashCode();
        }

        public String toString() {
            return "PendingRequest(targetState=" + this.f31377a + ", deferredResult=" + this.f31378b + ", reason=" + this.f31379c + ')';
        }

        public C0857b(com.obric.autogui.session.state.a r3, w<com.obric.autogui.common.e> r4, BizStatus.StatusChangedReasonStruct r5) {
            w<com.obric.autogui.common.e> r6 = (w) ZeusTransformUtils.wrapperContextForParams(r4, w.class, "com.obric.aiagent.plugin");
            o.e(r3, "targetState");
            o.e(r6, "deferredResult");
            o.e(r5, "reason");
            this.f31377a = r3;
            this.f31378b = r6;
            this.f31379c = r5;
        }

        public final com.obric.autogui.session.state.a a() {
            return this.f31377a;
        }

        public final w<com.obric.autogui.common.e> b() {
            return this.f31378b;
        }

        public final BizStatus.StatusChangedReasonStruct c() {
            return this.f31379c;
        }
    }

    /* JADX INFO: compiled from: AOSessionStateMachine.kt */
    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final BizStatus f31380a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final BizStatus f31381b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final BizStatus f31382c;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, c.class) == true) goto L8;
            return false;
        L8:
            c r6 = (c) ZeusTransformUtils.preCheckCast(r5, c.class, "com.obric.aiagent.plugin");
            if (this.f31380a == r6.f31380a) goto L12;
            return false;
        L12:
            if (this.f31381b == r6.f31381b) goto L15;
            return false;
        L15:
            if (this.f31382c == r6.f31382c) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            int r0 = this.f31380a.hashCode() * 31;
            BizStatus r1 = this.f31381b;
            int r2 = 0;
            if (r1 != null) goto L5;
            int r3 = 0;
        L6:
            int r4 = (r0 + r3) * 31;
            BizStatus r5 = this.f31382c;
            if (r5 == null) goto L11;
            r2 = r5.hashCode();
        L11:
            return r4 + r2;
        L5:
            r3 = r1.hashCode();
            goto L6
        }

        public String toString() {
            return "StateRequestSnapshot(current=" + this.f31380a + ", pending=" + this.f31381b + ", processing=" + this.f31382c + ')';
        }

        public c(BizStatus r2, BizStatus r3, BizStatus r4) {
            o.e(r2, "current");
            this.f31380a = r2;
            this.f31381b = r3;
            this.f31382c = r4;
        }

        public final BizStatus a() {
            return this.f31380a;
        }

        public final BizStatus b() {
            return this.f31381b;
        }

        public final BizStatus c() {
            return this.f31382c;
        }

        public final boolean d() {
            if (this.f31380a != BizStatus.TERMINATED) goto L5;
        L10:
            return true;
        L5:
            if (this.f31381b == BizStatus.TERMINATED) goto L10;
            if (this.f31382c == BizStatus.TERMINATED) goto L10;
            return false;
        }

        public final boolean a(BizStatus r2) {
            o.e(r2, "bizStatus");
            if (this.f31380a != r2) goto L5;
        L8:
            return true;
        L5:
            if (this.f31381b == r2) goto L8;
            return false;
        }

        public final String e() {
            return "current=" + this.f31380a + ", pending=" + this.f31381b + ", processing=" + this.f31382c;
        }
    }

    /* JADX INFO: compiled from: AOSessionStateMachine.kt */
    @d.c.b.a.f(b = "AOSessionStateMachine.kt", c = {197, 202}, d = "changeStateTo", e = "com.obric.autogui.session.state.AOSessionStateMachine")
    static final class d extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f31383a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f31384b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f31385c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f31386d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        /* synthetic */ Object f31387e;
        final /* synthetic */ b f;
        int g;

        d(b r3, d.c.d<? super d> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f31387e = r3;
            this.g |= Integer.MIN_VALUE;
            return this.f.a(null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: AOSessionStateMachine.kt */
    @d.c.b.a.f(b = "AOSessionStateMachine.kt", c = {198}, d = "invokeSuspend", e = "com.obric.autogui.session.state.AOSessionStateMachine$changeStateTo$5")
    static final class e extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f31388a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ b f31389b;

        e(b r3, d.c.d<? super e> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f31389b = r3;
            super(2, r5);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((e) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), e.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new e(this.f31389b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r5) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f31388a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r5);
        L12:
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r5);
            b r6 = this.f31389b;
            d.c.d r2 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f31388a = 1;
            if (b.a(r6, r2) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: compiled from: AOSessionStateMachine.kt */
    @d.c.b.a.f(b = "AOSessionStateMachine.kt", c = {242}, d = "triggerProcessStateQueue", e = "com.obric.autogui.session.state.AOSessionStateMachine")
    static final class f extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f31390a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f31391b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        /* synthetic */ Object f31392c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ b f31393d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f31394e;

        f(b r3, d.c.d<? super f> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f31393d = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f31392c = r3;
            this.f31394e |= Integer.MIN_VALUE;
            return b.a(this.f31393d, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    static {
        f31372a = new a(null);
    }

    public b(com.obric.autogui.session.a r11) {
        o.e(r11, "boundSession");
        this.f31373b = r11;
        AOThreadingTools.SingleThreadCoroutineScopeWrapper r0 = AOThreadingTools.INSTANCE.createSingleThreadCoroutineScope("ao-ses-th-state/" + r11.a(), true);
        this.f31374c = r0;
        this.f31375d = r0;
        g r1 = new g(this, r11);
        this.f31376e = r1;
        k r2 = new k(this, r11);
        this.f = r2;
        j r3 = new j(this, r11);
        this.g = r3;
        h r4 = new h(this, r11);
        this.h = r4;
        i r5 = new i(this, r11);
        this.i = r5;
        m r6 = new m(this, r11);
        this.j = r6;
        l r7 = new l(this, r11);
        this.k = r7;
        this.l = ao.a(new d.m[]{s.a(BizStatus.IDLE, r1), s.a(BizStatus.QUEUEING, r2), s.a(BizStatus.PREPARING, r3), s.a(BizStatus.OPERATING, r4), s.a(BizStatus.PAUSED, r5), s.a(BizStatus.USER_INTERRUPTED, r6), s.a(BizStatus.TERMINATED, r7)});
        this.m = new com.obric.autogui.session.state.holderfile.a();
        this.n = new com.obric.autogui.util.c.c((com.obric.autogui.util.c.b) ZeusTransformUtils.preCheckCast(r1, com.obric.autogui.util.c.b.class, "com.obric.aiagent.plugin"));
        this.o = new AtomicBoolean(false);
        this.p = new Object();
        this.q = new AtomicReference(null);
        this.r = new AtomicReference(null);
    }

    public static final /* synthetic */ Object a(b r2, d.c.d r3) {
        return r2.a((d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public final AOThreadingTools.SingleThreadCoroutineScopeWrapper a() {
        return this.f31375d;
    }

    public final com.obric.autogui.session.state.holderfile.a b() {
        return this.m;
    }

    private final com.obric.autogui.session.state.a b(BizStatus r2) {
        return (com.obric.autogui.session.state.a) ZeusTransformUtils.preCheckCast(this.l.get(r2), com.obric.autogui.session.state.a.class, "com.obric.aiagent.plugin");
    }

    public final BizStatus c() {
        return d().b();
    }

    public final c d() {
        Object r0 = this.p;
        monitor-enter(r0);
        c r1 = f();     // Catch: Throwable -> L7
        monitor-exit(r0);
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public final <T extends com.obric.autogui.session.state.a> T a(BizStatus r2) {
        o.e(r2, "type");
        T r1 = (T) b(r2);
        if (r1 != null) goto L6;
        return null;
    L6:
        return r1;
    }

    public final Object a(BizStatus.StatusChangedReasonStruct r4, d.c.d<? super com.obric.autogui.common.e> r5) {
        d.c.d<? super com.obric.autogui.common.e> r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
        if (this.f31373b.J().d() == false) goto L5;
        Loog.INSTANCE.w(TAG, "[ResumeFromPause] try to resume from paused when it's terminated.");
        return com.obric.autogui.common.e.f29014b.a();
    L5:
        if (ZeusTransformUtils.instanceOf(e(), com.obric.autogui.session.state.a.d.class) == true) goto L9;
        Loog.INSTANCE.w(TAG, "[ResumeFromPause] not in paused state (state=" + e().b() + ").");
        return com.obric.autogui.common.e.f29014b.a();
    L9:
        return a(BizStatus.OPERATING, r4, r6);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v1, types: [T, com.obric.autogui.common.e] */
    public final Object a(BizStatus r19, BizStatus.StatusChangedReasonStruct r20, d.c.d<? super com.obric.autogui.common.e> r21) {
        b r0 = this;
        BizStatus.StatusChangedReasonStruct r1 = r20;
        d.c.d r3 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r21, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r3, d.class) == false) goto L7;
        d r4 = (d) ZeusTransformUtils.preCheckCast(r3, d.class, "com.obric.aiagent.plugin");
        if ((r4.g & Integer.MIN_VALUE) == 0) goto L7;
        r4.g -= Integer.MIN_VALUE;
    L8:
        Object r5 = r4.f31387e;
        Object r6 = d.c.a.b.a();
        int r7 = r4.g;
        if (r7 == 0) goto L16;
        if (r7 == 1) goto L15;
        if (r7 != 2) goto L14;
        com.obric.autogui.session.state.a r2 = (com.obric.autogui.session.state.a) ZeusTransformUtils.preCheckCast(r4.f31385c, com.obric.autogui.session.state.a.class, "com.obric.aiagent.plugin");
        r1 = (BizStatus.StatusChangedReasonStruct) ZeusTransformUtils.preCheckCast(r4.f31384b, BizStatus.StatusChangedReasonStruct.class, "com.obric.aiagent.plugin");
        b r8 = (b) ZeusTransformUtils.preCheckCast(r4.f31383a, b.class, "com.obric.aiagent.plugin");
        d.o.a(r5);
    L52:
        com.obric.autogui.common.e r9 = (com.obric.autogui.common.e) ZeusTransformUtils.preCheckCast(r5, com.obric.autogui.common.e.class, "com.obric.aiagent.plugin");
        Loog.INSTANCE.i(TAG, "State change request completed, target=" + r2.b() + ", result=" + r9 + ", " + r8.a(r1) + ", " + r8.d().e() + ", session=" + r8.f31373b.a());
        return r9;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        w r10 = (w) ZeusTransformUtils.preCheckCast(r4.f31386d, w.class, "com.obric.aiagent.plugin");
        com.obric.autogui.session.state.a r11 = (com.obric.autogui.session.state.a) ZeusTransformUtils.preCheckCast(r4.f31385c, com.obric.autogui.session.state.a.class, "com.obric.aiagent.plugin");
        BizStatus.StatusChangedReasonStruct r12 = (BizStatus.StatusChangedReasonStruct) ZeusTransformUtils.preCheckCast(r4.f31384b, BizStatus.StatusChangedReasonStruct.class, "com.obric.aiagent.plugin");
        b r13 = (b) ZeusTransformUtils.preCheckCast(r4.f31383a, b.class, "com.obric.aiagent.plugin");
        d.o.a(r5);
        w r14 = r10;
        r0 = r13;
        com.obric.autogui.session.state.a r15 = r11;
        r1 = r12;
        Object r16 = r6;
    L48:
        r4.f31383a = r0;
        r4.f31384b = r1;
        r4.f31385c = r15;
        r4.f31386d = null;
        r4.g = 2;
        r5 = r14.a(r4);
        if (r5 != r16) goto L51;
        return r16;
    L51:
        com.obric.autogui.session.state.a r17 = r15;
        r8 = r0;
        r2 = r17;
        goto L52
    L16:
        d.o.a(r5);
        r15 = b(r19);
        if (r15 != null) goto L20;
        Loog.INSTANCE.e(TAG, "unmanaged biz status: " + r19);
        return com.obric.autogui.common.e.a.a(com.obric.autogui.common.e.f29014b, ZeusTransformUtils.mapRes(R.string.agent_internal_error, WsChannelMultiProcessSharedProvider.STRING_TYPE, "agent_internal_error"), null, 2, null);
    L20:
        r14 = y.a(null, 1, null);
        C0857b r18 = new C0857b(r15, r14, r1);
        Loog.INSTANCE.i(TAG, "State change request received, target=" + r15.b() + ", " + r0.a(r1) + ", " + d().e() + ", session=" + r0.f31373b.a());
        z.f r110 = new z.f();
        z.f r111 = new z.f();
        Object r112 = r0.p;
        monitor-enter(r112);
        C0857b r113 = (C0857b) ZeusTransformUtils.preCheckCast(r0.q.get(), C0857b.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L54
        BizStatus r114 = r15.b();     // Catch: Throwable -> L54
        c r115 = f();     // Catch: Throwable -> L54
        r111.f38504a = r0.a(r115, r114);     // Catch: Throwable -> L54
        if (r111.f38504a != 0) goto L33;
        r0.q.set(r18);     // Catch: Throwable -> L54
        c r22 = f();     // Catch: Throwable -> L54
        Loog r23 = Loog.INSTANCE;     // Catch: Throwable -> L54
        StringBuilder r24 = new StringBuilder().append("State change request enqueued, oldPending=");     // Catch: Throwable -> L54
        if (r113 == null) goto L29;
        com.obric.autogui.session.state.a r25 = r113.a();     // Catch: Throwable -> L54
        if (r25 == null) goto L29;
        BizStatus r26 = r25.b();     // Catch: Throwable -> L54
    L30:
        r23.i(TAG, r24.append(r26).append(", new=").append(r114).append(", ").append(r0.a(r1)).append(", before=").append(r115.e()).append(", after=").append(r22.e()).append(", session=").append(r0.f31373b.a()).toString());     // Catch: Throwable -> L54
    L29:
        r26 = null;
    L33:
        if (r111.f38504a != 0) goto L35;
        T r116 = r113;
    L36:
        r110.f38504a = r116;     // Catch: Throwable -> L54
        x r27 = x.f38692a;     // Catch: Throwable -> L54
        monitor-exit(r112);
        com.obric.autogui.common.e r28 = (com.obric.autogui.common.e) ZeusTransformUtils.preCheckCast(r111.f38504a, com.obric.autogui.common.e.class, "com.obric.aiagent.plugin");
        if (r28 == null) goto L42;
        Loog.INSTANCE.w(TAG, "State change request rejected, target=" + r15.b() + ", result=" + r28 + ", " + r0.a(r1) + ", " + d().e() + ", session=" + r0.f31373b.a());
        return r28;
    L42:
        C0857b r29 = (C0857b) ZeusTransformUtils.preCheckCast(r110.f38504a, C0857b.class, "com.obric.aiagent.plugin");
        if (r29 == null) goto L45;
        r0.a(r29, r29.a().b(), r15.b());
    L45:
        d.c.g r30 = r0.f31374c.getCoroutineScope().a();
        d.h.a.m r31 = (d.h.a.m) ZeusTransformUtils.preCheckCast(new e(r0, null), d.h.a.m.class, "com.obric.aiagent.plugin");
        r4.f31383a = r0;
        r4.f31384b = r1;
        r4.f31385c = r15;
        r4.f31386d = r14;
        r4.g = 1;
        Object r32 = kotlinx.coroutines.i.a(r30, r31, r4);
        r16 = r6;
        if (r32 != r16) goto L48;
        return r16;
    L35:
        r116 = 0;
    L54:
        th = move-exception;
        throw th;
    L7:
        r4 = new d(r0, r3);
        goto L8
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:56:0x01f7 -> B:57:0x01fa). Please report as a decompilation issue!!! */
    private final Object a(d.c.d<? super x> r13) {
        d.c.d r14 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r13, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r14, f.class) == false) goto L7;
        f r0 = (f) ZeusTransformUtils.preCheckCast(r14, f.class, "com.obric.aiagent.plugin");
        if ((r0.f31394e & Integer.MIN_VALUE) == 0) goto L7;
        r0.f31394e -= Integer.MIN_VALUE;
    L8:
        Object r15 = r0.f31392c;
        Object r1 = d.c.a.b.a();
        int r2 = r0.f31394e;
        if (r2 == 0) goto L18;
        if (r2 != 1) goto L17;
        C0857b r12 = (C0857b) ZeusTransformUtils.preCheckCast(r0.f31391b, C0857b.class, "com.obric.aiagent.plugin");
        b r3 = (b) ZeusTransformUtils.preCheckCast(r0.f31390a, b.class, "com.obric.aiagent.plugin");
        d.o.a(r15);     // Catch: Throwable -> L14
    L57:
        r12.b().a((com.obric.autogui.common.e) ZeusTransformUtils.preCheckCast(r15, com.obric.autogui.common.e.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L14
        Object r16 = r3.p;     // Catch: Throwable -> L82
        monitor-enter(r16);     // Catch: Throwable -> L82
        if (r3.r.get() != r12.a().b()) goto L63;
        r3.r.set(null);     // Catch: Throwable -> L66
    L63:
        x r17 = x.f38692a;     // Catch: Throwable -> L66
        monitor-exit(r16);     // Catch: Throwable -> L82
        b this = r3;
    L95:
        Object r18 = this.p;     // Catch: Throwable -> L87
        monitor-enter(r18);     // Catch: Throwable -> L87
        C0857b r4 = this.q.getAndSet(null);     // Catch: Throwable -> L84
        C0857b r6 = (C0857b) ZeusTransformUtils.preCheckCast(r4, C0857b.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L84
        AtomicReference<BizStatus> r7 = this.r;     // Catch: Throwable -> L84
        if (r6 == null) goto L27;
        com.obric.autogui.session.state.a r8 = r6.a();     // Catch: Throwable -> L84
        if (r8 == null) goto L27;
        BizStatus r9 = r8.b();     // Catch: Throwable -> L84
    L28:
        r7.set(r9);     // Catch: Throwable -> L84
        C0857b r5 = (C0857b) ZeusTransformUtils.preCheckCast(r4, C0857b.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L84
        monitor-exit(r18);     // Catch: Throwable -> L87
        if (r5 == null) goto L31;
        com.obric.autogui.util.c.b r19 = this.n.a();     // Catch: Throwable -> L69
        if (ZeusTransformUtils.instanceOf(r19, com.obric.autogui.session.state.a.class) == false) goto L35;
        com.obric.autogui.session.state.a r10 = (com.obric.autogui.session.state.a) ZeusTransformUtils.preCheckCast(r19, com.obric.autogui.session.state.a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L69
    L36:
        if (r10 == null) goto L38;
        BizStatus r11 = r10.b();     // Catch: Throwable -> L69
    L40:
        if (o.a(r5.a(), r19) == false) goto L53;
        Loog.INSTANCE.i(TAG, "State change to " + r5.a().getClass().getSimpleName() + " requested, but it's already the current state. Skipping, old=" + r5.a().b() + ", new=" + r5.a().b() + ", " + this.d().e() + ", session=" + this.f31373b.a());     // Catch: Throwable -> L69
        r5.b().a(com.obric.autogui.common.e.f29014b.a());     // Catch: Throwable -> L69
        Object r110 = this.p;     // Catch: Throwable -> L87
        monitor-enter(r110);     // Catch: Throwable -> L87
        if (this.r.get() != r5.a().b()) goto L47;
        this.r.set(null);     // Catch: Throwable -> L50
    L47:
        x r20 = x.f38692a;     // Catch: Throwable -> L50
        monitor-exit(r110);     // Catch: Throwable -> L87
        goto L95
    L50:
        th = move-exception;
        throw th;     // Catch: Throwable -> L87
    L53:
        Loog.INSTANCE.i(TAG, "Processing state change to: " + r5.a().b() + ", old=" + r11 + ", new=" + r5.a().b() + ", " + this.d().e() + ", session=" + this.f31373b.a());     // Catch: Throwable -> L69
        r5.a().a(r5.c());     // Catch: Throwable -> L69
        com.obric.autogui.util.c.c r111 = this.n;     // Catch: Throwable -> L69
        com.obric.autogui.util.c.b r21 = (com.obric.autogui.util.c.b) ZeusTransformUtils.preCheckCast(r5.a(), com.obric.autogui.util.c.b.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L69
        r0.f31390a = this;     // Catch: Throwable -> L69
        r0.f31391b = r5;     // Catch: Throwable -> L69
        r0.f31394e = 1;     // Catch: Throwable -> L69
        r15 = r111.a(r21, r0);     // Catch: Throwable -> L69
        if (r15 != r1) goto L56;
        return r1;
    L56:
        r3 = this;
        r12 = r5;
        goto L57
    L38:
        r11 = null;
        goto L40
    L35:
        r10 = null;
    L69:
        th = th;
        r3 = this;
        r12 = r5;
    L71:
        Object r22 = r3.p;     // Catch: Throwable -> L82
        monitor-enter(r22);     // Catch: Throwable -> L82
    L79:
        th = move-exception;
        throw th;     // Catch: Throwable -> L82
    L74:
        if (r3.r.get() != r12.a().b()) goto L76;
        r3.r.set(null);     // Catch: Throwable -> L79
    L76:
        x r112 = x.f38692a;     // Catch: Throwable -> L79
        monitor-exit(r22);     // Catch: Throwable -> L82
        throw th;     // Catch: Throwable -> L82
    L31:
        this.o.set(false);
    L92:
        return x.f38692a;
    L27:
        r9 = null;
        goto L28
    L84:
        th = move-exception;
        throw th;     // Catch: Throwable -> L87
    L87:
        th = th;
    L88:
        this.o.set(false);
        throw th;
    L66:
        th = move-exception;
        throw th;     // Catch: Throwable -> L82
    L82:
        th = th;
        this = r3;
    L14:
        th = th;
        goto L71
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        d.o.a(r15);
        if (this.o.compareAndSet(false, true) == true) goto L95;
        Loog.INSTANCE.i(TAG, "State change request handling deferred to active processing queue.");
    L7:
        r0 = new f(this, r14);
        goto L8
    }

    private final c f() {
        BizStatus r1 = e().b();
        C0857b r2 = (C0857b) ZeusTransformUtils.preCheckCast(this.q.get(), C0857b.class, "com.obric.aiagent.plugin");
        if (r2 == null) goto L7;
        com.obric.autogui.session.state.a r3 = r2.a();
        if (r3 == null) goto L7;
        BizStatus r4 = r3.b();
    L9:
        return new c(r1, r4, (BizStatus) ZeusTransformUtils.preCheckCast(this.r.get(), BizStatus.class, "com.obric.aiagent.plugin"));
    L7:
        r4 = null;
        goto L9
    }

    private final com.obric.autogui.common.e a(c r9, BizStatus r10) {
        if (c(r10) == false) goto L6;
        return null;
    L6:
        if (c(r9.c()) == false) goto L10;
        Loog.INSTANCE.w(TAG, "State change to " + r10 + " rejected by processing terminal request, old=" + r9.b() + ", new=" + r10 + ", " + r9.e() + ", session=" + this.f31373b.a());
        return com.obric.autogui.common.e.f29014b.b("state change to " + r10 + " rejected by processing terminal request");
    L10:
        if (c(r9.b()) == false) goto L13;
        Loog.INSTANCE.w(TAG, "State change to " + r10 + " rejected by pending terminal request, old=" + r9.b() + ", new=" + r10 + ", " + r9.e() + ", session=" + this.f31373b.a());
        return com.obric.autogui.common.e.f29014b.b("state change to " + r10 + " rejected by pending terminal request");
    L13:
        return null;
    }

    private final void a(C0857b r6, BizStatus r7, BizStatus r8) {
        Loog.INSTANCE.w(TAG, "State change to " + r7 + " cancelled by new request to " + r8 + ", old=" + r7 + ", new=" + r8 + ", " + d().e() + ", session=" + this.f31373b.a());
        r6.b().a(com.obric.autogui.common.e.f29014b.b("state change to " + r7 + " cancelled by new request to " + r8));
    }

    private final String a(BizStatus.StatusChangedReasonStruct r12) {
        String r11 = p.a((Iterable) ZeusTransformUtils.preCheckCast(r12.getExtra().keySet(), Iterable.class, "com.obric.aiagent.plugin"), null, (CharSequence) ZeusTransformUtils.preCheckCast("[", CharSequence.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("]", CharSequence.class, "com.obric.aiagent.plugin"), 0, null, null, 57, null);
        Object r0 = r12.getObj();
        if (r0 == null) goto L7;
        Class<?> r1 = r0.getClass();
        if (r1 == null) goto L7;
        String r2 = r1.getSimpleName();
    L9:
        return "reason=" + r12.getReason() + ", msg=" + r12.getMsg() + ", objClass=" + r2 + ", extraKeys=" + r11;
    L7:
        r2 = null;
        goto L9
    }

    private final boolean c(BizStatus r1) {
        if (r1 != BizStatus.TERMINATED) goto L5;
        return true;
    L5:
        return false;
    }

    public com.obric.autogui.session.state.a e() {
        com.obric.autogui.util.c.b r2 = this.n.a();
        o.a(r2, "null cannot be cast to non-null type com.obric.autogui.session.state.AOSessionBaseState");
        return (com.obric.autogui.session.state.a) ZeusTransformUtils.preCheckCast(r2, com.obric.autogui.session.state.a.class, "com.obric.aiagent.plugin");
    }
}
