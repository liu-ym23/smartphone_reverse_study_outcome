package com.bytedance.android.livesdk.live.model;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes10.dex */
public class Camera2AB {

    @SerializedName("camera_hw_level")
    private int cameraHWLevel;

    @SerializedName("camera_type")
    private int cameraType;

    public Camera2AB() {
        this.cameraType = 1;
        this.cameraHWLevel = 0;
    }

    public int getCameraHWLevel() {
        return this.cameraHWLevel;
    }

    public int getCameraType() {
        return this.cameraType;
    }

    public void setCameraHWLevel(int r100) {
        this.cameraHWLevel = r100;
    }

    public void setCameraType(int r100) {
        this.cameraType = r100;
    }

    public Camera2AB(int r100, int r101) {
        this.cameraType = r100;
        this.cameraHWLevel = r101;
    }
}
