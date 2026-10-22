package com.stepos.activeview.moveline;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public abstract class TimelineTicker {
    private static final int DEFAULT_FRAME_DELAY = 10;
    protected static long sFrameDelay = 10;
    protected List<TimelineTickerListener> mListeners;

    public interface TimelineTickerListener {
        void onUpdate(long j4);
    }

    public static void setFrameDelay(long j4) {
        sFrameDelay = j4;
    }

    public void addListener(TimelineTickerListener timelineTickerListener) {
        if (this.mListeners == null) {
            this.mListeners = new ArrayList();
        }
        this.mListeners.add(timelineTickerListener);
    }

    public abstract int getFrame();

    public abstract long getTime();

    public abstract boolean isActive();

    public void removeListener(TimelineTickerListener timelineTickerListener) {
        List<TimelineTickerListener> list = this.mListeners;
        if (list == null) {
            return;
        }
        list.remove(timelineTickerListener);
    }

    public abstract void start();

    public abstract void stop();

    public abstract void wake();
}
