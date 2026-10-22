package com.baidu.vi;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Build;
import android.text.Layout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.SparseArray;
import java.nio.IntBuffer;

/* JADX INFO: loaded from: classes39.dex */
public class EnvDrawText {
    private static final String DEVICE_VIVOX3L = "vivo X3L";
    private static final int FONT_STYLE_BOLD = 1;
    private static final int FONT_STYLE_ITALIC = 2;
    private static final int FONT_STYLE_NORMAL = 0;
    private static Bitmap defaultFontBmp;
    public static SparseArray<a> fontCache;
    private static Context mContext;
    private static String phonetype;

    private static native boolean nativeIsBitmapSame(Bitmap r100, Bitmap r101);

    private static Bitmap getTextBitmap() {
        Paint r100 = new Paint();
        r100.setSubpixelText(true);
        r100.setAntiAlias(false);
        r100.setTextSize(12.0f);
        r100.setTypeface(Typeface.DEFAULT);
        float r101 = r100.measureText("!");
        float r102 = r100.descent() - r100.ascent();
        if (r101 > 0.0f) goto L6;
        r101 = 3.0f;
    L6:
        if (r102 > 0.0f) goto L8;
        r102 = 15.0f;
    L8:
        Bitmap r103 = Bitmap.createBitmap((int) Math.ceil(r101), (int) Math.ceil(r102), Bitmap.Config.ALPHA_8);
        r103.eraseColor(0);
        Canvas r104 = new Canvas();
        r104.setBitmap(r103);
        r104.drawText("!", 0.0f, 0.0f - r100.ascent(), r100);
        return r103;
    }

    private static synchronized boolean isSystemFontChanged() {
        monitor-enter(EnvDrawText.class);
    L17:
        th = move-exception;
        throw th;
    L5:
        if (defaultFontBmp != null) goto L9;
        defaultFontBmp = getTextBitmap();     // Catch: Throwable -> L17
        monitor-exit(EnvDrawText.class);
        return false;
    L9:
        Bitmap r100 = getTextBitmap();     // Catch: Throwable -> L17
        if ((!nativeIsBitmapSame(r100, defaultFontBmp)) == false) goto L14;
        defaultFontBmp.recycle();     // Catch: Throwable -> L17
        defaultFontBmp = Bitmap.createBitmap(r100);     // Catch: Throwable -> L17
        r100.recycle();     // Catch: Throwable -> L17
        monitor-exit(EnvDrawText.class);
        return true;
    L14:
        r100.recycle();     // Catch: Throwable -> L17
        monitor-exit(EnvDrawText.class);
        return false;
    }

    public EnvDrawText() {
    }

    private static Paint.Align getTextAlignedType(int r100) {
        if (1 != r100) goto L7;
        return Paint.Align.LEFT;
    L7:
        if (2 != r100) goto L11;
        return Paint.Align.RIGHT;
    L11:
        return Paint.Align.CENTER;
    }

    private static Typeface getTypeface(int r100) {
        Typeface r101 = Typeface.DEFAULT;
        if (r100 == 1) goto L9;
        if (r100 == 2) goto L10;
        return r101;
    L10:
        return Typeface.create(r101, 2);
    L9:
        return Typeface.DEFAULT_BOLD;
    }

    public static synchronized void removeFontCache(int r100) {
        monitor-enter(EnvDrawText.class);
        a r101 = fontCache.get(r100);     // Catch: Throwable -> L13
        if (r101 != null) goto L8;
        monitor-exit(EnvDrawText.class);
        return;
    L8:
        int r102 = r101.f33586b - 1;     // Catch: Throwable -> L13
        r101.f33586b = r102;     // Catch: Throwable -> L13
        if (r102 != 0) goto L11;
        fontCache.remove(r100);     // Catch: Throwable -> L13
    L11:
        monitor-exit(EnvDrawText.class);
        return;
    L13:
        th = move-exception;
        throw th;
    }

    public static void setContext(Context r100) {
        mContext = r100;
    }

