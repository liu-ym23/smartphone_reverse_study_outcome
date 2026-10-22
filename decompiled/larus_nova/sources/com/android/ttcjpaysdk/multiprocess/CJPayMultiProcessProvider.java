package com.android.ttcjpaysdk.multiprocess;

import android.content.Context;
import com.android.ttcjpaysdk.base.CJPayHostInfo;
import com.android.ttcjpaysdk.base.service.ICJPayMultiProcessService;
import com.android.ttcjpaysdk.base.utils.CJBasicCommonUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes39.dex */
public class CJPayMultiProcessProvider implements ICJPayMultiProcessService {
    private CJPaySubProcessReceiver subProcessReceiver;

    @Override // com.android.ttcjpaysdk.base.service.ICJPayService
    public String getPackageName() {
        return null;
    }

    public CJPayMultiProcessProvider() {
        this.subProcessReceiver = new CJPaySubProcessReceiver();
    }

    public void start(Context r100) {
        CJPaySubProcessReceiver.registerReceiver(r100, this.subProcessReceiver);
    }

    @Override // com.android.ttcjpaysdk.base.service.ICJPayMultiProcessService
    public void stop(Context r100) {
        CJPaySubProcessReceiver.unregisterReceiver(r100, this.subProcessReceiver);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        CJBasicCommonUtils.reportCatchException("CJPayMultiProcessProvider#stop", th);
        CJBasicCommonUtils.logCatch("CJCatch", "CJPayMultiProcessProvider#stop", th);
    }

    @Override // com.android.ttcjpaysdk.base.service.ICJPayMultiProcessService
    public void pay(Context r100, JSONObject r101, String r110, int r111, String r112, String r113, String r114) {
        start(r100);
        CJPayMainProcessActivity.pay(r100, CJPayHostInfo.toBean(r101), r110, r111, r112, r113, r114);
    }
}
