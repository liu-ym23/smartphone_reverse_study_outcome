package com.baidu.mapapi.http.wrapper;

import java.util.concurrent.ExecutorService;

/* loaded from: classes.dex */
public class AsyncResponse<T> {
    private static final ExecutorService threadPool = ThreadPoolUtils.getThreadPool();
    private Callback<T> callback;
    private T data;

    /* renamed from: e, reason: collision with root package name */
    private Throwable f6033e;
    private volatile boolean finish = false;
    private boolean success = false;
    private boolean hasCallback = false;

    public interface Callback<T> {
        void onFailed(Throwable th);

        void onSuccess(T t4);
    }

    public void onFailed(Throwable th) {
        synchronized (this) {
            this.f6033e = th;
            this.finish = true;
        }
        threadPool.submit(new Runnable() { // from class: com.baidu.mapapi.http.wrapper.AsyncResponse.3
            @Override // java.lang.Runnable
            public void run() {
                synchronized (this) {
                    try {
                        if (this.callback != null && !this.hasCallback) {
                            this.callback.onFailed(this.f6033e);
                            this.hasCallback = true;
                        }
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
            }
        });
    }

    public void onSuccess(T t4) {
        synchronized (this) {
            this.data = t4;
            this.finish = true;
            this.success = true;
        }
        threadPool.submit(new Runnable() { // from class: com.baidu.mapapi.http.wrapper.AsyncResponse.2
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Runnable
            public void run() {
                synchronized (this) {
                    try {
                        if (this.callback != null && !this.hasCallback) {
                            this.callback.onSuccess(this.data);
                            this.hasCallback = true;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
        });
    }

    public void setCallback(Callback<T> callback) {
        this.callback = callback;
        threadPool.submit(new Runnable() { // from class: com.baidu.mapapi.http.wrapper.AsyncResponse.1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Runnable
            public void run() {
                synchronized (this) {
                    try {
                        if (this.finish && !this.hasCallback) {
                            if (this.success) {
                                this.callback.onSuccess(this.data);
                            } else {
                                this.callback.onFailed(this.f6033e);
                            }
                            this.hasCallback = true;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
        });
    }
}
