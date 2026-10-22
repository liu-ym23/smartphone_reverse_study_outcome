package com.obric.agent.utils;

import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import com.obric.aiagent.assistant.idl.IFlowAppIntentIDL;
import com.obric.aiagent.assistant.idl.IFlowGetLocationCallbackIDL;
import com.obric.aiagent.assistant.idl.bean.OLocationInfo;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.aiagent.platform.depend.ISecureLogDepend;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.aa;
import d.h.b.z;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import kotlinx.coroutines.am;
import kotlinx.coroutines.de;
import kotlinx.coroutines.dg;

/* JADX INFO: compiled from: LocationUtil.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class s {
    private static final String TAG = "LocationUtil";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final s f16064a = null;

    /* JADX INFO: compiled from: LocationUtil.kt */
    @d.c.b.a.f(b = "LocationUtil.kt", c = {195}, d = "doGetCurrentLocationV3", e = "com.obric.agent.utils.LocationUtil")
    static final class a extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f16065a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f16066b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ s f16067c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f16068d;

        a(s r3, d.c.d<? super a> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f16067c = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f16066b = r3;
            this.f16068d |= Integer.MIN_VALUE;
            return s.a(this.f16067c, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: LocationUtil.kt */
    static final class b implements d.h.a.b<Throwable, d.x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f16069a = null;

        static {
            f16069a = new b();
        }

        b() {
        }

        @Override // d.h.a.b
        public /* synthetic */ d.x invoke(Throwable r3) {
            a((Throwable) ZeusTransformUtils.preCheckCast(r3, Throwable.class, "com.obric.aiagent.plugin"));
            return d.x.f38692a;
        }

        public final void a(Throwable r2) {
            ISecureLogDepend.Companion.d(s.TAG, "doGetCurrentLocationV3: 内部请求被取消");
        }
    }

    /* JADX INFO: compiled from: LocationUtil.kt */
    @d.c.b.a.f(b = "LocationUtil.kt", c = {138, 143}, d = "getCurrentLocationV3", e = "com.obric.agent.utils.LocationUtil")
    static final class c extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f16070a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f16071b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ s f16072c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f16073d;

        c(s r3, d.c.d<? super c> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f16072c = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f16071b = r3;
            this.f16073d |= Integer.MIN_VALUE;
            return this.f16072c.a(null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: LocationUtil.kt */
    @d.c.b.a.f(b = "LocationUtil.kt", c = {139}, d = "invokeSuspend", e = "com.obric.agent.utils.LocationUtil$getCurrentLocationV3$2")
    static final class d extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super OLocationInfo>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f16074a;

        d(d.c.d<? super d> r3) {
            super(2, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        public final Object a(am r3, d.c.d<? super OLocationInfo> r4) {
            return ((d) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), d.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r1, d.c.d<?> r2) {
            return (d.c.d) ZeusTransformUtils.preCheckCast(new d((d.c.d) ZeusTransformUtils.wrapperContextForParams(r2, d.c.d.class, "com.obric.aiagent.plugin")), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super OLocationInfo> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r5) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f16074a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r5);
        L11:
            return r5;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r5);
            s r6 = s.f16064a;
            d.c.d r2 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f16074a = 1;
            r5 = s.a(r6, r2);
            if (r5 != r0) goto L11;
            return r0;
        }
    }

    static {
        f16064a = new s();
    }

    public static /* synthetic */ void lambda$eqqPwY3HyZFuSrO_CoufhLUKVJs(LocationManager r0, CountDownLatch r1, z.f r2, Location r3) {
        a(r0, r1, r2, r3);
    }

    private s() {
    }

    public static final /* synthetic */ Object a(s r2, d.c.d r3) {
        return r2.a((d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public final Location a(Context r7, Long r8) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r6, "context");
        final LocationManager r9 = (LocationManager) ZeusTransformUtils.preCheckCast(r6.getSystemService("location"), LocationManager.class, "com.obric.aiagent.plugin");
        Executor r10 = androidx.core.content.a.b(r6);
        d.h.b.o.c(r10, "getMainExecutor(...)");
        final z.f r1 = new z.f();
        final CountDownLatch r2 = new CountDownLatch(1);
        if (r9 == null) goto L5;
        r9.getCurrentLocation("fused", null, r10, new $$Lambda$s$eqqPwY3HyZFuSrO_CoufhLUKVJs(r9, r2, r1));
    L5:
        if (r8 == null) goto L8;
        r2.await(r8.longValue(), TimeUnit.MILLISECONDS);
    L8:
        return (Location) ZeusTransformUtils.preCheckCast(r1.f38504a, Location.class, "com.obric.aiagent.plugin");
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final void a(LocationManager r3, CountDownLatch r4, z.f r5, Location r6) {
        if (r6 != 0) goto L10;
        ILogDepend.Companion r7 = ILogDepend.Companion;
        StringBuilder r8 = new StringBuilder().append("getCurrentLocation: location is null ");
        if (r3 == null) goto L7;
        Boolean r9 = Boolean.valueOf(r3.isLocationEnabled());
    L8:
        r7.e(TAG, r8.append(r9).toString());
        r4.countDown();
        return;
    L7:
        r9 = null;
        goto L8
    L10:
        ISecureLogDepend.Companion.i(TAG, "getCurrentLocation: " + r6);
        r5.f38504a = r6;
        r4.countDown();
    }

    public final String a(Context r8, double r9, double r11) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r7, "context");
        List<Address> r10 = new Geocoder(r7).getFromLocation(r9, r11, 1);
        if (r10 == null) goto L7;
        Address r12 = (Address) ZeusTransformUtils.preCheckCast(d.a.p.l(r10), Address.class, "com.obric.aiagent.plugin");
        if (r12 == null) goto L7;
        String r13 = r12.getAddressLine(0);
    L8:
        ISecureLogDepend.Companion.i(TAG, "getFromLocation: " + r13);
        return r13;
    L7:
        r13 = null;
        goto L8
    }

    public final Object a(Long r9, d.c.d<? super OLocationInfo> r10) {
        d.c.d r11 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r10, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r11, c.class) == false) goto L7;
        c r0 = (c) ZeusTransformUtils.preCheckCast(r11, c.class, "com.obric.aiagent.plugin");
        if ((r0.f16073d & Integer.MIN_VALUE) == 0) goto L7;
        r0.f16073d -= Integer.MIN_VALUE;
    L8:
        Object r12 = r0.f16071b;
        Object r2 = d.c.a.b.a();
        int r3 = r0.f16073d;
        if (r3 == 0) goto L22;
        if (r3 == 1) goto L17;
        if (r3 != 2) goto L16;
        Long r13 = (Long) ZeusTransformUtils.preCheckCast(r0.f16070a, Long.class, "com.obric.aiagent.plugin");
        d.o.a(r12);     // Catch: Exception -> L20 CancellationException -> L34 de -> L35
    L31:
        OLocationInfo r8 = (OLocationInfo) ZeusTransformUtils.preCheckCast(r12, OLocationInfo.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L20 CancellationException -> L34 de -> L35
    L38:
        return r8;
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        Long r14 = (Long) ZeusTransformUtils.preCheckCast(r0.f16070a, Long.class, "com.obric.aiagent.plugin");
        d.o.a(r12);     // Catch: Exception -> L20 CancellationException -> L34 de -> L35
    L27:
        r8 = (OLocationInfo) ZeusTransformUtils.preCheckCast(r12, OLocationInfo.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L20 CancellationException -> L34 de -> L35
        goto L38
    L22:
        d.o.a(r12);
        if (r9 == null) goto L28;
        long r4 = r9.longValue();     // Catch: Exception -> L20 CancellationException -> L34 de -> L35
        d.h.a.m r15 = (d.h.a.m) ZeusTransformUtils.preCheckCast(new d(null), d.h.a.m.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L20 CancellationException -> L34 de -> L35
        r0.f16070a = r9;     // Catch: Exception -> L20 CancellationException -> L34 de -> L35
        r0.f16073d = 1;     // Catch: Exception -> L20 CancellationException -> L34 de -> L35
        r12 = dg.a(r4, r15, r0);     // Catch: Exception -> L20 CancellationException -> L34 de -> L35
        if (r12 != r2) goto L27;
        return r2;
    L28:
        r0.f16070a = r9;     // Catch: Exception -> L20 CancellationException -> L34 de -> L35
        r0.f16073d = 2;     // Catch: Exception -> L20 CancellationException -> L34 de -> L35
        r12 = a(r0);     // Catch: Exception -> L20 CancellationException -> L34 de -> L35
        if (r12 != r2) goto L31;
        return r2;
    L35:
        ILogDepend.Companion.e(TAG, "getCurrentLocationV3: 定位超时（" + r9 + "ms）");
        return null;
    L34:
        ILogDepend.Companion.d(TAG, "getCurrentLocationV3: 定位请求被取消");
        return null;
    L20:
        e = move-exception;
        ILogDepend.Companion.e(TAG, "getCurrentLocationV3: 定位异常 " + e.getMessage(), (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        return null;
    L7:
        r0 = new c(this, r11);
        goto L8
    }

    private final Object a(d.c.d<? super OLocationInfo> r7) {
        d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r7, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r8, a.class) == false) goto L7;
        a r0 = (a) ZeusTransformUtils.preCheckCast(r8, a.class, "com.obric.aiagent.plugin");
        if ((r0.f16068d & Integer.MIN_VALUE) == 0) goto L7;
        r0.f16068d -= Integer.MIN_VALUE;
    L8:
        Object r6 = r0.f16066b;
        Object r9 = d.c.a.b.a();
        int r2 = r0.f16068d;
        if (r2 == 0) goto L14;
        if (r2 != 1) goto L13;
        IFlowAppIntentIDL r10 = (IFlowAppIntentIDL) ZeusTransformUtils.preCheckCast(r0.f16065a, IFlowAppIntentIDL.class, "com.obric.aiagent.plugin");
        d.o.a(r6);
    L22:
        return (OLocationInfo) ZeusTransformUtils.preCheckCast(r6, OLocationInfo.class, "com.obric.aiagent.plugin");
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        d.o.a(r6);
        IFlowAppIntentIDL r11 = com.obric.aiagent.assistant.idl.r.a(aa.b(IFlowAppIntentIDL.class));
        if (r11 == null) goto L24;
        r0.f16065a = r11;
        r0.f16068d = 1;
        kotlinx.coroutines.o r4 = new kotlinx.coroutines.o(d.c.a.b.a((d.c.d) ZeusTransformUtils.preCheckCast(r0, d.c.d.class, "com.obric.aiagent.plugin")), 1);
        r4.e();
        final kotlinx.coroutines.n r3 = (kotlinx.coroutines.n) ZeusTransformUtils.preCheckCast(r4, kotlinx.coroutines.n.class, "com.obric.aiagent.plugin");
        r11.getLocation((IFlowGetLocationCallbackIDL) ZeusTransformUtils.preCheckCast(new LocationUtil$doGetCurrentLocationV3$loc$1$1(r3), IFlowGetLocationCallbackIDL.class, "com.obric.aiagent.plugin"));
        r3.a((d.h.a.b) ZeusTransformUtils.preCheckCast(b.f16069a, d.h.a.b.class, "com.obric.aiagent.plugin"));
        r6 = r4.h();
        if (r6 != d.c.a.b.a()) goto L19;
        d.c.b.a.h.c((d.c.d) ZeusTransformUtils.preCheckCast(r0, d.c.d.class, "com.obric.aiagent.plugin"));
    L19:
        if (r6 != r9) goto L22;
        return r9;
    L24:
        throw new com.obric.agent.permission.a.a("IFlowAppIntentIDL service not found!");
    L7:
        r0 = new a(this, r8);
        goto L8
    }
}
