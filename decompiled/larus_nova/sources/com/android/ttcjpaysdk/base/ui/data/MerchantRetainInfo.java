package com.android.ttcjpaysdk.base.ui.data;

import com.android.ttcjpaysdk.base.CJPayConstant;
import com.android.ttcjpaysdk.base.json.CJPayObject;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002BW\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0002\u0010\u000eJ\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\t\u0010\u0013\u001a\u00020\tHÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\rHÆ\u0003J[\u0010\u0016\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\rHÆ\u0001J\u0013\u0010\u0017\u001a\u00020\t2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0004HÖ\u0001R\u0014\u0010\f\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/android/ttcjpaysdk/base/ui/data/MerchantRetainInfo;", "Lcom/android/ttcjpaysdk/base/json/CJPayObject;", "Ljava/io/Serializable;", CJPayConstant.CJ_PAY_RETAIN_INFO_V2_SCHEMA_KEY, "", "position", "retain_event_report_path", "type", CJPayConstant.CJ_PAY_RETAIN_INFO_V2_USE_SCHEMA_KEY, "", "voucher_retain_info", "Lcom/android/ttcjpaysdk/base/ui/data/VoucherRetainInfo;", "default_retain_info", "Lcom/android/ttcjpaysdk/base/ui/data/DefaultRetainInfo;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLcom/android/ttcjpaysdk/base/ui/data/VoucherRetainInfo;Lcom/android/ttcjpaysdk/base/ui/data/DefaultRetainInfo;)V", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "", "hashCode", "", "toString", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class MerchantRetainInfo implements CJPayObject, Serializable {
    public DefaultRetainInfo default_retain_info;
    public String lynx_schema;
    public String position;
    public String retain_event_report_path;
    public String type;
    public boolean use_lynx_schema;
    public VoucherRetainInfo voucher_retain_info;

    public MerchantRetainInfo() {
        this(null, null, null, null, false, null, null, 127, null);
    }

    public static /* synthetic */ MerchantRetainInfo copy$default(MerchantRetainInfo r100, String r101, String r102, String r103, String r104, boolean r110, VoucherRetainInfo r111, DefaultRetainInfo r112, int r113, Object r114) {
        if ((r113 & 1) == 0) goto L6;
        r101 = r100.lynx_schema;
    L6:
        if ((r113 & 2) == 0) goto L8;
        r102 = r100.position;
    L8:
        String r115 = r102;
        if ((r113 & 4) == 0) goto L11;
        r103 = r100.retain_event_report_path;
    L11:
        String r105 = r103;
        if ((r113 & 8) == 0) goto L14;
        r104 = r100.type;
    L14:
        String r106 = r104;
        if ((r113 & 16) == 0) goto L17;
        r110 = r100.use_lynx_schema;
    L17:
        boolean r107 = r110;
        if ((r113 & 32) == 0) goto L20;
        r111 = r100.voucher_retain_info;
    L20:
        VoucherRetainInfo r108 = r111;
        if ((r113 & 64) == 0) goto L23;
        r112 = r100.default_retain_info;
    L23:
        String r109 = r101;
        return r100.copy(r109, r115, r105, r106, r107, r108, r112);
    }

    public final String component1() {
        return this.lynx_schema;
    }

    public final String component2() {
        return this.position;
    }

    public final String component3() {
        return this.retain_event_report_path;
    }

    public final String component4() {
        return this.type;
    }

    public final boolean component5() {
        return this.use_lynx_schema;
    }

    public final VoucherRetainInfo component6() {
        return this.voucher_retain_info;
    }

    public final DefaultRetainInfo component7() {
        return this.default_retain_info;
    }

    public final MerchantRetainInfo copy(String r110, String r111, String r112, String r113, boolean r114, VoucherRetainInfo r115, DefaultRetainInfo r116) {
        return new MerchantRetainInfo(r110, r111, r112, r113, r114, r115, r116);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof MerchantRetainInfo) == true) goto L8;
        return false;
    L8:
        MerchantRetainInfo r101 = (MerchantRetainInfo) r100;
        if (Intrinsics.areEqual(this.lynx_schema, r101.lynx_schema) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.position, r101.position) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.retain_event_report_path, r101.retain_event_report_path) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.type, r101.type) == true) goto L21;
        return false;
    L21:
        if (this.use_lynx_schema == r101.use_lynx_schema) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.voucher_retain_info, r101.voucher_retain_info) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.default_retain_info, r101.default_retain_info) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public int hashCode() {
        String r100 = this.lynx_schema;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.position;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.retain_event_report_path;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.type;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        if (this.use_lynx_schema == false) goto L21;
        int r113 = 1231;
    L22:
        int r114 = (r112 + r113) * 31;
        VoucherRetainInfo r115 = this.voucher_retain_info;
        if (r115 != null) goto L25;
        int r116 = 0;
    L26:
        int r117 = (r114 + r116) * 31;
        DefaultRetainInfo r118 = this.default_retain_info;
        if (r118 == null) goto L31;
        r101 = r118.hashCode();
    L31:
        return r117 + r101;
    L25:
        r116 = r115.hashCode();
        goto L26
    L21:
        r113 = 1237;
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
        return "MerchantRetainInfo(lynx_schema=" + this.lynx_schema + ", position=" + this.position + ", retain_event_report_path=" + this.retain_event_report_path + ", type=" + this.type + ", use_lynx_schema=" + this.use_lynx_schema + ", voucher_retain_info=" + this.voucher_retain_info + ", default_retain_info=" + this.default_retain_info + ')';
    }

    public MerchantRetainInfo(String r100, String r101, String r102, String r103, boolean r104, VoucherRetainInfo r105, DefaultRetainInfo r106) {
        this.lynx_schema = r100;
        this.position = r101;
        this.retain_event_report_path = r102;
        this.type = r103;
        this.use_lynx_schema = r104;
        this.voucher_retain_info = r105;
        this.default_retain_info = r106;
    }

    public /* synthetic */ MerchantRetainInfo(String r100, String r101, String r102, String r110, boolean r111, VoucherRetainInfo r112, DefaultRetainInfo r113, int r114, DefaultConstructorMarker r115) {
        if ((r114 & 1) == 0) goto L5;
        String r116 = null;
    L7:
        if ((r114 & 2) == 0) goto L9;
        String r103 = null;
    L11:
        if ((r114 & 4) == 0) goto L13;
        String r104 = null;
    L15:
        if ((r114 & 8) == 0) goto L17;
        String r105 = null;
    L19:
        if ((r114 & 16) == 0) goto L21;
        boolean r106 = false;
    L23:
        if ((r114 & 32) == 0) goto L25;
        VoucherRetainInfo r107 = null;
    L27:
        if ((r114 & 64) == 0) goto L29;
        DefaultRetainInfo r117 = null;
    L30:
        this(r116, r103, r104, r105, r106, r107, r117);
        return;
    L29:
        r117 = r113;
        goto L30
    L25:
        r107 = r112;
        goto L27
    L21:
        r106 = r111;
        goto L23
    L17:
        r105 = r110;
        goto L19
    L13:
        r104 = r102;
        goto L15
    L9:
        r103 = r101;
        goto L11
    L5:
        r116 = r100;
        goto L7
    }
}
