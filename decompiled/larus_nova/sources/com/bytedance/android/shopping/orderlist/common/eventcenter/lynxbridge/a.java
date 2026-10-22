package com.bytedance.android.shopping.orderlist.common.eventcenter.lynxbridge;

import com.bytedance.android.ec.adapter.api.IAdapterService;
import com.bytedance.android.ec.base.service.ECServiceManager;
import com.bytedance.ies.web.jsbridge2.f;
import pd.e;

/* JADX INFO: loaded from: classes13.dex */
public final class a implements f.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BridgetLynxComponent f179864a;

    public a(BridgetLynxComponent r100) {
        this.f179864a = r100;
    }

    @Override // com.bytedance.ies.web.jsbridge2.f.b
    public final f<Object, Object> a() {
        final BridgetLynxComponent r100 = this.f179864a;
        r100.getClass();
        boolean r101 = ECServiceManager.f42805a;
        e r102 = ((IAdapterService) ECServiceManager.c(IAdapterService.class)).getIExternaHybridService();
        if (r102 == null) goto L7;
        pd.f r103 = r102.getExternalJsBridgeMethodInjectorAdapter();
        if (r103 == null) goto L7;
        return r103.d(new BridgetLynxComponent$getSendNativeBridgeCommandResultMethod$1(r100));
    L7:
        return null;
    }
}
