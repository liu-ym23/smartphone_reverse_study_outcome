package com.android.ttcjpaysdk.bdpay.counter.outer.utils;

import com.alipay.sdk.m.p.e;
import com.android.ttcjpaysdk.base.ui.data.CJPayAddiItemInfo;
import com.android.ttcjpaysdk.base.ui.data.CJPayCreditPayMethods;
import com.android.ttcjpaysdk.base.ui.data.FrontPayTypeData;
import com.android.ttcjpaysdk.thirdparty.data.CJPayAddiParams;
import com.android.ttcjpaysdk.thirdparty.data.CJPayCheckoutCounterResponseBean;
import com.android.ttcjpaysdk.thirdparty.data.CJPayPaymentMethodInfo;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006J!\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\rJ,\u0010\u000e\u001a\u0016\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fj\n\u0012\u0004\u0012\u00020\u0010\u0018\u0001`\u00112\u0006\u0010\u0012\u001a\u00020\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014¨\u0006\u0015"}, d2 = {"Lcom/android/ttcjpaysdk/bdpay/counter/outer/utils/CJPayOuterPayMethodUtils;", "", "()V", "getChoseCreditMethod", "Lcom/android/ttcjpaysdk/base/ui/data/CJPayCreditPayMethods;", "paymentMethodInfo", "Lcom/android/ttcjpaysdk/thirdparty/data/CJPayPaymentMethodInfo;", "getPaymentMethodRawDataByIndex", "Lorg/json/JSONObject;", "counterResponse", "Lcom/android/ttcjpaysdk/thirdparty/data/CJPayCheckoutCounterResponseBean;", "chooseIndex", "", "(Lcom/android/ttcjpaysdk/thirdparty/data/CJPayCheckoutCounterResponseBean;Ljava/lang/Integer;)Lorg/json/JSONObject;", "getVoucherNoList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", e.f25671s, "payAddiParams", "Lcom/android/ttcjpaysdk/thirdparty/data/CJPayAddiParams;", "bdpay-counter-outer_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJPayOuterPayMethodUtils {
    public static final CJPayOuterPayMethodUtils INSTANCE = null;

    static {
        INSTANCE = new CJPayOuterPayMethodUtils();
    }

    private CJPayOuterPayMethodUtils() {
    }

    public final CJPayCreditPayMethods getChoseCreditMethod(CJPayPaymentMethodInfo r100) {
        Object r101 = null;
        if (r100 == null) goto L7;
        FrontPayTypeData r102 = r100.pay_type_data;
        if (r102 == null) goto L7;
        ArrayList<CJPayCreditPayMethods> r103 = r102.credit_pay_methods;
    L8:
        if (r103 == null) goto L20;
        Iterator<T> r104 = r103.iterator();
    L11:
        if (r104.hasNext() == false) goto L16;
        Object r105 = r104.next();
        if (((CJPayCreditPayMethods) r105).choose == false) goto L11;
        r101 = r105;
    L16:
        return (CJPayCreditPayMethods) r101;
    L20:
        return null;
    L7:
        r103 = null;
        goto L8
    }

    public final JSONObject getPaymentMethodRawDataByIndex(CJPayCheckoutCounterResponseBean r100, Integer r101) {
        if (r100 == null) goto L28;
        if (r101 == null) goto L28;
        JSONObject r102 = new JSONObject(r100.rawString).optJSONObject("paytype_info");
        if (r102 == null) goto L11;
        JSONObject r103 = r102.optJSONObject("sub_pay_type_sum_info");
        if (r103 == null) goto L11;
        JSONArray r104 = r103.optJSONArray("sub_pay_type_info_list");
    L12:
        if (r104 == null) goto L28;
        int r105 = r104.length();
        if (r105 < 0) goto L28;
        int r106 = 0;
    L16:
        Object r107 = r104.get(r106);
        if ((r107 instanceof JSONObject) == false) goto L19;
        JSONObject r108 = (JSONObject) r107;
    L20:
        if (r108 == null) goto L22;
        Integer r109 = Integer.valueOf(r108.optInt("index"));
    L24:
        if (Intrinsics.areEqual(r109, r101) == true) goto L25;
        if (r106 == r105) goto L28;
        r106 = r106 + 1;
        goto L16
    L25:
        return r108;
    L22:
        r109 = null;
        goto L24
    L19:
        r108 = null;
    L11:
        r104 = null;
    L28:
        return null;
    }

    public final ArrayList<String> getVoucherNoList(CJPayPaymentMethodInfo r100, CJPayAddiParams r101) {
        Intrinsics.checkNotNullParameter(r100, e.f25671s);
        boolean r102 = true;
        if (r101 != null) goto L5;
    L7:
        boolean r103 = false;
    L8:
        if (r103 == false) goto L24;
        CJPayAddiItemInfo r104 = r101.getAddiItemInfo();
        if (r104 != null) goto L12;
    L14:
        r102 = false;
    L15:
        if (r102 == false) goto L24;
        ArrayList<String> r105 = new ArrayList();
        ArrayList<String> r106 = r104.voucher_no_list;
        if (r106 == null) goto L22;
        Iterator<T> r107 = r106.iterator();
    L20:
        if (r107.hasNext() == false) goto L22;
        r105.add((String) r107.next());
    L22:
        return r105;
    L12:
        if (r104.has_discount != true) goto L14;
    L24:
        return r100.voucher_no_list;
    L5:
        if (r101.isOpen() != true) goto L7;
        r103 = true;
        goto L8
    }
}
