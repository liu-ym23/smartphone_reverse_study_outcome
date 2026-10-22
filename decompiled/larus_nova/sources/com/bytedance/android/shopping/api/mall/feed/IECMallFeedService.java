package com.bytedance.android.shopping.api.mall.feed;

import android.content.Context;
import com.bytedance.android.shopping.mall.feed.ECMallFeedOptService;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bg\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/feed/IECMallFeedService;", "", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IECMallFeedService {
    void a(Context r100);

    g b(String r100);

    ECMallFeedOptService c();

    d createFeedComponent(Context r100, b r101, e r102, f r103);
}
