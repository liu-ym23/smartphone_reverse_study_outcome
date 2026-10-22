package com.android.ttcjpaysdk.base.service;

import android.content.Context;
import com.android.ttcjpaysdk.base.h5.cjjsb.abs.AbsJsbOcr;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
public interface ICJPayOCRService extends ICJPayService {
    void release();

    void startOCR(Context r100, String r101, String r102, String r103, String r104, String r105, JSONObject r106, String r107, String r108, String r110, ICJPayServiceRetCallBack r111);

    void startOCR(Context r100, JSONObject r101, ICJPayServiceRetCallBack r102);

    void startOCRForIdCard(Context r100, AbsJsbOcr.OcrInput r101, String r102, JSONObject r103, ICJPayServiceRetCallBack r104);

    void startOCRForIdentity(Context r100, String r101, String r102, int r103, String r104, String r105, JSONObject r106, String r107, String r108, String r110, ICJPayServiceRetCallBack r111);

    void startOCRForPassportId(Context r100, String r101, String r102, int r103, String r104, JSONObject r105, String r106, JSONObject r107, String r108, ICJPayServiceRetCallBack r110);

    void startOCROptionV2(Context r100, AbsJsbOcr.OcrInput r101, String r102, JSONObject r103, JSONObject r104, ICJPayServiceRetCallBack r105);
}
