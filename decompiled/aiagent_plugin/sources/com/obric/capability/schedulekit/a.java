package com.obric.capability.schedulekit;

import android.app.Application;
import com.obric.capabilitykit.common.ICapabilityFeedbackReceiver;
import com.obric.capabilitykit.common.IQueryAppIntentsCallback;
import com.obric.capabilitykit.common.intent.AppIntentImplInfo;
import com.obric.capabilitykit.common.intent.IntentParams;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ao;
import d.h.b.o;
import d.h.b.p;
import d.x;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlinx.coroutines.am;
import kotlinx.coroutines.an;
import kotlinx.coroutines.br;
import kotlinx.coroutines.n;

/* JADX INFO: compiled from: CapabilityScheduleSdk.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a {
    private static final String TAG = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f31846a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final am f31847b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static b f31848c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final List<InterfaceC0873a> f31849d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static boolean f31850e;
    private static final CopyOnWriteArraySet<d.h.a.a<x>> f = null;

    /* JADX INFO: renamed from: com.obric.capability.schedulekit.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: CapabilityScheduleSdk.kt */
    private interface InterfaceC0873a {
        void call();
    }

    /* JADX INFO: compiled from: CapabilityScheduleSdk.kt */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Application f31851a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final ICapabilityFeedbackReceiver f31852b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int f31853c;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
            return false;
        L8:
            b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.aiagent.plugin");
            if (o.a(this.f31851a, r6.f31851a) == true) goto L12;
            return false;
        L12:
            if (o.a(this.f31852b, r6.f31852b) == true) goto L15;
            return false;
        L15:
            if (this.f31853c == r6.f31853c) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            return (((this.f31851a.hashCode() * 31) + this.f31852b.hashCode()) * 31) + Integer.hashCode(this.f31853c);
        }

        public String toString() {
            return "InitConfig(app=" + this.f31851a + ", receiverBinder=" + this.f31852b + ", extBindFlags=" + this.f31853c + ')';
        }

        public b(Application r3, ICapabilityFeedbackReceiver r4, int r5) {
            Application r6 = (Application) ZeusTransformUtils.wrapperContextForParams(r3, Application.class, "com.obric.aiagent.plugin");
            ICapabilityFeedbackReceiver r7 = (ICapabilityFeedbackReceiver) ZeusTransformUtils.wrapperContextForParams(r4, ICapabilityFeedbackReceiver.class, "com.obric.aiagent.plugin");
            o.e(r6, "app");
            o.e(r7, "receiverBinder");
            this.f31851a = r6;
            this.f31852b = r7;
            this.f31853c = r5;
        }

        public /* synthetic */ b(Application r2, ICapabilityFeedbackReceiver r3, int r4, int r5, d.h.b.h r6) {
            Application r7 = (Application) ZeusTransformUtils.wrapperContextForParams(r2, Application.class, "com.obric.aiagent.plugin");
            ICapabilityFeedbackReceiver r8 = (ICapabilityFeedbackReceiver) ZeusTransformUtils.wrapperContextForParams(r3, ICapabilityFeedbackReceiver.class, "com.obric.aiagent.plugin");
            if ((r5 & 4) == 0) goto L5;
            r4 = 0;
        L5:
            this(r7, r8, r4);
        }

        public final Application a() {
            return this.f31851a;
        }

        public final ICapabilityFeedbackReceiver b() {
            return this.f31852b;
        }

        public final int c() {
            return this.f31853c;
        }
    }

    /* JADX INFO: compiled from: CapabilityScheduleSdk.kt */
    public static final class c implements InterfaceC0873a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ d.h.a.a<x> f31854a;

        c(d.h.a.a<x> r3) {
            this.f31854a = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.a.class, "com.obric.aiagent.plugin");
        }

        @Override // com.obric.capability.schedulekit.a.InterfaceC0873a
        public void call() {
            this.f31854a.invoke();
        }
    }

    /* JADX INFO: compiled from: CapabilityScheduleSdk.kt */
    static final class d extends p implements d.h.a.a<x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f31855a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f31856b;

        d(String r1, boolean r2) {
            this.f31855a = r1;
            this.f31856b = r2;
            super(0);
        }

        @Override // d.h.a.a
        public /* synthetic */ x invoke() {
            a();
            return x.f38692a;
        }

        public final void a() {
            a.a(a.f31846a).a(this.f31855a, this.f31856b);
        }
    }

    /* JADX INFO: compiled from: CapabilityScheduleSdk.kt */
    static final class e extends p implements d.h.a.a<x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f31857a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f31858b;

        e(String r1, boolean r2) {
            this.f31857a = r1;
            this.f31858b = r2;
            super(0);
        }

        @Override // d.h.a.a
        public /* synthetic */ x invoke() {
            a();
            return x.f38692a;
        }

        public final void a() {
            a.a(a.f31846a).a(this.f31857a, this.f31858b);
        }
    }

    /* JADX INFO: compiled from: CapabilityScheduleSdk.kt */
    static final class f extends p implements d.h.a.a<x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f31859a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f31860b;

        f(String r1, boolean r2) {
            this.f31859a = r1;
            this.f31860b = r2;
            super(0);
        }

        @Override // d.h.a.a
        public /* synthetic */ x invoke() {
            a();
            return x.f38692a;
        }

        public final void a() {
            com.obric.capability.schedulekit.c.c.f31906a.i(a.c(), "dispatchServerActions");
            a.a(a.f31846a).a(this.f31859a, this.f31860b);
        }
    }

    /* JADX INFO: compiled from: CapabilityScheduleSdk.kt */
    static final class g extends p implements d.h.a.a<x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final g f31861a = null;

        static {
            f31861a = new g();
        }

        g() {
            super(0);
        }

        public final void a() {
        }

        @Override // d.h.a.a
        public /* synthetic */ x invoke() {
            a();
            return x.f38692a;
        }
    }

    /* JADX INFO: compiled from: CapabilityScheduleSdk.kt */
    @d.c.b.a.f(b = "CapabilityScheduleSdk.kt", c = {98}, d = "isDownloadAppIntentV2", e = "com.obric.capability.schedulekit.CapabilityScheduleSdk")
    static final class h extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        /* synthetic */ Object f31862a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ a f31863b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f31864c;

        h(a r3, d.c.d<? super h> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f31863b = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f31862a = r3;
            this.f31864c |= Integer.MIN_VALUE;
            return this.f31863b.c(null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: CapabilityScheduleSdk.kt */
    static final class i extends p implements d.h.a.a<x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f31865a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ n<List<AppIntentImplInfo>> f31866b;

        i(String r3, n<? super List<AppIntentImplInfo>> r4) {
            n<List<AppIntentImplInfo>> r5 = (n) ZeusTransformUtils.wrapperContextForParams(r4, n.class, "com.obric.aiagent.plugin");
            this.f31865a = r3;
            this.f31866b = r5;
            super(0);
        }

        @Override // d.h.a.a
        public /* synthetic */ x invoke() {
            a();
            return x.f38692a;
        }

        public final void a() {
            com.obric.capability.schedulekit.d r0 = a.a(a.f31846a);
            String r1 = this.f31865a;
            final n<List<AppIntentImplInfo>> r4 = this.f31866b;
            r0.a(r1, (IQueryAppIntentsCallback) ZeusTransformUtils.preCheckCast(new CapabilityScheduleSdk$queryAppIntents$2$1$1(r4), IQueryAppIntentsCallback.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: CapabilityScheduleSdk.kt */
    static final class j extends p implements d.h.a.a<x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ICapabilityFeedbackReceiver f31867a;

        j(ICapabilityFeedbackReceiver r3) {
            this.f31867a = (ICapabilityFeedbackReceiver) ZeusTransformUtils.wrapperContextForParams(r3, ICapabilityFeedbackReceiver.class, "com.obric.aiagent.plugin");
            super(0);
        }

        @Override // d.h.a.a
        public /* synthetic */ x invoke() {
            a();
            return x.f38692a;
        }

        public final void a() {
            com.obric.capability.schedulekit.c.c.f31906a.i(a.c(), "registerActionsResultReceiver");
            a.a(a.f31846a).a(this.f31867a);
        }
    }

    public static /* synthetic */ Thread lambda$MLU2XeQuvqVCQdijyNfTVS29O5I(Runnable r0) {
        return a(r0);
    }

    private a() {
    }

    public static final /* synthetic */ com.obric.capability.schedulekit.d a(a r0) {
        return r0.d();
    }

    public static final /* synthetic */ void a(a r2, d.h.a.a r3) {
        r2.b((d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.a.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ String c() {
        return TAG;
    }

    static {
        f31846a = new a();
        TAG = "CapabilityScheduleSdk";
        ExecutorService r0 = Executors.newSingleThreadExecutor($$Lambda$a$MLU2XeQuvqVCQdijyNfTVS29O5I.INSTANCE);
        o.c(r0, "newSingleThreadExecutor …pability-schedule\")\n    }");
        f31847b = an.a((d.c.g) ZeusTransformUtils.preCheckCast(br.a(r0), d.c.g.class, "com.obric.aiagent.plugin"));
        f31849d = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
        f = new CopyOnWriteArraySet();
    }

    private final com.obric.capability.schedulekit.d d() {
        return ScheduleServiceConnection.INSTANCE.getApi$capabilityschedulekit_release(e().c());
    }

    private static final Thread a(Runnable r2) {
        return new Thread((Runnable) ZeusTransformUtils.wrapperContextForParams(r2, Runnable.class, "com.obric.aiagent.plugin"), "capability-schedule");
    }

    private final b e() {
        b r1 = f31848c;
        if (r1 == null) goto L6;
        return r1;
    L6:
        throw new RuntimeException("you need to invoke CapabilityScheduleSdk.init!");
    }

    public static final void a(com.obric.capability.schedulekit.c.b r2) {
        com.obric.capability.schedulekit.c.b r3 = (com.obric.capability.schedulekit.c.b) ZeusTransformUtils.wrapperContextForParams(r2, com.obric.capability.schedulekit.c.b.class, "com.obric.aiagent.plugin");
        o.e(r3, "logger");
        com.obric.capability.schedulekit.c.c.f31906a.a(r3);
        com.obric.capability.schedulekit.c.c.f31906a.i(TAG, "CapabilityScheduleSdk setLogger");
    }

    public static final void a(b r5) {
        o.e(r5, "config");
        a r0 = f31846a;
        f31848c = r5;
        com.obric.capability.schedulekit.c.c.f31906a.i(TAG, "CapabilityScheduleSdk init");
        com.obric.capability.schedulekit.a.c.f31868a.a((com.obric.capability.schedulekit.a.c) ZeusTransformUtils.preCheckCast(new com.obric.capability.schedulekit.a.d((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r5.a(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")), com.obric.capability.schedulekit.a.c.class, "com.obric.aiagent.plugin"));
        r0.b((d.h.a.a) ZeusTransformUtils.preCheckCast(g.f31861a, d.h.a.a.class, "com.obric.aiagent.plugin"));
    }

    public static final void a(d.h.a.a<x> r2) {
        d.h.a.a<x> r3 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r2, d.h.a.a.class, "com.obric.aiagent.plugin");
        o.e(r3, "listener");
        f.add(r3);
    }

    public final void a() {
        Iterator r6 = ((Iterable) ZeusTransformUtils.preCheckCast(f, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L4:
        if (r6.hasNext() == false) goto L13;
        d.h.a.a r0 = (d.h.a.a) ZeusTransformUtils.preCheckCast(r6.next(), d.h.a.a.class, "com.obric.aiagent.plugin");
        d.n.a r2 = d.n.f38560a;     // Catch: Throwable -> L8
        r0.invoke();     // Catch: Throwable -> L8
        Object r1 = d.n.f(x.f38692a);     // Catch: Throwable -> L8
    L10:
        Throwable r3 = d.n.c(r1);
        if (r3 == null) goto L4;
        com.obric.capability.schedulekit.c.c.f31906a.e(TAG, "connectionListener throw exception: " + d.a.a(r3));
    L8:
        th = move-exception;
        d.n.a r4 = d.n.f38560a;
        r1 = d.n.f(d.o.a(th));
        goto L10
    }

    public final Object b(String r2, d.c.d<? super Integer> r3) {
        d.c.d<? super Integer> r1 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
        return com.obric.capability.schedulekit.f.f31911a.a(r2, r1);
    }

    public final Object c(String r6, d.c.d<? super Boolean> r7) {
        d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r7, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r8, h.class) == false) goto L7;
        h r0 = (h) ZeusTransformUtils.preCheckCast(r8, h.class, "com.obric.aiagent.plugin");
        if ((r0.f31864c & Integer.MIN_VALUE) == 0) goto L7;
        r0.f31864c -= Integer.MIN_VALUE;
    L8:
        Object r9 = r0.f31862a;
        Object r2 = d.c.a.b.a();
        int r3 = r0.f31864c;
        boolean r4 = true;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        d.o.a(r9);
    L18:
        if (((Number) ZeusTransformUtils.preCheckCast(r9, Number.class, "com.obric.aiagent.plugin")).intValue() >= 2) goto L22;
        r4 = false;
    L22:
        return d.c.b.a.b.a(r4);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        d.o.a(r9);
        r0.f31864c = 1;
        r9 = b(r6, r0);
        if (r9 != r2) goto L18;
        return r2;
    L7:
        r0 = new h(this, r8);
        goto L8
    }

    public static /* synthetic */ Object a(a r10, String r11, IntentParams r12, long r13, long r15, String r17, boolean r18, Map r19, d.c.d r20, int r21, Object r22) {
        IntentParams r0 = (IntentParams) ZeusTransformUtils.wrapperContextForParams(r12, IntentParams.class, "com.obric.aiagent.plugin");
        Map<String, String> r2 = (Map) ZeusTransformUtils.wrapperContextForParams(r19, Map.class, "com.obric.aiagent.plugin");
        d.c.d<? super JobResultWrapper> r1 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r20, d.c.d.class, "com.obric.aiagent.plugin");
        String r4 = null;
        if ((r21 & 2) == 0) goto L6;
        r0 = null;
    L6:
        if ((r21 & 4) == 0) goto L8;
        long r5 = 5000;
    L10:
        if ((r21 & 8) == 0) goto L12;
        long r7 = 0;
    L14:
        if ((r21 & 16) != 0) goto L18;
        r4 = r17;
    L18:
        if ((r21 & 32) == 0) goto L20;
        boolean r3 = false;
    L22:
        if ((r21 & 64) == 0) goto L25;
        r2 = ao.b();
    L25:
        return r10.a(r11, r0, r5, r7, r4, r3, r2, r1);
    L20:
        r3 = r18;
        goto L22
    L12:
        r7 = r15;
        goto L14
    L8:
        r5 = r13;
        goto L10
    }

    public final Object a(String r12, IntentParams r13, long r14, long r16, String r18, boolean r19, Map<String, String> r20, d.c.d<? super JobResultWrapper> r21) {
        IntentParams r4 = (IntentParams) ZeusTransformUtils.wrapperContextForParams(r13, IntentParams.class, "com.obric.aiagent.plugin");
        Map<String, String> r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r20, Map.class, "com.obric.aiagent.plugin");
        d.c.d<? super JobResultWrapper> r0 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r21, d.c.d.class, "com.obric.aiagent.plugin");
        Long r2 = d.c.b.a.b.a(r16);
        if (((Number) ZeusTransformUtils.preCheckCast(r2, Number.class, "com.obric.aiagent.plugin")).longValue() == 0) goto L5;
        boolean r3 = true;
    L6:
        if (r3 == true) goto L9;
        r2 = null;
    L9:
        if (r2 == null) goto L11;
        long r5 = r2.longValue();
    L12:
        long r9 = r5;
        b((d.h.a.a) ZeusTransformUtils.preCheckCast(new d(com.obric.capability.schedulekit.e.f31908a.a(r12, r4, r9, r18, r8), r19), d.h.a.a.class, "com.obric.aiagent.plugin"));
        return com.obric.capability.schedulekit.c.f31892a.a(r9, r14, r0);
    L11:
        r5 = UUID.randomUUID().toString().hashCode() & Integer.MAX_VALUE;
        goto L12
    L5:
        r3 = false;
        goto L6
    }

    public final Object a(String r12, String r13, long r14, long r16, String r18, boolean r19, Map<String, String> r20, d.c.d<? super JobResultWrapper> r21) {
        Map<String, String> r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r20, Map.class, "com.obric.aiagent.plugin");
        d.c.d<? super JobResultWrapper> r0 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r21, d.c.d.class, "com.obric.aiagent.plugin");
        Long r2 = d.c.b.a.b.a(r16);
        if (((Number) ZeusTransformUtils.preCheckCast(r2, Number.class, "com.obric.aiagent.plugin")).longValue() == 0) goto L5;
        boolean r3 = true;
    L6:
        if (r3 == true) goto L9;
        r2 = null;
    L9:
        if (r2 == null) goto L11;
        long r4 = r2.longValue();
    L12:
        long r9 = r4;
        b((d.h.a.a) ZeusTransformUtils.preCheckCast(new e(com.obric.capability.schedulekit.e.f31908a.a(r12, r13, r9, r18, r8), r19), d.h.a.a.class, "com.obric.aiagent.plugin"));
        return com.obric.capability.schedulekit.c.f31892a.a(r9, r14, r0);
    L11:
        r4 = UUID.randomUUID().toString().hashCode() & Integer.MAX_VALUE;
        goto L12
    L5:
        r3 = false;
        goto L6
    }

    public final void a(String r2, boolean r3) {
        o.e(r2, "payload");
        b((d.h.a.a) ZeusTransformUtils.preCheckCast(new f(r2, r3), d.h.a.a.class, "com.obric.aiagent.plugin"));
    }

    public final void a(ICapabilityFeedbackReceiver r3) {
        ICapabilityFeedbackReceiver r4 = (ICapabilityFeedbackReceiver) ZeusTransformUtils.wrapperContextForParams(r3, ICapabilityFeedbackReceiver.class, "com.obric.aiagent.plugin");
        o.e(r4, "receiver");
        b((d.h.a.a) ZeusTransformUtils.preCheckCast(new j(r4), d.h.a.a.class, "com.obric.aiagent.plugin"));
    }

    private final void a(InterfaceC0873a r4) {
        InterfaceC0873a r3 = (InterfaceC0873a) ZeusTransformUtils.wrapperContextForParams(r4, InterfaceC0873a.class, "com.obric.aiagent.plugin");
        com.obric.capability.schedulekit.c.c r5 = com.obric.capability.schedulekit.c.c.f31906a;
        String r0 = TAG;
        r5.d(r0, "addPendingCall");
        List<InterfaceC0873a> r6 = f31849d;
        monitor-enter(r6);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (f31850e == false) goto L7;
        com.obric.capability.schedulekit.c.c.f31906a.w(r0, "in addPendingCall: pending-calls have all been executed; this call shall be execute RIGHT AWAY.");     // Catch: Throwable -> L10
        r3.call();     // Catch: Throwable -> L10
        x r7 = x.f38692a;     // Catch: Throwable -> L10
    L8:
        monitor-exit(r6);
        return;
    L7:
        Boolean.valueOf(r6.add(r3));     // Catch: Throwable -> L10
        goto L8
    }

    private final void f() {
        com.obric.capability.schedulekit.c.c.f31906a.d(TAG, "execPendingCalls");
        List<InterfaceC0873a> r5 = f31849d;
        monitor-enter(r5);
        Iterator r0 = ((Iterable) ZeusTransformUtils.preCheckCast(r5, Iterable.class, "com.obric.aiagent.plugin")).iterator();     // Catch: Throwable -> L11
    L6:
        if (r0.hasNext() == false) goto L8;
        InterfaceC0873a r1 = (InterfaceC0873a) ZeusTransformUtils.preCheckCast(r0.next(), InterfaceC0873a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L11
        com.obric.capability.schedulekit.c.c.f31906a.d(TAG, "exec foreach call");     // Catch: Throwable -> L11
        r1.call();     // Catch: Throwable -> L11
        goto L6
    L8:
        f31849d.clear();     // Catch: Throwable -> L11
        f31850e = true;     // Catch: Throwable -> L11
        x r2 = x.f38692a;     // Catch: Throwable -> L11
        monitor-exit(r5);
        return;
    L11:
        th = move-exception;
        throw th;
    }

    public final void a(boolean r1) {
        List<InterfaceC0873a> r0 = f31849d;
        monitor-enter(r0);
        f31850e = r1;     // Catch: Throwable -> L7
        x r2 = x.f38692a;     // Catch: Throwable -> L7
        monitor-exit(r0);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private final void b(d.h.a.a<x> r4) {
        d.h.a.a r5 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.a.class, "com.obric.aiagent.plugin");
        if (o.a(d(), com.obric.capability.schedulekit.b.f31875a) == true) goto L5;
        r5.invoke();
        return;
    L5:
        a((InterfaceC0873a) ZeusTransformUtils.preCheckCast(new c(r5), InterfaceC0873a.class, "com.obric.aiagent.plugin"));
    }

    public final void b() {
        f();
        a(e().b());
    }

    public final Object a(String r5, d.c.d<? super List<AppIntentImplInfo>> r6) {
        d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
        kotlinx.coroutines.o r7 = new kotlinx.coroutines.o(d.c.a.b.a(r4), 1);
        r7.e();
        n r1 = (n) ZeusTransformUtils.preCheckCast(r7, n.class, "com.obric.aiagent.plugin");
        a(f31846a, (d.h.a.a) ZeusTransformUtils.preCheckCast(new i(r5, r1), d.h.a.a.class, "com.obric.aiagent.plugin"));
        Object r8 = r7.h();
        if (r8 != d.c.a.b.a()) goto L5;
        d.c.b.a.h.c(r4);
    L5:
        return r8;
    }
}
