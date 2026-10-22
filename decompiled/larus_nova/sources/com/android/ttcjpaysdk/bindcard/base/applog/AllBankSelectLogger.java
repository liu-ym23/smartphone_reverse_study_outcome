package com.android.ttcjpaysdk.bindcard.base.applog;

import com.android.ttcjpaysdk.base.framework.mvp.base.MvpLogger;
import com.android.ttcjpaysdk.base.ktextension.KtSafeMethodExtensionKt;
import com.android.ttcjpaysdk.base.utils.CJPayParamsUtils;
import com.android.ttcjpaysdk.bindcard.base.bean.QuickBindCardAdapterBean;
import com.android.ttcjpaysdk.bindcard.base.utils.BindCardCommonInfoUtil;
import com.android.ttcjpaysdk.bindcard.base.utils.CJPayBindCardLogUtils;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0005J\u0014\u0010\n\u001a\u00020\u00072\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/android/ttcjpaysdk/bindcard/base/applog/AllBankSelectLogger;", "Lcom/android/ttcjpaysdk/base/framework/mvp/base/MvpLogger;", "()V", "quickBindCardList", "Ljava/util/ArrayList;", "Lcom/android/ttcjpaysdk/bindcard/base/bean/QuickBindCardAdapterBean;", "allBankSelectPageImp", "", "bankClick", "bankInfo", "initParams", "bdpay-bindcard-base_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class AllBankSelectLogger implements MvpLogger {
    private ArrayList<QuickBindCardAdapterBean> quickBindCardList;

    public final void allBankSelectPageImp() {
        BindCardCommonInfoUtil r100 = BindCardCommonInfoUtil.INSTANCE;
        JSONObject r101 = CJPayParamsUtils.getCommonLogParams(r100.getMerchantId(), r100.getAppId());
        if (r101 == null) goto L6;
        CJPayBindCardLogUtils.doReport("wallet_addbcard_onestep_bank_list_page_imp", new JSONObject[]{r101});
        return;
    }

    public AllBankSelectLogger() {
        this.quickBindCardList = new ArrayList();
    }

    public final void bankClick(QuickBindCardAdapterBean r100) {
        Intrinsics.checkNotNullParameter(r100, "bankInfo");
        BindCardCommonInfoUtil r101 = BindCardCommonInfoUtil.INSTANCE;
        JSONObject r102 = CJPayParamsUtils.getCommonLogParams(r101.getMerchantId(), r101.getAppId());
        if (r102 == null) goto L6;
        KtSafeMethodExtensionKt.safePut(r102, "bank_name", r100.bankName);
        CJPayBindCardLogUtils.doReport("wallet_addbcard_onestep_bank_list_page_click", new JSONObject[]{r102});
        return;
    }

    public final void initParams(ArrayList<QuickBindCardAdapterBean> r100) {
        Intrinsics.checkNotNullParameter(r100, "quickBindCardList");
        this.quickBindCardList = r100;
    }
}
