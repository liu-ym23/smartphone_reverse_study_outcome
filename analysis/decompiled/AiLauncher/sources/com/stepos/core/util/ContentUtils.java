package com.stepos.core.util;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.hardware.HardwareBuffer;
import android.media.Image;
import com.stepos.core.data.ImageContent;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0007\u001a\u000e\u0010\u0003\u001a\u0004\u0018\u00010\u0002*\u00020\u0001H\u0007\u001a\u000e\u0010\u0004\u001a\u0004\u0018\u00010\u0005*\u00020\u0002H\u0003\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0006H\u0007\u001a\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u00012\u0006\u0010\b\u001a\u00020\tH\u0007¨\u0006\n"}, d2 = {"toImageContent", "Lcom/stepos/core/data/ImageContent;", "Landroid/graphics/Bitmap;", "toBitmap", "copyToHardwareBuffer", "Landroid/hardware/HardwareBuffer;", "Landroid/media/Image;", "loadImageContent", "path", "", "aiengine-api_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ContentUtils {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Bitmap.Config.values().length];
            try {
                iArr[Bitmap.Config.ARGB_8888.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Bitmap.Config.RGB_565.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private static final HardwareBuffer copyToHardwareBuffer(Bitmap bitmap) {
        Bitmap bitmapCopy = bitmap.copy(Bitmap.Config.HARDWARE, false);
        if (bitmapCopy != null) {
            return bitmapCopy.getHardwareBuffer();
        }
        return null;
    }

    public static final ImageContent loadImageContent(String path) {
        p.i(path, "path");
        Bitmap bitmapDecodeFile = BitmapFactory.decodeFile(path);
        if (bitmapDecodeFile == null) {
            return null;
        }
        return toImageContent(bitmapDecodeFile);
    }

    public static final Bitmap toBitmap(ImageContent imageContent) {
        p.i(imageContent, "<this>");
        HardwareBuffer hwBuffer = imageContent.getHwBuffer();
        if (hwBuffer == null) {
            return null;
        }
        return Bitmap.wrapHardwareBuffer(hwBuffer, null);
    }

    public static final ImageContent toImageContent(Bitmap bitmap) {
        p.i(bitmap, "<this>");
        HardwareBuffer hardwareBuffer = bitmap.getConfig() == Bitmap.Config.HARDWARE ? bitmap.getHardwareBuffer() : copyToHardwareBuffer(bitmap);
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Bitmap.Config config = bitmap.getConfig();
        int i10 = config == null ? -1 : WhenMappings.$EnumSwitchMapping$0[config.ordinal()];
        return new ImageContent(hardwareBuffer, null, 0L, width, height, (i10 == 1 || i10 != 2) ? 2 : 1, 0, null, null, 454, null);
    }

    public static final ImageContent toImageContent(Image image) {
        p.i(image, "<this>");
        HardwareBuffer hardwareBuffer = image.getHardwareBuffer();
        int width = image.getWidth();
        int height = image.getHeight();
        int format = image.getFormat();
        int i10 = 2;
        if (format != 1) {
            if (format == 17) {
                i10 = 3;
            } else if (format == 35) {
                i10 = 4;
            }
        }
        return new ImageContent(hardwareBuffer, null, 0L, width, height, i10, 0, null, null, 454, null);
    }
}
