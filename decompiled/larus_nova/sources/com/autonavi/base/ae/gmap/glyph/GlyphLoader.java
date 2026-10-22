package com.autonavi.base.ae.gmap.glyph;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.os.Build;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.accessibility.AccessibilityManager;
import com.amap.api.mapcore.util.b0;
import com.autonavi.base.amap.mapcore.tools.GLConvertUtil;
import com.bytedance.sysoptimizer.TypeFaceLancet;
import com.bytedance.sysoptimizer.TypeFaceOptimizer;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes39.dex */
public class GlyphLoader {
    private static Map<String, Typeface> FontFaceMap;

    public static /* synthetic */ Typeface access$000(String r100) {
        return Typeface.createFromFile(r100);
    }

    private static native long nativeCreateGlyphLoader();

    private static native void nativeDestroyGlyphLoader(long r100);

    static {
        FontFaceMap = new HashMap();
    }

    public static long createGlyphLoader() {
        return nativeCreateGlyphLoader();
    }

    public GlyphLoader() {
    }

    public static Typeface INVOKESTATIC_com_autonavi_base_ae_gmap_glyph_GlyphLoader_com_bytedance_sysoptimizer_TypeFaceLancet_createFromFile(String r100) {
        if (TypeFaceOptimizer.getSwitch() == false) goto L14;
        if (r100 == null) goto L14;
        if (TypeFaceLancet.cache.contains(r100) == true) goto L8;
        Typeface r101 = access$000(r100);
        if (r101 == null) goto L14;
        TypeFaceLancet.cache.put(r100, r101);
        return r101;
    L8:
        return (Typeface) TypeFaceLancet.cache.get(r100);
    L14:
        return access$000(r100);
    }

    private static String decodeUnicode(short r100) {
        StringBuffer r101 = new StringBuffer();
        r101.append((char) r100);
        return r101.toString();
    }

    public static void destroyGlyphLoader(long r100) {
        nativeDestroyGlyphLoader(r100);
    }

    private static FontMetricsRequestParam genFontMetricsParam(byte[] r100) {
        FontMetricsRequestParam r101 = new FontMetricsRequestParam();
        r101.fFontSize = GLConvertUtil.getInt(r100, 0) * 0.001f;
        r101.nFontStyleCode = GLConvertUtil.getInt(r100, 4);
        int r102 = 12;
        if (1 != GLConvertUtil.getInt(r100, 8)) goto L5;
        int r103 = GLConvertUtil.getInt(r100, 12);
        r101.strName = new String(r100, 16, r103);
        r102 = 16 + r103;
    L5:
        r101.languageArr = new String(r100, r102 + 4, GLConvertUtil.getInt(r100, r102));
        return r101;
    }

