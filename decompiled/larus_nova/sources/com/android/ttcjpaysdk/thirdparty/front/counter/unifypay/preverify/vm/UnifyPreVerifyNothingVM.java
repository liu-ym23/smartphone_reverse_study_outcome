package com.android.ttcjpaysdk.thirdparty.front.counter.unifypay.preverify.vm;

import com.android.ttcjpaysdk.base.ktextension.KtSafeMethodExtensionKt;
import com.android.ttcjpaysdk.thirdparty.front.counter.unifypay.preverify.UnifyPreVerifyVMContext;
import com.android.ttcjpaysdk.thirdparty.front.counter.unifypay.preverify.model.UnifyPreVerifyType;
import com.android.ttcjpaysdk.thirdparty.front.counter.unifypay.preverify.vm.base.UnifyPreVerifyBaseVM;
import com.tencent.connect.common.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0002J\b\u0010\u0007\u001a\u00020\bH\u0016J\"\u0010\t\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\rH\u0016¨\u0006\u000e"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/preverify/vm/UnifyPreVerifyNothingVM;", "Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/preverify/vm/base/UnifyPreVerifyBaseVM;", "verifyVMContext", "Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/preverify/UnifyPreVerifyVMContext;", "(Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/preverify/UnifyPreVerifyVMContext;)V", "doRequest", "", "getPreVerifyType", "Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/preverify/model/UnifyPreVerifyType;", "startVerify", "preVM", "preVerifyType", "extData", "Lorg/json/JSONObject;", "bdpay-front-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class UnifyPreVerifyNothingVM extends UnifyPreVerifyBaseVM {
    private final void doRequest() {
        JSONObject r100 = new JSONObject();
        KtSafeMethodExtensionKt.safePut(r100, "req_type", Constants.VIA_REPORT_TYPE_SHARE_TO_QQ);
        checkByServer(r100);
    }

    @Override // com.android.ttcjpaysdk.thirdparty.front.counter.unifypay.preverify.api.IUnifyPreVerifyComponent
    public UnifyPreVerifyType getPreVerifyType() {
        return UnifyPreVerifyType.VERIFY_TYPE_SKIP_VERIFY;
    }

    public UnifyPreVerifyNothingVM(UnifyPreVerifyVMContext r100) {
        Intrinsics.checkNotNullParameter(r100, "verifyVMContext");
        super(r100);
    }

    @Override // com.android.ttcjpaysdk.thirdparty.front.counter.unifypay.preverify.vm.base.UnifyPreVerifyBaseVM
    public void startVerify(UnifyPreVerifyBaseVM r100, UnifyPreVerifyType r101, JSONObject r102) {
        Intrinsics.checkNotNullParameter(r101, "preVerifyType");
        Intrinsics.checkNotNullParameter(r102, "extData");
        super.startVerify(r100, r101, r102);
        doRequest();
    }
}
