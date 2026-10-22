package com.bytedance.android.livesdkapi.depend.model;

import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BS\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0003\u0018\u00010\t\u0012\u0016\b\u0002\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0003\u0018\u00010\t¢\u0006\u0002\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\u0017\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0003\u0018\u00010\tHÆ\u0003J\u0017\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0003\u0018\u00010\tHÆ\u0003J]\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00032\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0003\u0018\u00010\t2\u0016\b\u0002\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0003\u0018\u00010\tHÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001f\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0003\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u001f\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0003\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000f¨\u0006 "}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/OneStepRequestBody;", "", "extra", "", "amount_list", "", "", "cupon_info", "coupon_info_map", "", "pre_calc_info_map", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;)V", "getAmount_list", "()Ljava/util/List;", "getCoupon_info_map", "()Ljava/util/Map;", "getCupon_info", "()Ljava/lang/String;", "getExtra", "getPre_calc_info_map", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "revenue-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class OneStepRequestBody {
    private final List<Long> amount_list;
    private final Map<Long, String> coupon_info_map;
    private final String cupon_info;
    private final String extra;
    private final Map<Long, String> pre_calc_info_map;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ OneStepRequestBody copy$default(OneStepRequestBody r100, String r101, List r102, String r103, Map r104, Map r105, int r106, Object r110) {
        if ((r106 & 1) == 0) goto L6;
        r101 = r100.extra;
    L6:
        if ((r106 & 2) == 0) goto L8;
        r102 = r100.amount_list;
    L8:
        List r111 = r102;
        if ((r106 & 4) == 0) goto L11;
        r103 = r100.cupon_info;
    L11:
        String r107 = r103;
        if ((r106 & 8) == 0) goto L14;
        r104 = r100.coupon_info_map;
    L14:
        Map r108 = r104;
        if ((r106 & 16) == 0) goto L17;
        r105 = r100.pre_calc_info_map;
    L17:
        String r109 = r101;
        return r100.copy(r109, r111, r107, r108, r105);
    }

    public final String component1() {
        return this.extra;
    }

    public final List<Long> component2() {
        return this.amount_list;
    }

    public final String component3() {
        return this.cupon_info;
    }

    public final Map<Long, String> component4() {
        return this.coupon_info_map;
    }

    public final Map<Long, String> component5() {
        return this.pre_calc_info_map;
    }

    public final OneStepRequestBody copy(String r100, List<Long> r101, String r110, Map<Long, String> r111, Map<Long, String> r112) {
        Intrinsics.checkNotNullParameter(r100, "extra");
        Intrinsics.checkNotNullParameter(r101, "amount_list");
        Intrinsics.checkNotNullParameter(r110, "cupon_info");
        return new OneStepRequestBody(r100, r101, r110, r111, r112);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof OneStepRequestBody) == false) goto L16;
        OneStepRequestBody r101 = (OneStepRequestBody) r100;
        if (Intrinsics.areEqual(this.extra, r101.extra) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.amount_list, r101.amount_list) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.cupon_info, r101.cupon_info) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.coupon_info_map, r101.coupon_info_map) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.pre_calc_info_map, r101.pre_calc_info_map) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public int hashCode() {
        String r100 = this.extra;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        List<Long> r104 = this.amount_list;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.cupon_info;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        Map<Long, String> r110 = this.coupon_info_map;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        Map<Long, String> r113 = this.pre_calc_info_map;
        if (r113 == null) goto L22;
        r101 = r113.hashCode();
    L22:
        return r112 + r101;
    L17:
        r111 = 0;
        goto L18
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "OneStepRequestBody(extra=" + this.extra + ", amount_list=" + this.amount_list + ", cupon_info=" + this.cupon_info + ", coupon_info_map=" + this.coupon_info_map + ", pre_calc_info_map=" + this.pre_calc_info_map + ")";
    }

    public final List<Long> getAmount_list() {
        return this.amount_list;
    }

    public final Map<Long, String> getCoupon_info_map() {
        return this.coupon_info_map;
    }

    public final String getCupon_info() {
        return this.cupon_info;
    }

    public final String getExtra() {
        return this.extra;
    }

    public final Map<Long, String> getPre_calc_info_map() {
        return this.pre_calc_info_map;
    }

    public OneStepRequestBody(String r100, List<Long> r101, String r102, Map<Long, String> r103, Map<Long, String> r104) {
        Intrinsics.checkNotNullParameter(r100, "extra");
        Intrinsics.checkNotNullParameter(r101, "amount_list");
        Intrinsics.checkNotNullParameter(r102, "cupon_info");
        this.extra = r100;
        this.amount_list = r101;
        this.cupon_info = r102;
        this.coupon_info_map = r103;
        this.pre_calc_info_map = r104;
    }

    public /* synthetic */ OneStepRequestBody(String r100, List r101, String r110, Map r111, Map r112, int r113, DefaultConstructorMarker r114) {
        if ((r113 & 8) == 0) goto L5;
        Map r102 = null;
    L7:
        if ((r113 & 16) == 0) goto L9;
        Map r103 = null;
    L10:
        this(r100, r101, r110, r102, r103);
        return;
    L9:
        r103 = r112;
        goto L10
    L5:
        r102 = r111;
        goto L7
    }
}
