package com.stepos.activeview.moveline;

import android.view.animation.Interpolator;
import com.stepos.activeview.moveline.item.FrameStyle;
import com.stepos.activeview.moveline.item.TweenItem;
import com.stepos.alphame.utils.Property;

/* loaded from: classes.dex */
public class Timeline extends BaseTimeline {
    public static final int INFINITE = -1;
    public static final String RESTART = "restart";
    public static final String REVERSE = "reverse";
    private boolean mPlayingBackwards;
    private boolean mStarted;
    private long time;
    private int mRepeatCount = 0;
    private float mRepeatDelay = Property.DEFAULT_FLOAT_VALUE;
    private String mRepeatMode = RESTART;
    private int mCurrentIteration = 0;
    float mSeekFraction = -1.0f;

    private void attachToRoot() {
        this.rootTimeline.add(this, this.startTime, 0);
    }

    private void detachFromRoot() {
        this.rootTimeline.remove(this);
    }

    private void initState() {
        this.mPlayingState = 0;
    }

    private void jumpToEnd() {
        if (this.mReversing) {
            for (Animation animation = this.last; animation != null; animation = animation.prev) {
                if (animation.mReversing) {
                    animation.update(animation.getDuration());
                } else {
                    animation.update(0L);
                }
            }
            return;
        }
        for (Animation animation2 = this.first; animation2 != null; animation2 = animation2.next) {
            if (animation2.mReversing) {
                animation2.update(0L);
            } else {
                animation2.update(animation2.getDuration());
            }
        }
    }

    private void start(boolean z4) {
        initState();
        this.mPlayingBackwards = z4;
        this.mReversing = z4;
        if (!Animation.timelineTicker.isActive()) {
            Animation.timelineTicker.wake();
        }
        if (this.mPlayingState != 2) {
            setCurrentPlayTime(0L);
            this.startTime += this.delayTime;
            this.time = this.mReversing ? getDuration() : 0L;
            for (Animation animation = this.first; animation != null; animation = animation.next) {
                animation.time = 0L;
            }
        } else {
            this.startTime = Animation.timelineTicker.getTime() - ((long) (getDuration() * this.mSeekFraction));
        }
        attachToRoot();
        this.mStarted = true;
        this.paused = false;
        if (this.mPlayingState != 1) {
            notifyStartListeners();
        }
    }

    private void updateChild(long j4) {
        long j5;
        long j6;
        for (Animation animation = this.first; animation != null; animation = animation.next) {
            if (animation.isActive || animation.startTime <= j4) {
                if (animation.mReversing) {
                    animation.update(animation.getDuration() - (j4 - animation.startTime));
                } else {
                    if (this.mPlayingBackwards) {
                        int duration = animation.getDuration();
                        int iGeRepeatDelayTime = animation.geRepeatDelayTime();
                        if ((duration + iGeRepeatDelayTime) - j4 < duration) {
                            j5 = iGeRepeatDelayTime;
                        } else {
                            j6 = 0;
                            animation.update(j6);
                        }
                    } else {
                        j5 = animation.startTime;
                    }
                    j6 = j4 - j5;
                    animation.update(j6);
                }
            }
        }
    }

    @Override // com.stepos.activeview.moveline.Animation
    public int getDuration() {
        if (this.dirty) {
            Animation animation = this.last;
            long j4 = 0;
            while (animation != null) {
                Animation animation2 = animation.prev;
                long duration = animation.startTime + animation.getDuration() + animation.geRepeatDelayTime();
                if (duration > j4) {
                    j4 = duration;
                }
                animation = animation2;
            }
            this.duration = (int) j4;
            this.dirty = false;
        }
        return super.getDuration();
    }

    @Override // com.stepos.activeview.moveline.BaseTimeline, com.stepos.activeview.moveline.Animation
    public void initAnimationValue() {
        for (Animation animation = this.last; animation != null; animation = animation.prev) {
            animation.initAnimationValue();
        }
    }

    @Override // com.stepos.activeview.moveline.Animation
    public boolean isPaused() {
        return this.paused;
    }

    public boolean isRunning() {
        return this.mStarted;
    }

    @Override // com.stepos.activeview.moveline.Animation
    public void pause() {
        if (this.paused || !this.mStarted) {
            return;
        }
        if (this.mPlayingState != 1) {
            this.time = Animation.timelineTicker.getTime() - (this.startTime - this.delayTime);
        }
        this.pauseTime = this.time;
        this.paused = true;
    }

    @Override // com.stepos.activeview.moveline.Animation
    public void play() {
        start(false);
    }

    @Override // com.stepos.activeview.moveline.Animation
    public void resume() {
        if (this.paused) {
            if (!Animation.timelineTicker.isActive()) {
                Animation.timelineTicker.wake();
            }
            if (this.mPlayingState == 1 || this.time >= this.delayTime) {
                this.startTime = Animation.timelineTicker.getTime() - (!this.mReversing ? this.pauseTime : getDuration() - this.pauseTime);
            } else {
                this.startTime = (this.delayTime - this.pauseTime) + Animation.timelineTicker.getTime();
            }
            this.paused = false;
        }
    }

    @Override // com.stepos.activeview.moveline.Animation
    public void reverse() {
        start(true);
    }

    @Override // com.stepos.activeview.moveline.BaseTimeline, com.stepos.activeview.moveline.Animation
    public void setActive(boolean z4) {
        super.setActive(z4);
        for (Animation animation = this.first; animation != null; animation = animation.next) {
            animation.setActive(z4);
        }
    }

