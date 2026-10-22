package com.bytedance.android.latch.internal;

import android.os.Looper;
import android.os.SystemClock;
import com.bytedance.android.latch.LatchOptions;
import com.bytedance.android.latch.internal.perf.LatchPerfMetricCollector;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.android.latch.a.d f58274a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f58275b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f58276c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final LatchOptions.a f58277d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final LatchPerfMetricCollector f58278e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final com.bytedance.android.latch.internal.perf.b f58279f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final hx.a f58280g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Function1<dx.c, Unit> f58281h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Function0<String> f58282i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final long f58283j;

    /* JADX INFO: renamed from: com.bytedance.android.latch.internal.a$a, reason: collision with other inner class name */
    public static final class RunnableC0926a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f58284a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f58285b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f58286c;

        public RunnableC0926a(a r100, int r101, String r102) {
            this.f58284a = r100;
            this.f58285b = r101;
            this.f58286c = r102;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a r100 = this.f58284a;     // Catch: Throwable -> L13
            hx.a r101 = r100.f58280g;     // Catch: Throwable -> L13
            if (r101 == null) goto L16;
            com.bytedance.android.latch.a.d r102 = r100.f58274a;     // Catch: Throwable -> L13
            int r103 = this.f58285b;     // Catch: Throwable -> L13
            if (r103 != 1) goto L7;
            String r104 = "latch.init.js";
        L11:
            r101.a(r102, new dx.a(r104, this.f58286c));     // Catch: Throwable -> L13
            return;
        L7:
            if (r103 == 2) goto L9;
            r104 = "unknown";
            goto L11
        L9:
            r104 = "prefetch.js";
            goto L11
        L16:
            return;
        L13:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L20;
            throw th;
        }
    }

    public final void b() {
        LatchPerfMetricCollector.c(this.f58278e, LatchPerfMetricCollector.PerfPoints.FILES_LOADED, null, null, 0, 14);
        h(103);
        String r100 = "filesLoaded";
        g(new dx.b(r100, 0, 6));
    }

    public final void c() {
        LatchPerfMetricCollector.c(this.f58278e, LatchPerfMetricCollector.PerfPoints.EVALUATE_PREFETCH_START, null, null, 0, 14);
        h(2);
        String r100 = "initJsFinished";
        g(new dx.b(r100, 0, 6));
    }

    public final void i() {
        LatchPerfMetricCollector.c(this.f58278e, LatchPerfMetricCollector.PerfPoints.EVALUATE_PREFETCH_END, null, null, 0, 14);
        h(3);
        String r100 = "prefetchJsReturned";
        g(new dx.b(r100, 0, 6));
    }

    public final void a(JSONObject r110) {
        Intrinsics.checkNotNullParameter(r110, "endAttachJson");
        g(new dx.b("endAttach: " + r110, 0, 6));
        LatchPerfMetricCollector.c(this.f58278e, LatchPerfMetricCollector.PerfPoints.ATTACH_CALLBACK_START, null, null, 0, 14);
    }

    public final void g(dx.b r100) {
        Intrinsics.checkNotNullParameter(r100, "logModel");
        hx.a r101 = this.f58280g;
        if (r101 == null) goto L6;
        r101.c(this.f58274a, r100);
        return;
    }

    public final void h(int r100) {
        long r101 = SystemClock.elapsedRealtime() - this.f58283j;
        this.f58277d.a(this.f58275b, r100, r101);
    }

    public final void j(String r110) {
        Intrinsics.checkNotNullParameter(r110, "callbackId");
        g(new dx.b("sendJsEvent; callbackId: " + r110, 0, 6));
        LatchPerfMetricCollector.c(this.f58278e, LatchPerfMetricCollector.PerfPoints.SEND_JS_EVENT, r110, null, 0, 12);
    }

    public final void k(JSONObject r110) {
        Intrinsics.checkNotNullParameter(r110, "attachJson");
        g(new dx.b("startAttach: " + r110, 0, 6));
        LatchPerfMetricCollector.c(this.f58278e, LatchPerfMetricCollector.PerfPoints.ATTACH_START, null, null, 0, 14);
    }

    public final void e(String r110, String r111) {
        Intrinsics.checkNotNullParameter(r110, "callbackId");
        Intrinsics.checkNotNullParameter(r111, "methodName");
        g(new dx.b("jsbEnd; methodName: " + r111 + ", callbackId: " + r110, 0, 6));
        LatchPerfMetricCollector.c(this.f58278e, LatchPerfMetricCollector.PerfPoints.JSB_END, r110, r111, 0, 8);
        com.bytedance.android.latch.internal.perf.b r100 = this.f58279f;
        r100.getClass();
        Intrinsics.checkNotNullParameter(r110, "callbackId");
        Intrinsics.checkNotNullParameter(r111, "methodName");
        long r101 = System.currentTimeMillis();
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == true) goto L5;
        com.bytedance.android.latch.internal.util.b.f58388a.post(new com.bytedance.android.latch.internal.perf.c(r100, r110, r101));
        return;
    L5:
        com.bytedance.android.latch.internal.perf.b.a(r100, r110).f58354c = r101;
    }

    public final void f(String r110, String r111) {
        Intrinsics.checkNotNullParameter(r110, "callbackId");
        Intrinsics.checkNotNullParameter(r111, "methodName");
        g(new dx.b("jsbStart; methodName: " + r111 + ", callbackId: " + r110, 0, 6));
        LatchPerfMetricCollector.c(this.f58278e, LatchPerfMetricCollector.PerfPoints.JSB_INIT, r110, r111, 0, 8);
        com.bytedance.android.latch.internal.perf.b r100 = this.f58279f;
        r100.getClass();
        Intrinsics.checkNotNullParameter(r110, "callbackId");
        Intrinsics.checkNotNullParameter(r111, "methodName");
        long r101 = System.currentTimeMillis();
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == true) goto L5;
        com.bytedance.android.latch.internal.util.b.f58388a.post(new com.bytedance.android.latch.internal.perf.d(r100, r110, r111, r101));
        return;
    L5:
        com.bytedance.android.latch.internal.perf.b.a r102 = com.bytedance.android.latch.internal.perf.b.a(r100, r110);
        Intrinsics.checkNotNullParameter(r111, "<set-?>");
        r102.f58352a = r111;
        r102.f58353b = r101;
    }

    public final void d(int r100, String r101, Map<String, ? extends Object> r102) {
        Intrinsics.checkNotNullParameter(r101, "message");
        Intrinsics.checkNotNullParameter(r102, "extra");
        this.f58277d.b(this.f58275b, r100, r101, r102);
        g(new dx.b("Error occurred: " + r101 + ", occasion: " + r100 + ", pageUrl: " + this.f58275b + ", extra: " + r102, 3, 4));
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == true) goto L5;
        com.bytedance.android.latch.internal.util.b.f58388a.post(new RunnableC0926a(this, r100, r101));
        return;
    L5:
        hx.a r103 = this.f58280g;
        if (r103 == null) goto L17;
        com.bytedance.android.latch.a.d r104 = this.f58274a;
        if (r100 != 1) goto L10;
        String r105 = "latch.init.js";
    L14:
        r103.a(r104, new dx.a(r105, r101));
        return;
    L10:
        if (r100 == 2) goto L12;
        r105 = "unknown";
        goto L14
    L12:
        r105 = "prefetch.js";
        goto L14
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a(com.bytedance.android.latch.a.d r100, String r101, String r102, LatchOptions.a r103, LatchPerfMetricCollector r104, com.bytedance.android.latch.internal.perf.b r105, hx.a r106, Function1<? super dx.c, Unit> r107, Function0<String> r110) {
        Intrinsics.checkNotNullParameter(r100, "process");
        Intrinsics.checkNotNullParameter(r101, "pageUrl");
        Intrinsics.checkNotNullParameter(r102, "engineType");
        Intrinsics.checkNotNullParameter(r103, "monitor");
        Intrinsics.checkNotNullParameter(r104, "perfMetric");
        Intrinsics.checkNotNullParameter(r105, "jsbPromiseMetric");
        Intrinsics.checkNotNullParameter(r107, "latchResultAction");
        Intrinsics.checkNotNullParameter(r110, "customMessage");
        this.f58274a = r100;
        this.f58275b = r101;
        this.f58276c = r102;
        this.f58277d = r103;
        this.f58278e = r104;
        this.f58279f = r105;
        this.f58280g = r106;
        this.f58281h = r107;
        this.f58282i = r110;
        this.f58283j = SystemClock.elapsedRealtime();
    }
}
