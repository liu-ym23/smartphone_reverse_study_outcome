package com.autonavi.base.ae.gmap.glyph;

/* JADX INFO: loaded from: classes39.dex */
public class GlyphRequestParam {
    public int drawingMode;
    public GlyphMetrics fGlyphMetrics;
    public Font font;
    public int isEmoji;
    public int isSDF;
    public String languageArr;
    public String strBuffer;
    public float strokeWidth;

    public GlyphRequestParam() {
        this.strBuffer = "";
        this.font = null;
        this.drawingMode = 0;
        this.strokeWidth = 0.0f;
        this.fGlyphMetrics = null;
        this.languageArr = "";
        this.isEmoji = 0;
        this.isSDF = 0;
    }
}
