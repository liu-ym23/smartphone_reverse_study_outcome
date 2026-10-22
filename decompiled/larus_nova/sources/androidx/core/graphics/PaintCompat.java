package androidx.core.graphics;

import android.graphics.BlendMode;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.os.Build;
import androidx.core.util.Pair;

/* JADX INFO: loaded from: classes6.dex */
public final class PaintCompat {
    private static final String EM_STRING = "m";
    private static final String TOFU_STRING = "\udfffd";
    private static final ThreadLocal<Pair<Rect, Rect>> sRectThreadLocal = null;

    /* JADX INFO: loaded from: classes17.dex */
    public static class Api23Impl {
        private Api23Impl() {
        }

        public static boolean hasGlyph(Paint r100, String r101) {
            return r100.hasGlyph(r101);
        }
    }

    /* JADX INFO: loaded from: classes17.dex */
    public static class Api29Impl {
        private Api29Impl() {
        }

        public static void setBlendMode(Paint r100, Object r101) {
            r100.setBlendMode((BlendMode) r101);
        }
    }

    static {
        sRectThreadLocal = new ThreadLocal();
    }

    private static Pair<Rect, Rect> obtainEmptyRects() {
        ThreadLocal<Pair<Rect, Rect>> r100 = sRectThreadLocal;
        Pair<Rect, Rect> r101 = r100.get();
        if (r101 != null) goto L5;
        Pair<Rect, Rect> r102 = new Pair(new Rect(), new Rect());
        r100.set(r102);
        return r102;
    L5:
        r101.first.setEmpty();
        r101.second.setEmpty();
        return r101;
    }

    private PaintCompat() {
    }

    public static boolean hasGlyph(Paint r100, String r110) {
        if (Build.VERSION.SDK_INT >= 23) goto L5;
        int r101 = r110.length();
        if (r101 == 1) goto L9;
    L11:
        float r102 = r100.measureText(TOFU_STRING);
        float r103 = r100.measureText(EM_STRING);
        float r104 = r100.measureText(r110);
        float r105 = 0.0f;
        if (r104 != 0.0f) goto L15;
        return false;
    L15:
        if (r110.codePointCount(0, r110.length()) <= 1) goto L26;
        if (r104 <= (r103 * 2.0f)) goto L19;
        return false;
    L19:
        int r106 = 0;
    L20:
        if (r106 >= r101) goto L23;
        int r107 = Character.charCount(r110.codePointAt(r106)) + r106;
        r105 = r105 + r100.measureText(r110, r106, r107);
        r106 = r107;
        goto L20
    L23:
        if (r104 < r105) goto L26;
        return false;
    L26:
        if (r104 == r102) goto L28;
        return true;
    L28:
        Pair<Rect, Rect> r108 = obtainEmptyRects();
        r100.getTextBounds(TOFU_STRING, 0, 2, r108.first);
        r100.getTextBounds(r110, 0, r101, r108.second);
        return !r108.first.equals(r108.second);
    L9:
        if (Character.isWhitespace(r110.charAt(0)) == false) goto L11;
        return true;
    L5:
        return Api23Impl.hasGlyph(r100, r110);
    }

    public static boolean setBlendMode(Paint r100, BlendModeCompat r101) {
        PorterDuffXfermode r102 = null;
        Object r103 = null;
        if (Build.VERSION.SDK_INT < 29) goto L8;
        if (r101 == null) goto L6;
        r103 = BlendModeUtils.Api29Impl.obtainBlendModeFromCompat(r101);
    L6:
        Api29Impl.setBlendMode(r100, r103);
        return true;
    L8:
        if (r101 == null) goto L17;
        PorterDuff.Mode r104 = BlendModeUtils.obtainPorterDuffFromCompat(r101);
        if (r104 == null) goto L12;
        r102 = new PorterDuffXfermode(r104);
    L12:
        r100.setXfermode(r102);
        if (r104 != null) goto L19;
        return false;
    L19:
        return true;
    L17:
        r100.setXfermode(null);
        return true;
    }
}
