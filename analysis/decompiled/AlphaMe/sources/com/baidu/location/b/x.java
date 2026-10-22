package com.baidu.location.b;

import java.util.concurrent.ExecutorService;

/* loaded from: classes.dex */
public class x {

    /* renamed from: a, reason: collision with root package name */
    private ExecutorService f5494a;

    /* renamed from: b, reason: collision with root package name */
    private ExecutorService f5495b;

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private static x f5496a = new x();
    }

    private x() {
        this.f5494a = null;
        this.f5495b = null;
    }

    public static x a() {
        return a.f5496a;
    }

    public synchronized ExecutorService b() {
        return this.f5494a;
    }

    public synchronized ExecutorService c() {
        return this.f5495b;
    }

    public void d() {
        ExecutorService executorService = this.f5494a;
        if (executorService != null) {
            executorService.shutdown();
        }
        ExecutorService executorService2 = this.f5495b;
        if (executorService2 != null) {
            executorService2.shutdown();
        }
    }
}
