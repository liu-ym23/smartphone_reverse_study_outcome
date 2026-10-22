package com.android.ttcjpaysdk.verify.data.product;

import com.android.ttcjpaysdk.base.json.CJPayObject;
import com.android.ttcjpaysdk.base.service.DyVerifyFlow;
import com.android.ttcjpaysdk.verify.constants.DyVerifyEventConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001B7\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bJ\b\u0010\r\u001a\u00020\u000eH&J\b\u0010\u000f\u001a\u00020\u000eH\u0016R\u0012\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u00020\nX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/android/ttcjpaysdk/verify/data/product/DyVerifyBase;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "member_biz_order_no", "", "app_id", "merchant_id", DyVerifyEventConstants.EventParam.VERIFY_TRACE_ID, "verify_params", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "vmFlowType", "Lcom/android/ttcjpaysdk/base/service/DyVerifyFlow;", "getVmFlowType", "()Lcom/android/ttcjpaysdk/base/service/DyVerifyFlow;", "isValid", "", "needMask", "dy-verify-sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class DyVerifyBase implements CJPayObject {
    public String app_id;
    public String member_biz_order_no;
    public String merchant_id;
    public String verify_params;
    public String verify_trace_id;

    public DyVerifyBase() {
        this(null, null, null, null, null, 31, null);
    }

    public abstract DyVerifyFlow getVmFlowType();

    public abstract boolean isValid();

    public boolean needMask() {
        return false;
    }

    public DyVerifyBase(String r100, String r101, String r102, String r103, String r104) {
        Intrinsics.checkNotNullParameter(r100, "member_biz_order_no");
        Intrinsics.checkNotNullParameter(r101, "app_id");
        Intrinsics.checkNotNullParameter(r102, "merchant_id");
        Intrinsics.checkNotNullParameter(r103, DyVerifyEventConstants.EventParam.VERIFY_TRACE_ID);
        Intrinsics.checkNotNullParameter(r104, "verify_params");
        this.member_biz_order_no = r100;
        this.app_id = r101;
        this.merchant_id = r102;
        this.verify_trace_id = r103;
        this.verify_params = r104;
    }

    public /* synthetic */ DyVerifyBase(String r100, String r101, String r102, String r103, String r104, int r110, DefaultConstructorMarker r111) {
        if ((r110 & 1) == 0) goto L5;
        String r112 = "";
    L7:
        if ((r110 & 2) == 0) goto L9;
        String r105 = "";
    L11:
        if ((r110 & 4) == 0) goto L13;
        String r106 = "";
    L15:
        if ((r110 & 8) == 0) goto L17;
        String r107 = "";
    L19:
        if ((r110 & 16) == 0) goto L21;
        String r113 = "";
    L22:
        this(r112, r105, r106, r107, r113);
        return;
    L21:
        r113 = r104;
        goto L22
    L17:
        r107 = r103;
        goto L19
    L13:
        r106 = r102;
        goto L15
    L9:
        r105 = r101;
        goto L11
    L5:
        r112 = r100;
        goto L7
    }
}
