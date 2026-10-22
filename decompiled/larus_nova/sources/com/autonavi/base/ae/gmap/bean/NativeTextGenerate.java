package com.autonavi.base.ae.gmap.bean;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import com.amap.api.mapcore.util.b0;
import com.amap.api.mapcore.util.p3;
import com.amap.api.mapcore.util.w3;
import com.amap.api.maps.model.BitmapDescriptor;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.autonavi.base.amap.mapcore.FileUtil;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes39.dex */
public class NativeTextGenerate {
    private static volatile NativeTextGenerate instance;
    private float density;
    private final int kTextAlignmentCenter;
    private final int kTextAlignmentLeft;
    private final int kTextAlignmentRight;
    private final int kTextLayoutLeftToRight;
    private final int kTextLayoutUpToDown;
    private TextPaint text_paint_bitmap;
    private TextPaint text_paint_size;

    public static class TextGeneratePOIStyleDesc {
        int boldFont;
        int fontBgColor;
        int fontBorderColor;
        int fontColor;
        int fontSize;

        public TextGeneratePOIStyleDesc() {
            this.fontSize = 0;
            this.fontColor = 0;
            this.fontBorderColor = 0;
            this.fontBgColor = 0;
            this.boldFont = 0;
        }
    }

    public static class TextGenerateTextBitmap {
        byte[] data;
        public int dataId;
        int dataLength;
        double height;
        BitmapDescriptor imageData;
        String text;
        double width;

        public TextGenerateTextBitmap() {
        }
    }

    public static class TextGenerateTextStyle {
        int layoutDirection;
        int singleLineCharaterLimit;
        int textAlignment;

        public TextGenerateTextStyle() {
            this.singleLineCharaterLimit = 7;
            this.textAlignment = 0;
            this.layoutDirection = 0;
        }
    }

    public static NativeTextGenerate getInstance() {
        if (instance != null) goto L15;
        monitor-enter(NativeTextGenerate.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (instance != null) goto L9;
        instance = new NativeTextGenerate();     // Catch: Throwable -> L11
    L9:
        monitor-exit(NativeTextGenerate.class);     // Catch: Throwable -> L11
    L15:
        return instance;
    }

    private NativeTextGenerate() {
        this.text_paint_size = null;
        this.text_paint_bitmap = null;
        this.density = 1.0f;
        this.kTextLayoutLeftToRight = 0;
        this.kTextLayoutUpToDown = 1;
        this.kTextAlignmentCenter = 0;
        this.kTextAlignmentLeft = 1;
        this.kTextAlignmentRight = 2;
        this.text_paint_size = new TextPaint();
        this.text_paint_bitmap = new TextPaint();
    }

    public BitmapDescriptor getIconBitmap(String r100) {
        if (r100 != null) goto L12;
        return null;
    L12:
        String r101 = r100.concat("_");     // Catch: Throwable -> L9
        byte[] r102 = p3.a(b0.f27047f, AMapEngineUtils.MAP_ICONS_ASSETS_NAME, r101);     // Catch: Throwable -> L9
        if (r102 == null) goto L11;
        return BitmapDescriptorFactory.fromBitmap(BitmapFactory.decodeByteArray(r102, 0, r102.length));
    L11:
        return null;
    L9:
        th = move-exception;
        w3.a(th);
        goto L11
    }

    public byte[] getMapStyleFileData(String r100) {
        return FileUtil.uncompress(p3.a(b0.f27047f, AMapEngineUtils.MAP_MAP_ASSETS_NAME, r100));
    L4:
        th = move-exception;
        w3.a(th);
        return null;
    }

    public void setDensity(float r100) {
        this.density = r100;
    }

    public void calculateTextBoundSize(TextGenerateTextBitmap r100, TextGenerateTextStyle r101, TextGeneratePOIStyleDesc r102) {
        if (r100 == null) goto L8;
        if (r101 == null) goto L9;
        if (r102 == null) goto L10;
        StaticLayout r103 = setPaintStyle(this.text_paint_size, r100, r101, r102);
        float r104 = this.text_paint_size.measureText(r100.text);
        Paint.FontMetrics r105 = this.text_paint_size.getFontMetrics();
        r100.width = r104;
        r100.height = r105.descent - r105.ascent;
        r100.width = r103.getWidth();
        r100.height = r103.getHeight();
        return;
    L10:
        return;
    L9:
        return;
    }

    public void generateTextBitmap(TextGenerateTextBitmap r100, TextGenerateTextStyle r101, TextGeneratePOIStyleDesc r102) {
        if (r100 == null) goto L14;
        if (r101 == null) goto L15;
        if (r102 == null) goto L16;
        StaticLayout r103 = setPaintStyle(this.text_paint_bitmap, r100, r101, r102);
        Bitmap r104 = Bitmap.createBitmap((int) r100.width, (int) r100.height, Bitmap.Config.ARGB_8888);
        Canvas r105 = new Canvas(r104);
        int r106 = r101.textAlignment;
        if (r106 != 0) goto L10;
        r105.translate(((float) r100.width) / 2.0f, 0.0f);
    L12:
        r103.draw(r105);
        this.text_paint_bitmap.setStyle(Paint.Style.STROKE);
        this.text_paint_bitmap.setStrokeWidth(1.0f);
        this.text_paint_bitmap.setColor(r102.fontBorderColor);
        r103.draw(r105);
        int r107 = (int) ((r100.width * r100.height) * 4.0d);
        r100.dataLength = r107;
        r100.data = new byte[r107];
        r100.dataId = w3.a();
        r104.copyPixelsToBuffer(ByteBuffer.wrap(r100.data));
        return;
    L10:
        if (r106 != 2) goto L12;
        r105.translate((float) r100.width, 0.0f);
        goto L12
    L16:
        return;
    L15:
        return;
    }

    private StaticLayout setPaintStyle(TextPaint r110, TextGenerateTextBitmap r111, TextGenerateTextStyle r112, TextGeneratePOIStyleDesc r113) {
        if (r111 == null) goto L28;
        if (r112 == null) goto L30;
        if (r113 == null) goto L31;
        float r100 = r113.fontSize * 1.3f;
        r110.setColor(r113.fontColor);
        r110.setTextSize(r100);
        r110.setStyle(Paint.Style.FILL);
        int r101 = 1;
        r110.setAntiAlias(true);
        r110.setFilterBitmap(true);
        if (r113.boldFont != 1) goto L9;
        Typeface r114 = Typeface.DEFAULT_BOLD;
    L10:
        r110.setTypeface(r114);
        int r115 = r112.textAlignment;
        if (r115 != 0) goto L13;
        r110.setTextAlign(Paint.Align.CENTER);
    L17:
        int r116 = r111.text.length();
        int r117 = r112.singleLineCharaterLimit;
        if (r116 <= r117) goto L20;
    L21:
        int r118 = (r116 / r117) + 1;
        int r102 = r116 / r118;
        if ((r116 % r118) > 0) goto L25;
        r101 = 0;
    L25:
        r117 = r102 + r101;
    L27:
        return new StaticLayout(r111.text, r110, (int) (r100 * r117), Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
    L20:
        if ((r116 % r117) == 0) goto L27;
    L13:
        if (r115 == 2) goto L15;
        r110.setTextAlign(Paint.Align.LEFT);
        goto L17
    L15:
        r110.setTextAlign(Paint.Align.RIGHT);
        goto L17
    L9:
        r114 = Typeface.DEFAULT;
        goto L10
    L31:
        return null;
    L30:
        return null;
    L28:
        return null;
    }
}
