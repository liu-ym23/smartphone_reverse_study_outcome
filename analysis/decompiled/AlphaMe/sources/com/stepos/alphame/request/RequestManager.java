package com.stepos.alphame.request;

import android.annotation.SuppressLint;
import android.content.Context;
import ch.qos.logback.core.joran.action.Action;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.stepos.alphame.request.JsonRequest;
import com.stepos.alphame.utils.AlphaMeLogger;
import com.stepos.alphame.utils.NetEnvHelper;
import com.stepos.alphame.utils.Property;
import com.stepos.alphame.utils.StringUtil;
import java.util.HashMap;
import java.util.Iterator;

/* loaded from: classes.dex */
public class RequestManager {
    private static final int MAX_UPLOAD_INFO_RESPONSE_LENGTH = 65536;
    private static final String URL_AWARENESS_POST = "https://hades.zyql.com/up/DailyPortrait";
    private static final String URL_GET_COUNTRY_INFO = "https://onemind.zyql.com/service/IpExt/getCountryCode";
    private static final String URL_PERSONA_OL_INFO = "https://onemind.zyql.com/service/daily/getDaily";
    private static final String URL_UPLOAD_INFO = "https://hades.zyql.com/daily-portrait/service-info";
    private static final String URL_WX_POST = "https://onemind.zyql.com/service/task/addApp";

    @SuppressLint({"StaticFieldLeak"})
    private static RequestManager sInstance;
    private com.android.volley.RequestQueue mRequestQueue;

    @SuppressLint({"UseSparseArrays"})
    private HashMap<Integer, RetryTask> mRetryList = new HashMap<>();

    public class RetryTask {
        static final int RETRY_MAX = 5;
        int retry = 5;
        Runnable task;

        public RetryTask(Runnable runnable) {
            this.task = runnable;
        }

        public void execute() {
            Runnable runnable = this.task;
            if (runnable != null) {
                runnable.run();
            }
        }
    }

    private RequestManager(Context context) {
        this.mRequestQueue = RequestQueue.getQueue(context);
    }

    public static synchronized RequestManager getInstance(Context context) {
        try {
            if (sInstance == null) {
                sInstance = new RequestManager(context.getApplicationContext());
            }
        } catch (Throwable th) {
            throw th;
        }
        return sInstance;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isSafeUploadInfoResponse(String str) {
        if (str == null) {
            return false;
        }
        String strTrim = str.trim();
        if (strTrim.isEmpty() || strTrim.length() > 65536 || !strTrim.startsWith("{") || !strTrim.endsWith("}")) {
            return false;
        }
        return !strTrim.contains("@type");
    }

    public void cancel(Object obj) {
        this.mRequestQueue.cancelAll(obj);
    }

    public void clearRetry() {
        this.mRetryList.clear();
    }

    public void removeRetry(int i4) {
        this.mRetryList.remove(Integer.valueOf(i4));
    }

    public void requestCountryInfo(Object obj, String str, String str2, ResponseListener<CountryInfoBean> responseListener) {
        AlphaMeLogger.iLog("requestCountryInfo disabled: country detection deprecated");
        if (responseListener != null) {
            responseListener.onFailed(0, new UnsupportedOperationException("requestCountryInfo disabled"));
        }
    }

    public void requestPersonaOL(Object obj, String str, ResponseListener<PersonaOLBean> responseListener) {
        new JsonRequest.Builder().setUrl(NetEnvHelper.mapUrl(URL_PERSONA_OL_INFO)).addParamer("cityName", str).setBeanType(new TypeReference<PersonaOLBean>() { // from class: com.stepos.alphame.request.RequestManager.1
        }).setListener(responseListener).setTag(obj).start(this.mRequestQueue);
    }

    public void requestUploadInfo(final String str, final String str2, final String str3, final ResponseListener<UploadInfoBean> responseListener) {
        this.mRequestQueue.add(new StringRequest(1, NetEnvHelper.mapUrl(URL_UPLOAD_INFO), new Response.Listener<String>() { // from class: com.stepos.alphame.request.RequestManager.2
            @Override // com.android.volley.Response.Listener
            public void onResponse(String str4) {
                if (RequestManager.isSafeUploadInfoResponse(str4)) {
                    responseListener.onSuccess(0, UploadInfoBean.fromJsonString(str4));
                } else {
                    AlphaMeLogger.eLog("requestUploadInfo response rejected by validation");
                    responseListener.onFailed(0, new IllegalArgumentException("invalid upload info response"));
                }
            }
        }, new Response.ErrorListener() { // from class: com.stepos.alphame.request.RequestManager.3
            @Override // com.android.volley.Response.ErrorListener
            public void onErrorResponse(VolleyError volleyError) {
                AlphaMeLogger.eLog("requestUploadInfo onErrorResponse " + volleyError);
            }
        }) { // from class: com.stepos.alphame.request.RequestManager.4
            @Override // com.android.volley.Request
            public byte[] getBody() {
                HashMap map = new HashMap();
                map.put("StepOSVersion", str2);
                map.put("AppVersion", str);
                map.put("Imei", str3);
                return JSON.toJSONString((Object) map, true).getBytes();
            }
        });
    }

    public void retryIfNeed() {
        AlphaMeLogger.iLog("retryIfNeed " + this.mRetryList.size());
        Iterator<RetryTask> it = this.mRetryList.values().iterator();
        while (it.hasNext()) {
            it.next().execute();
        }
    }

    public void uploadUserInfo(final String str, final long j4) {
        AlphaMeLogger.debugLog("uploadUserInfo " + StringUtil.formatDateFull(j4) + ", " + str);
        this.mRequestQueue.add(new StringRequest(1, NetEnvHelper.mapUrl(URL_AWARENESS_POST), new Response.Listener<String>() { // from class: com.stepos.alphame.request.RequestManager.5
            @Override // com.android.volley.Response.Listener
            public void onResponse(String str2) {
                AlphaMeLogger.debugLog("uploadUserInfo onResponse " + str2);
                Property.setLastUploadTime(j4);
            }
        }, new Response.ErrorListener() { // from class: com.stepos.alphame.request.RequestManager.6
            @Override // com.android.volley.Response.ErrorListener
            public void onErrorResponse(VolleyError volleyError) {
                AlphaMeLogger.eLog("uploadUserInfo onErrorResponse " + volleyError);
            }
        }) { // from class: com.stepos.alphame.request.RequestManager.7
            @Override // com.android.volley.Request
            public byte[] getBody() throws AuthFailureError {
                return str.getBytes();
            }
        });
    }

    public void uploadWXInfo(String str, String str2, ResponseListener<Object> responseListener) {
        AlphaMeLogger.iLog("uploadWXInfo " + str + ", " + str2);
        new JsonRequest.Builder().setUrl(NetEnvHelper.mapUrl(URL_WX_POST)).addParamer(Action.KEY_ATTRIBUTE, str).addParamer("name", str2).setListener(responseListener).start(this.mRequestQueue);
    }

    public void waitRetry(Runnable runnable, int i4) {
        AlphaMeLogger.dLog("waitRetry " + i4);
        RetryTask retryTask = this.mRetryList.get(Integer.valueOf(i4));
        if (retryTask == null) {
            this.mRetryList.put(Integer.valueOf(i4), new RetryTask(runnable));
            return;
        }
        int i5 = retryTask.retry - 1;
        retryTask.retry = i5;
        if (i5 > 0) {
            retryTask.task = runnable;
        }
    }
}
