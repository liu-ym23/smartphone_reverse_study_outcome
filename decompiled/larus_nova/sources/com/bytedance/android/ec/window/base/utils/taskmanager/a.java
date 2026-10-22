package com.bytedance.android.ec.window.base.utils.taskmanager;

import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.util.concurrent.ThreadFactory;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class a implements ThreadFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f49773a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f49774b;

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable r100) {
        Intrinsics.checkNotNullParameter(r100, "r");
        PthreadThreadV2 r101 = new PthreadThreadV2(r100, this.f49773a);
        r101.setDaemon(false);
        ThreadMethodProxy.setPriority(r101, this.f49774b);
        return r101;
    }

    public a(String r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "name");
        this.f49773a = r100;
        this.f49774b = r101;
    }
}
