package com.bytedance.android.ec.model.sku;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0006HÆ\u0003J2\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u0012J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0006HÖ\u0001R\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\u000b\u0010\tR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/ec/model/sku/HighLightItem;", "Ljava/io/Serializable;", "colorStartIndex", "", "colorEndIndex", "highLightColor", "", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;)V", "getColorEndIndex", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getColorStartIndex", "getHighLightColor", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;)Lcom/bytedance/android/ec/model/sku/HighLightItem;", "equals", "", "other", "", "hashCode", "toString", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class HighLightItem implements Serializable {

    @SerializedName("end_index")
    private final Integer colorEndIndex;

    @SerializedName("start_index")
    private final Integer colorStartIndex;

    @SerializedName("high_light_color")
    private final String highLightColor;

    public HighLightItem() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ HighLightItem copy$default(HighLightItem r100, Integer r101, Integer r102, String r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.colorStartIndex;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.colorEndIndex;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.highLightColor;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final Integer component1() {
        return this.colorStartIndex;
    }

    public final Integer component2() {
        return this.colorEndIndex;
    }

    public final String component3() {
        return this.highLightColor;
    }

    public final HighLightItem copy(Integer r100, Integer r101, String r102) {
        return new HighLightItem(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof HighLightItem) == false) goto L12;
        HighLightItem r101 = (HighLightItem) r100;
        if (Intrinsics.areEqual(this.colorStartIndex, r101.colorStartIndex) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.colorEndIndex, r101.colorEndIndex) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.highLightColor, r101.highLightColor) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public int hashCode() {
        Integer r100 = this.colorStartIndex;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Integer r104 = this.colorEndIndex;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.highLightColor;
        if (r107 == null) goto L14;
        r101 = r107.hashCode();
    L14:
        return r106 + r101;
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "HighLightItem(colorStartIndex=" + this.colorStartIndex + ", colorEndIndex=" + this.colorEndIndex + ", highLightColor=" + this.highLightColor + ")";
    }

    public final Integer getColorEndIndex() {
        return this.colorEndIndex;
    }

    public final Integer getColorStartIndex() {
        return this.colorStartIndex;
    }

    public final String getHighLightColor() {
        return this.highLightColor;
    }

    public HighLightItem(Integer r100, Integer r101, String r102) {
        this.colorStartIndex = r100;
        this.colorEndIndex = r101;
        this.highLightColor = r102;
    }

    public /* synthetic */ HighLightItem(Integer r100, Integer r101, String r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = null;
    L11:
        this(r100, r101, r102);
    }
}
