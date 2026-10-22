package com.android.ttcjpaysdk.base.performance;

import com.android.ttcjpaysdk.base.settings.bean.CJPayOptimizeSwitch;
import com.bytedance.caijing.sdk.infra.base.api.env.CJPerformanceService;
import com.bytedance.caijing.sdk.infra.base.task.b;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import ve4.a;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0004H\u0007J\u0018\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00042\b\b\u0002\u0010\u0018\u001a\u00020\u0019J\u0010\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0004H\u0007J\u0010\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0004H\u0007R\u001c\u0010\u0003\u001a\u00020\u00048\u0006X\u0087D¢\u0006\u000e\n\u0000\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\b\u001a\u00020\u00048\u0006X\u0087D¢\u0006\u000e\n\u0000\u0012\u0004\b\t\u0010\u0002\u001a\u0004\b\n\u0010\u0007R\u001c\u0010\u000b\u001a\u00020\u00048\u0006X\u0087D¢\u0006\u000e\n\u0000\u0012\u0004\b\f\u0010\u0002\u001a\u0004\b\r\u0010\u0007R\u001c\u0010\u000e\u001a\u00020\u00048\u0006X\u0087D¢\u0006\u000e\n\u0000\u0012\u0004\b\u000f\u0010\u0002\u001a\u0004\b\u0010\u0010\u0007R\u001c\u0010\u0011\u001a\u00020\u00048\u0006X\u0087D¢\u0006\u000e\n\u0000\u0012\u0004\b\u0012\u0010\u0002\u001a\u0004\b\u0013\u0010\u0007¨\u0006\u001c"}, d2 = {"Lcom/android/ttcjpaysdk/base/performance/CJPerformance;", "", "()V", "ET_SCENE", "", "getET_SCENE$annotations", "getET_SCENE", "()Ljava/lang/String;", "INTEGRATED_COUNTER_SCENE", "getINTEGRATED_COUNTER_SCENE$annotations", "getINTEGRATED_COUNTER_SCENE", "INTEGRATED_UNIFY_COUNTER_SCENE", "getINTEGRATED_UNIFY_COUNTER_SCENE$annotations", "getINTEGRATED_UNIFY_COUNTER_SCENE", "STANDARD_SCENE", "getSTANDARD_SCENE$annotations", "getSTANDARD_SCENE", "ZG_UNIFY_COUNTER_SCENE", "getZG_UNIFY_COUNTER_SCENE$annotations", "getZG_UNIFY_COUNTER_SCENE", "clear", "", "scene", "doFPSMonitor", "duration", "", "start", "stop", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJPerformance {
    private static final String ET_SCENE = null;
    public static final CJPerformance INSTANCE = null;
    private static final String INTEGRATED_COUNTER_SCENE = null;
    private static final String INTEGRATED_UNIFY_COUNTER_SCENE = null;
    private static final String STANDARD_SCENE = null;
    private static final String ZG_UNIFY_COUNTER_SCENE = null;

    private CJPerformance() {
    }

    @JvmStatic
    public static /* synthetic */ void getET_SCENE$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getINTEGRATED_COUNTER_SCENE$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getINTEGRATED_UNIFY_COUNTER_SCENE$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getSTANDARD_SCENE$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getZG_UNIFY_COUNTER_SCENE$annotations() {
    }

    static {
        INSTANCE = new CJPerformance();
        ET_SCENE = "cj_pay_et_launch";
        STANDARD_SCENE = "cj_pay_standard_launch";
        INTEGRATED_COUNTER_SCENE = "cj_pay_integrated_counter_launch";
        INTEGRATED_UNIFY_COUNTER_SCENE = "cj_pay_integrated_unify_launch";
        ZG_UNIFY_COUNTER_SCENE = "cj_pay_zg_unify_launch";
    }

    public static final String getET_SCENE() {
        return ET_SCENE;
    }

    public static final String getINTEGRATED_COUNTER_SCENE() {
        return INTEGRATED_COUNTER_SCENE;
    }

    public static final String getINTEGRATED_UNIFY_COUNTER_SCENE() {
        return INTEGRATED_UNIFY_COUNTER_SCENE;
    }

    public static final String getSTANDARD_SCENE() {
        return STANDARD_SCENE;
    }

    public static final String getZG_UNIFY_COUNTER_SCENE() {
        return ZG_UNIFY_COUNTER_SCENE;
    }

    @JvmStatic
    public static final void clear(String r100) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L9
        a.f554342a.getClass();     // Catch: Throwable -> L9
        CJPerformanceService r102 = (CJPerformanceService) a.a(CJPerformanceService.class);     // Catch: Throwable -> L9
        if (r102 == null) goto L6;
        r102.clear(r100);     // Catch: Throwable -> L9
        Unit r103 = Unit.INSTANCE;     // Catch: Throwable -> L9
    L7:
        Result.m9449constructorimpl(r103);     // Catch: Throwable -> L9
        return;
    L6:
        r103 = null;
    L9:
        th = move-exception;
        Result.Companion r104 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    }

    @JvmStatic
    public static final void start(String r100) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L9
        a.f554342a.getClass();     // Catch: Throwable -> L9
        CJPerformanceService r102 = (CJPerformanceService) a.a(CJPerformanceService.class);     // Catch: Throwable -> L9
        if (r102 == null) goto L6;
        r102.start(r100);     // Catch: Throwable -> L9
        Unit r103 = Unit.INSTANCE;     // Catch: Throwable -> L9
    L7:
        Result.m9449constructorimpl(r103);     // Catch: Throwable -> L9
        return;
    L6:
        r103 = null;
    L9:
        th = move-exception;
        Result.Companion r104 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    }

    @JvmStatic
    public static final void stop(String r100) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L9
        a.f554342a.getClass();     // Catch: Throwable -> L9
        CJPerformanceService r102 = (CJPerformanceService) a.a(CJPerformanceService.class);     // Catch: Throwable -> L9
        if (r102 == null) goto L6;
        r102.stop(r100);     // Catch: Throwable -> L9
        Unit r103 = Unit.INSTANCE;     // Catch: Throwable -> L9
    L7:
        Result.m9449constructorimpl(r103);     // Catch: Throwable -> L9
        return;
    L6:
        r103 = null;
    L9:
        th = move-exception;
        Result.Companion r104 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    }

    public final void doFPSMonitor(final String r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        if (CJPayOptimizeSwitch.Companion.get().fpsOpen == false) goto L11;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L6
        stop(r100);     // Catch: Throwable -> L6
        start(r100);     // Catch: Throwable -> L6
        b.g(new CJPerformance$doFPSMonitor$1$1(r100), r101);     // Catch: Throwable -> L6
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        Result.Companion r103 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        return;
    }

    public static /* synthetic */ void doFPSMonitor$default(CJPerformance r100, String r101, long r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L5;
        r102 = 5000;
    L5:
        r100.doFPSMonitor(r101, r102);
    }
}
