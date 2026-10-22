package com.android.ttcjpaysdk.base.ui.data;

import com.android.ttcjpaysdk.base.CJPayConstant;
import com.android.ttcjpaysdk.base.json.CJPayObject;
import com.ss.android.socialbase.appdownloader.util.parser.zip.UnixStat;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002B\u0093\u0001\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\u0014J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0011HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\rHÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\bHÆ\u0003J\u0097\u0001\u0010!\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0013\u0010\"\u001a\u00020\u00112\b\u0010#\u001a\u0004\u0018\u00010$HÖ\u0003J\t\u0010%\u001a\u00020&HÖ\u0001J\t\u0010'\u001a\u00020\bHÖ\u0001R\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0010\u001a\u00020\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lcom/android/ttcjpaysdk/base/ui/data/RetainInfoGroups;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "Ljava/io/Serializable;", "default_retain_info", "Lcom/android/ttcjpaysdk/base/ui/data/DefaultRetainInfo;", "goods_label_retain_info", "Lcom/android/ttcjpaysdk/base/ui/data/VoucherRetainInfo;", CJPayConstant.CJ_PAY_RETAIN_INFO_V2_SCHEMA_KEY, "", "no_pwd_retain_info", "position", "recommend_face_verify_info", "recommend_pay_type_retain_info", "Lcom/android/ttcjpaysdk/base/ui/data/RecommendPayTypeRetainInfo;", "retain_event_report_path", "type", CJPayConstant.CJ_PAY_RETAIN_INFO_V2_USE_SCHEMA_KEY, "", "voucher_retain_info", "retain_for_components", "(Lcom/android/ttcjpaysdk/base/ui/data/DefaultRetainInfo;Lcom/android/ttcjpaysdk/base/ui/data/VoucherRetainInfo;Ljava/lang/String;Lcom/android/ttcjpaysdk/base/ui/data/VoucherRetainInfo;Ljava/lang/String;Lcom/android/ttcjpaysdk/base/ui/data/VoucherRetainInfo;Lcom/android/ttcjpaysdk/base/ui/data/RecommendPayTypeRetainInfo;Ljava/lang/String;Ljava/lang/String;ZLcom/android/ttcjpaysdk/base/ui/data/VoucherRetainInfo;Ljava/lang/String;)V", "component1", "component10", "component11", "component12", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "", "hashCode", "", "toString", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class RetainInfoGroups implements CJPayObject, Serializable {
    public DefaultRetainInfo default_retain_info;
    public VoucherRetainInfo goods_label_retain_info;
    public String lynx_schema;
    public VoucherRetainInfo no_pwd_retain_info;
    public String position;
    public VoucherRetainInfo recommend_face_verify_info;
    public RecommendPayTypeRetainInfo recommend_pay_type_retain_info;
    public String retain_event_report_path;
    public String retain_for_components;
    public String type;
    public boolean use_lynx_schema;
    public VoucherRetainInfo voucher_retain_info;

    public RetainInfoGroups() {
        this(null, null, null, null, null, null, null, null, null, false, null, null, UnixStat.PERM_MASK, null);
    }

    public static /* synthetic */ RetainInfoGroups copy$default(RetainInfoGroups r110, DefaultRetainInfo r111, VoucherRetainInfo r112, String r113, VoucherRetainInfo r114, String r115, VoucherRetainInfo r116, RecommendPayTypeRetainInfo r210, String r211, String r212, boolean r213, VoucherRetainInfo r214, String r215, int r216, Object r217) {
        if ((r216 & 1) == 0) goto L5;
        DefaultRetainInfo r100 = r110.default_retain_info;
    L7:
        if ((r216 & 2) == 0) goto L9;
        VoucherRetainInfo r101 = r110.goods_label_retain_info;
    L11:
        if ((r216 & 4) == 0) goto L13;
        String r102 = r110.lynx_schema;
    L15:
        if ((r216 & 8) == 0) goto L17;
        VoucherRetainInfo r103 = r110.no_pwd_retain_info;
    L19:
        if ((r216 & 16) == 0) goto L21;
        String r104 = r110.position;
    L23:
        if ((r216 & 32) == 0) goto L25;
        VoucherRetainInfo r105 = r110.recommend_face_verify_info;
    L27:
        if ((r216 & 64) == 0) goto L29;
        RecommendPayTypeRetainInfo r106 = r110.recommend_pay_type_retain_info;
    L31:
        if ((r216 & 128) == 0) goto L33;
        String r107 = r110.retain_event_report_path;
    L35:
        if ((r216 & 256) == 0) goto L37;
        String r117 = r110.type;
    L39:
        if ((r216 & 512) == 0) goto L41;
        boolean r118 = r110.use_lynx_schema;
    L43:
        if ((r216 & 1024) == 0) goto L45;
        VoucherRetainInfo r119 = r110.voucher_retain_info;
    L47:
        if ((r216 & 2048) == 0) goto L49;
        String r108 = r110.retain_for_components;
    L51:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r117, r118, r119, r108);
    L49:
        r108 = r215;
        goto L51
    L45:
        r119 = r214;
        goto L47
    L41:
        r118 = r213;
        goto L43
    L37:
        r117 = r212;
        goto L39
    L33:
        r107 = r211;
        goto L35
    L29:
        r106 = r210;
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

    public final DefaultRetainInfo component1() {
        return this.default_retain_info;
    }

    public final boolean component10() {
        return this.use_lynx_schema;
    }

    public final VoucherRetainInfo component11() {
        return this.voucher_retain_info;
    }

    public final String component12() {
        return this.retain_for_components;
    }

    public final VoucherRetainInfo component2() {
        return this.goods_label_retain_info;
    }

    public final String component3() {
        return this.lynx_schema;
    }

    public final VoucherRetainInfo component4() {
        return this.no_pwd_retain_info;
    }

    public final String component5() {
        return this.position;
    }

    public final VoucherRetainInfo component6() {
        return this.recommend_face_verify_info;
    }

    public final RecommendPayTypeRetainInfo component7() {
        return this.recommend_pay_type_retain_info;
    }

    public final String component8() {
        return this.retain_event_report_path;
    }

    public final String component9() {
        return this.type;
    }

    public final RetainInfoGroups copy(DefaultRetainInfo r110, VoucherRetainInfo r111, String r112, VoucherRetainInfo r113, String r114, VoucherRetainInfo r210, RecommendPayTypeRetainInfo r211, String r212, String r213, boolean r214, VoucherRetainInfo r215, String r216) {
        return new RetainInfoGroups(r110, r111, r112, r113, r114, r210, r211, r212, r213, r214, r215, r216);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof RetainInfoGroups) == true) goto L8;
        return false;
    L8:
        RetainInfoGroups r101 = (RetainInfoGroups) r100;
        if (Intrinsics.areEqual(this.default_retain_info, r101.default_retain_info) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.goods_label_retain_info, r101.goods_label_retain_info) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.lynx_schema, r101.lynx_schema) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.no_pwd_retain_info, r101.no_pwd_retain_info) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.position, r101.position) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.recommend_face_verify_info, r101.recommend_face_verify_info) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.recommend_pay_type_retain_info, r101.recommend_pay_type_retain_info) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.retain_event_report_path, r101.retain_event_report_path) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.type, r101.type) == true) goto L36;
        return false;
    L36:
        if (this.use_lynx_schema == r101.use_lynx_schema) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.voucher_retain_info, r101.voucher_retain_info) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.retain_for_components, r101.retain_for_components) == true) goto L44;
        return false;
    L44:
        return true;
    }

    public int hashCode() {
        DefaultRetainInfo r100 = this.default_retain_info;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        VoucherRetainInfo r104 = this.goods_label_retain_info;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.lynx_schema;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        VoucherRetainInfo r110 = this.no_pwd_retain_info;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.position;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        VoucherRetainInfo r116 = this.recommend_face_verify_info;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        RecommendPayTypeRetainInfo r119 = this.recommend_pay_type_retain_info;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        String r122 = this.retain_event_report_path;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        String r125 = this.type;
        if (r125 != null) goto L37;
        int r126 = 0;
    L38:
        int r127 = (r124 + r126) * 31;
        if (this.use_lynx_schema == false) goto L41;
        int r128 = 1231;
    L42:
        int r129 = (r127 + r128) * 31;
        VoucherRetainInfo r130 = this.voucher_retain_info;
        if (r130 != null) goto L45;
        int r131 = 0;
    L46:
        int r132 = (r129 + r131) * 31;
        String r133 = this.retain_for_components;
        if (r133 == null) goto L51;
        r101 = r133.hashCode();
    L51:
        return r132 + r101;
    L45:
        r131 = r130.hashCode();
        goto L46
    L41:
        r128 = 1237;
        goto L42
    L37:
        r126 = r125.hashCode();
        goto L38
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
        return "RetainInfoGroups(default_retain_info=" + this.default_retain_info + ", goods_label_retain_info=" + this.goods_label_retain_info + ", lynx_schema=" + this.lynx_schema + ", no_pwd_retain_info=" + this.no_pwd_retain_info + ", position=" + this.position + ", recommend_face_verify_info=" + this.recommend_face_verify_info + ", recommend_pay_type_retain_info=" + this.recommend_pay_type_retain_info + ", retain_event_report_path=" + this.retain_event_report_path + ", type=" + this.type + ", use_lynx_schema=" + this.use_lynx_schema + ", voucher_retain_info=" + this.voucher_retain_info + ", retain_for_components=" + this.retain_for_components + ')';
    }

    public RetainInfoGroups(DefaultRetainInfo r100, VoucherRetainInfo r101, String r102, VoucherRetainInfo r103, String r104, VoucherRetainInfo r105, RecommendPayTypeRetainInfo r106, String r107, String r108, boolean r110, VoucherRetainInfo r111, String r112) {
        this.default_retain_info = r100;
        this.goods_label_retain_info = r101;
        this.lynx_schema = r102;
        this.no_pwd_retain_info = r103;
        this.position = r104;
        this.recommend_face_verify_info = r105;
        this.recommend_pay_type_retain_info = r106;
        this.retain_event_report_path = r107;
        this.type = r108;
        this.use_lynx_schema = r110;
        this.voucher_retain_info = r111;
        this.retain_for_components = r112;
    }

    public /* synthetic */ RetainInfoGroups(DefaultRetainInfo r110, VoucherRetainInfo r111, String r112, VoucherRetainInfo r113, String r114, VoucherRetainInfo r115, RecommendPayTypeRetainInfo r210, String r211, String r212, boolean r213, VoucherRetainInfo r214, String r215, int r216, DefaultConstructorMarker r217) {
        String r100 = null;
        if ((r216 & 1) == 0) goto L5;
        DefaultRetainInfo r101 = null;
    L7:
        if ((r216 & 2) == 0) goto L9;
        VoucherRetainInfo r102 = null;
    L11:
        if ((r216 & 4) == 0) goto L13;
        String r103 = null;
    L15:
        if ((r216 & 8) == 0) goto L17;
        VoucherRetainInfo r104 = null;
    L19:
        if ((r216 & 16) == 0) goto L21;
        String r105 = null;
    L23:
        if ((r216 & 32) == 0) goto L25;
        VoucherRetainInfo r106 = null;
    L27:
        if ((r216 & 64) == 0) goto L29;
        RecommendPayTypeRetainInfo r107 = null;
    L31:
        if ((r216 & 128) == 0) goto L33;
        String r108 = null;
    L35:
        if ((r216 & 256) == 0) goto L37;
        String r116 = null;
    L39:
        if ((r216 & 512) == 0) goto L41;
        boolean r117 = false;
    L43:
        if ((r216 & 1024) == 0) goto L45;
        VoucherRetainInfo r118 = null;
    L47:
        if ((r216 & 2048) != 0) goto L50;
        r100 = r215;
    L50:
        this(r101, r102, r103, r104, r105, r106, r107, r108, r116, r117, r118, r100);
        return;
    L45:
        r118 = r214;
        goto L47
    L41:
        r117 = r213;
        goto L43
    L37:
        r116 = r212;
        goto L39
    L33:
        r108 = r211;
        goto L35
    L29:
        r107 = r210;
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
