package com.stepos.statsapp.v3.lib.plugin.emitter.remote;

import android.util.Log;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class b implements RejectedExecutionHandler {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2823a;

    @Override // java.util.concurrent.RejectedExecutionHandler
    public final void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
        switch (this.f2823a) {
            case 0:
                ua.c.b("V3OfflineEmitter", "Task exceeds maximum limit");
                break;
            default:
                Log.e("ScheduledExecutor", "Exceeded ThreadPoolExecutor pool size");
                break;
        }
    }
}
