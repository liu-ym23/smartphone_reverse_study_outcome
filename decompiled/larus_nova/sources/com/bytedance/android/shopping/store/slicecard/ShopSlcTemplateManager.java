package com.bytedance.android.shopping.store.slicecard;

import androidx.camera.video.AudioStats;
import com.bytedance.android.ec.store.setting.k;
import com.bytedance.android.shopping.store.settings.ECShopABSettings;
import com.bytedance.android.shopping.store.slicecard.dto.ShopSliceItemConfig;
import com.bytedance.android.shopping.store.slicecard.dto.SliceTemplate;
import com.bytedance.android.shopping.store.slicecard.dto.SliceTemplateType;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class ShopSlcTemplateManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final com.bytedance.android.ec.store.setting.j f186315a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final List<String> f186316b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final List<String> f186317c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final List<String> f186318d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final List<String> f186319e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final List<String> f186320f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final List<String> f186321g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Lazy f186322h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final ConcurrentHashMap<String, ShopSliceItemConfig> f186323i = null;

    static {
        f186315a = new com.bytedance.android.ec.store.setting.j(CollectionsKt.listOf(new k[]{new k("shop_product_col2", 4, "https://lf-webcast-sourcecdn-tos.bytegecko.com/obj/byte-gurd-source/10181/gecko/resource/ecom_shop_slice_template/shop_product_col2/main.json"), new k("shop_product_col1", 4, "https://lf-webcast-sourcecdn-tos.bytegecko.com/obj/byte-gurd-source/10181/gecko/resource/ecom_shop_slice_template/shop_product_col1/main.json"), new k("shop_profile_ordinary", 1, "https://lf-webcast-sourcecdn-tos.bytegecko.com/obj/byte-gurd-source/10181/gecko/resource/ecom_shop_slice_template/shop_profile_ordinary/main.json"), new k("shop_profile_flagship", 1, "https://lf-webcast-sourcecdn-tos.bytegecko.com/obj/byte-gurd-source/10181/gecko/resource/ecom_shop_slice_template/shop_profile_flagship/main.json"), new k("shop_profile_brand", 1, "https://lf-webcast-sourcecdn-tos.bytegecko.com/obj/byte-gurd-source/10181/gecko/resource/ecom_shop_slice_template/shop_profile_brand/main.json"), new k("shop_profile_abnormal", 1, "https://lf-webcast-sourcecdn-tos.bytegecko.com/obj/byte-gurd-source/10181/gecko/resource/ecom_shop_slice_template/shop_profile_abnormal/main.json"), new k("shop_profile_brand_concise", 1, "https://lf-webcast-sourcecdn-tos.bytegecko.com/obj/byte-gurd-source/10181/gecko/resource/ecom_shop_slice_template/shop_profile_brand_concise/main.json"), new k("card_pack_shop_product_col1", 4, "https://lf-webcast-sourcecdn-tos.bytegecko.com/obj/byte-gurd-source/10181/gecko/resource/ecom_shop_slice_template/shop_product_col1_v2/main.json"), new k("card_pack_shop_product_col2", 4, "https://lf-webcast-sourcecdn-tos.bytegecko.com/obj/byte-gurd-source/10181/gecko/resource/ecom_shop_slice_template/shop_product_col2_v2/main.json"), new k("shop_product_clothing", 5, "https://lf-webcast-sourcecdn-tos.bytegecko.com/obj/byte-gurd-source/10181/gecko/resource/ecom_shop_slice_template/shop_product_clothing/main.json"), new k("shop_product_filter", 1, "https://lf-webcast-sourcecdn-tos.bytegecko.com/obj/byte-gurd-source/10181/gecko/resource/ecom_shop_slice_template/shop_product_filter/main.json")}));
        f186316b = CollectionsKt.listOf(new String[]{"shop_product_col1", "shop_product_col2"});
        f186317c = CollectionsKt.listOf(new String[]{"card_pack_shop_product_col1", "card_pack_shop_product_col2", "shop_product_clothing"});
        f186318d = CollectionsKt.listOf("shop_product_filter");
        f186319e = CollectionsKt.listOf(new String[]{"shop_profile_flagship", "shop_profile_ordinary", "shop_profile_brand", "shop_profile_abnormal"});
        f186320f = CollectionsKt.listOf("shop_top_bar");
        f186321g = CollectionsKt.listOf("shop_profile_brand_concise");
        f186322h = LazyKt.lazy(ShopSlcTemplateManager$templateSetting$2.INSTANCE);
        f186323i = new ConcurrentHashMap();
    }

    public static SliceTemplate a(SliceItemType r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "itemType");
        Object r102 = null;
        Integer r103 = null;
        if (ECShopABSettings.getEC_SHOP_CARD_PACK_FORCE_LOCAL() != 1) goto L45;
        ShopSliceItemConfig r104 = f186323i.get(r100.getType());
        if (r104 == null) goto L20;
        Iterator<T> r105 = r104.getTemplates().iterator();
    L8:
        if (r105.hasNext() == false) goto L18;
        Object r106 = r105.next();
        Integer r107 = ((SliceTemplate) r106).getSpanSize();
        if (r107 != null) goto L13;
    L15:
        boolean r108 = false;
    L16:
        if (r108 == false) goto L8;
    L19:
        SliceTemplate r109 = (SliceTemplate) r106;
    L21:
        SliceTemplate r110 = new SliceTemplate();
        if (r109 == null) goto L24;
        String r111 = r109.getName();
    L25:
        r110.setName(r111);
        if (r109 == null) goto L28;
        String r112 = r109.getUrl();
    L29:
        r110.setUrl(r112);
        if (r109 == null) goto L32;
        String r113 = r109.getVersion();
    L33:
        r110.setVersion(r113);
        if (r109 == null) goto L36;
        int r114 = r109.getType();
    L37:
        r110.setType(r114);
        if (r109 == null) goto L40;
        r103 = r109.getSpanSize();
    L40:
        r110.setSpanSize(r103);
        if (r109 == null) goto L43;
        double r115 = r109.getPredictHeight();
    L44:
        r110.setPredictHeight(r115);
        return r110;
    L43:
        r115 = AudioStats.AUDIO_AMPLITUDE_NONE;
        goto L44
    L36:
        r114 = SliceTemplateType.GECKO.getType();
        goto L37
    L32:
        r113 = null;
        goto L33
    L28:
        r112 = null;
        goto L29
    L24:
        r111 = null;
        goto L25
    L13:
        if (r107.intValue() != r101) goto L15;
        r108 = true;
        goto L16
    L18:
        r106 = null;
        goto L19
    L20:
        r109 = null;
        goto L21
    L45:
        ShopSliceItemConfig r116 = f186323i.get(r100.getType());
        if (r116 == null) goto L72;
        Iterator<T> r117 = r116.getTemplates().iterator();
    L49:
        if (r117.hasNext() == false) goto L60;
        Object r118 = r117.next();
        Integer r119 = ((SliceTemplate) r118).getSpanSize();
        if (r119 != null) goto L54;
    L56:
        boolean r120 = false;
    L57:
        if (r120 == false) goto L49;
        r102 = r118;
        goto L60
    L54:
        if (r119.intValue() != r101) goto L56;
        r120 = true;
    L60:
        return (SliceTemplate) r102;
    L72:
        return null;
    }
}
