package com.bytedance.android.shopping.anchorv4.data;

import com.bytedance.android.ec.base.settings.SDKSettingsCacheManager;
import com.bytedance.android.ec.core.utils.b2;
import com.bytedance.android.ec.hybrid.hostapi.IECHybridKevaService;
import com.bytedance.android.ec.model.ECCacheMonitorStruct;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.ecom.arch.slice.expr.SlcExprContext;
import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.bytedance.android.shopping.anchorv3.repository.api.PdpPackRequestParam;
import com.bytedance.android.shopping.anchorv4.dto.PackParsedDTO;
import com.bytedance.android.shopping.anchorv4.dto.PackResponseDTO;
import com.bytedance.android.shopping.anchorv4.experiment.PdpAB;
import com.bytedance.android.shopping.api.address.IAddressService;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.jedi.model.combine.Combine;
import com.bytedance.jedi.model.combine.Combine$applyStrategy$1;
import com.bytedance.jedi.model.combine.CombineExtensionsKt;
import com.bytedance.jedi.model.combine.Strategies;
import com.bytedance.jedi.model.repository.Repository;
import com.bytedance.services.apm.api.EnsureManager;
import com.larus.nova.R;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
public final class AnchorV4Repository extends Repository {
    public static final String A = null;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final long f166344z = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public PackResponseDTO f166345b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f166346c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f166347d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f166348e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f166349f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public WeakReference<Object> f166350g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f166351h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Lazy f166352i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Lazy f166353j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Lazy f166354k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Lazy f166355l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final k63.c f166356m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Lazy f166357n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Lazy f166358o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Lazy f166359p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Lazy f166360q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Lazy f166361r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final Lazy f166362s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final Lazy f166363t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public a1 f166364u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public Function1<? super a1, Unit> f166365v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final k f166366w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f166367x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f166368y;

    public static final class a {
    }

    public static final class b<T, R> implements Function {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AnchorV4Repository f166369a;

        public b(AnchorV4Repository r100) {
            this.f166369a = r100;
        }

        @Override // io.reactivex.functions.Function
        public final Object apply(Object r100) {
            PackResponseDTO r101 = (PackResponseDTO) r100;
            Intrinsics.checkNotNullParameter(r101, "it");
            PackParsedDTO r102 = r101.getParsedDTO();
            if (r102 == null) goto L12;
            Map<String, SlcElement> r103 = r102.getTemplates();
            if (r103 == null) goto L12;
            Iterator<T> r104 = r103.values().iterator();
        L8:
            if (r104.hasNext() == false) goto L12;
            SlcElement r105 = (SlcElement) r104.next();
            if (r105 == null) goto L8;
            k r106 = AnchorV4DataManager.f166335a;
            tq.a.d((SlcExprContext) AnchorV4DataManager.f166341g.getValue(), r105, null, 6);
        L12:
            this.f166369a.getClass();
            int r107 = t73.a.f544881a;
            t73.a.a(r101.getParsedDTO(), "pack_res");
            return r101;
        }
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AnchorV4Repository f166370a;

        public c(AnchorV4Repository r100) {
            this.f166370a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            AnchorV4Repository r101 = this.f166370a;
            r101.h((PackResponseDTO) r100);
        }
    }

    public static final class d<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AnchorV4Repository f166371a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Function1 f166372b;

