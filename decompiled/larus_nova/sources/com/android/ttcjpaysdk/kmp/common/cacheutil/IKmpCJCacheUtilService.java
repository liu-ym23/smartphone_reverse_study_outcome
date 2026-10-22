package com.android.ttcjpaysdk.kmp.common.cacheutil;

import kotlin.Metadata;
import pd6.a;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\b"}, d2 = {"Lcom/android/ttcjpaysdk/kmp/common/cacheutil/IKmpCJCacheUtilService;", "Lcom/bytedance/kmp/spi/IKmpService;", "setCacheData", "", "key", "", "value", "getCacheData", "cj_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IKmpCJCacheUtilService extends a {
    String getCacheData(String r100);

    void setCacheData(String r100, String r101);
}
