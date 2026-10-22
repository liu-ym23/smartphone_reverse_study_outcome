package com.bytedance.android.livesdk.chatroom.viewmodule;

import com.bytedance.android.livehostapi.business.depend.ICaptchaCallback;
import com.bytedance.android.livesdk.message.model.dn;
import com.bytedance.common.utility.Logger;

/* JADX INFO: loaded from: classes8.dex */
public final class t3 implements ICaptchaCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ VerifyCodeWidget f115585a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ dn f115586b;

    @Override // com.bytedance.android.livehostapi.business.depend.ICaptchaCallback
    public final void onSuccess() {
        Logger.d("VerifyCodeWidget", "showCaptchaV2, onSuccess");
        VerifyCodeWidget.xq(this.f115585a, this.f115586b.E(), true);
    }

    @Override // com.bytedance.android.livehostapi.business.depend.ICaptchaCallback
    public final void onFailure(int r100) {
        Logger.d("VerifyCodeWidget", "showCaptchaV2, onFailure");
        VerifyCodeWidget.xq(this.f115585a, this.f115586b.E(), false);
    }

    public t3(VerifyCodeWidget r100, dn r101) {
        this.f115585a = r100;
        this.f115586b = r101;
    }
}
