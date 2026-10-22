package com.bytedance.android.shopping.anchorv4.voavhs.offerrecord;

import com.bytedance.android.shopping.anchorv4.dto.components.LongContentLabelComponent;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u001e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/offerrecord/AnchorV4OfferRecordsDisplay;", "Ljava/io/Serializable;", "title", "Lcom/bytedance/android/shopping/anchorv4/dto/components/LongContentLabelComponent;", "records", "", "Lcom/bytedance/android/shopping/anchorv4/voavhs/offerrecord/AnchorV4OfferRecordItemVO;", "(Lcom/bytedance/android/shopping/anchorv4/dto/components/LongContentLabelComponent;Ljava/util/List;)V", "getRecords", "()Ljava/util/List;", "getTitle", "()Lcom/bytedance/android/shopping/anchorv4/dto/components/LongContentLabelComponent;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorV4OfferRecordsDisplay implements Serializable {

    @SerializedName("records")
    private final List<AnchorV4OfferRecordItemVO> records;

    @SerializedName("title")
    private final LongContentLabelComponent title;

    /* JADX WARN: Multi-variable type inference failed */
    public AnchorV4OfferRecordsDisplay() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AnchorV4OfferRecordsDisplay copy$default(AnchorV4OfferRecordsDisplay r100, LongContentLabelComponent r101, List r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.title;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.records;
    L9:
        return r100.copy(r101, r102);
    }

    public final LongContentLabelComponent component1() {
        return this.title;
    }

    public final List<AnchorV4OfferRecordItemVO> component2() {
        return this.records;
    }

    public final AnchorV4OfferRecordsDisplay copy(LongContentLabelComponent r100, List<AnchorV4OfferRecordItemVO> r101) {
        return new AnchorV4OfferRecordsDisplay(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof AnchorV4OfferRecordsDisplay) == false) goto L10;
        AnchorV4OfferRecordsDisplay r101 = (AnchorV4OfferRecordsDisplay) r100;
        if (Intrinsics.areEqual(this.title, r101.title) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.records, r101.records) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public int hashCode() {
        LongContentLabelComponent r100 = this.title;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        List<AnchorV4OfferRecordItemVO> r104 = this.records;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "AnchorV4OfferRecordsDisplay(title=" + this.title + ", records=" + this.records + ")";
    }

    public final List<AnchorV4OfferRecordItemVO> getRecords() {
        return this.records;
    }

    public final LongContentLabelComponent getTitle() {
        return this.title;
    }

    public AnchorV4OfferRecordsDisplay(LongContentLabelComponent r100, List<AnchorV4OfferRecordItemVO> r101) {
        this.title = r100;
        this.records = r101;
    }

    public /* synthetic */ AnchorV4OfferRecordsDisplay(LongContentLabelComponent r100, List r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this(r100, r101);
    }
}
