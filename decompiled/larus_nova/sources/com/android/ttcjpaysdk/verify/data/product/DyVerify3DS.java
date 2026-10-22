package com.android.ttcjpaysdk.verify.data.product;

import com.android.ttcjpaysdk.base.service.DyVerifyFlow;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\b\u0010\n\u001a\u00020\u000bH\u0016R\u0012\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/android/ttcjpaysdk/verify/data/product/DyVerify3DS;", "Lcom/android/ttcjpaysdk/verify/data/product/DyVerifyBase;", "access_token", "", "action_url", "(Ljava/lang/String;Ljava/lang/String;)V", "vmFlowType", "Lcom/android/ttcjpaysdk/base/service/DyVerifyFlow;", "getVmFlowType", "()Lcom/android/ttcjpaysdk/base/service/DyVerifyFlow;", "isValid", "", "dy-verify-sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DyVerify3DS extends DyVerifyBase {
    public String access_token;
    public String action_url;
    private final DyVerifyFlow vmFlowType;

    /* JADX WARN: Multi-variable type inference failed */
    public DyVerify3DS() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    @Override // com.android.ttcjpaysdk.verify.data.product.DyVerifyBase
    public boolean isValid() {
        if ((!StringsKt.isBlank(this.access_token)) == true) goto L5;
    L7:
        return false;
    L5:
        if ((!StringsKt.isBlank(this.action_url)) == false) goto L7;
        return true;
    }

    @Override // com.android.ttcjpaysdk.verify.data.product.DyVerifyBase
    public DyVerifyFlow getVmFlowType() {
        return this.vmFlowType;
    }

    public DyVerify3DS(String r110, String r111) {
        Intrinsics.checkNotNullParameter(r110, "access_token");
        Intrinsics.checkNotNullParameter(r111, "action_url");
        super(null, null, null, null, null, 31, null);
        this.access_token = r110;
        this.action_url = r111;
        this.vmFlowType = DyVerifyFlow.THREEDS;
    }

    public /* synthetic */ DyVerify3DS(String r100, String r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = "";
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = "";
    L8:
        this(r100, r101);
    }
}
