package com.bytedance.android.livesdk.jsbridge.methods;

import com.bytedance.android.live.browser.jsbridge.base.DoLiveCertResultModel;
import com.bytedance.android.livehostapi.business.depend.ILiveFaceCertCallback;
import com.bytedance.android.livehostapi.business.depend.LiveCertResult;
import com.bytedance.android.livehostapi.business.depend.LiveCertStatus;
import kotlin.Unit;

/* JADX INFO: loaded from: classes9.dex */
public final class p2 implements ILiveFaceCertCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ q2 f142174a;

    public p2(q2 r100) {
        this.f142174a = r100;
    }

    @Override // com.bytedance.android.livehostapi.business.depend.ILiveFaceCertCallback
    public final void onVerifyResult(LiveCertResult r100) {
        q2 r101 = this.f142174a;
        DoLiveCertResultModel r102 = new DoLiveCertResultModel();
        r102.c(DoLiveCertResultModel.Code.Success);
        r102.h("");
        if (r100 == null) goto L7;
        r102.d(Integer.valueOf(r100.getErrorCode()));
        r102.e(r100.getErrorMsg());
        r102.i(r100.getTicket());
        r102.f(r100.getExtraData());
        LiveCertStatus r103 = r100.getStatus();
        if (r103 == null) goto L7;
        r102.b(Integer.valueOf(r103.getCertStatus()));
        r102.g(Integer.valueOf(r103.getManualStatus()));
        r102.a(Integer.valueOf(r103.getAgeRange()));
    L7:
        Unit r104 = Unit.INSTANCE;
        r101.finishWithResult(r102);
    }
}
