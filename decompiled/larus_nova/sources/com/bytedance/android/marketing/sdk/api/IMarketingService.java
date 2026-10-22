package com.bytedance.android.marketing.sdk.api;

import android.content.Context;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bg\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/marketing/sdk/api/IMarketingService;", "", "ec-biz-marketing-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IMarketingService {
    void a(Context r100, String r101, boolean r102);

    Integer getFoldStatus();

    Integer getFoldType();
}
