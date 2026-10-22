package com.bumptech.glide.integration.webp;

import android.graphics.Bitmap;

/* JADX INFO: loaded from: classes39.dex */
public class WebpFrame {
    static final int FRAME_DURATION_MS_FOR_MIN = 100;
    static final int MIN_FRAME_DURATION_MS = 11;
    boolean blendPreviousFrame;
    int delay;
    boolean disposeBackgroundColor;

    /* JADX INFO: renamed from: ih, reason: collision with root package name */
    int f33683ih;

    /* JADX INFO: renamed from: iw, reason: collision with root package name */
    int f33684iw;

    /* JADX INFO: renamed from: ix, reason: collision with root package name */
    int f33685ix;

    /* JADX INFO: renamed from: iy, reason: collision with root package name */
    int f33686iy;
    private long mNativePtr;

    public static /* synthetic */ void a(WebpFrame r100) {
        r100.nativeFinalize();
    }

    private native void nativeDispose();

    private native void nativeFinalize();

    private native void nativeRenderFrame(int r100, int r101, Bitmap r102);

    private void fixFrameDuration() {
        if (this.delay >= 11) goto L6;
        this.delay = 100;
        return;
    }

    public void finalize() throws Throwable {
        super.finalize();
        WebpThread.execute(new a(this));
    }

    public void dispose() {
        nativeDispose();
    }

    public int getDurationMs() {
        return this.delay;
    }

    public int getHeight() {
        return this.f33683ih;
    }

    public int getWidth() {
        return this.f33684iw;
    }

    public int getXOffest() {
        return this.f33685ix;
    }

    public int getYOffest() {
        return this.f33686iy;
    }

    public boolean isBlendWithPreviousFrame() {
        return this.blendPreviousFrame;
    }

    public boolean shouldDisposeToBackgroundColor() {
        return this.disposeBackgroundColor;
    }

    public void renderFrame(int r100, int r101, Bitmap r102) {
        nativeRenderFrame(r100, r101, r102);
    }

    public WebpFrame(long r100, int r101, int r102, int r103, int r104, int r105, boolean r106, boolean r107) {
        this.mNativePtr = r100;
        this.f33685ix = r101;
        this.f33686iy = r102;
        this.f33684iw = r103;
        this.f33683ih = r104;
        this.delay = r105;
        this.blendPreviousFrame = r106;
        this.disposeBackgroundColor = r107;
        fixFrameDuration();
    }
}
