package com.bytedance.android.live.core.verify.interceptor;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livehostapi.business.depend.ILiveFaceCertCallback;
import com.bytedance.android.livehostapi.business.depend.LiveCertResult;
import com.bytedance.android.livehostapi.business.depend.LiveCertStatus;
import com.bytedance.android.livesdk.recharge.model.RechargeVerifyTraceStep;
import com.larus.nova.R;
import java.util.Map;
import v80.f;

/* JADX INFO: loaded from: classes45.dex */
public final class a implements ILiveFaceCertCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f f66474a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f66475b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f66476c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ t80.a f66477d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Map f66478e;

    @Override // com.bytedance.android.livehostapi.business.depend.ILiveFaceCertCallback
    public final void onVerifyResult(LiveCertResult r100) {
        StringBuilder r101 = new StringBuilder("Minor Verified result， isFaceOnly: ");
        r101.append(this.f66474a.f553646d);
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
        ALogger.i("MinorInterceptor", r101.toString());
        if (this.f66474a.f553646d == false) goto L24;
        if (r100 != null) goto L15;
    L20:
        f2.c(s1.B(R.string.ttlive_face_verify_failed_prompts), 0);
        t80.a r105 = this.f66477d;
        if (r105 == null) goto L23;
        r105.onVerifyResult(1);
    L23:
        this.f66478e.put("verify_result", "fail");
    L37:
        this.f66478e.put("live_result", String.valueOf(r100));
        int r106 = do0.a.f469399a;
        RechargeVerifyTraceStep r107 = RechargeVerifyTraceStep.STEP_RECHARGE_VERIFY_RESULT;
        if (r100 == null) goto L40;
        int r108 = r100.getErrorCode();
    L41:
        do0.a.a(r107, r108, this.f66475b, this.f66476c, "", this.f66478e);
        return;
    L40:
        r108 = 0;
        goto L41
    L15:
        if (r100.getErrorCode() != 0) goto L20;
        f2.c(s1.B(R.string.ttlive_cert_verify_success_prompts), 0);
        t80.a r109 = this.f66477d;
        if (r109 == null) goto L19;
        r109.onVerifyResult(3);
    L19:
        this.f66478e.put("verify_result", "success");
        goto L37
    L24:
        if (r100 == null) goto L37;
        LiveCertStatus r110 = r100.getStatus();
        if (r110 == null) goto L37;
        if (r110.getCertStatus() != 1) goto L33;
        f2.c(s1.B(R.string.ttlive_cert_verify_success_prompts), 0);
        t80.a r111 = this.f66477d;
        if (r111 == null) goto L32;
        r111.onVerifyResult(3);
    L32:
        this.f66478e.put("verify_result", "success");
        goto L37
    L33:
        t80.a r112 = this.f66477d;
        if (r112 == null) goto L36;
        r112.onVerifyResult(1);
    L36:
        this.f66478e.put("verify_result", "fail");
        goto L37
    L5:
        r103 = null;
        goto L6
    }

    public a(f r100, String r101, String r102, t80.a r103, Map r104) {
        this.f66474a = r100;
        this.f66475b = r101;
        this.f66476c = r102;
        this.f66477d = r103;
        this.f66478e = r104;
    }
}
