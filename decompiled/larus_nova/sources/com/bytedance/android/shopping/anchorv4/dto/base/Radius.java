package com.bytedance.android.shopping.anchorv4.dto.base;

import com.bytedance.android.livesdk.chatroom.event.VSUserProfileEvent;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J1\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/dto/base/Radius;", "Ljava/io/Serializable;", "topLeft", "", "topRight", "bottomRight", "bottomLeft", "(IIII)V", "getBottomLeft", "()I", "getBottomRight", "getTopLeft", "getTopRight", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "toString", "", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class Radius implements Serializable {

    @SerializedName("bottom_left")
    private final int bottomLeft;

    @SerializedName(VSUserProfileEvent.CLICK_POS_RIGHT)
    private final int bottomRight;

    @SerializedName("top_left")
    private final int topLeft;

    @SerializedName("top_right")
    private final int topRight;

    public Radius() {
        this(0, 0, 0, 0, 15, null);
    }

    public static /* synthetic */ Radius copy$default(Radius r100, int r101, int r102, int r103, int r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.topLeft;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.topRight;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.bottomRight;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.bottomLeft;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final int component1() {
        return this.topLeft;
    }

    public final int component2() {
        return this.topRight;
    }

    public final int component3() {
        return this.bottomRight;
    }

    public final int component4() {
        return this.bottomLeft;
    }

    public final Radius copy(int r100, int r101, int r102, int r103) {
        return new Radius(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof Radius) == false) goto L14;
        Radius r101 = (Radius) r100;
        if (this.topLeft == r101.topLeft) goto L8;
        return false;
    L8:
        if (this.topRight == r101.topRight) goto L10;
        return false;
    L10:
        if (this.bottomRight == r101.bottomRight) goto L12;
        return false;
    L12:
        if (this.bottomLeft == r101.bottomLeft) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public int hashCode() {
        return (((((this.topLeft * 31) + this.topRight) * 31) + this.bottomRight) * 31) + this.bottomLeft;
    }

    public String toString() {
        return "Radius(topLeft=" + this.topLeft + ", topRight=" + this.topRight + ", bottomRight=" + this.bottomRight + ", bottomLeft=" + this.bottomLeft + ")";
    }

    public final int getBottomLeft() {
        return this.bottomLeft;
    }

    public final int getBottomRight() {
        return this.bottomRight;
    }

    public final int getTopLeft() {
        return this.topLeft;
    }

    public final int getTopRight() {
        return this.topRight;
    }

    public Radius(int r100, int r101, int r102, int r103) {
        this.topLeft = r100;
        this.topRight = r101;
        this.bottomRight = r102;
        this.bottomLeft = r103;
    }

    public /* synthetic */ Radius(int r100, int r101, int r102, int r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = 0;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = 0;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = 0;
    L12:
        if ((r104 & 8) == 0) goto L14;
        r103 = 0;
    L14:
        this(r100, r101, r102, r103);
    }
}
