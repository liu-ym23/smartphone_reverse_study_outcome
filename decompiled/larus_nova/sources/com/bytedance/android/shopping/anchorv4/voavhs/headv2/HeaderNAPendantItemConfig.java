package com.bytedance.android.shopping.anchorv4.voavhs.headv2;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\tJ2\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u0012J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/HeaderNAPendantItemConfig;", "Ljava/io/Serializable;", "selected", "Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/FontStyle;", "unselected", "innerSpace", "", "(Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/FontStyle;Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/FontStyle;Ljava/lang/Double;)V", "getInnerSpace", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getSelected", "()Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/FontStyle;", "getUnselected", "component1", "component2", "component3", "copy", "(Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/FontStyle;Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/FontStyle;Ljava/lang/Double;)Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/HeaderNAPendantItemConfig;", "equals", "", "other", "", "hashCode", "", "toString", "", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class HeaderNAPendantItemConfig implements Serializable {

    @SerializedName("inner_space")
    private final Double innerSpace;

    @SerializedName("selected")
    private final FontStyle selected;

    @SerializedName("unselected")
    private final FontStyle unselected;

    public HeaderNAPendantItemConfig() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ HeaderNAPendantItemConfig copy$default(HeaderNAPendantItemConfig r100, FontStyle r101, FontStyle r102, Double r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.selected;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.unselected;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.innerSpace;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final FontStyle component1() {
        return this.selected;
    }

    public final FontStyle component2() {
        return this.unselected;
    }

    public final Double component3() {
        return this.innerSpace;
    }

    public final HeaderNAPendantItemConfig copy(FontStyle r100, FontStyle r101, Double r102) {
        return new HeaderNAPendantItemConfig(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof HeaderNAPendantItemConfig) == false) goto L12;
        HeaderNAPendantItemConfig r101 = (HeaderNAPendantItemConfig) r100;
        if (Intrinsics.areEqual(this.selected, r101.selected) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.unselected, r101.unselected) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.innerSpace, r101.innerSpace) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public int hashCode() {
        FontStyle r100 = this.selected;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        FontStyle r104 = this.unselected;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        Double r107 = this.innerSpace;
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
        return "HeaderNAPendantItemConfig(selected=" + this.selected + ", unselected=" + this.unselected + ", innerSpace=" + this.innerSpace + ")";
    }

    public final Double getInnerSpace() {
        return this.innerSpace;
    }

    public final FontStyle getSelected() {
        return this.selected;
    }

    public final FontStyle getUnselected() {
        return this.unselected;
    }

    public HeaderNAPendantItemConfig(FontStyle r100, FontStyle r101, Double r102) {
        this.selected = r100;
        this.unselected = r101;
        this.innerSpace = r102;
    }

    public /* synthetic */ HeaderNAPendantItemConfig(FontStyle r100, FontStyle r101, Double r102, int r103, DefaultConstructorMarker r104) {
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
