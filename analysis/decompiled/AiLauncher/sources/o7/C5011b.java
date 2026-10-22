package o7;

import android.animation.ValueAnimator;
import android.annotation.NonNull;
import android.annotation.Nullable;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.BlendMode;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import com.android.internal.R;
import com.stepos.ailauncher.chat.view.M8;

/* renamed from: o7.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C5011b {
    private static final double DAMPING_RATIO = 0.98d;
    private static final float EPSILON = 0.001f;
    private static final float EXP_STRETCH_INTENSITY = 0.016f;
    private static final float GLOW_ALPHA_START = 0.09f;
    private static final double LINEAR_DISTANCE_TAKE_OVER = 8.0d;
    private static final float LINEAR_STRETCH_INTENSITY = 0.016f;
    private static final float LINEAR_VELOCITY_TAKE_OVER = 200.0f;
    private static final float MAX_ALPHA = 0.15f;
    private static final float MAX_GLOW_SCALE = 2.0f;
    private static final int MAX_VELOCITY = 10000;
    private static final int MIN_VELOCITY = 100;
    private static final double NATURAL_FREQUENCY = 24.657d;
    private static final float ON_ABSORB_VELOCITY_ADJUSTMENT = 13.0f;
    private static final int PULL_DECAY_TIME = 2000;
    private static final float PULL_DISTANCE_ALPHA_GLOW_FACTOR = 0.8f;
    private static final float PULL_GLOW_BEGIN = 0.0f;
    private static final int PULL_TIME = 167;
    private static final float RADIUS_FACTOR = 0.6f;
    private static final int RECEDE_TIME = 600;
    private static final float SCROLL_DIST_AFFECTED_BY_EXP_STRETCH = 0.33f;
    private static final int STATE_ABSORB = 2;
    private static final int STATE_IDLE = 0;
    private static final int STATE_PULL = 1;
    private static final int STATE_PULL_DECAY = 4;
    private static final int STATE_RECEDE = 3;
    private static final String TAG = "EdgeEffect";
    private static final int TYPE_GLOW = 0;
    private static final int TYPE_NONE = -1;
    private static final int TYPE_STRETCH = 1;
    public static final long USE_STRETCH_EDGE_EFFECT_BY_DEFAULT = 171228096;
    private static final double VALUE_THRESHOLD = 0.001d;
    private static final int VELOCITY_GLOW_FACTOR = 6;
    private static final double VELOCITY_THRESHOLD = 0.01d;
    private float mBaseGlowScale;
    private final Rect mBounds;
    private float mDisplacement;
    private float mDistance;
    private float mDuration;
    private int mEdgeEffectType;
    private float mGlowAlpha;
    private float mGlowAlphaFinish;
    private float mGlowAlphaStart;
    private float mGlowScaleY;
    private float mGlowScaleYFinish;
    private float mGlowScaleYStart;
    private float mHeight;
    private final Interpolator mInterpolator;
    private final Paint mPaint;
    private float mPullDistance;
    private float mRadius;
    private long mStartTime;
    private int mState;
    private float mTargetDisplacement;
    private Matrix mTmpMatrix;
    private float[] mTmpPoints;
    private float mVelocity;
    private float mWidth;
    public static final BlendMode DEFAULT_BLEND_MODE = BlendMode.SRC_ATOP;
    private static final double ANGLE = 0.5235987755982988d;
    private static final float SIN = (float) Math.sin(ANGLE);
    private static final float COS = (float) Math.cos(ANGLE);

    public C5011b(Context context) {
        this(context, null);
    }

    private float calculateDistanceFromGlowValues(float f10, float f11) {
        float fHeight;
        if (f10 >= 1.0f) {
            return 1.0f;
        }
        if (f10 > 0.0f) {
            float f12 = 1.4285715f / (this.mGlowScaleY - 1.0f);
            f11 = f12 * f12;
            fHeight = this.mBounds.height();
        } else {
            fHeight = 0.8f;
        }
        return f11 / fHeight;
    }

    private float dampStretchVector(float f10) {
        float f11 = f10 > 0.0f ? 1.0f : -1.0f;
        float fAbs = Math.abs(f10);
        return f11 * ((float) ((0.016f * fAbs) + ((1.0d - Math.exp((-fAbs) * 8.237217334679498d)) * 0.01600000075995922d)));
    }

    private int getCurrentEdgeEffectBehavior() {
        if (ValueAnimator.areAnimatorsEnabled()) {
            return this.mEdgeEffectType;
        }
        return -1;
    }

    private boolean isAtEquilibrium() {
        double d10 = this.mDistance * this.mHeight;
        double d11 = this.mVelocity;
        if (d10 >= 0.0d) {
            return Math.abs(d11) < 0.01d && d10 < VALUE_THRESHOLD;
        }
        return true;
    }

    private float max(float f10, float f11, float f12, float f13) {
        return Math.max(Math.max(Math.max(f10, f11), f12), f13);
    }

    private float min(float f10, float f11, float f12, float f13) {
        return Math.min(Math.min(Math.min(f10, f11), f12), f13);
    }

    private void update() {
        float fMin = Math.min((AnimationUtils.currentAnimationTimeMillis() - this.mStartTime) / this.mDuration, 1.0f);
        float interpolation = this.mInterpolator.getInterpolation(fMin);
        float f10 = this.mGlowAlphaStart;
        float f11 = f10 + ((this.mGlowAlphaFinish - f10) * interpolation);
        this.mGlowAlpha = f11;
        float f12 = this.mGlowScaleYStart;
        float f13 = f12 + ((this.mGlowScaleYFinish - f12) * interpolation);
        this.mGlowScaleY = f13;
        if (this.mState != 1) {
            this.mDistance = calculateDistanceFromGlowValues(f13, f11);
        }
        this.mDisplacement = (this.mDisplacement + this.mTargetDisplacement) / 2.0f;
        if (fMin >= 0.999f) {
            int i10 = this.mState;
            if (i10 == 1) {
                this.mState = 4;
                this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
                this.mDuration = 2000.0f;
                this.mGlowAlphaStart = this.mGlowAlpha;
                this.mGlowScaleYStart = this.mGlowScaleY;
                this.mGlowAlphaFinish = 0.0f;
                this.mGlowScaleYFinish = 0.0f;
                return;
            }
            if (i10 != 2) {
                if (i10 == 3) {
                    this.mState = 0;
                    return;
                } else {
                    if (i10 != 4) {
                        return;
                    }
                    this.mState = 3;
                    return;
                }
            }
            this.mState = 3;
            this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
            this.mDuration = 600.0f;
            this.mGlowAlphaStart = this.mGlowAlpha;
            this.mGlowScaleYStart = this.mGlowScaleY;
            this.mGlowAlphaFinish = 0.0f;
            this.mGlowScaleYFinish = 0.0f;
        }
    }

    private void updateSpring() {
        float f10;
        long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        float f11 = (jCurrentAnimationTimeMillis - this.mStartTime) / 1000.0f;
        if (f11 < 0.001f) {
            return;
        }
        this.mStartTime = jCurrentAnimationTimeMillis;
        if (Math.abs(this.mVelocity) <= LINEAR_VELOCITY_TAKE_OVER && Math.abs(this.mDistance * this.mHeight) < LINEAR_DISTANCE_TAKE_OVER && Math.signum(this.mVelocity) == (-Math.signum(this.mDistance))) {
            float fSignum = Math.signum(this.mVelocity) * LINEAR_VELOCITY_TAKE_OVER;
            this.mVelocity = fSignum;
            float f12 = this.mDistance + ((fSignum * f11) / this.mHeight);
            if (Math.signum(f12) == Math.signum(this.mDistance)) {
                this.mDistance = f12;
                return;
            } else {
                this.mDistance = 0.0f;
                this.mVelocity = 0.0f;
                return;
            }
        }
        double dSqrt = Math.sqrt(getSpringStiffness());
        double springDampingRatio = getSpringDampingRatio();
        double dSqrt2 = Math.sqrt(1.0d - (springDampingRatio * springDampingRatio)) * dSqrt;
        float f13 = this.mDistance;
        float f14 = this.mHeight;
        double d10 = f13 * f14;
        double d11 = (1.0d / dSqrt2) * ((springDampingRatio * dSqrt * f13 * f14) + this.mVelocity);
        double d12 = f11;
        double d13 = (-springDampingRatio) * dSqrt * d12;
        double d14 = d12 * dSqrt2;
        double dPow = Math.pow(2.718281828459045d, d13) * ((Math.cos(d14) * d10) + (Math.sin(d14) * d11));
        double dPow2 = (Math.pow(2.718281828459045d, d13) * (((-dSqrt2) * d10 * Math.sin(d14)) + (dSqrt2 * d11 * Math.cos(d14)))) + ((-dSqrt) * dPow * springDampingRatio);
        float f15 = ((float) dPow) / this.mHeight;
        this.mDistance = f15;
        this.mVelocity = (float) dPow2;
        if (f15 > 1.0f) {
            this.mDistance = 1.0f;
            f10 = 0.0f;
            this.mVelocity = 0.0f;
        } else {
            f10 = 0.0f;
        }
        if (isAtEquilibrium()) {
            this.mDistance = f10;
            this.mVelocity = f10;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x01a1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean draw(android.graphics.Canvas r22) {
        /*
            Method dump skipped, instructions count: 427
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: o7.C5011b.draw(android.graphics.Canvas):boolean");
    }

    public void finish() {
        this.mState = 0;
        this.mDistance = 0.0f;
        this.mVelocity = 0.0f;
    }

    @Nullable
    public BlendMode getBlendMode() {
        return this.mPaint.getBlendMode();
    }

    public int getColor() {
        return this.mPaint.getColor();
    }

    public float getDistance() {
        return this.mDistance;
    }

    public int getMaxHeight() {
        return (int) this.mHeight;
    }

    public double getSpringDampingRatio() {
        return DAMPING_RATIO;
    }

    public double getSpringStiffness() {
        return 607.967649d;
    }

    public boolean isFinished() {
        return this.mState == 0;
    }

    public void onAbsorb(int i10) {
        int currentEdgeEffectBehavior = getCurrentEdgeEffectBehavior();
        if (currentEdgeEffectBehavior == 1) {
            this.mState = 3;
            this.mVelocity = i10 * 13.0f;
            this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
        } else {
            if (currentEdgeEffectBehavior != 0) {
                finish();
                return;
            }
            this.mState = 2;
            this.mVelocity = 0.0f;
            int iMin = Math.min(Math.max(100, Math.abs(i10)), 10000);
            this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
            this.mDuration = (iMin * 0.02f) + 0.15f;
            this.mGlowAlphaStart = GLOW_ALPHA_START;
            this.mGlowScaleYStart = Math.max(this.mGlowScaleY, 0.0f);
            this.mGlowScaleYFinish = Math.min(((((iMin / 100) * iMin) * 1.5E-4f) / 2.0f) + 0.025f, 1.0f);
            this.mGlowAlphaFinish = Math.max(this.mGlowAlphaStart, Math.min(iMin * 6 * 1.0E-5f, 0.15f));
            this.mTargetDisplacement = 0.5f;
        }
    }

    public void onPull(float f10) {
        onPull(f10, 0.5f);
    }

    public float onPullDistance(float f10, float f11) {
        int currentEdgeEffectBehavior = getCurrentEdgeEffectBehavior();
        if (currentEdgeEffectBehavior == -1) {
            return 0.0f;
        }
        float fMax = Math.max(0.0f, f10 + this.mDistance);
        float f12 = this.mDistance;
        float f13 = fMax - f12;
        if (f13 == 0.0f && f12 == 0.0f) {
            return 0.0f;
        }
        int i10 = this.mState;
        if (i10 != 1 && i10 != 4 && currentEdgeEffectBehavior == 0) {
            this.mPullDistance = f12;
            this.mState = 1;
        }
        onPull(f13, f11);
        return f13;
    }

    public void onRelease() {
        this.mPullDistance = 0.0f;
        int i10 = this.mState;
        if (i10 == 1 || i10 == 4) {
            this.mState = 3;
            this.mGlowAlphaStart = this.mGlowAlpha;
            this.mGlowScaleYStart = this.mGlowScaleY;
            this.mGlowAlphaFinish = 0.0f;
            this.mGlowScaleYFinish = 0.0f;
            this.mVelocity = 0.0f;
            this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
            this.mDuration = 600.0f;
        }
    }

    public void setBlendMode(@Nullable BlendMode blendMode) {
        this.mPaint.setBlendMode(blendMode);
    }

    public void setColor(int i10) {
        this.mPaint.setColor(i10);
    }

    public void setSize(int i10, int i11) {
        float f10 = i10;
        float f11 = SIN;
        float f12 = (f10 * 0.6f) / f11;
        float f13 = COS;
        float f14 = f12 - (f13 * f12);
        float f15 = i11;
        float f16 = (0.6f * f15) / f11;
        float f17 = f16 - (f13 * f16);
        this.mRadius = f12;
        this.mBaseGlowScale = f14 > 0.0f ? Math.min(f17 / f14, 1.0f) : 1.0f;
        Rect rect = this.mBounds;
        rect.set(rect.left, rect.top, i10, (int) Math.min(f15, f14));
        this.mWidth = f10;
        this.mHeight = f15;
    }

    public C5011b(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this.mInterpolator = new DecelerateInterpolator();
        this.mState = 0;
        this.mBounds = new Rect();
        Paint paint = new Paint();
        this.mPaint = paint;
        this.mDisplacement = 0.5f;
        this.mTargetDisplacement = 0.5f;
        this.mEdgeEffectType = 0;
        this.mTmpMatrix = null;
        this.mTmpPoints = null;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.EdgeEffect);
        int color = typedArrayObtainStyledAttributes.getColor(0, -10066330);
        this.mEdgeEffectType = 1;
        typedArrayObtainStyledAttributes.recycle();
        paint.setAntiAlias(true);
        paint.setColor((16777215 & color) | M8.SCRIM_COLOR);
        paint.setStyle(Paint.Style.FILL);
        paint.setBlendMode(DEFAULT_BLEND_MODE);
    }

    public void onPull(float f10, float f11) {
        int currentEdgeEffectBehavior = getCurrentEdgeEffectBehavior();
        if (currentEdgeEffectBehavior == -1) {
            finish();
            return;
        }
        long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        this.mTargetDisplacement = f11;
        int i10 = this.mState;
        if (i10 == 4 && jCurrentAnimationTimeMillis - this.mStartTime < this.mDuration && currentEdgeEffectBehavior == 0) {
            return;
        }
        if (i10 != 1) {
            if (currentEdgeEffectBehavior == 1) {
                this.mPullDistance = this.mDistance;
            } else {
                this.mGlowScaleY = Math.max(0.0f, this.mGlowScaleY);
            }
        }
        this.mState = 1;
        this.mStartTime = jCurrentAnimationTimeMillis;
        this.mDuration = 167.0f;
        float f12 = this.mPullDistance + f10;
        this.mPullDistance = f12;
        if (currentEdgeEffectBehavior == 1) {
            this.mPullDistance = Math.min(1.0f, f12);
        }
        this.mDistance = Math.max(0.0f, this.mPullDistance);
        this.mVelocity = 0.0f;
        if (this.mPullDistance == 0.0f) {
            this.mGlowScaleYStart = 0.0f;
            this.mGlowScaleY = 0.0f;
            this.mGlowAlphaStart = 0.0f;
            this.mGlowAlpha = 0.0f;
        } else {
            float fMin = Math.min(0.15f, this.mGlowAlpha + (Math.abs(f10) * 0.8f));
            this.mGlowAlphaStart = fMin;
            this.mGlowAlpha = fMin;
            float fMax = (float) (Math.max(0.0d, (1.0d - (1.0d / Math.sqrt(Math.abs(this.mPullDistance) * this.mBounds.height()))) - 0.3d) / 0.7d);
            this.mGlowScaleYStart = fMax;
            this.mGlowScaleY = fMax;
        }
        this.mGlowAlphaFinish = this.mGlowAlpha;
        this.mGlowScaleYFinish = this.mGlowScaleY;
        if (currentEdgeEffectBehavior == 1 && this.mDistance == 0.0f) {
            this.mState = 0;
        }
    }
}