        public d(AnchorV4Repository r100, Function1 r101) {
            this.f166371a = r100;
            this.f166372b = r101;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Throwable r101 = (Throwable) r100;
            if (com.bytedance.android.ec.core.abtest.d.f() == true) goto L5;
            com.bytedance.android.ec.sdk.helper.i.f48124a.e(ECAppInfoService.f48114e.getCurrentActivity(), com.bytedance.android.shopping.extensions.j.c(R.string.network_error), true, false);
        L5:
            Function1 r102 = this.f166372b;
            if (r102 == null) goto L8;
            Unit r103 = (Unit) r102.invoke(r101);
        L8:
            AnchorV4Repository.a(this.f166371a);
        }
    }

    public static final class e<T, R> implements Function {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AnchorV4Repository f166373a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ PdpPackRequestParam f166374b;

        public e(AnchorV4Repository r100, PdpPackRequestParam r101) {
            this.f166373a = r100;
            this.f166374b = r101;
        }

        @Override // io.reactivex.functions.Function
        public final Object apply(Object r100) {
            PackResponseDTO r101 = (PackResponseDTO) r100;
            Intrinsics.checkNotNullParameter(r101, "it");
            ECCacheMonitorStruct r102 = com.bytedance.android.shopping.anchorv4.experiment.b.f166754a;
            k r103 = AnchorV4DataManager.f166335a;
            if (com.bytedance.android.shopping.anchorv4.experiment.b.a(Boolean.valueOf(AnchorV4DataManager.l(this.f166374b))) == true) goto L5;
        L9:
            return r101;
        L5:
            if (r101.getStatusCode() != 0) goto L9;
            if (r101.isForbidCache() == true) goto L9;
            PackResponseDTO r104 = e73.f.b(r101);
            r104.setTimestamp(System.currentTimeMillis());
            this.f166373a.f166366w.c(this.f166374b, r104);
            goto L9
        }
    }

    public final CompositeDisposable f() {
        return (CompositeDisposable) this.f166348e.getValue();
    }

    public final List<i> g() {
        return (List) this.f166347d.getValue();
    }

    static {
        f166344z = com.bytedance.android.shopping.anchorv4.experiment.b.f166754a.getCacheNum();
        Lazy r100 = ECAppInfoService.f48110a;
        if (we.a.f559330a == false) goto L5;
        String r101 = "/aweme/v2/shop/promotion/pack/saas/";
    L6:
        A = r101;
        return;
    L5:
        r101 = "/aweme/v2/shop/promotion/pack/";
        goto L6
    }

    public static final void a(AnchorV4Repository r100) {
        Iterator<T> r101 = r100.g().iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((i) r101.next()).onGetPackClientError();
        goto L4
    }

    public final Observable<PackResponseDTO> e(PdpPackRequestParam r100) {
        Intrinsics.checkNotNullParameter(r100, "requestParam");
        i(r100);
        Combine r101 = CombineExtensionsKt.a((m) this.f166351h.getValue(), this.f166366w);
        Strategies.f251059a.getClass();
        Function2 r102 = Strategies.a();
        Intrinsics.checkNotNullParameter(r102, BdpAppEventConstant.PARAMS_STRATEGY_NAME);
        return new Combine$applyStrategy$1(r102, r101).a(r100).subscribeOn(Schedulers.io()).map(new e(this, r100));
    }

    public final void h(PackResponseDTO r100) {
        this.f166345b = r100;
        Iterator<T> r101 = g().iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((i) r101.next()).onGetPack(r100, false);
        goto L4
    }

    public final void i(PdpPackRequestParam r100) {
        int r101 = ECSdk.f48106a;
        IAddressService r102 = (IAddressService) ECSdk.a(IAddressService.class);
        if (r102 == null) goto L14;
        WeakReference<Object> r103 = this.f166350g;
        if (r103 == null) goto L7;
        Object r104 = r103.get();
    L8:
        o83.a r105 = IAddressService.a.a(r102, r104, "a1.b8094.c0.d0", 4);
        if (r105 == null) goto L15;
        String r106 = r105.a(true, null, null).toString();
        if (r106 == null) goto L16;
        r100.updateAddressDetail(r106);
        return;
    L16:
        return;
    L15:
        return;
    L7:
        r104 = null;
        goto L8
    }

    public AnchorV4Repository(String r100, k r101) {
        Intrinsics.checkNotNullParameter(r100, "sessionId");
        Intrinsics.checkNotNullParameter(r101, "packCache");
        this.f166366w = r101;
        this.f166367x = 0;
        this.f166368y = 1;
        this.f166346c = LazyKt.lazy(AnchorV4Repository$extraResponseList$2.INSTANCE);
        this.f166347d = LazyKt.lazy(AnchorV4Repository$watchList$2.INSTANCE);
        this.f166348e = LazyKt.lazy(AnchorV4Repository$compositeDisposable$2.INSTANCE);
        this.f166349f = LazyKt.lazy(AnchorV4Repository$extraDataWatchList$2.INSTANCE);
        this.f166351h = LazyKt.lazy(AnchorV4Repository$packFetcher$2.INSTANCE);
        this.f166352i = LazyKt.lazy(AnchorV4Repository$packChunkFetcher$2.INSTANCE);
        this.f166353j = LazyKt.lazy(AnchorV4Repository$shopGuideInfoFetcher$2.INSTANCE);
        this.f166354k = LazyKt.lazy(AnchorV4Repository$findSameGoodsFetcher$2.INSTANCE);
        this.f166355l = LazyKt.lazy(AnchorV4Repository$picSearchGoodsFetcher$2.INSTANCE);
        this.f166356m = new k63.c();
        this.f166357n = LazyKt.lazy(AnchorV4Repository$detailFetcher$2.INSTANCE);
        this.f166358o = LazyKt.lazy(AnchorV4Repository$shopRecommendFetcher$2.INSTANCE);
        this.f166359p = LazyKt.lazy(AnchorV4Repository$searchSuggestWordFetcher$2.INSTANCE);
        this.f166360q = LazyKt.lazy(AnchorV4Repository$autoApplyCouponFetcher$2.INSTANCE);
        this.f166361r = LazyKt.lazy(AnchorV4Repository$gulFeedbackFetcher$2.INSTANCE);
        this.f166362s = LazyKt.lazy(AnchorV4Repository$gulFeedbackDislikeFetcher$2.INSTANCE);
        this.f166363t = LazyKt.lazy(AnchorV4Repository$fissionBackFlowFetcher$2.INSTANCE);
    }

    public final Observable<com.bytedance.android.chunkstreamprediction.network.b<PackResponseDTO>> b(PdpPackRequestParam r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "requestParam");
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L5
        i(r100);     // Catch: Throwable -> L5
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L5
    L7:
        Observable<com.bytedance.android.chunkstreamprediction.network.b<PackResponseDTO>> r103 = ((l) this.f166352i.getValue()).a(r100);
        if (r101 == true) goto L10;
        return r103;
    L10:
        return r103.subscribeOn(Schedulers.io());
    L5:
        th = move-exception;
        Result.Companion r104 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    public final void c(PdpPackRequestParam r100, boolean r110, Function1<? super Throwable, Unit> r111) {
        Intrinsics.checkNotNullParameter(r100, "reqParam");
        PackResponseDTO r101 = this.f166366w.i(r100);
        int r102 = com.bytedance.android.shopping.anchorv4.experiment.b.f166754a.getDefaultTimeSeconds() * 1000;
        long r103 = System.currentTimeMillis();
        if (r101 == null) goto L5;
        long r104 = r101.getTimestamp();
    L6:
        long r105 = r103 - r104;
        long r106 = r102;
        boolean r107 = false;
        if (r105 > r106) goto L9;
        boolean r108 = true;
    L10:
        if (r110 == false) goto L14;
        if (r108 == false) goto L14;
        r107 = true;
    L14:
        if (r107 == true) goto L17;
        r101 = null;
    L17:
        if (r101 == null) goto L29;
        PackParsedDTO r109 = r101.getParsedDTO();
        if (r109 == null) goto L28;
        Map<String, SlcElement> r112 = r109.getTemplates();
        if (r112 == null) goto L28;
        Iterator<T> r113 = r112.values().iterator();
    L24:
        if (r113.hasNext() == false) goto L28;
        SlcElement r114 = (SlcElement) r113.next();
        if (r114 == null) goto L24;
        k r115 = AnchorV4DataManager.f166335a;
        tq.a.d((SlcExprContext) AnchorV4DataManager.f166341g.getValue(), r114, null, 6);
    L28:
        h(r101);
    L29:
        f().add(bg4.b.b(e(r100).map(new b(this))).subscribe(new c(this), new d(this, r111)));
        return;
    L9:
        r108 = false;
        goto L10
    L5:
        r104 = 0;
        goto L6
    }

    public final void d(PdpPackRequestParam r110, boolean r111, String r112, Function3<? super Integer, ? super String, ? super Throwable, Unit> r113, Function0<Unit> r114) {
        Intrinsics.checkNotNullParameter(r110, "reqParam");
        Object r100 = null;
        if (r111 == false) goto L28;
        PackResponseDTO r101 = this.f166366w.i(r110);
        int r102 = com.bytedance.android.shopping.anchorv4.experiment.b.f166754a.getDefaultTimeSeconds() * 1000;
        long r103 = System.currentTimeMillis();
        if (r101 == null) goto L7;
        long r115 = r101.getTimestamp();
    L9:
        if ((r103 - r115) > r102) goto L11;
        boolean r104 = true;
    L12:
        if (r104 == true) goto L15;
        r101 = null;
    L15:
        if (r101 == null) goto L27;
        PackParsedDTO r105 = r101.getParsedDTO();
        if (r105 == null) goto L26;
        Map<String, SlcElement> r106 = r105.getTemplates();
        if (r106 == null) goto L26;
        Iterator<T> r107 = r106.values().iterator();
    L22:
        if (r107.hasNext() == false) goto L26;
        SlcElement r108 = (SlcElement) r107.next();
        if (r108 == null) goto L22;
        k r109 = AnchorV4DataManager.f166335a;
        tq.a.d((SlcExprContext) AnchorV4DataManager.f166341g.getValue(), r108, null, 6);
    L26:
        h(r101);
    L27:
        boolean r116 = r104;
    L29:
        if (r116 == true) goto L31;
    L33:
        r110.updateFullResp(r116);
        f().add(b(r110, true).subscribe(new t(this, r113, String.valueOf(System.nanoTime()), r116, r112), new u(this, r113)));
    L34:
        com.bytedance.android.ec.core.abtest.d r117 = com.bytedance.android.ec.core.abtest.d.f43639a;
        int r118 = com.bytedance.android.ec.core.abtest.j.f43647a;
        int r119 = com.bytedance.android.ec.core.abtest.e.f43640a;
        Object r120 = com.bytedance.android.ec.core.abtest.e.a(Boolean.TRUE, Boolean.FALSE);
        int r121 = com.bytedance.android.ec.base.settings.b.f42814a;
        Result.Companion r122 = Result.Companion;     // Catch: Throwable -> L202
        com.bytedance.android.ec.base.settings.h.a();     // Catch: Throwable -> L202
        SDKSettingsCacheManager r123 = SDKSettingsCacheManager.f42812e;     // Catch: Throwable -> L202
        r123.getClass();     // Catch: Throwable -> L90
        Object r124 = SDKSettingsCacheManager.f42809b.get("detail_overdue_cache_clear");     // Catch: Throwable -> L90
        if (r124 != null) goto L42;
    L87:
        Object r125 = null;
    L88:
        Object r126 = Result.m9449constructorimpl(r125);     // Catch: Throwable -> L90
    L92:
        Throwable r127 = Result.m9452exceptionOrNullimpl(r126);     // Catch: Throwable -> L202
        if (r127 == null) goto L96;
        EnsureManager.ensureNotReachHere(r127);     // Catch: Throwable -> L202
    L96:
        if (Result.m9455isFailureimpl(r126) == false) goto L99;
        r126 = null;
    L99:
        if ((r126 instanceof Boolean) == true) goto L101;
        r126 = null;
    L101:
        Object r128 = (Boolean) r126;     // Catch: Throwable -> L202
        if (r128 != null) goto L108;
        r123.getClass();     // Catch: Throwable -> L202
        Object r129 = SDKSettingsCacheManager.f42808a.get("detail_overdue_cache_clear");     // Catch: Throwable -> L202
        if ((r129 instanceof Boolean) == true) goto L107;
        r129 = null;
    L107:
        r128 = (Boolean) r129;     // Catch: Throwable -> L202
    L108:
        if (r128 != null) goto L212;
        int r130 = com.bytedance.android.ec.base.settings.g.f42821a;     // Catch: Throwable -> L202
    L190:
        th = move-exception;
        Result.Companion r131 = Result.Companion;     // Catch: Throwable -> L202
        r128 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L202
    L193:
        if (Result.m9452exceptionOrNullimpl(r128) != null) goto L223;
    L200:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L202
        SDKSettingsCacheManager.e("detail_overdue_cache_clear", r128);     // Catch: Throwable -> L202
        goto L212
    L223:
        r128 = ((IECHybridKevaService) ServiceManager.get().getService(IECHybridKevaService.class)).getSDKSettingsValueFromRepo("detail_overdue_cache_clear", Boolean.class, r120);     // Catch: Throwable -> L197
    L198:
        if (r128 != null) goto L200;
        r128 = r120;
    L197:
        r128 = r120;
        goto L198
    L215:
        SDKSettingsCacheManager.f42812e.getClass();     // Catch: Throwable -> L164
        Object r132 = SDKSettingsCacheManager.f42809b.get("detail_overdue_cache_clear");     // Catch: Throwable -> L164
        if (r132 != null) goto L116;
    L161:
        Object r133 = null;
    L162:
        Object r134 = Result.m9449constructorimpl(r133);     // Catch: Throwable -> L164
    L166:
        Throwable r135 = Result.m9452exceptionOrNullimpl(r134);     // Catch: Throwable -> L190
        if (r135 == null) goto L170;
        EnsureManager.ensureNotReachHere(r135);     // Catch: Throwable -> L190
    L170:
        if (Result.m9455isFailureimpl(r134) == false) goto L173;
        r134 = null;
    L173:
        if ((r134 instanceof Boolean) == true) goto L175;
        r134 = null;
    L175:
        r128 = (Boolean) r134;     // Catch: Throwable -> L190
        if (r128 != null) goto L200;
        jj4.b r136 = jj4.b.f499326b;     // Catch: Throwable -> L190
        Object r137 = jj4.a.a("detail_overdue_cache_clear", Boolean.class, r120, false);     // Catch: Throwable -> L190
        if (r137 != null) goto L182;
        Intrinsics.throwNpe();     // Catch: Throwable -> L190
    L182:
        if ((r137 instanceof Boolean) == false) goto L185;
        r100 = r137;
    L185:
        Object r138 = (Boolean) r100;     // Catch: Throwable -> L190
        if (r138 != null) goto L188;
        r138 = r120;
    L188:
        r128 = Result.m9449constructorimpl(r138);     // Catch: Throwable -> L190
    L116:
        if ((r132 instanceof Boolean) == true) goto L118;
        Object r139 = null;
    L119:
        r133 = (Boolean) r139;     // Catch: Throwable -> L164
        if (r133 != null) goto L162;
        if ((r132 instanceof Number) == false) goto L149;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L131;
        Float r140 = Float.valueOf(((Number) r132).floatValue());     // Catch: Throwable -> L164
        if ((r140 instanceof Boolean) == true) goto L129;
        r140 = null;
    L129:
        r133 = (Boolean) r140;     // Catch: Throwable -> L164
        goto L162
    L131:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L137;
        Double r141 = Double.valueOf(((Number) r132).doubleValue());     // Catch: Throwable -> L164
        if ((r141 instanceof Boolean) == true) goto L135;
        r141 = null;
    L135:
        r133 = (Boolean) r141;     // Catch: Throwable -> L164
        goto L162
    L137:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L143;
        Integer r142 = Integer.valueOf(((Number) r132).intValue());     // Catch: Throwable -> L164
        if ((r142 instanceof Boolean) == true) goto L141;
        r142 = null;
    L141:
        r133 = (Boolean) r142;     // Catch: Throwable -> L164
        goto L162
    L143:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L149;
        Long r143 = Long.valueOf(((Number) r132).longValue());     // Catch: Throwable -> L164
        if ((r143 instanceof Boolean) == true) goto L147;
        r143 = null;
    L147:
        r133 = (Boolean) r143;     // Catch: Throwable -> L164
    L149:
        if ((r132 instanceof JSONObject) == false) goto L151;
    L225:
        Object r144 = SDKSettingsCacheManager.a().fromJson(r132.toString(), Boolean.class);     // Catch: Throwable -> L157
        if ((r144 instanceof Boolean) == true) goto L155;
        r144 = null;
    L155:
        Object r145 = Result.m9449constructorimpl((Boolean) r144);     // Catch: Throwable -> L157
    L159:
        r133 = r145;
        if (Result.m9455isFailureimpl(r133) == false) goto L162;
    L157:
        th = move-exception;
        Result.Companion r146 = Result.Companion;     // Catch: Throwable -> L164
        r145 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L164
        goto L159
    L151:
        if ((r132 instanceof JSONArray) == false) goto L161;
    L118:
        r139 = r132;
    L164:
        th = move-exception;
        Result.Companion r147 = Result.Companion;     // Catch: Throwable -> L190
        r134 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L190
    L212:
        if (((Boolean) r128).booleanValue() == false) goto L234;
        b2.a(new AnchorV4Repository$fetchPackChunkMode$3(this));
        return;
    L234:
        return;
    L42:
        if ((r124 instanceof Boolean) == true) goto L44;
        Object r148 = null;
    L45:
        r125 = (Boolean) r148;     // Catch: Throwable -> L90
        if (r125 != null) goto L88;
        if ((r124 instanceof Number) == false) goto L75;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Float.TYPE)) == false) goto L57;
        Float r149 = Float.valueOf(((Number) r124).floatValue());     // Catch: Throwable -> L90
        if ((r149 instanceof Boolean) == true) goto L55;
        r149 = null;
    L55:
        r125 = (Boolean) r149;     // Catch: Throwable -> L90
        goto L88
    L57:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Double.TYPE)) == false) goto L63;
        Double r150 = Double.valueOf(((Number) r124).doubleValue());     // Catch: Throwable -> L90
        if ((r150 instanceof Boolean) == true) goto L61;
        r150 = null;
    L61:
        r125 = (Boolean) r150;     // Catch: Throwable -> L90
        goto L88
    L63:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Integer.TYPE)) == false) goto L69;
        Integer r151 = Integer.valueOf(((Number) r124).intValue());     // Catch: Throwable -> L90
        if ((r151 instanceof Boolean) == true) goto L67;
        r151 = null;
    L67:
        r125 = (Boolean) r151;     // Catch: Throwable -> L90
        goto L88
    L69:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(Boolean.class), Reflection.getOrCreateKotlinClass(Long.TYPE)) == false) goto L75;
        Long r152 = Long.valueOf(((Number) r124).longValue());     // Catch: Throwable -> L90
        if ((r152 instanceof Boolean) == true) goto L73;
        r152 = null;
    L73:
        r125 = (Boolean) r152;     // Catch: Throwable -> L90
    L75:
        if ((r124 instanceof JSONObject) == false) goto L77;
    L227:
        Object r153 = SDKSettingsCacheManager.a().fromJson(r124.toString(), Boolean.class);     // Catch: Throwable -> L83
        if ((r153 instanceof Boolean) == true) goto L81;
        r153 = null;
    L81:
        Object r154 = Result.m9449constructorimpl((Boolean) r153);     // Catch: Throwable -> L83
    L85:
        r125 = r154;
        if (Result.m9455isFailureimpl(r125) == false) goto L88;
    L83:
        th = move-exception;
        Result.Companion r155 = Result.Companion;     // Catch: Throwable -> L90
        r154 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L90
        goto L85
    L77:
        if ((r124 instanceof JSONArray) == false) goto L87;
    L44:
        r148 = r124;
    L90:
        th = move-exception;
        Result.Companion r156 = Result.Companion;     // Catch: Throwable -> L202
        r126 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L202
    L202:
        th = move-exception;
        Result.Companion r157 = Result.Companion;
        Object r158 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        Throwable r159 = Result.m9452exceptionOrNullimpl(r158);
        if (r159 == null) goto L207;
        EnsureManager.ensureNotReachHere(r159);
    L207:
        if (Result.m9455isFailureimpl(r158) == true) goto L210;
        r120 = r158;
    L210:
        r128 = r120;
        goto L212
    L31:
        if (((Boolean) PdpAB.f166747a.getValue()).booleanValue() == true) goto L33;
        r114.invoke();
        goto L34
    L11:
        r104 = false;
        goto L12
    L7:
        r115 = 0;
        goto L9
    L28:
        r116 = false;
        goto L29
    }
}
