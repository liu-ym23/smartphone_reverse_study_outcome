package com.bytedance.android.shopping.widget.buybutton;

import com.bytedance.android.ec.model.ButtonTime;
import com.bytedance.android.ec.model.ButtonType;
import com.bytedance.android.ec.model.response.anchorv3.ButtonTipsStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductLink;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Integer f187313a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final PromotionProductLink f187314b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f187315c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f187316d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f187317e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Integer f187318f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Long f187319g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Boolean f187320h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Boolean f187321i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Integer f187322j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final ButtonTipsStruct f187323k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f187324l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Boolean f187325m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final ButtonTime f187326n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final ButtonType f187327o;

    public k() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, ButtonType.NORMAL);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof k) == false) goto L36;
        k r101 = (k) r100;
        if (Intrinsics.areEqual(this.f187313a, r101.f187313a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f187314b, r101.f187314b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f187315c, r101.f187315c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f187316d, r101.f187316d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f187317e, r101.f187317e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f187318f, r101.f187318f) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f187319g, r101.f187319g) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.f187320h, r101.f187320h) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.f187321i, r101.f187321i) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f187322j, r101.f187322j) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.f187323k, r101.f187323k) == true) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.f187324l, r101.f187324l) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f187325m, r101.f187325m) == true) goto L32;
        return false;
    L32:
        if (Intrinsics.areEqual(this.f187326n, r101.f187326n) == true) goto L34;
        return false;
    L34:
        if (Intrinsics.areEqual(this.f187327o, r101.f187327o) == true) goto L55;
        return false;
    L55:
        return true;
    L36:
        return false;
    }

    public final int hashCode() {
        Integer r100 = this.f187313a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        PromotionProductLink r104 = this.f187314b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f187315c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f187316d;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.f187317e;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        Integer r116 = this.f187318f;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        Long r119 = this.f187319g;
        if (r119 == null) goto L29;
        int r120 = r119.hashCode();
    L30:
        int r121 = (r118 + r120) * 31;
        Boolean r122 = this.f187320h;
        if (r122 == null) goto L33;
        int r123 = r122.hashCode();
    L34:
        int r124 = (r121 + r123) * 31;
        Boolean r125 = this.f187321i;
        if (r125 == null) goto L37;
        int r126 = r125.hashCode();
    L38:
        int r127 = (r124 + r126) * 31;
        Integer r128 = this.f187322j;
        if (r128 == null) goto L41;
        int r129 = r128.hashCode();
    L42:
        int r130 = (r127 + r129) * 31;
        ButtonTipsStruct r131 = this.f187323k;
        if (r131 == null) goto L45;
        int r132 = r131.hashCode();
    L46:
        int r133 = (r130 + r132) * 31;
        String r134 = this.f187324l;
        if (r134 == null) goto L49;
        int r135 = r134.hashCode();
    L50:
        int r136 = (r133 + r135) * 31;
        Boolean r137 = this.f187325m;
        if (r137 == null) goto L53;
        int r138 = r137.hashCode();
    L54:
        int r139 = (r136 + r138) * 31;
        ButtonTime r140 = this.f187326n;
        if (r140 == null) goto L57;
        int r141 = r140.hashCode();
    L58:
        int r142 = (r139 + r141) * 31;
        ButtonType r143 = this.f187327o;
        if (r143 == null) goto L62;
        r101 = r143.hashCode();
    L62:
        return r142 + r101;
    L57:
        r141 = 0;
        goto L58
    L53:
        r138 = 0;
        goto L54
    L49:
        r135 = 0;
        goto L50
    L45:
        r132 = 0;
        goto L46
    L41:
        r129 = 0;
        goto L42
    L37:
        r126 = 0;
        goto L38
    L33:
        r123 = 0;
        goto L34
    L29:
        r120 = 0;
        goto L30
    L25:
        r117 = 0;
        goto L26
    L21:
        r114 = 0;
        goto L22
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

    public final String toString() {
        return "SingleButtonModel(orderStatus=" + this.f187313a + ", links=" + this.f187314b + ", text=" + this.f187315c + ", subText=" + this.f187316d + ", tips=" + this.f187317e + ", applyCoupon=" + this.f187318f + ", applyCouponPrice=" + this.f187319g + ", alreadyBuy=" + this.f187320h + ", needCheckSku=" + this.f187321i + ", payType=" + this.f187322j + ", buttonTips=" + this.f187323k + ", wordColor=" + this.f187324l + ", grayButton=" + this.f187325m + ", buttonTime=" + this.f187326n + ", buttonType=" + this.f187327o + ")";
    }

    public k(Integer r100, PromotionProductLink r101, String r102, String r103, String r104, Integer r105, Long r110, Boolean r111, Boolean r112, Integer r113, ButtonTipsStruct r114, String r115, Boolean r116, ButtonTime r117, ButtonType r118) {
        Intrinsics.checkNotNullParameter(r118, "buttonType");
        this.f187313a = r100;
        this.f187314b = r101;
        this.f187315c = r102;
        this.f187316d = r103;
        this.f187317e = r104;
        this.f187318f = r105;
        this.f187319g = r110;
        this.f187320h = r111;
        this.f187321i = r112;
        this.f187322j = r113;
        this.f187323k = r114;
        this.f187324l = r115;
        this.f187325m = r116;
        this.f187326n = r117;
        this.f187327o = r118;
    }
}
