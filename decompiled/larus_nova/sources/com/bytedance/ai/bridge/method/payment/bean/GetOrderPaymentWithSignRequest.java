package com.bytedance.ai.bridge.method.payment.bean;

import com.google.gson.annotations.SerializedName;
import com.heytap.mcssdk.constant.b;
import com.larus.bmhome.music.applet.MusicAppletPage;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0015\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BM\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\bHÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003JO\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u001b\u001a\u00020\b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\r¨\u0006 "}, d2 = {"Lcom/bytedance/ai/bridge/method/payment/bean/GetOrderPaymentWithSignRequest;", "", "orderId", "", "signData", "signDbAuthorization", b.f276376z, "awemeBindStatus", "", "messageId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;)V", "getOrderId", "()Ljava/lang/String;", "getSignData", "getSignDbAuthorization", "getAppKey", "getAwemeBindStatus", "()Z", "getMessageId", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "", "toString", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GetOrderPaymentWithSignRequest {

    @SerializedName("app_key")
    private final String appKey;

    @SerializedName("aweme_bind_status")
    private final boolean awemeBindStatus;

    @SerializedName(MusicAppletPage.KEY_MESSAGE_ID)
    private final String messageId;

    @SerializedName("order_id")
    private final String orderId;

    @SerializedName("sign_data")
    private final String signData;

    @SerializedName("sign_db_authorization")
    private final String signDbAuthorization;

    public GetOrderPaymentWithSignRequest() {
        this(null, null, null, null, false, null, 63, null);
    }

    public static /* synthetic */ GetOrderPaymentWithSignRequest copy$default(GetOrderPaymentWithSignRequest r100, String r101, String r102, String r103, String r104, boolean r105, String r110, int r111, Object r112) {
        if ((r111 & 1) == 0) goto L6;
        r101 = r100.orderId;
    L6:
        if ((r111 & 2) == 0) goto L8;
        r102 = r100.signData;
    L8:
        String r113 = r102;
        if ((r111 & 4) == 0) goto L11;
        r103 = r100.signDbAuthorization;
    L11:
        String r106 = r103;
        if ((r111 & 8) == 0) goto L14;
        r104 = r100.appKey;
    L14:
        String r107 = r104;
        if ((r111 & 16) == 0) goto L17;
        r105 = r100.awemeBindStatus;
    L17:
        boolean r108 = r105;
        if ((r111 & 32) == 0) goto L20;
        r110 = r100.messageId;
    L20:
        String r109 = r101;
        return r100.copy(r109, r113, r106, r107, r108, r110);
    }

    public final String component1() {
        return this.orderId;
    }

    public final String component2() {
        return this.signData;
    }

    public final String component3() {
        return this.signDbAuthorization;
    }

    public final String component4() {
        return this.appKey;
    }

    public final boolean component5() {
        return this.awemeBindStatus;
    }

    public final String component6() {
        return this.messageId;
    }

    public final GetOrderPaymentWithSignRequest copy(String r100, String r110, String r111, String r112, boolean r113, String r114) {
        return new GetOrderPaymentWithSignRequest(r100, r110, r111, r112, r113, r114);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof GetOrderPaymentWithSignRequest) == true) goto L8;
        return false;
    L8:
        GetOrderPaymentWithSignRequest r101 = (GetOrderPaymentWithSignRequest) r100;
        if (Intrinsics.areEqual(this.orderId, r101.orderId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.signData, r101.signData) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.signDbAuthorization, r101.signDbAuthorization) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.appKey, r101.appKey) == true) goto L21;
        return false;
    L21:
        if (this.awemeBindStatus == r101.awemeBindStatus) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.messageId, r101.messageId) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        String r100 = this.orderId;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.signData;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.signDbAuthorization;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.appKey;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        if (this.awemeBindStatus == false) goto L21;
        int r113 = 1231;
    L22:
        int r114 = (r112 + r113) * 31;
        String r115 = this.messageId;
        if (r115 == null) goto L27;
        r101 = r115.hashCode();
    L27:
        return r114 + r101;
    L21:
        r113 = 1237;
        goto L22
    L17:
        r111 = r110.hashCode();
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
        return "GetOrderPaymentWithSignRequest(orderId=" + this.orderId + ", signData=" + this.signData + ", signDbAuthorization=" + this.signDbAuthorization + ", appKey=" + this.appKey + ", awemeBindStatus=" + this.awemeBindStatus + ", messageId=" + this.messageId + ')';
    }

    public final String getAppKey() {
        return this.appKey;
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

    public final String getSignData() {
        return this.signData;
    }

    public final String getSignDbAuthorization() {
        return this.signDbAuthorization;
    }

    public GetOrderPaymentWithSignRequest(String r100, String r101, String r102, String r103, boolean r104, String r105) {
        this.orderId = r100;
        this.signData = r101;
        this.signDbAuthorization = r102;
        this.appKey = r103;
        this.awemeBindStatus = r104;
        this.messageId = r105;
    }

    public /* synthetic */ GetOrderPaymentWithSignRequest(String r100, String r101, String r102, String r103, boolean r104, String r110, int r111, DefaultConstructorMarker r112) {
        String r105 = "";
        if ((r111 & 1) == 0) goto L5;
        String r113 = "";
    L7:
        if ((r111 & 2) == 0) goto L9;
        String r106 = "";
    L11:
        if ((r111 & 4) == 0) goto L13;
        String r107 = "";
    L15:
        if ((r111 & 8) != 0) goto L19;
        r105 = r103;
    L19:
        if ((r111 & 16) == 0) goto L21;
        boolean r108 = false;
    L23:
        if ((r111 & 32) == 0) goto L25;
        r110 = null;
    L25:
        String r114 = r110;
        this(r113, r106, r107, r105, r108, r114);
        return;
    L21:
        r108 = r104;
        goto L23
    L13:
        r107 = r102;
        goto L15
    L9:
        r106 = r101;
        goto L11
    L5:
        r113 = r100;
        goto L7
    }
}
