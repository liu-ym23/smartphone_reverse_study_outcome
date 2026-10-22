package com.baidu.mapapi.http.wrapper;

/* JADX INFO: loaded from: classes39.dex */
public class Response<T> {
    private T data;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Throwable f30577e;

    public Response() {
    }

    public T getData() {
        return this.data;
    }

    public Throwable getE() {
        return this.f30577e;
    }

    public void setData(T r100) {
        this.data = r100;
    }

    public void setE(Throwable r100) {
        this.f30577e = r100;
    }

    public Response(T r100, Throwable r101) {
        this.data = r100;
        this.f30577e = r101;
    }
}
