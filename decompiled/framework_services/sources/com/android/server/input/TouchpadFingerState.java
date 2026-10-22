package com.android.server.input;

/* JADX INFO: loaded from: classes2.dex */
public final class TouchpadFingerState {
    private final float mOrientation;
    private final float mPositionX;
    private final float mPositionY;
    private final float mPressure;
    private final float mTouchMajor;
    private final float mTouchMinor;
    private final int mTrackingId;
    private final float mWidthMajor;
    private final float mWidthMinor;

    public TouchpadFingerState(float touchMajor, float touchMinor, float widthMajor, float widthMinor, float pressure, float orientation, float positionX, float positionY, int trackingId) {
        this.mTouchMajor = touchMajor;
        this.mTouchMinor = touchMinor;
        this.mWidthMajor = widthMajor;
        this.mWidthMinor = widthMinor;
        this.mPressure = pressure;
        this.mOrientation = orientation;
        this.mPositionX = positionX;
        this.mPositionY = positionY;
        this.mTrackingId = trackingId;
    }

    public float getTouchMajor() {
        return this.mTouchMajor;
    }

    public float getTouchMinor() {
        return this.mTouchMinor;
    }

    public float getWidthMajor() {
        return this.mWidthMajor;
    }

    public float getWidthMinor() {
        return this.mWidthMinor;
    }

    public float getPressure() {
        return this.mPressure;
    }

    public float getOrientation() {
        return this.mOrientation;
    }

    public float getPositionX() {
        return this.mPositionX;
    }

    public float getPositionY() {
        return this.mPositionY;
    }

    public int getTrackingId() {
        return this.mTrackingId;
    }

    public String toString() {
        return "TouchpadFingerState { touchMajor = " + this.mTouchMajor + ", touchMinor = " + this.mTouchMinor + ", widthMajor = " + this.mWidthMajor + ", widthMinor = " + this.mWidthMinor + ", pressure = " + this.mPressure + ", orientation = " + this.mOrientation + ", positionX = " + this.mPositionX + ", positionY = " + this.mPositionY + ", trackingId = " + this.mTrackingId + " }";
    }

    @Deprecated
    private void __metadata() {
    }
}
