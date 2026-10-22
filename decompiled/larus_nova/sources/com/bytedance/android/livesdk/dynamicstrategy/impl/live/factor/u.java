package com.bytedance.android.livesdk.dynamicstrategy.impl.live.factor;

import com.bytedance.android.live.feature.api.IFeatureService;
import com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor;
import kotlin.Result;
import kotlin.ResultKt;
import r52.x1;
import r52.y1;

/* JADX INFO: loaded from: classes8.dex */
public final class u extends DynamicFactor<Integer> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Double f123182b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Double f123183c;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor
    public final Integer b() {
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L32
        IFeatureService r101 = (IFeatureService) jc1.k.f(IFeatureService.class);     // Catch: Throwable -> L32
        float r102 = -1.0f;
        if (r101 == null) goto L10;
        z90.a r103 = r101.getFeatureManager();     // Catch: Throwable -> L32
        if (r103 == null) goto L10;
        Float r104 = (Float) r103.getFeature("cpu_rate", Float.valueOf(-1.0f));     // Catch: Throwable -> L32
        if (r104 == null) goto L10;
        float r105 = r104.floatValue();     // Catch: Throwable -> L32
    L11:
        IFeatureService r106 = (IFeatureService) jc1.k.f(IFeatureService.class);     // Catch: Throwable -> L32
        if (r106 == null) goto L18;
        z90.a r107 = r106.getFeatureManager();     // Catch: Throwable -> L32
        if (r107 == null) goto L18;
        Float r108 = (Float) r107.getFeature("memory_available_rate", Float.valueOf(-1.0f));     // Catch: Throwable -> L32
        if (r108 == null) goto L18;
        r102 = r108.floatValue();     // Catch: Throwable -> L32
    L18:
        float r109 = 0;
        if (r105 < r109) goto L39;
        if (r102 < r109) goto L39;
        double r110 = (((double) (1 - r102)) * 0.1d) + (((double) r105) * 0.9d);     // Catch: Throwable -> L32
        if (r110 > this.f123182b.doubleValue()) goto L27;
        return 3;
    L27:
        if (r110 > this.f123183c.doubleValue()) goto L38;
        return 2;
    L38:
        return 1;
    L39:
        return -1;
    L10:
        r105 = -1.0f;
    L32:
        th = move-exception;
        Result.Companion r111 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        return -1;
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor
    public final String c() {
        return "live_realtime_performance";
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor
    public final void d() {
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor
    public final void e() {
    }

    public u() {
        this.f123182b = y1.f536288a.getValue();
        this.f123183c = x1.f536283a.getValue();
    }
}
