package android.hardware.display;

/* loaded from: classes.dex */
public class StepOSDisplayInfo {
    public static final float REFRESH_RATE_UNKNOWN = -1.0f;
    private final float mAmbientLux;
    private final boolean mIsAod;
    private final boolean mIsHbmActive;
    private final float mRefreshRateHz;
    private final float mScreenAutoBrightness;
    private final boolean mUseAutoBrightness;

    public StepOSDisplayInfo(float ambientLux, float screenAutoBrightness, boolean useAutoBrightness, boolean isHbmActive, boolean isAod, float refreshRateHz) {
        this.mAmbientLux = ambientLux;
        this.mScreenAutoBrightness = screenAutoBrightness;
        this.mUseAutoBrightness = useAutoBrightness;
        this.mIsHbmActive = isHbmActive;
        this.mIsAod = isAod;
        this.mRefreshRateHz = refreshRateHz;
    }

    public float getAmbientLux() {
        return this.mAmbientLux;
    }

    public float getScreenAutoBrightness() {
        return this.mScreenAutoBrightness;
    }

    public boolean isUseAutoBrightness() {
        return this.mUseAutoBrightness;
    }

    public boolean isHbmActive() {
        return this.mIsHbmActive;
    }

    public boolean isAod() {
        return this.mIsAod;
    }

    public float getRefreshRateHz() {
        return this.mRefreshRateHz;
    }

    public String toString() {
        return "StepOSDisplayInfo{ambientLux=" + this.mAmbientLux + ", screenAutoBrightness=" + this.mScreenAutoBrightness + ", useAutoBrightness=" + this.mUseAutoBrightness + ", isHbmActive=" + this.mIsHbmActive + ", isAod=" + this.mIsAod + ", refreshRateHz=" + this.mRefreshRateHz + "}";
    }
}
