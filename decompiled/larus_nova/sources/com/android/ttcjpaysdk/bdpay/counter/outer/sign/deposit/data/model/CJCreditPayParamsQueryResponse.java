package com.android.ttcjpaysdk.bdpay.counter.outer.sign.deposit.data.model;

import com.alipay.sdk.m.k.b;
import com.android.ttcjpaysdk.base.json.CJPayObject;
import com.android.ttcjpaysdk.bdpay.counter.outer.bean.CJPaySignInfoQueryResponse;
import com.ss.android.dypay.api.DyPayConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001Bs\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003¢\u0006\u0002\u0010\u000eJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003Jw\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eHÖ\u0003J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\u0006\u0010!\u001a\u00020\u001cJ\t\u0010\"\u001a\u00020\u0003HÖ\u0001R\u0012\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000b\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\f\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\r\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/android/ttcjpaysdk/bdpay/counter/outer/sign/deposit/data/model/CJCreditPayParamsQueryResponse;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "code", "", "msg", "invoke_info", "invoke_scene", "merchant_app_id", "merchant_id", DyPayConstant.K_PAY_INFO_PARAM_NONCESTR, "prepay_id", "sign", "timestamp", b.B0, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "", "hashCode", "", "isResponseOK", "toString", "bdpay-counter-outer_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJCreditPayParamsQueryResponse implements CJPayObject {
    public String code;
    public String invoke_info;
    public String invoke_scene;
    public String merchant_app_id;
    public String merchant_id;
    public String msg;
    public String noncestr;
    public String prepay_id;
    public String sign;
    public String timestamp;
    public String trade_no;

    public CJCreditPayParamsQueryResponse() {
        this(null, null, null, null, null, null, null, null, null, null, null, 2047, null);
    }

    public static /* synthetic */ CJCreditPayParamsQueryResponse copy$default(CJCreditPayParamsQueryResponse r110, String r111, String r112, String r113, String r114, String r115, String r116, String r117, String r210, String r211, String r212, String r213, int r214, Object r215) {
        if ((r214 & 1) == 0) goto L5;
        String r100 = r110.code;
    L7:
        if ((r214 & 2) == 0) goto L9;
        String r101 = r110.msg;
    L11:
        if ((r214 & 4) == 0) goto L13;
        String r102 = r110.invoke_info;
    L15:
        if ((r214 & 8) == 0) goto L17;
        String r103 = r110.invoke_scene;
    L19:
        if ((r214 & 16) == 0) goto L21;
        String r104 = r110.merchant_app_id;
    L23:
        if ((r214 & 32) == 0) goto L25;
        String r105 = r110.merchant_id;
    L27:
        if ((r214 & 64) == 0) goto L29;
        String r106 = r110.noncestr;
    L31:
        if ((r214 & 128) == 0) goto L33;
        String r107 = r110.prepay_id;
    L35:
        if ((r214 & 256) == 0) goto L37;
        String r118 = r110.sign;
    L39:
        if ((r214 & 512) == 0) goto L41;
        String r119 = r110.timestamp;
    L43:
        if ((r214 & 1024) == 0) goto L45;
        String r108 = r110.trade_no;
    L47:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r118, r119, r108);
    L45:
        r108 = r213;
        goto L47
    L41:
        r119 = r212;
        goto L43
    L37:
        r118 = r211;
        goto L39
    L33:
        r107 = r210;
        goto L35
    L29:
        r106 = r117;
        goto L31
    L25:
        r105 = r116;
        goto L27
    L21:
        r104 = r115;
        goto L23
    L17:
        r103 = r114;
        goto L19
    L13:
        r102 = r113;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    public final String component1() {
        return this.code;
    }

    public final String component10() {
        return this.timestamp;
    }

    public final String component11() {
        return this.trade_no;
    }

    public final String component2() {
        return this.msg;
    }

    public final String component3() {
        return this.invoke_info;
    }

    public final String component4() {
        return this.invoke_scene;
    }

    public final String component5() {
        return this.merchant_app_id;
    }

    public final String component6() {
        return this.merchant_id;
    }

    public final String component7() {
        return this.noncestr;
    }

    public final String component8() {
        return this.prepay_id;
    }

    public final String component9() {
        return this.sign;
    }

    public final CJCreditPayParamsQueryResponse copy(String r110, String r111, String r112, String r113, String r114, String r115, String r210, String r211, String r212, String r213, String r214) {
        Intrinsics.checkNotNullParameter(r110, "code");
        Intrinsics.checkNotNullParameter(r111, "msg");
        Intrinsics.checkNotNullParameter(r112, "invoke_info");
        Intrinsics.checkNotNullParameter(r113, "invoke_scene");
        Intrinsics.checkNotNullParameter(r114, "merchant_app_id");
        Intrinsics.checkNotNullParameter(r115, "merchant_id");
        Intrinsics.checkNotNullParameter(r210, DyPayConstant.K_PAY_INFO_PARAM_NONCESTR);
        Intrinsics.checkNotNullParameter(r211, "prepay_id");
        Intrinsics.checkNotNullParameter(r212, "sign");
        Intrinsics.checkNotNullParameter(r213, "timestamp");
        Intrinsics.checkNotNullParameter(r214, b.B0);
        return new CJCreditPayParamsQueryResponse(r110, r111, r112, r113, r114, r115, r210, r211, r212, r213, r214);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof CJCreditPayParamsQueryResponse) == true) goto L8;
        return false;
    L8:
        CJCreditPayParamsQueryResponse r101 = (CJCreditPayParamsQueryResponse) r100;
        if (Intrinsics.areEqual(this.code, r101.code) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.msg, r101.msg) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.invoke_info, r101.invoke_info) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.invoke_scene, r101.invoke_scene) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.merchant_app_id, r101.merchant_app_id) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.merchant_id, r101.merchant_id) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.noncestr, r101.noncestr) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.prepay_id, r101.prepay_id) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.sign, r101.sign) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.timestamp, r101.timestamp) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.trade_no, r101.trade_no) == true) goto L41;
        return false;
    L41:
        return true;
    }

    public int hashCode() {
        return (((((((((((((((((((this.code.hashCode() * 31) + this.msg.hashCode()) * 31) + this.invoke_info.hashCode()) * 31) + this.invoke_scene.hashCode()) * 31) + this.merchant_app_id.hashCode()) * 31) + this.merchant_id.hashCode()) * 31) + this.noncestr.hashCode()) * 31) + this.prepay_id.hashCode()) * 31) + this.sign.hashCode()) * 31) + this.timestamp.hashCode()) * 31) + this.trade_no.hashCode();
    }

    public String toString() {
        return "CJCreditPayParamsQueryResponse(code=" + this.code + ", msg=" + this.msg + ", invoke_info=" + this.invoke_info + ", invoke_scene=" + this.invoke_scene + ", merchant_app_id=" + this.merchant_app_id + ", merchant_id=" + this.merchant_id + ", noncestr=" + this.noncestr + ", prepay_id=" + this.prepay_id + ", sign=" + this.sign + ", timestamp=" + this.timestamp + ", trade_no=" + this.trade_no + ')';
    }

    public final boolean isResponseOK() {
        return Intrinsics.areEqual(CJPaySignInfoQueryResponse.CREDIT_RESPONSE_SUCCEED, this.code);
    }

    public CJCreditPayParamsQueryResponse(String r100, String r101, String r102, String r103, String r104, String r105, String r106, String r107, String r110, String r111, String r112) {
        Intrinsics.checkNotNullParameter(r100, "code");
        Intrinsics.checkNotNullParameter(r101, "msg");
        Intrinsics.checkNotNullParameter(r102, "invoke_info");
        Intrinsics.checkNotNullParameter(r103, "invoke_scene");
        Intrinsics.checkNotNullParameter(r104, "merchant_app_id");
        Intrinsics.checkNotNullParameter(r105, "merchant_id");
        Intrinsics.checkNotNullParameter(r106, DyPayConstant.K_PAY_INFO_PARAM_NONCESTR);
        Intrinsics.checkNotNullParameter(r107, "prepay_id");
        Intrinsics.checkNotNullParameter(r110, "sign");
        Intrinsics.checkNotNullParameter(r111, "timestamp");
        Intrinsics.checkNotNullParameter(r112, b.B0);
        this.code = r100;
        this.msg = r101;
        this.invoke_info = r102;
        this.invoke_scene = r103;
        this.merchant_app_id = r104;
        this.merchant_id = r105;
        this.noncestr = r106;
        this.prepay_id = r107;
        this.sign = r110;
        this.timestamp = r111;
        this.trade_no = r112;
    }

    public /* synthetic */ CJCreditPayParamsQueryResponse(String r110, String r111, String r112, String r113, String r114, String r115, String r116, String r210, String r211, String r212, String r213, int r214, DefaultConstructorMarker r215) {
        String r100 = "";
        if ((r214 & 1) == 0) goto L5;
        String r101 = "";
    L7:
        if ((r214 & 2) == 0) goto L9;
        String r102 = "";
    L11:
        if ((r214 & 4) == 0) goto L13;
        String r103 = "";
    L15:
        if ((r214 & 8) == 0) goto L17;
        String r104 = "";
    L19:
        if ((r214 & 16) == 0) goto L21;
        String r105 = "";
    L23:
        if ((r214 & 32) == 0) goto L25;
        String r106 = "";
    L27:
        if ((r214 & 64) == 0) goto L29;
        String r107 = "";
    L31:
        if ((r214 & 128) == 0) goto L33;
        String r108 = "";
    L35:
        if ((r214 & 256) == 0) goto L37;
        String r117 = "";
    L39:
        if ((r214 & 512) == 0) goto L41;
        String r118 = "";
    L43:
        if ((r214 & 1024) != 0) goto L46;
        r100 = r213;
    L46:
        this(r101, r102, r103, r104, r105, r106, r107, r108, r117, r118, r100);
        return;
    L41:
        r118 = r212;
        goto L43
    L37:
        r117 = r211;
        goto L39
    L33:
        r108 = r210;
        goto L35
    L29:
        r107 = r116;
        goto L31
    L25:
        r106 = r115;
        goto L27
    L21:
        r105 = r114;
        goto L23
    L17:
        r104 = r113;
        goto L19
    L13:
        r103 = r112;
        goto L15
    L9:
        r102 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L7
    }
}
