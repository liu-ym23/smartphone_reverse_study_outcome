package androidx.compose.ui.graphics;

import androidx.compose.ui.graphics.colorspace.ColorSpace;
import androidx.compose.ui.graphics.colorspace.ColorSpaces;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0015\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0000\u001aP\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00042\b\b\u0002\u0010\u000b\u001a\u00020\u0004\u001a;\u0010\f\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u0012¢\u0006\u0004\b\u0013\u0010\u0014\u001a\n\u0010\u0015\u001a\u00020\u0002*\u00020\u0016¨\u0006\u0017"}, d2 = {"toPixelMap", "Landroidx/compose/ui/graphics/PixelMap;", "Landroidx/compose/ui/graphics/ImageBitmap;", "startX", "", "startY", "width", "height", "buffer", "", "bufferOffset", "stride", "ImageBitmap", "config", "Landroidx/compose/ui/graphics/ImageBitmapConfig;", "hasAlpha", "", "colorSpace", "Landroidx/compose/ui/graphics/colorspace/ColorSpace;", "ImageBitmap-x__-hDU", "(IIIZLandroidx/compose/ui/graphics/colorspace/ColorSpace;)Landroidx/compose/ui/graphics/ImageBitmap;", "decodeToImageBitmap", "", "ui-graphics_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class ImageBitmapKt {
    public static final ImageBitmap decodeToImageBitmap(byte[] r100) {
        return AndroidImageBitmap_androidKt.createImageBitmap(r100);
    }

    /* JADX INFO: renamed from: ImageBitmap-x__-hDU, reason: not valid java name */
    public static final ImageBitmap m5071ImageBitmapx__hDU(int r100, int r101, int r102, boolean r103, ColorSpace r104) {
        return AndroidImageBitmap_androidKt.m4693ActualImageBitmapx__hDU(r100, r101, r102, r103, r104);
    }

    /* JADX INFO: renamed from: ImageBitmap-x__-hDU$default, reason: not valid java name */
    public static /* synthetic */ ImageBitmap m5072ImageBitmapx__hDU$default(int r100, int r101, int r102, boolean r103, ColorSpace r104, int r105, Object r106) {
        if ((r105 & 4) == 0) goto L6;
        r102 = ImageBitmapConfig.Companion.m5067getArgb8888_sVssgQ();
    L6:
        if ((r105 & 8) == 0) goto L9;
        r103 = true;
    L9:
        if ((r105 & 16) == 0) goto L12;
        r104 = ColorSpaces.INSTANCE.getSrgb();
    L12:
        return m5071ImageBitmapx__hDU(r100, r101, r102, r103, r104);
    }

    public static final PixelMap toPixelMap(ImageBitmap r100, int r101, int r110, int r111, int r112, int[] r113, int r114, int r115) {
        r100.readPixels(r113, r101, r110, r111, r112, r114, r115);
        return new PixelMap(r113, r111, r112, r114, r115);
    }

    public static /* synthetic */ PixelMap toPixelMap$default(ImageBitmap r100, int r101, int r102, int r103, int r104, int[] r105, int r106, int r107, int r108, Object r110) {
        if ((r108 & 1) == 0) goto L6;
        r101 = 0;
    L6:
        if ((r108 & 2) == 0) goto L9;
        r102 = 0;
    L9:
        if ((r108 & 4) == 0) goto L12;
        r103 = r100.getWidth();
    L12:
        if ((r108 & 8) == 0) goto L15;
        r104 = r100.getHeight();
    L15:
        if ((r108 & 16) == 0) goto L18;
        r105 = new int[r103 * r104];
    L18:
        if ((r108 & 32) == 0) goto L21;
        r106 = 0;
    L21:
        if ((r108 & 64) == 0) goto L24;
        r107 = r103;
    L24:
        return toPixelMap(r100, r101, r102, r103, r104, r105, r106, r107);
    }
}
