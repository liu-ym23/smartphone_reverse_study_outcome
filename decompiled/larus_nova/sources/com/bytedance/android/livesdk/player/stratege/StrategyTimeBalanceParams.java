package com.bytedance.android.livesdk.player.stratege;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0014\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR\u001e\u0010\u0012\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\u001e\u0010\u0015\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR\u001e\u0010\u0018\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\bR\u001e\u0010\u001b\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0006\"\u0004\b\u001d\u0010\b¨\u0006\u001e"}, d2 = {"Lcom/bytedance/android/livesdk/player/stratege/StrategyTimeBalanceParams;", "", "()V", "enableTimeBalance", "", "getEnableTimeBalance", "()Z", "setEnableTimeBalance", "(Z)V", "maxTimeBalancePercent", "", "getMaxTimeBalancePercent", "()F", "setMaxTimeBalancePercent", "(F)V", "minTimeBalancePercent", "getMinTimeBalancePercent", "setMinTimeBalancePercent", "timeBalanceToLuft", "getTimeBalanceToLuft", "setTimeBalanceToLuft", "timeBalanceToPregain", "getTimeBalanceToPregain", "setTimeBalanceToPregain", "timeBalanceToRatio", "getTimeBalanceToRatio", "setTimeBalanceToRatio", "timeBalanceToThreshold", "getTimeBalanceToThreshold", "setTimeBalanceToThreshold", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class StrategyTimeBalanceParams {

    @SerializedName("enableTimeBalance")
    private boolean enableTimeBalance;

    @SerializedName("maxTimeBalancePercent")
    private float maxTimeBalancePercent;

    @SerializedName("minTimeBalancePercent")
    private float minTimeBalancePercent;

    @SerializedName("timeBalanceToLuft")
    private boolean timeBalanceToLuft;

    @SerializedName("timeBalanceToPregain")
    private boolean timeBalanceToPregain;

    @SerializedName("timeBalanceToRatio")
    private boolean timeBalanceToRatio;

    @SerializedName("timeBalanceToThreshold")
    private boolean timeBalanceToThreshold;

    public StrategyTimeBalanceParams() {
        this.minTimeBalancePercent = -0.1f;
        this.maxTimeBalancePercent = 0.1f;
        this.timeBalanceToLuft = true;
        this.timeBalanceToRatio = true;
        this.timeBalanceToThreshold = true;
        this.timeBalanceToPregain = true;
    }

    public final boolean getEnableTimeBalance() {
        return this.enableTimeBalance;
    }

    public final float getMaxTimeBalancePercent() {
        return this.maxTimeBalancePercent;
    }

    public final float getMinTimeBalancePercent() {
        return this.minTimeBalancePercent;
    }

    public final boolean getTimeBalanceToLuft() {
        return this.timeBalanceToLuft;
    }

    public final boolean getTimeBalanceToPregain() {
        return this.timeBalanceToPregain;
    }

    public final boolean getTimeBalanceToRatio() {
        return this.timeBalanceToRatio;
    }

    public final boolean getTimeBalanceToThreshold() {
        return this.timeBalanceToThreshold;
    }

    public final void setEnableTimeBalance(boolean r100) {
        this.enableTimeBalance = r100;
    }

    public final void setMaxTimeBalancePercent(float r100) {
        this.maxTimeBalancePercent = r100;
    }

    public final void setMinTimeBalancePercent(float r100) {
        this.minTimeBalancePercent = r100;
    }

    public final void setTimeBalanceToLuft(boolean r100) {
        this.timeBalanceToLuft = r100;
    }

    public final void setTimeBalanceToPregain(boolean r100) {
        this.timeBalanceToPregain = r100;
    }

    public final void setTimeBalanceToRatio(boolean r100) {
        this.timeBalanceToRatio = r100;
    }

    public final void setTimeBalanceToThreshold(boolean r100) {
        this.timeBalanceToThreshold = r100;
    }
}
