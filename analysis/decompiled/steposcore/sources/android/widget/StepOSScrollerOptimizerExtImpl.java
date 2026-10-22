package android.widget;

import android.content.Context;
import android.provider.Settings;
import android.util.Log;
import android.widget.IStepOSScrollerOptimizerExt;

/* loaded from: classes.dex */
public class StepOSScrollerOptimizerExtImpl implements IStepOSScrollerOptimizerExt {
    private static final float DEFAULT_BALLISTIC_STIFFNESS = 102.0f;
    private static final float DEFAULT_CUBIC_STIFFNESS = 163.0f;
    private static final float DEFAULT_FRICTION = -4.2f;
    private static final float MIN_VISIBLE_CHANGE_PIXELS = 1.0f;
    private static final float THRESHOLD_MULTIPLIER = 0.75f;
    private static final float VELOCITY_THRESHOLD_MULTIPLIER = 62.5f;
    private float mBallisticStiffness;
    private Context mContext;
    private float mCubicStiffness;
    private boolean mEnableVerboseLog;
    private int mMaxOverVelocity;
    private boolean mUseOptimizer;
    private float mVelocityThreshold;
    private boolean mVertical;
    private float mMinVisibleChange = 1.0f;
    private float mFriction = DEFAULT_FRICTION;
    private double mNaturalFreq = Math.sqrt(102.0d);

    public void onAttach(Context context, boolean vertical) {
        this.mContext = context;
        this.mVertical = vertical;
        setValueThreshold(getValueThreshold());
        this.mUseOptimizer = Settings.Global.getInt(context.getContentResolver(), "over_scroller_optimizer_enable", 1) == 1;
        this.mEnableVerboseLog = Settings.Global.getInt(context.getContentResolver(), "over_scroller_verbose_enable", 0) == 1;
        setMinimumVisibleChange(Settings.Global.getFloat(context.getContentResolver(), "over_scroller_min_change", 0.5f));
        this.mBallisticStiffness = Settings.Global.getFloat(context.getContentResolver(), "over_scroller_ballistic_stiffness", DEFAULT_BALLISTIC_STIFFNESS);
        this.mCubicStiffness = Settings.Global.getFloat(context.getContentResolver(), "over_scroller_cubic_stiffness", DEFAULT_CUBIC_STIFFNESS);
        this.mMaxOverVelocity = Settings.Global.getInt(this.mContext.getContentResolver(), "over_scroller_max_velocity", 7000);
        if (this.mEnableVerboseLog) {
            debug("StepOSScrollerOptimizerExtImpl, mFriction= " + this.mFriction + ", mMinVisibleChange = " + this.mMinVisibleChange + ", mVelocityThreshold = " + this.mVelocityThreshold);
        }
    }

    public boolean useOptimizer() {
        return this.mUseOptimizer;
    }

    public float getValueThreshold() {
        return this.mMinVisibleChange * THRESHOLD_MULTIPLIER;
    }

    public void setMinimumVisibleChange(float minimumVisibleChange) {
        this.mMinVisibleChange = minimumVisibleChange;
        setValueThreshold(THRESHOLD_MULTIPLIER * minimumVisibleChange);
    }

    public void updateFriction(int velocity) {
        float scalar;
        if (velocity < 1500) {
            scalar = 15.0f;
        } else {
            scalar = 2.0f;
        }
        if (this.mEnableVerboseLog) {
            debug("updateFriction, velocity=" + velocity + ", scalar=" + scalar);
        }
        float multiplier = Settings.Global.getFloat(this.mContext.getContentResolver(), "over_scroller_friction_multiplier", 1.0f);
        setFriction((scalar * multiplier) / Math.abs(DEFAULT_FRICTION));
        if (this.mEnableVerboseLog) {
            debug("updateFriction, velocity=" + velocity + ", scalar=" + scalar + ", mFriction = " + this.mFriction);
        }
    }

    public void setFriction(float frictionScalar) {
        this.mFriction = DEFAULT_FRICTION * frictionScalar;
    }

    public void setValueThreshold(float threshold) {
        this.mVelocityThreshold = VELOCITY_THRESHOLD_MULTIPLIER * threshold;
    }

    public float getCurrentDistance(int velocity, long time) {
        return (getCurrVelocity(velocity, time) / this.mFriction) - (velocity / this.mFriction);
    }

    public float getCurrVelocity(int velocity, long time) {
        return (float) (velocity * Math.exp((time / 1000.0f) * this.mFriction));
    }

    public float getCurrentDistanceInTimeNanos(int velocity, long time) {
        return (getCurrVelocityInTimeNanos(velocity, time) / this.mFriction) - (velocity / this.mFriction);
    }

    public float getCurrVelocityInTimeNanos(int velocity, long time) {
        return (float) (velocity * Math.exp((time / 1.0E9f) * this.mFriction));
    }

