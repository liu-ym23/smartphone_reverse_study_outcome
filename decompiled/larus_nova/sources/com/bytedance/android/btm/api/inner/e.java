package com.bytedance.android.btm.api.inner;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.view.View;
import com.bytedance.android.bcm.api.model.BcmParams;
import com.bytedance.android.btm.api.BtmPageLifecycle;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.btm.api.model.j;
import com.bytedance.android.btm.api.model.k;
import com.bytedance.android.btm.api.model.p;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;
import zc.i;

/* JADX INFO: loaded from: classes3.dex */
public interface e {
    j addBtmEventParam(j r100);

    k addBtmEventParam(k r100);

    void checkEventParam(j r100);

    boolean checkPageBtmFormat(String r100, String r101, boolean r102, String r103, String r104);

    JSONObject createBtmChain(com.bytedance.android.btm.api.model.c r100);

    String createBtmId(com.bytedance.android.btm.api.model.c r100);

    String createExternalEvokeBtmToken(String r100, String r101, BcmParams r102);

    Map<String, Object> createFullyReportParams(String r100, PageFinder r101);

    String createJumpSourceBtmToken(com.bytedance.android.btm.api.model.d r100, boolean r101);

    Map<String, Object> createReportParams(String r100, PageFinder r101, Set<String> r102);

    boolean delayEventHook();

    boolean enableDeepLinkProcess(String r100);

    boolean enableRouterMonitor();

    boolean fixBcmValueNotConvert();

    boolean fixSourceTokenError();

    Map<String, Object> generateBtmEventParams(String r100, int r101, String r102);

    b getALogWriter();

    d getAppLog();

    com.bytedance.android.btm.api.model.e getBtmPageInfo(PageFinder r100);

    Object getCurrentResumedPage();

    com.bytedance.android.btm.api.k getHybridContainerLoadSchemaCallback();

    Object getLastCreatedPage();

    String getLastPageBtm();

    com.bytedance.android.btm.api.c getLaunchApi();

    f getLogWriter();

    g getMonitor();

    void getPageBtmWithSchemaAsync(String r100, h r101);

    String getPageId(PageFinder r100);

    BtmPageLifecycle getPageLifecycle();

    Object getReportParamsByKey(String r100, String r101, PageFinder r102);

    i getSchemaSettingCallback();

    com.bytedance.android.btm.api.g getThreadExecutor();

    void init();

    boolean isHybridContainer(View r100);

    void minimizeInit(Application r100);

    boolean onEventHook(Context r100, String r101, String r102, String r103, Long r104, Long r105, Boolean r106, JSONObject r107, boolean r108);

    void onLowMemory();

    void onRegisterHybridContainer(com.bytedance.android.btm.api.i r100);

    void onRegisterPage(com.bytedance.android.btm.api.d r100);

    void onRegisterPage(com.bytedance.android.btm.api.e r100);

    void onUnregisterPage(com.bytedance.android.btm.api.e r100);

    boolean processEventModel(j r100);

    boolean registerBtmPage(View r100, String r101, String r102, Map<String, ? extends Object> r103);

    void registerBtmPageCallback(bd.b r100);

    void registerEventChecker(com.bytedance.android.btm.api.model.i r100);

    boolean registerFEBtmPage(View r100, String r101, String r102, Boolean r103, Map<String, ? extends Object> r104);

    void registerPageBtmWithSchemaAsync(String r100, Object r101, String r102, String r103);

    boolean removeBcmChainPageId();

    boolean removeSearchTokenC();

    boolean removeSourceBtmTokenInQueue(String r100);

    void setInitInActivity(Activity r100);

    void setInitTag(String r100);

    void setStartNode(p r100);

    void unregisterBtmPageCallback(bd.b r100);

    void updateBtmPage(Object r100, String r101);

    void updateLazyDataSettings();

    boolean useV2Api();

    boolean useV2ApiMall();
}
