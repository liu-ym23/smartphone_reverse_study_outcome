package com.bytedance.android.shopping.store.tabkit;

import com.bytedance.android.ec.core.hybrid.prefetch.NativePrefetchMethod;
import com.bytedance.android.ec.host.api.hybrid.ECBaseBridgeMethod;

/* JADX INFO: loaded from: classes14.dex */
public final class d implements com.bytedance.ies.web.jsbridge2.f.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ pd.f f186735a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ECBaseBridgeMethod f186736b;

    public d(pd.f r100, NativePrefetchMethod r101) {
        this.f186735a = r100;
        this.f186736b = r101;
    }

    @Override // com.bytedance.ies.web.jsbridge2.f.b
    public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
        return this.f186735a.d(this.f186736b);
    }
}
