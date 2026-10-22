package com.android.server.vibrator;

import android.os.SystemClock;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
abstract class Step implements Comparable<Step> {
    public final VibrationStepConductor conductor;
    public final long startTime;

    public abstract List<Step> cancel();

    public abstract void cancelImmediately();

    public abstract List<Step> play();

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(Step r1) {
        return compareTo2(r1);
    }

    Step(VibrationStepConductor conductor, long startTime) {
        this.conductor = conductor;
        this.startTime = startTime;
    }

    protected HalVibration getVibration() {
        return this.conductor.getVibration();
    }

    public boolean isCleanUp() {
        return false;
    }

    public long getVibratorOnDuration() {
        return 0;
    }

    public boolean acceptVibratorCompleteCallback(int vibratorId) {
        return false;
    }

    public long calculateWaitTime() {
        if (this.startTime != Long.MAX_VALUE) goto L6;
        return 0;
    L6:
        return Math.max(0, this.startTime - SystemClock.uptimeMillis());
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(Step o) {
        return Long.compare(this.startTime, o.startTime);
    }
}
