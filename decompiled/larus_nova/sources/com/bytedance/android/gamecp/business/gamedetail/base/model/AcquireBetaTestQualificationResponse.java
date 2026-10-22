package com.bytedance.android.gamecp.business.gamedetail.base.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@ProtoMessage("webcast.gamecp.api.AcquireBetaTestQualificationResponse.Data")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0004\n\u0002\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/gamecp/business/gamedetail/base/model/AcquireBetaTestQualificationResponse;", "", "()V", "activationCode", "", "hasTestingQualification", "", "Ljava/lang/Boolean;", "gamecp-business_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AcquireBetaTestQualificationResponse implements vh7.h {

    @SerializedName("activation_code")
    public String activationCode;

    @SerializedName("has_testing_qualification")
    public Boolean hasTestingQualification;

    public AcquireBetaTestQualificationResponse() {
    }

    public AcquireBetaTestQualificationResponse(am3.g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L12;
        if (r102 != 1) goto L8;
        this.hasTestingQualification = Boolean.valueOf(am3.h.a(r100));
        goto L3
    L8:
        if (r102 != 2) goto L9;
        this.activationCode = am3.h.c(r100);
        goto L3
    L9:
        am3.h.e(r100);
        goto L3
    L12:
        r100.d(r101);
    }
}
