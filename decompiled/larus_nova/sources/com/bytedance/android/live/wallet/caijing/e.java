package com.bytedance.android.live.wallet.caijing;

import com.android.ttcjpaysdk.ttcjpayapi.IH5PayCallback;
import com.android.ttcjpaysdk.ttcjpayapi.TTCJPayUtils;
import com.bytedance.android.live.wallet.platform.jsbridge.methods.h;

/* JADX INFO: loaded from: classes7.dex */
public final class e implements IH5PayCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.android.live.wallet.platform.jsbridge.methods.g f102662a;

    public e(h r100) {
        this.f102662a = r100;
    }

    @Override // com.android.ttcjpaysdk.ttcjpayapi.IH5PayCallback
    public final void onResult(int r100, String r101) {
        this.f102662a.a(r100, r101);
        TTCJPayUtils.Companion.getInstance().releaseAll();
    }
}
