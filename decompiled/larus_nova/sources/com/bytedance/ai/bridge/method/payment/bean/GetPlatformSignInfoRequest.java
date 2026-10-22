package com.bytedance.ai.bridge.method.payment.bean;

import com.google.gson.annotations.SerializedName;
import com.heytap.mcssdk.constant.b;
import com.larus.bmhome.music.applet.MusicAppletPage;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B)\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003J+\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u0018"}, d2 = {"Lcom/bytedance/ai/bridge/method/payment/bean/GetPlatformSignInfoRequest;", "", "amount", "", b.f276376z, "", "messageId", "<init>", "(JLjava/lang/String;Ljava/lang/String;)V", "getAmount", "()J", "getAppKey", "()Ljava/lang/String;", "getMessageId", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GetPlatformSignInfoRequest {

    @SerializedName("amount")
    private final long amount;

    @SerializedName("app_key")
    private final String appKey;

    @SerializedName(MusicAppletPage.KEY_MESSAGE_ID)
    private final String messageId;

    public GetPlatformSignInfoRequest() {
        this(0, null, null, 7, null);
    }

    public static /* synthetic */ GetPlatformSignInfoRequest copy$default(GetPlatformSignInfoRequest r100, long r101, String r102, String r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.amount;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.appKey;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.messageId;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final long component1() {
        return this.amount;
    }

    public final String component2() {
        return this.appKey;
    }

    public final String component3() {
        return this.messageId;
    }

    public final GetPlatformSignInfoRequest copy(long r100, String r101, String r102) {
        return new GetPlatformSignInfoRequest(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof GetPlatformSignInfoRequest) == true) goto L8;
        return false;
    L8:
        GetPlatformSignInfoRequest r101 = (GetPlatformSignInfoRequest) r100;
        if (this.amount == r101.amount) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.appKey, r101.appKey) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.messageId, r101.messageId) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        long r100 = this.amount;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        String r102 = this.appKey;
        int r103 = 0;
        if (r102 != null) goto L5;
        int r104 = 0;
    L6:
        int r105 = (r101 + r104) * 31;
        String r106 = this.messageId;
        if (r106 == null) goto L11;
        r103 = r106.hashCode();
    L11:
        return r105 + r103;
    L5:
        r104 = r102.hashCode();
        goto L6
    }

    public String toString() {
        return "GetPlatformSignInfoRequest(amount=" + this.amount + ", appKey=" + this.appKey + ", messageId=" + this.messageId + ')';
    }

    public final long getAmount() {
        return this.amount;
    }

    public final String getAppKey() {
        return this.appKey;
    }

    public final String getMessageId() {
        return this.messageId;
    }

    public GetPlatformSignInfoRequest(long r100, String r101, String r102) {
        this.amount = r100;
        this.appKey = r101;
        this.messageId = r102;
    }

    public /* synthetic */ GetPlatformSignInfoRequest(long r100, String r101, String r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = 0;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = "";
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = null;
    L11:
        this(r100, r101, r102);
    }
}
