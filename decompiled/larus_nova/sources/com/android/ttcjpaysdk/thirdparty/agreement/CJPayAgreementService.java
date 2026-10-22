package com.android.ttcjpaysdk.thirdparty.agreement;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.android.ttcjpaysdk.base.json.CJPayJsonParser;
import com.android.ttcjpaysdk.base.service.ICJPayAgreementCallback;
import com.android.ttcjpaysdk.base.service.ICJPayAgreementService;
import com.android.ttcjpaysdk.base.service.annotation.CJPayModuleEntryReport;
import com.android.ttcjpaysdk.base.ui.data.CJPayCardProtocolBean;
import com.android.ttcjpaysdk.thirdparty.agreement.activity.CJPayAgreementActivity;
import com.android.ttcjpaysdk.thirdparty.agreement.fragment.CJPayAgreementDetailFragment;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes39.dex */
public class CJPayAgreementService implements ICJPayAgreementService {
    public static ICJPayAgreementCallback agreementCallback;

    public CJPayAgreementService() {
    }

    @Override // com.android.ttcjpaysdk.base.service.ICJPayService
    public String getPackageName() {
        return BuildConfig.LIBRARY_PACKAGE_NAME;
    }

    @Override // com.android.ttcjpaysdk.base.service.ICJPayAgreementService
    public Fragment getAgreementDetailFragment(ICJPayAgreementService.AgreementDetailParams r100) {
        CJPayAgreementDetailFragment r101 = new CJPayAgreementDetailFragment();
        r101.setAgreementInfo(r100.url, r100.title);
        Bundle r102 = new Bundle();
        r102.putBoolean("param_show_next_btn", false);
        r102.putBoolean("params_show_with_animation", true);
        r102.putInt("param_height", r100.height);
        r102.putBoolean("param_is_back_close", r100.isBackClose);
        if (r100.isCardStyle == false) goto L5;
        String r103 = CJPayAgreementDetailFragment.UI_STYLE_CARD;
    L6:
        r102.putString(CJPayAgreementDetailFragment.PARAM_UI_STYLE, r103);
        r102.putBoolean(CJPayAgreementDetailFragment.PARAM_FROM_DIALOG_FRAGMENT, r100.isFromDialog);
        r101.setArguments(r102);
        return r101;
    L5:
        r103 = "";
        goto L6
    }

    @Override // com.android.ttcjpaysdk.base.service.ICJPayAgreementService
    @CJPayModuleEntryReport
    public void startCJPayAgreementActivity(Context r100, ArrayList<JSONObject> r110, boolean r111, ICJPayAgreementCallback r112) {
        if (r100 != null) goto L4;
        return;
    L4:
        agreementCallback = r112;
        if (r110.size() <= 1) goto L7;
        int r101 = 0;
    L8:
        startCJPayAgreementActivity(r100, r110, r101, r111, r112);
        return;
    L7:
        r101 = 1;
        goto L8
    }

    @Override // com.android.ttcjpaysdk.base.service.ICJPayAgreementService
    @CJPayModuleEntryReport
    public void startCJPayAgreementActivity(Context r100, ArrayList<JSONObject> r110, int r111, boolean r112, ICJPayAgreementCallback r113) {
        if (r100 != null) goto L4;
        return;
    L4:
        agreementCallback = r113;
        ArrayList r101 = new ArrayList();
        Iterator<JSONObject> r114 = r110.iterator();
    L6:
        if (r114.hasNext() == false) goto L8;
        r101.add((CJPayCardProtocolBean) CJPayJsonParser.fromJson(r114.next(), CJPayCardProtocolBean.class));
        goto L6
    L8:
        CJPayAgreementActivity.start(r100, r111, r101, false, false, true, false, r112);
    }

    @Override // com.android.ttcjpaysdk.base.service.ICJPayAgreementService
    @CJPayModuleEntryReport
    public void startCJPayAgreementActivityWithHeight(Context r110, ArrayList<JSONObject> r111, int r112, boolean r113, ICJPayAgreementCallback r114) {
        if (r110 != null) goto L4;
        return;
    L4:
        agreementCallback = r114;
        if (r111.size() <= 1) goto L7;
        int r100 = 0;
    L8:
        ArrayList r101 = new ArrayList();
        Iterator<JSONObject> r115 = r111.iterator();
    L10:
        if (r115.hasNext() == false) goto L12;
        r101.add((CJPayCardProtocolBean) CJPayJsonParser.fromJson(r115.next(), CJPayCardProtocolBean.class));
        goto L10
    L12:
        CJPayAgreementActivity.start(r110, r100, r101, r112, false, false, true, false, r113);
        return;
    L7:
        r100 = 1;
        goto L8
    }

    @Override // com.android.ttcjpaysdk.base.service.ICJPayAgreementService
    @CJPayModuleEntryReport
    public void startCJPayAgreementActivityWithHeight(Context r110, ArrayList<JSONObject> r111, int r112, boolean r113, boolean r114, ICJPayAgreementCallback r115) {
        if (r110 != null) goto L4;
        return;
    L4:
        agreementCallback = r115;
        int r100 = 1;
        if (r111.size() <= 1) goto L7;
        r100 = 0;
    L7:
        ArrayList r101 = new ArrayList();
        Iterator<JSONObject> r102 = r111.iterator();
    L9:
        if (r102.hasNext() == false) goto L11;
        r101.add((CJPayCardProtocolBean) CJPayJsonParser.fromJson(r102.next(), CJPayCardProtocolBean.class));
        goto L9
    L11:
        CJPayAgreementActivity.start(r110, r100, r101, r112, false, false, true, false, r113, r114);
    }
}
