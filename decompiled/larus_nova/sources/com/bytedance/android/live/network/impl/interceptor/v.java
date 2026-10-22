package com.bytedance.android.live.network.impl.interceptor;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livehostapi.business.depend.ILiveFaceCertCallback;
import com.bytedance.android.livehostapi.business.depend.LiveCertResult;
import com.bytedance.android.livehostapi.business.depend.LiveCertStatus;
import com.bytedance.android.livesdk.recharge.model.RechargeVerifyTraceStep;
import com.larus.nova.R;
import java.util.Map;

/* JADX INFO: loaded from: classes46.dex */
public final class v implements ILiveFaceCertCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ v80.f f83902a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ t80.a f83903b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Map f83904c;

    @Override // com.bytedance.android.livehostapi.business.depend.ILiveFaceCertCallback
    public final void onVerifyResult(LiveCertResult r100) {
        StringBuilder r101 = new StringBuilder("receive Certication  result， isFaceOnly: ");
        r101.append(this.f83902a.f553646d);
        r101.append(", errorCode = ");
        Integer r102 = null;
        if (r100 == null) goto L5;
        Integer r103 = Integer.valueOf(r100.getErrorCode());
    L6:
        r101.append(r103);
        r101.append(", status = ");
        if (r100 == null) goto L11;
        LiveCertStatus r104 = r100.getStatus();
        if (r104 == null) goto L11;
        r102 = Integer.valueOf(r104.getCertStatus());
    L11:
        r101.append(r102);
        ALogger.i("LiveRechargeInterceptor", r101.toString());
        if (this.f83902a.f553646d == false) goto L24;
        if (r100 != null) goto L15;
    L20:
        f2.c(s1.B(R.string.ttlive_face_verify_failed_prompts), 0);
        t80.a r105 = this.f83903b;
        if (r105 == null) goto L23;
        r105.onVerifyResult(1);
    L23:
        this.f83904c.put("verify_result", "fail");
    L37:
        this.f83904c.put("live_result", String.valueOf(r100));
        int r106 = do0.a.f469399a;
        RechargeVerifyTraceStep r107 = RechargeVerifyTraceStep.STEP_RECHARGE_VERIFY_RESULT;
        if (r100 == null) goto L40;
        int r108 = r100.getErrorCode();
    L41:
        do0.a.a(r107, r108, "", "", "", this.f83904c);
        return;
    L40:
        r108 = 0;
        goto L41
    L15:
        if (r100.getErrorCode() != 0) goto L20;
        f2.c(s1.B(R.string.ttlive_cert_verify_success_prompts), 0);
        t80.a r109 = this.f83903b;
        if (r109 == null) goto L19;
        r109.onVerifyResult(3);
    L19:
        this.f83904c.put("verify_result", "success");
        goto L37
    L24:
        if (r100 == null) goto L37;
        LiveCertStatus r110 = r100.getStatus();
        if (r110 == null) goto L37;
        if (r110.getCertStatus() != 1) goto L33;
        f2.c(s1.B(R.string.ttlive_cert_verify_success_prompts), 0);
        t80.a r111 = this.f83903b;
        if (r111 == null) goto L32;
        r111.onVerifyResult(3);
    L32:
        this.f83904c.put("verify_result", "success");
        goto L37
    L33:
        t80.a r112 = this.f83903b;
        if (r112 == null) goto L36;
        r112.onVerifyResult(1);
    L36:
        this.f83904c.put("verify_result", "fail");
        goto L37
    L5:
        r103 = null;
        goto L6
    }

    public v(v80.f r100, t80.a r101, Map r102) {
        this.f83902a = r100;
        this.f83903b = r101;
        this.f83904c = r102;
    }
}
