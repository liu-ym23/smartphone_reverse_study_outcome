package com.stepos.activeview.moveline;

import android.view.animation.Interpolator;
import com.stepos.activeview.moveline.item.FrameStyle;
import java.util.ArrayList;

/* loaded from: classes.dex */
public abstract class Animation {
    static final int RUNNING = 1;
    static final int SEEKED = 2;
    static final int STOPPED = 0;
    protected long delayTime;
    protected boolean dirty;
    protected int duration;
    protected boolean isActive;
    private AnimationListener mAnimationListener;
    private Interpolator mInterpolator;
    protected boolean mReversing;
    protected Animation next;
    protected long pauseTime;
    protected boolean paused;
    protected Animation prev;
    protected int repeatDelayTime;
    protected RootTimeline rootTimeline;
    protected long time;
    protected BaseTimeline timeline;
    protected static TimelineTicker timelineTicker = TimelineTickerFactory.create();
    private static RootTimeline sRootTimeline = new RootTimeline();
    protected int mPlayingState = 0;
    protected ArrayList<AnimationListener> mListeners = new ArrayList<>();
    protected long startTime = 0;

    public Animation() {
        RootTimeline rootTimeline = sRootTimeline;
        this.timeline = rootTimeline;
        this.rootTimeline = rootTimeline;
    }

    public void addListener(AnimationListener animationListener) {
        this.mListeners.add(animationListener);
    }

    public int geRepeatDelayTime() {
        return this.repeatDelayTime;
    }

    public AnimationListener getAnimationListener() {
        return this.mAnimationListener;
    }

    public int getDuration() {
        return this.duration;
    }

    public FrameStyle getFrameStyle() {
        return null;
    }

    public Interpolator getInterpolator() {
        return this.mInterpolator;
    }

    public abstract void initAnimationValue();

    public boolean isActive() {
        return this.isActive;
    }

    public boolean isPaused() {
        return this.paused;
    }

    public void notifyEndListeners() {
        ArrayList<AnimationListener> arrayList = this.mListeners;
        if (arrayList != null) {
            ArrayList arrayList2 = (ArrayList) arrayList.clone();
            int size = arrayList2.size();
            for (int i4 = 0; i4 < size; i4++) {
                ((AnimationListener) arrayList2.get(i4)).onAnimationEnd(this);
            }
        }
    }

    public void notifyStartListeners() {
        ArrayList<AnimationListener> arrayList = this.mListeners;
        if (arrayList != null) {
            ArrayList arrayList2 = (ArrayList) arrayList.clone();
            int size = arrayList2.size();
            for (int i4 = 0; i4 < size; i4++) {
                ((AnimationListener) arrayList2.get(i4)).onAnimationStart(this);
            }
        }
    }

    public void pause() {
    }

    public void play() {
    }

    public void resume() {
    }

    public void reverse() {
    }

    public void setActive(boolean z4) {
        this.isActive = z4;
    }

    @Deprecated
    public void setAnimationListener(AnimationListener animationListener) {
        this.mAnimationListener = animationListener;
    }

    public void setDelayTime(int i4) {
        this.delayTime = i4;
    }

    public void setInterpolator(Interpolator interpolator) {
        this.mInterpolator = interpolator;
    }

    public void setRepeatDelayTime(int i4) {
        this.repeatDelayTime = i4;
    }

    public void stop() {
    }

    public abstract void update(long j4);
}
