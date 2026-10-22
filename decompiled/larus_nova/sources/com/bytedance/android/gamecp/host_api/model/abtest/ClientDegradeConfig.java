package com.bytedance.android.gamecp.host_api.model.abtest;

import com.bytedance.android.livesdkapi.performance.IPerformanceStrategyManager;
import com.bytedance.sdk.account.platform.base.OnekeyLoginConstants;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001:\u0001$B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001e\u0010\f\u001a\u00020\r8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0012\u001a\u00020\r8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011R\u001e\u0010\u0015\u001a\u00020\r8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000f\"\u0004\b\u0017\u0010\u0011R\u001e\u0010\u0018\u001a\u00020\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001e\u0010\u001e\u001a\u00020\u001f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#¨\u0006%"}, d2 = {"Lcom/bytedance/android/gamecp/host_api/model/abtest/ClientDegradeConfig;", "", "()V", "degradeLevel1", "Lcom/bytedance/android/gamecp/host_api/model/abtest/ClientDegradeConfig$DegradeLevel;", "getDegradeLevel1", "()Lcom/bytedance/android/gamecp/host_api/model/abtest/ClientDegradeConfig$DegradeLevel;", "setDegradeLevel1", "(Lcom/bytedance/android/gamecp/host_api/model/abtest/ClientDegradeConfig$DegradeLevel;)V", "degradeLevel2", "getDegradeLevel2", "setDegradeLevel2", "enableClient", "", "getEnableClient", "()Z", "setEnableClient", "(Z)V", "enableLowPower", "getEnableLowPower", "setEnableLowPower", "enablePerformance", "getEnablePerformance", "setEnablePerformance", "lowBatteryLevel", "", "getLowBatteryLevel", "()I", "setLowBatteryLevel", "(I)V", "recoverDuration", "", "getRecoverDuration", "()J", "setRecoverDuration", "(J)V", "DegradeLevel", "gamecp-host-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ClientDegradeConfig {

    @SerializedName("degradeLev1")
    private DegradeLevel degradeLevel1;

    @SerializedName("degradeLev2")
    private DegradeLevel degradeLevel2;

    @SerializedName("enableClient")
    private boolean enableClient;

    @SerializedName("enableLowPower")
    private boolean enableLowPower;

    @SerializedName("enablePerformance")
    private boolean enablePerformance;

    @SerializedName("lowBatteryLevel")
    private int lowBatteryLevel;

    @SerializedName("recoverDuration")
    private long recoverDuration;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000b\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0015\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\f\"\u0004\b\u0017\u0010\u000eR\u001e\u0010\u0018\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\f\"\u0004\b\u001a\u0010\u000e¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/gamecp/host_api/model/abtest/ClientDegradeConfig$DegradeLevel;", "", "()V", "duration", "", "getDuration", "()J", "setDuration", "(J)V", "fps", "", "getFps", "()F", "setFps", "(F)V", OnekeyLoginConstants.CU_KEY_OPERATOR, "", "getOperator", "()I", "setOperator", "(I)V", IPerformanceStrategyManager.KEY_FLOAT_TEMPERATURE, "getTemperature", "setTemperature", "uiStallRate", "getUiStallRate", "setUiStallRate", "gamecp-host-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class DegradeLevel {

        @SerializedName("duration")
        private long duration;

        @SerializedName("fps")
        private float fps;

        @SerializedName(OnekeyLoginConstants.CU_KEY_OPERATOR)
        private int operator;

        @SerializedName(IPerformanceStrategyManager.KEY_FLOAT_TEMPERATURE)
        private float temperature;

        @SerializedName("uiStallRate")
        private float uiStallRate;

        public DegradeLevel() {
            this.duration = 60000;
            this.uiStallRate = 0.6f;
            this.fps = 36.0f;
            this.temperature = 45.0f;
        }

        public final long getDuration() {
            return this.duration;
        }

        public final float getFps() {
            return this.fps;
        }

        public final int getOperator() {
            return this.operator;
        }

        public final float getTemperature() {
            return this.temperature;
        }

        public final float getUiStallRate() {
            return this.uiStallRate;
        }

        public final void setDuration(long r100) {
            this.duration = r100;
        }

        public final void setFps(float r100) {
            this.fps = r100;
        }

        public final void setOperator(int r100) {
            this.operator = r100;
        }

        public final void setTemperature(float r100) {
            this.temperature = r100;
        }

        public final void setUiStallRate(float r100) {
            this.uiStallRate = r100;
        }
    }

    public ClientDegradeConfig() {
        this.lowBatteryLevel = 30;
        this.recoverDuration = 60000;
    }

    public final DegradeLevel getDegradeLevel1() {
        return this.degradeLevel1;
    }

    public final DegradeLevel getDegradeLevel2() {
        return this.degradeLevel2;
    }

    public final boolean getEnableClient() {
        return this.enableClient;
    }

    public final boolean getEnableLowPower() {
        return this.enableLowPower;
    }

    public final boolean getEnablePerformance() {
        return this.enablePerformance;
    }

    public final int getLowBatteryLevel() {
        return this.lowBatteryLevel;
    }

    public final long getRecoverDuration() {
        return this.recoverDuration;
    }

    public final void setDegradeLevel1(DegradeLevel r100) {
        this.degradeLevel1 = r100;
    }

    public final void setDegradeLevel2(DegradeLevel r100) {
        this.degradeLevel2 = r100;
    }

    public final void setEnableClient(boolean r100) {
        this.enableClient = r100;
    }

    public final void setEnableLowPower(boolean r100) {
        this.enableLowPower = r100;
    }

    public final void setEnablePerformance(boolean r100) {
        this.enablePerformance = r100;
    }

    public final void setLowBatteryLevel(int r100) {
        this.lowBatteryLevel = r100;
    }

    public final void setRecoverDuration(long r100) {
        this.recoverDuration = r100;
    }
}
