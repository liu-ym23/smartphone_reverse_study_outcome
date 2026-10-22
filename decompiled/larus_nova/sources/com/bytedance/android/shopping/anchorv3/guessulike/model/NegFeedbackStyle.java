package com.bytedance.android.shopping.anchorv3.guessulike.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u0011\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\tJ,\u0010\u000f\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u0010J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0006HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u0019\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/shopping/anchorv3/guessulike/model/NegFeedbackStyle;", "Ljava/io/Serializable;", "items", "", "Lcom/bytedance/android/shopping/anchorv3/guessulike/model/FeedbackItem;", "firstPageLimit", "", "(Ljava/util/List;Ljava/lang/Integer;)V", "getFirstPageLimit", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getItems", "()Ljava/util/List;", "component1", "component2", "copy", "(Ljava/util/List;Ljava/lang/Integer;)Lcom/bytedance/android/shopping/anchorv3/guessulike/model/NegFeedbackStyle;", "equals", "", "other", "", "hashCode", "toString", "", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class NegFeedbackStyle implements Serializable {

    @SerializedName("first_page_limit")
    private final Integer firstPageLimit;
    private final List<FeedbackItem> items;

    /* JADX WARN: Multi-variable type inference failed */
    public NegFeedbackStyle() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ NegFeedbackStyle copy$default(NegFeedbackStyle r100, List r101, Integer r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.items;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.firstPageLimit;
    L9:
        return r100.copy(r101, r102);
    }

    public final List<FeedbackItem> component1() {
        return this.items;
    }

    public final Integer component2() {
        return this.firstPageLimit;
    }

    public final NegFeedbackStyle copy(List<FeedbackItem> r100, Integer r101) {
        return new NegFeedbackStyle(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof NegFeedbackStyle) == false) goto L10;
        NegFeedbackStyle r101 = (NegFeedbackStyle) r100;
        if (Intrinsics.areEqual(this.items, r101.items) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.firstPageLimit, r101.firstPageLimit) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public int hashCode() {
        List<FeedbackItem> r100 = this.items;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Integer r104 = this.firstPageLimit;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "NegFeedbackStyle(items=" + this.items + ", firstPageLimit=" + this.firstPageLimit + ")";
    }

    public final Integer getFirstPageLimit() {
        return this.firstPageLimit;
    }

    public final List<FeedbackItem> getItems() {
        return this.items;
    }

    public NegFeedbackStyle(List<FeedbackItem> r100, Integer r101) {
        this.items = r100;
        this.firstPageLimit = r101;
    }

    public /* synthetic */ NegFeedbackStyle(List r100, Integer r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this(r100, r101);
    }
}
