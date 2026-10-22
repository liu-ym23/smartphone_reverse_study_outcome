package com.amazing.utils;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.TextPaint;
import android.util.Xml;
import com.byted.cast.linkcommon.cybergarage.xml.XML;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.lynx.jsbridge.LynxResourceModule;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.ttvideoengine.model.VideoSeekTs;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: classes3.dex */
public class TextMeshUtils {
    public TextMeshUtils() {
    }

    private static String[] getAndroidSystemFontPaths() {
        XmlPullParser r100 = Xml.newPullParser();     // Catch: Throwable -> L46 Exception -> L51
        PolarisFileInputStreamWrapper r101 = new PolarisFileInputStreamWrapper(new PolarisFileWrapper("/system/etc/fonts.xml"));     // Catch: Throwable -> L46 Exception -> L51
        r100.setInput(r101, XML.CHARSET_UTF8);     // Catch: Throwable -> L43 Exception -> L45
        int r102 = r100.getEventType();     // Catch: Throwable -> L43 Exception -> L45
        ArrayList r103 = new ArrayList();     // Catch: Throwable -> L43 Exception -> L45
        ArrayList r104 = new ArrayList();     // Catch: Throwable -> L43 Exception -> L45
        String r105 = null;
    L7:
        if (r102 == 1) goto L40;
        if (r102 == 2) goto L37;
        if (r102 == 3) goto L17;
        if (r102 != 4) goto L39;
        r105 = r100.getText();     // Catch: Throwable -> L43 Exception -> L45
    L39:
        r102 = r100.next();     // Catch: Throwable -> L43 Exception -> L45
        goto L7
    L17:
        if ("family".equals(r100.getName()) == false) goto L31;
        int r106 = 0;
    L20:
        if (r106 >= r104.size()) goto L25;
        if (((String) r104.get(r106)).contains("Regular") == true) goto L26;
        r106 = r106 + 1;     // Catch: Throwable -> L43 Exception -> L45
    L26:
        String r107 = new String("/system/fonts/");     // Catch: Throwable -> L43 Exception -> L45
        if (r106 < 0) goto L29;
        r103.add(r107.concat((String) r104.get(r106)));     // Catch: Throwable -> L43 Exception -> L45
        goto L39
    L29:
        r103.add(r107.concat((String) r104.get(0)));     // Catch: Throwable -> L43 Exception -> L45
        goto L39
    L25:
        r106 = -1;
        goto L26
    L31:
        if (LynxResourceModule.FONT_TYPE.equals(r100.getName()) == false) goto L34;
        r104.add(r105);     // Catch: Throwable -> L43 Exception -> L45
        goto L39
    L34:
        if ("familyset".equals(r100.getName()) == false) goto L39;
        r105 = VideoSeekTs.KEY_ENDING;
        goto L39
    L37:
        if ("family".equals(r100.getName()) == false) goto L39;
        r104.clear();     // Catch: Throwable -> L43 Exception -> L45
        goto L39
    L40:
        String[] r108 = new String[r103.size()];     // Catch: Throwable -> L43 Exception -> L45
        r103.toArray(r108);     // Catch: Throwable -> L43 Exception -> L45
        r101.close();     // Catch: Exception -> L55
    L42:
        return r108;
    L43:
        Throwable th10 = th;
    L48:
        if (r101 != null) goto L62;
    L50:
        throw th10;
    L62:
        r101.close();     // Catch: Exception -> L56
    L52:
        if (r101 != null) goto L58;
    L54:
        return null;
    L58:
        r101.close();     // Catch: Exception -> L57
        goto L54
    L51:
        r101 = null;
    L46:
        th = move-exception;
        r101 = null;
        th10 = th;
        goto L48
    }

