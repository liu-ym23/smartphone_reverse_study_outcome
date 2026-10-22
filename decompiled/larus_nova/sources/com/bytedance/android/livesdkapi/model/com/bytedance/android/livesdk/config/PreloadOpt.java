package com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\u0014\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001e\u0010\f\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\"\u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0015\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0016\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0006\"\u0004\b\u0018\u0010\bR\u001e\u0010\u0019\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0006\"\u0004\b\u001b\u0010\bR\u001e\u0010\u001c\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0006\"\u0004\b\u001e\u0010\bR\u001e\u0010\u001f\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#¨\u0006$"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/com/bytedance/android/livesdk/config/PreloadOpt;", "", "()V", "enable", "", "getEnable", "()Z", "setEnable", "(Z)V", "observePlayingEvent", "getObservePlayingEvent", "setObservePlayingEvent", "postRoomInnerTask", "getPostRoomInnerTask", "setPostRoomInnerTask", "postRoomInnerTaskDelayTime", "", "getPostRoomInnerTaskDelayTime", "()Ljava/lang/Long;", "setPostRoomInnerTaskDelayTime", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "postStartRoomTask", "getPostStartRoomTask", "setPostStartRoomTask", "postVisibleTask", "getPostVisibleTask", "setPostVisibleTask", "postWhenFirstFrame", "getPostWhenFirstFrame", "setPostWhenFirstFrame", "startRoomTaskDelayTime", "getStartRoomTaskDelayTime", "()J", "setStartRoomTaskDelayTime", "(J)V", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PreloadOpt {

    @SerializedName("enable")
    private boolean enable;

    @SerializedName("observe_playing_event")
    private boolean observePlayingEvent;

    @SerializedName("post_room_inner_task")
    private boolean postRoomInnerTask;

    @SerializedName("post_room_inner_task_delay_time")
    private Long postRoomInnerTaskDelayTime;

    @SerializedName("post_start_room_task")
    private boolean postStartRoomTask;

    @SerializedName("post_visible_task")
    private boolean postVisibleTask;

    @SerializedName("post_when_first_frame")
    private boolean postWhenFirstFrame;

    @SerializedName("start_room_task_delay_time")
    private long startRoomTaskDelayTime;

    public PreloadOpt() {
        this.postRoomInnerTaskDelayTime = 0L;
    }

    public final boolean getEnable() {
        return this.enable;
    }

    public final boolean getObservePlayingEvent() {
        return this.observePlayingEvent;
    }

    public final boolean getPostRoomInnerTask() {
        return this.postRoomInnerTask;
    }

    public final Long getPostRoomInnerTaskDelayTime() {
        return this.postRoomInnerTaskDelayTime;
    }

    public final boolean getPostStartRoomTask() {
        return this.postStartRoomTask;
    }

    public final boolean getPostVisibleTask() {
        return this.postVisibleTask;
    }

    public final boolean getPostWhenFirstFrame() {
        return this.postWhenFirstFrame;
    }

    public final long getStartRoomTaskDelayTime() {
        return this.startRoomTaskDelayTime;
    }

    public final void setEnable(boolean r100) {
        this.enable = r100;
    }

    public final void setObservePlayingEvent(boolean r100) {
        this.observePlayingEvent = r100;
    }

    public final void setPostRoomInnerTask(boolean r100) {
        this.postRoomInnerTask = r100;
    }

    public final void setPostRoomInnerTaskDelayTime(Long r100) {
        this.postRoomInnerTaskDelayTime = r100;
    }

    public final void setPostStartRoomTask(boolean r100) {
        this.postStartRoomTask = r100;
    }

    public final void setPostVisibleTask(boolean r100) {
        this.postVisibleTask = r100;
    }

    public final void setPostWhenFirstFrame(boolean r100) {
        this.postWhenFirstFrame = r100;
    }

    public final void setStartRoomTaskDelayTime(long r100) {
        this.startRoomTaskDelayTime = r100;
    }
}
