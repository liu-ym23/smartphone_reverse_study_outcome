package com.android.ttcjpaysdk.verify.data.product;

import com.android.ttcjpaysdk.base.service.CustomizedConfig;
import com.android.ttcjpaysdk.base.service.DyVerifyFlow;
import com.android.ttcjpaysdk.thirdparty.front.counter.unifypay.preverify.vm.UnifyPreVerifySmsVM;
import com.android.ttcjpaysdk.verify.base.DyVerifyCenter;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\b\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\fH\u0016R\u0012\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000e"}, d2 = {"Lcom/android/ttcjpaysdk/verify/data/product/DyVerifyMsg;", "Lcom/android/ttcjpaysdk/verify/data/product/DyVerifyBase;", UnifyPreVerifySmsVM.KEY_MOBILE_MASK, "", "mobile_type", "title_text", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "vmFlowType", "Lcom/android/ttcjpaysdk/base/service/DyVerifyFlow;", "getVmFlowType", "()Lcom/android/ttcjpaysdk/base/service/DyVerifyFlow;", "isValid", "", "needMask", "dy-verify-sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DyVerifyMsg extends DyVerifyBase {
    public String mobile_mask;
    public String mobile_type;
    public String title_text;
    private final DyVerifyFlow vmFlowType;

    public DyVerifyMsg() {
        this(null, null, null, 7, null);
    }

    @Override // com.android.ttcjpaysdk.verify.data.product.DyVerifyBase
    public boolean isValid() {
        if ((!StringsKt.isBlank(this.merchant_id)) == true) goto L5;
    L7:
        return false;
    L5:
        if ((!StringsKt.isBlank(this.app_id)) == false) goto L7;
        return true;
    }

    @Override // com.android.ttcjpaysdk.verify.data.product.DyVerifyBase
    public boolean needMask() {
        DyVerifyCenter r100 = DyVerifyCenter.INSTANCE;
        CustomizedConfig r101 = r100.getConfig();
        if (r101 != null) goto L5;
    L7:
        boolean r102 = false;
    L8:
        if (r102 == false) goto L19;
        CustomizedConfig r103 = r100.getConfig();
        if (r103 != null) goto L12;
    L14:
        boolean r104 = false;
    L15:
        if (r104 == true) goto L20;
        return false;
    L20:
        return true;
    L12:
        if (r103.needMask != true) goto L14;
        r104 = true;
        goto L15
    L19:
        return true;
    L5:
        if (r101.isNewAnim != true) goto L7;
        r102 = true;
        goto L8
    }

    @Override // com.android.ttcjpaysdk.verify.data.product.DyVerifyBase
    public DyVerifyFlow getVmFlowType() {
        return this.vmFlowType;
    }

    public DyVerifyMsg(String r110, String r111, String r112) {
        Intrinsics.checkNotNullParameter(r110, UnifyPreVerifySmsVM.KEY_MOBILE_MASK);
        Intrinsics.checkNotNullParameter(r111, "mobile_type");
        Intrinsics.checkNotNullParameter(r112, "title_text");
        super(null, null, null, null, null, 31, null);
        this.mobile_mask = r110;
        this.mobile_type = r111;
        this.title_text = r112;
        this.vmFlowType = DyVerifyFlow.MSG;
    }

    public /* synthetic */ DyVerifyMsg(String r100, String r101, String r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = "";
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = "";
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = "";
    L11:
        this(r100, r101, r102);
    }
}
