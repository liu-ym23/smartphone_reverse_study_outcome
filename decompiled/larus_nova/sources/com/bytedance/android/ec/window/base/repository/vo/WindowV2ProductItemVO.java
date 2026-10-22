package com.bytedance.android.ec.window.base.repository.vo;

import com.bytedance.android.ec.core.utils.t0;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.model.response.ECRitTag;
import com.bytedance.android.ec.model.response.anchorv3.PromotionDiscountLabel;
import com.bytedance.android.ec.slice.SliceInitService;
import com.bytedance.android.ec.window.base.repository.dto.WindowV2ProductItemDTO;
import com.bytedance.android.ec.window.base.repository.dto.r;
import com.bytedance.android.ec.window.base.repository.dto.x;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.viewmodel.QLiveData;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import yn.u;

/* JADX INFO: loaded from: classes44.dex */
public class WindowV2ProductItemVO implements QModel {
    public static final a P = null;
    public Boolean A;
    public List<String> B;
    public final fo.b C;
    public String D;
    public String E;
    public int F;
    public boolean G;
    public String H;
    public x I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public ScrollStatus f49462J;
    public Map<String, ECWindowTagListDTO> K;
    public Integer L;
    public List<String> M;
    public String N;
    public final Lazy O;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f49463a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f49464b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Long f49465c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f49466d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f49467e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f49468f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f49469g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public List<String> f49470h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f49471i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f49472j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Long f49473k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f49474l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f49475m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public List<PromotionDiscountLabel> f49476n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f49477o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public List<? extends ECUrlModel> f49478p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public Map<String, String> f49479q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public String f49480r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public Map<String, ? extends List<ECRitTag>> f49481s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final QLiveData<b> f49482t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public Integer f49483u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public WindowV2ProductItemDTO.b f49484v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public u f49485w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public ECUrlModel f49486x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f49487y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public com.bytedance.android.ec.window.base.repository.vo.b f49488z;

    public static final class a {

        /* JADX INFO: renamed from: com.bytedance.android.ec.window.base.repository.vo.WindowV2ProductItemVO$a$a, reason: collision with other inner class name */
        @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00020\u0001¨\u0006\u0004"}, d2 = {"com/bytedance/android/ec/window/base/repository/vo/WindowV2ProductItemVO$a$a", "Lcom/google/gson/reflect/TypeToken;", "", "", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
        public static final class C0851a extends TypeToken<Map<String, ? extends String>> {
            public C0851a() {
            }
        }

        public a() {
        }

        public static Map a(String r100) {
            Map r101 = MapsKt.emptyMap();
            int r102 = t0.f45720a;     // Catch: Exception -> L12
            Gson r103 = t0.a.f45721a;     // Catch: Exception -> L12
            if (r100 != null) goto L6;
            r100 = SliceInitService.DEFAULT_SWITCH;
        L6:
            Map r104 = (Map) r103.fromJson(r100, new C0851a().getType());     // Catch: Exception -> L12
            LinkedHashMap r105 = new LinkedHashMap();     // Catch: Exception -> L12
            Iterator r106 = r104.entrySet().iterator();     // Catch: Exception -> L12
        L8:
            if (r106.hasNext() == false) goto L19;
            Map.Entry r107 = (Map.Entry) r106.next();     // Catch: Exception -> L12
            r105.put(r107.getKey(), t0.a.f45721a.fromJson((String) r107.getValue(), ECWindowTagListDTO.class));     // Catch: Exception -> L12
            goto L8
        L19:
            return r105;
        L12:
            e = move-exception;
            dm.a.a("StoreV2ProductItemVO").b("transFromStoreV2ProductItemDTOWithTagListMap", e);
            return r101;
        }

