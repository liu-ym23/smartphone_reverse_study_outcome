package com.bytedance.android.livehostapi.business;

import android.content.Context;
import com.bytedance.android.live.base.IService;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Map;
import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0002\u0012\u0013JP\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\n2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\f0\n2\u0006\u0010\r\u001a\u00020\u000eH&J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J@\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\n2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\f0\n2\u0006\u0010\r\u001a\u00020\u0011H&¨\u0006\u0014À\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livehostapi/business/IHostRealNameAuthorization;", "Lcom/bytedance/android/live/base/IService;", "doFaceLive", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "identityCode", "", "identityName", "userInfo", "", "themeData", "", "callback", "Lcom/bytedance/android/livehostapi/business/IHostRealNameAuthorization$FaceLiveCallback;", "preloadInit", "startBytedCert", "Lcom/bytedance/android/livehostapi/business/IHostRealNameAuthorization$BytedCertCallback;", "BytedCertCallback", "FaceLiveCallback", "hostapp-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IHostRealNameAuthorization extends IService {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006À\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livehostapi/business/IHostRealNameAuthorization$BytedCertCallback;", "", "onVerifyResult", "", "data", "Lorg/json/JSONObject;", "hostapp-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public interface BytedCertCallback {
        void onVerifyResult(JSONObject r100);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH&¨\u0006\fÀ\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livehostapi/business/IHostRealNameAuthorization$FaceLiveCallback;", "", "onDetectFaceLiveFinish", "", "isSuccess", "", "errorCode", "", "errorMsg", "", "data", "Lorg/json/JSONObject;", "hostapp-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public interface FaceLiveCallback {
        void onDetectFaceLiveFinish(boolean r100, int r101, String r102, JSONObject r103);
    }

    void doFaceLive(Context r100, String r101, String r102, Map<String, String> r103, Map<String, ? extends Object> r104, FaceLiveCallback r105);

    void preloadInit(Context r100);

    void startBytedCert(Context r100, Map<String, String> r101, Map<String, ? extends Object> r102, BytedCertCallback r103);
}
