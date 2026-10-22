package com.bytedance.android.shopping.anchorv3.auction.data;

import com.bytedance.android.ec.core.event.a;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/shopping/anchorv3/auction/data/AuctionOfferRecordsRequest;", "Ljava/io/Serializable;", "auctionId", "", "offset", "", "metaParam", "(Ljava/lang/String;ILjava/lang/String;)V", "getAuctionId", "()Ljava/lang/String;", "getMetaParam", "getOffset", "()I", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "toString", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AuctionOfferRecordsRequest implements Serializable {

    @SerializedName("auction_id")
    private final String auctionId;

    @SerializedName(a.KEY_META_PARAM)
    private final String metaParam;

    @SerializedName("offset")
    private final int offset;

    public static /* synthetic */ AuctionOfferRecordsRequest copy$default(AuctionOfferRecordsRequest r100, String r101, int r102, String r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.auctionId;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.offset;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.metaParam;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final String component1() {
        return this.auctionId;
    }

    public final int component2() {
        return this.offset;
    }

    public final String component3() {
        return this.metaParam;
    }

    public final AuctionOfferRecordsRequest copy(String r100, int r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "auctionId");
        Intrinsics.checkNotNullParameter(r102, "metaParam");
        return new AuctionOfferRecordsRequest(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof AuctionOfferRecordsRequest) == false) goto L12;
        AuctionOfferRecordsRequest r101 = (AuctionOfferRecordsRequest) r100;
        if (Intrinsics.areEqual(this.auctionId, r101.auctionId) == true) goto L8;
        return false;
    L8:
        if (this.offset == r101.offset) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.metaParam, r101.metaParam) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public int hashCode() {
        String r100 = this.auctionId;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = ((r102 * 31) + this.offset) * 31;
        String r104 = this.metaParam;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "AuctionOfferRecordsRequest(auctionId=" + this.auctionId + ", offset=" + this.offset + ", metaParam=" + this.metaParam + ")";
    }

    public final String getAuctionId() {
        return this.auctionId;
    }

    public final String getMetaParam() {
        return this.metaParam;
    }

    public final int getOffset() {
        return this.offset;
    }

    public AuctionOfferRecordsRequest(String r100, int r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "auctionId");
        Intrinsics.checkNotNullParameter(r102, "metaParam");
        this.auctionId = r100;
        this.offset = r101;
        this.metaParam = r102;
    }

    public /* synthetic */ AuctionOfferRecordsRequest(String r100, int r101, String r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 4) == 0) goto L5;
        r102 = "";
    L5:
        this(r100, r101, r102);
    }
}
