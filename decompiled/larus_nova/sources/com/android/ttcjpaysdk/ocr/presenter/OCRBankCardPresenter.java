package com.android.ttcjpaysdk.ocr.presenter;

import android.util.Base64;
import com.android.ttcjpaysdk.base.encrypt.CJEncryptScene;
import com.android.ttcjpaysdk.base.encrypt.CJPayEncryptHelper;
import com.android.ttcjpaysdk.base.encrypt.CJPaySecureRequestParams;
import com.android.ttcjpaysdk.base.network.ICJPayCallback;
import com.android.ttcjpaysdk.base.utils.CJBasicCommonUtils;
import com.android.ttcjpaysdk.ocr.OCRDevice;
import com.android.ttcjpaysdk.verify.constants.DyVerifyReqConstants;
import com.bytedance.android.ec.core.event.a;
import com.bytedance.caijing.sdk.infra.base.logger.CJLogger;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes39.dex */
public class OCRBankCardPresenter extends CJPayBasePresenter {
    public OCRBankCardPresenter() {
    }

    public void fetchOCRResult(byte[] r100, ICJPayCallback r101) {
        JSONObject r102 = new JSONObject();
        CJEncryptScene r103 = CJEncryptScene.OCR;     // Catch: Throwable -> L5
        r102.put("img_data", CJPayEncryptHelper.getEncryptDataSM(r103, Base64.encodeToString(r100, 2), "ocr-银行卡", "img_data"));     // Catch: Throwable -> L5
        r102.put(DyVerifyReqConstants.Key.RISK_INFO, OCRDevice.getInstance().getRiskInfo());     // Catch: Throwable -> L5
        CJPaySecureRequestParams r104 = new CJPaySecureRequestParams();     // Catch: Throwable -> L5
        r104.fields.add("ext");     // Catch: Throwable -> L5
        r104.fields.add("img_data");     // Catch: Throwable -> L5
        r102.put("ext", CJPayEncryptHelper.getEncryptDataSM(r103, "ext", "ocr-银行卡", "ext"));     // Catch: Throwable -> L5
        r102.put(DyVerifyReqConstants.Key.SECURE_REQUEST_PARAMS, r104.toJson(r103));     // Catch: Throwable -> L5
        sendRequest(r101, r102, "bytepay.member_product.get_card_no_by_ocr");     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        CJBasicCommonUtils.reportCatchException("OCRBankCardPresenter#fetchOCRResult", th);
        CJLogger.d("ocrtest", a.KEY_EXCEPTION);
        th.printStackTrace();
    }
}
