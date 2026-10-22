package com.bytedance.android.ec.store.repository.vo;

import com.bytedance.android.ec.core.utils.t0;
import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.facebook.imagepipeline.request.ImageRequest;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class ShopSlcProductItemV2 extends com.bytedance.android.shopping.store.hybridproduct.extension.o {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final a f48403x = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f48404h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f48405i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f48406j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f48407k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Integer f48408l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Long f48409m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public b f48410n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public List<String> f48411o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public String f48412p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f48413q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public String f48414r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public long f48415s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public String f48416t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public Pair<? extends com.bytedance.android.ec.core.imagex.r, ImageRequest[]> f48417u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Lazy f48418v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Lazy f48419w;

    public static final class a {

        /* JADX INFO: renamed from: com.bytedance.android.ec.store.repository.vo.ShopSlcProductItemV2$a$a, reason: collision with other inner class name */
        @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001¨\u0006\u0004"}, d2 = {"com/bytedance/android/ec/store/repository/vo/ShopSlcProductItemV2$a$a", "Lcom/google/gson/reflect/TypeToken;", "", "", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
        public static final class C0839a extends TypeToken<List<? extends String>> {
            public C0839a() {
            }
        }

        public a() {
        }

        public static ShopSlcProductItemV2 a(String r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "data");
            ShopSlcProductItemV2 r102 = new ShopSlcProductItemV2();
            Object r103 = null;
            Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L11
            int r105 = t0.f45720a;     // Catch: Throwable -> L11
            Object r106 = t0.a.f45721a.fromJson(r101, Map.class);     // Catch: Throwable -> L11
            if ((r106 instanceof Map) == true) goto L6;
            r106 = null;
        L6:
            Map r107 = (Map) r106;     // Catch: Throwable -> L11
            if (r107 != null) goto L9;
            r107 = MapsKt.emptyMap();     // Catch: Throwable -> L11
        L9:
            Object r108 = Result.m9449constructorimpl(r107);     // Catch: Throwable -> L11
        L14:
            if (Result.m9455isFailureimpl(r108) == false) goto L16;
            r108 = null;
        L16:
            Map<String, ? extends Object> r109 = (Map) r108;
            if (r109 != null) goto L19;
            r109 = MapsKt.emptyMap();
        L19:
            Intrinsics.checkNotNullParameter(r109, "<set-?>");
            r102.f185014a = r109;
            LinkedHashMap r110 = new LinkedHashMap();
            Object r111 = r102.f185014a.get("log_extra");
            if ((r111 instanceof Map) == true) goto L22;
            r111 = null;
        L22:
            Map r112 = (Map) r111;
            if (r112 == null) goto L25;
            r110.putAll(r112);
        L25:
            Unit r113 = Unit.INSTANCE;
            r102.f185019f = r110;
            Object r114 = r102.f185014a.get("biz_extra");
            if ((r114 instanceof Map) == true) goto L28;
            r114 = null;
        L28:
            Map r115 = (Map) r114;
            if (r115 != null) goto L31;
            r115 = MapsKt.emptyMap();
        L31:
            String r116 = (String) r115.get("product_tag_event_param");
            String r117 = "";
            if (r116 != null) goto L34;
            r116 = "";
        L34:
            Intrinsics.checkNotNullParameter(r116, "<set-?>");
            r102.f48416t = r116;
            String r118 = (String) r115.get("product_id");
            if (r118 != null) goto L37;
            r118 = "";
        L37:
            Intrinsics.checkNotNullParameter(r118, "<set-?>");
            r102.f48406j = r118;
            r102.f48407k = (String) r115.get("promotion_id");
            String r119 = (String) r115.get("sku_type");
            if (r119 == null) goto L40;
            Integer r120 = Integer.valueOf(CastIntegerProtector.parseInt(r119));
        L41:
            r102.f48408l = r120;
            String r121 = (String) r115.get(PdpOpenThirdParam.KEY_PROMOTION_SOURCE);
            if (r121 == null) goto L44;
            Long r122 = Long.valueOf(CastLongProtector.parseLong(r121));
        L45:
            r102.f48409m = r122;
            int r123 = t0.f45720a;     // Catch: Throwable -> L48
            Object r124 = Result.m9449constructorimpl((com.bytedance.android.ec.store.repository.vo.a) t0.a.f45721a.fromJson((String) r115.get("cart_ctrl_info"), com.bytedance.android.ec.store.repository.vo.a.class));     // Catch: Throwable -> L48
        L51:
            if (Result.m9455isFailureimpl(r124) == false) goto L53;
            r124 = null;
        L53:
            com.bytedance.android.ec.store.repository.vo.a r125 = (com.bytedance.android.ec.store.repository.vo.a) r124;
            b r126 = new b();
            if (r125 == null) goto L56;
            Boolean r127 = r125.b();
        L58:
            if (Intrinsics.areEqual(r127, Boolean.FALSE) == true) goto L65;
            if (r125 == null) goto L61;
            Boolean r128 = r125.b();
        L62:
            if (r128 == null) goto L65;
            boolean r129 = false;
        L66:
            r126.f48454a = Boolean.valueOf(r129);
            if (r125 == null) goto L71;
            sj3.n r130 = r125.a();
            if (r130 == null) goto L71;
            String r131 = r130.b();
        L72:
            r126.f48455b = r131;
            if (r125 == null) goto L75;
            String r132 = r125.c();
        L76:
            r126.f48456c = r132;
            Unit r133 = Unit.INSTANCE;
            r102.f48410n = r126;
            r102.f48412p = (String) r115.get("detail_url");
            r102.f48413q = Intrinsics.areEqual((String) r115.get("is_not_need_change_detail_url"), "1");
            int r134 = t0.f45720a;     // Catch: Throwable -> L82
            Gson r135 = t0.a.f45721a;     // Catch: Throwable -> L82
            Object r136 = r115.get("img_url_list");     // Catch: Throwable -> L82
            if (r136 == null) goto L81;
            Object r137 = Result.m9449constructorimpl((List) r135.fromJson((String) r136, new C0839a().getType()));     // Catch: Throwable -> L82
        L85:
            if (Result.m9455isFailureimpl(r137) == true) goto L88;
            r103 = r137;
        L88:
            r102.f48411o = (List) r103;
            String r138 = (String) r115.get("product_title");
            if (r138 == null) goto L92;
            r117 = r138;
        L92:
            Intrinsics.checkNotNullParameter(r117, "<set-?>");
            r102.f48414r = r117;
            String r139 = (String) r115.get("timing_sale_start_time");
            if (r139 == null) goto L95;
            long r140 = CastLongProtector.parseLong(r139);
        L96:
            r102.f48415s = r140;
            Intrinsics.areEqual((String) r115.get("is_appointed"), "1");
            return r102;
        L95:
            r140 = 0;
            goto L96
        L81:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");     // Catch: Throwable -> L82
        L82:
            th = move-exception;
            Result.Companion r141 = Result.Companion;
            r137 = Result.m9449constructorimpl(ResultKt.createFailure(th));
            goto L85
        L75:
            r132 = null;
        L71:
            r131 = null;
            goto L72
        L61:
            r128 = null;
        L65:
            r129 = true;
            goto L66
        L56:
            r127 = null;
        L48:
            th = move-exception;
            Result.Companion r142 = Result.Companion;
            r124 = Result.m9449constructorimpl(ResultKt.createFailure(th));
            goto L51
        L44:
            r122 = null;
            goto L45
        L40:
            r120 = null;
        L11:
            th = move-exception;
            Result.Companion r143 = Result.Companion;
            r108 = Result.m9449constructorimpl(ResultKt.createFailure(th));
            goto L14
        }
    }

    @Override // com.ss.android.ugc.aweme.kiwi.model.QModel
    public final int modelType() {
        return 101;
    }

    static {
        f48403x = new a();
    }

    public ShopSlcProductItemV2() {
        this.f48406j = "";
        this.f48414r = "";
        this.f48416t = "";
        this.f48418v = LazyKt.lazy(new ShopSlcProductItemV2$standardChainParam$2(this));
        this.f48419w = LazyKt.lazy(new ShopSlcProductItemV2$sliceRenderDataMap$2(this));
    }

    public final void c(Map<String, ? extends Object> r100) {
        LinkedHashMap r101 = new LinkedHashMap();
        r101.putAll(this.f185017d);
        if (r100 == null) goto L5;
        r101.putAll(r100);
    L5:
        Map r102 = (Map) ((Map) this.f48419w.getValue()).get("data");
        if (r102 == null) goto L8;
        r102.remove("slice_item_states");
    L8:
        Map r103 = (Map) ((Map) this.f48419w.getValue()).get("data");
        if (r103 == null) goto L12;
        r103.put("slice_item_states", r101);
        return;
    }
}
