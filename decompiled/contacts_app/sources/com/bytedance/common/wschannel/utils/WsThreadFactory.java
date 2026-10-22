package com.bytedance.common.wschannel.utils;

import com.bytedance.common.utility.Logger;
import java.util.concurrent.ThreadFactory;

/* JADX INFO: loaded from: classes2.dex */
public class WsThreadFactory implements ThreadFactory {
    private static final String TAG = "WsThreadFactory";
    private final String mThreadName;

    static {
    }

    static /* synthetic */ String access$000() {
        return TAG;
    }

    static /* synthetic */ String access$100(WsThreadFactory r0) {
        return r0.mThreadName;
    }

    public WsThreadFactory(String r3) {
        this.mThreadName = "WsChannel-" + r3;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(final Runnable r4) {
        if (Logger.debug() == false) goto L6;
        Logger.d(TAG, "creating newThread " + this.mThreadName);
    L6:
        return new Thread(new AnonymousClass1(this, r4), this.mThreadName);
    }
}
