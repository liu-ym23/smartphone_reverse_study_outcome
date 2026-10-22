package com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config;

import com.bytedance.speech.speechengine.SpeechEngineDefines;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0006\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001e\u0010\f\u001a\u00020\r8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/com/bytedance/android/livesdk/config/TimeConsumingFuncOpt;", "", "()V", "asyncToolbarAnimLog", "", "getAsyncToolbarAnimLog", "()Z", "setAsyncToolbarAnimLog", "(Z)V", "enableSample", "getEnableSample", "setEnableSample", "sampleRate", "", "getSampleRate", "()D", "setSampleRate", "(D)V", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class TimeConsumingFuncOpt {

    @SerializedName("async_toolbar_anim_log")
    private boolean asyncToolbarAnimLog;

    @SerializedName("enable_sample")
    private boolean enableSample;

    @SerializedName(SpeechEngineDefines.PARAMS_KEY_SAMPLE_RATE_INT)
    private double sampleRate;

    public TimeConsumingFuncOpt() {
        this.sampleRate = 0.1d;
    }

    public final boolean getAsyncToolbarAnimLog() {
        return this.asyncToolbarAnimLog;
    }

    public final boolean getEnableSample() {
        return this.enableSample;
    }

    public final double getSampleRate() {
        return this.sampleRate;
    }

    public final void setAsyncToolbarAnimLog(boolean r100) {
        this.asyncToolbarAnimLog = r100;
    }

    public final void setEnableSample(boolean r100) {
        this.enableSample = r100;
    }

    public final void setSampleRate(double r100) {
        this.sampleRate = r100;
    }
}
