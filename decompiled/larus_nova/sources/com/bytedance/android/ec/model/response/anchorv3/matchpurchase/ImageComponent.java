package com.bytedance.android.ec.model.response.anchorv3.matchpurchase;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J!\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/ec/model/response/anchorv3/matchpurchase/ImageComponent;", "Ljava/io/Serializable;", "combinationStruct", "Lcom/bytedance/android/ec/model/response/anchorv3/matchpurchase/CombinationStruct;", "combinationJump", "Lcom/bytedance/android/ec/model/response/anchorv3/matchpurchase/CombinationJumpStruct;", "(Lcom/bytedance/android/ec/model/response/anchorv3/matchpurchase/CombinationStruct;Lcom/bytedance/android/ec/model/response/anchorv3/matchpurchase/CombinationJumpStruct;)V", "getCombinationJump", "()Lcom/bytedance/android/ec/model/response/anchorv3/matchpurchase/CombinationJumpStruct;", "getCombinationStruct", "()Lcom/bytedance/android/ec/model/response/anchorv3/matchpurchase/CombinationStruct;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class ImageComponent implements Serializable {

    @SerializedName("combination_jump")
    private final CombinationJumpStruct combinationJump;

    @SerializedName("combination_struct")
    private final CombinationStruct combinationStruct;

    /* JADX WARN: Multi-variable type inference failed */
    public ImageComponent() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ ImageComponent copy$default(ImageComponent r100, CombinationStruct r101, CombinationJumpStruct r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.combinationStruct;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.combinationJump;
    L9:
        return r100.copy(r101, r102);
    }

    public final CombinationStruct component1() {
        return this.combinationStruct;
    }

    public final CombinationJumpStruct component2() {
        return this.combinationJump;
    }

    public final ImageComponent copy(CombinationStruct r100, CombinationJumpStruct r101) {
        return new ImageComponent(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof ImageComponent) == false) goto L10;
        ImageComponent r101 = (ImageComponent) r100;
        if (Intrinsics.areEqual(this.combinationStruct, r101.combinationStruct) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.combinationJump, r101.combinationJump) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public int hashCode() {
        CombinationStruct r100 = this.combinationStruct;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        CombinationJumpStruct r104 = this.combinationJump;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "ImageComponent(combinationStruct=" + this.combinationStruct + ", combinationJump=" + this.combinationJump + ")";
    }

    public final CombinationJumpStruct getCombinationJump() {
        return this.combinationJump;
    }

    public final CombinationStruct getCombinationStruct() {
        return this.combinationStruct;
    }

    public ImageComponent(CombinationStruct r100, CombinationJumpStruct r101) {
        this.combinationStruct = r100;
        this.combinationJump = r101;
    }

    public /* synthetic */ ImageComponent(CombinationStruct r100, CombinationJumpStruct r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this(r100, r101);
    }
}
