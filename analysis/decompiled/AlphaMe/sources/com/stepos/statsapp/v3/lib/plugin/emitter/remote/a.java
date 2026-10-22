package com.stepos.statsapp.v3.lib.plugin.emitter.remote;

import android.util.Log;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

/* loaded from: classes.dex */
public final /* synthetic */ class a implements RejectedExecutionHandler {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f12320a;

    public /* synthetic */ a(int i4) {
        this.f12320a = i4;
    }

    @Override // java.util.concurrent.RejectedExecutionHandler
    public final void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
        switch (this.f12320a) {
            case 0:
                T2.d.b("V3OfflineEmitter", "Task exceeds maximum limit");
                break;
            default:
                Log.e("ScheduledExecutor", "Exceeded ThreadPoolExecutor pool size");
                break;
        }
    }
}
