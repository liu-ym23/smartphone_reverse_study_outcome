package com.android.ttcjpaysdk.ocr.controller;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.android.ttcjpaysdk.base.CJPayHostInfo;
import com.android.ttcjpaysdk.base.service.ICJPayServiceRetCallBack;
import com.android.ttcjpaysdk.ocr.activity.CJPayOCRActivity;
import com.android.ttcjpaysdk.ocr.data.CJOCRBean;
import com.android.ttcjpaysdk.verify.constants.DyVerifyReqConstants;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0006\u0010\r\u001a\u00020\u000eJ\u001e\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u0004R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/android/ttcjpaysdk/ocr/controller/CJOCRManager;", "", "()V", "mCallBack", "Lcom/android/ttcjpaysdk/base/service/ICJPayServiceRetCallBack;", "getMCallBack", "()Lcom/android/ttcjpaysdk/base/service/ICJPayServiceRetCallBack;", "setMCallBack", "(Lcom/android/ttcjpaysdk/base/service/ICJPayServiceRetCallBack;)V", "getOCRBean", "Lcom/android/ttcjpaysdk/ocr/data/CJOCRBean;", "params", "Lorg/json/JSONObject;", "release", "", "startOCRProcess", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "callBack", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJOCRManager {
    public static final CJOCRManager INSTANCE = null;
    private static ICJPayServiceRetCallBack mCallBack;

    static {
        INSTANCE = new CJOCRManager();
    }

    private CJOCRManager() {
    }

    public final void release() {
        mCallBack = null;
    }

    public final ICJPayServiceRetCallBack getMCallBack() {
        return mCallBack;
    }

    private final CJOCRBean getOCRBean(JSONObject r100) {
        String r101 = r100.optString("type");
        String r102 = r100.optString(DyVerifyReqConstants.Key.RISK_INFO);
        JSONObject r103 = r100.optJSONObject("host_info");
        CJOCRBean r104 = new CJOCRBean(r101, CJPayHostInfo.Companion.toBean(r103), r100.toString());
        r104.setRiskInfo(r102);
        return r104;
    }

    public final void setMCallBack(ICJPayServiceRetCallBack r100) {
        mCallBack = r100;
    }

    public final void startOCRProcess(Context r100, JSONObject r101, ICJPayServiceRetCallBack r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "params");
        Intrinsics.checkNotNullParameter(r102, "callBack");
        Intent r103 = new Intent(r100, CJPayOCRActivity.class);
        Bundle r104 = new Bundle();
        r104.putSerializable("ocr_bean", getOCRBean(r101));
        r103.putExtras(r104);
        r100.startActivity(r103);
        mCallBack = r102;
        if ((r100 instanceof Activity) == false) goto L6;
        ((Activity) r100).overridePendingTransition(0, 0);
        return;
    }
}
