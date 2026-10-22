package com.bytedance.android.openlive.inner.platform;

import com.bytedance.android.livehostapi.wrap.AbsHostWallet;
import com.bytedance.android.openlive.inner.host.IOpenHostParams;

/* JADX INFO: loaded from: classes12.dex */
public class InternalHostWalletWrapper extends AbsHostWallet {
    private final IOpenHostParams openHostParams;

    @Override // com.bytedance.android.livehostapi.wrap.AbsHostWallet, com.bytedance.android.livehostapi.business.IHostWallet
    public String getCJAppId() {
        IOpenHostParams r100 = this.openHostParams;
        if (r100 != null) goto L5;
        return null;
    L5:
        return r100.getCJAppId();
    }

    @Override // com.bytedance.android.livehostapi.wrap.AbsHostWallet, com.bytedance.android.livehostapi.business.IHostWallet
    public String getCJMerchantId() {
        IOpenHostParams r100 = this.openHostParams;
        if (r100 != null) goto L5;
        return null;
    L5:
        return r100.getCJMerchantId();
    }

    public InternalHostWalletWrapper(IOpenHostParams r100) {
        this.openHostParams = r100;
    }
}
