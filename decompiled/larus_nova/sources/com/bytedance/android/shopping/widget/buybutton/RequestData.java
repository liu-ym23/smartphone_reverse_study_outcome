package com.bytedance.android.shopping.widget.buybutton;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u000b\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\u000b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/shopping/widget/buybutton/RequestData;", "Ljava/io/Serializable;", "marketingChannel", "", "secAuthorId", "(Ljava/lang/String;Ljava/lang/String;)V", "getMarketingChannel", "()Ljava/lang/String;", "getSecAuthorId", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class RequestData implements Serializable {

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_MARKET_CHANNEL)
    private final String marketingChannel;

    @SerializedName("sec_author_id")
    private final String secAuthorId;

    /* JADX WARN: Multi-variable type inference failed */
    public RequestData() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ RequestData copy$default(RequestData r100, String r101, String r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.marketingChannel;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.secAuthorId;
    L9:
        return r100.copy(r101, r102);
    }

    public final String component1() {
        return this.marketingChannel;
    }

    public final String component2() {
        return this.secAuthorId;
    }

    public final RequestData copy(String r100, String r101) {
        return new RequestData(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof RequestData) == false) goto L10;
        RequestData r101 = (RequestData) r100;
        if (Intrinsics.areEqual(this.marketingChannel, r101.marketingChannel) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.secAuthorId, r101.secAuthorId) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public int hashCode() {
        String r100 = this.marketingChannel;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.secAuthorId;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "RequestData(marketingChannel=" + this.marketingChannel + ", secAuthorId=" + this.secAuthorId + ")";
    }

    public final String getMarketingChannel() {
        return this.marketingChannel;
    }

    public final String getSecAuthorId() {
        return this.secAuthorId;
    }

    public RequestData(String r100, String r101) {
        this.marketingChannel = r100;
        this.secAuthorId = r101;
    }

    public /* synthetic */ RequestData(String r100, String r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this(r100, r101);
    }
}
