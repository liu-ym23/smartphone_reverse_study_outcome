package com.android.ttcjpaysdk.bdpay.bindcard.lynx;

import android.content.Context;
import com.android.ttcjpaysdk.base.CJPayHostInfo;
import com.android.ttcjpaysdk.base.CJPayTrackReport;
import com.android.ttcjpaysdk.base.service.ICJPayFrontMyBankCardService;
import com.android.ttcjpaysdk.base.service.annotation.CJPayModuleEntryReport;
import com.android.ttcjpaysdk.bindcard.base.utils.BindCardCommonInfoUtil;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
public class CJPayLynxMyBankCardProvider implements ICJPayFrontMyBankCardService {
    public CJPayLynxMyBankCardProvider() {
    }

    @Override // com.android.ttcjpaysdk.base.service.ICJPayService
    public String getPackageName() {
        return "lynx-my-bank-card-provider";
    }

    @Override // com.android.ttcjpaysdk.base.service.ICJPayFrontMyBankCardService
    @CJPayModuleEntryReport
    public void startFrontMyBankCard(Context r100, JSONObject r101) {
        BindCardCommonInfoUtil.INSTANCE.setHostInfo(CJPayHostInfo.toBean(r101));
        CJPayTrackReport.getInstance().doTrackReport(CJPayTrackReport.Scenes.START_MY_CARD.getValue(), "调用api耗时", "");
        CJLynxBankCardRouteUtil.routeBankCardActivity(r100, null);
    }

    @Override // com.android.ttcjpaysdk.base.service.ICJPayFrontMyBankCardService
    public void startFrontMyBankCardWithSchema(Context r100, String r101, JSONObject r102) {
        BindCardCommonInfoUtil.INSTANCE.setHostInfo(CJPayHostInfo.toBean(r102));
        CJPayTrackReport.getInstance().doTrackReport(CJPayTrackReport.Scenes.START_MY_CARD.getValue(), "调用api耗时", "");
        CJLynxBankCardRouteUtil.routeBankCardActivity(r100, r101);
    }
}
