package com.bytedance.android.ec.model.promotion;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u0017\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u000bJ:\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010\u0019J\u0013\u0010\u001a\u001a\u00020\u00032\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\bHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0005HÖ\u0001R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000e¨\u0006\u001f"}, d2 = {"Lcom/bytedance/android/ec/model/promotion/ECUIPromotionLiveListConfig;", "Ljava/io/Serializable;", "shouldShowFindSimilar", "", "similarLabel", "", "similarNewDesign", "addCartOpt", "", "(ZLjava/lang/String;ZLjava/lang/Integer;)V", "getAddCartOpt", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getShouldShowFindSimilar", "()Z", "setShouldShowFindSimilar", "(Z)V", "getSimilarLabel", "()Ljava/lang/String;", "getSimilarNewDesign", "component1", "component2", "component3", "component4", "copy", "(ZLjava/lang/String;ZLjava/lang/Integer;)Lcom/bytedance/android/ec/model/promotion/ECUIPromotionLiveListConfig;", "equals", "other", "", "hashCode", "toString", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class ECUIPromotionLiveListConfig implements Serializable {
    private final Integer addCartOpt;
    private boolean shouldShowFindSimilar;
    private final String similarLabel;
    private final boolean similarNewDesign;

    public static /* synthetic */ ECUIPromotionLiveListConfig copy$default(ECUIPromotionLiveListConfig r100, boolean r101, String r102, boolean r103, Integer r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.shouldShowFindSimilar;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.similarLabel;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.similarNewDesign;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.addCartOpt;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final boolean component1() {
        return this.shouldShowFindSimilar;
    }

    public final String component2() {
        return this.similarLabel;
    }

    public final boolean component3() {
        return this.similarNewDesign;
    }

    public final Integer component4() {
        return this.addCartOpt;
    }

    public final ECUIPromotionLiveListConfig copy(boolean r100, String r101, boolean r102, Integer r103) {
        return new ECUIPromotionLiveListConfig(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof ECUIPromotionLiveListConfig) == false) goto L14;
        ECUIPromotionLiveListConfig r101 = (ECUIPromotionLiveListConfig) r100;
        if (this.shouldShowFindSimilar == r101.shouldShowFindSimilar) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.similarLabel, r101.similarLabel) == true) goto L10;
        return false;
    L10:
        if (this.similarNewDesign == r101.similarNewDesign) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.addCartOpt, r101.addCartOpt) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3 */
    public int hashCode() {
        boolean r100 = this.shouldShowFindSimilar;
        ?? r101 = 1;
        ?? r102 = r100;
        if (r100 == false) goto L5;
        r102 = 1;
    L5:
        int r103 = r102 * 31;
        String r104 = this.similarLabel;
        int r105 = 0;
        if (r104 == null) goto L8;
        int r106 = r104.hashCode();
    L9:
        int r107 = (r103 + r106) * 31;
        boolean r108 = this.similarNewDesign;
        if (r108 == true) goto L13;
        r101 = r108;
    L13:
        int r109 = (r107 + r101) * 31;
        Integer r110 = this.addCartOpt;
        if (r110 == null) goto L17;
        r105 = r110.hashCode();
    L17:
        return r109 + r105;
    L8:
        r106 = 0;
        goto L9
    }

    public String toString() {
        return "ECUIPromotionLiveListConfig(shouldShowFindSimilar=" + this.shouldShowFindSimilar + ", similarLabel=" + this.similarLabel + ", similarNewDesign=" + this.similarNewDesign + ", addCartOpt=" + this.addCartOpt + ")";
    }

    public final Integer getAddCartOpt() {
        return this.addCartOpt;
    }

    public final boolean getShouldShowFindSimilar() {
        return this.shouldShowFindSimilar;
    }

    public final String getSimilarLabel() {
        return this.similarLabel;
    }

    public final boolean getSimilarNewDesign() {
        return this.similarNewDesign;
    }

    public final void setShouldShowFindSimilar(boolean r100) {
        this.shouldShowFindSimilar = r100;
    }

    public ECUIPromotionLiveListConfig(boolean r100, String r101, boolean r102, Integer r103) {
        this.shouldShowFindSimilar = r100;
        this.similarLabel = r101;
        this.similarNewDesign = r102;
        this.addCartOpt = r103;
    }

    public /* synthetic */ ECUIPromotionLiveListConfig(boolean r100, String r101, boolean r102, Integer r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 4) == 0) goto L5;
        r102 = false;
    L5:
        this(r100, r101, r102, r103);
    }
}
