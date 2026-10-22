package com.bytedance.android.ec.model.sku;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\nJ.\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u0014J\u0013\u0010\u0015\u001a\u00020\u00072\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0005HÖ\u0001R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/ec/model/sku/SkuStateAddCartGuideInfo;", "Ljava/io/Serializable;", "guideType", "", "hintText", "", "canAddCart", "", "(ILjava/lang/String;Ljava/lang/Boolean;)V", "getCanAddCart", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getGuideType", "()I", "getHintText", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "(ILjava/lang/String;Ljava/lang/Boolean;)Lcom/bytedance/android/ec/model/sku/SkuStateAddCartGuideInfo;", "equals", "other", "", "hashCode", "toString", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class SkuStateAddCartGuideInfo implements Serializable {
    private final Boolean canAddCart;
    private final int guideType;
    private final String hintText;

    public static /* synthetic */ SkuStateAddCartGuideInfo copy$default(SkuStateAddCartGuideInfo r100, int r101, String r102, Boolean r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.guideType;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.hintText;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.canAddCart;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final int component1() {
        return this.guideType;
    }

    public final String component2() {
        return this.hintText;
    }

    public final Boolean component3() {
        return this.canAddCart;
    }

    public final SkuStateAddCartGuideInfo copy(int r100, String r101, Boolean r102) {
        Intrinsics.checkNotNullParameter(r101, "hintText");
        return new SkuStateAddCartGuideInfo(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof SkuStateAddCartGuideInfo) == false) goto L12;
        SkuStateAddCartGuideInfo r101 = (SkuStateAddCartGuideInfo) r100;
        if (this.guideType == r101.guideType) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.hintText, r101.hintText) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.canAddCart, r101.canAddCart) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public int hashCode() {
        int r100 = this.guideType * 31;
        String r101 = this.hintText;
        int r102 = 0;
        if (r101 == null) goto L5;
        int r103 = r101.hashCode();
    L6:
        int r104 = (r100 + r103) * 31;
        Boolean r105 = this.canAddCart;
        if (r105 == null) goto L10;
        r102 = r105.hashCode();
    L10:
        return r104 + r102;
    L5:
        r103 = 0;
        goto L6
    }

    public String toString() {
        return "SkuStateAddCartGuideInfo(guideType=" + this.guideType + ", hintText=" + this.hintText + ", canAddCart=" + this.canAddCart + ")";
    }

    public final Boolean getCanAddCart() {
        return this.canAddCart;
    }

    public final int getGuideType() {
        return this.guideType;
    }

    public final String getHintText() {
        return this.hintText;
    }

    public SkuStateAddCartGuideInfo(int r100, String r101, Boolean r102) {
        Intrinsics.checkNotNullParameter(r101, "hintText");
        this.guideType = r100;
        this.hintText = r101;
        this.canAddCart = r102;
    }

    public /* synthetic */ SkuStateAddCartGuideInfo(int r100, String r101, Boolean r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 4) == 0) goto L5;
        r102 = null;
    L5:
        this(r100, r101, r102);
    }
}
