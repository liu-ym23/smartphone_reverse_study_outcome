package com.android.ttcjpaysdk.base.service;

import com.android.ttcjpaysdk.network.ITTCJPayCallback;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH&J\b\u0010\u000b\u001a\u00020\u0007H&¨\u0006\f"}, d2 = {"Lcom/android/ttcjpaysdk/base/service/ICJOuterPrefetchService;", "", "clearCache", "", "from", "", "getCacheData", "", "cacheKey", "callback", "Lcom/android/ttcjpaysdk/network/ITTCJPayCallback;", "isOuterBdPayNormal", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface ICJOuterPrefetchService {
    void clearCache(String r100);

    boolean getCacheData(String r100, ITTCJPayCallback r101);

    boolean isOuterBdPayNormal();
}
