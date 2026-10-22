package com.android.ttcjpaysdk.base.ui.data;

import com.android.ttcjpaysdk.base.json.CJPayObject;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002B{\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u000fJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\t\u0010\u0018\u001a\u00020\fHÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u007f\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0004HÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eHÖ\u0003J\t\u0010\u001f\u001a\u00020\fHÖ\u0001J\t\u0010 \u001a\u00020\u0004HÖ\u0001R\u0014\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000b\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/android/ttcjpaysdk/base/ui/data/RecommendPayTypeRetainInfo;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "Ljava/io/Serializable;", "title", "", "pay_type", "pay_type_title", "bank_card_id", "pay_type_icon", "retain_msg", "top_retain_button_text", "voucher_type", "", "bottom_retain_button_text", "is_discount", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "", "hashCode", "toString", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class RecommendPayTypeRetainInfo implements CJPayObject, Serializable {
    public String bank_card_id;
    public String bottom_retain_button_text;
    public String is_discount;
    public String pay_type;
    public String pay_type_icon;
    public String pay_type_title;
    public String retain_msg;
    public String title;
    public String top_retain_button_text;
    public int voucher_type;

    public RecommendPayTypeRetainInfo() {
        this(null, null, null, null, null, null, null, 0, null, null, 1023, null);
    }

    public static /* synthetic */ RecommendPayTypeRetainInfo copy$default(RecommendPayTypeRetainInfo r110, String r111, String r112, String r113, String r114, String r115, String r116, String r117, int r118, String r210, String r211, int r212, Object r213) {
        if ((r212 & 1) == 0) goto L5;
        String r100 = r110.title;
    L7:
        if ((r212 & 2) == 0) goto L9;
        String r101 = r110.pay_type;
    L11:
        if ((r212 & 4) == 0) goto L13;
        String r102 = r110.pay_type_title;
    L15:
        if ((r212 & 8) == 0) goto L17;
        String r103 = r110.bank_card_id;
    L19:
        if ((r212 & 16) == 0) goto L21;
        String r104 = r110.pay_type_icon;
    L23:
        if ((r212 & 32) == 0) goto L25;
        String r105 = r110.retain_msg;
    L27:
        if ((r212 & 64) == 0) goto L29;
        String r106 = r110.top_retain_button_text;
    L31:
        if ((r212 & 128) == 0) goto L33;
        int r107 = r110.voucher_type;
    L35:
        if ((r212 & 256) == 0) goto L37;
        String r119 = r110.bottom_retain_button_text;
    L39:
        if ((r212 & 512) == 0) goto L41;
        String r108 = r110.is_discount;
    L43:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r119, r108);
    L41:
        r108 = r211;
        goto L43
    L37:
        r119 = r210;
        goto L39
    L33:
        r107 = r118;
        goto L35
    L29:
        r106 = r117;
        goto L31
    L25:
        r105 = r116;
        goto L27
    L21:
        r104 = r115;
        goto L23
    L17:
        r103 = r114;
        goto L19
    L13:
        r102 = r113;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    public final String component1() {
        return this.title;
    }

    public final String component10() {
        return this.is_discount;
    }

    public final String component2() {
        return this.pay_type;
    }

    public final String component3() {
        return this.pay_type_title;
    }

    public final String component4() {
        return this.bank_card_id;
    }

    public final String component5() {
        return this.pay_type_icon;
    }

    public final String component6() {
        return this.retain_msg;
    }

    public final String component7() {
        return this.top_retain_button_text;
    }

    public final int component8() {
        return this.voucher_type;
    }

    public final String component9() {
        return this.bottom_retain_button_text;
    }

    public final RecommendPayTypeRetainInfo copy(String r110, String r111, String r112, String r113, String r114, String r115, String r116, int r210, String r211, String r212) {
        return new RecommendPayTypeRetainInfo(r110, r111, r112, r113, r114, r115, r116, r210, r211, r212);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof RecommendPayTypeRetainInfo) == true) goto L8;
        return false;
    L8:
        RecommendPayTypeRetainInfo r101 = (RecommendPayTypeRetainInfo) r100;
        if (Intrinsics.areEqual(this.title, r101.title) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.pay_type, r101.pay_type) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.pay_type_title, r101.pay_type_title) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.bank_card_id, r101.bank_card_id) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.pay_type_icon, r101.pay_type_icon) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.retain_msg, r101.retain_msg) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.top_retain_button_text, r101.top_retain_button_text) == true) goto L30;
        return false;
    L30:
        if (this.voucher_type == r101.voucher_type) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.bottom_retain_button_text, r101.bottom_retain_button_text) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.is_discount, r101.is_discount) == true) goto L38;
        return false;
    L38:
        return true;
    }

    public int hashCode() {
        String r100 = this.title;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.pay_type;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.pay_type_title;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.bank_card_id;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.pay_type_icon;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.retain_msg;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.top_retain_button_text;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (((r118 + r120) * 31) + this.voucher_type) * 31;
        String r122 = this.bottom_retain_button_text;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        String r125 = this.is_discount;
        if (r125 == null) goto L39;
        r101 = r125.hashCode();
    L39:
        return r124 + r101;
    L33:
        r123 = r122.hashCode();
        goto L34
    L29:
        r120 = r119.hashCode();
        goto L30
    L25:
        r117 = r116.hashCode();
        goto L26
    L21:
        r114 = r113.hashCode();
        goto L22
    L17:
        r111 = r110.hashCode();
        goto L18
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "RecommendPayTypeRetainInfo(title=" + this.title + ", pay_type=" + this.pay_type + ", pay_type_title=" + this.pay_type_title + ", bank_card_id=" + this.bank_card_id + ", pay_type_icon=" + this.pay_type_icon + ", retain_msg=" + this.retain_msg + ", top_retain_button_text=" + this.top_retain_button_text + ", voucher_type=" + this.voucher_type + ", bottom_retain_button_text=" + this.bottom_retain_button_text + ", is_discount=" + this.is_discount + ')';
    }

    public RecommendPayTypeRetainInfo(String r100, String r101, String r102, String r103, String r104, String r105, String r106, int r107, String r108, String r110) {
        this.title = r100;
        this.pay_type = r101;
        this.pay_type_title = r102;
        this.bank_card_id = r103;
        this.pay_type_icon = r104;
        this.retain_msg = r105;
        this.top_retain_button_text = r106;
        this.voucher_type = r107;
        this.bottom_retain_button_text = r108;
        this.is_discount = r110;
    }

    public /* synthetic */ RecommendPayTypeRetainInfo(String r110, String r111, String r112, String r113, String r114, String r115, String r116, int r117, String r210, String r211, int r212, DefaultConstructorMarker r213) {
        String r100 = null;
        if ((r212 & 1) == 0) goto L5;
        String r101 = null;
    L7:
        if ((r212 & 2) == 0) goto L9;
        String r102 = null;
    L11:
        if ((r212 & 4) == 0) goto L13;
        String r103 = null;
    L15:
        if ((r212 & 8) == 0) goto L17;
        String r104 = null;
    L19:
        if ((r212 & 16) == 0) goto L21;
        String r105 = null;
    L23:
        if ((r212 & 32) == 0) goto L25;
        String r106 = null;
    L27:
        if ((r212 & 64) == 0) goto L29;
        String r107 = null;
    L31:
        if ((r212 & 128) == 0) goto L33;
        int r108 = -1;
    L35:
        if ((r212 & 256) == 0) goto L37;
        String r118 = null;
    L39:
        if ((r212 & 512) != 0) goto L42;
        r100 = r211;
    L42:
        this(r101, r102, r103, r104, r105, r106, r107, r108, r118, r100);
        return;
    L37:
        r118 = r210;
        goto L39
    L33:
        r108 = r117;
        goto L35
    L29:
        r107 = r116;
        goto L31
    L25:
        r106 = r115;
        goto L27
    L21:
        r105 = r114;
        goto L23
    L17:
        r104 = r113;
        goto L19
    L13:
        r103 = r112;
        goto L15
    L9:
        r102 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L7
    }
}
