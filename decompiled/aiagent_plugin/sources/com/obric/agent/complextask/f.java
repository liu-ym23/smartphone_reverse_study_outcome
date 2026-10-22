package com.obric.agent.complextask;

import android.os.SystemClock;
import com.bytedance.apm.battery.dao.DBHelper;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.capabilitykit.common.ITaskStateChangeCallback;
import com.obric.funcall_api.IIntentActionService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.b.a.l;
import d.h.a.m;
import d.o;
import d.x;
import java.util.Map;
import java.util.concurrent.CancellationException;
import kotlinx.coroutines.a.s;
import kotlinx.coroutines.a.t;
import kotlinx.coroutines.am;
import kotlinx.coroutines.ax;
import kotlinx.coroutines.ca;
import kotlinx.coroutines.dg;
import kotlinx.coroutines.n;

/* JADX INFO: compiled from: TaskQueueManager.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class f {
    private static final String TAG = "TaskQueueManager";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f14362a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final kotlinx.coroutines.a.d<c> f14363b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ca f14364c;

    /* JADX INFO: renamed from: com.obric.agent.complextask.f$1, reason: invalid class name */
    /* JADX INFO: compiled from: TaskQueueManager.kt */
    @d.c.b.a.f(b = "TaskQueueManager.kt", c = {283, 39}, d = "invokeSuspend", e = "com.obric.agent.complextask.TaskQueueManager$1")
    static final class AnonymousClass1 extends l implements m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f14365a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f14366b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f14367c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f14368d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ f f14369e;

        AnonymousClass1(f r3, d.c.d<? super AnonymousClass1> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f14369e = r3;
            super(2, r5);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((AnonymousClass1) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), AnonymousClass1.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.f14369e, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x00ae -> B:8:0x0031). Please report as a decompilation issue!!! */
        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r11) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f14368d;
            if (r1 == 0) goto L14;
            if (r1 == 1) goto L11;
            if (r1 != 2) goto L10;
            kotlinx.coroutines.a.f r2 = (kotlinx.coroutines.a.f) ZeusTransformUtils.preCheckCast(this.f14367c, kotlinx.coroutines.a.f.class, "com.obric.aiagent.plugin");
            s r5 = (s) ZeusTransformUtils.preCheckCast(this.f14366b, s.class, "com.obric.aiagent.plugin");
            f r6 = (f) ZeusTransformUtils.preCheckCast(this.f14365a, f.class, "com.obric.aiagent.plugin");
            o.a(r11);     // Catch: Throwable -> L28
        L8:
            f r12 = r6;
        L16:
            this.f14365a = r12;     // Catch: Throwable -> L28
            this.f14366b = r5;     // Catch: Throwable -> L28
            this.f14367c = r2;     // Catch: Throwable -> L28
            this.f14368d = 1;     // Catch: Throwable -> L28
            Object r7 = r2.a(this);     // Catch: Throwable -> L28
            if (r7 != r0) goto L19;
            return r0;
        L19:
            r6 = r12;
            r11 = r7;
        L21:
            if (((Boolean) ZeusTransformUtils.preCheckCast(r11, Boolean.class, "com.obric.aiagent.plugin")).booleanValue() == false) goto L25;
            c r13 = (c) ZeusTransformUtils.preCheckCast(r2.a(), c.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L28
            this.f14365a = r6;     // Catch: Throwable -> L28
            this.f14366b = r5;     // Catch: Throwable -> L28
            this.f14367c = r2;     // Catch: Throwable -> L28
            this.f14368d = 2;     // Catch: Throwable -> L28
            if (f.a(r6, r13, this) != r0) goto L8;
            return r0;
        L25:
            x r10 = x.f38692a;     // Catch: Throwable -> L28
            kotlinx.coroutines.a.j.a(r5, null);
            return x.f38692a;
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L11:
            r2 = (kotlinx.coroutines.a.f) ZeusTransformUtils.preCheckCast(this.f14367c, kotlinx.coroutines.a.f.class, "com.obric.aiagent.plugin");
            r5 = (s) ZeusTransformUtils.preCheckCast(this.f14366b, s.class, "com.obric.aiagent.plugin");
            r6 = (f) ZeusTransformUtils.preCheckCast(this.f14365a, f.class, "com.obric.aiagent.plugin");
            o.a(r11);     // Catch: Throwable -> L28
            goto L21
        L14:
            o.a(r11);
            r5 = (s) ZeusTransformUtils.preCheckCast(f.a(this.f14369e), s.class, "com.obric.aiagent.plugin");
            r12 = this.f14369e;
            r2 = r5.g();     // Catch: Throwable -> L28
        L28:
            th = move-exception;
            throw th;     // Catch: Throwable -> L30
        L30:
            th = move-exception;
            kotlinx.coroutines.a.j.a(r5, th);
            throw th;
        }
    }

    /* JADX INFO: compiled from: TaskQueueManager.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: TaskQueueManager.kt */
    private static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f14370a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f14371b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final String f14372c;

        /* JADX INFO: compiled from: TaskQueueManager.kt */
        public static final class a {
            public /* synthetic */ a(d.h.b.h r1) {
                this();
            }

            private a() {
            }

            public final b a(String r2) {
                d.h.b.o.e(r2, "message");
                return new b(true, r2);
            }

            public final b b(String r2) {
                d.h.b.o.e(r2, "message");
                return new b(false, r2);
            }

            public final b a(boolean r2, String r3) {
                d.h.b.o.e(r3, "message");
                if (r2 == false) goto L6;
                return a(r3);
            L6:
                return b(r3);
            }
        }

        static {
            f14370a = new a(null);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
            return false;
        L8:
            b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.aiagent.plugin");
            if (this.f14371b == r6.f14371b) goto L12;
            return false;
        L12:
            if (d.h.b.o.a(this.f14372c, r6.f14372c) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (Boolean.hashCode(this.f14371b) * 31) + this.f14372c.hashCode();
        }

        public String toString() {
            return "TakeOverNotifyResult(isSuccess=" + this.f14371b + ", message=" + this.f14372c + ')';
        }

        public b(boolean r2, String r3) {
            d.h.b.o.e(r3, "message");
            this.f14371b = r2;
            this.f14372c = r3;
        }

        public final boolean a() {
            return this.f14371b;
        }

        public final String b() {
            return this.f14372c;
        }
    }

    /* JADX INFO: compiled from: TaskQueueManager.kt */
    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f14373a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f14374b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final long f14375c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final Map<String, String> f14376d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final String f14377e;
        private final ITaskStateChangeCallback f;

        public boolean equals(Object r9) {
            if (this != r9) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r9, c.class) == true) goto L8;
            return false;
        L8:
            c r10 = (c) ZeusTransformUtils.preCheckCast(r9, c.class, "com.obric.aiagent.plugin");
            if (d.h.b.o.a(this.f14373a, r10.f14373a) == true) goto L12;
            return false;
        L12:
            if (d.h.b.o.a(this.f14374b, r10.f14374b) == true) goto L15;
            return false;
        L15:
            if (this.f14375c == r10.f14375c) goto L18;
            return false;
        L18:
            if (d.h.b.o.a(this.f14376d, r10.f14376d) == true) goto L21;
            return false;
        L21:
            if (d.h.b.o.a(this.f14377e, r10.f14377e) == true) goto L24;
            return false;
        L24:
            if (d.h.b.o.a(this.f, r10.f) == true) goto L26;
            return false;
        L26:
            return true;
        }

        public int hashCode() {
            String r0 = this.f14373a;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = r2 * 31;
            String r4 = this.f14374b;
            if (r4 != null) goto L9;
            int r5 = 0;
        L10:
            int r6 = (((r3 + r5) * 31) + Long.hashCode(this.f14375c)) * 31;
            Map<String, String> r7 = this.f14376d;
            if (r7 != null) goto L13;
            int r8 = 0;
        L14:
            int r9 = (((r6 + r8) * 31) + this.f14377e.hashCode()) * 31;
            ITaskStateChangeCallback r10 = this.f;
            if (r10 == null) goto L19;
            r1 = r10.hashCode();
        L19:
            return r9 + r1;
        L13:
            r8 = r7.hashCode();
            goto L14
        L9:
            r5 = r4.hashCode();
            goto L10
        L5:
            r2 = r0.hashCode();
            goto L6
        }

        public String toString() {
            return "TaskData(messageId=" + this.f14373a + ", content=" + this.f14374b + ", timeout=" + this.f14375c + ", ext=" + this.f14376d + ", scene=" + this.f14377e + ", callback=" + this.f + ')';
        }

        public c(String r3, String r4, long r5, Map<String, String> r7, String r8, ITaskStateChangeCallback r9) {
            Map<String, String> r10 = (Map) ZeusTransformUtils.wrapperContextForParams(r7, Map.class, "com.obric.aiagent.plugin");
            ITaskStateChangeCallback r11 = (ITaskStateChangeCallback) ZeusTransformUtils.wrapperContextForParams(r9, ITaskStateChangeCallback.class, "com.obric.aiagent.plugin");
            d.h.b.o.e(r8, DBHelper.BATTERY_COL_SCENE);
            this.f14373a = r3;
            this.f14374b = r4;
            this.f14375c = r5;
            this.f14376d = r10;
            this.f14377e = r8;
            this.f = r11;
        }

        public final String a() {
            return this.f14373a;
        }

        public final String b() {
            return this.f14374b;
        }

        public final long c() {
            return this.f14375c;
        }

        public final Map<String, String> d() {
            return this.f14376d;
        }

        public final String e() {
            return this.f14377e;
        }

        public final ITaskStateChangeCallback f() {
            return this.f;
        }
    }

    /* JADX INFO: compiled from: TaskQueueManager.kt */
    static final class d implements d.h.a.b<Throwable, x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f14378a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ f f14379b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ c f14380c;

        d(int r1, f r2, c r3) {
            this.f14378a = r1;
            this.f14379b = r2;
            this.f14380c = r3;
        }

        @Override // d.h.a.b
        public /* synthetic */ x invoke(Throwable r3) {
            a((Throwable) ZeusTransformUtils.preCheckCast(r3, Throwable.class, "com.obric.aiagent.plugin"));
            return x.f38692a;
        }

        public final void a(Throwable r3) {
            ILogDepend.Companion.w(f.TAG, "userTakeOver: callback wait cancelled, attempt: " + this.f14378a + ", request: " + f.a(this.f14379b, this.f14380c));
        }
    }

    /* JADX INFO: compiled from: TaskQueueManager.kt */
    static final class e implements m<Boolean, String, x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ n<b> f14381a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f14382b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ f f14383c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ c f14384d;

        e(n<? super b> r3, int r4, f r5, c r6) {
            this.f14381a = (n) ZeusTransformUtils.wrapperContextForParams(r3, n.class, "com.obric.aiagent.plugin");
            this.f14382b = r4;
            this.f14383c = r5;
            this.f14384d = r6;
        }

        @Override // d.h.a.m
        public /* synthetic */ x invoke(Boolean r3, String r4) {
            a(((Boolean) ZeusTransformUtils.preCheckCast(r3, Boolean.class, "com.obric.aiagent.plugin")).booleanValue(), (String) ZeusTransformUtils.preCheckCast(r4, String.class, "com.obric.aiagent.plugin"));
            return x.f38692a;
        }

        public final void a(boolean r4, String r5) {
            d.h.b.o.e(r5, "message");
            b r0 = b.f14370a.a(r4, r5);
            if (this.f14381a.a() == false) goto L5;
            d.c.d r3 = (d.c.d) ZeusTransformUtils.preCheckCast(this.f14381a, d.c.d.class, "com.obric.aiagent.plugin");
            d.n.a r6 = d.n.f38560a;
            r3.resumeWith(d.n.f(r0));
            return;
        L5:
            ILogDepend.Companion.w(f.TAG, "userTakeOver: late callback ignored, attempt: " + this.f14382b + ", success: " + r4 + ", msg: " + r5 + ", request: " + f.a(this.f14383c, this.f14384d));
        }
    }

    /* JADX INFO: renamed from: com.obric.agent.complextask.f$f, reason: collision with other inner class name */
    /* JADX INFO: compiled from: TaskQueueManager.kt */
    @d.c.b.a.f(b = "TaskQueueManager.kt", c = {106}, d = "handleUserTakeOverRequestSafely", e = "com.obric.agent.complextask.TaskQueueManager")
    static final class C0288f extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f14385a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f14386b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        /* synthetic */ Object f14387c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ f f14388d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f14389e;

        C0288f(f r3, d.c.d<? super C0288f> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f14388d = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f14387c = r3;
            this.f14389e |= Integer.MIN_VALUE;
            return f.a(this.f14388d, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: TaskQueueManager.kt */
    @d.c.b.a.f(b = "TaskQueueManager.kt", c = {170}, d = "notifyOnceWithTimeout", e = "com.obric.agent.complextask.TaskQueueManager")
    static final class g extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f14390a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f14391b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ f f14392c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f14393d;

        g(f r3, d.c.d<? super g> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f14392c = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f14391b = r3;
            this.f14393d |= Integer.MIN_VALUE;
            return f.a(this.f14392c, null, 0, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: TaskQueueManager.kt */
    @d.c.b.a.f(b = "TaskQueueManager.kt", c = {171}, d = "invokeSuspend", e = "com.obric.agent.complextask.TaskQueueManager$notifyOnceWithTimeout$2")
    static final class h extends l implements m<am, d.c.d<? super b>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f14394a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ f f14395b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ IIntentActionService f14396c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ c f14397d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f14398e;

        h(f r3, IIntentActionService r4, c r5, int r6, d.c.d<? super h> r7) {
            IIntentActionService r8 = (IIntentActionService) ZeusTransformUtils.wrapperContextForParams(r4, IIntentActionService.class, "com.obric.aiagent.plugin");
            d.c.d r9 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r7, d.c.d.class, "com.obric.aiagent.plugin");
            this.f14395b = r3;
            this.f14396c = r8;
            this.f14397d = r5;
            this.f14398e = r6;
            super(2, r9);
        }

        public final Object a(am r3, d.c.d<? super b> r4) {
            return ((h) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), h.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r8, d.c.d<?> r9) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r9, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new h(this.f14395b, this.f14396c, this.f14397d, this.f14398e, r6), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super b> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r8) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f14394a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r8);
        L11:
            return r8;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r8);
            f r9 = this.f14395b;
            IIntentActionService r2 = this.f14396c;
            c r3 = this.f14397d;
            int r4 = this.f14398e;
            d.c.d r5 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f14394a = 1;
            r8 = f.a(r9, r2, r3, r4, r5);
            if (r8 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: compiled from: TaskQueueManager.kt */
    @d.c.b.a.f(b = "TaskQueueManager.kt", c = {142, 150}, d = "notifyWithRetry", e = "com.obric.agent.complextask.TaskQueueManager")
    static final class i extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f14399a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f14400b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f14401c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        long f14402d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f14403e;
        /* synthetic */ Object f;
        final /* synthetic */ f g;
        int h;

        i(f r3, d.c.d<? super i> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.g = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r4) {
            this.f = r4;
            this.h |= Integer.MIN_VALUE;
            return f.a(this.g, null, 0, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: TaskQueueManager.kt */
    @d.c.b.a.f(b = "TaskQueueManager.kt", c = {122}, d = "processUserTakeOverRequest", e = "com.obric.agent.complextask.TaskQueueManager")
    static final class j extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f14404a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f14405b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        long f14406c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        /* synthetic */ Object f14407d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ f f14408e;
        int f;

        j(f r3, d.c.d<? super j> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f14408e = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f14407d = r3;
            this.f |= Integer.MIN_VALUE;
            return f.b(this.f14408e, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    static {
        f14362a = new a(null);
    }

    private final String b() {
        return "takeover callback timeout after 5000ms";
    }

    public static /* synthetic */ x lambda$7DrXNTVlfljCDan1cUjLDPza6ck(String r0, ITaskStateChangeCallback r1) {
        return a(r0, r1);
    }

    public static /* synthetic */ x lambda$HfJ1dC0BM9y82uDbekQhUsS1oRk(ITaskStateChangeCallback r0) {
        return b(r0);
    }

    public f() {
        this.f14363b = kotlinx.coroutines.a.g.a(Integer.MAX_VALUE, null, null, 6, null);
        this.f14364c = kotlinx.coroutines.i.a(com.obric.agent.e.f14435a.a(), null, null, (m) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this, null), m.class, "com.obric.aiagent.plugin"), 3, null);
    }

    public static final /* synthetic */ Object a(f r2, c r3, int r4, d.c.d r5) {
        return r2.a(r3, r4, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ Object a(f r2, c r3, long r4, d.c.d r6) {
        return r2.a(r3, r4, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ Object a(f r2, c r3, d.c.d r4) {
        return r2.a(r3, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ Object a(f r2, IIntentActionService r3, c r4, int r5, d.c.d r6) {
        return r2.a((IIntentActionService) ZeusTransformUtils.wrapperContextForParams(r3, IIntentActionService.class, "com.obric.aiagent.plugin"), r4, r5, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ String a(f r0, c r1) {
        return r0.b(r1);
    }

    public static final /* synthetic */ kotlinx.coroutines.a.d a(f r0) {
        return r0.f14363b;
    }

    public static final /* synthetic */ Object b(f r2, c r3, d.c.d r4) {
        return r2.b(r3, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public final void a(String r11, String r12, long r13, Map<String, String> r15, String r16, ITaskStateChangeCallback r17) {
        Map r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r15, Map.class, "com.obric.aiagent.plugin");
        ITaskStateChangeCallback r9 = (ITaskStateChangeCallback) ZeusTransformUtils.wrapperContextForParams(r17, ITaskStateChangeCallback.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r16, DBHelper.BATTERY_COL_SCENE);
        a(new c(r11, r12, r13, r7, r16, r9));
    }

    private final void a(c r5) {
        Object r0 = this.f14363b.a_(r5);
        if (kotlinx.coroutines.a.h.b(r0) == false) goto L10;
        ILogDepend.Companion r1 = ILogDepend.Companion;
        StringBuilder r2 = new StringBuilder().append("userTakeOver enqueue failed: ");
        Throwable r3 = kotlinx.coroutines.a.h.e(r0);
        if (r3 == null) goto L7;
        String r4 = r3.getMessage();
    L8:
        r1.e(TAG, r2.append(r4).append(", request: ").append(b(r5)).toString());
        a(r5.f(), "enqueue user takeover failed");
        return;
    L7:
        r4 = null;
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final Object a(c r6, d.c.d<? super x> r7) {
        d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r7, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r8, C0288f.class) == false) goto L7;
        C0288f r0 = (C0288f) ZeusTransformUtils.preCheckCast(r8, C0288f.class, "com.obric.aiagent.plugin");
        if ((r0.f14389e & Integer.MIN_VALUE) == 0) goto L7;
        r0.f14389e -= Integer.MIN_VALUE;
    L8:
        Object r9 = r0.f14387c;
        Object r2 = d.c.a.b.a();
        int r3 = r0.f14389e;
        if (r3 == 0) goto L16;
        if (r3 != 1) goto L15;
        r6 = (c) ZeusTransformUtils.preCheckCast(r0.f14386b, c.class, "com.obric.aiagent.plugin");
        f r5 = (f) ZeusTransformUtils.preCheckCast(r0.f14385a, f.class, "com.obric.aiagent.plugin");
        o.a(r9);     // Catch: Exception -> L20 CancellationException -> L27
        f this = r5;
    L29:
    L26:
        return x.f38692a;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        o.a(r9);
        r0.f14385a = this;     // Catch: Exception -> L20 CancellationException -> L27
        r0.f14386b = r6;     // Catch: Exception -> L20 CancellationException -> L27
        r0.f14389e = 1;     // Catch: Exception -> L20 CancellationException -> L27
        Object r10 = b(r6, r0);     // Catch: Exception -> L20 CancellationException -> L27
        this = r10;
        if (r10 != r2) goto L29;
        return r2;
    L27:
        e = move-exception;
        throw e;
    L20:
        e = move-exception;
        String r1 = e.getMessage();
        if (r1 != null) goto L24;
        r1 = "process user takeover failed";
    L24:
        ILogDepend.Companion.e(TAG, "userTakeOver: process task failed, request: " + this.b(r6) + ", error: " + d.a.a((Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin")));
        this.a(r6.f(), r1);
    L7:
        r0 = new C0288f(this, r8);
        goto L8
    }

    private final Object b(c r8, d.c.d<? super x> r9) {
        d.c.d r10 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r9, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r10, j.class) == false) goto L7;
        j r0 = (j) ZeusTransformUtils.preCheckCast(r10, j.class, "com.obric.aiagent.plugin");
        if ((r0.f & Integer.MIN_VALUE) == 0) goto L7;
        r0.f -= Integer.MIN_VALUE;
    L8:
        Object r11 = r0.f14407d;
        Object r2 = d.c.a.b.a();
        int r3 = r0.f;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        long r7 = r0.f14406c;
        c r4 = (c) ZeusTransformUtils.preCheckCast(r0.f14405b, c.class, "com.obric.aiagent.plugin");
        f r1 = (f) ZeusTransformUtils.preCheckCast(r0.f14404a, f.class, "com.obric.aiagent.plugin");
        o.a(r11);
    L18:
        b r12 = (b) ZeusTransformUtils.preCheckCast(r11, b.class, "com.obric.aiagent.plugin");
        if (r12.a() == false) goto L22;
        r1.a(r4.f());
        return x.f38692a;
    L22:
        ILogDepend.Companion.e(TAG, "userTakeOver: failed after 2 attempts, msg: " + r12.b() + ", duration: " + (SystemClock.elapsedRealtime() - r7) + ", request: " + r1.b(r4));
        r1.a(r4.f(), r12.b());
        return x.f38692a;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        o.a(r11);
        long r5 = SystemClock.elapsedRealtime();
        r0.f14404a = this;
        r0.f14405b = r8;
        r0.f14406c = r5;
        r0.f = 1;
        r11 = a(r8, r5, r0);
        if (r11 != r2) goto L17;
        return r2;
    L17:
        r1 = this;
        r4 = r8;
        r7 = r5;
    L7:
        r0 = new j(this, r10);
        goto L8
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:30:0x00ea -> B:31:0x00ec). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:32:0x00f1 -> B:33:0x00f7). Please report as a decompilation issue!!! */
    private final Object a(c r20, long r21, d.c.d<? super b> r23) {
        d.c.d r1 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r23, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r1, i.class) == false) goto L7;
        i r3 = (i) ZeusTransformUtils.preCheckCast(r1, i.class, "com.obric.aiagent.plugin");
        if ((r3.h & Integer.MIN_VALUE) == 0) goto L7;
        r3.h -= Integer.MIN_VALUE;
        f r4 = this;
    L8:
        Object r2 = r3.f;
        Object r5 = d.c.a.b.a();
        int r6 = r3.h;
        if (r6 == 0) goto L16;
        if (r6 == 1) goto L15;
        if (r6 != 2) goto L14;
        int r7 = r3.f14403e;
        long r9 = r3.f14402d;
        b r8 = (b) ZeusTransformUtils.preCheckCast(r3.f14401c, b.class, "com.obric.aiagent.plugin");
        c r11 = (c) ZeusTransformUtils.preCheckCast(r3.f14400b, c.class, "com.obric.aiagent.plugin");
        f r0 = (f) ZeusTransformUtils.preCheckCast(r3.f14399a, f.class, "com.obric.aiagent.plugin");
        o.a(r2);
    L31:
        b r10 = r8;
        Object r12 = r5;
        f r13 = r0;
        c r14 = r11;
    L33:
        long r17 = r9;
        int r15 = r7 + 1;
        r4 = r13;
        Object r16 = r12;
        long r18 = r17;
    L18:
        if (r15 >= 3) goto L34;
        r3.f14399a = r4;
        r3.f14400b = r14;
        r3.f14401c = null;
        r3.f14402d = r18;
        r3.f14403e = r15;
        r3.h = 1;
        r2 = r4.a(r14, r15, r3);
        if (r2 != r16) goto L22;
        return r16;
    L22:
        long r19 = r18;
        c r22 = r14;
        r0 = r4;
        r5 = r16;
        r7 = r15;
        r9 = r19;
    L23:
        r10 = (b) ZeusTransformUtils.preCheckCast(r2, b.class, "com.obric.aiagent.plugin");
        r0.a(r22, r7, r10, r9);
        if (r10.a() == false) goto L26;
        return r10;
    L26:
        if (r7 >= 2) goto L32;
        r3.f14399a = r0;
        r3.f14400b = r22;
        r3.f14401c = r10;
        r3.f14402d = r9;
        r3.f14403e = r7;
        r3.h = 2;
        if (ax.a(500, r3) != r5) goto L30;
        return r5;
    L30:
        r11 = r22;
        r8 = r10;
        goto L31
    L32:
        Object r110 = r5;
        r13 = r0;
        r14 = r22;
        r12 = r110;
        goto L33
    L34:
        return r10;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r7 = r3.f14403e;
        r9 = r3.f14402d;
        r22 = (c) ZeusTransformUtils.preCheckCast(r3.f14400b, c.class, "com.obric.aiagent.plugin");
        r0 = (f) ZeusTransformUtils.preCheckCast(r3.f14399a, f.class, "com.obric.aiagent.plugin");
        o.a(r2);
        goto L23
    L16:
        o.a(r2);
        r10 = b.f14370a.b("takeover not attempted");
        r16 = r5;
        r15 = 1;
        r14 = r20;
        r18 = r21;
    L7:
        r4 = this;
        r3 = new i(r4, r1);
        goto L8
    }

    private final Object a(c r15, int r16, d.c.d<? super b> r17) {
        d.c.d r0 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r17, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r0, g.class) == false) goto L7;
        g r1 = (g) ZeusTransformUtils.preCheckCast(r0, g.class, "com.obric.aiagent.plugin");
        if ((r1.f14393d & Integer.MIN_VALUE) == 0) goto L7;
        r1.f14393d -= Integer.MIN_VALUE;
    L8:
        g r8 = r1;
        Object r2 = r8.f14391b;
        Object r9 = d.c.a.b.a();
        int r3 = r8.f14393d;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        f r4 = (f) ZeusTransformUtils.preCheckCast(r8.f14390a, f.class, "com.obric.aiagent.plugin");
        o.a(r2);
    L22:
        b r5 = (b) ZeusTransformUtils.preCheckCast(r2, b.class, "com.obric.aiagent.plugin");
        if (r5 == null) goto L25;
        return r5;
    L25:
        return b.f14370a.b(r4.b());
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        o.a(r2);
        IIntentActionService r6 = (IIntentActionService) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IIntentActionService.class), IIntentActionService.class, "com.obric.aiagent.plugin");
        if (r6 != null) goto L18;
        ILogDepend.Companion.e(TAG, "userTakeOver: IIntentActionService is null, attempt: " + r16 + ", request: " + b(r15));
        return b.f14370a.b("service not available");
    L18:
        m r7 = (m) ZeusTransformUtils.preCheckCast(new h(this, r6, r15, r16, null), m.class, "com.obric.aiagent.plugin");
        r8.f14390a = this;
        r8.f14393d = 1;
        r2 = dg.b(5000, r7, r8);
        if (r2 != r9) goto L21;
        return r9;
    L21:
        r4 = this;
    L7:
        r1 = new g(this, r0);
        goto L8
    }

    private final void a(c r4, int r5, b r6, long r7) {
        ILogDepend.Companion.i(TAG, "userTakeOver: attempt " + r5 + "/2 completed, success: " + r6.a() + ", msg: " + r6.b() + ", duration: " + (SystemClock.elapsedRealtime() - r7) + ", request: " + b(r4));
    }

    private final String b(c r3) {
        return "messageId=" + r3.a() + ", timeout=" + r3.c() + ", ext=" + r3.d() + ", scene=" + r3.e();
    }

    private final void a(ITaskStateChangeCallback r3) {
        a((ITaskStateChangeCallback) ZeusTransformUtils.wrapperContextForParams(r3, ITaskStateChangeCallback.class, "com.obric.aiagent.plugin"), $$Lambda$f$HfJ1dC0BM9y82uDbekQhUsS1oRk.INSTANCE);
    }

    private static final x b(ITaskStateChangeCallback r2) {
        ITaskStateChangeCallback r3 = (ITaskStateChangeCallback) ZeusTransformUtils.wrapperContextForParams(r2, ITaskStateChangeCallback.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "$this$notifyStateCallbackSafely");
        r3.onSuccess();
        return x.f38692a;
    }

    private final void a(ITaskStateChangeCallback r3, final String r4) {
        a((ITaskStateChangeCallback) ZeusTransformUtils.wrapperContextForParams(r3, ITaskStateChangeCallback.class, "com.obric.aiagent.plugin"), new $$Lambda$f$7DrXNTVlfljCDan1cUjLDPza6ck(r4));
    }

    private static final x a(String r2, ITaskStateChangeCallback r3) {
        ITaskStateChangeCallback r4 = (ITaskStateChangeCallback) ZeusTransformUtils.wrapperContextForParams(r3, ITaskStateChangeCallback.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "$this$notifyStateCallbackSafely");
        r4.onError(1, r2);
        return x.f38692a;
    }

    private final void a(ITaskStateChangeCallback r3, d.h.a.b<? super ITaskStateChangeCallback, x> r4) {
        ITaskStateChangeCallback r5 = (ITaskStateChangeCallback) ZeusTransformUtils.wrapperContextForParams(r3, ITaskStateChangeCallback.class, "com.obric.aiagent.plugin");
        d.h.a.b r6 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.b.class, "com.obric.aiagent.plugin");
        if (r5 != null) goto L13;
        return;
    L13:
        d.n.a r0 = d.n.f38560a;     // Catch: Throwable -> L7
        f r2 = (f) ZeusTransformUtils.preCheckCast(this, f.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L7
        r6.invoke(r5);     // Catch: Throwable -> L7
        Object r7 = d.n.f(x.f38692a);     // Catch: Throwable -> L7
    L9:
        Throwable r8 = d.n.c(r7);
        if (r8 == null) goto L15;
        ILogDepend.Companion.e(TAG, "userTakeOver: state callback failed, error: " + d.a.a(r8));
        return;
    L15:
        return;
    L7:
        th = move-exception;
        d.n.a r9 = d.n.f38560a;
        r7 = d.n.f(o.a(th));
        goto L9
    }

    public final void a() {
        t.a.a((t) ZeusTransformUtils.preCheckCast(this.f14363b, t.class, "com.obric.aiagent.plugin"), null, 1, null);
        ca.a.a(this.f14364c, null, 1, null);
    }

    private final Object a(IIntentActionService r12, c r13, int r14, d.c.d<? super b> r15) {
        IIntentActionService r2 = (IIntentActionService) ZeusTransformUtils.wrapperContextForParams(r12, IIntentActionService.class, "com.obric.aiagent.plugin");
        d.c.d r16 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r15, d.c.d.class, "com.obric.aiagent.plugin");
        kotlinx.coroutines.o r17 = new kotlinx.coroutines.o(d.c.a.b.a(r16), 1);
        r17.e();
        n r0 = (n) ZeusTransformUtils.preCheckCast(r17, n.class, "com.obric.aiagent.plugin");
        r0.a((d.h.a.b) ZeusTransformUtils.preCheckCast(new d(r14, this, r13), d.h.a.b.class, "com.obric.aiagent.plugin"));
        r2.notifyUserTakeOverByHttp(r13.a(), r13.b(), r13.e(), r13.c(), r13.d(), (m) ZeusTransformUtils.preCheckCast(new e(r0, r14, this, r13), m.class, "com.obric.aiagent.plugin"));     // Catch: Exception -> L5
    L12:
        Object r11 = r17.h();
        if (r11 != d.c.a.b.a()) goto L15;
        d.c.b.a.h.c(r16);
    L15:
        return r11;
    L5:
        e = move-exception;
        ILogDepend.Companion.e(TAG, "userTakeOver: notify throw, attempt: " + r14 + ", request: " + a(this, r13) + ", error: " + d.a.a((Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin")));
        if (r0.a() == false) goto L12;
        d.c.d r18 = (d.c.d) ZeusTransformUtils.preCheckCast(r0, d.c.d.class, "com.obric.aiagent.plugin");
        b.a r19 = b.f14370a;
        String r110 = e.getMessage();
        if (r110 != null) goto L11;
        r110 = "notify takeover failed";
    L11:
        b r111 = r19.b(r110);
        d.n.a r112 = d.n.f38560a;
        r18.resumeWith(d.n.f(r111));
        goto L12
    }
}
