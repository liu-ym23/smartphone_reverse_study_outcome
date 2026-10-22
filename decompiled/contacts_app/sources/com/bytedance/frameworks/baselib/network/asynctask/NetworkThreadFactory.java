package com.bytedance.frameworks.baselib.network.asynctask;

import android.os.Process;
import com.bytedance.common.utility.Logger;
import java.util.concurrent.ThreadFactory;

/* JADX INFO: loaded from: classes2.dex */
public class NetworkThreadFactory implements ThreadFactory {
    private static final String TAG = "NetworkThreadFactory";
    private final String mThreadName;

    static {
    }

    public NetworkThreadFactory(String r3) {
        this.mThreadName = "ttnet-" + r3;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(final Runnable r3) {
        return new Thread(new NetworkThreadFactory$$ExternalSyntheticLambda0(this, r3), this.mThreadName);
    }

    /* JADX INFO: renamed from: lambda$newThread$0$com-bytedance-frameworks-baselib-network-asynctask-NetworkThreadFactory, reason: not valid java name */
    /* synthetic */ void m233x6b2a5155(Runnable r4) {
        Process.setThreadPriority(10);
        r4.run();     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        Logger.e(TAG, "NetworkThreadFactory error when running in thread " + this.mThreadName, th);
    }
}
