package auc;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RSRuntimeException;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;

/* JADX INFO: loaded from: classes41.dex */
public final class b {
    public static void a(Context r100, Bitmap r101, int r102) throws RSRuntimeException {
        RenderScript r103 = null;
        ScriptIntrinsicBlur r104 = null;
        RenderScript r105 = RenderScript.create(r100);     // Catch: Throwable -> L20
        r105.setMessageHandler(new RenderScript.RSMessageHandler());     // Catch: Throwable -> L17
        Allocation r106 = Allocation.createFromBitmap(r105, r101, Allocation.MipmapControl.MIPMAP_NONE, 1);     // Catch: Throwable -> L17
        Allocation r107 = Allocation.createTyped(r105, r106.getType());     // Catch: Throwable -> L15
        r104 = ScriptIntrinsicBlur.create(r105, Element.U8_4(r105));     // Catch: Throwable -> L13
        r104.setInput(r106);     // Catch: Throwable -> L13
        r104.setRadius(r102);     // Catch: Throwable -> L13
        r104.forEach(r107);     // Catch: Throwable -> L13
        r107.copyTo(r101);     // Catch: Throwable -> L13
        if (Build.VERSION.SDK_INT < 23) goto L10;
        RenderScript.releaseAllContexts();
    L11:
        r106.destroy();
        r107.destroy();
        r104.destroy();
        return;
    L10:
        r105.destroy();
    L13:
        th = th;
        ScriptIntrinsicBlur r108 = r104;
        r103 = r105;
        ScriptIntrinsicBlur r109 = r108;
    L22:
        if (r103 != null) goto L24;
    L27:
        if (r106 == null) goto L29;
        r106.destroy();
    L29:
        if (r107 == null) goto L31;
        r107.destroy();
    L31:
        if (r109 == null) goto L33;
        r109.destroy();
    L33:
        throw th;
    L24:
        if (Build.VERSION.SDK_INT < 23) goto L26;
        RenderScript.releaseAllContexts();
        goto L27
    L26:
        r103.destroy();
    L15:
        th = th;
    L19:
        r107 = null;
        r103 = r105;
        r109 = null;
    L17:
        th = th;
        r106 = null;
    L20:
        th = th;
        r109 = null;
        r106 = null;
        r107 = null;
        goto L22
    }
}
