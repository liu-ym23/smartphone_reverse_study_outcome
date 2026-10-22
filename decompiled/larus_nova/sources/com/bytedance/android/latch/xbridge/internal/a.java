package com.bytedance.android.latch.xbridge.internal;

import android.content.Context;
import com.bytedance.android.latch.LatchProcessOptions;
import com.bytedance.android.latch.internal.perf.LatchPerfMetricCollector;
import com.bytedance.android.latch.prefetch.internal.h;
import com.bytedance.android.latch.prefetch.internal.q;
import com.bytedance.vmsdk.worker.JsWorker;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class a implements kx.a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final C0931a f58505e = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final kx.b f58506d;

    /* JADX INFO: renamed from: com.bytedance.android.latch.xbridge.internal.a$a, reason: collision with other inner class name */
    public static final class C0931a {
        public C0931a() {
        }
    }

    static {
        f58505e = new C0931a();
    }

    public a(kx.b r100) {
        Intrinsics.checkNotNullParameter(r100, "options");
        this.f58506d = r100;
        LatchPerfMetricCollector.c(new LatchPerfMetricCollector(), LatchPerfMetricCollector.PerfPoints.LATCH_START, null, null, 0, 14);
    }

    @Override // kx.a
    public final lx.c a(LatchProcessOptions r100) {
        Intrinsics.checkNotNullParameter(r100, "processOptions");
        return new lx.c(this.f58506d, r100);
    }

    @Override // kx.a
    public final kx.a.b c(Context r110, String r111, com.bytedance.android.latch.a.b r112, LatchProcessOptions r210) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r111, "pageUrl");
        Intrinsics.checkNotNullParameter(r112, "dataHolder");
        Intrinsics.checkNotNullParameter(r210, "processOptions");
        LatchPerfMetricCollector r100 = new LatchPerfMetricCollector();
        LatchPerfMetricCollector.c(r100, LatchPerfMetricCollector.PerfPoints.LATCH_START, null, null, 0, 14);
        LatchPerfMetricCollector.c(r100, LatchPerfMetricCollector.PerfPoints.HANDLE_SCHEME_INIT, null, null, r210.f58205b, 6);
        r100.d(r210.f58206c);
        LatchProcessOptions.PrefetchPartial r101 = r210.f58208e;
        LatchProcessOptions.PrefetchPartial r102 = LatchProcessOptions.PrefetchPartial.NATIVE;
        if (r101 != r102) goto L12;
        q r103 = this.f58506d.f496313e.a(r111);
        if (r103 == null) goto L11;
        h r104 = r103.a(r111, r112);
        if (r104 == null) goto L10;
        kx.b r105 = this.f58506d;
        r100.e();
        Unit r106 = Unit.INSTANCE;
        NativePrefetchProcessForXBridge r107 = new NativePrefetchProcessForXBridge(r104, r110, r105, r111, r112, r100, r210);
        r107.n();
        return r107;
    L10:
        Object r113 = "prefetch: rule not matched.";
        int r114 = -2007;
    L14:
        if (JsWorker.initialize() == false) goto L20;
        LatchProcessForXBridgeImpl r115 = new LatchProcessForXBridgeImpl(r110, this.f58506d, r111, r112, r100, r210);
        if (r210.f58208e != r102) goto L18;
        r115.f58221f.put("prefetchStatusCode", Integer.valueOf(r114));
        r115.f58221f.put("prefetchErrMsg", r113);
    L18:
        return r115;
    L20:
        return a(r210);
    L11:
        this.f58506d.f496313e.reload(r111);
        r113 = "prefetch: latch.json not prepared.";
        r114 = -2002;
        goto L14
    L12:
        r113 = "";
        r114 = 0;
        goto L14
    }
}
