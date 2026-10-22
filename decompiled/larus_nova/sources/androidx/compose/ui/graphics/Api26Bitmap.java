package androidx.compose.ui.graphics;

import android.graphics.Bitmap;
import androidx.compose.ui.graphics.colorspace.ColorSpace;
import androidx.compose.ui.graphics.colorspace.ColorSpaces;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J7\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0011\u0010\u0011\u001a\u00020\u000e*\u00020\u0005H\u0001¢\u0006\u0002\b\u0012¨\u0006\u0013"}, d2 = {"Landroidx/compose/ui/graphics/Api26Bitmap;", "", "<init>", "()V", "createBitmap", "Landroid/graphics/Bitmap;", "width", "", "height", "bitmapConfig", "Landroidx/compose/ui/graphics/ImageBitmapConfig;", "hasAlpha", "", "colorSpace", "Landroidx/compose/ui/graphics/colorspace/ColorSpace;", "createBitmap-x__-hDU$ui_graphics_release", "(IIIZLandroidx/compose/ui/graphics/colorspace/ColorSpace;)Landroid/graphics/Bitmap;", "composeColorSpace", "composeColorSpace$ui_graphics_release", "ui-graphics_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class Api26Bitmap {
    public static final Api26Bitmap INSTANCE = null;

    static {
        INSTANCE = new Api26Bitmap();
    }

    private Api26Bitmap() {
    }

    @JvmStatic
    public static final ColorSpace composeColorSpace$ui_graphics_release(Bitmap r100) {
        android.graphics.ColorSpace r101 = r100.getColorSpace();
        if (r101 == null) goto L7;
        ColorSpace r102 = AndroidColorSpace_androidKt.toComposeColorSpace(r101);
        if (r102 == null) goto L7;
        return r102;
    L7:
        return ColorSpaces.INSTANCE.getSrgb();
    }

    @JvmStatic
    /* JADX INFO: renamed from: createBitmap-x__-hDU$ui_graphics_release, reason: not valid java name */
    public static final Bitmap m4733createBitmapx__hDU$ui_graphics_release(int r100, int r101, int r102, boolean r103, ColorSpace r110) {
        return Bitmap.createBitmap(null, r100, r101, AndroidImageBitmap_androidKt.m4694toBitmapConfig1JJdX4A(r102), r103, AndroidColorSpace_androidKt.toAndroidColorSpace(r110));
    }
}
