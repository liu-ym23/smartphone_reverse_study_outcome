package com.baidu.naviapi.okhttp;

import com.baidu.naviapi.okhttp.log.BNLogUtil;
import java.io.IOException;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/* JADX INFO: loaded from: classes39.dex */
public class OkHttpManager extends HttpClient {
    private static final int TIMEOUT = 30;
    private final List<Call> calls;
    private String mOnlineHost;
    private int mOnlinePort;
    private OkHttpClient sClient;

    /* JADX INFO: renamed from: com.baidu.naviapi.okhttp.OkHttpManager$1, reason: invalid class name */
    public class AnonymousClass1 implements Callback {
        public final /* synthetic */ OkHttpManager this$0;
        public final /* synthetic */ HttpResponseListener val$listener;

        public static /* synthetic */ void a(HttpResponseListener r100, String r101) {
            lambda$onResponse$1(r100, r101);
        }

        public static /* synthetic */ void b(HttpResponseListener r100, IOException r101) {
            lambda$onFailure$0(r100, r101);
        }

        public AnonymousClass1(OkHttpManager r100, HttpResponseListener r101) {
            this.this$0 = r100;
            this.val$listener = r101;
        }

        private static /* synthetic */ void lambda$onFailure$0(HttpResponseListener r100, IOException r101) {
            r100.onError(r101.getMessage());
        }

        private static /* synthetic */ void lambda$onResponse$1(HttpResponseListener r100, String r101) {
            r100.onResponse(r101);
        }

        @Override // okhttp3.Callback
        public void onFailure(Call r100, final IOException r101) {
            final HttpResponseListener r102 = this.val$listener;
            if (r102 == null) goto L5;
            TaskExecutor.ui(new a(r102, r101));
        L5:
            List r103 = OkHttpManager.access$200(this.this$0);
            monitor-enter(r103);
            OkHttpManager.access$200(this.this$0).remove(r100);     // Catch: Throwable -> L10
            monitor-exit(r103);     // Catch: Throwable -> L10
            return;
        L10:
            th = move-exception;
            throw th;
        }

        @Override // okhttp3.Callback
        public void onResponse(Call r100, Response r101) throws IOException {
            if (this.val$listener != null) goto L5;
        L7:
            List r102 = OkHttpManager.access$200(this.this$0);
            monitor-enter(r102);
            OkHttpManager.access$200(this.this$0).remove(r100);     // Catch: Throwable -> L12
            monitor-exit(r102);     // Catch: Throwable -> L12
            return;
        L12:
            th = move-exception;
            throw th;
        L5:
            if (r101.body() == null) goto L7;
            final String r103 = r101.body().string();
            final HttpResponseListener r104 = this.val$listener;
            TaskExecutor.ui(new b(r104, r103));
            goto L7
        }
    }

    /* JADX INFO: renamed from: com.baidu.naviapi.okhttp.OkHttpManager$3, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass3 {
        public static final /* synthetic */ int[] $SwitchMap$com$baidu$naviapi$okhttp$RequestEntity$HttpMethod = null;

