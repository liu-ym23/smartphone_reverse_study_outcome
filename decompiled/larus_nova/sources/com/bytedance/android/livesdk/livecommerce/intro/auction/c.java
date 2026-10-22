package com.bytedance.android.livesdk.livecommerce.intro.auction;

import com.bytedance.android.ec.adapter.api.IAdapterService;
import com.bytedance.android.ec.base.service.ECServiceManager;

/* JADX INFO: loaded from: classes10.dex */
public final class c implements com.bytedance.ies.web.jsbridge2.f.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IntroAuctionPresenter f147871a;

    public c(IntroAuctionPresenter r100) {
        this.f147871a = r100;
    }

    @Override // com.bytedance.ies.web.jsbridge2.f.b
    public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
        final IntroAuctionPresenter r100 = this.f147871a;
        r100.getClass();
        boolean r101 = ECServiceManager.f42805a;
        IAdapterService r102 = (IAdapterService) ECServiceManager.c(IAdapterService.class);
        if (r102 == null) goto L9;
        pd.e r103 = r102.getIExternaHybridService();
        if (r103 == null) goto L9;
        pd.f r104 = r103.getExternalJsBridgeMethodInjectorAdapter();
        if (r104 == null) goto L9;
        return r104.d(new IntroAuctionPresenter$getUpdateContainerHeightMethod$1(r100));
    L9:
        return null;
    }
}
