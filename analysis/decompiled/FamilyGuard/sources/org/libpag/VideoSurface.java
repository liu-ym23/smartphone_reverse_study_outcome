package org.libpag;

import android.graphics.SurfaceTexture;
import android.view.Surface;

/* loaded from: classes.dex */
class VideoSurface implements SurfaceTexture.OnFrameAvailableListener {
    long nativeContext = 0;

    static {
        P4.a.a("pag");
        nativeInit();
    }

    private VideoSurface(int i5, int i6) {
        nativeSetup(i5, i6);
    }

    static VideoSurface a(int i5, int i6) {
        VideoSurface videoSurface = new VideoSurface(i5, i6);
        if (videoSurface.nativeContext == 0) {
            return null;
        }
        return videoSurface;
    }

    private native void nativeFinalize();

    private static native void nativeInit();

    private native void nativeRelease();

    private native void nativeSetup(int i5, int i6);

    private native void notifyFrameAvailable();

    protected void finalize() {
        nativeFinalize();
    }

    native Surface getInputSurface();

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        notifyFrameAvailable();
    }

    void a() {
        nativeRelease();
    }
}