    private static GlyphRequestParam genGlyphRequestParam(byte[] r100) {
        GlyphRequestParam r101 = new GlyphRequestParam();
        int r102 = GLConvertUtil.getInt(r100, 0);
        r101.strBuffer = new String(r100, 4, r102);
        int r103 = r102 + 4;
        Font r104 = new Font();
        r104.nFontStyleCode = GLConvertUtil.getInt(r100, r103);
        int r105 = r103 + 4;
        r104.nFontSize = GLConvertUtil.getInt(r100, r105);
        int r106 = r105 + 4;
        int r107 = GLConvertUtil.getInt(r100, r106);
        int r108 = r106 + 4;
        r104.strName = new String(r100, r108, r107);
        int r109 = r108 + r107;
        FontMetrics r110 = new FontMetrics();
        int r111 = GLConvertUtil.getInt(r100, r109);
        int r112 = r109 + 4;
        r110.fAscent = r111 * 0.001f;
        int r113 = GLConvertUtil.getInt(r100, r112);
        int r114 = r112 + 4;
        r110.fDescent = r113 * 0.001f;
        int r115 = GLConvertUtil.getInt(r100, r114);
        int r116 = r114 + 4;
        r110.fLeading = r115 * 0.001f;
        int r117 = GLConvertUtil.getInt(r100, r116);
        int r118 = r116 + 4;
        r110.fHeight = r117 * 0.001f;
        r104.fontMetrics = r110;
        r101.font = r104;
        r101.drawingMode = GLConvertUtil.getInt(r100, r118);
        int r119 = r118 + 4;
        int r120 = GLConvertUtil.getInt(r100, r119);
        int r121 = r119 + 4;
        r101.strokeWidth = r120 * 0.001f;
        int r122 = GLConvertUtil.getInt(r100, r121);
        int r123 = r121 + 4;
        r101.languageArr = new String(r100, r123, r122);
        r101.isEmoji = GLConvertUtil.getInt(r100, r123);
        int r124 = r123 + 4;
        r101.isSDF = GLConvertUtil.getInt(r100, r124);
        int r125 = r124 + 4;
        int r126 = GLConvertUtil.getInt(r100, r125);
        int r127 = r125 + 4;
        if (1 != r126) goto L5;
        GlyphMetrics r128 = new GlyphMetrics();
        r128.nWidth = GLConvertUtil.getInt(r100, r127);
        int r129 = r127 + 4;
        r128.nHeight = GLConvertUtil.getInt(r100, r129);
        int r130 = r129 + 4;
        int r131 = GLConvertUtil.getInt(r100, r130);
        int r132 = r130 + 4;
        r128.fLeft = r131 * 0.001f;
        r128.fTop = GLConvertUtil.getInt(r100, r132) * 0.001f;
        r128.fAdvance = GLConvertUtil.getInt(r100, r132 + 4) * 0.001f;
        r101.fGlyphMetrics = r128;
    L5:
        return r101;
    }

    private static FontMetrics getFontMetrics(byte[] r100) {
        FontMetricsRequestParam r101 = genFontMetricsParam(r100);
        TextPaint r102 = newTextPaint(new FontStyle(r101.nFontStyleCode), r101.fFontSize, r101.strName, false, 0.0f);
        Paint.FontMetrics r103 = r102.getFontMetrics();
        FontMetrics r104 = new FontMetrics();
        r104.bSuccess = true;
        r104.fAscent = Math.abs(r103.ascent);
        r104.fDescent = Math.abs(r103.descent);
        r104.fLeading = Math.abs(r103.leading);
        r104.fHeight = Math.abs(r103.ascent) + Math.abs(r103.descent);
        r102.setTypeface(null);
        return r104;
    }

    private static GlyphMetrics getGlyphMetrics(byte[] r100) {
        GlyphRequestParam r101 = genGlyphRequestParam(r100);
        FontStyle r102 = new FontStyle(r101.font.nFontStyleCode);
        if (r101.drawingMode == 0) goto L5;
        boolean r103 = true;
    L6:
        String r104 = r101.strBuffer;
        Font r105 = r101.font;
        float r106 = r105.nFontSize;
        String r107 = r105.strName;
        float r108 = r101.strokeWidth;
        if (r101.isEmoji <= 0) goto L9;
        boolean r109 = true;
    L11:
        if (r101.isSDF <= 0) goto L13;
        boolean r110 = true;
    L15:
        return loadGlyphMetrics(r104, r102, r106, r107, r103, r108, r109, r110);
    L13:
        r110 = false;
        goto L15
    L9:
        r109 = false;
        goto L11
    L5:
        r103 = false;
        goto L6
    }

