package com.baidu.platform.comapi.util;

import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.util.concurrent.ThreadFactory;

/* JADX INFO: loaded from: classes39.dex */
class b implements ThreadFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f33422a;

    public b(String r100) {
        this.f33422a = "BaiduMapSDK-" + r100;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable r100) {
        return new PthreadThreadV2(r100, this.f33422a);
    }
}
