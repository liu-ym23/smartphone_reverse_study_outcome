package com.bytedance.android.live.broadcastgame.opengame.openapi;

import com.bytedance.android.livehostapi.business.depend.ICaptchaCallback;
import com.bytedance.common.utility.Logger;

/* JADX INFO: loaded from: classes45.dex */
public final class o0 implements ICaptchaCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PayMethod f60526a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f60527b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ long f60528c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f60529d;

    @Override // com.bytedance.android.livehostapi.business.depend.ICaptchaCallback
    public final void onSuccess() {
        int r100 = com.bytedance.android.live.broadcastgame.opengame.q.f60744a;
        com.bytedance.android.live.broadcastgame.opengame.q.f("PayMethod", new Object[]{"verify success"});
        Logger.d("showCaptcha", "showCaptcha, onSuccess");
        PayMethod.t(this.f60526a, this.f60527b, this.f60528c, this.f60529d);
    }

    @Override // com.bytedance.android.livehostapi.business.depend.ICaptchaCallback
    public final void onFailure(int r100) {
        int r101 = com.bytedance.android.live.broadcastgame.opengame.q.f60744a;
        com.bytedance.android.live.broadcastgame.opengame.q.k("PayMethod", new Object[]{"verify fail, code: " + r100});
        Logger.d("showCaptcha", "showCaptcha, onFailure");
        this.f60526a.y(OpenApiErrorInfo.NO_REQUEST_PERMISSION);
    }

    public o0(PayMethod r100, String r101, long r102, String r103) {
        this.f60526a = r100;
        this.f60527b = r101;
        this.f60528c = r102;
        this.f60529d = r103;
    }
}
