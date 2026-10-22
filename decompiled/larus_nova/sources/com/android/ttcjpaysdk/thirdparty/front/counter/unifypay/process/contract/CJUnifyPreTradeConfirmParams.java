package com.android.ttcjpaysdk.thirdparty.front.counter.unifypay.process.contract;

import com.alipay.sdk.m.s.a;
import com.android.ttcjpaysdk.thirdparty.data.RequestType;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B3\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0007HÆ\u0003J7\u0010\u0015\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\b\u0010\u001b\u001a\u00020\u0003H\u0016R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\f\"\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\f¨\u0006\u001c"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/front/counter/unifypay/process/contract/CJUnifyPreTradeConfirmParams;", "", "token", "", "reqType", "refer", a.f25767y, "Lorg/json/JSONObject;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lorg/json/JSONObject;)V", "getExtInfo", "()Lorg/json/JSONObject;", "getRefer", "()Ljava/lang/String;", "getReqType", "setReqType", "(Ljava/lang/String;)V", "getToken", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "bdpay-front-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJUnifyPreTradeConfirmParams {
    private final JSONObject extInfo;
    private final String refer;
    private String reqType;
    private final String token;

    public CJUnifyPreTradeConfirmParams() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ CJUnifyPreTradeConfirmParams copy$default(CJUnifyPreTradeConfirmParams r100, String r101, String r102, String r103, JSONObject r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.token;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.reqType;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.refer;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.extInfo;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final String component1() {
        return this.token;
    }

    public final String component2() {
        return this.reqType;
    }

    public final String component3() {
        return this.refer;
    }

    public final JSONObject component4() {
        return this.extInfo;
    }

    public final CJUnifyPreTradeConfirmParams copy(String r100, String r101, String r102, JSONObject r103) {
        Intrinsics.checkNotNullParameter(r101, "reqType");
        return new CJUnifyPreTradeConfirmParams(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof CJUnifyPreTradeConfirmParams) == true) goto L8;
        return false;
    L8:
        CJUnifyPreTradeConfirmParams r101 = (CJUnifyPreTradeConfirmParams) r100;
        if (Intrinsics.areEqual(this.token, r101.token) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.reqType, r101.reqType) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.refer, r101.refer) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.extInfo, r101.extInfo) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        String r100 = this.token;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = ((r102 * 31) + this.reqType.hashCode()) * 31;
        String r104 = this.refer;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        JSONObject r107 = this.extInfo;
        if (r107 == null) goto L15;
        r101 = r107.hashCode();
    L15:
        return r106 + r101;
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "CJUnifyPreTradeConfirmParams(token=" + this.token + ", req_type='" + this.reqType + "', refer=" + this.refer + " , extInfo=" + this.extInfo + ')';
    }

    public final JSONObject getExtInfo() {
        return this.extInfo;
    }

    public final String getRefer() {
        return this.refer;
    }

    public final String getReqType() {
        return this.reqType;
    }

    public final String getToken() {
        return this.token;
    }

    public final void setReqType(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.reqType = r100;
    }

    public CJUnifyPreTradeConfirmParams(String r100, String r101, String r102, JSONObject r103) {
        Intrinsics.checkNotNullParameter(r101, "reqType");
        this.token = r100;
        this.reqType = r101;
        this.refer = r102;
        this.extInfo = r103;
    }

    public /* synthetic */ CJUnifyPreTradeConfirmParams(String r100, String r101, String r102, JSONObject r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = RequestType.TOKEN_VERIFY.getValue();
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = null;
    L12:
        if ((r104 & 8) == 0) goto L14;
        r103 = null;
    L14:
        this(r100, r101, r102, r103);
    }
}
