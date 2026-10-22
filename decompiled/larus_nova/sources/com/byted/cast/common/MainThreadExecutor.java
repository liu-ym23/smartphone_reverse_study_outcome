package com.byted.cast.common;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes39.dex */
public class MainThreadExecutor implements Executor {
    private final Handler handler;

    public MainThreadExecutor() {
        this.handler = new Handler(Looper.getMainLooper());
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable r100) {
        this.handler.post(r100);
    }
}
