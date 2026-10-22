package com.bytedance.common.wschannel.server;

import android.content.Context;
import android.os.HandlerThread;

/* JADX INFO: loaded from: classes2.dex */
public class MainChannelManager {
    private static volatile ChannelManager sInstance;

    private MainChannelManager() {
    }

    public static ChannelManager inst(Context r2) {
        if (sInstance != null) goto L15;
        monitor-enter(ChannelManager.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = createChannelManager(r2);     // Catch: Throwable -> L11
    L9:
        monitor-exit(ChannelManager.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    private static ChannelManager createChannelManager(Context r10) {
        HandlerThread r0 = new HandlerThread("wschannel");
        r0.start();
        ChannelKeeper r6 = new ChannelKeeper();
        MainMsgHandler r1 = new MainMsgHandler(r10, r6);
        IEnableObserver r8 = new AnonymousClass1();
        ChannelManager r9 = new ChannelManager(r10, r0.getLooper(), new AnonymousClass2(), r6, r1, r8);
        r1.setChannelManager(r9);
        return r9;
    }
}
