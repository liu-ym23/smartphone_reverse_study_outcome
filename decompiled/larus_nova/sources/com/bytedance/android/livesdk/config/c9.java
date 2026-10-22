package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\t\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001a\u0010\u000b\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u001a\u0010\r\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u0004\u001a\u0004\b\u000e\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livesdk/config/c9;", "", "", "fps", "I", "getFps", "()I", "resolutionWidth", "getResolutionWidth", "resolutionHeight", "getResolutionHeight", "cameraVideoWidth", "getCameraVideoWidth", "cameraVideoHeight", "getCameraVideoHeight", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class c9 {

    @SerializedName("camera_video_height")
    private final int cameraVideoHeight;

    @SerializedName("camera_video_width")
    private final int cameraVideoWidth;

    @SerializedName("fps")
    private final int fps;

    @SerializedName("resolution_height")
    private final int resolutionHeight;

    @SerializedName("resolution_width")
    private final int resolutionWidth;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof c9) == false) goto L16;
        c9 r101 = (c9) r100;
        if (this.fps == r101.fps) goto L8;
        return false;
    L8:
        if (this.resolutionWidth == r101.resolutionWidth) goto L10;
        return false;
    L10:
        if (this.resolutionHeight == r101.resolutionHeight) goto L12;
        return false;
    L12:
        if (this.cameraVideoWidth == r101.cameraVideoWidth) goto L14;
        return false;
    L14:
        if (this.cameraVideoHeight == r101.cameraVideoHeight) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public final int hashCode() {
        return (((((((this.fps * 31) + this.resolutionWidth) * 31) + this.resolutionHeight) * 31) + this.cameraVideoWidth) * 31) + this.cameraVideoHeight;
    }

    public final String toString() {
        return "KtvRoomGuestVideoConfig(fps=" + this.fps + ", resolutionWidth=" + this.resolutionWidth + ", resolutionHeight=" + this.resolutionHeight + ", cameraVideoWidth=" + this.cameraVideoWidth + ", cameraVideoHeight=" + this.cameraVideoHeight + ")";
    }

    public c9() {
        this.fps = 15;
        this.resolutionWidth = 720;
        this.resolutionHeight = 1280;
        this.cameraVideoWidth = 720;
        this.cameraVideoHeight = 540;
    }
}
