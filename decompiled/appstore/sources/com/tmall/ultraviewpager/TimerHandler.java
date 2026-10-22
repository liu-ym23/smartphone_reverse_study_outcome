package com.tmall.ultraviewpager;

import android.os.Handler;
import android.os.Message;

/* JADX INFO: loaded from: classes4.dex */
class TimerHandler extends Handler {
    static final int MSG_TIMER_ID = 87108;
    long interval;
    boolean isStopped;
    TimerHandlerListener listener;

    public interface TimerHandlerListener {
        void callBack();
    }

    public TimerHandler(TimerHandlerListener r10, long r11) {
        this.isStopped = true;
        this.listener = r10;
        this.interval = r11;
    }

    @Override // android.os.Handler
    public void handleMessage(Message r10) {
        if (MSG_TIMER_ID != r10.what) goto L9;
        TimerHandlerListener r11 = this.listener;
        if (r11 == null) goto L7;
        r11.callBack();
    L7:
        sendEmptyMessageDelayed(MSG_TIMER_ID, this.interval);
        return;
    }
}
