package com.stepos.alphame.movingstate;

import B0.g;

/* loaded from: classes.dex */
public class MovingState {
    public static final int ACCURACY_LEVEL_HIGH = 2;
    public static final int ACCURACY_LEVEL_INACCURATE = 0;
    public static final int ACCURACY_LEVEL_LOW = 1;
    public static final int STATE_RUN = 4;
    public static final int STATE_SLOWLY_WALK = 2;
    public static final int STATE_STILL = 1;
    public static final int STATE_UNKNOWN = 0;
    public static final int STATE_WALK = 3;
    public final int accuracyLevel;
    public final int duration;
    public final int eventDensity;
    public final int speed;
    public final int state;
    public final int stepCount;

    public MovingState(int i4, int i5, int i6, int i7, int i8) {
        this.state = i4;
        this.stepCount = i5;
        this.duration = i6;
        this.speed = i7;
        this.eventDensity = i8;
        this.accuracyLevel = i8 >= 60 ? 2 : i8 >= 15 ? 1 : 0;
    }

    public static MovingState staticStatic() {
        return new MovingState(1, 0, 0, 0, 0);
    }

    public static MovingState unknownState() {
        return new MovingState(0, 0, 0, 0, 0);
    }

    public int[] toIntArray() {
        return new int[]{this.state, this.speed, this.duration, this.accuracyLevel};
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("MovingState{state=");
        sb.append(this.state);
        sb.append(", stepCount=");
        sb.append(this.stepCount);
        sb.append(", duration=");
        sb.append(this.duration);
        sb.append(", speed=");
        sb.append(this.speed);
        sb.append(", eventDensity=");
        sb.append(this.eventDensity);
        sb.append(", accuracyLevel=");
        return g.o(sb, this.accuracyLevel, '}');
    }
}
