package com.autonavi.amap.mapcore.animation;

import android.content.Context;
import android.graphics.RectF;
import android.os.Handler;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import com.amap.api.maps.model.animation.Animation;

/* JADX INFO: loaded from: classes39.dex */
public class GLAnimation implements Cloneable {
    public static final int ABSOLUTE = 0;
    public static final int INFINITE = -1;
    public static final int RELATIVE_TO_PARENT = 2;
    public static final int RELATIVE_TO_SELF = 1;
    public static final int RESTART = 1;
    public static final int REVERSE = 2;
    public static final int START_ON_FIRST_FRAME = -1;
    public static final int ZORDER_BOTTOM = -1;
    public static final int ZORDER_NORMAL = 0;
    public static final int ZORDER_TOP = 1;
    private int mBackgroundColor;
    boolean mCycleFlip;
    private boolean mDetachWallpaper;
    long mDuration;
    boolean mEnded;
    boolean mFillAfter;
    boolean mFillBefore;
    boolean mFillEnabled;
    boolean mInitialized;
    Interpolator mInterpolator;
    Animation.AnimationListener mListener;
    private Handler mListenerHandler;
    private boolean mMore;
    private Runnable mOnEnd;
    private Runnable mOnStart;
    private boolean mOneMoreTime;
    RectF mPreviousRegion;
    GLTransformation mPreviousTransformation;
    RectF mRegion;
    int mRepeatCount;
    int mRepeatMode;
    int mRepeated;
    private float mScaleFactor;
    long mStartOffset;
    long mStartTime;
    boolean mStarted;
    private int mZAdjustment;

    private void fireAnimationRepeat() {
    }

    public void applyTransformation(float r100, GLTransformation r101) {
    }

    public boolean hasAlpha() {
        return false;
    }

    public boolean willChangeBounds() {
        return true;
    }

    public boolean willChangeTransformationMatrix() {
        return true;
    }

    private void fireAnimationEnd() {
        Animation.AnimationListener r100 = this.mListener;
        if (r100 == null) goto L9;
        Handler r101 = this.mListenerHandler;
        if (r101 != null) goto L7;
        r100.onAnimationEnd();
        return;
    L7:
        r101.postAtFrontOfQueue(this.mOnEnd);
        return;
    }

    private void fireAnimationStart() {
        Animation.AnimationListener r100 = this.mListener;
        if (r100 == null) goto L9;
        Handler r101 = this.mListenerHandler;
        if (r101 != null) goto L7;
        r100.onAnimationStart();
        return;
    L7:
        r101.postAtFrontOfQueue(this.mOnStart);
        return;
    }

    public void cancel() {
        if (this.mStarted == true) goto L5;
    L7:
        this.mStartTime = Long.MIN_VALUE;
        this.mOneMoreTime = false;
        this.mMore = false;
        return;
    L5:
        if (this.mEnded == true) goto L7;
        fireAnimationEnd();
        this.mEnded = true;
        goto L7
    }

    public void detach() {
        if (this.mStarted == true) goto L5;
        return;
    L5:
        if (this.mEnded == true) goto L9;
        this.mEnded = true;
        fireAnimationEnd();
        return;
    }

    public void ensureInterpolator() {
        if (this.mInterpolator != null) goto L6;
        this.mInterpolator = new AccelerateDecelerateInterpolator();
        return;
    }

    public void reset() {
        this.mPreviousRegion.setEmpty();
        this.mPreviousTransformation.clear();
        this.mInitialized = false;
        this.mCycleFlip = false;
        this.mRepeated = 0;
        this.mMore = true;
        this.mOneMoreTime = true;
        this.mListenerHandler = null;
    }

    public void start() {
        setStartTime(-1);
    }

