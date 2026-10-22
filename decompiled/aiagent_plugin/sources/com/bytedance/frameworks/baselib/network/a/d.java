package com.bytedance.frameworks.baselib.network.a;

import android.os.Process;
import com.bytedance.common.utility.Logger;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.ThreadFactory;

/* JADX INFO: compiled from: NetworkThreadFactory.java */
/* JADX INFO: loaded from: classes.dex */
public class d implements ThreadFactory {
    private static final String TAG = "d";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f7965a;

    static {
    }

    public static /* synthetic */ void lambda$hCpMbiVgq_tDP1z4VQBP1R6LFsg(d r0, Runnable r1) {
        r0.a(r1);
    }

    public d(String r3) {
        this.f7965a = "ttnet-" + r3;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable r3) {
        final Runnable r4 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.aiagent.plugin");
        return new Thread(new $$Lambda$d$hCpMbiVgq_tDP1z4VQBP1R6LFsg(this, r4), this.f7965a);
    }

    private /* synthetic */ void a(Runnable r4) {
        Runnable r5 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r4, Runnable.class, "com.obric.aiagent.plugin");
        Process.setThreadPriority(10);
        r5.run();     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        Logger.e(TAG, "NetworkThreadFactory error when running in thread " + this.f7965a, th);
    }
}
