package com.bytedance.android.livesdkapi.model;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010#\u001a\u00020$H\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0006\"\u0004\b\u0016\u0010\bR\u001a\u0010\u0017\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\f\"\u0004\b\u0019\u0010\u000eR\u001a\u0010\u001a\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\f\"\u0004\b\u001c\u0010\u000eR\u001a\u0010\u001d\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0006\"\u0004\b\u001f\u0010\bR\u001a\u0010 \u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0006\"\u0004\b\"\u0010\b¨\u0006%"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/AudioChannelExpandParams;", "", "()V", "audioPosition", "", "getAudioPosition", "()I", "setAudioPosition", "(I)V", "calculateTime", "", "getCalculateTime", "()F", "setCalculateTime", "(F)V", "enableAudioExpand", "", "getEnableAudioExpand", "()Z", "setEnableAudioExpand", "(Z)V", "isLeftRmsBigger", "setLeftRmsBigger", "leftRightDiff", "getLeftRightDiff", "setLeftRightDiff", "mixRatio", "getMixRatio", "setMixRatio", "openAnalyzeAudioFrame", "getOpenAnalyzeAudioFrame", "setOpenAnalyzeAudioFrame", "processType", "getProcessType", "setProcessType", "toString", "", "live-player-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AudioChannelExpandParams {
    private int audioPosition;
    private float calculateTime;
    private boolean enableAudioExpand;
    private int isLeftRmsBigger;
    private float leftRightDiff;
    private float mixRatio;
    private int openAnalyzeAudioFrame;
    private int processType;

    public String toString() {
        return "AudioChannelExpandParams(enableAudioExpand=" + this.enableAudioExpand + ",audioPosition=" + this.audioPosition + ",isLeftRmsBigger=" + this.isLeftRmsBigger + ",mixRatio=" + this.mixRatio + ", processType=" + this.processType + ", openAnalyzeAudioFrame=" + this.openAnalyzeAudioFrame + ",calculateTime=" + this.calculateTime + ",leftRightDiff=" + this.leftRightDiff + ')';
    }

    public AudioChannelExpandParams() {
        this.isLeftRmsBigger = 1;
    }

    public final int getAudioPosition() {
        return this.audioPosition;
    }

    public final float getCalculateTime() {
        return this.calculateTime;
    }

    public final boolean getEnableAudioExpand() {
        return this.enableAudioExpand;
    }

    public final float getLeftRightDiff() {
        return this.leftRightDiff;
    }

    public final float getMixRatio() {
        return this.mixRatio;
    }

    public final int getOpenAnalyzeAudioFrame() {
        return this.openAnalyzeAudioFrame;
    }

    public final int getProcessType() {
        return this.processType;
    }

    public final int isLeftRmsBigger() {
        return this.isLeftRmsBigger;
    }

    public final void setAudioPosition(int r100) {
        this.audioPosition = r100;
    }

    public final void setCalculateTime(float r100) {
        this.calculateTime = r100;
    }

    public final void setEnableAudioExpand(boolean r100) {
        this.enableAudioExpand = r100;
    }

    public final void setLeftRightDiff(float r100) {
        this.leftRightDiff = r100;
    }

    public final void setLeftRmsBigger(int r100) {
        this.isLeftRmsBigger = r100;
    }

    public final void setMixRatio(float r100) {
        this.mixRatio = r100;
    }

    public final void setOpenAnalyzeAudioFrame(int r100) {
        this.openAnalyzeAudioFrame = r100;
    }

    public final void setProcessType(int r100) {
        this.processType = r100;
    }
}
