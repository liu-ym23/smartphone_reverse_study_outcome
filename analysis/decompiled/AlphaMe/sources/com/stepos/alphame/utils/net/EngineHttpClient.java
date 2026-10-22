package com.stepos.alphame.utils.net;

import F1.n;
import android.os.Build;
import androidx.annotation.NonNull;
import com.stepos.alphame.ApplicationImpl;
import com.stepos.alphame.BuildConfig;
import com.stepos.alphame.awareness.AwarenessDataItem;
import com.stepos.alphame.utils.AlphaMeLogger;
import h3.C0599h;
import h3.G;
import h3.H;
import h3.InterfaceC0602k;
import h3.InterfaceC0603l;
import h3.J;
import h3.K;
import h3.L;
import h3.Q;
import h3.S;
import h3.V;
import h3.b0;
import j3.C0639c;
import j3.EnumC0637a;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.Util;
import okhttp3.internal.connection.RealCall;

/* loaded from: classes.dex */
public class EngineHttpClient {
    private static final String CACHE_FILE_NAME = "ENGINE_HTTP_CACHE";
    private static final int CACHE_SIZE = 10485760;
    private static final String TAG = "Personal";
    private static EngineHttpClient sInstance;
    S httpClient;

    public static class ApplicationInterceptor implements L {
        @Override // h3.L
        public b0 intercept(K k4) throws IOException {
            if (k4 == null || k4.request() == null) {
                new G();
                throw new IllegalStateException(Intrinsics.stringPlus("code < 0: ", -1).toString());
            }
            if (k4.request().f12826a != null) {
                AlphaMeLogger.debugLog("Personal", "ApplicationInterceptor.intercept " + EngineHttpClient.getPrintableUrl(k4.request().f12826a));
            }
            return k4.proceed(k4.request());
        }
    }

    public interface HttpClientListener<T> {
        void onFailure(Exception exc, ResponseInfo responseInfo);

        void onResponse(T t4, ResponseInfo responseInfo);
    }

    public static class NetworkInterceptor implements L {
        @Override // h3.L
        public b0 intercept(K k4) throws IOException {
            if (k4.request().f12826a != null) {
                AlphaMeLogger.debugLog("Personal", "NetworkInterceptor.intercept " + EngineHttpClient.getPrintableUrl(k4.request().f12826a));
            }
            return k4.proceed(k4.request());
        }
    }

