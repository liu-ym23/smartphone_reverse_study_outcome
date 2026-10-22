package androidx.compose.ui.graphics;

import android.os.Build;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\bH\u0007R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Landroidx/compose/ui/graphics/CanvasUtils;", "", "<init>", "()V", "reorderBarrierMethod", "Ljava/lang/reflect/Method;", "inorderBarrierMethod", "orderMethodsFetched", "", "enableZ", "", "canvas", "Landroid/graphics/Canvas;", "enable", "ui-graphics_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class CanvasUtils {
    public static final CanvasUtils INSTANCE = null;
    private static Method inorderBarrierMethod;
    private static boolean orderMethodsFetched;
    private static Method reorderBarrierMethod;

    static {
        INSTANCE = new CanvasUtils();
    }

    private CanvasUtils() {
    }

    public final void enableZ(android.graphics.Canvas r110, boolean r111) {
        int r100 = Build.VERSION.SDK_INT;
        if (r100 < 29) goto L6;
        CanvasZHelper.INSTANCE.enableZ(r110, r111);
        return;
    L6:
        if (orderMethodsFetched == false) goto L31;
    L18:
        if (r111 == true) goto L29;
    L22:
        if (r111 == true) goto L34;
        Method r112 = inorderBarrierMethod;     // Catch: Throwable -> L27
        if (r112 == null) goto L35;
        Intrinsics.checkNotNull(r112);     // Catch: Throwable -> L27
        r112.invoke(r110, new Object[0]);     // Catch: Throwable -> L27
        return;
    L36:
        return;
    L35:
        return;
    L34:
        return;
    L29:
        Method r101 = reorderBarrierMethod;     // Catch: Throwable -> L27
        if (r101 == null) goto L22;
        Intrinsics.checkNotNull(r101);     // Catch: Throwable -> L27
        r101.invoke(r110, new Object[0]);     // Catch: Throwable -> L27
        goto L22
    L31:
        if (r100 != 28) goto L10;
        Method r102 = Class.class.getDeclaredMethod("getDeclaredMethod", new Class[]{String.class, new Class[0].getClass()});     // Catch: Throwable -> L28
        reorderBarrierMethod = (Method) r102.invoke(android.graphics.Canvas.class, new Object[]{"insertReorderBarrier", new Class[0]});     // Catch: Throwable -> L28
        inorderBarrierMethod = (Method) r102.invoke(android.graphics.Canvas.class, new Object[]{"insertInorderBarrier", new Class[0]});     // Catch: Throwable -> L28
    L11:
        Method r103 = reorderBarrierMethod;     // Catch: Throwable -> L28
        if (r103 == null) goto L14;
        r103.setAccessible(true);     // Catch: Throwable -> L28
    L14:
        Method r104 = inorderBarrierMethod;     // Catch: Throwable -> L28
        if (r104 == null) goto L17;
        r104.setAccessible(true);     // Catch: Throwable -> L28
        goto L17
    L10:
        reorderBarrierMethod = android.graphics.Canvas.class.getDeclaredMethod("insertReorderBarrier", new Class[0]);     // Catch: Throwable -> L28
        inorderBarrierMethod = android.graphics.Canvas.class.getDeclaredMethod("insertInorderBarrier", new Class[0]);     // Catch: Throwable -> L28
    L17:
        orderMethodsFetched = true;
        goto L18
    }
}
