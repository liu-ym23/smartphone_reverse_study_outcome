package com.autonavi.base.ae.gmap.glanimation;

/* JADX INFO: loaded from: classes39.dex */
public abstract class AbstractAdglAnimation {
    public static final int DEFAULT_DURATION = 250;
    public static final int INTERPOLATOR_ACCELERATE = 1;
    public static final int INTERPOLATOR_ACCELERATE_DECELERATE = 3;
    public static final int INTERPOLATOR_BOUNCE = 4;
    public static final int INTERPOLATOR_DECELERATE = 2;
    public static final int INTERPOLATOR_DOUBLE_RAISE = 6;
    public static final int INTERPOLATOR_LINEAR = 0;
    public static final int INTERPOLATOR_OVERSHOOT = 5;
    public static final int INVALIDE_VALUE = -9999;
    protected int duration;
    protected boolean isOver;
    protected long offsetTime;
    protected long startTime;

    public void applyFinalState(Object r100) {
    }

    public abstract void doAnimation(Object r100);

    public boolean isValid() {
        return true;
    }

    public AbstractAdglAnimation() {
        this.duration = 300;
        this.isOver = false;
        this.startTime = -1;
        this.offsetTime = 0;
    }

    public boolean isOver() {
        return this.isOver;
    }
}
