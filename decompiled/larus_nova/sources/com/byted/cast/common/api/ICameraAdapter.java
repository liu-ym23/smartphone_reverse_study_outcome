package com.byted.cast.common.api;

import android.hardware.Camera;

/* JADX INFO: loaded from: classes39.dex */
public interface ICameraAdapter {
    Camera openCamera();

    Camera openCamera(int r100);

    void releaseCamera(Camera r100);
}
