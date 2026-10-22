package com.android.ttcjpaysdk.base.service.bean;

import com.android.ttcjpaysdk.base.utils.CJBasicCommonUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u001d\b\u0086\b\u0018\u0000 02\u00020\u0001:\u00010BÕ\u0001\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0014\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0004¢\u0006\u0002\u0010\u0018J\u0011\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0004HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0004HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0011HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0014HÆ\u0003J\t\u0010 \u001a\u00020\u0004HÆ\u0003J\t\u0010!\u001a\u00020\u0004HÆ\u0003J\t\u0010\"\u001a\u00020\u0004HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0004HÆ\u0003JÙ\u0001\u0010+\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u000e\u001a\u00020\u00042\b\b\u0002\u0010\u000f\u001a\u00020\u00042\b\b\u0002\u0010\u0010\u001a\u00020\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00042\b\b\u0002\u0010\u0016\u001a\u00020\u00042\b\b\u0002\u0010\u0017\u001a\u00020\u0004HÆ\u0001J\u0013\u0010,\u001a\u00020\u00142\b\u0010-\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010.\u001a\u00020\u0011HÖ\u0001J\t\u0010/\u001a\u00020\u0004HÖ\u0001R\u0014\u0010\f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0013\u001a\u00020\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0015\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0016\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0010\u001a\u00020\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000f\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000e\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0017\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u00061"}, d2 = {"Lcom/android/ttcjpaysdk/base/service/bean/VoucherDialogExpandResult;", "", "voucher_no_list", "", "", "expand_standard_rec_desc", "expand_standard_show_amount", "bank_card_expand_standard_rec_desc", "bank_card_expand_standard_show_amount", "bank_card_voucher_label", "combine_voucher_label", "voucher_label", "_bankcard_id", "_credit_pay_installment", "expand_pay_type_desc", "expand_fee_desc", "expand_fee", "", "_combine_type", "_is_std_expand", "", "_origin_method_unique_id", "_to_method_unique_id", "isOneCentPurchaseExpand", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "Companion", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class VoucherDialogExpandResult {
    public static final Companion Companion = null;
    public String _bankcard_id;
    public String _combine_type;
    public String _credit_pay_installment;
    public boolean _is_std_expand;
    public String _origin_method_unique_id;
    public String _to_method_unique_id;
    public String bank_card_expand_standard_rec_desc;
    public String bank_card_expand_standard_show_amount;
    public String bank_card_voucher_label;
    public String combine_voucher_label;
    public int expand_fee;
    public String expand_fee_desc;
    public String expand_pay_type_desc;
    public String expand_standard_rec_desc;
    public String expand_standard_show_amount;
    public String isOneCentPurchaseExpand;
    public String voucher_label;
    public List<String> voucher_no_list;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¨\u0006\u0007"}, d2 = {"Lcom/android/ttcjpaysdk/base/service/bean/VoucherDialogExpandResult$Companion;", "", "()V", "fromJson", "Lcom/android/ttcjpaysdk/base/service/bean/VoucherDialogExpandResult;", "json", "Lorg/json/JSONObject;", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final VoucherDialogExpandResult fromJson(JSONObject r210) {
            VoucherDialogExpandResult r110 = new VoucherDialogExpandResult(null, null, null, null, null, null, null, null, null, null, null, null, 0, null, false, null, null, null, 262143, null);
            if (r210 == null) goto L20;
            JSONArray r100 = r210.optJSONArray("voucher_no_list");     // Catch: Exception -> L16
            ArrayList r101 = new ArrayList();     // Catch: Exception -> L16
            if (r100 == null) goto L11;
            Iterator<Integer> r102 = RangesKt.until(0, r100.length()).iterator();     // Catch: Exception -> L16
        L8:
            if (r102.hasNext() == false) goto L11;
            r101.add(r100.optString(((IntIterator) r102).nextInt()));     // Catch: Exception -> L16
        L11:
            VoucherDialogExpandResult r103 = r110;
            r103.voucher_no_list = r101;     // Catch: Exception -> L14
            r103.expand_standard_rec_desc = r210.optString("expand_standard_rec_desc", "");     // Catch: Exception -> L14
            r103.expand_standard_show_amount = r210.optString("expand_standard_show_amount", "");     // Catch: Exception -> L14
            r103.bank_card_expand_standard_rec_desc = r210.optString("bank_card_expand_standard_rec_desc", "");     // Catch: Exception -> L14
            r103.bank_card_expand_standard_show_amount = r210.optString("bank_card_expand_standard_show_amount", "");     // Catch: Exception -> L14
            r103.bank_card_voucher_label = r210.optString("bank_card_voucher_label", "");     // Catch: Exception -> L14
            r103.combine_voucher_label = r210.optString("combine_voucher_label", "");     // Catch: Exception -> L14
            r103.voucher_label = r210.optString("voucher_label", "");     // Catch: Exception -> L14
            r103.expand_pay_type_desc = r210.optString("expand_pay_type_desc", "");     // Catch: Exception -> L14
            r103.expand_fee_desc = r210.optString("expand_fee_desc", "");     // Catch: Exception -> L14
            r103.expand_fee = r210.optInt("expand_fee", 0);     // Catch: Exception -> L14
            r103.isOneCentPurchaseExpand = r210.optString("one_cent_purchase_expand", "0");     // Catch: Exception -> L14
            return r103;
        L14:
            e = e;
        L18:
            CJBasicCommonUtils.reportCatchException("VoucherDialogExpandResult#fromJson", e);
            CJBasicCommonUtils.logCatch("CJCatch", "VoucherDialogExpandResult#fromJson", e);
            return r103;
        L16:
            e = e;
            r103 = r110;
            goto L18
        L20:
            return r110;
        }
    }

    static {
        Companion = new Companion(null);
    }

    public VoucherDialogExpandResult() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, 0, null, false, null, null, null, 262143, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ VoucherDialogExpandResult copy$default(VoucherDialogExpandResult r110, List r111, String r112, String r210, String r211, String r212, String r213, String r214, String r215, String r216, String r217, String r218, String r219, int r310, String r311, boolean r312, String r313, String r314, String r315, int r316, Object r317) {
        if ((r316 & 1) == 0) goto L5;
        List r100 = r110.voucher_no_list;
    L7:
        if ((r316 & 2) == 0) goto L9;
        String r101 = r110.expand_standard_rec_desc;
    L11:
        if ((r316 & 4) == 0) goto L13;
        String r102 = r110.expand_standard_show_amount;
    L15:
        if ((r316 & 8) == 0) goto L17;
        String r103 = r110.bank_card_expand_standard_rec_desc;
    L19:
        if ((r316 & 16) == 0) goto L21;
        String r104 = r110.bank_card_expand_standard_show_amount;
    L23:
        if ((r316 & 32) == 0) goto L25;
        String r105 = r110.bank_card_voucher_label;
    L27:
        if ((r316 & 64) == 0) goto L29;
        String r106 = r110.combine_voucher_label;
    L31:
        if ((r316 & 128) == 0) goto L33;
        String r107 = r110.voucher_label;
    L35:
        if ((r316 & 256) == 0) goto L37;
        String r113 = r110._bankcard_id;
    L39:
        if ((r316 & 512) == 0) goto L41;
        String r114 = r110._credit_pay_installment;
    L43:
        if ((r316 & 1024) == 0) goto L45;
        String r115 = r110.expand_pay_type_desc;
    L47:
        if ((r316 & 2048) == 0) goto L49;
        String r116 = r110.expand_fee_desc;
    L51:
        if ((r316 & 4096) == 0) goto L53;
        int r117 = r110.expand_fee;
    L55:
        if ((r316 & 8192) == 0) goto L57;
        String r118 = r110._combine_type;
    L58:
        String r318 = r118;
        if ((r316 & 16384) == 0) goto L61;
        boolean r119 = r110._is_std_expand;
    L62:
        boolean r319 = r119;
        if ((r316 & 32768) == 0) goto L65;
        String r120 = r110._origin_method_unique_id;
    L66:
        String r320 = r120;
        if ((r316 & 65536) == 0) goto L69;
        String r121 = r110._to_method_unique_id;
    L71:
        if ((r316 & 131072) == 0) goto L73;
        String r108 = r110.isOneCentPurchaseExpand;
    L75:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r113, r114, r115, r116, r117, r318, r319, r320, r121, r108);
    L73:
        r108 = r315;
        goto L75
    L69:
        r121 = r314;
        goto L71
    L65:
        r120 = r313;
        goto L66
    L61:
        r119 = r312;
        goto L62
    L57:
        r118 = r311;
        goto L58
    L53:
        r117 = r310;
        goto L55
    L49:
        r116 = r219;
        goto L51
    L45:
        r115 = r218;
        goto L47
    L41:
        r114 = r217;
        goto L43
    L37:
        r113 = r216;
        goto L39
    L33:
        r107 = r215;
        goto L35
    L29:
        r106 = r214;
        goto L31
    L25:
        r105 = r213;
        goto L27
    L21:
        r104 = r212;
        goto L23
    L17:
        r103 = r211;
        goto L19
    L13:
        r102 = r210;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    public final List<String> component1() {
        return this.voucher_no_list;
    }

    public final String component10() {
        return this._credit_pay_installment;
    }

    public final String component11() {
        return this.expand_pay_type_desc;
    }

    public final String component12() {
        return this.expand_fee_desc;
    }

    public final int component13() {
        return this.expand_fee;
    }

    public final String component14() {
        return this._combine_type;
    }

    public final boolean component15() {
        return this._is_std_expand;
    }

    public final String component16() {
        return this._origin_method_unique_id;
    }

    public final String component17() {
        return this._to_method_unique_id;
    }

    public final String component18() {
        return this.isOneCentPurchaseExpand;
    }

    public final String component2() {
        return this.expand_standard_rec_desc;
    }

    public final String component3() {
        return this.expand_standard_show_amount;
    }

    public final String component4() {
        return this.bank_card_expand_standard_rec_desc;
    }

    public final String component5() {
        return this.bank_card_expand_standard_show_amount;
    }

    public final String component6() {
        return this.bank_card_voucher_label;
    }

    public final String component7() {
        return this.combine_voucher_label;
    }

    public final String component8() {
        return this.voucher_label;
    }

    public final String component9() {
        return this._bankcard_id;
    }

    public final VoucherDialogExpandResult copy(List<String> r210, String r211, String r212, String r213, String r214, String r215, String r216, String r217, String r218, String r310, String r311, String r312, int r313, String r314, boolean r315, String r316, String r317, String r318) {
        Intrinsics.checkNotNullParameter(r311, "expand_pay_type_desc");
        Intrinsics.checkNotNullParameter(r312, "expand_fee_desc");
        Intrinsics.checkNotNullParameter(r316, "_origin_method_unique_id");
        Intrinsics.checkNotNullParameter(r317, "_to_method_unique_id");
        Intrinsics.checkNotNullParameter(r318, "isOneCentPurchaseExpand");
        return new VoucherDialogExpandResult(r210, r211, r212, r213, r214, r215, r216, r217, r218, r310, r311, r312, r313, r314, r315, r316, r317, r318);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof VoucherDialogExpandResult) == true) goto L8;
        return false;
    L8:
        VoucherDialogExpandResult r101 = (VoucherDialogExpandResult) r100;
        if (Intrinsics.areEqual(this.voucher_no_list, r101.voucher_no_list) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.expand_standard_rec_desc, r101.expand_standard_rec_desc) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.expand_standard_show_amount, r101.expand_standard_show_amount) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.bank_card_expand_standard_rec_desc, r101.bank_card_expand_standard_rec_desc) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.bank_card_expand_standard_show_amount, r101.bank_card_expand_standard_show_amount) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.bank_card_voucher_label, r101.bank_card_voucher_label) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.combine_voucher_label, r101.combine_voucher_label) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.voucher_label, r101.voucher_label) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this._bankcard_id, r101._bankcard_id) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this._credit_pay_installment, r101._credit_pay_installment) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.expand_pay_type_desc, r101.expand_pay_type_desc) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.expand_fee_desc, r101.expand_fee_desc) == true) goto L45;
        return false;
    L45:
        if (this.expand_fee == r101.expand_fee) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this._combine_type, r101._combine_type) == true) goto L51;
        return false;
    L51:
        if (this._is_std_expand == r101._is_std_expand) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this._origin_method_unique_id, r101._origin_method_unique_id) == true) goto L57;
        return false;
    L57:
        if (Intrinsics.areEqual(this._to_method_unique_id, r101._to_method_unique_id) == true) goto L60;
        return false;
    L60:
        if (Intrinsics.areEqual(this.isOneCentPurchaseExpand, r101.isOneCentPurchaseExpand) == true) goto L62;
        return false;
    L62:
        return true;
    }

    public int hashCode() {
        List<String> r100 = this.voucher_no_list;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.expand_standard_rec_desc;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.expand_standard_show_amount;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.bank_card_expand_standard_rec_desc;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.bank_card_expand_standard_show_amount;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.bank_card_voucher_label;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.combine_voucher_label;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        String r122 = this.voucher_label;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        String r125 = this._bankcard_id;
        if (r125 != null) goto L37;
        int r126 = 0;
    L38:
        int r127 = (r124 + r126) * 31;
        String r128 = this._credit_pay_installment;
        if (r128 != null) goto L41;
        int r129 = 0;
    L42:
        int r130 = (((((((r127 + r129) * 31) + this.expand_pay_type_desc.hashCode()) * 31) + this.expand_fee_desc.hashCode()) * 31) + this.expand_fee) * 31;
        String r131 = this._combine_type;
        if (r131 == null) goto L46;
        r101 = r131.hashCode();
    L46:
        int r132 = (r130 + r101) * 31;
        if (this._is_std_expand == false) goto L49;
        int r133 = 1231;
    L51:
        return ((((((r132 + r133) * 31) + this._origin_method_unique_id.hashCode()) * 31) + this._to_method_unique_id.hashCode()) * 31) + this.isOneCentPurchaseExpand.hashCode();
    L49:
        r133 = 1237;
        goto L51
    L41:
        r129 = r128.hashCode();
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
        return "VoucherDialogExpandResult(voucher_no_list=" + this.voucher_no_list + ", expand_standard_rec_desc=" + this.expand_standard_rec_desc + ", expand_standard_show_amount=" + this.expand_standard_show_amount + ", bank_card_expand_standard_rec_desc=" + this.bank_card_expand_standard_rec_desc + ", bank_card_expand_standard_show_amount=" + this.bank_card_expand_standard_show_amount + ", bank_card_voucher_label=" + this.bank_card_voucher_label + ", combine_voucher_label=" + this.combine_voucher_label + ", voucher_label=" + this.voucher_label + ", _bankcard_id=" + this._bankcard_id + ", _credit_pay_installment=" + this._credit_pay_installment + ", expand_pay_type_desc=" + this.expand_pay_type_desc + ", expand_fee_desc=" + this.expand_fee_desc + ", expand_fee=" + this.expand_fee + ", _combine_type=" + this._combine_type + ", _is_std_expand=" + this._is_std_expand + ", _origin_method_unique_id=" + this._origin_method_unique_id + ", _to_method_unique_id=" + this._to_method_unique_id + ", isOneCentPurchaseExpand=" + this.isOneCentPurchaseExpand + ')';
    }

    public VoucherDialogExpandResult(List<String> r100, String r101, String r110, String r111, String r112, String r113, String r114, String r115, String r116, String r117, String r118, String r119, int r210, String r211, boolean r212, String r213, String r214, String r215) {
        Intrinsics.checkNotNullParameter(r118, "expand_pay_type_desc");
        Intrinsics.checkNotNullParameter(r119, "expand_fee_desc");
        Intrinsics.checkNotNullParameter(r213, "_origin_method_unique_id");
        Intrinsics.checkNotNullParameter(r214, "_to_method_unique_id");
        Intrinsics.checkNotNullParameter(r215, "isOneCentPurchaseExpand");
        this.voucher_no_list = r100;
        this.expand_standard_rec_desc = r101;
        this.expand_standard_show_amount = r110;
        this.bank_card_expand_standard_rec_desc = r111;
        this.bank_card_expand_standard_show_amount = r112;
        this.bank_card_voucher_label = r113;
        this.combine_voucher_label = r114;
        this.voucher_label = r115;
        this._bankcard_id = r116;
        this._credit_pay_installment = r117;
        this.expand_pay_type_desc = r118;
        this.expand_fee_desc = r119;
        this.expand_fee = r210;
        this._combine_type = r211;
        this._is_std_expand = r212;
        this._origin_method_unique_id = r213;
        this._to_method_unique_id = r214;
        this.isOneCentPurchaseExpand = r215;
    }

    public /* synthetic */ VoucherDialogExpandResult(List r210, String r211, String r212, String r213, String r214, String r215, String r216, String r217, String r218, String r219, String r310, String r311, int r312, String r313, boolean r314, String r315, String r316, String r317, int r318, DefaultConstructorMarker r319) {
        if ((r318 & 1) == 0) goto L5;
        List r100 = null;
    L7:
        if ((r318 & 2) == 0) goto L9;
        String r101 = null;
    L11:
        if ((r318 & 4) == 0) goto L13;
        String r102 = null;
    L15:
        if ((r318 & 8) == 0) goto L17;
        String r103 = null;
    L19:
        if ((r318 & 16) == 0) goto L21;
        String r104 = null;
    L23:
        if ((r318 & 32) == 0) goto L25;
        String r105 = null;
    L27:
        if ((r318 & 64) == 0) goto L29;
        String r106 = null;
    L31:
        if ((r318 & 128) == 0) goto L33;
        String r107 = null;
    L35:
        if ((r318 & 256) == 0) goto L37;
        String r110 = null;
    L39:
        if ((r318 & 512) == 0) goto L41;
        String r111 = null;
    L43:
        if ((r318 & 1024) == 0) goto L45;
        String r112 = "";
    L47:
        if ((r318 & 2048) == 0) goto L49;
        String r113 = "";
    L50:
        boolean r114 = false;
        if ((r318 & 4096) == 0) goto L53;
        int r115 = 0;
    L55:
        if ((r318 & 8192) == 0) goto L57;
        String r108 = null;
    L59:
        if ((r318 & 16384) != 0) goto L63;
        r114 = r314;
    L63:
        if ((32768 & r318) == 0) goto L65;
        String r116 = "";
    L67:
        if ((r318 & 65536) == 0) goto L69;
        String r117 = "";
    L71:
        if ((r318 & 131072) == 0) goto L73;
        String r109 = "0";
    L74:
        this(r100, r101, r102, r103, r104, r105, r106, r107, r110, r111, r112, r113, r115, r108, r114, r116, r117, r109);
        return;
    L73:
        r109 = r317;
        goto L74
    L69:
        r117 = r316;
        goto L71
    L65:
        r116 = r315;
        goto L67
    L57:
        r108 = r313;
        goto L59
    L53:
        r115 = r312;
        goto L55
    L49:
        r113 = r311;
        goto L50
    L45:
        r112 = r310;
        goto L47
    L41:
        r111 = r219;
        goto L43
    L37:
        r110 = r218;
        goto L39
    L33:
        r107 = r217;
        goto L35
    L29:
        r106 = r216;
        goto L31
    L25:
        r105 = r215;
        goto L27
    L21:
        r104 = r214;
        goto L23
    L17:
        r103 = r213;
        goto L19
    L13:
        r102 = r212;
        goto L15
    L9:
        r101 = r211;
        goto L11
    L5:
        r100 = r210;
        goto L7
    }
}
