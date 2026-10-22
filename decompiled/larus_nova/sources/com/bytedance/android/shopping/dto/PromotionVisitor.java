package com.bytedance.android.shopping.dto;

import com.bytedance.android.ec.model.ECUrlModel;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u000f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0006HÆ\u0003J#\u0010\u0012\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R$\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001e\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/shopping/dto/PromotionVisitor;", "Ljava/io/Serializable;", "avatars", "", "Lcom/bytedance/android/ec/model/ECUrlModel;", "count", "", "(Ljava/util/List;J)V", "getAvatars", "()Ljava/util/List;", "setAvatars", "(Ljava/util/List;)V", "getCount", "()J", "setCount", "(J)V", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PromotionVisitor implements Serializable {

    @SerializedName("avatar")
    private List<? extends ECUrlModel> avatars;

    @SerializedName("count")
    private long count;

    public PromotionVisitor() {
        this(null, 0, 3, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PromotionVisitor copy$default(PromotionVisitor r100, List r101, long r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.avatars;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.count;
    L9:
        return r100.copy(r101, r102);
    }

    public final List<ECUrlModel> component1() {
        return this.avatars;
    }

    public final long component2() {
        return this.count;
    }

    public final PromotionVisitor copy(List<? extends ECUrlModel> r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, "avatars");
        return new PromotionVisitor(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof PromotionVisitor) == false) goto L10;
        PromotionVisitor r101 = (PromotionVisitor) r100;
        if (Intrinsics.areEqual(this.avatars, r101.avatars) == true) goto L8;
        return false;
    L8:
        if (this.count == r101.count) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public int hashCode() {
        List<? extends ECUrlModel> r100 = this.avatars;
        if (r100 == null) goto L5;
        int r101 = r100.hashCode();
    L6:
        long r102 = this.count;
        return (r101 * 31) + ((int) (r102 ^ (r102 >>> 32)));
    L5:
        r101 = 0;
        goto L6
    }

    public String toString() {
        return "PromotionVisitor(avatars=" + this.avatars + ", count=" + this.count + ")";
    }

    public final List<ECUrlModel> getAvatars() {
        return this.avatars;
    }

    public final long getCount() {
        return this.count;
    }

    public final void setAvatars(List<? extends ECUrlModel> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.avatars = r100;
    }

    public final void setCount(long r100) {
        this.count = r100;
    }

    public PromotionVisitor(List<? extends ECUrlModel> r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, "avatars");
        this.avatars = r100;
        this.count = r101;
    }

    public /* synthetic */ PromotionVisitor(List r100, long r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = CollectionsKt.emptyList();
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = 0;
    L8:
        this(r100, r101);
    }
}
