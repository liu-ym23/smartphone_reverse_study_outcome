package androidx.core.graphics;

import android.graphics.Bitmap;
import android.graphics.BlendMode;
import android.graphics.Canvas;
import android.graphics.ColorSpace;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.os.Build;
import androidx.annotation.ReplaceWith;

/* JADX INFO: loaded from: classes17.dex */
public final class BitmapCompat {

    public static class Api27Impl {
        private Api27Impl() {
        }

        public static Bitmap copyBitmapIfHardware(Bitmap r100) {
            if (r100.getConfig() != Bitmap.Config.HARDWARE) goto L9;
            Bitmap.Config r101 = Bitmap.Config.ARGB_8888;
            if (Build.VERSION.SDK_INT < 31) goto L8;
            r101 = Api31Impl.getHardwareBitmapConfig(r100);
        L8:
            return r100.copy(r101, true);
        L9:
            return r100;
        }

        public static boolean isAlreadyF16AndLinear(Bitmap r100) {
            ColorSpace r101 = ColorSpace.get(ColorSpace.Named.LINEAR_EXTENDED_SRGB);
            if (r100.getConfig() == Bitmap.Config.RGBA_F16) goto L5;
        L7:
            return false;
        L5:
            if (r100.getColorSpace().equals(r101) == false) goto L7;
            return true;
        }

        public static Bitmap createBitmapWithSourceColorspace(int r100, int r101, Bitmap r102, boolean r103) {
            Bitmap.Config r104 = r102.getConfig();
            ColorSpace r105 = r102.getColorSpace();
            ColorSpace r106 = ColorSpace.get(ColorSpace.Named.LINEAR_EXTENDED_SRGB);
            if (r103 == false) goto L8;
            if (r102.getColorSpace().equals(r106) == true) goto L8;
            r104 = Bitmap.Config.RGBA_F16;
            r105 = r106;
        L13:
            return Bitmap.createBitmap(r100, r101, r104, r102.hasAlpha(), r105);
        L8:
            if (r102.getConfig() != Bitmap.Config.HARDWARE) goto L13;
            r104 = Bitmap.Config.ARGB_8888;
            if (Build.VERSION.SDK_INT < 31) goto L13;
            r104 = Api31Impl.getHardwareBitmapConfig(r102);
            goto L13
        }
    }

    public static class Api29Impl {
        private Api29Impl() {
        }

        public static void setPaintBlendMode(Paint r100) {
            r100.setBlendMode(BlendMode.SRC);
        }
    }

    public static class Api31Impl {
        private Api31Impl() {
        }

        public static Bitmap.Config getHardwareBitmapConfig(Bitmap r100) {
            if (r100.getHardwareBuffer().getFormat() != 22) goto L7;
            return Bitmap.Config.RGBA_F16;
        L7:
            return Bitmap.Config.ARGB_8888;
        }
    }

    public static int sizeAtStep(int r100, int r101, int r102, int r103) {
        if (r102 != 0) goto L5;
        return r101;
    L5:
        if (r102 <= 0) goto L9;
        return r100 * (1 << (r103 - r102));
    L9:
        return r101 << ((-r102) - 1);
    }

    private BitmapCompat() {
    }

    @ReplaceWith(expression = "bitmap.getAllocationByteCount()")
    public static int getAllocationByteCount(Bitmap r100) {
        return r100.getAllocationByteCount();
    }

    @ReplaceWith(expression = "bitmap.hasMipMap()")
    public static boolean hasMipMap(Bitmap r100) {
        return r100.hasMipMap();
    }

    @ReplaceWith(expression = "bitmap.setHasMipMap(hasMipMap)")
    public static void setHasMipMap(Bitmap r100, boolean r101) {
        r100.setHasMipMap(r101);
    }

