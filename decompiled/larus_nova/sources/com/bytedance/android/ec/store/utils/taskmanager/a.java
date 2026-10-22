package com.bytedance.android.ec.store.utils.taskmanager;

import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.util.concurrent.ThreadFactory;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class a implements ThreadFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f48692a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f48693b;

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable r100) {
        Intrinsics.checkNotNullParameter(r100, "r");
        PthreadThreadV2 r101 = new PthreadThreadV2(r100, this.f48692a);
        r101.setDaemon(false);
        ThreadMethodProxy.setPriority(r101, this.f48693b);
        return r101;
    }

    public a(String r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "name");
        this.f48692a = r100;
        this.f48693b = r101;
    }
}