        static {
            int[] r100 = new int[RequestEntity.HttpMethod.values().length];
            $SwitchMap$com$baidu$naviapi$okhttp$RequestEntity$HttpMethod = r100;
            r100[RequestEntity.HttpMethod.GET.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            $SwitchMap$com$baidu$naviapi$okhttp$RequestEntity$HttpMethod[RequestEntity.HttpMethod.POST.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            $SwitchMap$com$baidu$naviapi$okhttp$RequestEntity$HttpMethod[RequestEntity.HttpMethod.DELETE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    public static class HttpCommonHeader implements Interceptor {
        private HttpCommonHeader() {
        }

        public /* synthetic */ HttpCommonHeader(AnonymousClass1 r100) {
            this();
        }

        @Override // okhttp3.Interceptor
        public Response intercept(Interceptor.Chain r100) throws IOException {
            Request r101 = r100.request();
            String r102 = r101.url().toString();
            Request.Builder r103 = r101.newBuilder().method(r101.method(), r101.body()).url(r102);
            r103.addHeader("X-Phone-Info", HttpConfig.phoneInfo);
            return r100.proceed(r103.build());
        }
    }

    public static class LazyHolder {
        public static final OkHttpManager MANAGER = null;

        static {
            MANAGER = new OkHttpManager(null);
        }

        private LazyHolder() {
        }
    }

    @Override // com.baidu.naviapi.okhttp.HttpClient
    public void cancelPendingRequest(String r100) {
    }

    @Override // com.baidu.naviapi.okhttp.HttpClient
    public void cancelPendingRequest() {
        BNLogUtil.logI("cancelPendingRequest");
        List<Call> r100 = this.calls;
        monitor-enter(r100);
        Iterator<Call> r101 = this.calls.iterator();     // Catch: Throwable -> L14
    L6:
        if (r101.hasNext() == false) goto L11;
        Call r102 = r101.next();     // Catch: Throwable -> L14
        if (r102 == null) goto L6;
        r102.cancel();     // Catch: Throwable -> L14
        goto L6
    L11:
        this.calls.clear();     // Catch: Throwable -> L14
        monitor-exit(r100);     // Catch: Throwable -> L14
        return;
    L14:
        th = move-exception;
        throw th;
    }

    private OkHttpManager() {
        this.calls = new LinkedList();
        this.mOnlineHost = HttpConfig.HOST;
        this.mOnlinePort = 1101;
        BNLogUtil.logE("OkHttpManager", "mOnlineHost:" + this.mOnlineHost + ",mOnlinePort:" + this.mOnlinePort);
        OkHttpClient.Builder r100 = new OkHttpClient.Builder();
        TimeUnit r101 = TimeUnit.SECONDS;
        this.sClient = r100.connectTimeout(30, r101).writeTimeout(30, r101).readTimeout(30, r101).addInterceptor(new HttpCommonHeader(null)).build();
    }

    public static OkHttpManager getInstance() {
        return LazyHolder.MANAGER;
    }

    public OkHttpClient getClient() {
        return this.sClient;
    }

    public String getOnlineHost() {
        return this.mOnlineHost;
    }

    public int getOnlinePort() {
        return this.mOnlinePort;
    }

    public /* synthetic */ OkHttpManager(AnonymousClass1 r100) {
        this();
    }

    public static /* synthetic */ List access$200(OkHttpManager r100) {
        return r100.calls;
    }

    private Request buildRequest(RequestEntity r100) {
        Request.Builder r101 = new Request.Builder().url(r100.getUrl());
        Map<String, String> r102 = r100.getHeaders();
        if (r102 == null) goto L8;
        Iterator<String> r103 = r102.keySet().iterator();
    L6:
        if (r103.hasNext() == false) goto L8;
        String r104 = r103.next();
        r101.addHeader(r104, r102.get(r104));
    L8:
        int r105 = AnonymousClass3.$SwitchMap$com$baidu$naviapi$okhttp$RequestEntity$HttpMethod[r100.getMethod().ordinal()];
        if (r105 != 1) goto L11;
        r101.get();
    L29:
        return r101.build();
    L11:
        if (r105 == 2) goto L17;
        if (r105 != 3) goto L29;
        r101.delete();
        goto L29
    L17:
        if (r100.getParams() == null) goto L29;
        FormBody.Builder r106 = new FormBody.Builder();
        Map r107 = r100.getParams();     // Catch: Exception -> L24
        Iterator r108 = r107.keySet().iterator();     // Catch: Exception -> L24
    L21:
        if (r108.hasNext() == false) goto L26;
        String r109 = (String) r108.next();     // Catch: Exception -> L24
        r106.add(r109, (String) r107.get(r109));     // Catch: Exception -> L24
    L26:
        r101.post(r106.build());
    L24:
        e = move-exception;
        e.printStackTrace();
        goto L26
    }

    private void byteRequest(RequestEntity r100, final HttpResponseListener r101) {
        Request r102 = buildRequest(r100);
        Call r103 = this.sClient.newCall(r102);
        r103.enqueue(new AnonymousClass2(this, r101));
        List<Call> r104 = this.calls;
        monitor-enter(r104);
        this.calls.add(r103);     // Catch: Throwable -> L7
        monitor-exit(r104);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private static Class<?> getClass(Type r100, int r101) {
        if ((r100 instanceof ParameterizedType) == false) goto L7;
        return getGenericClass((ParameterizedType) r100, r101);
    L7:
        if ((r100 instanceof TypeVariable) == false) goto L11;
        return getClass(((TypeVariable) r100).getBounds()[0], 0);
    L11:
        return (Class) r100;
    }

    private static Class<?> getGenericClass(ParameterizedType r100, int r101) {
        Type r102 = r100.getActualTypeArguments()[r101];
        if ((r102 instanceof ParameterizedType) == false) goto L7;
        return (Class) ((ParameterizedType) r102).getRawType();
    L7:
        if ((r102 instanceof GenericArrayType) == false) goto L11;
        return (Class) ((GenericArrayType) r102).getGenericComponentType();
    L11:
        if ((r102 instanceof TypeVariable) == false) goto L15;
        return getClass(((TypeVariable) r102).getBounds()[0], 0);
    L15:
        return (Class) r102;
    }

    private void stringRequest(RequestEntity r100, HttpResponseListener<String> r101) {
        Request r102 = buildRequest(r100);
        Call r103 = this.sClient.newCall(r102);
        r103.enqueue(new AnonymousClass1(this, r101));
        List<Call> r104 = this.calls;
        monitor-enter(r104);
        this.calls.add(r103);     // Catch: Throwable -> L7
        monitor-exit(r104);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.baidu.naviapi.okhttp.HttpClient
    public void sendRequest(RequestEntity r100, HttpResponseListener r101) {
        String r102 = getClass(r101.getClass().getGenericInterfaces()[0], 0).getName();
        if (r102.contentEquals("org.json.JSONObject") == false) goto L6;
        stringRequest(r100, r101);
        return;
    L6:
        if (r102.contentEquals("java.lang.String") == false) goto L9;
        stringRequest(r100, r101);
        return;
    L9:
        if (r102.contentEquals("byte") == false) goto L13;
        byteRequest(r100, r101);
        return;
    L13:
        throw new IllegalArgumentException("wrong listener type");
    }

    public void setOnlineHost(String r100, int r101) {
        this.mOnlineHost = r100;
        this.mOnlinePort = r101;
    }
}
