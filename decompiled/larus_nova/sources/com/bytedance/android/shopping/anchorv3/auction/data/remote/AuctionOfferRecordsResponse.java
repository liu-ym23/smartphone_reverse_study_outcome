package com.bytedance.android.shopping.anchorv3.auction.data.remote;

import com.bytedance.android.ec.model.api.CommerceBaseResponse;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002B\u001d\u0012\u000e\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0011\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0007HÆ\u0003J%\u0010\u000f\u001a\u00020\u00002\u0010\b\u0002\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0007HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001e\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/shopping/anchorv3/auction/data/remote/AuctionOfferRecordsResponse;", "Lcom/bytedance/android/ec/model/api/CommerceBaseResponse;", "Ljava/io/Serializable;", "records", "", "Lcom/bytedance/android/shopping/anchorv3/auction/data/remote/RecordList;", "offset", "", "(Ljava/util/List;I)V", "getOffset", "()I", "getRecords", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AuctionOfferRecordsResponse extends CommerceBaseResponse {

    @SerializedName("offset")
    private final int offset;

    @SerializedName("records")
    private final List<RecordList> records;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AuctionOfferRecordsResponse copy$default(AuctionOfferRecordsResponse r100, List r101, int r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.records;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.offset;
    L9:
        return r100.copy(r101, r102);
    }

    public final List<RecordList> component1() {
        return this.records;
    }

    public final int component2() {
        return this.offset;
    }

    public final AuctionOfferRecordsResponse copy(List<RecordList> r100, int r101) {
        return new AuctionOfferRecordsResponse(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof AuctionOfferRecordsResponse) == false) goto L10;
        AuctionOfferRecordsResponse r101 = (AuctionOfferRecordsResponse) r100;
        if (Intrinsics.areEqual(this.records, r101.records) == true) goto L8;
        return false;
    L8:
        if (this.offset == r101.offset) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public int hashCode() {
        List<RecordList> r100 = this.records;
        if (r100 == null) goto L5;
        int r101 = r100.hashCode();
    L7:
        return (r101 * 31) + this.offset;
    L5:
        r101 = 0;
        goto L7
    }

    public String toString() {
        return "AuctionOfferRecordsResponse(records=" + this.records + ", offset=" + this.offset + ")";
    }

    public final int getOffset() {
        return this.offset;
    }

    public final List<RecordList> getRecords() {
        return this.records;
    }

    public AuctionOfferRecordsResponse(List<RecordList> r100, int r101) {
        this.records = r100;
        this.offset = r101;
    }
}
