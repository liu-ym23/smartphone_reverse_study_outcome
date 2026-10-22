package com.bytedance.android.shopping.card_list.monitor;

import com.bytedance.android.shopping.card_list.monitor.cache.CacheMonitor;
import com.bytedance.android.shopping.card_list.monitor.firstScreen.CardListYataFirstScreenDurationMonitor;
import com.bytedance.android.shopping.card_list.monitor.fps.CardListYataFpsMonitor;
import com.bytedance.android.shopping.card_list.monitor.success_rate.CardListSuccessRateMonitor;
import com.bytedance.kmp.ec.yata.common.perf.d;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public final class CardListYataMonitorManager {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final Map<String, CardListYataMonitorManager> f171668k = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f171669a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f171670b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f171671c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public CardListYataFirstScreenDurationMonitor f171672d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public com.bytedance.android.shopping.card_list.monitor.error.a f171673e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public CardListYataFpsMonitor f171674f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public CardListSuccessRateMonitor f171675g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public d f171676h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public CacheMonitor f171677i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final JSONObject f171678j;

    public static final class a {
        public static CardListYataMonitorManager a(String r100) {
            return (CardListYataMonitorManager) ((LinkedHashMap) CardListYataMonitorManager.f171668k).get(r100);
        }
    }

    static {
        f171668k = new LinkedHashMap();
    }

    public CardListYataMonitorManager(JSONObject r100) {
        this.f171678j = r100;
        this.f171669a = LazyKt.lazy(new CardListYataMonitorManager$pageName$2(this));
        this.f171670b = LazyKt.lazy(new CardListYataMonitorManager$previousPage$2(this));
        this.f171671c = LazyKt.lazy(new CardListYataMonitorManager$sessionId$2(this));
    }
}
