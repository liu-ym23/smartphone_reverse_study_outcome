package com.android.ttcjpaysdk.ocr;

import android.content.Context;
import android.text.TextUtils;
import com.android.ttcjpaysdk.base.BuildConfig;
import com.android.ttcjpaysdk.base.CJPayHostInfo;
import com.android.ttcjpaysdk.base.h5.cjjsb.abs.AbsJsbOcr;
import com.android.ttcjpaysdk.base.service.ICJPayOCRService;
import com.android.ttcjpaysdk.base.service.ICJPayServiceRetCallBack;
import com.android.ttcjpaysdk.base.service.annotation.CJPayModuleEntryReport;
import com.android.ttcjpaysdk.ocr.controller.CJOCRManager;
import com.android.ttcjpaysdk.ocr.utils.OCREnumType;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes39.dex */
public class OCRService implements ICJPayOCRService {
    public static CJPayHostInfo hostInfo;

    public OCRService() {
    }

    @Override // com.android.ttcjpaysdk.base.service.ICJPayService
    public String getPackageName() {
        return BuildConfig.LIBRARY_PACKAGE_NAME;
    }

    @Override // com.android.ttcjpaysdk.base.service.ICJPayOCRService
    public void release() {
        OCRDevice.getInstance().setCallBack(null);
    }

    @Override // com.android.ttcjpaysdk.base.service.ICJPayOCRService
    @CJPayModuleEntryReport
    public void startOCR(Context r100, JSONObject r101, ICJPayServiceRetCallBack r102) {
        CJOCRManager.INSTANCE.startOCRProcess(r100, r101, r102);
    }

    @Override // com.android.ttcjpaysdk.base.service.ICJPayOCRService
    @CJPayModuleEntryReport
    public void startOCRForIdCard(Context r100, AbsJsbOcr.OcrInput r101, String r102, JSONObject r103, ICJPayServiceRetCallBack r104) {
        CJPayHostInfo r105 = CJPayHostInfo.toBean(r103);
        hostInfo = r105;
        r105.merchantId = r101.merchant_id;
        if (TextUtils.isEmpty(r101.app_id) == true) goto L6;
        CJPayHostInfo r106 = hostInfo;
        r106.appId = r101.app_id;
    L6:
        if (OCREnumType.ID_CARD_FXJ.getType().equals(r101.type) == false) goto L8;
        OCRDevice.startIDCardOCRForFxj(r100, r101, r102, r104);
        return;
    L8:
        OCRDevice.startIDCardOCR(r100, r101, r102, r104);
    }

    @Override // com.android.ttcjpaysdk.base.service.ICJPayOCRService
    @CJPayModuleEntryReport
    public void startOCROptionV2(Context r100, AbsJsbOcr.OcrInput r101, String r102, JSONObject r103, JSONObject r104, ICJPayServiceRetCallBack r105) {
        CJPayHostInfo r106 = CJPayHostInfo.toBean(r103);
        hostInfo = r106;
        r106.merchantId = r101.merchant_id;
        if (TextUtils.isEmpty(r101.app_id) == true) goto L5;
        CJPayHostInfo r107 = hostInfo;
        r107.appId = r101.app_id;
    L5:
        OCRDevice.startOCROptionV2(r100, r101, r102, r104, r105);
    }

    @Override // com.android.ttcjpaysdk.base.service.ICJPayOCRService
    @CJPayModuleEntryReport
    public void startOCRForPassportId(Context r100, String r101, String r110, int r111, String r112, JSONObject r113, String r114, JSONObject r115, String r116, ICJPayServiceRetCallBack r117) {
        CJPayHostInfo r102 = CJPayHostInfo.toBean(r115);
        hostInfo = r102;
        r102.merchantId = r101;
        if (TextUtils.isEmpty(r110) == true) goto L5;
        hostInfo.appId = r110;
    L5:
        OCRDevice.startPassportIdOCR(r100, r111, r112, r113, r114, r116, r117);
    }

    @Override // com.android.ttcjpaysdk.base.service.ICJPayOCRService
    @CJPayModuleEntryReport
    public void startOCR(Context r100, String r110, String r111, String r112, String r113, String r114, JSONObject r115, String r116, String r117, String r118, ICJPayServiceRetCallBack r119) {
        CJPayHostInfo r101 = CJPayHostInfo.toBean(r115);
        hostInfo = r101;
        r101.merchantId = r110;
        if (TextUtils.isEmpty(r111) == true) goto L5;
        hostInfo.appId = r111;
    L5:
        OCRDevice.startBankOCR(r100, r112, r113, r114, r116, r117, r118, r119);
    }

    @Override // com.android.ttcjpaysdk.base.service.ICJPayOCRService
    @CJPayModuleEntryReport
    public void startOCRForIdentity(Context r100, String r110, String r111, int r112, String r113, String r114, JSONObject r115, String r116, String r117, String r118, ICJPayServiceRetCallBack r119) {
        CJPayHostInfo r101 = CJPayHostInfo.toBean(r115);
        hostInfo = r101;
        r101.merchantId = r110;
        if (TextUtils.isEmpty(r111) == true) goto L5;
        hostInfo.appId = r111;
    L5:
        OCRDevice.startIdentityOCR(r100, r112, r113, r114, r116, r117, r118, r119);
    }
}
