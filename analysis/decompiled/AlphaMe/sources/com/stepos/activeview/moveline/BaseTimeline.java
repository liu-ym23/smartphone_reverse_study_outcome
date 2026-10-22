package com.stepos.activeview.moveline;

/* loaded from: classes.dex */
public abstract class BaseTimeline extends Animation {
    private static final String TAG = "BaseTimeline";
    protected Animation first;
    protected Animation last;
    private boolean mStarted;
    private long time;

    private long calcPosition(long j4, int i4) {
        return j4 >= 0 ? j4 + i4 : getDuration() + i4;
    }

    public void add(Animation animation) {
        BaseTimeline baseTimeline = animation.timeline;
        if (baseTimeline != null) {
            baseTimeline.remove(animation);
        }
        Animation animation2 = this.last;
        if (animation2 != null) {
            animation.next = animation2.next;
            animation2.next = animation;
        } else {
            animation.next = this.first;
            this.first = animation;
        }
        Animation animation3 = animation.next;
        if (animation3 != null) {
            animation3.prev = animation;
        } else {
            this.last = animation;
        }
        animation.prev = animation2;
        animation.timeline = this;
        this.dirty = true;
    }

    @Override // com.stepos.activeview.moveline.Animation
    public void initAnimationValue() {
    }

    public BaseTimeline remove(Animation animation) {
        if (animation.timeline == this) {
            Animation animation2 = animation.prev;
            if (animation2 != null) {
                animation2.next = animation.next;
            } else if (this.first == animation) {
                this.first = animation.next;
            }
            Animation animation3 = animation.next;
            if (animation3 != null) {
                animation3.prev = animation2;
            } else if (this.last == animation) {
                this.last = animation2;
            }
            animation.timeline = null;
            animation.prev = null;
            animation.next = null;
        }
        return this;
    }

    @Override // com.stepos.activeview.moveline.Animation
    public void setActive(boolean z4) {
        super.setActive(z4);
        for (Animation animation = this.first; animation != null; animation = animation.next) {
            animation.setActive(z4);
        }
    }

    public void add(Animation animation, int i4) {
        add(animation, -1L, i4);
    }

    public void add(Animation animation, long j4, int i4) {
        animation.startTime = calcPosition(j4, i4);
        add(animation);
    }
}
