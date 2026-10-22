package com.bytedance.android.window.shop.home.tab;

import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.model.response.ECRitTag;
import com.bytedance.android.ec.window.base.common.datachannel.ECWindowProductForm;
import com.bytedance.android.ec.window.base.repository.dto.WindowV2ProductItemDTO;
import com.bytedance.android.ec.window.base.repository.vo.WindowV2ProductItemVO;
import com.bytedance.android.ec.window.base.utils.i;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.bytedance.android.shopping.extensions.k;
import com.bytedance.android.window.shop.CategoryTabStruct;
import com.bytedance.android.window.shop.home.ECWindowParam;
import com.bytedance.android.window.shop.home.viewmodel.ECWindowViewModel;
import com.bytedance.android.window.shop.widget.ClickSeparatedTabSelectListener;
import com.bytedance.commerce.base.json.JsonDslUtilKt;
import com.larus.dora.api.model.FlowDoraWifiScene;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes14.dex */
public final class WindowTabEventReporter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f188681a = 0;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/window/shop/home/tab/WindowTabEventReporter$EventType;", "", "SHOW", "CLICK", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum EventType extends Enum<EventType> {
        public static final EventType CLICK = null;
        public static final EventType SHOW = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ EventType[] f188682a = null;

        static {
            EventType r100 = new EventType("SHOW", 0);
            SHOW = r100;
            EventType r101 = new EventType("CLICK", 1);
            CLICK = r101;
            f188682a = new EventType[]{r100, r101};
        }

        public static EventType valueOf(String r100) {
            return (EventType) r27.a.a(EventType.class, r100);
        }

        public static EventType[] values() {
            return (EventType[]) f188682a.clone();
        }

        public EventType(String r100, int r101) {
            super(r100, r101);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/window/shop/home/tab/WindowTabEventReporter$HotSaleProductClickArea;", "", "", "position", "I", "getPosition", "()I", "WATCH_PLAY_BACK", "BUY", FlowDoraWifiScene.OTHER, "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum HotSaleProductClickArea extends Enum<HotSaleProductClickArea> {
        public static final HotSaleProductClickArea BUY = null;
        public static final HotSaleProductClickArea OTHER = null;
        public static final HotSaleProductClickArea WATCH_PLAY_BACK = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ HotSaleProductClickArea[] f188683a = null;
        private final int position;

        static {
            HotSaleProductClickArea r100 = new HotSaleProductClickArea("WATCH_PLAY_BACK", 0, 101);
            WATCH_PLAY_BACK = r100;
            HotSaleProductClickArea r101 = new HotSaleProductClickArea("BUY", 1, 102);
            BUY = r101;
            HotSaleProductClickArea r102 = new HotSaleProductClickArea(FlowDoraWifiScene.OTHER, 2, 103);
            OTHER = r102;
            f188683a = new HotSaleProductClickArea[]{r100, r101, r102};
        }

        public static HotSaleProductClickArea valueOf(String r100) {
            return (HotSaleProductClickArea) r27.a.a(HotSaleProductClickArea.class, r100);
        }

        public static HotSaleProductClickArea[] values() {
            return (HotSaleProductClickArea[]) f188683a.clone();
        }

        public final int getPosition() {
            return this.position;
        }

        public HotSaleProductClickArea(String r100, int r101, int r102) {
            super(r100, r101);
            this.position = r102;
        }
    }

    public WindowTabEventReporter() {
    }

    static {
    }

    public static Map b(ECWindowParam r100) {
        return MapsKt.mutableMapOf(new Pair[]{TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_EVENT_ORIGIN_FEATURE, com.bytedance.android.ec.core.event.a.VALUE_TEMAI), TuplesKt.to("author_id", r100.getAuthorId()), TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_ENTRANCE_LOCATION, r100.getEntranceLocation()), TuplesKt.to("page_name", "store_page"), TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_STORE_TYPE, LiveEndPageData.TAG_WINDOW), TuplesKt.to("follow_status", String.valueOf(r100.getFollowStatus()))});
    }

    public static Map c(ECWindowParam r100, String r101, Integer r102) {
        Map r103 = b(r100);
        Pair r104 = TuplesKt.to("tab_id", r101);
        r103.put(r104.getFirst(), r104.getSecond());
        ConcurrentHashMap<String, CategoryTabStruct> r105 = com.bytedance.android.window.shop.e.f187769a;
        CategoryTabStruct r106 = r105.get(r101);
        String r107 = null;
        if (r106 == null) goto L7;
        Integer r108 = r106.getType();
        if (r108 == null) goto L7;
        String r109 = String.valueOf(r108.intValue());
    L8:
        Pair r110 = TuplesKt.to("tab_type", r109);
        r103.put(r110.getFirst(), r110.getSecond());
        CategoryTabStruct r111 = r105.get(r101);
        if (r111 == null) goto L11;
        String r112 = r111.getName();
    L12:
        Pair r113 = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_TAB_NAME, k.j(r112));
        r103.put(r113.getFirst(), r113.getSecond());
        Integer r114 = r100.getFollowStatus();
        if (r114 != null) goto L16;
    L18:
        String r115 = "1";
    L19:
        Pair r116 = TuplesKt.to("follow_status", r115);
        r103.put(r116.getFirst(), r116.getSecond());
        if (r102 == null) goto L22;
        r107 = String.valueOf(r102.intValue());
    L22:
        Pair r117 = TuplesKt.to("show_order", r107);
        r103.put(r117.getFirst(), r117.getSecond());
        return r103;
    L16:
        if (r114.intValue() != 0) goto L18;
        r115 = "0";
        goto L19
    L11:
        r112 = null;
    L7:
        r109 = null;
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void d(View r100, ECWindowViewModel r101, ECWindowParam r102, String r110) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "reporter");
        Intrinsics.checkNotNullParameter(r102, "shopParam");
        Intrinsics.checkNotNullParameter(r110, "orderType");
        PageFinder r103 = PageFinder.via(r100);
        Map r104 = b(r102);
        Pair r105 = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_ORDER_TYPE, r110);
        r104.put(r105.getFirst(), r105.getSecond());
        Unit r106 = Unit.INSTANCE;
        r101.doAnyEventActionWithBtm("c68164.d66157", r103, "click_ecommerce_store_sort", r104, new Pair[0]);
    }

    public static void f(ECWindowViewModel r100, ECWindowParam r101, Integer r102, String r103) {
        Map<String, String> r104 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_EVENT_ORIGIN_FEATURE, com.bytedance.android.ec.core.event.a.VALUE_TEMAI), TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_STORE_TYPE, LiveEndPageData.TAG_WINDOW), TuplesKt.to("author_id", r101.getAuthorId()), TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_ENTRANCE_LOCATION, r101.getEntranceLocation()), TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_STORE_SOURCE_PAGE, r101.getStoreSourcePage()), TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_STORE_SOURCE_METHOD, r101.getStoreSourceMethod()), TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_STORE_GROUP_TYPE, r101.getStoreGroupType())});
        if (r102 == null) goto L5;
        r104.put(com.bytedance.android.ec.core.event.a.KEY_PRODUCT_CNT, String.valueOf(r102.intValue()));
    L5:
        r100.doEventAction(r103, r104, new Pair[0]);
    }

    public static Map a(WindowV2ProductItemVO r110, ECWindowParam r111, ECWindowProductForm r112, FragmentActivity r113, String r114) {
        Intrinsics.checkNotNullParameter(r110, MapController.ITEM_LAYER_TAG);
        Intrinsics.checkNotNullParameter(r111, "shopParam");
        Intrinsics.checkNotNullParameter(r112, "productForm");
        Intrinsics.checkNotNullParameter(r113, "activity");
        Intrinsics.checkNotNullParameter(r114, "entranceFormSecond");
        Pair[] r100 = new Pair[28];
        r100[0] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_BST_GROUP_TYPE, "product");
        r100[1] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_ENTRANCE_LOCATION, r111.getEntranceLocation());
        r100[2] = TuplesKt.to("source_page", "store_page");
        r100[3] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_STORE_TYPE, LiveEndPageData.TAG_WINDOW);
        r100[4] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_ECOM_ENTRANCE_FORM, "live_top");
        r100[5] = TuplesKt.to("tab_name_second", r114);
        r100[6] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_ECOM_GROUP_TYPE, "product");
        r100[7] = TuplesKt.to("product_id", r110.f49463a);
        String r115 = r110.f49464b;
        String r101 = null;
        if (r115 != null) goto L5;
    L12:
        r115 = r110.f49463a;
    L13:
        r100[8] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_COMMODITY_ID, r115);
        Long r116 = r110.f49465c;
        if (r116 == null) goto L16;
        String r117 = String.valueOf(r116.longValue());
    L17:
        r100[9] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_COMMODITY_TYPE, r117);
        String r102 = "1";
        if (r111.getBrandTag() == null) goto L20;
        Object r118 = "1";
    L21:
        r100[10] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_BRAND_VERIFIED, r118);
        r100[11] = TuplesKt.to("search_params", r111.getSearchParams());
        r100[12] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_PRE_PRODUCT_ID, r111.getPreProductId());
        r100[13] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_PRE_ROOM_ID, r111.getPreRoomId());
        r100[14] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_PRE_GROUP_ID, r111.getPreGroupId());
        Map<String, ? extends List<ECRitTag>> r119 = r110.f49481s;
        if (r119 == null) goto L29;
        List<ECRitTag> r120 = r119.get("ecom_shop_product_before");
        if (r120 == null) goto L29;
        ECRitTag r121 = (ECRitTag) CollectionsKt.firstOrNull(r120);
        if (r121 == null) goto L29;
        r101 = r121.getTrackTag();
    L29:
        if (r101 != null) goto L31;
        r101 = "";
    L31:
        r100[15] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_LABEL_NAME, r101);
        if (r110.f() == null) goto L34;
        Object r103 = "1";
    L35:
        r100[16] = TuplesKt.to("is_product_info", r103);
        if (k.c(r110.f49471i) == false) goto L38;
        Object r104 = "1";
    L39:
        r100[17] = TuplesKt.to("is_price_info", r104);
        if (r110.d() == null) goto L42;
        Object r105 = "1";
    L43:
        r100[18] = TuplesKt.to("is_recommend_info", r105);
        WindowV2ProductItemDTO.b r106 = r110.f49484v;
        if (r106 == null) goto L46;
        String r107 = r106.a();
    L47:
        r100[19] = TuplesKt.to("content_form", r107);
        r100[20] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_CONTENT_SOURCE, "shop");
        r100[21] = TuplesKt.to("product_form", r112.getDes());
        JSONObject r122 = JsonDslUtilKt.a(new com.bytedance.commerce.base.json.a[]{JsonDslUtilKt.d(com.bytedance.android.ec.core.event.a.KEY_SOURCE_METHOD, "live_top"), JsonDslUtilKt.d("product_form", r112.getDes())});
        xn.c.b(r122, r113);
        r100[22] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_ENTRANCE_INFO, r122.toString());
        int r123 = i.f49729a;
        r100[23] = i.a("c3406.d8964_i" + ((Integer) r110.C.a(wn.a.C)), false);
        if (Intrinsics.areEqual((Boolean) r110.C.a(wn.a.B), Boolean.TRUE) == true) goto L51;
        r102 = "0";
    L51:
        r100[24] = TuplesKt.to("is_live_explain", r102);
        r100[25] = TuplesKt.to("product_orders", String.valueOf(k.f((Integer) r110.C.a(wn.a.A))));
        if (r111.isEcShare() == false) goto L54;
        Pair r124 = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_SHARE_CONTENT, r111.getShareContent());
    L55:
        r100[26] = r124;
        if (r111.isEcShare() == false) goto L58;
        Pair r125 = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_SHARE_OBJECT, r111.getShareObject());
    L59:
        r100[27] = r125;
        return MapsKt.mutableMapOf(r100);
    L58:
        r125 = TuplesKt.to("", "");
        goto L59
    L54:
        r124 = TuplesKt.to("", "");
        goto L55
    L46:
        r107 = "";
        goto L47
    L42:
        r105 = "0";
        goto L43
    L38:
        r104 = "0";
        goto L39
    L34:
        r103 = "0";
        goto L35
    L20:
        r118 = "0";
        goto L21
    L16:
        r117 = null;
        goto L17
    L5:
        if (r115.length() <= 0) goto L7;
        boolean r108 = true;
    L8:
        if (r108 == true) goto L11;
        r115 = null;
    L11:
        if (r115 != null) goto L13;
    L7:
        r108 = false;
        goto L8
    }

    public static void g(View r100, ECWindowViewModel r101, ECWindowParam r102, String r110, Integer r111) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "reporter");
        Intrinsics.checkNotNullParameter(r102, "shopParam");
        Intrinsics.checkNotNullParameter(r110, "categoryId");
        r101.doAnyEventActionWithBtm("a1.b7635.c68164.d260725", PageFinder.via(r100), "commodity_source_tab_show", c(r102, r110, r111), new Pair[0]);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void e(View r100, ECWindowViewModel r101, ECWindowParam r102, String r103, Integer r104, ClickSeparatedTabSelectListener.ActionType r105) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "reporter");
        Intrinsics.checkNotNullParameter(r102, "shopParam");
        Intrinsics.checkNotNullParameter(r103, "categoryId");
        Map r106 = c(r102, r103, r104);
        if (r105 == null) goto L9;
        int r107 = f.f188742b[r105.ordinal()];
        if (r107 != 1) goto L8;
        String r108 = "slide";
    L12:
        Pair r109 = TuplesKt.to("click_type", r108);
        r106.put(r109.getFirst(), r109.getSecond());
        r101.doAnyEventActionWithBtm("a1.b7635.c68164.d260725", PageFinder.via(r100), "commodity_source_tab_click", r106, new Pair[0]);
        return;
    L8:
        if (r107 != 2) goto L9;
        r108 = "click";
    L9:
        r108 = "default";
        goto L12
    }
}
