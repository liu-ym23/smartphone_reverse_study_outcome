package com.android.ttcjpaysdk.ocr.presenter;

import com.android.ttcjpaysdk.base.CJPayConstant;
import com.android.ttcjpaysdk.base.CJPayHostInfo;
import com.android.ttcjpaysdk.base.network.CJPayNetworkManager;
import com.android.ttcjpaysdk.base.network.ICJPayCallback;
import com.android.ttcjpaysdk.base.network.ICJPayRequest;
import com.android.ttcjpaysdk.base.saas.CJPaySaasUtils;
import com.android.ttcjpaysdk.base.utils.CJPayParamsUtils;
import com.android.ttcjpaysdk.ocr.OCRService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes39.dex */
public class CJPayBasePresenter {
    private ArrayList<ICJPayRequest> listOfRequest;

    public void cancelRequest() {
        ArrayList<ICJPayRequest> r100 = this.listOfRequest;
        if (r100 == null) goto L17;
        Iterator<ICJPayRequest> r101 = r100.iterator();
    L6:
        if (r101.hasNext() == false) goto L10;
        ICJPayRequest r102 = r101.next();
        if (r102 == null) goto L6;
        r102.cancel();
        goto L6
    L10:
        this.listOfRequest.clear();
        return;
    }

    public CJPayBasePresenter() {
        this.listOfRequest = new ArrayList();
    }

    public void addRequest(ICJPayRequest r100) {
        ArrayList<ICJPayRequest> r101 = this.listOfRequest;
        if (r101 == null) goto L6;
        r101.add(r100);
        return;
    }

    public void sendRequest(ICJPayCallback r100, JSONObject r101, String r110) {
        String r102 = CJPayParamsUtils.getHttpUrl(r110, CJPayParamsUtils.getBDServerDomainAPI());
        CJPayHostInfo r103 = OCRService.hostInfo;
        String r104 = "";
        if (r103 == null) goto L5;
        String r105 = r103.appId;
    L6:
        if (r103 == null) goto L8;
        r104 = r103.merchantId;
    L8:
        HashMap r106 = new HashMap();
        if ("1".equals(OCRService.hostInfo.isCaijingSaas) == false) goto L12;
        r106.put(CJPayConstant.CAIJING_SAAS_REQUEST_ENV_HEADER, "saas");
    L14:
        addRequest(CJPayNetworkManager.postForm(r102, CJPayParamsUtils.getHttpData(r110, r101.toString(), r105, r104), CJPayParamsUtils.getNetHeaderData(r102, r110, r106), r100));
        return;
    L12:
        if ("0".equals(OCRService.hostInfo.isCaijingSaas) == false) goto L14;
        r106.put(CJPayConstant.CAIJING_SAAS_REQUEST_ENV_HEADER, CJPaySaasUtils.CAIJING_NO_SAAS_REQUEST_HEADER_MARK);
        goto L14
    L5:
        r105 = "";
        goto L6
    }
}
