package com.bytedance.android.livesdk.performance.config;

import com.bytedance.android.livesdkapi.performance.IPerformanceStrategyManager;
import com.bytedance.sdk.account.platform.base.OnekeyLoginConstants;
import com.google.gson.annotations.SerializedName;
import com.ss.texturerender.TextureRenderKeys;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes11.dex */
public class LivePerformanceStrategyConfig {

    @SerializedName("enable")
    public boolean mEnable;

    @SerializedName("lintEnable")
    public boolean mLintEnable;

    @SerializedName("performance_degrade_list")
    public List<a> mPerformanceDegradeList;

    @SerializedName("performance_enhance_list")
    public List<a> mPerformanceEnhanceList;

    @SerializedName("power_degrade_list")
    public List<b> mPowerDegradeList;

    @SerializedName("power_enhance_list")
    public List<b> mPowerEnhanceList;

    @SerializedName("recover_duration")
    public long mRecoverDuration;

    public static class a {

        @SerializedName("duration")
        public long mDuration;

        @SerializedName(OnekeyLoginConstants.CU_KEY_OPERATOR)
        public int mOperator;

        @SerializedName("performance_level")
        public int mPerformanceLevel;

        @SerializedName(IPerformanceStrategyManager.KEY_FLOAT_TEMPERATURE)
        public double mTemperature;

        @SerializedName(IPerformanceStrategyManager.KEY_DOUBLE_UI_STALL_RATE)
        public double mUiStallRate;

        public a() {
        }

        public a(int r100, double r101, double r102) {
            this.mDuration = 30000;
            this.mOperator = 1;
            this.mPerformanceLevel = r100;
            this.mTemperature = r101;
            this.mUiStallRate = r102;
        }
    }

    public static class b {

        @SerializedName(OnekeyLoginConstants.CU_KEY_OPERATOR)
        public int mOperator;

        @SerializedName("performance_level")
        public int mPerformanceLevel;

        @SerializedName("power_in_charge")
        public boolean mPowerInCharge;

        @SerializedName(TextureRenderKeys.KEY_IS_POWER_LEVEL)
        public int mPowerLevel;

        public b() {
        }

        public b(int r100, int r101, boolean r102, int r103) {
            this.mOperator = r100;
            this.mPerformanceLevel = r101;
            this.mPowerInCharge = r102;
            this.mPowerLevel = r103;
        }
    }

    public LivePerformanceStrategyConfig() {
        this.mEnable = true;
        this.mLintEnable = false;
        this.mPerformanceDegradeList = new ArrayList();
        this.mPerformanceEnhanceList = new ArrayList();
        this.mPowerDegradeList = new ArrayList();
        this.mPowerEnhanceList = new ArrayList();
        this.mRecoverDuration = com.heytap.mcssdk.constant.a.f276323j;
        this.mPerformanceDegradeList.add(new a(1, 40.0d, 0.4d));
        this.mPerformanceDegradeList.add(new a(2, 42.0d, 0.44d));
        this.mPerformanceDegradeList.add(new a(3, 43.0d, 0.53d));
        this.mPerformanceDegradeList.add(new a(4, 44.0d, 0.68d));
        this.mPowerDegradeList.add(new b(0, 11, false, 20));
        this.mPowerEnhanceList.add(new b(1, 16, true, 90));
    }

    public boolean getEnable() {
        return this.mEnable;
    }

    public boolean getLintEnable() {
        return this.mLintEnable;
    }

    public List<a> getPerformanceDegradeList() {
        return this.mPerformanceDegradeList;
    }

    public List<a> getPerformanceEnhanceList() {
        return this.mPerformanceEnhanceList;
    }

    public List<b> getPowerDegradeList() {
        return this.mPowerDegradeList;
    }

    public List<b> getPowerEnhanceList() {
        return this.mPowerEnhanceList;
    }

    public long getRecoverDuration() {
        return this.mRecoverDuration;
    }

    public void setEnable(boolean r100) {
        this.mEnable = r100;
    }

    public void setLintEnable(boolean r100) {
        this.mLintEnable = r100;
    }

    public void setPerformanceDegradeList(List<a> r100) {
        this.mPerformanceDegradeList = r100;
    }

    public void setPerformanceEnhanceList(List<a> r100) {
        this.mPerformanceEnhanceList = r100;
    }

    public void setPowerDegradeList(List<b> r100) {
        this.mPowerDegradeList = r100;
    }

    public void setPowerEnhanceList(List<b> r100) {
        this.mPowerEnhanceList = r100;
    }

    public void setRecoverDuration(long r100) {
        this.mRecoverDuration = r100;
    }
}
