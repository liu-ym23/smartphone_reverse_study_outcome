package com.bytedance.android.shopping.anchorv4.voavhs.kolevaluation;

import com.bytedance.android.shopping.anchorv4.dto.components.LongContentLabelComponent;
import com.bytedance.android.shopping.anchorv4.dto.elements.KolReviewElement;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u0013\u0010\f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0006HÆ\u0003J)\u0010\u000e\u001a\u00020\u00002\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R \u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/kolevaluation/AnchorV4KolEvaluationDisplay;", "Ljava/io/Serializable;", "kolReviewList", "", "Lcom/bytedance/android/shopping/anchorv4/dto/elements/KolReviewElement;", "kolReviewTitle", "Lcom/bytedance/android/shopping/anchorv4/dto/components/LongContentLabelComponent;", "(Ljava/util/List;Lcom/bytedance/android/shopping/anchorv4/dto/components/LongContentLabelComponent;)V", "getKolReviewList", "()Ljava/util/List;", "getKolReviewTitle", "()Lcom/bytedance/android/shopping/anchorv4/dto/components/LongContentLabelComponent;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorV4KolEvaluationDisplay implements Serializable {

    @SerializedName("kol_review_list")
    private final List<KolReviewElement> kolReviewList;

    @SerializedName("kol_review_title")
    private final LongContentLabelComponent kolReviewTitle;

    /* JADX WARN: Multi-variable type inference failed */
    public AnchorV4KolEvaluationDisplay() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AnchorV4KolEvaluationDisplay copy$default(AnchorV4KolEvaluationDisplay r100, List r101, LongContentLabelComponent r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.kolReviewList;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.kolReviewTitle;
    L9:
        return r100.copy(r101, r102);
    }

    public final List<KolReviewElement> component1() {
        return this.kolReviewList;
    }

    public final LongContentLabelComponent component2() {
        return this.kolReviewTitle;
    }

    public final AnchorV4KolEvaluationDisplay copy(List<KolReviewElement> r100, LongContentLabelComponent r101) {
        return new AnchorV4KolEvaluationDisplay(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof AnchorV4KolEvaluationDisplay) == false) goto L10;
        AnchorV4KolEvaluationDisplay r101 = (AnchorV4KolEvaluationDisplay) r100;
        if (Intrinsics.areEqual(this.kolReviewList, r101.kolReviewList) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.kolReviewTitle, r101.kolReviewTitle) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public int hashCode() {
        List<KolReviewElement> r100 = this.kolReviewList;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        LongContentLabelComponent r104 = this.kolReviewTitle;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "AnchorV4KolEvaluationDisplay(kolReviewList=" + this.kolReviewList + ", kolReviewTitle=" + this.kolReviewTitle + ")";
    }

    public final List<KolReviewElement> getKolReviewList() {
        return this.kolReviewList;
    }

    public final LongContentLabelComponent getKolReviewTitle() {
        return this.kolReviewTitle;
    }

    public AnchorV4KolEvaluationDisplay(List<KolReviewElement> r100, LongContentLabelComponent r101) {
        this.kolReviewList = r100;
        this.kolReviewTitle = r101;
    }

    public /* synthetic */ AnchorV4KolEvaluationDisplay(List r100, LongContentLabelComponent r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this(r100, r101);
    }
}
