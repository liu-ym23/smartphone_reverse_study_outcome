package com.bytedance.android.ec.model.sku;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001BA\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0003¢\u0006\u0002\u0010\nJ\u0011\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0011\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0003HÆ\u0003JE\u0010\u0015\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\tHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0004HÖ\u0001R\u001e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000e¨\u0006\u001c"}, d2 = {"Lcom/bytedance/android/ec/model/sku/GradientInfo;", "Ljava/io/Serializable;", "colors", "", "", "startPosition", "Lcom/bytedance/android/ec/model/sku/Position;", "endPosition", "locations", "", "(Ljava/util/List;Lcom/bytedance/android/ec/model/sku/Position;Lcom/bytedance/android/ec/model/sku/Position;Ljava/util/List;)V", "getColors", "()Ljava/util/List;", "getEndPosition", "()Lcom/bytedance/android/ec/model/sku/Position;", "getLocations", "getStartPosition", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "toString", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class GradientInfo implements Serializable {

    @SerializedName("colors")
    private final List<String> colors;

    @SerializedName("end_position")
    private final Position endPosition;

    @SerializedName("locations")
    private final List<Integer> locations;

    @SerializedName("start_position")
    private final Position startPosition;

    public GradientInfo() {
        this(null, null, null, null, 15, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ GradientInfo copy$default(GradientInfo r100, List r101, Position r102, Position r103, List r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.colors;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.startPosition;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.endPosition;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.locations;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final List<String> component1() {
        return this.colors;
    }

    public final Position component2() {
        return this.startPosition;
    }

    public final Position component3() {
        return this.endPosition;
    }

    public final List<Integer> component4() {
        return this.locations;
    }

    public final GradientInfo copy(List<String> r100, Position r101, Position r102, List<Integer> r103) {
        return new GradientInfo(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof GradientInfo) == false) goto L14;
        GradientInfo r101 = (GradientInfo) r100;
        if (Intrinsics.areEqual(this.colors, r101.colors) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.startPosition, r101.startPosition) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.endPosition, r101.endPosition) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.locations, r101.locations) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public int hashCode() {
        List<String> r100 = this.colors;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Position r104 = this.startPosition;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        Position r107 = this.endPosition;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        List<Integer> r110 = this.locations;
        if (r110 == null) goto L18;
        r101 = r110.hashCode();
    L18:
        return r109 + r101;
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

    public String toString() {
        return "GradientInfo(colors=" + this.colors + ", startPosition=" + this.startPosition + ", endPosition=" + this.endPosition + ", locations=" + this.locations + ")";
    }

    public final List<String> getColors() {
        return this.colors;
    }

    public final Position getEndPosition() {
        return this.endPosition;
    }

    public final List<Integer> getLocations() {
        return this.locations;
    }

    public final Position getStartPosition() {
        return this.startPosition;
    }

    public GradientInfo(List<String> r100, Position r101, Position r102, List<Integer> r103) {
        this.colors = r100;
        this.startPosition = r101;
        this.endPosition = r102;
        this.locations = r103;
    }

    public /* synthetic */ GradientInfo(List r100, Position r101, Position r102, List r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = null;
    L12:
        if ((r104 & 8) == 0) goto L14;
        r103 = null;
    L14:
        this(r100, r101, r102, r103);
    }
}
