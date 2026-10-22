package com.bytedance.android.shopping.anchorv4.voavhs.kolevaluation;

import com.bytedance.android.shopping.anchorv4.dto.meta.PageMetaMappedMap;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J!\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/kolevaluation/AnchorV4KolEvaluationMeta;", "Ljava/io/Serializable;", "trackMeta", "Lcom/bytedance/android/shopping/anchorv4/voavhs/kolevaluation/AnchorV4KolEvaluationTrackMeta;", "businessMeta", "Lcom/bytedance/android/shopping/anchorv4/voavhs/kolevaluation/AnchorV4KolEvaluationBusinessMeta;", "(Lcom/bytedance/android/shopping/anchorv4/voavhs/kolevaluation/AnchorV4KolEvaluationTrackMeta;Lcom/bytedance/android/shopping/anchorv4/voavhs/kolevaluation/AnchorV4KolEvaluationBusinessMeta;)V", "getBusinessMeta", "()Lcom/bytedance/android/shopping/anchorv4/voavhs/kolevaluation/AnchorV4KolEvaluationBusinessMeta;", "getTrackMeta", "()Lcom/bytedance/android/shopping/anchorv4/voavhs/kolevaluation/AnchorV4KolEvaluationTrackMeta;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorV4KolEvaluationMeta implements Serializable {

    @SerializedName("business_meta")
    private final AnchorV4KolEvaluationBusinessMeta businessMeta;

    @SerializedName(PageMetaMappedMap.TRACK_META_KEY)
    private final AnchorV4KolEvaluationTrackMeta trackMeta;

    /* JADX WARN: Multi-variable type inference failed */
    public AnchorV4KolEvaluationMeta() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ AnchorV4KolEvaluationMeta copy$default(AnchorV4KolEvaluationMeta r100, AnchorV4KolEvaluationTrackMeta r101, AnchorV4KolEvaluationBusinessMeta r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.trackMeta;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.businessMeta;
    L9:
        return r100.copy(r101, r102);
    }

    public final AnchorV4KolEvaluationTrackMeta component1() {
        return this.trackMeta;
    }

    public final AnchorV4KolEvaluationBusinessMeta component2() {
        return this.businessMeta;
    }

    public final AnchorV4KolEvaluationMeta copy(AnchorV4KolEvaluationTrackMeta r100, AnchorV4KolEvaluationBusinessMeta r101) {
        return new AnchorV4KolEvaluationMeta(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof AnchorV4KolEvaluationMeta) == false) goto L10;
        AnchorV4KolEvaluationMeta r101 = (AnchorV4KolEvaluationMeta) r100;
        if (Intrinsics.areEqual(this.trackMeta, r101.trackMeta) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.businessMeta, r101.businessMeta) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public int hashCode() {
        AnchorV4KolEvaluationTrackMeta r100 = this.trackMeta;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        AnchorV4KolEvaluationBusinessMeta r104 = this.businessMeta;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "AnchorV4KolEvaluationMeta(trackMeta=" + this.trackMeta + ", businessMeta=" + this.businessMeta + ")";
    }

    public final AnchorV4KolEvaluationBusinessMeta getBusinessMeta() {
        return this.businessMeta;
    }

    public final AnchorV4KolEvaluationTrackMeta getTrackMeta() {
        return this.trackMeta;
    }

    public AnchorV4KolEvaluationMeta(AnchorV4KolEvaluationTrackMeta r100, AnchorV4KolEvaluationBusinessMeta r101) {
        this.trackMeta = r100;
        this.businessMeta = r101;
    }

    public /* synthetic */ AnchorV4KolEvaluationMeta(AnchorV4KolEvaluationTrackMeta r100, AnchorV4KolEvaluationBusinessMeta r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this(r100, r101);
    }
}
