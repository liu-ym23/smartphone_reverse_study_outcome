package auc;

import android.graphics.Bitmap;
import android.graphics.HardwareRenderer;
import android.graphics.RenderEffect;
import android.graphics.RenderNode;
import android.graphics.Shader;
import android.hardware.HardwareBuffer;
import android.media.Image;
import android.media.ImageReader;

/* JADX INFO: loaded from: classes41.dex */
public final class c {
    /* JADX WARN: Multi-variable type inference failed */
    public static Bitmap a(Bitmap r110, float r111) throws RuntimeException {
        int r100 = r110.getWidth();     // Catch: Throwable -> L30
        int r101 = r110.getHeight();     // Catch: Throwable -> L30
        ImageReader r102 = ImageReader.newInstance(r100, r101, 1, 1, 768);     // Catch: Throwable -> L30
        RenderNode r103 = new RenderNode("BlurEffect");     // Catch: Throwable -> L28
        HardwareRenderer r104 = new HardwareRenderer();     // Catch: Throwable -> L26
        r104.setSurface(r102.getSurface());     // Catch: Throwable -> L24
        r104.setContentRoot(r103);     // Catch: Throwable -> L24
        r103.setPosition(0, 0, r102.getWidth(), r102.getHeight());     // Catch: Throwable -> L24
        r103.setRenderEffect(RenderEffect.createBlurEffect(r111, r111, Shader.TileMode.MIRROR));     // Catch: Throwable -> L24
        r103.beginRecording(r100, r101).drawBitmap(r110, 0.0f, 0.0f, null);     // Catch: Throwable -> L24
        r103.endRecording();     // Catch: Throwable -> L24
        r104.createRenderRequest().setWaitForPresent(true).syncAndDraw();     // Catch: Throwable -> L24
        Image r112 = r102.acquireNextImage();     // Catch: Throwable -> L24
        if (r112 == null) goto L23;
        HardwareBuffer r113 = r112.getHardwareBuffer();     // Catch: Throwable -> L20
        if (r113 == null) goto L19;
        Bitmap r105 = Bitmap.wrapHardwareBuffer(r113, null);     // Catch: Throwable -> L16
        if (r105 == null) goto L15;
        r113.close();
        r112.close();
        r102.close();
        r103.discardDisplayList();
        r104.destroy();
        return r105;
    L15:
        throw new RuntimeException("Create Bitmap Failed");     // Catch: Throwable -> L16
    L19:
        throw new RuntimeException("No HardwareBuffer");     // Catch: Throwable -> L16
    L16:
        Throwable th10 = th;
        HardwareRenderer r106 = r104;
        Image r114 = r112;
    L34:
        if (r113 == null) goto L36;
        r113.close();
    L36:
        if (r114 == 0) goto L38;
        r114.close();
    L38:
        if (r102 == null) goto L40;
        r102.close();
    L40:
        if (r103 == null) goto L42;
        r103.discardDisplayList();
    L42:
        if (r106 == 0) goto L44;
        r106.destroy();
    L44:
        throw th10;
    L23:
        throw new RuntimeException("No Image");     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        th10 = th;
        r113 = null;
        r106 = r104;
        r114 = r112;
    L24:
        th = move-exception;
        r113 = null;
        th10 = th;
        r114 = 0;
        r106 = r104;
    L26:
        th = th;
        r113 = null;
        RenderNode r107 = null;
    L33:
        th10 = th;
        r114 = r107;
        r106 = r107;
    L28:
        th = th;
        r113 = null;
        r103 = null;
    L32:
        r107 = r103;
    L30:
        th = th;
        r113 = null;
        r102 = null;
        r103 = null;
        goto L32
    }
}
