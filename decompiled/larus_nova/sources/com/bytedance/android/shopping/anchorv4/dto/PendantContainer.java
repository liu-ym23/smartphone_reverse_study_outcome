package com.bytedance.android.shopping.anchorv4.dto;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BU\u0012\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003\u0012\u0012\b\u0002\u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003\u0012\u0012\b\u0002\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003\u0012\u0012\b\u0002\u0010\u0007\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\bJ\u0013\u0010\u000e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003HÆ\u0003J\u0013\u0010\u000f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003HÆ\u0003J\u0013\u0010\u0010\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003HÆ\u0003J\u0013\u0010\u0011\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003HÆ\u0003JY\u0010\u0012\u001a\u00020\u00002\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00032\u0012\b\u0002\u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00032\u0012\b\u0002\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00032\u0012\b\u0002\u0010\u0007\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R \u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR \u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR \u0010\u0007\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR \u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/dto/PendantContainer;", "Ljava/io/Serializable;", "leftBottom", "", "Lcom/bytedance/android/shopping/anchorv4/dto/LynxElement;", "rightBottom", "topRight", "topLeft", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "getLeftBottom", "()Ljava/util/List;", "getRightBottom", "getTopLeft", "getTopRight", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PendantContainer implements Serializable {

    @SerializedName("left_bottom")
    private final List<LynxElement> leftBottom;

    @SerializedName("right_bottom")
    private final List<LynxElement> rightBottom;

    @SerializedName("top_left")
    private final List<LynxElement> topLeft;

    @SerializedName("top_right")
    private final List<LynxElement> topRight;

    public PendantContainer() {
        this(null, null, null, null, 15, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PendantContainer copy$default(PendantContainer r100, List r101, List r102, List r103, List r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.leftBottom;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.rightBottom;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.topRight;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.topLeft;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final List<LynxElement> component1() {
        return this.leftBottom;
    }

    public final List<LynxElement> component2() {
        return this.rightBottom;
    }

    public final List<LynxElement> component3() {
        return this.topRight;
    }

    public final List<LynxElement> component4() {
        return this.topLeft;
    }

    public final PendantContainer copy(List<LynxElement> r100, List<LynxElement> r101, List<LynxElement> r102, List<LynxElement> r103) {
        return new PendantContainer(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof PendantContainer) == false) goto L14;
        PendantContainer r101 = (PendantContainer) r100;
        if (Intrinsics.areEqual(this.leftBottom, r101.leftBottom) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.rightBottom, r101.rightBottom) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.topRight, r101.topRight) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.topLeft, r101.topLeft) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public int hashCode() {
        List<LynxElement> r100 = this.leftBottom;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        List<LynxElement> r104 = this.rightBottom;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        List<LynxElement> r107 = this.topRight;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        List<LynxElement> r110 = this.topLeft;
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
        return "PendantContainer(leftBottom=" + this.leftBottom + ", rightBottom=" + this.rightBottom + ", topRight=" + this.topRight + ", topLeft=" + this.topLeft + ")";
    }

    public final List<LynxElement> getLeftBottom() {
        return this.leftBottom;
    }

    public final List<LynxElement> getRightBottom() {
        return this.rightBottom;
    }

    public final List<LynxElement> getTopLeft() {
        return this.topLeft;
    }

    public final List<LynxElement> getTopRight() {
        return this.topRight;
    }

    public PendantContainer(List<LynxElement> r100, List<LynxElement> r101, List<LynxElement> r102, List<LynxElement> r103) {
        this.leftBottom = r100;
        this.rightBottom = r101;
        this.topRight = r102;
        this.topLeft = r103;
    }

    public /* synthetic */ PendantContainer(List r100, List r101, List r102, List r103, int r104, DefaultConstructorMarker r105) {
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
