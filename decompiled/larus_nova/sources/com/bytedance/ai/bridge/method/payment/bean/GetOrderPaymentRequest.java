package com.bytedance.ai.bridge.method.payment.bean;

import com.google.gson.annotations.SerializedName;
import com.larus.bmhome.music.applet.MusicAppletPage;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BA\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\t\u0010\nJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0007HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003JC\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00072\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\f¨\u0006\u001d"}, d2 = {"Lcom/bytedance/ai/bridge/method/payment/bean/GetOrderPaymentRequest;", "", "appId", "", "orderId", "platformSignedPtCode", "awemeBindStatus", "", "messageId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;)V", "getAppId", "()Ljava/lang/String;", "getOrderId", "getPlatformSignedPtCode", "getAwemeBindStatus", "()Z", "getMessageId", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "", "toString", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GetOrderPaymentRequest {

    @SerializedName("app_key")
    private final String appId;

    @SerializedName("aweme_bind_status")
    private final boolean awemeBindStatus;

    @SerializedName(MusicAppletPage.KEY_MESSAGE_ID)
    private final String messageId;

    @SerializedName("order_id")
    private final String orderId;

    @SerializedName("platform_signed_pt_code")
    private final String platformSignedPtCode;

    public GetOrderPaymentRequest() {
        this(null, null, null, false, null, 31, null);
    }

    public static /* synthetic */ GetOrderPaymentRequest copy$default(GetOrderPaymentRequest r100, String r101, String r102, String r103, boolean r104, String r105, int r106, Object r110) {
        if ((r106 & 1) == 0) goto L6;
        r101 = r100.appId;
    L6:
        if ((r106 & 2) == 0) goto L8;
        r102 = r100.orderId;
    L8:
        String r111 = r102;
        if ((r106 & 4) == 0) goto L11;
        r103 = r100.platformSignedPtCode;
    L11:
        String r107 = r103;
        if ((r106 & 8) == 0) goto L14;
        r104 = r100.awemeBindStatus;
    L14:
        boolean r108 = r104;
        if ((r106 & 16) == 0) goto L17;
        r105 = r100.messageId;
    L17:
        String r109 = r101;
        return r100.copy(r109, r111, r107, r108, r105);
    }

    public final String component1() {
        return this.appId;
    }

    public final String component2() {
        return this.orderId;
    }

    public final String component3() {
        return this.platformSignedPtCode;
    }

    public final boolean component4() {
        return this.awemeBindStatus;
    }

    public final String component5() {
        return this.messageId;
    }

    public final GetOrderPaymentRequest copy(String r100, String r101, String r110, boolean r111, String r112) {
        return new GetOrderPaymentRequest(r100, r101, r110, r111, r112);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof GetOrderPaymentRequest) == true) goto L8;
        return false;
    L8:
        GetOrderPaymentRequest r101 = (GetOrderPaymentRequest) r100;
        if (Intrinsics.areEqual(this.appId, r101.appId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.orderId, r101.orderId) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.platformSignedPtCode, r101.platformSignedPtCode) == true) goto L18;
        return false;
    L18:
        if (this.awemeBindStatus == r101.awemeBindStatus) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.messageId, r101.messageId) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        String r100 = this.appId;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.orderId;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.platformSignedPtCode;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        if (this.awemeBindStatus == false) goto L17;
        int r110 = 1231;
    L18:
        int r111 = (r109 + r110) * 31;
        String r112 = this.messageId;
        if (r112 == null) goto L23;
        r101 = r112.hashCode();
    L23:
        return r111 + r101;
    L17:
        r110 = 1237;
        goto L18
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "GetOrderPaymentRequest(appId=" + this.appId + ", orderId=" + this.orderId + ", platformSignedPtCode=" + this.platformSignedPtCode + ", awemeBindStatus=" + this.awemeBindStatus + ", messageId=" + this.messageId + ')';
    }

    public final String getAppId() {
        return this.appId;
    }

    public final boolean getAwemeBindStatus() {
        return this.awemeBindStatus;
    }

    public final String getMessageId() {
        return this.messageId;
    }

    public final String getOrderId() {
        return this.orderId;
    }

    public final String getPlatformSignedPtCode() {
        return this.platformSignedPtCode;
    }

    public GetOrderPaymentRequest(String r100, String r101, String r102, boolean r103, String r104) {
        this.appId = r100;
        this.orderId = r101;
        this.platformSignedPtCode = r102;
        this.awemeBindStatus = r103;
        this.messageId = r104;
    }

    public /* synthetic */ GetOrderPaymentRequest(String r100, String r101, String r102, boolean r103, String r104, int r105, DefaultConstructorMarker r110) {
        String r106 = "";
        if ((r105 & 1) == 0) goto L5;
        String r111 = "";
    L7:
        if ((r105 & 2) != 0) goto L11;
        r106 = r101;
    L11:
        if ((r105 & 4) == 0) goto L13;
        String r107 = null;
    L15:
        if ((r105 & 8) == 0) goto L17;
        boolean r108 = false;
    L19:
        if ((r105 & 16) == 0) goto L21;
        String r109 = null;
    L22:
        this(r111, r106, r107, r108, r109);
        return;
    L21:
        r109 = r104;
        goto L22
    L17:
        r108 = r103;
        goto L19
    L13:
        r107 = r102;
        goto L15
    L5:
        r111 = r100;
        goto L7
    }
}
