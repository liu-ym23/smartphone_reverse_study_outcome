package com.android.ttcjpaysdk.verify.data.product;

import com.android.ttcjpaysdk.base.service.DyVerifyFlow;
import com.android.ttcjpaysdk.base.utils.CJBasicCommonUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001a\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\nH\u0002J\b\u0010\u000e\u001a\u00020\nH\u0016R\u0012\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u000f"}, d2 = {"Lcom/android/ttcjpaysdk/verify/data/product/DyVerifyFace;", "Lcom/android/ttcjpaysdk/verify/data/product/DyVerifyBase;", "verify_url_params", "Lcom/android/ttcjpaysdk/verify/data/product/VerifyUrlParams;", "(Lcom/android/ttcjpaysdk/verify/data/product/VerifyUrlParams;)V", "vmFlowType", "Lcom/android/ttcjpaysdk/base/service/DyVerifyFlow;", "getVmFlowType", "()Lcom/android/ttcjpaysdk/base/service/DyVerifyFlow;", "isConfigurationParamsValid", "", "params", "", "isSigned", "isValid", "dy-verify-sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DyVerifyFace extends DyVerifyBase {
    public VerifyUrlParams verify_url_params;
    private final DyVerifyFlow vmFlowType;

    /* JADX WARN: Multi-variable type inference failed */
    public DyVerifyFace() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    @Override // com.android.ttcjpaysdk.verify.data.product.DyVerifyBase
    public boolean isValid() {
        if ((!StringsKt.isBlank(this.verify_url_params.member_biz_order_no)) == true) goto L5;
    L13:
        return false;
    L5:
        if ((!StringsKt.isBlank(this.verify_url_params.live_route)) == false) goto L13;
        if ((!StringsKt.isBlank(this.verify_url_params.is_signed)) == false) goto L13;
        if ((!StringsKt.isBlank(this.verify_url_params.source)) == false) goto L13;
        VerifyUrlParams r100 = this.verify_url_params;
        if (isConfigurationParamsValid(r100.configuration_params, Intrinsics.areEqual(r100.is_signed, "1")) == false) goto L13;
        return true;
    }

    @Override // com.android.ttcjpaysdk.verify.data.product.DyVerifyBase
    public DyVerifyFlow getVmFlowType() {
        return this.vmFlowType;
    }

    public DyVerifyFace(VerifyUrlParams r110) {
        Intrinsics.checkNotNullParameter(r110, "verify_url_params");
        super(null, null, null, null, null, 31, null);
        this.verify_url_params = r110;
        this.vmFlowType = DyVerifyFlow.LIVEDETECT;
    }

    private final boolean isConfigurationParamsValid(String r100, boolean r101) {
        if (r100 != null) goto L39;
    L38:
        return false;
    L39:
        Boolean r102 = null;
        if ((!StringsKt.isBlank(r100)) == false) goto L7;
        String r103 = r100;
    L8:
        if (r103 == null) goto L38;
        if (r101 == false) goto L11;
        return true;
    L11:
        String r104 = new JSONObject(r100).optString("agreement_desc");     // Catch: Exception -> L36
        String r105 = new JSONObject(r100).optString("agreement_url");     // Catch: Exception -> L36
        if (r104 != null) goto L14;
        Boolean r106 = null;
    L19:
        if (r106 == null) goto L21;
        boolean r107 = r106.booleanValue();     // Catch: Exception -> L36
    L22:
        if (r107 == false) goto L41;
        if (r105 != null) goto L25;
    L29:
        if (r102 == null) goto L32;
        boolean r108 = r102.booleanValue();     // Catch: Exception -> L36
    L33:
        if (r108 == false) goto L42;
        return true;
    L42:
        return false;
    L32:
        r108 = false;
        goto L33
    L25:
        if (StringsKt.isBlank(r105) == true) goto L27;
        boolean r109 = true;
    L28:
        r102 = Boolean.valueOf(r109);     // Catch: Exception -> L36
        goto L29
    L27:
        r109 = false;
        goto L28
    L41:
        return false;
    L21:
        r107 = false;
        goto L22
    L14:
        if (StringsKt.isBlank(r104) == true) goto L16;
        boolean r110 = true;
    L17:
        r106 = Boolean.valueOf(r110);     // Catch: Exception -> L36
        goto L19
    L16:
        r110 = false;
        goto L17
    L7:
        r103 = null;
    L36:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("DyVerifyFace#isConfigurationParamsValid", e);
        CJBasicCommonUtils.logCatch("CJCatch", "DyVerifyFace#isConfigurationParamsValid", e);
        goto L38
    }

    public /* synthetic */ DyVerifyFace(VerifyUrlParams r110, int r111, DefaultConstructorMarker r112) {
        if ((r111 & 1) == 0) goto L5;
        r110 = new VerifyUrlParams(null, null, null, null, null, null, 63, null);
    L5:
        this(r110);
    }
}
