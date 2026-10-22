package com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.c.a;

import android.app.Application;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.HandlerThread;
import android.os.Looper;
import com.obric.aiagent.platform.depend.IAppContext;
import com.obric.cae.libs.location.CoordinateTransformUtils;
import com.obric.eventkit.task.model.LocationCondition;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.am;
import kotlinx.coroutines.an;
import kotlinx.coroutines.ao;
import kotlinx.coroutines.ax;
import kotlinx.coroutines.ca;

/* JADX INFO: compiled from: LocationMonitorCoordinator.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class h {
    private static final String TAG = "LocationMonitorCoordinator";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f17121a = null;
    private static final AtomicBoolean f = null;
    private static volatile h g;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final j f17122b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final am f17123c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final long f17124d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final ConcurrentHashMap<String, b> f17125e;

    /* JADX INFO: compiled from: LocationMonitorCoordinator.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        /* JADX INFO: renamed from: lambda$2tH0oCMbWkKSOf7P2nr-KPNoOzo, reason: not valid java name */
        public static /* synthetic */ void m167lambda$2tH0oCMbWkKSOf7P2nrKPNoOzo(a r0, h r1, Location r2) {
            a(r0, r1, r2);
        }

        private a() {
        }

        public final h a() {
            return h.a();
        }

        public final void b() {
            if (h.b().compareAndSet(false, true) == true) goto L5;
            return;
        L5:
            HandlerThread r2 = null;
            d.n.a r4 = d.n.f38560a;     // Catch: Throwable -> L15
            final a r13 = (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L15
            Application r5 = (Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L15
            if (com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.b.c.a() == true) goto L10;
            com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.b(h.TAG, "launchLocationMonitorIfNeeded location permission not granted");     // Catch: Throwable -> L15
            h.b().set(false);     // Catch: Throwable -> L15
            return;
        L10:
            final h r12 = new h(null, null, 0, 7, null);     // Catch: Throwable -> L15
            Object r6 = r5.getSystemService("location");     // Catch: Throwable -> L15
            d.h.b.o.a(r6, "null cannot be cast to non-null type android.location.LocationManager");     // Catch: Throwable -> L15
            LocationManager r7 = (LocationManager) ZeusTransformUtils.preCheckCast(r6, LocationManager.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L15
            HandlerThread r1 = new HandlerThread("location-monitor-thread");     // Catch: Throwable -> L15
            r1.start();     // Catch: Throwable -> L15
            a(r7, "passive", 0, 0.0f, new $$Lambda$h$a$2tH0oCMbWkKSOf7P2nrKPNoOzo(r13, r12), r1.getLooper());     // Catch: Throwable -> L13
            h.a(r12);     // Catch: Throwable -> L13
            com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.b(h.TAG, "launchLocationMonitorIfNeeded success");     // Catch: Throwable -> L13
            Object r14 = d.n.f(d.x.f38692a);     // Catch: Throwable -> L13
        L17:
            Throwable r15 = d.n.c(r14);
            if (r15 == null) goto L26;
            if (r1 == null) goto L21;
            r1.quitSafely();
        L21:
            h.b().set(false);
            com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.d(h.TAG, "launchLocationMonitorIfNeeded failed " + r15.getMessage());
            com.obric.event.task.base.report.e.f32759a.a(h.TAG, "launchLocationMonitorIfNeeded failed " + r15.getMessage());
            return;
        L26:
            return;
        L13:
            th = th;
            r2 = r1;
        L16:
            d.n.a r3 = d.n.f38560a;
            r14 = d.n.f(d.o.a(th));
            r1 = r2;
        L15:
            th = th;
            goto L16
        }

        private static final void a(a r2, h r3, Location r4) {
            d.h.b.o.e(r4, "location");
            d.n.a r0 = d.n.f38560a;     // Catch: Throwable -> L5
            r3.a(r2.a(r4));     // Catch: Throwable -> L5
            Object r5 = d.n.f(d.x.f38692a);     // Catch: Throwable -> L5
        L7:
            Throwable r6 = d.n.c(r5);
            if (r6 == null) goto L13;
            com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.d(h.TAG, "onLocationFrame failed " + r6.getMessage());
            com.obric.event.task.base.report.e.f32759a.a(h.TAG, "onLocationFrame failed " + r6.getMessage());
            return;
        L13:
            return;
        L5:
            th = move-exception;
            d.n.a r7 = d.n.f38560a;
            r5 = d.n.f(d.o.a(th));
            goto L7
        }

        private final n a(Location r13) {
            com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.a(h.TAG, "location frame time=" + r13.getTime() + " provider=" + r13.getProvider() + " accuracy=" + r13.getAccuracy() + " speed=" + r13.getSpeed());
            Long r12 = Long.valueOf(r13.getTime());
            if (((Number) ZeusTransformUtils.preCheckCast(r12, Number.class, "com.obric.aiagent.plugin")).longValue() <= 0) goto L5;
            boolean r0 = true;
        L6:
            if (r0 == true) goto L9;
            r12 = null;
        L9:
            if (r12 == null) goto L11;
            long r1 = r12.longValue();
        L12:
            long r3 = r1;
            if (r13.hasSpeed() == false) goto L15;
            float r5 = Math.abs(r13.getSpeed());
        L17:
            if (r13.hasAccuracy() == false) goto L19;
            float r6 = r13.getAccuracy();
        L20:
            double r7 = r13.getLongitude();
            double r9 = r13.getLatitude();
            String r14 = r13.getProvider();
            if (r14 != null) goto L24;
            r14 = "";
        L24:
            return new n(r3, r5, r6, r7, r9, r14);
        L19:
            r6 = -1.0f;
            goto L20
        L15:
            r5 = -1.0f;
            goto L17
        L11:
            r1 = System.currentTimeMillis();
            goto L12
        L5:
            r0 = false;
            goto L6
        }

        public static void a(LocationManager r7, String r8, long r9, float r11, LocationListener r12, Looper r13) {
            LocationListener r14 = (LocationListener) ZeusTransformUtils.wrapperContextForParams(r12, LocationListener.class, "com.obric.aiagent.plugin");
            if (com.obric.performance.power.monitor.a.f36932a.a() == true) goto L6;
            r7.requestLocationUpdates(r8, r9, r11, r14, r13);
            return;
        L6:
            r7.requestLocationUpdates(r8, r9, r11, r14, r13);
            com.obric.performance.power.monitor.g.a.b(r14.hashCode());
        }
    }

    /* JADX INFO: compiled from: LocationMonitorCoordinator.kt */
    private static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ae f17126a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long f17127b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final ca f17128c;

        public boolean equals(Object r9) {
            if (this != r9) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r9, b.class) == true) goto L8;
            return false;
        L8:
            b r10 = (b) ZeusTransformUtils.preCheckCast(r9, b.class, "com.obric.aiagent.plugin");
            if (d.h.b.o.a(this.f17126a, r10.f17126a) == true) goto L12;
            return false;
        L12:
            if (this.f17127b == r10.f17127b) goto L15;
            return false;
        L15:
            if (d.h.b.o.a(this.f17128c, r10.f17128c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            return (((this.f17126a.hashCode() * 31) + Long.hashCode(this.f17127b)) * 31) + this.f17128c.hashCode();
        }

        public String toString() {
            return "PendingReport(window=" + this.f17126a + ", targetReportTime=" + this.f17127b + ", job=" + this.f17128c + ')';
        }

        public b(ae r3, long r4, ca r6) {
            ca r7 = (ca) ZeusTransformUtils.wrapperContextForParams(r6, ca.class, "com.obric.aiagent.plugin");
            d.h.b.o.e(r3, "window");
            d.h.b.o.e(r7, "job");
            this.f17126a = r3;
            this.f17127b = r4;
            this.f17128c = r7;
        }

        public final ae a() {
            return this.f17126a;
        }

        public final long b() {
            return this.f17127b;
        }

        public final ca c() {
            return this.f17128c;
        }
    }

    /* JADX INFO: compiled from: LocationMonitorCoordinator.kt */
    @d.c.b.a.f(b = "LocationMonitorCoordinator.kt", c = {127}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.handler.location.monitor.LocationMonitorCoordinator$scheduleDelayedReport$job$1")
    static final class c extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f17129a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ long f17130b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ h f17131c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ ae f17132d;

        c(long r3, h r5, ae r6, d.c.d<? super c> r7) {
            d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r7, d.c.d.class, "com.obric.aiagent.plugin");
            this.f17130b = r3;
            this.f17131c = r5;
            this.f17132d = r6;
            super(2, r8);
        }

        public final Object a(am r3, d.c.d<? super d.x> r4) {
            return ((c) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), c.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r8, d.c.d<?> r9) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r9, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new c(this.f17130b, this.f17131c, this.f17132d, r6), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super d.x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r6) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f17129a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r6);
        L11:
            h.a(this.f17131c, this.f17132d.a(), "delay_job");
            return d.x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r6);
            long r3 = this.f17130b;
            d.c.d r7 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f17129a = 1;
            if (ax.a(r3, r7) != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: compiled from: CoroutineExceptionHandler.kt */
    public static final class d extends d.c.a implements CoroutineExceptionHandler {
        public d(CoroutineExceptionHandler.a r3) {
            super((d.c.g.c) ZeusTransformUtils.preCheckCast(r3, d.c.g.c.class, "com.obric.aiagent.plugin"));
        }

        @Override // kotlinx.coroutines.CoroutineExceptionHandler
        public void handleException(d.c.g r3, Throwable r4) {
            d.c.g r2 = (d.c.g) ZeusTransformUtils.wrapperContextForParams(r3, d.c.g.class, "com.obric.aiagent.plugin");
            com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.d(h.TAG, "scope coroutineExceptionHandler " + r4.getMessage());
            com.obric.event.task.base.report.e.f32759a.a(h.TAG, "scope coroutineExceptionHandler " + r4.getMessage());
        }
    }

    public h() {
        this(null, null, 0, 7, null);
    }

    public h(j r3, am r4, long r5) {
        am r6 = (am) ZeusTransformUtils.wrapperContextForParams(r4, am.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "frameBuffer");
        d.h.b.o.e(r6, "scope");
        this.f17122b = r3;
        this.f17123c = r6;
        this.f17124d = r5;
        this.f17125e = new ConcurrentHashMap();
    }

    public static final /* synthetic */ h a() {
        return g;
    }

    public static final /* synthetic */ void a(h r0) {
        g = r0;
    }

    public static final /* synthetic */ void a(h r0, String r1, String r2) {
        r0.a(r1, r2);
    }

    public static final /* synthetic */ AtomicBoolean b() {
        return f;
    }

    public /* synthetic */ h(j r4, am r5, long r6, int r8, d.h.b.h r9) {
        am r7 = (am) ZeusTransformUtils.wrapperContextForParams(r5, am.class, "com.obric.aiagent.plugin");
        if ((r8 & 1) == 0) goto L6;
        r4 = new j(0, 0, 3, null);
    L6:
        if ((r8 & 2) == 0) goto L9;
        r7 = an.a(com.obric.aiagent.executionengine.eventstaskmanager.common.a.f16677a.c().plus((d.c.g) ZeusTransformUtils.preCheckCast((CoroutineExceptionHandler) ZeusTransformUtils.preCheckCast(new d(CoroutineExceptionHandler.f38768a), CoroutineExceptionHandler.class, "com.obric.aiagent.plugin"), d.c.g.class, "com.obric.aiagent.plugin")));
    L9:
        if ((r8 & 4) == 0) goto L11;
        r6 = 600000;
    L11:
        this(r4, r7, r6);
    }

    static {
        f17121a = new a(null);
        f = new AtomicBoolean(false);
    }

    public final void a(n r7) {
        d.h.b.o.e(r7, "frame");
        this.f17122b.a(r7);
        Iterator r0 = ((Iterable) ZeusTransformUtils.preCheckCast(this.f17122b.b(r7), Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ae r1 = (ae) ZeusTransformUtils.preCheckCast(r0.next(), ae.class, "com.obric.aiagent.plugin");
        com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.b(TAG, "resolved trigger window taskId=" + r1.a() + " triggerResult=" + r1.f());
        a(r1);
        goto L4
    L6:
        b(r7);
    }

    public final void a(String r10, LocationCondition r11, long r12, int r14) {
        d.h.b.o.e(r10, DBDefinition.TASK_ID);
        d.h.b.o.e(r11, "condition");
        com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.b(TAG, "onLocationTrigger taskId=" + r10 + " triggerTime=" + r12 + " triggerResult=" + r14);
        this.f17122b.a(r10, a(r11), r12, r14);
    }

    private final void a(ae r17) {
        b r0 = (b) ZeusTransformUtils.preCheckCast(this.f17125e.remove(r17.a()), b.class, "com.obric.aiagent.plugin");
        if (r0 == null) goto L7;
        ca r1 = r0.c();
        if (r1 == null) goto L7;
        ca.a.a(r1, null, 1, null);
    L7:
        long r8 = r17.c().a() + this.f17124d;
        long r10 = d.l.n.a(r8 - System.currentTimeMillis(), 0);
        ca r2 = kotlinx.coroutines.i.a(this.f17123c, null, ao.f38852b, (d.h.a.m) ZeusTransformUtils.preCheckCast(new c(r10, this, r17, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 1, null);
        ((Map) ZeusTransformUtils.preCheckCast(this.f17125e, Map.class, "com.obric.aiagent.plugin")).put(r17.a(), new b(r17, r8, r2));
        com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.b(TAG, "schedule delayed report taskId=" + r17.a() + " targetReportTime=" + r8 + " remainingDelayMs=" + r10);
        r2.s_();
    }

    private final void b(n r11) {
        Collection<b> r0 = this.f17125e.values();
        d.h.b.o.c(r0, "<get-values>(...)");
        Iterable r1 = (Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.aiagent.plugin");
        Collection r2 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r3 = r1.iterator();
    L3:
        boolean r4 = true;
        if (r3.hasNext() == false) goto L11;
        Object r5 = r3.next();
        if (r11.a() >= ((b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.aiagent.plugin")).b()) goto L9;
        r4 = false;
    L9:
        if (r4 == false) goto L3;
        r2.add(r5);
        goto L3
    L11:
        Iterator r6 = ((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L13:
        if (r6.hasNext() == false) goto L17;
        b r7 = (b) ZeusTransformUtils.preCheckCast(r6.next(), b.class, "com.obric.aiagent.plugin");
        if (this.f17125e.remove(r7.a().a(), r7) == false) goto L13;
        ca.a.a(r7.c(), null, 1, null);
        com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.b(TAG, "report pending by location frame taskId=" + r7.a().a() + " frameTime=" + r11.a() + " targetReportTime=" + r7.b());
        b(r7.a());
        goto L13
    }

    private final void a(String r5, String r6) {
        b r0 = (b) ZeusTransformUtils.preCheckCast(this.f17125e.remove(r5), b.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L5;
        return;
    L5:
        com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.b(TAG, "report pending taskId=" + r5 + " reason=" + r6 + " targetReportTime=" + r0.b());
        b(r0.a());
    }

    private final void b(ae r5) {
        ae r0 = this.f17122b.a(r5.a(), r5, false);
        if (r0 != null) goto L5;
        return;
    L5:
        com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.b(TAG, "reportWindow taskId=" + r5.a() + " before=" + r0.d().size() + " after=" + r0.e().size());
        o.f17154a.a(c(r0));
    }

    private final f c(ae r12) {
        List<i> r5 = g.f17119a.a(r12);
        d.m<ab, t> r11 = g.f17119a.b(r12);
        ab r6 = (ab) ZeusTransformUtils.preCheckCast(r11.c(), ab.class, "com.obric.aiagent.plugin");
        t r7 = (t) ZeusTransformUtils.preCheckCast(r11.d(), t.class, "com.obric.aiagent.plugin");
        return new f(r12.a(), r12.b(), r12.d().size(), r12.e().size(), r5, r6, r7, g.f17119a.a(r7), g.f17119a.b(r7), r12.f());
    }

    private final LocationCondition a(LocationCondition r13) {
        Double r0 = r13.getLongitude();
        if (r0 == null) goto L25;
        double r1 = r0.doubleValue();
        Double r2 = r13.getLatitude();
        if (r2 == null) goto L25;
        double r3 = r2.doubleValue();
        Location r4 = new Location(TAG);
        r4.setLongitude(r1);
        r4.setLatitude(r3);
        d.n.a r5 = d.n.f38560a;     // Catch: Throwable -> L15
        Location r6 = CoordinateTransformUtils.convertLocation(CoordinateTransformUtils.CoordinateSystem.GCJ02, CoordinateTransformUtils.CoordinateSystem.WGS84, r4);     // Catch: Throwable -> L15
        if (r6 == null) goto L12;
        LocationCondition r7 = LocationCondition.copy$default(r13, null, null, Double.valueOf(r6.getLongitude()), Double.valueOf(r6.getLatitude()), null, null, null, 115, null);     // Catch: Throwable -> L15
        if (r7 == null) goto L12;
    L13:
        Object r8 = d.n.f(r7);     // Catch: Throwable -> L15
    L17:
        Throwable r9 = d.n.c(r8);
        if (r9 == null) goto L21;
        com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.d(TAG, "convert condition coordinate failed " + r9.getMessage());
        com.obric.event.task.base.report.e.f32759a.a(TAG, "convert condition coordinate failed " + r9.getMessage());
    L21:
        if (d.n.b(r8) == false) goto L24;
        r8 = r13;
    L24:
        return (LocationCondition) ZeusTransformUtils.preCheckCast(r8, LocationCondition.class, "com.obric.aiagent.plugin");
    L12:
        r7 = r13;
    L15:
        th = move-exception;
        d.n.a r10 = d.n.f38560a;
        r8 = d.n.f(d.o.a(th));
    L25:
        return r13;
    }
}
