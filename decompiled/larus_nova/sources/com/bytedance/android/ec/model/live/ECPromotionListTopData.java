package com.bytedance.android.ec.model.live;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002B+\u0012\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0017\u0010\u0018J\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003J\u0011\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J-\u0010\n\u001a\u00020\u00002\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0001J\t\u0010\f\u001a\u00020\u000bHÖ\u0001J\t\u0010\u000e\u001a\u00020\rHÖ\u0001J\u0013\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÖ\u0003R\"\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\"\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0013\u001a\u0004\b\u0016\u0010\u0015¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/ec/model/live/ECPromotionListTopData;", "Lcom/bytedance/android/ec/model/g;", "Ljava/io/Serializable;", "", "Lcom/bytedance/android/ec/model/live/ECPromotionInterationData;", "getInteractionData", "component1", "component2", "interactionV1", "interactionV2", "copy", "", "toString", "", "hashCode", "", "other", "", "equals", "Ljava/util/List;", "getInteractionV1", "()Ljava/util/List;", "getInteractionV2", "<init>", "(Ljava/util/List;Ljava/util/List;)V", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class ECPromotionListTopData extends com.bytedance.android.ec.model.g implements Serializable {

    @SerializedName("interaction")
    private final List<ECPromotionInterationData> interactionV1;

    @SerializedName("list_top_interaction")
    private final List<ECPromotionInterationData> interactionV2;

    /* JADX WARN: Multi-variable type inference failed */
    public ECPromotionListTopData() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ECPromotionListTopData copy$default(ECPromotionListTopData r100, List r101, List r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.interactionV1;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.interactionV2;
    L9:
        return r100.copy(r101, r102);
    }

    public final List<ECPromotionInterationData> component1() {
        return this.interactionV1;
    }

    public final List<ECPromotionInterationData> component2() {
        return this.interactionV2;
    }

    public final ECPromotionListTopData copy(List<ECPromotionInterationData> r100, List<ECPromotionInterationData> r101) {
        return new ECPromotionListTopData(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof ECPromotionListTopData) == false) goto L10;
        ECPromotionListTopData r101 = (ECPromotionListTopData) r100;
        if (Intrinsics.areEqual(this.interactionV1, r101.interactionV1) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.interactionV2, r101.interactionV2) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public int hashCode() {
        List<ECPromotionInterationData> r100 = this.interactionV1;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        List<ECPromotionInterationData> r104 = this.interactionV2;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "ECPromotionListTopData(interactionV1=" + this.interactionV1 + ", interactionV2=" + this.interactionV2 + ")";
    }

    public final List<ECPromotionInterationData> getInteractionData() {
        return this.interactionV2;
    }

    public final List<ECPromotionInterationData> getInteractionV1() {
        return this.interactionV1;
    }

    public final List<ECPromotionInterationData> getInteractionV2() {
        return this.interactionV2;
    }

    public ECPromotionListTopData(List<ECPromotionInterationData> r100, List<ECPromotionInterationData> r101) {
        this.interactionV1 = r100;
        this.interactionV2 = r101;
    }

    public /* synthetic */ ECPromotionListTopData(List r100, List r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this(r100, r101);
    }
}