    private static GlyphRaster getGlyphRaster(byte[] r100) {
        GlyphRequestParam r101 = genGlyphRequestParam(r100);
        FontStyle r102 = new FontStyle(r101.font.nFontStyleCode);
        int r103 = r101.drawingMode;
        if (r103 == 0) goto L5;
        boolean r104 = true;
    L7:
        if (r103 != 3) goto L10;
        String r105 = r101.strBuffer;
        Font r106 = r101.font;
        return loadPathRaster(r105, r102, r106.nFontSize, r106.strName, r104, r101.strokeWidth * 2.0f);
    L10:
        String r107 = r101.strBuffer;
        Font r108 = r101.font;
        float r109 = r108.nFontSize;
        String r110 = r108.strName;
        float r111 = r101.strokeWidth;
        if (r101.isEmoji <= 0) goto L13;
        boolean r112 = true;
    L15:
        if (r101.isSDF <= 0) goto L17;
        boolean r113 = true;
    L19:
        return loadGlyphRaster(r107, r102, r109, r110, r104, r111, r112, r113);
    L17:
        r113 = false;
        goto L19
    L13:
        r112 = false;
        goto L15
    L5:
        r104 = false;
        goto L7
    }

    private static String decodeUnicode(String r100) {
        StringBuffer r101 = new StringBuffer();
        r101.append(r100);
        return r101.toString();
    }

    private static TextPaint newTextPaint(FontStyle r100, float r101, String r102, boolean r103, float r104) {
        TextPaint r105 = new TextPaint();
        if (r100 != null) goto L5;
        return r105;
    L5:
        r105.setColor(-1);
        boolean r106 = true;
        r105.setAntiAlias(true);
        r105.setFilterBitmap(true);
        r105.setTextSize(r101);
        r105.setTextAlign(Paint.Align.LEFT);
        if (r103 == false) goto L8;
        r105.setStyle(Paint.Style.STROKE);
        r105.setStrokeWidth(r104);
    L9:
        int r107 = r100.getSlant();
        int r108 = 2;
        if (r107 == 0) goto L15;
        if (r107 == 1) goto L14;
        if (r107 != 2) goto L15;
    L14:
        boolean r109 = true;
    L16:
        int r110 = r100.getWeight();
        if (r110 != 500) goto L19;
    L29:
        boolean r111 = true;
    L30:
        if (r111 == false) goto L33;
        if (r109 == false) goto L33;
        r105.setFakeBoldText(true);
    L37:
        r108 = 0;
    L65:
        if (Build.VERSION.SDK_INT < 23) goto L44;
        r106 = false;
    L44:
        if (r102.isEmpty() == true) goto L58;
        if (r106 == true) goto L58;
        Map<String, Typeface> r112 = FontFaceMap;     // Catch: Exception -> L57
        monitor-enter(r112);     // Catch: Exception -> L57
        Typeface r113 = FontFaceMap.get(r102);     // Catch: Throwable -> L54
        if (r113 != null) goto L52;
        r113 = INVOKESTATIC_com_autonavi_base_ae_gmap_glyph_GlyphLoader_com_bytedance_sysoptimizer_TypeFaceLancet_createFromFile(r102);     // Catch: Throwable -> L54
        FontFaceMap.put(r102, r113);     // Catch: Throwable -> L54
    L52:
        monitor-exit(r112);     // Catch: Throwable -> L54
    L59:
        r105.setTypeface(r113);
        return r105;
    L54:
        th = move-exception;
        throw th;     // Catch: Exception -> L57
    L57:
        r113 = Typeface.create(Typeface.DEFAULT, r108);
    L58:
        r113 = Typeface.create(Typeface.DEFAULT, r108);
    L33:
        if (r111 == false) goto L35;
        r105.setFakeBoldText(true);
        goto L37
    L35:
        if (r109 == false) goto L37;
    L19:
        if (r110 == 600) goto L29;
        if (r110 == 700) goto L29;
        if (r110 == 800) goto L29;
        if (r110 == 900) goto L29;
        if (r110 == 1000) goto L29;
        r111 = false;
    L15:
        r109 = false;
        goto L16
    L8:
        r105.setStyle(Paint.Style.FILL);
        goto L9
    }

