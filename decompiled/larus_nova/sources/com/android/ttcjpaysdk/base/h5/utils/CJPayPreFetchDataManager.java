package com.android.ttcjpaysdk.base.h5.utils;

import android.net.Uri;
import android.text.TextUtils;
import com.alipay.sdk.m.p.e;
import com.android.ttcjpaysdk.base.CJOuterPayBean;
import com.android.ttcjpaysdk.base.h5.bean.CJPayPrefetchBean;
import com.android.ttcjpaysdk.base.settings.CJPaySettingsManager;
import com.android.ttcjpaysdk.base.utils.CJBasicCommonUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J(\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u001eH\u0007J\"\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040 2\u0006\u0010!\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\tJ\u001e\u0010#\u001a\u0004\u0018\u00010$2\b\u0010\u001b\u001a\u0004\u0018\u00010\u00042\b\u0010\u001c\u001a\u0004\u0018\u00010\u0004H\u0007J\u0018\u0010%\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00042\u0006\u0010&\u001a\u00020\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R(\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\t0\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001b\u0010\u000e\u001a\u00020\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0010\u0010\u0011R&\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00150\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000b\"\u0004\b\u0017\u0010\r¨\u0006'"}, d2 = {"Lcom/android/ttcjpaysdk/base/h5/utils/CJPayPreFetchDataManager;", "", "()V", "KEY_PRE_FETCH_DATA", "", "TYPE_NATIVE", "TYPE_WEB", "cacheDataMap", "Ljava/util/concurrent/ConcurrentHashMap;", "Lorg/json/JSONObject;", "getCacheDataMap", "()Ljava/util/concurrent/ConcurrentHashMap;", "setCacheDataMap", "(Ljava/util/concurrent/ConcurrentHashMap;)V", "executor", "Ljava/util/concurrent/ExecutorService;", "getExecutor", "()Ljava/util/concurrent/ExecutorService;", "executor$delegate", "Lkotlin/Lazy;", "requestTagMap", "", "getRequestTagMap", "setRequestTagMap", "getDataFromMemory", "", "type", "path", "host", "callback", "Lcom/android/ttcjpaysdk/base/h5/utils/IGetDataCallback;", "getHttpData", "", e.f25671s, "dataJson", "getPrefetchData", "Lcom/android/ttcjpaysdk/base/h5/bean/CJPayPrefetchBean;", "prefetchData", "url", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJPayPreFetchDataManager {
    public static final CJPayPreFetchDataManager INSTANCE = null;
    public static final String KEY_PRE_FETCH_DATA = "key_pre_fetch_data";
    public static final String TYPE_NATIVE = "cjpay_native";
    public static final String TYPE_WEB = "cjpay_h5";
    private static ConcurrentHashMap<String, JSONObject> cacheDataMap;
    private static final Lazy executor$delegate = null;
    private static ConcurrentHashMap<String, Boolean> requestTagMap;

    private CJPayPreFetchDataManager() {
    }

    static {
        INSTANCE = new CJPayPreFetchDataManager();
        cacheDataMap = new ConcurrentHashMap();
        requestTagMap = new ConcurrentHashMap();
        executor$delegate = LazyKt.lazy(CJPayPreFetchDataManager$executor$2.INSTANCE);
    }

    private final ExecutorService getExecutor() {
        return (ExecutorService) executor$delegate.getValue();
    }

    public final ConcurrentHashMap<String, JSONObject> getCacheDataMap() {
        return cacheDataMap;
    }

    public final ConcurrentHashMap<String, Boolean> getRequestTagMap() {
        return requestTagMap;
    }

    public final void setCacheDataMap(ConcurrentHashMap<String, JSONObject> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        cacheDataMap = r100;
    }

    public final void setRequestTagMap(ConcurrentHashMap<String, Boolean> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        requestTagMap = r100;
    }

    @JvmStatic
    public static final CJPayPrefetchBean getPrefetchData(String r100, String r101) {
        if (TextUtils.isEmpty(r100) == true) goto L36;
        String r102 = CJPaySettingsManager.getInstance().getSettingsInfo("webview_prefetch_config");
        if (TextUtils.isEmpty(r102) == true) goto L37;
        JSONArray r103 = new JSONObject(r102).optJSONArray(CJOuterPayBean.KEY_PREFETCH_DATA);     // Catch: Exception -> L22
        if (r103 == null) goto L38;
        ArrayList r104 = new ArrayList();     // Catch: Exception -> L22
        int r105 = r103.length();     // Catch: Exception -> L22
        int r106 = 0;
    L9:
        if (r106 >= r105) goto L11;
        r104.add(CJPayPrefetchBean.transformJson(r103.optJSONObject(r106)));     // Catch: Exception -> L22
        r106 = r106 + 1;     // Catch: Exception -> L22
        goto L9
    L11:
        Iterator r107 = r104.iterator();     // Catch: Exception -> L22
    L12:
        if (r107.hasNext() == false) goto L39;
        CJPayPrefetchBean r108 = (CJPayPrefetchBean) r107.next();     // Catch: Exception -> L22
        if (TextUtils.equals(r100, r108.path) == false) goto L12;
        Iterator<String> r109 = r108.hostList.iterator();     // Catch: Exception -> L22
    L18:
        if (r109.hasNext() == false) goto L12;
        if (Intrinsics.areEqual(r101, r109.next()) == false) goto L18;
        return r108;
    L39:
        return null;
    L38:
        return null;
    L22:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("CJPayPreFetchDataManager#getPrefetchData", e);
        CJBasicCommonUtils.logCatch("CJCatch", "CJPayPreFetchDataManager#getPrefetchData", e);
        return null;
    L37:
        return null;
    L36:
        return null;
    }

    @JvmStatic
    public static final void prefetchData(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "type");
        Intrinsics.checkNotNullParameter(r101, "url");
        if (r101.length() <= 0) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == false) goto L8;
        String r103 = r101;
    L9:
        if (r103 == null) goto L22;
        HashMap r104 = new HashMap();     // Catch: Exception -> L16
        Uri r105 = UriProtector.parse(r101);     // Catch: Exception -> L16
        String r106 = r105.getPath();     // Catch: Exception -> L16
        Iterator<String> r107 = UriProtector.getQueryParameterNames(r105).iterator();     // Catch: Exception -> L16
    L12:
        if (r107.hasNext() == false) goto L14;
        String r108 = r107.next();     // Catch: Exception -> L16
        r104.put(r108, UriProtector.getQueryParameter(r105, r108));     // Catch: Exception -> L16
        goto L12
    L14:
        INSTANCE.getExecutor().execute(new GetSettingsRunnable(r100, r106, r104, r105.getHost()));     // Catch: Exception -> L16
        return;
    L16:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("CJPayPreFetchDataManager#prefetchData", e);
        CJBasicCommonUtils.logCatch("CJCatch", "CJPayPreFetchDataManager#prefetchData", e);
        return;
    L22:
        return;
    L8:
        r103 = null;
        goto L9
    L5:
        r102 = false;
        goto L6
    }

    public final Map<String, String> getHttpData(String r100, JSONObject r101) {
        Intrinsics.checkNotNullParameter(r100, e.f25671s);
        Intrinsics.checkNotNullParameter(r101, "dataJson");
        HashMap r102 = new HashMap();
        Iterator<String> r103 = r101.keys();
    L4:
        if (r103.hasNext() == false) goto L6;
        String r104 = r103.next();
        Intrinsics.checkNotNull(r104, "null cannot be cast to non-null type kotlin.String");
        String r105 = r104;
        r102.put(r105, r101.optString(r105));
        goto L4
    L6:
        r102.put(e.f25671s, r100);
        return r102;
    }

    @JvmStatic
    public static final void getDataFromMemory(String r100, String r101, String r102, IGetDataCallback r103) {
        Intrinsics.checkNotNullParameter(r100, "type");
        Intrinsics.checkNotNullParameter(r101, "path");
        Intrinsics.checkNotNullParameter(r102, "host");
        Intrinsics.checkNotNullParameter(r103, "callback");
        String r104 = r100 + r101 + r102;
        if (requestTagMap.containsKey(r104) == true) goto L6;
        r103.onGetData(null);
        return;
    L6:
        INSTANCE.getExecutor().execute(new GetDataRunnable(r104, r103));
    }
}
