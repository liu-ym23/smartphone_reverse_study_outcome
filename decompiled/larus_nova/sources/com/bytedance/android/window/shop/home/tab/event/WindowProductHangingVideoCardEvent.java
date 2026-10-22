package com.bytedance.android.window.shop.home.tab.event;

import com.bytedance.android.ec.core.event.BaseMetricsEvent2;
import com.bytedance.android.ec.core.event.a;
import com.bytedance.android.ec.core.event.eventdumper.EventKey;
import com.bytedance.android.ec.window.base.repository.vo.WindowV2ProductItemVO;
import com.bytedance.android.shopping.api.window.AwemeInfo;
import com.bytedance.android.window.shop.repository.tab.entity.o;
import com.bytedance.android.window.shop.repository.tab.entity.p;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0015\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0018\u001a\u00020\u0005¢\u0006\u0004\b\u0019\u0010\u000bJ\u000e\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002R$\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR$\u0010\f\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0007\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000bR$\u0010\u000f\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0007\u001a\u0004\b\u0010\u0010\t\"\u0004\b\u0011\u0010\u000bR$\u0010\u0012\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0007\u001a\u0004\b\u0013\u0010\t\"\u0004\b\u0014\u0010\u000bR\"\u0010\u0015\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0007\u001a\u0004\b\u0016\u0010\t\"\u0004\b\u0017\u0010\u000b¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/window/shop/home/tab/event/WindowProductHangingVideoCardEvent;", "Lcom/bytedance/android/ec/core/event/BaseMetricsEvent2;", "Lcom/bytedance/android/window/shop/repository/tab/entity/p;", "videoVo", "fillWith", "", "groupId", "Ljava/lang/String;", "getGroupId", "()Ljava/lang/String;", "setGroupId", "(Ljava/lang/String;)V", "productId", "getProductId", "setProductId", "requestId", "getRequestId", "setRequestId", "commodityId", "getCommodityId", "setCommodityId", "commodityType", "getCommodityType", "setCommodityType", "actionName", "<init>", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class WindowProductHangingVideoCardEvent extends BaseMetricsEvent2 {

    @EventKey(a.KEY_COMMODITY_ID)
    private String commodityId;

    @EventKey(a.KEY_COMMODITY_TYPE)
    private String commodityType;

    @EventKey("group_id")
    private String groupId;

    @EventKey("product_id")
    private String productId;

    @EventKey("request_id")
    private String requestId;

    public final String getCommodityId() {
        return this.commodityId;
    }

    public final String getCommodityType() {
        return this.commodityType;
    }

    public final String getGroupId() {
        return this.groupId;
    }

    public final String getProductId() {
        return this.productId;
    }

    public final String getRequestId() {
        return this.requestId;
    }

    public WindowProductHangingVideoCardEvent(String r100) {
        Intrinsics.checkNotNullParameter(r100, "actionName");
        super(r100);
        this.commodityType = "outflow_order";
    }

    public final WindowProductHangingVideoCardEvent fillWith(p r100) {
        Intrinsics.checkNotNullParameter(r100, "videoVo");
        String r101 = null;
        if ((r100 instanceof o) == true) goto L5;
        p r102 = null;
    L6:
        o r103 = (o) r102;
        if (r103 == null) goto L11;
        AwemeInfo r104 = r103.e();
        if (r104 == null) goto L11;
        String r105 = r104.a();
    L12:
        this.groupId = r105;
        WindowV2ProductItemVO r106 = r100.f189623k;
        if (r106 == null) goto L15;
        String r107 = r106.f49463a;
    L16:
        this.productId = r107;
        if (r106 == null) goto L30;
        String r108 = r106.f49464b;
        if (r108 == null) goto L30;
        if (r108.length() <= 0) goto L23;
        boolean r109 = true;
    L24:
        if (r109 == true) goto L27;
        r108 = null;
    L27:
        if (r108 == null) goto L30;
        r101 = r108;
    L32:
        this.commodityId = r101;
        return this;
    L23:
        r109 = false;
    L30:
        if (r106 == null) goto L32;
        r101 = r106.f49463a;
        goto L32
    L15:
        r107 = null;
    L11:
        r105 = null;
        goto L12
    L5:
        r102 = r100;
        goto L6
    }

    public final void setCommodityId(String r100) {
        this.commodityId = r100;
    }

    public final void setCommodityType(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.commodityType = r100;
    }

    public final void setGroupId(String r100) {
        this.groupId = r100;
    }

    public final void setProductId(String r100) {
        this.productId = r100;
    }

    public final void setRequestId(String r100) {
        this.requestId = r100;
    }
}
