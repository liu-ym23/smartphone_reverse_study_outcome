package com.bytedance.android.shopping.anchorv4.voavhs.car;

import com.bytedance.android.shopping.anchorv4.dto.components.LongContentLabelComponent;
import com.bytedance.android.shopping.anchorv4.dto.elements.TextElement;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\bJ\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0003J9\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001c"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/car/AnchorV4CarAddressDisplay;", "Ljava/io/Serializable;", "carTitle", "Lcom/bytedance/android/shopping/anchorv4/dto/components/LongContentLabelComponent;", "carAddress", "Lcom/bytedance/android/shopping/anchorv4/dto/elements/TextElement;", "carDistance", "carAddressDetail", "(Lcom/bytedance/android/shopping/anchorv4/dto/components/LongContentLabelComponent;Lcom/bytedance/android/shopping/anchorv4/dto/elements/TextElement;Lcom/bytedance/android/shopping/anchorv4/dto/elements/TextElement;Lcom/bytedance/android/shopping/anchorv4/dto/elements/TextElement;)V", "getCarAddress", "()Lcom/bytedance/android/shopping/anchorv4/dto/elements/TextElement;", "getCarAddressDetail", "getCarDistance", "getCarTitle", "()Lcom/bytedance/android/shopping/anchorv4/dto/components/LongContentLabelComponent;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorV4CarAddressDisplay implements Serializable {

    @SerializedName("car_address")
    private final TextElement carAddress;

    @SerializedName("car_address_detail")
    private final TextElement carAddressDetail;

    @SerializedName("car_distance")
    private final TextElement carDistance;

    @SerializedName("car_title")
    private final LongContentLabelComponent carTitle;

    public AnchorV4CarAddressDisplay() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ AnchorV4CarAddressDisplay copy$default(AnchorV4CarAddressDisplay r100, LongContentLabelComponent r101, TextElement r102, TextElement r103, TextElement r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.carTitle;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.carAddress;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.carDistance;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.carAddressDetail;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final LongContentLabelComponent component1() {
        return this.carTitle;
    }

    public final TextElement component2() {
        return this.carAddress;
    }

    public final TextElement component3() {
        return this.carDistance;
    }

    public final TextElement component4() {
        return this.carAddressDetail;
    }

    public final AnchorV4CarAddressDisplay copy(LongContentLabelComponent r100, TextElement r101, TextElement r102, TextElement r103) {
        return new AnchorV4CarAddressDisplay(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof AnchorV4CarAddressDisplay) == false) goto L14;
        AnchorV4CarAddressDisplay r101 = (AnchorV4CarAddressDisplay) r100;
        if (Intrinsics.areEqual(this.carTitle, r101.carTitle) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.carAddress, r101.carAddress) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.carDistance, r101.carDistance) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.carAddressDetail, r101.carAddressDetail) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public int hashCode() {
        LongContentLabelComponent r100 = this.carTitle;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        TextElement r104 = this.carAddress;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        TextElement r107 = this.carDistance;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        TextElement r110 = this.carAddressDetail;
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
        return "AnchorV4CarAddressDisplay(carTitle=" + this.carTitle + ", carAddress=" + this.carAddress + ", carDistance=" + this.carDistance + ", carAddressDetail=" + this.carAddressDetail + ")";
    }

    public final TextElement getCarAddress() {
        return this.carAddress;
    }

    public final TextElement getCarAddressDetail() {
        return this.carAddressDetail;
    }

    public final TextElement getCarDistance() {
        return this.carDistance;
    }

    public final LongContentLabelComponent getCarTitle() {
        return this.carTitle;
    }

    public AnchorV4CarAddressDisplay(LongContentLabelComponent r100, TextElement r101, TextElement r102, TextElement r103) {
        this.carTitle = r100;
        this.carAddress = r101;
        this.carDistance = r102;
        this.carAddressDetail = r103;
    }

    public /* synthetic */ AnchorV4CarAddressDisplay(LongContentLabelComponent r100, TextElement r101, TextElement r102, TextElement r103, int r104, DefaultConstructorMarker r105) {
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
