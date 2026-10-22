package com.stepos.activeview.moveline;

import android.os.SystemClock;
import android.view.Choreographer;
import com.stepos.activeview.moveline.TimelineTicker;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class TimelineTickerFactory {

    public static class ChoreographerTimelineTicker extends TimelineTicker {
        private boolean mActive;
        private final Choreographer mChoreographer;
        private int mFrame;
        private final Choreographer.FrameCallback mFrameCallback;
        private long mLastTime;
        private long mStartTime;
        private long mTime;

        public ChoreographerTimelineTicker(Choreographer choreographer) {
            this.mChoreographer = choreographer;
            Choreographer.FrameCallback frameCallback = new Choreographer.FrameCallback() { // from class: com.stepos.activeview.moveline.TimelineTickerFactory.ChoreographerTimelineTicker.1
                @Override // android.view.Choreographer.FrameCallback
                public void doFrame(long j4) {
                    if (ChoreographerTimelineTicker.this.mActive) {
                        long jUptimeMillis = SystemClock.uptimeMillis();
                        long unused = ChoreographerTimelineTicker.this.mLastTime;
                        ChoreographerTimelineTicker.this.mLastTime = jUptimeMillis;
                        ChoreographerTimelineTicker.this.mTime = (int) (r5.mLastTime - ChoreographerTimelineTicker.this.mStartTime);
                        ChoreographerTimelineTicker.this.mFrame++;
                        ChoreographerTimelineTicker.this.dispatchUpdate();
                        ChoreographerTimelineTicker.this.mChoreographer.postFrameCallbackDelayed(ChoreographerTimelineTicker.this.mFrameCallback, TimelineTicker.sFrameDelay);
                    }
                }
            };
            this.mFrameCallback = frameCallback;
            this.mStartTime = SystemClock.uptimeMillis();
            frameCallback.doFrame(0L);
        }

        public static ChoreographerTimelineTicker create() {
            return new ChoreographerTimelineTicker(Choreographer.getInstance());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void dispatchUpdate() {
            List<TimelineTicker.TimelineTickerListener> list = this.mListeners;
            if (list == null || list.size() == 0) {
                return;
            }
            Iterator<TimelineTicker.TimelineTickerListener> it = this.mListeners.iterator();
            while (it.hasNext()) {
                it.next().onUpdate(this.mTime);
            }
        }

        @Override // com.stepos.activeview.moveline.TimelineTicker
        public int getFrame() {
            return this.mFrame;
        }

        @Override // com.stepos.activeview.moveline.TimelineTicker
        public long getTime() {
            return this.mTime;
        }

        @Override // com.stepos.activeview.moveline.TimelineTicker
        public boolean isActive() {
            return this.mActive;
        }

        @Override // com.stepos.activeview.moveline.TimelineTicker
        public void start() {
            if (this.mActive) {
                return;
            }
            this.mActive = true;
            this.mChoreographer.removeFrameCallback(this.mFrameCallback);
            this.mFrameCallback.doFrame(0L);
        }

        @Override // com.stepos.activeview.moveline.TimelineTicker
        public void stop() {
            this.mActive = false;
            this.mChoreographer.removeFrameCallback(this.mFrameCallback);
        }

        @Override // com.stepos.activeview.moveline.TimelineTicker
        public void wake() {
            start();
        }
    }

    public static TimelineTicker create() {
        return ChoreographerTimelineTicker.create();
    }
}
