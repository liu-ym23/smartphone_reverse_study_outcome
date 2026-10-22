package com.bytedance.android.shopping.anchorv4.voavhs.deletedproducttip;

import com.bytedance.android.shopping.anchorv4.dto.elements.TextWithOneIconElement;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/deletedproducttip/AnchorV4DeletedProductTipDisplay;", "Ljava/io/Serializable;", "deletedTip", "Lcom/bytedance/android/shopping/anchorv4/dto/elements/TextWithOneIconElement;", "(Lcom/bytedance/android/shopping/anchorv4/dto/elements/TextWithOneIconElement;)V", "getDeletedTip", "()Lcom/bytedance/android/shopping/anchorv4/dto/elements/TextWithOneIconElement;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorV4DeletedProductTipDisplay implements Serializable {

    @SerializedName("deleted_tip")
    private final TextWithOneIconElement deletedTip;

    /* JADX WARN: Multi-variable type inference failed */
    public AnchorV4DeletedProductTipDisplay() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ AnchorV4DeletedProductTipDisplay copy$default(AnchorV4DeletedProductTipDisplay r100, TextWithOneIconElement r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = r100.deletedTip;
    L6:
        return r100.copy(r101);
    }

    public final TextWithOneIconElement component1() {
        return this.deletedTip;
    }

    public final AnchorV4DeletedProductTipDisplay copy(TextWithOneIconElement r100) {
        return new AnchorV4DeletedProductTipDisplay(r100);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof AnchorV4DeletedProductTipDisplay) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.deletedTip, ((AnchorV4DeletedProductTipDisplay) r100).deletedTip) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public int hashCode() {
        TextWithOneIconElement r100 = this.deletedTip;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.hashCode();
    }

    public String toString() {
        return "AnchorV4DeletedProductTipDisplay(deletedTip=" + this.deletedTip + ")";
    }

    public final TextWithOneIconElement getDeletedTip() {
        return this.deletedTip;
    }

    public AnchorV4DeletedProductTipDisplay(TextWithOneIconElement r100) {
        this.deletedTip = r100;
    }

    public /* synthetic */ AnchorV4DeletedProductTipDisplay(TextWithOneIconElement r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = null;
    L5:
        this(r100);
    }
}
