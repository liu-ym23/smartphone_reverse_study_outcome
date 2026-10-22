package com.bytedance.android.shopping.card_list.monitor.cache;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public final class CacheMonitor {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Map<String, CacheMonitor> f171680d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final gb3.a f171681a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f171682b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final JSONObject f171683c;

    public static final class a {
    }

    static {
        f171680d = new LinkedHashMap();
    }

    public CacheMonitor(JSONObject r100) {
        this.f171683c = r100;
        this.f171681a = new gb3.a(r100.optString("page_name"), r100.optString("page_type"));
        this.f171682b = LazyKt.lazy(new CacheMonitor$baseParamMap$2(this));
    }

    public static void b(CacheMonitor r100, String r101, String r102) {
        Map<? extends String, ? extends Object> r103 = MapsKt.emptyMap();
        Intrinsics.checkNotNullParameter(r101, "result");
        Intrinsics.checkNotNullParameter(r102, "newSourceType");
        Intrinsics.checkNotNullParameter(r103, "extra");
        gb3.a r104 = r100.f171681a;
        Map<String, ? extends Object> r105 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("operate_type", "write"), TuplesKt.to("result", r101), TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_NEW_SOURCE_TYPE, r102)});
        r105.putAll(r103);
        r105.putAll((Map) r100.f171682b.getValue());
        Unit r106 = Unit.INSTANCE;
        r104.a("card_list_cache_operate", r105, null, null);
    }

    public static void a(CacheMonitor r100, String r101, String r102, String r103) {
        Map<? extends String, ? extends Object> r104 = MapsKt.emptyMap();
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "result");
        Intrinsics.checkNotNullParameter(r102, "renderNewSourceType");
        Intrinsics.checkNotNullParameter(r103, "cachedNewSourceType");
        Intrinsics.checkNotNullParameter(r104, "extra");
        gb3.a r105 = r100.f171681a;
        Map<String, ? extends Object> r106 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("operate_type", "read"), TuplesKt.to("result", r101), TuplesKt.to("reader_new_source_type", r102), TuplesKt.to("cached_new_source_type", r103)});
        r106.putAll(r104);
        r106.putAll((Map) r100.f171682b.getValue());
        Unit r107 = Unit.INSTANCE;
        r105.a("card_list_cache_operate", r106, null, null);
    }
}
