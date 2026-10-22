package com.bytedance.android.live.broadcastgame.opengame.openapi;

import com.bytedance.android.livehostapi.business.depend.ICaptchaCallback;

/* JADX INFO: loaded from: classes45.dex */
public final class u0 implements ICaptchaCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ p0 f60568a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f60569b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ long f60570c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f60571d;

    @Override // com.bytedance.android.livehostapi.business.depend.ICaptchaCallback
    public final void onSuccess() {
        int r100 = com.bytedance.android.live.broadcastgame.opengame.q.f60744a;
        com.bytedance.android.live.broadcastgame.opengame.q.f("PayMethodV3", new Object[]{"verify success"});
        p0.t(this.f60568a, this.f60569b, this.f60570c, this.f60571d);
    }

    @Override // com.bytedance.android.livehostapi.business.depend.ICaptchaCallback
    public final void onFailure(int r100) {
        int r101 = com.bytedance.android.live.broadcastgame.opengame.q.f60744a;
        com.bytedance.android.live.broadcastgame.opengame.q.k("PayMethodV3", new Object[]{"verify fail, code: " + r100});
        p0.x(this.f60568a, OpenApiErrorInfo.NO_REQUEST_PERMISSION, this.f60569b);
    }

    public u0(p0 r100, String r101, long r102, String r103) {
        this.f60568a = r100;
        this.f60569b = r101;
        this.f60570c = r102;
        this.f60571d = r103;
    }
}
