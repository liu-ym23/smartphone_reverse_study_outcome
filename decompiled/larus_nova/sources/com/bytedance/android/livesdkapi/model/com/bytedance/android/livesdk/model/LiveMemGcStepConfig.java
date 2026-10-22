package com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0014\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001e\u0010\f\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001e\u0010\u000f\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001e\u0010\u0012\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\u001e\u0010\u0015\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\b¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/com/bytedance/android/livesdk/model/LiveMemGcStepConfig;", "", "()V", "baseGcStepValue", "", "getBaseGcStepValue", "()I", "setBaseGcStepValue", "(I)V", "minGcStepValue", "getMinGcStepValue", "setMinGcStepValue", "newDiffGcValue", "getNewDiffGcValue", "setNewDiffGcValue", "resetBaseGcStepValue", "getResetBaseGcStepValue", "setResetBaseGcStepValue", "resetMinGcStepValue", "getResetMinGcStepValue", "setResetMinGcStepValue", "resetNewGcDiffValue", "getResetNewGcDiffValue", "setResetNewGcDiffValue", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveMemGcStepConfig {

    @SerializedName("base_gc_step_value")
    private int baseGcStepValue;

    @SerializedName("min_gc_step_value")
    private int minGcStepValue;

    @SerializedName("new_diff_gc_value")
    private int newDiffGcValue;

    @SerializedName("reset_base_gc_step_value")
    private int resetBaseGcStepValue;

    @SerializedName("reset_min_gc_step_value")
    private int resetMinGcStepValue;

    @SerializedName("reset_new_diff_gc_value")
    private int resetNewGcDiffValue;

    public LiveMemGcStepConfig() {
        this.baseGcStepValue = -100;
        this.minGcStepValue = -100;
        this.resetBaseGcStepValue = -100;
        this.resetMinGcStepValue = -100;
        this.newDiffGcValue = -100;
        this.resetNewGcDiffValue = -100;
    }

    public final int getBaseGcStepValue() {
        return this.baseGcStepValue;
    }

    public final int getMinGcStepValue() {
        return this.minGcStepValue;
    }

    public final int getNewDiffGcValue() {
        return this.newDiffGcValue;
    }

    public final int getResetBaseGcStepValue() {
        return this.resetBaseGcStepValue;
    }

    public final int getResetMinGcStepValue() {
        return this.resetMinGcStepValue;
    }

    public final int getResetNewGcDiffValue() {
        return this.resetNewGcDiffValue;
    }

    public final void setBaseGcStepValue(int r100) {
        this.baseGcStepValue = r100;
    }

    public final void setMinGcStepValue(int r100) {
        this.minGcStepValue = r100;
    }

    public final void setNewDiffGcValue(int r100) {
        this.newDiffGcValue = r100;
    }

    public final void setResetBaseGcStepValue(int r100) {
        this.resetBaseGcStepValue = r100;
    }

    public final void setResetMinGcStepValue(int r100) {
        this.resetMinGcStepValue = r100;
    }

    public final void setResetNewGcDiffValue(int r100) {
        this.resetNewGcDiffValue = r100;
    }
}