    public void setCurrentFraction(float f4) {
        if (f4 < Property.DEFAULT_FLOAT_VALUE) {
            f4 = 0.0f;
        }
        int i4 = (int) f4;
        if (f4 == 1.0f) {
            i4--;
        } else if (f4 > 1.0f) {
            int i5 = this.mRepeatCount;
            if (i4 < i5 + 1 || i5 == -1) {
                if (this.mRepeatMode == REVERSE) {
                    this.mPlayingBackwards = i4 % 2 != 0;
                }
                f4 %= 1.0f;
            } else {
                i4--;
                f4 = 1.0f;
            }
        } else {
            this.mPlayingBackwards = this.mReversing;
        }
        this.mCurrentIteration = i4;
        long duration = (long) (getDuration() * f4);
        this.startTime = Animation.timelineTicker.getTime() - duration;
        if (this.mPlayingState != 1) {
            this.mSeekFraction = f4;
            this.mPlayingState = 2;
        }
        if (this.mPlayingBackwards) {
            duration = getDuration() - duration;
        }
        initAnimationValue();
        setActive(false);
        updateChild(duration);
    }

    public void setCurrentPlayTime(long j4) {
        int duration = getDuration();
        setCurrentFraction(duration > 0 ? j4 / duration : 1.0f);
    }

    public void setRepeatCount(int i4) {
        this.mRepeatCount = i4;
    }

    public void setRepeatDelay(float f4) {
        this.mRepeatDelay = f4;
    }

    public void setRepeatMode(String str) {
        this.mRepeatMode = str;
    }

    @Override // com.stepos.activeview.moveline.Animation
    public void stop() {
        detachFromRoot();
        if (this.mReversing) {
            getDuration();
        }
        jumpToEnd();
        if (getAnimationListener() != null) {
            getAnimationListener().onAnimationStopped(this);
        }
        this.mStarted = false;
    }

    public Timeline to(TweenItem tweenItem, int i4, FrameStyle frameStyle, int i5) {
        return to(tweenItem, i4, frameStyle, -1, i5);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0022  */
    @Override // com.stepos.activeview.moveline.Animation
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void update(long r10) {
        /*
            r9 = this;
            int r0 = r9.getDuration()
            r1 = 0
            if (r0 > 0) goto L8
            goto L6c
        L8:
            long r2 = r9.time
            long r4 = (long) r0
            int r0 = (r10 > r4 ? 1 : (r10 == r4 ? 0 : -1))
            r6 = 0
            r8 = 1
            if (r0 < 0) goto L40
            r9.time = r4
            int r10 = r9.mCurrentIteration
            int r11 = r9.mRepeatCount
            if (r10 < r11) goto L24
            r10 = -1
            if (r11 != r10) goto L1e
            goto L24
        L1e:
            boolean r10 = r9.mReversing
            if (r10 != 0) goto L4d
        L22:
            r10 = r8
            goto L4e
        L24:
            java.lang.String r10 = r9.mRepeatMode
            java.lang.String r11 = "reverse"
            boolean r10 = r10.equals(r11)
            if (r10 == 0) goto L35
            boolean r10 = r9.mPlayingBackwards
            r10 = r10 ^ r8
            r9.mPlayingBackwards = r10
            r9.time = r6
        L35:
            long r10 = r9.startTime
            long r10 = r10 + r4
            r9.startTime = r10
            int r10 = r9.mCurrentIteration
            int r10 = r10 + r8
            r9.mCurrentIteration = r10
            goto L4d
        L40:
            int r0 = (r10 > r6 ? 1 : (r10 == r6 ? 0 : -1))
            if (r0 >= 0) goto L4b
            r9.time = r6
            boolean r10 = r9.mReversing
            if (r10 == 0) goto L4d
            goto L22
        L4b:
            r9.time = r10
        L4d:
            r10 = r1
        L4e:
            long r6 = r9.time
            int r11 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
            if (r11 != 0) goto L55
            return
        L55:
            boolean r11 = r9.isActive
            if (r11 != 0) goto L5b
            r9.isActive = r8
        L5b:
            boolean r11 = r9.mReversing
            if (r11 != 0) goto L65
            boolean r11 = r9.mPlayingBackwards
            if (r11 == 0) goto L65
            long r6 = r4 - r6
        L65:
            r9.updateChild(r6)
            r9.mPlayingState = r8
            if (r10 == 0) goto L85
        L6c:
            r9.detachFromRoot()
            r9.isActive = r1
            r9.mStarted = r1
            r9.mPlayingState = r1
            com.stepos.activeview.moveline.AnimationListener r10 = r9.getAnimationListener()
            if (r10 == 0) goto L82
            com.stepos.activeview.moveline.AnimationListener r10 = r9.getAnimationListener()
            r10.onAnimationEnd(r9)
        L82:
            r9.notifyEndListeners()
        L85:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.activeview.moveline.Timeline.update(long):void");
    }

    public Timeline to(TweenItem tweenItem, int i4, FrameStyle frameStyle, int i5, int i6) {
        return to(tweenItem, i4, frameStyle, null, i5, i6, 0);
    }

    public Timeline to(TweenItem tweenItem, int i4, FrameStyle frameStyle, Interpolator interpolator, int i5, int i6, int i7) {
        Tween tween = new Tween(tweenItem, i4, frameStyle, i7);
        tween.setInterpolator(interpolator);
        add(tween, i5, i6);
        return this;
    }
}
