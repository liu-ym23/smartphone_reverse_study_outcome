package com.bytedance.android.shopping.store.tabkit.ssr.interfaces;

import com.bytedance.android.shopping.store.tabkit.ssr.SSRModel;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\b"}, d2 = {"Lcom/bytedance/android/shopping/store/tabkit/ssr/interfaces/ISSRFetchCallback;", "", "onFailed", "", DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL, "Lcom/bytedance/android/shopping/store/tabkit/ssr/SSRModel;", "onSSRHydrate", "onSSRRender", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface ISSRFetchCallback {
    void onFailed(SSRModel r100);

    void onSSRHydrate(SSRModel r100);

    void onSSRRender(SSRModel r100);
}
