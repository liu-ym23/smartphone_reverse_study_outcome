package com.obric.autogui.platforms.tools.computercontrol;

import android.graphics.Bitmap;
import android.media.Image;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.platform.display.capture.BitmapScreenshot;
import com.obric.autogui.common.api.platform.display.capture.IScreenshot;
import com.obric.autogui.common.api.platform.display.capture.ScreenshotResult;
import com.obric.autogui.common.api.space.AOOperatingSpace;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.i;
import d.h.b.o;
import d.l.n;
import java.nio.Buffer;

/* JADX INFO: compiled from: ComputerControlImageUtils.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class ComputerControlImageUtils {
    public static final ComputerControlImageUtils INSTANCE = null;
    private static final String TAG = "ComputerControlImageUtils";

    static {
        INSTANCE = new ComputerControlImageUtils();
    }

    private ComputerControlImageUtils() {
    }

    public final Bitmap imageToBitmap(Image r9) {
        o.e(r9, "image");
        Bitmap r1 = null;
    L24:
        th = move-exception;
        Loog.INSTANCE.e(TAG, "Failed to convert CC screenshot image to bitmap.", th);     // Catch: Throwable -> L28
    L26:
        r9.close();
        return r1;
    L28:
        th = move-exception;
        r9.close();
        throw th;
    L4:
        if (r9.getFormat() == 1) goto L6;
        Loog.INSTANCE.w(TAG, "Unexpected CC screenshot image format=" + r9.getFormat() + ", try ARGB_8888 copy.");     // Catch: Throwable -> L24
    L6:
        Image.Plane[] r2 = r9.getPlanes();     // Catch: Throwable -> L24
        o.c(r2, "getPlanes(...)");     // Catch: Throwable -> L24
        Image.Plane r3 = (Image.Plane) ZeusTransformUtils.preCheckCast(i.c((Object[]) ZeusTransformUtils.preCheckCast(r2, Object[].class, "com.obric.aiagent.plugin")), Image.Plane.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L24
        if (r3 != null) goto L11;
        Loog.INSTANCE.e(TAG, "CC screenshot image has no planes.");     // Catch: Throwable -> L24
        r9.close();
        return null;
    L11:
        int r4 = r9.getWidth();     // Catch: Throwable -> L24
        int r5 = r9.getHeight();     // Catch: Throwable -> L24
        int r6 = r3.getPixelStride();     // Catch: Throwable -> L24
        int r7 = r3.getRowStride();     // Catch: Throwable -> L24
        if (r4 <= 0) goto L21;
        if (r5 <= 0) goto L21;
        if (r6 <= 0) goto L21;
        if (r7 <= 0) goto L21;
        Bitmap r8 = Bitmap.createBitmap(n.c((r7 - (r6 * r4)) / r6, 0) + r4, r5, Bitmap.Config.ARGB_8888);     // Catch: Throwable -> L24
        o.c(r8, "createBitmap(...)");     // Catch: Throwable -> L24
        r3.getBuffer().rewind();     // Catch: Throwable -> L24
        r8.copyPixelsFromBuffer((Buffer) ZeusTransformUtils.preCheckCast(r3.getBuffer(), Buffer.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L24
        if (r8.getWidth() != r4) goto L20;
        r1 = r8;
        goto L26
    L20:
        Bitmap r10 = Bitmap.createBitmap(r8, 0, 0, r4, r5);     // Catch: Throwable -> L24
        r8.recycle();     // Catch: Throwable -> L24
        o.a(r10);     // Catch: Throwable -> L24
        r1 = r10;
    L21:
        Loog.INSTANCE.e(TAG, "Invalid CC screenshot image: width=" + r4 + ", height=" + r5 + ", pixelStride=" + r6 + ", rowStride=" + r7 + '.');     // Catch: Throwable -> L24
        r9.close();
        return null;
    }

    public final ScreenshotResult toScreenshotResult(Bitmap r10, float r11) {
        o.e(r10, "bitmap");
        if (r11 != 1.0f) goto L5;
        boolean r9 = true;
    L6:
        if (r9 == true) goto L10;
        Bitmap r12 = Bitmap.createScaledBitmap(r10, n.c((int) (r10.getWidth() * r11), 1), n.c((int) (r10.getHeight() * r11), 1), true);
        r10.recycle();
        o.a(r12);
        r10 = r12;
    L10:
        return new ScreenshotResult(ScreenshotResult.Status.Ok, (IScreenshot) ZeusTransformUtils.preCheckCast(new BitmapScreenshot(r10, r11, AOOperatingSpace.SpaceType.ComputerControl), IScreenshot.class, "com.obric.aiagent.plugin"), null, 0, null, null, 60, null);
    L5:
        r9 = false;
        goto L6
    }
}
