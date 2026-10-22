package com.bytedance.android.marketing.sdk.impl.api;

import com.bytedance.kmp.ec.yata.view.render.controller.common.ContainerPosition;
import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.http.Body;
import com.bytedance.retrofit2.http.HeaderMap;
import com.bytedance.retrofit2.http.POST;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b`\u0018\u00002\u00020\u0001J.\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0014\b\u0001\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u00062\b\b\u0001\u0010\b\u001a\u00020\tH'¨\u0006\n"}, d2 = {"Lcom/bytedance/android/marketing/sdk/impl/api/GrowthApi;", "", "getMarketingResource", "Lcom/bytedance/retrofit2/Call;", "Lcom/bytedance/android/marketing/sdk/impl/api/MarketingResourceResponse;", "headerMap", "", "", ContainerPosition.BODY, "Lcom/bytedance/android/marketing/sdk/impl/api/MarketingResourceRequestBody;", "ec-biz-marketing-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface GrowthApi {
    @POST("/growth/marketing_express/meGetMarketingResourceV2/")
    Call<MarketingResourceResponse> getMarketingResource(@HeaderMap Map<String, String> r100, @Body MarketingResourceRequestBody r101);
}
