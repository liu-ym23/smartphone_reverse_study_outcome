package com.android.ttcjpaysdk.ocr;

import android.content.Context;
import com.android.ttcjpaysdk.base.h5.cjjsb.abs.AbsJsbOcr;
import com.android.ttcjpaysdk.base.json.CJPayJsonParser;
import com.android.ttcjpaysdk.base.router.CJPayRouterAPI;
import com.android.ttcjpaysdk.base.service.ICJPayServiceRetCallBack;
import com.android.ttcjpaysdk.base.settings.abtest.CJPayABExperimentKeys;
import com.android.ttcjpaysdk.base.settings.bean.CJPayOcrOptConfig;
import com.android.ttcjpaysdk.ocr.activity.CJPayOCRBankCardActivity;
import com.android.ttcjpaysdk.ocr.activity.CJPayOCRIDCardActivity;
import com.android.ttcjpaysdk.ocr.activity.CJPayOCRIDCardOptActivity;
import com.android.ttcjpaysdk.ocr.activity.CJPayOCRIdentityActivity;
import com.android.ttcjpaysdk.ocr.activity.CJPayOCROptionActivityV2;
import com.android.ttcjpaysdk.ocr.activity.CJPayOCRPassportActivity;
import com.android.ttcjpaysdk.ocr.data.CJOCRSettingsConfig;
import com.android.ttcjpaysdk.ocr.utils.OCRImageCdn;
import java.lang.reflect.GenericDeclaration;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes39.dex */
public class OCRDevice {
    public static final String KEY_CJ_PAY_OCR_SUB_TITLE = "key_cj_pay_ocr_sub_title";
    public static final String KEY_CJ_PAY_OCR_TITLE = "key_cj_pay_ocr_title";
    public static final String KEY_CJ_PAY_OCR_TYPE = "scene";
    private static volatile OCRDevice mInstance;
    private String backUploadInteface;
    private JSONObject extParams;
    private String frontUploadInteface;
    private ICJPayServiceRetCallBack mCallBack;
    private int mCompressSize;
    private String mParams;
    private String mRiskInfo;
    private String mRule;
    private CJPayOcrOptConfig ocrOptConfig;
    private String publicKey;
    private String tipsContent;
    private String tipsIconUrl;
    private String type;

    public void release() {
        setCallBack(null);
    }

