package com.android.ttcjpaysdk.base.service;

import com.android.ttcjpaysdk.base.service.bean.ALogReportConfig;
import com.android.ttcjpaysdk.base.service.bean.ReuseHostDomain;
import com.android.ttcjpaysdk.base.service.bean.WebViewCommonConfig;

/* JADX INFO: loaded from: classes3.dex */
public interface ICJPaySettingService extends ICJPayService {
    String appendSchemaParams(String r100);

    ALogReportConfig getALogReportConfig();

    <T> T getExperimentValue(String r100, Class<T> r101, T r102, boolean r103);

    ReuseHostDomain getHostDomain(String r100);

    WebViewCommonConfig getWebViewCommonConfig();

    boolean isEventUpload();

    boolean isVip();

    boolean useNewAnimType1();
}
