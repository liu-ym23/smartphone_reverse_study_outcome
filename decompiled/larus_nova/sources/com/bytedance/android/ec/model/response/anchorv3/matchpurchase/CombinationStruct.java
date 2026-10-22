package com.bytedance.android.ec.model.response.anchorv3.matchpurchase;

import com.bytedance.android.ec.core.event.a;
import com.bytedance.android.ec.model.ECUrlModel;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\u0002\u0010\tJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0011\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0003J3\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0005HÖ\u0001R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/ec/model/response/anchorv3/matchpurchase/CombinationStruct;", "Ljava/io/Serializable;", "image", "Lcom/bytedance/android/ec/model/ECUrlModel;", "combinationId", "", "imageHotAreas", "", "Lcom/bytedance/android/ec/model/response/anchorv3/matchpurchase/HotArea;", "(Lcom/bytedance/android/ec/model/ECUrlModel;Ljava/lang/String;Ljava/util/List;)V", "getCombinationId", "()Ljava/lang/String;", "getImage", "()Lcom/bytedance/android/ec/model/ECUrlModel;", "getImageHotAreas", "()Ljava/util/List;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class CombinationStruct implements Serializable {

    @SerializedName(a.KEY_COMBINATION_ID)
    private final String combinationId;

    @SerializedName("image")
    private final ECUrlModel image;

    @SerializedName("image_hot_area")
    private final List<HotArea> imageHotAreas;

    public CombinationStruct() {
        this(null, null, null, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CombinationStruct copy$default(CombinationStruct r100, ECUrlModel r101, String r102, List r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.image;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.combinationId;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.imageHotAreas;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final ECUrlModel component1() {
        return this.image;
    }

    public final String component2() {
        return this.combinationId;
    }

    public final List<HotArea> component3() {
        return this.imageHotAreas;
    }

    public final CombinationStruct copy(ECUrlModel r100, String r101, List<HotArea> r102) {
        return new CombinationStruct(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof CombinationStruct) == false) goto L12;
        CombinationStruct r101 = (CombinationStruct) r100;
        if (Intrinsics.areEqual(this.image, r101.image) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.combinationId, r101.combinationId) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.imageHotAreas, r101.imageHotAreas) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public int hashCode() {
        ECUrlModel r100 = this.image;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.combinationId;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        List<HotArea> r107 = this.imageHotAreas;
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
        return "CombinationStruct(image=" + this.image + ", combinationId=" + this.combinationId + ", imageHotAreas=" + this.imageHotAreas + ")";
    }

    public final String getCombinationId() {
        return this.combinationId;
    }

    public final ECUrlModel getImage() {
        return this.image;
    }

    public final List<HotArea> getImageHotAreas() {
        return this.imageHotAreas;
    }

    public CombinationStruct(ECUrlModel r100, String r101, List<HotArea> r102) {
        this.image = r100;
        this.combinationId = r101;
        this.imageHotAreas = r102;
    }

    public /* synthetic */ CombinationStruct(ECUrlModel r100, String r101, List r102, int r103, DefaultConstructorMarker r104) {
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
