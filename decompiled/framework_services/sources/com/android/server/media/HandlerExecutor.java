package com.android.server.media;

import android.os.Handler;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;

/* JADX INFO: loaded from: classes2.dex */
public class HandlerExecutor implements Executor {
    private final Handler mHandler;

    public HandlerExecutor(Handler handler) {
        handler.getClass();
        this.mHandler = handler;
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable command) {
        if (this.mHandler.post(command) == false) goto L6;
        return;
    L6:
        throw new RejectedExecutionException(this.mHandler + " is shutting down");
    }
}
