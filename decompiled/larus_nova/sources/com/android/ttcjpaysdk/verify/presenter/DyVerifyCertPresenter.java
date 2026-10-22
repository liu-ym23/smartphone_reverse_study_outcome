package com.android.ttcjpaysdk.verify.presenter;

import com.android.ttcjpaysdk.base.mvp.mvp.BasePresenter;
import com.android.ttcjpaysdk.verify.contract.DyVerifyCertView;
import com.android.ttcjpaysdk.verify.data.DyVerifyCertBaseReq;
import com.android.ttcjpaysdk.verify.data.DyVerifyQueryCertRes;
import com.android.ttcjpaysdk.verify.model.DyVerifyCertModel;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J$\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\n\u001a\u0004\u0018\u00010\u000bJ\u001a\u0010\f\u001a\u00020\u00062\b\u0010\r\u001a\u0004\u0018\u00010\b2\b\u0010\n\u001a\u0004\u0018\u00010\u000bJ\u0010\u0010\u000e\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\u000bJ\u0010\u0010\u000f\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\u000bJ\u0010\u0010\u0010\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\u000bJ\u001a\u0010\u0011\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013¨\u0006\u0014"}, d2 = {"Lcom/android/ttcjpaysdk/verify/presenter/DyVerifyCertPresenter;", "Lcom/android/ttcjpaysdk/base/mvp/mvp/BasePresenter;", "Lcom/android/ttcjpaysdk/verify/model/DyVerifyCertModel;", "Lcom/android/ttcjpaysdk/verify/contract/DyVerifyCertView;", "()V", "genPartCsr", "", "signFactorId", "", "genPartCsrData", "reqParams", "Lcom/android/ttcjpaysdk/verify/data/DyVerifyCertBaseReq;", "getCert", "csrData", "getSignFactor", "initialCsr", "invalidCert", "queryCert", "nativeCertInfo", "Lcom/android/ttcjpaysdk/verify/data/DyVerifyQueryCertRes$DyVerifyCertInfo;", "dy-verify-sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DyVerifyCertPresenter extends BasePresenter<DyVerifyCertModel, DyVerifyCertView> {
    public DyVerifyCertPresenter() {
    }

    public final void getSignFactor(DyVerifyCertBaseReq r100) {
        DyVerifyCertModel r101 = getModel();
        if (r101 == null) goto L6;
        r101.getSignFactor(r100, new C97381(this));
        return;
    }

    public final void initialCsr(DyVerifyCertBaseReq r100) {
        DyVerifyCertModel r101 = getModel();
        if (r101 == null) goto L6;
        r101.initialCsr(r100, new C97391(this));
        return;
    }

    public final void invalidCert(DyVerifyCertBaseReq r100) {
        DyVerifyCertModel r101 = getModel();
        if (r101 == null) goto L6;
        r101.invalidCert(r100, new C97401(this));
        return;
    }

    public final void getCert(String r100, DyVerifyCertBaseReq r101) {
        DyVerifyCertModel r102 = getModel();
        if (r102 == null) goto L6;
        r102.getCert(r100, r101, new C97371(this));
        return;
    }

    public final void queryCert(DyVerifyCertBaseReq r100, final DyVerifyQueryCertRes.DyVerifyCertInfo r101) {
        DyVerifyCertModel r102 = getModel();
        if (r102 == null) goto L6;
        r102.queryCert(r100, new C97411(this, r101));
        return;
    }

    public final void genPartCsr(String r100, String r101, DyVerifyCertBaseReq r102) {
        DyVerifyCertModel r103 = getModel();
        if (r103 == null) goto L6;
        r103.genPartCsr(r100, r101, r102, new AnonymousClass1(this));
        return;
    }
}
