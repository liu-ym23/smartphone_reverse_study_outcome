package com.bef.effectsdk.text;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.os.Build;
import android.text.BoringLayout;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import com.bef.effectsdk.text.data.BitmapType;
import com.bef.effectsdk.text.data.CharLayout;
import com.bef.effectsdk.text.data.TextBitmapResult;
import com.bef.effectsdk.text.data.TextLayoutParam;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.UByte;
import r27.a;

/* JADX INFO: loaded from: classes3.dex */
public class TextLayoutUtils {
    private static final int FONT_SIZE_INCREMENT = 2;
    private static final int FONT_SIZE_INIT = 10;
    private static final int MAX_BITMAP_HEIGHT = 2048;
    private static final int MAX_BITMAP_WIDTH = 2048;

    /* JADX INFO: renamed from: com.bef.effectsdk.text.TextLayoutUtils$1, reason: invalid class name */
    /* JADX INFO: loaded from: classes39.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$bef$effectsdk$text$TextLayoutUtils$COLOR_TYPE = null;
        static final /* synthetic */ int[] $SwitchMap$com$bef$effectsdk$text$data$BitmapType = null;

        static {
            int[] r100 = new int[COLOR_TYPE.values().length];
            $SwitchMap$com$bef$effectsdk$text$TextLayoutUtils$COLOR_TYPE = r100;
            r100[COLOR_TYPE.COLOR_TYPE_ALPHA.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L14:
            $SwitchMap$com$bef$effectsdk$text$TextLayoutUtils$COLOR_TYPE[COLOR_TYPE.COLOR_TYPE_RGBA.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L6:
            int[] r101 = new int[BitmapType.values().length];
            $SwitchMap$com$bef$effectsdk$text$data$BitmapType = r101;
            r101[BitmapType.TEXT_BITMAP_SHAKE_ALPHA.ordinal()] = 1;     // Catch: NoSuchFieldError -> L12
        L18:
            $SwitchMap$com$bef$effectsdk$text$data$BitmapType[BitmapType.TEXT_BITMAP_NEON_ALPHA.ordinal()] = 2;     // Catch: NoSuchFieldError -> L13
            return;
        }
    }

    /* JADX INFO: loaded from: classes39.dex */
    public static final enum COLOR_TYPE extends Enum<COLOR_TYPE> {
        private static final /* synthetic */ COLOR_TYPE[] $VALUES = null;
        public static final COLOR_TYPE COLOR_TYPE_ALPHA = null;
        public static final COLOR_TYPE COLOR_TYPE_RGBA = null;

        private static /* synthetic */ COLOR_TYPE[] $values() {
            return new COLOR_TYPE[]{COLOR_TYPE_RGBA, COLOR_TYPE_ALPHA};
        }

        static {
            COLOR_TYPE_RGBA = new COLOR_TYPE("COLOR_TYPE_RGBA", 0);
            COLOR_TYPE_ALPHA = new COLOR_TYPE("COLOR_TYPE_ALPHA", 1);
            $VALUES = $values();
        }

        public static COLOR_TYPE[] values() {
            return (COLOR_TYPE[]) $VALUES.clone();
        }

        public static COLOR_TYPE valueOf(String r100) {
            return (COLOR_TYPE) a.a(COLOR_TYPE.class, r100);
        }

        private COLOR_TYPE(String r100, int r101) {
            super(r100, r101);
        }
    }

    public TextLayoutUtils() {
    }

    public static String[] lyricShakeSplit(String r110) {
        if (r110 != null) goto L4;
        return null;
    L4:
        if (r110.isEmpty() == true) goto L68;
        String[] r111 = r110.replace("\n", " ").replace(",", "").replace("\r", " ").split(" ");
        ArrayList r100 = new ArrayList();
        StringBuilder r101 = new StringBuilder();
        int r102 = 0;
    L8:
        if (r102 >= r111.length) goto L49;
        if (r111[r102].isEmpty() == true) goto L47;
        int r103 = r101.toString().length();
        if (r103 != 0) goto L44;
        if (r111[r102].length() >= 10) goto L18;
        r101.append(r111[r102]);
        goto L47
    L18:
        if (r111[r102].length() != 10) goto L20;
        r100.add(r111[r102]);
        goto L47
    L20:
        r100.add(r111[r102].substring(0, 10));
        if (((r111[r102].length() - 10) % 9) != 0) goto L23;
        boolean r104 = true;
    L24:
        if (r104 == false) goto L26;
        int r105 = (r111[r102].length() - 10) / 9;
    L27:
        int r106 = 0;
    L28:
        if (r106 >= r105) goto L47;
        if (r106 != 0) goto L36;
        if (r104 == false) goto L33;
        r101.append("-");
        r101.append(r111[r102].substring(10, 19));
        String r112 = r101.toString();
        r100.add(r112);
        r101.delete(0, r112.length());
    L42:
        r106 = r106 + 1;
        goto L28
    L33:
        if (r105 != 1) goto L35;
        int r113 = r111[r102].length();
        r101.append("-");
        r101.append(r111[r102].substring(10, r113));
        goto L42
    L35:
        r101.append("-");
        r101.append(r111[r102].substring(10, 19));
        String r114 = r101.toString();
        r100.add(r114);
        r101.delete(0, r114.length());
        goto L42
    L36:
        int r115 = ((r106 - 1) * 9) + 19;
        if (r106 >= (r105 - 1)) goto L39;
        r101.append("-");
        r101.append(r111[r102].substring(r115, (r106 * 9) + 19));
        String r116 = r101.toString();
        r100.add(r116);
        r101.delete(0, r116.length());
        goto L42
    L39:
        if (r104 == false) goto L41;
        r101.append("-");
        r101.append(r111[r102].substring(r115, (r106 * 9) + 19));
        String r117 = r101.toString();
        r100.add(r117);
        r101.delete(0, r117.length());
        goto L42
    L41:
        int r118 = r111[r102].length();
        r101.append("-");
        r101.append(r111[r102].substring(r115, r118));
        goto L42
    L26:
        r105 = ((r111[r102].length() - 10) / 9) + 1;
        goto L27
    L23:
        r104 = false;
        goto L24
    L44:
        if (((r101.toString().length() + r111[r102].length()) + 1) > 10) goto L46;
        r101.append(" ");
        r101.append(r111[r102]);
        goto L47
    L46:
        r100.add(r101.toString());
        r101.delete(0, r103);
        r102 = r102 - 1;
    L47:
        r102 = r102 + 1;
        goto L8
    L49:
        if (r101.toString().length() == 0) goto L52;
        r100.add(r101.toString());
    L52:
        return (String[]) r100.toArray(new String[r100.size()]);
    L68:
        return null;
    }

    public static String[] splitLyric(String r110) {
        if (r110 != null) goto L4;
        return null;
    L4:
        if (r110.isEmpty() == true) goto L36;
        String[] r111 = r110.replace("\n", " ").replace("\r", " ").split(" ");
        ArrayList r100 = new ArrayList();
        int r101 = 0;
        int r102 = 0;
    L8:
        if (r101 >= r111.length) goto L27;
        StringBuilder r103 = new StringBuilder();
        if (((r102 % 5) % 3) != 0) goto L12;
        int r104 = 6;
    L13:
        int r105 = 0;
    L15:
        if (r101 >= r111.length) goto L25;
        if (((r111[r101].length() + r105) + 1) <= r104) goto L19;
        if (r105 > 3) goto L25;
    L19:
        r105 = r105 + (r111[r101].length() + 1);
        int r106 = r101 + 1;
        r103.append(r111[r101]);
        r103.append(" ");
        if (r106 != (r111.length - 1)) goto L24;
        if (r111[r106].length() >= 3) goto L24;
        r103.append(r111[r106]);
    L24:
        r101 = r106;
    L25:
        r102 = r102 + 1;
        r100.add(r103.substring(0, r103.length() - 1));
        goto L8
    L12:
        r104 = 10;
        goto L13
    L27:
        return (String[]) r100.toArray(new String[r100.size()]);
    L36:
        return null;
    }

    public static TextBitmapResult generateBitmapAtlasAlphaUTF32(int[] r100, TextLayoutParam r101) {
        if (r100 != null) goto L4;
        return null;
    L4:
        if (r100.length >= 1) goto L7;
        return null;
    L7:
        return generateBitmapAtlasUTF8(new String(r100, 0, r100.length), r101, COLOR_TYPE.COLOR_TYPE_ALPHA);
    }

    public static TextBitmapResult generateBitmapAtlasAlphaUTF8(String r100, TextLayoutParam r101) {
        if (r100 != null) goto L4;
        return null;
    L4:
        if (r100.isEmpty() == false) goto L7;
        return null;
    L7:
        return generateBitmapAtlasUTF8(r100, r101, COLOR_TYPE.COLOR_TYPE_ALPHA);
    }

    public static TextBitmapResult generateBitmapAtlasRGBAUTF32(int[] r100, TextLayoutParam r101) {
        if (r100 != null) goto L4;
        return null;
    L4:
        if (r100.length >= 1) goto L7;
        return null;
    L7:
        return generateBitmapAtlasUTF8(new String(r100, 0, r100.length), r101, COLOR_TYPE.COLOR_TYPE_RGBA);
    }

    public static TextBitmapResult generateBitmapAtlasRGBAUTF8(String r100, TextLayoutParam r101) {
        if (r100 != null) goto L4;
        return null;
    L4:
        if (r100.isEmpty() == false) goto L7;
        return null;
    L7:
        return generateBitmapAtlasUTF8(r100, r101, COLOR_TYPE.COLOR_TYPE_RGBA);
    }

    public static TextBitmapResult generateBitmapNeonAlphaUTF32(int[] r100, TextLayoutParam r101) {
        if (r100 != null) goto L4;
        return null;
    L4:
        if (r100.length >= 1) goto L7;
        return null;
    L7:
        return generateBitmapNeonAlphaUTF8(new String(r100, 0, r100.length), r101);
    }

    public static TextBitmapResult generateBitmapNeonAlphaUTF8(String r100, TextLayoutParam r101) {
        BitmapType r102 = BitmapType.valueOf(r101.bitmapType);
        int r103 = AnonymousClass1.$SwitchMap$com$bef$effectsdk$text$data$BitmapType[r102.ordinal()];
        if (r103 == 1) goto L11;
        if (r103 == 2) goto L9;
        return null;
    L9:
        return generateTextAutoSizedNeonBitmap(r100, r101);
    L11:
        return generateTextAutoSizedShakeBitmap(r100, r101);
    }

    public static TextBitmapResult generateBitmapNormalAlphaUTF32(int[] r100, TextLayoutParam r101) {
        if (r100 != null) goto L4;
        return null;
    L4:
        if (r100.length >= 1) goto L7;
        return null;
    L7:
        return generateBitmapNormalUTF8(new String(r100, 0, r100.length), r101, COLOR_TYPE.COLOR_TYPE_ALPHA);
    }

    public static TextBitmapResult generateBitmapNormalAlphaUTF8(String r100, TextLayoutParam r101) {
        if (r100 != null) goto L4;
        return null;
    L4:
        if (r100.isEmpty() == false) goto L7;
        return null;
    L7:
        return generateBitmapNormalUTF8(r100, r101, COLOR_TYPE.COLOR_TYPE_ALPHA);
    }

    public static TextBitmapResult generateBitmapNormalRGBAUTF32(int[] r100, TextLayoutParam r101) {
        if (r100 != null) goto L4;
        return null;
    L4:
        if (r100.length >= 1) goto L7;
        return null;
    L7:
        return generateBitmapNormalUTF8(new String(r100, 0, r100.length), r101, COLOR_TYPE.COLOR_TYPE_RGBA);
    }

    public static TextBitmapResult generateBitmapNormalRGBAUTF8(String r100, TextLayoutParam r101) {
        if (r100 != null) goto L4;
        return null;
    L4:
        if (r100.isEmpty() == false) goto L7;
        return null;
    L7:
        return generateBitmapNormalUTF8(r100, r101, COLOR_TYPE.COLOR_TYPE_RGBA);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v0 */
    /* JADX WARN: Type inference failed for: r13v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r13v5 */
    public static TextBitmapResult generateTextAutoSizedNeonBitmap(String r210, TextLayoutParam r211) {
        String[] r100 = splitLyric(r210);
        if (TextUtils.isEmpty(r210) == true) goto L40;
        if (r211 == null) goto L49;
        TextPaint r101 = new TextPaint();
        r101.setTextAlign(Paint.Align.LEFT);
        r101.setAntiAlias(true);
        if (TextUtils.isEmpty(r211.familyName) == false) goto L9;
    L11:
        ?? r110 = 0;
        if (r101.getFontMetrics().top >= r101.getFontMetrics().ascent) goto L14;
        boolean r111 = true;
    L15:
        TextBitmapResult r112 = new TextBitmapResult();
        r112.channel = 1;
        r112.lineCount = r100.length;
        r112.type = 0;
        r112.charLayouts = new CharLayout[r100.length];
        int[] r113 = new int[r100.length];
        float r114 = 0.0f;
        int r102 = 0;
        float r115 = 0.0f;
    L17:
        if (r102 >= r100.length) goto L27;
        String r103 = r100[r102];
        int r104 = 10;
        r101.setTextSize(10);
        float r105 = r101.measureText(r103, 0, r103.length());
    L20:
        if (r105 > r211.lineWidth) goto L22;
        r104 = r104 + 2;
        r101.setTextSize(r104);
        r105 = r101.measureText(r103, 0, r103.length());
        goto L20
    L22:
        int r106 = r104 - 2;
        r113[r102] = r106;
        r101.setTextSize(r106);
        Paint.FontMetrics r107 = r101.getFontMetrics();
        if (r111 == false) goto L25;
        float r108 = r107.bottom;
        float r109 = r107.top;
    L26:
        r115 = r115 + (r108 - r109);
        r102 = r102 + 1;
        goto L17
    L25:
        r108 = r107.descent;
        r109 = r107.ascent;
        goto L26
    L27:
        Bitmap r116 = Bitmap.createBitmap(r211.lineWidth, (int) r115, Bitmap.Config.ALPHA_8);
        Canvas r117 = new Canvas(r116);
        r112.bitmap = r116;
        int r118 = 0;
        float r119 = 0.0f;
    L29:
        if (r118 >= r100.length) goto L39;
        String r120 = r100[r118];
        r101.setTextSize(r113[r118]);
        Paint.FontMetrics r121 = r101.getFontMetrics();
        if (Build.VERSION.SDK_INT < 23) goto L33;
        StaticLayout r122 = StaticLayout.Builder.obtain(r120, r110, r120.length(), r101, r117.getWidth()).setAlignment(Layout.Alignment.ALIGN_NORMAL).setLineSpacing(r114, 1.0f).setIncludePad(r110).build();
        Canvas r123 = r117;
    L34:
        r122.draw(r123);
        CharLayout r124 = new CharLayout();
        if (r111 == false) goto L37;
        float r125 = r121.bottom;
        float r126 = r121.top;
        float r127 = r125 - r126;
        r124.baseline = (r119 - r126) / r115;
    L38:
        r124.top = r119 / r115;
        r119 = r119 + r127;
        r124.bottom = r119 / r115;
        r124.left = 0.0f;
        r124.right = 1.0f;
        r112.charLayouts[r118] = r124;
        r123.translate(0.0f, r127);
        r118 = r118 + 1;
        r117 = r123;
        r115 = r115;
        r113 = r113;
        r114 = 0.0f;
        r110 = 0;
        goto L29
    L37:
        float r128 = r121.descent;
        float r129 = r121.ascent;
        r127 = r128 - r129;
        r124.baseline = (r119 - r129) / r115;
        goto L38
    L33:
        r122 = new StaticLayout(r120, 0, r120.length(), r101, r117.getWidth(), Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
        r123 = r117;
        goto L34
    L39:
        return r112;
    L14:
        r111 = false;
        goto L15
    L9:
        if (TextUtils.isEmpty(r211.fontPath) == true) goto L11;
        r101.setTypeface(FontCache.getFromFile(r211.fontPath, r211.familyName));
        goto L11
    L49:
        return null;
    L40:
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r14v0 */
    /* JADX WARN: Type inference failed for: r14v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r14v5 */
    public static TextBitmapResult generateTextAutoSizedShakeBitmap(String r210, TextLayoutParam r211) {
        String[] r100 = lyricShakeSplit(r210);
        if (TextUtils.isEmpty(r210) == false) goto L6;
        return null;
    L6:
        TextPaint r110 = new TextPaint();
        r110.setAntiAlias(true);
        if (TextUtils.isEmpty(r211.familyName) == false) goto L9;
    L11:
        r110.setTextSize(r211.fontSize);
        ?? r111 = 0;
        if (r110.getFontMetrics().top >= r110.getFontMetrics().ascent) goto L14;
        boolean r112 = true;
    L15:
        Paint.FontMetrics r113 = r110.getFontMetrics();
        ArrayList r114 = new ArrayList();
        float r101 = r211.lineWidth;
        float r102 = 0.0f;
        float r103 = 0.0f;
        int r104 = 0;
        int r105 = 0;
    L17:
        if (r105 >= r100.length) goto L23;
        String r106 = r100[r105];
        if (Build.VERSION.SDK_INT < 23) goto L21;
        StaticLayout r107 = StaticLayout.Builder.obtain(r106, r111, r106.length(), r110, (int) r101).setAlignment(Layout.Alignment.ALIGN_OPPOSITE).setLineSpacing(r102, 1.0f).setIncludePad(r111).build();
    L22:
        r104 = r104 + r107.getLineCount();
        ArrayList r108 = r114;
        r108.add(r107);
        r105 = r105 + 1;
        r114 = r108;
        r113 = r113;
        r101 = r101;
        r110 = r110;
        r102 = 0.0f;
        r111 = 0;
        r103 = r107.getHeight() + r103;
        goto L17
    L21:
        r107 = new StaticLayout(r106, 0, r106.length(), r110, (int) r101, Layout.Alignment.ALIGN_OPPOSITE, 1.0f, 0.0f, false);
        goto L22
    L23:
        float r115 = r103;
        int r109 = r104;
        float r116 = r101;
        ArrayList r117 = r114;
        Paint.FontMetrics r118 = r113;
        TextBitmapResult r119 = new TextBitmapResult();
        r119.channel = 1;
        r119.lineCount = r109;
        r119.type = 0;
        r119.charLayouts = new CharLayout[r109];
        Bitmap r120 = Bitmap.createBitmap(r211.lineWidth, (int) r115, Bitmap.Config.ALPHA_8);
        Canvas r121 = new Canvas(r120);
        r119.bitmap = r120;
        int r122 = 0;
        float r123 = 0.0f;
        int r124 = 0;
    L25:
        if (r122 >= r100.length) goto L39;
        float r125 = ((StaticLayout) ListProtector.get(r117, r122)).getHeight();
        float r126 = r125 / ((StaticLayout) ListProtector.get(r117, r122)).getLineCount();
        int r127 = 0;
    L28:
        if (r127 >= ((StaticLayout) ListProtector.get(r117, r122)).getLineCount()) goto L38;
        CharLayout r128 = new CharLayout();
        float r129 = ((StaticLayout) ListProtector.get(r117, r122)).getLineWidth(r127);
        if (r112 == false) goto L32;
        r128.baseline = (r123 - r118.top) / r115;
    L33:
        r128.top = r123 / r115;
        r123 = r123 + r126;
        float r130 = r126;
        r128.bottom = (r123 - (Math.abs(r118.bottom - r118.descent) / 2.0f)) / r115;
        if (r211.textAlign != 0) goto L36;
        r128.left = 0.0f;
        r128.right = (r116 - r129) / r116;
    L37:
        r119.charLayouts[r124] = r128;
        r124 = r124 + 1;
        r127 = r127 + 1;
        r100 = r100;
        r126 = r130;
        goto L28
    L36:
        r128.left = (r116 - r129) / r116;
        r128.right = 1.0f;
        goto L37
    L32:
        r128.baseline = (r123 - r118.ascent) / r115;
        goto L33
    L38:
        ((StaticLayout) ListProtector.get(r117, r122)).draw(r121);
        r121.translate(0.0f, r125 * ((StaticLayout) ListProtector.get(r117, r122)).getLineCount());
        r122 = r122 + 1;
        r100 = r100;
        goto L25
    L39:
        return r119;
    L14:
        r112 = false;
        goto L15
    L9:
        if (TextUtils.isEmpty(r211.fontPath) == true) goto L11;
        r110.setTypeface(FontCache.getFromFile(r211.fontPath, r211.familyName));
        goto L11
    }

    private static TextBitmapResult generateBitmapAtlasUTF8(String r310, TextLayoutParam r311, COLOR_TYPE r312) {
        if (r310.isEmpty() == false) goto L5;
        return null;
    L5:
        Typeface r100 = Typeface.DEFAULT;
        String r101 = r311.familyName;
        if (r101 != null) goto L8;
    L15:
        int r102 = r311.textColor;
        int r103 = r311.backColor;
        int r104 = r311.shadowColor;
        if (AnonymousClass1.$SwitchMap$com$bef$effectsdk$text$TextLayoutUtils$COLOR_TYPE[r312.ordinal()] == 1) goto L18;
        int r105 = ((r102 & 255) << 24) + ((r102 >> 8) & 16777215);
        int r106 = ((r103 & 255) << 24) + ((r103 >> 8) & 16777215);
        int r107 = ((r104 & 255) << 24) + ((r104 >> 8) & 16777215);
    L19:
        Paint.Style r108 = Paint.Style.FILL;
        int r109 = r311.paintStyle;
        if (r109 == 0) goto L23;
        if (r109 == 1) goto L25;
        if (r109 != 2) goto L23;
        r108 = Paint.Style.FILL_AND_STROKE;
        float r110 = r311.strokeWidth;
    L26:
        TextPaint r111 = new TextPaint(1);
        if (r100 == null) goto L29;
        r111.setTypeface(r100);
    L29:
        r111.setColor(r105);
        r111.setStyle(r108);
        r111.setStrokeWidth(r110);
        r111.setTextSize(r311.fontSize);
        r111.setShadowLayer(r311.shadowRadius, r311.shadowDx, r311.shadowDy, r107);
        int r112 = r311.lineWidth;
        if (r112 > 2048) goto L32;
        if (r112 == 0) goto L32;
    L33:
        TextBitmapResult r113 = new TextBitmapResult();
        r113.channel = 4;
        r113.lineCount = 0;
        r113.type = 1;
        ArrayList r114 = new ArrayList();
        HashMap r115 = new HashMap();
        ArrayList r116 = new ArrayList();
        float r117 = Math.abs(r311.shadowDx) + (r311.shadowRadius / 2.0f);
        float r118 = Math.abs(r311.shadowDy);
        float r119 = r311.shadowRadius;
        float r120 = r118 + (r119 / 2.0f);
        float r121 = r311.letterSpacing;
        if (r121 > 0.0f) goto L37;
        r121 = 0.0f;
    L37:
        int r122 = (int) r121;
        float r123 = r311.lineSpacingAdd;
        if (r123 > 0.0f) goto L41;
        r123 = 0.0f;
    L41:
        int r124 = (int) r123;
        int r125 = (((int) Math.max((-r311.shadowDx) + (r119 / 2.0f), 0.0f)) + r122) + 1;
        int r126 = (((int) (Math.max((-r311.shadowDy) + (r311.shadowRadius / 2.0f), 0.0f) + r311.fontSize)) + r124) + 1;
        int r210 = r106;
        int r127 = 0;
        int r128 = 0;
    L43:
        if (r128 >= r310.length()) goto L88;
        CharLayout r129 = new CharLayout();
        ArrayList r211 = r114;
        r129.charCode = 0;
        r129.isEmoji = false;
        int r130 = r127 + 1;
        r129.charId = r127;
        short r131 = 1;
    L45:
        ArrayList r212 = r116;
        int r132 = r131 + r128;
        int r213 = r124;
        int r133 = r132 + 1;
        if (r310.length() <= r133) goto L65;
        String r134 = r310.substring(r132 - 1, r132);
        String r135 = r310.substring(r132, r133);
        float r214 = r120;
        if (r134.compareTo("\ud800") >= 0) goto L50;
    L58:
        int r136 = r128 + r131;
        int r137 = r136 + 1;
        int r215 = r126;
        String r138 = r310.substring(r136, r137);
        String r139 = r310.substring(r137, r136 + 2);
        if (r138.compareTo("\u200d") != 0) goto L68;
        if (r139.compareTo("\ud800") < 0) goto L68;
        if (r139.compareTo("\udbff") > 0) goto L68;
        r131 = (short) (r131 + 2);
        r116 = r212;
        r124 = r213;
        r126 = r215;
        r120 = r214;
    L68:
        if (r129.isEmoji == true) goto L73;
        byte[] r140 = r310.substring(r128, r128 + r131).getBytes();
        r129.charCode = 0;
        int r141 = 0;
    L71:
        if (r141 >= r140.length) goto L73;
        r129.charCode += (r140[r141] & UByte.MAX_VALUE) << (((r140.length - r141) - 1) * 8);
        r141 = r141 + 1;
    L73:
        CharLayout r142 = (CharLayout) r115.get(Integer.valueOf(r129.charCode));
        if (r142 != null) goto L76;
    L79:
        Rect r143 = new Rect();
        int r144 = r128 + r131;
        r111.getTextBounds(r310, r128, r144, r143);
        r143.left = (int) (r143.left + Math.min(r311.shadowDx - (r311.shadowRadius / 2.0f), 0.0f));
        r143.right = (int) (r143.right + Math.max(r311.shadowDx + (r311.shadowRadius / 2.0f), 0.0f));
        r143.bottom = (int) (r143.bottom + Math.max(r311.shadowDy + (r311.shadowRadius / 2.0f), 0.0f));
        r143.top = (int) (r143.top + Math.min(r311.shadowDy - (r311.shadowRadius / 2.0f), 0.0f));
        float r145 = r111.measureText(r310, r128, r144);
        r129.advance = r145;
        float r146 = r122;
        int r216 = r125;
        if (((((r125 + r145) + r117) + r146) + 1.0f) < r112) goto L85;
        int r147 = (((int) Math.max((-r311.shadowDx) + (r311.shadowRadius / 2.0f), 0.0f)) + r122) + 1;
        int r148 = r213;
        TextPaint r217 = r111;
        int r149 = (int) (r215 + (((r311.fontSize + r214) + r148) + 1.0f));
        if (r149 >= (4194304 / r112)) goto L83;
        int r150 = r149;
        int r151 = r147;
    L86:
        r212.add(new Rect(r128, r144, r151, r150));
        r129.baseline = r150;
        float r152 = r151;
        r129.origin = r152;
        int r218 = r148;
        int r153 = r143.left;
        r129.pos_left = r153;
        int r154 = r143.top;
        ArrayList r219 = r212;
        r129.pos_top = r154;
        int r155 = r143.right;
        r129.pos_right = r155;
        int r156 = r143.bottom;
        r129.pos_bottom = r156;
        r129.left = r153 + r151;
        r129.top = r154 + r150;
        r129.right = r155 + r151;
        r129.bottom = r156 + r150;
        r115.put(Integer.valueOf(r129.charCode), r129);
        r125 = (int) (r152 + (((r145 + r117) + r146) + 1.0f));
        r126 = r150;
    L87:
        r211.add(r129);
        r128 = r128 + r131;
        r114 = r211;
        r127 = r130;
        r124 = r218;
        r111 = r217;
        r116 = r219;
        r120 = r214;
        r112 = r112;
        r122 = r122;
        goto L43
    L83:
        r126 = r149;
        ArrayList r157 = r211;
        ArrayList r220 = r212;
    L89:
        r113.charLayouts = (CharLayout[]) r157.toArray(new CharLayout[0]);
        int r158 = r126 + ((int) r311.fontSize);
        if (AnonymousClass1.$SwitchMap$com$bef$effectsdk$text$TextLayoutUtils$COLOR_TYPE[r312.ordinal()] == 1) goto L92;
        int r159 = r112;
        Bitmap r160 = Bitmap.createBitmap(r159, r158, Bitmap.Config.ARGB_8888);
        r113.channel = 4;
    L93:
        if (r160 != null) goto L96;
        return null;
    L96:
        Paint r161 = new Paint();
        r161.setColor(r210);
        Canvas r162 = new Canvas(r160);
        r162.drawRect(new Rect(0, 0, r159, r158), r161);
        Iterator r163 = r220.iterator();
    L98:
        if (r163.hasNext() == false) goto L100;
        Rect r164 = (Rect) r163.next();
        r162.drawText(r310.substring(r164.left, r164.top), r164.right, r164.bottom, r217);
        goto L98
    L100:
        r113.bitmap = r160;
        int r165 = 0;
    L101:
        CharLayout[] r166 = r113.charLayouts;
        if (r165 >= r166.length) goto L104;
        CharLayout r167 = r166[r165];
        float r168 = r158;
        r167.bottom /= r168;
        r167.top /= r168;
        float r169 = r159;
        r167.left /= r169;
        r167.right /= r169;
        r165 = r165 + 1;
        goto L101
    L104:
        r162.setBitmap(null);
        return r113;
    L92:
        r159 = r112;
        r160 = Bitmap.createBitmap(r159, r158, Bitmap.Config.ALPHA_8);
        r113.channel = 1;
        goto L93
    L85:
        r148 = r213;
        r150 = r215;
        r217 = r111;
        r151 = r216;
        goto L86
    L76:
        if (r129.isEmoji == true) goto L79;
        r129.pos_left = r142.pos_left;
        r129.pos_top = r142.pos_top;
        r129.pos_right = r142.pos_right;
        r129.pos_bottom = r142.pos_bottom;
        r129.left = r142.left;
        r129.top = r142.top;
        r129.right = r142.right;
        r129.bottom = r142.bottom;
        r129.baseline = r142.baseline;
        r129.origin = r142.origin;
        r129.advance = r142.advance;
        r122 = r122;
        r126 = r215;
        r219 = r212;
        r218 = r213;
        r217 = r111;
        goto L87
    L50:
        if (r134.compareTo("\udbff") > 0) goto L58;
        if (r135.compareTo("\udc00") < 0) goto L58;
        if (r135.compareTo("\udfff") > 0) goto L58;
        r129.isEmoji = true;
        r131 = (short) (r131 + 1);
        if (r310.length() >= (r128 + 3)) goto L58;
    L66:
        r215 = r126;
        goto L68
    L65:
        r214 = r120;
        goto L66
    L88:
        r157 = r114;
        r217 = r111;
        r220 = r116;
    L32:
        r112 = 2048;
        goto L33
    L25:
        r108 = Paint.Style.STROKE;
        r110 = r311.strokeWidth;
    L23:
        r110 = 0.0f;
        goto L26
    L18:
        r105 = (r102 & 255) << 24;
        r106 = (r103 & 255) << 24;
        r107 = (r104 & 255) << 24;
        goto L19
    L8:
        if (r101.isEmpty() == true) goto L15;
        String r170 = r311.fontPath;
        if (r170 != null) goto L12;
    L14:
        r100 = FontCache.getFromSystem(r311.familyName, r311.fontStyle);
        goto L15
    L12:
        if (r170.isEmpty() == true) goto L14;
        r100 = FontCache.getFromFile(r311.fontPath, r311.familyName);
        goto L15
    }

    private static TextBitmapResult generateBitmapNormalUTF8(String r210, TextLayoutParam r211, COLOR_TYPE r212) {
        if (r210.isEmpty() == false) goto L5;
        return null;
    L5:
        Typeface r100 = Typeface.DEFAULT;
        String r101 = r211.familyName;
        if (r101 != null) goto L8;
    L15:
        int r102 = r211.textColor;
        int r103 = r211.backColor;
        int r104 = r211.shadowColor;
        if (AnonymousClass1.$SwitchMap$com$bef$effectsdk$text$TextLayoutUtils$COLOR_TYPE[r212.ordinal()] == 1) goto L18;
        int r105 = ((r102 & 255) << 24) + ((r102 >> 8) & 16777215);
        int r106 = ((r103 & 255) << 24) + ((r103 >> 8) & 16777215);
        int r107 = ((r104 & 255) << 24) + ((r104 >> 8) & 16777215);
    L19:
        int r110 = r106;
        Paint.Style r108 = Paint.Style.FILL;
        int r109 = r211.paintStyle;
        float r111 = 0.0f;
        if (r109 == 0) goto L23;
        if (r109 == 1) goto L25;
        if (r109 != 2) goto L23;
        r108 = Paint.Style.FILL_AND_STROKE;
        float r112 = r211.strokeWidth;
    L26:
        Layout.Alignment r113 = Layout.Alignment.ALIGN_NORMAL;
        int r114 = r211.textAlign;
        if (r114 == 0) goto L33;
        if (r114 == 1) goto L32;
        if (r114 != 2) goto L33;
        r113 = Layout.Alignment.ALIGN_CENTER;
        goto L33
    L32:
        r113 = Layout.Alignment.ALIGN_OPPOSITE;
    L33:
        int r115 = r211.maxLine;
        int r116 = r211.lineWidth;
        if (r116 != 0) goto L36;
        r115 = 1;
        r116 = 2048;
        int r117 = 2048;
        boolean r118 = false;
    L38:
        if (r115 != 1) goto L53;
        int r119 = r211.lineBreakMode;
        if (r119 == 0) goto L51;
        if (r119 == 1) goto L51;
        if (r119 != 2) goto L44;
        TextUtils.TruncateAt r120 = TextUtils.TruncateAt.START;
    L52:
        TextUtils.TruncateAt r121 = r120;
        int r122 = 2048;
    L47:
        r118 = false;
    L54:
        if (r117 <= r122) goto L56;
        r117 = 2048;
    L56:
        if (r116 <= r122) goto L58;
        r116 = 2048;
    L58:
        if (r115 != 0) goto L60;
        r115 = Integer.MAX_VALUE;
    L60:
        TextPaint r123 = new TextPaint(1);
        if (r100 == null) goto L63;
        r123.setTypeface(r100);
    L63:
        r123.setColor(r105);
        r123.setStyle(r108);
        r123.setStrokeWidth(r112);
        r123.setTextSize(r211.fontSize);
        r123.setShadowLayer(r211.shadowRadius, r211.shadowDx, r211.shadowDy, r107);
        int r124 = Build.VERSION.SDK_INT;
        r123.setLetterSpacing(r211.letterSpacing);
        BoringLayout.Metrics r213 = BoringLayout.isBoring(r210, r123);
        if (r115 != 1) goto L69;
        if (r213 == null) goto L69;
        if (r121 == TextUtils.TruncateAt.MARQUEE) goto L69;
        int r214 = r115;
        Layout r125 = new BoringLayout(r210, r123, r116, r113, r211.lineSpacingMult, r211.lineSpacingAdd, r213, true, r121, r117);
        int r126 = r116;
    L72:
        int r127 = 0;
    L74:
        int r128 = Math.min(r125.getLineCount(), r214);
        if (r128 != 0) goto L78;
        return null;
    L78:
        if (r118 == false) goto L80;
        r117 = r126;
    L80:
        int r129 = r117;
        int r130 = 0;
        int r131 = 0;
        int r132 = 0;
    L81:
        if (r132 >= r128) goto L86;
        int r133 = 2048;
        if (Math.max(r125.getLineBottom(r132), r130) > 2048) goto L87;
        r129 = Math.max((int) (r125.getLineRight(r132) - r125.getLineLeft(r132)), r129);
        r130 = Math.max(r125.getLineBottom(r132), r130);
        r131 = r131 + 1;
        r132 = r132 + 1;
    L87:
        if (r129 <= r133) goto L90;
        r129 = 2048;
    L90:
        if (r125.getLineBottom(r127) != 0) goto L93;
        return null;
    L93:
        if (r131 != 0) goto L95;
        int r134 = 1;
        r130 = 2048;
    L97:
        if (r134 != r125.getLineCount()) goto L101;
        Paint.FontMetrics r135 = r123.getFontMetrics();
        float r136 = r211.lineSpacingAdd + (r211.lineSpacingMult * ((r135.descent + Math.abs(r135.ascent)) + r135.leading));
        int r137 = r134 - 1;
        float r138 = r136 - (r125.getLineBottom(r137) - r125.getLineTop(r137));
        if (r138 <= 0.0f) goto L101;
        r111 = r138 + 0.5f;
        r130 = (int) (r130 + r111);
    L101:
        TextBitmapResult r139 = new TextBitmapResult();
        r139.channel = 4;
        r139.lineCount = r134;
        r139.type = 1;
        r139.charLayouts = new CharLayout[r134];
        int r140 = 0;
    L102:
        if (r140 >= r134) goto L109;
        r139.charLayouts[r140] = new CharLayout();
        float r141 = r130;
        r139.charLayouts[r140].baseline = r125.getLineBaseline(r140) / r141;
        CharLayout r142 = r139.charLayouts[r140];
        float r143 = r129;
        float r144 = r125.getLineLeft(r140) / r143;
        r142.left = r144;
        r142.pos_left = r144;
        CharLayout r145 = r139.charLayouts[r140];
        float r146 = r125.getLineTop(r140) / r141;
        r145.top = r146;
        r145.pos_top = r146;
        CharLayout r147 = r139.charLayouts[r140];
        float r148 = r125.getLineRight(r140) / r143;
        r147.right = r148;
        r147.pos_right = r148;
        if (r140 != (r134 - 1)) goto L106;
        CharLayout r149 = r139.charLayouts[r140];
        float r150 = (r125.getLineBottom(r140) + r111) / r141;
        r149.bottom = r150;
        r149.pos_bottom = r150;
    L107:
        r139.charLayouts[r140].charCode = -2;
        r140 = r140 + 1;
        goto L102
    L106:
        CharLayout r151 = r139.charLayouts[r140];
        float r152 = r125.getLineBottom(r140) / r141;
        r151.bottom = r152;
        r151.pos_bottom = r152;
        goto L107
    L109:
        if (AnonymousClass1.$SwitchMap$com$bef$effectsdk$text$TextLayoutUtils$COLOR_TYPE[r212.ordinal()] == 1) goto L111;
        Bitmap r153 = Bitmap.createBitmap(r129, r130, Bitmap.Config.ARGB_8888);
        r139.channel = 4;
    L112:
        r153.setPremultiplied(true);
        Canvas r154 = new Canvas(r153);
        Paint r155 = new Paint();
        r155.setColor(r110);
        r154.drawRect(new Rect(r127, r127, r129, r130), r155);
        r125.draw(r154);
        r139.bitmap = r153;
        r154.setBitmap(null);
        return r139;
    L111:
        r153 = Bitmap.createBitmap(r129, r130, Bitmap.Config.ALPHA_8);
        r139.channel = 1;
        goto L112
    L95:
        r134 = r131;
        goto L97
    L86:
        r133 = 2048;
    L69:
        r214 = r115;
        int r156 = r116;
        if (r124 < 23) goto L73;
        r126 = r156;
        r125 = StaticLayout.Builder.obtain(r210, 0, r210.length(), r123, r156).setAlignment(r113).setLineSpacing(r211.lineSpacingAdd, r211.lineSpacingMult).setIncludePad(true).setEllipsize(r121).setEllipsizedWidth(r117).build();
        goto L72
    L73:
        r126 = r156;
        r127 = 0;
        r125 = new StaticLayout(r210, 0, r210.length(), r123, r156, r113, r211.lineSpacingMult, r211.lineSpacingAdd, true, r121, r117);
        goto L74
    L44:
        if (r119 == 3) goto L49;
        if (r119 == 4) goto L48;
        r122 = 2048;
        r121 = null;
        goto L47
    L48:
        r120 = TextUtils.TruncateAt.END;
        goto L52
    L49:
        r120 = TextUtils.TruncateAt.MIDDLE;
    L51:
        r120 = TextUtils.TruncateAt.MARQUEE;
        goto L52
    L53:
        r122 = 2048;
        r121 = null;
        goto L54
    L36:
        r117 = r116;
        r118 = true;
        goto L38
    L25:
        r108 = Paint.Style.STROKE;
        r112 = r211.strokeWidth;
    L23:
        r112 = 0.0f;
        goto L26
    L18:
        r105 = (r102 & 255) << 24;
        r106 = (r103 & 255) << 24;
        r107 = (r104 & 255) << 24;
        goto L19
    L8:
        if (r101.isEmpty() == true) goto L15;
        String r157 = r211.fontPath;
        if (r157 != null) goto L12;
    L14:
        r100 = FontCache.getFromSystem(r211.familyName, r211.fontStyle);
        goto L15
    L12:
        if (r157.isEmpty() == true) goto L14;
        r100 = FontCache.getFromFile(r211.fontPath, r211.familyName);
        goto L15
    }
}
