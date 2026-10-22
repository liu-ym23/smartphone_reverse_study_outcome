package com.stepos.activeview.moveline;

import com.stepos.activeview.moveline.TimelineTicker;

/* loaded from: classes.dex */
public final class RootTimeline extends BaseTimeline implements TimelineTicker.TimelineTickerListener {
    private int autoStop = 60;
    private int mNextSleepFrame = 60;

    public RootTimeline() {
        this.startTime = Animation.timelineTicker.getTime();
        Animation.timelineTicker.addListener(this);
    }

    @Override // com.stepos.activeview.moveline.Animation
    public int getDuration() {
        return 0;
    }

    @Override // com.stepos.activeview.moveline.TimelineTicker.TimelineTickerListener
    public void onUpdate(long j4) {
        update(j4 - this.startTime);
    }

    @Override // com.stepos.activeview.moveline.Animation
    public void update(long j4) {
        Animation animation = this.first;
        while (animation != null) {
            Animation animation2 = animation.next;
            if ((animation.isActive || j4 > animation.startTime) && !animation.isPaused()) {
                if (animation.mReversing) {
                    animation.update(animation.getDuration() - (j4 - animation.startTime));
                } else {
                    animation.update(j4 - animation.startTime);
                }
            }
            animation = animation2;
        }
        if (Animation.timelineTicker.getFrame() >= this.mNextSleepFrame) {
            this.mNextSleepFrame = Animation.timelineTicker.getFrame() + this.autoStop;
            Animation animation3 = this.first;
            if (animation3 == null) {
                Animation.timelineTicker.stop();
                return;
            }
            while (animation3 != null) {
                if (!animation3.isPaused()) {
                    return;
                } else {
                    animation3 = animation3.next;
                }
            }
            Animation.timelineTicker.stop();
        }
    }
}