    public static GlyphRaster loadPathRaster(String r110, FontStyle r111, float r112, String r113, boolean r114, float r210) {
        GlyphRaster r100 = new GlyphRaster();
        if (r111 != null) goto L6;
        return r100;
    L6:
        if (TextUtils.isEmpty(r110) == false) goto L21;
        return r100;
    L21:
        TextPaint r101 = newTextPaint(r111, r112, r113, false, 0.0f);     // Catch: Exception -> L19
        Rect r102 = new Rect();     // Catch: Exception -> L19
        r101.getTextBounds(r110, 0, r110.length(), r102);     // Catch: Exception -> L19
        new Canvas(Bitmap.createBitmap(r102.width(), r102.height(), Bitmap.Config.ALPHA_8)).drawText(r110, 0 - r102.left, 0 - r102.top, r101);     // Catch: Exception -> L19
        TextPaint r115 = newTextPaint(r111, r112, r113, r114, r210);     // Catch: Exception -> L19
        Rect r116 = new Rect();     // Catch: Exception -> L19
        r115.getTextBounds(r110, 0, r110.length(), r116);     // Catch: Exception -> L19
        if (r114 == false) goto L15;
        if (r210 <= 0.0f) goto L15;
        float r103 = 0.5f * r210;     // Catch: Exception -> L19
        r116.top = (int) (r116.top - r103);     // Catch: Exception -> L19
        r116.left = (int) (r116.left - r103);     // Catch: Exception -> L19
        r116.right = (int) (r116.right + r103);     // Catch: Exception -> L19
        r116.bottom = (int) (r116.bottom + r103);     // Catch: Exception -> L19
    L15:
        if (r116.isEmpty() == true) goto L17;
        Bitmap r117 = Bitmap.createBitmap(r116.width(), r116.height(), Bitmap.Config.ALPHA_8);     // Catch: Exception -> L19
        Canvas r118 = new Canvas(r117);     // Catch: Exception -> L19
        float r104 = 0 - r116.left;     // Catch: Exception -> L19
        float r105 = 0 - r116.top;     // Catch: Exception -> L19
        Path r119 = new Path();     // Catch: Exception -> L19
        r101.getTextPath(r110, 0, r110.length(), r104, r105, r119);     // Catch: Exception -> L19
        r118.drawPath(r119, r115);     // Catch: Exception -> L19
        int r106 = r116.width() * r116.height();     // Catch: Exception -> L19
        byte[] r107 = new byte[r106];     // Catch: Exception -> L19
        ByteBuffer r108 = ByteBuffer.wrap(r107);     // Catch: Exception -> L19
        r100.bitmapWidth = r116.width();     // Catch: Exception -> L19
        r100.bitmapHeight = r116.height();     // Catch: Exception -> L19
        r100.bitmapPixelMode = 0;     // Catch: Exception -> L19
        r100.bitmapSize = r106;     // Catch: Exception -> L19
        r117.copyPixelsToBuffer(r108);     // Catch: Exception -> L19
        r117.recycle();     // Catch: Exception -> L19
        r100.bitmapBuffer = r107;     // Catch: Exception -> L19
        r100.bSuccess = true;     // Catch: Exception -> L19
    L17:
        r101.setTypeface(null);     // Catch: Exception -> L19
        r115.setTypeface(null);     // Catch: Exception -> L19
    L20:
        return r100;
    L19:
        r100.bSuccess = false;
        goto L20
    }

