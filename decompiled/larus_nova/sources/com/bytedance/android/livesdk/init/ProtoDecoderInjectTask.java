package com.bytedance.android.livesdk.init;

import com.bytedance.android.live.core.launch.AbsTask;
import com.bytedance.android.live.core.launch.Task;
import com.bytedance.android.live.core.launch.WorkThreadTask;
import com.bytedance.android.live.network.api.IMiddlewareNetworkService;
import com.bytedance.android.tools.pbadapter.annotation.GenProtoDecoders;
import java.util.Map;

/* JADX INFO: loaded from: classes9.dex */
@GenProtoDecoders
@WorkThreadTask
@Task(businessInfo = "WTO_ProtoDecoderInjectTask", value = 7)
public class ProtoDecoderInjectTask extends AbsTask {
    private static boolean hasInjected;
    private static final Object lock = null;

    static {
        lock = new Object();
    }

    @Override // com.bytedance.android.live.core.launch.AbsTask
    public void run() {
        Object r100 = lock;
        monitor-enter(r100);
    L17:
        th = move-exception;
        throw th;
    L5:
        if (hasInjected == false) goto L8;
        monitor-exit(r100);     // Catch: Throwable -> L17
        return;
    L8:
        hasInjected = true;     // Catch: Throwable -> L17
        if (t.f132673a == true) goto L15;
        yb.a.call("modelx");     // Catch: Throwable -> L17
        Map<Class, am3.c> r101 = hz.a.f487664a;     // Catch: Throwable -> L17
        if (jc1.k.f(IMiddlewareNetworkService.class) == null) goto L14;
        ((IMiddlewareNetworkService) jc1.k.f(IMiddlewareNetworkService.class)).injectProtoDecoders(r101);     // Catch: Throwable -> L17
    L14:
        t.f132673a = true;     // Catch: Throwable -> L17
    L15:
        monitor-exit(r100);     // Catch: Throwable -> L17
    }

    public ProtoDecoderInjectTask() {
    }
}
