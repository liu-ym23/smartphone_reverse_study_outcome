package com.bytedance.android.live.browser.service;

import com.bytedance.android.livehostapi.business.depend.share.SimpleShareCallback;
import com.lynx.tasm.LynxError;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class a0 extends SimpleShareCallback {
    @Override // com.bytedance.android.livehostapi.business.depend.share.SimpleShareCallback, com.bytedance.android.livehostapi.business.depend.share.IShareCallback
    public final void onFail(Throwable r100) {
        Intrinsics.checkNotNullParameter(r100, LynxError.LYNX_THROWABLE);
    }

    @Override // com.bytedance.android.livehostapi.business.depend.share.SimpleShareCallback, com.bytedance.android.livehostapi.business.depend.share.IShareCallback
    public final void onSuccess(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "platform");
        Intrinsics.checkNotNullParameter(r101, "shareType");
    }

    public a0() {
    }
}