        public static void b(WindowV2ProductItemDTO r100, WindowV2ProductItemVO r101) {
            Intrinsics.checkNotNullParameter(r100, "dto");
            Intrinsics.checkNotNullParameter(r101, "vo");
            String r102 = r100.y();
            String r103 = "";
            if (r102 != null) goto L5;
            r102 = "";
        L5:
            Intrinsics.checkNotNullParameter(r102, "<set-?>");
            r101.f49463a = r102;
            r101.f49464b = r100.z();
            r101.f49465c = r100.A();
            String r104 = r100.s();
            if (r104 == null) goto L9;
            r103 = r104;
        L9:
            Intrinsics.checkNotNullParameter(r103, "<set-?>");
            r101.f49466d = r103;
            r101.f49467e = r100.F();
            r101.f49468f = com.bytedance.android.shopping.extensions.k.f(r100.m());
            String r105 = com.bytedance.android.shopping.extensions.k.j(r100.I());
            Intrinsics.checkNotNullParameter(r105, "<set-?>");
            r101.f49469g = r105;
            List<String> r106 = r100.o();
            if (r106 != null) goto L12;
            r106 = CollectionsKt.emptyList();
        L12:
            Intrinsics.checkNotNullParameter(r106, "<set-?>");
            r101.f49470h = r106;
            List<String> r107 = r100.P();
            if (r107 != null) goto L15;
            r107 = CollectionsKt.emptyList();
        L15:
            Intrinsics.checkNotNullParameter(r107, "<set-?>");
            r101.B = r107;
            r101.f49472j = com.bytedance.android.shopping.extensions.k.h(r100.u());
            r101.f49471i = r100.v();
            r101.f49473k = r100.r();
            r101.f49474l = com.bytedance.android.shopping.extensions.k.h(r100.E());
            r101.f49475m = r100.Q();
            r101.f49476n = r100.k();
            Boolean r108 = r100.S();
            int r109 = 0;
            if (r108 == null) goto L18;
            boolean r110 = r108.booleanValue();
        L19:
            r101.f49477o = r110;
            r101.f49478p = r100.t();
            Integer r111 = r100.J();
            if (r111 == null) goto L22;
            r111.intValue();
        L22:
            r101.f49480r = r100.M();
            r101.f49479q = r100.q();
            r101.f49483u = r100.H();
            Integer r112 = r100.K();
            if (r112 == null) goto L25;
            r112.intValue();
        L25:
            r101.f49481s = r100.C();
            r101.f49484v = r100.i();
            r101.f49485w = r100.p();
            r101.G = r100.c();
            r101.f49486x = r100.L();
            r101.A = r100.n();
            r101.D = r100.D();
            r101.E = r100.j();
            r101.I = r100.R();
            r r113 = r100.f();
            Integer r114 = null;
            if (r113 == null) goto L28;
            int r115 = com.bytedance.android.ec.window.base.repository.vo.b.f49490e;
            com.bytedance.android.ec.window.base.repository.vo.b r116 = com.bytedance.android.ec.window.base.repository.vo.b.a.a(r113);
        L29:
            r101.f49488z = r116;
            String r117 = r100.a();
            if (r117 == null) goto L32;
            String r118 = (String) r101.C.b(wn.a.f560427x, r117);
        L32:
            String r119 = r100.b();
            if (r119 == null) goto L35;
            String r120 = (String) r101.C.b(wn.a.f560426w, r119);
        L35:
            Integer r121 = r100.G();
            if (r121 == null) goto L38;
            r109 = r121.intValue();
        L38:
            r101.F = r109;
            String r122 = r100.g();
            if (r122 == null) goto L41;
            String r123 = (String) r101.C.b(wn.a.f560428y, r122);
        L41:
            String r124 = r100.h();
            if (r124 == null) goto L44;
            String r125 = (String) r101.C.b(wn.a.f560429z, r124);
        L44:
            r101.H = r100.B();
            r101.K = r100.N();
            r101.L = r100.O();
            r101.M = r100.w();
            WindowV2ProductItemDTO.c r126 = r100.l();
            if (r126 == null) goto L47;
            Integer r127 = r126.b();
        L48:
            if (r127 == null) goto L51;
            r127.intValue();
        L51:
            ProductCardType.a r128 = ProductCardType.Companion;
            Long r129 = r100.x();
            r128.getClass();
            if (r129 == null) goto L54;
            r114 = Integer.valueOf((int) r129.longValue());
        L54:
            if (r114 != null) goto L57;
        L59:
            if (r114 != null) goto L62;
        L64:
            if (r114 != null) goto L67;
        L69:
            if (r114 != null) goto L72;
        L74:
            ProductCardType r130 = ProductCardType.UNKNOW;
        L75:
            Intrinsics.checkNotNullParameter(r130, "<set-?>");
            r101.N = r100.d();
            return;
        L72:
            if (r114.intValue() != 3) goto L74;
            r130 = ProductCardType.CROSS_SHOP_GOTO_DETAIL;
            goto L75
        L67:
            if (r114.intValue() != 2) goto L69;
            r130 = ProductCardType.CROSS_SHOP_GOTO_SHOP;
            goto L75
        L62:
            if (r114.intValue() != 1) goto L64;
            r130 = ProductCardType.GUESS_YOU_LIKE;
            goto L75
        L57:
            if (r114.intValue() != 0) goto L59;
            r130 = ProductCardType.GOODS_LIST;
            goto L75
        L47:
            r127 = null;
            goto L48
        L28:
            r116 = null;
            goto L29
        L18:
            r110 = false;
            goto L19
        }

