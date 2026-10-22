package br6;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006¨\u0006\t"}, d2 = {"Lbr6/d;", "", "", "dayRange", "I", "getDayRange", "()I", "guideTimes", "getGuideTimes", "locallife-groupon-api_release"}, k = 1, mv = {1, 4, 3})
public final class d {

    @SerializedName("day_range")
    private final int dayRange;

    @SerializedName("guide_times")
    private final int guideTimes;

    public d() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L8;
        return false;
    L8:
        d r101 = (d) r100;
        if (this.dayRange == r101.dayRange) goto L12;
        return false;
    L12:
        if (this.guideTimes == r101.guideTimes) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.dayRange * 31) + this.guideTimes;
    }

    public final String toString() {
        return "SwitchGuideFrequency(dayRange=" + this.dayRange + ", guideTimes=" + this.guideTimes + ')';
    }

    public d(int r100) {
        this.dayRange = 0;
        this.guideTimes = 0;
    }
}
