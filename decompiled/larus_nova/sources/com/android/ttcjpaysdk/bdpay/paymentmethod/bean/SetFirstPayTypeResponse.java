package com.android.ttcjpaysdk.bdpay.paymentmethod.bean;

import com.android.ttcjpaysdk.base.json.CJPayObject;
import com.bytedance.sdk.account.platform.api.IGoogleService;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B-\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007R\u0012\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/android/ttcjpaysdk/bdpay/paymentmethod/bean/SetFirstPayTypeResponse;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "code", "", "msg", "status", IGoogleService.ResponseKey.DISPLAY_NAME, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "bdpay-paymentmethod_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SetFirstPayTypeResponse implements CJPayObject {
    public String code;
    public String display_name;
    public String msg;
    public String status;

    public SetFirstPayTypeResponse() {
        this(null, null, null, null, 15, null);
    }

    public SetFirstPayTypeResponse(String r100, String r101, String r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "code");
        Intrinsics.checkNotNullParameter(r101, "msg");
        Intrinsics.checkNotNullParameter(r102, "status");
        Intrinsics.checkNotNullParameter(r103, IGoogleService.ResponseKey.DISPLAY_NAME);
        this.code = r100;
        this.msg = r101;
        this.status = r102;
        this.display_name = r103;
    }

    public /* synthetic */ SetFirstPayTypeResponse(String r100, String r101, String r102, String r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = "";
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = "";
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = "";
    L12:
        if ((r104 & 8) == 0) goto L14;
        r103 = "";
    L14:
        this(r100, r101, r102, r103);
    }
}
