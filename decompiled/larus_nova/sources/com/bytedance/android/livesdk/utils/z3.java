package com.bytedance.android.livesdk.utils;

import androidx.lifecycle.LiveData;
import com.bytedance.android.live.strategy.api.IStrategyService;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes11.dex */
public final class z3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<String, Integer> f159234a = null;

    static {
        f159234a = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("mode", 1)});
    }

    public static Map b() {
        IStrategyService r100 = (IStrategyService) jc1.k.f(IStrategyService.class);
        if (r100 == null) goto L7;
        LiveData r101 = IStrategyService.a.a(r100, "live_gradient_brightness_config", f159234a, false, 12);
        if (r101 == null) goto L7;
        return (Map) r101.getValue();
    L7:
        return null;
    }

    public static float a(Map r100, String r101, float r102) {
        Object r103 = r100.get(r101);
        if ((r103 instanceof Number) == true) goto L5;
        r103 = null;
    L5:
        Number r104 = (Number) r103;
        if (r104 != null) goto L8;
        return r102;
    L8:
        return r104.floatValue();
    }
}
