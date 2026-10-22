package com.bytedance.android.shopping.feed.model;

import com.bytedance.android.ec.model.api.CommerceBaseResponse;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import rd3.j;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0007\u0010\bR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/bytedance/android/shopping/feed/model/SaveMoneyCardMarketingInfoResponse;", "Lcom/bytedance/android/ec/model/api/CommerceBaseResponse;", "Lrd3/j;", "marketingInfo", "Lrd3/j;", "getMarketingInfo", "()Lrd3/j;", "<init>", "()V", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SaveMoneyCardMarketingInfoResponse extends CommerceBaseResponse {

    @SerializedName("marketing_info")
    private final j marketingInfo;

    public SaveMoneyCardMarketingInfoResponse() {
    }

    public final j getMarketingInfo() {
        return this.marketingInfo;
    }
}