    public static synchronized void registFontCache(int r100, Typeface r101) {
        monitor-enter(EnvDrawText.class);
        if (r100 == 0) goto L19;
        if (r101 == null) goto L19;
    L16:
        th = move-exception;
        throw th;
    L8:
        if (fontCache != null) goto L10;
        fontCache = new SparseArray();     // Catch: Throwable -> L16
    L10:
        a r102 = fontCache.get(r100);     // Catch: Throwable -> L16
        if (r102 != null) goto L13;
        a r103 = new a();     // Catch: Throwable -> L16
        r103.f33585a = r101;     // Catch: Throwable -> L16
        r103.f33586b++;     // Catch: Throwable -> L16
        fontCache.put(r100, r103);     // Catch: Throwable -> L16
    L14:
        monitor-exit(EnvDrawText.class);
        return;
    L13:
        r102.f33586b++;     // Catch: Throwable -> L16
    L19:
        monitor-exit(EnvDrawText.class);
    }

    private static short[] getTextSize(String r100, int r101, int r110) {
        int r102 = r100.length();
        if (r102 != 0) goto L6;
        return null;
    L6:
        TextPaint r103 = new TextPaint();
        r103.setSubpixelText(true);
        r103.setAntiAlias(true);
        r103.setTextSize(r101);
        r103.setTypeface(getTypeface(r110));
        short[] r104 = new short[r102];
        int r105 = 0;
    L7:
        if (r105 >= r102) goto L9;
        int r106 = r105 + 1;
        r104[r105] = (short) (((double) Layout.getDesiredWidth(r100, 0, r106, r103)) + 0.5d);
        r105 = r106;
        goto L7
    L9:
        return r104;
    }

    private static float[] getTextSizeExt(String r100, int r101, int r102) {
        if (r100.length() != 0) goto L6;
        return null;
    L6:
        Paint r103 = new Paint();
        r103.setSubpixelText(true);
        r103.setAntiAlias(true);
        r103.setTextSize(r101);
        r103.setTypeface(getTypeface(r102));
        return new float[]{r103.measureText(r100), r103.descent() - r103.ascent()};
    }

    private static Bitmap drawTextAlpha(String r110, int r111, int r112, int r113) {
        Canvas r100 = new Canvas();
        TextPaint r101 = new TextPaint();
        if (TextUtils.isEmpty(phonetype) == false) goto L5;
        phonetype = Build.MODEL;
    L5:
        String r102 = phonetype;
        int r103 = 0;
        if (r102 != null) goto L8;
    L10:
        int r104 = r112;
    L11:
        r101.reset();
        r101.setSubpixelText(false);
        r101.setAntiAlias(false);
        r101.setTextSize(r111);
        r101.setTypeface(getTypeface(r104));
        float r105 = (r113 * 1.3f) + 0.5f;
        int r106 = 92;
        int r107 = r110.indexOf(92, 0);
        Bitmap r114 = null;
        if (r107 != (-1)) goto L21;
        Paint.FontMetrics r108 = r101.getFontMetrics();
        int r109 = (int) (Layout.getDesiredWidth(r110, 0, r110.length(), r101) + r105);
        int r115 = (int) Math.ceil(r108.descent - r108.ascent);
        if (r109 <= 0) goto L20;
        if (r115 <= 0) goto L20;
        r114 = Bitmap.createBitmap(r109, r115, Bitmap.Config.ALPHA_8);
        if (r114 != null) goto L19;
        return r114;
    L19:
        r114.eraseColor(0);
        r100.setBitmap(r114);
    L20:
        r101.setStyle(Paint.Style.FILL);
        r100.drawText(r110, r105 * 0.5f, 0.0f - r108.ascent, r101);
    L47:
        return r114;
    L21:
        int r116 = r107 + 1;
        int r117 = (int) (((double) Layout.getDesiredWidth(r110.substring(0, r107), r101)) + 0.5d);
        int r118 = 2;
    L22:
        int r119 = r110.indexOf(r106, r116);
        if (r119 <= 0) goto L29;
        int r120 = (int) (((double) Layout.getDesiredWidth(r110.substring(r116, r119), r101)) + 0.5d);
        if (r120 <= r117) goto L27;
        r117 = r120;
    L27:
        r116 = r119 + 1;
        r118 = r118 + 1;
        r106 = 92;
        goto L22
    L29:
        if (r116 == r110.length()) goto L33;
        int r121 = (int) (((double) Layout.getDesiredWidth(r110.substring(r116, r110.length()), r101)) + 0.5d);
        if (r121 <= r117) goto L33;
        r117 = r121;
    L33:
        Paint.FontMetrics r122 = r101.getFontMetrics();
        int r123 = (int) Math.ceil(r122.descent - r122.ascent);
        int r124 = r117 + r113;
        int r125 = r118 * r123;
        if (r124 <= 0) goto L40;
        if (r125 <= 0) goto L40;
        r114 = Bitmap.createBitmap(r124, r125, Bitmap.Config.ALPHA_8);
        if (r114 != null) goto L39;
        return r114;
    L39:
        r114.eraseColor(0);
        r100.setBitmap(r114);
    L40:
        r101.setTextAlign(getTextAlignedType(3));
        float r126 = r124 - (r105 * 0.5f);
        int r127 = 0;
    L41:
        int r128 = r110.indexOf(92, r103);
        if (r128 <= 0) goto L45;
        String r129 = r110.substring(r103, r128);
        Layout.getDesiredWidth(r129, r101);
        r101.setStyle(Paint.Style.FILL);
        r100.drawText(r129, r126, (r127 * r123) - r122.ascent, r101);
        r127 = r127 + 1;
        r103 = r128 + 1;
        goto L41
    L45:
        if (r103 == r110.length()) goto L47;
        String r130 = r110.substring(r103, r110.length());
        Layout.getDesiredWidth(r130, r101);
        r101.setStyle(Paint.Style.FILL);
        r100.drawText(r130, r126, (r127 * r123) - r122.ascent, r101);
        goto L47
    L8:
        if (r102.equals(DEVICE_VIVOX3L) == false) goto L10;
        r104 = 0;
        goto L11
    }

