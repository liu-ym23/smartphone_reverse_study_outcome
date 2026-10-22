package com.bytedance.android.window.shop.home.tab.event;

import com.bytedance.android.ec.core.event.BaseMetricsEvent2;
import com.bytedance.android.ec.core.event.a;
import com.bytedance.android.ec.core.event.eventdumper.EventKey;
import com.bytedance.android.ec.window.base.repository.vo.WindowV2ProductItemVO;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0015\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tR\u0016\u0010\n\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\r\u001a\u00020\u00058\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0016\u0010\u000f\u001a\u00020\u00058\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0016\u0010\u0011\u001a\u00020\u00058\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\fR\u0016\u0010\u0013\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\fR\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\fR\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\fR\u0016\u0010\u0019\u001a\u00020\u00058\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\fR\u0016\u0010\u001b\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\f¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/window/shop/home/tab/event/WindowProductTagShowEvent;", "Lcom/bytedance/android/ec/core/event/BaseMetricsEvent2;", "videoCard", "", "tagTrackParam", "", "entranceForm", "product", "Lcom/bytedance/android/ec/window/base/repository/vo/WindowV2ProductItemVO;", "(ZLjava/lang/String;Ljava/lang/String;Lcom/bytedance/android/ec/window/base/repository/vo/WindowV2ProductItemVO;)V", "ecomEntranceForm", "getEcomEntranceForm", "()Ljava/lang/String;", "ecomGroupType", "getEcomGroupType", "feature", "getFeature", "pageName", "getPageName", "productId", "getProductId", "productTag", "getProductTag", "promotionId", "getPromotionId", "scene", "getScene", "tagShowPagePosition", "getTagShowPagePosition", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class WindowProductTagShowEvent extends BaseMetricsEvent2 {

    @EventKey(a.KEY_ECOM_ENTRANCE_FORM)
    private final String ecomEntranceForm;

    @EventKey(a.KEY_ECOM_GROUP_TYPE)
    private final String ecomGroupType;

    @EventKey(a.KEY_EVENT_ORIGIN_FEATURE)
    private final String feature;

    @EventKey("page_name")
    private final String pageName;

    @EventKey("product_id")
    private final String productId;

    @EventKey("product_tag")
    private final String productTag;

    @EventKey("promotion_id")
    private final String promotionId;

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

    public final String getProductId() {
        return this.productId;
    }

    public final String getProductTag() {
        return this.productTag;
    }

    public final String getPromotionId() {
        return this.promotionId;
    }

    public final String getScene() {
        return this.scene;
    }

    public final String getTagShowPagePosition() {
        return this.tagShowPagePosition;
    }

    public WindowProductTagShowEvent(boolean r100, String r101, String r102, WindowV2ProductItemVO r103) {
        Intrinsics.checkNotNullParameter(r102, "entranceForm");
        Intrinsics.checkNotNullParameter(r103, "product");
        super("product_tag_show");
        this.feature = a.VALUE_TEMAI;
        this.pageName = "store_page";
        this.scene = LiveEndPageData.TAG_WINDOW;
        this.ecomGroupType = "product";
        this.productId = r103.f49463a;
        this.promotionId = r103.f49464b;
        this.ecomEntranceForm = r102;
        if (r100 == false) goto L5;
        String r104 = "window_video_card";
    L6:
        this.tagShowPagePosition = r104;
        this.productTag = r101;
        return;
    L5:
        r104 = "window_product_card";
        goto L6
    }
}
