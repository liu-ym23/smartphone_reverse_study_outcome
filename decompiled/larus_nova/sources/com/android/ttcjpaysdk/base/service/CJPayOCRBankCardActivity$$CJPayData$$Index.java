package com.android.ttcjpaysdk.base.service;

import android.os.Bundle;
import com.android.ttcjpaysdk.ocr.OCRDevice;
import com.android.ttcjpaysdk.ocr.activity.CJPayOCRBankCardActivity;

/* JADX INFO: loaded from: classes28.dex */
public class CJPayOCRBankCardActivity$$CJPayData$$Index {
    public CJPayOCRBankCardActivity$$CJPayData$$Index() {
    }

    public static void autoWiredData(Object r100, Object r101) {
        Bundle r102 = (Bundle) r100;
        CJPayOCRBankCardActivity r103 = (CJPayOCRBankCardActivity) r101;
        if (r103.getIntent().getStringExtra(OCRDevice.KEY_CJ_PAY_OCR_TITLE) != null) goto L5;
        String r104 = r103.title;
    L6:
        r103.title = r104;
        if (r103.getIntent().getStringExtra(OCRDevice.KEY_CJ_PAY_OCR_SUB_TITLE) != null) goto L9;
        String r105 = r103.subTitle;
    L10:
        r103.subTitle = r105;
        if (r103.getIntent().getStringExtra("scene") != null) goto L13;
        String r106 = r103.ocrType;
    L14:
        r103.ocrType = r106;
        return;
    L13:
        r106 = r103.getIntent().getStringExtra("scene");
        goto L14
    L9:
        r105 = r103.getIntent().getStringExtra(OCRDevice.KEY_CJ_PAY_OCR_SUB_TITLE);
        goto L10
    L5:
        r104 = r103.getIntent().getStringExtra(OCRDevice.KEY_CJ_PAY_OCR_TITLE);
        goto L6
    }

    public static void restoreData(Object r100, Object r101) {
        Bundle r102 = (Bundle) r100;
        CJPayOCRBankCardActivity r103 = (CJPayOCRBankCardActivity) r101;
        if (r102.getString(OCRDevice.KEY_CJ_PAY_OCR_TITLE) != null) goto L5;
        String r104 = r103.title;
    L6:
        r103.title = r104;
        if (r102.getString(OCRDevice.KEY_CJ_PAY_OCR_SUB_TITLE) != null) goto L9;
        String r105 = r103.subTitle;
    L10:
        r103.subTitle = r105;
        if (r102.getString("scene") != null) goto L13;
        String r106 = r103.ocrType;
    L14:
        r103.ocrType = r106;
        return;
    L13:
        r106 = r102.getString("scene");
        goto L14
    L9:
        r105 = r102.getString(OCRDevice.KEY_CJ_PAY_OCR_SUB_TITLE);
        goto L10
    L5:
        r104 = r102.getString(OCRDevice.KEY_CJ_PAY_OCR_TITLE);
        goto L6
    }

    public static void saveData(Object r100, Object r101) {
        Bundle r102 = (Bundle) r100;
        CJPayOCRBankCardActivity r103 = (CJPayOCRBankCardActivity) r101;
        r102.putString(OCRDevice.KEY_CJ_PAY_OCR_TITLE, r103.title);
        r102.putString(OCRDevice.KEY_CJ_PAY_OCR_SUB_TITLE, r103.subTitle);
        r102.putString("scene", r103.ocrType);
    }
}
