package com.byted.cast.mediacommon.utils;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* JADX INFO: loaded from: classes39.dex */
public class HandlerWrapper {
    private final Handler mHandler;

    public Looper getLooper() {
        return this.mHandler.getLooper();
    }

    public Handler getHandler() {
        return this.mHandler;
    }

    public HandlerWrapper(Handler r100) {
        this.mHandler = r100;
    }

    public boolean post(Runnable r100) {
        return this.mHandler.post(r100);
    }

    public void removeCallbacks(Runnable r100) {
        this.mHandler.removeCallbacks(r100);
    }

    public void removeMessages(int r100) {
        this.mHandler.removeMessages(r100);
    }

    public boolean postDelayed(Runnable r100, long r101) {
        return this.mHandler.postDelayed(r100, r101);
    }

    public void sendMessageDelayed(Message r100, long r101) {
        this.mHandler.sendMessageDelayed(r100, r101);
    }
}
