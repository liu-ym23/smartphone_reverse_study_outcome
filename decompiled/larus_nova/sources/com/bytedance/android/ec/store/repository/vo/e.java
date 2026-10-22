package com.bytedance.android.ec.store.repository.vo;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010 \n\u0002\u0010$\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u001c\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u0004\u001a\u0004\b\u000e\u0010\u0006R6\u0010\u0011\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0010\u0018\u00010\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/ec/store/repository/vo/e;", "", "", "activityButtonText", "Ljava/lang/String;", "getActivityButtonText", "()Ljava/lang/String;", "productTabParams", "d", "productTabPassThroughApi", "e", "applyCouponSource", "b", "applyCouponInfo", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "", "", "applyResourceParams", "Ljava/util/List;", "c", "()Ljava/util/List;", "f", "(Ljava/util/List;)V", "<init>", "()V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class e {

    @SerializedName("activity_button_text")
    private final String activityButtonText;

    @SerializedName("apply_coupon_info")
    private final String applyCouponInfo;

    @SerializedName("apply_coupon_source")
    private final String applyCouponSource;

    @SerializedName("apply_resource_params")
    private List<? extends Map<String, ? extends Object>> applyResourceParams;

    @SerializedName("product_tab_params")
    private final String productTabParams;

    @SerializedName("product_tab_pass_through_api")
    private final String productTabPassThroughApi;

    public e() {
    }

    public final String a() {
        return this.applyCouponInfo;
    }

    public final String b() {
        return this.applyCouponSource;
    }

    public final List<Map<String, Object>> c() {
        return this.applyResourceParams;
    }

    public final String d() {
        return this.productTabParams;
    }

    public final String e() {
        return this.productTabPassThroughApi;
    }

    public final void f(List<? extends Map<String, ? extends Object>> r100) {
        this.applyResourceParams = r100;
    }
}
