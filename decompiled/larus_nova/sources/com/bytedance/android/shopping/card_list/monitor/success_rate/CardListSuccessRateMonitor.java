package com.bytedance.android.shopping.card_list.monitor.success_rate;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public final class CardListSuccessRateMonitor {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Map<String, CardListSuccessRateMonitor> f171707g = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f171708a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f171709b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f171710c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f171711d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f171712e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final JSONObject f171713f;

    public static final class a {
    }

    public final Map<String, String> a() {
        return MapsKt.mapOf(new Pair[]{TuplesKt.to("EVENT_PAGE_TECHNOLOGY", "YATA_Android"), TuplesKt.to("page_name", (String) this.f171709b.getValue()), TuplesKt.to("previous_page", (String) this.f171710c.getValue()), TuplesKt.to("session_id", (String) this.f171711d.getValue()), TuplesKt.to("page_type", this.f171713f.optString("page_type")), TuplesKt.to("status", String.valueOf(0))});
    }

    static {
        f171707g = new LinkedHashMap();
    }

    public CardListSuccessRateMonitor(JSONObject r100) {
        this.f171713f = r100;
        this.f171709b = LazyKt.lazy(new CardListSuccessRateMonitor$pageName$2(this));
        this.f171710c = LazyKt.lazy(new CardListSuccessRateMonitor$previousPage$2(this));
        this.f171711d = LazyKt.lazy(new CardListSuccessRateMonitor$sessionId$2(this));
        this.f171712e = LazyKt.lazy(new CardListSuccessRateMonitor$bizType$2(this));
    }
}