        public static WindowV2ProductItemVO c(a r100, WindowV2ProductItemDTO r101) {
            r100.getClass();
            Intrinsics.checkNotNullParameter(r101, "dto");
            WindowV2ProductItemVO r102 = new WindowV2ProductItemVO();
            b(r101, r102);
            return r102;
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f49489a;

        public static final class a {
        }

        static {
        }

        public final int getType() {
            return this.f49489a;
        }

        public b(int r100) {
            this.f49489a = r100;
        }
    }

    @Override // com.ss.android.ugc.aweme.kiwi.model.QModel
    public final int modelType() {
        return 0;
    }

    static {
        P = new a();
    }

    public final Integer b() {
        fo.b r100 = this.C;
        fo.a<String> r101 = wn.a.f560404a;
        return (Integer) r100.a(wn.a.C);
    }

    public final List<ECRitTag> d() {
        return g("ecom_shop_product_recommend");
    }

    public final List<ECRitTag> e() {
        return g("ecom_shop_product_shop_sellpoint");
    }

    public final List<ECRitTag> f() {
        return g("ecom_shop_product_below");
    }

    public WindowV2ProductItemVO() {
        this.f49463a = "";
        this.f49466d = "";
        this.f49469g = "";
        this.f49470h = CollectionsKt.emptyList();
        this.f49482t = new QLiveData();
        this.B = CollectionsKt.emptyList();
        this.C = new fo.b();
        this.f49462J = ScrollStatus.CANT_SCROLL;
        ProductCardType r100 = ProductCardType.UNKNOW;
        this.O = LazyKt.lazy(new WindowV2ProductItemVO$standardChainParam$2(this));
    }

    public final List<ECRitTag> g(String r100) {
        Map<String, ? extends List<ECRitTag>> r101 = this.f49481s;
        if (r101 == null) goto L9;
        List<ECRitTag> r102 = r101.get(r100);
        if (r102 == null) goto L9;
        if ((!r102.isEmpty()) == false) goto L9;
        return r102;
    L9:
        return null;
    }

    public final ECRitTag c(List<ECRitTag>[] r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "lists");
        int r102 = r100.length;
        int r103 = 0;
    L3:
        String r104 = null;
        if (r103 >= r102) goto L27;
        List<ECRitTag> r105 = r100[r103];
        List<ECRitTag> r106 = r105;
        if (r106 != null) goto L8;
    L11:
        boolean r107 = true;
    L12:
        if (r107 == true) goto L26;
        if (r101 == false) goto L16;
        ECRitTag r108 = (ECRitTag) CollectionsKt.firstOrNull(r105);
        if (r108 == null) goto L23;
        List<String> r109 = r108.getText();
        if (r109 == null) goto L23;
        r104 = (String) CollectionsKt.firstOrNull(r109);
    L23:
        if (com.bytedance.android.shopping.extensions.k.c(r104) == false) goto L26;
        return (ECRitTag) CollectionsKt.getOrNull(r105, 0);
    L16:
        return (ECRitTag) CollectionsKt.getOrNull(r105, 0);
    L26:
        r103 = r103 + 1;
        goto L3
    L8:
        if (r106.isEmpty() == true) goto L11;
        r107 = false;
        goto L12
    L27:
        return null;
    }
}
