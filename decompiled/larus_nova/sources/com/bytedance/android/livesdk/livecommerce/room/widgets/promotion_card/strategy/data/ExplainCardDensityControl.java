package com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.strategy.data;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/room/widgets/promotion_card/strategy/data/ExplainCardDensityControl;", "Ljava/io/Serializable;", "timeCycleDuration", "", "exposureTimeThreshold", "(JJ)V", "getExposureTimeThreshold", "()J", "getTimeCycleDuration", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ExplainCardDensityControl implements Serializable {

    @SerializedName("exposure_time")
    private final long exposureTimeThreshold;

    @SerializedName("judgement_cycle")
    private final long timeCycleDuration;

    public ExplainCardDensityControl() {
        this(0, 0, 3, null);
    }

    public static /* synthetic */ ExplainCardDensityControl copy$default(ExplainCardDensityControl r100, long r101, long r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.timeCycleDuration;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.exposureTimeThreshold;
    L9:
        return r100.copy(r101, r102);
    }

    public final long component1() {
        return this.timeCycleDuration;
    }

    public final long component2() {
        return this.exposureTimeThreshold;
    }

    public final ExplainCardDensityControl copy(long r100, long r101) {
        return new ExplainCardDensityControl(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof ExplainCardDensityControl) == false) goto L10;
        ExplainCardDensityControl r101 = (ExplainCardDensityControl) r100;
        if (this.timeCycleDuration == r101.timeCycleDuration) goto L8;
        return false;
    L8:
        if (this.exposureTimeThreshold == r101.exposureTimeThreshold) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public int hashCode() {
        long r100 = this.timeCycleDuration;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        long r102 = this.exposureTimeThreshold;
        return r101 + ((int) (r102 ^ (r102 >>> 32)));
    }

    public String toString() {
        return "ExplainCardDensityControl(timeCycleDuration=" + this.timeCycleDuration + ", exposureTimeThreshold=" + this.exposureTimeThreshold + ")";
    }

    public final long getExposureTimeThreshold() {
        return this.exposureTimeThreshold;
    }

    public final long getTimeCycleDuration() {
        return this.timeCycleDuration;
    }

    public ExplainCardDensityControl(long r100, long r101) {
        this.timeCycleDuration = r100;
        this.exposureTimeThreshold = r101;
    }

    public /* synthetic */ ExplainCardDensityControl(long r100, long r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = 0;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = 0;
    L8:
        this(r100, r101);
    }
}
