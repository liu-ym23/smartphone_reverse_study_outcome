package com.android.ttcjpaysdk.bindcard.base.utils;

import com.android.ttcjpaysdk.base.ui.data.CJPayVoucherInfo;
import com.android.ttcjpaysdk.base.utils.CJBasicCommonUtils;
import com.android.ttcjpaysdk.bindcard.base.bean.CJPayBankInfoBean;
import com.android.ttcjpaysdk.bindcard.base.constants.CJPayBindCardType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0014\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nJ2\u0010\f\u001a\u00020\b2\"\u0010\u0005\u001a\u001e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\rj\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f`\u00102\u0006\u0010\u0011\u001a\u00020\u000e¨\u0006\u0012"}, d2 = {"Lcom/android/ttcjpaysdk/bindcard/base/utils/BindCardVoucherLogUtil;", "", "()V", "createReportDiscountInfo", "Lorg/json/JSONObject;", "info", "Lcom/android/ttcjpaysdk/base/ui/data/CJPayVoucherInfo$Voucher;", "getAllDiscountInfo", "Lorg/json/JSONArray;", "list", "Ljava/util/ArrayList;", "Lcom/android/ttcjpaysdk/bindcard/base/bean/CJPayBankInfoBean;", "getDiscountReportInfo", "Ljava/util/HashMap;", "", "Lcom/android/ttcjpaysdk/base/ui/data/CJPayVoucherInfo;", "Lkotlin/collections/HashMap;", "voucherKey", "bdpay-bindcard-base_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class BindCardVoucherLogUtil {
    public static final BindCardVoucherLogUtil INSTANCE = null;

    static {
        INSTANCE = new BindCardVoucherLogUtil();
    }

    private BindCardVoucherLogUtil() {
    }

    private final JSONObject createReportDiscountInfo(CJPayVoucherInfo.Voucher r100) {
        JSONObject r101 = new JSONObject();
        r101.put("id", r100.voucher_no);     // Catch: Exception -> L9
        if (Intrinsics.areEqual(r100.voucher_type, "discount_voucher") == false) goto L6;
        int r102 = 0;
    L7:
        r101.put("type", r102);     // Catch: Exception -> L9
        r101.put("reduce", r100.reduce_amount);     // Catch: Exception -> L9
        r101.put("label", r100.label);     // Catch: Exception -> L9
        r101.put("front_bank_code", r100.front_bank_code);     // Catch: Exception -> L9
    L11:
        return r101;
    L6:
        r102 = 1;
    L9:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("BindCardVoucherLogUtil#createReportDiscountInfo", e);
        CJBasicCommonUtils.logCatch("CJCatch", "BindCardVoucherLogUtil#createReportDiscountInfo", e);
        goto L11
    }

    public final JSONArray getAllDiscountInfo(ArrayList<CJPayBankInfoBean> r100) {
        Intrinsics.checkNotNullParameter(r100, "list");
        JSONArray r101 = new JSONArray();
        Iterator<T> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L26;
        CJPayBankInfoBean r103 = (CJPayBankInfoBean) r102.next();
        if (Intrinsics.areEqual(r103.card_type, CJPayBindCardType.ALL.mType) == true) goto L7;
        CJPayVoucherInfo r104 = r103.getVoucherInfoMap().get(r103.card_type);
        if (r104 == null) goto L4;
        ArrayList<CJPayVoucherInfo.Voucher> r105 = r104.vouchers;
        if (r105 == null) goto L4;
        Iterator<T> r106 = r105.iterator();
    L24:
        if (r106.hasNext() == false) goto L4;
        CJPayVoucherInfo.Voucher r107 = (CJPayVoucherInfo.Voucher) r106.next();
        r101.put(INSTANCE.createReportDiscountInfo(r107));
        goto L24
    L7:
        Iterator<T> r108 = r103.getVoucherInfoMap().keySet().iterator();
    L9:
        if (r108.hasNext() == false) goto L4;
        String r109 = (String) r108.next();
        CJPayVoucherInfo r110 = r103.getVoucherInfoMap().get(r109);
        if (r110 == null) goto L9;
        ArrayList<CJPayVoucherInfo.Voucher> r111 = r110.vouchers;
        if (r111 == null) goto L9;
        Iterator<T> r112 = r111.iterator();
    L16:
        if (r112.hasNext() == false) goto L9;
        CJPayVoucherInfo.Voucher r113 = (CJPayVoucherInfo.Voucher) r112.next();
        r101.put(INSTANCE.createReportDiscountInfo(r113));
        goto L16
    L26:
        return r101;
    }

    public final JSONArray getDiscountReportInfo(HashMap<String, CJPayVoucherInfo> r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "info");
        Intrinsics.checkNotNullParameter(r101, "voucherKey");
        JSONArray r102 = new JSONArray();
        if (Intrinsics.areEqual(r101, CJPayBindCardType.ALL.mType) == false) goto L15;
        Iterator<T> r103 = r100.keySet().iterator();
    L6:
        if (r103.hasNext() == false) goto L23;
        CJPayVoucherInfo r104 = r100.get((String) r103.next());
        if (r104 == null) goto L6;
        ArrayList<CJPayVoucherInfo.Voucher> r105 = r104.vouchers;
        if (r105 == null) goto L6;
        Iterator<T> r106 = r105.iterator();
    L13:
        if (r106.hasNext() == false) goto L6;
        CJPayVoucherInfo.Voucher r107 = (CJPayVoucherInfo.Voucher) r106.next();
        r102.put(INSTANCE.createReportDiscountInfo(r107));
    L23:
        return r102;
    L15:
        CJPayVoucherInfo r108 = r100.get(r101);
        if (r108 == null) goto L23;
        ArrayList<CJPayVoucherInfo.Voucher> r109 = r108.vouchers;
        if (r109 == null) goto L23;
        Iterator<T> r110 = r109.iterator();
    L21:
        if (r110.hasNext() == false) goto L23;
        CJPayVoucherInfo.Voucher r111 = (CJPayVoucherInfo.Voucher) r110.next();
        r102.put(INSTANCE.createReportDiscountInfo(r111));
        goto L21
    }
}
