package com.baidu.mapapi.http.wrapper;

import com.baidu.mapapi.a;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes39.dex */
public class AsyncResponse<T> {
    private static final ExecutorService threadPool = null;
    private Callback<T> callback;
    private T data;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Throwable f30576e;
    private volatile boolean finish;
    private boolean hasCallback;
    private boolean success;

    public interface Callback<T> {
        void onFailed(Throwable r100);

        void onSuccess(T r100);
    }

    static {
        threadPool = a.a();
    }

    public AsyncResponse() {
        this.finish = false;
        this.success = false;
        this.hasCallback = false;
    }

    public static /* synthetic */ boolean access$000(AsyncResponse r100) {
        return r100.finish;
    }

    public static /* synthetic */ boolean access$100(AsyncResponse r100) {
        return r100.hasCallback;
    }

    public static /* synthetic */ boolean access$200(AsyncResponse r100) {
        return r100.success;
    }

    public static /* synthetic */ Object access$300(AsyncResponse r100) {
        return r100.data;
    }

    public static /* synthetic */ Callback access$400(AsyncResponse r100) {
        return r100.callback;
    }

    public static /* synthetic */ Throwable access$500(AsyncResponse r100) {
        return r100.f30576e;
    }

    public void onFailed(Throwable r100) {
        monitor-enter(this);
        this.f30576e = r100;     // Catch: Throwable -> L7
        this.finish = true;     // Catch: Throwable -> L7
        monitor-exit(this);     // Catch: Throwable -> L7
        threadPool.submit(new AnonymousClass3(this, this));
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void onSuccess(T r100) {
        monitor-enter(this);
        this.data = r100;     // Catch: Throwable -> L7
        this.finish = true;     // Catch: Throwable -> L7
        this.success = true;     // Catch: Throwable -> L7
        monitor-exit(this);     // Catch: Throwable -> L7
        threadPool.submit(new AnonymousClass2(this, this));
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void setCallback(Callback<T> r100) {
        this.callback = r100;
        threadPool.submit(new AnonymousClass1(this, this));
    }

    public static /* synthetic */ boolean access$102(AsyncResponse r100, boolean r101) {
        r100.hasCallback = r101;
        return r101;
    }
}
