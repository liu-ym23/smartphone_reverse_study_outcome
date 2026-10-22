package com.bytedance.android.live.network.impl.interceptor;

import android.content.DialogInterface;
import com.bytedance.android.livesdk.recharge.model.RechargeVerifyTraceStep;

/* JADX INFO: loaded from: classes46.dex */
public final class s implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ u.a f83892a;

    public s(u.a r100) {
        this.f83892a = r100;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r100, int r101) {
        t80.a r102 = this.f83892a.f83897b;
        if (r102 == null) goto L5;
        r102.onVerifyResult(0);
    L5:
        int r103 = do0.a.f469399a;
        do0.a.b(RechargeVerifyTraceStep.STEP_RECHARGE_VERIFY_CANCEL_CLICK, this.f83892a.f83898c, "", "", "");
        r100.dismiss();
    }
}
