package org.libpag;

import android.graphics.SurfaceTexture;
import android.view.Surface;
import gc.AbstractC4115a;

/* loaded from: classes5.dex */
class VideoSurface implements SurfaceTexture.OnFrameAvailableListener {
    long nativeContext = 0;

    static {
        AbstractC4115a.e("pag");
        nativeInit();
    }

    private VideoSurface(int i10, int i11) {
        nativeSetup(i10, i11);
    }

    public static VideoSurface a(int i10, int i11) {
        VideoSurface videoSurface = new VideoSurface(i10, i11);
        if (videoSurface.nativeContext == 0) {
            return null;
        }
        return videoSurface;
    }

    private native void nativeFinalize();

    private static native void nativeInit();

    private native void nativeRelease();

    private native void nativeSetup(int i10, int i11);

    private native void notifyFrameAvailable();

    public void finalize() {
        nativeFinalize();
    }

    public native Surface getInputSurface();

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        notifyFrameAvailable();
    }

    public void a() {
        nativeRelease();
    }
}
