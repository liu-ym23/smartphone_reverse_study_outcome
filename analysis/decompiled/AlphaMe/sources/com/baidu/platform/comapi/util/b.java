package com.baidu.platform.comapi.util;

import java.util.concurrent.ThreadFactory;

/* loaded from: classes.dex */
class b implements ThreadFactory {

    /* renamed from: a, reason: collision with root package name */
    private String f9302a;

    public b(String str) {
        this.f9302a = B0.g.m("BaiduMapSDK-", str);
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        return new Thread(runnable, this.f9302a);
    }
}
