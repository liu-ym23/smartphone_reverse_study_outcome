package com.bytedance.android.livesdkapi.eventbus;

import com.bytedance.android.livesdkapi.depend.model.live.IBaseStreamUrl;
import com.ss.android.ugc.aweme.shortvideo.ShortVideoSegments;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0012\"\u0004\b\u0017\u0010\u0014R\u001a\u0010\u0018\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\bR\u001a\u0010\u001b\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0006\"\u0004\b\u001d\u0010\bR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#¨\u0006$"}, d2 = {"Lcom/bytedance/android/livesdkapi/eventbus/ChangeCameraStreamEvent;", "", "()V", ShortVideoSegments.KEY_CAMERA_ID, "", "getCameraId", "()J", "setCameraId", "(J)V", "cameraLoadingText", "", "getCameraLoadingText", "()Ljava/lang/String;", "setCameraLoadingText", "(Ljava/lang/String;)V", "cameraScene", "", "getCameraScene", "()I", "setCameraScene", "(I)V", "cameraType", "getCameraType", "setCameraType", "roomId", "getRoomId", "setRoomId", "streamId", "getStreamId", "setStreamId", "streamUrl", "Lcom/bytedance/android/livesdkapi/depend/model/live/IBaseStreamUrl;", "getStreamUrl", "()Lcom/bytedance/android/livesdkapi/depend/model/live/IBaseStreamUrl;", "setStreamUrl", "(Lcom/bytedance/android/livesdkapi/depend/model/live/IBaseStreamUrl;)V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class ChangeCameraStreamEvent {
    private long cameraId;
    private String cameraLoadingText;
    private int cameraScene;
    private int cameraType;
    private long roomId;
    private long streamId;
    private IBaseStreamUrl streamUrl;

    public ChangeCameraStreamEvent() {
    }

    public final long getCameraId() {
        return this.cameraId;
    }

    public final String getCameraLoadingText() {
        return this.cameraLoadingText;
    }

    public final int getCameraScene() {
        return this.cameraScene;
    }

    public final int getCameraType() {
        return this.cameraType;
    }

    public final long getRoomId() {
        return this.roomId;
    }

    public final long getStreamId() {
        return this.streamId;
    }

    public final IBaseStreamUrl getStreamUrl() {
        return this.streamUrl;
    }

    public final void setCameraId(long r100) {
        this.cameraId = r100;
    }

    public final void setCameraLoadingText(String r100) {
        this.cameraLoadingText = r100;
    }

    public final void setCameraScene(int r100) {
        this.cameraScene = r100;
    }

    public final void setCameraType(int r100) {
        this.cameraType = r100;
    }

    public final void setRoomId(long r100) {
        this.roomId = r100;
    }

    public final void setStreamId(long r100) {
        this.streamId = r100;
    }

    public final void setStreamUrl(IBaseStreamUrl r100) {
        this.streamUrl = r100;
    }
}
