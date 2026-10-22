package com.byted.mgl.merge.service.api.privacy.camera;

import android.hardware.Camera;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;
import android.os.Handler;

/* JADX INFO: loaded from: classes43.dex */
public interface IPrivacyCamera {
    void close(CameraDevice r100, String r101) throws IllegalAccessException;

    Camera open(int r100, String r101) throws IllegalAccessException;

    void openCamera(CameraManager r100, String r101, CameraDevice.StateCallback r102, Handler r103, String r104) throws IllegalAccessException, CameraAccessException;

    void release(Camera r100, String r101) throws IllegalAccessException;
}
