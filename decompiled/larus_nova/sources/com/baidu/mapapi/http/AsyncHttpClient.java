package com.baidu.mapapi.http;

import com.baidu.mapsdkplatform.comapi.util.PermissionCheck;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import java.util.concurrent.ExecutorService;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes39.dex */
public class AsyncHttpClient {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f30555a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f30556b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ExecutorService f30557c;

    public class a extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ HttpClient.ProtoResultCallback f30558a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f30559b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ AsyncHttpClient f30560c;

        @Override // com.baidu.mapapi.http.AsyncHttpClient.b
        public void a() {
            HttpClient r100 = new HttpClient("GET", this.f30558a);
            r100.setMaxTimeOut(AsyncHttpClient.a(this.f30560c));
            r100.setReadTimeOut(AsyncHttpClient.b(this.f30560c));
            r100.request(this.f30559b);
        }

        public a(AsyncHttpClient r100, HttpClient.ProtoResultCallback r101, String r102) {
            this.f30560c = r100;
            this.f30558a = r101;
            this.f30559b = r102;
            super(null);
        }
    }

    public static abstract class b implements Runnable {
        public abstract void a();

        @Override // java.lang.Runnable
        public void run() {
            com_baidu_mapapi_http_AsyncHttpClient$b_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        private b() {
        }

        public void com_baidu_mapapi_http_AsyncHttpClient$b__run$___twin___() {
            a();
        }

        public /* synthetic */ b(a r100) {
            this();
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void com_baidu_mapapi_http_AsyncHttpClient$b_com_larus_apm_impl_protector_RunnableLancet_run(b r100) {
            r100.com_baidu_mapapi_http_AsyncHttpClient$b__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public AsyncHttpClient() {
        this.f30555a = 10000;
        this.f30556b = 10000;
        this.f30557c = PThreadExecutorsUtils.newCachedThreadPool(new DefaultThreadFactory("AsyncHttpClient"));
    }

    public boolean isAuthorized() {
        int r100 = PermissionCheck.permissionCheck();
        if (r100 != 0) goto L5;
    L10:
        return true;
    L5:
        if (r100 == 602) goto L10;
        if (r100 == 601) goto L10;
        return false;
    }

    public static /* synthetic */ int a(AsyncHttpClient r100) {
        return r100.f30555a;
    }

    public static /* synthetic */ int b(AsyncHttpClient r100) {
        return r100.f30556b;
    }

    public void get(String r100, HttpClient.ProtoResultCallback r101) {
        if (r100 == null) goto L6;
        this.f30557c.submit(new a(this, r101, r100));
        return;
    L6:
        throw new IllegalArgumentException("URI cannot be null");
    }
}
