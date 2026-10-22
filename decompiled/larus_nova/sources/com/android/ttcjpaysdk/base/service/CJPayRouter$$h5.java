package com.android.ttcjpaysdk.base.service;

import com.android.ttcjpaysdk.base.h5.ui.LynxActivity;
import com.android.ttcjpaysdk.base.service.annotation.bean.CJRouterBean;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes28.dex */
public class CJPayRouter$$h5 {
    public CJPayRouter$$h5() {
    }

    public static Map<String, CJRouterBean> getRouterMap() {
        HashMap r100 = new HashMap();
        r100.put("/h5/LynxActivity", CJRouterBean.create(CJRouterBean.Type.ACTIVITY, LynxActivity.class));
        return r100;
    }
}