    private static GlyphMetrics loadGlyphMetrics(String r100, FontStyle r101, float r102, String r103, boolean r104, float r105, boolean r110, boolean r111) {
        GlyphMetrics r112 = new GlyphMetrics();
        if (r101 != null) goto L6;
        return r112;
    L6:
        if (TextUtils.isEmpty(r100) == false) goto L24;
        return r112;
    L24:
        if (r110 == true) goto L20;
        TextPaint r106 = newTextPaint(r101, r102, r103, r104, r105);     // Catch: Exception -> L22
        Rect r107 = new Rect();     // Catch: Exception -> L22
        r106.getTextBounds(r100, 0, r100.length(), r107);     // Catch: Exception -> L22
        if (r107.width() == 0) goto L13;
    L15:
        if (r104 == true) goto L17;
    L19:
        r112.bSuccess = true;     // Catch: Exception -> L22
        r112.fLeft = r107.left;     // Catch: Exception -> L22
        r112.fTop = Math.abs(r106.getFontMetrics().ascent) - Math.abs(r107.top);     // Catch: Exception -> L22
        r112.nWidth = r107.width();     // Catch: Exception -> L22
        r112.nHeight = r107.height();     // Catch: Exception -> L22
        r112.fAdvance = r106.measureText(r100);     // Catch: Exception -> L22
        r106.setTypeface(null);     // Catch: Exception -> L22
    L23:
        return r112;
    L17:
        if (r105 <= 0.0f) goto L19;
        float r108 = r105 / 2.0f;     // Catch: Exception -> L22
        r107.top = (int) (r107.top - r108);     // Catch: Exception -> L22
        r107.left = (int) (r107.left - r108);     // Catch: Exception -> L22
        r107.right = (int) (r107.right + r108);     // Catch: Exception -> L22
        r107.bottom = (int) (r107.bottom + r108);     // Catch: Exception -> L22
        goto L19
    L13:
        if (r107.height() != 0) goto L15;
        float r109 = r106.measureText(" ", 0, 1);     // Catch: Exception -> L22
        float r113 = Math.abs(r106.getFontMetrics().ascent) + Math.abs(r106.getFontMetrics().descent);     // Catch: Exception -> L22
        r107.top = 0;     // Catch: Exception -> L22
        r107.left = 0;     // Catch: Exception -> L22
        r107.right = (int) r109;     // Catch: Exception -> L22
        r107.bottom = (int) r113;     // Catch: Exception -> L22
        goto L15
    L20:
        r112.bSuccess = true;     // Catch: Exception -> L22
        r112.fLeft = 0.0f;     // Catch: Exception -> L22
        r112.fTop = 0.0f;     // Catch: Exception -> L22
        int r114 = (int) r102;     // Catch: Exception -> L22
        r112.nWidth = r114;     // Catch: Exception -> L22
        r112.nHeight = r114;     // Catch: Exception -> L22
        r112.fAdvance = r102;     // Catch: Exception -> L22
    L22:
        r112.bSuccess = false;
        goto L23
    }