    private static short[] getTextSizeWithHalo(String r100, int r101, int r102, int r110) {
        int r103 = r100.length();
        if (r103 != 0) goto L6;
        return null;
    L6:
        TextPaint r104 = new TextPaint();
        r104.setSubpixelText(true);
        r104.setAntiAlias(true);
        r104.setTextSize(r101);
        r104.setTypeface(getTypeface(r102));
        if (r110 == 0) goto L9;
        r104.setStrokeWidth(r110);
        r104.setStrokeCap(Paint.Cap.ROUND);
        r104.setStrokeJoin(Paint.Join.ROUND);
        r104.setStyle(Paint.Style.STROKE);
    L9:
        short[] r105 = new short[r103];
        int r111 = 0;
    L10:
        if (r111 >= r103) goto L12;
        int r106 = r111 + 1;
        r105[r111] = (short) (((double) Layout.getDesiredWidth(r100, 0, r106, r104)) + 0.5d);
        r111 = r106;
        goto L10
    L12:
        return r105;
    }

    private static synchronized int[] drawText(String r210, int r211, int r212, int[] r213, int r214, int r215, int r216, int r310, int r311) {
        monitor-enter(EnvDrawText.class);
        Canvas r100 = new Canvas();     // Catch: Throwable -> L111
        TextPaint r101 = new TextPaint();     // Catch: Throwable -> L111
        if (TextUtils.isEmpty(phonetype) == false) goto L7;
        phonetype = Build.MODEL;     // Catch: Throwable -> L111
    L7:
        String r110 = phonetype;     // Catch: Throwable -> L111
        if (r110 != null) goto L10;
    L12:
        int r111 = r212;
    L13:
        r101.reset();     // Catch: Throwable -> L111
        r101.setSubpixelText(true);     // Catch: Throwable -> L111
        r101.setAntiAlias(true);     // Catch: Throwable -> L111
        r101.setTextSize(r211);     // Catch: Throwable -> L111
        r101.setShadowLayer(0.0f, 0.0f, 0.0f, 0);     // Catch: Throwable -> L111
        r101.setTypeface(getTypeface(r111));     // Catch: Throwable -> L111
        if (r310 == 0) goto L16;
        r101.setStrokeWidth(r310);     // Catch: Throwable -> L111
        r101.setStrokeCap(Paint.Cap.ROUND);     // Catch: Throwable -> L111
        r101.setStrokeJoin(Paint.Join.ROUND);     // Catch: Throwable -> L111
        r101.setStyle(Paint.Style.STROKE);     // Catch: Throwable -> L111
    L16:
        int r112 = r210.indexOf(92, 0);     // Catch: Throwable -> L111
        Bitmap r217 = null;
        if (r112 != (-1)) goto L44;
        Paint.FontMetrics r102 = r101.getFontMetrics();     // Catch: Throwable -> L111
        int r113 = (int) (((double) Layout.getDesiredWidth(r210, 0, r210.length(), r101)) + 0.5d);     // Catch: Throwable -> L111
        int r114 = (int) Math.ceil(r102.descent - r102.ascent);     // Catch: Throwable -> L111
        r213[0] = r113;     // Catch: Throwable -> L111
        r213[1] = r114;     // Catch: Throwable -> L111
        if (r213.length != 4) goto L21;
        int r115 = (int) Math.pow(2.0d, (int) Math.ceil(Math.log(r113) / Math.log(2.0d)));     // Catch: Throwable -> L111
        r114 = (int) Math.pow(2.0d, (int) Math.ceil(Math.log(r114) / Math.log(2.0d)));     // Catch: Throwable -> L111
        r113 = r115;
    L21:
        if (r113 != 0) goto L26;
        if (r114 != 0) goto L26;
        r114 = 0;
        r113 = 0;
    L26:
        if (r213.length != 4) goto L28;
        r213[2] = r113;     // Catch: Throwable -> L111
        r213[3] = r114;     // Catch: Throwable -> L111
    L28:
        if (r113 <= 0) goto L37;
        if (r114 <= 0) goto L37;
        Bitmap r103 = Bitmap.createBitmap(r113, r114, Bitmap.Config.ARGB_8888);     // Catch: Throwable -> L111
        if (r103 != null) goto L35;
        int[] r104 = new int[0];     // Catch: Throwable -> L111
        monitor-exit(EnvDrawText.class);
        return r104;
    L35:
        r100.setBitmap(r103);     // Catch: Throwable -> L111
        r217 = r103;
    L37:
        if ((r216 & (-16777216)) != 0) goto L39;
        r100.drawColor(16777215);     // Catch: Throwable -> L111
    L40:
        if (r310 == 0) goto L42;
        r101.setStrokeWidth(r310);     // Catch: Throwable -> L111
        r101.setStrokeCap(Paint.Cap.ROUND);     // Catch: Throwable -> L111
        r101.setStrokeJoin(Paint.Join.ROUND);     // Catch: Throwable -> L111
        r101.setStyle(Paint.Style.STROKE);     // Catch: Throwable -> L111
        r101.setColor(r215);     // Catch: Throwable -> L111
        r100.drawText(r210, 0.0f, 0.0f - r102.ascent, r101);     // Catch: Throwable -> L111
    L42:
        r101.setStyle(Paint.Style.FILL);     // Catch: Throwable -> L111
        r101.setColor(r214);     // Catch: Throwable -> L111
        r100.drawText(r210, 0.0f, 0.0f - r102.ascent, r101);     // Catch: Throwable -> L111
    L43:
        Bitmap r105 = r217;
        int[] r106 = new int[r113 * r114];     // Catch: Throwable -> L111
        if (r105 == null) goto L105;
        r105.copyPixelsToBuffer(IntBuffer.wrap(r106));     // Catch: Throwable -> L111
    L105:
        if (r105 != null) goto L107;
    L109:
        monitor-exit(EnvDrawText.class);
        return r106;
    L107:
        if (r105.isRecycled() == true) goto L109;
        r105.recycle();     // Catch: Throwable -> L111
        goto L109
    L39:
        r100.drawColor(r216);     // Catch: Throwable -> L111
        goto L40
    L44:
        int r116 = r112 + 1;     // Catch: Throwable -> L111
        int r117 = (int) (((double) Layout.getDesiredWidth(r210.substring(0, r112), r101)) + 0.5d);     // Catch: Throwable -> L111
        int r118 = 2;
    L45:
        int r119 = r210.indexOf(92, r116);     // Catch: Throwable -> L111
        if (r119 <= 0) goto L52;
        int r120 = (int) (((double) Layout.getDesiredWidth(r210.substring(r116, r119), r101)) + 0.5d);     // Catch: Throwable -> L111
        if (r120 <= r117) goto L50;
        r117 = r120;
    L50:
        r116 = r119 + 1;     // Catch: Throwable -> L111
        r118 = r118 + 1;     // Catch: Throwable -> L111
        goto L45
    L52:
        if (r116 == r210.length()) goto L56;
        int r121 = (int) (((double) Layout.getDesiredWidth(r210.substring(r116, r210.length()), r101)) + 0.5d);     // Catch: Throwable -> L111
        if (r121 <= r117) goto L56;
        r117 = r121;
    L56:
        Paint.FontMetrics r122 = r101.getFontMetrics();     // Catch: Throwable -> L111
        int r123 = (int) Math.ceil(r122.descent - r122.ascent);     // Catch: Throwable -> L111
        int r124 = r118 * r123;     // Catch: Throwable -> L111
        r213[0] = r117;     // Catch: Throwable -> L111
        r213[1] = r124;     // Catch: Throwable -> L111
        if (r213.length != 4) goto L59;
        int r125 = (int) Math.pow(2.0d, (int) Math.ceil(Math.log(r117) / Math.log(2.0d)));     // Catch: Throwable -> L111
        int r126 = (int) Math.pow(2.0d, (int) Math.ceil(Math.log(r124) / Math.log(2.0d)));     // Catch: Throwable -> L111
        int r127 = r125;
    L60:
        if (r127 != 0) goto L64;
        if (r126 != 0) goto L64;
        int r128 = 0;
        r113 = 0;
    L66:
        if (r213.length != 4) goto L68;
        r213[2] = r113;     // Catch: Throwable -> L111
        r213[3] = r128;     // Catch: Throwable -> L111
    L68:
        if (r113 <= 0) goto L77;
        if (r128 <= 0) goto L77;
        Bitmap r129 = Bitmap.createBitmap(r113, r128, Bitmap.Config.ARGB_8888);     // Catch: Throwable -> L111
        if (r129 != null) goto L75;
        int[] r107 = new int[0];     // Catch: Throwable -> L111
        monitor-exit(EnvDrawText.class);
        return r107;
    L75:
        r100.setBitmap(r129);     // Catch: Throwable -> L111
        r217 = r129;
    L77:
        if ((r216 & (-16777216)) != 0) goto L79;
        r100.drawColor(16777215);     // Catch: Throwable -> L111
    L80:
        r101.setTextAlign(getTextAlignedType(r311));     // Catch: Throwable -> L111
        if (r311 != 1) goto L84;
        int r108 = 0;
        int r130 = 0;
    L87:
        int r109 = 0;
    L88:
        int r131 = r210.indexOf(92, r108);     // Catch: Throwable -> L111
        if (r131 <= 0) goto L95;
        String r132 = r210.substring(r108, r131);     // Catch: Throwable -> L111
        Layout.getDesiredWidth(r132, r101);     // Catch: Throwable -> L111
        int r133 = r131 + 1;     // Catch: Throwable -> L111
        if (r310 == 0) goto L94;
        r101.setStrokeWidth(r310);     // Catch: Throwable -> L111
        r101.setStrokeCap(Paint.Cap.ROUND);     // Catch: Throwable -> L111
        r101.setStrokeJoin(Paint.Join.ROUND);     // Catch: Throwable -> L111
        r101.setStyle(Paint.Style.STROKE);     // Catch: Throwable -> L111
        r101.setColor(r215);     // Catch: Throwable -> L111
        r100.drawText(r132, r130, (r109 * r123) - r122.ascent, r101);     // Catch: Throwable -> L111
    L94:
        r101.setStyle(Paint.Style.FILL);     // Catch: Throwable -> L111
        r101.setColor(r214);     // Catch: Throwable -> L111
        r100.drawText(r132, r130, (r109 * r123) - r122.ascent, r101);     // Catch: Throwable -> L111
        r109 = r109 + 1;     // Catch: Throwable -> L111
        r128 = r128;
        r108 = r133;
        goto L88
    L95:
        int r218 = r128;
        if (r108 == r210.length()) goto L101;
        String r134 = r210.substring(r108, r210.length());     // Catch: Throwable -> L111
        Layout.getDesiredWidth(r134, r101);     // Catch: Throwable -> L111
        if (r310 == 0) goto L100;
        r101.setStrokeWidth(r310);     // Catch: Throwable -> L111
        r101.setStrokeCap(Paint.Cap.ROUND);     // Catch: Throwable -> L111
        r101.setStrokeJoin(Paint.Join.ROUND);     // Catch: Throwable -> L111
        r101.setStyle(Paint.Style.STROKE);     // Catch: Throwable -> L111
        r101.setColor(r215);     // Catch: Throwable -> L111
        r100.drawText(r134, r130, (r109 * r123) - r122.ascent, r101);     // Catch: Throwable -> L111
    L100:
        r101.setStyle(Paint.Style.FILL);     // Catch: Throwable -> L111
        r101.setColor(r214);     // Catch: Throwable -> L111
        r100.drawText(r134, r130, (r109 * r123) - r122.ascent, r101);     // Catch: Throwable -> L111
    L101:
        r114 = r218;
        goto L43
    L84:
        if (r311 != 2) goto L86;
        r108 = 0;
        r130 = r213[0];     // Catch: Throwable -> L111
        goto L87
    L86:
        r108 = 0;
        r130 = r213[0] / 2;     // Catch: Throwable -> L111
        goto L87
    L79:
        r100.drawColor(r216);     // Catch: Throwable -> L111
    L64:
        r128 = r126;
        r113 = r127;
        goto L66
    L59:
        r127 = r117;
        r126 = r124;
        goto L60
    L10:
        if (r110.equals(DEVICE_VIVOX3L) == false) goto L12;
        r111 = 0;
    L111:
        th = move-exception;
        throw th;
    }