    public GLAnimation() {
        this.mEnded = false;
        this.mStarted = false;
        this.mCycleFlip = false;
        this.mInitialized = false;
        this.mFillBefore = true;
        this.mFillAfter = false;
        this.mFillEnabled = false;
        this.mStartTime = -1;
        this.mDuration = 500;
        this.mRepeatCount = 0;
        this.mRepeated = 0;
        this.mRepeatMode = 1;
        this.mScaleFactor = 1.0f;
        this.mDetachWallpaper = false;
        this.mMore = true;
        this.mOneMoreTime = true;
        this.mPreviousRegion = new RectF();
        this.mRegion = new RectF();
        this.mPreviousTransformation = new GLTransformation();
        ensureInterpolator();     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        th.printStackTrace();
    }

    public GLAnimation clone() throws CloneNotSupportedException {
        GLAnimation r100 = (GLAnimation) super.clone();
        r100.mPreviousRegion = new RectF();
        r100.mRegion = new RectF();
        r100.mPreviousTransformation = new GLTransformation();
        return r100;
    }

    public long computeDurationHint() {
        return (getStartOffset() + getDuration()) * ((long) (getRepeatCount() + 1));
    }

    public void initialize() {
        reset();
        this.mInitialized = true;
    }

    public void startNow() {
        setStartTime(AnimationUtils.currentAnimationTimeMillis());
    }

    public int getBackgroundColor() {
        return this.mBackgroundColor;
    }

    public boolean getDetachWallpaper() {
        return this.mDetachWallpaper;
    }

    public long getDuration() {
        return this.mDuration;
    }

    public boolean getFillAfter() {
        return this.mFillAfter;
    }

    public boolean getFillBefore() {
        return this.mFillBefore;
    }

    public Interpolator getInterpolator() {
        return this.mInterpolator;
    }

    public int getRepeatCount() {
        return this.mRepeatCount;
    }

    public int getRepeatMode() {
        return this.mRepeatMode;
    }

    public float getScaleFactor() {
        return this.mScaleFactor;
    }

    public long getStartOffset() {
        return this.mStartOffset;
    }

    public long getStartTime() {
        return this.mStartTime;
    }

    public int getZAdjustment() {
        return this.mZAdjustment;
    }

    public boolean hasEnded() {
        return this.mEnded;
    }

    public boolean hasStarted() {
        return this.mStarted;
    }

    public boolean isFillEnabled() {
        return this.mFillEnabled;
    }

    public boolean isInitialized() {
        return this.mInitialized;
    }

