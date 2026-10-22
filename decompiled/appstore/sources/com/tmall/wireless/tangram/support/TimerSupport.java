package com.tmall.wireless.tangram.support;

import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class TimerSupport implements Runnable {
    private static final int MILLISECOND = 1000;
    private List<IntervalTickListener> mCopyListeners;
    private HandlerTimer mDefaultTimer;
    private Map<OnTickListener, IntervalTickListener> mListeners;

    public static final class IntervalTickListener {
        private int count;
        private int interval;
        private OnTickListener mListener;

        public IntervalTickListener(int r10, @NonNull OnTickListener r11, boolean r12) {
            this.interval = r10;
            this.count = 0;
            this.mListener = r11;
            if (r12 == false) goto L6;
            r11.onTick();
            return;
        }

        public void onTick() {
            int r10 = (this.count + 1) % this.interval;
            this.count = r10;
            if (r10 != 0) goto L8;
            OnTickListener r11 = this.mListener;
            if (r11 == null) goto L9;
            r11.onTick();
            return;
        L9:
            return;
        }
    }

    public interface OnTickListener {
        void onTick();
    }

    public TimerSupport() {
        this.mListeners = new HashMap();
        this.mCopyListeners = new ArrayList();
        this.mDefaultTimer = new HandlerTimer(1000, this);
    }

    public void clear() {
        this.mListeners.clear();
        this.mDefaultTimer.stop();
    }

    public HandlerTimer.TimerStatus getStatus() {
        return this.mDefaultTimer.getStatus();
    }

    public boolean isRegistered(@NonNull OnTickListener r10) {
        return this.mListeners.containsKey(r10);
    }

    public void pause() {
        this.mDefaultTimer.pause();
    }

    public void register(int r10, @NonNull OnTickListener r11) {
        register(r10, r11, false);
    }

    public void restart() {
        this.mDefaultTimer.restart();
    }

    @Override // java.lang.Runnable
    public void run() {
        this.mCopyListeners.clear();
        this.mCopyListeners.addAll(this.mListeners.values());
        int r10 = this.mCopyListeners.size();
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L6;
        this.mCopyListeners.get(r11).onTick();
        r11 = r11 + 1;
        goto L3
    L6:
        if (this.mListeners.isEmpty() == false) goto L10;
        this.mDefaultTimer.stop();
        return;
    }

    public void unregister(@NonNull OnTickListener r10) {
        this.mListeners.remove(r10);
    }

    public void register(int r10, @NonNull OnTickListener r11, boolean r12) {
        this.mListeners.put(r11, new IntervalTickListener(r10, r11, r12));
        this.mDefaultTimer.start(false);
    }
}
