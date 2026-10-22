package com.bytedance.android.livesdkapi.model;

import com.google.gson.annotations.SerializedName;
import com.ss.ttvideoengine.portrait.PortraitEngine;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\u0007\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0018\u001a\u00020\u0004J\u0006\u0010\u0019\u001a\u00020\u0004J\u0006\u0010\u001a\u001a\u00020\u0013R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001e\u0010\f\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001e\u0010\u000f\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001e\u0010\u0012\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/LiveDrawDragPlayConfig;", "", "()V", "dragIn", "", "getDragIn", "()Z", "setDragIn", "(Z)V", "enable", "getEnable", "setEnable", "firstFrame", "getFirstFrame", "setFirstFrame", "noDetach", "getNoDetach", "setNoDetach", "pullStreamThreshold", "", "getPullStreamThreshold", "()F", "setPullStreamThreshold", "(F)V", "getDragInConfig", "getFirstFrameConfig", "getPullStreamThresholdConfig", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveDrawDragPlayConfig {

    @SerializedName("drag_in")
    private boolean dragIn;

    @SerializedName("enable")
    private boolean enable;

    @SerializedName(PortraitEngine.LABEL_FIRST_FRAME)
    private boolean firstFrame;

    @SerializedName("no_detach")
    private boolean noDetach;

    @SerializedName("pull_stream_threshold")
    private float pullStreamThreshold;

    public final boolean getDragInConfig() {
        if (this.enable == true) goto L5;
    L7:
        return false;
    L5:
        if (this.dragIn == false) goto L7;
        return true;
    }

    public final boolean getFirstFrameConfig() {
        if (this.enable == true) goto L5;
    L9:
        return false;
    L5:
        if (this.dragIn == false) goto L9;
        if (this.firstFrame == false) goto L9;
        return true;
    }

    public final float getPullStreamThresholdConfig() {
        if (this.enable == true) goto L7;
        return -1.0f;
    L7:
        return this.pullStreamThreshold;
    }

    public LiveDrawDragPlayConfig() {
        this.pullStreamThreshold = 0.05f;
    }

    public final boolean getDragIn() {
        return this.dragIn;
    }

    public final boolean getEnable() {
        return this.enable;
    }

    public final boolean getFirstFrame() {
        return this.firstFrame;
    }

    public final boolean getNoDetach() {
        return this.noDetach;
    }

    public final float getPullStreamThreshold() {
        return this.pullStreamThreshold;
    }

    public final void setDragIn(boolean r100) {
        this.dragIn = r100;
    }

    public final void setEnable(boolean r100) {
        this.enable = r100;
    }

    public final void setFirstFrame(boolean r100) {
        this.firstFrame = r100;
    }

    public final void setNoDetach(boolean r100) {
        this.noDetach = r100;
    }

    public final void setPullStreamThreshold(float r100) {
        this.pullStreamThreshold = r100;
    }
}
