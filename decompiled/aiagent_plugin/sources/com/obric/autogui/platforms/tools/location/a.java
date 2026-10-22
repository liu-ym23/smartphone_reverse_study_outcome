package com.obric.autogui.platforms.tools.location;

import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Looper;
import android.util.EventsUtils;
import com.obric.agent.trace.toolmetrics.OmniClientToolTraceServiceImpl;
import com.obric.autogui.common.api.logging.Loog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.b.a.f;
import d.c.b.a.h;
import d.c.b.a.l;
import d.c.d;
import d.c.g;
import d.h.a.m;
import d.o;
import d.x;
import kotlinx.coroutines.am;
import kotlinx.coroutines.an;
import kotlinx.coroutines.au;
import kotlinx.coroutines.bd;
import kotlinx.coroutines.cx;
import kotlinx.coroutines.dg;
import kotlinx.coroutines.i;
import kotlinx.coroutines.n;

/* JADX INFO: compiled from: LocationRefresher.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a {
    private static final String TAG = "LocationRefresher";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f30403a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final am f30404b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static au<? extends Location> f30405c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final kotlinx.coroutines.f.a f30406d = null;

    /* JADX INFO: renamed from: com.obric.autogui.platforms.tools.location.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: LocationRefresher.kt */
    @f(b = "LocationRefresher.kt", c = {EventsUtils.FEAT_TYPE_NFC_EVENT}, d = "invokeSuspend", e = "com.obric.autogui.platforms.tools.location.LocationRefresher$fetchLocation$2")
    static final class C0816a extends l implements m<am, d<? super Location>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f30407a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f30408b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f30409c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f30410d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ LocationManager f30411e;

        /* JADX INFO: renamed from: com.obric.autogui.platforms.tools.location.a$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: LocationRefresher.kt */
        static final class C0817a implements d.h.a.b<Throwable, x> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ LocationManager f30412a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ LocationRefresher$fetchLocation$2$1$listener$1 f30413b;

            C0817a(LocationManager r1, LocationRefresher$fetchLocation$2$1$listener$1 r2) {
                this.f30412a = r1;
                this.f30413b = r2;
            }

            @Override // d.h.a.b
            public /* synthetic */ x invoke(Throwable r3) {
                a((Throwable) ZeusTransformUtils.preCheckCast(r3, Throwable.class, "com.obric.aiagent.plugin"));
                return x.f38692a;
            }

            public final void a(Throwable r3) {
                a(this.f30412a, (LocationListener) ZeusTransformUtils.preCheckCast(this.f30413b, LocationListener.class, "com.obric.aiagent.plugin"));     // Catch: Exception -> L4
                return;
            }

            public static void a(LocationManager r2, LocationListener r3) {
                LocationListener r4 = (LocationListener) ZeusTransformUtils.wrapperContextForParams(r3, LocationListener.class, "com.obric.aiagent.plugin");
                if (com.obric.performance.power.monitor.a.f36932a.a() == true) goto L6;
                r2.removeUpdates(r4);
                return;
            L6:
                r2.removeUpdates(r4);
                com.obric.performance.power.monitor.g.a.c(r4.hashCode());
            }
        }

        C0816a(String r3, LocationManager r4, d<? super C0816a> r5) {
            d r6 = (d) ZeusTransformUtils.wrapperContextForParams(r5, d.class, "com.obric.aiagent.plugin");
            this.f30410d = r3;
            this.f30411e = r4;
            super(2, r6);
        }

        public final Object a(am r3, d<? super Location> r4) {
            return ((C0816a) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin")), C0816a.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d<x> create(Object r3, d<?> r4) {
            d r5 = (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin");
            return (d) ZeusTransformUtils.preCheckCast(new C0816a(this.f30410d, this.f30411e, r5), d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d<? super Location> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.preCheckCast(r4, d.class, "com.obric.aiagent.plugin"));
        }

        /* JADX WARN: Type inference failed for: r5v4, types: [com.obric.autogui.platforms.tools.location.LocationRefresher$fetchLocation$2$1$listener$1, java.lang.Object] */
        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r11) {
            Object r1 = d.c.a.b.a();
            int r2 = this.f30409c;
            if (r2 == 0) goto L8;
            if (r2 != 1) goto L7;
            LocationManager r0 = (LocationManager) ZeusTransformUtils.preCheckCast(this.f30408b, LocationManager.class, "com.obric.aiagent.plugin");
            String r10 = (String) ZeusTransformUtils.preCheckCast(this.f30407a, String.class, "com.obric.aiagent.plugin");
            o.a(r11);
        L20:
            return r11;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r11);
            String r12 = this.f30410d;
            final LocationManager r3 = this.f30411e;
            this.f30407a = r12;
            this.f30408b = r3;
            this.f30409c = 1;
            kotlinx.coroutines.o r6 = new kotlinx.coroutines.o(d.c.a.b.a((d) ZeusTransformUtils.preCheckCast(this, d.class, "com.obric.aiagent.plugin")), 1);
            r6.e();
            final n r4 = (n) ZeusTransformUtils.preCheckCast(r6, n.class, "com.obric.aiagent.plugin");
            ?? r5 = new LocationRefresher$fetchLocation$2$1$listener$1(r4, r3);
            Loog.INSTANCE.d(a.TAG, "Requesting single update from " + r12);     // Catch: Exception -> L11
            a(r3, r12, (LocationListener) ZeusTransformUtils.preCheckCast(r5, LocationListener.class, "com.obric.aiagent.plugin"), Looper.getMainLooper());     // Catch: Exception -> L11
            r4.a((d.h.a.b) ZeusTransformUtils.preCheckCast(new C0817a(r3, r5), d.h.a.b.class, "com.obric.aiagent.plugin"));     // Catch: Exception -> L11
        L15:
            r11 = r6.h();
            if (r11 != d.c.a.b.a()) goto L18;
            h.c((d) ZeusTransformUtils.preCheckCast(this, d.class, "com.obric.aiagent.plugin"));
        L18:
            if (r11 != r1) goto L20;
            return r1;
        L11:
            e = move-exception;
            Loog.INSTANCE.e(a.TAG, "Error requesting location updates", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
            if (r4.a() == false) goto L15;
            d r13 = (d) ZeusTransformUtils.preCheckCast(r4, d.class, "com.obric.aiagent.plugin");
            d.n.a r7 = d.n.f38560a;
            r13.resumeWith(d.n.f(null));
            goto L15
        }

        public static void a(LocationManager r2, String r3, LocationListener r4, Looper r5) {
            LocationListener r6 = (LocationListener) ZeusTransformUtils.wrapperContextForParams(r4, LocationListener.class, "com.obric.aiagent.plugin");
            if (com.obric.performance.power.monitor.a.f36932a.a() == true) goto L6;
            r2.requestSingleUpdate(r3, r6, r5);
            return;
        L6:
            r2.requestSingleUpdate(r3, r6, r5);
            com.obric.performance.power.monitor.g.a.f37000a.a(com.obric.performance.power.monitor.g.a.f37000a.a() + 1);
        }
    }

    /* JADX INFO: compiled from: LocationRefresher.kt */
    @f(b = "LocationRefresher.kt", c = {94}, d = "getOrTriggerRefresh", e = "com.obric.autogui.platforms.tools.location.LocationRefresher")
    static final class b extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f30414a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f30415b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        /* synthetic */ Object f30416c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ a f30417d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f30418e;

        b(a r3, d<? super b> r4) {
            d r5 = (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin");
            this.f30417d = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f30416c = r3;
            this.f30418e |= Integer.MIN_VALUE;
            return this.f30417d.a(null, (d) ZeusTransformUtils.preCheckCast(this, d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: LocationRefresher.kt */
    @f(b = "LocationRefresher.kt", c = {37}, d = "invokeSuspend", e = "com.obric.autogui.platforms.tools.location.LocationRefresher$getOrTriggerRefresh$2$newTask$1")
    static final class c extends l implements m<am, d<? super Location>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f30419a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ LocationManager f30420b;

        c(LocationManager r3, d<? super c> r4) {
            d r5 = (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin");
            this.f30420b = r3;
            super(2, r5);
        }

        public final Object a(am r3, d<? super Location> r4) {
            return ((c) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin")), c.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d<x> create(Object r2, d<?> r3) {
            d r4 = (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.aiagent.plugin");
            return (d) ZeusTransformUtils.preCheckCast(new c(this.f30420b, r4), d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d<? super Location> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.preCheckCast(r4, d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r6) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f30419a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r6);
        L11:
            return r6;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r6);
            a r7 = a.f30403a;
            LocationManager r2 = this.f30420b;
            d r3 = (d) ZeusTransformUtils.preCheckCast(this, d.class, "com.obric.aiagent.plugin");
            this.f30419a = 1;
            r6 = a.a(r7, r2, r3);
            if (r6 != r0) goto L11;
            return r0;
        }
    }

    private a() {
    }

    public static final /* synthetic */ Object a(a r2, LocationManager r3, d r4) {
        return r2.b(r3, (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin"));
    }

    static {
        f30403a = new a();
        f30404b = an.a(bd.b().plus((g) ZeusTransformUtils.preCheckCast(cx.a(null, 1, null), g.class, "com.obric.aiagent.plugin")));
        f30406d = kotlinx.coroutines.f.c.a(false, 1, null);
    }

    public final Object a(LocationManager r12, d<? super au<? extends Location>> r13) {
        d r14 = (d) ZeusTransformUtils.wrapperContextForParams(r13, d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r14, b.class) == false) goto L7;
        b r0 = (b) ZeusTransformUtils.preCheckCast(r14, b.class, "com.obric.aiagent.plugin");
        if ((r0.f30418e & Integer.MIN_VALUE) == 0) goto L7;
        r0.f30418e -= Integer.MIN_VALUE;
    L8:
        Object r11 = r0.f30416c;
        Object r15 = d.c.a.b.a();
        int r2 = r0.f30418e;
        if (r2 == 0) goto L14;
        if (r2 != 1) goto L13;
        kotlinx.coroutines.f.a r16 = (kotlinx.coroutines.f.a) ZeusTransformUtils.preCheckCast(r0.f30415b, kotlinx.coroutines.f.a.class, "com.obric.aiagent.plugin");
        LocationManager r17 = (LocationManager) ZeusTransformUtils.preCheckCast(r0.f30414a, LocationManager.class, "com.obric.aiagent.plugin");
        o.a(r11);
        kotlinx.coroutines.f.a r18 = r16;
        r12 = r17;
    L31:
        au<? extends Location> r19 = f30405c;     // Catch: Throwable -> L28
        if (r19 != null) goto L21;
    L25:
        Loog.INSTANCE.d(TAG, "Starting new location refresh task");     // Catch: Throwable -> L28
        au<? extends Location> r110 = i.b(f30404b, null, null, (m) ZeusTransformUtils.preCheckCast(new c(r12, null), m.class, "com.obric.aiagent.plugin"), 3, null);     // Catch: Throwable -> L28
        f30405c = r110;     // Catch: Throwable -> L28
        r18.b(null);
        return r110;
    L21:
        if (r19.b() == false) goto L25;
        Loog.INSTANCE.d(TAG, "Reusing existing location refresh task");     // Catch: Throwable -> L28
        r18.b(null);
        return r19;
    L28:
        th = move-exception;
        r18.b(null);
        throw th;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        o.a(r11);
        r18 = f30406d;
        r0.f30414a = r12;
        r0.f30415b = r18;
        r0.f30418e = 1;
        if (r18.a(null, r0) != r15) goto L31;
        return r15;
    L7:
        r0 = new b(this, r14);
        goto L8
    }

    private final Object b(LocationManager r6, d<? super Location> r7) {
        d r5 = (d) ZeusTransformUtils.wrapperContextForParams(r7, d.class, "com.obric.aiagent.plugin");
        String r8 = "network";
        if (r6.isProviderEnabled("network") == true) goto L9;
        if (r6.isProviderEnabled("gps") == false) goto L10;
        r8 = "gps";
        goto L9
    L10:
        return null;
    L9:
        return dg.b(OmniClientToolTraceServiceImpl.WATCHDOG_INTERVAL_MS, (m) ZeusTransformUtils.preCheckCast(new C0816a(r8, r6, null), m.class, "com.obric.aiagent.plugin"), r5);
    }
}
