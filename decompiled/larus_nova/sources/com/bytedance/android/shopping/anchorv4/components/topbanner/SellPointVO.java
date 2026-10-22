package com.bytedance.android.shopping.anchorv4.components.topbanner;

import com.bytedance.android.ec.model.ECUrlModel;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J+\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0007HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0005HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/components/topbanner/SellPointVO;", "Ljava/io/Serializable;", "icon", "Lcom/bytedance/android/ec/model/ECUrlModel;", "title", "", "rightDistance", "", "(Lcom/bytedance/android/ec/model/ECUrlModel;Ljava/lang/String;I)V", "getIcon", "()Lcom/bytedance/android/ec/model/ECUrlModel;", "getRightDistance", "()I", "getTitle", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "toString", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SellPointVO implements Serializable {

    @SerializedName("icon")
    private final ECUrlModel icon;

    @SerializedName("right_distance")
    private final int rightDistance;

    @SerializedName("title")
    private final String title;

    public SellPointVO() {
        this(null, null, 0, 7, null);
    }

    public static /* synthetic */ SellPointVO copy$default(SellPointVO r100, ECUrlModel r101, String r102, int r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.icon;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.title;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.rightDistance;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final ECUrlModel component1() {
        return this.icon;
    }

    public final String component2() {
        return this.title;
    }

    public final int component3() {
        return this.rightDistance;
    }

    public final SellPointVO copy(ECUrlModel r100, String r101, int r102) {
        return new SellPointVO(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof SellPointVO) == false) goto L12;
        SellPointVO r101 = (SellPointVO) r100;
        if (Intrinsics.areEqual(this.icon, r101.icon) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.title, r101.title) == true) goto L10;
        return false;
    L10:
        if (this.rightDistance == r101.rightDistance) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public int hashCode() {
        ECUrlModel r100 = this.icon;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.title;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return ((r103 + r101) * 31) + this.rightDistance;
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "SellPointVO(icon=" + this.icon + ", title=" + this.title + ", rightDistance=" + this.rightDistance + ")";
    }

    public final ECUrlModel getIcon() {
        return this.icon;
    }

    public final int getRightDistance() {
        return this.rightDistance;
    }

    public final String getTitle() {
        return this.title;
    }

    public SellPointVO(ECUrlModel r100, String r101, int r102) {
        this.icon = r100;
        this.title = r101;
        this.rightDistance = r102;
    }

    public /* synthetic */ SellPointVO(ECUrlModel r100, String r101, int r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = 0;
    L11:
        this(r100, r101, r102);
    }
}
