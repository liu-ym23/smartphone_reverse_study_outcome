package androidx.compose.ui.graphics;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import androidx.compose.ui.graphics.colorspace.ColorSpace;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\u0010\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0005H\u0000\u001a7\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0000¢\u0006\u0004\b\u0010\u0010\u0011\u001a\n\u0010\u0012\u001a\u00020\u0002*\u00020\u0001\u001a\u0013\u0010\u0013\u001a\u00020\u0014*\u00020\u000bH\u0000¢\u0006\u0004\b\u0015\u0010\u0016\u001a\u0011\u0010\u0017\u001a\u00020\u000b*\u00020\u0014H\u0000¢\u0006\u0002\u0010\u0018¨\u0006\u0019"}, d2 = {"asImageBitmap", "Landroidx/compose/ui/graphics/ImageBitmap;", "Landroid/graphics/Bitmap;", "createImageBitmap", HTTP.CONTENT_RANGE_BYTES, "", "ActualImageBitmap", "width", "", "height", "config", "Landroidx/compose/ui/graphics/ImageBitmapConfig;", "hasAlpha", "", "colorSpace", "Landroidx/compose/ui/graphics/colorspace/ColorSpace;", "ActualImageBitmap-x__-hDU", "(IIIZLandroidx/compose/ui/graphics/colorspace/ColorSpace;)Landroidx/compose/ui/graphics/ImageBitmap;", "asAndroidBitmap", "toBitmapConfig", "Landroid/graphics/Bitmap$Config;", "toBitmapConfig-1JJdX4A", "(I)Landroid/graphics/Bitmap$Config;", "toImageConfig", "(Landroid/graphics/Bitmap$Config;)I", "ui-graphics_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class AndroidImageBitmap_androidKt {
    public static final Bitmap asAndroidBitmap(ImageBitmap r100) {
        if ((r100 instanceof AndroidImageBitmap) == false) goto L7;
        return ((AndroidImageBitmap) r100).getBitmap$ui_graphics_release();
    L7:
        throw new UnsupportedOperationException("Unable to obtain android.graphics.Bitmap");
    }

    public static final ImageBitmap asImageBitmap(Bitmap r100) {
        return new AndroidImageBitmap(r100);
    }

    public static final ImageBitmap createImageBitmap(byte[] r100) {
        return asImageBitmap(BitmapFactory.decodeByteArray(r100, 0, r100.length));
    }

    /* JADX INFO: renamed from: toBitmapConfig-1JJdX4A, reason: not valid java name */
    public static final Bitmap.Config m4694toBitmapConfig1JJdX4A(int r100) {
        ImageBitmapConfig.Companion r101 = ImageBitmapConfig.Companion;
        if (ImageBitmapConfig.m5062equalsimpl0(r100, r101.m5067getArgb8888_sVssgQ()) == false) goto L6;
        return Bitmap.Config.ARGB_8888;
    L6:
        if (ImageBitmapConfig.m5062equalsimpl0(r100, r101.m5066getAlpha8_sVssgQ()) == false) goto L9;
        return Bitmap.Config.ALPHA_8;
    L9:
        if (ImageBitmapConfig.m5062equalsimpl0(r100, r101.m5070getRgb565_sVssgQ()) == true) goto L24;
        int r102 = Build.VERSION.SDK_INT;
        if (r102 >= 26) goto L14;
    L16:
        if (r102 < 26) goto L21;
        if (ImageBitmapConfig.m5062equalsimpl0(r100, r101.m5069getGpu_sVssgQ()) == false) goto L21;
        return Bitmap.Config.HARDWARE;
    L21:
        return Bitmap.Config.ARGB_8888;
    L14:
        if (ImageBitmapConfig.m5062equalsimpl0(r100, r101.m5068getF16_sVssgQ()) == false) goto L16;
        return Bitmap.Config.RGBA_F16;
    L24:
        return Bitmap.Config.RGB_565;
    }

    public static final int toImageConfig(Bitmap.Config r100) {
        if (r100 != Bitmap.Config.ALPHA_8) goto L6;
        return ImageBitmapConfig.Companion.m5066getAlpha8_sVssgQ();
    L6:
        if (r100 != Bitmap.Config.RGB_565) goto L9;
        return ImageBitmapConfig.Companion.m5070getRgb565_sVssgQ();
    L9:
        if (r100 == Bitmap.Config.ARGB_4444) goto L24;
        int r101 = Build.VERSION.SDK_INT;
        if (r101 >= 26) goto L14;
    L16:
        if (r101 < 26) goto L21;
        if (r100 != Bitmap.Config.HARDWARE) goto L21;
        return ImageBitmapConfig.Companion.m5069getGpu_sVssgQ();
    L21:
        return ImageBitmapConfig.Companion.m5067getArgb8888_sVssgQ();
    L14:
        if (r100 != Bitmap.Config.RGBA_F16) goto L16;
        return ImageBitmapConfig.Companion.m5068getF16_sVssgQ();
    L24:
        return ImageBitmapConfig.Companion.m5067getArgb8888_sVssgQ();
    }

    /* JADX INFO: renamed from: ActualImageBitmap-x__-hDU, reason: not valid java name */
    public static final ImageBitmap m4693ActualImageBitmapx__hDU(int r100, int r101, int r102, boolean r103, ColorSpace r104) {
        Bitmap.Config r105 = m4694toBitmapConfig1JJdX4A(r102);
        if (Build.VERSION.SDK_INT < 26) goto L5;
        Bitmap r106 = Api26Bitmap.m4733createBitmapx__hDU$ui_graphics_release(r100, r101, r102, r103, r104);
    L7:
        return new AndroidImageBitmap(r106);
    L5:
        r106 = Bitmap.createBitmap(null, r100, r101, r105);
        r106.setHasAlpha(r103);
        goto L7
    }
}
