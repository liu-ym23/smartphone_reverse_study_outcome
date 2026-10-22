package com.baidu.mapapi.http.wrapper;

/* loaded from: classes.dex */
public class Response<T> {
    private T data;

    /* renamed from: e, reason: collision with root package name */
    private Throwable f6034e;

    public Response() {
    }

    public T getData() {
        return this.data;
    }

    public Throwable getE() {
        return this.f6034e;
    }

    public void setData(T t4) {
        this.data = t4;
    }

    public void setE(Throwable th) {
        this.f6034e = th;
    }

    public Response(T t4, Throwable th) {
        this.data = t4;
        this.f6034e = th;
    }
}