    /* JADX INFO: renamed from: clone, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object mo8139clone() throws CloneNotSupportedException {
        return clone();
    }

    public void restrictDuration(long r100) {
        long r101 = this.mStartOffset;
        if (r101 <= r100) goto L6;
        this.mStartOffset = r100;
        this.mDuration = 0;
        this.mRepeatCount = 0;
        return;
    L6:
        long r102 = this.mDuration + r101;
        if (r102 <= r100) goto L10;
        this.mDuration = r100 - r101;
        r102 = r100;
    L10:
        if (this.mDuration > 0) goto L13;
        this.mDuration = 0;
        this.mRepeatCount = 0;
        return;
    L13:
        int r103 = this.mRepeatCount;
        if (r103 < 0) goto L19;
        long r104 = r103;
        if (r104 > r100) goto L19;
        if ((r104 * r102) > r100) goto L19;
        return;
    L19:
        int r110 = ((int) (r100 / r102)) - 1;
        this.mRepeatCount = r110;
        if (r110 >= 0) goto L24;
        this.mRepeatCount = 0;
        return;
    }

    public void scaleCurrentDuration(float r100) {
        this.mDuration = (long) (this.mDuration * r100);
        this.mStartOffset = (long) (this.mStartOffset * r100);
    }

    public void setAnimationListener(Animation.AnimationListener r100) {
        this.mListener = r100;
    }

    public void setBackgroundColor(int r100) {
        this.mBackgroundColor = r100;
    }

    public void setDetachWallpaper(boolean r100) {
        this.mDetachWallpaper = r100;
    }

    public void setDuration(long r100) {
        if (r100 >= 0) goto L5;
        r100 = 0;
    L5:
        this.mDuration = r100;
    }

    public void setFillAfter(boolean r100) {
        this.mFillAfter = r100;
    }

    public void setFillBefore(boolean r100) {
        this.mFillBefore = r100;
    }

    public void setFillEnabled(boolean r100) {
        this.mFillEnabled = r100;
    }

    public void setInterpolator(Interpolator r100) {
        this.mInterpolator = r100;
    }

    public void setRepeatCount(int r100) {
        if (r100 >= 0) goto L4;
        r100 = -1;
    L4:
        this.mRepeatCount = r100;
    }

    public void setRepeatMode(int r100) {
        this.mRepeatMode = r100;
    }

    public void setStartOffset(long r100) {
        this.mStartOffset = r100;
    }

    public void setStartTime(long r100) {
        this.mStartTime = r100;
        this.mEnded = false;
        this.mStarted = false;
        this.mCycleFlip = false;
        this.mRepeated = 0;
        this.mMore = true;
    }

    public void setZAdjustment(int r100) {
        this.mZAdjustment = r100;
    }

    public boolean getTransformation(long r110, GLTransformation r111) {
        if (this.mStartTime != (-1)) goto L5;
        this.mStartTime = r110;
    L5:
        long r100 = getStartOffset();
        long r101 = this.mDuration;
        if (r101 == 0) goto L9;
        float r112 = (r110 - (this.mStartTime + r100)) / r101;
    L13:
        if (r112 < 1.0f) goto L15;
        boolean r102 = true;
    L16:
        this.mMore = !r102;
        if (this.mFillEnabled == true) goto L20;
        r112 = Math.max(Math.min(r112, 1.0f), 0.0f);
    L20:
        if (r112 >= 0.0f) goto L24;
        if (this.mFillBefore == true) goto L24;
    L28:
        boolean r103 = false;
    L30:
        if (r103 == true) goto L32;
    L45:
        if (r102 == false) goto L57;
        int r113 = this.mRepeatCount;
        int r114 = this.mRepeated;
        if (r113 == r114) goto L49;
        if (r113 <= 0) goto L54;
        this.mRepeated = r114 + 1;
    L54:
        if (this.mRepeatMode != 2) goto L56;
        this.mCycleFlip = !this.mCycleFlip;
    L56:
        this.mStartTime = -1;
        this.mMore = true;
        fireAnimationRepeat();
        goto L57
    L49:
        if (this.mEnded == true) goto L57;
        this.mEnded = true;
        fireAnimationEnd();
    L57:
        boolean r115 = this.mMore;
        if (r115 == false) goto L60;
    L63:
        return r115;
    L60:
        if (this.mOneMoreTime == false) goto L63;
        this.mOneMoreTime = false;
        return true;
    L32:
        if (this.mStarted == true) goto L39;
        fireAnimationStart();     // Catch: Throwable -> L35
    L37:
        this.mStarted = true;
    L35:
        th = move-exception;
        th.printStackTrace();
    L39:
        if (this.mFillEnabled == false) goto L42;
        r112 = Math.max(Math.min(r112, 1.0f), 0.0f);
    L42:
        if (this.mCycleFlip == false) goto L44;
        r112 = 1.0f - r112;
    L44:
        applyTransformation(this.mInterpolator.getInterpolation(r112), r111);
    L24:
        if (r112 > 1.0f) goto L26;
    L29:
        r103 = true;
        goto L30
    L26:
        if (this.mFillAfter == false) goto L28;
    L15:
        r102 = false;
        goto L16
    L9:
        if (r110 >= this.mStartTime) goto L11;
        r112 = 0.0f;
        goto L13
    L11:
        r112 = 1.0f;
        goto L13
    }

    public void setInterpolator(Context r100, int r101) {
        setInterpolator(AnimationUtils.loadInterpolator(r100, r101));
    }

    public boolean getTransformation(long r100, GLTransformation r101, float r102) {
        this.mScaleFactor = r102;
        return getTransformation(r100, r101);
    }
}
