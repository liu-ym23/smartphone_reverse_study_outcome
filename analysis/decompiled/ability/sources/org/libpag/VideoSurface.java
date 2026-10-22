package org.libpag;

import android.graphics.SurfaceTexture;
import z2.l;

/* loaded from: classes4.dex */
class VideoSurface implements SurfaceTexture.OnFrameAvailableListener {
    long nativeContext = 0;

    static {
        l.j("pag");
        nativeInit();
    }

    private VideoSurface(int i, int i6) {
        nativeSetup(i, i6);
    }

    public static VideoSurface Make(int i, int i6) {
        VideoSurface videoSurface = new VideoSurface(i, i6);
        if (videoSurface.nativeContext == 0) {
            return null;
        }
        return videoSurface;
    }

    private native void nativeFinalize();

    private static native void nativeInit();

    private native void nativeRelease();

    private native void nativeSetup(int i, int i6);

    private native void notifyFrameAvailable();

    public void finalize() {
        nativeFinalize();
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        notifyFrameAvailable();
    }

    public void release() {
        nativeRelease();
    }
}
