package com.bytedance.android.shopping.store.tabkit.ssr.interfaces;

import android.os.Handler;
import com.bytedance.android.shopping.store.tabkit.ssr.SSRModel;
import com.bytedance.android.shopping.store.utils.CommonUtils;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class SSRFetchCallbackDelegate implements ISSRFetchCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicBoolean f186850a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ISSRFetchCallback f186851b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, Long> f186852c;

    @Override // com.bytedance.android.shopping.store.tabkit.ssr.interfaces.ISSRFetchCallback
    public final void onFailed(final SSRModel r100) {
        Intrinsics.checkNotNullParameter(r100, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        if (this.f186850a.getAndSet(true) == false) goto L5;
        return;
    L5:
        Handler r101 = CommonUtils.f186901a;
        CommonUtils.e(false, new AnonymousClass1(this, r100));
    }

    @Override // com.bytedance.android.shopping.store.tabkit.ssr.interfaces.ISSRFetchCallback
    public final void onSSRHydrate(final SSRModel r100) {
        Intrinsics.checkNotNullParameter(r100, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        if (this.f186850a.getAndSet(true) == false) goto L5;
        return;
    L5:
        Handler r101 = CommonUtils.f186901a;
        CommonUtils.e(false, new C104071(this, r100));
    }

    @Override // com.bytedance.android.shopping.store.tabkit.ssr.interfaces.ISSRFetchCallback
    public final void onSSRRender(final SSRModel r100) {
        Intrinsics.checkNotNullParameter(r100, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        Handler r101 = CommonUtils.f186901a;
        CommonUtils.e(false, new C104081(this, r100));
    }

    public SSRFetchCallbackDelegate(ISSRFetchCallback r100, Map<String, Long> r101) {
        Intrinsics.checkNotNullParameter(r100, "cb");
        Intrinsics.checkNotNullParameter(r101, "timing");
        this.f186851b = r100;
        this.f186852c = r101;
        this.f186850a = new AtomicBoolean(false);
    }
}
