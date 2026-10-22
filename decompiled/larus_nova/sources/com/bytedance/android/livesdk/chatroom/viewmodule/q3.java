package com.bytedance.android.livesdk.chatroom.viewmodule;

import com.bytedance.android.livehostapi.business.depend.ICaptchaCallback;
import com.bytedance.android.livesdk.message.model.cn;
import com.bytedance.android.livesdk.message.model.mj;
import com.bytedance.common.utility.Logger;

/* JADX INFO: loaded from: classes8.dex */
public final class q3 implements ICaptchaCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ VerifyCodeWidget f115335a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ cn f115336b;

    @Override // com.bytedance.android.livehostapi.business.depend.ICaptchaCallback
    public final void onSuccess() {
        Logger.d("VerifyCodeWidget", "showCaptcha, onSuccess");
        VerifyCodeWidget.yq(this.f115335a, this.f115336b, 1);
        VerifyCodeWidget.wq(this.f115335a, 0);
        if (rx1.m.e(this.f115335a.context) == false) goto L5;
        xs2.b.a().post(new mj(false, null, 30));
    L5:
        this.f115335a.f115092c = true;
    }

    @Override // com.bytedance.android.livehostapi.business.depend.ICaptchaCallback
    public final void onFailure(int r100) {
        Logger.d("VerifyCodeWidget", "showCaptcha, onFailure");
        VerifyCodeWidget.yq(this.f115335a, this.f115336b, 0);
        VerifyCodeWidget.wq(this.f115335a, r100);
    }

    public q3(VerifyCodeWidget r100, cn r101, hu2.c r102) {
        this.f115335a = r100;
        this.f115336b = r101;
    }
}