    public static OCRDevice getInstance() {
        if (mInstance != null) goto L15;
        monitor-enter(OCRDevice.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (mInstance != null) goto L9;
        mInstance = new OCRDevice();     // Catch: Throwable -> L11
    L9:
        monitor-exit(OCRDevice.class);     // Catch: Throwable -> L11
    L15:
        return mInstance;
    }

    public int getCompressSize() {
        if (this.mCompressSize >= 0) goto L12;
        if ("1".equals(this.ocrOptConfig.compress_opt) == false) goto L9;
        int r100 = this.ocrOptConfig.default_compress_size_kb;
        if (r100 < 0) goto L9;
    L10:
        this.mCompressSize = r100;
    L9:
        r100 = 0;
    L12:
        return this.mCompressSize;
    }

    private OCRDevice() {
        this.ocrOptConfig = CJPayABExperimentKeys.getOcrOptConfig().value(true);
        this.frontUploadInteface = "";
        this.backUploadInteface = "";
        this.publicKey = "";
        this.type = "";
        this.tipsIconUrl = "";
        this.tipsContent = "";
    }

    public ICJPayServiceRetCallBack getCallBack() {
        return this.mCallBack;
    }

    public JSONObject getExtParams() {
        return this.extParams;
    }

    public String getParams() {
        return this.mParams;
    }

    public String getRiskInfo() {
        return this.mRiskInfo;
    }

    public String getRule() {
        return this.mRule;
    }

    public String getTipsContent() {
        return this.tipsContent;
    }

    public String getTipsIconUrl() {
        return this.tipsIconUrl;
    }

    public String getType() {
        return this.type;
    }

    public void setCallBack(ICJPayServiceRetCallBack r100) {
        this.mCallBack = r100;
    }

    public void setCompressSize(int r100) {
        this.mCompressSize = r100;
    }

    public void setExtParams(JSONObject r100) {
        this.extParams = r100;
    }

    public void setParams(String r100) {
        this.mParams = r100;
    }

    public void setRiskInfo(String r100) {
        this.mRiskInfo = r100;
    }

    public void setRule(String r100) {
        this.mRule = r100;
    }

    public void setType(String r100) {
        if (r100 != null) goto L4;
        r100 = "";
    L4:
        this.type = r100;
    }

    public void setInputParams(AbsJsbOcr.OcrInput r100, String r101, ICJPayServiceRetCallBack r102) {
        this.type = r100.type;
        this.mCompressSize = r100.compress_size;
        this.mParams = r100.track_base_param;
        this.extParams = r100.ext_params;
        this.mRule = r100.rule;
        this.mRiskInfo = r101;
        this.mCallBack = r102;
        this.tipsIconUrl = r100.cj_tips_icon_url;
        this.tipsContent = r100.cj_tips_content;
        this.frontUploadInteface = r100.frontUploadInteface;
        this.backUploadInteface = r100.backUploadInteface;
        this.publicKey = r100.publicKey;
    }

    public static void startIDCardOCR(Context r100, AbsJsbOcr.OcrInput r101, String r102, ICJPayServiceRetCallBack r103) {
        getInstance().setInputParams(r101, r102, r103);
        GenericDeclaration r104 = CJPayOCRIDCardActivity.class;
        if (OCRImageCdn.ID_CARD_OPT_LIST.contains(r101.type) == false) goto L5;
    L6:
        r104 = CJPayOCRIDCardOptActivity.class;
    L7:
        CJPayRouterAPI.getInstance().build(r104).withString("scene", r101.type).navigation(r100);
        return;
    L5:
        if (CJPayABExperimentKeys.getIdCardOpt().value(true).equals("1") == false) goto L7;
        goto L6
    }

    public static void startIDCardOCRForFxj(Context r100, AbsJsbOcr.OcrInput r101, String r102, ICJPayServiceRetCallBack r103) {
        getInstance().setInputParams(r101, r102, r103);
        GenericDeclaration r104 = CJPayOCRIDCardActivity.class;
        if (CJPayABExperimentKeys.getFxjOpt().value(true).equals("1") == false) goto L5;
        r104 = CJPayOCRIDCardOptActivity.class;
    L5:
        CJPayRouterAPI.Builder r105 = CJPayRouterAPI.getInstance().build(r104).withString("frontUploadInteface", r101.frontUploadInteface).withString("backUploadInteface", r101.backUploadInteface).withString("publicKey", r101.publicKey).withBoolean("hideDouyinPayBrand", true);
        String r106 = r101.type;
        if (r106 != null) goto L8;
        r106 = "";
    L8:
        r105.withString("scene", r106).navigation(r100);
    }

    public static void startOCROptionV2(Context r100, AbsJsbOcr.OcrInput r101, String r102, JSONObject r103, ICJPayServiceRetCallBack r104) {
        getInstance().setInputParams(r101, r102, r104);
        if (r103 == null) goto L5;
        CJOCRSettingsConfig r105 = (CJOCRSettingsConfig) CJPayJsonParser.fromJson(r103, CJOCRSettingsConfig.class);
    L6:
        if (r105 != null) goto L8;
        r105 = new CJOCRSettingsConfig();
    L8:
        CJPayRouterAPI.getInstance().build(CJPayOCROptionActivityV2.class).withString("scene", r101.type).withSerializable("config", r105).navigation(r100);
        return;
    L5:
        r105 = null;
        goto L6
    }

    public static void startPassportIdOCR(Context r100, int r101, String r102, JSONObject r103, String r104, String r105, ICJPayServiceRetCallBack r106) {
        CJPayRouterAPI.Builder r107 = CJPayRouterAPI.getInstance().build(CJPayOCRPassportActivity.class);
        if (r105 != null) goto L5;
        String r108 = "";
    L6:
        r107.withString("scene", r108).navigation(r100);
        getInstance().setCallBack(r106);
        getInstance().setCompressSize(r101);
        getInstance().setParams(r102);
        getInstance().setRiskInfo(r104);
        getInstance().setExtParams(r103);
        getInstance().setType(r105);
        return;
    L5:
        r108 = r105;
        goto L6
    }

    public static void startBankOCR(Context r100, String r101, String r102, String r103, String r104, String r105, String r106, ICJPayServiceRetCallBack r110) {
        CJPayRouterAPI.Builder r107 = CJPayRouterAPI.getInstance().build(CJPayOCRBankCardActivity.class);
        String r108 = "";
        if (r104 != null) goto L5;
        r104 = "";
    L5:
        CJPayRouterAPI.Builder r109 = r107.withSerializable(KEY_CJ_PAY_OCR_TITLE, r104);
        if (r105 != null) goto L8;
        r105 = "";
    L8:
        CJPayRouterAPI.Builder r111 = r109.withSerializable(KEY_CJ_PAY_OCR_SUB_TITLE, r105);
        if (r106 == null) goto L12;
        r108 = r106;
    L12:
        r111.withString("scene", r108).navigation(r100);
        getInstance().setCallBack(r110);
        getInstance().setRule(r101);
        getInstance().setParams(r102);
        getInstance().setRiskInfo(r103);
        getInstance().setType(r106);
    }

    public static void startIdentityOCR(Context r100, int r101, String r102, String r103, String r104, String r105, String r106, ICJPayServiceRetCallBack r110) {
        CJPayRouterAPI.Builder r107 = CJPayRouterAPI.getInstance().build(CJPayOCRIdentityActivity.class);
        String r108 = "";
        if (r104 != null) goto L5;
        r104 = "";
    L5:
        CJPayRouterAPI.Builder r109 = r107.withSerializable(KEY_CJ_PAY_OCR_TITLE, r104);
        if (r105 != null) goto L8;
        r105 = "";
    L8:
        CJPayRouterAPI.Builder r111 = r109.withSerializable(KEY_CJ_PAY_OCR_SUB_TITLE, r105);
        if (r106 == null) goto L12;
        r108 = r106;
    L12:
        r111.withString("scene", r108).navigation(r100);
        getInstance().setCallBack(r110);
        getInstance().setCompressSize(r101);
        getInstance().setParams(r102);
        getInstance().setRiskInfo(r103);
        getInstance().setType(r106);
    }
}
