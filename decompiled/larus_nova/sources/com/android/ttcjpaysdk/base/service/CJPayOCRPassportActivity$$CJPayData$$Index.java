package com.android.ttcjpaysdk.base.service;

import android.os.Bundle;
import com.android.ttcjpaysdk.ocr.activity.CJPayOCRPassportActivity;

/* JADX INFO: loaded from: classes28.dex */
public class CJPayOCRPassportActivity$$CJPayData$$Index {
    public CJPayOCRPassportActivity$$CJPayData$$Index() {
    }

    public static void autoWiredData(Object r100, Object r101) {
        Bundle r102 = (Bundle) r100;
        CJPayOCRPassportActivity r103 = (CJPayOCRPassportActivity) r101;
        if (r103.getIntent().getStringExtra("scene") != null) goto L5;
        String r104 = r103.ocrType;
    L6:
        r103.ocrType = r104;
        return;
    L5:
        r104 = r103.getIntent().getStringExtra("scene");
        goto L6
    }

    public static void restoreData(Object r100, Object r101) {
        Bundle r102 = (Bundle) r100;
        CJPayOCRPassportActivity r103 = (CJPayOCRPassportActivity) r101;
        if (r102.getString("scene") != null) goto L5;
        String r104 = r103.ocrType;
    L6:
        r103.ocrType = r104;
        return;
    L5:
        r104 = r102.getString("scene");
        goto L6
    }

    public static void saveData(Object r100, Object r101) {
        ((Bundle) r100).putString("scene", ((CJPayOCRPassportActivity) r101).ocrType);
    }
}
