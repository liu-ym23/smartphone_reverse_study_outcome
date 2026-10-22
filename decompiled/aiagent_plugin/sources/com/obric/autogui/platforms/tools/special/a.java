package com.obric.autogui.platforms.tools.special;

import android.content.ComponentName;
import com.obric.aiagent.product.ObricProductSdk;
import com.obric.aiagent.product.platform.api.app.IObricActivityTaskManager;
import com.obric.aiagent.product.platform.api.app.ObricSystemAnimationListener;
import com.obric.autogui.common.api.AOSystemTools;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.platform.special.ActionSystemAnimationMonitor;
import com.obric.autogui.common.api.platform.special.PageSwitchPhase;
import com.obric.autogui.common.api.platform.special.SystemAnimationSnapshot;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.c.b.a.l;
import d.h.a.m;
import d.h.b.h;
import d.h.b.o;
import d.k;
import d.l.n;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicLong;
import kotlinx.coroutines.am;
import kotlinx.coroutines.b.i;
import kotlinx.coroutines.b.j;
import kotlinx.coroutines.b.x;
import kotlinx.coroutines.dg;

/* JADX INFO: compiled from: ActionSystemAnimationMonitorImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a implements ActionSystemAnimationMonitor {
    private static final String TAG = "RuleStability";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f30546a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f30547b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final CopyOnWriteArrayList<SystemAnimationSnapshot> f30548c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final x<c> f30549d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final AtomicLong f30550e;
    private final Object f;
    private final Object g;
    private volatile boolean h;
    private final ObricSystemAnimationListener i;

    /* JADX INFO: renamed from: com.obric.autogui.platforms.tools.special.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ActionSystemAnimationMonitorImpl.kt */
    private static final class C0825a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f30551a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final PageSwitchPhase f30552b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final PageSwitchPhase f30553c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final boolean f30554d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final Integer f30555e;
        private final Integer f;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, C0825a.class) == true) goto L8;
            return false;
        L8:
            C0825a r6 = (C0825a) ZeusTransformUtils.preCheckCast(r5, C0825a.class, "com.obric.aiagent.plugin");
            if (this.f30551a == r6.f30551a) goto L12;
            return false;
        L12:
            if (this.f30552b == r6.f30552b) goto L15;
            return false;
        L15:
            if (this.f30553c == r6.f30553c) goto L18;
            return false;
        L18:
            if (this.f30554d == r6.f30554d) goto L21;
            return false;
        L21:
            if (o.a(this.f30555e, r6.f30555e) == true) goto L24;
            return false;
        L24:
            if (o.a(this.f, r6.f) == true) goto L26;
            return false;
        L26:
            return true;
        }

        public int hashCode() {
            int r0 = ((((((Integer.hashCode(this.f30551a) * 31) + this.f30552b.hashCode()) * 31) + this.f30553c.hashCode()) * 31) + Boolean.hashCode(this.f30554d)) * 31;
            Integer r1 = this.f30555e;
            int r2 = 0;
            if (r1 != null) goto L5;
            int r3 = 0;
        L6:
            int r4 = (r0 + r3) * 31;
            Integer r5 = this.f;
            if (r5 == null) goto L11;
            r2 = r5.hashCode();
        L11:
            return r4 + r2;
        L5:
            r3 = r1.hashCode();
            goto L6
        }

        public String toString() {
            return "CallbackStateTrace(processingSequence=" + this.f30551a + ", previousPhase=" + this.f30552b + ", currentPhase=" + this.f30553c + ", stateAccepted=" + this.f30554d + ", stateTransitionIdBefore=" + this.f30555e + ", stateTransitionIdAfter=" + this.f + ')';
        }

        public C0825a(int r2, PageSwitchPhase r3, PageSwitchPhase r4, boolean r5, Integer r6, Integer r7) {
            o.e(r3, "previousPhase");
            o.e(r4, "currentPhase");
            this.f30551a = r2;
            this.f30552b = r3;
            this.f30553c = r4;
            this.f30554d = r5;
            this.f30555e = r6;
            this.f = r7;
        }

        public final int a() {
            return this.f30551a;
        }

        public final PageSwitchPhase b() {
            return this.f30552b;
        }

        public final PageSwitchPhase c() {
            return this.f30553c;
        }

        public final boolean d() {
            return this.f30554d;
        }

        public final Integer e() {
            return this.f30555e;
        }

        public final Integer f() {
            return this.f;
        }
    }

    /* JADX INFO: compiled from: ActionSystemAnimationMonitorImpl.kt */
    public static final class b {
        public /* synthetic */ b(h r1) {
            this();
        }

        private b() {
        }

        public final a a(String r2) {
            o.e(r2, "stepId");
            a r1 = new a(r2, null);
            if (a.a(r1) == false) goto L6;
            return r1;
        L6:
            return null;
        }
    }

    /* JADX INFO: compiled from: ActionSystemAnimationMonitorImpl.kt */
    private static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final PageSwitchPhase f30556a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final SystemAnimationSnapshot f30557b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final boolean f30558c;

        public c() {
            this(null, null, false, 7, null);
        }

        public static /* synthetic */ c a(c r0, PageSwitchPhase r1, SystemAnimationSnapshot r2, boolean r3, int r4, Object r5) {
            if ((r4 & 1) == 0) goto L6;
            r1 = r0.f30556a;
        L6:
            if ((r4 & 2) == 0) goto L9;
            r2 = r0.f30557b;
        L9:
            if ((r4 & 4) == 0) goto L12;
            r3 = r0.f30558c;
        L12:
            return r0.a(r1, r2, r3);
        }

        public final c a(PageSwitchPhase r1, SystemAnimationSnapshot r2, boolean r3) {
            o.e(r1, "phase");
            return new c(r1, r2, r3);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, c.class) == true) goto L8;
            return false;
        L8:
            c r6 = (c) ZeusTransformUtils.preCheckCast(r5, c.class, "com.obric.aiagent.plugin");
            if (this.f30556a == r6.f30556a) goto L12;
            return false;
        L12:
            if (o.a(this.f30557b, r6.f30557b) == true) goto L15;
            return false;
        L15:
            if (this.f30558c == r6.f30558c) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            int r0 = this.f30556a.hashCode() * 31;
            SystemAnimationSnapshot r1 = this.f30557b;
            if (r1 != null) goto L5;
            int r2 = 0;
        L7:
            return ((r0 + r2) * 31) + Boolean.hashCode(this.f30558c);
        L5:
            r2 = r1.hashCode();
            goto L7
        }

        public String toString() {
            return "PageSwitchState(phase=" + this.f30556a + ", latestSnapshot=" + this.f30557b + ", hasStarted=" + this.f30558c + ')';
        }

        public c(PageSwitchPhase r2, SystemAnimationSnapshot r3, boolean r4) {
            o.e(r2, "phase");
            this.f30556a = r2;
            this.f30557b = r3;
            this.f30558c = r4;
        }

        public /* synthetic */ c(PageSwitchPhase r1, SystemAnimationSnapshot r2, boolean r3, int r4, h r5) {
            if ((r4 & 1) == 0) goto L6;
            r1 = PageSwitchPhase.NotStarted;
        L6:
            if ((r4 & 2) == 0) goto L9;
            r2 = null;
        L9:
            if ((r4 & 4) == 0) goto L11;
            r3 = false;
        L11:
            this(r1, r2, r3);
        }

        public final PageSwitchPhase a() {
            return this.f30556a;
        }

        public final SystemAnimationSnapshot b() {
            return this.f30557b;
        }

        public final boolean c() {
            return this.f30558c;
        }
    }

    /* JADX INFO: compiled from: ActionSystemAnimationMonitorImpl.kt */
    public /* synthetic */ class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f30559a = null;

        static {
            int[] r0 = new int[SystemAnimationSnapshot.Event.values().length];
            r0[SystemAnimationSnapshot.Event.Pending.ordinal()] = 1;     // Catch: NoSuchFieldError -> L13
        L23:
            r0[SystemAnimationSnapshot.Event.Launch.ordinal()] = 2;     // Catch: NoSuchFieldError -> L14
        L35:
            r0[SystemAnimationSnapshot.Event.Finished.ordinal()] = 3;     // Catch: NoSuchFieldError -> L15
        L25:
            r0[SystemAnimationSnapshot.Event.Cancelled.ordinal()] = 4;     // Catch: NoSuchFieldError -> L16
        L27:
            r0[SystemAnimationSnapshot.Event.Baseline.ordinal()] = 5;     // Catch: NoSuchFieldError -> L17
        L21:
            r0[SystemAnimationSnapshot.Event.Started.ordinal()] = 6;     // Catch: NoSuchFieldError -> L18
        L29:
            r0[SystemAnimationSnapshot.Event.TakeOver.ordinal()] = 7;     // Catch: NoSuchFieldError -> L19
        L31:
            r0[SystemAnimationSnapshot.Event.Unknown.ordinal()] = 8;     // Catch: NoSuchFieldError -> L20
        L11:
            f30559a = r0;
        }
    }

    /* JADX INFO: compiled from: ActionSystemAnimationMonitorImpl.kt */
    @d.c.b.a.f(b = "ActionSystemAnimationMonitorImpl.kt", c = {77}, d = "invokeSuspend", e = "com.obric.autogui.platforms.tools.special.ActionSystemAnimationMonitorImpl$awaitReady$4")
    static final class e extends l implements m<am, d.c.d<? super SystemAnimationSnapshot>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f30560a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ a f30561b;

        /* JADX INFO: renamed from: com.obric.autogui.platforms.tools.special.a$e$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SafeCollector.common.kt */
        public static final class C0826a implements kotlinx.coroutines.b.h<c> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ kotlinx.coroutines.b.h f30562a;

            /* JADX INFO: renamed from: com.obric.autogui.platforms.tools.special.a$e$a$1, reason: invalid class name */
            /* JADX INFO: compiled from: Emitters.kt */
            public static final class AnonymousClass1<T> implements i {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                final /* synthetic */ i f30563a;

                /* JADX INFO: renamed from: com.obric.autogui.platforms.tools.special.a$e$a$1$1, reason: invalid class name and collision with other inner class name */
                /* JADX INFO: compiled from: Emitters.kt */
                @d.c.b.a.f(b = "ActionSystemAnimationMonitorImpl.kt", c = {219}, d = "emit", e = "com.obric.autogui.platforms.tools.special.ActionSystemAnimationMonitorImpl$awaitReady$4$invokeSuspend$$inlined$filter$1$2")
                public static final class C08271 extends d.c.b.a.d {

                    /* JADX INFO: renamed from: a, reason: collision with root package name */
                    /* synthetic */ Object f30564a;

                    /* JADX INFO: renamed from: b, reason: collision with root package name */
                    int f30565b;

                    /* JADX INFO: renamed from: c, reason: collision with root package name */
                    final /* synthetic */ AnonymousClass1 f30566c;

                    public C08271(AnonymousClass1 r3, d.c.d r4) {
                        d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                        this.f30566c = r3;
                        super(r5);
                    }

                    @Override // d.c.b.a.a
                    public final Object invokeSuspend(Object r3) {
                        this.f30564a = r3;
                        this.f30565b |= Integer.MIN_VALUE;
                        return this.f30566c.emit(null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
                    }
                }

                public AnonymousClass1(i r3) {
                    this.f30563a = (i) ZeusTransformUtils.wrapperContextForParams(r3, i.class, "com.obric.aiagent.plugin");
                }

                @Override // kotlinx.coroutines.b.i
                public final Object emit(Object r6, d.c.d r7) {
                    d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r7, d.c.d.class, "com.obric.aiagent.plugin");
                    if (ZeusTransformUtils.instanceOf(r8, C08271.class) == false) goto L7;
                    C08271 r0 = (C08271) ZeusTransformUtils.preCheckCast(r8, C08271.class, "com.obric.aiagent.plugin");
                    if ((r0.f30565b & Integer.MIN_VALUE) == 0) goto L7;
                    r0.f30565b -= Integer.MIN_VALUE;
                L8:
                    Object r9 = r0.f30564a;
                    Object r2 = d.c.a.b.a();
                    int r3 = r0.f30565b;
                    if (r3 == 0) goto L14;
                    if (r3 != 1) goto L13;
                    d.o.a(r9);
                L23:
                    return d.x.f38692a;
                L13:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                L14:
                    d.o.a(r9);
                    i r5 = this.f30563a;
                    d.c.d r10 = (d.c.d) ZeusTransformUtils.preCheckCast(r0, d.c.d.class, "com.obric.aiagent.plugin");
                    if (((c) ZeusTransformUtils.preCheckCast(r6, c.class, "com.obric.aiagent.plugin")).a() != PageSwitchPhase.Ended) goto L17;
                    boolean r11 = true;
                L18:
                    if (r11 == false) goto L23;
                    r0.f30565b = 1;
                    if (r5.emit(r6, r0) != r2) goto L23;
                    return r2;
                L17:
                    r11 = false;
                L7:
                    r0 = new C08271(this, r8);
                    goto L8
                }
            }

            public C0826a(kotlinx.coroutines.b.h r3) {
                this.f30562a = (kotlinx.coroutines.b.h) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.b.h.class, "com.obric.aiagent.plugin");
            }

            @Override // kotlinx.coroutines.b.h
            public Object collect(i<? super c> r3, d.c.d r4) {
                i r5 = (i) ZeusTransformUtils.wrapperContextForParams(r3, i.class, "com.obric.aiagent.plugin");
                d.c.d<? super d.x> r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                Object r2 = this.f30562a.collect((i) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r5), i.class, "com.obric.aiagent.plugin"), r6);
                if (r2 != d.c.a.b.a()) goto L6;
                return r2;
            L6:
                return d.x.f38692a;
            }
        }

        e(a r3, d.c.d<? super e> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f30561b = r3;
            super(2, r5);
        }

        public final Object a(am r3, d.c.d<? super SystemAnimationSnapshot> r4) {
            return ((e) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), e.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new e(this.f30561b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super SystemAnimationSnapshot> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r5) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f30560a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r5);
        L12:
            return ((c) ZeusTransformUtils.preCheckCast(r5, c.class, "com.obric.aiagent.plugin")).b();
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r5);
            kotlinx.coroutines.b.h r6 = (kotlinx.coroutines.b.h) ZeusTransformUtils.preCheckCast(new C0826a((kotlinx.coroutines.b.h) ZeusTransformUtils.preCheckCast(a.b(this.f30561b), kotlinx.coroutines.b.h.class, "com.obric.aiagent.plugin")), kotlinx.coroutines.b.h.class, "com.obric.aiagent.plugin");
            d.c.d r2 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f30560a = 1;
            r5 = j.b(r6, r2);
            if (r5 != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: compiled from: ActionSystemAnimationMonitorImpl.kt */
    public static final class f extends ObricSystemAnimationListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ a f30567a;

        f(a r1) {
            this.f30567a = r1;
        }

        @Override // com.obric.aiagent.product.platform.api.app.ObricSystemAnimationListener
        public void onSystemAnimationStateChanged(int r18, boolean r19, int r20, int r21, ComponentName r22, ComponentName[] r23, int[] r24) {
            long r13 = a.c(this.f30567a).incrementAndGet();
            long r10 = AOSystemTools.INSTANCE.nowTimeMillis();
            SystemAnimationSnapshot.Event r3 = SystemAnimationSnapshot.Event.Companion.fromRawValue(r18);
            Boolean r16 = null;
            if (r23 == null) goto L5;
            List r2 = d.a.i.g(r23);
        L6:
            if (r2 != null) goto L8;
            r2 = p.b();
        L8:
            List r8 = r2;
            if (r24 == null) goto L11;
            List<Integer> r4 = d.a.i.f(r24);
        L12:
            if (r4 != null) goto L14;
            r4 = p.b();
        L14:
            SystemAnimationSnapshot r15 = new SystemAnimationSnapshot(r3, r19, r20, r21, r22, r8, r4, r10);
            C0825a r5 = a.a(this.f30567a, r15);
            Loog r6 = Loog.INSTANCE;
            StringBuilder r7 = new StringBuilder();
            StringBuilder r0 = r7.append("[RuleStability] callback stepId=").append(this.f30567a.getStepId()).append(", arrivalSeq=").append(r13).append(", processingSeq=").append(r5.a()).append(", event=").append(r15.getEvent()).append(", rawEvent=").append(r18).append(", phase=").append(r5.b()).append("->").append(r5.c()).append(", stateAccepted=").append(r5.d()).append(", stateTransitionIdBefore=").append(r5.e()).append(", stateTransitionIdAfter=").append(r5.f()).append(", matchesPreviousTransition=");
            Integer r1 = r5.e();
            if (r1 != null) goto L17;
        L21:
            r0.append(r16).append(", receivedAtMillis=");
            r7.append(r15.getReceivedAtMillis()).append(", thread=").append(Thread.currentThread().getName()).append(", stillAnimating=").append(r19).append(", top=").append(r22).append(", transitType=").append(r20).append(", transitionId=").append(r21).append(", involved=").append(r15.getInvolvedActivities().size());
            r6.i("RuleStability", r7.toString());
            return;
        L17:
            if (((Number) ZeusTransformUtils.preCheckCast(r1, Number.class, "com.obric.aiagent.plugin")).intValue() != r21) goto L19;
            boolean r9 = true;
        L20:
            r16 = Boolean.valueOf(r9);
            goto L21
        L19:
            r9 = false;
            goto L20
        L11:
            r4 = null;
            goto L12
        L5:
            r2 = null;
            goto L6
        }
    }

    static {
        f30546a = new b(null);
    }

    public /* synthetic */ a(String r1, h r2) {
        this(r1);
    }

    private a(String r7) {
        this.f30547b = r7;
        this.f30548c = new CopyOnWriteArrayList();
        this.f30549d = kotlinx.coroutines.b.am.a(new c(null, null, false, 7, null));
        this.f30550e = new AtomicLong(0);
        this.f = new Object();
        this.g = new Object();
        this.i = c();
    }

    public static final /* synthetic */ C0825a a(a r0, SystemAnimationSnapshot r1) {
        return r0.a(r1);
    }

    public static final /* synthetic */ boolean a(a r0) {
        return r0.b();
    }

    public static final /* synthetic */ x b(a r0) {
        return r0.f30549d;
    }

    public static final /* synthetic */ AtomicLong c(a r0) {
        return r0.f30550e;
    }

    @Override // com.obric.autogui.common.api.platform.special.ActionSystemAnimationMonitor
    public String getStepId() {
        return this.f30547b;
    }

    private final IObricActivityTaskManager a() {
        return ObricProductSdk.INSTANCE.platformService().activityTaskManager();
    }

    @Override // com.obric.autogui.common.api.platform.special.ActionSystemAnimationMonitor
    public List<SystemAnimationSnapshot> snapshots() {
        return p.o((Iterable) ZeusTransformUtils.preCheckCast(this.f30548c, Iterable.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.obric.autogui.common.api.platform.special.ActionSystemAnimationMonitor
    public PageSwitchPhase pageSwitchPhase() {
        return ((c) ZeusTransformUtils.preCheckCast(this.f30549d.c(), c.class, "com.obric.aiagent.plugin")).a();
    }

    @Override // com.obric.autogui.common.api.platform.special.ActionSystemAnimationMonitor
    public boolean hasPageSwitchStarted() {
        return ((c) ZeusTransformUtils.preCheckCast(this.f30549d.c(), c.class, "com.obric.aiagent.plugin")).c();
    }

    @Override // com.obric.autogui.common.api.platform.special.ActionSystemAnimationMonitor
    public SystemAnimationSnapshot latestPageSwitchSnapshot() {
        return ((c) ZeusTransformUtils.preCheckCast(this.f30549d.c(), c.class, "com.obric.aiagent.plugin")).b();
    }

    @Override // com.obric.autogui.common.api.platform.special.ActionSystemAnimationMonitor
    public Object awaitReady(long r7, d.c.d<? super SystemAnimationSnapshot> r9) {
        d.c.d r10 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r9, d.c.d.class, "com.obric.aiagent.plugin");
        c r0 = this.f30549d.c();
        if (((c) ZeusTransformUtils.preCheckCast(r0, c.class, "com.obric.aiagent.plugin")).a() != PageSwitchPhase.Ended) goto L5;
        boolean r2 = true;
    L7:
        if (r2 == true) goto L10;
        r0 = null;
    L10:
        c r1 = (c) ZeusTransformUtils.preCheckCast(r0, c.class, "com.obric.aiagent.plugin");
        if (r1 == null) goto L16;
        SystemAnimationSnapshot r3 = r1.b();
        if (r3 == null) goto L16;
        return r3;
    L16:
        return dg.b(n.a(r7, 0), (m) ZeusTransformUtils.preCheckCast(new e(this, null), m.class, "com.obric.aiagent.plugin"), r10);
    L5:
        r2 = false;
        goto L7
    }

    @Override // com.obric.autogui.common.api.platform.special.ActionSystemAnimationMonitor
    public boolean unregister() {
        Object r0 = this.g;
        monitor-enter(r0);
    L23:
        th = move-exception;
        throw th;
    L5:
        if (this.h == false) goto L7;
        d.n.a r1 = d.n.f38560a;     // Catch: Throwable -> L11
        a r2 = (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L11
        Object r3 = d.n.f(Boolean.valueOf(r2.a().unregisterSystemAnimationListener(r2.i)));     // Catch: Throwable -> L11
    L13:
        Throwable r4 = d.n.c(r3);     // Catch: Throwable -> L23
        if (r4 == null) goto L17;
        Loog.INSTANCE.e("RuleStability", "[RuleStability] unregister failed, stepId=" + getStepId(), r4);     // Catch: Throwable -> L23
        r3 = false;     // Catch: Throwable -> L23
    L17:
        boolean r5 = ((Boolean) ZeusTransformUtils.preCheckCast(r3, Boolean.class, "com.obric.aiagent.plugin")).booleanValue();     // Catch: Throwable -> L23
        if (r5 == false) goto L20;
        this.h = false;     // Catch: Throwable -> L23
    L20:
        Loog.INSTANCE.i("RuleStability", "[RuleStability] unregister result=" + r5 + ", stepId=" + getStepId() + ", callbackCount=" + this.f30548c.size());     // Catch: Throwable -> L23
        monitor-exit(r0);
        return r5;
    L11:
        th = move-exception;
        d.n.a r6 = d.n.f38560a;     // Catch: Throwable -> L23
        r3 = d.n.f(d.o.a(th));     // Catch: Throwable -> L23
        goto L13
    L7:
        monitor-exit(r0);
        return true;
    }

    private final boolean b() {
        Object r0 = this.g;
        monitor-enter(r0);
    L20:
        th = move-exception;
        throw th;
    L5:
        if (this.h == true) goto L7;
        d.n.a r1 = d.n.f38560a;     // Catch: Throwable -> L11
        a r2 = (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L11
        Object r3 = d.n.f(Boolean.valueOf(r2.a().registerSystemAnimationListener(r2.i)));     // Catch: Throwable -> L11
    L13:
        Throwable r4 = d.n.c(r3);     // Catch: Throwable -> L20
        if (r4 == null) goto L17;
        Loog.INSTANCE.e("RuleStability", "[RuleStability] register failed, stepId=" + getStepId(), r4);     // Catch: Throwable -> L20
        r3 = false;     // Catch: Throwable -> L20
    L17:
        boolean r5 = ((Boolean) ZeusTransformUtils.preCheckCast(r3, Boolean.class, "com.obric.aiagent.plugin")).booleanValue();     // Catch: Throwable -> L20
        this.h = r5;     // Catch: Throwable -> L20
        Loog.INSTANCE.i("RuleStability", "[RuleStability] register result=" + r5 + ", stepId=" + getStepId());     // Catch: Throwable -> L20
        monitor-exit(r0);
        return r5;
    L11:
        th = move-exception;
        d.n.a r6 = d.n.f38560a;     // Catch: Throwable -> L20
        r3 = d.n.f(d.o.a(th));     // Catch: Throwable -> L20
        goto L13
    L7:
        monitor-exit(r0);
        return true;
    }

    private final C0825a a(SystemAnimationSnapshot r15) {
        Object r0 = this.f;
        monitor-enter(r0);
        this.f30548c.add(r15);     // Catch: Throwable -> L44
        c r1 = (c) ZeusTransformUtils.preCheckCast(this.f30549d.c(), c.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L44
        Integer r5 = null;
        switch(d.f30559a[r15.getEvent().ordinal()]) {
            case 1: goto L18;
            case 2: goto L18;
            case 3: goto L9;
            case 4: goto L9;
            case 5: goto L7;
            case 6: goto L7;
            case 7: goto L7;
            case 8: goto L7;
            default: goto L43;
        };     // Catch: Throwable -> L44
    L7:
        c r16 = null;
    L26:
        if (r16 == null) goto L28;
        this.f30549d.b(r16);     // Catch: Throwable -> L44
    L28:
        c r2 = (c) ZeusTransformUtils.preCheckCast(this.f30549d.c(), c.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L44
        int r7 = this.f30548c.size();     // Catch: Throwable -> L44
        PageSwitchPhase r8 = r1.a();     // Catch: Throwable -> L44
        PageSwitchPhase r9 = r2.a();     // Catch: Throwable -> L44
        if (r16 == null) goto L31;
        boolean r10 = true;
    L32:
        SystemAnimationSnapshot r14 = r1.b();     // Catch: Throwable -> L44
        if (r14 == null) goto L35;
        Integer r11 = Integer.valueOf(r14.getTransitionId());     // Catch: Throwable -> L44
    L36:
        SystemAnimationSnapshot r17 = r2.b();     // Catch: Throwable -> L44
        if (r17 == null) goto L39;
        r5 = Integer.valueOf(r17.getTransitionId());     // Catch: Throwable -> L44
    L39:
        C0825a r13 = new C0825a(r7, r8, r9, r10, r11, r5);     // Catch: Throwable -> L44
        monitor-exit(r0);
        return r13;
    L35:
        r11 = null;
        goto L36
    L31:
        r10 = false;
        goto L32
    L43:
        throw new k();     // Catch: Throwable -> L44
    L9:
        if (r1.a() != PageSwitchPhase.InProgress) goto L11;
        boolean r3 = true;
    L12:
        if (r3 == false) goto L14;
        c r6 = r1;
    L15:
        if (r6 == null) goto L7;
        r16 = c.a(r6, PageSwitchPhase.Ended, r15, false, 4, null);     // Catch: Throwable -> L44
        goto L26
    L14:
        r6 = null;
        goto L15
    L11:
        r3 = false;
        goto L12
    L18:
        if (r1.a() == PageSwitchPhase.Ended) goto L20;
        boolean r4 = true;
    L21:
        if (r4 == false) goto L23;
        c r12 = r1;
    L24:
        if (r12 == null) goto L7;
        r16 = r12.a(PageSwitchPhase.InProgress, r15, true);     // Catch: Throwable -> L44
        goto L26
    L23:
        r12 = null;
        goto L24
    L20:
        r4 = false;
    L44:
        th = move-exception;
        throw th;
    }

    private final ObricSystemAnimationListener c() {
        return (ObricSystemAnimationListener) ZeusTransformUtils.preCheckCast(new f(this), ObricSystemAnimationListener.class, "com.obric.aiagent.plugin");
    }
}