    private EngineHttpClient() {
        try {
            if (this.httpClient == null) {
                C0599h c0599h = new C0599h(new File(ApplicationImpl.getApplication().getCacheDir(), CACHE_FILE_NAME));
                Q q4 = new Q();
                q4.f12765k = c0599h;
                TimeUnit unit = TimeUnit.SECONDS;
                Intrinsics.checkNotNullParameter(unit, "unit");
                q4.f12779y = Util.checkDuration("timeout", 10L, unit);
                Intrinsics.checkNotNullParameter(unit, "unit");
                q4.f12780z = Util.checkDuration("timeout", 10L, unit);
                Intrinsics.checkNotNullParameter(unit, "unit");
                q4.f12751A = Util.checkDuration("timeout", 10L, unit);
                ApplicationInterceptor interceptor = new ApplicationInterceptor();
                Intrinsics.checkNotNullParameter(interceptor, "interceptor");
                q4.f12757c.add(interceptor);
                NetworkInterceptor interceptor2 = new NetworkInterceptor();
                Intrinsics.checkNotNullParameter(interceptor2, "interceptor");
                q4.f12758d.add(interceptor2);
                C0639c interceptor3 = new C0639c();
                if (BuildConfig.DEBUG) {
                    EnumC0637a level = EnumC0637a.f13135c;
                    Intrinsics.checkNotNullParameter(level, "level");
                    Intrinsics.checkNotNullParameter(level, "<set-?>");
                    interceptor3.f13139b = level;
                } else if (Build.TYPE.equalsIgnoreCase("eng")) {
                    EnumC0637a level2 = EnumC0637a.f13134b;
                    Intrinsics.checkNotNullParameter(level2, "level");
                    Intrinsics.checkNotNullParameter(level2, "<set-?>");
                    interceptor3.f13139b = level2;
                }
                Intrinsics.checkNotNullParameter(interceptor3, "interceptor");
                q4.f12757c.add(interceptor3);
                this.httpClient = new S(q4);
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public static synchronized void destroy() {
        sInstance = null;
    }

    public static synchronized EngineHttpClient getInstance() {
        try {
            if (sInstance == null) {
                sInstance = new EngineHttpClient();
            }
        } catch (Throwable th) {
            throw th;
        }
        return sInstance;
    }

    public static String getPrintableUrl(J j4) {
        if (BuildConfig.DEBUG || Build.TYPE.equalsIgnoreCase("eng")) {
            return j4.f12730i;
        }
        String str = j4.f12729h;
        if (str != null) {
            return str;
        }
        String str2 = j4.f12725d;
        return str2 != null ? str2 : "dummy_url";
    }

    public void cancelAll() {
        AlphaMeLogger.debugLog("Personal", "cancel all");
        S s4 = this.httpClient;
        if (s4 == null) {
            return;
        }
        Iterator it = s4.f12787a.d().iterator();
        while (it.hasNext()) {
            ((InterfaceC0602k) it.next()).cancel();
        }
        Iterator it2 = this.httpClient.f12787a.e().iterator();
        while (it2.hasNext()) {
            ((InterfaceC0602k) it2.next()).cancel();
        }
    }

    public void cancelTag(Object obj) {
        if (this.httpClient == null || obj == null) {
            return;
        }
        AlphaMeLogger.debugLog("Personal", "cancel tag:" + obj.toString());
        for (InterfaceC0602k interfaceC0602k : this.httpClient.f12787a.d()) {
            if (obj.equals(interfaceC0602k.request().d(Object.class))) {
                interfaceC0602k.cancel();
            }
        }
        for (InterfaceC0602k interfaceC0602k2 : this.httpClient.f12787a.e()) {
            if (obj.equals(interfaceC0602k2.request().d(Object.class))) {
                interfaceC0602k2.cancel();
            }
        }
    }

    public S getHttpClient() {
        return this.httpClient;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T> HttpResponse<T> request(@NonNull HttpRequest httpRequest, Class<T> cls) throws IOException {
        J j4;
        S s4 = this.httpClient;
        if (s4 == null) {
            return new HttpResponse<>();
        }
        V request = httpRequest.request;
        Intrinsics.checkNotNullParameter(request, "request");
        b0 b0VarExecute = new RealCall(s4, request, false).execute();
        HttpResponse<T> httpResponse = new HttpResponse<>();
        if (b0VarExecute != null) {
            ResponseInfo responseInfo = new ResponseInfo(httpRequest);
            int i4 = b0VarExecute.f12867d;
            responseInfo.setStatusCode(i4);
            responseInfo.setCache(b0VarExecute.f12872i != null);
            H h4 = b0VarExecute.f12869f;
            if (h4 != null) {
                responseInfo.setHeaders(h4.e());
            }
            httpResponse.setResponseInfo(responseInfo);
            V v4 = b0VarExecute.f12864a;
            AlphaMeLogger.debugLog("Personal", "%1$s's response code: %2$d, message:%3$s" + ((v4 == null || (j4 = v4.f12826a) == null) ? "" : j4.f12730i) + i4 + b0VarExecute.f12866c);
            try {
                String strString = b0VarExecute.f12870g.string();
                T tB = strString;
                if (cls != String.class) {
                    tB = new n().b(cls, strString);
                }
                httpResponse.setBody(tB);
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        }
        return httpResponse;
    }

    public <T> T requestSync(@NonNull HttpRequest httpRequest, Class<T> cls) throws IOException {
        return request(httpRequest, cls).getBody();
    }

    public <T> void request(@NonNull final HttpRequest httpRequest, final Class<T> cls, final HttpClientListener<T> httpClientListener) {
        S s4 = this.httpClient;
        if (s4 == null) {
            return;
        }
        V request = httpRequest.request;
        Intrinsics.checkNotNullParameter(request, "request");
        RealCall realCall = new RealCall(s4, request, false);
        httpRequest.call = realCall;
        realCall.enqueue(new InterfaceC0603l() { // from class: com.stepos.alphame.utils.net.EngineHttpClient.1
            @Override // h3.InterfaceC0603l
            public void onFailure(InterfaceC0602k interfaceC0602k, IOException iOException) {
                AlphaMeLogger.debugLog("Personal", "onFailure :" + iOException.getMessage());
                HttpClientListener httpClientListener2 = httpClientListener;
                if (httpClientListener2 != null) {
                    httpClientListener2.onFailure(iOException, new ResponseInfo(httpRequest));
                }
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // h3.InterfaceC0603l
            public void onResponse(InterfaceC0602k interfaceC0602k, b0 b0Var) throws IOException {
                J j4;
                if (b0Var == null) {
                    HttpClientListener httpClientListener2 = httpClientListener;
                    if (httpClientListener2 != null) {
                        httpClientListener2.onFailure(new IllegalAccessException("null response"), new ResponseInfo(httpRequest));
                        return;
                    }
                    return;
                }
                V v4 = b0Var.f12864a;
                if (v4 != null && (j4 = v4.f12826a) != null) {
                    EngineHttpClient.getPrintableUrl(j4);
                }
                StringBuilder sb = new StringBuilder("response code: %1$d, message:%2$s");
                int i4 = b0Var.f12867d;
                sb.append(i4);
                sb.append(AwarenessDataItem.PERMISSION_SPLITTER);
                String str = b0Var.f12866c;
                sb.append(str);
                AlphaMeLogger.debugLog("Personal", sb.toString());
                if (httpClientListener == null) {
                    return;
                }
                ResponseInfo responseInfo = new ResponseInfo(httpRequest);
                responseInfo.setStatusCode(i4);
                responseInfo.setCache(b0Var.f12872i != null);
                H h4 = b0Var.f12869f;
                if (h4 != null) {
                    responseInfo.setHeaders(h4.e());
                }
                if (!b0Var.d()) {
                    b0Var.close();
                    httpClientListener.onFailure(new IllegalAccessException(str), responseInfo);
                    return;
                }
                try {
                    String strString = b0Var.f12870g.string();
                    String strB = strString;
                    if (cls != String.class) {
                        strB = new n().b(cls, strString);
                    }
                    httpClientListener.onResponse(strB, responseInfo);
                } catch (Exception e4) {
                    e4.printStackTrace();
                    httpClientListener.onFailure(e4, responseInfo);
                }
            }
        });
    }
}
