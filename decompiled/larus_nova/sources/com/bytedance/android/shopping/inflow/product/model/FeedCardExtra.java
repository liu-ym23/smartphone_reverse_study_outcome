package com.bytedance.android.shopping.inflow.product.model;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.io.Serializable;
import kotlin.Metadata;
import qe3.c;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u00132\u00020\u0001:\u0001\u0014B\u0007¢\u0006\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\r\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/shopping/inflow/product/model/FeedCardExtra;", "Ljava/io/Serializable;", "", "recommendInfo", "Ljava/lang/String;", "getRecommendInfo", "()Ljava/lang/String;", "Lcom/bytedance/android/shopping/inflow/product/model/FeedCardCartInfo;", "cartInfo", "Lcom/bytedance/android/shopping/inflow/product/model/FeedCardCartInfo;", "getCartInfo", "()Lcom/bytedance/android/shopping/inflow/product/model/FeedCardCartInfo;", "Lqe3/c;", "innerFlowPageStyle", "Lqe3/c;", "getInnerFlowPageStyle", "()Lqe3/c;", "<init>", "()V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class FeedCardExtra implements Serializable {
    public static final a Companion = null;
    private static final long serialVersionUID = -23712;

    @SerializedName("cart_info")
    private final FeedCardCartInfo cartInfo;

    @SerializedName("inner_flow_page_style")
    private final c innerFlowPageStyle;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_RECOMMEND_INFO)
    private final String recommendInfo;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public FeedCardExtra() {
    }

    public final FeedCardCartInfo getCartInfo() {
        return this.cartInfo;
    }

    public final c getInnerFlowPageStyle() {
        return this.innerFlowPageStyle;
    }

    public final String getRecommendInfo() {
        return this.recommendInfo;
    }
}
