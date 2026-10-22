package com.android.ttcjpaysdk.bindcard.base.utils;

import android.content.Context;
import com.android.ttcjpaysdk.base.CJPayHostInfo;
import com.android.ttcjpaysdk.bindcard.base.bean.CJPayBankInfoBean;
import com.android.ttcjpaysdk.bindcard.base.bean.QuickBindCardAdapterBean;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J&\u0010\u0007\u001a\u00020\b2\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\n2\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\n¨\u0006\f"}, d2 = {"Lcom/android/ttcjpaysdk/bindcard/base/utils/DataConvertUtil;", "", "()V", "cjPayBankInfoBean2QuickBindCardAdapterBean", "Lcom/android/ttcjpaysdk/bindcard/base/bean/QuickBindCardAdapterBean;", "bankInfo", "Lcom/android/ttcjpaysdk/bindcard/base/bean/CJPayBankInfoBean;", "cjPayBankInfoBean2QuickBindCardAdapterBeanList", "", "srcDataList", "Ljava/util/ArrayList;", "resultDataList", "bdpay-bindcard-base_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DataConvertUtil {
    public static final DataConvertUtil INSTANCE = null;

    static {
        INSTANCE = new DataConvertUtil();
    }

    private DataConvertUtil() {
    }

    public final QuickBindCardAdapterBean cjPayBankInfoBean2QuickBindCardAdapterBean(CJPayBankInfoBean r100) {
        Intrinsics.checkNotNullParameter(r100, "bankInfo");
        Context r101 = CJPayHostInfo.applicationContext;
        String r102 = "";
        if (r101 == null) goto L5;
        Intrinsics.checkNotNull(r101);
        String r103 = r101.getResources().getString(R.string.cj_pay_quick_bind_card_item_support_debit_only);
    L6:
        Context r104 = CJPayHostInfo.applicationContext;
        if (r104 == null) goto L9;
        Intrinsics.checkNotNull(r104);
        String r105 = r104.getResources().getString(R.string.cj_pay_quick_bind_card_item_support_credit_only);
    L10:
        QuickBindCardAdapterBean r106 = new QuickBindCardAdapterBean();
        r106.backgroundColor = r100.background_color;
        r106.bankName = r100.bank_name;
        r106.bankIconUrl = r100.icon_url;
        r106.iconBackground = r100.icon_background;
        r106.cardType = r100.card_type;
        r106.bankCode = r100.bank_code;
        r106.debitVoucher = r100.getDebitVoucher();
        r106.creditVoucher = r100.getCreditVoucher();
        r106.unionPayVoucher = r100.getUnionPayVoucher();
        r106.homePageVoucher = r100.getHomePageVoucher();
        r106.debitHomePageVoucher = r100.getDebitHomePageVoucher();
        r106.creditHomePageVoucher = r100.getCreditHomePageVoucher();
        r106.cardBinVoucher = r100.getCardBinVoucher();
        r106.debitCardBinVoucher = r100.getDebitCardBinVoucher();
        r106.creditCardBinVoucher = r100.getCreditCardBinVoucher();
        r106.voucher_info_map = r100.getVoucherInfoMap();
        r106.bank_rank = r100.bank_rank;
        r106.rank_type = r100.rank_type;
        r106.is_support_one_key = r100.is_support_one_key;
        if (Intrinsics.areEqual("DEBIT", r100.card_type) == false) goto L14;
        r102 = r103;
    L16:
        r106.descLable = r102;
        r106.jumpBindCardType = r100.jump_bind_card_type;
        r106.bankInitials = r100.bank_initials;
        r106.bankPopularFlag = r100.bank_popular_flag;
        r106.bankSortNumber = r100.bank_sort_number;
        r106.showDebitVoucher = r100.showDebitVoucher();
        r106.showCreditVoucher = r100.showCreditVoucher();
        return r106;
    L14:
        if (Intrinsics.areEqual("CREDIT", r100.card_type) == false) goto L16;
        r102 = r105;
        goto L16
    L9:
        r105 = "";
        goto L10
    L5:
        r103 = "";
        goto L6
    }

    public final void cjPayBankInfoBean2QuickBindCardAdapterBeanList(ArrayList<CJPayBankInfoBean> r100, ArrayList<QuickBindCardAdapterBean> r101) {
        if (r101 == null) goto L16;
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.size() <= 0) goto L21;
        int r102 = r100.size();
        int r103 = 0;
    L8:
        if (r103 >= r102) goto L22;
        if (BindCardCommonInfoUtil.INSTANCE.getHostInfo().isUnionPayEnable() == false) goto L12;
    L14:
        r101.add(cjPayBankInfoBean2QuickBindCardAdapterBean((CJPayBankInfoBean) ListProtector.get(r100, r103)));
    L15:
        r103 = r103 + 1;
        goto L8
    L12:
        if (((CJPayBankInfoBean) ListProtector.get(r100, r103)).isUnionPay() == false) goto L14;
    L22:
        return;
    L21:
        return;
    }
}
