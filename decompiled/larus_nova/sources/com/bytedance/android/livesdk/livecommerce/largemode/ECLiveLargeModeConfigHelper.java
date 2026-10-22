package com.bytedance.android.livesdk.livecommerce.largemode;

import android.util.LruCache;
import com.bytedance.android.livesdk.livecommerce.largemode.model.ComponentLargeModeConfig;
import com.bytedance.android.livesdk.livecommerce.largemode.model.LargeModeConfig;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes10.dex */
public final class ECLiveLargeModeConfigHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f149245a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f149246b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Map<String, Map<String, LargeModeConfig>> f149247c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final LruCache<String, Map<String, Map<String, ComponentLargeModeConfig>>> f149248d = null;

    static {
        f149245a = LazyKt.lazy(ECLiveLargeModeConfigHelper$scaleLevel$2.INSTANCE);
        f149246b = LazyKt.lazy(ECLiveLargeModeConfigHelper$SETTINGS_LARGE_MODE_CONFIG_VALUE$2.INSTANCE);
        Pair[] r100 = {TuplesKt.to("PromotionCard", ki2.b.f503601a), TuplesKt.to("ExplainCard", ii2.b.f489986a), TuplesKt.to("List", ji2.b.f499171a)};
        LargeModeConfig r101 = ki2.a.f503600a;
        LargeModeConfig r110 = ii2.a.f489985a;
        LargeModeConfig r111 = ji2.a.f499170a;
        f149247c = MapsKt.mapOf(new Pair[]{TuplesKt.to("1.0", MapsKt.mapOf(r100)), TuplesKt.to("1.15", MapsKt.mapOf(new Pair[]{TuplesKt.to("PromotionCard", r101), TuplesKt.to("ExplainCard", r110), TuplesKt.to("List", r111)})), TuplesKt.to("1.3", MapsKt.mapOf(new Pair[]{TuplesKt.to("PromotionCard", r101), TuplesKt.to("ExplainCard", r110), TuplesKt.to("List", r111)}))});
        f149248d = new LruCache(2);
    }
}
