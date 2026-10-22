package com.byted.cast.mediacommon;

import android.graphics.Point;
import android.graphics.SurfaceTexture;
import android.view.Surface;
import com.byted.cast.common.config.Config;

/* JADX INFO: loaded from: classes39.dex */
public interface IMediaCamera {

    /* JADX INFO: renamed from: com.byted.cast.mediacommon.IMediaCamera$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static Point $default$getCameraSize(IMediaCamera r100) {
            return null;
        }

        public static int $default$getFps(IMediaCamera r100) {
            return 0;
        }

        public static void $default$openCamera(IMediaCamera r100, int r101, int r102, int r103, int r104, int r105) {
        }

        public static void $default$releaseCamera(IMediaCamera r100) {
        }

        public static void $default$setConfig(IMediaCamera r100, Config r101) {
        }

        public static void $default$setFlashEnable(IMediaCamera r100, boolean r101) {
        }

        public static void $default$setStartCert(IMediaCamera r100, Object r101) {
        }

        public static void $default$setStopCert(IMediaCamera r100, Object r101) {
        }

        public static void $default$startPreview(IMediaCamera r100, SurfaceTexture r101) {
        }

        public static void $default$startPreviewSurface(IMediaCamera r100, Surface r101) {
        }
    }

    Point getCameraSize();

    int getFps();

    void openCamera(int r100, int r101, int r102, int r103, int r104);

    void releaseCamera();

    void setConfig(Config r100);

    void setFlashEnable(boolean r100);

    void setStartCert(Object r100);

    void setStopCert(Object r100);

    void startPreview(SurfaceTexture r100);

    void startPreviewSurface(Surface r100);
}
