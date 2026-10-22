package com.android.server.common;

import android.view.SurfaceControl;

/* JADX INFO: loaded from: classes.dex */
public interface IGameScreenSaver {

    public static class DozeScreenBrightness {
        public int mReason;
        public float mScreenBrightnessFloat;
        public int mScreenBrightnessInt;
        public int mScreenState;
        public boolean mUseNormalBrightnessForDoze;

        public DozeScreenBrightness() {
            this.mScreenState = 0;
            this.mReason = 0;
            this.mScreenBrightnessFloat = Float.NaN;
            this.mScreenBrightnessInt = -1;
            this.mUseNormalBrightnessForDoze = false;
        }

        public void set(int screenState, int reason, float screenBrightnessFloat, int screenBrightnessInt, boolean useNormalBrightnessForDoze) {
            this.mScreenState = screenState;
            this.mReason = reason;
            this.mScreenBrightnessFloat = screenBrightnessFloat;
            this.mScreenBrightnessInt = screenBrightnessInt;
            this.mUseNormalBrightnessForDoze = useNormalBrightnessForDoze;
        }

        public String toString() {
            return "DozeScreenBrightness{mScreenState=" + this.mScreenState + ", mReason=" + this.mReason + ", mScreenBrightnessFloat=" + this.mScreenBrightnessFloat + ", mScreenBrightnessInt=" + this.mScreenBrightnessInt + ", mUseNormalBrightnessForDoze=" + this.mUseNormalBrightnessForDoze + '}';
        }
    }

    @FunctionalInterface
    public interface KeyguardShade {
        SurfaceControl get();
    }

    @FunctionalInterface
    public interface SetDozeBrightness {
        void setBrightness(int r1, int r2, float r3, int r4, boolean r5);

        default void setBrightness(DozeScreenBrightness brightness) {
            setBrightness(brightness.mScreenState, brightness.mReason, brightness.mScreenBrightnessFloat, brightness.mScreenBrightnessInt, brightness.mUseNormalBrightnessForDoze);
        }
    }

    boolean interceptDozeOverrideScreenBrightness(int r1, int r2, float r3, int r4, boolean r5);

    void setAccelerometerData(float[] r1);

    void setDozeBrightnessFunction(SetDozeBrightness r1);

    void setKeyguardShade(KeyguardShade r1);
}
