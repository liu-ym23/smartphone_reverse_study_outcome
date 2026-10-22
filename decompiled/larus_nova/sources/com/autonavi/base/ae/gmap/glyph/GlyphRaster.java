package com.autonavi.base.ae.gmap.glyph;

/* JADX INFO: loaded from: classes39.dex */
public class GlyphRaster {
    public static final int PIXEL_MODE_A8 = 0;
    public static final int PIXEL_MODE_ARGB = 1;
    public static final int PIXEL_MODE_RGB = 3;
    public static final int PIXEL_MODE_RGBA = 2;
    public boolean bSuccess;
    public byte[] bitmapBuffer;
    public int bitmapHeight;
    public int bitmapPixelMode;
    public int bitmapSize;
    public int bitmapWidth;

    public GlyphRaster() {
        this.bSuccess = false;
        this.bitmapBuffer = null;
        this.bitmapSize = 0;
        this.bitmapWidth = 0;
        this.bitmapHeight = 0;
        this.bitmapPixelMode = 0;
    }
}
