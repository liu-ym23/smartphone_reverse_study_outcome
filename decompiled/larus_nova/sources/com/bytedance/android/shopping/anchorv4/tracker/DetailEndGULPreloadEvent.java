package com.bytedance.android.shopping.anchorv4.tracker;

import com.bytedance.android.ec.core.event.BaseMetricsEvent2;
import com.bytedance.android.ec.core.event.eventdumper.EventKey;
import kotlin.Metadata;
import kotlin.Unit;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u000b\u001a\u00020\b8\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0016\u0010\r\u001a\u00020\u000e8\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0011\u001a\u00020\b8\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\n¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/tracker/DetailEndGULPreloadEvent;", "Lcom/bytedance/android/ec/core/event/BaseMetricsEvent2;", "()V", "detail", "Lorg/json/JSONObject;", "getDetail", "()Lorg/json/JSONObject;", "pageName", "", "getPageName", "()Ljava/lang/String;", "prefetchType", "getPrefetchType", "status", "", "getStatus", "()I", "type", "getType", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class DetailEndGULPreloadEvent extends BaseMetricsEvent2 {

    @EventKey("detail")
    private final JSONObject detail;

    @EventKey("page_name")
    private final String pageName;

    @EventKey("gyl_prefetch_type")
    private final String prefetchType;

    @EventKey("status")
    private final int status;

    @EventKey("type")
    private final String type;

    public DetailEndGULPreloadEvent() {
        super("ies_ecommerce_client_custom_log");
        JSONObject r100 = new JSONObject();
        r100.put("t_net_start", System.currentTimeMillis());
        Unit r101 = Unit.INSTANCE;
        this.detail = r100;
        this.type = "PERFORMANCE_LOG";
        this.prefetchType = "mall_feed_in_detail";
        this.status = 1;
        this.pageName = com.bytedance.android.ec.core.event.a.VALUE_PRODUCT_DETAIL;
    }

    public final JSONObject getDetail() {
        return this.detail;
    }

    public final String getPageName() {
        return this.pageName;
    }

    public final String getPrefetchType() {
        return this.prefetchType;
    }

    public final int getStatus() {
        return this.status;
    }

    public final String getType() {
        return this.type;
    }
}