    public static Bitmap createScaledBitmap(Bitmap r210, int r211, int r212, Rect r213, boolean r214) {
        if (r211 <= 0) goto L142;
        if (r212 <= 0) goto L142;
        if (r213 != null) goto L7;
    L19:
        int r100 = Build.VERSION.SDK_INT;
        if (r100 < 27) goto L22;
        Bitmap r101 = Api27Impl.copyBitmapIfHardware(r210);
    L23:
        if (r213 == null) goto L25;
        int r102 = r213.width();
    L26:
        if (r213 == null) goto L28;
        int r103 = r213.height();
    L29:
        float r104 = r211 / r102;
        float r110 = r212 / r103;
        if (r213 == null) goto L32;
        int r111 = r213.left;
    L33:
        if (r213 == null) goto L35;
        int r105 = r213.top;
    L37:
        if (r111 != 0) goto L49;
        if (r105 != 0) goto L49;
        if (r211 != r210.getWidth()) goto L49;
        if (r212 != r210.getHeight()) goto L49;
        if (r210.isMutable() == false) goto L48;
        if (r210 != r101) goto L48;
        return r210.copy(r210.getConfig(), true);
    L48:
        return r101;
    L49:
        Paint r112 = new Paint(1);
        r112.setFilterBitmap(true);
        if (r100 < 29) goto L52;
        Api29Impl.setPaintBlendMode(r112);
    L53:
        if (r102 != r211) goto L57;
        if (r103 != r212) goto L57;
        Bitmap r106 = Bitmap.createBitmap(r211, r212, r101.getConfig());
        new Canvas(r106).drawBitmap(r101, -r111, -r105, r112);
        return r106;
    L57:
        double r113 = Math.log(2.0d);
        if (r104 <= 1.0f) goto L60;
        double r114 = Math.ceil(Math.log(r104) / r113);
    L61:
        int r107 = (int) r114;
        if (r110 <= 1.0f) goto L64;
        double r115 = Math.ceil(Math.log(r110) / r113);
    L65:
        int r116 = (int) r115;
        if (r214 == false) goto L78;
        if (r100 < 27) goto L78;
        if (Api27Impl.isAlreadyF16AndLinear(r210) == true) goto L78;
        if (r107 <= 0) goto L73;
        int r117 = sizeAtStep(r102, r211, 1, r107);
    L74:
        if (r116 <= 0) goto L76;
        int r118 = sizeAtStep(r103, r212, 1, r116);
    L77:
        Bitmap r119 = Api27Impl.createBitmapWithSourceColorspace(r117, r118, r210, true);
        Paint r120 = r112;
        new Canvas(r119).drawBitmap(r101, -r111, -r105, r120);
        r105 = 0;
        r111 = 0;
        int r121 = 1;
        Bitmap r122 = r101;
        r101 = r119;
    L79:
        Rect r123 = new Rect(r111, r105, r102, r103);
        Rect r108 = new Rect();
        int r124 = r107;
        int r125 = r116;
    L80:
        if (r124 != 0) goto L87;
        if (r125 != 0) goto L87;
        if (r122 == r210) goto L86;
        if (r122 == null) goto L86;
        r122.recycle();
    L86:
        return r101;
    L87:
        if (r124 >= 0) goto L89;
        r124 = r124 + 1;
    L91:
        if (r125 >= 0) goto L93;
        r125 = r125 + 1;
    L95:
        int r109 = r125;
        Paint r215 = r120;
        Rect r126 = r123;
        r108.set(0, 0, sizeAtStep(r102, r211, r124, r107), sizeAtStep(r103, r212, r109, r116));
        if (r124 != 0) goto L99;
        if (r109 != 0) goto L99;
        boolean r127 = true;
    L100:
        if (r122 != null) goto L102;
    L106:
        boolean r128 = false;
    L107:
        if (r122 == null) goto L121;
        if (r122 == r210) goto L121;
        if (r214 == false) goto L115;
        Rect r129 = r108;
        if (Build.VERSION.SDK_INT >= 27) goto L113;
    L116:
        if (r127 == false) goto L120;
        if (r128 == false) goto L122;
        if (r121 == 0) goto L120;
    L122:
        if (r122 == r210) goto L125;
        if (r122 == null) goto L125;
        r122.recycle();
    L125:
        if (r124 <= 0) goto L127;
        int r130 = r121;
    L128:
        int r131 = sizeAtStep(r102, r211, r130, r107);
        if (r109 <= 0) goto L131;
        int r132 = r121;
    L132:
        int r133 = sizeAtStep(r103, r212, r132, r116);
        if (Build.VERSION.SDK_INT < 27) goto L139;
        if (r214 == false) goto L137;
        if (r127 == true) goto L137;
        boolean r134 = true;
    L138:
        Bitmap r135 = Api27Impl.createBitmapWithSourceColorspace(r131, r133, r210, r134);
    L140:
        Rect r136 = r129;
        new Canvas(r135).drawBitmap(r101, r126, r136, r215);
        r126.set(r136);
        r125 = r109;
        Bitmap r216 = r101;
        r101 = r135;
        r108 = r136;
        r123 = r126;
        r120 = r215;
        r122 = r216;
    L137:
        r134 = false;
        goto L138
    L139:
        r135 = Bitmap.createBitmap(r131, r133, r101.getConfig());
        goto L140
    L131:
        r132 = r109;
        goto L132
    L127:
        r130 = r124;
    L120:
        r135 = r122;
        goto L140
    L113:
        if (Api27Impl.isAlreadyF16AndLinear(r122) == false) goto L122;
    L115:
        r129 = r108;
    L121:
        r129 = r108;
        goto L122
    L102:
        if (r122.getWidth() != r211) goto L106;
        if (r122.getHeight() != r212) goto L106;
        r128 = true;
    L99:
        r127 = false;
        goto L100
    L93:
        if (r125 <= 0) goto L95;
        r125 = r125 - 1;
        goto L95
    L89:
        if (r124 <= 0) goto L91;
        r124 = r124 - 1;
        goto L91
    L76:
        r118 = r103;
        goto L77
    L73:
        r117 = r102;
    L78:
        r120 = r112;
        r122 = null;
        r121 = 0;
        goto L79
    L64:
        r115 = Math.floor(Math.log(r110) / r113);
        goto L65
    L60:
        r114 = Math.floor(Math.log(r104) / r113);
        goto L61
    L52:
        r112.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
        goto L53
    L35:
        r105 = 0;
        goto L37
    L32:
        r111 = 0;
        goto L33
    L28:
        r103 = r210.getHeight();
        goto L29
    L25:
        r102 = r210.getWidth();
        goto L26
    L22:
        r101 = r210;
        goto L23
    L7:
        if (r213.isEmpty() == true) goto L18;
        if (r213.left < 0) goto L18;
        if (r213.right > r210.getWidth()) goto L18;
        if (r213.top < 0) goto L18;
        if (r213.bottom <= r210.getHeight()) goto L19;
    L18:
        throw new IllegalArgumentException("srcRect must be contained by srcBm!");
    L142:
        throw new IllegalArgumentException("dstW and dstH must be > 0!");
    }
}