    public double getSplineFlingDistance(int velocity) {
        return (this.mVelocityThreshold / this.mFriction) - (Math.abs(velocity) / this.mFriction);
    }

    public int getSplineFlingDuration(int fromVelocity) {
        return getSplineFlingDuration(Math.abs(fromVelocity), this.mVelocityThreshold);
    }

    public int getSplineFlingDuration(float fromVelocity, float toVelocity) {
        return (int) ((Math.log(toVelocity / fromVelocity) * 1000.0d) / this.mFriction);
    }

    public int adjustDuration(int velocity, int start, int oldFinal, int newFinal) {
        int velocity2 = Math.abs(velocity);
        int newDistance = Math.abs(newFinal - start);
        float atEdgeVelocity = (newDistance * this.mFriction) + velocity2;
        return getSplineFlingDuration(velocity2, atEdgeVelocity);
    }

    public long getSplineFlingDurationInNanos(int fromVelocity) {
        return getSplineFlingDurationInNanos(Math.abs(fromVelocity), this.mVelocityThreshold);
    }

    public long getSplineFlingDurationInNanos(float fromVelocity, float toVelocity) {
        return (long) ((Math.log(toVelocity / fromVelocity) * 1.0E9d) / this.mFriction);
    }

    public long adjustDurationInNanos(int velocity, int start, int oldFinal, int newFinal) {
        int velocity2 = Math.abs(velocity);
        int newDistance = Math.abs(newFinal - start);
        float atEdgeVelocity = (newDistance * this.mFriction) + velocity2;
        return getSplineFlingDurationInNanos(velocity2, atEdgeVelocity);
    }

    public int getMaxOverVelocity() {
        return this.mMaxOverVelocity;
    }

    public void setStiffness(float stiffness) {
        if (stiffness <= 0.0f) {
            throw new IllegalArgumentException("Spring stiffness constant must be positive.");
        }
        this.mNaturalFreq = Math.sqrt(stiffness);
    }

    public void setNaturalFreq(double naturalFreq) {
        this.mNaturalFreq = naturalFreq;
    }

    public IStepOSScrollerOptimizerExt.MassState updateBallisticValue(double lastDisplacement, double lastVelocity, double timeElapsed, double finalPosition) {
        double deltaT = timeElapsed / 1000.0d;
        double lastDisplacement2 = lastDisplacement - finalPosition;
        double coeffB = lastVelocity + (this.mNaturalFreq * lastDisplacement2);
        double displacement = ((coeffB * deltaT) + lastDisplacement2) * Math.pow(2.718281828459045d, (-this.mNaturalFreq) * deltaT);
        double currentVelocity = (((coeffB * deltaT) + lastDisplacement2) * Math.pow(2.718281828459045d, (-this.mNaturalFreq) * deltaT) * (-this.mNaturalFreq)) + (Math.pow(2.718281828459045d, (-this.mNaturalFreq) * deltaT) * coeffB);
        return new IStepOSScrollerOptimizerExt.MassState((float) (displacement + finalPosition), (float) currentVelocity);
    }

    public double getNaturalFreqByDistance(double distance, double velocity) {
        return Math.abs(velocity) / (2.718281828459045d * distance);
    }

    public void resetBallisticNaturalFreq() {
        setStiffness(this.mBallisticStiffness);
    }

    public void resetCubicNaturalFreq() {
        setStiffness(this.mCubicStiffness);
    }

    public double getBallisticDuration() {
        return 1000.0d / this.mNaturalFreq;
    }

    public double getCubicDuration(double lastDisplacement, double lastVelocity, double finalPosition) {
        double lastDisplacement2 = lastDisplacement - finalPosition;
        double coeffB = lastVelocity + (this.mNaturalFreq * lastDisplacement2);
        return Math.max(Math.log((Math.abs(lastDisplacement2) * 2.0d) / this.mMinVisibleChange) / this.mNaturalFreq, (Math.log((Math.abs(coeffB) * 4.0d) / ((this.mNaturalFreq * 2.718281828459045d) * this.mMinVisibleChange)) * 2.0d) / this.mNaturalFreq) * 1000.0d;
    }

    public void debug(String message) {
        if (this.mVertical) {
            Log.d("OverScroller-Y", message);
        } else {
            Log.d("OverScroller-X", message);
        }
    }

    public void verbose(String message) {
        if (!this.mEnableVerboseLog) {
            return;
        }
        if (this.mVertical) {
            Log.v("OverScroller-Y", message);
        } else {
            Log.v("OverScroller-X", message);
        }
    }

    public void setOptimizeEnabled(boolean enabled) {
        this.mUseOptimizer = enabled;
    }

    public void onAttach(Object obj) {
    }
}
