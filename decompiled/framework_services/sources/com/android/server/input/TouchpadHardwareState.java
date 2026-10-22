package com.android.server.input;

import android.annotation.NonNull;
import com.android.internal.util.AnnotationValidations;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public final class TouchpadHardwareState {
    private final int mButtonsDown;
    private final int mFingerCount;
    private final TouchpadFingerState[] mFingerStates;
    private final float mTimestamp;
    private final int mTouchCount;

    public TouchpadHardwareState(float timestamp, int buttonsDown, int fingerCount, int touchCount, TouchpadFingerState[] fingerStates) {
        this.mTimestamp = timestamp;
        this.mButtonsDown = buttonsDown;
        this.mFingerCount = fingerCount;
        this.mTouchCount = touchCount;
        this.mFingerStates = fingerStates;
        AnnotationValidations.validate(NonNull.class, null, this.mFingerStates);
    }

    public float getTimestamp() {
        return this.mTimestamp;
    }

    public int getButtonsDown() {
        return this.mButtonsDown;
    }

    public int getFingerCount() {
        return this.mFingerCount;
    }

    public int getTouchCount() {
        return this.mTouchCount;
    }

    public TouchpadFingerState[] getFingerStates() {
        return this.mFingerStates;
    }

    public String toString() {
        return "TouchpadHardwareState { timestamp = " + this.mTimestamp + ", buttonsDown = " + this.mButtonsDown + ", fingerCount = " + this.mFingerCount + ", touchCount = " + this.mTouchCount + ", fingerStates = " + Arrays.toString(this.mFingerStates) + " }";
    }

    @Deprecated
    private void __metadata() {
    }
}
