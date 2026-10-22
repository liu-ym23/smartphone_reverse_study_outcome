package com.bytedance.android.livesdkapi.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\u001a\n\u0002\u0010\u0006\n\u0002\b\u0017\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0015\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR\u001e\u0010\u0018\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\bR\u001e\u0010\u001b\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0006\"\u0004\b\u001d\u0010\bR\u001e\u0010\u001e\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0006\"\u0004\b \u0010\bR\u001e\u0010!\u001a\u00020\"8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001e\u0010'\u001a\u00020\"8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010$\"\u0004\b)\u0010&R\u001e\u0010*\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0012\"\u0004\b,\u0010\u0014R\u001e\u0010-\u001a\u00020\"8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010$\"\u0004\b/\u0010&R\u001e\u00100\u001a\u00020\"8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010$\"\u0004\b2\u0010&R\u001e\u00103\u001a\u00020\"8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010$\"\u0004\b5\u0010&R\u001e\u00106\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\u0006\"\u0004\b8\u0010\bR\u001e\u00109\u001a\u00020\"8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010$\"\u0004\b;\u0010&R\u001e\u0010<\u001a\u00020=8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR\u001e\u0010B\u001a\u00020\"8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010$\"\u0004\bD\u0010&R\u001e\u0010E\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u0010\u0006\"\u0004\bG\u0010\bR\u001e\u0010H\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010\f\"\u0004\bJ\u0010\u000eR\u001e\u0010K\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bL\u0010\u0006\"\u0004\bM\u0010\bR\u001e\u0010N\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bO\u0010\u0006\"\u0004\bP\u0010\bR\u001e\u0010Q\u001a\u00020\"8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bR\u0010$\"\u0004\bS\u0010&¨\u0006T"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/LiveGcControllerConfig;", "", "()V", "adjustJatoConfig", "", "getAdjustJatoConfig", "()Z", "setAdjustJatoConfig", "(Z)V", "checkForceGcPercent", "", "getCheckForceGcPercent", "()F", "setCheckForceGcPercent", "(F)V", "checkHeapLoopInterval", "", "getCheckHeapLoopInterval", "()J", "setCheckHeapLoopInterval", "(J)V", "debug", "getDebug", "setDebug", "disablePrevCall", "getDisablePrevCall", "setDisablePrevCall", "enable", "getEnable", "setEnable", "enableExitGcInhibit", "getEnableExitGcInhibit", "setEnableExitGcInhibit", "exitGcInhibitDuration", "", "getExitGcInhibitDuration", "()I", "setExitGcInhibitDuration", "(I)V", "exitGcInhibitStrategy", "getExitGcInhibitStrategy", "setExitGcInhibitStrategy", "forceGcInterval", "getForceGcInterval", "setForceGcInterval", "gcBlockerMode", "getGcBlockerMode", "setGcBlockerMode", "gcBlockerStrategy", "getGcBlockerStrategy", "setGcBlockerStrategy", "gcScrollStrategy", "getGcScrollStrategy", "setGcScrollStrategy", "jatoEnableMaxHeapSize", "getJatoEnableMaxHeapSize", "setJatoEnableMaxHeapSize", "jatoMaxHeapLimit", "getJatoMaxHeapLimit", "setJatoMaxHeapLimit", "jatoMaxHeapLimitPercent", "", "getJatoMaxHeapLimitPercent", "()D", "setJatoMaxHeapLimitPercent", "(D)V", "jatoMaxHeapLimitReset", "getJatoMaxHeapLimitReset", "setJatoMaxHeapLimitReset", "needGcAfterRelease", "getNeedGcAfterRelease", "setNeedGcAfterRelease", "newMaxHeapLimitPercent", "getNewMaxHeapLimitPercent", "setNewMaxHeapLimitPercent", "openCheckHeapLoop", "getOpenCheckHeapLoop", "setOpenCheckHeapLoop", "removeHeapSizeLimit", "getRemoveHeapSizeLimit", "setRemoveHeapSizeLimit", "requestGcBlockDuration", "getRequestGcBlockDuration", "setRequestGcBlockDuration", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class LiveGcControllerConfig {

    @SerializedName("adjust_jato_config")
    private boolean adjustJatoConfig;

    @SerializedName("check_force_gc_percent")
    private float checkForceGcPercent;

    @SerializedName("check_heap_loop_interval")
    private long checkHeapLoopInterval;

    @SerializedName("debug")
    private boolean debug;

    @SerializedName("disable_prev_call")
    private boolean disablePrevCall;

    @SerializedName("enable")
    private boolean enable;

    @SerializedName("enable_exit_gc_inhibit")
    private boolean enableExitGcInhibit;

    @SerializedName("exit_gc_inhibit_duration")
    private int exitGcInhibitDuration;

    @SerializedName("exit_gc_inhibit_strategy")
    private int exitGcInhibitStrategy;

    @SerializedName("force_gc_interval")
    private long forceGcInterval;

    @SerializedName("gc_blocker_mode")
    private int gcBlockerMode;

    @SerializedName("gc_blocker_strategy")
    private int gcBlockerStrategy;

    @SerializedName("gc_scroll_strategy")
    private int gcScrollStrategy;

    @SerializedName("jato_enable_max_heap_size")
    private boolean jatoEnableMaxHeapSize;

    @SerializedName("jato_max_heap_limit")
    private int jatoMaxHeapLimit;

    @SerializedName("jato_max_heap_limit_percent")
    private double jatoMaxHeapLimitPercent;

    @SerializedName("jato_max_heap_limit_reset")
    private int jatoMaxHeapLimitReset;

    @SerializedName("need_gc_after_release")
    private boolean needGcAfterRelease;

    @SerializedName("new_max_heap_limit_percent")
    private float newMaxHeapLimitPercent;

    @SerializedName("open_check_heap_loop")
    private boolean openCheckHeapLoop;

    @SerializedName("jato_remove_heap_size_limit")
    private boolean removeHeapSizeLimit;

    @SerializedName("request_gc_block_duration")
    private int requestGcBlockDuration;

    public LiveGcControllerConfig() {
        this.requestGcBlockDuration = 3000;
        this.newMaxHeapLimitPercent = 0.8f;
        this.checkHeapLoopInterval = 1000;
        this.checkForceGcPercent = 0.7f;
        this.forceGcInterval = 20000;
        this.exitGcInhibitDuration = 2000;
    }

    public final boolean getAdjustJatoConfig() {
        return this.adjustJatoConfig;
    }

    public final float getCheckForceGcPercent() {
        return this.checkForceGcPercent;
    }

    public final long getCheckHeapLoopInterval() {
        return this.checkHeapLoopInterval;
    }

    public final boolean getDebug() {
        return this.debug;
    }

    public final boolean getDisablePrevCall() {
        return this.disablePrevCall;
    }

    public final boolean getEnable() {
        return this.enable;
    }

    public final boolean getEnableExitGcInhibit() {
        return this.enableExitGcInhibit;
    }

    public final int getExitGcInhibitDuration() {
        return this.exitGcInhibitDuration;
    }

    public final int getExitGcInhibitStrategy() {
        return this.exitGcInhibitStrategy;
    }

    public final long getForceGcInterval() {
        return this.forceGcInterval;
    }

    public final int getGcBlockerMode() {
        return this.gcBlockerMode;
    }

    public final int getGcBlockerStrategy() {
        return this.gcBlockerStrategy;
    }

    public final int getGcScrollStrategy() {
        return this.gcScrollStrategy;
    }

    public final boolean getJatoEnableMaxHeapSize() {
        return this.jatoEnableMaxHeapSize;
    }

    public final int getJatoMaxHeapLimit() {
        return this.jatoMaxHeapLimit;
    }

    public final double getJatoMaxHeapLimitPercent() {
        return this.jatoMaxHeapLimitPercent;
    }

    public final int getJatoMaxHeapLimitReset() {
        return this.jatoMaxHeapLimitReset;
    }

    public final boolean getNeedGcAfterRelease() {
        return this.needGcAfterRelease;
    }

    public final float getNewMaxHeapLimitPercent() {
        return this.newMaxHeapLimitPercent;
    }

    public final boolean getOpenCheckHeapLoop() {
        return this.openCheckHeapLoop;
    }

    public final boolean getRemoveHeapSizeLimit() {
        return this.removeHeapSizeLimit;
    }

    public final int getRequestGcBlockDuration() {
        return this.requestGcBlockDuration;
    }

    public final void setAdjustJatoConfig(boolean r100) {
        this.adjustJatoConfig = r100;
    }

    public final void setCheckForceGcPercent(float r100) {
        this.checkForceGcPercent = r100;
    }

    public final void setCheckHeapLoopInterval(long r100) {
        this.checkHeapLoopInterval = r100;
    }

    public final void setDebug(boolean r100) {
        this.debug = r100;
    }

    public final void setDisablePrevCall(boolean r100) {
        this.disablePrevCall = r100;
    }

    public final void setEnable(boolean r100) {
        this.enable = r100;
    }

    public final void setEnableExitGcInhibit(boolean r100) {
        this.enableExitGcInhibit = r100;
    }

    public final void setExitGcInhibitDuration(int r100) {
        this.exitGcInhibitDuration = r100;
    }

    public final void setExitGcInhibitStrategy(int r100) {
        this.exitGcInhibitStrategy = r100;
    }

    public final void setForceGcInterval(long r100) {
        this.forceGcInterval = r100;
    }

    public final void setGcBlockerMode(int r100) {
        this.gcBlockerMode = r100;
    }

    public final void setGcBlockerStrategy(int r100) {
        this.gcBlockerStrategy = r100;
    }

    public final void setGcScrollStrategy(int r100) {
        this.gcScrollStrategy = r100;
    }

    public final void setJatoEnableMaxHeapSize(boolean r100) {
        this.jatoEnableMaxHeapSize = r100;
    }

    public final void setJatoMaxHeapLimit(int r100) {
        this.jatoMaxHeapLimit = r100;
    }

    public final void setJatoMaxHeapLimitPercent(double r100) {
        this.jatoMaxHeapLimitPercent = r100;
    }

    public final void setJatoMaxHeapLimitReset(int r100) {
        this.jatoMaxHeapLimitReset = r100;
    }

    public final void setNeedGcAfterRelease(boolean r100) {
        this.needGcAfterRelease = r100;
    }

    public final void setNewMaxHeapLimitPercent(float r100) {
        this.newMaxHeapLimitPercent = r100;
    }

    public final void setOpenCheckHeapLoop(boolean r100) {
        this.openCheckHeapLoop = r100;
    }

    public final void setRemoveHeapSizeLimit(boolean r100) {
        this.removeHeapSizeLimit = r100;
    }

    public final void setRequestGcBlockDuration(int r100) {
        this.requestGcBlockDuration = r100;
    }
}
