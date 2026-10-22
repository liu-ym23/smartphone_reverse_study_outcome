package androidx.compose.ui.graphics;

import androidx.compose.ui.graphics.colorspace.ColorSpace;
import androidx.compose.ui.graphics.colorspace.ColorSpaces;
import kotlin.Metadata;

@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0015\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0000\u001aP\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00042\b\b\u0002\u0010\u000b\u001a\u00020\u0004\u001a;\u0010\f\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u0012¢\u0006\u0004\b\u0013\u0010\u0014\u001a\n\u0010\u0015\u001a\u00020\u0002*\u00020\u0016¨\u0006\u0017"}, d2 = {"toPixelMap", "Landroidx/compose/ui/graphics/PixelMap;", "Landroidx/compose/ui/graphics/ImageBitmap;", "startX", "", "startY", "width", "height", "buffer", "", "bufferOffset", "stride", "ImageBitmap", "config", "Landroidx/compose/ui/graphics/ImageBitmapConfig;", "hasAlpha", "", "colorSpace", "Landroidx/compose/ui/graphics/colorspace/ColorSpace;", "ImageBitmap-x__-hDU", "(IIIZLandroidx/compose/ui/graphics/colorspace/ColorSpace;)Landroidx/compose/ui/graphics/ImageBitmap;", "decodeToImageBitmap", "", "ui-graphics_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ImageBitmapKt {
    /* renamed from: ImageBitmap-x__-hDU, reason: not valid java name */
    public static final ImageBitmap m4374ImageBitmapx__hDU(int i, int i6, int i10, boolean z10, ColorSpace colorSpace) {
        return AndroidImageBitmap_androidKt.m4005ActualImageBitmapx__hDU(i, i6, i10, z10, colorSpace);
    }

    /* renamed from: ImageBitmap-x__-hDU$default, reason: not valid java name */
    public static /* synthetic */ ImageBitmap m4375ImageBitmapx__hDU$default(int i, int i6, int i10, boolean z10, ColorSpace colorSpace, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            i10 = ImageBitmapConfig.INSTANCE.m4370getArgb8888_sVssgQ();
        }
        if ((i11 & 8) != 0) {
            z10 = true;
        }
        if ((i11 & 16) != 0) {
            colorSpace = ColorSpaces.INSTANCE.getSrgb();
        }
        return m4374ImageBitmapx__hDU(i, i6, i10, z10, colorSpace);
    }

    public static final ImageBitmap decodeToImageBitmap(byte[] bArr) {
        return AndroidImageBitmap_androidKt.createImageBitmap(bArr);
    }

    public static final PixelMap toPixelMap(ImageBitmap imageBitmap, int i, int i6, int i10, int i11, int[] iArr, int i12, int i13) {
        imageBitmap.readPixels(iArr, i, i6, i10, i11, i12, i13);
        return new PixelMap(iArr, i10, i11, i12, i13);
    }

    public static /* synthetic */ PixelMap toPixelMap$default(ImageBitmap imageBitmap, int i, int i6, int i10, int i11, int[] iArr, int i12, int i13, int i14, Object obj) {
        if ((i14 & 1) != 0) {
            i = 0;
        }
        if ((i14 & 2) != 0) {
            i6 = 0;
        }
        if ((i14 & 4) != 0) {
            i10 = imageBitmap.getWidth();
        }
        if ((i14 & 8) != 0) {
            i11 = imageBitmap.getHeight();
        }
        if ((i14 & 16) != 0) {
            iArr = new int[i10 * i11];
        }
        if ((i14 & 32) != 0) {
            i12 = 0;
        }
        if ((i14 & 64) != 0) {
            i13 = i10;
        }
        return toPixelMap(imageBitmap, i, i6, i10, i11, iArr, i12, i13);
    }
}
