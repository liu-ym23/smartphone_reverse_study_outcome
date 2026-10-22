package com.bytedance.android.ec.store.repository.vo;

import com.amap.api.col.s.ce;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010$\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001a\u0010\u001bR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0010\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR0\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006\u001c"}, d2 = {"Lcom/bytedance/android/ec/store/repository/vo/g;", "", "", "schema", "Ljava/lang/String;", "d", "()Ljava/lang/String;", RXScreenCaptureService.KEY_INDEX, "(Ljava/lang/String;)V", "", "planId", "Ljava/lang/Long;", "c", "()Ljava/lang/Long;", "h", "(Ljava/lang/Long;)V", "couponTotalCount", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "f", "", "panelData", "Ljava/util/Map;", "b", "()Ljava/util/Map;", ce.f26391f, "(Ljava/util/Map;)V", "<init>", "()V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class g {

    @SerializedName("coupon_total_count")
    private Long couponTotalCount;

    @SerializedName("panel_data")
    private Map<String, ? extends Object> panelData;

    @SerializedName("plan_id")
    private Long planId;

    @SerializedName("panel_schema")
    private String schema;

    public g() {
    }

    public final boolean e() {
        Long r100 = this.couponTotalCount;
        if (r100 != null) goto L6;
    L8:
        return false;
    L6:
        if (r100.longValue() != 1) goto L8;
        return true;
    }

    public final Long a() {
        return this.couponTotalCount;
    }

    public final Map<String, Object> b() {
        return this.panelData;
    }

    public final Long c() {
        return this.planId;
    }

    public final String d() {
        return this.schema;
    }

    public final void f(Long r100) {
        this.couponTotalCount = r100;
    }

    public final void g(Map<String, ? extends Object> r100) {
        this.panelData = r100;
    }

    public final void h(Long r100) {
        this.planId = r100;
    }

    public final void i(String r100) {
        this.schema = r100;
    }
}
