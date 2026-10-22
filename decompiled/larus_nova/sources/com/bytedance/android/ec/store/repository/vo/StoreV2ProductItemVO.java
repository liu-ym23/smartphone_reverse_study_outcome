package com.bytedance.android.ec.store.repository.vo;

import com.bytedance.android.ec.core.utils.t0;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.model.response.ECRitTag;
import com.bytedance.android.ec.model.response.anchorv3.PromotionDiscountLabel;
import com.bytedance.android.ec.slice.SliceInitService;
import com.bytedance.android.ec.store.repository.dto.MarketingDataDTO;
import com.facebook.imagepipeline.request.ImageRequest;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.ss.android.ugc.aweme.kiwi.viewmodel.QLiveData;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public class StoreV2ProductItemVO implements com.bytedance.android.shopping.store.hybridproduct.extension.d {
    public static final a Q = null;
    public final km.b A;
    public String B;
    public String C;
    public MarketingDataDTO D;
    public boolean E;
    public String F;
    public com.bytedance.android.ec.store.repository.dto.n G;
    public ScrollStatus H;
    public Map<String, ECTagListDTO> I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public com.bytedance.android.ec.store.repository.dto.i f48420J;
    public com.bytedance.android.ec.store.repository.dto.l.d K;
    public List<String> L;
    public String M;
    public boolean N;
    public ProductCardType O;
    public final Lazy P;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f48421a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f48422b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Long f48423c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f48424d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f48425e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public List<String> f48426f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Pair<? extends com.bytedance.android.ec.core.imagex.r, ImageRequest[]> f48427g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f48428h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Integer f48429i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f48430j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f48431k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f48432l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public List<PromotionDiscountLabel> f48433m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public List<? extends ECUrlModel> f48434n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public Map<String, String> f48435o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public Map<String, ? extends List<ECRitTag>> f48436p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final QLiveData<b> f48437q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public Integer f48438r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public com.bytedance.android.ec.store.repository.dto.l.b f48439s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public com.bytedance.android.ec.store.repository.dto.o f48440t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public im.v f48441u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f48442v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f48443w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public com.bytedance.android.ec.store.repository.vo.b f48444x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public Boolean f48445y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public List<String> f48446z;

    public static final class a {

        /* JADX INFO: renamed from: com.bytedance.android.ec.store.repository.vo.StoreV2ProductItemVO$a$a, reason: collision with other inner class name */
        @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00020\u0001¨\u0006\u0004"}, d2 = {"com/bytedance/android/ec/store/repository/vo/StoreV2ProductItemVO$a$a", "Lcom/google/gson/reflect/TypeToken;", "", "", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
        public static final class C0840a extends TypeToken<Map<String, ? extends String>> {
            public C0840a() {
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
            Map r104 = (Map) r103.fromJson(r100, new C0840a().getType());     // Catch: Exception -> L12
            LinkedHashMap r105 = new LinkedHashMap();     // Catch: Exception -> L12
            Iterator r106 = r104.entrySet().iterator();     // Catch: Exception -> L12
        L8:
            if (r106.hasNext() == false) goto L19;
            Map.Entry r107 = (Map.Entry) r106.next();     // Catch: Exception -> L12
            r105.put(r107.getKey(), t0.a.f45721a.fromJson((String) r107.getValue(), ECTagListDTO.class));     // Catch: Exception -> L12
            goto L8
        L19:
            return r105;
        L12:
            e = move-exception;
            dm.a.a("StoreV2ProductItemVO").b("transFromStoreV2ProductItemDTOWithTagListMap", e);
            return r101;
        }

        public static StoreV2ProductItemVO b(com.bytedance.android.ec.store.repository.dto.l r100) {
            Intrinsics.checkNotNullParameter(r100, "dto");
            StoreV2ProductItemVO r101 = new StoreV2ProductItemVO();
            c(r100, r101);
            return r101;
        }

        public static StoreV2ProductItemVO d(com.bytedance.android.ec.store.repository.dto.l r100) {
            Intrinsics.checkNotNullParameter(r100, "dto");
            StoreV2ProductItemVO r101 = new StoreV2ProductItemVO();
            c(r100, r101);
            a r102 = StoreV2ProductItemVO.Q;
            com.bytedance.android.ec.store.repository.dto.l.c r103 = r100.k();
            if (r103 == null) goto L5;
            String r104 = r103.a();
        L6:
            r102.getClass();
            r101.I = a(r104);
            return r101;
        L5:
            r104 = null;
            goto L6
        }

        public static void c(com.bytedance.android.ec.store.repository.dto.l r100, StoreV2ProductItemVO r101) {
            Intrinsics.checkNotNullParameter(r100, "dto");
            Intrinsics.checkNotNullParameter(r101, "vo");
            String r102 = r100.A();
            String r103 = "";
            if (r102 != null) goto L5;
            r102 = "";
        L5:
            Intrinsics.checkNotNullParameter(r102, "<set-?>");
            r101.f48421a = r102;
            r101.f48422b = r100.B();
            r101.f48423c = r100.C();
            String r104 = r100.s();
            if (r104 == null) goto L9;
            r103 = r104;
        L9:
            Intrinsics.checkNotNullParameter(r103, "<set-?>");
            r101.f48424d = r103;
            r101.f48425e = r100.r();
            com.bytedance.android.shopping.extensions.k.f(r100.l());
            Intrinsics.checkNotNullParameter(com.bytedance.android.shopping.extensions.k.j(r100.K()), "<set-?>");
            List<String> r105 = r100.n();
            if (r105 != null) goto L12;
            r105 = CollectionsKt.emptyList();
        L12:
            Intrinsics.checkNotNullParameter(r105, "<set-?>");
            r101.f48426f = r105;
            List<String> r106 = r100.P();
            if (r106 != null) goto L15;
            r106 = CollectionsKt.emptyList();
        L15:
            Intrinsics.checkNotNullParameter(r106, "<set-?>");
            r101.f48446z = r106;
            r101.f48430j = com.bytedance.android.shopping.extensions.k.h(r100.v());
            r101.f48428h = r100.w();
            r101.f48429i = r100.x();
            r101.f48431k = com.bytedance.android.shopping.extensions.k.h(r100.G());
            r101.f48432l = r100.Q();
            r101.f48433m = r100.i();
            Boolean r107 = r100.S();
            if (r107 == null) goto L18;
            r107.booleanValue();
        L18:
            r101.f48434n = r100.t();
            Integer r108 = r100.L();
            if (r108 == null) goto L21;
            r108.intValue();
        L21:
            LinkedHashMap r109 = new LinkedHashMap();
            Map<String, String> r110 = r100.p();
            if (r110 == null) goto L24;
            r109.putAll(r110);
        L24:
            Unit r111 = Unit.INSTANCE;
            r101.f48435o = r109;
            r101.f48438r = r100.J();
            Integer r112 = r100.M();
            if (r112 == null) goto L27;
            r112.intValue();
        L27:
            r101.f48436p = r100.D();
            r101.f48439s = r100.g();
            r101.f48441u = r100.o();
            r101.E = r100.c();
            r101.f48445y = r100.m();
            r101.B = r100.E();
            r101.C = r100.h();
            r101.G = r100.R();
            com.bytedance.android.ec.store.repository.dto.b r113 = r100.d();
            Integer r114 = null;
            if (r113 == null) goto L30;
            int r115 = com.bytedance.android.ec.store.repository.vo.b.f48453e;
            com.bytedance.android.ec.store.repository.vo.b r116 = com.bytedance.android.ec.store.repository.vo.b.a.a(r113);
        L31:
            r101.f48444x = r116;
            String r117 = r100.a();
            if (r117 == null) goto L34;
            String r118 = (String) r101.A.a(com.bytedance.android.ec.store.window.i.f49011b, r117);
        L34:
            String r119 = r100.b();
            if (r119 == null) goto L37;
            String r120 = (String) r101.A.a(com.bytedance.android.ec.store.window.i.f49010a, r119);
        L37:
            Integer r121 = r100.H();
            if (r121 == null) goto L40;
            r121.intValue();
        L40:
            String r122 = r100.e();
            if (r122 == null) goto L43;
            String r123 = (String) r101.A.a(com.bytedance.android.ec.store.window.i.f49012c, r122);
        L43:
            String r124 = r100.f();
            if (r124 == null) goto L46;
            String r125 = (String) r101.A.a(com.bytedance.android.ec.store.window.i.f49013d, r124);
        L46:
            r101.D = r100.q();
            r101.F = r100.u();
            r101.I = r100.N();
            r101.f48440t = r100.O();
            r101.f48420J = r100.I();
            r101.K = r100.j();
            r101.L = r100.y();
            r101.M = r100.F();
            com.bytedance.android.ec.store.repository.dto.l.c r126 = r100.k();
            if (r126 == null) goto L49;
            Integer r127 = r126.b();
        L51:
            if (r127 != null) goto L54;
        L56:
            boolean r128 = false;
        L57:
            r101.N = r128;
            ProductCardType.a r129 = ProductCardType.Companion;
            Long r130 = r100.z();
            r129.getClass();
            if (r130 == null) goto L60;
            r114 = Integer.valueOf((int) r130.longValue());
        L60:
            if (r114 != null) goto L63;
        L65:
            if (r114 != null) goto L68;
        L70:
            if (r114 != null) goto L73;
        L75:
            if (r114 != null) goto L78;
        L80:
            ProductCardType r131 = ProductCardType.UNKNOW;
        L81:
            Intrinsics.checkNotNullParameter(r131, "<set-?>");
            r101.O = r131;
            return;
        L78:
            if (r114.intValue() != 3) goto L80;
            r131 = ProductCardType.CROSS_SHOP_GOTO_DETAIL;
            goto L81
        L73:
            if (r114.intValue() != 2) goto L75;
            r131 = ProductCardType.CROSS_SHOP_GOTO_SHOP;
            goto L81
        L68:
            if (r114.intValue() != 1) goto L70;
            r131 = ProductCardType.GUESS_YOU_LIKE;
            goto L81
        L63:
            if (r114.intValue() != 0) goto L65;
            r131 = ProductCardType.GOODS_LIST;
            goto L81
        L54:
            if (r127.intValue() != 1) goto L56;
            r128 = true;
            goto L57
        L49:
            r127 = null;
            goto L51
        L30:
            r116 = null;
            goto L31
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f48447a;

        public static final class a {
        }

        static {
        }

        public final int getType() {
            return this.f48447a;
        }

        public b(int r100) {
            this.f48447a = r100;
        }
    }

    @Override // com.ss.android.ugc.aweme.kiwi.model.QModel
    public int modelType() {
        return 0;
    }

    static {
        Q = new a();
    }

    public final String b() {
        if ((!this.f48446z.isEmpty()) == false) goto L8;
        if (com.bytedance.android.shopping.extensions.k.c((String) CollectionsKt.first(this.f48446z)) == false) goto L8;
        return ProductRatio.FOURRATIONTHREE.getType();
    L8:
        return ProductRatio.ONERATIOONE.getType();
    }

    public StoreV2ProductItemVO() {
        this.f48421a = "";
        this.f48424d = "";
        this.f48426f = CollectionsKt.emptyList();
        this.f48437q = new QLiveData();
        this.f48446z = CollectionsKt.emptyList();
        this.A = new km.b();
        this.H = ScrollStatus.CANT_SCROLL;
        this.O = ProductCardType.UNKNOW;
        this.P = LazyKt.lazy(new StoreV2ProductItemVO$standardChainParam$2(this));
    }

    public final List<ECRitTag> c(String r100) {
        Map<String, ? extends List<ECRitTag>> r101 = this.f48436p;
        if (r101 == null) goto L9;
        List<ECRitTag> r102 = r101.get(r100);
        if (r102 == null) goto L9;
        if ((!r102.isEmpty()) == false) goto L9;
        return r102;
    L9:
        return null;
    }
}
