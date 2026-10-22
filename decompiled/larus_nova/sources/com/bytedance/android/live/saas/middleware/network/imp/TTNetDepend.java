package com.bytedance.android.live.saas.middleware.network.imp;

import android.content.Context;
import com.android.ttcjpaysdk.base.CJPayConstant;
import com.bytedance.android.live.saas.middleware.BDLiveSdk;
import com.bytedance.android.live.saas.middleware.utils.CornetPlugin;
import com.bytedance.android.livesdkapi.app.AppConstants;
import com.bytedance.common.utility.Logger;
import com.bytedance.ttnet.ITTNetDepend;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes47.dex */
public class TTNetDepend implements ITTNetDepend {
    public static final String API_HOST_API = "api.snssdk.com";
    public static final String API_HOST_FEEDBACK = "xgfe.snssdk.com";
    public static final String API_HOST_I = "ib.snssdk.com";
    public static final String API_HOST_I2 = "i.snssdk.com";
    public static final String API_HOST_ISUB = "isub.snssdk.com";
    public static final String API_HOST_LOG = "log.snssdk.com";
    public static final String API_HOST_MON = "mon.snssdk.com";
    public static final String API_HOST_SI = "security.snssdk.com";
    public static final String API_HOST_SRV = "ichannel.snssdk.com";
    public static final String API_HOST_WEBCAST = "webcast.ixigua.com";
    public static final String API_HOST_XGADMIN = "xigua-admin.bytedance.net";
    public static final String DOMAIN_HTTPDNS_KEY = "httpdns";
    public static final String DOMAIN_NETLOG_KEY = "netlog";
    private static volatile TTNetDepend sInstance;

    public TTNetDepend() {
    }

    @Override // com.bytedance.ttnet.ITTNetDepend
    public int checkHttpRequestException(Throwable r100, String[] r101) {
        return 1;
    }

    @Override // com.bytedance.ttnet.ITTNetDepend
    public String executeGet(int r100, String r101) throws Exception {
        return null;
    }

    @Override // com.bytedance.ttnet.ITTNetDepend
    public String getApiIHostPrefix() {
        return AppConstants.API_HOST_I_PREFIX;
    }

    @Override // com.bytedance.ttnet.ITTNetDepend
    public String getCdnHostSuffix() {
        return AppConstants.CDN_HOST_SUFFIX_DEFAULT;
    }

    @Override // com.bytedance.ttnet.ITTNetDepend
    public ArrayList<String> getCookieFlushPathList() {
        return null;
    }

    @Override // com.bytedance.ttnet.ITTNetDepend
    public String getHostSuffix() {
        return ".snssdk.com";
    }

    @Override // com.bytedance.ttnet.ITTNetDepend
    public int getProviderInt(Context r100, String r101, int r102) {
        return r102;
    }

    @Override // com.bytedance.ttnet.ITTNetDepend
    public String getProviderString(Context r100, String r101, String r102) {
        return r102;
    }

    @Override // com.bytedance.ttnet.ITTNetDepend
    public String getShareCookieMainDomain() {
        return ".snssdk.com";
    }

    @Override // com.bytedance.ttnet.ITTNetDepend
    public boolean isPrivateApiAccessEnabled() {
        return false;
    }

    @Override // com.bytedance.ttnet.ITTNetDepend
    public void mobOnEvent(Context r100, String r101, String r102, JSONObject r103) {
    }

    @Override // com.bytedance.ttnet.ITTNetDepend
    public void monitorLogSend(String r100, JSONObject r101) {
    }

    @Override // com.bytedance.ttnet.ITTNetDepend
    public void onColdStartFinish() {
    }

    @Override // com.bytedance.ttnet.ITTNetDepend
    public void onNetConfigUpdate(JSONObject r100, boolean r101) {
    }

    @Override // com.bytedance.ttnet.ITTNetDepend
    public void onShareCookieConfigUpdated(String r100) {
    }

    @Override // com.bytedance.ttnet.ITTNetDepend
    public void saveMapToProvider(Context r100, Map<String, ?> r101) {
    }

    public static TTNetDepend inst() {
        if (sInstance != null) goto L15;
        monitor-enter(TTNetDepend.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new TTNetDepend();     // Catch: Throwable -> L11
    L9:
        monitor-exit(TTNetDepend.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    @Override // com.bytedance.ttnet.ITTNetDepend
    public Map<String, String> getHostReverseMap() {
        LinkedHashMap r100 = new LinkedHashMap();
        r100.put("ib.snssdk.com", RXScreenCaptureService.KEY_INDEX);
        r100.put("security.snssdk.com", BytedCertConstant.LivenessInfoConfigKey.KEY);
        r100.put("isub.snssdk.com", AppConstants.API_HOST_API_PREFIX);
        r100.put("ichannel.snssdk.com", AppConstants.API_HOST_SRV_PREFIX);
        r100.put("log.snssdk.com", "log");
        r100.put("mon.snssdk.com", "mon");
        return r100;
    }

    @Override // com.bytedance.ttnet.ITTNetDepend
    public Map<String, String> getTTNetServiceDomainMap() {
        HashMap r100 = new HashMap();
        r100.put("httpdns", "dig.bdurl.net");
        r100.put("netlog", "crash.snssdk.com");
        r100.put("boe", CJPayConstant.BOE_SUFFIX);
        return r100;
    }

    @Override // com.bytedance.ttnet.ITTNetDepend
    public boolean isCronetPluginInstalled() {
        return CornetPlugin.INSTANCE.isCornetSoInstalled(getContext());
    }

    @Override // com.bytedance.ttnet.ITTNetDepend
    public int getAppId() {
        return BDLiveSdk.getAppInfo().appId();
    }

    @Override // com.bytedance.ttnet.ITTNetDepend
    public String[] getConfigServers() {
        if ("local_test".equalsIgnoreCase(BDLiveSdk.getAppInfo().channel()) == false) goto L7;
        return null;
    L7:
        return new String[]{"dm.toutiao.com", "dm.bytedance.com", "dm-hl.toutiao.com"};
    }

    @Override // com.bytedance.ttnet.ITTNetDepend
    public Context getContext() {
        return BDLiveSdk.getContext();
    }

    @Override // com.bytedance.ttnet.ITTNetDepend
    public void onAppConfigUpdated(Context r100, JSONObject r101) {
        if (Logger.debug() == false) goto L6;
        Logger.d("AppConfig", "TTNetDepend.onAppConfigUpdated:" + r101);
        return;
    }
}
