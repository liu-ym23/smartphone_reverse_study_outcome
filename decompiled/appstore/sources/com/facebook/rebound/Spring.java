package com.facebook.rebound;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: loaded from: classes2.dex */
public class Spring {
    private static int ID = 0;
    private static final double MAX_DELTA_TIME_SEC = 0.064d;
    private static final double SOLVER_TIMESTEP_SEC = 0.001d;
    private final PhysicsState mCurrentState;
    private double mDisplacementFromRestThreshold;
    private double mEndValue;
    private final String mId;
    private CopyOnWriteArraySet<SpringListener> mListeners;
    private boolean mOvershootClampingEnabled;
    private final PhysicsState mPreviousState;
    private double mRestSpeedThreshold;
    private SpringConfig mSpringConfig;
    private final BaseSpringSystem mSpringSystem;
    private double mStartValue;
    private final PhysicsState mTempState;
    private double mTimeAccumulator;
    private boolean mWasAtRest;

    /* JADX INFO: renamed from: com.facebook.rebound.Spring$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class PhysicsState {
        double position;
        double velocity;

        private PhysicsState() {
        }

        public /* synthetic */ PhysicsState(AnonymousClass1 r10) {
            this();
        }
    }

    static {
    }

    public Spring(BaseSpringSystem r10) {
        AnonymousClass1 r11 = null;
        this.mCurrentState = new PhysicsState(r11);
        this.mPreviousState = new PhysicsState(r11);
        this.mTempState = new PhysicsState(r11);
        this.mWasAtRest = true;
        this.mRestSpeedThreshold = 0.005d;
        this.mDisplacementFromRestThreshold = 0.005d;
        this.mListeners = new CopyOnWriteArraySet();
        this.mTimeAccumulator = 0.0d;
        if (r10 == null) goto L7;
        this.mSpringSystem = r10;
        StringBuilder r12 = new StringBuilder();
        r12.append("spring:");
        int r13 = ID;
        ID = r13 + 1;
        r12.append(r13);
        this.mId = r12.toString();
        setSpringConfig(SpringConfig.defaultConfig);
        return;
    L7:
        throw new IllegalArgumentException("Spring cannot be created outside of a BaseSpringSystem");
    }

    private double getDisplacementDistanceForState(PhysicsState r10) {
        return Math.abs(this.mEndValue - r10.position);
    }

    private void interpolate(double r10) {
        PhysicsState r11 = this.mCurrentState;
        double r12 = r11.position * r10;
        PhysicsState r13 = this.mPreviousState;
        double r14 = 1.0d - r10;
        r11.position = r12 + (r13.position * r14);
        r11.velocity = (r11.velocity * r10) + (r13.velocity * r14);
    }

    public Spring addListener(SpringListener r10) {
        if (r10 == null) goto L6;
        this.mListeners.add(r10);
        return this;
    L6:
        throw new IllegalArgumentException("newListener is required");
    }

    public void advance(double r31) {
        boolean r10 = isAtRest();
        if (r10 == true) goto L5;
    L7:
        double r11 = MAX_DELTA_TIME_SEC;
        if (r31 > MAX_DELTA_TIME_SEC) goto L11;
        r11 = r31;
    L11:
        this.mTimeAccumulator += r11;
        SpringConfig r12 = this.mSpringConfig;
        double r13 = r12.tension;
        double r14 = r12.friction;
        PhysicsState r15 = this.mCurrentState;
        double r16 = r15.position;
        double r17 = r15.velocity;
        PhysicsState r18 = this.mTempState;
        double r19 = r18.position;
        double r110 = r18.velocity;
    L12:
        double r20 = this.mTimeAccumulator;
        if (r20 < SOLVER_TIMESTEP_SEC) goto L18;
        double r21 = r20 - SOLVER_TIMESTEP_SEC;
        this.mTimeAccumulator = r21;
        if (r21 >= SOLVER_TIMESTEP_SEC) goto L17;
        PhysicsState r22 = this.mPreviousState;
        r22.position = r16;
        r22.velocity = r17;
    L17:
        double r23 = this.mEndValue;
        double r111 = ((r23 - r19) * r13) - (r14 * r17);
        double r112 = ((r17 * SOLVER_TIMESTEP_SEC) * 0.5d) + r16;
        double r24 = r17 + ((r111 * SOLVER_TIMESTEP_SEC) * 0.5d);
        double r113 = ((r23 - r112) * r13) - (r14 * r24);
        double r25 = r16 + ((r24 * SOLVER_TIMESTEP_SEC) * 0.5d);
        double r26 = r17 + ((r113 * SOLVER_TIMESTEP_SEC) * 0.5d);
        double r114 = ((r23 - r25) * r13) - (r14 * r26);
        double r27 = r16 + (r26 * SOLVER_TIMESTEP_SEC);
        double r28 = r17 + (r114 * SOLVER_TIMESTEP_SEC);
        r16 = r16 + ((((r17 + ((r24 + r26) * 2.0d)) + r28) * 0.16666666666666666d) * SOLVER_TIMESTEP_SEC);
        r17 = r17 + ((((r111 + ((r113 + r114) * 2.0d)) + (((r23 - r27) * r13) - (r14 * r28))) * 0.16666666666666666d) * SOLVER_TIMESTEP_SEC);
        r19 = r27;
        r110 = r28;
        goto L12
    L18:
        PhysicsState r29 = this.mTempState;
        r29.position = r19;
        r29.velocity = r110;
        PhysicsState r30 = this.mCurrentState;
        r30.position = r16;
        r30.velocity = r17;
        if (r20 <= 0.0d) goto L21;
        interpolate(r20 / SOLVER_TIMESTEP_SEC);
    L21:
        boolean r32 = true;
        if (isAtRest() == true) goto L30;
        if (this.mOvershootClampingEnabled == true) goto L26;
    L28:
        boolean r33 = r10;
    L35:
        if (this.mWasAtRest == false) goto L37;
        this.mWasAtRest = false;
        boolean r34 = true;
    L38:
        if (r33 == false) goto L40;
        this.mWasAtRest = true;
    L41:
        Iterator<SpringListener> r35 = this.mListeners.iterator();
    L43:
        if (r35.hasNext() == false) goto L50;
        SpringListener r36 = r35.next();
        if (r34 == false) goto L47;
        r36.onSpringActivate(this);
    L47:
        r36.onSpringUpdate(this);
        if (r32 == false) goto L43;
        r36.onSpringAtRest(this);
        goto L43
    L50:
        return;
    L40:
        r32 = false;
        goto L41
    L37:
        r34 = false;
        goto L38
    L26:
        if (isOvershooting() == false) goto L28;
    L30:
        if (r13 <= 0.0d) goto L32;
        double r37 = this.mEndValue;
        this.mStartValue = r37;
        this.mCurrentState.position = r37;
    L33:
        setVelocity(0.0d);
        r33 = true;
        goto L35
    L32:
        double r38 = this.mCurrentState.position;
        this.mEndValue = r38;
        this.mStartValue = r38;
        goto L33
    L5:
        if (this.mWasAtRest == false) goto L7;
    }

    public boolean currentValueIsApproximately(double r10) {
        if (Math.abs(getCurrentValue() - r10) > getRestDisplacementThreshold()) goto L5;
        return true;
    L5:
        return false;
    }

    public void destroy() {
        this.mListeners.clear();
        this.mSpringSystem.deregisterSpring(this);
    }

    public double getCurrentDisplacementDistance() {
        return getDisplacementDistanceForState(this.mCurrentState);
    }

    public double getCurrentValue() {
        return this.mCurrentState.position;
    }

    public double getEndValue() {
        return this.mEndValue;
    }

    public String getId() {
        return this.mId;
    }

    public double getRestDisplacementThreshold() {
        return this.mDisplacementFromRestThreshold;
    }

    public double getRestSpeedThreshold() {
        return this.mRestSpeedThreshold;
    }

    public SpringConfig getSpringConfig() {
        return this.mSpringConfig;
    }

    public double getStartValue() {
        return this.mStartValue;
    }

    public double getVelocity() {
        return this.mCurrentState.velocity;
    }

    public boolean isAtRest() {
        if (Math.abs(this.mCurrentState.velocity) <= this.mRestSpeedThreshold) goto L5;
    L9:
        return false;
    L5:
        if (getDisplacementDistanceForState(this.mCurrentState) > this.mDisplacementFromRestThreshold) goto L7;
    L8:
        return true;
    L7:
        if (this.mSpringConfig.tension != 0.0d) goto L9;
        goto L8
    }

    public boolean isOvershootClampingEnabled() {
        return this.mOvershootClampingEnabled;
    }

    public boolean isOvershooting() {
        if (this.mSpringConfig.tension > 0.0d) goto L5;
    L13:
        return false;
    L5:
        if (this.mStartValue >= this.mEndValue) goto L9;
        if (getCurrentValue() <= this.mEndValue) goto L9;
    L12:
        return true;
    L9:
        if (this.mStartValue <= this.mEndValue) goto L13;
        if (getCurrentValue() >= this.mEndValue) goto L13;
        goto L12
    }

    public Spring removeAllListeners() {
        this.mListeners.clear();
        return this;
    }

    public Spring removeListener(SpringListener r10) {
        if (r10 == null) goto L6;
        this.mListeners.remove(r10);
        return this;
    L6:
        throw new IllegalArgumentException("listenerToRemove is required");
    }

    public Spring setAtRest() {
        PhysicsState r10 = this.mCurrentState;
        double r11 = r10.position;
        this.mEndValue = r11;
        this.mTempState.position = r11;
        r10.velocity = 0.0d;
        return this;
    }

    public Spring setCurrentValue(double r10) {
        return setCurrentValue(r10, true);
    }

    public Spring setEndValue(double r10) {
        if (this.mEndValue == r10) goto L5;
    L7:
        this.mStartValue = getCurrentValue();
        this.mEndValue = r10;
        this.mSpringSystem.activateSpring(getId());
        Iterator<SpringListener> r11 = this.mListeners.iterator();
    L9:
        if (r11.hasNext() == false) goto L11;
        r11.next().onSpringEndStateChange(this);
        goto L9
    L11:
        return this;
    L5:
        if (isAtRest() == false) goto L7;
        return this;
    }

    public Spring setOvershootClampingEnabled(boolean r10) {
        this.mOvershootClampingEnabled = r10;
        return this;
    }

    public Spring setRestDisplacementThreshold(double r10) {
        this.mDisplacementFromRestThreshold = r10;
        return this;
    }

    public Spring setRestSpeedThreshold(double r10) {
        this.mRestSpeedThreshold = r10;
        return this;
    }

    public Spring setSpringConfig(SpringConfig r10) {
        if (r10 == null) goto L6;
        this.mSpringConfig = r10;
        return this;
    L6:
        throw new IllegalArgumentException("springConfig is required");
    }

    public Spring setVelocity(double r10) {
        PhysicsState r11 = this.mCurrentState;
        if (r10 != r11.velocity) goto L5;
        return this;
    L5:
        r11.velocity = r10;
        this.mSpringSystem.activateSpring(getId());
        return this;
    }

    public boolean systemShouldAdvance() {
        if (isAtRest() == true) goto L5;
    L8:
        return true;
    L5:
        if (wasAtRest() == false) goto L8;
        return false;
    }

    public boolean wasAtRest() {
        return this.mWasAtRest;
    }

    public Spring setCurrentValue(double r10, boolean r11) {
        this.mStartValue = r10;
        this.mCurrentState.position = r10;
        this.mSpringSystem.activateSpring(getId());
        Iterator<SpringListener> r12 = this.mListeners.iterator();
    L4:
        if (r12.hasNext() == false) goto L6;
        r12.next().onSpringUpdate(this);
        goto L4
    L6:
        if (r11 == false) goto L8;
        setAtRest();
    L8:
        return this;
    }
}
