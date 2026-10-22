package com.android.ttcjpaysdk.bindcard.unionpay.bean;

import com.android.ttcjpaysdk.base.json.CJPayObject;
import com.android.ttcjpaysdk.bindcard.base.utils.BindCardCommonInfoUtil;
import com.android.ttcjpaysdk.thirdparty.data.CJPayFaceVerifyInfo;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B_\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\u0004\u0012\b\b\u0002\u0010\n\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0004\u0012\b\b\u0002\u0010\f\u001a\u00020\u0004\u0012\b\b\u0002\u0010\r\u001a\u00020\u0004¢\u0006\u0002\u0010\u000eJ\u0006\u0010\u0019\u001a\u00020\u001aJ\u0006\u0010\u001b\u001a\u00020\u0014R\u0012\u0010\u0006\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0012\u0010\u000b\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0013\u001a\u00020\u00148F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0012\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\r\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0017\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0010R\u0012\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\f\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/android/ttcjpaysdk/bindcard/unionpay/bean/UnionPaySignInfo;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "Ljava/io/Serializable;", "identity_verify_order_no", "", "union_pay_sign_status", "action_page_type", "face_verify_info", "Lcom/android/ttcjpaysdk/thirdparty/data/CJPayFaceVerifyInfo;", "additional_verify_type", "display_icon", "display_desc", "voucher_label", "signOrderNo", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/android/ttcjpaysdk/thirdparty/data/CJPayFaceVerifyInfo;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAdditional_verify_type", "()Ljava/lang/String;", "setAdditional_verify_type", "(Ljava/lang/String;)V", "goSetPwd", "", "getGoSetPwd", "()Z", "smchId", "getSmchId", "getPageType", "Lcom/android/ttcjpaysdk/bindcard/unionpay/bean/UnionPayPageType;", "isSigned", "bdpay-bindcard-unionpay_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class UnionPaySignInfo implements CJPayObject, Serializable {
    public String action_page_type;
    private String additional_verify_type;
    public String display_desc;
    public String display_icon;
    public CJPayFaceVerifyInfo face_verify_info;
    public String identity_verify_order_no;
    public String signOrderNo;
    public String union_pay_sign_status;
    public String voucher_label;

    public UnionPaySignInfo() {
        this(null, null, null, null, null, null, null, null, null, 511, null);
    }

    public final boolean getGoSetPwd() {
        return BindCardCommonInfoUtil.INSTANCE.isGoSetPwd();
    }

    public final UnionPayPageType getPageType() {
        String r100 = this.action_page_type;
        switch(r100.hashCode()) {
            case -1513014117: goto L22;
            case -1411926371: goto L18;
            case -1135664540: goto L14;
            case -529964262: goto L10;
            case 57402406: goto L6;
            default: goto L26;
        };
    L6:
        if (r100.equals("union_pay_card_list") == false) goto L26;
        return UnionPayPageType.TYPE_UNION_CARD_LIST;
    L10:
        if (r100.equals("identity_verify") == false) goto L26;
        return UnionPayPageType.TYPE_IDENTITY_VERIFY;
    L14:
        if (r100.equals("union_pay_sign") == false) goto L26;
        return UnionPayPageType.TYPE_UNION_PAY_SIGN;
    L18:
        if (r100.equals("password_verify") == false) goto L26;
        return UnionPayPageType.TYPE_PASSWORD_VERIFY;
    L22:
        if (r100.equals("face_verify") == false) goto L26;
        return UnionPayPageType.TYPE_FACE_VERIFY;
    L26:
        return UnionPayPageType.TYPE_DEFAULT;
    }

    public final String getSmchId() {
        return BindCardCommonInfoUtil.INSTANCE.getSmchId();
    }

    public final boolean isSigned() {
        return Intrinsics.areEqual(this.union_pay_sign_status, "valid");
    }

    public final String getAdditional_verify_type() {
        return this.additional_verify_type;
    }

    public final void setAdditional_verify_type(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.additional_verify_type = r100;
    }

    public UnionPaySignInfo(String r100, String r101, String r102, CJPayFaceVerifyInfo r103, String r104, String r105, String r106, String r107, String r110) {
        Intrinsics.checkNotNullParameter(r100, "identity_verify_order_no");
        Intrinsics.checkNotNullParameter(r101, "union_pay_sign_status");
        Intrinsics.checkNotNullParameter(r102, "action_page_type");
        Intrinsics.checkNotNullParameter(r103, "face_verify_info");
        Intrinsics.checkNotNullParameter(r104, "additional_verify_type");
        Intrinsics.checkNotNullParameter(r105, "display_icon");
        Intrinsics.checkNotNullParameter(r106, "display_desc");
        Intrinsics.checkNotNullParameter(r107, "voucher_label");
        Intrinsics.checkNotNullParameter(r110, "signOrderNo");
        this.identity_verify_order_no = r100;
        this.union_pay_sign_status = r101;
        this.action_page_type = r102;
        this.face_verify_info = r103;
        this.additional_verify_type = r104;
        this.display_icon = r105;
        this.display_desc = r106;
        this.voucher_label = r107;
        this.signOrderNo = r110;
    }

    public /* synthetic */ UnionPaySignInfo(String r310, String r311, String r312, CJPayFaceVerifyInfo r313, String r314, String r315, String r316, String r317, String r410, int r411, DefaultConstructorMarker r412) {
        String r100 = "";
        if ((r411 & 1) == 0) goto L5;
        String r101 = "";
    L7:
        if ((r411 & 2) == 0) goto L9;
        String r102 = "";
    L11:
        if ((r411 & 4) == 0) goto L13;
        String r103 = "";
    L15:
        if ((r411 & 8) == 0) goto L17;
        CJPayFaceVerifyInfo r104 = new CJPayFaceVerifyInfo(null, null, null, null, null, null, null, false, null, null, null, null, false, null, null, null, null, null, null, null, null, null, 4194303, null);
    L19:
        if ((r411 & 16) == 0) goto L21;
        String r105 = "";
    L23:
        if ((r411 & 32) == 0) goto L25;
        String r106 = "";
    L27:
        if ((r411 & 64) == 0) goto L29;
        String r107 = "";
    L31:
        if ((r411 & 128) == 0) goto L33;
        String r108 = "";
    L35:
        if ((r411 & 256) != 0) goto L38;
        r100 = r410;
    L38:
        this(r101, r102, r103, r104, r105, r106, r107, r108, r100);
        return;
    L33:
        r108 = r317;
        goto L35
    L29:
        r107 = r316;
        goto L31
    L25:
        r106 = r315;
        goto L27
    L21:
        r105 = r314;
        goto L23
    L17:
        r104 = r313;
        goto L19
    L13:
        r103 = r312;
        goto L15
    L9:
        r102 = r311;
        goto L11
    L5:
        r101 = r310;
        goto L7
    }
}