    private static float getDeviceDpi() {
        Resources r100 = Resources.getSystem();
        return WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics()).densityDpi;
    }

    private static Bitmap callIStaticGenerateBitmapForEmoji(byte[] r100, int r101) {
        String r102 = new String(r100);
        TextPaint r103 = new TextPaint();
        r103.setTextSize(r101);
        r103.setAntiAlias(true);
        r103.setStyle(Paint.Style.FILL);
        r103.setTextAlign(Paint.Align.LEFT);
        Rect r104 = new Rect();
        r103.getTextBounds(r102, 0, r102.length(), r104);
        Bitmap r105 = Bitmap.createBitmap(r104.width(), r104.height(), Bitmap.Config.ARGB_8888);
        Canvas r106 = new Canvas(r105);
        r106.drawText(r102, -r104.left, -r104.top, r103);
        r106.save();
        r106.restore();
        return r105;
    }

    private static Bitmap generateImage(String r100, float r101, byte[] r102, int r103, boolean r104, float r105, int r110, boolean r111, float r112, float r113, int r114, float r115) {
        String r106 = new String(r102);
        TextPaint r107 = new TextPaint();
        r107.setTextSize(r101);
        r107.setAntiAlias(true);
        r107.setStyle(Paint.Style.FILL);
        r107.setTextAlign(Paint.Align.LEFT);
        r107.setColor(r103);
        Rect r108 = new Rect();
        float[] r109 = new float[r106.length()];
        r107.getTextWidths(r106, r109);
        r107.getTextBounds(r106, 0, r106.length(), r108);
        float r116 = r109[0];
        if (r104 == true) goto L5;
        r105 = 0.0f;
    L5:
        if (r111 == true) goto L7;
        r112 = 0.0f;
        r113 = 0.0f;
        r115 = 0.0f;
    L7:
        float r117 = Math.max(Math.abs(r112), Math.abs(r113)) + r105;
        TextPaint r118 = new TextPaint();
        if (r104 == true) goto L10;
        if (r111 == true) goto L10;
    L13:
        float r119 = (2.0f * r117) * r101;
        Bitmap r120 = Bitmap.createBitmap((int) (r108.width() + r119), (int) (r108.height() + r119), Bitmap.Config.ARGB_8888);
        Canvas r121 = new Canvas(r120);
        if (r104 == true) goto L16;
        if (r111 == true) goto L16;
    L17:
        float r122 = r117 * r101;
        r121.drawText(r106, (-r108.left) + r122, (-r108.top) + r122, r107);
        r121.save();
        r121.restore();
        return r120;
    L16:
        float r123 = r117 * r101;
        r121.drawText(r106, (-r108.left) + r123, (-r108.top) + r123, r118);
    L10:
        r118.setTextSize(r101);
        r118.setAntiAlias(true);
        r118.setStyle(Paint.Style.STROKE);
        r118.setTextAlign(Paint.Align.LEFT);
        r118.setStrokeWidth((r105 * 2.0f) * r101);
        r118.setColor(r110);
        if (r111 == false) goto L13;
        r118.setShadowLayer(r115 * r101, r112 * r101, r113 * r101, r114);
        goto L13
    }

    private static float[] generateImageSize(String r100, float r101, byte[] r102, int r103, boolean r104, float r105, int r106, boolean r107, float r108, float r110, int r111, float r112) {
        String r109 = new String(r102);
        TextPaint r113 = new TextPaint();
        r113.setTextSize(r101);
        r113.setAntiAlias(true);
        r113.setStyle(Paint.Style.FILL);
        r113.setTextAlign(Paint.Align.LEFT);
        r113.setColor(r103);
        Rect r114 = new Rect();
        float[] r115 = new float[r109.length()];
        r113.getTextWidths(r109, r115);
        r113.getTextBounds(r109, 0, r109.length(), r114);
        if (r104 == true) goto L5;
        r105 = 0.0f;
    L5:
        if (r107 == true) goto L8;
        r108 = 0.0f;
        r110 = 0.0f;
    L8:
        return new float[]{r114.left, r114.right, -r114.bottom, -r114.top, r115[0], (r105 + Math.max(Math.abs(r108), Math.abs(r110))) * r101, r113.ascent(), r113.descent()};
    }

    private static Bitmap callIStaticGenerateBitmapFromTextMesh(byte[] r210, String r211, int r212, int r213, int r214, float r215, int r216, float r217, int r310, float r311, float r312, float r313, int r314, int r315, int r316, int r317) {
        String r100 = new String(r210);
        Rect r101 = new Rect(0, 0, r316, r317);
        Bitmap r102 = Bitmap.createBitmap(r316, r317, Bitmap.Config.ARGB_8888);
        Paint r103 = new Paint();
        r103.setColor(0);
        r103.setStyle(Paint.Style.FILL);
        Canvas r104 = new Canvas(r102);
        TextPaint r105 = new TextPaint();
        r105.setColor(r213);
        float r106 = r212;
        r105.setTextSize(r106);
        r105.setAntiAlias(true);
        r105.setStyle(Paint.Style.FILL);
        if (r315 != 0) goto L5;
        r105.setTextAlign(Paint.Align.LEFT);
    L9:
        if ((r216 & 16) != 16) goto L12;
        r105.setUnderlineText(true);
    L12:
        if ((r216 & 32) != 32) goto L15;
        r105.setStrikeThruText(true);
    L15:
        if ((r216 & 4) != 4) goto L18;
        r105.setTextSkewX((-r215) / 90.0f);
    L18:
        if ((r216 & 8) != 8) goto L21;
        r105.setFakeBoldText(true);
    L21:
        if ((r216 & 2) != 2) goto L23;
        r105.setShadowLayer(r311, r312, r313, r314);
    L23:
        Paint.FontMetrics r110 = r105.getFontMetrics();
        float r111 = r110.top;
        float r112 = r110.bottom;
        String[] r107 = r100.split("\n");
        int r113 = r107.length;
        if ((r216 & 1) != 1) goto L36;
        TextPaint r114 = new TextPaint();
        r114.setColor(r310);
        r114.setTextSize(r105.getTextSize());
        r114.setAntiAlias(r105.isAntiAlias());
        r114.setStyle(Paint.Style.STROKE);
        r114.setStrokeWidth((5.0f * r217) / r106);
        r114.setTextAlign(r105.getTextAlign());
        r114.setTextSkewX(r105.getTextSkewX());
        r105.setFakeBoldText(false);
        r114.setFakeBoldText(true);
        float r115 = r214 / r106;
        float r108 = (-r110.ascent) + r110.descent;
        float r109 = r108 * 0.1f;
        int r116 = 0;
    L26:
        if (r116 >= r113) goto L36;
        TextPaint r318 = r105;
        float r117 = r111;
        float r218 = r112;
        float r118 = r106;
        Canvas r219 = r104;
        String[] r220 = r107;
        int r119 = (int) (((double) ((int) ((r101.centerY() - (r111 / 2.0f)) - (r112 / 2.0f)))) - (((((double) (r113 - 1)) * 0.5d) - ((double) r116)) * ((double) (r109 + r108))));
        r114.setLetterSpacing(r115);
        if (r315 != 0) goto L30;
        Canvas r120 = r219;
        r120.drawText(r220[r116], r101.left, r119, r114);
    L34:
        r116 = r116 + 1;
        r112 = r218;
        r107 = r220;
        r105 = r318;
        r104 = r120;
        r111 = r117;
        r106 = r118;
        goto L26
    L30:
        r120 = r219;
        if (r315 != 1) goto L33;
        r120.drawText(r220[r116], r101.centerX(), r119, r114);
        goto L34
    L33:
        r120.drawText(r220[r116], r101.right, r119, r114);
    L36:
        String[] r221 = r107;
        TextPaint r319 = r105;
        float r121 = r106;
        float r122 = r111;
        float r222 = r112;
        Canvas r123 = r104;
        float r124 = r214 / r121;
        float r125 = (-r110.ascent) + r110.descent;
        float r126 = 0.1f * r125;
        int r127 = 0;
    L37:
        if (r127 >= r113) goto L46;
        int r128 = (int) (((double) ((int) ((r101.centerY() - (r122 / 2.0f)) - (r222 / 2.0f)))) - (((((double) (r113 - 1)) * 0.5d) - ((double) r127)) * ((double) (r126 + r125))));
        TextPaint r129 = r319;
        r129.setLetterSpacing(r124);
        if (r315 != 0) goto L42;
        r123.drawText(r221[r127], r101.left, r128, r129);
    L45:
        r127 = r127 + 1;
        r319 = r129;
        goto L37
    L42:
        if (r315 != 1) goto L44;
        r123.drawText(r221[r127], r101.centerX(), r128, r129);
        goto L45
    L44:
        r123.drawText(r221[r127], r101.right, r128, r129);
        goto L45
    L46:
        r123.save();
        r123.restore();
        return r102;
    L5:
        if (r315 != 1) goto L7;
        r105.setTextAlign(Paint.Align.CENTER);
        goto L9
    L7:
        r105.setTextAlign(Paint.Align.RIGHT);
        goto L9
    }
}
