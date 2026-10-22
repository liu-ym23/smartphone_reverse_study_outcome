package com.autonavi.base.ae.gmap.glyph;

/* JADX INFO: loaded from: classes39.dex */
public class FontStyle {
    public static final int SLANT_ITALIC = 1;
    public static final int SLANT_OBLIQUE = 2;
    public static final int SLANT_UPRIGHT = 0;
    public static final int WEIGHT_BLACK = 900;
    public static final int WEIGHT_BOLD = 700;
    public static final int WEIGHT_EXTRA_BLACK = 1000;
    public static final int WEIGHT_EXTRA_BOLD = 800;
    public static final int WEIGHT_EXTRA_LIGHT = 200;
    public static final int WEIGHT_INVISIBLE = 0;
    public static final int WEIGHT_LIGHT = 300;
    public static final int WEIGHT_MEDIUM = 500;
    public static final int WEIGHT_NORMAL = 400;
    public static final int WEIGHT_SEMI_BOLD = 600;
    public static final int WEIGHT_THIN = 100;
    public static final int WIDTH_CONDENSED = 3;
    public static final int WIDTH_EXPANDED = 7;
    public static final int WIDTH_EXTRA_CONDENSED = 2;
    public static final int WIDTH_EXTRA_EXPANDED = 8;
    public static final int WIDTH_NORMAL = 5;
    public static final int WIDTH_SEMI_CONDENSED = 4;
    public static final int WIDTH_SEMI_EXPANDED = 6;
    public static final int WIDTH_ULTRA_CONDENSED = 1;
    public static final int WIDTH_ULTRA_EXPANDED = 9;
    private int nFontStyleCode;

    public FontStyle Bold() {
        return new FontStyle(700, 5, 0);
    }

    public FontStyle BoldItalic() {
        return new FontStyle(700, 5, 1);
    }

    public FontStyle Italic() {
        return new FontStyle(400, 5, 1);
    }

    public FontStyle Normal() {
        return new FontStyle(400, 5, 0);
    }

    public int getSlant() {
        return (this.nFontStyleCode >> 24) & 255;
    }

    public int getWeight() {
        return this.nFontStyleCode & 65535;
    }

    public int getWidth() {
        return (this.nFontStyleCode >> 16) & 255;
    }

    public FontStyle() {
        this.nFontStyleCode = 328080;
    }

    public boolean isBold() {
        if (getWeight() < 600) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isItalic() {
        if (getSlant() == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public int getCode() {
        return this.nFontStyleCode;
    }

    public FontStyle(int r100) {
        this.nFontStyleCode = r100;
    }

    public FontStyle(int r100, int r101, int r102) {
        this.nFontStyleCode = (r100 + r101) << ((r102 << 24) + 16);
    }
}
