package com.bytedance.android.window.shop.repository.dto;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001:\u0003\u0006\b\tR\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/bytedance/android/window/shop/repository/dto/q;", "", "", "Lcom/bytedance/android/window/shop/repository/dto/q$c;", "couponList", "Ljava/util/List;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/util/List;", "b", "c", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class q {

    @SerializedName("coupon_list")
    private final List<c> couponList;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/window/shop/repository/dto/q$a;", "", "", "detailPrefix", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "detailDesc", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "detailSuffix", "c", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class a {

        @SerializedName("detail_desc")
        private final String detailDesc;

        @SerializedName("detail_prefix")
        private final String detailPrefix;

        @SerializedName("detail_suffix")
        private final String detailSuffix;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof a) == false) goto L12;
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.detailPrefix, r101.detailPrefix) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.detailDesc, r101.detailDesc) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.detailSuffix, r101.detailSuffix) == true) goto L19;
            return false;
        L19:
            return true;
        L12:
            return false;
        }

        public final int hashCode() {
            String r100 = this.detailPrefix;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = r102 * 31;
            String r104 = this.detailDesc;
            if (r104 == null) goto L9;
            int r105 = r104.hashCode();
        L10:
            int r106 = (r103 + r105) * 31;
            String r107 = this.detailSuffix;
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

        public final String toString() {
            return "WindowCouponCollectDesc(detailPrefix=" + this.detailPrefix + ", detailDesc=" + this.detailDesc + ", detailSuffix=" + this.detailSuffix + ")";
        }

        public a() {
            this.detailPrefix = null;
            this.detailDesc = null;
            this.detailSuffix = null;
        }

        public final String a() {
            return this.detailDesc;
        }

        public final String b() {
            return this.detailPrefix;
        }

        public final String c() {
            return this.detailSuffix;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006¨\u0006\r"}, d2 = {"Lcom/bytedance/android/window/shop/repository/dto/q$b;", "", "", "discountPrefix", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "discountDesc", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "discountSuffix", "d", "discountExtraDesc", "b", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class b {

        @SerializedName("discount_desc")
        private final String discountDesc;

        @SerializedName("discount_extra_desc")
        private final String discountExtraDesc;

        @SerializedName("discount_prefix")
        private final String discountPrefix;

        @SerializedName("discount_suffix")
        private final String discountSuffix;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof b) == false) goto L14;
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.discountPrefix, r101.discountPrefix) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.discountDesc, r101.discountDesc) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.discountSuffix, r101.discountSuffix) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.discountExtraDesc, r101.discountExtraDesc) == true) goto L22;
            return false;
        L22:
            return true;
        L14:
            return false;
        }

        public final int hashCode() {
            String r100 = this.discountPrefix;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = r102 * 31;
            String r104 = this.discountDesc;
            if (r104 == null) goto L9;
            int r105 = r104.hashCode();
        L10:
            int r106 = (r103 + r105) * 31;
            String r107 = this.discountSuffix;
            if (r107 == null) goto L13;
            int r108 = r107.hashCode();
        L14:
            int r109 = (r106 + r108) * 31;
            String r110 = this.discountExtraDesc;
            if (r110 == null) goto L18;
            r101 = r110.hashCode();
        L18:
            return r109 + r101;
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

        public final String toString() {
            return "WindowCouponCollectDiscountDesc(discountPrefix=" + this.discountPrefix + ", discountDesc=" + this.discountDesc + ", discountSuffix=" + this.discountSuffix + ", discountExtraDesc=" + this.discountExtraDesc + ")";
        }

        public b() {
            this.discountPrefix = null;
            this.discountDesc = null;
            this.discountSuffix = null;
            this.discountExtraDesc = null;
        }

        public final String a() {
            return this.discountDesc;
        }

        public final String b() {
            return this.discountExtraDesc;
        }

        public final String c() {
            return this.discountPrefix;
        }

        public final String d() {
            return this.discountSuffix;
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\r\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u000e\u001a\u0004\b\u0012\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/window/shop/repository/dto/q$c;", "", "Lcom/bytedance/android/window/shop/repository/dto/q$a;", "description", "Lcom/bytedance/android/window/shop/repository/dto/q$a;", "b", "()Lcom/bytedance/android/window/shop/repository/dto/q$a;", "Lcom/bytedance/android/window/shop/repository/dto/q$b;", "discountDesc", "Lcom/bytedance/android/window/shop/repository/dto/q$b;", "c", "()Lcom/bytedance/android/window/shop/repository/dto/q$b;", "", "actionDesc", "Ljava/lang/String;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/String;", "schema", "d", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class c {

        @SerializedName("action_desc")
        private final String actionDesc;

        @SerializedName("description")
        private final a description;

        @SerializedName("discount_desc")
        private final b discountDesc;

        @SerializedName("schema")
        private final String schema;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof c) == false) goto L14;
            c r101 = (c) r100;
            if (Intrinsics.areEqual(this.description, r101.description) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.discountDesc, r101.discountDesc) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.actionDesc, r101.actionDesc) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.schema, r101.schema) == true) goto L22;
            return false;
        L22:
            return true;
        L14:
            return false;
        }

        public final int hashCode() {
            a r100 = this.description;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = r102 * 31;
            b r104 = this.discountDesc;
            if (r104 == null) goto L9;
            int r105 = r104.hashCode();
        L10:
            int r106 = (r103 + r105) * 31;
            String r107 = this.actionDesc;
            if (r107 == null) goto L13;
            int r108 = r107.hashCode();
        L14:
            int r109 = (r106 + r108) * 31;
            String r110 = this.schema;
            if (r110 == null) goto L18;
            r101 = r110.hashCode();
        L18:
            return r109 + r101;
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

        public final String toString() {
            return "WindowCouponInfo(description=" + this.description + ", discountDesc=" + this.discountDesc + ", actionDesc=" + this.actionDesc + ", schema=" + this.schema + ")";
        }

        public c() {
            this.description = null;
            this.discountDesc = null;
            this.actionDesc = null;
            this.schema = null;
        }

        public final String a() {
            return this.actionDesc;
        }

        public final a b() {
            return this.description;
        }

        public final b c() {
            return this.discountDesc;
        }

        public final String d() {
            return this.schema;
        }
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof q) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.couponList, ((q) r100).couponList) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        List<c> r100 = this.couponList;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.hashCode();
    }

    public final String toString() {
        return "WindowCouponItemDTO(couponList=" + this.couponList + ")";
    }

    public q() {
        this.couponList = null;
    }

    public final List<c> a() {
        return this.couponList;
    }
}
