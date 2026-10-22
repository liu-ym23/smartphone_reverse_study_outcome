package com.android.ttcjpaysdk.base.paymentbasis;

import android.app.Activity;
import com.android.ttcjpaysdk.base.paymentbasis.common.CJPayException;
import com.android.ttcjpaysdk.base.paymentbasis.common.CJUnSupportedException;
import com.android.ttcjpaysdk.base.paymentbasis.common.CJWXUnInstalledException;
import com.android.ttcjpaysdk.base.service.ICJPayBasisPaymentService;

/* JADX INFO: loaded from: classes28.dex */
public abstract class CJPayBaseSessionManager {
    protected CJPaySession mCurrentSession;

    public CJPayBaseSessionManager() {
    }

    public abstract void endSession(CJPaySession r100);

    public abstract CJPaySession newSession(Activity r100, String r101, String r102, CJPayCallback r103, ICJPayBasisPaymentService.OnPayResultCallback r104) throws CJWXUnInstalledException, CJUnSupportedException, CJPayException;

    public void releaseCurrentPaySession() {
        CJPaySession r100 = this.mCurrentSession;
        if (r100 == null) goto L5;
        r100.release();
    L5:
        this.mCurrentSession = null;
    }

    public CJPaySession currentSession() {
        return this.mCurrentSession;
    }
}
