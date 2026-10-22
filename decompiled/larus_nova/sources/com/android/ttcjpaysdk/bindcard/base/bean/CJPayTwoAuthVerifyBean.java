package com.android.ttcjpaysdk.bindcard.base.bean;

import com.android.ttcjpaysdk.thirdparty.data.CJPayFaceVerifyInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005¢\u0006\u0002\u0010\tJ\u0006\u0010\n\u001a\u00020\u000bR\u0012\u0010\b\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/android/ttcjpaysdk/bindcard/base/bean/CJPayTwoAuthVerifyBean;", "Lcom/android/ttcjpaysdk/bindcard/base/bean/CJPayBindCardBaseBean;", "button_info", "Lcom/android/ttcjpaysdk/base/ui/data/CJPayButtonInfo;", "sign_order_no", "", "face_verify_info", "Lcom/android/ttcjpaysdk/thirdparty/data/CJPayFaceVerifyInfo;", "additional_verify_type", "(Lcom/android/ttcjpaysdk/base/ui/data/CJPayButtonInfo;Ljava/lang/String;Lcom/android/ttcjpaysdk/thirdparty/data/CJPayFaceVerifyInfo;Ljava/lang/String;)V", "needFaceCheck", "", "bdpay-bindcard-base_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJPayTwoAuthVerifyBean extends CJPayBindCardBaseBean {
    public String additional_verify_type;
    public com.android.ttcjpaysdk.base.ui.data.CJPayButtonInfo button_info;
    public CJPayFaceVerifyInfo face_verify_info;
    public String sign_order_no;

    public CJPayTwoAuthVerifyBean() {
        this(null, null, null, null, 15, null);
    }

    public final boolean needFaceCheck() {
        return Intrinsics.areEqual(this.additional_verify_type, "live_detection");
    }

    public CJPayTwoAuthVerifyBean(com.android.ttcjpaysdk.base.ui.data.CJPayButtonInfo r100, String r101, CJPayFaceVerifyInfo r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "button_info");
        Intrinsics.checkNotNullParameter(r102, "face_verify_info");
        Intrinsics.checkNotNullParameter(r103, "additional_verify_type");
        this.button_info = r100;
        this.sign_order_no = r101;
        this.face_verify_info = r102;
        this.additional_verify_type = r103;
    }

    public /* synthetic */ CJPayTwoAuthVerifyBean(com.android.ttcjpaysdk.base.ui.data.CJPayButtonInfo r310, String r311, CJPayFaceVerifyInfo r312, String r313, int r314, DefaultConstructorMarker r315) {
        if ((r314 & 1) == 0) goto L5;
        com.android.ttcjpaysdk.base.ui.data.CJPayButtonInfo r100 = new com.android.ttcjpaysdk.base.ui.data.CJPayButtonInfo();
    L6:
        String r101 = "";
        if ((r314 & 2) == 0) goto L9;
        String r102 = "";
    L11:
        if ((r314 & 4) == 0) goto L13;
        CJPayFaceVerifyInfo r103 = new CJPayFaceVerifyInfo(null, null, null, null, null, null, null, false, null, null, null, null, false, null, null, null, null, null, null, null, null, null, 4194303, null);
    L15:
        if ((r314 & 8) != 0) goto L18;
        r101 = r313;
    L18:
        this(r100, r102, r103, r101);
        return;
    L13:
        r103 = r312;
        goto L15
    L9:
        r102 = r311;
        goto L11
    L5:
        r100 = r310;
        goto L6
    }
}
