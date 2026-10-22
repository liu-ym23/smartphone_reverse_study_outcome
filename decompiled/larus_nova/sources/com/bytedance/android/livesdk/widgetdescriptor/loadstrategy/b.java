package com.bytedance.android.livesdk.widgetdescriptor.loadstrategy;

import android.os.Handler;
import com.bytedance.android.live.core.tetris.layer.core.descriptor.LayerDescriptorList;
import com.bytedance.android.livesdk.config.o91;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class b implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f162384a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f162385b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f162386c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f162387d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f162388e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f162389f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final mg2.d f162390g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final com.bytedance.android.livesdk.widgetdescriptor.priority.c f162391h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final o91 f162392i;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f162393a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.bytedance.android.livesdk.widgetdescriptor.loadstrategy.a f162394b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f162395c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Iterator f162396d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ Map f162397e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ Runnable f162398f;

        public a(b r100, com.bytedance.android.livesdk.widgetdescriptor.loadstrategy.a r101, String r102, Iterator r103, Map r104, Runnable r105) {
            this.f162393a = r100;
            this.f162394b = r101;
            this.f162395c = r102;
            this.f162396d = r103;
            this.f162397e = r104;
            this.f162398f = r105;
        }

        public final void a() {
            b r100 = this.f162393a;
            if (r100.f162389f == true) goto L12;
            LayerDescriptorList r101 = this.f162394b.f162382a;
            if (r101 == null) goto L7;
            r100.f162390g.b(mg2.e.f513710c, r101);
        L7:
            LayerDescriptorList r102 = this.f162394b.f162383b;
            if (r102 == null) goto L10;
            this.f162393a.f162390g.b(mg2.e.f513712e, r102);
        L10:
            String r103 = d80.b.f467383a;
            d80.b.b(this.f162395c);
            this.f162393a.e(this.f162395c, this.f162396d, this.f162397e, this.f162398f);
            return;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.widgetdescriptor.loadstrategy.b$b, reason: collision with other inner class name */
    public static final class RunnableC2482b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f162399a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Runnable f162400b;

        public RunnableC2482b(b r100, Runnable r101) {
            this.f162399a = r100;
            this.f162400b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
        L8:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L16;
            throw th;
        L16:
            return;
        L3:
            if (this.f162399a.f162389f == true) goto L11;
            Runnable r100 = this.f162400b;     // Catch: Throwable -> L8
            if (r100 == null) goto L15;
            r100.run();     // Catch: Throwable -> L8
            return;
        L15:
            return;
        }
    }

    @Override // com.bytedance.android.livesdk.widgetdescriptor.loadstrategy.f
    public final void onDestroy() {
        if (this.f162389f == false) goto L5;
        return;
    L5:
        c.a(LiveCommonConstants.REASON_ON_DEDTROY);
        this.f162389f = true;
        ((Handler) this.f162388e.getValue()).removeCallbacksAndMessages(null);
        this.f162391h.release();
    }

    @Override // com.bytedance.android.livesdk.widgetdescriptor.loadstrategy.f
    public final void a(Runnable r100) {
        c.a("loadP2Group");
        f(this.f162386c, r100);
    }

    @Override // com.bytedance.android.livesdk.widgetdescriptor.loadstrategy.f
    public final void b(Runnable r100) {
        c.a("loadP0Group");
        f(this.f162384a, r100);
    }

    @Override // com.bytedance.android.livesdk.widgetdescriptor.loadstrategy.f
    public final void c(Runnable r100) {
        c.a("loadP1Group");
        f(this.f162385b, r100);
    }

    @Override // com.bytedance.android.livesdk.widgetdescriptor.loadstrategy.f
    public final void d(Runnable r100) {
        c.a("loadOtherGroup");
        f(this.f162387d, r100);
    }

    public final void f(String r100, Runnable r101) {
        if (this.f162389f == false) goto L5;
        return;
    L5:
        Map<Double, Long> r102 = null;
        if (Intrinsics.areEqual(r100, this.f162384a) == false) goto L9;
        TreeMap<Double, com.bytedance.android.livesdk.widgetdescriptor.loadstrategy.a> r103 = this.f162391h.d();
    L19:
        if (Intrinsics.areEqual(r100, this.f162384a) == false) goto L24;
        o91 r104 = this.f162392i;
        if (r104 == null) goto L38;
        r102 = r104.g();
    L38:
        if (r103 == null) goto L41;
        e(r100, r103.entrySet().iterator(), r102, r101);
        return;
    L41:
        return;
    L24:
        if (Intrinsics.areEqual(r100, this.f162385b) == false) goto L29;
        o91 r105 = this.f162392i;
        if (r105 == null) goto L38;
        r102 = r105.h();
        goto L38
    L29:
        if (Intrinsics.areEqual(r100, this.f162386c) == false) goto L34;
        o91 r106 = this.f162392i;
        if (r106 == null) goto L38;
        r102 = r106.i();
        goto L38
    L34:
        if (Intrinsics.areEqual(r100, this.f162387d) == false) goto L38;
        o91 r107 = this.f162392i;
        if (r107 == null) goto L38;
        r102 = r107.f();
        goto L38
    L9:
        if (Intrinsics.areEqual(r100, this.f162385b) == false) goto L12;
        r103 = this.f162391h.a();
        goto L19
    L12:
        if (Intrinsics.areEqual(r100, this.f162386c) == false) goto L15;
        r103 = this.f162391h.b();
        goto L19
    L15:
        if (Intrinsics.areEqual(r100, this.f162387d) == false) goto L17;
        r103 = this.f162391h.c();
        goto L19
    L17:
        r103 = null;
        goto L19
    }

    public b(mg2.d r100, com.bytedance.android.livesdk.widgetdescriptor.priority.b r101, o91 r102) {
        Intrinsics.checkNotNullParameter(r100, "componentManager");
        Intrinsics.checkNotNullParameter(r101, "priorityOperator");
        this.f162390g = r100;
        this.f162391h = r101;
        this.f162392i = r102;
        this.f162384a = "p0";
        this.f162385b = "p1";
        this.f162386c = "p2";
        this.f162387d = "other";
        this.f162388e = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, DescriptorLoadInOrderStrategy$sHandler$2.INSTANCE);
    }

    public final void e(String r110, Iterator<? extends Map.Entry<Double, com.bytedance.android.livesdk.widgetdescriptor.loadstrategy.a>> r111, Map<Double, Long> r112, Runnable r113) {
        if (this.f162389f == false) goto L6;
        return;
    L6:
        if (r111.hasNext() == false) goto L28;
        Map.Entry<Double, com.bytedance.android.livesdk.widgetdescriptor.loadstrategy.a> r100 = r111.next();
        double r101 = r100.getKey().doubleValue();
        if (r112 == null) goto L12;
        Long r102 = r112.get(Double.valueOf(r101));
        if (r102 == null) goto L12;
        long r114 = r102.longValue();
    L13:
        com.bytedance.android.livesdk.widgetdescriptor.loadstrategy.a r103 = r100.getValue();
        if (Intrinsics.areEqual(r110, this.f162384a) == true) goto L16;
    L26:
        ((Handler) this.f162388e.getValue()).postDelayed(new a(this, r103, r110, r111, r112, r113), r114);
        return;
    L16:
        if (r114 != 0) goto L26;
        if (this.f162389f == true) goto L35;
        LayerDescriptorList r104 = r103.f162382a;
        if (r104 == null) goto L22;
        this.f162390g.b(mg2.e.f513710c, r104);
    L22:
        LayerDescriptorList r105 = r103.f162383b;
        if (r105 == null) goto L25;
        this.f162390g.b(mg2.e.f513712e, r105);
    L25:
        d80.b.b(r110);
        e(r110, r111, r112, r113);
        return;
    L35:
        return;
    L12:
        r114 = 0;
        goto L13
    L28:
        if (Intrinsics.areEqual(r110, this.f162384a) == true) goto L30;
        ((Handler) this.f162388e.getValue()).post(new RunnableC2482b(this, r113));
        return;
    L30:
        if (this.f162389f == true) goto L38;
        if (r113 == null) goto L39;
        r113.run();
        return;
    L39:
        return;
    }
}
