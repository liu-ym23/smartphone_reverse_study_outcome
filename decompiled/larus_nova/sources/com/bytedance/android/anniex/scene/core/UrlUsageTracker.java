package com.bytedance.android.anniex.scene.core;

import android.os.Build;
import android.os.Message;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.bytedance.android.anniex.optimize.UsageLynxOptimize;
import com.bytedance.android.anniex.scene.connect.SceneConnectCenter;
import com.bytedance.android.anniex.scene.data.SceneDbManager;
import com.bytedance.android.anniex.scene.handler.idle.TaskType;
import com.bytedance.android.anniex.scene.settings.SwitchCenter;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.bytedance.ies.bullet.service.base.c1;
import com.bytedance.ies.bullet.service.base.r;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.lynx.devtoolwrapper.ScreenshotMode;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
public final class UrlUsageTracker {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static UrlUsageTracker f41107n;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f41108a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap<String, a> f41109b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile int f41110c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f41111d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f41112e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f41113f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f41114g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f41115h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Lazy f41116i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f41117j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f41118k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f41119l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final ConcurrentLinkedDeque<String> f41120m;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f41121a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f41122b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f41123c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f41124d;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (this.f41121a == r101.f41121a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f41122b, r101.f41122b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f41123c, r101.f41123c) == true) goto L18;
            return false;
        L18:
            if (this.f41124d == r101.f41124d) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            int r100 = ((this.f41121a * 31) + this.f41122b.hashCode()) * 31;
            String r101 = this.f41123c;
            if (r101 != null) goto L5;
            int r102 = 0;
        L7:
            return ((r100 + r102) * 31) + this.f41124d;
        L5:
            r102 = r101.hashCode();
            goto L7
        }

        public final String toString() {
            return "CacheRecord(count=" + this.f41121a + ", url=" + this.f41122b + ", identifyUrl=" + this.f41123c + ", status=" + this.f41124d + ')';
        }

        public a(String r100, String r101, int r102) {
            Intrinsics.checkNotNullParameter(r100, "url");
            this.f41121a = 1;
            this.f41122b = r100;
            this.f41123c = r101;
            this.f41124d = r102;
        }
    }

    public static final class b {
        public static UrlUsageTracker a() {
            if (UrlUsageTracker.f41107n != null) goto L5;
            UrlUsageTracker.f41107n = new UrlUsageTracker();
        L5:
            UrlUsageTracker r100 = UrlUsageTracker.f41107n;
            Intrinsics.checkNotNull(r100);
            return r100;
        }
    }

    public static final class c implements va.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ UrlUsageTracker f41125a;

        public c(UrlUsageTracker r100) {
            this.f41125a = r100;
        }

        @Override // va.d
        public final void a(Message r100) {
            Intrinsics.checkNotNullParameter(r100, "msg");
            if (r100.what != 5) goto L11;
            UrlUsageTracker.b(this.f41125a);     // Catch: Exception -> L6
            return;
        L6:
            e = move-exception;
            HybridLogger r101 = HybridLogger.f246343a;
            UrlUsageTracker r102 = UrlUsageTracker.f41107n;
            HybridLogger.i("UrlUsageTracker", "queryTopUrls 数据查询异常：" + e.getMessage(), null, 12);
            return;
        }

        @Override // va.d
        public final void b(Message r100) {
            Intrinsics.checkNotNullParameter(r100, "msg");
            if (r100.what != 4) goto L14;
            Map<String, a> r101 = MapsKt.toMap(this.f41125a.f41109b);     // Catch: Exception -> L9
            Intrinsics.checkNotNullParameter(r101, "data");     // Catch: Exception -> L9
            SceneDbManager r102 = (SceneDbManager) this.f41125a.f41108a.getValue();     // Catch: Exception -> L9
            if (r102 == null) goto L7;
            r102.d(UrlUsageTracker.a(this.f41125a), r101);     // Catch: Exception -> L9
        L7:
            this.f41125a.f41109b.clear();     // Catch: Exception -> L9
            this.f41125a.f41110c = 0;     // Catch: Exception -> L9
            return;
        L9:
            e = move-exception;
            HybridLogger r103 = HybridLogger.f246343a;
            UrlUsageTracker r104 = UrlUsageTracker.f41107n;
            HybridLogger.i("UrlUsageTracker", "flushBatch 数据入库异常：" + e.getMessage(), null, 12);
            return;
        }
    }

    static {
    }

    public final void d() {
        if (((Boolean) SwitchCenter.f41334w.getValue()).booleanValue() == true) goto L5;
        return;
    L5:
        if (Build.VERSION.SDK_INT >= 26) goto L7;
        return;
    L7:
        if (this.f41117j == true) goto L12;
        va.a.C7976a r100 = va.a.f553911g;
        r100.a().a();
        va.a r101 = r100.a();
        c r102 = new c(this);
        Intrinsics.checkNotNullParameter(r102, "urlUsageHandlerAPI");
        r101.f553917e = r102;
        this.f41117j = true;
        return;
    }

    public UrlUsageTracker() {
        this.f41108a = LazyKt.lazy(UrlUsageTracker$sceneDbHelper$2.INSTANCE);
        this.f41109b = new ConcurrentHashMap();
        this.f41111d = ((Number) SwitchCenter.f41337z.getValue()).intValue();
        this.f41112e = ((Number) SwitchCenter.A.getValue()).intValue();
        this.f41114g = LazyKt.lazy(UrlUsageTracker$preloadData$2.INSTANCE);
        this.f41115h = LazyKt.lazy(new UrlUsageTracker$preloadMap$2(this));
        this.f41116i = LazyKt.lazy(new UrlUsageTracker$lastPreloadedList$2(this));
        this.f41120m = new ConcurrentLinkedDeque();
    }

    public static final j a(UrlUsageTracker r100) {
        r100.getClass();
        List r101 = (List) SwitchCenter.Q.getValue();
        if (r101 == null) goto L8;
        if (r101.size() != 2) goto L8;
        return new j(((Number) ListProtector.get(r101, 0)).floatValue(), ((Number) ListProtector.get(r101, 1)).floatValue());
    L8:
        return new j(0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v17 */
    /* JADX WARN: Type inference failed for: r4v1, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r4v2, types: [java.lang.Object, java.util.List] */
    /* JADX WARN: Type inference failed for: r4v3, types: [java.util.ArrayList] */
    public static final void b(UrlUsageTracker r210) {
        r210.getClass();
        if (((Boolean) SwitchCenter.O.getValue()).booleanValue() == false) goto L7;
        SceneDbManager r100 = (SceneDbManager) r210.f41108a.getValue();
        if (r100 == null) goto L8;
        Triple<List<com.bytedance.android.anniex.scene.data.c>, Double, Double> r101 = r100.h(((Number) SwitchCenter.H.getValue()).longValue());
    L10:
        if (r101 == null) goto L27;
        Lazy r102 = SceneConnectCenter.f41082a;
        List<com.bytedance.android.anniex.scene.data.c> r103 = r101.getFirst();
        double r104 = r101.getSecond().doubleValue();
        double r105 = r101.getThird().doubleValue();
        Intrinsics.checkNotNullParameter(r103, "hotUrls");
        HybridLogger r110 = HybridLogger.f246343a;
        HybridLogger.f("UrlUsageTracker", "reportPredictUrlUsage url size:" + r103.size() + ", ratio:" + r104 + ", enableRatio:" + r105, null, 12);
        s26.d r111 = s26.d.f540305c;
        r r112 = (r) s26.d.f540305c.c(r.class);
        if (r112 == null) goto L27;
        c1 r113 = new c1("bdx_monitor_annie_hot_url_usage", null, null, null, null, 254);
        JSONObject r114 = new JSONObject();     // Catch: Exception -> L23
        Iterator r115 = CollectionsKt.take(r103, 20).iterator();     // Catch: Exception -> L23
        int r116 = 0;
    L16:
        if (r115.hasNext() == false) goto L21;
        Object r117 = r115.next();     // Catch: Exception -> L23
        int r106 = r116 + 1;     // Catch: Exception -> L23
        if (r116 >= 0) goto L20;
        CollectionsKt.throwIndexOverflow();     // Catch: Exception -> L23
    L20:
        r114.put("top_" + r106 + "_url_usage", ((com.bytedance.android.anniex.scene.data.c) r117).f41185a);     // Catch: Exception -> L23
        r116 = r106;
        goto L16
    L21:
        r114.put("report_type", "predict");     // Catch: Exception -> L23
        r113.f247794d = r114;     // Catch: Exception -> L23
        JSONObject r107 = new JSONObject();     // Catch: Exception -> L23
        r107.put(MapBundleKey.OfflineMapKey.OFFLINE_RATION, r104);     // Catch: Exception -> L23
        r107.put("enable_ratio", r105);     // Catch: Exception -> L23
        r107.put("hot_list_size", r103.size());     // Catch: Exception -> L23
        r113.f247795e = r107;     // Catch: Exception -> L23
    L25:
        r112.S(r113);
    L23:
        e = move-exception;
        HybridLogger r108 = HybridLogger.f246343a;
        HybridLogger.i("UrlUsageTracker", "reportPredictUrlUsage error:" + e.getMessage(), null, 12);
    L27:
        if (((Boolean) SwitchCenter.L.getValue()).booleanValue() == false) goto L55;
        if (r210.f41113f == false) goto L31;
    L53:
        r210.f41113f = true;
        goto L55
    L31:
        if (((String[]) r210.f41116i.getValue()).length != 0) goto L33;
        boolean r109 = true;
    L35:
        if ((!r109) == false) goto L53;
        ArrayList r118 = new ArrayList(((String[]) r210.f41116i.getValue()).length);
        String[] r119 = (String[]) r210.f41116i.getValue();
        int r120 = r119.length;
        int r121 = 0;
    L37:
        if (r121 >= r120) goto L43;
        String r122 = r119[r121];
        if (((HashSet) r210.f41115h.getValue()).contains(r122) == true) goto L41;
        r118.add(r122);
    L41:
        r121 = r121 + 1;
        goto L37
    L43:
        if ((!r118.isEmpty()) == false) goto L53;
        HybridLogger r123 = HybridLogger.f246343a;
        HybridLogger.f("UrlUsageTracker", "准备清理不再高热的URL缓存，数量: " + r118.size(), null, 12);
        Iterator r124 = r118.iterator();
    L46:
        if (r124.hasNext() == false) goto L53;
        final String r125 = (String) r124.next();
        if (r125.length() <= 0) goto L50;
        boolean r126 = true;
    L51:
        if (r126 == false) goto L46;
        com.bytedance.android.anniex.scene.handler.idle.c.a r127 = new com.bytedance.android.anniex.scene.handler.idle.c.a();
        r127.f41209c = 100;
        r127.f41211e = 0;
        r127.f41212f = false;
        Intrinsics.checkNotNullParameter("clear_not_hot_usage_cache", "tag");
        r127.f41208b = "clear_not_hot_usage_cache";
        r127.f41211e = ((Number) SwitchCenter.M.getValue()).longValue();
        Function1<com.bytedance.android.anniex.scene.data.c, Unit> r128 = new UrlUsageTracker$doClearNotHotUsageCache$1$preloadTask$1(r125);
        Intrinsics.checkNotNullParameter(r128, "r");
        r127.f41214h = r128;
        com.bytedance.android.anniex.scene.handler.idle.h.f41220a.a(r127.a(TaskType.CLEAR_NOT_HOT_USAGE_CACHE));
        goto L46
    L50:
        r126 = false;
        goto L51
    L33:
        r109 = false;
    L55:
        if (((Boolean) SwitchCenter.f41335x.getValue()).booleanValue() == false) goto L108;
        if (r101 == null) goto L83;
        List<com.bytedance.android.anniex.scene.data.c> r129 = r101.getFirst();
        if (r129 == null) goto L83;
        List r130 = (List) SwitchCenter.F.getValue();
        if (r130 != null) goto L62;
        r130 = CollectionsKt.emptyList();
    L62:
        ?? r131 = new ArrayList();
        Iterator r132 = r129.iterator();
    L64:
        if (r132.hasNext() == false) goto L84;
        Object r133 = r132.next();
        com.bytedance.android.anniex.scene.data.c r134 = (com.bytedance.android.anniex.scene.data.c) r133;
        if (Intrinsics.areEqual(r134.f41185a, ScreenshotMode.SCREEN_SHOT_MODE_LYNX_VIEW) == true) goto L80;
        List r135 = r130;
        if ((r135 instanceof Collection) == true) goto L70;
    L72:
        Iterator r136 = r135.iterator();
    L74:
        if (r136.hasNext() == false) goto L71;
        if (StringsKt.contains$default(r134.f41185a, (String) r136.next(), false, 2, null) == false) goto L74;
        boolean r137 = false;
    L78:
        if (r137 == false) goto L80;
        boolean r138 = true;
    L81:
        if (r138 == false) goto L64;
        r131.add(r133);
    L71:
        r137 = true;
        goto L78
    L70:
        if (r135.isEmpty() == false) goto L72;
    L80:
        r138 = false;
    L84:
        Lazy r139 = SceneConnectCenter.f41082a;
        Intrinsics.checkNotNullParameter(r131, "list");
        Iterable r140 = (Iterable) r131;
        ArrayList r141 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r140, 10));
        Iterator r142 = r140.iterator();
    L86:
        if (r142.hasNext() == false) goto L88;
        r141.add(((com.bytedance.android.anniex.scene.data.c) r142.next()).f41185a);
        goto L86
    L88:
        Object[] r143 = r141.toArray(new String[0]);
        if (r143 == null) goto L107;
        String[] r144 = (String[]) r143;
        HybridLogger r145 = HybridLogger.f246343a;
        HybridLogger.f("UrlUsageTracker", "recordLastCodeCacheMap identifyUrl Size : " + r144.length, null, 12);
        SceneConnectCenter.a().storeStringArray("bdx_anniex_last_code_preload_list_url", r144);
        if (((Boolean) SwitchCenter.f41336y.getValue()).booleanValue() == true) goto L93;
        return;
    L93:
        if (((Boolean) SwitchCenter.f41315j0.getValue()).booleanValue() == false) goto L95;
        boolean r146 = true;
    L96:
        if (r146 == false) goto L132;
        long r147 = System.currentTimeMillis();
        if (SceneConnectCenter.f41084c != 0) goto L101;
        SceneConnectCenter.f41084c = SceneConnectCenter.a().getLong("bdx_anniex_last_code_preload_task", 0);
    L101:
        if ((r147 - SceneConnectCenter.f41084c) <= ((((Number) SwitchCenter.f41295J.getValue()).longValue() * ((long) 60)) * ((long) 1000))) goto L103;
        long r148 = System.currentTimeMillis();
        SceneConnectCenter.f41084c = r148;
        SceneConnectCenter.a().storeLong("bdx_anniex_last_code_preload_task", r148);
        boolean r149 = true;
    L104:
        if (r149 == false) goto L133;
        r210.f41119l = true;
        UsageLynxOptimize.d(r131);
        return;
    L133:
        return;
    L103:
        r149 = false;
        goto L104
    L132:
        return;
    L95:
        r146 = !r210.f41119l;
        goto L96
    L107:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    L83:
        r131 = CollectionsKt.emptyList();
        goto L84
    L108:
        return;
    L8:
        r101 = null;
        goto L10
    L7:
        ((Boolean) SwitchCenter.P.getValue()).booleanValue();
        goto L8
    }

    public final boolean c(String r100, String r110) {
        if (r110 == null) goto L8;
        if (((HashSet) this.f41115h.getValue()).contains(r110) == false) goto L8;
        return true;
    L8:
        if (SwitchCenter.c() == false) goto L29;
        this.f41120m.add(r100);
        if ((this.f41120m.size() % ((Number) SwitchCenter.f41337z.getValue()).intValue()) != 0) goto L30;
        Lazy r101 = SceneConnectCenter.f41082a;
        List r102 = CollectionsKt.toList(this.f41120m);
        Intrinsics.checkNotNullParameter(r102, "urls");
        if (r102.isEmpty() == false) goto L14;
    L24:
        this.f41120m.clear();
        return false;
    L14:
        if (SwitchCenter.c() == false) goto L24;
        s26.d r111 = s26.d.f540305c;
        r r112 = (r) s26.d.f540305c.c(r.class);
        if (r112 == null) goto L24;
        c1 r103 = new c1("bdx_anniex_code_cache_failed_urls", null, null, null, null, 254);
        JSONObject r104 = new JSONObject();     // Catch: Exception -> L21
        r104.put("failed_urls", r102.toString());     // Catch: Exception -> L21
        r103.f247794d = r104;     // Catch: Exception -> L21
        JSONObject r105 = new JSONObject();     // Catch: Exception -> L21
        r105.put("size", r102.size());     // Catch: Exception -> L21
        r103.f247795e = r105;     // Catch: Exception -> L21
    L23:
        r112.S(r103);
    L21:
        e = move-exception;
        HybridLogger r106 = HybridLogger.f246343a;
        HybridLogger.i("UrlUsageTracker", "reportCodeCacheFailedUrls error:" + e.getMessage(), null, 12);
        goto L23
    L30:
        return false;
    L29:
        return false;
    }
}
