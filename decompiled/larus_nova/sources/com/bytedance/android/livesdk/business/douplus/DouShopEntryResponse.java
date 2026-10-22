package com.bytedance.android.livesdk.business.douplus;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001B'\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0006HÆ\u0003J+\u0010\u0010\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0006HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/livesdk/business/douplus/DouShopEntryResponse;", "Ljava/io/Serializable;", "url", "", com.bytedance.android.ec.core.event.a.KEY_STATUS_MSG, "statusCode", "", "(Ljava/lang/String;Ljava/lang/String;I)V", "getStatusCode", "()I", "getStatusMsg", "()Ljava/lang/String;", "getUrl", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "toString", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class DouShopEntryResponse implements Serializable {

    @SerializedName("status_code")
    private final int statusCode;

    @SerializedName("status_msg")
    private final String statusMsg;

    @SerializedName("url")
    private final String url;

    public DouShopEntryResponse() {
        this(null, null, 0, 7, null);
    }

    public static /* synthetic */ DouShopEntryResponse copy$default(DouShopEntryResponse r100, String r101, String r102, int r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.url;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.statusMsg;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.statusCode;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final String component1() {
        return this.url;
    }

    public final String component2() {
        return this.statusMsg;
    }

    public final int component3() {
        return this.statusCode;
    }

    public final DouShopEntryResponse copy(String r100, String r101, int r102) {
        return new DouShopEntryResponse(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof DouShopEntryResponse) == false) goto L12;
        DouShopEntryResponse r101 = (DouShopEntryResponse) r100;
        if (Intrinsics.areEqual(this.url, r101.url) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.statusMsg, r101.statusMsg) == true) goto L10;
        return false;
    L10:
        if (this.statusCode == r101.statusCode) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public int hashCode() {
        String r100 = this.url;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.statusMsg;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return ((r103 + r101) * 31) + this.statusCode;
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "DouShopEntryResponse(url=" + this.url + ", statusMsg=" + this.statusMsg + ", statusCode=" + this.statusCode + ")";
    }

    public final int getStatusCode() {
        return this.statusCode;
    }

    public final String getStatusMsg() {
        return this.statusMsg;
    }

    public final String getUrl() {
        return this.url;
    }

    public DouShopEntryResponse(String r100, String r101, int r102) {
        this.url = r100;
        this.statusMsg = r101;
        this.statusCode = r102;
    }

    public /* synthetic */ DouShopEntryResponse(String r100, String r101, int r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = "";
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = "";
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = -1;
    L11:
        this(r100, r101, r102);
    }
}