    private static GlyphRaster loadGlyphRaster(String r100, FontStyle r101, float r110, String r111, boolean r112, float r113, boolean r114, boolean r115) {
        GlyphRaster r102 = new GlyphRaster();
        if (r101 != null) goto L6;
        return r102;
    L6:
        if (TextUtils.isEmpty(r100) == false) goto L61;
        return r102;
    L61:
        Context r103 = b0.f27047f;     // Catch: Throwable -> L19
        if (r103 == null) goto L21;
        AccessibilityManager r104 = (AccessibilityManager) r103.getApplicationContext().getSystemService("accessibility");     // Catch: Throwable -> L19
        if (Build.VERSION.SDK_INT >= 36) goto L15;
        Boolean r105 = (Boolean) ReflectUtil.invoke("android.view.accessibility.AccessibilityManager", r104, "isHighTextContrastEnabled", null);     // Catch: Throwable -> L19
    L16:
        if (r105 == null) goto L21;
        boolean r106 = r105.booleanValue();     // Catch: Throwable -> L19
    L63:
        TextPaint r107 = newTextPaint(r101, r110, r111, r112, r113);     // Catch: Exception -> L59
        Rect r116 = new Rect();     // Catch: Exception -> L59
        r107.getTextBounds(r100, 0, r100.length(), r116);     // Catch: Exception -> L59
        if (r116.width() == 0) goto L25;
    L27:
        if (r112 == false) goto L32;
        if (r113 <= 0.0f) goto L32;
        float r117 = r113 / 2.0f;     // Catch: Exception -> L59
        r116.top = (int) (r116.top - r117);     // Catch: Exception -> L59
        r116.left = (int) (r116.left - r117);     // Catch: Exception -> L59
        r116.right = (int) (r116.right + r117);     // Catch: Exception -> L59
        r116.bottom = (int) (r116.bottom + r117);     // Catch: Exception -> L59
    L32:
        if (r116.isEmpty() == true) goto L57;
        Bitmap.Config r118 = Bitmap.Config.ALPHA_8;     // Catch: Exception -> L59
        if (r114 == true) goto L38;
        if (r106 == true) goto L38;
        int r119 = 1;
    L39:
        if (r115 == false) goto L41;
        int r120 = 3;
    L42:
        int r108 = r120 * 2;     // Catch: Exception -> L59
        Bitmap r121 = Bitmap.createBitmap(r116.width() + r108, r116.height() + r108, r118);     // Catch: Exception -> L59
        new Canvas(r121).drawText(r100, (0 - r116.left) + r120, (0 - r116.top) + r120, r107);     // Catch: Exception -> L59
        int r109 = r116.width() + r108;     // Catch: Exception -> L59
        int r122 = r116.height() + r108;     // Catch: Exception -> L59
        int r123 = r109 * r122;     // Catch: Exception -> L59
        byte[] r124 = new byte[r123 * r119];     // Catch: Exception -> L59
        r121.copyPixelsToBuffer(ByteBuffer.wrap(r124));     // Catch: Exception -> L59
        if (r106 == false) goto L52;
        byte[] r125 = new byte[r123];     // Catch: Exception -> L59
        int r126 = 0;
    L45:
        if (r126 >= r122) goto L51;
        int r127 = 0;
    L48:
        if (r127 >= (r109 * r119)) goto L50;
        int r128 = r126 * r109;     // Catch: Exception -> L59
        r125[(r127 / r119) + r128] = r124[(r128 * r119) + r127];     // Catch: Exception -> L59
        r127 = r127 + r119;     // Catch: Exception -> L59
        goto L48
    L50:
        r126 = r126 + 1;     // Catch: Exception -> L59
        goto L45
    L51:
        r124 = r125;
    L52:
        r102.bitmapWidth = r109;     // Catch: Exception -> L59
        r102.bitmapHeight = r122;     // Catch: Exception -> L59
        if (r114 == false) goto L55;
        r102.bitmapPixelMode = 1;     // Catch: Exception -> L59
    L56:
        r102.bitmapSize = r124.length;     // Catch: Exception -> L59
        r102.bitmapBuffer = r124;     // Catch: Exception -> L59
        r121.recycle();     // Catch: Exception -> L59
        r102.bSuccess = true;     // Catch: Exception -> L59
        goto L57
    L55:
        r102.bitmapPixelMode = 0;     // Catch: Exception -> L59
        goto L56
    L41:
        r120 = 0;
    L38:
        r118 = Bitmap.Config.ARGB_8888;     // Catch: Exception -> L59
        r119 = 4;
    L57:
        r107.setTypeface(null);     // Catch: Exception -> L59
    L60:
        return r102;
    L25:
        if (r116.height() != 0) goto L27;
        float r129 = r107.measureText(" ", 0, 1);     // Catch: Exception -> L59
        float r130 = Math.abs(r107.getFontMetrics().ascent) + Math.abs(r107.getFontMetrics().descent);     // Catch: Exception -> L59
        r116.right = (int) r129;     // Catch: Exception -> L59
        r116.bottom = (int) r130;     // Catch: Exception -> L59
        r116.left = 0;     // Catch: Exception -> L59
        r116.top = 0;     // Catch: Exception -> L59
    L59:
        r102.bSuccess = false;
        goto L60
    L15:
        r105 = (Boolean) ReflectUtil.invoke("android.view.accessibility.AccessibilityManager", r104, "isHighContrastTextEnabled", null);     // Catch: Throwable -> L19
    L21:
        r106 = false;
    L19:
        th = move-exception;
        th.toString();
        goto L21
    }
}
