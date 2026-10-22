package com.bumptech.glide.gifdecoder;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes39.dex */
public class GifHeader {
    public static final int NETSCAPE_LOOP_COUNT_DOES_NOT_EXIST = -1;
    public static final int NETSCAPE_LOOP_COUNT_FOREVER = 0;
    int bgColor;
    int bgIndex;
    GifFrame currentFrame;
    int frameCount;
    final List<GifFrame> frames;
    int[] gct;
    boolean gctFlag;
    int gctSize;
    int height;
    int loopCount;
    int pixelAspect;
    int status;
    int width;

    public GifHeader() {
        this.gct = null;
        this.status = 0;
        this.frameCount = 0;
        this.frames = new ArrayList();
        this.loopCount = -1;
    }

    public int getHeight() {
        return this.height;
    }

    public int getNumFrames() {
        return this.frameCount;
    }

    public int getStatus() {
        return this.status;
    }

    public int getWidth() {
        return this.width;
    }
}
