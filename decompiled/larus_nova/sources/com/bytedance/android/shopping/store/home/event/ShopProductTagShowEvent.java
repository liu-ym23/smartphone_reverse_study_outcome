package com.bytedance.android.shopping.store.home.event;

import com.bytedance.android.ec.core.event.BaseMetricsEvent2;
import com.bytedance.android.ec.core.event.a;
import com.bytedance.android.ec.core.event.eventdumper.EventKey;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\u0018\u00002\u00020\u0001B\u0017\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005R\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\t\u001a\u00020\u00038\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\bR\u0016\u0010\u000b\u001a\u00020\u00038\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\bR\u0016\u0010\r\u001a\u00020\u00038\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\bR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\bR\u0016\u0010\u0011\u001a\u00020\u00038\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\bR\u0016\u0010\u0013\u001a\u00020\u00038\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/shopping/store/home/event/ShopProductTagShowEvent;", "Lcom/bytedance/android/ec/core/event/BaseMetricsEvent2;", "tagTrackParam", "", "entranceForm", "(Ljava/lang/String;Ljava/lang/String;)V", "ecomEntranceForm", "getEcomEntranceForm", "()Ljava/lang/String;", "ecomGroupType", "getEcomGroupType", "feature", "getFeature", "pageName", "getPageName", "productTag", "getProductTag", "scene", "getScene", "tagShowPagePosition", "getTagShowPagePosition", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ShopProductTagShowEvent extends BaseMetricsEvent2 {

    @EventKey(a.KEY_ECOM_ENTRANCE_FORM)
    private final String ecomEntranceForm;

    @EventKey(a.KEY_ECOM_GROUP_TYPE)
    private final String ecomGroupType;

    @EventKey(a.KEY_EVENT_ORIGIN_FEATURE)
    private final String feature;

    @EventKey("page_name")
    private final String pageName;

    @EventKey("product_tag")
    private final String productTag;

    @EventKey("tag_show_scene")
    private final String scene;

    @EventKey("tag_show_page_position")
    private final String tagShowPagePosition;

    public final String getEcomEntranceForm() {
        return this.ecomEntranceForm;
    }

    public final String getEcomGroupType() {
        return this.ecomGroupType;
    }

    public final String getFeature() {
        return this.feature;
    }

    public final String getPageName() {
        return this.pageName;
    }

    public final String getProductTag() {
        return this.productTag;
    }

    public final String getScene() {
        return this.scene;
    }

    public final String getTagShowPagePosition() {
        return this.tagShowPagePosition;
    }

    public ShopProductTagShowEvent(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "entranceForm");
        super("product_tag_show");
        this.feature = a.VALUE_TEMAI;
        this.pageName = "store_page";
        this.scene = "shop";
        this.ecomGroupType = "product";
        this.ecomEntranceForm = r101;
        this.tagShowPagePosition = "shop_header";
        this.productTag = r100;
    }
}
