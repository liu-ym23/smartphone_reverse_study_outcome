package com.bytedance.android.livesdk.widgetdescriptor.priority;

import com.bytedance.android.live.core.utils.a0;
import com.bytedance.android.livesdkapi.model.VSOptimizeConfig;
import com.bytedance.android.livesdkapi.strategy.StrategyConvertHelper;
import com.bytedance.ies.sdk.widgets.DataCenter;
import j40.z3;
import java.util.Map;
import java.util.TreeMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class b implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f162441a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, Double> f162442b;

    @Override // com.bytedance.android.livesdk.widgetdescriptor.priority.c
    public final TreeMap<Double, com.bytedance.android.livesdk.widgetdescriptor.loadstrategy.a> a() {
        return this.f162441a.a();
    }

    @Override // com.bytedance.android.livesdk.widgetdescriptor.priority.c
    public final TreeMap<Double, com.bytedance.android.livesdk.widgetdescriptor.loadstrategy.a> b() {
        return this.f162441a.b();
    }

    @Override // com.bytedance.android.livesdk.widgetdescriptor.priority.c
    public final TreeMap<Double, com.bytedance.android.livesdk.widgetdescriptor.loadstrategy.a> c() {
        return this.f162441a.c();
    }

    @Override // com.bytedance.android.livesdk.widgetdescriptor.priority.c
    public final TreeMap<Double, com.bytedance.android.livesdk.widgetdescriptor.loadstrategy.a> d() {
        return this.f162441a.d();
    }

    @Override // com.bytedance.android.livesdk.widgetdescriptor.priority.c
    public final void release() {
        this.f162441a.release();
    }

    public b(Map<String, Double> r100, e r101, DataCenter r110, h70.b r111) {
        Intrinsics.checkNotNullParameter(r111, "layerContext");
        this.f162442b = r100;
        VSOptimizeConfig r102 = (VSOptimizeConfig) StrategyConvertHelper.getObjectStrategyValue$default("live_vs_optimize_config_smart", z3.f497333a.getValue(), false, false, 12, null);
        if (r110 != null) goto L5;
    L9:
        d r103 = new a(r100, r101, r110, r111);
    L10:
        this.f162441a = r103;
        return;
    L5:
        if (a0.k(r110) != true) goto L9;
        if (r102.getEnterRoom() == false) goto L9;
        r103 = new VSOtherSplitStrategy(r100, r101, r110, r111);
        goto L10
    }
}
