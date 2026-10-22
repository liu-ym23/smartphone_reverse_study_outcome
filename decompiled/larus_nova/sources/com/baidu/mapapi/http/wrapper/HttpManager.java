package com.baidu.mapapi.http.wrapper;

import android.text.TextUtils;
import com.baidu.mapapi.a;
import com.baidu.mapapi.http.HttpClient;
import com.baidu.mapapi.http.wrapper.annotation.BodyData;
import com.baidu.mapapi.http.wrapper.annotation.POST;
import com.baidu.mapapi.http.wrapper.annotation.PUT;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes39.dex */
public class HttpManager {
    public static final String HTTP_DELETE = "DELETE";
    public static final String HTTP_GET = "GET";
    public static final String HTTP_POST = "POST";
    public static final String HTTP_PUT = "PUT";
    private static final String UN_SUPPORT_REQUEST_METHOD = "UN_SUPPORT_REQUEST_METHOD";
    private String host;
    private String prefix;
    private final ExecutorService threadPool;

    public HttpManager(String r100) {
        this(r100, "");
    }

    public static /* synthetic */ String access$000(HttpManager r100) {
        return r100.host;
    }

    public static /* synthetic */ String access$100(HttpManager r100) {
        return r100.prefix;
    }

    public static /* synthetic */ ExecutorService access$400(HttpManager r100) {
        return r100.threadPool;
    }

    private Class<?> getGenericReturnType(Method r100) {
        Iterator<Map.Entry<String, ClassInfo>> r101 = ClassInfo.getType(r100.getGenericReturnType()).getGenericParams().entrySet().iterator();
        if (r101.hasNext() == true) goto L5;
        return null;
    L5:
        return r101.next().getValue().getRawType();
    }

    public <T> T getApiInstance(Class<T> r100) {
        return (T) Proxy.newProxyInstance(getClass().getClassLoader(), new Class[]{r100}, new AnonymousClass1(this));
    }

    public HttpManager(String r100, String r101) {
        this.host = "";
        this.prefix = "";
        this.threadPool = a.a();
        if (TextUtils.isEmpty(r100) == true) goto L6;
        this.host = r100;
    L6:
        if (TextUtils.isEmpty(r101) == true) goto L9;
        this.prefix = r101;
        return;
    }

    public static /* synthetic */ Class access$200(HttpManager r100, Method r101) {
        return r100.getGenericReturnType(r101);
    }

    private void makeCommonHeader(HttpClient.HttpHeader r100, Class<?> r101, String r102) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r101 != POST.class) goto L6;
    L7:
        r100.setAccept("application/body").setCharset("UTF-8").setConnection(HTTP.KEEP_ALIVE);
        if (BodyData.TYPE_URL_ENCODED.equals(r102) == false) goto L11;
        r100.setContentType("application/x-www-form-urlencoded");
    L11:
        if (BodyData.TYPE_FORM_DATA.equals(r102) == false) goto L14;
        r100.setContentType("multipart/form-data;boundary=bd_map_sdk_cc");
    L14:
        if ("json".equals(r102) == false) goto L19;
        r100.setContentType("application/json");
        return;
    L19:
        return;
    L6:
        if (r101 == PUT.class) goto L7;
    }

    public static /* synthetic */ void access$300(HttpManager r100, HttpClient.HttpHeader r101, Class r102, String r103) {
        r100.makeCommonHeader(r101, r102, r103);
    }
}
