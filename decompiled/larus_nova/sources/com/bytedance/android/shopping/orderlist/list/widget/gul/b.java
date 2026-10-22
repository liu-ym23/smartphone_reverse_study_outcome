package com.bytedance.android.shopping.orderlist.list.widget.gul;

import com.bytedance.android.ec.adapter.api.IAdapterService;
import com.bytedance.android.ec.base.service.ECServiceManager;
import com.bytedance.android.ec.host.api.hybrid.ECBaseBridgeMethod;
import com.bytedance.ies.web.jsbridge2.f;

/* JADX INFO: loaded from: classes13.dex */
public final class b implements f.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ OrderListGULComponent f180450a;

    public b(OrderListGULComponent r100) {
        this.f180450a = r100;
    }

    @Override // com.bytedance.ies.web.jsbridge2.f.b
    public final f<Object, Object> a() {
        final OrderListGULComponent r100 = this.f180450a;
        r100.getClass();
        ECBaseBridgeMethod r101 = new OrderListGULComponent$getBridgeMethod$bridgeMethod$1(r100);
        boolean r102 = ECServiceManager.f42805a;
        pd.e r103 = ((IAdapterService) ECServiceManager.c(IAdapterService.class)).getIExternaHybridService();
        if (r103 == null) goto L7;
        pd.f r104 = r103.getExternalJsBridgeMethodInjectorAdapter();
        if (r104 == null) goto L7;
        return r104.d(r101);
    L7:
        return null;
    }
}
