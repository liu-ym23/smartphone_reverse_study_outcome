package androidx.compose.ui.graphics.layer;

import android.graphics.Canvas;
import android.os.Build;
import android.view.Surface;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0007J\u0006\u0010\f\u001a\u00020\u0007J\n\u0010\r\u001a\u0004\u0018\u00010\u0005H\u0003J\u0010\u0010\u000e\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0003R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Landroidx/compose/ui/graphics/layer/SurfaceUtils;", "", "<init>", "()V", "lockHardwareCanvasMethod", "Ljava/lang/reflect/Method;", "hasRetrievedMethod", "", "lockCanvas", "Landroid/graphics/Canvas;", "surface", "Landroid/view/Surface;", "isLockHardwareCanvasAvailable", "resolveLockHardwareCanvasMethod", "lockCanvasFallback", "ui-graphics_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class SurfaceUtils {
    public static final SurfaceUtils INSTANCE = null;
    private static boolean hasRetrievedMethod;
    private static Method lockHardwareCanvasMethod;

    static {
        INSTANCE = new SurfaceUtils();
    }

    private SurfaceUtils() {
    }

    private final Method resolveLockHardwareCanvasMethod() {
        monitor-enter(this);
        Method r100 = lockHardwareCanvasMethod;     // Catch: Throwable -> L7
        if (hasRetrievedMethod == true) goto L9;
        hasRetrievedMethod = true;     // Catch: Throwable -> L7
        Method r101 = Surface.class.getDeclaredMethod("lockHardwareCanvas", new Class[0]);     // Catch: Throwable -> L7
        r101.setAccessible(true);     // Catch: Throwable -> L7
        lockHardwareCanvasMethod = r101;     // Catch: Throwable -> L7
        r100 = r101;
    L9:
        monitor-exit(this);
        return r100;
    L7:
        r100 = null;
        lockHardwareCanvasMethod = null;     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    public final boolean isLockHardwareCanvasAvailable() {
        int r100 = Build.VERSION.SDK_INT;
        if (r100 < 23) goto L6;
        return true;
    L6:
        if (r100 == 22) goto L8;
    L10:
        return false;
    L8:
        if (resolveLockHardwareCanvasMethod() == null) goto L10;
        return true;
    }

    private final Canvas lockCanvasFallback(Surface r100) {
        Method r101 = resolveLockHardwareCanvasMethod();
        if (r101 == null) goto L6;
        Object r102 = r101.invoke(r100, new Object[0]);
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type android.graphics.Canvas");
        return (Canvas) r102;
    L6:
        return r100.lockCanvas(null);
    }

    public final Canvas lockCanvas(Surface r100) {
        if (Build.VERSION.SDK_INT < 23) goto L6;
        return SurfaceVerificationHelper.INSTANCE.lockHardwareCanvas(r100);
    L6:
        return lockCanvasFallback(r100);
    }
}
