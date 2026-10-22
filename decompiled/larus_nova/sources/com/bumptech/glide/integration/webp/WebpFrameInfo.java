package com.bumptech.glide.integration.webp;

/* JADX INFO: loaded from: classes39.dex */
public class WebpFrameInfo {
    public final boolean blendPreviousFrame;
    public final boolean disposeBackgroundColor;
    public final int duration;
    public final int frameNumber;
    public final int height;
    public final int width;
    public final int xOffset;
    public final int yOffset;

    public String toString() {
        return "frameNumber=" + this.frameNumber + ", xOffset=" + this.xOffset + ", yOffset=" + this.yOffset + ", width=" + this.width + ", height=" + this.height + ", duration=" + this.duration + ", blendPreviousFrame=" + this.blendPreviousFrame + ", disposeBackgroundColor=" + this.disposeBackgroundColor;
    }

    public WebpFrameInfo(int r100, WebpFrame r101) {
        this.frameNumber = r100;
        this.xOffset = r101.getXOffest();
        this.yOffset = r101.getYOffest();
        this.width = r101.getWidth();
        this.height = r101.getHeight();
        this.duration = r101.getDurationMs();
        this.blendPreviousFrame = r101.isBlendWithPreviousFrame();
        this.disposeBackgroundColor = r101.shouldDisposeToBackgroundColor();
    }
}
