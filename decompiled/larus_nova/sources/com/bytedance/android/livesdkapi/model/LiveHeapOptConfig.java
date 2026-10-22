package com.bytedance.android.livesdkapi.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0017\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0015\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR\u001e\u0010\u0018\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\bR\u001e\u0010\u001b\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0006\"\u0004\b\u001d\u0010\bR\u001e\u0010\u001e\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0006\"\u0004\b \u0010\bR\u001e\u0010!\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0012\"\u0004\b#\u0010\u0014R\u001e\u0010$\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0006\"\u0004\b&\u0010\b¨\u0006'"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/LiveHeapOptConfig;", "", "()V", "diffGCValue", "", "getDiffGCValue", "()I", "setDiffGCValue", "(I)V", "enableHeapOpt", "", "getEnableHeapOpt", "()Z", "setEnableHeapOpt", "(Z)V", "expandHeapPercent", "", "getExpandHeapPercent", "()F", "setExpandHeapPercent", "(F)V", "expandHeapValue", "getExpandHeapValue", "setExpandHeapValue", "newDiffGcValue", "getNewDiffGcValue", "setNewDiffGcValue", "resetNewGcDiffValue", "getResetNewGcDiffValue", "setResetNewGcDiffValue", "resetTriggerValue", "getResetTriggerValue", "setResetTriggerValue", "triggerGCPercent", "getTriggerGCPercent", "setTriggerGCPercent", "triggerGCValue", "getTriggerGCValue", "setTriggerGCValue", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class LiveHeapOptConfig {

    @SerializedName("diff_gc_value")
    private int diffGCValue;

    @SerializedName("enable_heap_opt")
    private boolean enableHeapOpt;

    @SerializedName("expand_heap_percent")
    private float expandHeapPercent;

    @SerializedName("expand_heap_value")
    private int expandHeapValue;

    @SerializedName("new_diff_gc_value")
    private int newDiffGcValue;

    @SerializedName("reset_new_diff_gc_value")
    private int resetNewGcDiffValue;

    @SerializedName("reset_gc_value")
    private int resetTriggerValue;

    @SerializedName("trigger_gc_percent")
    private float triggerGCPercent;

    @SerializedName("trigger_gc_value")
    private int triggerGCValue;

    public LiveHeapOptConfig() {
        this.resetTriggerValue = 100;
    }

    public final int getDiffGCValue() {
        return this.diffGCValue;
    }

    public final boolean getEnableHeapOpt() {
        return this.enableHeapOpt;
    }

    public final float getExpandHeapPercent() {
        return this.expandHeapPercent;
    }

    public final int getExpandHeapValue() {
        return this.expandHeapValue;
    }

    public final int getNewDiffGcValue() {
        return this.newDiffGcValue;
    }

    public final int getResetNewGcDiffValue() {
        return this.resetNewGcDiffValue;
    }

    public final int getResetTriggerValue() {
        return this.resetTriggerValue;
    }

    public final float getTriggerGCPercent() {
        return this.triggerGCPercent;
    }

    public final int getTriggerGCValue() {
        return this.triggerGCValue;
    }

    public final void setDiffGCValue(int r100) {
        this.diffGCValue = r100;
    }

    public final void setEnableHeapOpt(boolean r100) {
        this.enableHeapOpt = r100;
    }

    public final void setExpandHeapPercent(float r100) {
        this.expandHeapPercent = r100;
    }

    public final void setExpandHeapValue(int r100) {
        this.expandHeapValue = r100;
    }

    public final void setNewDiffGcValue(int r100) {
        this.newDiffGcValue = r100;
    }

    public final void setResetNewGcDiffValue(int r100) {
        this.resetNewGcDiffValue = r100;
    }

    public final void setResetTriggerValue(int r100) {
        this.resetTriggerValue = r100;
    }

    public final void setTriggerGCPercent(float r100) {
        this.triggerGCPercent = r100;
    }

    public final void setTriggerGCValue(int r100) {
        this.triggerGCValue = r100;
    }
}
