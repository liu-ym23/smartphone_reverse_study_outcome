package com.bytedance.android.shopping.skubuy.cache;

import b43.c;
import com.bytedance.android.ec.core.buynow.BuyNowPerformanceOpt;
import com.bytedance.android.ec.core.sku.UltimateBuyCacheConfig;
import com.bytedance.android.ec.core.utils.t0;
import com.bytedance.android.ec.model.abscontainer.ISchemaModel;
import com.bytedance.android.shopping.abscontainer.arch.core.cache.b;
import com.bytedance.android.shopping.sku.common.controller.SkuCommonBigPicCacheController;
import com.bytedance.android.shopping.skubuy.platform.helper.PlatformYataProtocolCrop$cropProtocolForCache$newYataData$1;
import com.bytedance.kmp.ec.yata.common.protocol.data.p;
import j43.d;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class SkuBuyResponseCacheHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f183110a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f183111b = null;

    static {
        f183110a = LazyKt.lazy(LazyThreadSafetyMode.NONE, SkuBuyResponseCacheHelper$skuBuyCacheConfig$2.INSTANCE);
        f183111b = LazyKt.lazy(SkuBuyResponseCacheHelper$lruCache$2.INSTANCE);
    }

    public static a a(ISchemaModel r100) {
        Intrinsics.checkNotNullParameter(r100, "schemaModel");
        String r101 = r100.getQueryParam("default_spec_id");
        c r102 = c.f17507a;
        String r103 = null;
        if (r101 != null) goto L27;
    L7:
        List r104 = null;
    L8:
        boolean r105 = false;
        if (r104 == null) goto L11;
        Object r106 = CollectionsKt.getOrNull(r104, 0);
    L13:
        if ((r106 instanceof String) == true) goto L15;
        r106 = null;
    L15:
        String r107 = (String) r106;
        if (r107 == null) goto L26;
        if (r107.length() != 0) goto L20;
        r105 = true;
    L20:
        if (r105 == true) goto L26;
        if (Intrinsics.areEqual(r107, "null") == true) goto L26;
        r103 = r107;
    L26:
        return new a(r100.getQueryParam("sku_promotion_id"), r100.getQueryParam("id"), r100.getQueryParam("scene_type"), r103);
    L11:
        r106 = null;
        goto L13
    L27:
        int r108 = t0.f45720a;     // Catch: Exception -> L6
        r104 = (List) t0.a.f45721a.fromJson(r101, new b43.a().getType());     // Catch: Exception -> L6
        goto L8
    }

    public static com.bytedance.android.shopping.abscontainer.arch.core.cache.a b(a r100) {
        Intrinsics.checkNotNullParameter(r100, "cacheKey");
        b r101 = (b) f183111b.getValue();
        String r102 = r100.a();
        r101.getClass();
        Intrinsics.checkNotNullParameter(r102, "cacheKey");
        com.bytedance.android.shopping.abscontainer.arch.core.cache.a r103 = r101.f164130a.b(r102);
        Object r104 = null;
        if (r103 != null) goto L6;
        return null;
    L6:
        if (c(r103) == true) goto L8;
        return null;
    L8:
        SkuCommonBigPicCacheController.a r105 = SkuCommonBigPicCacheController.f182622a;
        String r106 = r100.f183113b;
        if (r106 != null) goto L11;
        r106 = "";
    L11:
        com.bytedance.android.shopping.sku.common.controller.b r107 = SkuCommonBigPicCacheController.a(r106);
        if (r107 != null) goto L14;
    L43:
        return r103;
    L14:
        if (Boolean.valueOf(r107.f182630a).booleanValue() == false) goto L16;
        String r108 = "big_pic";
    L17:
        com.bytedance.kmp.ec.yata.common.protocol.data.c r109 = r103.f164128a.g();
        if (r109 == null) goto L26;
        Map<String, p> r110 = r109.getData();
        if (r110 == null) goto L26;
        p r111 = r110.get("specs_1");
        if (r111 == null) goto L26;
        Map<String, Object> r112 = r111.h();
        if (r112 == null) goto L26;
        Object r113 = r112.get("specs_state");
    L28:
        if ((r113 instanceof Map) == true) goto L30;
        r113 = null;
    L30:
        Map r114 = (Map) r113;
        if (r114 == null) goto L33;
        Object r115 = r114.get("0");
    L35:
        if (TypeIntrinsics.isMutableMap(r115) == false) goto L38;
        r104 = r115;
    L38:
        Map r116 = (Map) r104;
        if (r116 == null) goto L41;
        r116.get("cur_show_mode");
    L41:
        if (r116 == null) goto L43;
        r116.put("cur_show_mode", r108);
        goto L43
    L33:
        r115 = null;
    L26:
        r113 = null;
        goto L28
    L16:
        r108 = "small_pic";
        goto L17
    }

    public static boolean c(com.bytedance.android.shopping.abscontainer.arch.core.cache.a r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        int r101 = d.f497356a;
        if ((System.currentTimeMillis() - r100.f164129b) > (((UltimateBuyCacheConfig) f183110a.getValue()).getExpireTime() * ((long) 1000))) goto L9;
        return true;
    L9:
        return false;
    }

    public static void d(a r100, n33.a r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "cacheKey");
        Intrinsics.checkNotNullParameter(r101, "response");
        String r103 = r100.f183113b;
        boolean r104 = true;
        if (r103 != null) goto L5;
    L8:
        boolean r105 = true;
    L9:
        if (r105 == false) goto L12;
        return;
    L12:
        if (BuyNowPerformanceOpt.d() == true) goto L14;
        return;
    L14:
        com.bytedance.kmp.ec.yata.common.protocol.data.c r106 = r101.g();
        Object r107 = null;
        if (r106 == null) goto L19;
        Map<String, Object> r108 = r106.g();
        if (r108 == null) goto L19;
        Object r109 = r108.get("tracker_common_params");
    L21:
        if ((r109 instanceof Map) == true) goto L24;
        r109 = null;
    L24:
        if (mq.b.c((Map) r109, "all_forbidden", false) == false) goto L26;
        return;
    L26:
        String r110 = r100.f183115d;
        if (r102 == false) goto L63;
        com.bytedance.kmp.ec.yata.common.protocol.data.c r111 = r101.g();
        if (r111 == null) goto L35;
        Map<String, p> r112 = r111.getData();
        if (r112 == null) goto L35;
        p r113 = r112.get("specs_1");
        if (r113 == null) goto L35;
        Map<String, Object> r114 = r113.h();
    L36:
        if (r114 == null) goto L38;
        Object r115 = r114.get("specs_state");
    L40:
        if ((r115 instanceof Map) == true) goto L42;
        r115 = null;
    L42:
        Map r116 = (Map) r115;
        if (r116 == null) goto L45;
        Object r117 = r116.get("0");
    L47:
        if ((r117 instanceof Map) == true) goto L49;
        r117 = null;
    L49:
        Map r118 = (Map) r117;
        if (r118 == null) goto L52;
        Object r119 = r118.get("selected_spec_item_id");
    L54:
        if ((r119 instanceof String) == true) goto L56;
    L62:
        r110 = String.valueOf(r107);
        goto L63
    L56:
        if (((CharSequence) r119).length() == 0) goto L59;
        r104 = false;
    L59:
        if (r104 == true) goto L62;
        r107 = r119;
        goto L62
    L52:
        r119 = null;
        goto L54
    L45:
        r117 = null;
        goto L47
    L38:
        r115 = null;
    L35:
        r114 = null;
    L63:
        String r120 = r100.f183113b;
        com.bytedance.kmp.ec.yata.common.protocol.data.c r121 = r101.g();
        if (r121 == null) goto L67;
        int r122 = com.bytedance.android.shopping.skubuy.platform.helper.c.f183163a;
        Intrinsics.checkNotNullParameter(r121, "yataData");
        Intrinsics.checkNotNullParameter(r120, "productId");
        r101 = new n33.a(new com.bytedance.kmp.ec.yata.common.protocol.utils.d(r121, new PlatformYataProtocolCrop$cropProtocolForCache$newYataData$1()).a(), 2);
    L67:
        b r123 = (b) f183111b.getValue();
        String r124 = new a(r100.f183112a, r100.f183113b, r100.f183114c, r110).a();
        int r125 = d.f497356a;
        com.bytedance.android.shopping.abscontainer.arch.core.cache.a r126 = new com.bytedance.android.shopping.abscontainer.arch.core.cache.a(r101, System.currentTimeMillis());
        r123.getClass();
        Intrinsics.checkNotNullParameter(r124, "cacheKey");
        Intrinsics.checkNotNullParameter(r126, "cache");
        r123.f164130a.g(r124, r126);
        return;
    L19:
        r109 = null;
        goto L21
    L5:
        if (r103.length() == 0) goto L8;
        r105 = false;
        goto L9
    }
}
