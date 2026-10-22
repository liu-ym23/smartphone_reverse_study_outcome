package com.bytedance.android.sdk.bdticketguard;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\t\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001a\u0010\u000b\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u001a\u0010\r\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u0004\u001a\u0004\b\u000e\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/sdk/bdticketguard/a;", "", "", "attestKey", "Ljava/lang/String;", "getAttestKey", "()Ljava/lang/String;", "attestTsSign", "getAttestTsSign", "requestContent", "getRequestContent", "requestSign", "getRequestSign", "secTs", "getSecTs", "bd_ticket_guard_api_release"}, k = 1, mv = {1, 4, 0})
public final class a {

    @SerializedName("attestkey")
    private final String attestKey;

    @SerializedName("attestkey_ts_sign")
    private final String attestTsSign;

    @SerializedName("req_content")
    private final String requestContent;

    @SerializedName("req_sign")
    private final String requestSign;

    @SerializedName("sec_ts")
    private final String secTs;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L16;
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.attestKey, r101.attestKey) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.attestTsSign, r101.attestTsSign) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.requestContent, r101.requestContent) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.requestSign, r101.requestSign) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.secTs, r101.secTs) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public final int hashCode() {
        String r100 = this.attestKey;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.attestTsSign;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.requestContent;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.requestSign;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.secTs;
        if (r113 == null) goto L22;
        r101 = r113.hashCode();
    L22:
        return r112 + r101;
    L17:
        r111 = 0;
        goto L18
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "AttestClientData(attestKey=" + this.attestKey + ", attestTsSign=" + this.attestTsSign + ", requestContent=" + this.requestContent + ", requestSign=" + this.requestSign + ", secTs=" + this.secTs + ")";
    }

    public a() {
        this("", "", "", "", "");
    }

    public a(String r100, String r101, String r102, String r103, String r104) {
        this.attestKey = r100;
        this.attestTsSign = r101;
        this.requestContent = r102;
        this.requestSign = r103;
        this.secTs = r104;
    }
}
