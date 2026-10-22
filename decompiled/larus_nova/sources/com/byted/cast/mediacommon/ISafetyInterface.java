package com.byted.cast.mediacommon;

import android.content.Context;
import android.content.Intent;
import android.hardware.Camera;
import android.hardware.display.VirtualDisplay;
import android.media.AudioRecord;
import android.media.projection.MediaProjection;
import android.media.projection.MediaProjectionManager;
import android.os.Handler;
import android.view.Surface;

/* JADX INFO: loaded from: classes39.dex */
public interface ISafetyInterface {

    /* JADX INFO: renamed from: com.byted.cast.mediacommon.ISafetyInterface$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static Intent $default$createScreenCaptureIntent(ISafetyInterface r100, MediaProjectionManager r101) {
            return null;
        }

        public static VirtualDisplay $default$createVirtualDisplay(ISafetyInterface r100, MediaProjection r101, String r102, int r103, int r104, int r105, int r106, Surface r107, VirtualDisplay.Callback r108, Handler r109) {
            return null;
        }

        public static MediaProjection $default$getMediaProjection(ISafetyInterface r100, MediaProjectionManager r101, int r102, Intent r103) {
            return null;
        }

        public static MediaProjectionManager $default$getMediaProjectionManager(ISafetyInterface r100, Context r101) {
            return null;
        }

        public static Camera $default$openCamera(ISafetyInterface r100) {
            return null;
        }

        public static Camera $default$openCamera(ISafetyInterface r100, int r101) {
            return null;
        }

        public static void $default$release(ISafetyInterface r100, AudioRecord r101) {
        }

        public static void $default$releaseCamera(ISafetyInterface r100, Camera r101) {
        }

        public static void $default$startRecording(ISafetyInterface r100, AudioRecord r101) {
        }

        public static void $default$stop(ISafetyInterface r100, AudioRecord r101) {
        }
    }

    Intent createScreenCaptureIntent(MediaProjectionManager r100);

    VirtualDisplay createVirtualDisplay(MediaProjection r100, String r101, int r102, int r103, int r104, int r105, Surface r106, VirtualDisplay.Callback r107, Handler r108);

    MediaProjection getMediaProjection(MediaProjectionManager r100, int r101, Intent r102);

    MediaProjectionManager getMediaProjectionManager(Context r100);

    Camera openCamera();

    Camera openCamera(int r100);

    void release(AudioRecord r100);

    void releaseCamera(Camera r100);

    void startRecording(AudioRecord r100);

    void stop(AudioRecord r100);
}
