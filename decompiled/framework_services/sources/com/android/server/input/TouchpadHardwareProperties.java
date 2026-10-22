package com.android.server.input;

import com.android.server.storage.DeviceStorageMonitorServiceSmtEx;

/* JADX INFO: loaded from: classes2.dex */
public class TouchpadHardwareProperties {
    private float mBottom;
    private boolean mIsButtonPad;
    private boolean mIsHapticPad;
    private float mLeft;
    private short mMaxFingerCount;
    private float mOrientationMaximum;
    private float mOrientationMinimum;
    private boolean mReportsPressure;
    private float mResX;
    private float mResY;
    private float mRight;
    private float mTop;

    public static class Builder {
        private float mBottom;
        private long mBuilderFieldsSet;
        private boolean mIsButtonPad;
        private boolean mIsHapticPad;
        private float mLeft;
        private short mMaxFingerCount;
        private float mOrientationMaximum;
        private float mOrientationMinimum;
        private boolean mReportsPressure;
        private float mResX;
        private float mResY;
        private float mRight;
        private float mTop;

        public Builder(float left, float top, float right, float bottom, float resX, float resY, float orientationMinimum, float orientationMaximum, short maxFingerCount, boolean isButtonPad, boolean isHapticPad) {
            this.mBuilderFieldsSet = 0;
            this.mLeft = left;
            this.mTop = top;
            this.mRight = right;
            this.mBottom = bottom;
            this.mResX = resX;
            this.mResY = resY;
            this.mOrientationMinimum = orientationMinimum;
            this.mOrientationMaximum = orientationMaximum;
            this.mMaxFingerCount = maxFingerCount;
            this.mIsButtonPad = isButtonPad;
            this.mIsHapticPad = isHapticPad;
        }

        public Builder setLeft(float value) {
            checkNotUsed();
            this.mBuilderFieldsSet |= 1;
            this.mLeft = value;
            return this;
        }

        public Builder setTop(float value) {
            checkNotUsed();
            this.mBuilderFieldsSet |= 2;
            this.mTop = value;
            return this;
        }

        public Builder setRight(float value) {
            checkNotUsed();
            this.mBuilderFieldsSet |= 4;
            this.mRight = value;
            return this;
        }

        public Builder setBottom(float value) {
            checkNotUsed();
            this.mBuilderFieldsSet |= 8;
            this.mBottom = value;
            return this;
        }

        public Builder setResX(float value) {
            checkNotUsed();
            this.mBuilderFieldsSet |= 16;
            this.mResX = value;
            return this;
        }

        public Builder setResY(float value) {
            checkNotUsed();
            this.mBuilderFieldsSet |= 32;
            this.mResY = value;
            return this;
        }

        public Builder setOrientationMinimum(float value) {
            checkNotUsed();
            this.mBuilderFieldsSet |= 64;
            this.mOrientationMinimum = value;
            return this;
        }

        public Builder setOrientationMaximum(float value) {
            checkNotUsed();
            this.mBuilderFieldsSet |= 128;
            this.mOrientationMaximum = value;
            return this;
        }

        public Builder setMaxFingerCount(short value) {
            checkNotUsed();
            this.mBuilderFieldsSet |= 256;
            this.mMaxFingerCount = value;
            return this;
        }

        public Builder setIsButtonPad(boolean value) {
            checkNotUsed();
            this.mBuilderFieldsSet |= 512;
            this.mIsButtonPad = value;
            return this;
        }

        public Builder setIsHapticPad(boolean value) {
            checkNotUsed();
            this.mBuilderFieldsSet |= DeviceStorageMonitorServiceSmtEx.TrafficStats.KB_IN_BYTES;
            this.mIsHapticPad = value;
            return this;
        }

        public Builder setReportsPressure(boolean value) {
            checkNotUsed();
            this.mBuilderFieldsSet |= 2048;
            this.mReportsPressure = value;
            return this;
        }

        public TouchpadHardwareProperties build() {
            checkNotUsed();
            this.mBuilderFieldsSet |= 4096;
            if ((this.mBuilderFieldsSet & 2048) != 0) goto L5;
            this.mReportsPressure = true;
        L5:
            TouchpadHardwareProperties o = new TouchpadHardwareProperties(this.mLeft, this.mTop, this.mRight, this.mBottom, this.mResX, this.mResY, this.mOrientationMinimum, this.mOrientationMaximum, this.mMaxFingerCount, this.mIsButtonPad, this.mIsHapticPad, this.mReportsPressure);
            return o;
        }

        private void checkNotUsed() {
            if ((this.mBuilderFieldsSet & 4096) != 0) goto L6;
            return;
        L6:
            throw new IllegalStateException("This Builder should not be reused. Use a new Builder instance instead");
        }
    }

    public String toString() {
        return "HardwareProperties{left=" + this.mLeft + ", top=" + this.mTop + ", right=" + this.mRight + ", bottom=" + this.mBottom + ", resX=" + this.mResX + ", resY=" + this.mResY + ", orientationMinimum=" + this.mOrientationMinimum + ", orientationMaximum=" + this.mOrientationMaximum + ", maxFingerCount=" + this.mMaxFingerCount + ", isButtonPad=" + this.mIsButtonPad + ", isHapticPad=" + this.mIsHapticPad + ", reportsPressure=" + this.mReportsPressure + '}';
    }

    TouchpadHardwareProperties(float left, float top, float right, float bottom, float resX, float resY, float orientationMinimum, float orientationMaximum, short maxFingerCount, boolean isButtonPad, boolean isHapticPad, boolean reportsPressure) {
        this.mReportsPressure = true;
        this.mLeft = left;
        this.mTop = top;
        this.mRight = right;
        this.mBottom = bottom;
        this.mResX = resX;
        this.mResY = resY;
        this.mOrientationMinimum = orientationMinimum;
        this.mOrientationMaximum = orientationMaximum;
        this.mMaxFingerCount = maxFingerCount;
        this.mIsButtonPad = isButtonPad;
        this.mIsHapticPad = isHapticPad;
        this.mReportsPressure = reportsPressure;
    }

    public float getLeft() {
        return this.mLeft;
    }

    public float getTop() {
        return this.mTop;
    }

    public float getRight() {
        return this.mRight;
    }

    public float getBottom() {
        return this.mBottom;
    }

    public float getResX() {
        return this.mResX;
    }

    public float getResY() {
        return this.mResY;
    }

    public float getOrientationMinimum() {
        return this.mOrientationMinimum;
    }

    public float getOrientationMaximum() {
        return this.mOrientationMaximum;
    }

    public short getMaxFingerCount() {
        return this.mMaxFingerCount;
    }

    public boolean isIsButtonPad() {
        return this.mIsButtonPad;
    }

    public boolean isIsHapticPad() {
        return this.mIsHapticPad;
    }

    public boolean isReportsPressure() {
        return this.mReportsPressure;
    }

    @Deprecated
    private void __metadata() {
    }
}