    private static synchronized Bitmap drawTextExt(String r210, int r211, int r212, int[] r213, int r214, int r215, int r216, int r310, int r311) {
        monitor-enter(EnvDrawText.class);
        Canvas r100 = new Canvas();     // Catch: Throwable -> L100
        TextPaint r101 = new TextPaint();     // Catch: Throwable -> L100
        if (TextUtils.isEmpty(phonetype) == false) goto L7;
        phonetype = Build.MODEL;     // Catch: Throwable -> L100
    L7:
        String r110 = phonetype;     // Catch: Throwable -> L100
        if (r110 != null) goto L10;
    L12:
        int r111 = r212;
    L13:
        r101.reset();     // Catch: Throwable -> L100
        r101.setSubpixelText(true);     // Catch: Throwable -> L100
        r101.setAntiAlias(true);     // Catch: Throwable -> L100
        r101.setTextSize(r211);     // Catch: Throwable -> L100
        r101.setShadowLayer(0.0f, 0.0f, 0.0f, 0);     // Catch: Throwable -> L100
        r101.setTypeface(getTypeface(r111));     // Catch: Throwable -> L100
        if (r310 == 0) goto L16;
        r101.setStrokeWidth(r310);     // Catch: Throwable -> L100
        r101.setStrokeCap(Paint.Cap.ROUND);     // Catch: Throwable -> L100
        r101.setStrokeJoin(Paint.Join.ROUND);     // Catch: Throwable -> L100
        r101.setStyle(Paint.Style.STROKE);     // Catch: Throwable -> L100
    L16:
        int r112 = r210.indexOf(92, 0);     // Catch: Throwable -> L100
        Bitmap r217 = null;
        if (r112 != (-1)) goto L43;
        Paint.FontMetrics r102 = r101.getFontMetrics();     // Catch: Throwable -> L100
        int r113 = (int) (((double) Layout.getDesiredWidth(r210, 0, r210.length(), r101)) + 0.5d);     // Catch: Throwable -> L100
        int r114 = (int) Math.ceil(r102.descent - r102.ascent);     // Catch: Throwable -> L100
        r213[0] = r113;     // Catch: Throwable -> L100
        r213[1] = r114;     // Catch: Throwable -> L100
        if (r213.length != 4) goto L21;
        int r115 = (int) Math.pow(2.0d, (int) Math.ceil(Math.log(r113) / Math.log(2.0d)));     // Catch: Throwable -> L100
        r114 = (int) Math.pow(2.0d, (int) Math.ceil(Math.log(r114) / Math.log(2.0d)));     // Catch: Throwable -> L100
        r113 = r115;
    L21:
        if (r113 != 0) goto L25;
        if (r114 != 0) goto L25;
        r114 = 0;
        int r116 = 0;
    L27:
        if (r213.length != 4) goto L29;
        r213[2] = r116;     // Catch: Throwable -> L100
        r213[3] = r114;     // Catch: Throwable -> L100
    L29:
        if (r116 <= 0) goto L37;
        if (r114 <= 0) goto L37;
        Bitmap r103 = Bitmap.createBitmap(r116, r114, Bitmap.Config.ARGB_8888);     // Catch: Throwable -> L100
        if (r103 != null) goto L35;
        monitor-exit(EnvDrawText.class);
        return r103;
    L35:
        r100.setBitmap(r103);     // Catch: Throwable -> L100
        r217 = r103;
    L37:
        if ((r216 & (-16777216)) != 0) goto L39;
        r100.drawColor(16777215);     // Catch: Throwable -> L100
    L40:
        if (r310 == 0) goto L42;
        r101.setStrokeWidth(r310);     // Catch: Throwable -> L100
        r101.setStrokeCap(Paint.Cap.ROUND);     // Catch: Throwable -> L100
        r101.setStrokeJoin(Paint.Join.ROUND);     // Catch: Throwable -> L100
        r101.setStyle(Paint.Style.STROKE);     // Catch: Throwable -> L100
        r101.setColor(r215);     // Catch: Throwable -> L100
        r100.drawText(r210, 0.0f, 0.0f - r102.ascent, r101);     // Catch: Throwable -> L100
    L42:
        r101.setStyle(Paint.Style.FILL);     // Catch: Throwable -> L100
        r101.setColor(r214);     // Catch: Throwable -> L100
        r100.drawText(r210, 0.0f, 0.0f - r102.ascent, r101);     // Catch: Throwable -> L100
    L98:
        monitor-exit(EnvDrawText.class);
        return r217;
    L39:
        r100.drawColor(r216);     // Catch: Throwable -> L100
    L25:
        r116 = r113;
        goto L27
    L43:
        int r117 = r112 + 1;     // Catch: Throwable -> L100
        int r118 = (int) (((double) Layout.getDesiredWidth(r210.substring(0, r112), r101)) + 0.5d);     // Catch: Throwable -> L100
        int r119 = 2;
    L44:
        int r120 = r210.indexOf(92, r117);     // Catch: Throwable -> L100
        if (r120 <= 0) goto L51;
        int r121 = (int) (((double) Layout.getDesiredWidth(r210.substring(r117, r120), r101)) + 0.5d);     // Catch: Throwable -> L100
        if (r121 <= r118) goto L49;
        r118 = r121;
    L49:
        r117 = r120 + 1;     // Catch: Throwable -> L100
        r119 = r119 + 1;     // Catch: Throwable -> L100
        goto L44
    L51:
        if (r117 == r210.length()) goto L55;
        int r122 = (int) (((double) Layout.getDesiredWidth(r210.substring(r117, r210.length()), r101)) + 0.5d);     // Catch: Throwable -> L100
        if (r122 <= r118) goto L55;
        r118 = r122;
    L55:
        Paint.FontMetrics r123 = r101.getFontMetrics();     // Catch: Throwable -> L100
        int r124 = (int) Math.ceil(r123.descent - r123.ascent);     // Catch: Throwable -> L100
        int r125 = r119 * r124;     // Catch: Throwable -> L100
        r213[0] = r118;     // Catch: Throwable -> L100
        r213[1] = r125;     // Catch: Throwable -> L100
        if (r213.length != 4) goto L58;
        Paint.FontMetrics r218 = r123;
        int r126 = (int) Math.pow(2.0d, (int) Math.ceil(Math.log(r118) / Math.log(2.0d)));     // Catch: Throwable -> L100
        r125 = (int) Math.pow(2.0d, (int) Math.ceil(Math.log(r125) / Math.log(2.0d)));     // Catch: Throwable -> L100
        r118 = r126;
    L59:
        if (r118 != 0) goto L64;
        if (r125 != 0) goto L64;
        r118 = 0;
        r125 = 0;
    L64:
        if (r213.length != 4) goto L66;
        r213[2] = r118;     // Catch: Throwable -> L100
        r213[3] = r125;     // Catch: Throwable -> L100
    L66:
        if (r118 <= 0) goto L74;
        if (r125 <= 0) goto L74;
        Bitmap r127 = Bitmap.createBitmap(r118, r125, Bitmap.Config.ARGB_8888);     // Catch: Throwable -> L100
        if (r127 != null) goto L72;
        monitor-exit(EnvDrawText.class);
        return r127;
    L72:
        r100.setBitmap(r127);     // Catch: Throwable -> L100
        r217 = r127;
    L74:
        if ((r216 & (-16777216)) != 0) goto L76;
        r100.drawColor(16777215);     // Catch: Throwable -> L100
    L77:
        r101.setTextAlign(getTextAlignedType(r311));     // Catch: Throwable -> L100
        if (r311 != 1) goto L81;
        int r104 = 0;
        int r128 = 0;
    L84:
        int r105 = 0;
    L85:
        int r129 = r210.indexOf(92, r104);     // Catch: Throwable -> L100
        if (r129 <= 0) goto L92;
        String r106 = r210.substring(r104, r129);     // Catch: Throwable -> L100
        Layout.getDesiredWidth(r106, r101);     // Catch: Throwable -> L100
        int r130 = r129 + 1;     // Catch: Throwable -> L100
        if (r310 == 0) goto L90;
        r101.setStrokeWidth(r310);     // Catch: Throwable -> L100
        r101.setStrokeCap(Paint.Cap.ROUND);     // Catch: Throwable -> L100
        r101.setStrokeJoin(Paint.Join.ROUND);     // Catch: Throwable -> L100
        r101.setStyle(Paint.Style.STROKE);     // Catch: Throwable -> L100
        r101.setColor(r215);     // Catch: Throwable -> L100
        float r131 = r105 * r124;     // Catch: Throwable -> L100
        Paint.FontMetrics r132 = r218;
        r100.drawText(r106, r128, r131 - r132.ascent, r101);     // Catch: Throwable -> L100
    L91:
        r101.setStyle(Paint.Style.FILL);     // Catch: Throwable -> L100
        r101.setColor(r214);     // Catch: Throwable -> L100
        r100.drawText(r106, r128, (r105 * r124) - r132.ascent, r101);     // Catch: Throwable -> L100
        r105 = r105 + 1;     // Catch: Throwable -> L100
        r104 = r130;
        r218 = r132;
        goto L85
    L90:
        r132 = r218;
        goto L91
    L92:
        Paint.FontMetrics r133 = r218;
        if (r104 == r210.length()) goto L98;
        String r107 = r210.substring(r104, r210.length());     // Catch: Throwable -> L100
        Layout.getDesiredWidth(r107, r101);     // Catch: Throwable -> L100
        if (r310 == 0) goto L97;
        r101.setStrokeWidth(r310);     // Catch: Throwable -> L100
        r101.setStrokeCap(Paint.Cap.ROUND);     // Catch: Throwable -> L100
        r101.setStrokeJoin(Paint.Join.ROUND);     // Catch: Throwable -> L100
        r101.setStyle(Paint.Style.STROKE);     // Catch: Throwable -> L100
        r101.setColor(r215);     // Catch: Throwable -> L100
        r100.drawText(r107, r128, (r105 * r124) - r133.ascent, r101);     // Catch: Throwable -> L100
    L97:
        r101.setStyle(Paint.Style.FILL);     // Catch: Throwable -> L100
        r101.setColor(r214);     // Catch: Throwable -> L100
        r100.drawText(r107, r128, (r105 * r124) - r133.ascent, r101);     // Catch: Throwable -> L100
        goto L98
    L81:
        if (r311 != 2) goto L83;
        r104 = 0;
        r128 = r213[0];     // Catch: Throwable -> L100
        goto L84
    L83:
        r104 = 0;
        r128 = r213[0] / 2;     // Catch: Throwable -> L100
        goto L84
    L76:
        r100.drawColor(r216);     // Catch: Throwable -> L100
        goto L77
    L58:
        r218 = r123;
        goto L59
    L10:
        if (r110.equals(DEVICE_VIVOX3L) == false) goto L12;
        r111 = 0;
    L100:
        th = move-exception;
        throw th;
    }
}
