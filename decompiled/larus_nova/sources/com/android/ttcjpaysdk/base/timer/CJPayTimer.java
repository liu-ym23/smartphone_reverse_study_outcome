package com.android.ttcjpaysdk.base.timer;

import android.os.CountDownTimer;

/* JADX INFO: loaded from: classes28.dex */
public class CJPayTimer extends CountDownTimer {
    private TickListener tickListener;

    public interface TickListener {
        void onFinish();

        void tick(long r100);
    }

    @Override // android.os.CountDownTimer
    public void onFinish() {
        TickListener r100 = this.tickListener;
        if (r100 == null) goto L6;
        r100.onFinish();
        return;
    }

    @Override // android.os.CountDownTimer
    public void onTick(long r100) {
        TickListener r101 = this.tickListener;
        if (r101 == null) goto L6;
        r101.tick(r100);
        return;
    }

    public void setTickListener(TickListener r100) {
        this.tickListener = r100;
    }

    public CJPayTimer(long r100, long r101) {
        super(r100, r101);
    }
}
