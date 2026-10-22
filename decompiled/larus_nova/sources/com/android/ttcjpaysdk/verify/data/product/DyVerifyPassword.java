package com.android.ttcjpaysdk.verify.data.product;

import com.android.ttcjpaysdk.base.service.DyVerifyFlow;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016R\u0012\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\f"}, d2 = {"Lcom/android/ttcjpaysdk/verify/data/product/DyVerifyPassword;", "Lcom/android/ttcjpaysdk/verify/data/product/DyVerifyBase;", "title", "", "(Ljava/lang/String;)V", "vmFlowType", "Lcom/android/ttcjpaysdk/base/service/DyVerifyFlow;", "getVmFlowType", "()Lcom/android/ttcjpaysdk/base/service/DyVerifyFlow;", "isValid", "", "needMask", "dy-verify-sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DyVerifyPassword extends DyVerifyBase {
    public String title;
    private final DyVerifyFlow vmFlowType;

    /* JADX WARN: Multi-variable type inference failed */
    public DyVerifyPassword() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    @Override // com.android.ttcjpaysdk.verify.data.product.DyVerifyBase
    public boolean needMask() {
        return true;
    }

    @Override // com.android.ttcjpaysdk.verify.data.product.DyVerifyBase
    public boolean isValid() {
        if ((!StringsKt.isBlank(this.member_biz_order_no)) == true) goto L5;
    L9:
        return false;
    L5:
        if ((!StringsKt.isBlank(this.merchant_id)) == false) goto L9;
        if ((!StringsKt.isBlank(this.app_id)) == false) goto L9;
        return true;
    }

    @Override // com.android.ttcjpaysdk.verify.data.product.DyVerifyBase
    public DyVerifyFlow getVmFlowType() {
        return this.vmFlowType;
    }

    public DyVerifyPassword(String r110) {
        Intrinsics.checkNotNullParameter(r110, "title");
        super(null, null, null, null, null, 31, null);
        this.title = r110;
        this.vmFlowType = DyVerifyFlow.PASSWORD;
    }

    public /* synthetic */ DyVerifyPassword(String r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = "";
    L5:
        this(r100);
    }
}
