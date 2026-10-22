package com.stepos.statsapp.v3.lib.plugin.emitter.remote;

import android.util.Log;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final /* synthetic */ class b implements RejectedExecutionHandler {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8024a;

    @Override // java.util.concurrent.RejectedExecutionHandler
    public final void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
        switch (this.f8024a) {
            case 0:
                ta.c.b("V3OfflineEmitter", "Task exceeds maximum limit");
                break;
            default:
                Log.e("ScheduledExecutor", "Exceeded ThreadPoolExecutor pool size");
                break;
        }
    }
}
