package com.bytedance.android.shopping.mall.homepage.tools;

import android.content.Context;
import android.location.LocationManager;
import android.os.Looper;
import com.amap.api.services.geocoder.GeocodeSearch;
import com.bytedance.android.ec.base.settings.SDKSettingsCacheManager;
import com.bytedance.android.ec.hybrid.data.ECHybridDataEngine;
import com.bytedance.android.ec.hybrid.data.network.ECHybridNetworkTask;
import com.bytedance.android.ec.hybrid.hostapi.IHybridHostService;
import com.bytedance.android.ec.hybrid.list.entity.dto.ECNAMallCardExtra;
import com.bytedance.android.ec.hybrid.log.mall.ECMallLogUtil;
import com.bytedance.android.ec.hybrid.monitor.HybridAppInfoService;
import com.bytedance.android.shopping.api.mall.IECMallAddressService;
import com.bytedance.android.shopping.api.mall.common.homepage.card.BigFontAdapter;
import com.bytedance.android.shopping.api.mall.common.tools.NativeMallGeckoHelper;
import com.bytedance.android.shopping.api.mall.common.tools.StorageItemDataProvider;
import com.bytedance.android.shopping.api.mall.model.HomePageDTO;
import com.bytedance.android.shopping.verse.api.IVerseService;
import com.bytedance.common.utility.Logger;
import com.bytedance.sdk.account.platform.base.OnekeyLoginConstants;
import com.bytedance.services.apm.api.EnsureManager;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.android.ugc.aweme.thread.ThreadPoolHelper;
import com.ss.android.ugc.effectmanager.EffectConfiguration;
import com.ttnet.org.chromium.base.BaseSwitches;
import com.ttnet.org.chromium.net.NetError;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public final class DataEngineWrapper implements com.bytedance.android.shopping.api.mall.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ECHybridDataEngine f178407a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public y93.a f178408b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Map<String, ? extends Object> f178409c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f178410d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f178411e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public com.bytedance.android.ec.hybrid.list.util.d f178412f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ConcurrentHashMap<String, Object> f178413g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f178414h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Lazy f178415i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Lazy f178416j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Lazy f178417k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Lazy f178418l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Lazy f178419m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Lazy f178420n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Lazy f178421o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Lazy f178422p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public com.bytedance.android.ec.hybrid.tools.b<String> f178423q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public volatile String f178424r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public volatile boolean f178425s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public volatile HomePageDTO f178426t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public volatile HomePageDTO f178427u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public Integer f178428v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public volatile Function1<? super Long, ? extends JSONObject> f178429w;

    public final class a implements com.bytedance.android.ec.hybrid.data.g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DataEngineWrapper f178430a;

        public a(DataEngineWrapper r100) {
            this.f178430a = r100;
        }

        @Override // com.bytedance.android.ec.hybrid.data.g
        public final Map<String, Object> a(String r110) {
            Intrinsics.checkNotNullParameter(r110, "apiKey");
            HashMap r100 = new HashMap();
            r100.put("page_num", "1");
            r100.put(EffectConfiguration.KEY_CURSOR, "0");
            r100.put("recommend_back_up_offset", "0");
            Map<String, ? extends Object> r101 = this.f178430a.f178409c;
            if (r101 == null) goto L10;
            Iterator<Map.Entry<String, ? extends Object>> r102 = r101.entrySet().iterator();
        L6:
            if (r102.hasNext() == false) goto L10;
            Map.Entry<String, ? extends Object> r103 = r102.next();
            String r104 = r103.getKey();
            Object r105 = r103.getValue();
            if (r100.containsKey(r104) == true) goto L6;
            r100.put(r104, r105.toString());
        L10:
            v93.a.f553778c.getClass();
            String r106 = v93.a.f553777b;
            if (r106.length() <= 0) goto L13;
            boolean r107 = true;
        L14:
            if (r107 == false) goto L16;
            r100.put("pitaya_info", r106);
        L16:
            Object r108 = null;
            if (r100.get("log_extra") != null) goto L35;
            Object r109 = r100.get("tab_id");
            JSONObject r111 = new JSONObject();
            if (r100.containsKey(this.f178430a.f178410d) == false) goto L25;
            DataEngineWrapper r112 = this.f178430a;
            String r113 = r112.f178410d;
            Object r114 = r100.get(r113);
            if ((r114 instanceof String) == true) goto L23;
            r114 = null;
        L23:
            DataEngineWrapper.b(r112, r111, r113, (String) r114);
        L25:
            if (r100.containsKey(this.f178430a.f178411e) == false) goto L30;
            DataEngineWrapper r115 = this.f178430a;
            String r116 = r115.f178411e;
            Object r117 = r100.get(r116);
            if ((r117 instanceof String) == true) goto L29;
            r117 = null;
        L29:
            DataEngineWrapper.b(r115, r111, r116, (String) r117);
        L30:
            if (r109 == null) goto L34;
            DataEngineWrapper.b(this.f178430a, r111, "tab_id", r109.toString());
            Object r118 = r100.get(com.bytedance.android.ec.core.event.a.KEY_TAB_NAME);
            if (r118 == null) goto L34;
            DataEngineWrapper.b(this.f178430a, r111, com.bytedance.android.ec.core.event.a.KEY_TAB_NAME, r118.toString());
        L34:
            Unit r119 = Unit.INSTANCE;
            r100.put("log_extra", r111.toString());
        L35:
            DataEngineWrapper r120 = this.f178430a;
            if (r120.f178428v != null) goto L38;
            r120.f178428v = com.bytedance.android.shopping.api.mall.common.tools.h.f170438b.getLocationPermissionParam();
        L38:
            Integer r121 = this.f178430a.f178428v;
            if (r121 != null) goto L161;
        L54:
            int r122 = com.bytedance.android.ec.hybrid.tools.f.f47635a;
            Object r123 = 0;
            int r124 = com.bytedance.android.ec.base.settings.c.f42815a;
            Result.Companion r125 = Result.Companion;     // Catch: Throwable -> L130
            Object r126 = com.bytedance.android.ec.base.settings.d.f42818c.get("ec_mall_legou_preload_ec_hybrid_config_opt");     // Catch: Throwable -> L105
            if (r126 != null) goto L60;
        L102:
            Object r127 = null;
        L103:
            Object r128 = Result.m9449constructorimpl(r127);     // Catch: Throwable -> L105
        L107:
            Throwable r129 = Result.m9452exceptionOrNullimpl(r128);     // Catch: Throwable -> L130
            if (r129 == null) goto L111;
            EnsureManager.ensureNotReachHere(r129);     // Catch: Throwable -> L130
        L111:
            if (Result.m9455isFailureimpl(r128) == false) goto L114;
            r128 = null;
        L114:
            if ((r128 instanceof Integer) == true) goto L116;
            r128 = null;
        L116:
            Object r130 = (Integer) r128;     // Catch: Throwable -> L130
            if (r130 == null) goto L119;
            r123 = r130;
        L139:
            if (((Number) r123).intValue() > 0) goto L141;
            this.f178430a.f178428v = null;
        L141:
            g(r100, r110);
            Map<String, ? extends Object> r131 = this.f178430a.f178409c;
            if (r131 == null) goto L144;
            Object r132 = r131.get("page_name");
        L146:
            if ((r132 instanceof String) == false) goto L149;
            r108 = r132;
        L149:
            String r133 = (String) r108;
            if (r133 != null) goto L152;
            r133 = "";
        L152:
            Lazy r134 = BigFontAdapter.f170278a;
            if (BigFontAdapter.b(r133) == false) goto L155;
            r100.put("big_font_enabled", 1);
            BigFontAdapter.FontType.Companion.getClass();
            r100.put("font_size_pref", Integer.valueOf(BigFontAdapter.FontType.a.a()));
        L155:
            ECMallFavoriteSectionHelper.K.getClass();
            if (Intrinsics.areEqual(ECMallFavoriteSectionHelper.a.a().a(), Boolean.TRUE) == false) goto L158;
            r100.put("is_active_refresh", Boolean.FALSE);
        L158:
            r100.put("can_client_nest_channel", Integer.valueOf(((Number) this.f178430a.f178421o.getValue()).intValue()));
            return r100;
        L144:
            r132 = null;
            goto L146
        L119:
            IHybridHostService r135 = com.bytedance.android.ec.hybrid.a.h();     // Catch: Throwable -> L130
            if (r135 == null) goto L122;
            Object r136 = r135.getHostABValue("ec_mall_legou_preload_ec_hybrid_config_opt", r123);     // Catch: Throwable -> L130
        L123:
            if (r136 == null) goto L139;
            if ((r136 instanceof Integer) == true) goto L127;
            r136 = null;
        L127:
            Object r137 = (Integer) r136;     // Catch: Throwable -> L130
            if (r137 == null) goto L139;
        L137:
            r123 = r137;
            goto L139
        L122:
            r136 = null;
            goto L123
        L60:
            if ((r126 instanceof Integer) == true) goto L62;
            Object r138 = null;
        L63:
            r127 = (Integer) r138;     // Catch: Throwable -> L105
            if (r127 != null) goto L103;
            if ((r126 instanceof Number) == false) goto L90;
            if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L75;
            Float r139 = Float.valueOf(((Number) r126).floatValue());     // Catch: Throwable -> L105
            if ((r139 instanceof Integer) == true) goto L73;
            r139 = null;
        L73:
            r127 = (Integer) r139;     // Catch: Throwable -> L105
            goto L103
        L75:
            if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L81;
            Double r140 = Double.valueOf(((Number) r126).doubleValue());     // Catch: Throwable -> L105
            if ((r140 instanceof Integer) == true) goto L79;
            r140 = null;
        L79:
            r127 = (Integer) r140;     // Catch: Throwable -> L105
            goto L103
        L81:
            if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L84;
            r127 = Integer.valueOf(((Number) r126).intValue());     // Catch: Throwable -> L105
            goto L103
        L84:
            if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Integer.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L90;
            Long r141 = Long.valueOf(((Number) r126).longValue());     // Catch: Throwable -> L105
            if ((r141 instanceof Integer) == true) goto L88;
            r141 = null;
        L88:
            r127 = (Integer) r141;     // Catch: Throwable -> L105
        L90:
            if ((r126 instanceof JSONObject) == false) goto L92;
        L167:
            SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L98
            Object r142 = SDKSettingsCacheManager.a().fromJson(r126.toString(), Integer.class);     // Catch: Throwable -> L98
            if ((r142 instanceof Integer) == true) goto L96;
            r142 = null;
        L96:
            Object r143 = Result.m9449constructorimpl((Integer) r142);     // Catch: Throwable -> L98
        L100:
            r127 = r143;
            if (Result.m9455isFailureimpl(r127) == false) goto L103;
        L98:
            th = move-exception;
            Result.Companion r144 = Result.Companion;     // Catch: Throwable -> L105
            r143 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L105
            goto L100
        L92:
            if ((r126 instanceof JSONArray) == false) goto L102;
        L62:
            r138 = r126;
        L105:
            th = move-exception;
            Result.Companion r145 = Result.Companion;     // Catch: Throwable -> L130
            r128 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L130
        L130:
            th = move-exception;
            Result.Companion r146 = Result.Companion;
            r137 = Result.m9449constructorimpl(ResultKt.createFailure(th));
            Throwable r147 = Result.m9452exceptionOrNullimpl(r137);
            if (r147 == null) goto L135;
            EnsureManager.ensureNotReachHere(r147);
        L135:
            if (Result.m9455isFailureimpl(r137) == false) goto L137;
        L161:
            int r148 = r121.intValue();     // Catch: Throwable -> L160
            Context r149 = com.bytedance.android.shopping.api.mall.common.tools.h.f170438b.getIHybridHostAppInfo().getApplicationContext();     // Catch: Throwable -> L160
            if (r149 == null) goto L43;
            Object r150 = r149.getSystemService("location");     // Catch: Throwable -> L160
        L45:
            if ((r150 instanceof LocationManager) == true) goto L47;
            r150 = null;
        L47:
            LocationManager r151 = (LocationManager) r150;     // Catch: Throwable -> L160
            if (r151 != null) goto L50;
        L52:
            String r152 = "2";
        L53:
            r100.put("webcast_gps_access", r152);     // Catch: Throwable -> L160
            goto L54
        L50:
            if (r151.isProviderEnabled(GeocodeSearch.GPS) != true) goto L52;
            r152 = String.valueOf(r148);     // Catch: Throwable -> L160
            goto L53
        L43:
            r150 = null;
            goto L45
        L13:
            r107 = false;
            goto L14
        }

        @Override // com.bytedance.android.ec.hybrid.data.g
        public final Map<String, Object> c(List<String> r100) {
            Intrinsics.checkNotNullParameter(r100, "keys");
            return new StorageItemDataProvider(com.bytedance.android.shopping.api.mall.common.tools.h.f170438b.getIHybridHostAppInfo().getApplicationContext()).a(r100);
        }

        @Override // com.bytedance.android.ec.hybrid.data.g
        public final Map<String, String> d(String r100) {
            Intrinsics.checkNotNullParameter(r100, "apiKey");
            return MapsKt.emptyMap();
        }

        @Override // com.bytedance.android.ec.hybrid.data.g
        public final Map e(String r100, String r101) {
            return new HashMap();
        }

        @Override // com.bytedance.android.ec.hybrid.data.g
        public final Map f(String r100, Map r101) {
            return new HashMap();
        }

        @Override // com.bytedance.android.ec.hybrid.data.g
        public final void g(Map<String, Object> r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "extraParams");
            Intrinsics.checkNotNullParameter(r101, "apiKey");
            if (r100.containsKey("ec_address_data") == false) goto L5;
            return;
        L5:
            if (Intrinsics.areEqual(r101, "homepage") == false) goto L7;
        L12:
            int r102 = k93.a.f502141a;
            boolean r103 = true;
            if ("".length() <= 0) goto L15;
            boolean r104 = true;
        L16:
            if (r104 == false) goto L41;
            String r105 = this.f178430a.d();
            if (r105 != null) goto L20;
        L23:
            boolean r106 = true;
        L24:
            if (r106 == false) goto L37;
            IECMallAddressService r107 = (IECMallAddressService) ServiceManager.get().getService(IECMallAddressService.class);
            if (r107 == null) goto L42;
            String r108 = null;
            String r109 = r107.getAddress(null, "");
            if (r109 != null) goto L30;
            return;
        L30:
            if (r109.length() > 0) goto L33;
            r103 = false;
        L33:
            if (r103 == false) goto L35;
            r108 = r109;
        L35:
            if (r108 == null) goto L44;
            this.f178430a.f178424r = r108;
            Unit r110 = Unit.INSTANCE;
            r100.put("ec_address_data", r108);
            return;
        L44:
            return;
        L42:
            return;
        L37:
            r100.put("ec_address_data", r105);
            return;
        L20:
            if (r105.length() == 0) goto L23;
            r106 = false;
            goto L24
        L41:
            return;
        L15:
            r104 = false;
            goto L16
        L7:
            if (Intrinsics.areEqual(r101, "favorite_feed") == true) goto L12;
            if (Intrinsics.areEqual(r101, "popup_get") == true) goto L12;
            if (Intrinsics.areEqual(r101, "homepage_refresh") == true) goto L12;
        }

        @Override // com.bytedance.android.ec.hybrid.data.g
        public final Map b(String r100, String r101, Map r102) {
            return new HashMap();
        }
    }

    public final class b implements ECHybridNetworkTask.a {
    }

    public final void B() {
        if (this.f178408b.r() != null) goto L6;
        this.f178408b = y93.a.a(this.f178408b, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 0, null, null, null, null, null, false, -1, -1, -1, -1, 126);
    L6:
        if (this.f178429w != null) goto L8;
        return;
    L8:
        if (this.f178408b.f566968b != null) goto L24;
        Function1<? super Long, ? extends JSONObject> r100 = this.f178429w;
        if (r100 == null) goto L16;
        Long r101 = this.f178408b.o();
        if (r101 == null) goto L14;
        long r102 = r101.longValue();
    L15:
        JSONObject r710 = r100.invoke(Long.valueOf(r102));
    L17:
        this.f178429w = null;
        if (r710 != null) goto L21;
        this.f178408b = y93.a.a(this.f178408b, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 1, null, null, null, null, null, false, -1, -1, -1, -1, 126);
        return;
    L21:
        this.f178408b = y93.a.a(this.f178408b, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 2, null, null, null, null, r710, false, -1, -1, -1, -1, 94);
        return;
    L14:
        r102 = -1;
        goto L15
    L16:
        r710 = null;
        goto L17
    }

    public final void H() {
        Lazy r100 = ECMallLogUtil.f47441a;
        ECMallLogUtil.c(com.bytedance.android.ec.hybrid.log.mall.e.b.f47470b, "DataEngineWrapper#resetChunkedState()@" + hashCode());
        this.f178425s = false;
        this.f178426t = null;
    }

    public final void I() {
        Lazy r100 = ECMallLogUtil.f47441a;
        ECMallLogUtil.c(com.bytedance.android.ec.hybrid.log.mall.e.b.f47470b, "DataEngineWrapper#resetPrefetchState()@" + hashCode());
        this.f178425s = false;
        this.f178426t = null;
    }

    public final void J() {
        Lazy r100 = ECMallLogUtil.f47441a;
        ECMallLogUtil.c(com.bytedance.android.ec.hybrid.log.mall.k.a.f47501b, "DataEngineWrapper#resetPrefetchedImages()@" + hashCode() + ", previousSize = " + Integer.valueOf(e().size()));
        this.f178423q = new com.bytedance.android.ec.hybrid.tools.b(((Number) this.f178418l.getValue()).intValue());
    }

    public final String d() {
        if (((Boolean) this.f178420n.getValue()).booleanValue() == true) goto L6;
        return null;
    L6:
        return this.f178424r;
    }

    public final com.bytedance.android.ec.hybrid.tools.b<String> e() {
        com.bytedance.android.ec.hybrid.tools.b<String> r100 = this.f178423q;
        if (r100 == null) goto L5;
        return r100;
    L5:
        com.bytedance.android.ec.hybrid.tools.b<String> r101 = new com.bytedance.android.ec.hybrid.tools.b(((Number) this.f178418l.getValue()).intValue());
        this.f178423q = r101;
        return r101;
    }

    public final void n() {
        Integer r100 = this.f178408b.h();
        if (r100 != null) goto L6;
    L8:
        this.f178408b = y93.a.a(this.f178408b, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 1, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, -268435457, -1, -1, -1, 127);
        return;
    L6:
        if (r100.intValue() != 1) goto L8;
    }

    public final void z() {
        this.f178408b = y93.a.a(this.f178408b, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 1, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, -1, -262145, -1, -1, 127);
    }

    public DataEngineWrapper() {
        this.f178408b = new y93.a(null, -1);
        this.f178410d = "xtab_toast_info";
        this.f178411e = "video_guide_mall";
        this.f178413g = new ConcurrentHashMap();
        this.f178414h = LazyKt.lazy(DataEngineWrapper$jsonParseOptEnable$2.INSTANCE);
        this.f178415i = LazyKt.lazy(DataEngineWrapper$firstScreenImageOptEnable$2.INSTANCE);
        this.f178416j = LazyKt.lazy(DataEngineWrapper$ioDispatchOptEnable$2.INSTANCE);
        this.f178417k = LazyKt.lazy(DataEngineWrapper$domainConnectConfig$2.INSTANCE);
        this.f178418l = LazyKt.lazy(DataEngineWrapper$prefetchedImageSetMaxSize$2.INSTANCE);
        this.f178419m = LazyKt.lazy(DataEngineWrapper$aiPrefetchExpiredDataReuseStrategy$2.INSTANCE);
        this.f178420n = LazyKt.lazy(DataEngineWrapper$addressDataCacheEnable$2.INSTANCE);
        this.f178421o = LazyKt.lazy(DataEngineWrapper$supportNestedScrollChannel$2.INSTANCE);
        this.f178422p = LazyKt.lazy(DataEngineWrapper$categoryTabConvertConfig$2.INSTANCE);
    }

    public static final String a(DataEngineWrapper r100) {
        Map<String, ? extends Object> r101 = r100.f178409c;
        if (r101 == null) goto L8;
        Object r102 = r101.get("page_name");
        if (r102 == null) goto L8;
        String r103 = r102.toString();
        if (r103 == null) goto L8;
        return r103;
    L8:
        return "";
    }

    public final void A(long r710) {
        this.f178408b = y93.a.a(this.f178408b, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 0, Long.valueOf(r710), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, -1, -524289, -1, -1, 127);
    }

    public final void D(final ECNAMallCardExtra r100) {
        Intrinsics.checkNotNullParameter(r100, "config");
        final com.bytedance.android.ec.hybrid.tools.b<String> r101 = e();
        ((Number) kk.d.a(0, new DataEngineWrapper$prefetchIdleImagesFrom$1(r100, r101))).intValue();
    }

    public final int E(final ECNAMallCardExtra r100) {
        Intrinsics.checkNotNullParameter(r100, "config");
        final com.bytedance.android.ec.hybrid.tools.b<String> r101 = e();
        if (r101 != null) goto L6;
        return 0;
    L6:
        return ((Number) kk.d.a(0, new DataEngineWrapper$prefetchImagesFrom$2(this, r100, r101))).intValue();
    }

    public final void G(Integer r710) {
        if (this.f178408b.b() == null) goto L5;
        return;
    L5:
        if (r710 == null) goto L7;
        int r100 = r710.intValue();
        this.f178408b = y93.a.a(this.f178408b, Integer.valueOf(r100), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, -2, -1, -1, -1, 127);
    L7:
        boolean r101 = com.bytedance.android.shopping.api.mall.common.tools.h.f170438b.getIHybridHostUserService().isLogin();
        this.f178408b = y93.a.a(this.f178408b, null, Integer.valueOf(r101 ? 1 : 0), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, -3, -1, -1, -1, 127);
    }

    public final void K(Map<String, ? extends Object> r710) {
        Intrinsics.checkNotNullParameter(r710, "map");
        this.f178408b = y93.a.a(this.f178408b, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, r710, null, false, -1, -1, -1, -1, 111);
    }

    public final void L(Function1<? super y93.a, y93.a> r100) {
        Intrinsics.checkNotNullParameter(r100, OnekeyLoginConstants.CU_KEY_OPERATOR);
        this.f178408b = r100.invoke(this.f178408b);
    }

    public final void c(int r710) {
        this.f178408b = y93.a.a(this.f178408b, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, Integer.valueOf(r710), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, -1, -1, -129, -1, 127);
    }

    public final void i(long r710) {
        this.f178408b = y93.a.a(this.f178408b, null, null, null, null, null, Long.valueOf(r710), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, -131073, -1, -1, -1, 127);
    }

    public final void j(long r710) {
        this.f178408b = y93.a.a(this.f178408b, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 0, null, null, null, null, null, null, Long.valueOf(r710), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, -1, -134217729, -1, -1, 127);
    }

    public final void k(long r710) {
        y93.a r100 = y93.a.a(this.f178408b, null, null, null, null, null, null, null, null, null, null, null, null, null, null, Long.valueOf(r710), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, -67108865, -1, -1, -1, 127);
        this.f178408b = r100;
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L8
        if (r100.A() != null) goto L6;
        this.f178408b = y93.a.a(this.f178408b, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, Long.valueOf(r710), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, -1, -1, -4097, -1, 127);     // Catch: Throwable -> L8
    L6:
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        Result.Companion r102 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    }

    public final void m(long r710) {
        this.f178408b = y93.a.a(this.f178408b, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, Long.valueOf(r710), null, null, null, null, null, null, null, null, null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, -1, -9, -1, -1, 127);
    }

    public final void o(long r710) {
        this.f178408b = y93.a.a(this.f178408b, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, Long.valueOf(r710), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, -134217729, -1, -1, -1, 127);
    }

    public final void p(long r710) {
        this.f178408b = y93.a.a(this.f178408b, null, null, null, null, null, null, null, null, null, null, null, null, null, Long.valueOf(r710), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, -33554433, -1, -1, -1, 127);
    }

    public final void q(long r710) {
        this.f178408b = y93.a.a(this.f178408b, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 0, null, null, Long.valueOf(r710), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, -1, -2097153, -1, -1, 127);
    }

    public final void r(long r710) {
        if (this.f178408b.n() == null) goto L5;
        return;
    L5:
        this.f178408b = y93.a.a(this.f178408b, null, null, null, null, null, null, null, null, null, Long.valueOf(r710), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, -2097153, -1, -1, -1, 127);
    }

    public final void t(long r710) {
        if (this.f178408b.p() == null) goto L5;
        return;
    L5:
        this.f178408b = y93.a.a(this.f178408b, null, null, null, null, null, null, null, null, Long.valueOf(r710), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, -1048577, -1, -1, -1, 127);
    }

    public final void u(long r710) {
        if (this.f178408b.q() == null) goto L5;
        return;
    L5:
        this.f178408b = y93.a.a(this.f178408b, null, null, Long.valueOf(r710), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, NetError.ERR_TTNET_FT_INVALID_STREAM, -1, -1, -1, 127);
    }

    public final void v(int r710) {
        this.f178408b = y93.a.a(this.f178408b, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, Integer.valueOf(r710), null, null, null, null, null, null, null, null, null, null, null, null, null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, true, -536870913, -1, -1, -1, 63);
    }

    public final void w(long r710) {
        y93.a r100 = y93.a.a(this.f178408b, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 0, null, Long.valueOf(r710), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, -1, -1048577, -1, -1, 127);
        this.f178408b = r100;
        if (r100.A() != null) goto L6;
        this.f178408b = y93.a.a(this.f178408b, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, Long.valueOf(r710), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, -1, -1, -4097, -1, 127);
        return;
    }

    public final void x(long r710) {
        this.f178408b = y93.a.a(this.f178408b, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 0, null, null, null, null, Long.valueOf(r710), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, -1, -8388609, -1, -1, 127);
    }

    public final void y(long r710) {
        this.f178408b = y93.a.a(this.f178408b, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 0, null, null, null, Long.valueOf(r710), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, -1, -4194305, -1, -1, 127);
    }

    public final void f(String r100, Map<String, ? extends Object> r101) {
        if (r101 == null) goto L4;
        Map<String, ? extends Object> r102 = MapsKt.toMap(r101);
    L5:
        this.f178409c = r102;
        monitor-enter(this);
    L24:
        th = move-exception;
        throw th;
    L8:
        if (this.f178407a == null) goto L11;
        monitor-exit(this);
        return;
    L11:
        if (r100 != null) goto L13;
        r100 = NativeMallGeckoHelper.c();     // Catch: Throwable -> L24
    L13:
        Lazy r103 = ECMallLogUtil.f47441a;     // Catch: Throwable -> L24
        ECMallLogUtil.c(com.bytedance.android.ec.hybrid.log.mall.m.b.f47508b, "use config url is ".concat(r100));     // Catch: Throwable -> L24
        if (HybridAppInfoService.f47545p.isLocalTest() == false) goto L18;
        IVerseService r104 = (IVerseService) com.bytedance.android.ec.hybrid.a.f().getService(IVerseService.class);     // Catch: Throwable -> L24
        if (r104 == null) goto L18;
        r104.getMallDebugService();     // Catch: Throwable -> L24
    L18:
        ECHybridDataEngine.a r105 = new ECHybridDataEngine.a();     // Catch: Throwable -> L24
        String r106 = com.bytedance.android.shopping.api.mall.common.tools.h.f170438b.getIHybridHostAppInfo().getAppVersionName();     // Catch: Throwable -> L24
        if (r106 != null) goto L21;
        r106 = "";
    L21:
        Intrinsics.checkNotNullParameter(r106, BaseSwitches.V);     // Catch: Throwable -> L24
        r105.f46646d = r106;     // Catch: Throwable -> L24
        Intrinsics.checkNotNullParameter(r100, "path");     // Catch: Throwable -> L24
        r105.f46643a = r100;     // Catch: Throwable -> L24
        a r107 = new a(this);     // Catch: Throwable -> L24
        Intrinsics.checkNotNullParameter(r107, "applier");     // Catch: Throwable -> L24
        r105.f46645c = r107;     // Catch: Throwable -> L24
        this.f178407a = r105.a();     // Catch: Throwable -> L24
        monitor-exit(this);
        return;
    L4:
        r102 = null;
        goto L5
    }

    public final void g(long r710, String r711) {
        this.f178408b = y93.a.a(this.f178408b, null, null, null, null, null, null, Long.valueOf(r710), r711, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, -786433, -1, -1, -1, 127);
    }

    public final void h(long r710, Integer r711) {
        this.f178408b = y93.a.a(this.f178408b, null, null, null, null, null, null, Long.valueOf(r710), null, null, null, null, null, null, null, null, null, null, null, r711, null, null, null, null, null, null, null, null, null, null, null, null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, -1074003969, -1, -1, -1, 127);
    }

    public final void l(long r710, int r711) {
        this.f178408b = y93.a.a(this.f178408b, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, Long.valueOf(r710), Integer.valueOf(r711), null, null, null, null, null, null, null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, -1, -49, -1, -1, 127);
    }

    public static void F(final DataEngineWrapper r100, final HomePageDTO r101, final int r102) {
        Intrinsics.checkNotNullParameter(r101, "homepage");
        final boolean r103 = true;
        kk.d.c(new DataEngineWrapper$prefetchImagesFrom$1(r100, r102, r101, r103));
    }

    public final void s(long r710, Integer r711, String r712) {
        this.f178408b = y93.a.a(this.f178408b, null, null, null, null, null, null, null, null, null, Long.valueOf(r710), null, null, null, null, null, null, null, null, r711, r712, null, null, null, null, null, null, null, null, null, null, null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, 1071644671, -1, -1, -1, 127);
    }

    public static void C(DataEngineWrapper r100, HomePageDTO r101, boolean r102, int r103) {
        if ((r103 & 2) == 0) goto L5;
        r102 = true;
    L5:
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "homepage");
        if (r.f178540a.c() != 0) goto L9;
        kk.d.c(new DataEngineWrapper$prefetchImageInner$1(r100, r101, null, r102));
        return;
    L9:
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L11;
        ThreadPoolHelper.c().submit(new e(r100, r101, r102, null));
        return;
    L11:
        kk.d.c(new DataEngineWrapper$prefetchImageInner$1(r100, r101, null, r102));
    }

    public static final void b(DataEngineWrapper r100, JSONObject r101, String r102, String r103) {
        r100.getClass();
        r101.put(r102, r103);     // Catch: Exception -> L5
        return;
    L5:
        Logger.d("puffone-DataEngineWrapper.insertToJson()", "err");
    }
}
