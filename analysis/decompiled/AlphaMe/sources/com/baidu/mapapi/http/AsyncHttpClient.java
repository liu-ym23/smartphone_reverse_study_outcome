package com.baidu.mapapi.http;

import com.baidu.mapapi.http.HttpClient;
import com.baidu.mapsdkplatform.comapi.util.PermissionCheck;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: classes.dex */
public class AsyncHttpClient {

    /* renamed from: a, reason: collision with root package name */
    private int f6012a = 10000;

    /* renamed from: b, reason: collision with root package name */
    private int f6013b = 10000;

    /* renamed from: c, reason: collision with root package name */
    private ExecutorService f6014c = Executors.newCachedThreadPool();

    public class a extends b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ HttpClient.ProtoResultCallback f6015a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f6016b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(HttpClient.ProtoResultCallback protoResultCallback, String str) {
            super(null);
            this.f6015a = protoResultCallback;
            this.f6016b = str;
        }

        @Override // com.baidu.mapapi.http.AsyncHttpClient.b
        public void a() throws Throwable {
            HttpClient httpClient = new HttpClient("GET", this.f6015a);
            httpClient.setMaxTimeOut(AsyncHttpClient.this.f6012a);
            httpClient.setReadTimeOut(AsyncHttpClient.this.f6013b);
            httpClient.request(this.f6016b);
        }
    }

    public static abstract class b implements Runnable {
        private b() {
        }

        public abstract void a();

        @Override // java.lang.Runnable
        public void run() {
            a();
        }

        public /* synthetic */ b(a aVar) {
            this();
        }
    }

    public void get(String str, HttpClient.ProtoResultCallback protoResultCallback) {
        if (str == null) {
            throw new IllegalArgumentException("URI cannot be null");
        }
        this.f6014c.submit(new a(protoResultCallback, str));
    }

    public boolean isAuthorized() {
        int iPermissionCheck = PermissionCheck.permissionCheck();
        return iPermissionCheck == 0 || iPermissionCheck == 602 || iPermissionCheck == 601;
    }
}
