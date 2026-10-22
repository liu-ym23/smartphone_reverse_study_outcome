package com.autonavi.base.amap.mapcore.tools;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.TextPaint;
import com.amap.api.mapcore.util.w3;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes39.dex */
public class TextTextureGenerator {
    private static final int ALIGNCENTER = 51;
    private static final int ALIGNLEFT = 49;
    private static final int ALIGNRIGHT = 50;
    static final int AN_LABEL_MAXCHARINLINE = 7;
    static final int AN_LABEL_MULITYLINE_SPAN = 2;
    private int TEXT_FONTSIZE;
    private int TEXT_FONTSIZE_TRUE;
    private float base_line;
    private float start_x;
    private Paint text_paint;

    public static int GetNearstSize2N(int r100) {
        int r101 = 1;
    L3:
        if (r100 <= r101) goto L4;
        r101 = r101 * 2;
        goto L3
    L4:
        return r101;
    }

    private void createTextParam() {
        int r100 = this.TEXT_FONTSIZE - 2;
        this.TEXT_FONTSIZE_TRUE = r100;
        Paint r101 = newPaint(null, r100, 49);
        this.text_paint = r101;
        float r102 = (this.TEXT_FONTSIZE - this.TEXT_FONTSIZE_TRUE) / 2.0f;
        this.start_x = r102;
        Paint.FontMetrics r103 = r101.getFontMetrics();     // Catch: Exception -> L6
        float r104 = r103.descent;     // Catch: Exception -> L6
        float r105 = r103.ascent;     // Catch: Exception -> L10
    L8:
        this.base_line = (((this.TEXT_FONTSIZE_TRUE - (r104 + r105)) / 2.0f) + r102) + 0.5f;
        return;
    L7:
        r105 = -27.832031f;
    L6:
        r104 = 7.3242188f;
        goto L7
    }

    public TextTextureGenerator() {
        this.TEXT_FONTSIZE = -1;
        this.TEXT_FONTSIZE_TRUE = -1;
        this.base_line = 0.0f;
        this.start_x = 0.0f;
        this.text_paint = null;
        createTextParam();
    }

    public static float getFontHeight(Paint r100) {
        Paint.FontMetrics r101 = r100.getFontMetrics();
        return r101.descent - r101.ascent;
    }

    public byte[] getCharsWidths(int[] r100) {
        int r101 = r100.length;
        byte[] r102 = new byte[r101];
        int r103 = 0;
    L3:
        if (r103 >= r101) goto L5;
        r102[r103] = (byte) (this.text_paint.measureText(((char) r100[r103]) + "") + (this.TEXT_FONTSIZE - this.TEXT_FONTSIZE_TRUE));
        r103 = r103 + 1;
        goto L3
    L5:
        return r102;
    }

    public static float getFontlength(Paint r100, String r101) {
        return r100.measureText(r101);
    }

    public byte[] getTextPixelBuffer(int r110, int r111) {
        if (this.TEXT_FONTSIZE == r111) goto L21;
        this.TEXT_FONTSIZE = r111;
        createTextParam();
    L21:
        char r112 = (char) r110;     // Catch: Throwable -> L19
        char[] r100 = {r112};     // Catch: Throwable -> L19
        float r101 = this.base_line;     // Catch: Throwable -> L19
        int r102 = this.TEXT_FONTSIZE;     // Catch: Throwable -> L19
        Bitmap r103 = Bitmap.createBitmap(r102, r102, Bitmap.Config.ALPHA_8);     // Catch: Throwable -> L19
        Canvas r104 = new Canvas(r103);     // Catch: Throwable -> L19
        int r105 = this.TEXT_FONTSIZE;     // Catch: Throwable -> L19
        byte[] r106 = new byte[r105 * r105];     // Catch: Throwable -> L19
        ByteBuffer r107 = ByteBuffer.wrap(r106);     // Catch: Throwable -> L19
        float r113 = this.text_paint.measureText(String.valueOf(r112));     // Catch: Throwable -> L19
        char r114 = r100[0];     // Catch: Throwable -> L19
        if (r114 > 0) goto L9;
    L11:
        float r108 = r101;
        Paint.Align r115 = this.text_paint.getTextAlign();     // Catch: Throwable -> L19
        float r116 = this.text_paint.getTextSize();     // Catch: Throwable -> L19
        float r117 = r113 - this.TEXT_FONTSIZE_TRUE;     // Catch: Throwable -> L19
        Paint.Align r109 = Paint.Align.CENTER;     // Catch: Throwable -> L19
        if (r115 != r109) goto L14;
    L16:
        r104.drawText(r100, 0, 1, this.start_x, r108, this.text_paint);     // Catch: Throwable -> L19
    L17:
        r103.copyPixelsToBuffer(r107);     // Catch: Throwable -> L19
        w3.a(r103);     // Catch: Throwable -> L19
        return r106;
    L14:
        if (r117 < 4.0f) goto L16;
        this.text_paint.setTextAlign(r109);     // Catch: Throwable -> L19
        this.text_paint.setTextSize(this.TEXT_FONTSIZE_TRUE - r117);     // Catch: Throwable -> L19
        r104.drawText(r100, 0, 1, (this.TEXT_FONTSIZE_TRUE - r117) / 2.0f, r108, this.text_paint);     // Catch: Throwable -> L19
        this.text_paint.setTextAlign(r115);     // Catch: Throwable -> L19
        this.text_paint.setTextSize(r116);     // Catch: Throwable -> L19
        goto L17
    L9:
        if (r114 >= 256) goto L11;
        r101 = r101 - 1.5f;     // Catch: Throwable -> L19
    L19:
        return null;
    }

    private static Paint newPaint(String r100, int r101, int r102) {
        TextPaint r103 = new TextPaint();
        r103.setColor(-1);
        r103.setTextSize(r101);
        r103.setAntiAlias(true);
        r103.setFilterBitmap(true);
        r103.setTypeface(Typeface.DEFAULT_BOLD);
        switch(r102) {
            case 49: goto L7;
            case 50: goto L6;
            case 51: goto L5;
            default: goto L4;
        };
    L4:
        r103.setTextAlign(Paint.Align.LEFT);
    L8:
        return r103;
    L5:
        r103.setTextAlign(Paint.Align.CENTER);
        goto L8
    L6:
        r103.setTextAlign(Paint.Align.RIGHT);
        goto L8
    L7:
        r103.setTextAlign(Paint.Align.LEFT);
        goto L8
    }
}
