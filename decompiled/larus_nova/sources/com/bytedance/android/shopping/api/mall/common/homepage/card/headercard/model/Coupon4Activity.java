package com.bytedance.android.shopping.api.mall.common.homepage.card.headercard.model;

import com.google.gson.annotations.SerializedName;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B5\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0016\b\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\u0002\u0010\tJ\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0010J\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u0017\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0003J>\u0010\u0015\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0016\b\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u0016J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001b\u001a\u00020\bHÖ\u0001R\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR$\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001c"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/Coupon4Activity;", "", "id", "", "amount", "", "extra", "", "", "(Ljava/lang/Long;Ljava/lang/Integer;Ljava/util/Map;)V", "getAmount", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getExtra", "()Ljava/util/Map;", "getId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "component1", "component2", "component3", "copy", "(Ljava/lang/Long;Ljava/lang/Integer;Ljava/util/Map;)Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/Coupon4Activity;", "equals", "", "other", "hashCode", "toString", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class Coupon4Activity {

    @SerializedName("amount")
    private final Integer amount;

    @SerializedName("extra")
    private final Map<String, String> extra;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @SerializedName("id")
    private final Long f170332id;

    public Coupon4Activity() {
        this(null, null, null, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Coupon4Activity copy$default(Coupon4Activity r100, Long r101, Integer r102, Map r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.f170332id;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.amount;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.extra;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final Long component1() {
        return this.f170332id;
    }

    public final Integer component2() {
        return this.amount;
    }

    public final Map<String, String> component3() {
        return this.extra;
    }

    public final Coupon4Activity copy(Long r100, Integer r101, Map<String, String> r102) {
        return new Coupon4Activity(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof Coupon4Activity) == false) goto L12;
        Coupon4Activity r101 = (Coupon4Activity) r100;
        if (Intrinsics.areEqual(this.f170332id, r101.f170332id) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.amount, r101.amount) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.extra, r101.extra) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public int hashCode() {
        Long r100 = this.f170332id;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Integer r104 = this.amount;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        Map<String, String> r107 = this.extra;
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
        return "Coupon4Activity(id=" + this.f170332id + ", amount=" + this.amount + ", extra=" + this.extra + ")";
    }

    public final Integer getAmount() {
        return this.amount;
    }

    public final Map<String, String> getExtra() {
        return this.extra;
    }

    public final Long getId() {
        return this.f170332id;
    }

    public Coupon4Activity(Long r100, Integer r101, Map<String, String> r102) {
        this.f170332id = r100;
        this.amount = r101;
        this.extra = r102;
    }

    public /* synthetic */ Coupon4Activity(Long r100, Integer r101, Map r102, int r103, DefaultConstructorMarker r104) {
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
